package com.getjar.sdk.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.getjar.sdk.comm.Result;
import com.getjar.sdk.data.MetadataValue;
import com.getjar.sdk.data.MetadataValue.MetadataReliability;
import com.getjar.sdk.exceptions.ServiceException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility
{
  public static final String ACCESS_WIFI_STATE_PERMISSION = "android.permission.ACCESS_WIFI_STATE";
  public static final String GETJAR_CLIENT_PARAM = "gjclnt=1";
  private static final String GETJAR_V1_DB = "GetJarRewardsDB";
  public static final String PREFERENCES_FILE_NAME = "GetJarClientPrefs";
  public static final String PREFERENCES_KEY_DEVICEOBJECTID = "DeviceObjectID";
  public static final String PREFERENCES_KEY_FIRST_RUN_FLAG = "FirstRunFlag";
  public static final String PREFERENCES_KEY_FIRST_UX_RUN_FLAG = "FirstUXRun";
  public static final String PREFERENCES_KEY_INSTALLATIONID = "InstallationID";
  public static final String PREFERENCES_KEY_INSTALL_TIME = "InstallTime";
  public static final String PREFERENCES_KEY_LAUNCH_COUNT = "LaunchCount";
  public static final String PREFERENCES_KEY_LOCALE = "Locale";
  public static final String PREFERENCES_KEY_SANDBOX = "SandBox";
  public static final String PREFERENCES_KEY_USER_ACCESS_ID = "UserAccessID";
  public static final String PREFERENCES_KEY_USER_ID = "UserID";
  public static final String QUERY_APPENDIX = "&";
  public static final String QUERY_START = "?";
  public static final String READ_PHONE_STATE_PERMISSION = "android.permission.READ_PHONE_STATE";
  private static Random sRnd = new Random();
  
  public static Date adjustUTCDate(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return new Date(localCalendar.getTimeInMillis() + localCalendar.get(15) + localCalendar.get(16));
  }
  
  public static long convertMillSec(long paramLong)
  {
    return 1000L * paramLong;
  }
  
  public static String epochToISO8601(long paramLong)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
    localGregorianCalendar.setTimeInMillis(paramLong);
    return String.format(Locale.US, "%1$04d-%2$02d-%3$02dT%4$02d:%5$02d:%6$02d.%7$03dZ", new Object[] { Integer.valueOf(localGregorianCalendar.get(1)), Integer.valueOf(localGregorianCalendar.get(2) + 1), Integer.valueOf(localGregorianCalendar.get(5)), Integer.valueOf(localGregorianCalendar.get(11)), Integer.valueOf(localGregorianCalendar.get(12)), Integer.valueOf(localGregorianCalendar.get(13)), Integer.valueOf(localGregorianCalendar.get(14)) });
  }
  
  public static String getAndroidID(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    OverridesUtility.initialize(paramContext);
    String str = OverridesUtility.getValueFakeID("identity.android.id");
    if (!StringUtility.isNullOrEmpty(str))
    {
      Logger.v(Area.AUTH.value(), "[*** OVERRIDE ***] Override value being used: 'identity.android.id' = '%1$s'", new Object[] { str });
      return str;
    }
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((paramContext == null) || (paramContext.length() <= 1)) {
      return null;
    }
    return paramContext;
  }
  
  public static File[] getCacheLocations(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    return new File[] { getExternalCacheLocation(), paramContext.getFilesDir(), paramContext.getCacheDir() };
  }
  
  public static String getCurrentLocale(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.getDisplayName();
  }
  
  public static String getDefaultLocale()
  {
    return Locale.getDefault().getDisplayName();
  }
  
  public static String getDeviceObjectId(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    OverridesUtility.initialize(paramContext);
    Object localObject1 = OverridesUtility.getValueFakeID("identity.device.id");
    if (!StringUtility.isNullOrEmpty((String)localObject1))
    {
      Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "[*** OVERRIDE ***] Override value being used: 'identity.device.id' = '%1$s'", new Object[] { localObject1 });
      return (String)localObject1;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("GetJarClientPrefs", 0);
    if (localSharedPreferences.contains("DeviceObjectID")) {
      return localSharedPreferences.getString("DeviceObjectID", null);
    }
    localObject1 = null;
    if (RewardUtility.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
      localObject1 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() > 0) {
        break label179;
      }
    }
    try
    {
      localObject2 = Class.forName("android.os.SystemProperties");
      localObject2 = (String)((Class)localObject2).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject2, new Object[] { "ro.serialno", null });
      label179:
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {}
      }
      else
      {
        localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      }
      if (localObject1 != null)
      {
        paramContext = (Context)localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        paramContext = UUID.randomUUID().toString();
      }
      localSharedPreferences.edit().putString("DeviceObjectID", paramContext).commit();
      return paramContext;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Object localObject4 = localObject1;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Object localObject5 = localObject1;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject6 = localObject1;
      }
    }
  }
  
  public static File getExternalCacheLocation()
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "getjar" + File.separator + "cache");
    localFile.mkdirs();
    return localFile;
  }
  
  public static String getInstallationID(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    OverridesUtility.initialize(paramContext);
    String str = OverridesUtility.getValueFakeID("identity.device.id");
    if (!StringUtility.isNullOrEmpty(str))
    {
      Logger.v(Area.AUTH.value() | Area.STORAGE.value(), "[*** OVERRIDE ***] Override value being used: 'identity.device.id' = '%1$s'", new Object[] { str });
      return str;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("GetJarClientPrefs", 0);
    if (localSharedPreferences.contains("InstallationID")) {
      return localSharedPreferences.getString("InstallationID", null);
    }
    str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (str == null) {
      paramContext = Long.toString(System.currentTimeMillis(), 36) + Integer.toString(sRnd.nextInt(Integer.MAX_VALUE), 36);
    }
    localSharedPreferences.edit().putString("InstallationID", paramContext).commit();
    return paramContext;
  }
  
  public static List<String> getLocalIpAddresses()
  {
    localArrayList = new ArrayList();
    try
    {
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      while (localEnumeration1.hasMoreElements())
      {
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        while (localEnumeration2.hasMoreElements())
        {
          InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
          if (!localInetAddress.isLoopbackAddress()) {
            localArrayList.add(localInetAddress.getHostAddress());
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      Logger.e(Area.COMM.value(), localException, "getLocalIpAddresses() failed", new Object[0]);
    }
  }
  
  public static String getLocale(Context paramContext)
  {
    return paramContext.getSharedPreferences("GetJarClientPrefs", 0).getString("Locale", null);
  }
  
  public static String getPackageNameFromBroadcastIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Must have a valid intent.");
    }
    paramIntent = paramIntent.getData();
    if (paramIntent != null) {
      return paramIntent.getSchemeSpecificPart();
    }
    return null;
  }
  
  public static long getResponseAmount(Exception paramException, long paramLong)
  {
    long l = paramLong;
    if (paramException.getClass().isInstance(ServiceException.class))
    {
      paramException = ((ServiceException)paramException).getRequestResult().getResponseJson();
      l = paramLong;
      if (paramException != null)
      {
        l = paramLong;
        if (paramException.length() <= 0) {}
      }
    }
    try
    {
      int i = paramException.getJSONObject("return").getInt("amount");
      l = i;
      return l;
    }
    catch (JSONException paramException)
    {
      Logger.e(Area.EARN.value(), paramException, "getResponseAmount() failed", new Object[0]);
    }
    return paramLong;
  }
  
  public static String getResponseSubstate(Exception paramException, String paramString)
  {
    Logger.d(Area.COMM.value(), "getResponseSubstate() -- START: defaultValue=" + paramString, new Object[0]);
    String str = paramString;
    Object localObject = str;
    if (paramException != null)
    {
      localObject = str;
      if (paramException.getClass().isInstance(ServiceException.class)) {
        localObject = str;
      }
    }
    try
    {
      paramException = ((ServiceException)paramException).getRequestResult();
      localObject = str;
      Logger.d(Area.COMM.value(), "getResponseSubstate() -- RequestResult=" + paramException.toString(), new Object[0]);
      localObject = str;
      paramException = paramException.getErrorResponseSubcode();
      localObject = paramException;
      boolean bool = StringUtility.isNullOrEmpty(paramException);
      localObject = paramException;
      if (bool) {
        localObject = paramString;
      }
    }
    catch (ClassCastException paramException)
    {
      for (;;)
      {
        Logger.e(Area.COMM.value(), paramException, "getResponseSubstate() failed", new Object[0]);
      }
    }
    Logger.d(Area.COMM.value(), "getResponseSubstate() -- DONE: substate=" + (String)localObject, new Object[0]);
    return (String)localObject;
  }
  
  public static boolean getSandboxMode(Context paramContext)
  {
    return paramContext.getSharedPreferences("GetJarClientPrefs", 0).getBoolean("SandBox", false);
  }
  
  public static Integer getStaticIntegerField(Class<?> paramClass, String paramString)
    throws IllegalArgumentException, IllegalAccessException
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("Must have a valid source type.");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("Must have a valid field name.");
    }
    try
    {
      int i = paramClass.getDeclaredField(paramString).getInt(null);
      return Integer.valueOf(i);
    }
    catch (NoSuchFieldException paramClass) {}
    return null;
  }
  
  public static String getUserAccessId(Context paramContext)
  {
    return paramContext.getSharedPreferences("GetJarClientPrefs", 0).getString("UserAccessID", null);
  }
  
  public static byte[] gzipCompress(String paramString)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString.getBytes());
    localGZIPOutputStream.close();
    paramString = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramString;
  }
  
  public static String gzipDecompress(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte, 32);
    StringBuilder localStringBuilder = new StringBuilder();
    byte[] arrayOfByte = new byte[32];
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(new String(arrayOfByte, 0, i));
    }
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return localStringBuilder.toString();
  }
  
  public static boolean isCurrentThreadTheUIThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public static boolean isExistApp(Context paramContext, String paramString)
  {
    try
    {
      if (paramContext.getPackageManager().getApplicationInfo(paramString, 0) != null)
      {
        Logger.d(Area.EARN.value(), "ReportUsage: isExistApp() -- TRUE..", new Object[0]);
        return true;
      }
      Logger.d(Area.EARN.value(), "ReportUsage: isExistApp() -- (appInfo NULL) FALSE..", new Object[0]);
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.d(Area.EARN.value(), "ReportUsage: isExistApp() -- (NameNotFoundException) FALSE..", new Object[0]);
    }
    return false;
  }
  
  public static HashMap<String, String> jsonArrayStringToMap(String paramString)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      if (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject.isNull("value")) {
          localHashMap.put(localJSONObject.getString("key"), null);
        }
        for (;;)
        {
          i += 1;
          break;
          localHashMap.put(localJSONObject.getString("key"), localJSONObject.getString("value"));
        }
      }
    }
    return localHashMap;
  }
  
  public static HashMap<String, String> jsonArrayStringToMapUnchange(String paramString)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    Logger.d(Area.COMM.value(), "Outside Unchange:" + paramString, new Object[0]);
    Object localObject;
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      Logger.d(Area.COMM.value(), "Inside", new Object[0]);
      paramString = new JSONArray(paramString);
      Logger.d(Area.COMM.value(), "JSONARRAY size:" + paramString.length(), new Object[0]);
      int i = 0;
      while (i < paramString.length())
      {
        localObject = paramString.getJSONObject(i);
        Iterator localIterator = ((JSONObject)localObject).keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, ((JSONObject)localObject).getString(str));
        }
        i += 1;
      }
    }
    paramString = localHashMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      localObject = (Map.Entry)paramString.next();
      Logger.d(Area.COMM.value(), (String)((Map.Entry)localObject).getKey() + ", " + (String)((Map.Entry)localObject).getValue(), new Object[0]);
    }
    return localHashMap;
  }
  
  public static String jsonObjectMapToJsonString(Map<String, JSONObject> paramMap)
    throws JSONException
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("'map' can not be NULL");
    }
    JSONArray localJSONArray = new JSONArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      JSONObject localJSONObject1 = (JSONObject)localEntry.getValue();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("key", localEntry.getKey());
      localJSONObject2.put("value", localJSONObject1);
      localJSONArray.put(localJSONObject2);
    }
    return localJSONArray.toString();
  }
  
  public static String mapToJsonString(Map<String, String> paramMap)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("key", paramMap.getKey());
      localJSONObject.put("value", paramMap.getValue());
      if (paramMap.getValue() == null) {}
      for (paramMap = JSONObject.NULL;; paramMap = paramMap.getValue())
      {
        localJSONObject.put("value", paramMap);
        localJSONArray.put(localJSONObject);
        break;
      }
    }
    return localJSONArray.toString();
  }
  
  public static String metadataMapToJsonString(Map<String, MetadataValue> paramMap)
    throws JSONException
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("'map' can not be NULL");
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = ((MetadataValue)localEntry.getValue()).getValue();
      JSONObject localJSONObject = new JSONObject();
      paramMap = str;
      if (str == null) {
        paramMap = JSONObject.NULL;
      }
      localJSONObject.put("value", paramMap);
      localJSONObject.put("reliability", ((MetadataValue)localEntry.getValue()).getReliability().name());
      paramMap = new JSONObject();
      paramMap.put("key", localEntry.getKey());
      paramMap.put("value", localJSONObject);
      localJSONArray.put(paramMap);
    }
    return localJSONArray.toString();
  }
  
  public static void previousVersionCleanUp(Context paramContext)
  {
    String[] arrayOfString = paramContext.databaseList();
    int k = 1;
    int m = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        String str = arrayOfString[i];
        Logger.d(Area.STORAGE.value(), "database:" + str, new Object[0]);
        if (str.equalsIgnoreCase("GetJarRewardsDB")) {
          j = 0;
        }
      }
      else
      {
        if (j == 0)
        {
          paramContext.deleteDatabase("GetJarRewardsDB");
          paramContext = paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit();
          paramContext.clear();
          paramContext.clear();
          paramContext.commit();
        }
        return;
      }
      i += 1;
    }
  }
  
  public static void saveLocale(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit().putString("Locale", paramString).commit();
  }
  
  public static void saveSandboxMode(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit().putBoolean("SandBox", paramBoolean).commit();
  }
  
  public static void setLocale(Context paramContext, String paramString)
  {
    paramString = new Locale(paramString);
    Locale.setDefault(paramString);
    Configuration localConfiguration = new Configuration();
    localConfiguration.locale = paramString;
    paramContext.getResources().updateConfiguration(localConfiguration, paramContext.getResources().getDisplayMetrics());
  }
  
  public static void setUserAccessId(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("GetJarClientPrefs", 0).edit().putString("UserAccessID", paramString).commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */