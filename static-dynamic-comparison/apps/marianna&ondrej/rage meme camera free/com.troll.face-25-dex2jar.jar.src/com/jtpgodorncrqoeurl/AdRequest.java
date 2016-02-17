package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

public class AdRequest
{
  private JSONObject a;
  private boolean b = false;
  private int c;
  private int d;
  private TelephonyManager e;
  private String f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private String j;
  private String k;
  private String l;
  private List m;
  private boolean n = false;
  private Context o;
  private Activity p;
  
  public AdRequest(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext instanceof Activity)) {
      this.p = ((Activity)paramContext);
    }
    for (;;)
    {
      this.j = paramString1;
      this.g = paramString2.equals("audio");
      this.h = paramString2.equals("reengagement");
      this.i = paramString2.equals("reengagement_alarm");
      return;
      this.o = paramContext;
    }
  }
  
  private String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    Object localObject2;
    int i1;
    if (this.g)
    {
      localObject1 = (AudioManager)paramContext.getSystemService("audio");
      double d1 = Math.round(((AudioManager)localObject1).getStreamVolume(3) / ((AudioManager)localObject1).getStreamMaxVolume(3) * 100.0D) / 100.0D;
      localObject2 = "" + "&level=" + d1;
      localObject1 = localObject2;
      if (paramSharedPreferences.getBoolean("SD_IS_AUDIOTRACK_" + this.j, false)) {
        i1 = paramSharedPreferences.getInt("SD_ITERATION_COUNTER_AUDIO_" + this.j, 0);
      }
    }
    Object localObject6;
    String str;
    for (Object localObject1 = (String)localObject2 + "&audio_counter=" + i1;; str = "")
    {
      if (!this.h)
      {
        localObject2 = localObject1;
        if (!this.i) {}
      }
      else
      {
        localObject6 = "standard,";
        i1 = -1;
      }
      try
      {
        localObject2 = Class.forName(paramContext.getPackageName() + ".R$layout");
        i2 = ((Class)localObject2).getField("reengagement").getInt(localObject2);
        i1 = i2;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          int i2;
          Object localObject4;
          Object localObject5;
          continue;
          paramContext = (Context)localObject5;
        }
      }
      localObject4 = localObject6;
      if (i1 != -1) {}
      for (;;)
      {
        try
        {
          localObject2 = Class.forName(paramContext.getPackageName() + ".R$id");
          i1 = ((Class)localObject2).getField("appimgview").getInt(localObject2);
          i2 = ((Class)localObject2).getField("appimg").getInt(localObject2);
          i3 = ((Class)localObject2).getField("appimgtext").getInt(localObject2);
          localObject2 = localObject6;
          if (i1 != -1)
          {
            localObject2 = localObject6;
            if (i2 != -1)
            {
              localObject2 = localObject6;
              if (i3 != -1) {
                localObject2 = "standard," + "banner,";
              }
            }
          }
        }
        catch (Exception localException2)
        {
          int i3;
          int i4;
          int i5;
          Object localObject3 = localObject6;
          continue;
        }
        try
        {
          localObject4 = Class.forName(paramContext.getPackageName() + ".R$id");
          i1 = ((Class)localObject4).getField("appcustomview").getInt(localObject4);
          i2 = ((Class)localObject4).getField("appcustomtitle").getInt(localObject4);
          i3 = ((Class)localObject4).getField("appcustomdescription").getInt(localObject4);
          i4 = ((Class)localObject4).getField("appcustomsmalltext").getInt(localObject4);
          i5 = ((Class)localObject4).getField("appcustomcta").getInt(localObject4);
          localObject4 = localObject2;
          if (i1 != -1)
          {
            localObject4 = localObject2;
            if (i2 != -1)
            {
              localObject4 = localObject2;
              if (i3 != -1)
              {
                localObject4 = localObject2;
                if (i4 != -1)
                {
                  localObject4 = localObject2;
                  if (i5 != -1) {
                    localObject4 = (String)localObject2 + "customtext,";
                  }
                }
              }
            }
          }
        }
        catch (Exception localException4)
        {
          localObject5 = localObject2;
        }
      }
      localObject2 = ((String)localObject4).substring(0, ((String)localObject4).length() - 1);
      localObject4 = (String)localObject1 + "&reengagement_supported=" + (String)localObject2;
      localObject2 = "";
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          PackageManager localPackageManager = paramContext.getPackageManager();
          localObject1 = localObject2;
          localObject6 = localPackageManager.getPackageInfo(paramContext.getPackageName(), 1).activities;
          if (localObject6 != null)
          {
            localObject1 = localObject2;
            i1 = localObject6.length;
            localObject1 = localObject2;
            if (i1 > 0)
            {
              localObject1 = localObject2;
              localObject2 = "" + ",custom";
              localObject1 = localObject2;
              Intent localIntent = new Intent("android.intent.action.MAIN", null);
              localObject1 = localObject2;
              localIntent.addCategory("android.intent.category.LAUNCHER");
              localObject1 = localObject2;
              localIntent.setPackage(paramContext.getPackageName());
              paramContext = (Context)localObject2;
              localObject1 = localObject2;
              if (localPackageManager.queryIntentActivities(localIntent, 0).size() > 0)
              {
                localObject1 = localObject2;
                paramContext = (String)localObject2 + ",default";
              }
              localObject1 = paramContext;
              i2 = localObject6.length;
              i1 = 0;
              localObject1 = paramContext;
              if (i1 < i2) {
                localObject1 = localObject6[i1];
              }
            }
          }
        }
        catch (Exception paramContext)
        {
          continue;
        }
        try
        {
          if (!((ActivityInfo)localObject1).name.equals("com.jtpgodorncrqoeurl.ReEngagementActivity")) {
            continue;
          }
          localObject1 = paramContext + ",server";
          if (((String)localObject1).equals("")) {
            break;
          }
          paramContext = (Context)localObject1;
          if (((String)localObject1).startsWith(",")) {
            paramContext = ((String)localObject1).substring(1);
          }
          paramContext = (String)localObject4 + "&reengagement_customsupport=" + paramContext;
          i1 = paramSharedPreferences.getInt("SD_ITERATION_COUNTER_" + this.j, 0);
          localObject2 = paramContext + "&iteration_counter=" + i1;
          paramContext = (Context)localObject2;
          if (this.h) {
            paramContext = (String)localObject2 + "&launch_type=App";
          }
          paramSharedPreferences = paramContext;
          if (this.i) {
            paramSharedPreferences = paramContext + "&launch_type=Alarm";
          }
          return paramSharedPreferences;
        }
        catch (Exception localException1)
        {
          i1 += 1;
        }
        i1 = 0;
      }
    }
  }
  
  public JSONObject makeLBRequest()
  {
    if (this.b) {
      return null;
    }
    this.b = true;
    Object localObject1;
    Object localObject3;
    Object localObject6;
    int i2;
    int i1;
    Object localObject7;
    if (this.p != null)
    {
      localObject1 = this.p;
      Object localObject5 = ((Context)localObject1).getSharedPreferences("Preference", 0);
      if (this.p != null)
      {
        localObject3 = new DisplayMetrics();
        this.p.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
        localObject4 = new Rect();
        localObject6 = this.p.getWindow();
        ((Window)localObject6).getDecorView().getWindowVisibleDisplayFrame((Rect)localObject4);
        i2 = ((Rect)localObject4).top;
        i1 = ((Window)localObject6).findViewById(16908290).getTop();
        if (i1 <= i2) {
          break label864;
        }
        i1 -= i2;
        this.c = ((DisplayMetrics)localObject3).widthPixels;
        this.k = this.j;
        localObject4 = ((SharedPreferences)localObject5).getString("sectionidXLrg", null);
        localObject6 = ((SharedPreferences)localObject5).getString("sectionidLrg", null);
        localObject7 = ((SharedPreferences)localObject5).getString("sectionidMed", null);
        if (this.c <= 720) {
          break label917;
        }
        if ((localObject4 == null) || (((String)localObject4).equals(""))) {
          break label869;
        }
        this.k = ((String)localObject4);
        AdLog.d("LBAdController", "SectionIdToUse =" + this.k);
        this.d = (((DisplayMetrics)localObject3).heightPixels - i2 - i1);
        AdLog.d("LBAdController", "Device Width = " + this.c + ", Height = " + this.d);
        AdLog.d("LBAdController", "SBH = " + i2 + ", TBH = " + i1);
      }
      Object localObject4 = new BasicHttpParams();
      ((HttpParams)localObject4).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
      localObject3 = new DefaultHttpClient((HttpParams)localObject4);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject4, 5000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject4, 3000);
      if (this.p == null) {
        break label1009;
      }
      this.e = ((TelephonyManager)this.p.getBaseContext().getSystemService("phone"));
      label401:
      localObject4 = new String[2];
      localObject4[0] = "http://ad.leadboltapps.net";
      localObject4[1] = "http://ad.leadbolt.net";
      if (Build.VERSION.SDK_INT >= 17) {
        System.setProperty("http.keepAlive", "false");
      }
      if (this.k == null) {
        this.k = this.j;
      }
      localObject5 = AdEncryption.encrypt(("&section_id=" + this.k + "&appId=null&optin=" + ((SharedPreferences)localObject5).getString("SD_APP_OPTIN", "0") + a((Context)localObject1, (SharedPreferences)localObject5)).trim()).trim();
      localObject6 = new ArrayList(2);
      ((List)localObject6).add(new BasicNameValuePair("ref", AdRefValues.adRefValues((Context)localObject1, this.e, this.l, this.m, this.n, this.c, this.d)));
      i2 = 0;
      i1 = 0;
      if ((i2 >= localObject4.length) || (i1 != 0)) {
        break label1172;
      }
      this.f = localObject4[i2];
      localObject1 = this.f + "/show_app.conf?";
      if (this.g) {
        localObject1 = this.f + "/show_app_audio?";
      }
      if ((this.h) || (this.i)) {
        localObject1 = this.f + "/show_reengagement?";
      }
      localObject1 = new HttpPost((String)localObject1 + "&get=" + (String)localObject5 + "&section_id=" + this.k);
    }
    label1172:
    label1177:
    for (;;)
    {
      try
      {
        ((HttpPost)localObject1).setEntity(new UrlEncodedFormEntity((List)localObject6));
        i3 = 0;
        if (i3 >= 10) {
          break label1177;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          localObject7 = ((HttpClient)localObject3).execute((HttpUriRequest)localObject1);
          if (((HttpResponse)localObject7).getStatusLine().getStatusCode() == 200)
          {
            localObject7 = ((HttpResponse)localObject7).getEntity();
            if (localObject7 != null)
            {
              localObject7 = ((HttpEntity)localObject7).getContent();
              this.a = new JSONObject(AdUtils.convertStreamToString((InputStream)localObject7));
              ((InputStream)localObject7).close();
            }
            this.b = false;
            i1 = 1;
            if (i1 != 0) {
              break label1172;
            }
            i2 += 1;
            break label579;
            localObject1 = this.o;
            break;
            i1 = 0;
            break label126;
            if ((localObject6 != null) && (!((String)localObject6).equals("")))
            {
              this.k = ((String)localObject6);
              break label213;
            }
            if ((localObject7 == null) || (((String)localObject7).equals(""))) {
              break label213;
            }
            this.k = ((String)localObject7);
            break label213;
            if (this.c > 480)
            {
              if ((localObject6 != null) && (!((String)localObject6).equals("")))
              {
                this.k = ((String)localObject6);
                break label213;
              }
              if ((localObject7 == null) || (((String)localObject7).equals(""))) {
                break label213;
              }
              this.k = ((String)localObject7);
              break label213;
            }
            if ((this.c <= 320) || (localObject7 == null) || (((String)localObject7).equals(""))) {
              break label213;
            }
            this.k = ((String)localObject7);
            break label213;
            this.e = ((TelephonyManager)this.o.getSystemService("phone"));
            break label401;
            localException1 = localException1;
            AdLog.printStackTrace("LBAdController", localException1);
            continue;
          }
        }
        catch (ConnectTimeoutException localConnectTimeoutException)
        {
          int i3;
          AdLog.e("LBAdController", "Connection Timed out - " + localConnectTimeoutException.getMessage());
          this.a = new JSONObject();
          this.b = false;
          i1 = 0;
          continue;
        }
        catch (Exception localException2)
        {
          AdLog.e("LBAdController", "Issue with connection - " + localException2.getMessage());
          AdLog.printStackTrace("LBAdController", localException2);
          this.a = new JSONObject();
          this.b = false;
          i1 = 0;
          continue;
        }
        finally
        {
          this.b = false;
        }
        i3 += 1;
        continue;
      }
      return this.a;
    }
  }
  
  public void setSubId(String paramString)
  {
    this.l = paramString;
  }
  
  public void setTokens(List paramList)
  {
    this.m = paramList;
  }
  
  public void setUseLocation(boolean paramBoolean)
  {
    this.n = paramBoolean;
    AdLog.i("LBAdController", "setUseLocation: " + paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */