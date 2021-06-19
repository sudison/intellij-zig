// This is a generated file. Not intended for manual editing.
package org.ziglang.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.ziglang.psi.ZigLangTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ZigLangParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // MultiplyExpr (AdditionOp MultiplyExpr)*
  public static boolean AdditionExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditionExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITION_EXPR, "<addition expr>");
    r = MultiplyExpr(b, l + 1);
    r = r && AdditionExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AdditionOp MultiplyExpr)*
  private static boolean AdditionExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditionExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AdditionExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AdditionExpr_1", c)) break;
    }
    return true;
  }

  // AdditionOp MultiplyExpr
  private static boolean AdditionExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditionExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AdditionOp(b, l + 1);
    r = r && MultiplyExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | PLUS2 | PLUSPERCENT | MINUSPERCENT
  public static boolean AdditionOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditionOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITION_OP, "<addition op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, PLUS2);
    if (!r) r = consumeToken(b, PLUSPERCENT);
    if (!r) r = consumeToken(b, MINUSPERCENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET Expr (COLON Expr)? RBRACKET
  public static boolean ArrayTypeStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayTypeStart")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && Expr(b, l + 1);
    r = r && ArrayTypeStart_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, ARRAY_TYPE_START, r);
    return r;
  }

  // (COLON Expr)?
  private static boolean ArrayTypeStart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayTypeStart_2")) return false;
    ArrayTypeStart_2_0(b, l + 1);
    return true;
  }

  // COLON Expr
  private static boolean ArrayTypeStart_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayTypeStart_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON StringList
  public static boolean AsmClobbers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmClobbers")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && StringList(b, l + 1);
    exit_section_(b, m, ASM_CLOBBERS, r);
    return r;
  }

  /* ********************************************************** */
  // ASM VOLATILE? LPAREN Expr AsmOutput? RPAREN
  public static boolean AsmExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmExpr")) return false;
    if (!nextTokenIs(b, ASM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASM);
    r = r && AsmExpr_1(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && AsmExpr_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ASM_EXPR, r);
    return r;
  }

  // VOLATILE?
  private static boolean AsmExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmExpr_1")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  // AsmOutput?
  private static boolean AsmExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmExpr_4")) return false;
    AsmOutput(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON AsmInputList AsmClobbers?
  public static boolean AsmInput(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmInput")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && AsmInputList(b, l + 1);
    r = r && AsmInput_2(b, l + 1);
    exit_section_(b, m, ASM_INPUT, r);
    return r;
  }

  // AsmClobbers?
  private static boolean AsmInput_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmInput_2")) return false;
    AsmClobbers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACKET ID RBRACKET STRINGLITERAL LPAREN Expr RPAREN
  public static boolean AsmInputItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmInputItem")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, ID, RBRACKET);
    r = r && STRINGLITERAL(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ASM_INPUT_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // (AsmInputItem COMMA)* AsmInputItem
  public static boolean AsmInputList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmInputList")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AsmInputList_0(b, l + 1);
    r = r && AsmInputItem(b, l + 1);
    exit_section_(b, m, ASM_INPUT_LIST, r);
    return r;
  }

  // (AsmInputItem COMMA)*
  private static boolean AsmInputList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmInputList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AsmInputList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AsmInputList_0", c)) break;
    }
    return true;
  }

  // AsmInputItem COMMA
  private static boolean AsmInputList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmInputList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AsmInputItem(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON AsmOutputList AsmInput?
  public static boolean AsmOutput(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutput")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && AsmOutputList(b, l + 1);
    r = r && AsmOutput_2(b, l + 1);
    exit_section_(b, m, ASM_OUTPUT, r);
    return r;
  }

  // AsmInput?
  private static boolean AsmOutput_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutput_2")) return false;
    AsmInput(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACKET ID RBRACKET STRINGLITERAL LPAREN (MINUSRARROW TypeExpr | ID) RPAREN
  public static boolean AsmOutputItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputItem")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, ID, RBRACKET);
    r = r && STRINGLITERAL(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && AsmOutputItem_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ASM_OUTPUT_ITEM, r);
    return r;
  }

  // MINUSRARROW TypeExpr | ID
  private static boolean AsmOutputItem_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputItem_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AsmOutputItem_5_0(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUSRARROW TypeExpr
  private static boolean AsmOutputItem_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputItem_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINUSRARROW);
    r = r && TypeExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (AsmOutputItem COMMA)* AsmOutputItem?
  public static boolean AsmOutputList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASM_OUTPUT_LIST, "<asm output list>");
    r = AsmOutputList_0(b, l + 1);
    r = r && AsmOutputList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AsmOutputItem COMMA)*
  private static boolean AsmOutputList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AsmOutputList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AsmOutputList_0", c)) break;
    }
    return true;
  }

  // AsmOutputItem COMMA
  private static boolean AsmOutputList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AsmOutputItem(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // AsmOutputItem?
  private static boolean AsmOutputList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmOutputList_1")) return false;
    AsmOutputItem(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expr (AssignOp Expr)?
  public static boolean AssignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_EXPR, "<assign expr>");
    r = Expr(b, l + 1);
    r = r && AssignExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AssignOp Expr)?
  private static boolean AssignExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr_1")) return false;
    AssignExpr_1_0(b, l + 1);
    return true;
  }

  // AssignOp Expr
  private static boolean AssignExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignOp(b, l + 1);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASTERISKEQUAL
  //      | SLASHEQUAL
  //      | PERCENTEQUAL
  //      | PLUSEQUAL
  //      | MINUSEQUAL
  //      | LARROW2EQUAL
  //      | RARROW2EQUAL
  //      | AMPERSANDEQUAL
  //      | CARETEQUAL
  //      | PIPEEQUAL
  //      | ASTERISKPERCENTEQUAL
  //      | PLUSPERCENTEQUAL
  //      | MINUSPERCENTEQUAL
  //      | EQUAL
  public static boolean AssignOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_OP, "<assign op>");
    r = consumeToken(b, ASTERISKEQUAL);
    if (!r) r = consumeToken(b, SLASHEQUAL);
    if (!r) r = consumeToken(b, PERCENTEQUAL);
    if (!r) r = consumeToken(b, PLUSEQUAL);
    if (!r) r = consumeToken(b, MINUSEQUAL);
    if (!r) r = consumeToken(b, LARROW2EQUAL);
    if (!r) r = consumeToken(b, RARROW2EQUAL);
    if (!r) r = consumeToken(b, AMPERSANDEQUAL);
    if (!r) r = consumeToken(b, CARETEQUAL);
    if (!r) r = consumeToken(b, PIPEEQUAL);
    if (!r) r = consumeToken(b, ASTERISKPERCENTEQUAL);
    if (!r) r = consumeToken(b, PLUSPERCENTEQUAL);
    if (!r) r = consumeToken(b, MINUSPERCENTEQUAL);
    if (!r) r = consumeToken(b, EQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '@' ID
  public static boolean BUILTINIDENTIFIER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BUILTINIDENTIFIER")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTINIDENTIFIER, "<builtinidentifier>");
    r = consumeToken(b, "@");
    r = r && consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AdditionExpr (BitShiftOp AdditionExpr)*
  public static boolean BitShiftExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitShiftExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_SHIFT_EXPR, "<bit shift expr>");
    r = AdditionExpr(b, l + 1);
    r = r && BitShiftExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BitShiftOp AdditionExpr)*
  private static boolean BitShiftExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitShiftExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!BitShiftExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BitShiftExpr_1", c)) break;
    }
    return true;
  }

  // BitShiftOp AdditionExpr
  private static boolean BitShiftExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitShiftExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BitShiftOp(b, l + 1);
    r = r && AdditionExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LARROW2 | RARROW2
  public static boolean BitShiftOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitShiftOp")) return false;
    if (!nextTokenIs(b, "<bit shift op>", LARROW2, RARROW2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_SHIFT_OP, "<bit shift op>");
    r = consumeToken(b, LARROW2);
    if (!r) r = consumeToken(b, RARROW2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BitShiftExpr (BitwiseOp BitShiftExpr)*
  public static boolean BitwiseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITWISE_EXPR, "<bitwise expr>");
    r = BitShiftExpr(b, l + 1);
    r = r && BitwiseExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BitwiseOp BitShiftExpr)*
  private static boolean BitwiseExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!BitwiseExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BitwiseExpr_1", c)) break;
    }
    return true;
  }

  // BitwiseOp BitShiftExpr
  private static boolean BitwiseExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BitwiseOp(b, l + 1);
    r = r && BitShiftExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AMPERSAND | CARET | PIPE | orelse | catch Payload?
  public static boolean BitwiseOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITWISE_OP, "<bitwise op>");
    r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, ORELSE);
    if (!r) r = BitwiseOp_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // catch Payload?
  private static boolean BitwiseOp_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseOp_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH);
    r = r && BitwiseOp_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean BitwiseOp_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BitwiseOp_4_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACE Statement* RBRACE
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && Block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // Statement*
  private static boolean Block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BlockLabel? Block
  public static boolean BlockExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockExpr")) return false;
    if (!nextTokenIs(b, "<block expr>", ID, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_EXPR, "<block expr>");
    r = BlockExpr_0(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BlockLabel?
  private static boolean BlockExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockExpr_0")) return false;
    BlockLabel(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BlockExpr | AssignExpr SEMICOLON
  public static boolean BlockExprStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockExprStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_EXPR_STATEMENT, "<block expr statement>");
    r = BlockExpr(b, l + 1);
    if (!r) r = BlockExprStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AssignExpr SEMICOLON
  private static boolean BlockExprStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockExprStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID COLON
  public static boolean BlockLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockLabel")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, COLON);
    exit_section_(b, m, BLOCK_LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // CompareExpr (AND CompareExpr)*
  public static boolean BoolAndExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolAndExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_AND_EXPR, "<bool and expr>");
    r = CompareExpr(b, l + 1);
    r = r && BoolAndExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AND CompareExpr)*
  private static boolean BoolAndExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolAndExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!BoolAndExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BoolAndExpr_1", c)) break;
    }
    return true;
  }

  // AND CompareExpr
  private static boolean BoolAndExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolAndExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && CompareExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BoolAndExpr (OR BoolAndExpr)*
  public static boolean BoolOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolOrExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_OR_EXPR, "<bool or expr>");
    r = BoolAndExpr(b, l + 1);
    r = r && BoolOrExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OR BoolAndExpr)*
  private static boolean BoolOrExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolOrExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!BoolOrExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BoolOrExpr_1", c)) break;
    }
    return true;
  }

  // OR BoolAndExpr
  private static boolean BoolOrExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolOrExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && BoolAndExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON ID
  public static boolean BreakLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakLabel")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, ID);
    exit_section_(b, m, BREAK_LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // ALIGN LPAREN Expr RPAREN
  public static boolean ByteAlign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ByteAlign")) return false;
    if (!nextTokenIs(b, ALIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, BYTE_ALIGN, r);
    return r;
  }

  /* ********************************************************** */
  // CALLCONV LPAREN Expr RPAREN
  public static boolean CallConv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallConv")) return false;
    if (!nextTokenIs(b, CALLCONV)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CALLCONV, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CALL_CONV, r);
    return r;
  }

  /* ********************************************************** */
  // BitwiseExpr (CompareOp BitwiseExpr)?
  public static boolean CompareExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARE_EXPR, "<compare expr>");
    r = BitwiseExpr(b, l + 1);
    r = r && CompareExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (CompareOp BitwiseExpr)?
  private static boolean CompareExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareExpr_1")) return false;
    CompareExpr_1_0(b, l + 1);
    return true;
  }

  // CompareOp BitwiseExpr
  private static boolean CompareExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CompareOp(b, l + 1);
    r = r && BitwiseExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQUALEQUAL | EXCLAMATIONMARKEQUAL |LARROW |RARROW|LARROWEQUAL|RARROWEQUAL
  public static boolean CompareOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARE_OP, "<compare op>");
    r = consumeToken(b, EQUALEQUAL);
    if (!r) r = consumeToken(b, EXCLAMATIONMARKEQUAL);
    if (!r) r = consumeToken(b, LARROW);
    if (!r) r = consumeToken(b, RARROW);
    if (!r) r = consumeToken(b, LARROWEQUAL);
    if (!r) r = consumeToken(b, RARROWEQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (EXTERN | PACKED)? ContainerDeclAuto
  public static boolean ContainerDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_DECL, "<container decl>");
    r = ContainerDecl_0(b, l + 1);
    r = r && ContainerDeclAuto(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EXTERN | PACKED)?
  private static boolean ContainerDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDecl_0")) return false;
    ContainerDecl_0_0(b, l + 1);
    return true;
  }

  // EXTERN | PACKED
  private static boolean ContainerDecl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDecl_0_0")) return false;
    boolean r;
    r = consumeToken(b, EXTERN);
    if (!r) r = consumeToken(b, PACKED);
    return r;
  }

  /* ********************************************************** */
  // ContainerDeclType LBRACE container_doc_comment? ContainerMembers RBRACE
  public static boolean ContainerDeclAuto(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclAuto")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_DECL_AUTO, "<container decl auto>");
    r = ContainerDeclType(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && ContainerDeclAuto_2(b, l + 1);
    r = r && ContainerMembers(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // container_doc_comment?
  private static boolean ContainerDeclAuto_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclAuto_2")) return false;
    container_doc_comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRUCT
  //     | OPAQUE
  //     | ENUM (LPAREN Expr RPAREN)?
  //     | UNION (LPAREN (ENUM (LPAREN Expr RPAREN)? | Expr) RPAREN)?
  public static boolean ContainerDeclType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_DECL_TYPE, "<container decl type>");
    r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, OPAQUE);
    if (!r) r = ContainerDeclType_2(b, l + 1);
    if (!r) r = ContainerDeclType_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ENUM (LPAREN Expr RPAREN)?
  private static boolean ContainerDeclType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    r = r && ContainerDeclType_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LPAREN Expr RPAREN)?
  private static boolean ContainerDeclType_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_2_1")) return false;
    ContainerDeclType_2_1_0(b, l + 1);
    return true;
  }

  // LPAREN Expr RPAREN
  private static boolean ContainerDeclType_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // UNION (LPAREN (ENUM (LPAREN Expr RPAREN)? | Expr) RPAREN)?
  private static boolean ContainerDeclType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNION);
    r = r && ContainerDeclType_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LPAREN (ENUM (LPAREN Expr RPAREN)? | Expr) RPAREN)?
  private static boolean ContainerDeclType_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3_1")) return false;
    ContainerDeclType_3_1_0(b, l + 1);
    return true;
  }

  // LPAREN (ENUM (LPAREN Expr RPAREN)? | Expr) RPAREN
  private static boolean ContainerDeclType_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ContainerDeclType_3_1_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ENUM (LPAREN Expr RPAREN)? | Expr
  private static boolean ContainerDeclType_3_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerDeclType_3_1_0_1_0(b, l + 1);
    if (!r) r = Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ENUM (LPAREN Expr RPAREN)?
  private static boolean ContainerDeclType_3_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    r = r && ContainerDeclType_3_1_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LPAREN Expr RPAREN)?
  private static boolean ContainerDeclType_3_1_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3_1_0_1_0_1")) return false;
    ContainerDeclType_3_1_0_1_0_1_0(b, l + 1);
    return true;
  }

  // LPAREN Expr RPAREN
  private static boolean ContainerDeclType_3_1_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclType_3_1_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TestDecl ContainerDeclarations?
  //     | TopLevelComptime ContainerDeclarations?
  //     | DocComment? PUB? TopLevelDecl ContainerDeclarations?
  static boolean ContainerDeclarations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerDeclarations_0(b, l + 1);
    if (!r) r = ContainerDeclarations_1(b, l + 1);
    if (!r) r = ContainerDeclarations_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TestDecl ContainerDeclarations?
  private static boolean ContainerDeclarations_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TestDecl(b, l + 1);
    r = r && ContainerDeclarations_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ContainerDeclarations?
  private static boolean ContainerDeclarations_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_0_1")) return false;
    ContainerDeclarations(b, l + 1);
    return true;
  }

  // TopLevelComptime ContainerDeclarations?
  private static boolean ContainerDeclarations_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TopLevelComptime(b, l + 1);
    r = r && ContainerDeclarations_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ContainerDeclarations?
  private static boolean ContainerDeclarations_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_1_1")) return false;
    ContainerDeclarations(b, l + 1);
    return true;
  }

  // DocComment? PUB? TopLevelDecl ContainerDeclarations?
  private static boolean ContainerDeclarations_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerDeclarations_2_0(b, l + 1);
    r = r && ContainerDeclarations_2_1(b, l + 1);
    r = r && TopLevelDecl(b, l + 1);
    r = r && ContainerDeclarations_2_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DocComment?
  private static boolean ContainerDeclarations_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_2_0")) return false;
    DocComment(b, l + 1);
    return true;
  }

  // PUB?
  private static boolean ContainerDeclarations_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_2_1")) return false;
    consumeToken(b, PUB);
    return true;
  }

  // ContainerDeclarations?
  private static boolean ContainerDeclarations_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_2_3")) return false;
    ContainerDeclarations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DocComment? COMPTIME? ID (COLON (ANY_TYPE|TypeExpr) ByteAlign?)? (EQUAL Expr)?
  public static boolean ContainerField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_FIELD, "<container field>");
    r = ContainerField_0(b, l + 1);
    r = r && ContainerField_1(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && ContainerField_3(b, l + 1);
    r = r && ContainerField_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DocComment?
  private static boolean ContainerField_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_0")) return false;
    DocComment(b, l + 1);
    return true;
  }

  // COMPTIME?
  private static boolean ContainerField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_1")) return false;
    consumeToken(b, COMPTIME);
    return true;
  }

  // (COLON (ANY_TYPE|TypeExpr) ByteAlign?)?
  private static boolean ContainerField_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_3")) return false;
    ContainerField_3_0(b, l + 1);
    return true;
  }

  // COLON (ANY_TYPE|TypeExpr) ByteAlign?
  private static boolean ContainerField_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && ContainerField_3_0_1(b, l + 1);
    r = r && ContainerField_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ANY_TYPE|TypeExpr
  private static boolean ContainerField_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_3_0_1")) return false;
    boolean r;
    r = consumeToken(b, ANY_TYPE);
    if (!r) r = TypeExpr(b, l + 1);
    return r;
  }

  // ByteAlign?
  private static boolean ContainerField_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_3_0_2")) return false;
    ByteAlign(b, l + 1);
    return true;
  }

  // (EQUAL Expr)?
  private static boolean ContainerField_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_4")) return false;
    ContainerField_4_0(b, l + 1);
    return true;
  }

  // EQUAL Expr
  private static boolean ContainerField_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerField_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ContainerDeclarations? (ContainerField COMMA)* (ContainerField | ContainerDeclarations?)
  static boolean ContainerMembers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerMembers_0(b, l + 1);
    r = r && ContainerMembers_1(b, l + 1);
    r = r && ContainerMembers_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ContainerDeclarations?
  private static boolean ContainerMembers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers_0")) return false;
    ContainerDeclarations(b, l + 1);
    return true;
  }

  // (ContainerField COMMA)*
  private static boolean ContainerMembers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ContainerMembers_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ContainerMembers_1", c)) break;
    }
    return true;
  }

  // ContainerField COMMA
  private static boolean ContainerMembers_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerField(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ContainerField | ContainerDeclarations?
  private static boolean ContainerMembers_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerField(b, l + 1);
    if (!r) r = ContainerMembers_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ContainerDeclarations?
  private static boolean ContainerMembers_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers_2_1")) return false;
    ContainerDeclarations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeExpr InitList?
  public static boolean CurlySuffixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CurlySuffixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CURLY_SUFFIX_EXPR, "<curly suffix expr>");
    r = TypeExpr(b, l + 1);
    r = r && CurlySuffixExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // InitList?
  private static boolean CurlySuffixExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CurlySuffixExpr_1")) return false;
    InitList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COMMENT+
  static boolean DocComment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DocComment")) return false;
    if (!nextTokenIs(b, COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMENT)) break;
      if (!empty_element_parsed_guard_(b, "DocComment", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SuffixExpr | (EXCLAMATIONMARK TypeExpr)?
  public static boolean ErrorUnionExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErrorUnionExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ERROR_UNION_EXPR, "<error union expr>");
    r = SuffixExpr(b, l + 1);
    if (!r) r = ErrorUnionExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (EXCLAMATIONMARK TypeExpr)?
  private static boolean ErrorUnionExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErrorUnionExpr_1")) return false;
    ErrorUnionExpr_1_0(b, l + 1);
    return true;
  }

  // EXCLAMATIONMARK TypeExpr
  private static boolean ErrorUnionExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErrorUnionExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXCLAMATIONMARK);
    r = r && TypeExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BoolOrExpr
  public static boolean Expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = BoolOrExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (Expr COMMA)* Expr?
  public static boolean ExprList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_LIST, "<expr list>");
    r = ExprList_0(b, l + 1);
    r = r && ExprList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Expr COMMA)*
  private static boolean ExprList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExprList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExprList_0", c)) break;
    }
    return true;
  }

  // Expr COMMA
  private static boolean ExprList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expr(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expr?
  private static boolean ExprList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprList_1")) return false;
    Expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DOT ID EQUAL Expr
  public static boolean FieldInit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInit")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID, EQUAL);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, FIELD_INIT, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN ExprList RPAREN
  public static boolean FnCallArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnCallArguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && ExprList(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FN_CALL_ARGUMENTS, r);
    return r;
  }

  /* ********************************************************** */
  // FN ID? LPAREN ParamDeclList RPAREN ByteAlign? LinkSection? CallConv? EXCLAMATIONMARK?  TypeExpr
  static boolean FnProto(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto")) return false;
    if (!nextTokenIs(b, FN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN);
    r = r && FnProto_1(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && ParamDeclList(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && FnProto_5(b, l + 1);
    r = r && FnProto_6(b, l + 1);
    r = r && FnProto_7(b, l + 1);
    r = r && FnProto_8(b, l + 1);
    r = r && TypeExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ID?
  private static boolean FnProto_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto_1")) return false;
    consumeToken(b, ID);
    return true;
  }

  // ByteAlign?
  private static boolean FnProto_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto_5")) return false;
    ByteAlign(b, l + 1);
    return true;
  }

  // LinkSection?
  private static boolean FnProto_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto_6")) return false;
    LinkSection(b, l + 1);
    return true;
  }

  // CallConv?
  private static boolean FnProto_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto_7")) return false;
    CallConv(b, l + 1);
    return true;
  }

  // EXCLAMATIONMARK?
  private static boolean FnProto_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto_8")) return false;
    consumeToken(b, EXCLAMATIONMARK);
    return true;
  }

  /* ********************************************************** */
  // ForPrefix Expr (ELSE Expr)?
  public static boolean ForExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForExpr")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForPrefix(b, l + 1);
    r = r && Expr(b, l + 1);
    r = r && ForExpr_2(b, l + 1);
    exit_section_(b, m, FOR_EXPR, r);
    return r;
  }

  // (ELSE Expr)?
  private static boolean ForExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForExpr_2")) return false;
    ForExpr_2_0(b, l + 1);
    return true;
  }

  // ELSE Expr
  private static boolean ForExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR LPAREN Expr RPAREN PtrIndexPayload
  public static boolean ForPrefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForPrefix")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && PtrIndexPayload(b, l + 1);
    exit_section_(b, m, FOR_PREFIX, r);
    return r;
  }

  /* ********************************************************** */
  // ForPrefix BlockExpr (ELSE Statement)?
  //     | ForPrefix AssignExpr (SEMICOLON | ELSE Statement)
  public static boolean ForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForStatement_0(b, l + 1);
    if (!r) r = ForStatement_1(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // ForPrefix BlockExpr (ELSE Statement)?
  private static boolean ForStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForPrefix(b, l + 1);
    r = r && BlockExpr(b, l + 1);
    r = r && ForStatement_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE Statement)?
  private static boolean ForStatement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_0_2")) return false;
    ForStatement_0_2_0(b, l + 1);
    return true;
  }

  // ELSE Statement
  private static boolean ForStatement_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ForPrefix AssignExpr (SEMICOLON | ELSE Statement)
  private static boolean ForStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForPrefix(b, l + 1);
    r = r && AssignExpr(b, l + 1);
    r = r && ForStatement_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON | ELSE Statement
  private static boolean ForStatement_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = ForStatement_1_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE Statement
  private static boolean ForStatement_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_1_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IfPrefix Expr (ELSE Payload? Expr)?
  public static boolean IfExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfPrefix(b, l + 1);
    r = r && Expr(b, l + 1);
    r = r && IfExpr_2(b, l + 1);
    exit_section_(b, m, IF_EXPR, r);
    return r;
  }

  // (ELSE Payload? Expr)?
  private static boolean IfExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr_2")) return false;
    IfExpr_2_0(b, l + 1);
    return true;
  }

  // ELSE Payload? Expr
  private static boolean IfExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && IfExpr_2_0_1(b, l + 1);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean IfExpr_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr_2_0_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IF LPAREN Expr RPAREN PtrPayload?
  public static boolean IfPrefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfPrefix")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && IfPrefix_4(b, l + 1);
    exit_section_(b, m, IF_PREFIX, r);
    return r;
  }

  // PtrPayload?
  private static boolean IfPrefix_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfPrefix_4")) return false;
    PtrPayload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IfPrefix BlockExpr (ELSE Payload? Statement)?
  //     | IfPrefix AssignExpr (SEMICOLON | ELSE Payload? Statement)
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfStatement_0(b, l + 1);
    if (!r) r = IfStatement_1(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // IfPrefix BlockExpr (ELSE Payload? Statement)?
  private static boolean IfStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfPrefix(b, l + 1);
    r = r && BlockExpr(b, l + 1);
    r = r && IfStatement_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE Payload? Statement)?
  private static boolean IfStatement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_0_2")) return false;
    IfStatement_0_2_0(b, l + 1);
    return true;
  }

  // ELSE Payload? Statement
  private static boolean IfStatement_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && IfStatement_0_2_0_1(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean IfStatement_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_0_2_0_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  // IfPrefix AssignExpr (SEMICOLON | ELSE Payload? Statement)
  private static boolean IfStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfPrefix(b, l + 1);
    r = r && AssignExpr(b, l + 1);
    r = r && IfStatement_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON | ELSE Payload? Statement
  private static boolean IfStatement_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = IfStatement_1_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE Payload? Statement
  private static boolean IfStatement_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_1_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && IfStatement_1_2_1_1(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean IfStatement_1_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_1_2_1_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LBRACE FieldInit (COMMA FieldInit)* COMMA? RBRACE
  //     | LBRACE Expr (COMMA Expr)* COMMA? RBRACE
  //     | LBRACE RBRACE
  public static boolean InitList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = InitList_0(b, l + 1);
    if (!r) r = InitList_1(b, l + 1);
    if (!r) r = parseTokens(b, 0, LBRACE, RBRACE);
    exit_section_(b, m, INIT_LIST, r);
    return r;
  }

  // LBRACE FieldInit (COMMA FieldInit)* COMMA? RBRACE
  private static boolean InitList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && FieldInit(b, l + 1);
    r = r && InitList_0_2(b, l + 1);
    r = r && InitList_0_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA FieldInit)*
  private static boolean InitList_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InitList_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InitList_0_2", c)) break;
    }
    return true;
  }

  // COMMA FieldInit
  private static boolean InitList_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FieldInit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean InitList_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_0_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // LBRACE Expr (COMMA Expr)* COMMA? RBRACE
  private static boolean InitList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && Expr(b, l + 1);
    r = r && InitList_1_2(b, l + 1);
    r = r && InitList_1_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Expr)*
  private static boolean InitList_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InitList_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InitList_1_2", c)) break;
    }
    return true;
  }

  // COMMA Expr
  private static boolean InitList_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean InitList_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InitList_1_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // BlockLabel? (Block | LoopStatement)
  public static boolean LabeledStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabeledStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LABELED_STATEMENT, "<labeled statement>");
    r = LabeledStatement_0(b, l + 1);
    r = r && LabeledStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BlockLabel?
  private static boolean LabeledStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabeledStatement_0")) return false;
    BlockLabel(b, l + 1);
    return true;
  }

  // Block | LoopStatement
  private static boolean LabeledStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabeledStatement_1")) return false;
    boolean r;
    r = Block(b, l + 1);
    if (!r) r = LoopStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LINKSECTION LPAREN Expr RPAREN
  public static boolean LinkSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LinkSection")) return false;
    if (!nextTokenIs(b, LINKSECTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINKSECTION, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, LINK_SECTION, r);
    return r;
  }

  /* ********************************************************** */
  // INLINE? (ForExpr | WhileExpr)
  public static boolean LoopExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOP_EXPR, "<loop expr>");
    r = LoopExpr_0(b, l + 1);
    r = r && LoopExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INLINE?
  private static boolean LoopExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopExpr_0")) return false;
    consumeToken(b, INLINE);
    return true;
  }

  // ForExpr | WhileExpr
  private static boolean LoopExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopExpr_1")) return false;
    boolean r;
    r = ForExpr(b, l + 1);
    if (!r) r = WhileExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // INLINE? (ForStatement | WhileStatement)
  public static boolean LoopStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOP_STATEMENT, "<loop statement>");
    r = LoopStatement_0(b, l + 1);
    r = r && LoopStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INLINE?
  private static boolean LoopStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopStatement_0")) return false;
    consumeToken(b, INLINE);
    return true;
  }

  // ForStatement | WhileStatement
  private static boolean LoopStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopStatement_1")) return false;
    boolean r;
    r = ForStatement(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PrefixExpr (MultiplyOp PrefixExpr)*
  public static boolean MultiplyExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplyExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_EXPR, "<multiply expr>");
    r = PrefixExpr(b, l + 1);
    r = r && MultiplyExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MultiplyOp PrefixExpr)*
  private static boolean MultiplyExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplyExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MultiplyExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MultiplyExpr_1", c)) break;
    }
    return true;
  }

  // MultiplyOp PrefixExpr
  private static boolean MultiplyExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplyExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MultiplyOp(b, l + 1);
    r = r && PrefixExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PIPE2 | ASTERISK | SLASH | PERCENT | ASTERISK2 | ASTERISKPERCENT
  public static boolean MultiplyOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplyOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_OP, "<multiply op>");
    r = consumeToken(b, PIPE2);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, ASTERISK2);
    if (!r) r = consumeToken(b, ASTERISKPERCENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ID COLON)? ParamType
  public static boolean ParamDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DECL, "<param decl>");
    r = ParamDecl_0(b, l + 1);
    r = r && ParamType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ID COLON)?
  private static boolean ParamDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDecl_0")) return false;
    ParamDecl_0_0(b, l + 1);
    return true;
  }

  // ID COLON
  private static boolean ParamDecl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDecl_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (ParamDecl COMMA)* ParamDecl?
  public static boolean ParamDeclList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDeclList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DECL_LIST, "<param decl list>");
    r = ParamDeclList_0(b, l + 1);
    r = r && ParamDeclList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ParamDecl COMMA)*
  private static boolean ParamDeclList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDeclList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParamDeclList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParamDeclList_0", c)) break;
    }
    return true;
  }

  // ParamDecl COMMA
  private static boolean ParamDeclList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDeclList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamDecl(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamDecl?
  private static boolean ParamDeclList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDeclList_1")) return false;
    ParamDecl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeExpr
  public static boolean ParamType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_TYPE, "<param type>");
    r = TypeExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PIPE ID PIPE
  public static boolean Payload(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Payload")) return false;
    if (!nextTokenIs(b, PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PIPE, ID, PIPE);
    exit_section_(b, m, PAYLOAD, r);
    return r;
  }

  /* ********************************************************** */
  // PrefixOp* PrimaryExpr
  public static boolean PrefixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_EXPR, "<prefix expr>");
    r = PrefixExpr_0(b, l + 1);
    r = r && PrimaryExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PrefixOp*
  private static boolean PrefixExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixExpr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PrefixOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PrefixExpr_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // EXCLAMATIONMARK
  //      | MINUS
  //      | TILDE
  //      | MINUSPERCENT
  //      | AMPERSAND
  //      | TRY
  //      | AWAIT
  public static boolean PrefixOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_OP, "<prefix op>");
    r = consumeToken(b, EXCLAMATIONMARK);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, MINUSPERCENT);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, TRY);
    if (!r) r = consumeToken(b, AWAIT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QUESTIONMARK
  //     | ANYFRAME MINUSRARROW
  //     | SliceTypeStart (ByteAlign | CONST | VOLATILE | ALLOWZERO)*
  //     | PtrTypeStart (ALIGN LPAREN Expr (COLON INTEGER COLON INTEGER)? RPAREN | CONST | VOLATILE| ALLOWZERO)*
  //     | ArrayTypeStart
  public static boolean PrefixTypeOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_TYPE_OP, "<prefix type op>");
    r = consumeToken(b, QUESTIONMARK);
    if (!r) r = parseTokens(b, 0, ANYFRAME, MINUSRARROW);
    if (!r) r = PrefixTypeOp_2(b, l + 1);
    if (!r) r = PrefixTypeOp_3(b, l + 1);
    if (!r) r = ArrayTypeStart(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SliceTypeStart (ByteAlign | CONST | VOLATILE | ALLOWZERO)*
  private static boolean PrefixTypeOp_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SliceTypeStart(b, l + 1);
    r = r && PrefixTypeOp_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ByteAlign | CONST | VOLATILE | ALLOWZERO)*
  private static boolean PrefixTypeOp_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PrefixTypeOp_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PrefixTypeOp_2_1", c)) break;
    }
    return true;
  }

  // ByteAlign | CONST | VOLATILE | ALLOWZERO
  private static boolean PrefixTypeOp_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_2_1_0")) return false;
    boolean r;
    r = ByteAlign(b, l + 1);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, VOLATILE);
    if (!r) r = consumeToken(b, ALLOWZERO);
    return r;
  }

  // PtrTypeStart (ALIGN LPAREN Expr (COLON INTEGER COLON INTEGER)? RPAREN | CONST | VOLATILE| ALLOWZERO)*
  private static boolean PrefixTypeOp_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PtrTypeStart(b, l + 1);
    r = r && PrefixTypeOp_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ALIGN LPAREN Expr (COLON INTEGER COLON INTEGER)? RPAREN | CONST | VOLATILE| ALLOWZERO)*
  private static boolean PrefixTypeOp_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_3_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PrefixTypeOp_3_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PrefixTypeOp_3_1", c)) break;
    }
    return true;
  }

  // ALIGN LPAREN Expr (COLON INTEGER COLON INTEGER)? RPAREN | CONST | VOLATILE| ALLOWZERO
  private static boolean PrefixTypeOp_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PrefixTypeOp_3_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, VOLATILE);
    if (!r) r = consumeToken(b, ALLOWZERO);
    exit_section_(b, m, null, r);
    return r;
  }

  // ALIGN LPAREN Expr (COLON INTEGER COLON INTEGER)? RPAREN
  private static boolean PrefixTypeOp_3_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_3_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIGN, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && PrefixTypeOp_3_1_0_0_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON INTEGER COLON INTEGER)?
  private static boolean PrefixTypeOp_3_1_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_3_1_0_0_3")) return false;
    PrefixTypeOp_3_1_0_0_3_0(b, l + 1);
    return true;
  }

  // COLON INTEGER COLON INTEGER
  private static boolean PrefixTypeOp_3_1_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixTypeOp_3_1_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, INTEGER, COLON, INTEGER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AsmExpr
  //     | IfExpr
  //     | BREAK BreakLabel? Expr?
  //     | COMPTIME Expr
  //     | NOSUSPEND Expr
  //     | CONTINUE BreakLabel?
  //     | RESUME Expr
  //     | RETURN Expr?
  //     | BlockLabel? LoopExpr
  //     | Block
  //     | CurlySuffixExpr
  public static boolean PrimaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPR, "<primary expr>");
    r = AsmExpr(b, l + 1);
    if (!r) r = IfExpr(b, l + 1);
    if (!r) r = PrimaryExpr_2(b, l + 1);
    if (!r) r = PrimaryExpr_3(b, l + 1);
    if (!r) r = PrimaryExpr_4(b, l + 1);
    if (!r) r = PrimaryExpr_5(b, l + 1);
    if (!r) r = PrimaryExpr_6(b, l + 1);
    if (!r) r = PrimaryExpr_7(b, l + 1);
    if (!r) r = PrimaryExpr_8(b, l + 1);
    if (!r) r = Block(b, l + 1);
    if (!r) r = CurlySuffixExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BREAK BreakLabel? Expr?
  private static boolean PrimaryExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    r = r && PrimaryExpr_2_1(b, l + 1);
    r = r && PrimaryExpr_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BreakLabel?
  private static boolean PrimaryExpr_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_2_1")) return false;
    BreakLabel(b, l + 1);
    return true;
  }

  // Expr?
  private static boolean PrimaryExpr_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_2_2")) return false;
    Expr(b, l + 1);
    return true;
  }

  // COMPTIME Expr
  private static boolean PrimaryExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPTIME);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOSUSPEND Expr
  private static boolean PrimaryExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOSUSPEND);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CONTINUE BreakLabel?
  private static boolean PrimaryExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    r = r && PrimaryExpr_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BreakLabel?
  private static boolean PrimaryExpr_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_5_1")) return false;
    BreakLabel(b, l + 1);
    return true;
  }

  // RESUME Expr
  private static boolean PrimaryExpr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RESUME);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RETURN Expr?
  private static boolean PrimaryExpr_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && PrimaryExpr_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expr?
  private static boolean PrimaryExpr_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_7_1")) return false;
    Expr(b, l + 1);
    return true;
  }

  // BlockLabel? LoopExpr
  private static boolean PrimaryExpr_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PrimaryExpr_8_0(b, l + 1);
    r = r && LoopExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BlockLabel?
  private static boolean PrimaryExpr_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_8_0")) return false;
    BlockLabel(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BUILTINIDENTIFIER FnCallArguments
  //     | CHAR_LITERAL
  //     | ContainerDecl
  //     | DOT ID
  //     | ID
  //     | INTEGER
  //     | STRINGLITERAL
  public static boolean PrimaryTypeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryTypeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_TYPE_EXPR, "<primary type expr>");
    r = PrimaryTypeExpr_0(b, l + 1);
    if (!r) r = consumeToken(b, CHAR_LITERAL);
    if (!r) r = ContainerDecl(b, l + 1);
    if (!r) r = parseTokens(b, 0, DOT, ID);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = STRINGLITERAL(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BUILTINIDENTIFIER FnCallArguments
  private static boolean PrimaryTypeExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryTypeExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BUILTINIDENTIFIER(b, l + 1);
    r = r && FnCallArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PIPE ASTERISK? ID (COMMA ID)? PIPE
  public static boolean PtrIndexPayload(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrIndexPayload")) return false;
    if (!nextTokenIs(b, PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && PtrIndexPayload_1(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && PtrIndexPayload_3(b, l + 1);
    r = r && consumeToken(b, PIPE);
    exit_section_(b, m, PTR_INDEX_PAYLOAD, r);
    return r;
  }

  // ASTERISK?
  private static boolean PtrIndexPayload_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrIndexPayload_1")) return false;
    consumeToken(b, ASTERISK);
    return true;
  }

  // (COMMA ID)?
  private static boolean PtrIndexPayload_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrIndexPayload_3")) return false;
    PtrIndexPayload_3_0(b, l + 1);
    return true;
  }

  // COMMA ID
  private static boolean PtrIndexPayload_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrIndexPayload_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PIPE ASTERISK? ID PIPE
  public static boolean PtrPayload(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrPayload")) return false;
    if (!nextTokenIs(b, PIPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && PtrPayload_1(b, l + 1);
    r = r && consumeTokens(b, 0, ID, PIPE);
    exit_section_(b, m, PTR_PAYLOAD, r);
    return r;
  }

  // ASTERISK?
  private static boolean PtrPayload_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrPayload_1")) return false;
    consumeToken(b, ASTERISK);
    return true;
  }

  /* ********************************************************** */
  // ASTERISK
  //     | ASTERISK2
  //     | LBRACKET ASTERISK (LETTERC | COLON Expr)? RBRACKET
  public static boolean PtrTypeStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrTypeStart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PTR_TYPE_START, "<ptr type start>");
    r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, ASTERISK2);
    if (!r) r = PtrTypeStart_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACKET ASTERISK (LETTERC | COLON Expr)? RBRACKET
  private static boolean PtrTypeStart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrTypeStart_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, ASTERISK);
    r = r && PtrTypeStart_2_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LETTERC | COLON Expr)?
  private static boolean PtrTypeStart_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrTypeStart_2_2")) return false;
    PtrTypeStart_2_2_0(b, l + 1);
    return true;
  }

  // LETTERC | COLON Expr
  private static boolean PtrTypeStart_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrTypeStart_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LETTERC);
    if (!r) r = PtrTypeStart_2_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON Expr
  private static boolean PtrTypeStart_2_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PtrTypeStart_2_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRINGLITERALSINGLE
  public static boolean STRINGLITERAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STRINGLITERAL")) return false;
    if (!nextTokenIs(b, STRINGLITERALSINGLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRINGLITERALSINGLE);
    exit_section_(b, m, STRINGLITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET (COLON Expr)? RBRACKET
  public static boolean SliceTypeStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SliceTypeStart")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && SliceTypeStart_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, SLICE_TYPE_START, r);
    return r;
  }

  // (COLON Expr)?
  private static boolean SliceTypeStart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SliceTypeStart_1")) return false;
    SliceTypeStart_1_0(b, l + 1);
    return true;
  }

  // COLON Expr
  private static boolean SliceTypeStart_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SliceTypeStart_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VarDecl
  //     | COMPTIME BlockExprStatement
  //     | NOSUSPEND BlockExprStatement
  //     | SUSPEND BlockExprStatement
  //     | DEFER BlockExprStatement
  //     | ERRDEFER Payload? BlockExprStatement
  //     | IfStatement
  //     | LabeledStatement
  //     | SwitchExpr
  //     | AssignExpr SEMICOLON
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = VarDecl(b, l + 1);
    if (!r) r = Statement_1(b, l + 1);
    if (!r) r = Statement_2(b, l + 1);
    if (!r) r = Statement_3(b, l + 1);
    if (!r) r = Statement_4(b, l + 1);
    if (!r) r = Statement_5(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = LabeledStatement(b, l + 1);
    if (!r) r = SwitchExpr(b, l + 1);
    if (!r) r = Statement_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMPTIME BlockExprStatement
  private static boolean Statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMPTIME);
    r = r && BlockExprStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NOSUSPEND BlockExprStatement
  private static boolean Statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOSUSPEND);
    r = r && BlockExprStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SUSPEND BlockExprStatement
  private static boolean Statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUSPEND);
    r = r && BlockExprStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DEFER BlockExprStatement
  private static boolean Statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFER);
    r = r && BlockExprStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ERRDEFER Payload? BlockExprStatement
  private static boolean Statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ERRDEFER);
    r = r && Statement_5_1(b, l + 1);
    r = r && BlockExprStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean Statement_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_5_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  // AssignExpr SEMICOLON
  private static boolean Statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (STRINGLITERAL COMMA)* STRINGLITERAL?
  public static boolean StringList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LIST, "<string list>");
    r = StringList_0(b, l + 1);
    r = r && StringList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (STRINGLITERAL COMMA)*
  private static boolean StringList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StringList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StringList_0", c)) break;
    }
    return true;
  }

  // STRINGLITERAL COMMA
  private static boolean StringList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = STRINGLITERAL(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRINGLITERAL?
  private static boolean StringList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringList_1")) return false;
    STRINGLITERAL(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ASYNC PrimaryTypeExpr SuffixOp* FnCallArguments
  //     | PrimaryTypeExpr (SuffixOp | FnCallArguments)*
  public static boolean SuffixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUFFIX_EXPR, "<suffix expr>");
    r = SuffixExpr_0(b, l + 1);
    if (!r) r = SuffixExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ASYNC PrimaryTypeExpr SuffixOp* FnCallArguments
  private static boolean SuffixExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASYNC);
    r = r && PrimaryTypeExpr(b, l + 1);
    r = r && SuffixExpr_0_2(b, l + 1);
    r = r && FnCallArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SuffixOp*
  private static boolean SuffixExpr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SuffixOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SuffixExpr_0_2", c)) break;
    }
    return true;
  }

  // PrimaryTypeExpr (SuffixOp | FnCallArguments)*
  private static boolean SuffixExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PrimaryTypeExpr(b, l + 1);
    r = r && SuffixExpr_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SuffixOp | FnCallArguments)*
  private static boolean SuffixExpr_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SuffixExpr_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SuffixExpr_1_1", c)) break;
    }
    return true;
  }

  // SuffixOp | FnCallArguments
  private static boolean SuffixExpr_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_1_1_0")) return false;
    boolean r;
    r = SuffixOp(b, l + 1);
    if (!r) r = FnCallArguments(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET Expr (DOT2 (Expr? (COLON Expr)?)?)? RBRACKET
  //                   | DOT ID
  //                   | DOTASTERISK
  //                   | DOTQUESTIONMARK
  public static boolean SuffixOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUFFIX_OP, "<suffix op>");
    r = SuffixOp_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, DOT, ID);
    if (!r) r = consumeToken(b, DOTASTERISK);
    if (!r) r = consumeToken(b, DOTQUESTIONMARK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACKET Expr (DOT2 (Expr? (COLON Expr)?)?)? RBRACKET
  private static boolean SuffixOp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && Expr(b, l + 1);
    r = r && SuffixOp_0_2(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT2 (Expr? (COLON Expr)?)?)?
  private static boolean SuffixOp_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2")) return false;
    SuffixOp_0_2_0(b, l + 1);
    return true;
  }

  // DOT2 (Expr? (COLON Expr)?)?
  private static boolean SuffixOp_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT2);
    r = r && SuffixOp_0_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Expr? (COLON Expr)?)?
  private static boolean SuffixOp_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2_0_1")) return false;
    SuffixOp_0_2_0_1_0(b, l + 1);
    return true;
  }

  // Expr? (COLON Expr)?
  private static boolean SuffixOp_0_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SuffixOp_0_2_0_1_0_0(b, l + 1);
    r = r && SuffixOp_0_2_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expr?
  private static boolean SuffixOp_0_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2_0_1_0_0")) return false;
    Expr(b, l + 1);
    return true;
  }

  // (COLON Expr)?
  private static boolean SuffixOp_0_2_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2_0_1_0_1")) return false;
    SuffixOp_0_2_0_1_0_1_0(b, l + 1);
    return true;
  }

  // COLON Expr
  private static boolean SuffixOp_0_2_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixOp_0_2_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SwitchItem (COMMA SwitchItem)* COMMA? | ELSE
  public static boolean SwitchCase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCase")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_CASE, "<switch case>");
    r = SwitchCase_0(b, l + 1);
    if (!r) r = consumeToken(b, ELSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SwitchItem (COMMA SwitchItem)* COMMA?
  private static boolean SwitchCase_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCase_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SwitchItem(b, l + 1);
    r = r && SwitchCase_0_1(b, l + 1);
    r = r && SwitchCase_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA SwitchItem)*
  private static boolean SwitchCase_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCase_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SwitchCase_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchCase_0_1", c)) break;
    }
    return true;
  }

  // COMMA SwitchItem
  private static boolean SwitchCase_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCase_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && SwitchItem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean SwitchCase_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchCase_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // SWITCH LPAREN Expr RPAREN LBRACE SwitchProngList RBRACE
  public static boolean SwitchExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchExpr")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SWITCH, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, LBRACE);
    r = r && SwitchProngList(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, SWITCH_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // Expr (DOT3 Expr)?
  public static boolean SwitchItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchItem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_ITEM, "<switch item>");
    r = Expr(b, l + 1);
    r = r && SwitchItem_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOT3 Expr)?
  private static boolean SwitchItem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchItem_1")) return false;
    SwitchItem_1_0(b, l + 1);
    return true;
  }

  // DOT3 Expr
  private static boolean SwitchItem_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchItem_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT3);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SwitchCase EQUALRARROW PtrPayload? AssignExpr
  public static boolean SwitchProng(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchProng")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_PRONG, "<switch prong>");
    r = SwitchCase(b, l + 1);
    r = r && consumeToken(b, EQUALRARROW);
    r = r && SwitchProng_2(b, l + 1);
    r = r && AssignExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PtrPayload?
  private static boolean SwitchProng_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchProng_2")) return false;
    PtrPayload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (SwitchProng COMMA)* SwitchProng
  public static boolean SwitchProngList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchProngList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_PRONG_LIST, "<switch prong list>");
    r = SwitchProngList_0(b, l + 1);
    r = r && SwitchProng(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (SwitchProng COMMA)*
  private static boolean SwitchProngList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchProngList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SwitchProngList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SwitchProngList_0", c)) break;
    }
    return true;
  }

  // SwitchProng COMMA
  private static boolean SwitchProngList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchProngList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SwitchProng(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DocComment? TEST STRINGLITERALSINGLE? Block
  public static boolean TestDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TestDecl")) return false;
    if (!nextTokenIs(b, "<test decl>", COMMENT, TEST)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEST_DECL, "<test decl>");
    r = TestDecl_0(b, l + 1);
    r = r && consumeToken(b, TEST);
    r = r && TestDecl_2(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DocComment?
  private static boolean TestDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TestDecl_0")) return false;
    DocComment(b, l + 1);
    return true;
  }

  // STRINGLITERALSINGLE?
  private static boolean TestDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TestDecl_2")) return false;
    consumeToken(b, STRINGLITERALSINGLE);
    return true;
  }

  /* ********************************************************** */
  // DocComment? COMPTIME BlockExpr
  public static boolean TopLevelComptime(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelComptime")) return false;
    if (!nextTokenIs(b, "<top level comptime>", COMMENT, COMPTIME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_COMPTIME, "<top level comptime>");
    r = TopLevelComptime_0(b, l + 1);
    r = r && consumeToken(b, COMPTIME);
    r = r && BlockExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DocComment?
  private static boolean TopLevelComptime_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelComptime_0")) return false;
    DocComment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (EXPORT | EXTERN STRINGLITERALSINGLE? | (INLINE | NOINLINE))?  FnProto (SEMICOLON | Block)
  //     |(EXPORT | EXTERN STRINGLITERALSINGLE?)? THREAD_LOCAL? VarDecl
  //     | USING_NAME_SPACE Expr SEMICOLON
  static boolean TopLevelDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TopLevelDecl_0(b, l + 1);
    if (!r) r = TopLevelDecl_1(b, l + 1);
    if (!r) r = TopLevelDecl_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EXPORT | EXTERN STRINGLITERALSINGLE? | (INLINE | NOINLINE))?  FnProto (SEMICOLON | Block)
  private static boolean TopLevelDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TopLevelDecl_0_0(b, l + 1);
    r = r && FnProto(b, l + 1);
    r = r && TopLevelDecl_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EXPORT | EXTERN STRINGLITERALSINGLE? | (INLINE | NOINLINE))?
  private static boolean TopLevelDecl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_0")) return false;
    TopLevelDecl_0_0_0(b, l + 1);
    return true;
  }

  // EXPORT | EXTERN STRINGLITERALSINGLE? | (INLINE | NOINLINE)
  private static boolean TopLevelDecl_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPORT);
    if (!r) r = TopLevelDecl_0_0_0_1(b, l + 1);
    if (!r) r = TopLevelDecl_0_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EXTERN STRINGLITERALSINGLE?
  private static boolean TopLevelDecl_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTERN);
    r = r && TopLevelDecl_0_0_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRINGLITERALSINGLE?
  private static boolean TopLevelDecl_0_0_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_0_0_1_1")) return false;
    consumeToken(b, STRINGLITERALSINGLE);
    return true;
  }

  // INLINE | NOINLINE
  private static boolean TopLevelDecl_0_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_0_0_2")) return false;
    boolean r;
    r = consumeToken(b, INLINE);
    if (!r) r = consumeToken(b, NOINLINE);
    return r;
  }

  // SEMICOLON | Block
  private static boolean TopLevelDecl_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_2")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = Block(b, l + 1);
    return r;
  }

  // (EXPORT | EXTERN STRINGLITERALSINGLE?)? THREAD_LOCAL? VarDecl
  private static boolean TopLevelDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TopLevelDecl_1_0(b, l + 1);
    r = r && TopLevelDecl_1_1(b, l + 1);
    r = r && VarDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EXPORT | EXTERN STRINGLITERALSINGLE?)?
  private static boolean TopLevelDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_1_0")) return false;
    TopLevelDecl_1_0_0(b, l + 1);
    return true;
  }

  // EXPORT | EXTERN STRINGLITERALSINGLE?
  private static boolean TopLevelDecl_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPORT);
    if (!r) r = TopLevelDecl_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EXTERN STRINGLITERALSINGLE?
  private static boolean TopLevelDecl_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTERN);
    r = r && TopLevelDecl_1_0_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRINGLITERALSINGLE?
  private static boolean TopLevelDecl_1_0_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_1_0_0_1_1")) return false;
    consumeToken(b, STRINGLITERALSINGLE);
    return true;
  }

  // THREAD_LOCAL?
  private static boolean TopLevelDecl_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_1_1")) return false;
    consumeToken(b, THREAD_LOCAL);
    return true;
  }

  // USING_NAME_SPACE Expr SEMICOLON
  private static boolean TopLevelDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USING_NAME_SPACE);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PrefixTypeOp* ErrorUnionExpr
  public static boolean TypeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPR, "<type expr>");
    r = TypeExpr_0(b, l + 1);
    r = r && ErrorUnionExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PrefixTypeOp*
  private static boolean TypeExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeExpr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PrefixTypeOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeExpr_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (CONST |VAR) ID (COLON TypeExpr)? ByteAlign? LinkSection? (EQUAL Expr)? SEMICOLON
  public static boolean VarDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl")) return false;
    if (!nextTokenIs(b, "<var decl>", CONST, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL, "<var decl>");
    r = VarDecl_0(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && VarDecl_2(b, l + 1);
    r = r && VarDecl_3(b, l + 1);
    r = r && VarDecl_4(b, l + 1);
    r = r && VarDecl_5(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONST |VAR
  private static boolean VarDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_0")) return false;
    boolean r;
    r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, VAR);
    return r;
  }

  // (COLON TypeExpr)?
  private static boolean VarDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_2")) return false;
    VarDecl_2_0(b, l + 1);
    return true;
  }

  // COLON TypeExpr
  private static boolean VarDecl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && TypeExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ByteAlign?
  private static boolean VarDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_3")) return false;
    ByteAlign(b, l + 1);
    return true;
  }

  // LinkSection?
  private static boolean VarDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_4")) return false;
    LinkSection(b, l + 1);
    return true;
  }

  // (EQUAL Expr)?
  private static boolean VarDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_5")) return false;
    VarDecl_5_0(b, l + 1);
    return true;
  }

  // EQUAL Expr
  private static boolean VarDecl_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON LPAREN AssignExpr RPAREN
  public static boolean WhileContinueExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileContinueExpr")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, LPAREN);
    r = r && AssignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, WHILE_CONTINUE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // WhilePrefix Expr (ELSE Payload? Expr)?
  public static boolean WhileExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpr")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WhilePrefix(b, l + 1);
    r = r && Expr(b, l + 1);
    r = r && WhileExpr_2(b, l + 1);
    exit_section_(b, m, WHILE_EXPR, r);
    return r;
  }

  // (ELSE Payload? Expr)?
  private static boolean WhileExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpr_2")) return false;
    WhileExpr_2_0(b, l + 1);
    return true;
  }

  // ELSE Payload? Expr
  private static boolean WhileExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && WhileExpr_2_0_1(b, l + 1);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean WhileExpr_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileExpr_2_0_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WHILE LPAREN Expr RPAREN PtrPayload? WhileContinueExpr?
  public static boolean WhilePrefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhilePrefix")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, WHILE, LPAREN);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && WhilePrefix_4(b, l + 1);
    r = r && WhilePrefix_5(b, l + 1);
    exit_section_(b, m, WHILE_PREFIX, r);
    return r;
  }

  // PtrPayload?
  private static boolean WhilePrefix_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhilePrefix_4")) return false;
    PtrPayload(b, l + 1);
    return true;
  }

  // WhileContinueExpr?
  private static boolean WhilePrefix_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhilePrefix_5")) return false;
    WhileContinueExpr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WhilePrefix BlockExpr (ELSE Payload? Statement)?
  //     | WhilePrefix AssignExpr (SEMICOLON | ELSE Payload? Statement)
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WhileStatement_0(b, l + 1);
    if (!r) r = WhileStatement_1(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  // WhilePrefix BlockExpr (ELSE Payload? Statement)?
  private static boolean WhileStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WhilePrefix(b, l + 1);
    r = r && BlockExpr(b, l + 1);
    r = r && WhileStatement_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE Payload? Statement)?
  private static boolean WhileStatement_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_0_2")) return false;
    WhileStatement_0_2_0(b, l + 1);
    return true;
  }

  // ELSE Payload? Statement
  private static boolean WhileStatement_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && WhileStatement_0_2_0_1(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean WhileStatement_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_0_2_0_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  // WhilePrefix AssignExpr (SEMICOLON | ELSE Payload? Statement)
  private static boolean WhileStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WhilePrefix(b, l + 1);
    r = r && AssignExpr(b, l + 1);
    r = r && WhileStatement_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON | ELSE Payload? Statement
  private static boolean WhileStatement_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = WhileStatement_1_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE Payload? Statement
  private static boolean WhileStatement_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_1_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && WhileStatement_1_2_1_1(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Payload?
  private static boolean WhileStatement_1_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement_1_2_1_1")) return false;
    Payload(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CONTAINER_DOC+
  static boolean container_doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_doc_comment")) return false;
    if (!nextTokenIs(b, CONTAINER_DOC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTAINER_DOC);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, CONTAINER_DOC)) break;
      if (!empty_element_parsed_guard_(b, "container_doc_comment", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // container_doc_comment? ContainerDeclarations?
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_0(b, l + 1);
    r = r && root_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // container_doc_comment?
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    container_doc_comment(b, l + 1);
    return true;
  }

  // ContainerDeclarations?
  private static boolean root_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_1")) return false;
    ContainerDeclarations(b, l + 1);
    return true;
  }

}
