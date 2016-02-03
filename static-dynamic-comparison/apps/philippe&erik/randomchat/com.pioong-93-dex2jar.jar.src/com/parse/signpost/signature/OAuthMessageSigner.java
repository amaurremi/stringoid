package com.parse.signpost.signature;

import com.parse.codec.binary.Base64;
import com.parse.signpost.exception.OAuthMessageSignerException;
import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public abstract class OAuthMessageSigner
  implements Serializable
{
  private static final long serialVersionUID = 4445779788786131202L;
  private transient Base64 base64 = new Base64();
  private String consumerSecret;
  private String tokenSecret;
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.base64 = new Base64();
  }
  
  protected String base64Encode(byte[] paramArrayOfByte)
  {
    return new String(this.base64.encode(paramArrayOfByte));
  }
  
  protected byte[] decodeBase64(String paramString)
  {
    return this.base64.decode(paramString.getBytes());
  }
  
  public String getConsumerSecret()
  {
    return this.consumerSecret;
  }
  
  public abstract String getSignatureMethod();
  
  public String getTokenSecret()
  {
    return this.tokenSecret;
  }
  
  public void setConsumerSecret(String paramString)
  {
    this.consumerSecret = paramString;
  }
  
  public void setTokenSecret(String paramString)
  {
    this.tokenSecret = paramString;
  }
  
  public abstract String sign(HttpRequest paramHttpRequest, HttpParameters paramHttpParameters)
    throws OAuthMessageSignerException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/signpost/signature/OAuthMessageSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */