package com.google.android.b.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

public final class al
  extends FrameLayout
{
  private final ProgressBar a;
  private final TextView b;
  
  public al(Context paramContext)
  {
    super(paramContext, null, bg.c(paramContext));
    ak localak = new ak(paramContext);
    setBackgroundColor(-16777216);
    this.a = new ProgressBar(paramContext);
    this.a.setVisibility(8);
    addView(this.a, new FrameLayout.LayoutParams(-2, -2, 17));
    int i = (int)(10.0F * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    this.b = new TextView(paramContext);
    this.b.setTextAppearance(paramContext, 16973894);
    this.b.setTextColor(-1);
    this.b.setVisibility(8);
    this.b.setPadding(i, i, i, i);
    this.b.setGravity(17);
    this.b.setText(localak.a);
    addView(this.b, new FrameLayout.LayoutParams(-2, -2, 17));
  }
  
  public final void a()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public final void b()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public final void c()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if ((m == 1073741824) && (n == 1073741824)) {}
    for (;;)
    {
      paramInt1 = resolveSize(i, paramInt1);
      paramInt2 = resolveSize(j, paramInt2);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      return;
      if ((m == 1073741824) || ((m == Integer.MIN_VALUE) && (n == 0)))
      {
        j = (int)(i / 1.777F);
      }
      else if ((n == 1073741824) || ((n == Integer.MIN_VALUE) && (m == 0)))
      {
        i = (int)(j * 1.777F);
      }
      else if ((m == Integer.MIN_VALUE) && (n == Integer.MIN_VALUE))
      {
        if (j < i / 1.777F) {
          i = (int)(j * 1.777F);
        } else {
          j = (int)(i / 1.777F);
        }
      }
      else
      {
        j = 0;
        i = k;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */