package com.go.weatherex.viewex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.a.a.an;

public class ExtendableButton
  extends TextView
{
  private Drawable a;
  private Drawable b;
  private boolean c;
  private boolean d;
  private float e = 1.0F;
  private an f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private Rect l = new Rect();
  
  public ExtendableButton(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ExtendableButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    Resources localResources = getResources();
    this.a = localResources.getDrawable(2130838592);
    this.b = localResources.getDrawable(2130837894);
    this.f = new an();
    this.f.a(new float[] { 0.0F, 1.0F });
    this.f.c(300L);
    this.f.a(new a(this));
  }
  
  public boolean a()
  {
    if (this.c) {
      return false;
    }
    this.d = true;
    this.f.a();
    return true;
  }
  
  public boolean b()
  {
    if (this.c) {
      return false;
    }
    this.d = false;
    this.f.a();
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d) {}
    for (float f1 = this.e;; f1 = 1.0F - this.e)
    {
      this.j = ((int)(255.0F * f1));
      this.k = ((int)((1.0F - f1) * this.i));
      this.b.setAlpha(this.j);
      this.b.setBounds(this.k, 0, this.g, this.h);
      this.b.draw(paramCanvas);
      int m = paramCanvas.save();
      paramCanvas.translate(this.k - this.i, 0.0F);
      this.a.setAlpha(255 - this.j);
      this.a.draw(paramCanvas);
      paramCanvas.restoreToCount(m);
      getDrawingRect(this.l);
      m = paramCanvas.saveLayerAlpha(this.l.left - getPaddingLeft(), this.l.top - getPaddingTop(), this.l.right + getPaddingRight(), this.l.bottom + getPaddingBottom(), this.j, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(m);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      this.g = (paramInt3 - paramInt1);
      this.h = (paramInt4 - paramInt2);
      paramInt2 = this.a.getIntrinsicWidth();
      paramInt1 = this.a.getIntrinsicHeight();
      this.i = (this.g - paramInt2);
      paramInt2 = (this.h - paramInt1) / 2;
      this.a.setBounds(this.i, paramInt2, this.g, paramInt1 + paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/ExtendableButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */