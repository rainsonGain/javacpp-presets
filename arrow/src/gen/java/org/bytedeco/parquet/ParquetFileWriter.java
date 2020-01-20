// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ParquetFileWriter extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ParquetFileWriter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ParquetFileWriter(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ParquetFileWriter position(long position) {
        return (ParquetFileWriter)super.position(position);
    }

  // Forward declare a virtual class 'Contents' to aid dependency injection and more
  // easily create test fixtures
  // An implementation of the Contents class is defined in the .cc file
  @NoOffset public static class Contents extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Contents(Pointer p) { super(p); }
  
    // Perform any cleanup associated with the file contents
    public native void Close();

    /** \note Deprecated since 1.3.0 */
    public native RowGroupWriter AppendRowGroup(@Cast("int64_t") long num_rows);

    public native RowGroupWriter AppendRowGroup();
    public native RowGroupWriter AppendBufferedRowGroup();

    public native @Cast("int64_t") long num_rows();
    public native int num_columns();
    public native int num_row_groups();

    public native @SharedPtr WriterProperties properties();

    public native @Const @SharedPtr KeyValueMetadata key_value_metadata();

    // Return const-pointer to make it clear that this object is not to be copied
    public native @Const SchemaDescriptor schema();

    public native @ByRef SchemaDescriptor schema_(); public native Contents schema_(SchemaDescriptor setter);

    /** This should be the only place this is stored. Everything else is a const reference */
    public native @Const @SharedPtr KeyValueMetadata key_value_metadata_(); public native Contents key_value_metadata_(KeyValueMetadata setter);

    public native @SharedPtr FileMetaData metadata();
    public native @SharedPtr FileMetaData file_metadata_(); public native Contents file_metadata_(FileMetaData setter);
  }

  public ParquetFileWriter() { super((Pointer)null); allocate(); }
  private native void allocate();

  public static native @UniquePtr ParquetFileWriter Open(
        @SharedPtr org.bytedeco.arrow.OutputStream sink,
        @SharedPtr GroupNode schema,
        @SharedPtr WriterProperties properties/*=parquet::default_writer_properties()*/,
        @Const @SharedPtr KeyValueMetadata key_value_metadata/*=nullptr*/);
  public static native @UniquePtr ParquetFileWriter Open(
        @SharedPtr org.bytedeco.arrow.OutputStream sink,
        @SharedPtr GroupNode schema);

  public static native @UniquePtr ParquetFileWriter Open(
        @SharedPtr org.bytedeco.parquet.OutputStream sink,
        @SharedPtr GroupNode schema,
        @SharedPtr WriterProperties properties/*=parquet::default_writer_properties()*/,
        @Const @SharedPtr KeyValueMetadata key_value_metadata/*=nullptr*/);
  public static native @UniquePtr ParquetFileWriter Open(
        @SharedPtr org.bytedeco.parquet.OutputStream sink,
        @SharedPtr GroupNode schema);

  public native void Open(@UniquePtr Contents contents);
  public native void Close();

  // Construct a RowGroupWriter for the indicated number of rows.
  //
  // Ownership is solely within the ParquetFileWriter. The RowGroupWriter is only valid
  // until the next call to AppendRowGroup or AppendBufferedRowGroup or Close.
  // @param num_rows The number of rows that are stored in the new RowGroup
  //
  // \deprecated Since 1.3.0
  
  ///
  public native RowGroupWriter AppendRowGroup(@Cast("int64_t") long num_rows);

  /** Construct a RowGroupWriter with an arbitrary number of rows.
   * 
   *  Ownership is solely within the ParquetFileWriter. The RowGroupWriter is only valid
   *  until the next call to AppendRowGroup or AppendBufferedRowGroup or Close. */
  
  ///
  public native RowGroupWriter AppendRowGroup();

  /** Construct a RowGroupWriter that buffers all the values until the RowGroup is ready.
   *  Use this if you want to write a RowGroup based on a certain size
   * 
   *  Ownership is solely within the ParquetFileWriter. The RowGroupWriter is only valid
   *  until the next call to AppendRowGroup or AppendBufferedRowGroup or Close. */
  
  ///
  public native RowGroupWriter AppendBufferedRowGroup();

  /** Number of columns.
   * 
   *  This number is fixed during the lifetime of the writer as it is determined via
   *  the schema. */
  
  ///
  public native int num_columns();

  /** Number of rows in the yet started RowGroups.
   * 
   *  Changes on the addition of a new RowGroup. */
  public native @Cast("int64_t") long num_rows();

  /** Number of started RowGroups. */
  public native int num_row_groups();

  /** Configuration passed to the writer, e.g. the used Parquet format version. */
  public native @SharedPtr WriterProperties properties();

  /** Returns the file schema descriptor */
  public native @Const SchemaDescriptor schema();

  /** Returns a column descriptor in schema */
  public native @Const ColumnDescriptor descr(int i);

  /** Returns the file custom metadata */
  public native @Const @SharedPtr KeyValueMetadata key_value_metadata();

  /** Returns the file metadata, only available after calling Close(). */
  public native @SharedPtr FileMetaData metadata();
}
