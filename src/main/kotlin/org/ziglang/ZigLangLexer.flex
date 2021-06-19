package org.ziglang.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.ziglang.psi.ZigLangTypes.*;

%%

%{
  public ZigLangLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class ZigLangLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
ox80_oxBF=[\200-\277]
oxF4='\364'
ox80_ox8F=[\200-\217]
oxF1_oxF3=[\361-\363]
oxF0='\360'
ox90_0xBF=[\220-\277]
oxEE_oxEF=[\356-\357]
oxED='\355'
ox80_ox9F=[\200-\237]
oxE1_oxEC=[\341-\354]
oxE0='\340'
oxA0_oxBF=[\240-\277]
oxC2_oxDF=[\302-\337]
mb_utf8_literal=
       ({oxF4} {ox80_ox8F} {ox80_oxBF} {ox80_oxBF})
     | ({oxF1_oxF3} {ox80_oxBF} {ox80_oxBF} {ox80_oxBF})
     | ({oxF0} {ox90_0xBF} {ox80_oxBF} {ox80_oxBF})
     | ({oxEE_oxEF} {ox80_oxBF} {ox80_oxBF})
     | ({oxED} {ox80_ox9F} {ox80_oxBF})
     | ({oxE1_oxEC} {ox80_oxBF} {ox80_oxBF})
     | ({oxE0} {oxA0_oxBF} {ox80_oxBF})
     | ({oxC2_oxDF} {ox80_oxBF})

ascii_char_not_nl_slash_squote=[\000-\011\013-\046\050-\133\135-\177]

WHITE_SPACE=[\s]+
CONTAINER_DOC="//"!.*
COMMENT="///".*
HEX=[0-9a-fA-F]
INTEGER=[0-9]+
ID=[A-Za-z_][A-Za-z0-9_]*
CHAR_ESCAPE=\\x{HEX}{HEX}|\\u\{{HEX}+}|\\[nr\t\'\"]
char_char={mb_utf8_literal} | {CHAR_ESCAPE} | {ascii_char_not_nl_slash_squote}
CHAR_LITERAL=\' {char_char} \'
STRING_CHAR={CHAR_ESCAPE}|[^\"\n]
STRINGLITERALSINGLE=\"{STRING_CHAR}*\"

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return WHITE_SPACE; }

  "pub"                      { return PUB; }
  "fn"                       { return FN; }
  "const"                    { return CONST; }
  "var"                      { return VAR; }
  "="                        { return EQUAL; }
  "c"                        { return LETTERC; }
  "or"                       { return OR; }
  "and"                      { return AND; }
  "export"                   { return EXPORT; }
  "extern"                   { return EXTERN; }
  "inline"                   { return INLINE; }
  "noinline"                 { return NOINLINE; }
  "threadlocal"              { return THREAD_LOCAL; }
  "usingnamespace"           { return USING_NAME_SPACE; }
  "align"                    { return ALIGN; }
  "linksection"              { return LINKSECTION; }
  "callconv"                 { return CALLCONV; }
  "comptime"                 { return COMPTIME; }
  "anytype"                  { return ANY_TYPE; }
  "test"                     { return TEST; }
  "nosuspend"                { return NOSUSPEND; }
  "suspend"                  { return SUSPEND; }
  "defer"                    { return DEFER; }
  "errdefer"                 { return ERRDEFER; }
  "for"                      { return FOR; }
  "while"                    { return WHILE; }
  "switch"                   { return SWITCH; }
  "break"                    { return BREAK; }
  "continue"                 { return CONTINUE; }
  "resume"                   { return RESUME; }
  "asm"                      { return ASM; }
  "volatile"                 { return VOLATILE; }
  "anyframe"                 { return ANYFRAME; }
  "allowzero"                { return ALLOWZERO; }
  "async"                    { return ASYNC; }
  "=="                       { return EQUALEQUAL; }
  "<"                        { return LARROW; }
  ">"                        { return RARROW; }
  "!"                        { return EXCLAMATIONMARK; }
  "!="                       { return EXCLAMATIONMARKEQUAL; }
  "<="                       { return LARROWEQUAL; }
  ">="                       { return RARROWEQUAL; }
  "&"                        { return AMPERSAND; }
  "^"                        { return CARET; }
  "|"                        { return PIPE; }
  "orelse"                   { return ORELSE; }
  "catch"                    { return CATCH; }
  "<<"                       { return LARROW2; }
  ">>"                       { return RARROW2; }
  "+"                        { return PLUS; }
  "-"                        { return MINUS; }
  "++"                       { return PLUS2; }
  "+%"                       { return PLUSPERCENT; }
  "-%"                       { return MINUSPERCENT; }
  "||"                       { return PIPE2; }
  "*"                        { return ASTERISK; }
  "/"                        { return SLASH; }
  "%"                        { return PERCENT; }
  "**"                       { return ASTERISK2; }
  "*%"                       { return ASTERISKPERCENT; }
  "if"                       { return IF; }
  "return"                   { return RETURN; }
  "else"                     { return ELSE; }
  "{"                        { return LBRACE; }
  "}"                        { return RBRACE; }
  "*="                       { return ASTERISKEQUAL; }
  "/="                       { return SLASHEQUAL; }
  "%="                       { return PERCENTEQUAL; }
  "+="                       { return PLUSEQUAL; }
  "-="                       { return MINUSEQUAL; }
  "<<="                      { return LARROW2EQUAL; }
  ">>="                      { return RARROW2EQUAL; }
  "&="                       { return AMPERSANDEQUAL; }
  "^="                       { return CARETEQUAL; }
  "=>"                       { return EQUALRARROW; }
  "->"                       { return MINUSRARROW; }
  "|="                       { return PIPEEQUAL; }
  "*%="                      { return ASTERISKPERCENTEQUAL; }
  "+%="                      { return PLUSPERCENTEQUAL; }
  "-%="                      { return MINUSPERCENTEQUAL; }
  "~"                        { return TILDE; }
  "."                        { return DOT; }
  ".."                       { return DOT2; }
  "..."                      { return DOT3; }
  "try"                      { return TRY; }
  "["                        { return LBRACKET; }
  "]"                        { return RBRACKET; }
  ".*"                       { return DOTASTERISK; }
  "?"                        { return QUESTIONMARK; }
  ".?"                       { return DOTQUESTIONMARK; }
  ";"                        { return SEMICOLON; }
  "("                        { return LPAREN; }
  ")"                        { return RPAREN; }
  ","                        { return COMMA; }
  ":"                        { return COLON; }
  "AWAIT"                    { return AWAIT; }
  {CHAR_LITERAL}      { return CHAR_LITERAL; }

  {CONTAINER_DOC}            { return CONTAINER_DOC; }
  {COMMENT}                  { return COMMENT; }
  {INTEGER}                  { return INTEGER; }
  {ID}                       { return ID; }
  {STRINGLITERALSINGLE}      { return STRINGLITERALSINGLE; }

}

[^] { return BAD_CHARACTER; }
