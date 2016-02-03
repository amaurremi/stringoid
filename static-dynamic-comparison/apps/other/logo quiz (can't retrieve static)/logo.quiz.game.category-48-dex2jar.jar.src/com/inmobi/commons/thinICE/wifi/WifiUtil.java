package com.inmobi.commons.thinICE.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class WifiUtil
{
  private static final String[] a = { "android.permission.ACCESS_WIFI_STATE" };
  private static final String[] b = { "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE" };
  private static final String[] c = { "android.permission.WAKE_LOCK" };
  
  private static long a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  private static long a(byte[] paramArrayOfByte)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramArrayOfByte != null)
    {
      l1 = l2;
      if (paramArrayOfByte.length == 6) {
        l1 = a(paramArrayOfByte[5]) | a(paramArrayOfByte[4]) << 8 | a(paramArrayOfByte[3]) << 16 | a(paramArrayOfByte[2]) << 24 | a(paramArrayOfByte[1]) << 32 | a(paramArrayOfByte[0]) << 40;
      }
    }
    return l1;
  }
  
  private static boolean a(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (paramString != null) && (paramString.endsWith("_nomap"));
  }
  
  public static WifiInfo getConnectedWifiInfo(Context paramContext)
  {
    int i = IceDataCollector.getConfig().getWifiFlags();
    if (!ThinICEConfigSettings.bitTest(i, 2)) {}
    for (boolean bool = true;; bool = false) {
      return getConnectedWifiInfo(paramContext, bool, ThinICEConfigSettings.bitTest(i, 1));
    }
  }
  
  public static WifiInfo getConnectedWifiInfo(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    android.net.wifi.WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo == null) {}
    WifiInfo localWifiInfo1;
    String str;
    do
    {
      return null;
      localWifiInfo1 = new WifiInfo();
      str = localWifiInfo.getBSSID();
      paramContext = localWifiInfo.getSSID();
    } while ((str == null) || (a(paramBoolean1, paramContext)));
    localWifiInfo1.bssid = macToLong(str);
    if (paramBoolean2) {
      paramContext = null;
    }
    localWifiInfo1.ssid = paramContext;
    localWifiInfo1.rssi = localWifiInfo.getRssi();
    localWifiInfo1.ip = localWifiInfo.getIpAddress();
    return localWifiInfo1;
  }
  
  public static boolean hasGetConnectedWifiInfoPermission(Context paramContext)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramContext.checkCallingOrSelfPermission(arrayOfString[i]) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean hasWifiScanPermission(Context paramContext, boolean paramBoolean)
  {
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramContext.checkCallingOrSelfPermission(arrayOfString[i]) != 0) {
        return false;
      }
      i += 1;
    }
    if (paramBoolean)
    {
      arrayOfString = c;
      j = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label74;
        }
        if (paramContext.checkCallingOrSelfPermission(arrayOfString[i]) != 0) {
          break;
        }
        i += 1;
      }
    }
    label74:
    return true;
  }
  
  public static long macToLong(String paramString)
  {
    paramString = paramString.split("\\:");
    byte[] arrayOfByte = new byte[6];
    int i = 0;
    while (i < 6)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString[i], 16));
      i += 1;
    }
    return a(arrayOfByte);
  }
  
  public static WifiInfo scanResultToWifiInfo(ScanResult paramScanResult, boolean paramBoolean)
  {
    String str = null;
    if (paramScanResult == null) {
      return null;
    }
    WifiInfo localWifiInfo = new WifiInfo();
    localWifiInfo.bssid = macToLong(paramScanResult.BSSID);
    if (paramBoolean) {}
    for (;;)
    {
      localWifiInfo.ssid = str;
      localWifiInfo.rssi = paramScanResult.level;
      return localWifiInfo;
      str = paramScanResult.SSID;
    }
  }
  
  public static List<WifiInfo> scanResultsToWifiInfos(List<ScanResult> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ScanResult localScanResult = (ScanResult)paramList.next();
      if (!a(paramBoolean1, localScanResult.SSID)) {
        localArrayList.add(scanResultToWifiInfo(localScanResult, paramBoolean2));
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/WifiUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */