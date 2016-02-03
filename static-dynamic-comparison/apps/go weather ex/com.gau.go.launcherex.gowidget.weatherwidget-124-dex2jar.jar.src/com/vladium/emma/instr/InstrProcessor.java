package com.vladium.emma.instr;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.Processor;
import com.vladium.emma.filter.IInclExclFilter;
import com.vladium.emma.filter.IInclExclFilter.Factory;
import com.vladium.util.Files;
import com.vladium.util.IPathEnumerator.IPathHandler;
import java.io.File;

public abstract class InstrProcessor
  extends Processor
  implements IPathEnumerator.IPathHandler
{
  protected static final String CLASSES = "classes";
  public static final String DEFAULT_DO_SUID_COMPENSATION = "true";
  public static final String DEFAULT_EXCLUDE_BRIDGE_METHODS = "true";
  public static final String DEFAULT_EXCLUDE_SYNTHETIC_METHODS = "true";
  protected static final boolean IN_CLASSES = true;
  protected static final boolean IN_LIB = false;
  protected static final String LIB = "lib";
  public static final String PROPERTY_DO_SUID_COMPENSATION = "instr.do_suid_compensation";
  public static final String PROPERTY_EXCLUDE_BRIDGE_METHODS = "instr.exclude_bridge_methods";
  public static final String PROPERTY_EXCLUDE_SYNTHETIC_METHODS = "instr.exclude_synthetic_methods";
  protected boolean m_canonical;
  protected int m_classCopies;
  protected int m_classInstrs;
  protected IInclExclFilter m_coverageFilter;
  protected boolean m_dependsMode = true;
  protected File[] m_instrPath;
  protected File m_mdataOutFile;
  protected Boolean m_mdataOutMerge;
  protected File m_outDir;
  protected OutMode m_outMode;
  
  public static InstrProcessor create()
  {
    return new InstrProcessorST();
  }
  
  protected final void createDir(File paramFile, boolean paramBoolean)
    throws EMMARuntimeException
  {
    if (paramBoolean)
    {
      if ((!paramFile.mkdirs()) && (!paramFile.exists())) {
        throw new EMMARuntimeException("OUT_MKDIR_FAILURE", new Object[] { paramFile.getAbsolutePath() });
      }
    }
    else if ((!paramFile.mkdir()) && (!paramFile.exists())) {
      throw new EMMARuntimeException("OUT_MKDIR_FAILURE", new Object[] { paramFile.getAbsolutePath() });
    }
  }
  
  protected final File getFullOutDir(File paramFile, boolean paramBoolean)
  {
    if (this.m_outMode == OutMode.OUT_MODE_OVERWRITE) {
      return paramFile;
    }
    if (this.m_outMode == OutMode.OUT_MODE_COPY) {
      return this.m_outDir;
    }
    if (this.m_outMode == OutMode.OUT_MODE_FULLCOPY)
    {
      if (paramBoolean) {}
      for (paramFile = Files.newFile(this.m_outDir, "classes");; paramFile = Files.newFile(this.m_outDir, "lib")) {
        return paramFile;
      }
    }
    throw new IllegalStateException("invalid out mode state: " + this.m_outMode);
  }
  
  protected final File getFullOutFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    return Files.newFile(getFullOutDir(paramFile1, paramBoolean), paramFile2.getPath());
  }
  
  protected void reset()
  {
    this.m_classInstrs = 0;
    this.m_classCopies = 0;
  }
  
  public final void setDependsMode(boolean paramBoolean)
  {
    try
    {
      this.m_dependsMode = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setInclExclFilter(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      try
      {
        this.m_coverageFilter = null;
        return;
      }
      finally {}
      this.m_coverageFilter = IInclExclFilter.Factory.create(paramArrayOfString);
    }
  }
  
  public final void setInstrOutDir(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        this.m_outDir = null;
        return;
      }
      finally {}
      paramString = new File(paramString);
      if ((paramString.exists()) && (!paramString.isDirectory())) {
        throw new IllegalArgumentException("not a directory: [" + paramString.getAbsolutePath() + "]");
      }
      this.m_outDir = paramString;
    }
  }
  
  /* Error */
  public final void setInstrPath(String[] paramArrayOfString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +8 -> 11
    //   6: aload_1
    //   7: arraylength
    //   8: ifne +18 -> 26
    //   11: aload_0
    //   12: getstatic 174	com/vladium/util/IConstants:EMPTY_FILE_ARRAY	[Ljava/io/File;
    //   15: putfield 176	com/vladium/emma/instr/InstrProcessor:m_instrPath	[Ljava/io/File;
    //   18: aload_0
    //   19: iload_2
    //   20: putfield 178	com/vladium/emma/instr/InstrProcessor:m_canonical	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: aload_1
    //   28: iload_2
    //   29: invokestatic 182	com/vladium/util/Files:pathToFiles	([Ljava/lang/String;Z)[Ljava/io/File;
    //   32: putfield 176	com/vladium/emma/instr/InstrProcessor:m_instrPath	[Ljava/io/File;
    //   35: goto -17 -> 18
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	InstrProcessor
    //   0	43	1	paramArrayOfString	String[]
    //   0	43	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	38	finally
    //   11	18	38	finally
    //   18	23	38	finally
    //   26	35	38	finally
  }
  
  public final void setMetaOutFile(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        this.m_mdataOutFile = null;
        return;
      }
      finally {}
      paramString = new File(paramString);
      if ((paramString.exists()) && (!paramString.isFile())) {
        throw new IllegalArgumentException("not a file: [" + paramString.getAbsolutePath() + "]");
      }
      this.m_mdataOutFile = paramString;
    }
  }
  
  public final void setMetaOutMerge(Boolean paramBoolean)
  {
    try
    {
      this.m_mdataOutMerge = paramBoolean;
      return;
    }
    finally
    {
      paramBoolean = finally;
      throw paramBoolean;
    }
  }
  
  public final void setOutMode(OutMode paramOutMode)
  {
    if (paramOutMode == null) {
      try
      {
        throw new IllegalArgumentException("null input: mode");
      }
      finally {}
    }
    this.m_outMode = paramOutMode;
  }
  
  protected void validateState()
  {
    super.validateState();
    if ((this.m_instrPath == null) || (this.m_instrPath.length == 0)) {
      throw new IllegalStateException("instrumentation path not set");
    }
    if (this.m_outMode == null) {
      throw new IllegalStateException("output mode not set");
    }
    if (this.m_outMode != OutMode.OUT_MODE_OVERWRITE)
    {
      if (this.m_outDir == null) {
        throw new IllegalStateException("output directory not set");
      }
      File localFile = Files.canonicalizeFile(this.m_outDir);
      Object localObject1;
      int j;
      if (this.m_canonical)
      {
        localObject1 = this.m_instrPath;
        j = localObject1.length;
      }
      label206:
      for (Object localObject2 = localFile;; localObject2 = ((File)localObject2).getParentFile())
      {
        if (localObject2 == null) {
          return;
        }
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label206;
          }
          if (((File)localObject2).equals(localObject1[i]))
          {
            throw new IllegalStateException("output directory [" + localFile + "] cannot be one of the instrumentation path directories (or a child thereof)");
            localObject2 = new File[this.m_instrPath.length];
            i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= localObject2.length) {
                break;
              }
              localObject2[i] = Files.canonicalizeFile(this.m_instrPath[i]);
              i += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public static final class OutMode
  {
    public static final OutMode OUT_MODE_COPY = new OutMode("copy");
    public static final OutMode OUT_MODE_FULLCOPY = new OutMode("fullcopy");
    public static final OutMode OUT_MODE_OVERWRITE = new OutMode("overwrite");
    private final String m_name;
    
    private OutMode(String paramString)
    {
      this.m_name = paramString;
    }
    
    public static OutMode nameToMode(String paramString)
    {
      if (OUT_MODE_COPY.m_name.equals(paramString)) {
        return OUT_MODE_COPY;
      }
      if (OUT_MODE_FULLCOPY.m_name.equals(paramString)) {
        return OUT_MODE_FULLCOPY;
      }
      if (OUT_MODE_OVERWRITE.m_name.equals(paramString)) {
        return OUT_MODE_OVERWRITE;
      }
      return null;
    }
    
    public String getName()
    {
      return this.m_name;
    }
    
    public String toString()
    {
      return this.m_name;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/instr/InstrProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */