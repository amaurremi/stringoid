package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.auth.ChallengeState;
import com.amazonaws.org.apache.http.auth.ContextAwareAuthScheme;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.auth.MalformedChallengeException;
import com.amazonaws.org.apache.http.protocol.HTTP;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.Locale;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public abstract class AuthSchemeBase
  implements ContextAwareAuthScheme
{
  private ChallengeState challengeState;
  
  public AuthSchemeBase()
  {
    this(null);
  }
  
  public AuthSchemeBase(ChallengeState paramChallengeState)
  {
    this.challengeState = paramChallengeState;
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    return authenticate(paramCredentials, paramHttpRequest);
  }
  
  public boolean isProxy()
  {
    return (this.challengeState != null) && (this.challengeState == ChallengeState.PROXY);
  }
  
  protected abstract void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2);
  
  public void processChallenge(Header paramHeader)
  {
    if (paramHeader == null) {
      throw new IllegalArgumentException("Header may not be null");
    }
    Object localObject = paramHeader.getName();
    int i;
    if (((String)localObject).equalsIgnoreCase("WWW-Authenticate"))
    {
      this.challengeState = ChallengeState.TARGET;
      if (!(paramHeader instanceof FormattedHeader)) {
        break label144;
      }
      localObject = ((FormattedHeader)paramHeader).getBuffer();
      i = ((FormattedHeader)paramHeader).getValuePos();
      paramHeader = (Header)localObject;
    }
    for (;;)
    {
      if ((i >= paramHeader.length()) || (!HTTP.isWhitespace(paramHeader.charAt(i)))) {
        break label191;
      }
      i += 1;
      continue;
      if (((String)localObject).equalsIgnoreCase("Proxy-Authenticate"))
      {
        this.challengeState = ChallengeState.PROXY;
        break;
      }
      throw new MalformedChallengeException("Unexpected header name: " + (String)localObject);
      label144:
      localObject = paramHeader.getValue();
      if (localObject == null) {
        throw new MalformedChallengeException("Header value is null");
      }
      paramHeader = new CharArrayBuffer(((String)localObject).length());
      paramHeader.append((String)localObject);
      i = 0;
    }
    label191:
    int j = i;
    while ((j < paramHeader.length()) && (!HTTP.isWhitespace(paramHeader.charAt(j)))) {
      j += 1;
    }
    localObject = paramHeader.substring(i, j);
    if (!((String)localObject).equalsIgnoreCase(getSchemeName())) {
      throw new MalformedChallengeException("Invalid scheme identifier: " + (String)localObject);
    }
    parseChallenge(paramHeader, j, paramHeader.length());
  }
  
  public String toString()
  {
    String str = getSchemeName();
    if (str != null) {
      return str.toUpperCase(Locale.US);
    }
    return super.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/AuthSchemeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */