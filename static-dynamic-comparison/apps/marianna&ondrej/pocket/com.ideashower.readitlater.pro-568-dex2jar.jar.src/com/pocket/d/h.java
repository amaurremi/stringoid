package com.pocket.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ideashower.readitlater.views.AvatarView;

public class h
  extends m
{
  private final Rect b = new Rect();
  
  public h(Bitmap paramBitmap, Resources paramResources)
  {
    super(paramBitmap, paramResources);
  }
  
  public void a(RectF paramRectF)
  {
    setBounds((int)paramRectF.left, (int)paramRectF.top, (int)paramRectF.right, (int)paramRectF.bottom);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect1 = getBounds();
    float f = localRect1.width() / getIntrinsicWidth();
    if (f != 1.0F)
    {
      paramCanvas.save();
      paramCanvas.scale(f, f, localRect1.left, localRect1.top);
      Rect localRect2 = this.b;
      int i = (int)(localRect1.width() / f);
      localRect2.set(localRect1.left, localRect1.top, localRect1.left + i, localRect1.top + i);
      AvatarView.a(localRect2, paramCanvas, this.a);
      paramCanvas.restore();
      return;
    }
    AvatarView.a(localRect1, paramCanvas, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */