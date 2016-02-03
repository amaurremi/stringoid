package com.parse.signpost.signature;

import com.parse.signpost.OAuth;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;

public class PlainTextMessageSigner
  extends OAuthMessageSigner
{
  public String getSignatureMethod()
  {
    return "PLAINTEXT";
  }
  
  public String sign(HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
    throws OAuthMessageSignerException
  {
    return OAuth.percentEncode(getConsumerSecret()) + '&' + OAuth.percentEncode(getTokenSecret());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/signature/PlainTextMessageSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */