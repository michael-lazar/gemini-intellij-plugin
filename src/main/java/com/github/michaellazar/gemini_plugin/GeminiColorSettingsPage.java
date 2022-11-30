package com.github.michaellazar.gemini_plugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class GeminiColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Header 1//Header 1 marker", GeminiSyntaxHighlighter.H1_HEADER),
            new AttributesDescriptor("Header 1//Header 1", GeminiSyntaxHighlighter.H1_TEXT),
            new AttributesDescriptor("Header 2//Header 2 marker", GeminiSyntaxHighlighter.H2_HEADER),
            new AttributesDescriptor("Header 2//Header 2", GeminiSyntaxHighlighter.H2_TEXT),
            new AttributesDescriptor("Header 3//Header 3 marker", GeminiSyntaxHighlighter.H3_HEADER),
            new AttributesDescriptor("Header 3//Header 3", GeminiSyntaxHighlighter.H3_TEXT),
            new AttributesDescriptor("Blockquote//Blockquote marker", GeminiSyntaxHighlighter.QUOTE_HEADER),
            new AttributesDescriptor("Blockquote//Blockquote", GeminiSyntaxHighlighter.QUOTE_TEXT),
            new AttributesDescriptor("Unordered list//Unordered list marker", GeminiSyntaxHighlighter.ULIST_HEADER),
            new AttributesDescriptor("Unordered list//Unordered list", GeminiSyntaxHighlighter.ULIST_TEXT),
            new AttributesDescriptor("Link//Link marker", GeminiSyntaxHighlighter.LINK_HEADER),
            new AttributesDescriptor("Link//Link URL", GeminiSyntaxHighlighter.LINK_URL),
            new AttributesDescriptor("Link//Link text", GeminiSyntaxHighlighter.LINK_TEXT),
            new AttributesDescriptor("Preformatted//Preformatted marker", GeminiSyntaxHighlighter.PRE_HEADER),
            new AttributesDescriptor("Preformatted//Preformatted alt-text", GeminiSyntaxHighlighter.PRE_ALT),
            new AttributesDescriptor("Preformatted//Preformatted", GeminiSyntaxHighlighter.PRE_TEXT),
            new AttributesDescriptor("Plain text", GeminiSyntaxHighlighter.PLAIN_TEXT),
            new AttributesDescriptor("Bad value", GeminiSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return GeminiIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new GeminiSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "# text/gemini test file\n" +
                "\n" +
                "This is test file that demonstrates the various text/gemini line types.\n" +
                "\n" +
                "## Formatting\n" +
                "\n" +
                "> quote line\n" +
                "> quote line\n" +
                "\n" +
                "* bullet list item\n" +
                "* bullet list item\n" +
                "\n" +
                "```alt text\n" +
                "preformatted text block\n" +
                "```\n" +
                "\n" +
                "## Links\n" +
                "\n" +
                "### Internal\n" +
                "\n" +
                "=> ./ This is a relative URL\n" +
                "=> /test.gmi This is an absolute URL\n" +
                "\n" +
                "### External\n" +
                "\n" +
                "=> gemini://gemini.circumlunar.space/\n" +
                "=> gemini://gemini.circumlunar.space/ This is an external URL\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Gemini";
    }

}