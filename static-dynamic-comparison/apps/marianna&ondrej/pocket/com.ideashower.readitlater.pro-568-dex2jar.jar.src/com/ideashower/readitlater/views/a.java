package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;

public abstract class a
  extends ThemedImageView
{
  private PorterDuffXfermode a;
  private RectF b;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  private RectF getRect()
  {
    if (this.b == null) {
      this.b = new RectF();
    }
    return this.b;
  }
  
  protected abstract void a(Canvas paramCanvas, RectF paramRectF);
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getDrawable();
    if (localObject == null)
    {
      super.onDraw(paramCanvas);
      return;
    }
    localObject = ((BitmapDrawable)localObject).getPaint();
    int i = paramCanvas.saveLayer(this.b, null, 31);
    a(paramCanvas, this.b);
    Xfermode localXfermode = ((Paint)localObject).getXfermode();
    ((Paint)localObject).setXfermode(this.a);
    super.onDraw(paramCanvas);
    ((Paint)localObject).setXfermode(localXfermode);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    getRect().set(0.0F, 0.0F, getWidth(), getHeight());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */