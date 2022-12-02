// This is a generated file. Not intended for manual editing.
package com.github.michaellazar.gemini_plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.michaellazar.gemini_plugin.psi.impl.*;

public interface GeminiTypes {

  IElementType DESCRIPTION = new GeminiElementType("DESCRIPTION");
  IElementType H_1 = new GeminiElementType("H_1");
  IElementType H_2 = new GeminiElementType("H_2");
  IElementType H_3 = new GeminiElementType("H_3");
  IElementType LINE = new GeminiElementType("LINE");
  IElementType LINK = new GeminiElementType("LINK");
  IElementType PLAINTEXT = new GeminiElementType("PLAINTEXT");
  IElementType PRE = new GeminiElementType("PRE");
  IElementType QUOTE = new GeminiElementType("QUOTE");
  IElementType ULIST = new GeminiElementType("ULIST");

  IElementType H1_HEADER = new GeminiTokenType("H1_HEADER");
  IElementType H1_TEXT = new GeminiTokenType("H1_TEXT");
  IElementType H2_HEADER = new GeminiTokenType("H2_HEADER");
  IElementType H2_TEXT = new GeminiTokenType("H2_TEXT");
  IElementType H3_HEADER = new GeminiTokenType("H3_HEADER");
  IElementType H3_TEXT = new GeminiTokenType("H3_TEXT");
  IElementType LINK_HEADER = new GeminiTokenType("LINK_HEADER");
  IElementType LINK_TEXT = new GeminiTokenType("LINK_TEXT");
  IElementType LINK_URL = new GeminiTokenType("LINK_URL");
  IElementType PLAIN_HEADER = new GeminiTokenType("PLAIN_HEADER");
  IElementType PLAIN_TEXT = new GeminiTokenType("PLAIN_TEXT");
  IElementType PRE_ALT = new GeminiTokenType("PRE_ALT");
  IElementType PRE_FOOTER = new GeminiTokenType("PRE_FOOTER");
  IElementType PRE_HEADER = new GeminiTokenType("PRE_HEADER");
  IElementType PRE_TEXT = new GeminiTokenType("PRE_TEXT");
  IElementType QUOTE_HEADER = new GeminiTokenType("QUOTE_HEADER");
  IElementType QUOTE_TEXT = new GeminiTokenType("QUOTE_TEXT");
  IElementType ULIST_HEADER = new GeminiTokenType("ULIST_HEADER");
  IElementType ULIST_TEXT = new GeminiTokenType("ULIST_TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DESCRIPTION) {
        return new GeminiDescriptionImpl(node);
      }
      else if (type == H_1) {
        return new GeminiH1Impl(node);
      }
      else if (type == H_2) {
        return new GeminiH2Impl(node);
      }
      else if (type == H_3) {
        return new GeminiH3Impl(node);
      }
      else if (type == LINE) {
        return new GeminiLineImpl(node);
      }
      else if (type == LINK) {
        return new GeminiLinkImpl(node);
      }
      else if (type == PLAINTEXT) {
        return new GeminiPlaintextImpl(node);
      }
      else if (type == PRE) {
        return new GeminiPreImpl(node);
      }
      else if (type == QUOTE) {
        return new GeminiQuoteImpl(node);
      }
      else if (type == ULIST) {
        return new GeminiUlistImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
