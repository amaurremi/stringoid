package com.android.a.a;

import com.android.a.ab;
import com.android.a.b;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
  implements b
{
  private final File a;
  
  public d(File paramFile, int paramInt)
  {
    this.a = paramFile;
  }
  
  static int a(InputStream paramInputStream)
  {
    return 0x0 | e(paramInputStream) << 0 | e(paramInputStream) << 8 | e(paramInputStream) << 16 | e(paramInputStream) << 24;
  }
  
  static void a(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void a(OutputStream paramOutputStream, long paramLong)
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
  
  static void a(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    a(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  static void a(Map paramMap, OutputStream paramOutputStream)
  {
    if (paramMap != null)
    {
      a(paramOutputStream, paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      for (;;)
      {
        if (!paramMap.hasNext()) {
          return;
        }
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(paramOutputStream, (String)localEntry.getKey());
        a(paramOutputStream, (String)localEntry.getValue());
      }
    }
    a(paramOutputStream, 0);
  }
  
  private static byte[] a(InputStream paramInputStream, int paramInt)
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
  
  static long b(InputStream paramInputStream)
  {
    return 0L | (e(paramInputStream) & 0xFF) << 0 | (e(paramInputStream) & 0xFF) << 8 | (e(paramInputStream) & 0xFF) << 16 | (e(paramInputStream) & 0xFF) << 24 | (e(paramInputStream) & 0xFF) << 32 | (e(paramInputStream) & 0xFF) << 40 | (e(paramInputStream) & 0xFF) << 48 | (e(paramInputStream) & 0xFF) << 56;
  }
  
  static String c(InputStream paramInputStream)
  {
    return new String(a(paramInputStream, (int)b(paramInputStream)), "UTF-8");
  }
  
  private String d(String paramString)
  {
    int i = paramString.length() / 2;
    return String.valueOf(paramString.substring(0, i).hashCode()) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  static Map d(InputStream paramInputStream)
  {
    int j = a(paramInputStream);
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
        return (Map)localObject;
        localObject = new HashMap(j);
        break;
      }
      ((Map)localObject).put(c(paramInputStream).intern(), c(paramInputStream).intern());
      i += 1;
    }
  }
  
  private static int e(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  /* Error */
  public com.android.a.c a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 180	com/android/a/a/d:c	(Ljava/lang/String;)Ljava/io/File;
    //   10: astore 9
    //   12: aload 8
    //   14: astore 6
    //   16: aload 9
    //   18: ifnull +19 -> 37
    //   21: aload 9
    //   23: invokevirtual 185	java/io/File:exists	()Z
    //   26: istore 4
    //   28: iload 4
    //   30: ifne +12 -> 42
    //   33: aload 8
    //   35: astore 6
    //   37: aload_0
    //   38: monitorexit
    //   39: aload 6
    //   41: areturn
    //   42: new 187	com/android/a/a/f
    //   45: dup
    //   46: new 189	java/io/FileInputStream
    //   49: dup
    //   50: aload 9
    //   52: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: aconst_null
    //   56: invokespecial 195	com/android/a/a/f:<init>	(Ljava/io/InputStream;Lcom/android/a/a/f;)V
    //   59: astore 5
    //   61: aload 5
    //   63: astore 6
    //   65: aload 5
    //   67: invokestatic 200	com/android/a/a/e:a	(Ljava/io/InputStream;)Lcom/android/a/a/e;
    //   70: astore 7
    //   72: aload 5
    //   74: astore 6
    //   76: aload 9
    //   78: invokevirtual 203	java/io/File:length	()J
    //   81: l2i
    //   82: istore_2
    //   83: aload 5
    //   85: astore 6
    //   87: aload 5
    //   89: invokestatic 206	com/android/a/a/f:a	(Lcom/android/a/a/f;)I
    //   92: istore_3
    //   93: iload_2
    //   94: iload_3
    //   95: isub
    //   96: ifge +32 -> 128
    //   99: aload 8
    //   101: astore 6
    //   103: aload 5
    //   105: ifnull -68 -> 37
    //   108: aload 5
    //   110: invokevirtual 209	com/android/a/a/f:close	()V
    //   113: aload 8
    //   115: astore 6
    //   117: goto -80 -> 37
    //   120: astore_1
    //   121: aload 8
    //   123: astore 6
    //   125: goto -88 -> 37
    //   128: aload 5
    //   130: astore 6
    //   132: aload 7
    //   134: aload 5
    //   136: aload 9
    //   138: invokevirtual 203	java/io/File:length	()J
    //   141: l2i
    //   142: aload 5
    //   144: invokestatic 206	com/android/a/a/f:a	(Lcom/android/a/a/f;)I
    //   147: isub
    //   148: invokestatic 123	com/android/a/a/d:a	(Ljava/io/InputStream;I)[B
    //   151: invokevirtual 212	com/android/a/a/e:a	([B)Lcom/android/a/c;
    //   154: astore 7
    //   156: aload 5
    //   158: ifnull +8 -> 166
    //   161: aload 5
    //   163: invokevirtual 209	com/android/a/a/f:close	()V
    //   166: aload 7
    //   168: astore 6
    //   170: goto -133 -> 37
    //   173: astore 7
    //   175: aconst_null
    //   176: astore 5
    //   178: aload 5
    //   180: astore 6
    //   182: ldc -42
    //   184: iconst_2
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload 9
    //   192: invokevirtual 217	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 7
    //   200: invokevirtual 218	java/io/IOException:toString	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 223	com/android/a/ab:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload 5
    //   209: astore 6
    //   211: aload_0
    //   212: aload_1
    //   213: invokevirtual 225	com/android/a/a/d:b	(Ljava/lang/String;)V
    //   216: aload 8
    //   218: astore 6
    //   220: aload 5
    //   222: ifnull -185 -> 37
    //   225: aload 5
    //   227: invokevirtual 209	com/android/a/a/f:close	()V
    //   230: aload 8
    //   232: astore 6
    //   234: goto -197 -> 37
    //   237: astore_1
    //   238: aload 8
    //   240: astore 6
    //   242: goto -205 -> 37
    //   245: astore_1
    //   246: aconst_null
    //   247: astore 5
    //   249: aload 8
    //   251: astore 6
    //   253: aload 5
    //   255: ifnull -218 -> 37
    //   258: aload 5
    //   260: invokevirtual 209	com/android/a/a/f:close	()V
    //   263: aload 8
    //   265: astore 6
    //   267: goto -230 -> 37
    //   270: astore_1
    //   271: aload 8
    //   273: astore 6
    //   275: goto -238 -> 37
    //   278: astore_1
    //   279: aconst_null
    //   280: astore 6
    //   282: aload 6
    //   284: ifnull +8 -> 292
    //   287: aload 6
    //   289: invokevirtual 209	com/android/a/a/f:close	()V
    //   292: aload_1
    //   293: athrow
    //   294: astore_1
    //   295: aload_0
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    //   299: astore_1
    //   300: aload 8
    //   302: astore 6
    //   304: goto -267 -> 37
    //   307: astore_1
    //   308: aload 8
    //   310: astore 6
    //   312: goto -275 -> 37
    //   315: astore_1
    //   316: goto -34 -> 282
    //   319: astore_1
    //   320: goto -71 -> 249
    //   323: astore 7
    //   325: goto -147 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	d
    //   0	328	1	paramString	String
    //   82	14	2	i	int
    //   92	4	3	j	int
    //   26	3	4	bool	boolean
    //   59	200	5	localf	f
    //   14	297	6	localObject1	Object
    //   70	97	7	localObject2	Object
    //   173	26	7	localIOException1	IOException
    //   323	1	7	localIOException2	IOException
    //   1	308	8	localObject3	Object
    //   10	181	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   108	113	120	java/io/IOException
    //   42	61	173	java/io/IOException
    //   225	230	237	java/io/IOException
    //   42	61	245	java/lang/OutOfMemoryError
    //   258	263	270	java/io/IOException
    //   42	61	278	finally
    //   5	12	294	finally
    //   21	28	294	finally
    //   108	113	294	finally
    //   161	166	294	finally
    //   225	230	294	finally
    //   258	263	294	finally
    //   287	292	294	finally
    //   292	294	294	finally
    //   161	166	299	java/io/IOException
    //   287	292	307	java/io/IOException
    //   65	72	315	finally
    //   76	83	315	finally
    //   87	93	315	finally
    //   132	156	315	finally
    //   182	207	315	finally
    //   211	216	315	finally
    //   65	72	319	java/lang/OutOfMemoryError
    //   76	83	319	java/lang/OutOfMemoryError
    //   87	93	319	java/lang/OutOfMemoryError
    //   132	156	319	java/lang/OutOfMemoryError
    //   65	72	323	java/io/IOException
    //   76	83	323	java/io/IOException
    //   87	93	323	java/io/IOException
    //   132	156	323	java/io/IOException
  }
  
  public void a()
  {
    try
    {
      if ((!this.a.exists()) && (!this.a.mkdirs())) {
        ab.c("Unable to create cache dir %s", new Object[] { this.a.getAbsolutePath() });
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void a(String paramString, com.android.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 180	com/android/a/a/d:c	(Ljava/lang/String;)Ljava/io/File;
    //   7: astore_3
    //   8: new 235	java/io/FileOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 236	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore 4
    //   18: new 197	com/android/a/a/e
    //   21: dup
    //   22: aload_1
    //   23: aload_2
    //   24: invokespecial 238	com/android/a/a/e:<init>	(Ljava/lang/String;Lcom/android/a/c;)V
    //   27: aload 4
    //   29: invokevirtual 241	com/android/a/a/e:a	(Ljava/io/OutputStream;)Z
    //   32: pop
    //   33: aload 4
    //   35: aload_2
    //   36: getfield 246	com/android/a/c:a	[B
    //   39: invokevirtual 249	java/io/FileOutputStream:write	([B)V
    //   42: aload 4
    //   44: invokevirtual 250	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: aload_3
    //   52: invokevirtual 253	java/io/File:delete	()Z
    //   55: ifne -8 -> 47
    //   58: ldc -1
    //   60: iconst_1
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_3
    //   67: invokevirtual 217	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   70: aastore
    //   71: invokestatic 223	com/android/a/ab:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: goto -27 -> 47
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	d
    //   0	82	1	paramString	String
    //   0	82	2	paramc	com.android.a.c
    //   7	60	3	localFile	File
    //   16	27	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   8	47	50	java/io/IOException
    //   2	8	77	finally
    //   8	47	77	finally
    //   51	74	77	finally
  }
  
  public void b(String paramString)
  {
    try
    {
      if (!c(paramString).delete()) {
        ab.b("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, d(paramString) });
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public File c(String paramString)
  {
    return new File(this.a, d(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */