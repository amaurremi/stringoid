package com.go.weatherex.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.gau.go.gostaticsdk.d;
import com.gau.go.launcherex.gowidget.download.b;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.d.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static File a()
  {
    File localFile = new File(com.gtp.a.a.c.c.a(), "GoAdImage");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static void a(Context paramContext)
  {
    new h(paramContext).execute(new Void[0]);
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 1).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("go_ad_statistics_share_prefs", 0);
    String str = localSharedPreferences.getString(paramString, null);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Object localObject = str.split("#");
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(localObject[0]);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.gau.go.launcherex.gowidget.statistics.a.a locala;
        localException.printStackTrace();
      }
    }
    str = localObject[1];
    localObject = localObject[2];
    if (System.currentTimeMillis() - l1 < 1800000L)
    {
      locala = new com.gau.go.launcherex.gowidget.statistics.a.a(183);
      locala.a(str);
      locala.b("b000");
      locala.e((String)localObject);
      r.a(paramContext.getApplicationContext()).a(locala);
    }
    localSharedPreferences.edit().remove(paramString).commit();
  }
  
  private static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    new g(paramString).execute(new Void[0]);
  }
  
  private static void a(JSONArray paramJSONArray, Context paramContext)
  {
    int i = 0;
    if (i < paramJSONArray.length()) {}
    for (;;)
    {
      try
      {
        str = ((JSONObject)paramJSONArray.get(i)).getString("icon");
        b(paramJSONArray, paramContext);
        localFile = new File(a().getPath() + File.separator + m.a(str));
        if (!localFile.exists()) {
          break label123;
        }
      }
      catch (Exception localException)
      {
        String str;
        File localFile;
        boolean bool;
        int k;
        i += 1;
      }
      bool = com.jiubang.goweather.e.a.a(localFile, str);
      k = j - 1;
      if (!bool)
      {
        j = k;
        if (k > 0) {
          continue;
        }
        continue;
        return;
      }
      break;
      label123:
      int j = 3;
    }
  }
  
  private static final void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {
      paramJSONObject.put(paramString, paramInt);
    }
  }
  
  private static final void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
  
  public static boolean a(Context paramContext, a parama)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (!com.gau.go.gostaticsdk.f.c.e(paramContext)) {
      a(paramContext, 2131166414);
    }
    while (parama == null) {
      return false;
    }
    switch (parama.k())
    {
    default: 
      a(paramContext, 2131166415);
      bool1 = false;
    }
    for (;;)
    {
      a(parama.a());
      b(paramContext, parama);
      return bool1;
      if (TextUtils.isEmpty(parama.f())) {}
      for (Object localObject = paramContext.getText(2131165759).toString() + parama.d();; localObject = parama.f())
      {
        b.a(paramContext, (String)localObject + ".apk", parama.j(), parama.d(), parama.g());
        bool1 = bool2;
        break;
      }
      if (y.s(paramContext))
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama.j()));
        try
        {
          ((Intent)localObject).setPackage("com.android.vending");
          ((Intent)localObject).setFlags(268435456);
          paramContext.startActivity((Intent)localObject);
          bool1 = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      else
      {
        com.gau.go.launcherex.gowidget.weather.globaltheme.a.d(paramContext, parama.j());
        bool1 = bool2;
        continue;
        com.gau.go.launcherex.gowidget.weather.globaltheme.a.d(paramContext, parama.j());
        bool1 = bool2;
      }
    }
  }
  
  public static ArrayList b(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = g(paramContext);
      if (paramContext == null) {
        return localArrayList;
      }
      paramContext = new JSONArray(paramContext);
      int i = 0;
      while (i < paramContext.length())
      {
        JSONObject localJSONObject = (JSONObject)paramContext.get(i);
        a locala = new a();
        locala.a(localJSONObject.getInt("mapid"));
        locala.c(localJSONObject.getString("icon"));
        locala.b(a().getPath() + File.separator + m.a(locala.e()));
        locala.d(localJSONObject.getString("name"));
        locala.e(localJSONObject.getString("packagename"));
        locala.f(localJSONObject.getString("location"));
        locala.g(localJSONObject.getString("description"));
        locala.h(localJSONObject.getString("downloadurl"));
        locala.b(localJSONObject.getInt("downloadtype"));
        locala.a(localJSONObject.getString("cbackurl"));
        localArrayList.add(locala);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramContext) {}
  }
  
  private static void b(Context paramContext, a parama)
  {
    com.gau.go.launcherex.gowidget.statistics.a.a locala = new com.gau.go.launcherex.gowidget.statistics.a.a(183);
    locala.a(parama.d() + "");
    locala.b("a000");
    locala.e(parama.h());
    r.a(paramContext.getApplicationContext()).a(locala);
    paramContext = paramContext.getSharedPreferences("go_ad_statistics_share_prefs", 0).edit();
    paramContext.putString(parama.g(), System.currentTimeMillis() + "#" + parama.d() + "#" + parama.h());
    paramContext.commit();
  }
  
  private static void b(String paramString, Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = paramString.optJSONObject("result");
        if (localJSONObject != null)
        {
          if (localJSONObject.getInt("status") != 1) {
            return;
          }
          paramString = paramString.optJSONArray("types");
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = (JSONObject)paramString.get(i);
            if (localJSONObject.getInt("typeid") != 2) {
              break label94;
            }
            a(localJSONObject.optJSONArray("apps"), paramContext);
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label94:
      i += 1;
    }
  }
  
  private static void b(JSONArray paramJSONArray, Context paramContext)
  {
    try
    {
      paramContext = paramContext.openFileOutput("go_ad_cach_file.txt", 0);
      paramContext.write(paramJSONArray.toString().getBytes());
      paramContext.close();
      return;
    }
    catch (Exception paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = GoWidgetApplication.b(paramContext.getApplicationContext());
    return (paramContext.a(2)) || (paramContext.a(1)) || (paramContext.a(32)) || (paramContext.a(128));
  }
  
  private static String e(Context paramContext)
  {
    Object localObject2 = f(paramContext);
    if (localObject2 != null) {}
    for (Object localObject1 = ((JSONObject)localObject2).toString(); TextUtils.isEmpty((CharSequence)localObject1); localObject1 = "") {
      return null;
    }
    localObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("typeid", "2");
      localJSONArray.put(localJSONObject);
      ((JSONObject)localObject1).put("phead", localObject2);
      ((JSONObject)localObject1).put("types", localJSONArray);
      localObject2 = new ArrayList();
      ((List)localObject2).add(new BasicNameValuePair("handle", "0"));
      ((List)localObject2).add(new BasicNameValuePair("data", ((JSONObject)localObject1).toString()));
      ((List)localObject2).add(new BasicNameValuePair("shandle", "0"));
      return com.gtp.go.weather.coupon.c.a.a(paramContext, "http://lightapp.goforandroid.com/lightapp/common?funid=2&rd=", (List)localObject2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private static JSONObject f(Context paramContext)
  {
    localJSONObject = new JSONObject();
    try
    {
      a(localJSONObject, "pversion", 1);
      a(localJSONObject, "aid", y.v(paramContext));
      a(localJSONObject, "gadid", y.w(paramContext));
      a(localJSONObject, "imei", y.d(paramContext));
      a(localJSONObject, "goid", d.b(paramContext));
      a(localJSONObject, "cid", 2);
      a(localJSONObject, "cversion", y.e(paramContext));
      try
      {
        i = Integer.valueOf(y.f(paramContext)).intValue();
        a(localJSONObject, "channel", i);
        a(localJSONObject, "local", y.n(paramContext).toUpperCase());
        a(localJSONObject, "lang", y.l(paramContext).toUpperCase());
        a(localJSONObject, "imsi", y.r(paramContext));
        a(localJSONObject, "dpi", y.y(paramContext));
        a(localJSONObject, "sdk", Build.VERSION.SDK_INT);
        a(localJSONObject, "sys", Build.VERSION.RELEASE);
        a(localJSONObject, "model", Build.DEVICE);
        if (y.s(paramContext))
        {
          i = 1;
          a(localJSONObject, "hasmarket", i);
          if (!y.h(paramContext)) {
            break label240;
          }
          i = 1;
          a(localJSONObject, "official", i);
          a(localJSONObject, "net", y.u(paramContext));
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          int i = 0;
          continue;
          i = 0;
          continue;
          label240:
          i = 0;
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static String g(Context paramContext)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      paramContext = paramContext.openFileInput("go_ad_cach_file.txt");
      byte[] arrayOfByte = new byte['Ѐ'];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = paramContext.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramContext.close();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    localByteArrayOutputStream.close();
    paramContext = new String(localByteArrayOutputStream.toByteArray());
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */