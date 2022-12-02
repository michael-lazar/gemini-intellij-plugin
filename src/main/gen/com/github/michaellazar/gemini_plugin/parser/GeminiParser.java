// This is a generated file. Not intended for manual editing.
package com.github.michaellazar.gemini_plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.michaellazar.gemini_plugin.psi.GeminiTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GeminiParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return geminiFile(b, l + 1);
  }

  /* ********************************************************** */
  // line*
  static boolean geminiFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geminiFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!line(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "geminiFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // H1_HEADER H1_TEXT?
  public static boolean h1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h1")) return false;
    if (!nextTokenIs(b, H1_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, H1_HEADER);
    r = r && h1_1(b, l + 1);
    exit_section_(b, m, H_1, r);
    return r;
  }

  // H1_TEXT?
  private static boolean h1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h1_1")) return false;
    consumeToken(b, H1_TEXT);
    return true;
  }

  /* ********************************************************** */
  // H2_HEADER H2_TEXT?
  public static boolean h2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h2")) return false;
    if (!nextTokenIs(b, H2_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, H2_HEADER);
    r = r && h2_1(b, l + 1);
    exit_section_(b, m, H_2, r);
    return r;
  }

  // H2_TEXT?
  private static boolean h2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h2_1")) return false;
    consumeToken(b, H2_TEXT);
    return true;
  }

  /* ********************************************************** */
  // H3_HEADER H3_TEXT?
  public static boolean h3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h3")) return false;
    if (!nextTokenIs(b, H3_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, H3_HEADER);
    r = r && h3_1(b, l + 1);
    exit_section_(b, m, H_3, r);
    return r;
  }

  // H3_TEXT?
  private static boolean h3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h3_1")) return false;
    consumeToken(b, H3_TEXT);
    return true;
  }

  /* ********************************************************** */
  // h3|h2|h1|quote|ulist|link|pre|plaintext
  public static boolean line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINE, "<line>");
    r = h3(b, l + 1);
    if (!r) r = h2(b, l + 1);
    if (!r) r = h1(b, l + 1);
    if (!r) r = quote(b, l + 1);
    if (!r) r = ulist(b, l + 1);
    if (!r) r = link(b, l + 1);
    if (!r) r = pre(b, l + 1);
    if (!r) r = plaintext(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LINK_HEADER LINK_URL LINK_TEXT?
  public static boolean link(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link")) return false;
    if (!nextTokenIs(b, LINK_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LINK_HEADER, LINK_URL);
    r = r && link_2(b, l + 1);
    exit_section_(b, m, LINK, r);
    return r;
  }

  // LINK_TEXT?
  private static boolean link_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "link_2")) return false;
    consumeToken(b, LINK_TEXT);
    return true;
  }

  /* ********************************************************** */
  // PLAIN_HEADER PLAIN_TEXT?
  public static boolean plaintext(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plaintext")) return false;
    if (!nextTokenIs(b, PLAIN_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLAIN_HEADER);
    r = r && plaintext_1(b, l + 1);
    exit_section_(b, m, PLAINTEXT, r);
    return r;
  }

  // PLAIN_TEXT?
  private static boolean plaintext_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plaintext_1")) return false;
    consumeToken(b, PLAIN_TEXT);
    return true;
  }

  /* ********************************************************** */
  // PRE_HEADER PRE_ALT? PRE_TEXT* PRE_FOOTER?
  public static boolean pre(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre")) return false;
    if (!nextTokenIs(b, PRE_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PRE_HEADER);
    r = r && pre_1(b, l + 1);
    r = r && pre_2(b, l + 1);
    r = r && pre_3(b, l + 1);
    exit_section_(b, m, PRE, r);
    return r;
  }

  // PRE_ALT?
  private static boolean pre_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_1")) return false;
    consumeToken(b, PRE_ALT);
    return true;
  }

  // PRE_TEXT*
  private static boolean pre_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, PRE_TEXT)) break;
      if (!empty_element_parsed_guard_(b, "pre_2", c)) break;
    }
    return true;
  }

  // PRE_FOOTER?
  private static boolean pre_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pre_3")) return false;
    consumeToken(b, PRE_FOOTER);
    return true;
  }

  /* ********************************************************** */
  // QUOTE_HEADER QUOTE_TEXT?
  public static boolean quote(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quote")) return false;
    if (!nextTokenIs(b, QUOTE_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE_HEADER);
    r = r && quote_1(b, l + 1);
    exit_section_(b, m, QUOTE, r);
    return r;
  }

  // QUOTE_TEXT?
  private static boolean quote_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quote_1")) return false;
    consumeToken(b, QUOTE_TEXT);
    return true;
  }

  /* ********************************************************** */
  // ULIST_HEADER ULIST_TEXT?
  public static boolean ulist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ulist")) return false;
    if (!nextTokenIs(b, ULIST_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ULIST_HEADER);
    r = r && ulist_1(b, l + 1);
    exit_section_(b, m, ULIST, r);
    return r;
  }

  // ULIST_TEXT?
  private static boolean ulist_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ulist_1")) return false;
    consumeToken(b, ULIST_TEXT);
    return true;
  }

}
