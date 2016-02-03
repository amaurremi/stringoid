package org.osmdroid.util;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import org.osmdroid.tileprovider.MapTile;

public abstract class TileLooper
{
  protected final Point mLowerRight = new Point();
  protected final Point mUpperLeft = new Point();
  
  public abstract void finaliseLoop();
  
  public abstract void handleTile(Canvas paramCanvas, int paramInt1, MapTile paramMapTile, int paramInt2, int paramInt3);
  
  public abstract void initialiseLoop(int paramInt1, int paramInt2);
  
  public final void loop(Canvas paramCanvas, int paramInt1, int paramInt2, Rect paramRect)
  {
    TileSystem.PixelXYToTileXY(paramRect.left, paramRect.top, this.mUpperLeft);
    this.mUpperLeft.offset(-1, -1);
    TileSystem.PixelXYToTileXY(paramRect.right, paramRect.bottom, this.mLowerRight);
    int k = 1 << paramInt1;
    initialiseLoop(paramInt1, paramInt2);
    int i = this.mUpperLeft.y;
    while (i <= this.mLowerRight.y)
    {
      int j = this.mUpperLeft.x;
      while (j <= this.mLowerRight.x)
      {
        int m = MyMath.mod(i, k);
        handleTile(paramCanvas, paramInt2, new MapTile(paramInt1, MyMath.mod(j, k), m), j, i);
        j += 1;
      }
      i += 1;
    }
    finaliseLoop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/TileLooper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */