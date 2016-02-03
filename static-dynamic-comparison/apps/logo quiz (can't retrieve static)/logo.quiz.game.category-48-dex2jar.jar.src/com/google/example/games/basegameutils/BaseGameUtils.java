package com.google.example.games.basegameutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

public class BaseGameUtils
{
  public static Dialog makeSimpleDialog(Activity paramActivity, String paramString)
  {
    return new AlertDialog.Builder(paramActivity).setMessage(paramString).setNeutralButton(17039370, null).create();
  }
  
  public static Dialog makeSimpleDialog(Activity paramActivity, String paramString1, String paramString2)
  {
    return new AlertDialog.Builder(paramActivity).setTitle(paramString1).setMessage(paramString2).setNeutralButton(17039370, null).create();
  }
  
  public static boolean resolveConnectionFailure(Activity paramActivity, GoogleApiClient paramGoogleApiClient, ConnectionResult paramConnectionResult, int paramInt, String paramString)
  {
    if (paramConnectionResult.hasResolution()) {
      try
      {
        paramConnectionResult.startResolutionForResult(paramActivity, paramInt);
        return true;
      }
      catch (IntentSender.SendIntentException paramActivity)
      {
        paramGoogleApiClient.connect();
        return false;
      }
    }
    paramGoogleApiClient = GooglePlayServicesUtil.getErrorDialog(paramConnectionResult.getErrorCode(), paramActivity, paramInt);
    if (paramGoogleApiClient != null)
    {
      paramGoogleApiClient.show();
      return false;
    }
    showAlert(paramActivity, paramString);
    return false;
  }
  
  public static void showActivityResultError(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramActivity == null)
    {
      Log.e("BaseGameUtils", "*** No Activity. Can't show failure dialog!");
      return;
    }
    Dialog localDialog1;
    switch (paramInt2)
    {
    default: 
      Dialog localDialog2 = GooglePlayServicesUtil.getErrorDialog(paramInt3, paramActivity, paramInt1, null);
      localDialog1 = localDialog2;
      if (localDialog2 == null)
      {
        Log.e("BaseGamesUtils", "No standard error dialog available. Making fallback dialog.");
        localDialog1 = makeSimpleDialog(paramActivity, paramActivity.getString(paramInt3) + " " + paramActivity.getString(paramInt4));
      }
      break;
    }
    for (;;)
    {
      localDialog1.show();
      return;
      localDialog1 = makeSimpleDialog(paramActivity, paramActivity.getString(R.string.gamehelper_app_misconfigured));
      continue;
      localDialog1 = makeSimpleDialog(paramActivity, paramActivity.getString(R.string.gamehelper_sign_in_failed));
      continue;
      localDialog1 = makeSimpleDialog(paramActivity, paramActivity.getString(R.string.gamehelper_license_failed));
    }
  }
  
  public static void showAlert(Activity paramActivity, String paramString)
  {
    new AlertDialog.Builder(paramActivity).setMessage(paramString).setNeutralButton(17039370, null).create().show();
  }
  
  public static boolean verifySampleSetup(Activity paramActivity, int... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    localStringBuilder.append("The following set up problems were found:\n\n");
    if (paramActivity.getPackageName().startsWith("com.google.example.games"))
    {
      i = 1;
      localStringBuilder.append("- Package name cannot be com.google.*. You need to change the sample's package name to your own package.").append("\n");
    }
    int m = paramVarArgs.length;
    int j = 0;
    for (;;)
    {
      int k = i;
      if (j < m)
      {
        if (paramActivity.getString(paramVarArgs[j]).toLowerCase().contains("replaceme"))
        {
          k = 1;
          localStringBuilder.append("- You must replace all placeholder IDs in the ids.xml file by your project's IDs.").append("\n");
        }
      }
      else
      {
        if (k == 0) {
          break;
        }
        localStringBuilder.append("\n\nThese problems may prevent the app from working properly.");
        showAlert(paramActivity, localStringBuilder.toString());
        return false;
      }
      j += 1;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/example/games/basegameutils/BaseGameUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */