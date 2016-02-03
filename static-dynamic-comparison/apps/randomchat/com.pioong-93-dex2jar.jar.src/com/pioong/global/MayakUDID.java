package com.pioong.global;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MayakUDID
{
  private static final boolean LOG = false;
  public static final String PREFS_NAME = "openudid_prefs";
  public static final String PREF_KEY = "openudid";
  public static final String TAG = "OpenUDID";
  private static final boolean _UseBlueToothFailback = false;
  private static final boolean _UseImeiFailback = false;
  private static String _openUdid;
  
  private static String Md5(String paramString)
  {
    localObject1 = null;
    try
    {
      localObject2 = MessageDigest.getInstance("MD5");
      localObject1 = localObject2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        localNoSuchAlgorithmException.printStackTrace();
        continue;
        int j = localNoSuchAlgorithmException[i] & 0xFF;
        localObject1 = paramString;
        if (j <= 15) {
          localObject1 = paramString + "0";
        }
        paramString = localObject1 + Integer.toHexString(j);
        i += 1;
      }
    }
    ((MessageDigest)localObject1).update(paramString.getBytes(), 0, paramString.length());
    localObject2 = ((MessageDigest)localObject1).digest();
    paramString = new String();
    i = 0;
    if (i >= localObject2.length) {
      return paramString.toUpperCase();
    }
  }
  
  private static void _debugLog(String paramString) {}
  
  private static void generateBlueToothId()
  {
    try
    {
      String str = BluetoothAdapter.getDefaultAdapter().getAddress();
      if (str != null) {
        _openUdid = "BTMAC:" + str;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private static void generateImeiId(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      if ((paramContext != null) && (!paramContext.substring(0, 3).equals("000"))) {
        _openUdid = "IMEI:" + paramContext;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void generateOpenUDIDInContext(Context paramContext)
  {
    generateWifiId(paramContext);
    if (_openUdid != null) {
      return;
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id").toLowerCase();
      if ((paramContext != null) && (paramContext.length() > 14) && (!paramContext.equals("9774d56d682e549c")))
      {
        _openUdid = "ANDROID:" + paramContext;
        return;
      }
    }
    catch (Exception paramContext) {}
    try
    {
      generateRandomNumber();
      _debugLog(_openUdid);
      _debugLog("done");
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private static void generateRandomNumber()
  {
    _openUdid = Md5(UUID.randomUUID().toString());
  }
  
  private static void generateSystemId()
  {
    String str = String.format("%s/%s/%s/%s:%s/%s/%s:%s/%s/%d-%s-%s-%s-%s", new Object[] { Build.BRAND, Build.PRODUCT, Build.DEVICE, Build.BOARD, Build.VERSION.RELEASE, Build.ID, Build.VERSION.INCREMENTAL, Build.TYPE, Build.TAGS, Long.valueOf(Build.TIME), Build.DISPLAY, Build.HOST, Build.MANUFACTURER, Build.MODEL });
    _debugLog(str);
    if (str != null) {
      _openUdid = Md5(str);
    }
  }
  
  private static void generateWifiId(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      _debugLog(String.format("%s", new Object[] { paramContext.getMacAddress() }));
      paramContext = paramContext.getMacAddress();
      if (paramContext != null) {
        _openUdid = "WIFIMAC:" + paramContext;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static String getCorpUDID(String paramString)
  {
    return Md5(String.format("%s.%s", new Object[] { paramString, getOpenUDIDInContext() }));
  }
  
  public static String getOpenUDIDInContext()
  {
    return _openUdid;
  }
  
  public static void syncContext(Context paramContext)
  {
    if (_openUdid == null) {}
    try
    {
      localObject = paramContext.createPackageContext("net.openudid.android", 2);
      paramContext = (Context)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject;
      String str;
      for (;;) {}
    }
    localObject = paramContext.getSharedPreferences("openudid_prefs", 1);
    str = ((SharedPreferences)localObject).getString("openudid", null);
    if (str == null)
    {
      generateOpenUDIDInContext(paramContext);
      paramContext = ((SharedPreferences)localObject).edit();
      paramContext.putString("openudid", _openUdid);
      paramContext.commit();
      return;
    }
    _openUdid = str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/global/MayakUDID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */