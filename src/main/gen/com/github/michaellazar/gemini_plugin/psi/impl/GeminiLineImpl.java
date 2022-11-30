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

public class GeminiLineImpl extends ASTWrapperPsiElement implements GeminiLine {

  public GeminiLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GeminiVisitor visitor) {
    visitor.visitLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GeminiVisitor) accept((GeminiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GeminiH1 getH1() {
    return findChildByClass(GeminiH1.class);
  }

  @Override
  @Nullable
  public GeminiH2 getH2() {
    return findChildByClass(GeminiH2.class);
  }

  @Override
  @Nullable
  public GeminiH3 getH3() {
    return findChildByClass(GeminiH3.class);
  }

  @Override
  @Nullable
  public GeminiLink getLink() {
    return findChildByClass(GeminiLink.class);
  }

  @Override
  @Nullable
  public GeminiPlaintext getPlaintext() {
    return findChildByClass(GeminiPlaintext.class);
  }

  @Override
  @Nullable
  public GeminiPre getPre() {
    return findChildByClass(GeminiPre.class);
  }

  @Override
  @Nullable
  public GeminiQuote getQuote() {
    return findChildByClass(GeminiQuote.class);
  }

  @Override
  @Nullable
  public GeminiUlist getUlist() {
    return findChildByClass(GeminiUlist.class);
  }

}
