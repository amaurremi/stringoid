package com.jiubang.core.a;

import android.content.Context;
import android.hardware.SensorEvent;
import android.view.Display;
import android.view.WindowManager;

public class d
{
  private float[] a = new float[3];
  private float b = 2.5F;
  private float c = 0.5F;
  
  public final float[] a(Context paramContext, SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent == null) || (paramSensorEvent.values.length < 3) || (paramSensorEvent.values[0] == 0.0F) || (paramSensorEvent.values[1] == 0.0F) || (paramSensorEvent.values[2] == 0.0F)) {
      return null;
    }
    switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      this.a[0] = paramSensorEvent.values[0];
      this.a[1] = (-paramSensorEvent.values[1]);
      this.a[2] = (-paramSensorEvent.values[2]);
    }
    for (;;)
    {
      paramContext = this.a;
      paramContext[1] /= 60.0F;
      paramContext = this.a;
      paramContext[2] /= 60.0F;
      paramContext = this.a;
      paramContext[1] -= this.c;
      paramContext = this.a;
      paramContext[1] *= this.b;
      paramContext = this.a;
      paramContext[2] *= this.b;
      if (this.a[1] > 1.0F) {
        this.a[1] = 1.0F;
      }
      if (this.a[1] < -1.0F) {
        this.a[1] = -1.0F;
      }
      if (this.a[2] > 1.0F) {
        this.a[2] = 1.0F;
      }
      if (this.a[2] < -1.0F) {
        this.a[2] = -1.0F;
      }
      return this.a;
      this.a[0] = paramSensorEvent.values[0];
      this.a[1] = paramSensorEvent.values[2];
      this.a[2] = (-paramSensorEvent.values[1]);
      continue;
      this.a[0] = paramSensorEvent.values[0];
      this.a[1] = paramSensorEvent.values[1];
      this.a[2] = paramSensorEvent.values[2];
      continue;
      this.a[0] = paramSensorEvent.values[0];
      this.a[1] = (-paramSensorEvent.values[2]);
      this.a[2] = paramSensorEvent.values[1];
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */