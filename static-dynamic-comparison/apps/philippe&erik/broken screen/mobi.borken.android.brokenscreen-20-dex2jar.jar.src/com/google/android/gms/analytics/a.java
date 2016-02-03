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

class a
  implements m
{
  private static Object tn = new Object();
  private static a to;
  private Context mContext;
  private AdvertisingIdClient.Info tp;
  private long tq;
  private String tr;
  private boolean ts = false;
  private Object tt = new Object();
  
  a(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  static String H(String paramString)
  {
    MessageDigest localMessageDigest = ak.W("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  private boolean I(String paramString)
  {
    try
    {
      paramString = H(paramString);
      aa.C("Storing hashed adid.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      this.tr = paramString;
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
  
  private boolean a(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    Object localObject1 = null;
    if (paramInfo2 == null) {}
    for (paramInfo2 = null; TextUtils.isEmpty(paramInfo2); paramInfo2 = paramInfo2.getId()) {
      return true;
    }
    h.r(this.mContext);
    h localh = h.cq();
    String str = localh.getValue("&cid");
    boolean bool;
    for (;;)
    {
      synchronized (this.tt)
      {
        if (!this.ts)
        {
          this.tr = q(this.mContext);
          this.ts = true;
          paramInfo1 = H(paramInfo2 + str);
          if (!TextUtils.isEmpty(paramInfo1)) {
            break;
          }
          return false;
        }
      }
      if (TextUtils.isEmpty(this.tr))
      {
        if (paramInfo1 == null) {}
        for (paramInfo1 = (AdvertisingIdClient.Info)localObject1; paramInfo1 == null; paramInfo1 = paramInfo1.getId())
        {
          bool = I(paramInfo2 + str);
          return bool;
        }
        this.tr = H(paramInfo1 + str);
      }
    }
    if (paramInfo1.equals(this.tr)) {
      return true;
    }
    if (!TextUtils.isEmpty(this.tr))
    {
      aa.C("Resetting the client id because Advertising Id changed.");
      paramInfo1 = localh.cr();
      aa.C("New client Id: " + paramInfo1);
    }
    for (;;)
    {
      bool = I(paramInfo2 + paramInfo1);
      return bool;
      paramInfo1 = str;
    }
  }
  
  public static m p(Context paramContext)
  {
    if (to == null) {}
    synchronized (tn)
    {
      if (to == null) {
        to = new a(paramContext);
      }
      return to;
    }
  }
  
  static String q(Context paramContext)
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
  
  AdvertisingIdClient.Info cf()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
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
  
  public String getValue(String paramString)
  {
    long l = System.currentTimeMillis();
    AdvertisingIdClient.Info localInfo;
    if (l - this.tq > 1000L)
    {
      localInfo = cf();
      if (!a(this.tp, localInfo)) {
        break label72;
      }
    }
    label72:
    for (this.tp = localInfo;; this.tp = new AdvertisingIdClient.Info("", false))
    {
      this.tq = l;
      if (this.tp == null) {
        break label118;
      }
      if (!"&adid".equals(paramString)) {
        break;
      }
      return this.tp.getId();
    }
    if ("&ate".equals(paramString))
    {
      if (this.tp.isLimitAdTrackingEnabled()) {
        return "0";
      }
      return "1";
    }
    label118:
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */