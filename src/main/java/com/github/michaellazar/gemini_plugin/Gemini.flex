package com.github.michaellazar.gemini_plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.michaellazar.gemini_plugin.psi.GeminiTypes;
import com.intellij.psi.TokenType;

%%

%class GeminiLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

SP=" "
TEXT=[^\r\n]
CRLF=\r?\n
URL=\S+

H1_HEADER="#" [ ]?
H2_HEADER="##" [ ]?
H3_HEADER="###" [ ]?
QUOTE_HEADER=">" [ ]?
ULIST_HEADER="* "
PRE_HEADER="```"
PRE_FOOTER="```" [^\r\n]*
LINK_HEADER="=>" [ ]?

%state WAITING_H1_TEXT
%state WAITING_H2_TEXT
%state WAITING_H3_TEXT
%state WAITING_QUOTE_TEXT
%state WAITING_ULIST_TEXT
%state WAITING_PLAIN_TEXT
%state WAITING_LINK_URL
%state WAITING_LINK_SP
%state WAITING_LINK_TEXT
%state WAITING_PRE_ALT
%state WAITING_PRE_TEXT
%state WAITING_PRE_CRLF
%state WAITING_CRLF

%%

// I have no idea what I'm doing here... but it works, damnit!

<YYINITIAL> {H3_HEADER}             { yybegin(WAITING_H3_TEXT); return GeminiTypes.H3_HEADER; }
<WAITING_H3_TEXT> {TEXT}+           { yybegin(WAITING_CRLF); return GeminiTypes.H3_TEXT; }
<WAITING_H3_TEXT> {CRLF}            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {H2_HEADER}             { yybegin(WAITING_H2_TEXT); return GeminiTypes.H2_HEADER; }
<WAITING_H2_TEXT> {TEXT}+           { yybegin(WAITING_CRLF); return GeminiTypes.H2_TEXT; }
<WAITING_H2_TEXT> {CRLF}            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {H1_HEADER}             { yybegin(WAITING_H1_TEXT); return GeminiTypes.H1_HEADER; }
<WAITING_H1_TEXT> {TEXT}+           { yybegin(WAITING_CRLF); return GeminiTypes.H1_TEXT; }
<WAITING_H1_TEXT> {CRLF}            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {QUOTE_HEADER}          { yybegin(WAITING_QUOTE_TEXT); return GeminiTypes.QUOTE_HEADER; }
<WAITING_QUOTE_TEXT> {TEXT}+        { yybegin(WAITING_CRLF); return GeminiTypes.QUOTE_TEXT; }
<WAITING_QUOTE_TEXT> {CRLF}         { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {ULIST_HEADER}          { yybegin(WAITING_ULIST_TEXT); return GeminiTypes.ULIST_HEADER; }
<WAITING_ULIST_TEXT> {TEXT}+        { yybegin(WAITING_CRLF); return GeminiTypes.ULIST_TEXT; }
<WAITING_ULIST_TEXT> {CRLF}         { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {TEXT}                  { yybegin(WAITING_PLAIN_TEXT); return GeminiTypes.PLAIN_HEADER; }
<WAITING_PLAIN_TEXT> {TEXT}+        { yybegin(WAITING_CRLF); return GeminiTypes.PLAIN_TEXT; }
<WAITING_PLAIN_TEXT> {CRLF}         { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {LINK_HEADER}           { yybegin(WAITING_LINK_URL); return GeminiTypes.LINK_HEADER; }
<WAITING_LINK_URL> {URL}            { yybegin(WAITING_LINK_SP); return GeminiTypes.LINK_URL; }
<WAITING_LINK_SP> {CRLF}            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
<WAITING_LINK_SP> {SP}              { yybegin(WAITING_LINK_TEXT); return TokenType.WHITE_SPACE; }
<WAITING_LINK_TEXT> {TEXT}+         { yybegin(WAITING_CRLF); return GeminiTypes.LINK_TEXT; }
<WAITING_LINK_TEXT> {CRLF}          { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {PRE_HEADER}            { yybegin(WAITING_PRE_ALT); return GeminiTypes.PRE_HEADER; }
<WAITING_PRE_ALT> {TEXT}+           { yybegin(WAITING_PRE_CRLF); return GeminiTypes.PRE_ALT; }
<WAITING_PRE_ALT> {CRLF}            { yybegin(WAITING_PRE_TEXT); return TokenType.WHITE_SPACE; }
<WAITING_PRE_CRLF> {CRLF}           { yybegin(WAITING_PRE_TEXT); return TokenType.WHITE_SPACE; }
<WAITING_PRE_TEXT> {PRE_FOOTER}     { yybegin(WAITING_CRLF); return GeminiTypes.PRE_FOOTER; }
<WAITING_PRE_TEXT> {TEXT}+          { yybegin(WAITING_PRE_CRLF); return GeminiTypes.PRE_TEXT; }
<WAITING_PRE_TEXT> {CRLF}           { yybegin(WAITING_PRE_TEXT); return TokenType.WHITE_SPACE; }

<WAITING_CRLF> {CRLF}               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {CRLF}                  { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                 { return TokenType.BAD_CHARACTER; }
