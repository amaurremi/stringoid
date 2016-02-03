package com.getjar.sdk.utilities;

import android.graphics.Bitmap;

public class DownloadUrl
{
  private Bitmap mAppIcon;
  private String mAppLink;
  private String mAppName;
  private String mAppPackageName;
  private Bitmap mGetIcon;
  private String mGetJarLink;
  private String mGetJarName;
  private String mGetJarPackageName;
  
  public DownloadUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.mAppName = paramString1;
    this.mAppLink = paramString3;
    this.mGetJarLink = paramString6;
    this.mGetIcon = paramBitmap2;
    this.mAppIcon = paramBitmap1;
    this.mAppPackageName = paramString2;
    this.mGetJarName = paramString4;
    this.mGetJarPackageName = paramString5;
  }
  
  public Bitmap getAppIcon()
  {
    return this.mAppIcon;
  }
  
  public String getAppLink()
  {
    return this.mAppLink;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public String getAppPackageName()
  {
    return this.mAppPackageName;
  }
  
  public Bitmap getGetJarIcon()
  {
    return this.mGetIcon;
  }
  
  public String getGetJarLink()
  {
    return this.mGetJarLink;
  }
  
  public String getGetJarName()
  {
    return this.mGetJarName;
  }
  
  public String getGetPackageName()
  {
    return this.mGetJarPackageName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/DownloadUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */