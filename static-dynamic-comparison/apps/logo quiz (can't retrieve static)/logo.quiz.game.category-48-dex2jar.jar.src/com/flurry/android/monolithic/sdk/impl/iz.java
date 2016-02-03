package com.flurry.android.monolithic.sdk.impl;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.HttpParams;

public final class iz
{
  private static SchemeRegistry a;
  
  public static HttpClient a(HttpParams paramHttpParams)
  {
    return new DefaultHttpClient(paramHttpParams);
  }
  
  /* Error */
  private static SchemeRegistry a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 17	com/flurry/android/monolithic/sdk/impl/iz:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   6: ifnull +12 -> 18
    //   9: getstatic 17	com/flurry/android/monolithic/sdk/impl/iz:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 19	org/apache/http/conn/scheme/SchemeRegistry
    //   21: dup
    //   22: invokespecial 22	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   25: putstatic 17	com/flurry/android/monolithic/sdk/impl/iz:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   28: getstatic 17	com/flurry/android/monolithic/sdk/impl/iz:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   31: new 24	org/apache/http/conn/scheme/Scheme
    //   34: dup
    //   35: ldc 26
    //   37: invokestatic 32	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   40: bipush 80
    //   42: invokespecial 35	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   45: invokevirtual 39	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   48: pop
    //   49: getstatic 17	com/flurry/android/monolithic/sdk/impl/iz:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   52: new 24	org/apache/http/conn/scheme/Scheme
    //   55: dup
    //   56: ldc 41
    //   58: new 43	com/flurry/android/monolithic/sdk/impl/ix
    //   61: dup
    //   62: invokespecial 44	com/flurry/android/monolithic/sdk/impl/ix:<init>	()V
    //   65: sipush 443
    //   68: invokespecial 35	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   71: invokevirtual 39	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   74: pop
    //   75: getstatic 17	com/flurry/android/monolithic/sdk/impl/iz:a	Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   78: astore_0
    //   79: goto -66 -> 13
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	67	0	localSchemeRegistry	SchemeRegistry
    //   82	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	82	finally
    //   18	79	82	finally
  }
  
  public static HttpClient b(HttpParams paramHttpParams)
  {
    return new DefaultHttpClient(new SingleClientConnManager(paramHttpParams, a()), paramHttpParams);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */