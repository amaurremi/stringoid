package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

public class AuthorizationHeaderSigningStrategy
  implements SigningStrategy
{
  private static final long serialVersionUID = 1L;
  
  public String writeSignature(String paramString, HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OAuth ");
    if (paramHttpParameters.containsKey("realm"))
    {
      localStringBuilder.append(paramHttpParameters.getAsHeaderElement("realm"));
      localStringBuilder.append(", ");
    }
    if (paramHttpParameters.containsKey("oauth_token"))
    {
      localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_token"));
      localStringBuilder.append(", ");
    }
    if (paramHttpParameters.containsKey("oauth_callback"))
    {
      localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_callback"));
      localStringBuilder.append(", ");
    }
    if (paramHttpParameters.containsKey("oauth_verifier"))
    {
      localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_verifier"));
      localStringBuilder.append(", ");
    }
    localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_consumer_key"));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_version"));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_signature_method"));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_timestamp"));
    localStringBuilder.append(", ");
    localStringBuilder.append(paramHttpParameters.getAsHeaderElement("oauth_nonce"));
    localStringBuilder.append(", ");
    localStringBuilder.append(OAuth.toHeaderElement("oauth_signature", paramString));
    paramString = localStringBuilder.toString();
    paramHttpRequest.setHeader("Authorization", paramString);
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/signature/AuthorizationHeaderSigningStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */