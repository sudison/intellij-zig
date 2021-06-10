// This is a generated file. Not intended for manual editing.
package org.ziglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.ziglang.psi.impl.*;

public interface ZigLangTypes {

  IElementType ADDITION_EXPR = new ZigLangElementType("ADDITION_EXPR");
  IElementType ADDITION_OP = new ZigLangElementType("ADDITION_OP");
  IElementType ASSIGN_EXPR = new ZigLangElementType("ASSIGN_EXPR");
  IElementType ASSIGN_OP = new ZigLangElementType("ASSIGN_OP");
  IElementType BITWISE_EXPR = new ZigLangElementType("BITWISE_EXPR");
  IElementType BITWISE_OP = new ZigLangElementType("BITWISE_OP");
  IElementType BIT_SHIFT_EXPR = new ZigLangElementType("BIT_SHIFT_EXPR");
  IElementType BIT_SHIFT_OP = new ZigLangElementType("BIT_SHIFT_OP");
  IElementType BLOCK = new ZigLangElementType("BLOCK");
  IElementType BOOL_AND_EXPR = new ZigLangElementType("BOOL_AND_EXPR");
  IElementType BOOL_OR_EXPR = new ZigLangElementType("BOOL_OR_EXPR");
  IElementType BUILTINIDENTIFIER = new ZigLangElementType("BUILTINIDENTIFIER");
  IElementType COMPARE_EXPR = new ZigLangElementType("COMPARE_EXPR");
  IElementType COMPARE_OP = new ZigLangElementType("COMPARE_OP");
  IElementType CONTAINER_DECLARATIONS = new ZigLangElementType("CONTAINER_DECLARATIONS");
  IElementType CONTAINER_DOC_COMMENT = new ZigLangElementType("CONTAINER_DOC_COMMENT");
  IElementType CONTAINER_MEMBERS = new ZigLangElementType("CONTAINER_MEMBERS");
  IElementType CURLY_SUFFIX_EXPR = new ZigLangElementType("CURLY_SUFFIX_EXPR");
  IElementType ERROR_UNION_EXPR = new ZigLangElementType("ERROR_UNION_EXPR");
  IElementType EXPR = new ZigLangElementType("EXPR");
  IElementType EXPR_LIST = new ZigLangElementType("EXPR_LIST");
  IElementType FN_CALL_ARGUMENTS = new ZigLangElementType("FN_CALL_ARGUMENTS");
  IElementType FN_PROTO = new ZigLangElementType("FN_PROTO");
  IElementType IF_EXPR = new ZigLangElementType("IF_EXPR");
  IElementType IF_PREFIX = new ZigLangElementType("IF_PREFIX");
  IElementType MULTIPLY_EXPR = new ZigLangElementType("MULTIPLY_EXPR");
  IElementType MULTIPLY_OP = new ZigLangElementType("MULTIPLY_OP");
  IElementType PARAM_DECL = new ZigLangElementType("PARAM_DECL");
  IElementType PARAM_DECL_LIST = new ZigLangElementType("PARAM_DECL_LIST");
  IElementType PARAM_TYPE = new ZigLangElementType("PARAM_TYPE");
  IElementType PAYLOAD = new ZigLangElementType("PAYLOAD");
  IElementType PREFIX_EXPR = new ZigLangElementType("PREFIX_EXPR");
  IElementType PREFIX_OP = new ZigLangElementType("PREFIX_OP");
  IElementType PRIMARY_EXPR = new ZigLangElementType("PRIMARY_EXPR");
  IElementType PRIMARY_TYPE_EXPR = new ZigLangElementType("PRIMARY_TYPE_EXPR");
  IElementType PTR_PAYLOAD = new ZigLangElementType("PTR_PAYLOAD");
  IElementType STATEMENT = new ZigLangElementType("STATEMENT");
  IElementType STRINGLITERAL = new ZigLangElementType("STRINGLITERAL");
  IElementType SUFFIX_EXPR = new ZigLangElementType("SUFFIX_EXPR");
  IElementType SUFFIX_OP = new ZigLangElementType("SUFFIX_OP");
  IElementType TOP_LEVEL_DECL = new ZigLangElementType("TOP_LEVEL_DECL");
  IElementType TYPE_EXPR = new ZigLangElementType("TYPE_EXPR");
  IElementType VAR_DECL = new ZigLangElementType("VAR_DECL");

  IElementType AMPERSAND = new ZigLangTokenType("&");
  IElementType AMPERSANDEQUAL = new ZigLangTokenType("&=");
  IElementType AND = new ZigLangTokenType("and");
  IElementType ASTERISK = new ZigLangTokenType("*");
  IElementType ASTERISK2 = new ZigLangTokenType("**");
  IElementType ASTERISKEQUAL = new ZigLangTokenType("*=");
  IElementType ASTERISKPERCENT = new ZigLangTokenType("*%");
  IElementType ASTERISKPERCENTEQUAL = new ZigLangTokenType("*%=");
  IElementType AWAIT = new ZigLangTokenType("AWAIT");
  IElementType CARET = new ZigLangTokenType("^");
  IElementType CARETEQUAL = new ZigLangTokenType("^=");
  IElementType CATCH = new ZigLangTokenType("catch");
  IElementType COLON = new ZigLangTokenType(":");
  IElementType COMMA = new ZigLangTokenType(",");
  IElementType COMMENT = new ZigLangTokenType("COMMENT");
  IElementType CONST = new ZigLangTokenType("const");
  IElementType DOT = new ZigLangTokenType(".");
  IElementType DOT2 = new ZigLangTokenType("DOT2");
  IElementType DOTASTERISK = new ZigLangTokenType(".*");
  IElementType DOTQUESTIONMARK = new ZigLangTokenType(".?");
  IElementType ELSE = new ZigLangTokenType("else");
  IElementType EQUAL = new ZigLangTokenType("=");
  IElementType EQUALEQUAL = new ZigLangTokenType("==");
  IElementType EXCLAMATIONMARK = new ZigLangTokenType("!");
  IElementType EXCLAMATIONMARKEQUAL = new ZigLangTokenType("!=");
  IElementType FN = new ZigLangTokenType("fn");
  IElementType ID = new ZigLangTokenType("ID");
  IElementType IF = new ZigLangTokenType("if");
  IElementType INTEGER = new ZigLangTokenType("INTEGER");
  IElementType LARROW = new ZigLangTokenType("<");
  IElementType LARROW2 = new ZigLangTokenType("<<");
  IElementType LARROW2EQUAL = new ZigLangTokenType("<<=");
  IElementType LARROWEQUAL = new ZigLangTokenType("<=");
  IElementType LBRACE = new ZigLangTokenType("{");
  IElementType LBRACKET = new ZigLangTokenType("[");
  IElementType LPAREN = new ZigLangTokenType("(");
  IElementType MINUS = new ZigLangTokenType("-");
  IElementType MINUSEQUAL = new ZigLangTokenType("-=");
  IElementType MINUSPERCENT = new ZigLangTokenType("-%");
  IElementType MINUSPERCENTEQUAL = new ZigLangTokenType("-%=");
  IElementType OR = new ZigLangTokenType("or");
  IElementType ORELSE = new ZigLangTokenType("orelse");
  IElementType PERCENT = new ZigLangTokenType("%");
  IElementType PERCENTEQUAL = new ZigLangTokenType("%=");
  IElementType PIPE = new ZigLangTokenType("|");
  IElementType PIPE2 = new ZigLangTokenType("||");
  IElementType PIPEEQUAL = new ZigLangTokenType("|=");
  IElementType PLUS = new ZigLangTokenType("+");
  IElementType PLUS2 = new ZigLangTokenType("++");
  IElementType PLUSEQUAL = new ZigLangTokenType("+=");
  IElementType PLUSPERCENT = new ZigLangTokenType("+%");
  IElementType PLUSPERCENTEQUAL = new ZigLangTokenType("+%=");
  IElementType PUB = new ZigLangTokenType("pub");
  IElementType RARROW = new ZigLangTokenType(">");
  IElementType RARROW2 = new ZigLangTokenType(">>");
  IElementType RARROW2EQUAL = new ZigLangTokenType(">>=");
  IElementType RARROWEQUAL = new ZigLangTokenType(">=");
  IElementType RBRACE = new ZigLangTokenType("}");
  IElementType RBRACKET = new ZigLangTokenType("]");
  IElementType RETURN = new ZigLangTokenType("return");
  IElementType RPAREN = new ZigLangTokenType(")");
  IElementType SEMICOLON = new ZigLangTokenType(";");
  IElementType SLASH = new ZigLangTokenType("/");
  IElementType SLASHEQUAL = new ZigLangTokenType("/=");
  IElementType STRINGLITERALSINGLE = new ZigLangTokenType("STRINGLITERALSINGLE");
  IElementType TILDE = new ZigLangTokenType("~");
  IElementType TRY = new ZigLangTokenType("try");
  IElementType VAR = new ZigLangTokenType("var");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITION_EXPR) {
        return new ZigAdditionExprImpl(node);
      }
      else if (type == ADDITION_OP) {
        return new ZigAdditionOpImpl(node);
      }
      else if (type == ASSIGN_EXPR) {
        return new ZigAssignExprImpl(node);
      }
      else if (type == ASSIGN_OP) {
        return new ZigAssignOpImpl(node);
      }
      else if (type == BITWISE_EXPR) {
        return new ZigBitwiseExprImpl(node);
      }
      else if (type == BITWISE_OP) {
        return new ZigBitwiseOpImpl(node);
      }
      else if (type == BIT_SHIFT_EXPR) {
        return new ZigBitShiftExprImpl(node);
      }
      else if (type == BIT_SHIFT_OP) {
        return new ZigBitShiftOpImpl(node);
      }
      else if (type == BLOCK) {
        return new ZigBlockImpl(node);
      }
      else if (type == BOOL_AND_EXPR) {
        return new ZigBoolAndExprImpl(node);
      }
      else if (type == BOOL_OR_EXPR) {
        return new ZigBoolOrExprImpl(node);
      }
      else if (type == BUILTINIDENTIFIER) {
        return new ZigBuiltinidentifierImpl(node);
      }
      else if (type == COMPARE_EXPR) {
        return new ZigCompareExprImpl(node);
      }
      else if (type == COMPARE_OP) {
        return new ZigCompareOpImpl(node);
      }
      else if (type == CONTAINER_DECLARATIONS) {
        return new ZigContainerDeclarationsImpl(node);
      }
      else if (type == CONTAINER_DOC_COMMENT) {
        return new ZigContainerDocCommentImpl(node);
      }
      else if (type == CONTAINER_MEMBERS) {
        return new ZigContainerMembersImpl(node);
      }
      else if (type == CURLY_SUFFIX_EXPR) {
        return new ZigCurlySuffixExprImpl(node);
      }
      else if (type == ERROR_UNION_EXPR) {
        return new ZigErrorUnionExprImpl(node);
      }
      else if (type == EXPR) {
        return new ZigExprImpl(node);
      }
      else if (type == EXPR_LIST) {
        return new ZigExprListImpl(node);
      }
      else if (type == FN_CALL_ARGUMENTS) {
        return new ZigFnCallArgumentsImpl(node);
      }
      else if (type == FN_PROTO) {
        return new ZigFnProtoImpl(node);
      }
      else if (type == IF_EXPR) {
        return new ZigIfExprImpl(node);
      }
      else if (type == IF_PREFIX) {
        return new ZigIfPrefixImpl(node);
      }
      else if (type == MULTIPLY_EXPR) {
        return new ZigMultiplyExprImpl(node);
      }
      else if (type == MULTIPLY_OP) {
        return new ZigMultiplyOpImpl(node);
      }
      else if (type == PARAM_DECL) {
        return new ZigParamDeclImpl(node);
      }
      else if (type == PARAM_DECL_LIST) {
        return new ZigParamDeclListImpl(node);
      }
      else if (type == PARAM_TYPE) {
        return new ZigParamTypeImpl(node);
      }
      else if (type == PAYLOAD) {
        return new ZigPayloadImpl(node);
      }
      else if (type == PREFIX_EXPR) {
        return new ZigPrefixExprImpl(node);
      }
      else if (type == PREFIX_OP) {
        return new ZigPrefixOpImpl(node);
      }
      else if (type == PRIMARY_EXPR) {
        return new ZigPrimaryExprImpl(node);
      }
      else if (type == PRIMARY_TYPE_EXPR) {
        return new ZigPrimaryTypeExprImpl(node);
      }
      else if (type == PTR_PAYLOAD) {
        return new ZigPtrPayloadImpl(node);
      }
      else if (type == STATEMENT) {
        return new ZigStatementImpl(node);
      }
      else if (type == STRINGLITERAL) {
        return new ZigStringliteralImpl(node);
      }
      else if (type == SUFFIX_EXPR) {
        return new ZigSuffixExprImpl(node);
      }
      else if (type == SUFFIX_OP) {
        return new ZigSuffixOpImpl(node);
      }
      else if (type == TOP_LEVEL_DECL) {
        return new ZigTopLevelDeclImpl(node);
      }
      else if (type == TYPE_EXPR) {
        return new ZigTypeExprImpl(node);
      }
      else if (type == VAR_DECL) {
        return new ZigVarDeclImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
