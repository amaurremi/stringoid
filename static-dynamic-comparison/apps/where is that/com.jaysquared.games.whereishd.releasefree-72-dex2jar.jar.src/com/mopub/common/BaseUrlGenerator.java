package com.mopub.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings.Secure;
import com.mopub.common.util.Strings;
import com.mopub.common.util.Utils;

public abstract class BaseUrlGenerator
{
  private static final String IFA_PREFIX = "ifa:";
  private static final String SHA_PREFIX = "sha:";
  private boolean mFirstParam;
  private StringBuilder mStringBuilder;
  
  private String getParamDelimiter()
  {
    if (this.mFirstParam)
    {
      this.mFirstParam = false;
      return "?";
    }
    return "&";
  }
  
  protected void addParam(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (Strings.isEmpty(paramString2))) {
      return;
    }
    this.mStringBuilder.append(getParamDelimiter());
    this.mStringBuilder.append(paramString1);
    this.mStringBuilder.append("=");
    this.mStringBuilder.append(Uri.encode(paramString2));
  }
  
  public abstract String generateUrlString(String paramString);
  
  protected String getAppVersionFromContext(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  protected String getFinalUrlString()
  {
    return this.mStringBuilder.toString();
  }
  
  protected String getUdidFromContext(Context paramContext)
  {
    String str = GpsHelper.getAdvertisingId(paramContext);
    if (str != null) {
      return "ifa:" + str;
    }
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (paramContext == null) {}
    for (paramContext = "";; paramContext = Utils.sha1(paramContext)) {
      return "sha:" + paramContext;
    }
  }
  
  protected void initUrlString(String paramString1, String paramString2)
  {
    this.mStringBuilder = new StringBuilder("http://" + paramString1 + paramString2);
    this.mFirstParam = true;
  }
  
  protected void setApiVersion(String paramString)
  {
    addParam("v", paramString);
  }
  
  protected void setAppVersion(String paramString)
  {
    addParam("av", paramString);
  }
  
  protected void setDeviceInfo(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return;
    }
    int i = 0;
    while (i < paramVarArgs.length - 1)
    {
      localStringBuilder.append(paramVarArgs[i]).append(",");
      i += 1;
    }
    localStringBuilder.append(paramVarArgs[(paramVarArgs.length - 1)]);
    addParam("dn", localStringBuilder.toString());
  }
  
  protected void setDoNotTrack(boolean paramBoolean)
  {
    if (paramBoolean) {
      addParam("dnt", "1");
    }
  }
  
  protected void setExternalStoragePermission(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      addParam("android_perms_ext_storage", str);
      return;
    }
  }
  
  protected void setUdid(String paramString)
  {
    addParam("udid", paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/common/BaseUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */