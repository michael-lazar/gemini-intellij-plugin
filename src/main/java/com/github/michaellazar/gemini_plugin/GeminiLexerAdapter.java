package com.github.michaellazar.gemini_plugin;

import com.intellij.lexer.FlexAdapter;

public class GeminiLexerAdapter extends FlexAdapter {

    public GeminiLexerAdapter() {
        super(new GeminiLexer(null));
    }
}

