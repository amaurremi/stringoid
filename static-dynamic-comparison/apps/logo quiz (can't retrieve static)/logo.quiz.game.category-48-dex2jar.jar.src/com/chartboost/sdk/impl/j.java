package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.b;
import com.chartboost.sdk.Libraries.c;
import com.chartboost.sdk.Libraries.c.a;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Libraries.f.a;
import com.chartboost.sdk.Libraries.f.g;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private String a;
  private JSONObject b;
  private Map<String, Object> c;
  private Map<String, Object> d;
  private String e;
  private boolean f = false;
  private f.a g = null;
  
  public j(String paramString)
  {
    this.a = paramString;
    this.e = "POST";
  }
  
  public static j a(JSONObject paramJSONObject)
  {
    try
    {
      j localj = new j(paramJSONObject.getString("path"));
      localj.e = paramJSONObject.getString("method");
      localj.c = e.a(paramJSONObject.optJSONObject("query"));
      localj.b = paramJSONObject.optJSONObject("body");
      localj.d = e.a(paramJSONObject.optJSONObject("headers"));
      localj.f = paramJSONObject.getBoolean("ensureDelivery");
      return localj;
    }
    catch (Exception paramJSONObject)
    {
      CBLogging.d("CBAPIRequest", "Unable to deserialize failed request", paramJSONObject);
    }
    return null;
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: instanceof 87
    //   9: ifeq +201 -> 210
    //   12: aload_1
    //   13: checkcast 87	android/app/Activity
    //   16: astore 5
    //   18: new 89	android/graphics/Rect
    //   21: dup
    //   22: invokespecial 90	android/graphics/Rect:<init>	()V
    //   25: astore 6
    //   27: aload 5
    //   29: invokevirtual 94	android/app/Activity:getWindow	()Landroid/view/Window;
    //   32: invokevirtual 100	android/view/Window:getDecorView	()Landroid/view/View;
    //   35: aload 6
    //   37: invokevirtual 106	android/view/View:getWindowVisibleDisplayFrame	(Landroid/graphics/Rect;)V
    //   40: getstatic 112	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 9
    //   45: if_icmpge +9 -> 54
    //   48: aload 6
    //   50: iconst_0
    //   51: putfield 115	android/graphics/Rect:top	I
    //   54: aload 6
    //   56: invokevirtual 119	android/graphics/Rect:width	()I
    //   59: istore_2
    //   60: aload 6
    //   62: invokevirtual 122	android/graphics/Rect:height	()I
    //   65: istore_3
    //   66: iload_3
    //   67: istore 4
    //   69: iload_2
    //   70: istore_3
    //   71: iload 4
    //   73: istore_2
    //   74: aload_1
    //   75: ldc 124
    //   77: invokevirtual 130	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   80: checkcast 132	android/view/WindowManager
    //   83: invokeinterface 136 1 0
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 141	android/view/Display:getWidth	()I
    //   93: istore 4
    //   95: iload_3
    //   96: ifle +97 -> 193
    //   99: iload_3
    //   100: iload 4
    //   102: if_icmpgt +91 -> 193
    //   105: aload_1
    //   106: invokevirtual 144	android/view/Display:getHeight	()I
    //   109: istore 4
    //   111: iload_2
    //   112: ifle +87 -> 199
    //   115: iload_2
    //   116: iload 4
    //   118: if_icmpgt +81 -> 199
    //   121: aload_0
    //   122: ldc -110
    //   124: new 148	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   131: ldc -105
    //   133: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_3
    //   137: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokevirtual 165	com/chartboost/sdk/impl/j:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   146: aload_0
    //   147: ldc -89
    //   149: new 148	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   156: ldc -105
    //   158: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_2
    //   162: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 165	com/chartboost/sdk/impl/j:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   171: return
    //   172: astore 5
    //   174: iconst_0
    //   175: istore_2
    //   176: ldc 77
    //   178: ldc -87
    //   180: aload 5
    //   182: invokestatic 171	com/chartboost/sdk/Libraries/CBLogging:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: iload_2
    //   186: istore_3
    //   187: iload 4
    //   189: istore_2
    //   190: goto -116 -> 74
    //   193: iload 4
    //   195: istore_3
    //   196: goto -91 -> 105
    //   199: iload 4
    //   201: istore_2
    //   202: goto -81 -> 121
    //   205: astore 5
    //   207: goto -31 -> 176
    //   210: iconst_0
    //   211: istore_2
    //   212: goto -138 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	j
    //   0	215	1	paramContext	Context
    //   59	153	2	i	int
    //   4	192	3	j	int
    //   1	199	4	k	int
    //   16	12	5	localActivity	android.app.Activity
    //   172	9	5	localException1	Exception
    //   205	1	5	localException2	Exception
    //   25	36	6	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   5	54	172	java/lang/Exception
    //   54	60	172	java/lang/Exception
    //   60	66	205	java/lang/Exception
  }
  
  public void a()
  {
    a("identity", c.b());
    c.a locala = c.c();
    if (locala.b()) {
      a("tracking", Integer.valueOf(locala.a()));
    }
  }
  
  public void a(Context paramContext)
  {
    a("app", CBPreferences.getInstance().getAppID());
    if ("sdk".equals(Build.PRODUCT)) {
      a("model", "Android Simulator");
    }
    for (;;)
    {
      a("device_type", Build.MANUFACTURER + " " + Build.MODEL);
      a("os", "Android " + Build.VERSION.RELEASE);
      a("country", Locale.getDefault().getCountry());
      a("language", Locale.getDefault().getLanguage());
      a("sdk", "4.0.1");
      a("timestamp", String.valueOf(Long.valueOf(new Date().getTime() / 1000L).intValue()));
      a("session", Integer.valueOf(CBUtility.a().getInt("cbPrefSessionCount", 0)));
      int i = l.b();
      if (i != -1) {
        a("reachability", Integer.valueOf(i));
      }
      b(paramContext);
      a("scale", "" + paramContext.getResources().getDisplayMetrics().density);
      try
      {
        String str = paramContext.getPackageName();
        a("bundle", paramContext.getPackageManager().getPackageInfo(str, 128).versionName);
        a("bundle_id", str);
        return;
      }
      catch (Exception paramContext)
      {
        CBLogging.b("CBAPIRequest", "Exception raised getting package mager object", paramContext);
      }
      a("model", Build.MODEL);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.b == null) {
      this.b = new JSONObject();
    }
    try
    {
      this.b.put(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      CBLogging.b("CBAPIRequest", "Error adding body argument", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    this.d.put(paramString1, paramString2);
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    try
    {
      if (paramJSONObject.getString(paramString) != null) {
        a(paramString, paramJSONObject.optString(paramString));
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void a(f.g... paramVarArgs)
  {
    this.g = f.a(paramVarArgs);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a.startsWith("/")) {}
    for (String str = "";; str = "/") {
      return str + this.a + CBUtility.a(this.c);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    paramString2 = b.b(b.a(String.format(Locale.US, "%s %s\n%s\n%s", new Object[] { this.e, b(), paramString2, c() }).getBytes()));
    a("X-Chartboost-App", paramString1);
    a("X-Chartboost-Signature", paramString2);
  }
  
  public String c()
  {
    return this.b.toString();
  }
  
  public JSONObject d()
  {
    return this.b;
  }
  
  public Map<String, Object> e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public f.a g()
  {
    return this.g;
  }
  
  public JSONObject h()
  {
    return e.a(new e.a[] { e.a("path", this.a), e.a("method", this.e), e.a("query", e.a(this.c)), e.a("body", this.b), e.a("headers", e.a(this.d)), e.a("ensureDelivery", Boolean.valueOf(this.f)) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */