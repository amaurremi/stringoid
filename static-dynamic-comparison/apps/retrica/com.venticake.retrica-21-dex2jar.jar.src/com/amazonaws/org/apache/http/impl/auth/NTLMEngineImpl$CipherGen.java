package com.amazonaws.org.apache.http.impl.auth;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;

public class NTLMEngineImpl$CipherGen
{
  protected final byte[] challenge;
  protected byte[] clientChallenge;
  protected byte[] lanManagerSessionKey = null;
  protected byte[] lm2SessionResponse = null;
  protected byte[] lmHash = null;
  protected byte[] lmResponse = null;
  protected byte[] lmUserSessionKey = null;
  protected byte[] lmv2Response = null;
  protected byte[] ntlm2SessionResponse = null;
  protected byte[] ntlm2SessionResponseUserSessionKey = null;
  protected byte[] ntlmHash = null;
  protected byte[] ntlmResponse = null;
  protected byte[] ntlmUserSessionKey = null;
  protected byte[] ntlmv2Blob = null;
  protected byte[] ntlmv2Hash = null;
  protected byte[] ntlmv2Response = null;
  protected byte[] ntlmv2UserSessionKey = null;
  protected final String password;
  protected byte[] secondaryKey;
  protected final String target;
  protected final byte[] targetInformation;
  protected byte[] timestamp;
  protected final String user;
  
  public NTLMEngineImpl$CipherGen(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramString1, paramString2, paramString3, paramArrayOfByte1, paramArrayOfByte2, null, null, null);
  }
  
  public NTLMEngineImpl$CipherGen(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    this.target = paramString1;
    this.user = paramString2;
    this.password = paramString3;
    this.challenge = paramArrayOfByte1;
    this.targetInformation = paramArrayOfByte2;
    this.clientChallenge = paramArrayOfByte3;
    this.secondaryKey = paramArrayOfByte4;
    this.timestamp = paramArrayOfByte5;
  }
  
  public byte[] getClientChallenge()
  {
    if (this.clientChallenge == null) {
      this.clientChallenge = NTLMEngineImpl.access$000();
    }
    return this.clientChallenge;
  }
  
  public byte[] getLM2SessionResponse()
  {
    if (this.lm2SessionResponse == null)
    {
      byte[] arrayOfByte = getClientChallenge();
      this.lm2SessionResponse = new byte[24];
      System.arraycopy(arrayOfByte, 0, this.lm2SessionResponse, 0, arrayOfByte.length);
      Arrays.fill(this.lm2SessionResponse, arrayOfByte.length, this.lm2SessionResponse.length, (byte)0);
    }
    return this.lm2SessionResponse;
  }
  
  public byte[] getLMHash()
  {
    if (this.lmHash == null) {
      this.lmHash = NTLMEngineImpl.access$200(this.password);
    }
    return this.lmHash;
  }
  
  public byte[] getLMResponse()
  {
    if (this.lmResponse == null) {
      this.lmResponse = NTLMEngineImpl.access$300(getLMHash(), this.challenge);
    }
    return this.lmResponse;
  }
  
  public byte[] getLMUserSessionKey()
  {
    if (this.lmUserSessionKey == null)
    {
      byte[] arrayOfByte = getLMHash();
      this.lmUserSessionKey = new byte[16];
      System.arraycopy(arrayOfByte, 0, this.lmUserSessionKey, 0, 8);
      Arrays.fill(this.lmUserSessionKey, 8, 16, (byte)0);
    }
    return this.lmUserSessionKey;
  }
  
  public byte[] getLMv2Response()
  {
    if (this.lmv2Response == null) {
      this.lmv2Response = NTLMEngineImpl.access$700(getNTLMv2Hash(), this.challenge, getClientChallenge());
    }
    return this.lmv2Response;
  }
  
  public byte[] getLanManagerSessionKey()
  {
    byte[] arrayOfByte;
    Object localObject2;
    if (this.lanManagerSessionKey == null)
    {
      arrayOfByte = getLMHash();
      localObject2 = getLMResponse();
    }
    try
    {
      Object localObject1 = new byte[14];
      System.arraycopy(arrayOfByte, 0, localObject1, 0, 8);
      Arrays.fill((byte[])localObject1, 8, localObject1.length, (byte)-67);
      Object localObject3 = NTLMEngineImpl.access$800((byte[])localObject1, 0);
      localObject1 = NTLMEngineImpl.access$800((byte[])localObject1, 7);
      arrayOfByte = new byte[8];
      System.arraycopy(localObject2, 0, arrayOfByte, 0, arrayOfByte.length);
      localObject2 = Cipher.getInstance("DES/ECB/NoPadding");
      ((Cipher)localObject2).init(1, (Key)localObject3);
      localObject2 = ((Cipher)localObject2).doFinal(arrayOfByte);
      localObject3 = Cipher.getInstance("DES/ECB/NoPadding");
      ((Cipher)localObject3).init(1, (Key)localObject1);
      localObject1 = ((Cipher)localObject3).doFinal(arrayOfByte);
      this.lanManagerSessionKey = new byte[16];
      System.arraycopy(localObject2, 0, this.lanManagerSessionKey, 0, localObject2.length);
      System.arraycopy(localObject1, 0, this.lanManagerSessionKey, localObject2.length, localObject1.length);
      return this.lanManagerSessionKey;
    }
    catch (Exception localException)
    {
      throw new NTLMEngineException(localException.getMessage(), localException);
    }
  }
  
  public byte[] getNTLM2SessionResponse()
  {
    if (this.ntlm2SessionResponse == null) {
      this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
    }
    return this.ntlm2SessionResponse;
  }
  
  public byte[] getNTLM2SessionResponseUserSessionKey()
  {
    if (this.ntlm2SessionResponseUserSessionKey == null)
    {
      byte[] arrayOfByte1 = getNTLMUserSessionKey();
      byte[] arrayOfByte2 = getLM2SessionResponse();
      byte[] arrayOfByte3 = new byte[this.challenge.length + arrayOfByte2.length];
      System.arraycopy(this.challenge, 0, arrayOfByte3, 0, this.challenge.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte3, this.challenge.length, arrayOfByte2.length);
      this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(arrayOfByte3, arrayOfByte1);
    }
    return this.ntlm2SessionResponseUserSessionKey;
  }
  
  public byte[] getNTLMHash()
  {
    if (this.ntlmHash == null) {
      this.ntlmHash = NTLMEngineImpl.access$400(this.password);
    }
    return this.ntlmHash;
  }
  
  public byte[] getNTLMResponse()
  {
    if (this.ntlmResponse == null) {
      this.ntlmResponse = NTLMEngineImpl.access$300(getNTLMHash(), this.challenge);
    }
    return this.ntlmResponse;
  }
  
  public byte[] getNTLMUserSessionKey()
  {
    if (this.ntlmUserSessionKey == null)
    {
      byte[] arrayOfByte = getNTLMHash();
      NTLMEngineImpl.MD4 localMD4 = new NTLMEngineImpl.MD4();
      localMD4.update(arrayOfByte);
      this.ntlmUserSessionKey = localMD4.getOutput();
    }
    return this.ntlmUserSessionKey;
  }
  
  public byte[] getNTLMv2Blob()
  {
    if (this.ntlmv2Blob == null) {
      this.ntlmv2Blob = NTLMEngineImpl.access$600(getClientChallenge(), this.targetInformation, getTimestamp());
    }
    return this.ntlmv2Blob;
  }
  
  public byte[] getNTLMv2Hash()
  {
    if (this.ntlmv2Hash == null) {
      this.ntlmv2Hash = NTLMEngineImpl.access$500(this.target, this.user, this.password);
    }
    return this.ntlmv2Hash;
  }
  
  public byte[] getNTLMv2Response()
  {
    if (this.ntlmv2Response == null) {
      this.ntlmv2Response = NTLMEngineImpl.access$700(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
    }
    return this.ntlmv2Response;
  }
  
  public byte[] getNTLMv2UserSessionKey()
  {
    if (this.ntlmv2UserSessionKey == null)
    {
      byte[] arrayOfByte1 = getNTLMv2Hash();
      byte[] arrayOfByte2 = getNTLMv2Blob();
      byte[] arrayOfByte3 = new byte[arrayOfByte2.length + this.challenge.length];
      System.arraycopy(this.challenge, 0, arrayOfByte3, 0, this.challenge.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte3, this.challenge.length, arrayOfByte2.length);
      this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(NTLMEngineImpl.hmacMD5(arrayOfByte3, arrayOfByte1), arrayOfByte1);
    }
    return this.ntlmv2UserSessionKey;
  }
  
  public byte[] getSecondaryKey()
  {
    if (this.secondaryKey == null) {
      this.secondaryKey = NTLMEngineImpl.access$100();
    }
    return this.secondaryKey;
  }
  
  public byte[] getTimestamp()
  {
    if (this.timestamp == null)
    {
      long l = (System.currentTimeMillis() + 11644473600000L) * 10000L;
      this.timestamp = new byte[8];
      int i = 0;
      while (i < 8)
      {
        this.timestamp[i] = ((byte)(int)l);
        l >>>= 8;
        i += 1;
      }
    }
    return this.timestamp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl$CipherGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */