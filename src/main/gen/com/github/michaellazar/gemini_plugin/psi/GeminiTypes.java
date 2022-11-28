// This is a generated file. Not intended for manual editing.
package com.github.michaellazar.gemini_plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.michaellazar.gemini_plugin.psi.impl.*;

public interface GeminiTypes {

  IElementType PROPERTY = new GeminiElementType("PROPERTY");

  IElementType COMMENT = new GeminiTokenType("COMMENT");
  IElementType CRLF = new GeminiTokenType("CRLF");
  IElementType KEY = new GeminiTokenType("KEY");
  IElementType SEPARATOR = new GeminiTokenType("SEPARATOR");
  IElementType VALUE = new GeminiTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new GeminiPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
