package com.e.a;

import com.e.a.b.a.f;
import com.e.a.b.a.l;
import com.e.a.b.a.o;
import com.e.a.b.c;
import com.e.a.b.d;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public final class e
  extends ResponseCache
{
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  final n a;
  private final c c;
  private int d;
  private int e;
  
  private f a(URLConnection paramURLConnection)
  {
    if ((paramURLConnection instanceof l)) {
      return ((l)paramURLConnection).b();
    }
    if ((paramURLConnection instanceof o)) {
      return ((o)paramURLConnection).a();
    }
    return null;
  }
  
  private String a(URI paramURI)
  {
    try
    {
      paramURI = a(MessageDigest.getInstance("MD5").digest(paramURI.toString().getBytes("UTF-8")));
      return paramURI;
    }
    catch (NoSuchAlgorithmException paramURI)
    {
      throw new AssertionError(paramURI);
    }
    catch (UnsupportedEncodingException paramURI)
    {
      throw new AssertionError(paramURI);
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = b;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  private void a(d paramd)
  {
    if (paramd != null) {}
    try
    {
      paramd.b();
      return;
    }
    catch (IOException paramd) {}
  }
  
  private boolean a(String paramString, URI paramURI)
  {
    if ((paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("DELETE"))) {}
    try
    {
      this.c.c(a(paramURI));
      return true;
      return false;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
  }
  
  private static InputStream b(final com.e.a.b.g paramg)
  {
    new FilterInputStream(paramg.a(1))
    {
      public void close()
      {
        paramg.close();
        super.close();
      }
    };
  }
  
  public CacheResponse get(URI paramURI, String paramString, Map paramMap)
  {
    Object localObject = a(paramURI);
    try
    {
      localObject = this.c.a((String)localObject);
      if (localObject == null) {
        return null;
      }
      g localg = new g(((com.e.a.b.g)localObject).a(0));
      if (!localg.a(paramURI, paramString, paramMap))
      {
        ((com.e.a.b.g)localObject).close();
        return null;
      }
      if (g.a(localg)) {
        return new i(localg, (com.e.a.b.g)localObject);
      }
      return new h(localg, (com.e.a.b.g)localObject);
    }
    catch (IOException paramURI) {}
    return null;
  }
  
  /* Error */
  public java.net.CacheRequest put(URI paramURI, URLConnection paramURLConnection)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 163
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_2
    //   10: checkcast 163	java/net/HttpURLConnection
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 166	java/net/HttpURLConnection:getRequestMethod	()Ljava/lang/String;
    //   18: astore_3
    //   19: aload_0
    //   20: aload_3
    //   21: aload_1
    //   22: invokespecial 168	com/e/a/e:a	(Ljava/lang/String;Ljava/net/URI;)Z
    //   25: ifne -18 -> 7
    //   28: aload_3
    //   29: ldc -86
    //   31: invokevirtual 109	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq -27 -> 7
    //   37: aload_0
    //   38: aload_2
    //   39: invokespecial 172	com/e/a/e:a	(Ljava/net/URLConnection;)Lcom/e/a/b/a/f;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull -37 -> 7
    //   47: aload_3
    //   48: invokevirtual 178	com/e/a/b/a/f:h	()Lcom/e/a/b/a/u;
    //   51: astore 4
    //   53: aload 4
    //   55: invokevirtual 184	com/e/a/b/a/u:i	()Z
    //   58: ifne -51 -> 7
    //   61: new 139	com/e/a/g
    //   64: dup
    //   65: aload_1
    //   66: aload_3
    //   67: invokevirtual 188	com/e/a/b/a/f:g	()Lcom/e/a/b/a/t;
    //   70: invokevirtual 193	com/e/a/b/a/t:c	()Lcom/e/a/b/a/s;
    //   73: aload 4
    //   75: invokevirtual 196	com/e/a/b/a/u:g	()Ljava/util/Set;
    //   78: invokevirtual 201	com/e/a/b/a/s:a	(Ljava/util/Set;)Lcom/e/a/b/a/s;
    //   81: aload_2
    //   82: invokespecial 204	com/e/a/g:<init>	(Ljava/net/URI;Lcom/e/a/b/a/s;Ljava/net/HttpURLConnection;)V
    //   85: astore_2
    //   86: aload_0
    //   87: getfield 115	com/e/a/e:c	Lcom/e/a/b/c;
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 117	com/e/a/e:a	(Ljava/net/URI;)Ljava/lang/String;
    //   95: invokevirtual 207	com/e/a/b/c:b	(Ljava/lang/String;)Lcom/e/a/b/d;
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull -93 -> 7
    //   103: aload_2
    //   104: aload_1
    //   105: invokevirtual 209	com/e/a/g:a	(Lcom/e/a/b/d;)V
    //   108: new 211	com/e/a/f
    //   111: dup
    //   112: aload_0
    //   113: aload_1
    //   114: invokespecial 214	com/e/a/f:<init>	(Lcom/e/a/e;Lcom/e/a/b/d;)V
    //   117: astore_2
    //   118: aload_2
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_0
    //   124: aload_1
    //   125: invokespecial 215	com/e/a/e:a	(Lcom/e/a/b/d;)V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_2
    //   131: goto -8 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	e
    //   0	134	1	paramURI	URI
    //   0	134	2	paramURLConnection	URLConnection
    //   18	49	3	localObject	Object
    //   51	23	4	localu	com.e.a.b.a.u
    // Exception table:
    //   from	to	target	type
    //   86	99	120	java/io/IOException
    //   103	118	130	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */