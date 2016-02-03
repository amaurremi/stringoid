package com.getjar.sdk.comm;

import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.exceptions.ServiceException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.Header;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.json.JSONException;
import org.json.JSONObject;

public final class RequestUtilities
{
  protected static boolean checkForRetryOnException(Exception paramException, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (isSafeRetriableException(paramException)) || (isUnsafeRetriableException(paramException));
    }
    return isSafeRetriableException(paramException);
  }
  
  protected static void debugDumpRequestProperties(HttpRequestBase paramHttpRequestBase, int paramInt)
  {
    if (Logger.getInstance().shouldLog(3, Area.COMM.value())) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("[request:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] The request headers for this request:\r\n");
      paramHttpRequestBase = paramHttpRequestBase.getAllHeaders();
      int j = paramHttpRequestBase.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramHttpRequestBase[i];
        localStringBuilder.append(Area.COMM.name());
        localStringBuilder.append(":      [request:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("] ");
        localStringBuilder.append(((Header)localObject).getName());
        localStringBuilder.append(" = ");
        localStringBuilder.append(((Header)localObject).getValue());
        localStringBuilder.append("\r\n");
        i += 1;
      }
      Logger.d(Area.COMM.value(), localStringBuilder.toString(), new Object[0]);
      return;
    }
    catch (Throwable paramHttpRequestBase)
    {
      paramHttpRequestBase.printStackTrace();
    }
  }
  
  protected static String getPostDataBlob(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      try
      {
        localStringBuilder.append(URLEncoder.encode((String)paramMap.get(str), "UTF-8"));
        if (localIterator.hasNext()) {
          localStringBuilder.append("&");
        }
      }
      catch (UnsupportedEncodingException paramMap)
      {
        throw new CommunicationException(paramMap);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static ServiceException getServicesException(Result paramResult)
    throws ServiceException, JSONException
  {
    if (paramResult == null) {
      throw new IllegalArgumentException("'result' can not be NULL");
    }
    if (paramResult.getResponseJson() != null)
    {
      if (paramResult.getResponseJson().has("error")) {
        return new ServiceException(String.format(Locale.US, "[ResponseCode: %1$d] Result: %2$s", new Object[] { Integer.valueOf(paramResult.getResponseCode()), paramResult.getResponseJson().toString(2) }), paramResult);
      }
      if (!paramResult.getResponseJson().has("return")) {
        return new ServiceException(String.format(Locale.US, "Unexpected JSON result [ResponseCode: %1$d] Result: %2$s", new Object[] { Integer.valueOf(paramResult.getResponseCode()), paramResult.getResponseJson().toString(2) }), paramResult);
      }
    }
    return null;
  }
  
  public static boolean isNetworkException(Exception paramException)
  {
    return (paramException != null) && ((isSafeRetriableException(paramException)) || (isUnsafeRetriableException(paramException)));
  }
  
  private static boolean isSafeRetriableException(Exception paramException)
  {
    return ((paramException instanceof SSLHandshakeException)) || ((paramException instanceof SSLKeyException)) || ((paramException instanceof SSLPeerUnverifiedException)) || ((paramException instanceof HttpHostConnectException)) || ((paramException instanceof ConnectTimeoutException)) || ((paramException instanceof ConnectException)) || ((paramException instanceof UnknownHostException)) || ((paramException instanceof BindException)) || ((paramException instanceof NoRouteToHostException)) || ((paramException instanceof PortUnreachableException)) || ((paramException instanceof UnknownServiceException)) || ((paramException instanceof NetworkUnavailableException));
  }
  
  private static boolean isUnsafeRetriableException(Exception paramException)
  {
    return ((paramException instanceof SSLProtocolException)) || ((paramException instanceof NoHttpResponseException)) || ((paramException instanceof ClientProtocolException)) || ((paramException instanceof SSLException)) || ((paramException instanceof SocketTimeoutException)) || ((paramException instanceof HttpRetryException)) || ((paramException instanceof ProtocolException)) || ((paramException instanceof SocketException)) || (paramException.getClass().getName().startsWith("org.apache.http"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/RequestUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */