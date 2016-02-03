package com.vladium.util;

import com.vladium.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

public abstract interface IPathEnumerator
{
  public abstract void enumerate()
    throws IOException;
  
  public static abstract class Factory
  {
    public static IPathEnumerator create(File[] paramArrayOfFile, boolean paramBoolean, IPathEnumerator.IPathHandler paramIPathHandler)
    {
      return new PathEnumerator(paramArrayOfFile, paramBoolean, paramIPathHandler);
    }
    
    private static final class PathEnumerator
      implements IPathEnumerator
    {
      private static final boolean IGNORE_INVALID_ENTRIES = true;
      private final boolean m_canonical;
      private File m_currentPathDir;
      private final IPathEnumerator.IPathHandler m_handler;
      private final Logger m_log;
      private final ArrayList m_path;
      private int m_pathIndex;
      private final Set m_pathSet;
      private final boolean m_processManifest;
      private boolean m_trace1;
      private boolean m_verbose;
      
      PathEnumerator(File[] paramArrayOfFile, boolean paramBoolean, IPathEnumerator.IPathHandler paramIPathHandler)
      {
        this.m_path = new ArrayList(paramArrayOfFile.length);
        int i = 0;
        while (i < paramArrayOfFile.length)
        {
          this.m_path.add(paramArrayOfFile[i]);
          i += 1;
        }
        this.m_canonical = paramBoolean;
        if (paramIPathHandler == null) {
          throw new IllegalArgumentException("null input: handler");
        }
        this.m_handler = paramIPathHandler;
        this.m_processManifest = true;
        if (this.m_processManifest)
        {
          this.m_pathSet = new HashSet(paramArrayOfFile.length);
          i = 0;
          while (i < paramArrayOfFile.length)
          {
            this.m_pathSet.add(paramArrayOfFile[i].getPath());
            i += 1;
          }
        }
        this.m_pathSet = null;
        this.m_log = Logger.getLogger();
        this.m_verbose = this.m_log.atVERBOSE();
        this.m_trace1 = this.m_log.atTRACE1();
      }
      
      /* Error */
      private void enumeratePathArchive(String paramString)
        throws IOException
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 91	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_trace1	Z
        //   4: istore 5
        //   6: new 65	java/io/File
        //   9: dup
        //   10: aload_0
        //   11: getfield 101	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_currentPathDir	Ljava/io/File;
        //   14: aload_1
        //   15: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   18: astore 9
        //   20: aconst_null
        //   21: astore 8
        //   23: aconst_null
        //   24: astore 6
        //   26: new 106	java/util/jar/JarInputStream
        //   29: dup
        //   30: new 108	java/io/BufferedInputStream
        //   33: dup
        //   34: new 110	java/io/FileInputStream
        //   37: dup
        //   38: aload 9
        //   40: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   43: ldc 114
        //   45: invokespecial 117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
        //   48: invokespecial 120	java/util/jar/JarInputStream:<init>	(Ljava/io/InputStream;)V
        //   51: astore 7
        //   53: aload_0
        //   54: getfield 56	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_handler	Lcom/vladium/util/IPathEnumerator$IPathHandler;
        //   57: astore 10
        //   59: aload 7
        //   61: invokevirtual 124	java/util/jar/JarInputStream:getManifest	()Ljava/util/jar/Manifest;
        //   64: astore 8
        //   66: aload 8
        //   68: astore 6
        //   70: aload 8
        //   72: ifnonnull +10 -> 82
        //   75: aload 9
        //   77: invokestatic 128	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:readManifestViaJarFile	(Ljava/io/File;)Ljava/util/jar/Manifest;
        //   80: astore 6
        //   82: aload 10
        //   84: aload_0
        //   85: getfield 101	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_currentPathDir	Ljava/io/File;
        //   88: new 65	java/io/File
        //   91: dup
        //   92: aload_1
        //   93: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
        //   96: aload 6
        //   98: invokeinterface 135 4 0
        //   103: aload 7
        //   105: invokevirtual 139	java/util/jar/JarInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
        //   108: astore_1
        //   109: aload_1
        //   110: ifnull +74 -> 184
        //   113: iload 5
        //   115: ifeq +39 -> 154
        //   118: aload_0
        //   119: getfield 80	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_log	Lcom/vladium/logging/Logger;
        //   122: ldc -116
        //   124: new 142	java/lang/StringBuilder
        //   127: dup
        //   128: invokespecial 143	java/lang/StringBuilder:<init>	()V
        //   131: ldc -111
        //   133: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   136: aload_1
        //   137: invokevirtual 154	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
        //   140: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: ldc -100
        //   145: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   151: invokevirtual 163	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
        //   154: aload 10
        //   156: aload 7
        //   158: aload_1
        //   159: invokeinterface 167 3 0
        //   164: aload 7
        //   166: invokevirtual 170	java/util/jar/JarInputStream:closeEntry	()V
        //   169: goto -66 -> 103
        //   172: astore_1
        //   173: aload 7
        //   175: ifnull +8 -> 183
        //   178: aload 7
        //   180: invokevirtual 173	java/util/jar/JarInputStream:close	()V
        //   183: return
        //   184: aload_0
        //   185: getfield 58	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_processManifest	Z
        //   188: ifeq +224 -> 412
        //   191: aload 6
        //   193: astore_1
        //   194: aload 6
        //   196: ifnonnull +9 -> 205
        //   199: aload 7
        //   201: invokevirtual 124	java/util/jar/JarInputStream:getManifest	()Ljava/util/jar/Manifest;
        //   204: astore_1
        //   205: aload_1
        //   206: ifnull +206 -> 412
        //   209: aload_1
        //   210: invokevirtual 179	java/util/jar/Manifest:getMainAttributes	()Ljava/util/jar/Attributes;
        //   213: astore_1
        //   214: aload_1
        //   215: ifnull +197 -> 412
        //   218: aload_1
        //   219: getstatic 185	java/util/jar/Attributes$Name:CLASS_PATH	Ljava/util/jar/Attributes$Name;
        //   222: invokevirtual 191	java/util/jar/Attributes:getValue	(Ljava/util/jar/Attributes$Name;)Ljava/lang/String;
        //   225: astore_1
        //   226: aload_1
        //   227: ifnull +185 -> 412
        //   230: new 193	java/util/StringTokenizer
        //   233: dup
        //   234: aload_1
        //   235: invokespecial 194	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
        //   238: astore 8
        //   240: iconst_1
        //   241: istore_2
        //   242: aload 8
        //   244: invokevirtual 197	java/util/StringTokenizer:hasMoreTokens	()Z
        //   247: ifeq +165 -> 412
        //   250: aload 8
        //   252: invokevirtual 200	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
        //   255: astore_1
        //   256: aload 9
        //   258: invokevirtual 204	java/io/File:getParentFile	()Ljava/io/File;
        //   261: astore 6
        //   263: aload 6
        //   265: ifnull +113 -> 378
        //   268: new 65	java/io/File
        //   271: dup
        //   272: aload 6
        //   274: aload_1
        //   275: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   278: astore_1
        //   279: aload_0
        //   280: getfield 47	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_canonical	Z
        //   283: ifeq +120 -> 403
        //   286: aload_1
        //   287: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
        //   290: invokestatic 210	com/vladium/util/Files:canonicalizePathname	(Ljava/lang/String;)Ljava/lang/String;
        //   293: astore 6
        //   295: aload_0
        //   296: getfield 63	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_pathSet	Ljava/util/Set;
        //   299: aload 6
        //   301: invokeinterface 72 2 0
        //   306: ifeq +143 -> 449
        //   309: aload_0
        //   310: getfield 86	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_verbose	Z
        //   313: ifeq +34 -> 347
        //   316: aload_0
        //   317: getfield 80	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_log	Lcom/vladium/logging/Logger;
        //   320: new 142	java/lang/StringBuilder
        //   323: dup
        //   324: invokespecial 143	java/lang/StringBuilder:<init>	()V
        //   327: ldc -44
        //   329: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   332: aload_1
        //   333: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   336: ldc -39
        //   338: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   341: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   344: invokevirtual 220	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
        //   347: aload_0
        //   348: getfield 41	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_path	Ljava/util/ArrayList;
        //   351: astore 6
        //   353: aload_0
        //   354: getfield 222	com/vladium/util/IPathEnumerator$Factory$PathEnumerator:m_pathIndex	I
        //   357: istore 4
        //   359: iload_2
        //   360: iconst_1
        //   361: iadd
        //   362: istore_3
        //   363: aload 6
        //   365: iload 4
        //   367: iload_2
        //   368: iadd
        //   369: aload_1
        //   370: invokevirtual 225	java/util/ArrayList:add	(ILjava/lang/Object;)V
        //   373: iload_3
        //   374: istore_2
        //   375: goto +74 -> 449
        //   378: new 65	java/io/File
        //   381: dup
        //   382: aload_1
        //   383: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
        //   386: astore_1
        //   387: goto -108 -> 279
        //   390: astore_1
        //   391: aload 7
        //   393: ifnull +8 -> 401
        //   396: aload 7
        //   398: invokevirtual 173	java/util/jar/JarInputStream:close	()V
        //   401: aload_1
        //   402: athrow
        //   403: aload_1
        //   404: invokevirtual 69	java/io/File:getPath	()Ljava/lang/String;
        //   407: astore 6
        //   409: goto -114 -> 295
        //   412: aload 7
        //   414: ifnull +34 -> 448
        //   417: aload 7
        //   419: invokevirtual 173	java/util/jar/JarInputStream:close	()V
        //   422: return
        //   423: astore_1
        //   424: return
        //   425: astore_1
        //   426: return
        //   427: astore 6
        //   429: goto -28 -> 401
        //   432: astore_1
        //   433: aload 8
        //   435: astore 7
        //   437: goto -46 -> 391
        //   440: astore_1
        //   441: aload 6
        //   443: astore 7
        //   445: goto -272 -> 173
        //   448: return
        //   449: goto -207 -> 242
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	452	0	this	PathEnumerator
        //   0	452	1	paramString	String
        //   241	134	2	i	int
        //   362	12	3	j	int
        //   357	12	4	k	int
        //   4	110	5	bool	boolean
        //   24	384	6	localObject1	Object
        //   427	15	6	localException	Exception
        //   51	393	7	localObject2	Object
        //   21	413	8	localObject3	Object
        //   18	239	9	localFile	File
        //   57	98	10	localIPathHandler	IPathEnumerator.IPathHandler
        // Exception table:
        //   from	to	target	type
        //   53	66	172	java/io/FileNotFoundException
        //   75	82	172	java/io/FileNotFoundException
        //   82	103	172	java/io/FileNotFoundException
        //   103	109	172	java/io/FileNotFoundException
        //   118	154	172	java/io/FileNotFoundException
        //   154	169	172	java/io/FileNotFoundException
        //   184	191	172	java/io/FileNotFoundException
        //   199	205	172	java/io/FileNotFoundException
        //   209	214	172	java/io/FileNotFoundException
        //   218	226	172	java/io/FileNotFoundException
        //   230	240	172	java/io/FileNotFoundException
        //   242	263	172	java/io/FileNotFoundException
        //   268	279	172	java/io/FileNotFoundException
        //   279	295	172	java/io/FileNotFoundException
        //   295	347	172	java/io/FileNotFoundException
        //   347	359	172	java/io/FileNotFoundException
        //   363	373	172	java/io/FileNotFoundException
        //   378	387	172	java/io/FileNotFoundException
        //   403	409	172	java/io/FileNotFoundException
        //   53	66	390	finally
        //   75	82	390	finally
        //   82	103	390	finally
        //   103	109	390	finally
        //   118	154	390	finally
        //   154	169	390	finally
        //   184	191	390	finally
        //   199	205	390	finally
        //   209	214	390	finally
        //   218	226	390	finally
        //   230	240	390	finally
        //   242	263	390	finally
        //   268	279	390	finally
        //   279	295	390	finally
        //   295	347	390	finally
        //   347	359	390	finally
        //   363	373	390	finally
        //   378	387	390	finally
        //   403	409	390	finally
        //   417	422	423	java/lang/Exception
        //   178	183	425	java/lang/Exception
        //   396	401	427	java/lang/Exception
        //   26	53	432	finally
        //   26	53	440	java/io/FileNotFoundException
      }
      
      private void enumeratePathDir(String paramString)
        throws IOException
      {
        boolean bool = this.m_trace1;
        File localFile3 = this.m_currentPathDir;
        File localFile1;
        IPathEnumerator.IPathHandler localIPathHandler;
        int i;
        label47:
        String str;
        File localFile2;
        if (paramString != null)
        {
          localFile1 = new File(localFile3, paramString);
          String[] arrayOfString = localFile1.list();
          localIPathHandler = this.m_handler;
          i = 0;
          int j = arrayOfString.length;
          if (i >= j) {
            return;
          }
          str = arrayOfString[i];
          if (paramString == null) {
            break label178;
          }
          localFile2 = new File(paramString, str);
          label74:
          if (!new File(localFile1, str).isDirectory()) {
            break label192;
          }
          localIPathHandler.handleDirStart(localFile3, localFile2);
          if (bool) {
            this.m_log.trace1("enumeratePathDir", "recursing into [" + localFile2.getName() + "] ...");
          }
          enumeratePathDir(localFile2.getPath());
          localIPathHandler.handleDirEnd(localFile3, localFile2);
        }
        for (;;)
        {
          i += 1;
          break label47;
          localFile1 = localFile3;
          break;
          label178:
          localFile2 = new File(str);
          break label74;
          label192:
          if (bool) {
            this.m_log.trace1("enumeratePathDir", "processing file [" + localFile2.getName() + "] ...");
          }
          localIPathHandler.handleFile(localFile3, localFile2);
        }
      }
      
      /* Error */
      private static Manifest readManifestViaJarFile(File paramFile)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_1
        //   2: aconst_null
        //   3: astore_2
        //   4: aconst_null
        //   5: astore_3
        //   6: new 256	java/util/jar/JarFile
        //   9: dup
        //   10: aload_0
        //   11: iconst_0
        //   12: invokespecial 259	java/util/jar/JarFile:<init>	(Ljava/io/File;Z)V
        //   15: astore_0
        //   16: aload_0
        //   17: invokevirtual 260	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
        //   20: astore_2
        //   21: aload_2
        //   22: astore_1
        //   23: aload_0
        //   24: ifnull +57 -> 81
        //   27: aload_0
        //   28: invokevirtual 261	java/util/jar/JarFile:close	()V
        //   31: aload_1
        //   32: areturn
        //   33: astore_0
        //   34: aload_1
        //   35: areturn
        //   36: astore_0
        //   37: aload_3
        //   38: astore_0
        //   39: aload_0
        //   40: ifnull -9 -> 31
        //   43: aload_0
        //   44: invokevirtual 261	java/util/jar/JarFile:close	()V
        //   47: aconst_null
        //   48: areturn
        //   49: astore_0
        //   50: aconst_null
        //   51: areturn
        //   52: astore_0
        //   53: aload_2
        //   54: astore_1
        //   55: aload_1
        //   56: ifnull +7 -> 63
        //   59: aload_1
        //   60: invokevirtual 261	java/util/jar/JarFile:close	()V
        //   63: aload_0
        //   64: athrow
        //   65: astore_1
        //   66: goto -3 -> 63
        //   69: astore_2
        //   70: aload_0
        //   71: astore_1
        //   72: aload_2
        //   73: astore_0
        //   74: goto -19 -> 55
        //   77: astore_2
        //   78: goto -39 -> 39
        //   81: aload_1
        //   82: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	paramFile	File
        //   1	59	1	localObject1	Object
        //   65	1	1	localIOException1	IOException
        //   71	11	1	localFile	File
        //   3	51	2	localManifest	Manifest
        //   69	4	2	localObject2	Object
        //   77	1	2	localIOException2	IOException
        //   5	33	3	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   27	31	33	java/io/IOException
        //   6	16	36	java/io/IOException
        //   43	47	49	java/io/IOException
        //   6	16	52	finally
        //   59	63	65	java/io/IOException
        //   16	21	69	finally
        //   16	21	77	java/io/IOException
      }
      
      public void enumerate()
        throws IOException
      {
        IPathEnumerator.IPathHandler localIPathHandler = this.m_handler;
        this.m_pathIndex = 0;
        if (this.m_pathIndex < this.m_path.size())
        {
          File localFile = (File)this.m_path.get(this.m_pathIndex);
          if (!localFile.exists()) {}
          for (;;)
          {
            this.m_pathIndex += 1;
            break;
            if (localFile.isDirectory())
            {
              if (this.m_verbose) {
                this.m_log.verbose("processing dir path entry [" + localFile.getAbsolutePath() + "] ...");
              }
              this.m_currentPathDir = localFile;
              enumeratePathDir(null);
            }
            else
            {
              String str = localFile.getName();
              Object localObject = str.toLowerCase();
              if ((((String)localObject).endsWith(".zip")) || (((String)localObject).endsWith(".jar")))
              {
                if (this.m_verbose) {
                  this.m_log.verbose("processing archive path entry [" + localFile.getAbsolutePath() + "] ...");
                }
                localFile = localFile.getParentFile();
                localObject = new File(str);
                this.m_currentPathDir = localFile;
                enumeratePathArchive(str);
                localIPathHandler.handleArchiveEnd(localFile, (File)localObject);
              }
            }
          }
        }
      }
    }
  }
  
  public static abstract interface IPathHandler
  {
    public abstract void handleArchiveEnd(File paramFile1, File paramFile2);
    
    public abstract void handleArchiveEntry(JarInputStream paramJarInputStream, ZipEntry paramZipEntry);
    
    public abstract void handleArchiveStart(File paramFile1, File paramFile2, Manifest paramManifest);
    
    public abstract void handleDirEnd(File paramFile1, File paramFile2);
    
    public abstract void handleDirStart(File paramFile1, File paramFile2);
    
    public abstract void handleFile(File paramFile1, File paramFile2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IPathEnumerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */