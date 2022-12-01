package com.github.michaellazar.gemini_plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.michaellazar.gemini_plugin.psi.GeminiPre;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GeminiFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        Collection<GeminiPre> geminiPres = PsiTreeUtil.findChildrenOfType(root, GeminiPre.class);

        for (final GeminiPre geminiPre : geminiPres) {
            descriptors.add(
                    new FoldingDescriptor(
                            geminiPre.getNode(),
                            new TextRange(
                                    geminiPre.getTextRange().getStartOffset(),
                                    geminiPre.getTextRange().getEndOffset()
                            )
                    )
            );
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getPsi() instanceof GeminiPre) {
            String elementText = StringUtil.shortenTextWithEllipsis(node.getText(), 30, 5);
            return "pre: ".concat(elementText);
        }
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

}