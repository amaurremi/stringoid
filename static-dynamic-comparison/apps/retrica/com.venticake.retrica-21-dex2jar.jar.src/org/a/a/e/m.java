package org.a.a.e;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.a.a.i;

public class m
  implements k
{
  private final File a;
  private final String b;
  private final ClassLoader c;
  private final Map<String, Object> d;
  
  public m(String paramString)
  {
    this(paramString, null, false);
  }
  
  private m(String paramString, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("No resource path provided");
    }
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + '/';
    }
    this.a = null;
    this.b = str;
    paramString = paramClassLoader;
    if (paramClassLoader == null)
    {
      paramString = paramClassLoader;
      if (!paramBoolean) {
        paramString = getClass().getClassLoader();
      }
    }
    this.c = paramString;
    this.d = a(b("ZoneInfoMap"));
  }
  
  /* Error */
  private static Map<String, Object> a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 82	java/util/concurrent/ConcurrentHashMap
    //   3: dup
    //   4: invokespecial 83	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   7: astore_1
    //   8: new 85	java/io/DataInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 88	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   16: astore_0
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 91	org/a/a/e/m:a	(Ljava/io/DataInputStream;Ljava/util/Map;)V
    //   22: aload_0
    //   23: invokevirtual 94	java/io/DataInputStream:close	()V
    //   26: aload_1
    //   27: ldc 96
    //   29: new 98	java/lang/ref/SoftReference
    //   32: dup
    //   33: getstatic 103	org/a/a/i:a	Lorg/a/a/i;
    //   36: invokespecial 106	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   39: invokeinterface 112 3 0
    //   44: pop
    //   45: aload_1
    //   46: areturn
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 94	java/io/DataInputStream:close	()V
    //   52: aload_1
    //   53: athrow
    //   54: astore_0
    //   55: goto -29 -> 26
    //   58: astore_0
    //   59: goto -7 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramInputStream	InputStream
    //   7	39	1	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   47	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	22	47	finally
    //   22	26	54	java/io/IOException
    //   48	52	58	java/io/IOException
  }
  
  private static void a(DataInputStream paramDataInputStream, Map<String, Object> paramMap)
  {
    int j = 0;
    int k = paramDataInputStream.readUnsignedShort();
    String[] arrayOfString = new String[k];
    int i = 0;
    while (i < k)
    {
      arrayOfString[i] = paramDataInputStream.readUTF().intern();
      i += 1;
    }
    k = paramDataInputStream.readUnsignedShort();
    i = j;
    while (i < k) {
      try
      {
        paramMap.put(arrayOfString[paramDataInputStream.readUnsignedShort()], arrayOfString[paramDataInputStream.readUnsignedShort()]);
        i += 1;
      }
      catch (ArrayIndexOutOfBoundsException paramDataInputStream)
      {
        throw new IOException("Corrupt zone info map");
      }
    }
  }
  
  private InputStream b(String paramString)
  {
    if (this.a != null) {
      localObject = new FileInputStream(new File(this.a, paramString));
    }
    String str;
    do
    {
      return (InputStream)localObject;
      str = this.b.concat(paramString);
      if (this.c == null) {
        break;
      }
      paramString = this.c.getResourceAsStream(str);
      localObject = paramString;
    } while (paramString != null);
    Object localObject = new StringBuilder(40).append("Resource not found: \"").append(str).append("\" ClassLoader: ");
    if (this.c != null) {}
    for (paramString = this.c.toString();; paramString = "system")
    {
      throw new IOException(paramString);
      paramString = ClassLoader.getSystemResourceAsStream(str);
      break;
    }
  }
  
  /* Error */
  private i c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 73	org/a/a/e/m:b	(Ljava/lang/String;)Ljava/io/InputStream;
    //   5: astore_3
    //   6: aload_3
    //   7: astore_2
    //   8: aload_3
    //   9: aload_1
    //   10: invokestatic 168	org/a/a/e/c:a	(Ljava/io/InputStream;Ljava/lang/String;)Lorg/a/a/i;
    //   13: astore 4
    //   15: aload_3
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 78	org/a/a/e/m:d	Ljava/util/Map;
    //   21: aload_1
    //   22: new 98	java/lang/ref/SoftReference
    //   25: dup
    //   26: aload 4
    //   28: invokespecial 106	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   31: invokeinterface 112 3 0
    //   36: pop
    //   37: aload_3
    //   38: ifnull +7 -> 45
    //   41: aload_3
    //   42: invokevirtual 171	java/io/InputStream:close	()V
    //   45: aload 4
    //   47: areturn
    //   48: astore 4
    //   50: aconst_null
    //   51: astore_3
    //   52: aload_3
    //   53: astore_2
    //   54: aload_0
    //   55: aload 4
    //   57: invokevirtual 174	org/a/a/e/m:a	(Ljava/lang/Exception;)V
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 78	org/a/a/e/m:d	Ljava/util/Map;
    //   66: aload_1
    //   67: invokeinterface 178 2 0
    //   72: pop
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 171	java/io/InputStream:close	()V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 171	java/io/InputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload 4
    //   99: areturn
    //   100: astore_1
    //   101: goto -20 -> 81
    //   104: astore_2
    //   105: goto -11 -> 94
    //   108: astore_1
    //   109: goto -23 -> 86
    //   112: astore 4
    //   114: goto -62 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	m
    //   0	117	1	paramString	String
    //   7	84	2	localInputStream1	InputStream
    //   104	1	2	localIOException1	IOException
    //   5	73	3	localInputStream2	InputStream
    //   13	33	4	locali	i
    //   48	50	4	localIOException2	IOException
    //   112	1	4	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   0	6	48	java/io/IOException
    //   0	6	83	finally
    //   41	45	96	java/io/IOException
    //   77	81	100	java/io/IOException
    //   90	94	104	java/io/IOException
    //   8	15	108	finally
    //   17	37	108	finally
    //   54	60	108	finally
    //   62	73	108	finally
    //   8	15	112	java/io/IOException
    //   17	37	112	java/io/IOException
  }
  
  public Set<String> a()
  {
    return new TreeSet(this.d.keySet());
  }
  
  public i a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    i locali;
    do
    {
      return (i)localObject;
      localObject = this.d.get(paramString);
      if (localObject == null) {
        return null;
      }
      if (paramString.equals(localObject)) {
        return c(paramString);
      }
      if (!(localObject instanceof SoftReference)) {
        break;
      }
      locali = (i)((SoftReference)localObject).get();
      localObject = locali;
    } while (locali != null);
    return c(paramString);
    return a((String)localObject);
  }
  
  protected void a(Exception paramException)
  {
    Thread localThread = Thread.currentThread();
    localThread.getThreadGroup().uncaughtException(localThread, paramException);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */