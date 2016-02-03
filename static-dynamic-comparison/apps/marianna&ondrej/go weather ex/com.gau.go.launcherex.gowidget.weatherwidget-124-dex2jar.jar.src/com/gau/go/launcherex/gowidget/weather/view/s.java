package com.gau.go.launcherex.gowidget.weather.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class s
  extends Animation
{
  private int b;
  private int c;
  private StringBuffer d;
  
  public s(Clock paramClock, int paramInt)
  {
    this.b = paramInt;
    this.c = (paramInt % 12 * 30);
    this.d = new StringBuffer();
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.d.setLength(0);
    Clock.a(this.a, (int)(this.c + 30.0F * paramFloat));
    Clock.b(this.a, (int)(360.0F * paramFloat));
    int i;
    int j;
    int k;
    if (Clock.a(this.a) != null)
    {
      i = this.b;
      j = Clock.b(this.a) / 360 + i;
      k = (int)(60.0F * paramFloat) % 60;
      if (k != 0) {
        break label165;
      }
      paramTransformation = this.d;
      if (j != 12) {
        break label156;
      }
      i = 12;
      paramTransformation.append(String.valueOf(i)).append(":00");
      if (j < 12) {
        break label270;
      }
      this.d.append(" PM");
    }
    for (;;)
    {
      Clock.a(this.a).setText(this.d.toString());
      this.a.invalidate();
      return;
      label156:
      i = j % 12;
      break;
      label165:
      if (k < 10)
      {
        paramTransformation = this.d;
        if (j == 12) {}
        for (i = 12;; i = j % 12)
        {
          paramTransformation.append(String.valueOf(i)).append(":0").append(String.valueOf(k));
          break;
        }
      }
      paramTransformation = this.d;
      if (j == 12) {}
      for (i = 12;; i = j % 12)
      {
        paramTransformation.append(String.valueOf(i)).append(":").append(String.valueOf(k));
        break;
      }
      label270:
      this.d.append(" AM");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */