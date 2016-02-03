package com.magmamobile.game.engine.tmp.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.magmamobile.game.engine.Game;

public class NormalTextDrawer
  extends TextDrawer
{
  private Paint p = new Paint();
  
  public NormalTextDrawer(int paramInt1, int paramInt2, boolean paramBoolean, Paint.Align paramAlign)
  {
    this.p.setColor(paramInt2);
    this.p.setTextSize(paramInt1);
    this.p.setTextAlign(paramAlign);
    this.p.setAntiAlias(true);
    this.p.setFilterBitmap(true);
    this.p.setFakeBoldText(paramBoolean);
    this.p.setTypeface(Game.typeface);
  }
  
  public void draw(String paramString, int paramInt1, int paramInt2)
  {
    Game.mCanvas.drawText(paramString, paramInt1, paramInt2, this.p);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/text/NormalTextDrawer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */