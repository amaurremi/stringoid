package com.mopub.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.provider.Settings.Secure;
import java.io.File;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.conn.util.InetAddressUtils;

public class DeviceUtils
{
  private static final int MAX_DISK_CACHE_SIZE = 104857600;
  private static final int MAX_MEMORY_CACHE_SIZE = 31457280;
  private static final int MIN_DISK_CACHE_SIZE = 31457280;
  
  public static boolean bitmaskContainsFlag(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static long diskCacheSizeBytes(File paramFile)
  {
    long l1 = 31457280L;
    try
    {
      paramFile = new StatFs(paramFile.getAbsolutePath());
      long l2 = paramFile.getBlockCount() * paramFile.getBlockSize() / 50L;
      l1 = l2;
    }
    catch (IllegalArgumentException paramFile)
    {
      for (;;)
      {
        com.mopub.nativeads.util.Utils.MoPubLog("Unable to calculate 2% of available disk space, defaulting to minimum");
      }
    }
    return Math.max(Math.min(l1, 104857600L), 31457280L);
  }
  
  public static String getHashedUdid(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return Utils.sha1(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
  }
  
  public static String getIpAddress(IP paramIP)
    throws SocketException
  {
    Object localObject;
    do
    {
      do
      {
        Iterator localIterator1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = Collections.list(((NetworkInterface)localIterator1.next()).getInetAddresses()).iterator();
        }
        localObject = (InetAddress)localIterator2.next();
      } while (((InetAddress)localObject).isLoopbackAddress());
      localObject = ((InetAddress)localObject).getHostAddress().toUpperCase();
    } while (!paramIP.matches((String)localObject));
    return paramIP.toString((String)localObject);
    return null;
  }
  
  public static String getUserAgent()
  {
    return System.getProperty("http.agent");
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    if (paramContext == null) {}
    while (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
      return false;
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
      return true;
    }
    try
    {
      boolean bool = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
      return bool;
    }
    catch (NullPointerException paramContext) {}
    return false;
  }
  
  public static int memoryCacheSizeBytes(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    l2 = localActivityManager.getMemoryClass();
    l1 = l2;
    if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {}
    try
    {
      int i = ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
      l1 = l2;
      if (bitmaskContainsFlag(paramContext.getApplicationInfo().flags, i))
      {
        i = ((Integer)new Reflection.MethodBuilder(localActivityManager, "getLargeMemoryClass").execute()).intValue();
        l1 = i;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.mopub.nativeads.util.Utils.MoPubLog("Unable to reflectively determine large heap size on Honeycomb and above.");
        l1 = l2;
      }
    }
    return (int)Math.min(31457280L, l1 / 8L * 1024L * 1024L);
  }
  
  public static enum IP
  {
    IPv4,  IPv6;
    
    private IP() {}
    
    private boolean matches(String paramString)
    {
      switch (DeviceUtils.1.$SwitchMap$com$mopub$common$util$DeviceUtils$IP[ordinal()])
      {
      default: 
        return false;
      case 1: 
        return InetAddressUtils.isIPv4Address(paramString);
      }
      return InetAddressUtils.isIPv6Address(paramString);
    }
    
    private String toString(String paramString)
    {
      String str = paramString;
      switch (DeviceUtils.1.$SwitchMap$com$mopub$common$util$DeviceUtils$IP[ordinal()])
      {
      default: 
        str = null;
      case 1: 
        return str;
      }
      return paramString.split("%")[0];
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/util/DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */