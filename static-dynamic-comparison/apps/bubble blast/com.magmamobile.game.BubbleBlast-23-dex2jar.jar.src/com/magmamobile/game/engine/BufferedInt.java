package com.magmamobile.game.engine;

import android.graphics.Paint;

public class BufferedInt
{
  public static final int FORMAT_STANDARD = 0;
  public static final int FORMAT_TIME_MM_SS = 1;
  public static final int FORMAT_TIME_M_SS = 2;
  private int format;
  private int last;
  private Paint paint;
  private String prefix;
  private String string;
  private String suffix;
  private int value;
  private float width;
  
  public BufferedInt()
  {
    this.format = 0;
  }
  
  public BufferedInt(String paramString)
  {
    this(paramString, 0);
  }
  
  public BufferedInt(String paramString, int paramInt)
  {
    this(paramString, null, paramInt);
  }
  
  public BufferedInt(String paramString1, String paramString2, int paramInt)
  {
    this.prefix = paramString1;
    this.suffix = paramString2;
    this.format = paramInt;
  }
  
  public void add(int paramInt)
  {
    this.value += paramInt;
  }
  
  public void dec()
  {
    this.value -= 1;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public Paint getPaint()
  {
    return this.paint;
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public String getSuffix()
  {
    return this.suffix;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public float getWidth()
  {
    return this.width;
  }
  
  public void inc()
  {
    this.value += 1;
  }
  
  public void setFormat(int paramInt)
  {
    this.format = paramInt;
  }
  
  public void setPaint(Paint paramPaint)
  {
    this.paint = paramPaint;
  }
  
  public void setPrefix(String paramString)
  {
    this.prefix = paramString;
  }
  
  public void setSuffix(String paramString)
  {
    this.suffix = paramString;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    if ((this.value != this.last) || (this.string == null))
    {
      this.last = this.value;
      if (this.format != 0) {
        break label210;
      }
      if ((this.prefix == null) || (this.suffix == null)) {
        break label114;
      }
      this.string = (this.prefix + String.valueOf(this.value) + this.suffix);
      if (this.paint == null) {
        break label646;
      }
    }
    label114:
    label210:
    label259:
    label408:
    label478:
    label625:
    label646:
    for (float f = this.paint.measureText(this.string);; f = 0.0F)
    {
      this.width = f;
      return this.string;
      if (this.prefix != null)
      {
        this.string = (this.prefix + String.valueOf(this.value));
        break;
      }
      if (this.suffix != null)
      {
        this.string = (String.valueOf(this.value) + this.suffix);
        break;
      }
      this.string = String.valueOf(this.value);
      break;
      StringBuilder localStringBuilder;
      if (this.format == 1)
      {
        i = this.value % 60;
        j = this.value / 60 % 60;
        if (j > 9)
        {
          str = j;
          localStringBuilder = new StringBuilder(String.valueOf(str)).append(":");
          if (i <= 9) {
            break label408;
          }
        }
        for (str = i;; str = "0" + i)
        {
          this.string = str;
          if (this.prefix != null) {
            this.string = (this.prefix + this.string);
          }
          if (this.suffix == null) {
            break;
          }
          this.string += this.suffix;
          break;
          str = "0" + j;
          break label259;
        }
      }
      if (this.format != 2) {
        break;
      }
      int i = this.value % 60;
      int j = this.value / 60 % 60;
      if (j > 9)
      {
        str = j;
        localStringBuilder = new StringBuilder(String.valueOf(str)).append(":");
        if (i <= 9) {
          break label625;
        }
      }
      for (String str = i;; str = "0" + i)
      {
        this.string = str;
        if (this.prefix != null) {
          this.string = (this.prefix + this.string);
        }
        if (this.suffix == null) {
          break;
        }
        this.string += this.suffix;
        break;
        str = j;
        break label478;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/BufferedInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */