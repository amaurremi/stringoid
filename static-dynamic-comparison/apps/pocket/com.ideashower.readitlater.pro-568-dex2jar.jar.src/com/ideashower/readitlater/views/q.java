package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ImageView.ScaleType;
import com.ideashower.readitlater.views.gallery.f;
import com.ideashower.readitlater.views.gallery.g;

public class q
  extends ThemedImageView
{
  protected f a = new f();
  protected float b;
  protected float c;
  protected Context d;
  protected final Rect e = new Rect();
  private int f = 0;
  private int g;
  private float h;
  private float i = 0.0F;
  private int j;
  private int k;
  private boolean l;
  
  public q(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public q(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public q(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = paramContext;
    c();
    setImageMatrix(this.a);
    setScaleType(ImageView.ScaleType.MATRIX);
    setOnTouchListener(new r(this, null));
    this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    a(0, 0);
    setMaxZoom(3.0F);
  }
  
  private void a(boolean paramBoolean)
  {
    int n = 1;
    int i7 = getWidth();
    int i5 = getHeight();
    int m = getPaddingLeft();
    int i3 = getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getPaddingBottom();
    m = (int)((i7 - m - i3) / 2.0F);
    int i6 = (int)((i5 - i1 - i2) / 2.0F);
    if ((i7 == 0) || (i5 == 0))
    {
      if (paramBoolean) {
        this.l = true;
      }
      return;
    }
    i1 = this.e.left;
    i2 = this.e.right;
    i3 = this.e.top;
    int i4 = this.e.bottom;
    label187:
    label269:
    label333:
    float f1;
    float f2;
    if (this.j == 0)
    {
      this.e.left = getPaddingLeft();
      this.e.right = (i7 - getPaddingRight());
      if (this.k != 0) {
        break label538;
      }
      this.e.top = getPaddingTop();
      this.e.bottom = (i5 - getPaddingBottom());
      i5 = this.e.width();
      i7 = this.e.height();
      if ((this.j == this.k) && (i5 != i7))
      {
        if (i5 >= i7) {
          break label585;
        }
        m = getPaddingTop() + i6;
        i6 = i5 / 2;
        this.e.top = (m - i6);
        this.e.bottom = (m + i6);
      }
      m = n;
      if (i1 == this.e.left)
      {
        m = n;
        if (i2 == this.e.right)
        {
          m = n;
          if (i3 == this.e.top)
          {
            if (i4 == this.e.bottom) {
              break label627;
            }
            m = n;
          }
        }
      }
      f1 = i5 / this.b;
      f2 = i7 / this.c;
      if (f1 < f2) {
        break label633;
      }
    }
    float f3;
    float f4;
    for (;;)
    {
      this.i = f1;
      if (m != 0) {
        a();
      }
      if (!paramBoolean) {
        break label638;
      }
      c();
      this.a.a(this.b, this.c);
      this.a.postScale(this.i, this.i, 0.0F, 0.0F);
      f2 = i5;
      f3 = this.i;
      f4 = this.b;
      f1 = (i7 - this.i * this.c) / 2.0F;
      f2 = (f2 - f3 * f4) / 2.0F;
      this.a.postTranslate(f2 + this.e.left, f1 + this.e.top);
      setImageMatrix(this.a);
      return;
      i7 = getPaddingLeft() + m;
      int i8 = Math.min(m, this.j);
      this.e.left = (i7 - i8);
      this.e.right = (i7 + i8);
      break;
      label538:
      i5 = getPaddingTop() + i6;
      i7 = Math.min(i6, this.k);
      this.e.top = (i5 - i7);
      this.e.bottom = (i5 + i7);
      break label187;
      label585:
      m = getPaddingLeft() + m;
      i6 = i7 / 2;
      this.e.left = (m - i6);
      this.e.right = (m + i6);
      break label269;
      label627:
      m = 0;
      break label333;
      label633:
      f1 = f2;
    }
    label638:
    if (m != 0)
    {
      f1 = i2 - i1;
      f2 = i5 / f1;
      f3 = this.e.left - i1;
      f4 = i5;
      float f5 = this.e.top - i3;
      float f6 = i7;
      this.a.postTranslate(f3 * f2 - (f4 - f1), f5 * f2 - (f6 - f1));
      this.a.postScale(f2, f2, this.e.exactCenterX(), this.e.exactCenterY());
    }
    b();
  }
  
  private void c()
  {
    this.a = new f();
    this.a.setTranslate(1.0F, 1.0F);
  }
  
  private void d()
  {
    g localg = this.a.a();
    if (localg.c > this.h)
    {
      f1 = this.h / localg.c;
      this.a.postScale(f1, f1, this.e.exactCenterX(), this.e.exactCenterY());
    }
    while (localg.c >= this.i) {
      return;
    }
    float f1 = this.i / localg.c;
    this.a.postScale(f1, f1, this.e.exactCenterX(), this.e.exactCenterY());
  }
  
  private void e()
  {
    Object localObject2 = this.a.a();
    Object localObject1 = localObject2;
    if (((g)localObject2).a > this.e.left)
    {
      this.a.postTranslate(this.e.left - ((g)localObject2).a, 0.0F);
      localObject1 = this.a.a();
    }
    localObject2 = localObject1;
    float f1;
    float f2;
    if (((g)localObject1).a + ((g)localObject1).d < this.e.right)
    {
      localObject2 = this.a;
      f1 = this.e.right;
      f2 = ((g)localObject1).a;
      ((f)localObject2).postTranslate(f1 - (((g)localObject1).d + f2), 0.0F);
      localObject2 = this.a.a();
    }
    localObject1 = localObject2;
    if (((g)localObject2).b > this.e.top)
    {
      this.a.postTranslate(0.0F, this.e.top - ((g)localObject2).b);
      localObject1 = this.a.a();
    }
    if (((g)localObject1).b + ((g)localObject1).e < this.e.bottom)
    {
      localObject2 = this.a;
      f1 = this.e.bottom;
      f2 = ((g)localObject1).b;
      ((f)localObject2).postTranslate(0.0F, f1 - (((g)localObject1).e + f2));
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    a(false);
  }
  
  protected void b()
  {
    d();
    e();
    setImageMatrix(this.a);
  }
  
  public Bitmap getCroppedBitmap()
  {
    if (getDrawable() == null) {
      return null;
    }
    Object localObject = new f();
    ((f)localObject).a(this.a);
    localObject = ((f)localObject).a();
    float f1 = 1.0F / ((g)localObject).c;
    float f2 = ((g)localObject).a;
    float f3 = this.e.left;
    float f4 = ((g)localObject).b;
    float f5 = this.e.top;
    int m = (int)(this.e.width() * f1);
    int n = (int)(f1 * this.e.height());
    localObject = new Matrix();
    ((Matrix)localObject).postTranslate((f2 - f3) * f1, (f4 - f5) * f1);
    Bitmap localBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.concat((Matrix)localObject);
    getDrawable().draw(localCanvas);
    return localBitmap;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(-getPaddingLeft(), -getPaddingRight());
    super.onDraw(paramCanvas);
    paramCanvas.translate(getPaddingLeft(), getPaddingRight());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    this.f = -1;
    boolean bool = this.l;
    this.l = false;
    a(bool);
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
    c();
    setImageBitmap(paramBitmap);
    if (paramBitmap != null)
    {
      this.b = paramBitmap.getWidth();
      this.c = paramBitmap.getHeight();
      a(true);
    }
  }
  
  public void setMaxZoom(float paramFloat)
  {
    this.h = paramFloat;
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */