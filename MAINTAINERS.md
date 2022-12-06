# Maintainers

Some development notes for myself...

### Tutorial

This plugin was created following the steps in the [Simple Language Support Tutorial](https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html).

### Making changes to the lexer/parser

1. Delete `src/main/gen`
2. Edit `Gemini.flex` file
   1. Right click -> "Run JFlex Generator"
3. Edit `Gemini.bnf` file
   1. Right click -> "Generate Parser Code"
4. Go to the top toolbar, "Run Plugin"

Generated types are placed in the `GeminiTypes` file.

- The syntax highlighter uses lexer tokens
- The spell checker uses parser tokens
- The folding builder uses parser tokens

### Downloading the plugin

The compiled (unsigned) plugin can be downloaded as an artifact from the GitHub action build workflow.

### Icons

The rocket SVG icon was downloaded as a public domain image and resized to 80x80.

The gemini file SVG was created by modifying the markdown icon using Inkscape.

https://jetbrains.design/intellij/resources/icons_list/

### Publishing a release

1. Make sure the `[Unreleased]` section in the changelog includes all changes.
2. Update the `pluginVersion` in the `gradle.properties` file.
3. Commit changes and push to main branch.
4. Navigate to the [releases](https://github.com/michael-lazar/gemini-intellij-plugin/releases/) page.
5. Find the draft release -> "Edit" -> "Publish".
6. Wait for the release action to finish running.
7. Merge the changelog PR.
