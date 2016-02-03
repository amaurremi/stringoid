package com.amazonaws.org.apache.http.impl.auth;

import java.io.UnsupportedEncodingException;

class NTLMEngineImpl$Type2Message
  extends NTLMEngineImpl.NTLMMessage
{
  protected byte[] challenge = new byte[8];
  protected int flags;
  protected String target;
  protected byte[] targetInfo;
  
  NTLMEngineImpl$Type2Message(String paramString)
  {
    super(paramString, 2);
    readBytes(this.challenge, 24);
    this.flags = readULong(20);
    if ((this.flags & 0x1) == 0) {
      throw new NTLMEngineException("NTLM type 2 message has flags that make no sense: " + Integer.toString(this.flags));
    }
    this.target = null;
    if (getMessageLength() >= 20)
    {
      paramString = readSecurityBuffer(12);
      if (paramString.length == 0) {}
    }
    try
    {
      this.target = new String(paramString, "UnicodeLittleUnmarked");
      this.targetInfo = null;
      if (getMessageLength() >= 48)
      {
        paramString = readSecurityBuffer(40);
        if (paramString.length != 0) {
          this.targetInfo = paramString;
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new NTLMEngineException(paramString.getMessage(), paramString);
    }
  }
  
  byte[] getChallenge()
  {
    return this.challenge;
  }
  
  int getFlags()
  {
    return this.flags;
  }
  
  String getTarget()
  {
    return this.target;
  }
  
  byte[] getTargetInfo()
  {
    return this.targetInfo;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl$Type2Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */