package com.adfonic.android.api.request.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class AndroidDeviceId
{
  private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
  private static final String PREFERENCE_DEVICE_ID = "UUID";
  
  private static String SHA1(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes());
      paramString = asHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  private static String asHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfChar[(i * 2)] = HEX_CHARS[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      arrayOfChar[(i * 2 + 1)] = HEX_CHARS[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static String getAndroidDeviceId(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String getDpId(Context paramContext)
  {
    String str2 = getAndroidDeviceId(paramContext);
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    do
    {
      return str1;
      str1 = SHA1(str2);
    } while (!str2.equals("9774d56d682e549c"));
    return getTestRandomDeviceIdFromPreferences(paramContext);
  }
  
  private static String getTestRandomDeviceIdFromPreferences(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("Adfonic", 0);
    if (((SharedPreferences)localObject).getString("UUID", null) == null)
    {
      paramContext = SHA1(UUID.randomUUID().toString());
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("UUID", paramContext);
      ((SharedPreferences.Editor)localObject).commit();
      return paramContext;
    }
    return ((SharedPreferences)localObject).getString("UUID", "");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/request/utils/AndroidDeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */