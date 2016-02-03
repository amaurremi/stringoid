package com.pocket.b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class g
  implements SensorEventListener
{
  private final Context a;
  private SensorManager b;
  private Sensor c;
  private h d;
  private final float[] e = new float[2];
  private Display f;
  private Configuration g;
  private float h;
  private final DisplayMetrics i = new DisplayMetrics();
  private float j;
  
  public g(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(float[] paramArrayOfFloat, int paramInt, float paramFloat)
  {
    paramArrayOfFloat[paramInt] = Math.min(Math.max(paramArrayOfFloat[paramInt], -paramFloat), paramFloat);
  }
  
  public void a()
  {
    this.g = this.a.getResources().getConfiguration();
    this.f = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    this.f.getMetrics(this.i);
    this.j = this.i.density;
    b();
  }
  
  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public boolean a(h paramh)
  {
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    this.c = localSensorManager.getDefaultSensor(4);
    if (this.c == null) {
      return false;
    }
    this.d = paramh;
    this.b = localSensorManager;
    a();
    localSensorManager.registerListener(this, this.c, 1);
    return true;
  }
  
  public void b()
  {
    this.e[0] = 0.0F;
    this.e[1] = 0.0F;
    if (this.d != null) {
      this.d.a(this.e);
    }
  }
  
  public void c()
  {
    if (this.b != null) {
      this.b.unregisterListener(this);
    }
    this.g = null;
    this.f = null;
    this.d = null;
    this.c = null;
    this.b = null;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.b == null) {
      return;
    }
    int k = this.g.orientation;
    int m = this.f.getRotation();
    float f3 = paramSensorEvent.values[0];
    float f4 = paramSensorEvent.values[1];
    float f2;
    float f1;
    if (k == 2) {
      if (m == 3)
      {
        f2 = -f3;
        f1 = f4;
      }
    }
    for (;;)
    {
      f3 = this.j * 0.2F;
      paramSensorEvent = this.e;
      paramSensorEvent[0] = (f2 * f3 + paramSensorEvent[0]);
      paramSensorEvent = this.e;
      paramSensorEvent[1] = (f1 * f3 + paramSensorEvent[1]);
      if (this.h != 0.0F)
      {
        a(this.e, 0, this.h);
        a(this.e, 1, this.h);
      }
      this.d.a(this.e);
      return;
      f1 = f4;
      f2 = f3;
      if (m == 1)
      {
        f1 = -f4;
        f2 = f3;
        continue;
        f1 = f4;
        f2 = f3;
        if (k == 1)
        {
          f1 = f4;
          f2 = f3;
          if (m == 0)
          {
            f2 = f4;
            f1 = f3;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */