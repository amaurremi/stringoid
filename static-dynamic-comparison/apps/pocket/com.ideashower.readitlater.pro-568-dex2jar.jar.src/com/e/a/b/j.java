package com.e.a.b;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.net.ssl.SSLSocket;

public class j
{
  private static final j a = ;
  private Constructor b;
  
  public static j a()
  {
    return a;
  }
  
  /* Error */
  private static j c()
  {
    // Byte code:
    //   0: ldc 28
    //   2: ldc 30
    //   4: iconst_0
    //   5: anewarray 32	java/lang/Class
    //   8: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   11: astore_1
    //   12: ldc 38
    //   14: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 44
    //   21: iconst_1
    //   22: anewarray 32	java/lang/Class
    //   25: dup
    //   26: iconst_0
    //   27: getstatic 50	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   30: aastore
    //   31: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: astore_2
    //   35: aload_0
    //   36: ldc 52
    //   38: iconst_1
    //   39: anewarray 32	java/lang/Class
    //   42: dup
    //   43: iconst_0
    //   44: ldc 54
    //   46: aastore
    //   47: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   50: astore_3
    //   51: new 56	com/e/a/b/l
    //   54: dup
    //   55: aload_1
    //   56: aload_0
    //   57: aload_2
    //   58: aload_3
    //   59: aload_0
    //   60: ldc 58
    //   62: iconst_1
    //   63: anewarray 32	java/lang/Class
    //   66: dup
    //   67: iconst_0
    //   68: ldc 60
    //   70: aastore
    //   71: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   74: aload_0
    //   75: ldc 62
    //   77: iconst_0
    //   78: anewarray 32	java/lang/Class
    //   81: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   84: aconst_null
    //   85: invokespecial 65	com/e/a/b/l:<init>	(Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/e/a/b/j$1;)V
    //   88: astore 4
    //   90: aload 4
    //   92: areturn
    //   93: astore_0
    //   94: new 2	com/e/a/b/j
    //   97: dup
    //   98: invokespecial 66	com/e/a/b/j:<init>	()V
    //   101: areturn
    //   102: astore_0
    //   103: ldc 68
    //   105: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   108: astore_0
    //   109: goto -91 -> 18
    //   112: astore 4
    //   114: new 70	com/e/a/b/k
    //   117: dup
    //   118: aload_1
    //   119: aload_0
    //   120: aload_2
    //   121: aload_3
    //   122: aconst_null
    //   123: invokespecial 73	com/e/a/b/k:<init>	(Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/e/a/b/j$1;)V
    //   126: astore_0
    //   127: aload_0
    //   128: areturn
    //   129: astore_0
    //   130: ldc 75
    //   132: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   135: astore_0
    //   136: new 77	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   143: ldc 75
    //   145: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 84
    //   150: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   159: astore_2
    //   160: new 77	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   167: ldc 75
    //   169: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 90
    //   174: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   183: astore_3
    //   184: new 77	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   191: ldc 75
    //   193: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 92
    //   198: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 42	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   207: astore 4
    //   209: new 94	com/e/a/b/n
    //   212: dup
    //   213: aload_1
    //   214: aload_0
    //   215: ldc 96
    //   217: iconst_2
    //   218: anewarray 32	java/lang/Class
    //   221: dup
    //   222: iconst_0
    //   223: ldc 98
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload_2
    //   229: aastore
    //   230: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   233: aload_0
    //   234: ldc 100
    //   236: iconst_1
    //   237: anewarray 32	java/lang/Class
    //   240: dup
    //   241: iconst_0
    //   242: ldc 98
    //   244: aastore
    //   245: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   248: aload_3
    //   249: aload 4
    //   251: invokespecial 103	com/e/a/b/n:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   254: astore_0
    //   255: aload_0
    //   256: areturn
    //   257: astore_0
    //   258: new 105	com/e/a/b/m
    //   261: dup
    //   262: aload_1
    //   263: aconst_null
    //   264: invokespecial 108	com/e/a/b/m:<init>	(Ljava/lang/reflect/Method;Lcom/e/a/b/j$1;)V
    //   267: areturn
    //   268: astore_0
    //   269: goto -11 -> 258
    //   272: astore_0
    //   273: goto -143 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	58	0	localClass1	Class
    //   93	1	0	localNoSuchMethodException1	NoSuchMethodException
    //   102	1	0	localClassNotFoundException1	ClassNotFoundException
    //   108	20	0	localObject1	Object
    //   129	1	0	localClassNotFoundException2	ClassNotFoundException
    //   135	121	0	localObject2	Object
    //   257	1	0	localClassNotFoundException3	ClassNotFoundException
    //   268	1	0	localNoSuchMethodException2	NoSuchMethodException
    //   272	1	0	localNoSuchMethodException3	NoSuchMethodException
    //   11	252	1	localMethod	java.lang.reflect.Method
    //   34	195	2	localObject3	Object
    //   50	199	3	localObject4	Object
    //   88	3	4	locall	l
    //   112	1	4	localNoSuchMethodException4	NoSuchMethodException
    //   207	43	4	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   0	12	93	java/lang/NoSuchMethodException
    //   12	18	102	java/lang/ClassNotFoundException
    //   51	90	112	java/lang/NoSuchMethodException
    //   18	51	129	java/lang/ClassNotFoundException
    //   51	90	129	java/lang/ClassNotFoundException
    //   103	109	129	java/lang/ClassNotFoundException
    //   114	127	129	java/lang/ClassNotFoundException
    //   130	255	257	java/lang/ClassNotFoundException
    //   130	255	268	java/lang/NoSuchMethodException
    //   12	18	272	java/lang/NoSuchMethodException
    //   18	51	272	java/lang/NoSuchMethodException
    //   103	109	272	java/lang/NoSuchMethodException
    //   114	127	272	java/lang/NoSuchMethodException
  }
  
  public OutputStream a(OutputStream paramOutputStream, Deflater paramDeflater, boolean paramBoolean)
  {
    try
    {
      Constructor localConstructor2 = this.b;
      Constructor localConstructor1 = localConstructor2;
      if (localConstructor2 == null)
      {
        localConstructor1 = DeflaterOutputStream.class.getConstructor(new Class[] { OutputStream.class, Deflater.class, Boolean.TYPE });
        this.b = localConstructor1;
      }
      paramOutputStream = (OutputStream)localConstructor1.newInstance(new Object[] { paramOutputStream, paramDeflater, Boolean.valueOf(paramBoolean) });
      return paramOutputStream;
    }
    catch (NoSuchMethodException paramOutputStream)
    {
      throw new UnsupportedOperationException("Cannot SPDY; no SYNC_FLUSH available");
    }
    catch (InvocationTargetException paramOutputStream)
    {
      if ((paramOutputStream.getCause() instanceof RuntimeException)) {}
      for (paramOutputStream = (RuntimeException)paramOutputStream.getCause();; paramOutputStream = new RuntimeException(paramOutputStream.getCause())) {
        throw paramOutputStream;
      }
    }
    catch (InstantiationException paramOutputStream)
    {
      throw new RuntimeException(paramOutputStream);
    }
    catch (IllegalAccessException paramOutputStream)
    {
      throw new AssertionError();
    }
  }
  
  public URI a(URL paramURL)
  {
    return paramURL.toURI();
  }
  
  public void a(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void a(Socket paramSocket) {}
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket)
  {
    paramSSLSocket.setEnabledProtocols(new String[] { "SSLv3" });
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString) {}
  
  public void a(SSLSocket paramSSLSocket, byte[] paramArrayOfByte) {}
  
  public String b()
  {
    return "OkHttp";
  }
  
  public void b(Socket paramSocket) {}
  
  public byte[] b(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public int c(Socket paramSocket)
  {
    return 1400;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */