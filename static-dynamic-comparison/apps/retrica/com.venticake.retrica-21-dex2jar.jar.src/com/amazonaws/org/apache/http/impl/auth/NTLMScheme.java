package com.amazonaws.org.apache.http.impl.auth;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.auth.AuthenticationException;
import com.amazonaws.org.apache.http.auth.Credentials;
import com.amazonaws.org.apache.http.auth.InvalidCredentialsException;
import com.amazonaws.org.apache.http.auth.NTCredentials;
import com.amazonaws.org.apache.http.message.BufferedHeader;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class NTLMScheme
  extends AuthSchemeBase
{
  private String challenge;
  private final NTLMEngine engine;
  private NTLMScheme.State state;
  
  public NTLMScheme(NTLMEngine paramNTLMEngine)
  {
    if (paramNTLMEngine == null) {
      throw new IllegalArgumentException("NTLM engine may not be null");
    }
    this.engine = paramNTLMEngine;
    this.state = NTLMScheme.State.UNINITIATED;
    this.challenge = null;
  }
  
  public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest)
  {
    for (;;)
    {
      try
      {
        paramHttpRequest = (NTCredentials)paramCredentials;
        if ((this.state == NTLMScheme.State.CHALLENGE_RECEIVED) || (this.state == NTLMScheme.State.FAILED))
        {
          paramCredentials = this.engine.generateType1Msg(paramHttpRequest.getDomain(), paramHttpRequest.getWorkstation());
          this.state = NTLMScheme.State.MSG_TYPE1_GENERATED;
          paramHttpRequest = new CharArrayBuffer(32);
          if (!isProxy()) {
            break label207;
          }
          paramHttpRequest.append("Proxy-Authorization");
          paramHttpRequest.append(": NTLM ");
          paramHttpRequest.append(paramCredentials);
          return new BufferedHeader(paramHttpRequest);
        }
      }
      catch (ClassCastException paramHttpRequest)
      {
        throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + paramCredentials.getClass().getName());
      }
      if (this.state == NTLMScheme.State.MSG_TYPE2_RECEVIED)
      {
        paramCredentials = this.engine.generateType3Msg(paramHttpRequest.getUserName(), paramHttpRequest.getPassword(), paramHttpRequest.getDomain(), paramHttpRequest.getWorkstation(), this.challenge);
        this.state = NTLMScheme.State.MSG_TYPE3_GENERATED;
      }
      else
      {
        throw new AuthenticationException("Unexpected state: " + this.state);
        label207:
        paramHttpRequest.append("Authorization");
      }
    }
  }
  
  public String getRealm()
  {
    return null;
  }
  
  public String getSchemeName()
  {
    return "ntlm";
  }
  
  public boolean isComplete()
  {
    return (this.state == NTLMScheme.State.MSG_TYPE3_GENERATED) || (this.state == NTLMScheme.State.FAILED);
  }
  
  public boolean isConnectionBased()
  {
    return true;
  }
  
  protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2)
  {
    paramCharArrayBuffer = paramCharArrayBuffer.substringTrimmed(paramInt1, paramInt2);
    if (paramCharArrayBuffer.length() == 0)
    {
      if (this.state == NTLMScheme.State.UNINITIATED) {}
      for (this.state = NTLMScheme.State.CHALLENGE_RECEIVED;; this.state = NTLMScheme.State.FAILED)
      {
        this.challenge = null;
        return;
      }
    }
    this.state = NTLMScheme.State.MSG_TYPE2_RECEVIED;
    this.challenge = paramCharArrayBuffer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */