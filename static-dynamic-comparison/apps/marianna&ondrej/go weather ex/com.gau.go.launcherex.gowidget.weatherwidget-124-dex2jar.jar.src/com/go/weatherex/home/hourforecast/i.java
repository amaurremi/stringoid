package com.go.weatherex.home.hourforecast;

import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class i
  extends Animation
{
  private i(TrendGraphs paramTrendGraphs) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i;
    if ((TrendGraphs.a(this.a)) && (paramFloat < 1.0F))
    {
      TrendGraphs.a(this.a, TrendGraphs.b(this.a) * paramFloat * 2.0F);
      if (TrendGraphs.c(this.a) > TrendGraphs.b(this.a))
      {
        int j = 0;
        int k = 0;
        i = 0;
        if (j < TrendGraphs.d(this.a).size())
        {
          paramTransformation = (h)TrendGraphs.d(this.a).get(j);
          int m = k;
          int n = i;
          if (paramTransformation != null)
          {
            if (!paramTransformation.d()) {
              break label133;
            }
            n = i;
            m = k;
          }
          for (;;)
          {
            j += 1;
            k = m;
            i = n;
            break;
            label133:
            if ((i == 0) && (paramTransformation.a() == TrendGraphs.e(this.a)))
            {
              m = k;
              n = i;
              if (TrendGraphs.c(this.a) >= TrendGraphs.b(this.a) * 1.4F)
              {
                TrendGraphs.a(this.a, paramTransformation);
                n = 1;
                m = k;
              }
            }
            else
            {
              m = k;
              n = i;
              if (k == 0)
              {
                m = k;
                n = i;
                if (paramTransformation.a() == TrendGraphs.f(this.a))
                {
                  TrendGraphs.a(this.a, paramTransformation);
                  m = 1;
                  n = i;
                }
              }
            }
          }
        }
      }
    }
    else if (paramFloat == 1.0F)
    {
      TrendGraphs.a(this.a, TrendGraphs.b(this.a) * 2.0F);
      i = 0;
      if (i < TrendGraphs.d(this.a).size())
      {
        paramTransformation = (h)TrendGraphs.d(this.a).get(i);
        if (paramTransformation == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramTransformation.a(0.0F);
        }
      }
    }
    this.a.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/hourforecast/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */