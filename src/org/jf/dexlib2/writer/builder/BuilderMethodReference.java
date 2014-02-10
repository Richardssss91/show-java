/*
 * Copyright 2013, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;

import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.writer.DexWriter;

public class BuilderMethodReference extends BaseMethodReference implements BuilderReference {
    @Nonnull final BuilderTypeReference definingClass;
    @Nonnull final BuilderStringReference name;
    @Nonnull final BuilderProtoReference proto;
    int index = DexWriter.NO_INDEX;

    BuilderMethodReference(@Nonnull BuilderTypeReference definingClass,
                           @Nonnull BuilderStringReference name,
                           @Nonnull BuilderProtoReference proto) {
        this.definingClass = definingClass;
        this.name = name;
        this.proto = proto;
    }

    @Nonnull @Override public String getDefiningClass() {
        return definingClass.getType();
    }

    @Nonnull @Override public String getName() {
        return this.name.getString();
    }

    @Nonnull @Override public BuilderTypeList getParameterTypes() {
        return proto.parameterTypes;
    }

    @Nonnull @Override public String getReturnType() {
        return proto.returnType.getType();
    }

    @Override public int getIndex() {
        return index;
    }

    @Override public void setIndex(int index) {
        this.index = index;
    }
}
