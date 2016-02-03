package org.apache.a.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class b
{
  public static final BigInteger a = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
  public static final BigInteger b = a.multiply(BigInteger.valueOf(1152921504606846976L));
  public static final File[] c = new File[0];
  private static final Charset d = Charset.forName("UTF-8");
  
  public static FileInputStream a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream a(File paramFile, boolean paramBoolean)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
        throw new IOException("Directory '" + localFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  public static String a(File paramFile, String paramString)
  {
    return a(paramFile, a.a(paramString));
  }
  
  public static String a(File paramFile, Charset paramCharset)
  {
    File localFile = null;
    try
    {
      paramFile = a(paramFile);
      localFile = paramFile;
      paramCharset = d.a(paramFile, a.a(paramCharset));
      return paramCharset;
    }
    finally
    {
      d.a(localFile);
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    a(paramFile1, paramFile2, true);
  }
  
  public static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    b(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte)
  {
    a(paramFile, paramArrayOfByte, false);
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    File localFile = null;
    try
    {
      paramFile = a(paramFile, paramBoolean);
      localFile = paramFile;
      paramFile.write(paramArrayOfByte);
      localFile = paramFile;
      paramFile.close();
      return;
    }
    finally
    {
      d.a(localFile);
    }
  }
  
  public static void b(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      if (!j(paramFile)) {
        d(paramFile);
      }
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  /* Error */
  private static void b(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aload_1
    //   4: invokevirtual 51	java/io/File:exists	()Z
    //   7: ifeq +42 -> 49
    //   10: aload_1
    //   11: invokevirtual 54	java/io/File:isDirectory	()Z
    //   14: ifeq +35 -> 49
    //   17: new 56	java/io/IOException
    //   20: dup
    //   21: new 58	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   28: ldc -91
    //   30: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 72
    //   39: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 79	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: new 91	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore 9
    //   59: new 113	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 203	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore 10
    //   69: aload 9
    //   71: invokevirtual 207	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   74: astore 11
    //   76: aload 10
    //   78: invokevirtual 208	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   81: astore 13
    //   83: aload 11
    //   85: invokevirtual 214	java/nio/channels/FileChannel:size	()J
    //   88: lstore 7
    //   90: lconst_0
    //   91: lstore_3
    //   92: goto +233 -> 325
    //   95: aload 13
    //   97: aload 11
    //   99: lload_3
    //   100: lload 5
    //   102: invokevirtual 218	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   105: lstore 5
    //   107: lload_3
    //   108: lload 5
    //   110: ladd
    //   111: lstore_3
    //   112: goto +213 -> 325
    //   115: lload 7
    //   117: lload_3
    //   118: lsub
    //   119: lstore 5
    //   121: goto -26 -> 95
    //   124: aload 13
    //   126: invokestatic 221	org/apache/a/b/d:a	(Ljava/io/Closeable;)V
    //   129: aload 10
    //   131: invokestatic 189	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
    //   134: aload 11
    //   136: invokestatic 221	org/apache/a/b/d:a	(Ljava/io/Closeable;)V
    //   139: aload 9
    //   141: invokestatic 137	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   144: aload_0
    //   145: invokevirtual 224	java/io/File:length	()J
    //   148: aload_1
    //   149: invokevirtual 224	java/io/File:length	()J
    //   152: lcmp
    //   153: ifeq +78 -> 231
    //   156: new 56	java/io/IOException
    //   159: dup
    //   160: new 58	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   167: ldc -30
    //   169: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   176: ldc -28
    //   178: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: ldc -26
    //   187: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokespecial 79	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: astore_0
    //   198: aconst_null
    //   199: astore_1
    //   200: aconst_null
    //   201: astore 9
    //   203: aconst_null
    //   204: astore 10
    //   206: aload 13
    //   208: astore 11
    //   210: aload_1
    //   211: invokestatic 221	org/apache/a/b/d:a	(Ljava/io/Closeable;)V
    //   214: aload 9
    //   216: invokestatic 189	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
    //   219: aload 11
    //   221: invokestatic 221	org/apache/a/b/d:a	(Ljava/io/Closeable;)V
    //   224: aload 10
    //   226: invokestatic 137	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   229: aload_0
    //   230: athrow
    //   231: iload_2
    //   232: ifeq +12 -> 244
    //   235: aload_1
    //   236: aload_0
    //   237: invokevirtual 233	java/io/File:lastModified	()J
    //   240: invokevirtual 237	java/io/File:setLastModified	(J)Z
    //   243: pop
    //   244: return
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_1
    //   248: aconst_null
    //   249: astore 12
    //   251: aload 9
    //   253: astore 10
    //   255: aload 13
    //   257: astore 11
    //   259: aload 12
    //   261: astore 9
    //   263: goto -53 -> 210
    //   266: astore_0
    //   267: aconst_null
    //   268: astore_1
    //   269: aload 9
    //   271: astore 12
    //   273: aload 13
    //   275: astore 11
    //   277: aload 10
    //   279: astore 9
    //   281: aload 12
    //   283: astore 10
    //   285: goto -75 -> 210
    //   288: astore_0
    //   289: aload 9
    //   291: astore 12
    //   293: aconst_null
    //   294: astore_1
    //   295: aload 10
    //   297: astore 9
    //   299: aload 12
    //   301: astore 10
    //   303: goto -93 -> 210
    //   306: astore_0
    //   307: aload 9
    //   309: astore 12
    //   311: aload 13
    //   313: astore_1
    //   314: aload 10
    //   316: astore 9
    //   318: aload 12
    //   320: astore 10
    //   322: goto -112 -> 210
    //   325: lload_3
    //   326: lload 7
    //   328: lcmp
    //   329: ifge -205 -> 124
    //   332: lload 7
    //   334: lload_3
    //   335: lsub
    //   336: ldc2_w 238
    //   339: lcmp
    //   340: ifle -225 -> 115
    //   343: ldc2_w 238
    //   346: lstore 5
    //   348: goto -253 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramFile1	File
    //   0	351	1	paramFile2	File
    //   0	351	2	paramBoolean	boolean
    //   91	244	3	l1	long
    //   100	1	5	localObject1	Object
    //   105	242	5	l2	long
    //   88	245	7	l3	long
    //   57	260	9	localObject2	Object
    //   67	254	10	localObject3	Object
    //   74	202	11	localFileChannel1	java.nio.channels.FileChannel
    //   249	70	12	localObject4	Object
    //   1	311	13	localFileChannel2	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   49	59	197	finally
    //   59	69	245	finally
    //   69	76	266	finally
    //   76	83	288	finally
    //   83	90	306	finally
    //   95	107	306	finally
  }
  
  public static boolean c(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        d(paramFile);
      }
      try
      {
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static void d(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        f(localFile);
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        for (;;) {}
      }
    }
  }
  
  public static String e(File paramFile)
  {
    return a(paramFile, Charset.defaultCharset());
  }
  
  public static void f(File paramFile)
  {
    if (paramFile.isDirectory()) {
      b(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static void g(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory()) {
        throw new IOException("File " + paramFile + " exists and is " + "not a directory. Unable to create directory.");
      }
    }
    else if ((!paramFile.mkdirs()) && (!paramFile.isDirectory())) {
      throw new IOException("Unable to create directory " + paramFile);
    }
  }
  
  public static long h(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (paramFile.isDirectory()) {
      return i(paramFile);
    }
    return paramFile.length();
  }
  
  public static long i(File paramFile)
  {
    long l1 = 0L;
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    paramFile = paramFile.listFiles();
    long l2;
    if (paramFile == null)
    {
      l2 = l1;
      return l2;
    }
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l2 = h(paramFile[i]);
      i += 1;
      l1 = l2 + l1;
    }
  }
  
  public static boolean j(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("File must not be null");
    }
    if (c.a()) {
      return false;
    }
    if (paramFile.getParent() == null) {}
    while (paramFile.getCanonicalFile().equals(paramFile.getAbsoluteFile()))
    {
      return false;
      paramFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */