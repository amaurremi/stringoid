package org.vinuxproject.sonic;

public class Sonic
{
  long sonicID = 0L;
  
  static
  {
    System.loadLibrary("sonic");
  }
  
  public Sonic(int paramInt1, int paramInt2)
  {
    close();
    this.sonicID = initNative(paramInt1, paramInt2);
  }
  
  private native int availableBytesNative(long paramLong);
  
  private native void closeNative(long paramLong);
  
  private native void flushNative(long paramLong);
  
  private native boolean getChordPitchNative(long paramLong);
  
  private native int getNumChannelsNative(long paramLong);
  
  private native float getPitchNative(long paramLong);
  
  private native float getRateNative(long paramLong);
  
  private native int getSampleRateNative(long paramLong);
  
  private native float getSpeedNative(long paramLong);
  
  private native float getVolumeNative(long paramLong);
  
  private native long initNative(int paramInt1, int paramInt2);
  
  private native boolean putBytesNative(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native int receiveBytesNative(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void setChordPitchNative(long paramLong, boolean paramBoolean);
  
  private native void setNumChannelsNative(long paramLong, int paramInt);
  
  private native void setPitchNative(long paramLong, float paramFloat);
  
  private native void setRateNative(long paramLong, float paramFloat);
  
  private native void setSampleRateNative(long paramLong, int paramInt);
  
  private native void setSpeedNative(long paramLong, float paramFloat);
  
  private native void setVolumeNative(long paramLong, float paramFloat);
  
  public int availableBytes()
  {
    return availableBytesNative(this.sonicID);
  }
  
  public void close()
  {
    if (this.sonicID != 0L)
    {
      closeNative(this.sonicID);
      this.sonicID = 0L;
    }
  }
  
  protected void finalize()
  {
    close();
  }
  
  public void flush()
  {
    flushNative(this.sonicID);
  }
  
  public boolean getChordPitch()
  {
    return getChordPitchNative(this.sonicID);
  }
  
  public int getNumChannels()
  {
    return getNumChannelsNative(this.sonicID);
  }
  
  public float getPitch()
  {
    return getPitchNative(this.sonicID);
  }
  
  public float getRate()
  {
    return getRateNative(this.sonicID);
  }
  
  public int getSampleRate()
  {
    return getSampleRateNative(this.sonicID);
  }
  
  public float getSpeed()
  {
    return getSpeedNative(this.sonicID);
  }
  
  public float getVolume()
  {
    return getVolumeNative(this.sonicID);
  }
  
  public boolean putBytes(byte[] paramArrayOfByte, int paramInt)
  {
    return putBytesNative(this.sonicID, paramArrayOfByte, paramInt);
  }
  
  public int receiveBytes(byte[] paramArrayOfByte, int paramInt)
  {
    return receiveBytesNative(this.sonicID, paramArrayOfByte, paramInt);
  }
  
  public void setChordPitch(boolean paramBoolean)
  {
    setChordPitchNative(this.sonicID, paramBoolean);
  }
  
  public void setNumChannels(int paramInt)
  {
    setNumChannelsNative(this.sonicID, paramInt);
  }
  
  public void setPitch(float paramFloat)
  {
    setPitchNative(this.sonicID, paramFloat);
  }
  
  public void setRate(float paramFloat)
  {
    setRateNative(this.sonicID, paramFloat);
  }
  
  public void setSampleRate(int paramInt)
  {
    setSampleRateNative(this.sonicID, paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    setSpeedNative(this.sonicID, paramFloat);
  }
  
  public void setVolume(float paramFloat)
  {
    setVolumeNative(this.sonicID, paramFloat);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/vinuxproject/sonic/Sonic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */