package com.pocket.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.b.c.c;
import com.ideashower.readitlater.util.j;
import com.pocket.b.b;
import com.pocket.i.a.i;
import java.util.ArrayList;
import java.util.Iterator;

public class ad
{
  private static final float a = j.a(20.0F);
  private static final int b = i.c;
  private static final Interpolator c = new AccelerateDecelerateInterpolator();
  private static final int d = j.a(150.0F);
  private static final long[] e = { 0L };
  
  private static c a(float paramFloat1, float paramFloat2, long paramLong, ViewGroup paramViewGroup, ArrayList paramArrayList)
  {
    ImageView localImageView = new ImageView(paramViewGroup.getContext());
    ae localae = new ae(null);
    localImageView.setImageDrawable(localae);
    paramViewGroup.addView(localImageView);
    paramArrayList.add(localImageView);
    float f1 = localae.getIntrinsicWidth() / 2.0F;
    float f2 = localae.getIntrinsicHeight() / 2.0F;
    com.b.c.a.a(localImageView, 1.0F);
    com.b.c.a.f(localImageView, paramFloat1 - f1);
    com.b.c.a.g(localImageView, paramFloat2 - f2);
    com.b.c.a.b(localImageView, 0.0F);
    com.b.c.a.c(localImageView, 0.0F);
    return c.a(localImageView).k(0.0F).g(1.0F).i(1.0F).a(c).a(900L).b(paramLong);
  }
  
  private static void a(float paramFloat1, float paramFloat2, final ViewGroup paramViewGroup, long... paramVarArgs)
  {
    int i = paramVarArgs.length;
    if (i == 0)
    {
      paramVarArgs = e;
      i = 1;
    }
    for (;;)
    {
      long l = 0L;
      ArrayList localArrayList = new ArrayList(i);
      int j = 0;
      c localc = null;
      while (j < i)
      {
        l += paramVarArgs[j];
        localc = a(paramFloat1, paramFloat2, l, paramViewGroup, localArrayList);
        j += 1;
      }
      localc.a(new b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          paramAnonymousa = ad.this.iterator();
          while (paramAnonymousa.hasNext())
          {
            View localView = (View)paramAnonymousa.next();
            paramViewGroup.removeView(localView);
          }
        }
      });
      return;
    }
  }
  
  public static void a(float paramFloat1, float paramFloat2, RelativeLayout paramRelativeLayout, long... paramVarArgs)
  {
    a(paramFloat1, paramFloat2, paramRelativeLayout, paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */