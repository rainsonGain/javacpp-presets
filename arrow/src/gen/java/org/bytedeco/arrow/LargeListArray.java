// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


/** Concrete Array class for large list data (with 64-bit offsets) */
@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class LargeListArray extends BaseLargeListArray {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LargeListArray(Pointer p) { super(p); }

  public LargeListArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data) { super((Pointer)null); allocate(data); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::ArrayData>"}) ArrayData data);

  
  ///
  ///
  public LargeListArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
                   @Const @SharedPtr @ByRef ArrowBuffer value_offsets,
                   @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values,
                   @Const @SharedPtr @ByRef(nullValue = "std::shared_ptr<arrow::Buffer>(nullptr)") ArrowBuffer null_bitmap,
                   @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/) { super((Pointer)null); allocate(type, length, value_offsets, values, null_bitmap, null_count, offset); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
                   @Const @SharedPtr @ByRef ArrowBuffer value_offsets,
                   @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values,
                   @Const @SharedPtr @ByRef(nullValue = "std::shared_ptr<arrow::Buffer>(nullptr)") ArrowBuffer null_bitmap,
                   @Cast("int64_t") long null_count/*=arrow::kUnknownNullCount*/, @Cast("int64_t") long offset/*=0*/);
  public LargeListArray(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
                   @Const @SharedPtr @ByRef ArrowBuffer value_offsets,
                   @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values) { super((Pointer)null); allocate(type, length, value_offsets, values); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType type, @Cast("int64_t") long length,
                   @Const @SharedPtr @ByRef ArrowBuffer value_offsets,
                   @SharedPtr @Cast({"", "std::shared_ptr<arrow::Array>"}) Array values);

  /** \brief Construct LargeListArray from array of offsets and child value array
   * 
   *  This function does the bare minimum of validation of the offsets and
   *  input types, and will allocate a new offsets array if necessary (i.e. if
   *  the offsets contain any nulls). If the offsets do not have nulls, they
   *  are assumed to be well-formed
   * 
   *  @param offsets [in] Array containing n + 1 offsets encoding length and
   *  size. Must be of int64 type
   *  @param values [in] Array containing list values
   *  @param pool [in] MemoryPool in case new offsets array needs to be
   *  allocated because of null values
   *  @param out [out] Will have length equal to offsets.length() - 1 */
  public static native @ByVal Status FromArrays(@Const @ByRef Array offsets, @Const @ByRef Array values, MemoryPool pool,
                             @SharedPtr Array out);
}
