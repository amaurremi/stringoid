package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

public class QueryStringSigningStrategy
  implements SigningStrategy
{
  private static final long serialVersionUID = 1L;
  
  public String writeSignature(String paramString, HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
  {
    paramString = new StringBuilder(OAuth.addQueryParameters(paramHttpRequest.getRequestUrl(), new String[] { "oauth_signature", paramString }));
    if (paramHttpParameters.containsKey("oauth_token"))
    {
      paramString.append("&");
      paramString.append(paramHttpParameters.getAsQueryString("oauth_token"));
    }
    if (paramHttpParameters.containsKey("oauth_callback"))
    {
      paramString.append("&");
      paramString.append(paramHttpParameters.getAsQueryString("oauth_callback"));
    }
    if (paramHttpParameters.containsKey("oauth_verifier"))
    {
      paramString.append("&");
      paramString.append(paramHttpParameters.getAsQueryString("oauth_verifier"));
    }
    paramString.append("&");
    paramString.append(paramHttpParameters.getAsQueryString("oauth_consumer_key"));
    paramString.append("&");
    paramString.append(paramHttpParameters.getAsQueryString("oauth_version"));
    paramString.append("&");
    paramString.append(paramHttpParameters.getAsQueryString("oauth_signature_method"));
    paramString.append("&");
    paramString.append(paramHttpParameters.getAsQueryString("oauth_timestamp"));
    paramString.append("&");
    paramString.append(paramHttpParameters.getAsQueryString("oauth_nonce"));
    paramString = paramString.toString();
    paramHttpRequest.setRequestUrl(paramString);
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/signature/QueryStringSigningStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */