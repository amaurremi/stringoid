package com.magmamobile.game.engine;

import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;

public class StrokeTextPainter
{
  protected Paint.Align _align = Paint.Align.LEFT;
  protected boolean _bold = false;
  protected int _fillColor = -16777216;
  protected Paint _paint1 = Label.createLabelPaint(this._size, this._fillColor, this._bold, false, false);
  protected Paint _paint2 = Label.createLabelPaint(this._size, this._strokeColor, this._bold, false, false);
  protected float _size = 20.0F;
  protected int _strokeColor = -1;
  protected float _strokeWidth;
  protected String _text = null;
  
  public StrokeTextPainter()
  {
    this._paint1.setStyle(Paint.Style.FILL);
    this._paint2.setStyle(Paint.Style.STROKE);
  }
  
  public void draw(int paramInt1, int paramInt2)
  {
    if (this._text != null)
    {
      Game.drawText(this._text, paramInt1, paramInt2, this._paint1);
      Game.drawText(this._text, paramInt1, paramInt2, this._paint2);
    }
  }
  
  public Paint.Align getAlign()
  {
    return this._align;
  }
  
  public int getFillColor()
  {
    return this._fillColor;
  }
  
  public float getSize()
  {
    return this._size;
  }
  
  public int getStrokeColor()
  {
    return this._strokeColor;
  }
  
  public float getStrokeWidth()
  {
    return this._strokeWidth;
  }
  
  public String getText()
  {
    return this._text;
  }
  
  public boolean isBold()
  {
    return this._bold;
  }
  
  public void setAlign(Paint.Align paramAlign)
  {
    this._align = paramAlign;
    this._paint1.setTextAlign(this._align);
    this._paint2.setTextAlign(this._align);
  }
  
  public void setBold(boolean paramBoolean)
  {
    this._bold = paramBoolean;
    this._paint1.setFakeBoldText(this._bold);
    this._paint2.setFakeBoldText(this._bold);
  }
  
  public void setFillColor(int paramInt)
  {
    this._fillColor = paramInt;
    this._paint1.setColor(this._fillColor);
  }
  
  public void setSize(float paramFloat)
  {
    this._size = paramFloat;
    this._paint1.setTextSize(this._size);
    this._paint2.setTextSize(this._size);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this._strokeColor = paramInt;
    this._paint2.setColor(this._strokeColor);
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this._strokeWidth = paramFloat;
    this._paint2.setStrokeWidth(this._strokeWidth);
  }
  
  public void setText(String paramString)
  {
    this._text = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/StrokeTextPainter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */