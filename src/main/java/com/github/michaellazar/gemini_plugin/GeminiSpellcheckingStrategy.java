package com.github.michaellazar.gemini_plugin;

import com.intellij.psi.PsiElement;
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import com.github.michaellazar.gemini_plugin.psi.*;
import org.jetbrains.annotations.NotNull;

public class GeminiSpellcheckingStrategy extends SpellcheckingStrategy {

    @Override
    public @NotNull Tokenizer<?> getTokenizer(PsiElement element) {
        if (element instanceof GeminiPlaintext) {
            return TEXT_TOKENIZER;
        }
        if (element instanceof GeminiPre) {
            // Skip pre blocks because they often contain ascii art, code, etc
            return EMPTY_TOKENIZER;
        }
        if (element instanceof GeminiDescription) {
            return TEXT_TOKENIZER;
        }
        return EMPTY_TOKENIZER;
    }
}