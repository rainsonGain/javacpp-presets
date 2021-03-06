// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::fs::internal") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DirInfo extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public DirInfo() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DirInfo(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DirInfo(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public DirInfo position(long position) {
        return (DirInfo)super.position(position);
    }

  public native @StdString String full_path(); public native DirInfo full_path(String setter);
  public native @ByRef @Cast("arrow::fs::TimePoint*") Pointer mtime(); public native DirInfo mtime(Pointer setter);

  public native @Cast("bool") @Name("operator ==") boolean equals(@Const @ByRef DirInfo other);

  
}
