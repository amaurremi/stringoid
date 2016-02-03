package com.jumptap.adtag.utils;

import android.content.Context;
import android.webkit.WebView;
import com.jumptap.adtag.JtAdWidgetSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class JtAdUrlBuilder
{
  private static final String JT_COUNT = "1";
  private Context context;
  private JtAdWidgetSettings widgetSettings;
  
  public JtAdUrlBuilder(JtAdWidgetSettings paramJtAdWidgetSettings, Context paramContext)
  {
    this.widgetSettings = paramJtAdWidgetSettings;
    this.context = paramContext;
  }
  
  public static String encodeParam(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getAdUrl(WebView paramWebView)
  {
    return getAdUrl(paramWebView, null);
  }
  
  public String getAdUrl(WebView paramWebView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.widgetSettings.getHostURL());
    localStringBuilder.append("&ua=").append(encodeParam(this.widgetSettings.getUserAgent(paramWebView)));
    localStringBuilder.append("&pub=").append(encodeParam(this.widgetSettings.getPublisherId()));
    localStringBuilder.append("&spot=").append(encodeParam(this.widgetSettings.getSpotId()));
    localStringBuilder.append("&site=").append(encodeParam(this.widgetSettings.getSiteId()));
    if (this.widgetSettings.isShouldSendLocation())
    {
      str = JtAdManager.getLocation(this.context);
      if (str != null)
      {
        localStringBuilder.append("&ll=").append(encodeParam(str));
        localStringBuilder.append("&country=").append(encodeParam(this.widgetSettings.getCountry()));
        localStringBuilder.append("&pc=").append(encodeParam(this.widgetSettings.getPostalCode()));
      }
    }
    localStringBuilder.append("&mt-age=").append(encodeParam(this.widgetSettings.getAge()));
    localStringBuilder.append("&mt-gender=").append(encodeParam(this.widgetSettings.getGender()));
    localStringBuilder.append("&mt-hhi=").append(encodeParam(this.widgetSettings.getHHI()));
    localStringBuilder.append("&hid_sha1=").append(encodeParam(JtAdManager.getHIDSHA1(this.context)));
    localStringBuilder.append("&a=").append(encodeParam(this.widgetSettings.getAdultContentType()));
    localStringBuilder.append("&l=").append(encodeParam(this.widgetSettings.getLanguage()));
    localStringBuilder.append("&c=").append(encodeParam("1"));
    localStringBuilder.append("&version=").append(encodeParam(this.widgetSettings.getVersion()));
    localStringBuilder.append("&mt-speed=").append(encodeParam(JtAdManager.getConnectionType(this.context)));
    localStringBuilder.append("&mt-jtlib=").append(encodeParam(this.widgetSettings.getJtLibVer()));
    localStringBuilder.append("&mt-bundle=").append(encodeParam(this.widgetSettings.getBundleVersion()));
    localStringBuilder.append("&mt-os=").append(encodeParam(this.widgetSettings.getOs()));
    localStringBuilder.append("&mt-osversion=").append(encodeParam(JtAdManager.getSDKVersion()));
    localStringBuilder.append("&mt-model=").append(encodeParam(JtAdManager.getAndroidModel()));
    localStringBuilder.append("&mt-make=").append(encodeParam(JtAdManager.getBrand()));
    localStringBuilder.append("&mt-fw=").append(encodeParam(JtAdManager.getKernelVersion()));
    localStringBuilder.append("&mt-operator=").append(encodeParam(JtAdManager.getOperatorName(this.context)));
    localStringBuilder.append("&mt-nradio=").append(encodeParam(JtAdManager.getNetworkType(this.context)));
    localStringBuilder.append("&mt-dradio=").append(encodeParam(JtAdManager.getPhoneType(this.context)));
    int i = paramWebView.getWidth();
    int j = paramWebView.getHeight();
    paramWebView = Integer.toString(i);
    String str = Integer.toString(j);
    localStringBuilder.append("&mt-width=").append(encodeParam(paramWebView));
    localStringBuilder.append("&mt-height=").append(encodeParam(str));
    if (paramString != null) {
      localStringBuilder.append("&" + paramString);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/utils/JtAdUrlBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */