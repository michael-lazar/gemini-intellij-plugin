package com.github.michaellazar.gemini_plugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.github.michaellazar.gemini_plugin.GeminiFileType;
import com.github.michaellazar.gemini_plugin.GeminiLanguage;
import org.jetbrains.annotations.NotNull;

public class GeminiFile extends PsiFileBase {

    public GeminiFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, GeminiLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return GeminiFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Gemini File";
    }

}