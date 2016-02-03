package com.magmamobile.game.engine;

import android.graphics.Paint;

public class IncrementalInt
{
  private int format;
  private int last;
  private Paint paint;
  private String prefix;
  private int seed;
  private String string;
  private String suffix;
  private int value;
  private float width;
  
  public IncrementalInt() {}
  
  public IncrementalInt(String paramString)
  {
    this(paramString, null);
  }
  
  public IncrementalInt(String paramString1, String paramString2)
  {
    this.prefix = paramString1;
    this.suffix = paramString2;
  }
  
  public void add(int paramInt)
  {
    this.seed += paramInt;
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
  
  public void onAction()
  {
    int i;
    if (this.seed != 0)
    {
      i = Math.abs(this.seed);
      if (i <= 100) {
        break label74;
      }
      if (this.seed > 0)
      {
        this.value += 100;
        this.seed -= 100;
      }
    }
    else
    {
      return;
    }
    this.value -= 100;
    this.seed += 100;
    return;
    label74:
    if (i > 10)
    {
      if (this.seed > 0)
      {
        this.value += 10;
        this.seed -= 10;
        return;
      }
      this.value -= 10;
      this.seed += 10;
      return;
    }
    if (this.seed > 0)
    {
      this.value += 1;
      this.seed -= 1;
      return;
    }
    this.value -= 1;
    this.seed += 1;
  }
  
  public void realize()
  {
    this.value += this.seed;
    this.seed = 0;
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
      if ((this.prefix == null) || (this.suffix == null)) {
        break label107;
      }
      this.string = (this.prefix + String.valueOf(this.value) + this.suffix);
      if (this.paint == null) {
        break label203;
      }
    }
    label107:
    label203:
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
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/IncrementalInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */