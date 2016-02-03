package com.badlogic.gdx.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class r
{
  public static boolean a = System.getProperty("os.name").contains("Windows");
  public static boolean b = System.getProperty("os.name").contains("Linux");
  public static boolean c = System.getProperty("os.name").contains("Mac");
  public static boolean d = false;
  public static boolean e = false;
  public static boolean f = System.getProperty("os.arch").equals("amd64");
  private static final HashSet<String> g = new HashSet();
  private String h;
  
  static
  {
    String str = System.getProperty("java.vm.name");
    if ((str != null) && (str.contains("Dalvik")))
    {
      e = true;
      a = false;
      b = false;
      c = false;
      f = false;
    }
    if ((!e) && (!a) && (!b) && (!c))
    {
      d = true;
      f = false;
    }
  }
  
  /* Error */
  private File a(String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: aload_3
    //   8: invokevirtual 82	java/io/File:exists	()Z
    //   11: ifeq +17 -> 28
    //   14: aload_0
    //   15: new 84	java/io/FileInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: invokevirtual 90	com/badlogic/gdx/utils/r:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore 5
    //   28: aload 5
    //   30: ifnull +12 -> 42
    //   33: aload 5
    //   35: aload_2
    //   36: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne +122 -> 161
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 93	com/badlogic/gdx/utils/r:c	(Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore_2
    //   48: aload_3
    //   49: invokevirtual 97	java/io/File:getParentFile	()Ljava/io/File;
    //   52: invokevirtual 100	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: new 102	java/io/FileOutputStream
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: astore 5
    //   66: sipush 4096
    //   69: newarray <illegal type>
    //   71: astore 6
    //   73: aload_2
    //   74: aload 6
    //   76: invokevirtual 109	java/io/InputStream:read	([B)I
    //   79: istore 4
    //   81: iload 4
    //   83: iconst_m1
    //   84: if_icmpne +14 -> 98
    //   87: aload_2
    //   88: invokevirtual 112	java/io/InputStream:close	()V
    //   91: aload 5
    //   93: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   96: aload_3
    //   97: areturn
    //   98: aload 5
    //   100: aload 6
    //   102: iconst_0
    //   103: iload 4
    //   105: invokevirtual 117	java/io/FileOutputStream:write	([BII)V
    //   108: goto -35 -> 73
    //   111: astore_2
    //   112: new 119	com/badlogic/gdx/utils/f
    //   115: dup
    //   116: new 121	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   123: ldc 124
    //   125: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc -126
    //   134: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_3
    //   138: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   141: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: aload_2
    //   148: invokespecial 140	com/badlogic/gdx/utils/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: athrow
    //   152: astore 5
    //   154: aload 6
    //   156: astore 5
    //   158: goto -130 -> 28
    //   161: aload_3
    //   162: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	r
    //   0	163	1	paramString1	String
    //   0	163	2	paramString2	String
    //   0	163	3	paramFile	File
    //   79	25	4	i	int
    //   5	94	5	localObject	Object
    //   152	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   156	1	5	arrayOfByte1	byte[]
    //   1	154	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	73	111	java/io/IOException
    //   73	81	111	java/io/IOException
    //   87	96	111	java/io/IOException
    //   98	108	111	java/io/IOException
    //   14	28	152	java/io/FileNotFoundException
  }
  
  private Throwable b(String paramString1, String paramString2, File paramFile)
  {
    try
    {
      System.load(a(paramString1, paramString2, paramFile).getAbsolutePath());
      return null;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString1;
  }
  
  private InputStream c(String paramString)
  {
    Object localObject2;
    Object localObject1;
    InputStream localInputStream;
    if (this.h == null)
    {
      localObject2 = r.class.getResourceAsStream("/" + paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        throw new f("Unable to read file for extraction: " + paramString);
      }
    }
    else
    {
      try
      {
        localObject1 = new ZipFile(this.h);
        localObject2 = ((ZipFile)localObject1).getEntry(paramString);
        if (localObject2 == null) {
          throw new f("Couldn't find '" + paramString + "' in JAR: " + this.h);
        }
      }
      catch (IOException localIOException)
      {
        throw new f("Error reading '" + paramString + "' in JAR: " + this.h, localIOException);
      }
      localInputStream = localIOException.getInputStream((ZipEntry)localObject2);
    }
    return localInputStream;
  }
  
  private void d(String paramString)
  {
    String str1 = a(c(paramString));
    String str2 = new File(paramString).getName();
    Throwable localThrowable1 = b(paramString, str1, new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + str1, str2));
    if (localThrowable1 == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject = File.createTempFile(str1, null);
          if (((File)localObject).delete())
          {
            localObject = b(paramString, str1, (File)localObject);
            if (localObject == null) {
              continue;
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;) {}
        }
      }
    } while ((b(paramString, str1, new File(System.getProperty("user.home") + "/.libgdx/" + str1, str2)) == null) || (b(paramString, str1, new File(".temp/" + str1, str2)) == null));
    paramString = new File(System.getProperty("java.library.path"), paramString);
    if (paramString.exists())
    {
      System.load(paramString.getAbsolutePath());
      return;
    }
    throw new f(localThrowable1);
  }
  
  public String a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("input cannot be null.");
    }
    CRC32 localCRC32 = new CRC32();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      try
      {
        i = paramInputStream.read(arrayOfByte);
        if (i != -1) {
          continue;
        }
      }
      catch (Exception localException)
      {
        int i;
        s.a(paramInputStream);
        continue;
      }
      return Long.toString(localCRC32.getValue(), 16);
      localCRC32.update(arrayOfByte, 0, i);
    }
  }
  
  public String a(String paramString)
  {
    Object localObject;
    if (a)
    {
      localObject = new StringBuilder().append(paramString);
      if (f)
      {
        paramString = "64.dll";
        localObject = paramString;
      }
    }
    do
    {
      return (String)localObject;
      paramString = ".dll";
      break;
      if (b)
      {
        localObject = new StringBuilder().append("lib").append(paramString);
        if (f) {}
        for (paramString = "64.so";; paramString = ".so") {
          return paramString;
        }
      }
      localObject = paramString;
    } while (!c);
    return "lib" + paramString + ".dylib";
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 46	com/badlogic/gdx/utils/r:d	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 256	com/badlogic/gdx/utils/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: getstatic 69	com/badlogic/gdx/utils/r:g	Ljava/util/HashSet;
    //   22: aload_1
    //   23: invokevirtual 258	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifne -18 -> 10
    //   31: getstatic 48	com/badlogic/gdx/utils/r:e	Z
    //   34: ifeq +23 -> 57
    //   37: aload_1
    //   38: invokestatic 261	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   41: getstatic 69	com/badlogic/gdx/utils/r:g	Ljava/util/HashSet;
    //   44: aload_1
    //   45: invokevirtual 264	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: goto -39 -> 10
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 266	com/badlogic/gdx/utils/r:d	(Ljava/lang/String;)V
    //   62: goto -21 -> 41
    //   65: astore_3
    //   66: new 121	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 268
    //   76: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 270
    //   86: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 20
    //   91: invokestatic 26	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: astore 4
    //   99: getstatic 58	com/badlogic/gdx/utils/r:f	Z
    //   102: ifeq +25 -> 127
    //   105: ldc_w 272
    //   108: astore_1
    //   109: new 119	com/badlogic/gdx/utils/f
    //   112: dup
    //   113: aload 4
    //   115: aload_1
    //   116: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aload_3
    //   123: invokespecial 140	com/badlogic/gdx/utils/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: athrow
    //   127: ldc_w 274
    //   130: astore_1
    //   131: goto -22 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	r
    //   0	134	1	paramString	String
    //   5	23	2	bool	boolean
    //   65	58	3	localThrowable	Throwable
    //   97	17	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	6	52	finally
    //   13	27	52	finally
    //   31	41	52	finally
    //   41	49	52	finally
    //   57	62	52	finally
    //   66	105	52	finally
    //   109	127	52	finally
    //   31	41	65	java/lang/Throwable
    //   57	62	65	java/lang/Throwable
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */