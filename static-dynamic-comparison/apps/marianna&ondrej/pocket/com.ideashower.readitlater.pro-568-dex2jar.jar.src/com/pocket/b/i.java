package com.pocket.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.b.c.c;

public class i
{
  private static final Interpolator a = new AnticipateInterpolator(0.42F);
  private static final Interpolator b = new OvershootInterpolator(0.42F);
  private static final Interpolator c = new AccelerateDecelerateInterpolator();
  private static final Interpolator d = new AccelerateDecelerateInterpolator();
  private static final Interpolator e = new AccelerateDecelerateInterpolator();
  private j f;
  private View[] g;
  private View[] h;
  
  private c a(View paramView, long paramLong, boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f3 = 0.75F;
    if (paramBoolean)
    {
      f1 = 0.75F;
      com.b.c.a.b(paramView, f1);
      if (!paramBoolean) {
        break label143;
      }
      f1 = 0.75F;
      label31:
      com.b.c.a.c(paramView, f1);
      if (!paramBoolean) {
        break label149;
      }
      f1 = 0.0F;
      label45:
      com.b.c.a.a(paramView, f1);
      c localc = c.a(paramView).b(paramLong).a(222L);
      if (!paramBoolean) {
        break label155;
      }
      paramView = b;
      label76:
      paramView = localc.a(paramView);
      if (!paramBoolean) {
        break label162;
      }
      f1 = 1.0F;
      label91:
      paramView = paramView.g(f1);
      f1 = f3;
      if (paramBoolean) {
        f1 = 1.0F;
      }
      paramView = paramView.i(f1);
      if (!paramBoolean) {
        break label169;
      }
    }
    label143:
    label149:
    label155:
    label162:
    label169:
    for (float f1 = f2;; f1 = 0.0F)
    {
      return paramView.k(f1).a(null);
      f1 = 1.0F;
      break;
      f1 = 1.0F;
      break label31;
      f1 = 1.0F;
      break label45;
      paramView = a;
      break label76;
      f1 = 0.75F;
      break label91;
    }
  }
  
  private View[] c(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    View[] arrayOfView = new View[j];
    int i = 0;
    while (i < j)
    {
      arrayOfView[i] = paramViewGroup.getChildAt(i);
      i += 1;
    }
    return arrayOfView;
  }
  
  public i a(ViewGroup paramViewGroup)
  {
    return a(c(paramViewGroup));
  }
  
  public i a(j paramj)
  {
    this.f = paramj;
    return this;
  }
  
  public i a(View... paramVarArgs)
  {
    if (this.g == null)
    {
      this.g = paramVarArgs;
      return this;
    }
    this.g = ((View[])org.apache.a.c.a.a(this.g, paramVarArgs));
    return this;
  }
  
  public void a()
  {
    int j = 0;
    c localc = null;
    View[] arrayOfView = this.g;
    int k = arrayOfView.length;
    long l = 0L;
    int i = 0;
    while (i < k)
    {
      localc = a(arrayOfView[i], l, false);
      l += 50L;
      i += 1;
    }
    l = 272L;
    arrayOfView = this.h;
    k = arrayOfView.length;
    i = j;
    while (i < k)
    {
      localc = a(arrayOfView[i], l, true);
      l += 50L;
      i += 1;
    }
    if ((localc != null) && (this.f != null)) {
      localc.a(new b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          i.a(i.this).a();
        }
      });
    }
  }
  
  public i b(ViewGroup paramViewGroup)
  {
    return b(c(paramViewGroup));
  }
  
  public i b(View... paramVarArgs)
  {
    if (this.h == null)
    {
      this.h = paramVarArgs;
      return this;
    }
    this.h = ((View[])org.apache.a.c.a.a(this.h, paramVarArgs));
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */