package com.github.michaellazar.gemini_plugin;

import com.intellij.lexer.Lexer;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.CodeInsightColors.HYPERLINK_ATTRIBUTES;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.github.michaellazar.gemini_plugin.psi.GeminiTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GeminiSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey H1_HEADER = createTextAttributesKey("GEMINI_H1_HEADER", KEYWORD);
    public static final TextAttributesKey H1_TEXT = createTextAttributesKey("GEMINI_H1_TEXT", CONSTANT);
    public static final TextAttributesKey H2_HEADER = createTextAttributesKey("GEMINI_H2_HEADER", KEYWORD);
    public static final TextAttributesKey H2_TEXT = createTextAttributesKey("GEMINI_H2_TEXT", CONSTANT);
    public static final TextAttributesKey H3_HEADER = createTextAttributesKey("GEMINI_H3_HEADER", KEYWORD);
    public static final TextAttributesKey H3_TEXT = createTextAttributesKey("GEMINI_H3_TEXT", CONSTANT);
    public static final TextAttributesKey QUOTE_HEADER = createTextAttributesKey("GEMINI_QUOTE_HEADER", KEYWORD);
    public static final TextAttributesKey QUOTE_TEXT = createTextAttributesKey("GEMINI_QUOTE_TEXT", STRING);
    public static final TextAttributesKey ULIST_HEADER = createTextAttributesKey("GEMINI_ULIST_HEADER", KEYWORD);
    public static final TextAttributesKey ULIST_TEXT = createTextAttributesKey("GEMINI_ULIST_TEXT", HighlighterColors.TEXT);
    public static final TextAttributesKey LINK_HEADER = createTextAttributesKey("GEMINI_LINK_HEADER", KEYWORD);
    public static final TextAttributesKey LINK_URL = createTextAttributesKey("GEMINI_LINK_URL", STATIC_METHOD);
    public static final TextAttributesKey LINK_TEXT = createTextAttributesKey("GEMINI_LINK_TEXT", HYPERLINK_ATTRIBUTES);
    public static final TextAttributesKey PLAIN_TEXT = createTextAttributesKey("GEMINI_PLAIN_TEXT", HighlighterColors.TEXT);
    public static final TextAttributesKey PRE_HEADER = createTextAttributesKey("GEMINI_PRE_HEADER", KEYWORD);
    public static final TextAttributesKey PRE_ALT = createTextAttributesKey("GEMINI_PRE_ALT", CONSTANT);
    public static final TextAttributesKey PRE_TEXT = createTextAttributesKey("GEMINI_PRE_TEXT", STRING);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("GEMINI_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] H1_HEADER_KEYS = new TextAttributesKey[]{H1_HEADER};
    private static final TextAttributesKey[] H1_TEXT_KEYS = new TextAttributesKey[]{H1_TEXT};
    private static final TextAttributesKey[] H2_HEADER_KEYS = new TextAttributesKey[]{H2_HEADER};
    private static final TextAttributesKey[] H2_TEXT_KEYS = new TextAttributesKey[]{H2_TEXT};
    private static final TextAttributesKey[] H3_HEADER_KEYS = new TextAttributesKey[]{H3_HEADER};
    private static final TextAttributesKey[] H3_TEXT_KEYS = new TextAttributesKey[]{H3_TEXT};
    private static final TextAttributesKey[] QUOTE_HEADER_KEYS = new TextAttributesKey[]{QUOTE_HEADER};
    private static final TextAttributesKey[] QUOTE_TEXT_KEYS = new TextAttributesKey[]{QUOTE_TEXT};
    private static final TextAttributesKey[] ULIST_HEADER_KEYS = new TextAttributesKey[]{ULIST_HEADER};
    private static final TextAttributesKey[] ULIST_TEXT_KEYS = new TextAttributesKey[]{ULIST_TEXT};
    private static final TextAttributesKey[] LINK_HEADER_KEYS = new TextAttributesKey[]{LINK_HEADER};
    private static final TextAttributesKey[] LINK_URL_KEYS = new TextAttributesKey[]{LINK_URL};
    private static final TextAttributesKey[] LINK_TEXT_KEYS = new TextAttributesKey[]{LINK_TEXT};
    private static final TextAttributesKey[] PLAIN_TEXT_KEYS = new TextAttributesKey[]{PLAIN_TEXT};
    private static final TextAttributesKey[] PRE_HEADER_KEYS = new TextAttributesKey[]{PRE_HEADER};
    private static final TextAttributesKey[] PRE_TEXT_KEYS = new TextAttributesKey[]{PRE_TEXT};
    private static final TextAttributesKey[] PRE_ALT_KEYS = new TextAttributesKey[]{PRE_ALT};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new GeminiLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        System.out.println(tokenType);

        if (tokenType.equals(GeminiTypes.H1_HEADER)) {
            return H1_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.H1_TEXT)) {
            return H1_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.H2_HEADER)) {
            return H2_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.H2_TEXT)) {
            return H2_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.H3_HEADER)) {
            return H3_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.H3_TEXT)) {
            return H3_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.QUOTE_HEADER)) {
            return QUOTE_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.QUOTE_TEXT)) {
            return QUOTE_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.ULIST_HEADER)) {
            return ULIST_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.ULIST_TEXT)) {
            return ULIST_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.LINK_HEADER)) {
            return LINK_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.LINK_TEXT)) {
            return LINK_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.LINK_URL)) {
            return LINK_URL_KEYS;
        }
        if (tokenType.equals(GeminiTypes.PLAIN_HEADER) || tokenType.equals(GeminiTypes.PLAIN_TEXT)) {
            return PLAIN_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.PRE_HEADER) || tokenType.equals(GeminiTypes.PRE_FOOTER)) {
            return PRE_HEADER_KEYS;
        }
        if (tokenType.equals(GeminiTypes.PRE_TEXT)) {
            return PRE_TEXT_KEYS;
        }
        if (tokenType.equals(GeminiTypes.PRE_ALT)) {
            return PRE_ALT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}