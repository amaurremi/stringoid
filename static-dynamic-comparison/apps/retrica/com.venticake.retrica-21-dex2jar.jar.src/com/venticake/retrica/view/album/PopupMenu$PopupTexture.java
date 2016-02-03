package com.venticake.retrica.view.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;

final class PopupMenu$PopupTexture
  extends CanvasTexture
{
  private final NinePatch mBackground;
  private final Rect mBackgroundRect = new Rect();
  private final NinePatch mHighlightSelected;
  private final Bitmap mTriangleBottom;
  private int mTriangleX = 0;
  
  public PopupMenu$PopupTexture(PopupMenu paramPopupMenu, Context paramContext)
  {
    super(Bitmap.Config.ARGB_8888);
    paramPopupMenu = paramContext.getResources();
    paramContext = BitmapFactory.decodeResource(paramPopupMenu, 2130837661);
    this.mBackground = new NinePatch(paramContext, paramContext.getNinePatchChunk(), null);
    paramContext = BitmapFactory.decodeResource(paramPopupMenu, 2130837662);
    this.mHighlightSelected = new NinePatch(paramContext, paramContext.getNinePatchChunk(), null);
    this.mTriangleBottom = BitmapFactory.decodeResource(paramPopupMenu, 2130837663);
  }
  
  protected void onSizeChanged()
  {
    this.mBackgroundRect.set(0, 0, getWidth(), getHeight() - (int)(14.0F * Gallery.PIXEL_DENSITY));
  }
  
  protected void renderCanvas(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramInt1 = 0;
    paramBitmap.eraseColor(0);
    this.mBackground.draw(paramCanvas, this.mBackgroundRect, PopupMenu.access$0());
    paramBitmap = this.mTriangleBottom;
    paramCanvas.drawBitmap(paramBitmap, this.mTriangleX, paramInt2 - paramBitmap.getHeight() - 1, PopupMenu.access$0());
    paramBitmap = PopupMenu.access$1(this.this$0);
    paramInt2 = PopupMenu.access$2(this.this$0);
    if (paramInt2 != -1)
    {
      PopupMenu.Option localOption = paramBitmap[paramInt2];
      this.mHighlightSelected.draw(paramCanvas, PopupMenu.Option.access$0(localOption).getBounds());
    }
    paramInt2 = paramBitmap.length;
    for (;;)
    {
      if (paramInt1 == paramInt2) {
        return;
      }
      PopupMenu.Option.access$0(paramBitmap[paramInt1]).draw(paramCanvas);
      paramInt1 += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/PopupMenu$PopupTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */