package com.go.weatherex.viewex;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

public class SlidingTabStrip
  extends LinearLayout
{
  private final int a;
  private final Paint b;
  private int c;
  private final Paint d;
  private int e;
  private final Paint f;
  private final float g;
  private int h;
  private float i;
  private i j;
  private final h k;
  private boolean l = true;
  
  public SlidingTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    float f1 = getResources().getDisplayMetrics().density;
    paramAttributeSet = new TypedValue();
    paramContext.getTheme().resolveAttribute(16842800, paramAttributeSet, true);
    int m = paramAttributeSet.data;
    this.e = a(m, (byte)38);
    this.k = new h(null);
    this.k.a(new int[] { -13388315 });
    this.k.b(new int[] { a(m, 32) });
    this.a = ((int)(2.0F * f1));
    this.b = new Paint();
    this.b.setColor(this.e);
    this.c = ((int)(8.0F * f1));
    this.d = new Paint();
    this.g = 0.5F;
    this.f = new Paint();
    this.f.setStrokeWidth((int)(f1 * 1.0F));
  }
  
  private static int a(int paramInt, byte paramByte)
  {
    return Color.argb(paramByte, Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.red(paramInt1);
    float f3 = Color.red(paramInt2);
    float f4 = Color.green(paramInt1);
    float f5 = Color.green(paramInt2);
    float f6 = Color.blue(paramInt1);
    float f7 = Color.blue(paramInt2);
    return Color.rgb((int)(f2 * paramFloat + f3 * f1), (int)(f4 * paramFloat + f5 * f1), (int)(f1 * f7 + f6 * paramFloat));
  }
  
  public void a(byte paramByte)
  {
    this.e = a(this.e, paramByte);
    this.b.setColor(this.e);
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.h = paramInt;
    this.i = paramFloat;
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(int... paramVarArgs)
  {
    this.j = null;
    this.k.a(paramVarArgs);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i5 = getHeight();
    int i3 = getChildCount();
    int i4 = (int)(Math.min(Math.max(0.0F, this.g), 1.0F) * i5);
    Object localObject;
    View localView;
    int i1;
    int i2;
    int n;
    int m;
    if (this.j != null)
    {
      localObject = this.j;
      if (i3 > 0)
      {
        localView = getChildAt(this.h);
        i1 = localView.getLeft();
        i2 = localView.getRight();
        n = ((i)localObject).a(this.h);
        if ((this.i <= 0.0F) || (this.h >= getChildCount() - 1)) {
          break label388;
        }
        int i6 = ((i)localObject).a(this.h + 1);
        m = n;
        if (n != i6) {
          m = a(i6, n, this.i);
        }
        localView = getChildAt(this.h + 1);
        float f1 = this.i;
        float f2 = localView.getLeft();
        float f3 = this.i;
        i1 = (int)(i1 * (1.0F - f3) + f1 * f2);
        f1 = this.i;
        f2 = localView.getRight();
        f3 = this.i;
        i2 = (int)(i2 * (1.0F - f3) + f2 * f1);
        n = m;
      }
    }
    for (;;)
    {
      this.d.setColor(n);
      paramCanvas.drawRect(i1, i5 - this.c, i2, i5, this.d);
      paramCanvas.drawRect(0.0F, i5 - this.a, getWidth(), i5, this.b);
      if (this.l)
      {
        n = (i5 - i4) / 2;
        m = 0;
        for (;;)
        {
          if (m < i3 - 1)
          {
            localView = getChildAt(m);
            this.f.setColor(((i)localObject).b(m));
            paramCanvas.drawLine(localView.getRight(), n, localView.getRight(), n + i4, this.f);
            m += 1;
            continue;
            localObject = this.k;
            break;
          }
        }
      }
      return;
      label388:
      m = i2;
      i2 = m;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/viewex/SlidingTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */