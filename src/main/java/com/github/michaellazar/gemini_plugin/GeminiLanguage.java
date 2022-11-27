package com.github.michaellazar.gemini_plugin;

import com.intellij.lang.Language;

public class GeminiLanguage extends Language {

    public static final GeminiLanguage INSTANCE = new GeminiLanguage();

    private GeminiLanguage() {
        super("Gemini");
    }

}