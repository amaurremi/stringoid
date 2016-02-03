package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class f
  implements ag
{
  private static Object a = new Object();
  private static f b;
  private AdvertisingIdClient.Info c;
  private long d;
  private Context e;
  private String f;
  private boolean g = false;
  private Object h = new Object();
  
  f(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }
  
  public static ag a(Context paramContext)
  {
    if (b == null) {}
    synchronized (a)
    {
      if (b == null) {
        b = new f(paramContext);
      }
      return b;
    }
  }
  
  private boolean a(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    Object localObject1 = null;
    if (paramInfo2 == null) {}
    for (paramInfo2 = null; TextUtils.isEmpty(paramInfo2); paramInfo2 = paramInfo2.getId()) {
      return true;
    }
    ac.a(this.e);
    ac localac = ac.a();
    String str = localac.a("&cid");
    boolean bool;
    for (;;)
    {
      synchronized (this.h)
      {
        if (!this.g)
        {
          this.f = b(this.e);
          this.g = true;
          paramInfo1 = b(paramInfo2 + str);
          if (!TextUtils.isEmpty(paramInfo1)) {
            break;
          }
          return false;
        }
      }
      if (TextUtils.isEmpty(this.f))
      {
        if (paramInfo1 == null) {}
        for (paramInfo1 = (AdvertisingIdClient.Info)localObject1; paramInfo1 == null; paramInfo1 = paramInfo1.getId())
        {
          bool = c(paramInfo2 + str);
          return bool;
        }
        this.f = b(paramInfo1 + str);
      }
    }
    if (paramInfo1.equals(this.f)) {
      return true;
    }
    if (!TextUtils.isEmpty(this.f))
    {
      aa.C("Resetting the client id because Advertising Id changed.");
      paramInfo1 = localac.b();
      aa.C("New client Id: " + paramInfo1);
    }
    for (;;)
    {
      bool = c(paramInfo2 + paramInfo1);
      return bool;
      paramInfo1 = str;
    }
  }
  
  static String b(Context paramContext)
  {
    String str = null;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaClientIdData");
      Object localObject2 = new byte[''];
      int i = localFileInputStream.read((byte[])localObject2, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        aa.D("Hash file seems corrupted, deleting it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaClientIdData");
        return null;
      }
      if (i <= 0)
      {
        aa.B("Hash file is empty.");
        localFileInputStream.close();
        return null;
      }
      localObject2 = new String((byte[])localObject2, 0, i);
      Object localObject1;
      return null;
    }
    catch (IOException localIOException2)
    {
      try
      {
        localFileInputStream.close();
        return (String)localObject2;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          localObject1 = localIOException2;
        }
      }
      catch (FileNotFoundException paramContext)
      {
        return localIOException2;
      }
      localIOException2 = localIOException2;
      aa.D("Error reading Hash file, deleting it.");
      paramContext.deleteFile("gaClientIdData");
      return str;
    }
    catch (FileNotFoundException paramContext) {}
  }
  
  static String b(String paramString)
  {
    MessageDigest localMessageDigest = t.c("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  private boolean c(String paramString)
  {
    try
    {
      paramString = b(paramString);
      aa.C("Storing hashed adid.");
      FileOutputStream localFileOutputStream = this.e.openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      this.f = paramString;
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      aa.A("Error creating hash file.");
      return false;
    }
    catch (IOException paramString)
    {
      aa.A("Error writing to hash file.");
    }
    return false;
  }
  
  AdvertisingIdClient.Info a()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.e);
      return localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      aa.D("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      return null;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      aa.D("GooglePlayServicesRepairableException getting Ad Id Info");
      return null;
    }
    catch (IOException localIOException)
    {
      aa.D("IOException getting Ad Id Info");
      return null;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      aa.D("GooglePlayServicesNotAvailableException getting Ad Id Info");
      return null;
    }
    catch (Exception localException)
    {
      aa.D("Unknown exception. Could not get the ad Id.");
    }
    return null;
  }
  
  public String a(String paramString)
  {
    long l = System.currentTimeMillis();
    AdvertisingIdClient.Info localInfo;
    if (l - this.d > 1000L)
    {
      localInfo = a();
      if (!a(this.c, localInfo)) {
        break label71;
      }
    }
    label71:
    for (this.c = localInfo;; this.c = new AdvertisingIdClient.Info("", false))
    {
      this.d = l;
      if (this.c == null) {
        break label115;
      }
      if (!"&adid".equals(paramString)) {
        break;
      }
      return this.c.getId();
    }
    if ("&ate".equals(paramString))
    {
      if (this.c.isLimitAdTrackingEnabled()) {
        return "0";
      }
      return "1";
    }
    label115:
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */