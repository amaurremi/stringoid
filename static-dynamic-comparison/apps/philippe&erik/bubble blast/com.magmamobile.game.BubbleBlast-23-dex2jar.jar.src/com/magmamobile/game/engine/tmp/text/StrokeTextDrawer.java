package com.magmamobile.game.engine.tmp.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.magmamobile.game.engine.Game;

public class StrokeTextDrawer
  extends TextDrawer
{
  private Paint p = new Paint();
  private Paint s;
  
  public StrokeTextDrawer(int paramInt1, int paramInt2, boolean paramBoolean, Paint.Align paramAlign, int paramInt3, float paramFloat)
  {
    this.p.setColor(paramInt2);
    this.p.setTextSize(paramInt1);
    this.p.setTextAlign(paramAlign);
    this.p.setAntiAlias(true);
    this.p.setFilterBitmap(true);
    this.p.setFakeBoldText(paramBoolean);
    this.p.setTypeface(Game.typeface);
    this.s = new Paint();
    this.s.setColor(paramInt3);
    this.s.setTextSize(paramInt1);
    this.s.setTextAlign(paramAlign);
    this.s.setAntiAlias(true);
    this.s.setFilterBitmap(true);
    this.s.setFakeBoldText(paramBoolean);
    this.s.setTypeface(Game.typeface);
  }
  
  public void draw(String paramString, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (i > 1)
    {
      Game.mCanvas.drawText(paramString, paramInt1, paramInt2, this.p);
      return;
    }
    int j = -1;
    for (;;)
    {
      if (j > 1)
      {
        i += 1;
        break;
      }
      Game.mCanvas.drawText(paramString, i + paramInt1, j + paramInt2, this.s);
      j += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/text/StrokeTextDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */