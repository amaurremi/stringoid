package com.jaysquared.games.whereishd.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class TextDrawable
  extends BitmapDrawable
{
  private final Paint paint;
  private final String text;
  
  public TextDrawable(String paramString)
  {
    this.text = paramString;
    this.paint = new Paint();
    this.paint.setColor(-1);
    this.paint.setTextSize(22.0F);
    this.paint.setAntiAlias(true);
    this.paint.setFakeBoldText(true);
    this.paint.setShadowLayer(6.0F, 0.0F, 0.0F, -16777216);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setTextAlign(Paint.Align.CENTER);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(new Rect(-100, 0, 100, 100), this.paint);
    paramCanvas.drawText("Play 10 rounds", 0.0F, 30.0F, this.paint);
    paramCanvas.drawText(this.text, 0.0F, 60.0F, this.paint);
    paramCanvas.drawText("Start", 0.0F, 90.0F, this.paint);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.paint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/TextDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */