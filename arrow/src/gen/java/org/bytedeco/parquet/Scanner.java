// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class Scanner extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Scanner(Pointer p) { super(p); }


  public static native @SharedPtr Scanner Make(
        @SharedPtr ColumnReader col_reader,
        @Cast("int64_t") long batch_size/*=parquet::DEFAULT_SCANNER_BATCH_SIZE*/,
        MemoryPool pool/*=arrow::default_memory_pool()*/);
  public static native @SharedPtr Scanner Make(
        @SharedPtr ColumnReader col_reader);

  public native void PrintNext(@Cast("std::ostream*") @ByRef Pointer out, int width, @Cast("bool") boolean with_levels/*=false*/);
  public native void PrintNext(@Cast("std::ostream*") @ByRef Pointer out, int width);

  public native @Cast("bool") boolean HasNext();

  public native @Const ColumnDescriptor descr();

  public native @Cast("int64_t") long batch_size();

  public native void SetBatchSize(@Cast("int64_t") long batch_size);
}
