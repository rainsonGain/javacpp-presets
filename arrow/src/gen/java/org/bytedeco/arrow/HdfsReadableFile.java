// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::io") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class HdfsReadableFile extends RandomAccessFile {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HdfsReadableFile(Pointer p) { super(p); }


  public native @ByVal Status Close();

  public native @Cast("bool") boolean closed();

  public native @ByVal Status GetSize(@Cast("int64_t*") LongPointer size);
  public native @ByVal Status GetSize(@Cast("int64_t*") LongBuffer size);
  public native @ByVal Status GetSize(@Cast("int64_t*") long[] size);

  // NOTE: If you wish to read a particular range of a file in a multithreaded
  // context, you may prefer to use ReadAt to avoid locking issues
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @Cast("int64_t*") LongPointer bytes_read, Pointer buffer);
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @Cast("int64_t*") LongBuffer bytes_read, Pointer buffer);
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @Cast("int64_t*") long[] bytes_read, Pointer buffer);

  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @SharedPtr ArrowBuffer out);

  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @Cast("int64_t*") LongPointer bytes_read,
                  Pointer buffer);
  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @Cast("int64_t*") LongBuffer bytes_read,
                  Pointer buffer);
  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @Cast("int64_t*") long[] bytes_read,
                  Pointer buffer);

  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @SharedPtr ArrowBuffer out);

  public native @ByVal Status Seek(@Cast("int64_t") long _position);
  public native @ByVal Status Tell(@Cast("int64_t*") LongPointer _position);
  public native @ByVal Status Tell(@Cast("int64_t*") LongBuffer _position);
  public native @ByVal Status Tell(@Cast("int64_t*") long[] _position);

  
}
