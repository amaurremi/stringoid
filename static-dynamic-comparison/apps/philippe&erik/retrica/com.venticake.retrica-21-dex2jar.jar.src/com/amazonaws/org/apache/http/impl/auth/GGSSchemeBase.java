package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.auth.AuthenticationException;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.auth.InvalidCredentialsException;
import com.amazonaws.org.apache.http.message.BufferedHeader;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.commons.a.a.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;

public abstract class GGSSchemeBase
  extends AuthSchemeBase
{
  private final a base64codec = new a();
  private final Log log = LogFactory.getLog(getClass());
  private GGSSchemeBase.State state = GGSSchemeBase.State.UNINITIATED;
  private final boolean stripPort;
  private byte[] token;
  
  GGSSchemeBase(boolean paramBoolean)
  {
    this.stripPort = paramBoolean;
  }
  
  @Deprecated
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest)
  {
    return authenticate(paramCredentials, paramHttpRequest, null);
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    switch (1.$SwitchMap$org$apache$http$impl$auth$GGSSchemeBase$State[this.state.ordinal()])
    {
    default: 
      throw new IllegalStateException("Illegal state: " + this.state);
    case 1: 
      throw new AuthenticationException(getSchemeName() + " authentication has not been initiated");
    case 2: 
      throw new AuthenticationException(getSchemeName() + " authentication has failed");
    case 3: 
      for (;;)
      {
        try
        {
          if (!isProxy()) {
            break label220;
          }
          paramCredentials = "http.proxy_host";
          paramCredentials = (HttpHost)paramHttpContext.getAttribute(paramCredentials);
          if (paramCredentials != null) {
            break;
          }
          throw new AuthenticationException("Authentication host is not set in the execution context");
        }
        catch (GSSException paramCredentials)
        {
          this.state = GGSSchemeBase.State.FAILED;
          if (paramCredentials.getMajor() == 9) {
            break label207;
          }
        }
        if (paramCredentials.getMajor() != 8) {
          break label420;
        }
        throw new InvalidCredentialsException(paramCredentials.getMessage(), paramCredentials);
        paramCredentials = "http.target_host";
      }
      if ((!this.stripPort) && (paramCredentials.getPort() > 0))
      {
        paramCredentials = paramCredentials.toHostString();
        if (this.log.isDebugEnabled()) {
          this.log.debug("init " + paramCredentials);
        }
        this.token = generateToken(this.token, paramCredentials);
        this.state = GGSSchemeBase.State.TOKEN_GENERATED;
      }
      break;
    case 4: 
      label207:
      label220:
      paramCredentials = new String(this.base64codec.e(this.token));
      if (this.log.isDebugEnabled()) {
        this.log.debug("Sending response '" + paramCredentials + "' back to the auth server");
      }
      paramHttpRequest = new CharArrayBuffer(32);
      if (isProxy()) {
        paramHttpRequest.append("Proxy-Authorization");
      }
      break;
    }
    for (;;)
    {
      paramHttpRequest.append(": Negotiate ");
      paramHttpRequest.append(paramCredentials);
      return new BufferedHeader(paramHttpRequest);
      paramCredentials = paramCredentials.getHostName();
      break;
      label420:
      if (paramCredentials.getMajor() == 13) {
        throw new InvalidCredentialsException(paramCredentials.getMessage(), paramCredentials);
      }
      if ((paramCredentials.getMajor() == 10) || (paramCredentials.getMajor() == 19) || (paramCredentials.getMajor() == 20)) {
        throw new AuthenticationException(paramCredentials.getMessage(), paramCredentials);
      }
      throw new AuthenticationException(paramCredentials.getMessage());
      paramHttpRequest.append("Authorization");
    }
  }
  
  protected byte[] generateGSSToken(byte[] paramArrayOfByte, Oid paramOid, String paramString)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = getManager();
    paramArrayOfByte = paramArrayOfByte.createContext(paramArrayOfByte.createName("HTTP@" + paramString, GSSName.NT_HOSTBASED_SERVICE).canonicalize(paramOid), paramOid, null, 0);
    paramArrayOfByte.requestMutualAuth(true);
    paramArrayOfByte.requestCredDeleg(true);
    return paramArrayOfByte.initSecContext(arrayOfByte, 0, arrayOfByte.length);
  }
  
  protected abstract byte[] generateToken(byte[] paramArrayOfByte, String paramString);
  
  protected GSSManager getManager()
  {
    return GSSManager.getInstance();
  }
  
  public boolean isComplete()
  {
    return (this.state == GGSSchemeBase.State.TOKEN_GENERATED) || (this.state == GGSSchemeBase.State.FAILED);
  }
  
  protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2)
  {
    paramCharArrayBuffer = paramCharArrayBuffer.substringTrimmed(paramInt1, paramInt2);
    if (this.log.isDebugEnabled()) {
      this.log.debug("Received challenge '" + paramCharArrayBuffer + "' from the auth server");
    }
    if (this.state == GGSSchemeBase.State.UNINITIATED)
    {
      this.token = this.base64codec.b(paramCharArrayBuffer.getBytes());
      this.state = GGSSchemeBase.State.CHALLENGE_RECEIVED;
      return;
    }
    this.log.debug("Authentication already attempted");
    this.state = GGSSchemeBase.State.FAILED;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/GGSSchemeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */