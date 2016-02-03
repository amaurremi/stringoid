package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.ideashower.readitlater.f.h;
import com.pocket.d.i;
import com.pocket.m.a.k;

public class AvatarView
  extends a
{
  private static Paint a;
  private static PorterDuffXfermode b;
  private h c;
  private com.pocket.m.a.a d;
  private com.ideashower.readitlater.util.a.b e;
  private com.ideashower.readitlater.db.operation.f f;
  private boolean g = false;
  private Paint h;
  private i i;
  
  public AvatarView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public AvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public AvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private static void a(float paramFloat1, float paramFloat2, float paramFloat3, Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramCanvas.drawCircle(paramFloat3, paramFloat3, paramFloat3, paramPaint);
    paramCanvas.restore();
  }
  
  public static void a(Rect paramRect, Canvas paramCanvas, Paint paramPaint)
  {
    a(paramRect.left, paramRect.top, paramRect.width() / 2, paramCanvas, paramPaint);
  }
  
  public static void a(RectF paramRectF, Canvas paramCanvas, Paint paramPaint)
  {
    a(paramRectF.left, paramRectF.top, paramRectF.width() / 2.0F, paramCanvas, paramPaint);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.AvatarView);
      setBorderEnabled(paramAttributeSet.getBoolean(0, false));
      paramAttributeSet.recycle();
    }
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setColor(-16777216);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((this.d == null) && (getDrawable() == null)) {
      a();
    }
  }
  
  private void c()
  {
    if (this.c == null) {
      this.c = new h()
      {
        protected void a(com.ideashower.readitlater.util.a.b paramAnonymousb)
        {
          if (AvatarView.a(AvatarView.this) != null) {
            AvatarView.a(AvatarView.this).b(false);
          }
          AvatarView.a(AvatarView.this, true);
          if ((paramAnonymousb != null) && (paramAnonymousb.c())) {
            AvatarView.this.setImageBitmap(paramAnonymousb.b());
          }
          for (;;)
          {
            AvatarView.a(AvatarView.this, false);
            AvatarView.a(AvatarView.this, paramAnonymousb);
            return;
            AvatarView.this.setImageBitmap(null);
          }
        }
      };
    }
    if (this.f != null) {}
    for (Object localObject = this.f.e(); localObject == null; localObject = null)
    {
      this.d = null;
      return;
    }
    try
    {
      this.d = ((com.pocket.m.a.a)localObject);
      localObject = new com.pocket.k.d(getWidth(), getHeight());
      localObject = com.ideashower.readitlater.f.f.a(this.d, (com.pocket.k.a)localObject, com.pocket.m.a.d.b()).a(1).a(true, k.a).a(this.c, true, true).a();
      this.c.b((com.ideashower.readitlater.f.e)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.d = null;
      com.ideashower.readitlater.util.e.a(localThrowable);
    }
  }
  
  public static Paint getMaskPaint()
  {
    if (a == null)
    {
      a = new Paint();
      a.setAntiAlias(true);
      a.setColor(-16777216);
    }
    return a;
  }
  
  public static PorterDuffXfermode getMaskXfermode()
  {
    if (b == null) {
      b = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
    return b;
  }
  
  private void setBorderEnabled(boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      this.i = new i(getContext());
      this.i.setBounds(0, 0, getWidth(), getHeight());
      this.i.setState(getDrawableState());
      if (paramBoolean) {
        j = this.i.a();
      }
      setPadding(j, j, j, j);
      return;
    }
    this.i = null;
  }
  
  public void a()
  {
    this.g = true;
    setImageResource(2130837521);
    this.g = false;
  }
  
  protected void a(Canvas paramCanvas, RectF paramRectF)
  {
    float f1 = (paramRectF.width() - getPaddingLeft() - getPaddingRight()) / 2.0F;
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1, this.h);
  }
  
  public void b()
  {
    this.f = null;
    this.d = null;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.i != null) {
      this.i.setState(getDrawableState());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.i != null) {
      this.i.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.f != null)) {
      c();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.i != null) {
      this.i.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setFriend(com.ideashower.readitlater.db.operation.f paramf)
  {
    this.f = paramf;
    if (getHeight() == 0) {
      return;
    }
    c();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (!this.g) {
      b();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (!this.g) {
      b();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (!this.g) {
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/AvatarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */