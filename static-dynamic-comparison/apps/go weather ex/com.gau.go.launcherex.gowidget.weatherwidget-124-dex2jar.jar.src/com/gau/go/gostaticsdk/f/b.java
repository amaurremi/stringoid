package com.gau.go.gostaticsdk.f;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class b
{
  private int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['က'];
    int i = 0;
    try
    {
      int j;
      for (;;)
      {
        int k = paramInputStream.read(arrayOfByte);
        j = i;
        if (-1 == k) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, k);
        i += k;
      }
      return j;
    }
    catch (Exception paramInputStream)
    {
      j = 0;
    }
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    if (paramArrayOfByte != null) {}
    try
    {
      arrayOfByte = d(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = null;
    if (paramArrayOfByte != null) {}
    try
    {
      arrayOfByte = c(paramArrayOfByte);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 48	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 51	java/io/ByteArrayInputStream:<init>	([B)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_3
    //   20: astore 4
    //   22: new 53	java/util/zip/GZIPInputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 56	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore_3
    //   31: aload_0
    //   32: aload_3
    //   33: invokespecial 58	com/gau/go/gostaticsdk/f/b:a	(Ljava/io/InputStream;)[B
    //   36: astore_2
    //   37: aload_3
    //   38: ifnull +7 -> 45
    //   41: aload_3
    //   42: invokevirtual 61	java/util/zip/GZIPInputStream:close	()V
    //   45: aload_1
    //   46: ifnull +7 -> 53
    //   49: aload_1
    //   50: invokevirtual 62	java/io/ByteArrayInputStream:close	()V
    //   53: aload_2
    //   54: areturn
    //   55: astore_3
    //   56: aload_3
    //   57: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   60: goto -15 -> 45
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_1
    //   73: aload 5
    //   75: astore 4
    //   77: aload_1
    //   78: astore_2
    //   79: aload_3
    //   80: athrow
    //   81: astore_3
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: astore_2
    //   86: aload 4
    //   88: ifnull +8 -> 96
    //   91: aload 4
    //   93: invokevirtual 61	java/util/zip/GZIPInputStream:close	()V
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 62	java/io/ByteArrayInputStream:close	()V
    //   104: aload_2
    //   105: athrow
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   111: goto -15 -> 96
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 42	java/lang/Exception:printStackTrace	()V
    //   119: goto -15 -> 104
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -39 -> 86
    //   128: astore_2
    //   129: aload_3
    //   130: astore 4
    //   132: goto -46 -> 86
    //   135: astore_3
    //   136: aload 5
    //   138: astore 4
    //   140: goto -63 -> 77
    //   143: astore_2
    //   144: aload_3
    //   145: astore 4
    //   147: aload_2
    //   148: astore_3
    //   149: goto -72 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	b
    //   0	152	1	paramArrayOfByte	byte[]
    //   18	87	2	localObject1	Object
    //   122	1	2	localObject2	Object
    //   128	1	2	localObject3	Object
    //   143	5	2	localException1	Exception
    //   1	41	3	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   55	2	3	localException2	Exception
    //   70	10	3	localException3	Exception
    //   81	4	3	localObject4	Object
    //   106	24	3	localException4	Exception
    //   135	10	3	localException5	Exception
    //   148	1	3	localObject5	Object
    //   3	143	4	localObject6	Object
    //   6	131	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   41	45	55	java/lang/Exception
    //   49	53	63	java/lang/Exception
    //   8	17	70	java/lang/Exception
    //   22	31	81	finally
    //   79	81	81	finally
    //   91	96	106	java/lang/Exception
    //   100	104	114	java/lang/Exception
    //   8	17	122	finally
    //   31	37	128	finally
    //   22	31	135	java/lang/Exception
    //   31	37	143	java/lang/Exception
  }
  
  /* Error */
  private byte[] d(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 28	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: sipush 1000
    //   7: invokespecial 65	java/io/ByteArrayOutputStream:<init>	(I)V
    //   10: astore 4
    //   12: new 67	java/util/zip/GZIPOutputStream
    //   15: dup
    //   16: aload 4
    //   18: invokespecial 70	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_2
    //   24: aload_3
    //   25: aload_1
    //   26: invokevirtual 72	java/util/zip/GZIPOutputStream:write	([B)V
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 75	java/util/zip/GZIPOutputStream:flush	()V
    //   35: aload_3
    //   36: ifnull +7 -> 43
    //   39: aload_3
    //   40: invokevirtual 76	java/util/zip/GZIPOutputStream:close	()V
    //   43: aload 4
    //   45: invokevirtual 35	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   48: areturn
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_1
    //   53: athrow
    //   54: astore_1
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 76	java/util/zip/GZIPOutputStream:close	()V
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: goto -23 -> 43
    //   69: astore_2
    //   70: goto -7 -> 63
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_2
    //   76: goto -21 -> 55
    //   79: astore_1
    //   80: aload_3
    //   81: astore_2
    //   82: goto -30 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	b
    //   0	85	1	paramArrayOfByte	byte[]
    //   23	37	2	localGZIPOutputStream1	java.util.zip.GZIPOutputStream
    //   69	1	2	localException	Exception
    //   75	7	2	localGZIPOutputStream2	java.util.zip.GZIPOutputStream
    //   21	60	3	localGZIPOutputStream3	java.util.zip.GZIPOutputStream
    //   10	34	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   12	22	49	java/lang/Exception
    //   24	29	54	finally
    //   31	35	54	finally
    //   52	54	54	finally
    //   39	43	65	java/lang/Exception
    //   59	63	69	java/lang/Exception
    //   12	22	73	finally
    //   24	29	79	java/lang/Exception
    //   31	35	79	java/lang/Exception
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    try
    {
      paramArrayOfByte = com.gau.go.gostaticsdk.d.b.a(paramArrayOfByte);
      FileOutputStream localFileOutputStream = new FileOutputStream(d.a(paramString, false));
      FileChannel localFileChannel = localFileOutputStream.getChannel();
      paramString = localFileChannel.tryLock();
      for (;;)
      {
        if (paramString == null) {
          try
          {
            d.a("StatisticsManager", "cahe locked by other ,wait...");
            Thread.currentThread();
            Thread.sleep(200L);
            paramString = localFileChannel.tryLock();
          }
          catch (InterruptedException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return;
      localFileOutputStream.write(paramArrayOfByte);
      localFileOutputStream.flush();
      if (paramString != null) {
        paramString.release();
      }
      localFileOutputStream.close();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: new 143	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload_2
    //   21: astore_1
    //   22: aload 6
    //   24: invokevirtual 150	java/io/File:exists	()Z
    //   27: ifeq +70 -> 97
    //   30: new 152	java/io/FileInputStream
    //   33: dup
    //   34: aload 6
    //   36: invokespecial 153	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: aload_0
    //   43: aload_2
    //   44: invokespecial 58	com/gau/go/gostaticsdk/f/b:a	(Ljava/io/InputStream;)[B
    //   47: astore 6
    //   49: aload 6
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: aload_3
    //   55: astore 4
    //   57: aload_3
    //   58: astore 5
    //   60: aload_3
    //   61: astore 6
    //   63: aload_3
    //   64: invokestatic 155	com/gau/go/gostaticsdk/d/b:b	([B)[B
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: astore 4
    //   73: aload_3
    //   74: astore 5
    //   76: aload_3
    //   77: astore 6
    //   79: aload_0
    //   80: aload_3
    //   81: invokespecial 156	com/gau/go/gostaticsdk/f/b:b	([B)[B
    //   84: astore_3
    //   85: aload_3
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 157	java/io/InputStream:close	()V
    //   95: aload_3
    //   96: astore_1
    //   97: aload_1
    //   98: areturn
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   104: aload_3
    //   105: areturn
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload 4
    //   114: invokevirtual 158	java/io/FileNotFoundException:printStackTrace	()V
    //   117: aload_3
    //   118: astore_1
    //   119: aload_2
    //   120: ifnull -23 -> 97
    //   123: aload_2
    //   124: invokevirtual 157	java/io/InputStream:close	()V
    //   127: aload_3
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   134: aload_3
    //   135: areturn
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_2
    //   140: aload 5
    //   142: astore_3
    //   143: aload_2
    //   144: astore_1
    //   145: aload 4
    //   147: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   150: aload_3
    //   151: astore_1
    //   152: aload_2
    //   153: ifnull -56 -> 97
    //   156: aload_2
    //   157: invokevirtual 157	java/io/InputStream:close	()V
    //   160: aload_3
    //   161: areturn
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   167: aload_3
    //   168: areturn
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_2
    //   172: aload 4
    //   174: astore_3
    //   175: aload_3
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull -81 -> 97
    //   181: aload_2
    //   182: invokevirtual 157	java/io/InputStream:close	()V
    //   185: aload_3
    //   186: areturn
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   192: aload_3
    //   193: areturn
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 157	java/io/InputStream:close	()V
    //   205: aload_2
    //   206: athrow
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   212: goto -7 -> 205
    //   215: astore_2
    //   216: goto -19 -> 197
    //   219: astore_1
    //   220: aload 4
    //   222: astore_3
    //   223: goto -48 -> 175
    //   226: astore_1
    //   227: aload 4
    //   229: astore_3
    //   230: goto -55 -> 175
    //   233: astore 4
    //   235: aload 5
    //   237: astore_3
    //   238: goto -95 -> 143
    //   241: astore 4
    //   243: aload 5
    //   245: astore_3
    //   246: goto -103 -> 143
    //   249: astore 4
    //   251: goto -141 -> 110
    //   254: astore 4
    //   256: aload 6
    //   258: astore_3
    //   259: goto -149 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	b
    //   0	262	1	paramString	String
    //   9	173	2	localFileInputStream	java.io.FileInputStream
    //   194	12	2	localObject1	Object
    //   215	1	2	localObject2	Object
    //   1	258	3	localObject3	Object
    //   6	66	4	localObject4	Object
    //   106	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   136	92	4	localIOException1	IOException
    //   233	1	4	localIOException2	IOException
    //   241	1	4	localIOException3	IOException
    //   249	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   254	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   3	241	5	localObject5	Object
    //   18	239	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   91	95	99	java/io/IOException
    //   30	40	106	java/io/FileNotFoundException
    //   123	127	129	java/io/IOException
    //   30	40	136	java/io/IOException
    //   156	160	162	java/io/IOException
    //   30	40	169	java/lang/Exception
    //   181	185	187	java/io/IOException
    //   30	40	194	finally
    //   201	205	207	java/io/IOException
    //   42	49	215	finally
    //   63	68	215	finally
    //   79	85	215	finally
    //   112	117	215	finally
    //   145	150	215	finally
    //   42	49	219	java/lang/Exception
    //   63	68	226	java/lang/Exception
    //   79	85	226	java/lang/Exception
    //   42	49	233	java/io/IOException
    //   63	68	241	java/io/IOException
    //   79	85	241	java/io/IOException
    //   42	49	249	java/io/FileNotFoundException
    //   63	68	254	java/io/FileNotFoundException
    //   79	85	254	java/io/FileNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */