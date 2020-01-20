// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;


/** Represents a 128-bit decimal value along with its precision and scale.
 * 
 *  BasicDecimalScalar128 can be safely compiled to IR without references to libstdc++.
 *  This class has additional functionality on top of BasicDecimalScalar128 to deal with
 *  strings and streams. */
@Namespace("gandiva") @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class DecimalScalar128 extends BasicDecimalScalar128 {
    static { Loader.load(); }

  
    public DecimalScalar128(@Cast("int64_t") long high_bits, @Cast("uint64_t") long low_bits, int precision,
                                      int scale) { super((Pointer)null); allocate(high_bits, low_bits, precision, scale); }
    private native void allocate(@Cast("int64_t") long high_bits, @Cast("uint64_t") long low_bits, int precision,
                                      int scale);
  
    public DecimalScalar128(@Const @ByRef BasicDecimal128 value, int precision,
                                      int scale) { super((Pointer)null); allocate(value, precision, scale); }
    private native void allocate(@Const @ByRef BasicDecimal128 value, int precision,
                                      int scale);
  
    public DecimalScalar128(int precision, int scale) { super((Pointer)null); allocate(precision, scale); }
    private native void allocate(int precision, int scale);
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DecimalScalar128(Pointer p) { super(p); }


  public DecimalScalar128(@StdString String value, int precision, int scale) { super((Pointer)null); allocate(value, precision, scale); }
  private native void allocate(@StdString String value, int precision, int scale);
  public DecimalScalar128(@StdString BytePointer value, int precision, int scale) { super((Pointer)null); allocate(value, precision, scale); }
  private native void allocate(@StdString BytePointer value, int precision, int scale);

  /** \brief constructor creates a DecimalScalar128 from a BasicDecimalScalar128. */
  public DecimalScalar128(@Const @ByRef BasicDecimalScalar128 scalar) { super((Pointer)null); allocate(scalar); }
  @NoException private native void allocate(@Const @ByRef BasicDecimalScalar128 scalar);

  public native @StdString String ToString();

  
}
