package com.flurry.android;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class CrcMessageDigest
  extends MessageDigest
{
  private CRC32 crc = new CRC32();
  
  public CrcMessageDigest()
  {
    super("CRC");
  }
  
  protected byte[] engineDigest()
  {
    long l = this.crc.getValue();
    return new byte[] { (byte)(int)((0xFFFFFFFFFF000000 & l) >> 24), (byte)(int)((0xFF0000 & l) >> 16), (byte)(int)((0xFF00 & l) >> 8), (byte)(int)(l & 0xFF) };
  }
  
  protected void engineReset()
  {
    this.crc.reset();
  }
  
  protected void engineUpdate(byte paramByte)
  {
    this.crc.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.crc.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int getChecksum()
  {
    return ByteBuffer.wrap(engineDigest()).getInt();
  }
  
  public byte[] getDigest()
  {
    return engineDigest();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/CrcMessageDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */