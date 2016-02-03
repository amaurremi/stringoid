package com.badlogic.gdx.audio.io;

import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class Mpg123Decoder
{
  private static final String TAG = "BadLogicAudioDecoder";
  public final long _Handle;
  
  static
  {
    System.loadLibrary("Mpg123Decoder");
  }
  
  public Mpg123Decoder(String paramString)
  {
    initDecoder();
    this._Handle = openFile(paramString);
    if (this._Handle <= 0L) {
      cleanupDecoder();
    }
  }
  
  public static void cleanupDecoder() {}
  
  private native void closeFile(long paramLong);
  
  private native float getLength(long paramLong);
  
  private native int getNumChannels(long paramLong);
  
  private native int getRate(long paramLong);
  
  public static void initDecoder()
  {
    ninitLib();
  }
  
  private native int nTell(long paramLong);
  
  private static native void ncleanupLib();
  
  private static native boolean ninitLib();
  
  private native long openFile(String paramString);
  
  private native int readSamples(long paramLong, short[] paramArrayOfShort, int paramInt1, int paramInt2);
  
  private native int seekTo(long paramLong, int paramInt);
  
  private native int skipSamples(long paramLong, int paramInt);
  
  public void dispose()
  {
    if (this._Handle > 0L) {
      closeFile(this._Handle);
    }
  }
  
  public int getChannels()
  {
    if (this._Handle <= 0L) {
      return -1;
    }
    return getNumChannels(this._Handle);
  }
  
  public float getLength()
  {
    if (this._Handle <= 0L) {
      return -1.0F;
    }
    return getLength(this._Handle);
  }
  
  public long getPosition()
  {
    if (this._Handle > 0L) {
      return nTell(this._Handle) / getRate() * 1000L;
    }
    return -1L;
  }
  
  public int getRate()
  {
    if (this._Handle <= 0L) {
      return -1;
    }
    return getRate(this._Handle);
  }
  
  public boolean isReady()
  {
    return this._Handle > 0L;
  }
  
  public int readSamples(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (this._Handle <= 0L) {
      return -1;
    }
    return readSamples(this._Handle, paramArrayOfShort, paramInt1, paramInt2);
  }
  
  public void seekTo(long paramLong)
  {
    if (this._Handle > 0L)
    {
      CoreHelper.WriteTraceEntry("BadLogicAudioDecoder", "  Decoder is seeking to: " + paramLong + "...");
      int i = (int)(getRate() * paramLong / 1000L);
      seekTo(this._Handle, i);
      CoreHelper.WriteTraceEntry("BadLogicAudioDecoder", "  Decoder seek complete! Now at: " + getPosition());
    }
  }
  
  public int skipSamples(int paramInt)
  {
    if (this._Handle <= 0L) {
      return -1;
    }
    return skipSamples(this._Handle, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/badlogic/gdx/audio/io/Mpg123Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */