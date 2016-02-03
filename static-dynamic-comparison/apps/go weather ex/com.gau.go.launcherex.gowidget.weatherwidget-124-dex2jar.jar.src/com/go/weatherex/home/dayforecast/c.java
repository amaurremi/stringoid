package com.go.weatherex.home.dayforecast;

import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class c
  extends Animation
{
  private c(ColumnGraphs paramColumnGraphs) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (ColumnGraphs.a(this.a))
    {
      int i = 0;
      if (i < ColumnGraphs.b(this.a).size())
      {
        paramTransformation = (b)ColumnGraphs.b(this.a).get(i);
        float f = paramTransformation.h() * 0.2F;
        if ((paramFloat >= f) && (paramTransformation.i() > 0.0F))
        {
          f = (paramFloat - f) / paramTransformation.i();
          if (f >= 1.0F) {
            break label108;
          }
          paramTransformation.a(f);
          paramTransformation.b(f * (paramTransformation.c() / 2.0F));
        }
        label108:
        while (paramTransformation.l())
        {
          i += 1;
          break;
        }
        if (paramFloat < 1.0F)
        {
          if (!paramTransformation.k()) {
            break label180;
          }
          if (paramTransformation.j() >= ColumnGraphs.c(this.a)) {
            break label172;
          }
          paramTransformation.e(paramTransformation.j() + 0.1F);
        }
        for (;;)
        {
          paramTransformation.b(paramTransformation.c() / 2.0F);
          paramTransformation.a(1.0F);
          break;
          label172:
          paramTransformation.b(false);
          continue;
          label180:
          if (paramTransformation.j() > 0.0F) {
            paramTransformation.e(paramTransformation.j() - 0.1F);
          } else {
            paramTransformation.c(true);
          }
        }
      }
      this.a.invalidate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */