package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.auth.ChallengeState;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.auth.params.AuthParams;
import com.amazonaws.org.apache.http.message.BufferedHeader;
import com.amazonaws.org.apache.http.protocol.BasicHttpContext;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import com.amazonaws.org.apache.http.util.EncodingUtils;
import java.security.Principal;
import org.apache.commons.a.a.a;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicScheme
  extends RFC2617Scheme
{
  private boolean complete = false;
  
  public BasicScheme()
  {
    this(null);
  }
  
  public BasicScheme(ChallengeState paramChallengeState)
  {
    super(paramChallengeState);
  }
  
  public static Header authenticate(Credentials paramCredentials, String paramString, boolean paramBoolean)
  {
    if (paramCredentials == null) {
      throw new IllegalArgumentException("Credentials may not be null");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("charset may not be null");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCredentials.getUserPrincipal().getName());
    localStringBuilder.append(":");
    if (paramCredentials.getPassword() == null)
    {
      paramCredentials = "null";
      localStringBuilder.append(paramCredentials);
      paramCredentials = a.a(EncodingUtils.getBytes(localStringBuilder.toString(), paramString));
      paramString = new CharArrayBuffer(32);
      if (!paramBoolean) {
        break label142;
      }
      paramString.append("Proxy-Authorization");
    }
    for (;;)
    {
      paramString.append(": Basic ");
      paramString.append(paramCredentials, 0, paramCredentials.length);
      return new BufferedHeader(paramString);
      paramCredentials = paramCredentials.getPassword();
      break;
      label142:
      paramString.append("Authorization");
    }
  }
  
  @Deprecated
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest)
  {
    return authenticate(paramCredentials, paramHttpRequest, new BasicHttpContext());
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramCredentials == null) {
      throw new IllegalArgumentException("Credentials may not be null");
    }
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    return authenticate(paramCredentials, AuthParams.getCredentialCharset(paramHttpRequest.getParams()), isProxy());
  }
  
  public String getSchemeName()
  {
    return "basic";
  }
  
  public boolean isComplete()
  {
    return this.complete;
  }
  
  public boolean isConnectionBased()
  {
    return false;
  }
  
  public void processChallenge(Header paramHeader)
  {
    super.processChallenge(paramHeader);
    this.complete = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/BasicScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */