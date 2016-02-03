package org.osmdroid.google.wrapper.v2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import java.lang.reflect.Method;
import org.osmdroid.api.IMap;

public class MapFactory
{
  public static boolean canGetMapsFingerprint(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      Method localMethod = Class.forName("com.google.android.maps.KeyHelper").getDeclaredMethod("getSignatureFingerprint", new Class[] { PackageManager.class, String.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramPackageManager, paramString });
      return true;
    }
    catch (Throwable paramPackageManager) {}
    return false;
  }
  
  public static IMap getMap(MapFragment paramMapFragment)
  {
    paramMapFragment = paramMapFragment.getMap();
    if (paramMapFragment != null) {
      return new MapWrapper(paramMapFragment);
    }
    return null;
  }
  
  public static IMap getMap(com.google.android.gms.maps.MapView paramMapView)
  {
    GoogleMap localGoogleMap = paramMapView.getMap();
    MapsInitializer.initialize(paramMapView.getContext());
    if (localGoogleMap != null) {
      return new MapWrapper(localGoogleMap);
    }
    return null;
  }
  
  public static IMap getMap(SupportMapFragment paramSupportMapFragment)
  {
    paramSupportMapFragment = paramSupportMapFragment.getMap();
    if (paramSupportMapFragment != null) {
      return new MapWrapper(paramSupportMapFragment);
    }
    return null;
  }
  
  public static IMap getMap(com.google.android.maps.MapView paramMapView)
  {
    return new GoogleV1MapWrapper(paramMapView);
  }
  
  public static IMap getMap(org.osmdroid.views.MapView paramMapView)
  {
    return new OsmdroidMapWrapper(paramMapView);
  }
  
  public static boolean isGoogleMapsV1Supported()
  {
    try
    {
      Class.forName("com.google.android.maps.MapActivity");
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isGoogleMapsV2Supported(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
      {
        int i = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
        bool1 = bool2;
        if (i >= 131072) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/v2/MapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */