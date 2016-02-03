package com.chartboost.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.b;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;

public final class m
{
  private static m c;
  private a a;
  private a b;
  
  private m(a parama)
  {
    this.a = parama;
  }
  
  public static m a(a parama)
  {
    if (c == null) {
      c = new m(parama);
    }
    return c;
  }
  
  private void a(String paramString, Context paramContext)
  {
    this.b.c = a.b.g;
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = Chartboost.sharedChartboost().getContext();
    }
    if (localContext == null) {
      if (this.a != null) {
        this.a.a(this.b, false, paramString, CBError.CBClickError.NO_HOST_ACTIVITY);
      }
    }
    for (;;)
    {
      return;
      try
      {
        paramContext = new Intent("android.intent.action.VIEW");
        if (!(localContext instanceof Activity)) {
          paramContext.addFlags(268435456);
        }
        paramContext.setData(Uri.parse(paramString));
        localContext.startActivity(paramContext);
        paramContext = paramString;
        if (this.a == null) {
          continue;
        }
        this.a.a(this.b, true, paramContext, null);
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (paramString.startsWith("market://"))
          {
            paramContext = paramString;
            try
            {
              paramString = "http://market.android.com/" + paramString.substring(9);
              paramContext = paramString;
              Intent localIntent = new Intent("android.intent.action.VIEW");
              paramContext = paramString;
              if (!(localContext instanceof Activity))
              {
                paramContext = paramString;
                localIntent.addFlags(268435456);
              }
              paramContext = paramString;
              localIntent.setData(Uri.parse(paramString));
              paramContext = paramString;
              localContext.startActivity(localIntent);
              paramContext = paramString;
            }
            catch (Exception paramString)
            {
              CBLogging.b("CBURLOpener", "Exception raised openeing an inavld playstore URL", paramString);
            }
            if (this.a == null) {
              break;
            }
            this.a.a(this.b, false, paramContext, CBError.CBClickError.URI_UNRECOGNIZED);
            return;
          }
          paramContext = paramString;
          if (this.a != null)
          {
            this.a.a(this.b, false, paramString, CBError.CBClickError.URI_UNRECOGNIZED);
            paramContext = paramString;
          }
        }
      }
    }
  }
  
  public void a(a parama, final String paramString, final Activity paramActivity)
  {
    this.b = parama;
    Object localObject;
    try
    {
      localObject = new URI(paramString);
      localObject = ((URI)localObject).getScheme();
      if (localObject == null)
      {
        if (this.a != null) {
          this.a.a(parama, false, paramString, CBError.CBClickError.URI_INVALID);
        }
        return;
      }
    }
    catch (URISyntaxException paramActivity)
    {
      while (this.a == null) {}
      this.a.a(parama, false, paramString, CBError.CBClickError.URI_INVALID);
      return;
    }
    if ((!((String)localObject).equals("http")) && (!((String)localObject).equals("https")))
    {
      a(paramString, paramActivity);
      return;
    }
    parama = new Runnable()
    {
      public void a(final String paramAnonymousString)
      {
        paramAnonymousString = new Runnable()
        {
          public void run()
          {
            m.a(m.this, paramAnonymousString, m.1.this.b);
          }
        };
        if (paramActivity != null)
        {
          paramActivity.runOnUiThread(paramAnonymousString);
          return;
        }
        new Handler().post(paramAnonymousString);
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 24	com/chartboost/sdk/impl/m$1:a	Ljava/lang/String;
        //   4: astore_1
        //   5: aload_1
        //   6: astore_2
        //   7: invokestatic 55	com/chartboost/sdk/impl/l:a	()Z
        //   10: ifeq +140 -> 150
        //   13: aconst_null
        //   14: astore_3
        //   15: aconst_null
        //   16: astore 4
        //   18: aload_3
        //   19: astore_2
        //   20: invokestatic 61	com/chartboost/sdk/CBPreferences:getInstance	()Lcom/chartboost/sdk/CBPreferences;
        //   23: astore 5
        //   25: aload_3
        //   26: astore_2
        //   27: new 63	java/net/URL
        //   30: dup
        //   31: aload_0
        //   32: getfield 24	com/chartboost/sdk/impl/m$1:a	Ljava/lang/String;
        //   35: invokespecial 65	java/net/URL:<init>	(Ljava/lang/String;)V
        //   38: invokevirtual 69	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   41: checkcast 71	java/net/HttpURLConnection
        //   44: astore_3
        //   45: aload_3
        //   46: iconst_0
        //   47: invokevirtual 75	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
        //   50: aload_3
        //   51: aload 5
        //   53: invokevirtual 79	com/chartboost/sdk/CBPreferences:getTimeout	()I
        //   56: invokevirtual 83	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   59: aload_3
        //   60: aload 5
        //   62: invokevirtual 79	com/chartboost/sdk/CBPreferences:getTimeout	()I
        //   65: invokevirtual 86	java/net/HttpURLConnection:setReadTimeout	(I)V
        //   68: aload_3
        //   69: ldc 88
        //   71: invokevirtual 92	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   74: astore_2
        //   75: aload_2
        //   76: ifnull +5 -> 81
        //   79: aload_2
        //   80: astore_1
        //   81: aload_1
        //   82: astore_2
        //   83: aload_3
        //   84: ifnull +66 -> 150
        //   87: aload_3
        //   88: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
        //   91: aload_0
        //   92: aload_1
        //   93: invokevirtual 97	com/chartboost/sdk/impl/m$1:a	(Ljava/lang/String;)V
        //   96: return
        //   97: astore_2
        //   98: aload 4
        //   100: astore_3
        //   101: aload_2
        //   102: astore 4
        //   104: aload_3
        //   105: astore_2
        //   106: ldc 99
        //   108: ldc 101
        //   110: aload 4
        //   112: invokestatic 106	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   115: aload_1
        //   116: astore_2
        //   117: aload_3
        //   118: ifnull +32 -> 150
        //   121: aload_3
        //   122: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
        //   125: goto -34 -> 91
        //   128: astore_1
        //   129: aload_2
        //   130: ifnull +7 -> 137
        //   133: aload_2
        //   134: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
        //   137: aload_1
        //   138: athrow
        //   139: astore_1
        //   140: aload_3
        //   141: astore_2
        //   142: goto -13 -> 129
        //   145: astore 4
        //   147: goto -43 -> 104
        //   150: aload_2
        //   151: astore_1
        //   152: goto -61 -> 91
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	155	0	this	1
        //   4	112	1	localObject1	Object
        //   128	10	1	localObject2	Object
        //   139	1	1	localObject3	Object
        //   151	1	1	localObject4	Object
        //   6	77	2	localObject5	Object
        //   97	5	2	localException1	Exception
        //   105	46	2	localObject6	Object
        //   14	127	3	localObject7	Object
        //   16	95	4	localException2	Exception
        //   145	1	4	localException3	Exception
        //   23	38	5	localCBPreferences	com.chartboost.sdk.CBPreferences
        // Exception table:
        //   from	to	target	type
        //   20	25	97	java/lang/Exception
        //   27	45	97	java/lang/Exception
        //   20	25	128	finally
        //   27	45	128	finally
        //   106	115	128	finally
        //   45	75	139	finally
        //   45	75	145	java/lang/Exception
      }
    };
    k.a().execute(parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, boolean paramBoolean, String paramString, CBError.CBClickError paramCBClickError);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */