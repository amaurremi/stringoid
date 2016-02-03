package com.go.weatherex.home.rain;

import android.util.SparseArray;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;

class e
  extends Animation
{
  private float b;
  
  public e(ForecastRainProbabilityGraphs paramForecastRainProbabilityGraphs, float paramFloat)
  {
    this.b = paramFloat;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if ((ForecastRainProbabilityGraphs.a(this.a) != null) && (ForecastRainProbabilityGraphs.a(this.a).size() > 0))
    {
      int j = ForecastRainProbabilityGraphs.b(this.a).size();
      int i = 0;
      if (i < j)
      {
        paramTransformation = (f)ForecastRainProbabilityGraphs.b(this.a).get(i);
        float f = paramTransformation.j() * ForecastRainProbabilityGraphs.c(this.a);
        if (paramFloat >= f) {
          if (paramTransformation.k() == 0.0F)
          {
            paramTransformation.d(0);
            paramTransformation.a(1.0F);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          f = (paramFloat - f) / paramTransformation.k();
          if (f < 1.0F)
          {
            paramTransformation.d((int)(paramTransformation.d() * f));
            paramTransformation.a(f);
          }
          else if (!paramTransformation.l())
          {
            if ((paramTransformation.d() > 0) && (paramFloat < 1.0F)) {
              if (paramTransformation.i()) {
                if (paramTransformation.h() < ForecastRainProbabilityGraphs.d(this.a))
                {
                  paramTransformation.b(paramTransformation.h() + ForecastRainProbabilityGraphs.e(this.a));
                  label201:
                  paramTransformation.d(paramTransformation.d() + (int)paramTransformation.h());
                }
              }
            }
            for (;;)
            {
              paramTransformation.a(1.0F);
              break;
              paramTransformation.a(false);
              break label201;
              if (paramTransformation.h() > 0.0F)
              {
                paramTransformation.b(paramTransformation.h() - ForecastRainProbabilityGraphs.e(this.a));
                break label201;
              }
              paramTransformation.b(true);
              break label201;
              paramTransformation.d(paramTransformation.d());
            }
            paramTransformation.d(0);
            paramTransformation.a(0.0F);
          }
        }
      }
      if (paramFloat != 1.0F) {
        break label367;
      }
      i = 0;
      while (i < ForecastRainProbabilityGraphs.b(this.a).size())
      {
        paramTransformation = (f)ForecastRainProbabilityGraphs.b(this.a).get(i);
        if (paramTransformation != null)
        {
          paramTransformation.e(0);
          paramTransformation.b(0.0F);
          paramTransformation.a(1.0F);
        }
        i += 1;
      }
      this.a.invalidate();
    }
    label367:
    while (ForecastRainProbabilityGraphs.a < 11) {
      return;
    }
    this.a.invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/rain/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */