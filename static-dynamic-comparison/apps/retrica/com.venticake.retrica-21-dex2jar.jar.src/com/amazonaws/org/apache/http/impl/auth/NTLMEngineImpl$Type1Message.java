package com.amazonaws.org.apache.http.impl.auth;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

class NTLMEngineImpl$Type1Message
  extends NTLMEngineImpl.NTLMMessage
{
  protected byte[] domainBytes;
  protected byte[] hostBytes;
  
  NTLMEngineImpl$Type1Message(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = NTLMEngineImpl.access$1300(paramString2);
      paramString1 = NTLMEngineImpl.access$1400(paramString1);
      this.hostBytes = paramString2.getBytes("UnicodeLittleUnmarked");
      this.domainBytes = paramString1.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked");
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new NTLMEngineException("Unicode unsupported: " + paramString1.getMessage(), paramString1);
    }
  }
  
  String getResponse()
  {
    prepareResponse(40, 1);
    addULong(-502758767);
    addUShort(0);
    addUShort(0);
    addULong(40);
    addUShort(0);
    addUShort(0);
    addULong(40);
    addUShort(261);
    addULong(2600);
    addUShort(3840);
    return super.getResponse();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl$Type1Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */