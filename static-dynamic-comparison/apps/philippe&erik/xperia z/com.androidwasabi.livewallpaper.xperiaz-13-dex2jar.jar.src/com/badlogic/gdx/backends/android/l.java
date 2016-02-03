package com.badlogic.gdx.backends.android;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class l
  implements SensorEventListener
{
  final float[] a;
  final float[] b;
  final com.badlogic.gdx.l c;
  
  l(j paramj, com.badlogic.gdx.l paraml, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.a = paramArrayOfFloat1;
    this.b = paramArrayOfFloat2;
    this.c = paraml;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      if (this.c != com.badlogic.gdx.l.b) {
        break label69;
      }
      System.arraycopy(paramSensorEvent.values, 0, this.a, 0, this.a.length);
    }
    for (;;)
    {
      if (paramSensorEvent.sensor.getType() == 2) {
        System.arraycopy(paramSensorEvent.values, 0, this.b, 0, this.b.length);
      }
      return;
      label69:
      this.a[0] = paramSensorEvent.values[1];
      this.a[1] = (-paramSensorEvent.values[0]);
      this.a[2] = paramSensorEvent.values[2];
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */