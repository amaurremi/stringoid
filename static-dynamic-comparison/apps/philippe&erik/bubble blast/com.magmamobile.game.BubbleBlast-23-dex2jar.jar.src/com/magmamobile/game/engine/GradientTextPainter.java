package com.magmamobile.game.engine;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;

public class GradientTextPainter
  extends StrokeTextPainter
{
  private int _color1 = -1;
  private int _color2 = -16777216;
  private int _lastX;
  private int _lastY;
  
  public GradientTextPainter()
  {
    this._paint1.setShader(new LinearGradient(0.0F, this._lastY - this._size, 0.0F, this._lastY, this._color1, this._color2, Shader.TileMode.CLAMP));
  }
  
  public void draw(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this._lastX) || (paramInt2 != this._lastY))
    {
      this._lastX = paramInt1;
      this._lastY = paramInt2;
      this._paint1.setShader(new LinearGradient(0.0F, this._lastY - this._size, 0.0F, this._lastY, this._color1, this._color2, Shader.TileMode.CLAMP));
    }
    if (this._text != null)
    {
      Game.drawText(this._text, paramInt1, paramInt2, this._paint1);
      Game.drawText(this._text, paramInt1, paramInt2, this._paint2);
    }
  }
  
  public int getColor1()
  {
    return this._color1;
  }
  
  public int getColor2()
  {
    return this._color2;
  }
  
  public void setColor1(int paramInt)
  {
    this._color1 = paramInt;
  }
  
  public void setColor2(int paramInt)
  {
    this._color2 = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GradientTextPainter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */