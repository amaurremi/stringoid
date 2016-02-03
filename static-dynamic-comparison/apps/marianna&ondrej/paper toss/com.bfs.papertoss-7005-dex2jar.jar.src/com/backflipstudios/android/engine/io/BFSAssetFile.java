package com.backflipstudios.android.engine.io;

import android.content.Context;
import android.content.res.AssetManager;
import com.backflipstudios.android.debug.BFSDebug;
import com.bfs.papertoss.PaperTossApplication;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class BFSAssetFile
{
  private static final int READ_BUFFER_SIZE = 16384;
  private String m_path = null;
  private int m_pos = 0;
  private int m_size = -1;
  private InputStream m_stream = null;
  
  private static byte[] readAllOfStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['䀀'];
    while (paramInputStream.available() > 0)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 16384);
      if (i > 0) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    }
    paramInputStream = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramInputStream;
    }
    catch (Exception localException) {}
    return paramInputStream;
  }
  
  public static byte[] readContentsOfFile(String paramString)
  {
    BFSAssetFile localBFSAssetFile = new BFSAssetFile();
    localBFSAssetFile.open(paramString, "r");
    return localBFSAssetFile.getData();
  }
  
  private static byte[] readPartOfStream(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[Math.min(paramInputStream.available(), paramInt)];
    paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void close()
  {
    if (this.m_stream != null) {}
    try
    {
      this.m_stream.close();
      this.m_stream = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public byte[] getData()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore_3
    //   14: aload 6
    //   16: astore_1
    //   17: aload 7
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   24: ifnull +48 -> 72
    //   27: aload 6
    //   29: astore_1
    //   30: aload 7
    //   32: astore_2
    //   33: aload_0
    //   34: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   37: invokevirtual 81	java/io/InputStream:reset	()V
    //   40: aload 6
    //   42: astore_1
    //   43: aload 7
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   50: invokestatic 83	com/backflipstudios/android/engine/io/BFSAssetFile:readAllOfStream	(Ljava/io/InputStream;)[B
    //   53: astore 5
    //   55: aload 5
    //   57: astore_1
    //   58: aload_1
    //   59: astore_2
    //   60: aload_3
    //   61: ifnull +9 -> 70
    //   64: aload_3
    //   65: invokevirtual 78	java/io/InputStream:close	()V
    //   68: aload_1
    //   69: astore_2
    //   70: aload_2
    //   71: areturn
    //   72: aload 6
    //   74: astore_1
    //   75: aload 7
    //   77: astore_2
    //   78: invokestatic 89	com/bfs/papertoss/PaperTossApplication:getInstance	()Lcom/bfs/papertoss/PaperTossApplication;
    //   81: invokevirtual 95	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   84: aload_0
    //   85: getfield 19	com/backflipstudios/android/engine/io/BFSAssetFile:m_path	Ljava/lang/String;
    //   88: iconst_2
    //   89: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +19 -> 113
    //   97: aload_3
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: aload_3
    //   102: invokestatic 83	com/backflipstudios/android/engine/io/BFSAssetFile:readAllOfStream	(Ljava/io/InputStream;)[B
    //   105: astore 5
    //   107: aload 5
    //   109: astore_1
    //   110: goto -52 -> 58
    //   113: aload_3
    //   114: astore_1
    //   115: aload_3
    //   116: astore_2
    //   117: ldc 102
    //   119: new 104	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   126: ldc 107
    //   128: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 19	com/backflipstudios/android/engine/io/BFSAssetFile:m_path	Ljava/lang/String;
    //   135: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 120	com/backflipstudios/android/debug/BFSDebug:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 5
    //   146: astore_1
    //   147: goto -89 -> 58
    //   150: astore_3
    //   151: aload_1
    //   152: astore_2
    //   153: ldc 102
    //   155: ldc 122
    //   157: aload_3
    //   158: invokestatic 126	com/backflipstudios/android/debug/BFSDebug:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload 4
    //   163: astore_2
    //   164: aload_1
    //   165: ifnull -95 -> 70
    //   168: aload_1
    //   169: invokevirtual 78	java/io/InputStream:close	()V
    //   172: aconst_null
    //   173: areturn
    //   174: astore_1
    //   175: aconst_null
    //   176: areturn
    //   177: astore_1
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 78	java/io/InputStream:close	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_2
    //   189: aload_1
    //   190: areturn
    //   191: astore_2
    //   192: goto -6 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	BFSAssetFile
    //   16	153	1	localObject1	Object
    //   174	1	1	localException1	Exception
    //   177	13	1	arrayOfByte1	byte[]
    //   19	164	2	localObject2	Object
    //   188	1	2	localException2	Exception
    //   191	1	2	localException3	Exception
    //   13	103	3	localInputStream	InputStream
    //   150	8	3	localException4	Exception
    //   1	161	4	localObject3	Object
    //   4	141	5	arrayOfByte2	byte[]
    //   7	66	6	localObject4	Object
    //   10	66	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	150	java/lang/Exception
    //   33	40	150	java/lang/Exception
    //   46	55	150	java/lang/Exception
    //   78	93	150	java/lang/Exception
    //   101	107	150	java/lang/Exception
    //   117	144	150	java/lang/Exception
    //   168	172	174	java/lang/Exception
    //   20	27	177	finally
    //   33	40	177	finally
    //   46	55	177	finally
    //   78	93	177	finally
    //   101	107	177	finally
    //   117	144	177	finally
    //   153	161	177	finally
    //   64	68	188	java/lang/Exception
    //   182	186	191	java/lang/Exception
  }
  
  public int getSize()
  {
    byte[] arrayOfByte;
    if (this.m_size == -1)
    {
      arrayOfByte = getData();
      if (arrayOfByte == null) {
        break label28;
      }
    }
    label28:
    for (this.m_size = arrayOfByte.length;; this.m_size = 0) {
      return this.m_size;
    }
  }
  
  public void open(String paramString1, String paramString2)
  {
    this.m_path = paramString1;
    try
    {
      paramString1 = PaperTossApplication.getInstance().getAssets().open(this.m_path, 2);
      if (paramString1 != null)
      {
        if (paramString1.markSupported())
        {
          paramString1.mark(Integer.MAX_VALUE);
          this.m_stream = paramString1;
          return;
        }
        BFSDebug.w("BFS", "BFSAssetFile.open: Random access read unsupported.");
        try
        {
          paramString1.close();
          return;
        }
        catch (Exception paramString1)
        {
          return;
        }
      }
      BFSDebug.w("BFS", "BFSAssetFile.open: Unable to open file, file not found.");
      return;
    }
    catch (Exception paramString1)
    {
      BFSDebug.e("BFS", "BFSAssetFile.open", paramString1);
    }
  }
  
  /* Error */
  public byte[] read(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 7
    //   16: astore 6
    //   18: aload 8
    //   20: astore_3
    //   21: aload 9
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   29: ifnull +109 -> 138
    //   32: aload 7
    //   34: astore 6
    //   36: aload 8
    //   38: astore_3
    //   39: aload 9
    //   41: astore 4
    //   43: aload_0
    //   44: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   47: invokevirtual 81	java/io/InputStream:reset	()V
    //   50: aload 7
    //   52: astore 6
    //   54: aload 8
    //   56: astore_3
    //   57: aload 9
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   65: aload_0
    //   66: getfield 25	com/backflipstudios/android/engine/io/BFSAssetFile:m_pos	I
    //   69: i2l
    //   70: invokevirtual 147	java/io/InputStream:skip	(J)J
    //   73: pop2
    //   74: aload 7
    //   76: astore 6
    //   78: aload 8
    //   80: astore_3
    //   81: aload 9
    //   83: astore 4
    //   85: aload_0
    //   86: getfield 23	com/backflipstudios/android/engine/io/BFSAssetFile:m_stream	Ljava/io/InputStream;
    //   89: iload_1
    //   90: invokestatic 149	com/backflipstudios/android/engine/io/BFSAssetFile:readPartOfStream	(Ljava/io/InputStream;I)[B
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +24 -> 119
    //   98: aload_2
    //   99: astore 6
    //   101: aload 5
    //   103: astore_3
    //   104: aload 5
    //   106: astore 4
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 25	com/backflipstudios/android/engine/io/BFSAssetFile:m_pos	I
    //   113: aload_2
    //   114: arraylength
    //   115: iadd
    //   116: putfield 25	com/backflipstudios/android/engine/io/BFSAssetFile:m_pos	I
    //   119: aload_2
    //   120: astore 4
    //   122: aload 5
    //   124: ifnull +11 -> 135
    //   127: aload 5
    //   129: invokevirtual 78	java/io/InputStream:close	()V
    //   132: aload_2
    //   133: astore 4
    //   135: aload 4
    //   137: areturn
    //   138: aload 7
    //   140: astore 6
    //   142: aload 8
    //   144: astore_3
    //   145: aload 9
    //   147: astore 4
    //   149: invokestatic 89	com/bfs/papertoss/PaperTossApplication:getInstance	()Lcom/bfs/papertoss/PaperTossApplication;
    //   152: invokevirtual 95	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   155: aload_0
    //   156: getfield 19	com/backflipstudios/android/engine/io/BFSAssetFile:m_path	Ljava/lang/String;
    //   159: iconst_2
    //   160: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   163: astore 5
    //   165: aload 5
    //   167: ifnull +46 -> 213
    //   170: aload 7
    //   172: astore 6
    //   174: aload 5
    //   176: astore_3
    //   177: aload 5
    //   179: astore 4
    //   181: aload 5
    //   183: aload_0
    //   184: getfield 25	com/backflipstudios/android/engine/io/BFSAssetFile:m_pos	I
    //   187: i2l
    //   188: invokevirtual 147	java/io/InputStream:skip	(J)J
    //   191: pop2
    //   192: aload 7
    //   194: astore 6
    //   196: aload 5
    //   198: astore_3
    //   199: aload 5
    //   201: astore 4
    //   203: aload 5
    //   205: iload_1
    //   206: invokestatic 149	com/backflipstudios/android/engine/io/BFSAssetFile:readPartOfStream	(Ljava/io/InputStream;I)[B
    //   209: astore_2
    //   210: goto -116 -> 94
    //   213: aload 7
    //   215: astore 6
    //   217: aload 5
    //   219: astore_3
    //   220: aload 5
    //   222: astore 4
    //   224: ldc 102
    //   226: new 104	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   233: ldc 107
    //   235: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: getfield 19	com/backflipstudios/android/engine/io/BFSAssetFile:m_path	Ljava/lang/String;
    //   242: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 120	com/backflipstudios/android/debug/BFSDebug:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -157 -> 94
    //   254: astore_2
    //   255: aload_3
    //   256: astore 4
    //   258: ldc 102
    //   260: ldc 122
    //   262: aload_2
    //   263: invokestatic 126	com/backflipstudios/android/debug/BFSDebug:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload 6
    //   268: astore 4
    //   270: aload_3
    //   271: ifnull -136 -> 135
    //   274: aload_3
    //   275: invokevirtual 78	java/io/InputStream:close	()V
    //   278: aload 6
    //   280: areturn
    //   281: astore_2
    //   282: aload 6
    //   284: areturn
    //   285: astore_2
    //   286: aload 4
    //   288: ifnull +8 -> 296
    //   291: aload 4
    //   293: invokevirtual 78	java/io/InputStream:close	()V
    //   296: aload_2
    //   297: athrow
    //   298: astore_3
    //   299: aload_2
    //   300: areturn
    //   301: astore_3
    //   302: goto -6 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	BFSAssetFile
    //   0	305	1	paramInt	int
    //   4	206	2	arrayOfByte1	byte[]
    //   254	9	2	localException1	Exception
    //   281	1	2	localException2	Exception
    //   285	15	2	arrayOfByte2	byte[]
    //   20	255	3	localObject1	Object
    //   298	1	3	localException3	Exception
    //   301	1	3	localException4	Exception
    //   23	269	4	localObject2	Object
    //   12	209	5	localInputStream	InputStream
    //   16	267	6	localObject3	Object
    //   1	213	7	localObject4	Object
    //   6	137	8	localObject5	Object
    //   9	137	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   25	32	254	java/lang/Exception
    //   43	50	254	java/lang/Exception
    //   61	74	254	java/lang/Exception
    //   85	94	254	java/lang/Exception
    //   108	119	254	java/lang/Exception
    //   149	165	254	java/lang/Exception
    //   181	192	254	java/lang/Exception
    //   203	210	254	java/lang/Exception
    //   224	251	254	java/lang/Exception
    //   274	278	281	java/lang/Exception
    //   25	32	285	finally
    //   43	50	285	finally
    //   61	74	285	finally
    //   85	94	285	finally
    //   108	119	285	finally
    //   149	165	285	finally
    //   181	192	285	finally
    //   203	210	285	finally
    //   224	251	285	finally
    //   258	266	285	finally
    //   127	132	298	java/lang/Exception
    //   291	296	301	java/lang/Exception
  }
  
  public boolean seek(int paramInt)
  {
    if (paramInt <= getSize())
    {
      this.m_pos = paramInt;
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/backflipstudios/android/engine/io/BFSAssetFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */