// This is a generated file. Not intended for manual editing.
package com.github.michaellazar.gemini_plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.michaellazar.gemini_plugin.psi.GeminiTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.michaellazar.gemini_plugin.psi.*;

public class GeminiLinkImpl extends ASTWrapperPsiElement implements GeminiLink {

  public GeminiLinkImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GeminiVisitor visitor) {
    visitor.visitLink(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GeminiVisitor) accept((GeminiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GeminiDescription getDescription() {
    return findChildByClass(GeminiDescription.class);
  }

}
