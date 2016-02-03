package com.getjar.sdk.comm;

import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.utilities.StringUtility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class ImageServiceProxy
  extends ServiceProxyBase
{
  private static final String _CONTRACT_VERSION = "20120612";
  private static volatile ImageServiceProxy _Instance = null;
  private static final String _URL_TEMPLATE_GET_IMAGE = String.format(Locale.US, "%1$s%2$s", new Object[] { "%1$simage/images/%2$s?optimize_size=true&version=", "20120612" });
  
  public static ImageServiceProxy getInstance()
  {
    if (_Instance == null) {
      makeTheInstance();
    }
    return _Instance;
  }
  
  private static void makeTheInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new ImageServiceProxy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Operation getImage(CommContext paramCommContext, String paramString, Integer paramInteger1, Integer paramInteger2, boolean paramBoolean)
    throws Exception
  {
    if (paramCommContext == null) {
      throw new IllegalArgumentException("The required parameter 'commContext' was not provided");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'imageId' can not be NULL or empty");
    }
    try
    {
      String str = String.format(Locale.US, _URL_TEMPLATE_GET_IMAGE, new Object[] { GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("service.image.endpoint", SettingsManager.Scope.CLIENT), URLEncoder.encode(paramString, "UTF-8") });
      paramString = str;
      if (paramInteger1 != null) {
        paramString = String.format(Locale.US, "%1$s&width=%2$d", new Object[] { str, Integer.valueOf(paramInteger1.intValue()) });
      }
      paramInteger1 = paramString;
      if (paramInteger2 != null) {
        paramInteger1 = String.format(Locale.US, "%1$s&height=%2$d", new Object[] { paramString, Integer.valueOf(paramInteger2.intValue()) });
      }
      return makeAsyncGETRequestForJson("getImage", Operation.Priority.MEDIUM, paramCommContext, paramInteger1, null, null, paramBoolean, false, true);
    }
    catch (UnsupportedEncodingException paramCommContext)
    {
      throw new CommunicationException(paramCommContext);
    }
  }
  
  public Operation getImage(CommContext paramCommContext, String paramString, boolean paramBoolean)
    throws Exception
  {
    return getImage(paramCommContext, paramString, null, null, paramBoolean);
  }
  
  protected Request.ServiceName getServiceName()
  {
    return Request.ServiceName.IMAGE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/ImageServiceProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */