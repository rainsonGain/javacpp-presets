// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


/** \brief Base class for file format implementation */
@Namespace("arrow::dataset") @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class FileFormat extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileFormat(Pointer p) { super(p); }


  /** \brief The name identifying the kind of file format */
  public native @StdString String type_name();

  /** \brief Indicate if the FileSource is supported/readable by this format. */
  public native @ByVal BoolResult IsSupported(@Const @ByRef FileSource source);

  /** \brief Return the schema of the file if possible. */
  public native @ByVal SchemaResult Inspect(@Const @ByRef FileSource source);

  /** \brief Open a file for scanning */
  public native @ByVal ScanTaskIteratorResult ScanFile(
        @Const @ByRef FileSource source, @SharedPtr ScanOptions options,
        @SharedPtr ScanContext context);

  /** \brief Open a fragment */
  public native @ByVal FragmentResult MakeFragment(
        @Const @ByRef FileSource location, @SharedPtr ScanOptions options);
}
