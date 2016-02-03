package com.jumptap.adtag.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JtAdManager
{
  private static final String CHAR_SET = "iso-8859-1";
  private static final String CONNECTION_TYPE_EDGE = "edge";
  private static final String CONNECTION_TYPE_WIFI = "wifi";
  private static final String CONNECTION_TYPE__3G = "3g";
  public static final String JT_AD = "JtAd";
  public static final String JT_NAMRSPACE = "http://www.jumptap.com/lib/android";
  private static final int NETWORK_TYPE_CDMA = 4;
  private static final int NETWORK_TYPE_EVDO_0 = 5;
  private static final int NETWORK_TYPE_EVDO_A = 6;
  private static final int NETWORK_TYPE_HSDPA = 8;
  private static final int NETWORK_TYPE_HSPA = 10;
  private static final int NETWORK_TYPE_HSUPA = 9;
  private static final int NETWORK_TYPE_IDEN = 11;
  private static final int NETWORK_TYPE_RRT = 7;
  private static final String PREF_NAME = "jtPref";
  private static final String SHA1_ALGORITHM = "SHA-1";
  private static String procVersionStr = null;
  private boolean testMode = false;
  
  public static String SHA1(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte = new byte[40];
      localMessageDigest.update(paramString.getBytes("iso-8859-1"), 0, paramString.length());
      paramString = convertToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.i("JtAd", "Error generating generating SHA-1: ", paramString);
    }
    return null;
  }
  
  private static String convertToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int k;
    int j;
    if (i < paramArrayOfByte.length)
    {
      k = paramArrayOfByte[i] >>> 4 & 0xF;
      j = 0;
    }
    for (;;)
    {
      if ((k >= 0) && (k <= 9)) {
        localStringBuffer.append((char)(k + 48));
      }
      for (;;)
      {
        k = paramArrayOfByte[i] & 0xF;
        if (j < 1) {
          break label91;
        }
        i += 1;
        break;
        localStringBuffer.append((char)(k - 10 + 97));
      }
      return localStringBuffer.toString();
      label91:
      j += 1;
    }
  }
  
  public static String getAndroidModel()
  {
    return Build.DEVICE;
  }
  
  public static String getBrand()
  {
    return Build.BRAND;
  }
  
  public static String getConnectionType(Context paramContext)
  {
    String str = "";
    Object localObject = getConnectivityManager(paramContext);
    paramContext = str;
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      paramContext = str;
      if (localObject != null)
      {
        i = ((NetworkInfo)localObject).getType();
        j = ((NetworkInfo)localObject).getSubtype();
        if (i != 1) {
          break label77;
        }
        paramContext = "wifi";
      }
    }
    for (;;)
    {
      Log.i("JtAd", "connectionType=" + paramContext);
      return paramContext;
      label77:
      paramContext = str;
      if (i == 0) {
        paramContext = getConnectionTypeByNetSubtype(j);
      }
    }
  }
  
  private static String getConnectionTypeByNetSubtype(int paramInt)
  {
    String str = "";
    if ((paramInt == 3) || (paramInt == 7) || (paramInt == 8) || (paramInt == 10) || (paramInt == 9) || (paramInt == 5) || (paramInt == 6)) {
      str = "3g";
    }
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 4) || (paramInt == 11)) {
      str = "edge";
    }
    return str;
  }
  
  private static ConnectivityManager getConnectivityManager(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        return paramContext;
      }
      catch (SecurityException paramContext)
      {
        Log.e("JtAd", "JtAdManager.getConnectivityManager: " + paramContext.getMessage());
        return null;
      }
    }
    Log.e("JtAd", "JtAdManager: Requires ACCESS_NETWORK_STATE permission");
    return null;
  }
  
  public static String getHID(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String getHIDSHA1(Context paramContext)
  {
    return SHA1(getHID(paramContext));
  }
  
  public static String getIPAddress()
  {
    String str = null;
    if (0 == 0) {
      str = getLocalIpAddress();
    }
    return str;
  }
  
  public static String getKernelVersion()
  {
    if (procVersionStr == null)
    {
      try
      {
        Object localObject1 = new BufferedReader(new FileReader("/proc/version"), 256);
        try
        {
          String str2 = ((BufferedReader)localObject1).readLine();
          ((BufferedReader)localObject1).close();
          localObject1 = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\([^)]+\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(str2);
          if (!((Matcher)localObject1).matches())
          {
            Log.e("JtAd", "Regex did not match on /proc/version: " + str2);
            return "Unavailable";
          }
        }
        finally
        {
          ((BufferedReader)localObject1).close();
        }
        if (localIOException.groupCount() >= 4) {
          break label146;
        }
      }
      catch (IOException localIOException)
      {
        Log.e("JtAd", "IO Exception when getting kernel version for Device Info screen", localIOException);
        return "Unavailable";
      }
      Log.e("JtAd", "Regex match on /proc/version only returned " + localIOException.groupCount() + " groups");
      return "Unavailable";
      label146:
      procVersionStr = localIOException.group(1);
      String str1 = procVersionStr;
      return str1;
    }
    return procVersionStr;
  }
  
  private static String getLocalIpAddress()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (SocketException localSocketException)
    {
      Log.e("JtAd", "JtAdManager.getLocalIpAddress:" + localSocketException.toString());
    }
    return null;
  }
  
  public static String getLocation(Context paramContext)
  {
    JtLocation.init(paramContext);
    paramContext = null;
    Location localLocation = JtLocation.getCurrentLocation();
    if (localLocation != null) {
      paramContext = localLocation.getLatitude() + "," + localLocation.getLongitude();
    }
    return paramContext;
  }
  
  public static String getManufacturer()
  {
    return "";
  }
  
  public static String getNetworkType(Context paramContext)
  {
    paramContext = getTelephonyManager(paramContext);
    if (paramContext != null) {}
    switch (paramContext.getNetworkType())
    {
    default: 
      return "";
    case 1: 
      return "GPRS";
    case 2: 
      return "EDGE";
    }
    return "UMTS";
  }
  
  public static String getOperatorName(Context paramContext)
  {
    TelephonyManager localTelephonyManager = getTelephonyManager(paramContext);
    paramContext = "";
    if (localTelephonyManager != null) {
      paramContext = localTelephonyManager.getNetworkOperatorName();
    }
    return paramContext;
  }
  
  public static String getPhoneType(Context paramContext)
  {
    paramContext = getTelephonyManager(paramContext);
    if (paramContext != null) {}
    switch (paramContext.getPhoneType())
    {
    default: 
      return "";
    }
    return "GSM";
  }
  
  public static String getPreferences(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("jtPref", 0).getString(paramString1, paramString2);
  }
  
  public static String getSDKVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  private static TelephonyManager getTelephonyManager(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      Log.e("JtAd", "JtAdManager.getTelephonyManager: " + paramContext.getMessage());
    }
    return null;
  }
  
  public static void removePreferences(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("jtPref", 0).edit();
    paramContext.remove(paramString);
    paramContext.commit();
  }
  
  public static void savePreferences(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("jtPref", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public boolean isTestMode()
  {
    return this.testMode;
  }
  
  public void setTestMode(boolean paramBoolean)
  {
    this.testMode = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/JtAdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */