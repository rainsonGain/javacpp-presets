// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A file interface that uses memory-mapped files for memory interactions
 * 
 *  This implementation supports zero-copy reads. The same class is used
 *  for both reading and writing.
 * 
 *  If opening a file in a writable mode, it is not truncated first as with
 *  FileOutputStream. */
@Namespace("arrow::io") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class MemoryMappedFile extends ReadWriteFileInterface {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MemoryMappedFile(Pointer p) { super(p); }


  /** Create new file with indicated size, return in read/write mode */
  public static native @ByVal Status Create(@StdString String path, @Cast("int64_t") long size,
                         @SharedPtr MemoryMappedFile out);
  public static native @ByVal Status Create(@StdString BytePointer path, @Cast("int64_t") long size,
                         @SharedPtr MemoryMappedFile out);

  // mmap() with whole file
  public static native @ByVal Status Open(@StdString String path, FileMode.type mode,
                       @SharedPtr MemoryMappedFile out);
  public static native @ByVal Status Open(@StdString BytePointer path, @Cast("arrow::io::FileMode::type") int mode,
                       @SharedPtr MemoryMappedFile out);

  // mmap() with a region of file, the offset must be a multiple of the page size
  public static native @ByVal Status Open(@StdString String path, FileMode.type mode, @Cast("const int64_t") long offset,
                       @Cast("const int64_t") long length, @SharedPtr MemoryMappedFile out);
  public static native @ByVal Status Open(@StdString BytePointer path, @Cast("arrow::io::FileMode::type") int mode, @Cast("const int64_t") long offset,
                       @Cast("const int64_t") long length, @SharedPtr MemoryMappedFile out);

  public native @ByVal Status Close();

  public native @Cast("bool") boolean closed();

  public native @ByVal Status Tell(@Cast("int64_t*") LongPointer _position);
  public native @ByVal Status Tell(@Cast("int64_t*") LongBuffer _position);
  public native @ByVal Status Tell(@Cast("int64_t*") long[] _position);

  public native @ByVal Status Seek(@Cast("int64_t") long _position);

  // Required by RandomAccessFile, copies memory into out. Not thread-safe
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @Cast("int64_t*") LongPointer bytes_read, Pointer out);
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @Cast("int64_t*") LongBuffer bytes_read, Pointer out);
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @Cast("int64_t*") long[] bytes_read, Pointer out);

  // Zero copy read, moves position pointer. Not thread-safe
  public native @ByVal Status Read(@Cast("int64_t") long nbytes, @SharedPtr ArrowBuffer out);

  // Zero-copy read, leaves position unchanged. Acquires a reader lock
  // for the duration of slice creation (typically very short). Is thread-safe.
  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @SharedPtr ArrowBuffer out);

  // Raw copy of the memory at specified position. Thread-safe, but
  // locks out other readers for the duration of memcpy. Prefer the
  // zero copy method
  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @Cast("int64_t*") LongPointer bytes_read,
                  Pointer out);
  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @Cast("int64_t*") LongBuffer bytes_read,
                  Pointer out);
  public native @ByVal Status ReadAt(@Cast("int64_t") long _position, @Cast("int64_t") long nbytes, @Cast("int64_t*") long[] bytes_read,
                  Pointer out);

  public native @Cast("bool") boolean supports_zero_copy();

  /** Write data at the current position in the file. Thread-safe */
  public native @ByVal Status Write(@Const Pointer data, @Cast("int64_t") long nbytes);
  /** \cond FALSE */
  /** \endcond
   <p>
   *  Set the size of the map to new_size. */
  public native @ByVal Status Resize(@Cast("int64_t") long new_size);

  /** Write data at a particular position in the file. Thread-safe */
  public native @ByVal Status WriteAt(@Cast("int64_t") long _position, @Const Pointer data, @Cast("int64_t") long nbytes);

  // @return: the size in bytes of the memory source

  // @return: the size in bytes of the memory source
  public native @ByVal Status GetSize(@Cast("int64_t*") LongPointer size);
  public native @ByVal Status GetSize(@Cast("int64_t*") LongBuffer size);
  public native @ByVal Status GetSize(@Cast("int64_t*") long[] size);

  public native int file_descriptor();
}
