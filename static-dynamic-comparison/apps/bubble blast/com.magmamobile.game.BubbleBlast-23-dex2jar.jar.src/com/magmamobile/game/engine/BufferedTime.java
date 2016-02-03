package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.os.SystemClock;

public class BufferedTime
{
  private static final int CMAX = 16;
  private char[] buffer = new char[16];
  private int laststamp;
  private int minutes;
  private Paint paint;
  private String prefix;
  private int seconds;
  private int stamp;
  private long start;
  private String suffix;
  private long time;
  private String tostring;
  private float width;
  
  public void capture()
  {
    this.time = (SystemClock.elapsedRealtime() - this.start);
    this.stamp = ((int)(this.time / 1000L));
    int i;
    int j;
    if ((this.laststamp != this.stamp) || (this.tostring == null))
    {
      this.seconds = (this.stamp % 60);
      this.minutes = (this.stamp / 60 % 60);
      this.laststamp = this.stamp;
      if (this.seconds <= 9) {
        break label289;
      }
      this.buffer[15] = ((char)(this.seconds % 10 + 48));
      this.buffer[14] = ((char)(this.seconds / 10 % 10 + 48));
      i = 1 + 1 + 1;
      this.buffer[13] = ':';
      i += 1;
      if (this.minutes != 0) {
        break label322;
      }
      this.buffer[12] = '0';
      this.buffer[11] = '0';
      j = i + 1 + 1;
      label174:
      this.tostring = String.copyValueOf(this.buffer, 16 - j + 1, j - 1);
      if (this.prefix != null) {
        this.tostring = (this.prefix + this.tostring);
      }
      if (this.suffix != null) {
        this.tostring += this.suffix;
      }
      if (this.paint == null) {
        break label409;
      }
    }
    label289:
    label322:
    label409:
    for (float f = this.paint.measureText(this.tostring);; f = 0.0F)
    {
      this.width = f;
      return;
      this.buffer[15] = ((char)(this.seconds + 48));
      this.buffer[14] = '0';
      i = 1 + 1 + 1;
      break;
      if (this.minutes < 10)
      {
        this.buffer[12] = ((char)(this.minutes + 48));
        this.buffer[11] = '0';
        j = i + 1 + 1;
        break label174;
      }
      int k = this.minutes;
      for (;;)
      {
        j = i;
        if (k <= 0) {
          break;
        }
        this.buffer[(16 - i)] = ((char)(k % 10 + 48));
        i += 1;
        k /= 10;
      }
    }
  }
  
  public void fromNow()
  {
    this.start = SystemClock.elapsedRealtime();
    capture();
  }
  
  public long getMinutes()
  {
    return this.minutes;
  }
  
  public Paint getPaint()
  {
    return this.paint;
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public long getSeconds()
  {
    return this.seconds;
  }
  
  public String getSuffix()
  {
    return this.suffix;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public void setPaint(Paint paramPaint)
  {
    this.paint = paramPaint;
  }
  
  public void setPrefix(String paramString)
  {
    this.prefix = paramString;
    this.tostring = null;
  }
  
  public void setSuffix(String paramString)
  {
    this.suffix = paramString;
    this.tostring = null;
  }
  
  public String toString()
  {
    return this.tostring;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/BufferedTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */