// This is a generated file. Not intended for manual editing.
package org.ziglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.ziglang.psi.impl.*;

public interface ZigLangTypes {

  IElementType ADDITION_EXPR = new ZigLangElementType("ADDITION_EXPR");
  IElementType ADDITION_OP = new ZigLangElementType("ADDITION_OP");
  IElementType ARRAY_TYPE_START = new ZigLangElementType("ARRAY_TYPE_START");
  IElementType ASM_CLOBBERS = new ZigLangElementType("ASM_CLOBBERS");
  IElementType ASM_EXPR = new ZigLangElementType("ASM_EXPR");
  IElementType ASM_INPUT = new ZigLangElementType("ASM_INPUT");
  IElementType ASM_INPUT_ITEM = new ZigLangElementType("ASM_INPUT_ITEM");
  IElementType ASM_INPUT_LIST = new ZigLangElementType("ASM_INPUT_LIST");
  IElementType ASM_OUTPUT = new ZigLangElementType("ASM_OUTPUT");
  IElementType ASM_OUTPUT_ITEM = new ZigLangElementType("ASM_OUTPUT_ITEM");
  IElementType ASM_OUTPUT_LIST = new ZigLangElementType("ASM_OUTPUT_LIST");
  IElementType ASSIGN_EXPR = new ZigLangElementType("ASSIGN_EXPR");
  IElementType ASSIGN_OP = new ZigLangElementType("ASSIGN_OP");
  IElementType BITWISE_EXPR = new ZigLangElementType("BITWISE_EXPR");
  IElementType BITWISE_OP = new ZigLangElementType("BITWISE_OP");
  IElementType BIT_SHIFT_EXPR = new ZigLangElementType("BIT_SHIFT_EXPR");
  IElementType BIT_SHIFT_OP = new ZigLangElementType("BIT_SHIFT_OP");
  IElementType BLOCK = new ZigLangElementType("BLOCK");
  IElementType BLOCK_EXPR = new ZigLangElementType("BLOCK_EXPR");
  IElementType BLOCK_EXPR_STATEMENT = new ZigLangElementType("BLOCK_EXPR_STATEMENT");
  IElementType BLOCK_LABEL = new ZigLangElementType("BLOCK_LABEL");
  IElementType BOOL_AND_EXPR = new ZigLangElementType("BOOL_AND_EXPR");
  IElementType BOOL_OR_EXPR = new ZigLangElementType("BOOL_OR_EXPR");
  IElementType BREAK_LABEL = new ZigLangElementType("BREAK_LABEL");
  IElementType BUILTINIDENTIFIER = new ZigLangElementType("BUILTINIDENTIFIER");
  IElementType BYTE_ALIGN = new ZigLangElementType("BYTE_ALIGN");
  IElementType CALL_CONV = new ZigLangElementType("CALL_CONV");
  IElementType COMPARE_EXPR = new ZigLangElementType("COMPARE_EXPR");
  IElementType COMPARE_OP = new ZigLangElementType("COMPARE_OP");
  IElementType CONTAINER_DECL = new ZigLangElementType("CONTAINER_DECL");
  IElementType CONTAINER_DECL_AUTO = new ZigLangElementType("CONTAINER_DECL_AUTO");
  IElementType CONTAINER_DECL_TYPE = new ZigLangElementType("CONTAINER_DECL_TYPE");
  IElementType CONTAINER_FIELD = new ZigLangElementType("CONTAINER_FIELD");
  IElementType CURLY_SUFFIX_EXPR = new ZigLangElementType("CURLY_SUFFIX_EXPR");
  IElementType ERROR_SET_DECL = new ZigLangElementType("ERROR_SET_DECL");
  IElementType ERROR_UNION_EXPR = new ZigLangElementType("ERROR_UNION_EXPR");
  IElementType EXPR = new ZigLangElementType("EXPR");
  IElementType EXPR_LIST = new ZigLangElementType("EXPR_LIST");
  IElementType FIELD_INIT = new ZigLangElementType("FIELD_INIT");
  IElementType FN_CALL_ARGUMENTS = new ZigLangElementType("FN_CALL_ARGUMENTS");
  IElementType FOR_EXPR = new ZigLangElementType("FOR_EXPR");
  IElementType FOR_PREFIX = new ZigLangElementType("FOR_PREFIX");
  IElementType FOR_STATEMENT = new ZigLangElementType("FOR_STATEMENT");
  IElementType IDENTIFIER_LIST = new ZigLangElementType("IDENTIFIER_LIST");
  IElementType IF_EXPR = new ZigLangElementType("IF_EXPR");
  IElementType IF_PREFIX = new ZigLangElementType("IF_PREFIX");
  IElementType IF_STATEMENT = new ZigLangElementType("IF_STATEMENT");
  IElementType INIT_LIST = new ZigLangElementType("INIT_LIST");
  IElementType LABELED_STATEMENT = new ZigLangElementType("LABELED_STATEMENT");
  IElementType LINK_SECTION = new ZigLangElementType("LINK_SECTION");
  IElementType LOOP_EXPR = new ZigLangElementType("LOOP_EXPR");
  IElementType LOOP_STATEMENT = new ZigLangElementType("LOOP_STATEMENT");
  IElementType MULTIPLY_EXPR = new ZigLangElementType("MULTIPLY_EXPR");
  IElementType MULTIPLY_OP = new ZigLangElementType("MULTIPLY_OP");
  IElementType PARAM_DECL = new ZigLangElementType("PARAM_DECL");
  IElementType PARAM_DECL_LIST = new ZigLangElementType("PARAM_DECL_LIST");
  IElementType PARAM_TYPE = new ZigLangElementType("PARAM_TYPE");
  IElementType PAYLOAD = new ZigLangElementType("PAYLOAD");
  IElementType PREFIX_EXPR = new ZigLangElementType("PREFIX_EXPR");
  IElementType PREFIX_OP = new ZigLangElementType("PREFIX_OP");
  IElementType PREFIX_TYPE_OP = new ZigLangElementType("PREFIX_TYPE_OP");
  IElementType PRIMARY_EXPR = new ZigLangElementType("PRIMARY_EXPR");
  IElementType PRIMARY_TYPE_EXPR = new ZigLangElementType("PRIMARY_TYPE_EXPR");
  IElementType PTR_INDEX_PAYLOAD = new ZigLangElementType("PTR_INDEX_PAYLOAD");
  IElementType PTR_PAYLOAD = new ZigLangElementType("PTR_PAYLOAD");
  IElementType PTR_TYPE_START = new ZigLangElementType("PTR_TYPE_START");
  IElementType SLICE_TYPE_START = new ZigLangElementType("SLICE_TYPE_START");
  IElementType STATEMENT = new ZigLangElementType("STATEMENT");
  IElementType STRINGLITERAL = new ZigLangElementType("STRINGLITERAL");
  IElementType STRING_LIST = new ZigLangElementType("STRING_LIST");
  IElementType SUFFIX_EXPR = new ZigLangElementType("SUFFIX_EXPR");
  IElementType SUFFIX_OP = new ZigLangElementType("SUFFIX_OP");
  IElementType SWITCH_CASE = new ZigLangElementType("SWITCH_CASE");
  IElementType SWITCH_EXPR = new ZigLangElementType("SWITCH_EXPR");
  IElementType SWITCH_ITEM = new ZigLangElementType("SWITCH_ITEM");
  IElementType SWITCH_PRONG = new ZigLangElementType("SWITCH_PRONG");
  IElementType SWITCH_PRONG_LIST = new ZigLangElementType("SWITCH_PRONG_LIST");
  IElementType TEST_DECL = new ZigLangElementType("TEST_DECL");
  IElementType TOP_LEVEL_COMPTIME = new ZigLangElementType("TOP_LEVEL_COMPTIME");
  IElementType TYPE_EXPR = new ZigLangElementType("TYPE_EXPR");
  IElementType VAR_DECL = new ZigLangElementType("VAR_DECL");
  IElementType WHILE_CONTINUE_EXPR = new ZigLangElementType("WHILE_CONTINUE_EXPR");
  IElementType WHILE_EXPR = new ZigLangElementType("WHILE_EXPR");
  IElementType WHILE_PREFIX = new ZigLangElementType("WHILE_PREFIX");
  IElementType WHILE_STATEMENT = new ZigLangElementType("WHILE_STATEMENT");

  IElementType ALIGN = new ZigLangTokenType("align");
  IElementType ALLOWZERO = new ZigLangTokenType("allowzero");
  IElementType AMPERSAND = new ZigLangTokenType("&");
  IElementType AMPERSANDEQUAL = new ZigLangTokenType("&=");
  IElementType AND = new ZigLangTokenType("and");
  IElementType ANYFRAME = new ZigLangTokenType("anyframe");
  IElementType ANY_TYPE = new ZigLangTokenType("anytype");
  IElementType ASM = new ZigLangTokenType("asm");
  IElementType ASTERISK = new ZigLangTokenType("*");
  IElementType ASTERISK2 = new ZigLangTokenType("**");
  IElementType ASTERISKEQUAL = new ZigLangTokenType("*=");
  IElementType ASTERISKPERCENT = new ZigLangTokenType("*%");
  IElementType ASTERISKPERCENTEQUAL = new ZigLangTokenType("*%=");
  IElementType ASYNC = new ZigLangTokenType("async");
  IElementType AWAIT = new ZigLangTokenType("AWAIT");
  IElementType BREAK = new ZigLangTokenType("break");
  IElementType CALLCONV = new ZigLangTokenType("callconv");
  IElementType CARET = new ZigLangTokenType("^");
  IElementType CARETEQUAL = new ZigLangTokenType("^=");
  IElementType CATCH = new ZigLangTokenType("catch");
  IElementType CHAR_LITERAL = new ZigLangTokenType("CHAR_LITERAL");
  IElementType COLON = new ZigLangTokenType(":");
  IElementType COMMA = new ZigLangTokenType(",");
  IElementType COMMENT = new ZigLangTokenType("COMMENT");
  IElementType COMPTIME = new ZigLangTokenType("comptime");
  IElementType CONST = new ZigLangTokenType("const");
  IElementType CONTAINER_DOC = new ZigLangTokenType("CONTAINER_DOC");
  IElementType CONTINUE = new ZigLangTokenType("continue");
  IElementType DEFER = new ZigLangTokenType("defer");
  IElementType DOT = new ZigLangTokenType(".");
  IElementType DOT2 = new ZigLangTokenType("..");
  IElementType DOT3 = new ZigLangTokenType("...");
  IElementType DOTASTERISK = new ZigLangTokenType(".*");
  IElementType DOTQUESTIONMARK = new ZigLangTokenType(".?");
  IElementType ELSE = new ZigLangTokenType("else");
  IElementType ENUM = new ZigLangTokenType("ENUM");
  IElementType EQUAL = new ZigLangTokenType("=");
  IElementType EQUALEQUAL = new ZigLangTokenType("==");
  IElementType EQUALRARROW = new ZigLangTokenType("=>");
  IElementType ERRDEFER = new ZigLangTokenType("errdefer");
  IElementType ERROR = new ZigLangTokenType("ERROR");
  IElementType EXCLAMATIONMARK = new ZigLangTokenType("!");
  IElementType EXCLAMATIONMARKEQUAL = new ZigLangTokenType("!=");
  IElementType EXPORT = new ZigLangTokenType("export");
  IElementType EXTERN = new ZigLangTokenType("extern");
  IElementType FN = new ZigLangTokenType("fn");
  IElementType FOR = new ZigLangTokenType("for");
  IElementType ID = new ZigLangTokenType("ID");
  IElementType IF = new ZigLangTokenType("if");
  IElementType INLINE = new ZigLangTokenType("inline");
  IElementType INTEGER = new ZigLangTokenType("INTEGER");
  IElementType LARROW = new ZigLangTokenType("<");
  IElementType LARROW2 = new ZigLangTokenType("<<");
  IElementType LARROW2EQUAL = new ZigLangTokenType("<<=");
  IElementType LARROWEQUAL = new ZigLangTokenType("<=");
  IElementType LBRACE = new ZigLangTokenType("{");
  IElementType LBRACKET = new ZigLangTokenType("[");
  IElementType LETTERC = new ZigLangTokenType("c");
  IElementType LINKSECTION = new ZigLangTokenType("linksection");
  IElementType LPAREN = new ZigLangTokenType("(");
  IElementType MINUS = new ZigLangTokenType("-");
  IElementType MINUSEQUAL = new ZigLangTokenType("-=");
  IElementType MINUSPERCENT = new ZigLangTokenType("-%");
  IElementType MINUSPERCENTEQUAL = new ZigLangTokenType("-%=");
  IElementType MINUSRARROW = new ZigLangTokenType("->");
  IElementType NOINLINE = new ZigLangTokenType("noinline");
  IElementType NOSUSPEND = new ZigLangTokenType("nosuspend");
  IElementType OPAQUE = new ZigLangTokenType("OPAQUE");
  IElementType OR = new ZigLangTokenType("or");
  IElementType ORELSE = new ZigLangTokenType("orelse");
  IElementType PACKED = new ZigLangTokenType("PACKED");
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
  IElementType QUESTIONMARK = new ZigLangTokenType("?");
  IElementType RARROW = new ZigLangTokenType(">");
  IElementType RARROW2 = new ZigLangTokenType(">>");
  IElementType RARROW2EQUAL = new ZigLangTokenType(">>=");
  IElementType RARROWEQUAL = new ZigLangTokenType(">=");
  IElementType RBRACE = new ZigLangTokenType("}");
  IElementType RBRACKET = new ZigLangTokenType("]");
  IElementType RESUME = new ZigLangTokenType("resume");
  IElementType RETURN = new ZigLangTokenType("return");
  IElementType RPAREN = new ZigLangTokenType(")");
  IElementType SEMICOLON = new ZigLangTokenType(";");
  IElementType SLASH = new ZigLangTokenType("/");
  IElementType SLASHEQUAL = new ZigLangTokenType("/=");
  IElementType STRINGLITERALSINGLE = new ZigLangTokenType("STRINGLITERALSINGLE");
  IElementType STRUCT = new ZigLangTokenType("STRUCT");
  IElementType SUSPEND = new ZigLangTokenType("suspend");
  IElementType SWITCH = new ZigLangTokenType("switch");
  IElementType TEST = new ZigLangTokenType("test");
  IElementType THREAD_LOCAL = new ZigLangTokenType("threadlocal");
  IElementType TILDE = new ZigLangTokenType("~");
  IElementType TRY = new ZigLangTokenType("try");
  IElementType UNION = new ZigLangTokenType("UNION");
  IElementType USING_NAME_SPACE = new ZigLangTokenType("usingnamespace");
  IElementType VAR = new ZigLangTokenType("var");
  IElementType VOLATILE = new ZigLangTokenType("volatile");
  IElementType WHILE = new ZigLangTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITION_EXPR) {
        return new ZigAdditionExprImpl(node);
      }
      else if (type == ADDITION_OP) {
        return new ZigAdditionOpImpl(node);
      }
      else if (type == ARRAY_TYPE_START) {
        return new ZigArrayTypeStartImpl(node);
      }
      else if (type == ASM_CLOBBERS) {
        return new ZigAsmClobbersImpl(node);
      }
      else if (type == ASM_EXPR) {
        return new ZigAsmExprImpl(node);
      }
      else if (type == ASM_INPUT) {
        return new ZigAsmInputImpl(node);
      }
      else if (type == ASM_INPUT_ITEM) {
        return new ZigAsmInputItemImpl(node);
      }
      else if (type == ASM_INPUT_LIST) {
        return new ZigAsmInputListImpl(node);
      }
      else if (type == ASM_OUTPUT) {
        return new ZigAsmOutputImpl(node);
      }
      else if (type == ASM_OUTPUT_ITEM) {
        return new ZigAsmOutputItemImpl(node);
      }
      else if (type == ASM_OUTPUT_LIST) {
        return new ZigAsmOutputListImpl(node);
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
      else if (type == BLOCK_EXPR) {
        return new ZigBlockExprImpl(node);
      }
      else if (type == BLOCK_EXPR_STATEMENT) {
        return new ZigBlockExprStatementImpl(node);
      }
      else if (type == BLOCK_LABEL) {
        return new ZigBlockLabelImpl(node);
      }
      else if (type == BOOL_AND_EXPR) {
        return new ZigBoolAndExprImpl(node);
      }
      else if (type == BOOL_OR_EXPR) {
        return new ZigBoolOrExprImpl(node);
      }
      else if (type == BREAK_LABEL) {
        return new ZigBreakLabelImpl(node);
      }
      else if (type == BUILTINIDENTIFIER) {
        return new ZigBuiltinidentifierImpl(node);
      }
      else if (type == BYTE_ALIGN) {
        return new ZigByteAlignImpl(node);
      }
      else if (type == CALL_CONV) {
        return new ZigCallConvImpl(node);
      }
      else if (type == COMPARE_EXPR) {
        return new ZigCompareExprImpl(node);
      }
      else if (type == COMPARE_OP) {
        return new ZigCompareOpImpl(node);
      }
      else if (type == CONTAINER_DECL) {
        return new ZigContainerDeclImpl(node);
      }
      else if (type == CONTAINER_DECL_AUTO) {
        return new ZigContainerDeclAutoImpl(node);
      }
      else if (type == CONTAINER_DECL_TYPE) {
        return new ZigContainerDeclTypeImpl(node);
      }
      else if (type == CONTAINER_FIELD) {
        return new ZigContainerFieldImpl(node);
      }
      else if (type == CURLY_SUFFIX_EXPR) {
        return new ZigCurlySuffixExprImpl(node);
      }
      else if (type == ERROR_SET_DECL) {
        return new ZigErrorSetDeclImpl(node);
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
      else if (type == FIELD_INIT) {
        return new ZigFieldInitImpl(node);
      }
      else if (type == FN_CALL_ARGUMENTS) {
        return new ZigFnCallArgumentsImpl(node);
      }
      else if (type == FOR_EXPR) {
        return new ZigForExprImpl(node);
      }
      else if (type == FOR_PREFIX) {
        return new ZigForPrefixImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ZigForStatementImpl(node);
      }
      else if (type == IDENTIFIER_LIST) {
        return new ZigIdentifierListImpl(node);
      }
      else if (type == IF_EXPR) {
        return new ZigIfExprImpl(node);
      }
      else if (type == IF_PREFIX) {
        return new ZigIfPrefixImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new ZigIfStatementImpl(node);
      }
      else if (type == INIT_LIST) {
        return new ZigInitListImpl(node);
      }
      else if (type == LABELED_STATEMENT) {
        return new ZigLabeledStatementImpl(node);
      }
      else if (type == LINK_SECTION) {
        return new ZigLinkSectionImpl(node);
      }
      else if (type == LOOP_EXPR) {
        return new ZigLoopExprImpl(node);
      }
      else if (type == LOOP_STATEMENT) {
        return new ZigLoopStatementImpl(node);
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
      else if (type == PREFIX_TYPE_OP) {
        return new ZigPrefixTypeOpImpl(node);
      }
      else if (type == PRIMARY_EXPR) {
        return new ZigPrimaryExprImpl(node);
      }
      else if (type == PRIMARY_TYPE_EXPR) {
        return new ZigPrimaryTypeExprImpl(node);
      }
      else if (type == PTR_INDEX_PAYLOAD) {
        return new ZigPtrIndexPayloadImpl(node);
      }
      else if (type == PTR_PAYLOAD) {
        return new ZigPtrPayloadImpl(node);
      }
      else if (type == PTR_TYPE_START) {
        return new ZigPtrTypeStartImpl(node);
      }
      else if (type == SLICE_TYPE_START) {
        return new ZigSliceTypeStartImpl(node);
      }
      else if (type == STATEMENT) {
        return new ZigStatementImpl(node);
      }
      else if (type == STRINGLITERAL) {
        return new ZigStringliteralImpl(node);
      }
      else if (type == STRING_LIST) {
        return new ZigStringListImpl(node);
      }
      else if (type == SUFFIX_EXPR) {
        return new ZigSuffixExprImpl(node);
      }
      else if (type == SUFFIX_OP) {
        return new ZigSuffixOpImpl(node);
      }
      else if (type == SWITCH_CASE) {
        return new ZigSwitchCaseImpl(node);
      }
      else if (type == SWITCH_EXPR) {
        return new ZigSwitchExprImpl(node);
      }
      else if (type == SWITCH_ITEM) {
        return new ZigSwitchItemImpl(node);
      }
      else if (type == SWITCH_PRONG) {
        return new ZigSwitchProngImpl(node);
      }
      else if (type == SWITCH_PRONG_LIST) {
        return new ZigSwitchProngListImpl(node);
      }
      else if (type == TEST_DECL) {
        return new ZigTestDeclImpl(node);
      }
      else if (type == TOP_LEVEL_COMPTIME) {
        return new ZigTopLevelComptimeImpl(node);
      }
      else if (type == TYPE_EXPR) {
        return new ZigTypeExprImpl(node);
      }
      else if (type == VAR_DECL) {
        return new ZigVarDeclImpl(node);
      }
      else if (type == WHILE_CONTINUE_EXPR) {
        return new ZigWhileContinueExprImpl(node);
      }
      else if (type == WHILE_EXPR) {
        return new ZigWhileExprImpl(node);
      }
      else if (type == WHILE_PREFIX) {
        return new ZigWhilePrefixImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ZigWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
