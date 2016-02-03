package com.magmamobile.game.engine.tmp;

import android.graphics.Bitmap;
import com.magmamobile.game.engine.Game;

public final class ManagedBitmap
{
  private Bitmap bitmap;
  private int key;
  
  public ManagedBitmap(int paramInt)
  {
    this.key = paramInt;
  }
  
  public void free() {}
  
  public Bitmap getBitmap()
  {
    if ((this.bitmap == null) || (this.bitmap.isRecycled())) {
      this.bitmap = Game.getBitmap(this.key);
    }
    return this.bitmap;
  }
  
  public void release()
  {
    if (this.bitmap != null)
    {
      Game.freeBitmap(this.key);
      if (!this.bitmap.isRecycled()) {
        this.bitmap.recycle();
      }
      this.bitmap = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/ManagedBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */