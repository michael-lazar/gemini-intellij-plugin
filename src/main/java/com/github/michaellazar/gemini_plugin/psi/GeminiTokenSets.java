package com.github.michaellazar.gemini_plugin.psi;

import com.intellij.psi.tree.TokenSet;

public interface GeminiTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(GeminiTypes.KEY);
    TokenSet COMMENTS = TokenSet.create(GeminiTypes.COMMENT);
}