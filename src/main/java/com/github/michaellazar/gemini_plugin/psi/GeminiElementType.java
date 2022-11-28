// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.michaellazar.gemini_plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.github.michaellazar.gemini_plugin.GeminiLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class GeminiElementType extends IElementType {

    public GeminiElementType(@NotNull @NonNls String debugName) {
        super(debugName, GeminiLanguage.INSTANCE);
    }

}