package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.ideashower.readitlater.f.f;
import com.ideashower.readitlater.f.h;
import com.ideashower.readitlater.util.a.b;
import com.ideashower.readitlater.util.e;
import com.pocket.m.a.k;

public class ImageRequestView
  extends ThemedImageView
{
  private com.pocket.i.a.a a;
  private h b;
  private com.pocket.m.a.a c;
  private com.pocket.m.a.d d;
  private b e;
  private boolean f = true;
  
  public ImageRequestView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ImageRequestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ImageRequestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new com.pocket.i.a.a(getContext(), 2131165779);
    this.b = new h()
    {
      protected void a(b paramAnonymousb)
      {
        ImageRequestView.a(ImageRequestView.this, paramAnonymousb);
      }
    };
    setScaleType(ImageView.ScaleType.CENTER);
    if (this.c == null) {
      b();
    }
  }
  
  private void b()
  {
    setImageDrawable(null);
  }
  
  private void c()
  {
    if ((getWidth() == 0) || (getHeight() == 0)) {
      return;
    }
    try
    {
      Object localObject = new com.pocket.k.d(getWidth(), getHeight());
      localObject = f.a(this.c, (com.pocket.k.a)localObject, this.d);
      ((f)localObject).a(1).a(true, k.a).a(this.b, true, true);
      this.b.b(((f)localObject).a());
      return;
    }
    catch (Throwable localThrowable)
    {
      e.a(localThrowable);
    }
  }
  
  private void setImage(b paramb)
  {
    if (this.e != null) {
      this.e.b(false);
    }
    if ((paramb != null) && (paramb.c())) {
      setImageBitmap(paramb.b());
    }
    for (;;)
    {
      this.e = paramb;
      return;
      setImageBitmap(null);
    }
  }
  
  public void a(com.pocket.m.a.a parama, com.pocket.m.a.d paramd)
  {
    b();
    this.c = parama;
    this.d = paramd;
    if (parama != null) {
      c();
    }
  }
  
  public void a(String paramString, com.pocket.m.a.d paramd)
  {
    a(com.pocket.m.a.a.a(paramString), paramd);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.a.setState(getDrawableState());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((getDrawable() == null) && (this.f)) {
      this.a.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.a.setBounds(0, 0, getWidth(), getHeight());
      this.a.setState(getDrawableState());
      if (this.c != null) {
        c();
      }
    }
  }
  
  public void setDrawPlaceholder(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ImageRequestView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */