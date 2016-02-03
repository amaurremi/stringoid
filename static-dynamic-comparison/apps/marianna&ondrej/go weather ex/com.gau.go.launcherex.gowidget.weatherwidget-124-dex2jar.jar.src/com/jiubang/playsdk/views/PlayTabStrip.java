package com.jiubang.playsdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.d;
import com.jiubang.playsdk.g.j;

public class PlayTabStrip
  extends LinearLayout
{
  private final Paint a;
  private final int b;
  private int c;
  private final Paint d;
  private final int e;
  private float f;
  private final int g;
  private final Paint h;
  private int i = -1;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  
  public PlayTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlayTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    paramContext = paramContext.getResources();
    paramAttributeSet = aa.a().b();
    this.b = paramContext.getDimensionPixelSize(d.l);
    this.a = new Paint();
    this.a.setColor(paramContext.getColor(com.jiubang.playsdk.c.b));
    this.e = paramContext.getDimensionPixelSize(d.n);
    this.d = new Paint();
    this.d.setColor(paramContext.getColor(paramAttributeSet.d()));
    this.h = new Paint();
    this.h.setColor(paramContext.getColor(com.jiubang.playsdk.c.f));
    this.h.setStrokeWidth(paramContext.getDimensionPixelSize(d.o));
    this.g = paramContext.getDimensionPixelSize(d.q);
    this.j = getContext().getResources().getColor(com.jiubang.playsdk.c.c);
    this.k = getContext().getResources().getColor(paramAttributeSet.e());
    this.l = j.b(getContext());
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != -1)
    {
      int m = 0;
      while (m < getChildCount())
      {
        if ((getChildAt(m) instanceof TextView)) {
          ((TextView)getChildAt(m)).setTextColor(this.j);
        }
        m += 1;
      }
      if ((getChildAt(paramInt) instanceof TextView)) {
        ((TextView)getChildAt(paramInt)).setTextColor(this.k);
      }
      this.i = paramInt;
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    this.c = paramInt1;
    this.f = paramFloat;
    invalidate();
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    this.f = 0.0F;
    invalidate();
  }
  
  public void c(int paramInt)
  {
    this.l = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i2 = getHeight();
    int i1 = getChildCount();
    View localView;
    int n;
    int m;
    if (this.l <= getWidth())
    {
      paramCanvas.drawRect(0.0F, i2 - this.e, getWidth(), i2, this.h);
      if (i1 <= 0) {
        break label333;
      }
      localView = getChildAt(this.c);
      n = localView.getLeft();
      m = localView.getRight();
      if ((this.f <= 0.0F) || (this.c >= i1 - 1)) {
        break label362;
      }
      localView = getChildAt(this.c + 1);
      int i4 = localView.getLeft();
      int i3 = localView.getRight();
      float f1 = this.f;
      float f2 = i4;
      float f3 = this.f;
      n = (int)(f1 * f2 + n * (1.0F - f3));
      f1 = this.f;
      f2 = i3;
      f3 = this.f;
      m = (int)(m * (1.0F - f3) + f1 * f2);
    }
    label333:
    label362:
    for (;;)
    {
      paramCanvas.drawRect(n, i2 - this.e, m, i2, this.d);
      for (;;)
      {
        m = 1;
        while (m < i1)
        {
          localView = getChildAt(m);
          n = localView.getPaddingTop();
          i2 = localView.getPaddingBottom();
          n = n + (localView.getHeight() - n - i2) / 2 - this.g / 2;
          paramCanvas.drawLine(localView.getLeft(), n, localView.getLeft(), this.g + n, this.h);
          m += 1;
        }
        paramCanvas.drawRect(0.0F, i2 - this.e, this.l, i2, this.h);
        break;
        paramCanvas.drawRect(0.0F, i2 - this.e, getWidth(), i2, this.a);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/PlayTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */