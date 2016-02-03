package com.jumptap.adtag;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class JtAdWidgetSettings
  implements Cloneable
{
  private static final String ANDROID_OS = "Linux";
  private static final String BASE_JT_URL = "http://a.jumptap.com/a/ads?textOnly=f";
  private static final String DEFAULT_LANG = "en";
  private static final int DEFAULT_REFRESH_PERIOD = 60;
  private static final String DISMISS_BUTTON_DEFAULT_LABEL = "Close";
  private static final int INTERSTITIAL_SHOW_DEFAULT_TIME = 10;
  private static final String JT_BUNDLE = "com.jumptap.adtag-android";
  private static final String JT_LIB_VER = "2.5.0.0";
  private static final String TAPLINK_VER = "v28";
  private static final String XHTML = "xhtml";
  private String adFormat = "xhtml";
  private String adultContentType = "notallowed";
  private String age = "";
  private Bitmap alternateImage;
  private String appId = "";
  private String appVer = "";
  private int backgroundColor = -1;
  private String bundleVersion = "com.jumptap.adtag-android";
  private String country = "";
  private String dismissButtonLabel = "Close";
  private String gender = "";
  private int height = 50;
  private String hhi = "";
  private String host = "http://a.jumptap.com/a/ads?textOnly=f";
  private int interstitialshowTime = 10;
  private String jtLibVer = "2.5.0.0";
  private String language = "en";
  private String os = "Linux";
  private String postalCode = "";
  private String publisherId = null;
  private int refreshPeriod = 60;
  private boolean shouldDebugNetworkTraffic = false;
  private boolean shouldSendLocation = true;
  private String siteId = null;
  private String spotId = null;
  private String userAgent = null;
  private String version = "v28";
  private int width = 320;
  
  protected JtAdWidgetSettings() {}
  
  protected JtAdWidgetSettings(String paramString)
  {
    this.publisherId = paramString;
  }
  
  public JtAdWidgetSettings copy()
  {
    try
    {
      JtAdWidgetSettings localJtAdWidgetSettings = (JtAdWidgetSettings)clone();
      return localJtAdWidgetSettings;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      Log.d("JtAd", localCloneNotSupportedException.getMessage());
    }
    return null;
  }
  
  protected String getAdFormat()
  {
    return this.adFormat;
  }
  
  public String getAdultContentType()
  {
    return this.adultContentType;
  }
  
  public String getAge()
  {
    return this.age;
  }
  
  public Bitmap getAlternateImage()
  {
    return this.alternateImage;
  }
  
  public String getApplicationId()
  {
    return this.appId;
  }
  
  public String getApplicationVersion()
  {
    return this.appVer;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public String getBundleVersion()
  {
    return this.bundleVersion;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getDismissButtonLabel()
  {
    return this.dismissButtonLabel;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public String getHHI()
  {
    return this.hhi;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getHostURL()
  {
    return this.host;
  }
  
  public int getInterstitialshowTime()
  {
    return this.interstitialshowTime;
  }
  
  public String getJtLibVer()
  {
    return this.jtLibVer;
  }
  
  public String getLanguage()
  {
    return this.language;
  }
  
  public String getOs()
  {
    return this.os;
  }
  
  public String getPostalCode()
  {
    return this.postalCode;
  }
  
  public String getPublisherId()
  {
    return this.publisherId;
  }
  
  public int getRefreshPeriod()
  {
    return this.refreshPeriod;
  }
  
  public boolean getShouldDebugNetworkTraffic()
  {
    return this.shouldDebugNetworkTraffic;
  }
  
  public String getSiteId()
  {
    return this.siteId;
  }
  
  public String getSpotId()
  {
    return this.spotId;
  }
  
  public String getUserAgent(WebView paramWebView)
  {
    if (this.userAgent == null)
    {
      this.userAgent = paramWebView.getSettings().getUserAgentString();
      Log.d("JtAd", "userAgent: " + this.userAgent);
    }
    return this.userAgent;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isShouldSendLocation()
  {
    return this.shouldSendLocation;
  }
  
  public void setAdFormat(String paramString)
  {
    this.adFormat = paramString;
  }
  
  public void setAdultContentType(String paramString)
  {
    this.adultContentType = paramString;
  }
  
  public void setAge(String paramString)
  {
    this.age = paramString;
  }
  
  public void setAlternateImage(Bitmap paramBitmap)
  {
    this.alternateImage = paramBitmap;
  }
  
  public void setApplicationId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setApplicationVersion(String paramString)
  {
    this.appVer = paramString;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setCountry(String paramString)
  {
    this.country = paramString;
  }
  
  public void setDismissButtonLabel(String paramString)
  {
    this.dismissButtonLabel = paramString;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setHHI(String paramString)
  {
    this.hhi = paramString;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setHostURL(String paramString)
  {
    this.host = paramString;
  }
  
  public void setInterstitialshowTime(int paramInt)
  {
    this.interstitialshowTime = paramInt;
  }
  
  public void setLanguage(String paramString)
  {
    this.language = paramString;
  }
  
  public void setPostalCode(String paramString)
  {
    this.postalCode = paramString;
  }
  
  public void setPublisherId(String paramString)
  {
    this.publisherId = paramString;
  }
  
  public void setRefreshPeriod(int paramInt)
  {
    this.refreshPeriod = paramInt;
  }
  
  public void setShouldDebugNetworkTraffic(boolean paramBoolean)
  {
    this.shouldDebugNetworkTraffic = paramBoolean;
  }
  
  public void setShouldSendLocation(boolean paramBoolean)
  {
    this.shouldSendLocation = paramBoolean;
  }
  
  public void setSiteId(String paramString)
  {
    this.siteId = paramString;
  }
  
  public void setSpotId(String paramString)
  {
    this.spotId = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public static abstract interface AdultContent
  {
    public static final String ALLOWED = "allowed";
    public static final String NOT_ALLOWED = "notallowed";
    public static final String ONLY = "only";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/JtAdWidgetSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */