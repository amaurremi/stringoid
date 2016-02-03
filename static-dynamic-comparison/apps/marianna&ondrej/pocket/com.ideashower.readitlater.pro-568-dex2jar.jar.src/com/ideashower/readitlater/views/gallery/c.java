package com.ideashower.readitlater.views.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class c
  extends ImageView
  implements k
{
  protected f a = new f();
  protected float b;
  protected float c;
  protected float d;
  protected PointF e = new PointF();
  protected Context f;
  private e g;
  private int h = 0;
  private int i = 2;
  private j j;
  
  public c(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.f = paramContext;
    b();
    setImageMatrix(this.a);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void b()
  {
    this.a = new f();
    this.a.setTranslate(1.0F, 1.0F);
    this.e = new PointF();
  }
  
  private void c()
  {
    int k = getWidth();
    int m = getHeight();
    if ((k == 0) || (m == 0)) {
      return;
    }
    b();
    this.a.a(this.b, this.c);
    float f1 = k / this.b;
    float f2 = m / this.c;
    if (f1 <= f2) {}
    for (;;)
    {
      this.d = f1;
      this.a.postScale(f1, f1, this.e.x, this.e.y);
      f2 = k;
      float f4 = this.b;
      float f3 = (m - f1 * this.c) / 2.0F;
      f2 = (f2 - f4 * f1) / 2.0F;
      f1 = f2;
      if (this.i == 2) {
        f1 = f2 + k;
      }
      this.a.postTranslate(f1, f3);
      setImageMatrix(this.a);
      d();
      return;
      f1 = f2;
    }
  }
  
  private void d()
  {
    if ((this.i == 1) && (this.g != null)) {
      this.g.a(this.a);
    }
  }
  
  private void e()
  {
    g localg = this.a.a();
    int k = getWidth();
    float f2 = k;
    float f1;
    boolean bool;
    if (localg.c <= this.d)
    {
      f1 = 0.3F;
      f1 *= f2;
      if (localg.a <= f1) {
        break label84;
      }
      if (this.g == null) {
        break label128;
      }
      bool = this.g.a(-1, true);
    }
    for (;;)
    {
      if (!bool) {
        a(true);
      }
      return;
      f1 = 0.4F;
      break;
      label84:
      f2 = localg.a;
      if ((localg.d + f2 < k - f1) && (this.g != null)) {
        bool = this.g.a(1, true);
      } else {
        label128:
        bool = false;
      }
    }
  }
  
  public void a() {}
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if (this.i == 1) {
      return;
    }
    g localg = this.a.a();
    float f1 = localg.a(getWidth());
    if (paramBoolean) {}
    for (paramFloat = paramFloat - localg.d - f1;; paramFloat = f1 + paramFloat)
    {
      this.a.postTranslate(paramFloat - localg.a, 0.0F);
      setImageMatrix(this.a);
      return;
    }
  }
  
  public void a(j paramj)
  {
    if ((this.h == 3) && (paramj == this.j))
    {
      this.h = 0;
      if (this.g != null) {
        this.g.a();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = j.a(this.a, this.d, 3.0F, getWidth(), getHeight(), this);
    if (this.j != null)
    {
      if (!paramBoolean) {
        this.j.a();
      }
      this.h = 3;
      invalidate();
    }
  }
  
  public void a(boolean paramBoolean, e parame)
  {
    setClickable(paramBoolean);
    this.g = parame;
    if (paramBoolean)
    {
      setOnTouchListener(new d(this, null));
      this.i = 1;
      return;
    }
    setOnTouchListener(null);
    this.i = 2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.h == 3) && (this.j != null))
    {
      this.j.a(this.a);
      setImageMatrix(this.a);
      d();
      invalidate();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      c();
      if (this.i == 1)
      {
        this.h = -1;
        e();
      }
    }
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    Object localObject = getDrawable();
    if ((localObject != null) && ((localObject instanceof BitmapDrawable)))
    {
      localObject = ((BitmapDrawable)getDrawable()).getBitmap();
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
    }
    b();
    setImageBitmap(paramBitmap);
    if (paramBitmap != null)
    {
      this.b = paramBitmap.getWidth();
      this.c = paramBitmap.getHeight();
      c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/gallery/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */