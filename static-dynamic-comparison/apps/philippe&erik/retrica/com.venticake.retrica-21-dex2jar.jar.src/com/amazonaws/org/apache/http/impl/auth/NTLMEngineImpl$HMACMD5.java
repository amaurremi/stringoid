package com.amazonaws.org.apache.http.impl.auth;

import java.security.MessageDigest;

class NTLMEngineImpl$HMACMD5
{
  protected byte[] ipad;
  protected MessageDigest md5;
  protected byte[] opad;
  
  NTLMEngineImpl$HMACMD5(byte[] paramArrayOfByte)
  {
    int i;
    try
    {
      this.md5 = MessageDigest.getInstance("MD5");
      this.ipad = new byte[64];
      this.opad = new byte[64];
      i = paramArrayOfByte.length;
      int j = i;
      byte[] arrayOfByte = paramArrayOfByte;
      if (i > 64)
      {
        this.md5.update(paramArrayOfByte);
        arrayOfByte = this.md5.digest();
        j = arrayOfByte.length;
      }
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          this.ipad[i] = ((byte)(arrayOfByte[i] ^ 0x36));
          this.opad[i] = ((byte)(arrayOfByte[i] ^ 0x5C));
          i += 1;
          continue;
          if (i >= 64) {
            break;
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      throw new NTLMEngineException("Error getting md5 message digest implementation: " + paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
    for (;;)
    {
      this.ipad[i] = 54;
      this.opad[i] = 92;
      i += 1;
      continue;
      this.md5.reset();
      this.md5.update(this.ipad);
      return;
    }
  }
  
  byte[] getOutput()
  {
    byte[] arrayOfByte = this.md5.digest();
    this.md5.update(this.opad);
    return this.md5.digest(arrayOfByte);
  }
  
  void update(byte[] paramArrayOfByte)
  {
    this.md5.update(paramArrayOfByte);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/auth/NTLMEngineImpl$HMACMD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */