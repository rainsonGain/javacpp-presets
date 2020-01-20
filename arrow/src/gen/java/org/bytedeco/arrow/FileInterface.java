// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::io") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FileInterface extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileInterface(Pointer p) { super(p); }


  /** \brief Close the stream cleanly
   * 
   *  For writable streams, this will attempt to flush any pending data
   *  before releasing the underlying resource.
   * 
   *  After Close() is called, closed() returns true and the stream is not
   *  available for further operations. */
  
  ///
  ///
  public native @ByVal Status Close();

  /** \brief Close the stream abruptly
   * 
   *  This method does not guarantee that any pending data is flushed.
   *  It merely releases any underlying resource used by the stream for
   *  its operation.
   * 
   *  After Abort() is called, closed() returns true and the stream is not
   *  available for further operations. */
  public native @ByVal Status Abort();

  /** \brief Return the position in this stream */
  public native @ByVal Status Tell(@Cast("int64_t*") LongPointer _position);
  public native @ByVal Status Tell(@Cast("int64_t*") LongBuffer _position);
  public native @ByVal Status Tell(@Cast("int64_t*") long[] _position);

  /** \brief Return whether the stream is closed */
  public native @Cast("bool") boolean closed();

  public native FileMode.type mode();
}
