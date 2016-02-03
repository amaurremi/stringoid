package com.mocoplex.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static f h = null;
  private static String j = "http://ad.adlibr.com/report3.jsp";
  protected Context a = null;
  protected String b = null;
  Hashtable<String, JSONObject> c;
  JSONArray d;
  Hashtable<String, JSONObject> e;
  JSONArray f;
  public long g = 0L;
  private boolean i = false;
  
  private f(Context paramContext)
  {
    f();
    if ((this.b != null) || ((paramContext == null) || (g.a == null))) {}
    try
    {
      localObject1 = paramContext.createPackageContext("net.openudid.android", 2);
      paramContext = (Context)localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject1;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = paramContext.getSharedPreferences("openudid_prefs", 1);
    localObject2 = ((SharedPreferences)localObject1).getString("openudid", null);
    if (localObject2 == null) {}
    try
    {
      localObject2 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      String.format("%s", new Object[] { ((WifiInfo)localObject2).getMacAddress() });
      localObject2 = ((WifiInfo)localObject2).getMacAddress();
      if (localObject2 != null) {
        g.a = "WIFIMAC:" + (String)localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (g.a == null) {}
    for (;;)
    {
      try
      {
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id").toLowerCase();
        if ((paramContext != null) && (paramContext.length() > 14) && (!paramContext.equals("9774d56d682e549c")))
        {
          g.a = "ANDROID:" + paramContext;
          paramContext = ((SharedPreferences)localObject1).edit();
          paramContext.putString("openudid", g.a);
          paramContext.commit();
          this.b = g.a;
          return;
        }
      }
      catch (Exception paramContext) {}
      try
      {
        g.a = g.a(UUID.randomUUID().toString());
        paramContext = g.a;
        continue;
        g.a = (String)localObject2;
        continue;
        this.b = "";
        return;
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (h == null) {
        h = new f(paramContext);
      }
      if (h.a == null)
      {
        h.a = paramContext;
        h.i = true;
      }
      paramContext = h;
      return paramContext;
    }
    finally {}
  }
  
  private JSONObject a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = Integer.toString(paramInt1);
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < 2) {
      localObject1 = "0" + (String)localObject2;
    }
    String str = new StringBuilder(String.valueOf(paramString)).append((String)localObject1).toString() + "_" + Integer.toString(paramInt2);
    localObject2 = (JSONObject)this.c.get(str);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("ymd", paramString);
      ((JSONObject)localObject1).put("h", paramInt1);
      ((JSONObject)localObject1).put("aid", paramInt2);
      ((JSONObject)localObject1).put("req", 0);
      ((JSONObject)localObject1).put("clk", 0);
      this.c.put(str, localObject1);
      this.d.put(localObject1);
      return (JSONObject)localObject1;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  private JSONObject a(String paramString1, String paramString2)
  {
    String str = paramString1 + "_" + paramString2;
    JSONObject localJSONObject2 = (JSONObject)this.e.get(str);
    JSONObject localJSONObject1 = localJSONObject2;
    if (localJSONObject2 == null) {
      localJSONObject1 = new JSONObject();
    }
    try
    {
      localJSONObject1.put("ymd", paramString1);
      localJSONObject1.put("name", paramString2);
      localJSONObject1.put("pv", 0);
      localJSONObject1.put("req", 0);
      localJSONObject1.put("clk", 0);
      this.e.put(str, localJSONObject1);
      this.f.put(localJSONObject1);
      return localJSONObject1;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
  }
  
  private void f()
  {
    this.c = new Hashtable();
    this.d = new JSONArray();
    this.e = new Hashtable();
    this.f = new JSONArray();
  }
  
  private String g()
  {
    Date localDate = new Date(new Date().getTime() + this.g);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
    return localSimpleDateFormat.format(localDate);
  }
  
  private static int h()
  {
    Date localDate = new Date(new Date().getTime());
    TimeZone localTimeZone = TimeZone.getTimeZone("Asia/Seoul");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("H");
    localSimpleDateFormat.setTimeZone(localTimeZone);
    return Integer.parseInt(localSimpleDateFormat.format(localDate));
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    JSONObject localJSONObject = a(g(), h(), paramInt);
    try
    {
      localJSONObject.put("req", localJSONObject.getInt("req") + 1);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public final void a(Activity paramActivity)
  {
    if (this.a == paramActivity)
    {
      b();
      AdlibConfig.getInstance().f();
      this.a = null;
      AdlibConfig.getInstance().a();
      AdlibConfig.getInstance().j();
      c.a();
      c.b();
      e.a();
      e.b();
    }
  }
  
  public final void a(String paramString)
  {
    paramString = a(g(), paramString);
    try
    {
      paramString.put("pv", paramString.getInt("pv") + 1);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected final void b()
  {
    try
    {
      Object localObject1 = new JSONObject();
      String str1 = AdlibConfig.getInstance().c("api");
      ((JSONObject)localObject1).put("log", this.d);
      ((JSONObject)localObject1).put("pv", this.f);
      f();
      String str2 = j;
      new AdlibConfig.c();
      localObject1 = ((JSONObject)localObject1).toString();
      Object localObject2 = new ByteArrayOutputStream();
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream((OutputStream)localObject2));
      localBufferedOutputStream.write(((String)localObject1).getBytes());
      localBufferedOutputStream.close();
      ((ByteArrayOutputStream)localObject2).close();
      localObject1 = new ByteArrayEntity(((ByteArrayOutputStream)localObject2).toByteArray());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new BasicNameValuePair("media", str1));
      ((ArrayList)localObject2).add(new BasicNameValuePair("udid", this.b));
      new d(new Handler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return;
          }
          ((String)paramAnonymousMessage.obj).equals("Y");
        }
      }).a(str2, (ByteArrayEntity)localObject1, (ArrayList)localObject2);
      return;
    }
    catch (JSONException localJSONException) {}catch (IOException localIOException) {}
  }
  
  public final void b(int paramInt)
  {
    JSONObject localJSONObject = a(g(), h(), paramInt);
    try
    {
      localJSONObject.put("clk", localJSONObject.getInt("clk") + 1);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public final void b(String paramString)
  {
    paramString = a(g(), paramString);
    try
    {
      paramString.put("req", paramString.getInt("req") + 1);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public final Context c()
  {
    return this.a;
  }
  
  public final void c(String paramString)
  {
    paramString = a(g(), paramString);
    try
    {
      paramString.put("clk", paramString.getInt("clk") + 1);
      b();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  public final void d()
  {
    this.i = false;
  }
  
  public final boolean e()
  {
    return this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */