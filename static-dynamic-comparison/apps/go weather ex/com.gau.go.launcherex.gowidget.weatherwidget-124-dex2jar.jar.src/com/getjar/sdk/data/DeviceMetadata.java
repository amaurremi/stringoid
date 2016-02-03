package com.getjar.sdk.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.getjar.sdk.comm.UserAgentValuesManager;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.OverridesUtility;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class DeviceMetadata
{
  public static String KEY_ANDROID_DEVICE_ANDROID_ID = "android.device.android_id";
  public static String KEY_ANDROID_DEVICE_BOARD = "android.device.board";
  public static String KEY_ANDROID_DEVICE_BRAND = "android.device.brand";
  public static String KEY_ANDROID_DEVICE_DEVICE_ID = "android.device.device_id";
  public static String KEY_ANDROID_DEVICE_HARDWARE = "android.device.hardware";
  public static String KEY_ANDROID_DEVICE_MANUFACTURER = "android.device.manufacturer";
  public static String KEY_ANDROID_DEVICE_MODEL = "android.device.model";
  public static String KEY_ANDROID_DEVICE_PRODUCT = "android.device.product";
  public static String KEY_ANDROID_DEVICE_SERIAL_NUMBER = "android.device.serial_number";
  public static String KEY_ANDROID_OS_INCREMENTAL = "android.os.incremental";
  public static String KEY_ANDROID_OS_RELEASE = "android.os.release";
  public static String KEY_ANDROID_OS_SDK_INT = "android.os.sdk_int";
  public static String KEY_DEVICE_PLATFORM = "device.platform";
  public static String KEY_DEVICE_PLATFORM_VERSION = "device.platform_version";
  private final Context _context;
  private Map<String, String> _deviceMetadata = null;
  private Map<String, MetadataValue> _deviceMetadataWithReliability = null;
  
  public DeviceMetadata(Context paramContext)
  {
    this._context = paramContext;
    OverridesUtility.initialize(paramContext);
    int i = findSdkInt(paramContext);
    String str1 = findHardware(paramContext);
    String str2 = findManufacturer(paramContext);
    String str3 = findSerialNo(paramContext, i);
    if (StringUtility.isNullOrEmpty(str3)) {
      Logger.w(Area.AUTH.value(), "Failed to get a serial number", new Object[0]);
    }
    String str4 = findAndroidId(paramContext);
    if (StringUtility.isNullOrEmpty(str4)) {
      Logger.w(Area.AUTH.value(), "Failed to get the Android ID", new Object[0]);
    }
    String str5 = findDeviceId(paramContext);
    if (StringUtility.isNullOrEmpty(str4)) {
      Logger.w(Area.AUTH.value(), "Failed to get the device ID [TelephonyManager.getDeviceId()]", new Object[0]);
    }
    this._deviceMetadata = new HashMap(14);
    this._deviceMetadata.put(KEY_DEVICE_PLATFORM, "android");
    this._deviceMetadata.put(KEY_DEVICE_PLATFORM_VERSION, Build.VERSION.RELEASE);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_ANDROID_ID, str4);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_BOARD, Build.BOARD);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_BRAND, Build.BRAND);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_DEVICE_ID, str5);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_HARDWARE, str1);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_MANUFACTURER, str2);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_MODEL, Build.MODEL);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_PRODUCT, Build.PRODUCT);
    this._deviceMetadata.put(KEY_ANDROID_DEVICE_SERIAL_NUMBER, str3);
    this._deviceMetadata.put(KEY_ANDROID_OS_INCREMENTAL, Build.VERSION.INCREMENTAL);
    this._deviceMetadata.put(KEY_ANDROID_OS_RELEASE, Build.VERSION.RELEASE);
    this._deviceMetadata.put(KEY_ANDROID_OS_SDK_INT, Integer.toString(i));
    this._deviceMetadata.put("legacy.device.user_agent", UserAgentValuesManager.getInstance().getWebKitUserAgent(paramContext));
    this._deviceMetadataWithReliability = new HashMap(14);
    this._deviceMetadataWithReliability.put(KEY_DEVICE_PLATFORM, getMetadataValueInstance("android"));
    this._deviceMetadataWithReliability.put(KEY_DEVICE_PLATFORM_VERSION, getMetadataValueInstance(Build.VERSION.RELEASE));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_ANDROID_ID, getMetadataValueInstance(str4));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_BOARD, getMetadataValueInstance(Build.BOARD));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_BRAND, getMetadataValueInstance(Build.BRAND));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_DEVICE_ID, getMetadataValueInstance(str5));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_HARDWARE, getMetadataValueInstance(str1));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_MANUFACTURER, getMetadataValueInstance(str2));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_MODEL, getMetadataValueInstance(Build.MODEL));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_PRODUCT, getMetadataValueInstance(Build.PRODUCT));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_DEVICE_SERIAL_NUMBER, getMetadataValueInstance(str3));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_OS_INCREMENTAL, getMetadataValueInstance(Build.VERSION.INCREMENTAL));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_OS_RELEASE, getMetadataValueInstance(Build.VERSION.RELEASE));
    this._deviceMetadataWithReliability.put(KEY_ANDROID_OS_SDK_INT, getMetadataValueInstance(Integer.toString(i)));
    this._deviceMetadataWithReliability.put("legacy.device.user_agent", getMetadataValueInstance(UserAgentValuesManager.getInstance().getWebKitUserAgent(paramContext)));
  }
  
  private String findAndroidId(Context paramContext)
  {
    String str = OverridesUtility.getValueFakeID("identity.android.id");
    if (!StringUtility.isNullOrEmpty(str))
    {
      Logger.v(Area.AUTH.value(), "[*** OVERRIDE ***] Override value being used: 'identity.android.id' = '%1$s'", new Object[] { str });
      return str;
    }
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((paramContext == null) || (paramContext.length() <= 1)) {
      return "";
    }
    return paramContext;
  }
  
  private String findDeviceId(Context paramContext)
  {
    String str = OverridesUtility.getValueFakeID("identity.device.id");
    if (!StringUtility.isNullOrEmpty(str))
    {
      Logger.v(Area.AUTH.value(), "[*** OVERRIDE ***] Override value being used: 'identity.device.id' = '%1$s'", new Object[] { str });
      return str;
    }
    if (RewardUtility.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    return "";
  }
  
  private String findHardware(Context paramContext)
  {
    try
    {
      paramContext = (String)Build.class.getDeclaredField("HARDWARE").get(null);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private String findManufacturer(Context paramContext)
  {
    try
    {
      paramContext = (String)Build.class.getDeclaredField("MANUFACTURER").get(null);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private int findSdkInt(Context paramContext)
  {
    try
    {
      i = Build.VERSION.class.getDeclaredField("SDK_INT").getInt(null);
      return i;
    }
    catch (Exception paramContext)
    {
      try
      {
        int i = Integer.parseInt(Build.VERSION.SDK);
        return i;
      }
      catch (Exception paramContext) {}
    }
    return 3;
  }
  
  private String findSerialNo(Context paramContext, int paramInt)
  {
    paramContext = OverridesUtility.getValueFakeID("identity.serial.number");
    if (!StringUtility.isNullOrEmpty(paramContext))
    {
      Logger.v(Area.AUTH.value(), "[*** OVERRIDE ***] Override value being used: 'identity.serial.number' = '%1$s'", new Object[] { paramContext });
      return paramContext;
    }
    if (paramInt >= 9) {}
    try
    {
      return (String)Build.class.getDeclaredField("SERIAL").get(null);
    }
    catch (IllegalAccessException paramContext)
    {
      return "";
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;) {}
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;) {}
    }
    paramContext = Class.forName("android.os.SystemProperties");
    paramContext = (String)paramContext.getMethod("get", new Class[] { String.class, String.class }).invoke(paramContext, new Object[] { "ro.serialno", null });
    return paramContext;
  }
  
  private MetadataValue getMetadataValueInstance(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {}
    for (MetadataValue.MetadataReliability localMetadataReliability = MetadataValue.MetadataReliability.NOT_AVAILABLE;; localMetadataReliability = MetadataValue.MetadataReliability.AVAILABLE) {
      return new MetadataValue(paramString, localMetadataReliability);
    }
  }
  
  public Map<String, String> getMetadata()
  {
    if (StringUtility.isNullOrEmpty((String)this._deviceMetadata.get("legacy.device.user_agent"))) {
      this._deviceMetadata.put("legacy.device.user_agent", UserAgentValuesManager.getInstance().getWebKitUserAgent(this._context));
    }
    return Collections.unmodifiableMap(this._deviceMetadata);
  }
  
  public String getMetadataValue(String paramString)
  {
    return (String)getMetadata().get(paramString);
  }
  
  public Map<String, MetadataValue> getMetadataWithReliability()
  {
    MetadataValue localMetadataValue = (MetadataValue)this._deviceMetadataWithReliability.get("legacy.device.user_agent");
    if ((localMetadataValue == null) || (StringUtility.isNullOrEmpty(localMetadataValue.getValue()))) {
      this._deviceMetadataWithReliability.put("legacy.device.user_agent", getMetadataValueInstance(UserAgentValuesManager.getInstance().getWebKitUserAgent(this._context)));
    }
    return Collections.unmodifiableMap(this._deviceMetadataWithReliability);
  }
  
  public String toJsonString()
    throws JSONException
  {
    return Utility.mapToJsonString(getMetadata());
  }
  
  public String toJsonStringWithReliabilities()
    throws JSONException
  {
    return Utility.metadataMapToJsonString(getMetadataWithReliability());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/DeviceMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */