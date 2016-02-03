package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiskBasedCache
  implements Cache
{
  private static final int CACHE_MAGIC = 538051844;
  private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
  private static final float HYSTERESIS_FACTOR = 0.9F;
  protected final Map<String, CacheHeader> mEntries = new LinkedHashMap(16, 0.75F, true);
  protected final int mMaxCacheSizeInBytes;
  protected final File mRootDirectory;
  protected long mTotalSize = 0L;
  
  public DiskBasedCache(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public DiskBasedCache(File paramFile, int paramInt)
  {
    this.mRootDirectory = paramFile;
    this.mMaxCacheSizeInBytes = paramInt;
  }
  
  private String getFilenameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    return String.valueOf(paramString.substring(0, i).hashCode()) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  private void pruneIfNeeded(int paramInt)
  {
    if (this.mTotalSize + paramInt < this.mMaxCacheSizeInBytes) {
      return;
    }
    if (VolleyLog.DEBUG) {
      VolleyLog.v("Pruning old cache entries.", new Object[0]);
    }
    long l1 = this.mTotalSize;
    int i = 0;
    long l2 = SystemClock.elapsedRealtime();
    Iterator localIterator = this.mEntries.entrySet().iterator();
    label61:
    label71:
    CacheHeader localCacheHeader;
    if (!localIterator.hasNext())
    {
      if (VolleyLog.DEBUG) {
        VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(this.mTotalSize - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
      }
    }
    else
    {
      localCacheHeader = (CacheHeader)((Map.Entry)localIterator.next()).getValue();
      if (!getFileForKey(localCacheHeader.key).delete()) {
        break label206;
      }
      this.mTotalSize -= localCacheHeader.size;
    }
    for (;;)
    {
      localIterator.remove();
      int j = i + 1;
      i = j;
      if ((float)(this.mTotalSize + paramInt) >= this.mMaxCacheSizeInBytes * 0.9F) {
        break label61;
      }
      i = j;
      break label71;
      break;
      label206:
      VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { localCacheHeader.key, getFilenameForKey(localCacheHeader.key) });
    }
  }
  
  private void putEntry(String paramString, CacheHeader paramCacheHeader)
  {
    if (!this.mEntries.containsKey(paramString)) {}
    CacheHeader localCacheHeader;
    for (this.mTotalSize += paramCacheHeader.size;; this.mTotalSize += paramCacheHeader.size - localCacheHeader.size)
    {
      this.mEntries.put(paramString, paramCacheHeader);
      return;
      localCacheHeader = (CacheHeader)this.mEntries.get(paramString);
    }
  }
  
  private static int read(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  static int readInt(InputStream paramInputStream)
    throws IOException
  {
    return 0x0 | read(paramInputStream) << 0 | read(paramInputStream) << 8 | read(paramInputStream) << 16 | read(paramInputStream) << 24;
  }
  
  static long readLong(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (read(paramInputStream) & 0xFF) << 0 | (read(paramInputStream) & 0xFF) << 8 | (read(paramInputStream) & 0xFF) << 16 | (read(paramInputStream) & 0xFF) << 24 | (read(paramInputStream) & 0xFF) << 32 | (read(paramInputStream) & 0xFF) << 40 | (read(paramInputStream) & 0xFF) << 48 | (read(paramInputStream) & 0xFF) << 56;
  }
  
  static String readString(InputStream paramInputStream)
    throws IOException
  {
    return new String(streamToBytes(paramInputStream, (int)readLong(paramInputStream)), "UTF-8");
  }
  
  static Map<String, String> readStringStringMap(InputStream paramInputStream)
    throws IOException
  {
    int j = readInt(paramInputStream);
    Object localObject;
    int i;
    if (j == 0)
    {
      localObject = Collections.emptyMap();
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        return (Map<String, String>)localObject;
        localObject = new HashMap(j);
        break;
      }
      ((Map)localObject).put(readString(paramInputStream).intern(), readString(paramInputStream).intern());
      i += 1;
    }
  }
  
  private void removeEntry(String paramString)
  {
    CacheHeader localCacheHeader = (CacheHeader)this.mEntries.get(paramString);
    if (localCacheHeader != null)
    {
      this.mTotalSize -= localCacheHeader.size;
      this.mEntries.remove(paramString);
    }
  }
  
  private static byte[] streamToBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt)
      {
        j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j != -1) {}
      }
      else
      {
        if (i == paramInt) {
          break;
        }
        throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
      }
      i += j;
    }
    return arrayOfByte;
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void writeLong(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void writeString(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    writeLong(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  static void writeStringStringMap(Map<String, String> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramMap != null)
    {
      writeInt(paramOutputStream, paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        if (!paramMap.hasNext()) {
          return;
        }
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        writeString(paramOutputStream, (String)localEntry.getKey());
        writeString(paramOutputStream, (String)localEntry.getValue());
      }
    }
    writeInt(paramOutputStream, 0);
  }
  
  public void clear()
  {
    int i = 0;
    for (;;)
    {
      File[] arrayOfFile;
      int j;
      try
      {
        arrayOfFile = this.mRootDirectory.listFiles();
        if (arrayOfFile != null)
        {
          j = arrayOfFile.length;
          break label68;
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        VolleyLog.d("Cache cleared.", new Object[0]);
        return;
      }
      finally {}
      arrayOfFile[i].delete();
      i += 1;
      label68:
      if (i < j) {}
    }
  }
  
  /* Error */
  public Cache.Entry get(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 45	com/android/volley/toolbox/DiskBasedCache:mEntries	Ljava/util/Map;
    //   9: aload_1
    //   10: invokeinterface 187 2 0
    //   15: checkcast 8	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +10 -> 32
    //   25: aload 5
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: areturn
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 155	com/android/volley/toolbox/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   37: astore 7
    //   39: aconst_null
    //   40: astore_2
    //   41: aconst_null
    //   42: astore 6
    //   44: new 11	com/android/volley/toolbox/DiskBasedCache$CountingInputStream
    //   47: dup
    //   48: new 300	java/io/FileInputStream
    //   51: dup
    //   52: aload 7
    //   54: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: aconst_null
    //   58: invokespecial 305	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokestatic 309	com/android/volley/toolbox/DiskBasedCache$CacheHeader:readHeader	(Ljava/io/InputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   66: pop
    //   67: aload 4
    //   69: aload_3
    //   70: aload 7
    //   72: invokevirtual 311	java/io/File:length	()J
    //   75: aload_3
    //   76: invokestatic 315	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:access$1	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;)I
    //   79: i2l
    //   80: lsub
    //   81: l2i
    //   82: invokestatic 214	com/android/volley/toolbox/DiskBasedCache:streamToBytes	(Ljava/io/InputStream;I)[B
    //   85: invokevirtual 319	com/android/volley/toolbox/DiskBasedCache$CacheHeader:toCacheEntry	([B)Lcom/android/volley/Cache$Entry;
    //   88: astore_2
    //   89: aload_3
    //   90: ifnull +7 -> 97
    //   93: aload_3
    //   94: invokevirtual 322	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:close	()V
    //   97: aload_2
    //   98: astore_1
    //   99: goto -71 -> 28
    //   102: astore_1
    //   103: aload 5
    //   105: astore_1
    //   106: goto -78 -> 28
    //   109: astore 4
    //   111: aload 6
    //   113: astore_3
    //   114: aload_3
    //   115: astore_2
    //   116: ldc_w 324
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload 7
    //   127: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload 4
    //   135: invokevirtual 328	java/io/IOException:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 173	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_3
    //   143: astore_2
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 330	com/android/volley/toolbox/DiskBasedCache:remove	(Ljava/lang/String;)V
    //   149: aload 5
    //   151: astore_1
    //   152: aload_3
    //   153: ifnull -125 -> 28
    //   156: aload_3
    //   157: invokevirtual 322	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:close	()V
    //   160: aload 5
    //   162: astore_1
    //   163: goto -135 -> 28
    //   166: astore_1
    //   167: aload 5
    //   169: astore_1
    //   170: goto -142 -> 28
    //   173: astore_1
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 322	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_1
    //   188: athrow
    //   189: astore_1
    //   190: aload 5
    //   192: astore_1
    //   193: goto -165 -> 28
    //   196: astore_1
    //   197: aload_3
    //   198: astore_2
    //   199: goto -25 -> 174
    //   202: astore 4
    //   204: goto -90 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	DiskBasedCache
    //   0	207	1	paramString	String
    //   40	159	2	localObject1	Object
    //   61	137	3	localObject2	Object
    //   18	50	4	localCacheHeader	CacheHeader
    //   109	25	4	localIOException1	IOException
    //   202	1	4	localIOException2	IOException
    //   1	190	5	localObject3	Object
    //   42	70	6	localObject4	Object
    //   37	89	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   93	97	102	java/io/IOException
    //   44	62	109	java/io/IOException
    //   156	160	166	java/io/IOException
    //   44	62	173	finally
    //   116	142	173	finally
    //   144	149	173	finally
    //   5	20	184	finally
    //   32	39	184	finally
    //   93	97	184	finally
    //   156	160	184	finally
    //   178	182	184	finally
    //   182	184	184	finally
    //   178	182	189	java/io/IOException
    //   62	89	196	finally
    //   62	89	202	java/io/IOException
  }
  
  public File getFileForKey(String paramString)
  {
    return new File(this.mRootDirectory, getFilenameForKey(paramString));
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   8: invokevirtual 337	java/io/File:exists	()Z
    //   11: ifne +36 -> 47
    //   14: aload_0
    //   15: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   18: invokevirtual 340	java/io/File:mkdirs	()Z
    //   21: ifne +23 -> 44
    //   24: ldc_w 342
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   37: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   40: aastore
    //   41: invokestatic 345	com/android/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 49	com/android/volley/toolbox/DiskBasedCache:mRootDirectory	Ljava/io/File;
    //   51: invokevirtual 293	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull -14 -> 44
    //   61: aload 6
    //   63: arraylength
    //   64: istore_2
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -23 -> 44
    //   70: aload 6
    //   72: iload_1
    //   73: aaload
    //   74: astore 7
    //   76: aconst_null
    //   77: astore_3
    //   78: aconst_null
    //   79: astore 5
    //   81: new 300	java/io/FileInputStream
    //   84: dup
    //   85: aload 7
    //   87: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: astore 4
    //   92: aload 4
    //   94: invokestatic 309	com/android/volley/toolbox/DiskBasedCache$CacheHeader:readHeader	(Ljava/io/InputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   97: astore_3
    //   98: aload_3
    //   99: aload 7
    //   101: invokevirtual 311	java/io/File:length	()J
    //   104: putfield 163	com/android/volley/toolbox/DiskBasedCache$CacheHeader:size	J
    //   107: aload_0
    //   108: aload_3
    //   109: getfield 151	com/android/volley/toolbox/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   112: aload_3
    //   113: invokespecial 347	com/android/volley/toolbox/DiskBasedCache:putEntry	(Ljava/lang/String;Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;)V
    //   116: aload 4
    //   118: ifnull +93 -> 211
    //   121: aload 4
    //   123: invokevirtual 348	java/io/FileInputStream:close	()V
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -65 -> 65
    //   133: astore_3
    //   134: aload 5
    //   136: astore 4
    //   138: aload 7
    //   140: ifnull +12 -> 152
    //   143: aload 4
    //   145: astore_3
    //   146: aload 7
    //   148: invokevirtual 160	java/io/File:delete	()Z
    //   151: pop
    //   152: aload 4
    //   154: ifnull -28 -> 126
    //   157: aload 4
    //   159: invokevirtual 348	java/io/FileInputStream:close	()V
    //   162: goto -36 -> 126
    //   165: astore_3
    //   166: goto -40 -> 126
    //   169: astore 4
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 348	java/io/FileInputStream:close	()V
    //   179: aload 4
    //   181: athrow
    //   182: astore_3
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_3
    //   186: athrow
    //   187: astore_3
    //   188: goto -62 -> 126
    //   191: astore_3
    //   192: goto -13 -> 179
    //   195: astore 5
    //   197: aload 4
    //   199: astore_3
    //   200: aload 5
    //   202: astore 4
    //   204: goto -33 -> 171
    //   207: astore_3
    //   208: goto -70 -> 138
    //   211: goto -85 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	DiskBasedCache
    //   1	129	1	i	int
    //   64	4	2	j	int
    //   77	36	3	localCacheHeader	CacheHeader
    //   133	1	3	localIOException1	IOException
    //   145	1	3	localObject1	Object
    //   165	11	3	localIOException2	IOException
    //   182	4	3	localObject2	Object
    //   187	1	3	localIOException3	IOException
    //   191	1	3	localIOException4	IOException
    //   199	1	3	localObject3	Object
    //   207	1	3	localIOException5	IOException
    //   90	68	4	localObject4	Object
    //   169	29	4	localObject5	Object
    //   202	1	4	localObject6	Object
    //   79	56	5	localObject7	Object
    //   195	6	5	localObject8	Object
    //   54	17	6	arrayOfFile	File[]
    //   74	73	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   81	92	133	java/io/IOException
    //   157	162	165	java/io/IOException
    //   81	92	169	finally
    //   146	152	169	finally
    //   4	44	182	finally
    //   47	56	182	finally
    //   61	65	182	finally
    //   121	126	182	finally
    //   157	162	182	finally
    //   175	179	182	finally
    //   179	182	182	finally
    //   121	126	187	java/io/IOException
    //   175	179	191	java/io/IOException
    //   92	116	195	finally
    //   92	116	207	java/io/IOException
  }
  
  public void invalidate(String paramString, boolean paramBoolean)
  {
    try
    {
      Cache.Entry localEntry = get(paramString);
      if (localEntry != null)
      {
        localEntry.softTtl = 0L;
        if (paramBoolean) {
          localEntry.ttl = 0L;
        }
        put(paramString, localEntry);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void put(String paramString, Cache.Entry paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 367	com/android/volley/Cache$Entry:data	[B
    //   7: arraylength
    //   8: invokespecial 369	com/android/volley/toolbox/DiskBasedCache:pruneIfNeeded	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 155	com/android/volley/toolbox/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: new 371	java/io/FileOutputStream
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 372	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore 4
    //   27: new 8	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   30: dup
    //   31: aload_1
    //   32: aload_2
    //   33: invokespecial 374	com/android/volley/toolbox/DiskBasedCache$CacheHeader:<init>	(Ljava/lang/String;Lcom/android/volley/Cache$Entry;)V
    //   36: astore 5
    //   38: aload 5
    //   40: aload 4
    //   42: invokevirtual 378	com/android/volley/toolbox/DiskBasedCache$CacheHeader:writeHeader	(Ljava/io/OutputStream;)Z
    //   45: pop
    //   46: aload 4
    //   48: aload_2
    //   49: getfield 367	com/android/volley/Cache$Entry:data	[B
    //   52: invokevirtual 381	java/io/FileOutputStream:write	([B)V
    //   55: aload 4
    //   57: invokevirtual 382	java/io/FileOutputStream:close	()V
    //   60: aload_0
    //   61: aload_1
    //   62: aload 5
    //   64: invokespecial 347	com/android/volley/toolbox/DiskBasedCache:putEntry	(Ljava/lang/String;Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 160	java/io/File:delete	()Z
    //   75: ifne -8 -> 67
    //   78: ldc_w 384
    //   81: iconst_1
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 173	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: goto -28 -> 67
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	DiskBasedCache
    //   0	103	1	paramString	String
    //   0	103	2	paramEntry	Cache.Entry
    //   16	72	3	localFile	File
    //   25	31	4	localFileOutputStream	java.io.FileOutputStream
    //   36	27	5	localCacheHeader	CacheHeader
    // Exception table:
    //   from	to	target	type
    //   17	67	70	java/io/IOException
    //   2	17	98	finally
    //   17	67	98	finally
    //   71	95	98	finally
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = getFileForKey(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, getFilenameForKey(paramString) });
      }
      return;
    }
    finally {}
  }
  
  static class CacheHeader
  {
    public String etag;
    public String key;
    public Map<String, String> responseHeaders;
    public long serverDate;
    public long size;
    public long softTtl;
    public long ttl;
    
    private CacheHeader() {}
    
    public CacheHeader(String paramString, Cache.Entry paramEntry)
    {
      this.key = paramString;
      this.size = paramEntry.data.length;
      this.etag = paramEntry.etag;
      this.serverDate = paramEntry.serverDate;
      this.ttl = paramEntry.ttl;
      this.softTtl = paramEntry.softTtl;
      this.responseHeaders = paramEntry.responseHeaders;
    }
    
    public static CacheHeader readHeader(InputStream paramInputStream)
      throws IOException
    {
      CacheHeader localCacheHeader = new CacheHeader();
      if (DiskBasedCache.readInt(paramInputStream) != 538051844) {
        throw new IOException();
      }
      localCacheHeader.key = DiskBasedCache.readString(paramInputStream);
      localCacheHeader.etag = DiskBasedCache.readString(paramInputStream);
      if (localCacheHeader.etag.equals("")) {
        localCacheHeader.etag = null;
      }
      localCacheHeader.serverDate = DiskBasedCache.readLong(paramInputStream);
      localCacheHeader.ttl = DiskBasedCache.readLong(paramInputStream);
      localCacheHeader.softTtl = DiskBasedCache.readLong(paramInputStream);
      localCacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(paramInputStream);
      return localCacheHeader;
    }
    
    public Cache.Entry toCacheEntry(byte[] paramArrayOfByte)
    {
      Cache.Entry localEntry = new Cache.Entry();
      localEntry.data = paramArrayOfByte;
      localEntry.etag = this.etag;
      localEntry.serverDate = this.serverDate;
      localEntry.ttl = this.ttl;
      localEntry.softTtl = this.softTtl;
      localEntry.responseHeaders = this.responseHeaders;
      return localEntry;
    }
    
    public boolean writeHeader(OutputStream paramOutputStream)
    {
      try
      {
        DiskBasedCache.writeInt(paramOutputStream, 538051844);
        DiskBasedCache.writeString(paramOutputStream, this.key);
        if (this.etag == null) {}
        for (String str = "";; str = this.etag)
        {
          DiskBasedCache.writeString(paramOutputStream, str);
          DiskBasedCache.writeLong(paramOutputStream, this.serverDate);
          DiskBasedCache.writeLong(paramOutputStream, this.ttl);
          DiskBasedCache.writeLong(paramOutputStream, this.softTtl);
          DiskBasedCache.writeStringStringMap(this.responseHeaders, paramOutputStream);
          paramOutputStream.flush();
          return true;
        }
        return false;
      }
      catch (IOException paramOutputStream)
      {
        VolleyLog.d("%s", new Object[] { paramOutputStream.toString() });
      }
    }
  }
  
  private static class CountingInputStream
    extends FilterInputStream
  {
    private int bytesRead = 0;
    
    private CountingInputStream(InputStream paramInputStream)
    {
      super();
    }
    
    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        this.bytesRead += 1;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.bytesRead += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/android/volley/toolbox/DiskBasedCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */