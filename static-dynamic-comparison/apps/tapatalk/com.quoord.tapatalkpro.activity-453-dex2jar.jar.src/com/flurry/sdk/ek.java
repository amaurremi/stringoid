package com.flurry.sdk;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.HttpParams;

public final class ek {
    private static SchemeRegistry a;

    public static HttpClient a(HttpParams paramHttpParams) {
        return new DefaultHttpClient(new SingleClientConnManager(paramHttpParams, a()), paramHttpParams);
    }

    /* Error */
    private static SchemeRegistry a() {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   6: ifnull +12 -> 18
        //   9: getstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   12: astore_0
        //   13: ldc 2
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: new 26	org/apache/http/conn/scheme/SchemeRegistry
        //   21: dup
        //   22: invokespecial 29	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
        //   25: putstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   28: getstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   31: new 31	org/apache/http/conn/scheme/Scheme
        //   34: dup
        //   35: ldc 33
        //   37: invokestatic 39	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
        //   40: bipush 80
        //   42: invokespecial 42	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
        //   45: invokevirtual 46	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
        //   48: pop
        //   49: invokestatic 52	com/flurry/sdk/eo:d	()Z
        //   52: ifeq +36 -> 88
        //   55: getstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   58: new 31	org/apache/http/conn/scheme/Scheme
        //   61: dup
        //   62: ldc 54
        //   64: new 56	com/flurry/sdk/ei
        //   67: dup
        //   68: invokespecial 57	com/flurry/sdk/ei:<init>	()V
        //   71: sipush 443
        //   74: invokespecial 42	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
        //   77: invokevirtual 46	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
        //   80: pop
        //   81: getstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   84: astore_0
        //   85: goto -72 -> 13
        //   88: getstatic 24	com/flurry/sdk/ek:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
        //   91: new 31	org/apache/http/conn/scheme/Scheme
        //   94: dup
        //   95: ldc 54
        //   97: invokestatic 62	org/apache/http/conn/ssl/SSLSocketFactory:getSocketFactory	()Lorg/apache/http/conn/ssl/SSLSocketFactory;
        //   100: sipush 443
        //   103: invokespecial 42	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
        //   106: invokevirtual 46	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
        //   109: pop
        //   110: goto -29 -> 81
        //   113: astore_0
        //   114: ldc 2
        //   116: monitorexit
        //   117: aload_0
        //   118: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   12	73	0	localSchemeRegistry	SchemeRegistry
        //   113	5	0	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   3	13	113	finally
        //   18	81	113	finally
        //   81	85	113	finally
        //   88	110	113	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */