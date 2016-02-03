package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ez
public class go
{
  public static final a<Void> wy = new a()
  {
    public Void c(InputStream paramAnonymousInputStream)
    {
      return null;
    }
    
    public Void dr()
    {
      return null;
    }
  };
  
  public <T> Future<T> a(final String paramString, final a<T> parama)
  {
    gi.submit(new Callable()
    {
      /* Error */
      public T call()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore_2
        //   5: aconst_null
        //   6: astore 4
        //   8: new 38	java/net/URL
        //   11: dup
        //   12: aload_0
        //   13: getfield 24	com/google/android/gms/internal/go$2:wz	Ljava/lang/String;
        //   16: invokespecial 41	java/net/URL:<init>	(Ljava/lang/String;)V
        //   19: invokevirtual 45	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   22: checkcast 47	java/net/HttpURLConnection
        //   25: astore_3
        //   26: aload_3
        //   27: invokevirtual 50	java/net/HttpURLConnection:connect	()V
        //   30: aload_3
        //   31: invokevirtual 54	java/net/HttpURLConnection:getResponseCode	()I
        //   34: istore_1
        //   35: iload_1
        //   36: sipush 200
        //   39: if_icmplt +34 -> 73
        //   42: iload_1
        //   43: sipush 299
        //   46: if_icmpgt +27 -> 73
        //   49: aload_0
        //   50: getfield 26	com/google/android/gms/internal/go$2:wA	Lcom/google/android/gms/internal/go$a;
        //   53: aload_3
        //   54: invokevirtual 58	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   57: invokeinterface 64 2 0
        //   62: astore_2
        //   63: aload_3
        //   64: ifnull +7 -> 71
        //   67: aload_3
        //   68: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
        //   71: aload_2
        //   72: areturn
        //   73: aload_3
        //   74: ifnull +7 -> 81
        //   77: aload_3
        //   78: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
        //   81: aload_0
        //   82: getfield 26	com/google/android/gms/internal/go$2:wA	Lcom/google/android/gms/internal/go$a;
        //   85: invokeinterface 70 1 0
        //   90: areturn
        //   91: astore_2
        //   92: aload 4
        //   94: astore_3
        //   95: aload_2
        //   96: astore 4
        //   98: aload_3
        //   99: astore_2
        //   100: ldc 72
        //   102: aload 4
        //   104: invokestatic 78	com/google/android/gms/internal/gs:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   107: aload_3
        //   108: ifnull -27 -> 81
        //   111: aload_3
        //   112: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
        //   115: goto -34 -> 81
        //   118: astore 4
        //   120: aload 5
        //   122: astore_3
        //   123: aload_3
        //   124: astore_2
        //   125: ldc 72
        //   127: aload 4
        //   129: invokestatic 78	com/google/android/gms/internal/gs:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   132: aload_3
        //   133: ifnull -52 -> 81
        //   136: aload_3
        //   137: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
        //   140: goto -59 -> 81
        //   143: astore 4
        //   145: aload_2
        //   146: astore_3
        //   147: aload 4
        //   149: astore_2
        //   150: aload_3
        //   151: ifnull +7 -> 158
        //   154: aload_3
        //   155: invokevirtual 67	java/net/HttpURLConnection:disconnect	()V
        //   158: aload_2
        //   159: athrow
        //   160: astore_2
        //   161: goto -11 -> 150
        //   164: astore 4
        //   166: goto -43 -> 123
        //   169: astore 4
        //   171: goto -73 -> 98
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	174	0	this	2
        //   34	13	1	i	int
        //   4	68	2	localObject1	Object
        //   91	5	2	localMalformedURLException1	java.net.MalformedURLException
        //   99	60	2	localObject2	Object
        //   160	1	2	localObject3	Object
        //   25	130	3	localObject4	Object
        //   6	97	4	localMalformedURLException2	java.net.MalformedURLException
        //   118	10	4	localIOException1	java.io.IOException
        //   143	5	4	localObject5	Object
        //   164	1	4	localIOException2	java.io.IOException
        //   169	1	4	localMalformedURLException3	java.net.MalformedURLException
        //   1	120	5	localObject6	Object
        // Exception table:
        //   from	to	target	type
        //   8	26	91	java/net/MalformedURLException
        //   8	26	118	java/io/IOException
        //   8	26	143	finally
        //   100	107	143	finally
        //   125	132	143	finally
        //   26	35	160	finally
        //   49	63	160	finally
        //   26	35	164	java/io/IOException
        //   49	63	164	java/io/IOException
        //   26	35	169	java/net/MalformedURLException
        //   49	63	169	java/net/MalformedURLException
      }
    });
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(InputStream paramInputStream);
    
    public abstract T cK();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */