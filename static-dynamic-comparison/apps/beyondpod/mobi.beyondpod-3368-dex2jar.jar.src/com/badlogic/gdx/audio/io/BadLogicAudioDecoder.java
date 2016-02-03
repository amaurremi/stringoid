package com.badlogic.gdx.audio.io;

import android.media.AudioTrack;
import java.io.IOException;

public class BadLogicAudioDecoder
{
  private static final String TAG = "BadLogicAudioDecoder";
  Mpg123Decoder _Decoder;
  int _LastRead;
  private short[] _PCMBuffer;
  
  public static void cleanupDecoder() {}
  
  public static void initDecoder() {}
  
  public int decodeMP3()
    throws IOException
  {
    this._LastRead = this._Decoder.readSamples(this._PCMBuffer, 0, this._PCMBuffer.length);
    return this._LastRead;
  }
  
  public int getChannelCount()
  {
    return this._Decoder.getChannels();
  }
  
  public long getCurrentPos()
  {
    return this._Decoder.getPosition();
  }
  
  public int getPCMData(byte[] paramArrayOfByte)
  {
    if (this._LastRead > 0)
    {
      receiveBytes(this._PCMBuffer, this._LastRead, paramArrayOfByte);
      return this._LastRead * 2;
    }
    return 0;
  }
  
  public int getSampleRate()
  {
    return this._Decoder.getRate();
  }
  
  public long getSampleTime()
  {
    return this._Decoder.getLength() * 1000L;
  }
  
  public void receiveBytes(short[] paramArrayOfShort, int paramInt, byte[] paramArrayOfByte)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return;
      }
      int j = paramArrayOfShort[i];
      paramArrayOfByte[(i << 1)] = ((byte)(j & 0xFF));
      paramArrayOfByte[((i << 1) + 1)] = ((byte)(j >> 8));
      i += 1;
    }
  }
  
  public void release()
  {
    if (this._Decoder != null)
    {
      this._Decoder.dispose();
      this._Decoder = null;
    }
    cleanupDecoder();
    this._PCMBuffer = null;
  }
  
  public void seekTo(long paramLong)
  {
    this._Decoder.seekTo(paramLong);
  }
  
  public boolean setDataSource(String paramString)
  {
    this._Decoder = new Mpg123Decoder(paramString);
    if (!this._Decoder.isReady()) {
      return false;
    }
    int j = getSampleRate();
    if (getChannelCount() == 2) {}
    for (int i = 12;; i = 4)
    {
      this._PCMBuffer = new short[AudioTrack.getMinBufferSize(j, i, 2)];
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/badlogic/gdx/audio/io/BadLogicAudioDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */