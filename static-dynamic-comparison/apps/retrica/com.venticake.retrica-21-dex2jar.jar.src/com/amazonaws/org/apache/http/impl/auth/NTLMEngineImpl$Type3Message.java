package com.amazonaws.org.apache.http.impl.auth;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

class NTLMEngineImpl$Type3Message
  extends NTLMEngineImpl.NTLMMessage
{
  protected byte[] domainBytes;
  protected byte[] hostBytes;
  protected byte[] lmResp;
  protected byte[] ntResp;
  protected byte[] sessionKey;
  protected int type2Flags;
  protected byte[] userBytes;
  
  NTLMEngineImpl$Type3Message(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte1, int paramInt, String paramString5, byte[] paramArrayOfByte2)
  {
    this.type2Flags = paramInt;
    paramString2 = NTLMEngineImpl.access$1300(paramString2);
    String str = NTLMEngineImpl.access$1400(paramString1);
    paramString4 = new NTLMEngineImpl.CipherGen(paramString5, paramString3, paramString4, paramArrayOfByte1, paramArrayOfByte2);
    if (((0x800000 & paramInt) != 0) && (paramArrayOfByte2 != null) && (paramString5 != null)) {}
    for (;;)
    {
      try
      {
        this.ntResp = paramString4.getNTLMv2Response();
        this.lmResp = paramString4.getLMv2Response();
        if ((paramInt & 0x80) == 0) {
          continue;
        }
        paramString1 = paramString4.getLanManagerSessionKey();
      }
      catch (NTLMEngineException paramString1)
      {
        this.ntResp = new byte[0];
        this.lmResp = paramString4.getLMResponse();
        if ((paramInt & 0x80) == 0) {
          continue;
        }
        paramString1 = paramString4.getLanManagerSessionKey();
        continue;
        paramString1 = paramString4.getLMUserSessionKey();
        continue;
        this.sessionKey = null;
        continue;
      }
      if ((0x40000000 & paramInt) == 0) {
        continue;
      }
      this.sessionKey = NTLMEngineImpl.RC4(paramString4.getSecondaryKey(), paramString1);
      try
      {
        this.domainBytes = str.toUpperCase(Locale.US).getBytes("UnicodeLittleUnmarked");
        this.hostBytes = paramString2.getBytes("UnicodeLittleUnmarked");
        this.userBytes = paramString3.getBytes("UnicodeLittleUnmarked");
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        throw new NTLMEngineException("Unicode not supported: " + paramString1.getMessage(), paramString1);
      }
      paramString1 = paramString4.getNTLMv2UserSessionKey();
      continue;
      if ((0x80000 & paramInt) != 0)
      {
        this.ntResp = paramString4.getNTLM2SessionResponse();
        this.lmResp = paramString4.getLM2SessionResponse();
        if ((paramInt & 0x80) != 0) {
          paramString1 = paramString4.getLanManagerSessionKey();
        } else {
          paramString1 = paramString4.getNTLM2SessionResponseUserSessionKey();
        }
      }
      else
      {
        this.ntResp = paramString4.getNTLMResponse();
        this.lmResp = paramString4.getLMResponse();
        if ((paramInt & 0x80) != 0) {
          paramString1 = paramString4.getLanManagerSessionKey();
        } else {
          paramString1 = paramString4.getNTLMUserSessionKey();
        }
      }
    }
  }
  
  String getResponse()
  {
    int j = this.ntResp.length;
    int k = this.lmResp.length;
    int m = this.domainBytes.length;
    int n = this.hostBytes.length;
    int i1 = this.userBytes.length;
    if (this.sessionKey != null) {}
    for (int i = this.sessionKey.length;; i = 0)
    {
      int i2 = 72 + k;
      int i3 = i2 + j;
      int i4 = i3 + m;
      int i5 = i4 + i1;
      int i6 = i5 + n;
      prepareResponse(i6 + i, 3);
      addUShort(k);
      addUShort(k);
      addULong(72);
      addUShort(j);
      addUShort(j);
      addULong(i2);
      addUShort(m);
      addUShort(m);
      addULong(i3);
      addUShort(i1);
      addUShort(i1);
      addULong(i4);
      addUShort(n);
      addUShort(n);
      addULong(i5);
      addUShort(i);
      addUShort(i);
      addULong(i6);
      addULong(this.type2Flags & 0x80 | 0x3000 | this.type2Flags & 0x200 | this.type2Flags & 0x80000 | 0x2000000 | this.type2Flags & 0x8000 | this.type2Flags & 0x20 | this.type2Flags & 0x10 | this.type2Flags & 0x20000000 | this.type2Flags & 0x80000000 | this.type2Flags & 0x40000000 | this.type2Flags & 0x800000 | this.type2Flags & 0x1 | this.type2Flags & 0x4);
      addUShort(261);
      addULong(2600);
      addUShort(3840);
      addBytes(this.lmResp);
      addBytes(this.ntResp);
      addBytes(this.domainBytes);
      addBytes(this.userBytes);
      addBytes(this.hostBytes);
      if (this.sessionKey != null) {
        addBytes(this.sessionKey);
      }
      return super.getResponse();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl$Type3Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */