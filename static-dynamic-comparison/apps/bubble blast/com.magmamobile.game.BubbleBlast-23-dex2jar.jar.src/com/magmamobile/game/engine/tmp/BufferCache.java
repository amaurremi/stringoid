package com.magmamobile.game.engine.tmp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.magmamobile.game.engine.Game;

public class BufferCache
{
  private Bitmap cache;
  private Canvas canvas;
  private Rect dst;
  private Rect rect;
  
  public BufferCache(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.rect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.dst = new Rect(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    this.cache = Game.createBitmap(this.rect.width(), this.rect.height());
    this.canvas = new Canvas(this.cache);
  }
  
  public void capture()
  {
    this.canvas.drawBitmap(Game.buffer, this.rect, this.dst, null);
  }
  
  public void redraw()
  {
    Game.mCanvas.drawBitmap(this.cache, this.dst, this.rect, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/BufferCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */