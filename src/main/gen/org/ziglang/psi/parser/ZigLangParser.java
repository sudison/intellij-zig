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
  // (PUB? TopLevelDecl)*
  public static boolean ContainerDeclarations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations")) return false;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_DECLARATIONS, "<container declarations>");
    while (true) {
      int c = current_position_(b);
      if (!ContainerDeclarations_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ContainerDeclarations", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // PUB? TopLevelDecl
  private static boolean ContainerDeclarations_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ContainerDeclarations_0_0(b, l + 1);
    r = r && TopLevelDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PUB?
  private static boolean ContainerDeclarations_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerDeclarations_0_0")) return false;
    consumeToken(b, PUB);
    return true;
  }

  /* ********************************************************** */
  // ContainerDeclarations
  public static boolean ContainerMembers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerMembers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAINER_MEMBERS, "<container members>");
    r = ContainerDeclarations(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TypeExpr
  public static boolean CurlySuffixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CurlySuffixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CURLY_SUFFIX_EXPR, "<curly suffix expr>");
    r = TypeExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // FN ID? LPAREN ParamDeclList RPAREN  TypeExpr
  public static boolean FnProto(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto")) return false;
    if (!nextTokenIs(b, FN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN);
    r = r && FnProto_1(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && ParamDeclList(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && TypeExpr(b, l + 1);
    exit_section_(b, m, FN_PROTO, r);
    return r;
  }

  // ID?
  private static boolean FnProto_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnProto_1")) return false;
    consumeToken(b, ID);
    return true;
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
  // IfExpr | RETURN Expr?| Block | CurlySuffixExpr
  public static boolean PrimaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPR, "<primary expr>");
    r = IfExpr(b, l + 1);
    if (!r) r = PrimaryExpr_1(b, l + 1);
    if (!r) r = Block(b, l + 1);
    if (!r) r = CurlySuffixExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RETURN Expr?
  private static boolean PrimaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && PrimaryExpr_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expr?
  private static boolean PrimaryExpr_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr_1_1")) return false;
    Expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BUILTINIDENTIFIER FnCallArguments | DOT ID | ID | INTEGER | STRINGLITERAL
  public static boolean PrimaryTypeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryTypeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_TYPE_EXPR, "<primary type expr>");
    r = PrimaryTypeExpr_0(b, l + 1);
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
  // VarDecl | AssignExpr SEMICOLON
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = VarDecl(b, l + 1);
    if (!r) r = Statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AssignExpr SEMICOLON
  private static boolean Statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PrimaryTypeExpr (SuffixOp | FnCallArguments)*
  public static boolean SuffixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUFFIX_EXPR, "<suffix expr>");
    r = PrimaryTypeExpr(b, l + 1);
    r = r && SuffixExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (SuffixOp | FnCallArguments)*
  private static boolean SuffixExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SuffixExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SuffixExpr_1", c)) break;
    }
    return true;
  }

  // SuffixOp | FnCallArguments
  private static boolean SuffixExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuffixExpr_1_0")) return false;
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
  // FnProto (SEMICOLON | Block) | VarDecl
  public static boolean TopLevelDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_DECL, "<top level decl>");
    r = TopLevelDecl_0(b, l + 1);
    if (!r) r = VarDecl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FnProto (SEMICOLON | Block)
  private static boolean TopLevelDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FnProto(b, l + 1);
    r = r && TopLevelDecl_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON | Block
  private static boolean TopLevelDecl_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDecl_0_1")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = Block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ErrorUnionExpr
  public static boolean TypeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_EXPR, "<type expr>");
    r = ErrorUnionExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (CONST |VAR) ID (COLON TypeExpr)? (EQUAL Expr)? SEMICOLON
  public static boolean VarDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl")) return false;
    if (!nextTokenIs(b, "<var decl>", CONST, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL, "<var decl>");
    r = VarDecl_0(b, l + 1);
    r = r && consumeToken(b, ID);
    r = r && VarDecl_2(b, l + 1);
    r = r && VarDecl_3(b, l + 1);
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

  // (EQUAL Expr)?
  private static boolean VarDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_3")) return false;
    VarDecl_3_0(b, l + 1);
    return true;
  }

  // EQUAL Expr
  private static boolean VarDecl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDecl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT+
  public static boolean container_doc_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_doc_comment")) return false;
    if (!nextTokenIs(b, COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMENT)) break;
      if (!empty_element_parsed_guard_(b, "container_doc_comment", c)) break;
    }
    exit_section_(b, m, CONTAINER_DOC_COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // container_doc_comment? ContainerMembers
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_0(b, l + 1);
    r = r && ContainerMembers(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // container_doc_comment?
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    container_doc_comment(b, l + 1);
    return true;
  }

}
