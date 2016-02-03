package com.magmamobile.game.engine;

import android.graphics.Bitmap;

public final class FixedBackground
{
  private static Bitmap _bm;
  private static int _res = -1;
  
  public static void freeBitmap()
  {
    if (_res == -1) {}
    while (_bm == null) {
      return;
    }
    if (!_bm.isRecycled()) {
      _bm.recycle();
    }
    _bm = null;
    if (_res >= 0) {
      Game.freeBitmap(_res);
    }
    _res = -1;
    System.gc();
  }
  
  public static Bitmap getBitmap()
  {
    return _bm;
  }
  
  public static int getRes()
  {
    return _res;
  }
  
  public static void onAction() {}
  
  public static void onInitialize(int paramInt)
  {
    if (paramInt != _res)
    {
      freeBitmap();
      _res = paramInt;
      _bm = Game.getBitmap(_res);
    }
  }
  
  public static void onRender()
  {
    if (_bm == null) {}
    while (_bm.isRecycled()) {
      return;
    }
    Game.drawBitmap(_bm);
  }
  
  public static void onTerminate() {}
  
  public static void setBitmap(Bitmap paramBitmap)
  {
    freeBitmap();
    _bm = paramBitmap;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/FixedBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */