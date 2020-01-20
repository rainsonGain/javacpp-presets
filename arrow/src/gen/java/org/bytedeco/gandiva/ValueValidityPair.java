// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;


@Namespace("gandiva") @Opaque @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class ValueValidityPair extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public ValueValidityPair() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ValueValidityPair(Pointer p) { super(p); }
}
