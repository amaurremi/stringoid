package com.google.example.games.basegameutils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class GameHelperUtils
{
  private static final String[] FALLBACK_STRINGS = { "*Unknown error.", "*Failed to sign in. Please check your network connection and try again.", "*The application is incorrectly configured. Check that the package name and signing certificate match the client ID created in Developer Console. Also, if the application is not yet published, check that the account you are trying to sign in with is listed as a tester account. See logs for more information.", "*License check failed." };
  private static final int[] RES_IDS = { R.string.gamehelper_unknown_error, R.string.gamehelper_sign_in_failed, R.string.gamehelper_app_misconfigured, R.string.gamehelper_license_failed };
  public static final int R_APP_MISCONFIGURED = 2;
  public static final int R_LICENSE_FAILED = 3;
  public static final int R_SIGN_IN_FAILED = 1;
  public static final int R_UNKNOWN_ERROR = 0;
  
  static String activityResponseCodeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case -1: 
      return "RESULT_OK";
    case 0: 
      return "RESULT_CANCELED";
    case 10004: 
      return "RESULT_APP_MISCONFIGURED";
    case 10005: 
      return "RESULT_LEFT_ROOM";
    case 10003: 
      return "RESULT_LICENSE_FAILED";
    case 10001: 
      return "RESULT_RECONNECT_REQUIRED";
    }
    return "SIGN_IN_FAILED";
  }
  
  static void byteToString(StringBuilder paramStringBuilder, byte paramByte)
  {
    if (paramByte < 0) {
      paramByte += 256;
    }
    for (;;)
    {
      int i = paramByte / 16;
      paramByte %= 16;
      paramStringBuilder.append("0123456789ABCDEF".substring(i, i + 1));
      paramStringBuilder.append("0123456789ABCDEF".substring(paramByte, paramByte + 1));
      return;
    }
  }
  
  static String errorCodeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown error code " + paramInt;
    case 10: 
      return "DEVELOPER_ERROR(" + paramInt + ")";
    case 8: 
      return "INTERNAL_ERROR(" + paramInt + ")";
    case 5: 
      return "INVALID_ACCOUNT(" + paramInt + ")";
    case 11: 
      return "LICENSE_CHECK_FAILED(" + paramInt + ")";
    case 7: 
      return "NETWORK_ERROR(" + paramInt + ")";
    case 6: 
      return "RESOLUTION_REQUIRED(" + paramInt + ")";
    case 3: 
      return "SERVICE_DISABLED(" + paramInt + ")";
    case 9: 
      return "SERVICE_INVALID(" + paramInt + ")";
    case 1: 
      return "SERVICE_MISSING(" + paramInt + ")";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED(" + paramInt + ")";
    case 4: 
      return "SIGN_IN_REQUIRED(" + paramInt + ")";
    }
    return "SUCCESS(" + paramInt + ")";
  }
  
  static String getAppIdFromResource(Context paramContext)
  {
    try
    {
      Resources localResources = paramContext.getResources();
      paramContext = localResources.getString(localResources.getIdentifier("app_id", "string", paramContext.getPackageName()));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "??? (failed to retrieve APP ID)";
  }
  
  static String getSHA1CertFingerprint(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
      if (paramContext.length == 0) {
        return "ERROR: NO SIGNATURE.";
      }
      if (paramContext.length > 1) {
        return "ERROR: MULTIPLE SIGNATURES";
      }
      paramContext = MessageDigest.getInstance("SHA1").digest(paramContext[0].toByteArray());
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramContext.length)
      {
        if (i > 0) {
          localStringBuilder.append(":");
        }
        byteToString(localStringBuilder, paramContext[i]);
        i += 1;
      }
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return "(ERROR: package not found)";
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "(ERROR: SHA1 algorithm not found)";
  }
  
  static String getString(Context paramContext, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RES_IDS.length)) {}
    int i;
    for (;;)
    {
      i = RES_IDS[paramInt];
      try
      {
        paramContext = paramContext.getString(i);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        Log.w("GameHelper", "*** GameHelper could not found resource id #" + i + ". " + "This probably happened because you included it as a stand-alone JAR. " + "BaseGameUtils should be compiled as a LIBRARY PROJECT, so that it can access " + "its resources. Using a fallback string.");
      }
      paramInt = 0;
    }
    return FALLBACK_STRINGS[paramInt];
  }
  
  static void printMisconfiguredDebugInfo(Context paramContext)
  {
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "**** APP NOT CORRECTLY CONFIGURED TO USE GOOGLE PLAY GAME SERVICES");
    Log.w("GameHelper", "**** This is usually caused by one of these reasons:");
    Log.w("GameHelper", "**** (1) Your package name and certificate fingerprint do not match");
    Log.w("GameHelper", "****     the client ID you registered in Developer Console.");
    Log.w("GameHelper", "**** (2) Your App ID was incorrectly entered.");
    Log.w("GameHelper", "**** (3) Your game settings have not been published and you are ");
    Log.w("GameHelper", "****     trying to log in with an account that is not listed as");
    Log.w("GameHelper", "****     a test account.");
    Log.w("GameHelper", "****");
    if (paramContext == null)
    {
      Log.w("GameHelper", "*** (no Context, so can't print more debug info)");
      return;
    }
    Log.w("GameHelper", "**** To help you debug, here is the information about this app");
    Log.w("GameHelper", "**** Package name         : " + paramContext.getPackageName());
    Log.w("GameHelper", "**** Cert SHA1 fingerprint: " + getSHA1CertFingerprint(paramContext));
    Log.w("GameHelper", "**** App ID from          : " + getAppIdFromResource(paramContext));
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "**** Check that the above information matches your setup in ");
    Log.w("GameHelper", "**** Developer Console. Also, check that you're logging in with the");
    Log.w("GameHelper", "**** right account (it should be listed in the Testers section if");
    Log.w("GameHelper", "**** your project is not yet published).");
    Log.w("GameHelper", "****");
    Log.w("GameHelper", "**** For more information, refer to the troubleshooting guide:");
    Log.w("GameHelper", "****   http://developers.google.com/games/services/android/troubleshooting");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/example/games/basegameutils/GameHelperUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */