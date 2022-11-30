// This is a generated file. Not intended for manual editing.
package com.github.michaellazar.gemini_plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GeminiLine extends PsiElement {

  @Nullable
  GeminiH1 getH1();

  @Nullable
  GeminiH2 getH2();

  @Nullable
  GeminiH3 getH3();

  @Nullable
  GeminiLink getLink();

  @Nullable
  GeminiPlaintext getPlaintext();

  @Nullable
  GeminiPre getPre();

  @Nullable
  GeminiQuote getQuote();

  @Nullable
  GeminiUlist getUlist();

}
