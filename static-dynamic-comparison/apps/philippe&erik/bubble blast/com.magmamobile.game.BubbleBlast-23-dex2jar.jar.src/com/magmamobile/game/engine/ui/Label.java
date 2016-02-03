package com.magmamobile.game.engine.ui;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.TextUtils;

public class Label
  extends Component
{
  private Paint _paint = new Paint();
  private String _text;
  private int _textColor;
  private float _textSize;
  private Typeface _typeface = Typeface.DEFAULT;
  
  public String getText()
  {
    return this._text;
  }
  
  public int getTextColor()
  {
    return this._textColor;
  }
  
  public float getTextSize()
  {
    return this._textColor;
  }
  
  public Typeface getTypeface()
  {
    return this._typeface;
  }
  
  protected void onDraw()
  {
    if (this._text == null) {
      return;
    }
    Game.drawText(this._text, (int)this._left, (int)this._top, this._paint);
  }
  
  public void setText(String paramString)
  {
    if (TextUtils.isEqual(paramString, this._text)) {
      return;
    }
    this._text = paramString;
    this._dirty = true;
  }
  
  public void setTextColor(int paramInt)
  {
    if (this._textColor != paramInt)
    {
      this._textColor = paramInt;
      this._paint.setColor(this._textColor);
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (this._textSize != paramFloat)
    {
      this._textSize = paramFloat;
      this._paint.setTextSize(this._textSize);
      this._dirty = true;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this._typeface = paramTypeface;
    this._paint.setTypeface(this._typeface);
    this._dirty = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ui/Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */