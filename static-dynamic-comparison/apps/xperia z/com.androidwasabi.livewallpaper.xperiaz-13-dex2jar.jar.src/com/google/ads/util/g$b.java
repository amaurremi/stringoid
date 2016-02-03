package com.google.ads.util;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.google.ads.internal.d;
import com.google.ads.internal.i;
import com.google.ads.o;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class g$b
  extends i
{
  public g$b(d paramd, Map<String, o> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramd, paramMap, paramBoolean1, paramBoolean2);
  }
  
  private static WebResourceResponse a(String paramString, Context paramContext)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    try
    {
      AdUtil.a(paramString, paramContext.getApplicationContext());
      paramString.connect();
      paramContext = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(AdUtil.a(new InputStreamReader(paramString.getInputStream())).getBytes("UTF-8")));
      return paramContext;
    }
    finally
    {
      paramString.disconnect();
    }
  }
  
  /* Error */
  public WebResourceResponse shouldInterceptRequest(android.webkit.WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: ldc 82
    //   2: new 84	java/io/File
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 89	java/io/File:getName	()Ljava/lang/String;
    //   13: invokevirtual 93	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   16: ifeq +131 -> 147
    //   19: aload_0
    //   20: getfield 96	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
    //   23: invokevirtual 102	com/google/ads/internal/d:k	()Lcom/google/ads/internal/c;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +101 -> 129
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 108	com/google/ads/internal/c:c	(Z)V
    //   36: aload_0
    //   37: getfield 96	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
    //   40: invokevirtual 112	com/google/ads/internal/d:i	()Lcom/google/ads/n;
    //   43: getfield 118	com/google/ads/n:d	Lcom/google/ads/util/i$b;
    //   46: invokevirtual 123	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   49: checkcast 125	com/google/ads/m
    //   52: getfield 128	com/google/ads/m:b	Lcom/google/ads/util/i$b;
    //   55: invokevirtual 123	com/google/ads/util/i$b:a	()Ljava/lang/Object;
    //   58: checkcast 130	com/google/ads/m$a
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 96	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
    //   66: invokevirtual 112	com/google/ads/internal/d:i	()Lcom/google/ads/n;
    //   69: invokevirtual 133	com/google/ads/n:b	()Z
    //   72: ifne +129 -> 201
    //   75: aload_0
    //   76: getfield 136	com/google/ads/util/g$b:b	Z
    //   79: ifeq +75 -> 154
    //   82: aload_3
    //   83: getfield 140	com/google/ads/m$a:f	Lcom/google/ads/util/i$c;
    //   86: invokevirtual 143	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   89: checkcast 61	java/lang/String
    //   92: astore_3
    //   93: new 145	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   100: ldc -107
    //   102: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc -101
    //   111: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 162	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   120: aload_3
    //   121: aload_1
    //   122: invokevirtual 167	android/webkit/WebView:getContext	()Landroid/content/Context;
    //   125: invokestatic 169	com/google/ads/util/g$b:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
    //   128: areturn
    //   129: aload_0
    //   130: getfield 96	com/google/ads/util/g$b:a	Lcom/google/ads/internal/d;
    //   133: iconst_1
    //   134: invokevirtual 171	com/google/ads/internal/d:a	(Z)V
    //   137: goto -101 -> 36
    //   140: astore_3
    //   141: ldc -83
    //   143: aload_3
    //   144: invokestatic 176	com/google/ads/util/b:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload_0
    //   148: aload_1
    //   149: aload_2
    //   150: invokespecial 178	com/google/ads/internal/i:shouldInterceptRequest	(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   153: areturn
    //   154: aload_3
    //   155: getfield 181	com/google/ads/m$a:e	Lcom/google/ads/util/i$c;
    //   158: invokevirtual 143	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   161: checkcast 61	java/lang/String
    //   164: astore_3
    //   165: new 145	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   172: ldc -107
    //   174: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc -101
    //   183: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 162	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   192: aload_3
    //   193: aload_1
    //   194: invokevirtual 167	android/webkit/WebView:getContext	()Landroid/content/Context;
    //   197: invokestatic 169	com/google/ads/util/g$b:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
    //   200: areturn
    //   201: aload_3
    //   202: getfield 184	com/google/ads/m$a:g	Lcom/google/ads/util/i$c;
    //   205: invokevirtual 143	com/google/ads/util/i$c:a	()Ljava/lang/Object;
    //   208: checkcast 61	java/lang/String
    //   211: astore_3
    //   212: new 145	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   219: ldc -107
    //   221: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_3
    //   225: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc -101
    //   230: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 162	com/google/ads/util/b:a	(Ljava/lang/String;)V
    //   239: aload_3
    //   240: aload_1
    //   241: invokevirtual 167	android/webkit/WebView:getContext	()Landroid/content/Context;
    //   244: invokestatic 169	com/google/ads/util/g$b:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/webkit/WebResourceResponse;
    //   247: astore_3
    //   248: aload_3
    //   249: areturn
    //   250: astore_3
    //   251: ldc -70
    //   253: aload_3
    //   254: invokestatic 176	com/google/ads/util/b:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -110 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	b
    //   0	260	1	paramWebView	android.webkit.WebView
    //   0	260	2	paramString	String
    //   26	95	3	localObject1	Object
    //   140	15	3	localIOException	java.io.IOException
    //   164	85	3	localObject2	Object
    //   250	4	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	27	140	java/io/IOException
    //   31	36	140	java/io/IOException
    //   36	129	140	java/io/IOException
    //   129	137	140	java/io/IOException
    //   154	201	140	java/io/IOException
    //   201	248	140	java/io/IOException
    //   0	27	250	java/lang/Throwable
    //   31	36	250	java/lang/Throwable
    //   36	129	250	java/lang/Throwable
    //   129	137	250	java/lang/Throwable
    //   154	201	250	java/lang/Throwable
    //   201	248	250	java/lang/Throwable
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/util/g$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */