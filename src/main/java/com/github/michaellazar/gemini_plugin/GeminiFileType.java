package com.github.michaellazar.gemini_plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GeminiFileType extends LanguageFileType {

    public static final GeminiFileType INSTANCE = new GeminiFileType();

    private GeminiFileType() {
        super(GeminiLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Gemini File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Gemini markup file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "gmi";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return GeminiIcons.FILE;
    }

}