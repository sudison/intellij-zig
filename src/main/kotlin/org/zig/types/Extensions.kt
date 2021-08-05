package org.zig.types

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import org.zig.ZigLangHelper.primitiveTypes
import org.zig.psi.*

data class UnknownType(val e: PsiElement, val t: Type, val handler: (Type) -> Unit)
class Context(private val visitedTypes: MutableMap<PsiElement, Type?>, val unknownTypes: MutableSet<UnknownType>) {
  fun cacheType(e: PsiElement, getType: () -> Type?): Type? {
    val cachedType = visitedTypes[e]
    if (cachedType != null) return cachedType

    val t = getType() ?: return null
    visitedTypes[e] = t
    return t
  }
}

private fun getStructType(ctx: Context, e: ZigContainerDecl): StructType {
  val fieldTypeMap = mutableMapOf<String, FieldType?>()
  e.children.forEach {
    when (it) {
      is ZigContainerField ->
        fieldTypeMap[it.firstChild?.text!!] =
          FieldType(it, PsiTreeUtil.getChildOfType(it, ZigPrimaryTypeExpr::class.java)?.type(ctx))
      is ZigFnDecl ->
        fieldTypeMap[it.nameIdentifier?.text!!] = FieldType(it, it.type(ctx))
      is ZigTopVarDecl ->
        fieldTypeMap[it.nameIdentifier?.text!!] = FieldType(it, it.type(ctx))
    }
  }

  return StructType(e, fieldTypeMap)
}

private fun getEnumType(ctx: Context, e: ZigContainerDecl): StructType {
  val fieldTypeMap = mutableMapOf<String, FieldType?>()
  e.children.forEach {
    when (it) {
      is ZigContainerField ->
        fieldTypeMap[it.firstChild?.text!!] =
          FieldType(it, BuildinType("u2"))
      is ZigFnDecl ->
        fieldTypeMap[it.nameIdentifier?.text!!] = FieldType(it, it.type(ctx))
      is ZigTopVarDecl ->
        fieldTypeMap[it.nameIdentifier?.text!!] = FieldType(it, it.type(ctx))
    }
  }

  return StructType(e, fieldTypeMap)
}

fun ZigFnDecl.type(ctx: Context): Type? {
  return ctx.cacheType(this) {

    val t = FnType(this, null)
    val ut = UnknownType(this, t) {
      val fnType = it as FnType

      val fnProto = PsiTreeUtil.getChildOfType(this, ZigFnProto::class.java) ?: return@UnknownType
      val returnType = PsiTreeUtil.getChildOfType(fnProto, ZigPrimaryTypeExpr::class.java)?.type(ctx)
      fnType.returnType = returnType
    }
    ctx.unknownTypes.add(ut)
    t
  }
}

fun ZigContainerDecl.type(ctx: Context): Type? {
  return ctx.cacheType(this) {
    when (firstChild?.firstChild?.text) {
      ZigLangTypes.STRUCT.toString().toLowerCase() -> getStructType(ctx, this)
      ZigLangTypes.ENUM.toString().toLowerCase() -> getEnumType(ctx, this)
      else -> null
    }
  }
}

fun ZigSymbol.type(ctx: Context): Type? {
  val id = firstChild?.text ?: return null
  return ctx.cacheType(this) {
    if (id in primitiveTypes) {
      BuildinType(id)
    } else {
      val e = findPsiElementByNameInsideFile(id, this)
      e?.type(ctx)
    }
  }
}

fun ZigPrimaryTypeExpr.type(ctx: Context): Type? {
  return when (val c = firstChild) {
    is ZigContainerDecl -> c.type(ctx)
    is ZigSymbol -> c.type(ctx)
    else -> null
  }
}

fun ZigTopVarDecl.type(ctx: Context): Type? {
  return PsiTreeUtil.findChildOfType(this, ZigPrimaryTypeExpr::class.java)?.type(ctx)
}

fun ZigLocalVarDecl.type(ctx: Context): Type? {
  return PsiTreeUtil.findChildOfType(this, ZigPrimaryTypeExpr::class.java)?.type(ctx)
}

fun PsiElement.type(ctx: Context): Type? {
  return when (this) {
    is ZigTopVarDecl -> type(ctx)
    is ZigLocalVarDecl -> type(ctx)
    is ZigPrimaryTypeExpr -> type(ctx)
    is ZigSymbol -> type(ctx)
    is ZigFnDecl -> type(ctx)
    else -> null
  }
}

fun PsiElement.inference(): Type? {
  val ctx = Context(mutableMapOf(), mutableSetOf())
  val t = this.type(ctx)
  while(ctx.unknownTypes.isNotEmpty()) {
    val ut = ctx.unknownTypes.first()
    ut.handler(ut.t)
    ctx.unknownTypes.remove(ut)
  }
  return t
}

val PsiElement.leftSiblings: Sequence<PsiElement>
  get() = generateSequence(this.prevSibling) { it.prevSibling }

