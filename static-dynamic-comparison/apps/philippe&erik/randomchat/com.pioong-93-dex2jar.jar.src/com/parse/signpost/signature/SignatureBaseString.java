package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Set;

public class SignatureBaseString
{
  private HttpRequest request;
  private HttpParameters requestParameters;
  
  public SignatureBaseString(HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
  {
    this.request = paramHttpRequest;
    this.requestParameters = paramHttpParameters;
  }
  
  public String generate()
    throws OAuthMessageSignerException
  {
    try
    {
      String str1 = normalizeRequestUrl();
      String str2 = normalizeRequestParameters();
      str1 = this.request.getMethod() + '&' + OAuth.percentEncode(str1) + '&' + OAuth.percentEncode(str2);
      return str1;
    }
    catch (Exception localException)
    {
      throw new OAuthMessageSignerException(localException);
    }
  }
  
  public String normalizeRequestParameters()
    throws IOException
  {
    if (this.requestParameters == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.requestParameters.keySet().iterator();
    int i = 0;
    if (!localIterator.hasNext()) {
      return localStringBuilder.toString();
    }
    String str = (String)localIterator.next();
    if (("oauth_signature".equals(str)) || ("realm".equals(str))) {}
    for (;;)
    {
      i += 1;
      break;
      if (i > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(this.requestParameters.getAsQueryString(str));
    }
  }
  
  public String normalizeRequestUrl()
    throws URISyntaxException
  {
    Object localObject3 = new URI(this.request.getRequestUrl());
    String str = ((URI)localObject3).getScheme().toLowerCase();
    Object localObject2 = ((URI)localObject3).getAuthority().toLowerCase();
    if (((!str.equals("http")) || (((URI)localObject3).getPort() != 80)) && ((!str.equals("https")) || (((URI)localObject3).getPort() != 443))) {}
    for (int i = 0;; i = 1)
    {
      Object localObject1 = localObject2;
      if (i != 0)
      {
        i = ((String)localObject2).lastIndexOf(":");
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
      }
      localObject3 = ((URI)localObject3).getRawPath();
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (((String)localObject3).length() > 0) {}
      }
      else
      {
        localObject2 = "/";
      }
      return str + "://" + (String)localObject1 + (String)localObject2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/signature/SignatureBaseString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */