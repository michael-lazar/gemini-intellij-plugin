package com.github.michaellazar.gemini_plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.github.michaellazar.gemini_plugin.GeminiLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GeminiTokenType extends IElementType {

    public GeminiTokenType(@NotNull @NonNls String debugName) {
        super(debugName, GeminiLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "GeminiTokenType." + super.toString();
    }

}