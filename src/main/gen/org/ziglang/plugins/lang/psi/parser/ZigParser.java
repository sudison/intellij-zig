// This is a generated file. Not intended for manual editing.
package org.ziglang.plugins.lang.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.ziglang.plugins.lang.psi.ZigTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ZigParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return zigFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARRAY_EXPR, BOOLEAN, CHAR, ERROR_SET_EXPR,
      EXPR, FLOAT, FN_PROTO, INTEGER,
      KEYWORD_LITERAL, NULL, STRING, SYMBOL),
  };

  /* ********************************************************** */
  // expr additionOperator expr
  public static boolean additionExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additionExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITION_EXPR, "<addition expr>");
    r = expr(b, l + 1);
    r = r && additionOperator(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PLUS_SYM | MINUS_SYM | INC_SYM | PLUS_MOD_SYM | MINUS_MOD_SYM
  public static boolean additionOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additionOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITION_OPERATOR, "<addition operator>");
    r = consumeToken(b, PLUS_SYM);
    if (!r) r = consumeToken(b, MINUS_SYM);
    if (!r) r = consumeToken(b, INC_SYM);
    if (!r) r = consumeToken(b, PLUS_MOD_SYM);
    if (!r) r = consumeToken(b, MINUS_MOD_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET expr RIGHT_BRACKET
  public static boolean arrayAccessSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayAccessSuffix")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, ARRAY_ACCESS_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET expr? RIGHT_BRACKET
  //  (ALIGN_KEYWORD LEFT_PAREN expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN)?
  //  CONST_KEYWORD? VOLATILE_KEYWORD? typeExpr
  public static boolean arrayExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && arrayExpr_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    r = r && arrayExpr_3(b, l + 1);
    r = r && arrayExpr_4(b, l + 1);
    r = r && arrayExpr_5(b, l + 1);
    r = r && typeExpr(b, l + 1);
    exit_section_(b, m, ARRAY_EXPR, r);
    return r;
  }

  // expr?
  private static boolean arrayExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_1")) return false;
    expr(b, l + 1);
    return true;
  }

  // (ALIGN_KEYWORD LEFT_PAREN expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN)?
  private static boolean arrayExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_3")) return false;
    arrayExpr_3_0(b, l + 1);
    return true;
  }

  // ALIGN_KEYWORD LEFT_PAREN expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN
  private static boolean arrayExpr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && arrayExpr_3_0_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON_SYM integer COLON_SYM integer)?
  private static boolean arrayExpr_3_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_3_0_3")) return false;
    arrayExpr_3_0_3_0(b, l + 1);
    return true;
  }

  // COLON_SYM integer COLON_SYM integer
  private static boolean arrayExpr_3_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_3_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && integer(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    r = r && integer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CONST_KEYWORD?
  private static boolean arrayExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_4")) return false;
    consumeToken(b, CONST_KEYWORD);
    return true;
  }

  // VOLATILE_KEYWORD?
  private static boolean arrayExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayExpr_5")) return false;
    consumeToken(b, VOLATILE_KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // COLON_SYM (string (COMMA_SYM string)*)?
  public static boolean asmClobbers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmClobbers")) return false;
    if (!nextTokenIs(b, COLON_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && asmClobbers_1(b, l + 1);
    exit_section_(b, m, ASM_CLOBBERS, r);
    return r;
  }

  // (string (COMMA_SYM string)*)?
  private static boolean asmClobbers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmClobbers_1")) return false;
    asmClobbers_1_0(b, l + 1);
    return true;
  }

  // string (COMMA_SYM string)*
  private static boolean asmClobbers_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmClobbers_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string(b, l + 1);
    r = r && asmClobbers_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM string)*
  private static boolean asmClobbers_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmClobbers_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!asmClobbers_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asmClobbers_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM string
  private static boolean asmClobbers_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmClobbers_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASM_KEYWORD VOLATILE_KEYWORD?
  //  LEFT_PAREN string asmOutput? RIGHT_PAREN
  public static boolean asmExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmExpr")) return false;
    if (!nextTokenIs(b, ASM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASM_KEYWORD);
    r = r && asmExpr_1(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && string(b, l + 1);
    r = r && asmExpr_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, ASM_EXPR, r);
    return r;
  }

  // VOLATILE_KEYWORD?
  private static boolean asmExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmExpr_1")) return false;
    consumeToken(b, VOLATILE_KEYWORD);
    return true;
  }

  // asmOutput?
  private static boolean asmExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmExpr_4")) return false;
    asmOutput(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON_SYM (asmInputItem (COMMA_SYM asmInputItem)*)? asmClobbers?
  public static boolean asmInput(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInput")) return false;
    if (!nextTokenIs(b, COLON_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && asmInput_1(b, l + 1);
    r = r && asmInput_2(b, l + 1);
    exit_section_(b, m, ASM_INPUT, r);
    return r;
  }

  // (asmInputItem (COMMA_SYM asmInputItem)*)?
  private static boolean asmInput_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInput_1")) return false;
    asmInput_1_0(b, l + 1);
    return true;
  }

  // asmInputItem (COMMA_SYM asmInputItem)*
  private static boolean asmInput_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInput_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = asmInputItem(b, l + 1);
    r = r && asmInput_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM asmInputItem)*
  private static boolean asmInput_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInput_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!asmInput_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asmInput_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM asmInputItem
  private static boolean asmInput_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInput_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && asmInputItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // asmClobbers?
  private static boolean asmInput_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInput_2")) return false;
    asmClobbers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKET symbol RIGHT_BRACKET string LEFT_PAREN expr RIGHT_PAREN
  public static boolean asmInputItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmInputItem")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    r = r && string(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, ASM_INPUT_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // COLON_SYM (asmOutputItem (COMMA_SYM asmOutputItem)*)? asmInput?
  public static boolean asmOutput(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutput")) return false;
    if (!nextTokenIs(b, COLON_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && asmOutput_1(b, l + 1);
    r = r && asmOutput_2(b, l + 1);
    exit_section_(b, m, ASM_OUTPUT, r);
    return r;
  }

  // (asmOutputItem (COMMA_SYM asmOutputItem)*)?
  private static boolean asmOutput_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutput_1")) return false;
    asmOutput_1_0(b, l + 1);
    return true;
  }

  // asmOutputItem (COMMA_SYM asmOutputItem)*
  private static boolean asmOutput_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutput_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = asmOutputItem(b, l + 1);
    r = r && asmOutput_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM asmOutputItem)*
  private static boolean asmOutput_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutput_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!asmOutput_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asmOutput_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM asmOutputItem
  private static boolean asmOutput_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutput_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && asmOutputItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // asmInput?
  private static boolean asmOutput_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutput_2")) return false;
    asmInput(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKET symbol RIGHT_BRACKET string LEFT_PAREN (symbol | SMALL_ARROW_SYM typeExpr) RIGHT_PAREN
  public static boolean asmOutputItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutputItem")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    r = r && string(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && asmOutputItem_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, ASM_OUTPUT_ITEM, r);
    return r;
  }

  // symbol | SMALL_ARROW_SYM typeExpr
  private static boolean asmOutputItem_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutputItem_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    if (!r) r = asmOutputItem_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SMALL_ARROW_SYM typeExpr
  private static boolean asmOutputItem_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asmOutputItem_5_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SMALL_ARROW_SYM);
    r = r && typeExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr assignOperator expr
  public static boolean assignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_EXPR, "<assign expr>");
    r = expr(b, l + 1);
    r = r && assignOperator(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQ_SYM
  //  | TIMES_ASSIGN_SYM
  //  | DIV_ASSIGN_SYM
  //  | MOD_ASSIGN_SYM
  //  | PLUS_ASSIGN_SYM
  //  | STAR_ASSIGN_SYM
  //  | MINUS_ASSIGN_SYM
  //  | SHL_ASSIGN_SYM
  //  | SHR_ASSIGN_SYM
  //  | AND_ASSIGN_SYM
  //  | EXPONENT_ASSIGN_SYM
  //  | OR_ASSIGN_SYM
  //  | STAR_MOD_ASSIGN_SYM
  //  | PLUS_MOD_ASSIGN_SYM
  //  | MINUS_MOD_ASSIGN_SYM
  public static boolean assignOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_OPERATOR, "<assign operator>");
    r = consumeToken(b, EQ_SYM);
    if (!r) r = consumeToken(b, TIMES_ASSIGN_SYM);
    if (!r) r = consumeToken(b, DIV_ASSIGN_SYM);
    if (!r) r = consumeToken(b, MOD_ASSIGN_SYM);
    if (!r) r = consumeToken(b, PLUS_ASSIGN_SYM);
    if (!r) r = consumeToken(b, STAR_ASSIGN_SYM);
    if (!r) r = consumeToken(b, MINUS_ASSIGN_SYM);
    if (!r) r = consumeToken(b, SHL_ASSIGN_SYM);
    if (!r) r = consumeToken(b, SHR_ASSIGN_SYM);
    if (!r) r = consumeToken(b, AND_ASSIGN_SYM);
    if (!r) r = consumeToken(b, EXPONENT_ASSIGN_SYM);
    if (!r) r = consumeToken(b, OR_ASSIGN_SYM);
    if (!r) r = consumeToken(b, STAR_MOD_ASSIGN_SYM);
    if (!r) r = consumeToken(b, PLUS_MOD_ASSIGN_SYM);
    if (!r) r = consumeToken(b, MINUS_MOD_ASSIGN_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ASYNC_KEYWORD (LT_SYM primary GT_SYM)? primary fnCallSuffix
  public static boolean asyncExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asyncExpr")) return false;
    if (!nextTokenIs(b, ASYNC_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASYNC_KEYWORD);
    r = r && asyncExpr_1(b, l + 1);
    r = r && primary(b, l + 1);
    r = r && fnCallSuffix(b, l + 1);
    exit_section_(b, m, ASYNC_EXPR, r);
    return r;
  }

  // (LT_SYM primary GT_SYM)?
  private static boolean asyncExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asyncExpr_1")) return false;
    asyncExpr_1_0(b, l + 1);
    return true;
  }

  // LT_SYM primary GT_SYM
  private static boolean asyncExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asyncExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT_SYM);
    r = r && primary(b, l + 1);
    r = r && consumeToken(b, GT_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AWAIT_KEYWORD expr
  public static boolean awaitExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "awaitExpr")) return false;
    if (!nextTokenIs(b, AWAIT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AWAIT_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, m, AWAIT_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // expr AND_SYM expr
  public static boolean binaryAndExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryAndExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_AND_EXPR, "<binary and expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, AND_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr SEP_SYM expr
  public static boolean binaryOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryOrExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OR_EXPR, "<binary or expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr EXPONENT_SYM expr
  public static boolean binaryXorExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryXorExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_XOR_EXPR, "<binary xor expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, EXPONENT_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr bitShiftOperator expr
  public static boolean bitShiftExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitShiftExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_SHIFT_EXPR, "<bit shift expr>");
    r = expr(b, l + 1);
    r = r && bitShiftOperator(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SHL_SYM | SHR_SYM
  public static boolean bitShiftOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitShiftOperator")) return false;
    if (!nextTokenIs(b, "<bit shift operator>", SHL_SYM, SHR_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_SHIFT_OPERATOR, "<bit shift operator>");
    r = consumeToken(b, SHL_SYM);
    if (!r) r = consumeToken(b, SHR_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (symbol COLON_SYM)? LEFT_BRACE statement* RIGHT_BRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, "<block>", LEFT_BRACE, SYM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && block_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (symbol COLON_SYM)?
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    block_0_0(b, l + 1);
    return true;
  }

  // symbol COLON_SYM
  private static boolean block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement*
  private static boolean block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // block
  //  | ifBlock
  //  | ifErrorBlock
  //  | testBlock
  //  | whileBlock
  //  | forBlock
  //  | switchStatement
  //  | compTimeBlock
  //  | suspendBlock
  public static boolean blockBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_BLOCK, "<block block>");
    r = block(b, l + 1);
    if (!r) r = ifBlock(b, l + 1);
    if (!r) r = ifErrorBlock(b, l + 1);
    if (!r) r = testBlock(b, l + 1);
    if (!r) r = whileBlock(b, l + 1);
    if (!r) r = forBlock(b, l + 1);
    if (!r) r = switchStatement(b, l + 1);
    if (!r) r = compTimeBlock(b, l + 1);
    if (!r) r = suspendBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // block
  //  | ifExprOrBlock
  //  | ifErrorExprOrBlock
  //  | testExprOrBlock
  //  | whileExprOrBlock
  //  | forOrBlock
  //  | switchStatement
  //  | compTimeExprOrBlock
  //  | suspendExprOrBlock
  public static boolean blockExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_EXPR, "<block expr>");
    r = block(b, l + 1);
    if (!r) r = ifExprOrBlock(b, l + 1);
    if (!r) r = ifErrorExprOrBlock(b, l + 1);
    if (!r) r = testExprOrBlock(b, l + 1);
    if (!r) r = whileExprOrBlock(b, l + 1);
    if (!r) r = forOrBlock(b, l + 1);
    if (!r) r = switchStatement(b, l + 1);
    if (!r) r = compTimeExprOrBlock(b, l + 1);
    if (!r) r = suspendExprOrBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr AND_KEYWORD expr
  public static boolean boolAndExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolAndExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_AND_EXPR, "<bool and expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, AND_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr OR_KEYWORD expr
  public static boolean boolOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolOrExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_OR_EXPR, "<bool or expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, OR_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD | FALSE_KEYWORD
  public static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    if (!nextTokenIs(b, "<boolean $>", FALSE_KEYWORD, TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean $>");
    r = consumeToken(b, TRUE_KEYWORD);
    if (!r) r = consumeToken(b, FALSE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BREAK_KEYWORD (COLON_SYM symbol)? expr?
  public static boolean breakExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakExpr")) return false;
    if (!nextTokenIs(b, BREAK_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK_KEYWORD);
    r = r && breakExpr_1(b, l + 1);
    r = r && breakExpr_2(b, l + 1);
    exit_section_(b, m, BREAK_EXPR, r);
    return r;
  }

  // (COLON_SYM symbol)?
  private static boolean breakExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakExpr_1")) return false;
    breakExpr_1_0(b, l + 1);
    return true;
  }

  // COLON_SYM symbol
  private static boolean breakExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr?
  private static boolean breakExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakExpr_2")) return false;
    expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CANCEL_KEYWORD expr
  public static boolean cancelExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cancelExpr")) return false;
    if (!nextTokenIs(b, CANCEL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CANCEL_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, m, CANCEL_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // CHAR_LITERAL
  public static boolean char_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "char_$")) return false;
    if (!nextTokenIs(b, CHAR_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHAR_LITERAL);
    exit_section_(b, m, CHAR, r);
    return r;
  }

  /* ********************************************************** */
  // COMPTIME_KEYWORD block
  public static boolean compTimeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compTimeBlock")) return false;
    if (!nextTokenIs(b, COMPTIME_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPTIME_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, COMP_TIME_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // COMPTIME_KEYWORD exprOrBlock
  public static boolean compTimeExprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compTimeExprOrBlock")) return false;
    if (!nextTokenIs(b, COMPTIME_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPTIME_KEYWORD);
    r = r && exprOrBlock(b, l + 1);
    exit_section_(b, m, COMP_TIME_EXPR_OR_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // expr comparisonOperator expr
  public static boolean comparisonExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_EXPR, "<comparison expr>");
    r = expr(b, l + 1);
    r = r && comparisonOperator(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQUAL_SYM
  //  | UNEQUAL_SYM
  //  | LT_SYM
  //  | GT_SYM
  //  | LE_SYM
  //  | GE_SYM
  public static boolean comparisonOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_OPERATOR, "<comparison operator>");
    r = consumeToken(b, EQUAL_SYM);
    if (!r) r = consumeToken(b, UNEQUAL_SYM);
    if (!r) r = consumeToken(b, LT_SYM);
    if (!r) r = consumeToken(b, GT_SYM);
    if (!r) r = consumeToken(b, LE_SYM);
    if (!r) r = consumeToken(b, GE_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (EXTERN_KEYWORD | PACKED_KEYWORD)?
  //  ( STRUCT_KEYWORD groupedExpr?
  //  | UNION_KEYWORD (ENUM_KEYWORD groupedExpr? | groupedExpr)?
  //  | ENUM_KEYWORD groupedExpr?
  //  )
  //  LEFT_BRACE containerMember* RIGHT_BRACE
  public static boolean containerExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_EXPR, "<container expr>");
    r = containerExpr_0(b, l + 1);
    r = r && containerExpr_1(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && containerExpr_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EXTERN_KEYWORD | PACKED_KEYWORD)?
  private static boolean containerExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_0")) return false;
    containerExpr_0_0(b, l + 1);
    return true;
  }

  // EXTERN_KEYWORD | PACKED_KEYWORD
  private static boolean containerExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_0_0")) return false;
    boolean r;
    r = consumeToken(b, EXTERN_KEYWORD);
    if (!r) r = consumeToken(b, PACKED_KEYWORD);
    return r;
  }

  // STRUCT_KEYWORD groupedExpr?
  //  | UNION_KEYWORD (ENUM_KEYWORD groupedExpr? | groupedExpr)?
  //  | ENUM_KEYWORD groupedExpr?
  private static boolean containerExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = containerExpr_1_0(b, l + 1);
    if (!r) r = containerExpr_1_1(b, l + 1);
    if (!r) r = containerExpr_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRUCT_KEYWORD groupedExpr?
  private static boolean containerExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRUCT_KEYWORD);
    r = r && containerExpr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // groupedExpr?
  private static boolean containerExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_0_1")) return false;
    groupedExpr(b, l + 1);
    return true;
  }

  // UNION_KEYWORD (ENUM_KEYWORD groupedExpr? | groupedExpr)?
  private static boolean containerExpr_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNION_KEYWORD);
    r = r && containerExpr_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ENUM_KEYWORD groupedExpr? | groupedExpr)?
  private static boolean containerExpr_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_1_1")) return false;
    containerExpr_1_1_1_0(b, l + 1);
    return true;
  }

  // ENUM_KEYWORD groupedExpr? | groupedExpr
  private static boolean containerExpr_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = containerExpr_1_1_1_0_0(b, l + 1);
    if (!r) r = groupedExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ENUM_KEYWORD groupedExpr?
  private static boolean containerExpr_1_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM_KEYWORD);
    r = r && containerExpr_1_1_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // groupedExpr?
  private static boolean containerExpr_1_1_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_1_1_0_0_1")) return false;
    groupedExpr(b, l + 1);
    return true;
  }

  // ENUM_KEYWORD groupedExpr?
  private static boolean containerExpr_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM_KEYWORD);
    r = r && containerExpr_1_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // groupedExpr?
  private static boolean containerExpr_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_1_2_1")) return false;
    groupedExpr(b, l + 1);
    return true;
  }

  // containerMember*
  private static boolean containerExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerExpr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!containerMember(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "containerExpr_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // symbol (COLON_SYM primary)? (EQ_SYM expr)? COMMA_SYM
  public static boolean containerField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerField")) return false;
    if (!nextTokenIs(b, SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && containerField_1(b, l + 1);
    r = r && containerField_2(b, l + 1);
    r = r && consumeToken(b, COMMA_SYM);
    exit_section_(b, m, CONTAINER_FIELD, r);
    return r;
  }

  // (COLON_SYM primary)?
  private static boolean containerField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerField_1")) return false;
    containerField_1_0(b, l + 1);
    return true;
  }

  // COLON_SYM primary
  private static boolean containerField_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerField_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EQ_SYM expr)?
  private static boolean containerField_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerField_2")) return false;
    containerField_2_0(b, l + 1);
    return true;
  }

  // EQ_SYM expr
  private static boolean containerField_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerField_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // structLiteralField (COMMA_SYM structLiteralField)*
  //  | expr (COMMA_SYM expr)*
  public static boolean containerInitBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_INIT_BODY, "<container init body>");
    r = containerInitBody_0(b, l + 1);
    if (!r) r = containerInitBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // structLiteralField (COMMA_SYM structLiteralField)*
  private static boolean containerInitBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = structLiteralField(b, l + 1);
    r = r && containerInitBody_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM structLiteralField)*
  private static boolean containerInitBody_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!containerInitBody_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "containerInitBody_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM structLiteralField
  private static boolean containerInitBody_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && structLiteralField(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr (COMMA_SYM expr)*
  private static boolean containerInitBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && containerInitBody_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM expr)*
  private static boolean containerInitBody_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!containerInitBody_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "containerInitBody_1_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM expr
  private static boolean containerInitBody_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitBody_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE (containerInitBody COMMA_SYM?)? RIGHT_BRACE
  public static boolean containerInitSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitSuffix")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && containerInitSuffix_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, CONTAINER_INIT_SUFFIX, r);
    return r;
  }

  // (containerInitBody COMMA_SYM?)?
  private static boolean containerInitSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitSuffix_1")) return false;
    containerInitSuffix_1_0(b, l + 1);
    return true;
  }

  // containerInitBody COMMA_SYM?
  private static boolean containerInitSuffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitSuffix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = containerInitBody(b, l + 1);
    r = r && containerInitSuffix_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA_SYM?
  private static boolean containerInitSuffix_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerInitSuffix_1_0_1")) return false;
    consumeToken(b, COMMA_SYM);
    return true;
  }

  /* ********************************************************** */
  // containerField
  //  | fnDeclaration
  //  | globalVarDeclaration
  public static boolean containerMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "containerMember")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_MEMBER, "<container member>");
    r = containerField(b, l + 1);
    if (!r) r = fnDeclaration(b, l + 1);
    if (!r) r = globalVarDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE_KEYWORD (COLON_SYM symbol)?
  public static boolean continueExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueExpr")) return false;
    if (!nextTokenIs(b, CONTINUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE_KEYWORD);
    r = r && continueExpr_1(b, l + 1);
    exit_section_(b, m, CONTINUE_EXPR, r);
    return r;
  }

  // (COLON_SYM symbol)?
  private static boolean continueExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueExpr_1")) return false;
    continueExpr_1_0(b, l + 1);
    return true;
  }

  // COLON_SYM symbol
  private static boolean continueExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr containerInitSuffix
  public static boolean curlySuffixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "curlySuffixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CURLY_SUFFIX_EXPR, "<curly suffix expr>");
    r = expr(b, l + 1);
    r = r && containerInitSuffix(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (DEFER_KEYWORD | DEFERROR_KEYWORD) expr
  public static boolean defer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defer")) return false;
    if (!nextTokenIs(b, "<defer>", DEFERROR_KEYWORD, DEFER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFER, "<defer>");
    r = defer_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DEFER_KEYWORD | DEFERROR_KEYWORD
  private static boolean defer_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defer_0")) return false;
    boolean r;
    r = consumeToken(b, DEFER_KEYWORD);
    if (!r) r = consumeToken(b, DEFERROR_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // (DEFER_KEYWORD | DEFERROR_KEYWORD) block
  public static boolean deferBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deferBlock")) return false;
    if (!nextTokenIs(b, "<defer block>", DEFERROR_KEYWORD, DEFER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFER_BLOCK, "<defer block>");
    r = deferBlock_0(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DEFER_KEYWORD | DEFERROR_KEYWORD
  private static boolean deferBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deferBlock_0")) return false;
    boolean r;
    r = consumeToken(b, DEFER_KEYWORD);
    if (!r) r = consumeToken(b, DEFERROR_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // ERROR_KEYWORD
  //  LEFT_BRACE (symbol (COMMA_SYM symbol)*)? RIGHT_BRACE
  public static boolean errorSetExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorSetExpr")) return false;
    if (!nextTokenIs(b, ERROR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ERROR_KEYWORD, LEFT_BRACE);
    r = r && errorSetExpr_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, ERROR_SET_EXPR, r);
    return r;
  }

  // (symbol (COMMA_SYM symbol)*)?
  private static boolean errorSetExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorSetExpr_2")) return false;
    errorSetExpr_2_0(b, l + 1);
    return true;
  }

  // symbol (COMMA_SYM symbol)*
  private static boolean errorSetExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorSetExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && errorSetExpr_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM symbol)*
  private static boolean errorSetExpr_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorSetExpr_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!errorSetExpr_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "errorSetExpr_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM symbol
  private static boolean errorSetExpr_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "errorSetExpr_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tryExpr
  //  | returnExpr
  //  | breakExpr
  //  | assignExpr
  //  | cancelExpr
  //  | resumeExpr
  //  | awaitExpr
  //  | unwrapExpr
  //  | boolOrExpr
  //  | boolAndExpr
  //  | comparisonExpr
  //  | orElseExpr
  //  | binaryOrExpr
  //  | binaryXorExpr
  //  | binaryAndExpr
  //  | bitShiftExpr
  //  | additionExpr
  //  | multiplyExpr
  //  | curlySuffixExpr
  //  | typeExpr
  //  | prefixOpExpr
  //  | suffixOpExpr
  //  | asyncExpr
  //  | primary
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expr>");
    r = tryExpr(b, l + 1);
    if (!r) r = returnExpr(b, l + 1);
    if (!r) r = breakExpr(b, l + 1);
    if (!r) r = assignExpr(b, l + 1);
    if (!r) r = cancelExpr(b, l + 1);
    if (!r) r = resumeExpr(b, l + 1);
    if (!r) r = awaitExpr(b, l + 1);
    if (!r) r = unwrapExpr(b, l + 1);
    if (!r) r = boolOrExpr(b, l + 1);
    if (!r) r = boolAndExpr(b, l + 1);
    if (!r) r = comparisonExpr(b, l + 1);
    if (!r) r = orElseExpr(b, l + 1);
    if (!r) r = binaryOrExpr(b, l + 1);
    if (!r) r = binaryXorExpr(b, l + 1);
    if (!r) r = binaryAndExpr(b, l + 1);
    if (!r) r = bitShiftExpr(b, l + 1);
    if (!r) r = additionExpr(b, l + 1);
    if (!r) r = multiplyExpr(b, l + 1);
    if (!r) r = curlySuffixExpr(b, l + 1);
    if (!r) r = typeExpr(b, l + 1);
    if (!r) r = prefixOpExpr(b, l + 1);
    if (!r) r = suffixOpExpr(b, l + 1);
    if (!r) r = asyncExpr(b, l + 1);
    if (!r) r = primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // block | expr
  static boolean exprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprOrBlock")) return false;
    boolean r;
    r = block(b, l + 1);
    if (!r) r = expr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PUB_KEYWORD? EXTERN_KEYWORD string?
  //   (fnProto | variableDeclaration)
  //  SEMICOLON_SYM
  public static boolean externDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externDeclaration")) return false;
    if (!nextTokenIs(b, "<extern declaration>", EXTERN_KEYWORD, PUB_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXTERN_DECLARATION, "<extern declaration>");
    r = externDeclaration_0(b, l + 1);
    r = r && consumeToken(b, EXTERN_KEYWORD);
    r = r && externDeclaration_2(b, l + 1);
    r = r && externDeclaration_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUB_KEYWORD?
  private static boolean externDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externDeclaration_0")) return false;
    consumeToken(b, PUB_KEYWORD);
    return true;
  }

  // string?
  private static boolean externDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externDeclaration_2")) return false;
    string(b, l + 1);
    return true;
  }

  // fnProto | variableDeclaration
  private static boolean externDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "externDeclaration_3")) return false;
    boolean r;
    r = fnProto(b, l + 1);
    if (!r) r = variableDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // DOT_SYM symbol
  public static boolean fieldAccessSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldAccessSuffix")) return false;
    if (!nextTokenIs(b, DOT_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT_SYM);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, FIELD_ACCESS_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_LITERAL
  public static boolean float_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_$")) return false;
    if (!nextTokenIs(b, FLOAT_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOAT_LITERAL);
    exit_section_(b, m, FLOAT, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN (expr (COMMA_SYM expr)*)? RIGHT_PAREN
  public static boolean fnCallSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnCallSuffix")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && fnCallSuffix_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, FN_CALL_SUFFIX, r);
    return r;
  }

  // (expr (COMMA_SYM expr)*)?
  private static boolean fnCallSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnCallSuffix_1")) return false;
    fnCallSuffix_1_0(b, l + 1);
    return true;
  }

  // expr (COMMA_SYM expr)*
  private static boolean fnCallSuffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnCallSuffix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && fnCallSuffix_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM expr)*
  private static boolean fnCallSuffix_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnCallSuffix_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fnCallSuffix_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fnCallSuffix_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM expr
  private static boolean fnCallSuffix_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnCallSuffix_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PUB_KEYWORD? (INLINE_KEYWORD | EXPORT_KEYWORD)?
  //   fnProto block
  public static boolean fnDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN_DECLARATION, "<fn declaration>");
    r = fnDeclaration_0(b, l + 1);
    r = r && fnDeclaration_1(b, l + 1);
    r = r && fnProto(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUB_KEYWORD?
  private static boolean fnDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnDeclaration_0")) return false;
    consumeToken(b, PUB_KEYWORD);
    return true;
  }

  // (INLINE_KEYWORD | EXPORT_KEYWORD)?
  private static boolean fnDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnDeclaration_1")) return false;
    fnDeclaration_1_0(b, l + 1);
    return true;
  }

  // INLINE_KEYWORD | EXPORT_KEYWORD
  private static boolean fnDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnDeclaration_1_0")) return false;
    boolean r;
    r = consumeToken(b, INLINE_KEYWORD);
    if (!r) r = consumeToken(b, EXPORT_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // ( NAKEDCC_KEYWORD
  //  | STDCALLCC_KEYWORD
  //  | EXTERN_KEYWORD
  //  | (ASYNC_KEYWORD (LEFT_PAREN expr RIGHT_PAREN)?)
  //  )?
  //  FN_KEYWORD symbol? parameterList (ALIGN_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  //  (SECTION_KEYWORD LEFT_PAREN expr RIGHT_PAREN)? NOT_SYM? (typeExpr | VAR_KEYWORD)
  public static boolean fnProto(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN_PROTO, "<fn proto>");
    r = fnProto_0(b, l + 1);
    r = r && consumeToken(b, FN_KEYWORD);
    r = r && fnProto_2(b, l + 1);
    r = r && parameterList(b, l + 1);
    r = r && fnProto_4(b, l + 1);
    r = r && fnProto_5(b, l + 1);
    r = r && fnProto_6(b, l + 1);
    r = r && fnProto_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( NAKEDCC_KEYWORD
  //  | STDCALLCC_KEYWORD
  //  | EXTERN_KEYWORD
  //  | (ASYNC_KEYWORD (LEFT_PAREN expr RIGHT_PAREN)?)
  //  )?
  private static boolean fnProto_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_0")) return false;
    fnProto_0_0(b, l + 1);
    return true;
  }

  // NAKEDCC_KEYWORD
  //  | STDCALLCC_KEYWORD
  //  | EXTERN_KEYWORD
  //  | (ASYNC_KEYWORD (LEFT_PAREN expr RIGHT_PAREN)?)
  private static boolean fnProto_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAKEDCC_KEYWORD);
    if (!r) r = consumeToken(b, STDCALLCC_KEYWORD);
    if (!r) r = consumeToken(b, EXTERN_KEYWORD);
    if (!r) r = fnProto_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASYNC_KEYWORD (LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean fnProto_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_0_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASYNC_KEYWORD);
    r = r && fnProto_0_0_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean fnProto_0_0_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_0_0_3_1")) return false;
    fnProto_0_0_3_1_0(b, l + 1);
    return true;
  }

  // LEFT_PAREN expr RIGHT_PAREN
  private static boolean fnProto_0_0_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_0_0_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // symbol?
  private static boolean fnProto_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_2")) return false;
    symbol(b, l + 1);
    return true;
  }

  // (ALIGN_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean fnProto_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_4")) return false;
    fnProto_4_0(b, l + 1);
    return true;
  }

  // ALIGN_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  private static boolean fnProto_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SECTION_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean fnProto_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_5")) return false;
    fnProto_5_0(b, l + 1);
    return true;
  }

  // SECTION_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  private static boolean fnProto_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SECTION_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOT_SYM?
  private static boolean fnProto_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_6")) return false;
    consumeToken(b, NOT_SYM);
    return true;
  }

  // typeExpr | VAR_KEYWORD
  private static boolean fnProto_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fnProto_7")) return false;
    boolean r;
    r = typeExpr(b, l + 1);
    if (!r) r = consumeToken(b, VAR_KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // (symbol COLON_SYM)? INLINE_KEYWORD?
  //  FOR_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //   (SEP_SYM STAR_SYM? symbol (COMMA_SYM symbol)? SEP_SYM)?
  //    block
  //   (ELSE_KEYWORD blockBlock)?
  public static boolean forBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_BLOCK, "<for block>");
    r = forBlock_0(b, l + 1);
    r = r && forBlock_1(b, l + 1);
    r = r && consumeTokens(b, 0, FOR_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && forBlock_6(b, l + 1);
    r = r && block(b, l + 1);
    r = r && forBlock_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (symbol COLON_SYM)?
  private static boolean forBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_0")) return false;
    forBlock_0_0(b, l + 1);
    return true;
  }

  // symbol COLON_SYM
  private static boolean forBlock_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // INLINE_KEYWORD?
  private static boolean forBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_1")) return false;
    consumeToken(b, INLINE_KEYWORD);
    return true;
  }

  // (SEP_SYM STAR_SYM? symbol (COMMA_SYM symbol)? SEP_SYM)?
  private static boolean forBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_6")) return false;
    forBlock_6_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol (COMMA_SYM symbol)? SEP_SYM
  private static boolean forBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && forBlock_6_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && forBlock_6_0_3(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean forBlock_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_6_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  // (COMMA_SYM symbol)?
  private static boolean forBlock_6_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_6_0_3")) return false;
    forBlock_6_0_3_0(b, l + 1);
    return true;
  }

  // COMMA_SYM symbol
  private static boolean forBlock_6_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_6_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE_KEYWORD blockBlock)?
  private static boolean forBlock_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_8")) return false;
    forBlock_8_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD blockBlock
  private static boolean forBlock_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forBlock_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && blockBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (symbol COLON_SYM)? INLINE_KEYWORD?
  //  FOR_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //   (SEP_SYM STAR_SYM? symbol (COMMA_SYM symbol)? SEP_SYM)?
  //    exprOrBlock
  //   (ELSE_KEYWORD blockExpr)?
  public static boolean forOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_OR_BLOCK, "<for or block>");
    r = forOrBlock_0(b, l + 1);
    r = r && forOrBlock_1(b, l + 1);
    r = r && consumeTokens(b, 0, FOR_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && forOrBlock_6(b, l + 1);
    r = r && exprOrBlock(b, l + 1);
    r = r && forOrBlock_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (symbol COLON_SYM)?
  private static boolean forOrBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_0")) return false;
    forOrBlock_0_0(b, l + 1);
    return true;
  }

  // symbol COLON_SYM
  private static boolean forOrBlock_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // INLINE_KEYWORD?
  private static boolean forOrBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_1")) return false;
    consumeToken(b, INLINE_KEYWORD);
    return true;
  }

  // (SEP_SYM STAR_SYM? symbol (COMMA_SYM symbol)? SEP_SYM)?
  private static boolean forOrBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_6")) return false;
    forOrBlock_6_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol (COMMA_SYM symbol)? SEP_SYM
  private static boolean forOrBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && forOrBlock_6_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && forOrBlock_6_0_3(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean forOrBlock_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_6_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  // (COMMA_SYM symbol)?
  private static boolean forOrBlock_6_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_6_0_3")) return false;
    forOrBlock_6_0_3_0(b, l + 1);
    return true;
  }

  // COMMA_SYM symbol
  private static boolean forOrBlock_6_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_6_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE_KEYWORD blockExpr)?
  private static boolean forOrBlock_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_8")) return false;
    forOrBlock_8_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD blockExpr
  private static boolean forOrBlock_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forOrBlock_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && blockExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PUB_KEYWORD? EXPORT_KEYWORD?
  //   variableDeclaration
  //  SEMICOLON_SYM
  public static boolean globalVarDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_VAR_DECLARATION, "<global var declaration>");
    r = globalVarDeclaration_0(b, l + 1);
    r = r && globalVarDeclaration_1(b, l + 1);
    r = r && variableDeclaration(b, l + 1);
    r = r && consumeToken(b, SEMICOLON_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUB_KEYWORD?
  private static boolean globalVarDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDeclaration_0")) return false;
    consumeToken(b, PUB_KEYWORD);
    return true;
  }

  // EXPORT_KEYWORD?
  private static boolean globalVarDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDeclaration_1")) return false;
    consumeToken(b, EXPORT_KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PAREN expr RIGHT_PAREN
  public static boolean groupedExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupedExpr")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, GROUPED_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //   block
  //  (ELSE_KEYWORD blockBlock)?
  public static boolean ifBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifBlock")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && block(b, l + 1);
    r = r && ifBlock_5(b, l + 1);
    exit_section_(b, m, IF_BLOCK, r);
    return r;
  }

  // (ELSE_KEYWORD blockBlock)?
  private static boolean ifBlock_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifBlock_5")) return false;
    ifBlock_5_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD blockBlock
  private static boolean ifBlock_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifBlock_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && blockBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //  (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //   block
  //  ELSE_KEYWORD SEP_SYM symbol SEP_SYM blockBlock
  public static boolean ifErrorBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorBlock")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && ifErrorBlock_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && consumeTokens(b, 0, ELSE_KEYWORD, SEP_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    r = r && blockBlock(b, l + 1);
    exit_section_(b, m, IF_ERROR_BLOCK, r);
    return r;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean ifErrorBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorBlock_4")) return false;
    ifErrorBlock_4_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean ifErrorBlock_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorBlock_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && ifErrorBlock_4_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean ifErrorBlock_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorBlock_4_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  /* ********************************************************** */
  // IF_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //  (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //   exprOrBlock
  //  ELSE_KEYWORD SEP_SYM symbol SEP_SYM blockExpr
  public static boolean ifErrorExprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorExprOrBlock")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && ifErrorExprOrBlock_4(b, l + 1);
    r = r && exprOrBlock(b, l + 1);
    r = r && consumeTokens(b, 0, ELSE_KEYWORD, SEP_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    r = r && blockExpr(b, l + 1);
    exit_section_(b, m, IF_ERROR_EXPR_OR_BLOCK, r);
    return r;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean ifErrorExprOrBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorExprOrBlock_4")) return false;
    ifErrorExprOrBlock_4_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean ifErrorExprOrBlock_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorExprOrBlock_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && ifErrorExprOrBlock_4_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean ifErrorExprOrBlock_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifErrorExprOrBlock_4_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  /* ********************************************************** */
  // IF_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //   exprOrBlock
  //  (ELSE_KEYWORD exprOrBlock)?
  public static boolean ifExprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExprOrBlock")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && exprOrBlock(b, l + 1);
    r = r && ifExprOrBlock_5(b, l + 1);
    exit_section_(b, m, IF_EXPR_OR_BLOCK, r);
    return r;
  }

  // (ELSE_KEYWORD exprOrBlock)?
  private static boolean ifExprOrBlock_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExprOrBlock_5")) return false;
    ifExprOrBlock_5_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD exprOrBlock
  private static boolean ifExprOrBlock_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExprOrBlock_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && exprOrBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INT_LITERAL
  public static boolean integer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer")) return false;
    if (!nextTokenIs(b, INT_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT_LITERAL);
    exit_section_(b, m, INTEGER, r);
    return r;
  }

  /* ********************************************************** */
  // UNDEFINED_KEYWORD
  //  | ERROR_KEYWORD
  //  | THIS_KEYWORD
  //  | UNREACHABLE_KEYWORD
  //  | SUSPEND_KEYWORD
  public static boolean keywordLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keywordLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD_LITERAL, "<keyword literal>");
    r = consumeToken(b, UNDEFINED_KEYWORD);
    if (!r) r = consumeToken(b, ERROR_KEYWORD);
    if (!r) r = consumeToken(b, THIS_KEYWORD);
    if (!r) r = consumeToken(b, UNREACHABLE_KEYWORD);
    if (!r) r = consumeToken(b, SUSPEND_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMPTIME_KEYWORD? variableDeclaration
  //  SEMICOLON_SYM
  public static boolean localVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOCAL_VARIABLE_DECLARATION, "<local variable declaration>");
    r = localVariableDeclaration_0(b, l + 1);
    r = r && variableDeclaration(b, l + 1);
    r = r && consumeToken(b, SEMICOLON_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMPTIME_KEYWORD?
  private static boolean localVariableDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_0")) return false;
    consumeToken(b, COMPTIME_KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // AT_SYM BUILTIN_FUNCTION fnCallSuffix
  public static boolean macroExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroExpr")) return false;
    if (!nextTokenIs(b, AT_SYM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MACRO_EXPR, null);
    r = consumeTokens(b, 1, AT_SYM, BUILTIN_FUNCTION);
    p = r; // pin = 1
    r = r && fnCallSuffix(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // expr multiplyOperator expr
  public static boolean multiplyExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_EXPR, "<multiply expr>");
    r = expr(b, l + 1);
    r = r && multiplyOperator(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SEP_SEP_SYM | STAR_SYM | DIV_SYM | MOD_SYM | STAR_STAR_SYM | STAR_MOD_SYM
  public static boolean multiplyOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_OPERATOR, "<multiply operator>");
    r = consumeToken(b, SEP_SEP_SYM);
    if (!r) r = consumeToken(b, STAR_SYM);
    if (!r) r = consumeToken(b, DIV_SYM);
    if (!r) r = consumeToken(b, MOD_SYM);
    if (!r) r = consumeToken(b, STAR_STAR_SYM);
    if (!r) r = consumeToken(b, STAR_MOD_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NULL_KEYWORD
  public static boolean null_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "null_$")) return false;
    if (!nextTokenIs(b, NULL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL_KEYWORD);
    exit_section_(b, m, NULL, r);
    return r;
  }

  /* ********************************************************** */
  // DOT_SYM QUESTION_SYM
  public static boolean optionalSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optionalSuffix")) return false;
    if (!nextTokenIs(b, DOT_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT_SYM, QUESTION_SYM);
    exit_section_(b, m, OPTIONAL_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // expr ORELSE_KEYWORD expr
  public static boolean orElseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orElseExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OR_ELSE_EXPR, "<or else expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, ORELSE_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (NOALIAS_KEYWORD | COMPTIME_KEYWORD)?
  //  (symbol COLON_SYM)?
  //  (typeExpr | VAR_KEYWORD | RANGE_SYM)
  public static boolean paramDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DECLARATION, "<param declaration>");
    r = paramDeclaration_0(b, l + 1);
    r = r && paramDeclaration_1(b, l + 1);
    r = r && paramDeclaration_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NOALIAS_KEYWORD | COMPTIME_KEYWORD)?
  private static boolean paramDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_0")) return false;
    paramDeclaration_0_0(b, l + 1);
    return true;
  }

  // NOALIAS_KEYWORD | COMPTIME_KEYWORD
  private static boolean paramDeclaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_0_0")) return false;
    boolean r;
    r = consumeToken(b, NOALIAS_KEYWORD);
    if (!r) r = consumeToken(b, COMPTIME_KEYWORD);
    return r;
  }

  // (symbol COLON_SYM)?
  private static boolean paramDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_1")) return false;
    paramDeclaration_1_0(b, l + 1);
    return true;
  }

  // symbol COLON_SYM
  private static boolean paramDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeExpr | VAR_KEYWORD | RANGE_SYM
  private static boolean paramDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_2")) return false;
    boolean r;
    r = typeExpr(b, l + 1);
    if (!r) r = consumeToken(b, VAR_KEYWORD);
    if (!r) r = consumeToken(b, RANGE_SYM);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN (paramDeclaration (COMMA_SYM paramDeclaration)*)? RIGHT_PAREN
  public static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && parameterList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // (paramDeclaration (COMMA_SYM paramDeclaration)*)?
  private static boolean parameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1")) return false;
    parameterList_1_0(b, l + 1);
    return true;
  }

  // paramDeclaration (COMMA_SYM paramDeclaration)*
  private static boolean parameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paramDeclaration(b, l + 1);
    r = r && parameterList_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM paramDeclaration)*
  private static boolean parameterList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameterList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM paramDeclaration
  private static boolean parameterList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && paramDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT_SYM STAR_SYM
  public static boolean pointerSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pointerSuffix")) return false;
    if (!nextTokenIs(b, DOT_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT_SYM, STAR_SYM);
    exit_section_(b, m, POINTER_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // NOT_SYM
  //  | MINUS_SYM
  //  | BITWISE_NOT_SYM
  //  | STAR_SYM
  //  | AND_SYM
  //  ( ALIGN_KEYWORD LEFT_PAREN
  //    expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN
  //  )? CONST_KEYWORD? VOLATILE_KEYWORD?
  //  | QUESTION_SYM
  //  | VERY_QUESTION_SYM
  //  | MINUS_MOD_SYM
  //  | TRY_KEYWORD
  //  | AWAIT_KEYWORD
  public static boolean prefixOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_OP, "<prefix op>");
    r = consumeToken(b, NOT_SYM);
    if (!r) r = consumeToken(b, MINUS_SYM);
    if (!r) r = consumeToken(b, BITWISE_NOT_SYM);
    if (!r) r = consumeToken(b, STAR_SYM);
    if (!r) r = prefixOp_4(b, l + 1);
    if (!r) r = consumeToken(b, QUESTION_SYM);
    if (!r) r = consumeToken(b, VERY_QUESTION_SYM);
    if (!r) r = consumeToken(b, MINUS_MOD_SYM);
    if (!r) r = consumeToken(b, TRY_KEYWORD);
    if (!r) r = consumeToken(b, AWAIT_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AND_SYM
  //  ( ALIGN_KEYWORD LEFT_PAREN
  //    expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN
  //  )? CONST_KEYWORD? VOLATILE_KEYWORD?
  private static boolean prefixOp_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND_SYM);
    r = r && prefixOp_4_1(b, l + 1);
    r = r && prefixOp_4_2(b, l + 1);
    r = r && prefixOp_4_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ALIGN_KEYWORD LEFT_PAREN
  //    expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN
  //  )?
  private static boolean prefixOp_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4_1")) return false;
    prefixOp_4_1_0(b, l + 1);
    return true;
  }

  // ALIGN_KEYWORD LEFT_PAREN
  //    expr (COLON_SYM integer COLON_SYM integer)? RIGHT_PAREN
  private static boolean prefixOp_4_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && prefixOp_4_1_0_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON_SYM integer COLON_SYM integer)?
  private static boolean prefixOp_4_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4_1_0_3")) return false;
    prefixOp_4_1_0_3_0(b, l + 1);
    return true;
  }

  // COLON_SYM integer COLON_SYM integer
  private static boolean prefixOp_4_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4_1_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && integer(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    r = r && integer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CONST_KEYWORD?
  private static boolean prefixOp_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4_2")) return false;
    consumeToken(b, CONST_KEYWORD);
    return true;
  }

  // VOLATILE_KEYWORD?
  private static boolean prefixOp_4_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOp_4_3")) return false;
    consumeToken(b, VOLATILE_KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // prefixOp expr
  public static boolean prefixOpExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOpExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_OP_EXPR, "<prefix op expr>");
    r = prefixOp(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // integer
  //  | float
  //  | string
  //  | char
  //  | keywordLiteral
  //  | boolean
  //  | null
  //  | blockExpr
  //  | symbol
  //  | macroExpr
  //  | arrayExpr
  //  | fnProto
  //  | asmExpr
  //  | containerExpr
  //  | continueExpr
  //  | errorSetExpr
  //  | groupedExpr
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    r = integer(b, l + 1);
    if (!r) r = float_$(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = char_$(b, l + 1);
    if (!r) r = keywordLiteral(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = null_$(b, l + 1);
    if (!r) r = blockExpr(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = macroExpr(b, l + 1);
    if (!r) r = arrayExpr(b, l + 1);
    if (!r) r = fnProto(b, l + 1);
    if (!r) r = asmExpr(b, l + 1);
    if (!r) r = containerExpr(b, l + 1);
    if (!r) r = continueExpr(b, l + 1);
    if (!r) r = errorSetExpr(b, l + 1);
    if (!r) r = groupedExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // RESUME_KEYWORD expr
  public static boolean resumeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resumeExpr")) return false;
    if (!nextTokenIs(b, RESUME_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RESUME_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, m, RESUME_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN_KEYWORD expr?
  public static boolean returnExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnExpr")) return false;
    if (!nextTokenIs(b, RETURN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN_KEYWORD);
    r = r && returnExpr_1(b, l + 1);
    exit_section_(b, m, RETURN_EXPR, r);
    return r;
  }

  // expr?
  private static boolean returnExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnExpr_1")) return false;
    expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKET expr SLICE_SYM expr? RIGHT_BRACKET
  public static boolean sliceSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sliceSuffix")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SLICE_SYM);
    r = r && sliceSuffix_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, SLICE_SUFFIX, r);
    return r;
  }

  // expr?
  private static boolean sliceSuffix_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sliceSuffix_3")) return false;
    expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // localVariableDeclaration
  //  | deferBlock
  //  | defer SEMICOLON_SYM
  //  | blockBlock
  //  | expr? SEMICOLON_SYM
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = localVariableDeclaration(b, l + 1);
    if (!r) r = deferBlock(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    if (!r) r = blockBlock(b, l + 1);
    if (!r) r = statement_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // defer SEMICOLON_SYM
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = defer(b, l + 1);
    r = r && consumeToken(b, SEMICOLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr? SEMICOLON_SYM
  private static boolean statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_4_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr?
  private static boolean statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4_0")) return false;
    expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STR | RAW_STR
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, "<string>", RAW_STR, STR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = consumeToken(b, STR);
    if (!r) r = consumeToken(b, RAW_STR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOT_SYM symbol EQ_SYM expr
  public static boolean structLiteralField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structLiteralField")) return false;
    if (!nextTokenIs(b, DOT_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, EQ_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, STRUCT_LITERAL_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // expr
  //  (
  //    fnCallSuffix
  //  | arrayAccessSuffix
  //  | fieldAccessSuffix
  //  | sliceSuffix
  //  | pointerSuffix
  //  | optionalSuffix
  //  )
  public static boolean suffixOpExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffixOpExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUFFIX_OP_EXPR, "<suffix op expr>");
    r = expr(b, l + 1);
    r = r && suffixOpExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fnCallSuffix
  //  | arrayAccessSuffix
  //  | fieldAccessSuffix
  //  | sliceSuffix
  //  | pointerSuffix
  //  | optionalSuffix
  private static boolean suffixOpExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffixOpExpr_1")) return false;
    boolean r;
    r = fnCallSuffix(b, l + 1);
    if (!r) r = arrayAccessSuffix(b, l + 1);
    if (!r) r = fieldAccessSuffix(b, l + 1);
    if (!r) r = sliceSuffix(b, l + 1);
    if (!r) r = pointerSuffix(b, l + 1);
    if (!r) r = optionalSuffix(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SUSPEND_KEYWORD (SEP_SYM symbol SEP_SYM block)?
  public static boolean suspendBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suspendBlock")) return false;
    if (!nextTokenIs(b, SUSPEND_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUSPEND_KEYWORD);
    r = r && suspendBlock_1(b, l + 1);
    exit_section_(b, m, SUSPEND_BLOCK, r);
    return r;
  }

  // (SEP_SYM symbol SEP_SYM block)?
  private static boolean suspendBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suspendBlock_1")) return false;
    suspendBlock_1_0(b, l + 1);
    return true;
  }

  // SEP_SYM symbol SEP_SYM block
  private static boolean suspendBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suspendBlock_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SUSPEND_KEYWORD (SEP_SYM symbol SEP_SYM exprOrBlock)?
  public static boolean suspendExprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suspendExprOrBlock")) return false;
    if (!nextTokenIs(b, SUSPEND_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUSPEND_KEYWORD);
    r = r && suspendExprOrBlock_1(b, l + 1);
    exit_section_(b, m, SUSPEND_EXPR_OR_BLOCK, r);
    return r;
  }

  // (SEP_SYM symbol SEP_SYM exprOrBlock)?
  private static boolean suspendExprOrBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suspendExprOrBlock_1")) return false;
    suspendExprOrBlock_1_0(b, l + 1);
    return true;
  }

  // SEP_SYM symbol SEP_SYM exprOrBlock
  private static boolean suspendExprOrBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suspendExprOrBlock_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    r = r && exprOrBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (RANGE_SYM expr)?
  public static boolean switchItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_ITEM, "<switch item>");
    r = expr(b, l + 1);
    r = r && switchItem_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (RANGE_SYM expr)?
  private static boolean switchItem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchItem_1")) return false;
    switchItem_1_0(b, l + 1);
    return true;
  }

  // RANGE_SYM expr
  private static boolean switchItem_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchItem_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RANGE_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (ELSE_KEYWORD | (switchItem (COMMA_SYM switchItem)*)?)
  //  ARROW_SYM
  //  (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //  expr COMMA_SYM
  public static boolean switchProng(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_PRONG, "<switch prong>");
    r = switchProng_0(b, l + 1);
    r = r && consumeToken(b, ARROW_SYM);
    r = r && switchProng_2(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, COMMA_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ELSE_KEYWORD | (switchItem (COMMA_SYM switchItem)*)?
  private static boolean switchProng_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    if (!r) r = switchProng_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (switchItem (COMMA_SYM switchItem)*)?
  private static boolean switchProng_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_0_1")) return false;
    switchProng_0_1_0(b, l + 1);
    return true;
  }

  // switchItem (COMMA_SYM switchItem)*
  private static boolean switchProng_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = switchItem(b, l + 1);
    r = r && switchProng_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA_SYM switchItem)*
  private static boolean switchProng_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_0_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!switchProng_0_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switchProng_0_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA_SYM switchItem
  private static boolean switchProng_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA_SYM);
    r = r && switchItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean switchProng_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_2")) return false;
    switchProng_2_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean switchProng_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && switchProng_2_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean switchProng_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchProng_2_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  /* ********************************************************** */
  // SWITCH_KEYWORD
  //   LEFT_PAREN expr RIGHT_PAREN
  //   LEFT_BRACE switchProng* RIGHT_BRACE
  public static boolean switchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchStatement")) return false;
    if (!nextTokenIs(b, SWITCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SWITCH_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_PAREN, LEFT_BRACE);
    r = r && switchStatement_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  // switchProng*
  private static boolean switchStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchStatement_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!switchProng(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switchStatement_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SYM
  public static boolean symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbol")) return false;
    if (!nextTokenIs(b, SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYM);
    exit_section_(b, m, SYMBOL, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //  (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //   block
  //  (ELSE_KEYWORD blockBlock)?
  public static boolean testBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testBlock")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && testBlock_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && testBlock_6(b, l + 1);
    exit_section_(b, m, TEST_BLOCK, r);
    return r;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean testBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testBlock_4")) return false;
    testBlock_4_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean testBlock_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testBlock_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && testBlock_4_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean testBlock_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testBlock_4_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  // (ELSE_KEYWORD blockBlock)?
  private static boolean testBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testBlock_6")) return false;
    testBlock_6_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD blockBlock
  private static boolean testBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && blockBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEST_KEYWORD string block
  public static boolean testDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testDeclaration")) return false;
    if (!nextTokenIs(b, TEST_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST_KEYWORD);
    r = r && string(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, TEST_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //  (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //   exprOrBlock
  //  (ELSE_KEYWORD blockExpr)?
  public static boolean testExprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testExprOrBlock")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && testExprOrBlock_4(b, l + 1);
    r = r && exprOrBlock(b, l + 1);
    r = r && testExprOrBlock_6(b, l + 1);
    exit_section_(b, m, TEST_EXPR_OR_BLOCK, r);
    return r;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean testExprOrBlock_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testExprOrBlock_4")) return false;
    testExprOrBlock_4_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean testExprOrBlock_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testExprOrBlock_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && testExprOrBlock_4_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean testExprOrBlock_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testExprOrBlock_4_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  // (ELSE_KEYWORD blockExpr)?
  private static boolean testExprOrBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testExprOrBlock_6")) return false;
    testExprOrBlock_6_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD blockExpr
  private static boolean testExprOrBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testExprOrBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && blockExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMPTIME_KEYWORD block
  //  | fnDeclaration
  //  | externDeclaration
  //  | globalVarDeclaration
  //  | useDeclaration
  //  | testDeclaration
  //  | expr
  static boolean topLevelItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelItem")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = topLevelItem_0(b, l + 1);
    if (!r) r = fnDeclaration(b, l + 1);
    if (!r) r = externDeclaration(b, l + 1);
    if (!r) r = globalVarDeclaration(b, l + 1);
    if (!r) r = useDeclaration(b, l + 1);
    if (!r) r = testDeclaration(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMPTIME_KEYWORD block
  private static boolean topLevelItem_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelItem_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPTIME_KEYWORD);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TRY_KEYWORD expr
  public static boolean tryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryExpr")) return false;
    if (!nextTokenIs(b, TRY_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY_KEYWORD);
    r = r && expr(b, l + 1);
    exit_section_(b, m, TRY_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // expr NOT_SYM expr
  public static boolean typeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPR, "<type expr>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, NOT_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CATCH_KEYWORD (SEP_SYM symbol SEP_SYM)? expr
  public static boolean unwrapError(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapError")) return false;
    if (!nextTokenIs(b, CATCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH_KEYWORD);
    r = r && unwrapError_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, UNWRAP_ERROR, r);
    return r;
  }

  // (SEP_SYM symbol SEP_SYM)?
  private static boolean unwrapError_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapError_1")) return false;
    unwrapError_1_0(b, l + 1);
    return true;
  }

  // SEP_SYM symbol SEP_SYM
  private static boolean unwrapError_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapError_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (unwrapNullable | unwrapError)
  public static boolean unwrapExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNWRAP_EXPR, "<unwrap expr>");
    r = expr(b, l + 1);
    r = r && unwrapExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unwrapNullable | unwrapError
  private static boolean unwrapExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapExpr_1")) return false;
    boolean r;
    r = unwrapNullable(b, l + 1);
    if (!r) r = unwrapError(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // VERY_QUESTION_SYM expr
  public static boolean unwrapNullable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unwrapNullable")) return false;
    if (!nextTokenIs(b, VERY_QUESTION_SYM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERY_QUESTION_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, UNWRAP_NULLABLE, r);
    return r;
  }

  /* ********************************************************** */
  // PUB_KEYWORD? USE_KEYWORD expr
  //  SEMICOLON_SYM
  public static boolean useDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useDeclaration")) return false;
    if (!nextTokenIs(b, "<use declaration>", PUB_KEYWORD, USE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_DECLARATION, "<use declaration>");
    r = useDeclaration_0(b, l + 1);
    r = r && consumeToken(b, USE_KEYWORD);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON_SYM);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUB_KEYWORD?
  private static boolean useDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useDeclaration_0")) return false;
    consumeToken(b, PUB_KEYWORD);
    return true;
  }

  /* ********************************************************** */
  // (VAR_KEYWORD | CONST_KEYWORD) symbol (COLON_SYM (typeExpr | primary))?
  //  (ALIGN_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  //  (SECTION_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  //  (EQ_SYM expr)?
  public static boolean variableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration")) return false;
    if (!nextTokenIs(b, "<variable declaration>", CONST_KEYWORD, VAR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION, "<variable declaration>");
    r = variableDeclaration_0(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && variableDeclaration_2(b, l + 1);
    r = r && variableDeclaration_3(b, l + 1);
    r = r && variableDeclaration_4(b, l + 1);
    r = r && variableDeclaration_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VAR_KEYWORD | CONST_KEYWORD
  private static boolean variableDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_0")) return false;
    boolean r;
    r = consumeToken(b, VAR_KEYWORD);
    if (!r) r = consumeToken(b, CONST_KEYWORD);
    return r;
  }

  // (COLON_SYM (typeExpr | primary))?
  private static boolean variableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_2")) return false;
    variableDeclaration_2_0(b, l + 1);
    return true;
  }

  // COLON_SYM (typeExpr | primary)
  private static boolean variableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON_SYM);
    r = r && variableDeclaration_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeExpr | primary
  private static boolean variableDeclaration_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_2_0_1")) return false;
    boolean r;
    r = typeExpr(b, l + 1);
    if (!r) r = primary(b, l + 1);
    return r;
  }

  // (ALIGN_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean variableDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_3")) return false;
    variableDeclaration_3_0(b, l + 1);
    return true;
  }

  // ALIGN_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  private static boolean variableDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SECTION_KEYWORD LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean variableDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_4")) return false;
    variableDeclaration_4_0(b, l + 1);
    return true;
  }

  // SECTION_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  private static boolean variableDeclaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SECTION_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EQ_SYM expr)?
  private static boolean variableDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_5")) return false;
    variableDeclaration_5_0(b, l + 1);
    return true;
  }

  // EQ_SYM expr
  private static boolean variableDeclaration_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ_SYM);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (symbol COLON_SYM)? INLINE_KEYWORD?
  //  WHILE_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //   (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //   (COLON_SYM LEFT_PAREN expr RIGHT_PAREN)?
  //    block
  //   (ELSE_KEYWORD (SEP_SYM symbol SEP_SYM)? blockBlock)?
  public static boolean whileBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHILE_BLOCK, "<while block>");
    r = whileBlock_0(b, l + 1);
    r = r && whileBlock_1(b, l + 1);
    r = r && consumeTokens(b, 0, WHILE_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && whileBlock_6(b, l + 1);
    r = r && whileBlock_7(b, l + 1);
    r = r && block(b, l + 1);
    r = r && whileBlock_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (symbol COLON_SYM)?
  private static boolean whileBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_0")) return false;
    whileBlock_0_0(b, l + 1);
    return true;
  }

  // symbol COLON_SYM
  private static boolean whileBlock_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // INLINE_KEYWORD?
  private static boolean whileBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_1")) return false;
    consumeToken(b, INLINE_KEYWORD);
    return true;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean whileBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_6")) return false;
    whileBlock_6_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean whileBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && whileBlock_6_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean whileBlock_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_6_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  // (COLON_SYM LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean whileBlock_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_7")) return false;
    whileBlock_7_0(b, l + 1);
    return true;
  }

  // COLON_SYM LEFT_PAREN expr RIGHT_PAREN
  private static boolean whileBlock_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON_SYM, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE_KEYWORD (SEP_SYM symbol SEP_SYM)? blockBlock)?
  private static boolean whileBlock_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_9")) return false;
    whileBlock_9_0(b, l + 1);
    return true;
  }

  // ELSE_KEYWORD (SEP_SYM symbol SEP_SYM)? blockBlock
  private static boolean whileBlock_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE_KEYWORD);
    r = r && whileBlock_9_0_1(b, l + 1);
    r = r && blockBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SEP_SYM symbol SEP_SYM)?
  private static boolean whileBlock_9_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_9_0_1")) return false;
    whileBlock_9_0_1_0(b, l + 1);
    return true;
  }

  // SEP_SYM symbol SEP_SYM
  private static boolean whileBlock_9_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileBlock_9_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (symbol COLON_SYM)? INLINE_KEYWORD?
  //  WHILE_KEYWORD LEFT_PAREN expr RIGHT_PAREN
  //   (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  //   (COLON_SYM LEFT_PAREN expr RIGHT_PAREN)?
  //    exprOrBlock
  public static boolean whileExprOrBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHILE_EXPR_OR_BLOCK, "<while expr or block>");
    r = whileExprOrBlock_0(b, l + 1);
    r = r && whileExprOrBlock_1(b, l + 1);
    r = r && consumeTokens(b, 0, WHILE_KEYWORD, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && whileExprOrBlock_6(b, l + 1);
    r = r && whileExprOrBlock_7(b, l + 1);
    r = r && exprOrBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (symbol COLON_SYM)?
  private static boolean whileExprOrBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_0")) return false;
    whileExprOrBlock_0_0(b, l + 1);
    return true;
  }

  // symbol COLON_SYM
  private static boolean whileExprOrBlock_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = symbol(b, l + 1);
    r = r && consumeToken(b, COLON_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // INLINE_KEYWORD?
  private static boolean whileExprOrBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_1")) return false;
    consumeToken(b, INLINE_KEYWORD);
    return true;
  }

  // (SEP_SYM STAR_SYM? symbol SEP_SYM)?
  private static boolean whileExprOrBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_6")) return false;
    whileExprOrBlock_6_0(b, l + 1);
    return true;
  }

  // SEP_SYM STAR_SYM? symbol SEP_SYM
  private static boolean whileExprOrBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEP_SYM);
    r = r && whileExprOrBlock_6_0_1(b, l + 1);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, SEP_SYM);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR_SYM?
  private static boolean whileExprOrBlock_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_6_0_1")) return false;
    consumeToken(b, STAR_SYM);
    return true;
  }

  // (COLON_SYM LEFT_PAREN expr RIGHT_PAREN)?
  private static boolean whileExprOrBlock_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_7")) return false;
    whileExprOrBlock_7_0(b, l + 1);
    return true;
  }

  // COLON_SYM LEFT_PAREN expr RIGHT_PAREN
  private static boolean whileExprOrBlock_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileExprOrBlock_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON_SYM, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // topLevelItem*
  static boolean zigFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zigFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!topLevelItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "zigFile", c)) break;
    }
    return true;
  }

}
