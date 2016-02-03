package com.badlogic.gdx.backends.android.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.badlogic.gdx.l;

class h
  implements SensorEventListener
{
  final float[] a;
  final float[] b;
  final l c;
  
  h(f paramf, l paraml, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
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
      f.a(this.d, paramSensorEvent.timestamp);
      System.arraycopy(paramSensorEvent.values, 0, this.a, 0, this.a.length);
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      System.arraycopy(paramSensorEvent.values, 0, this.b, 0, this.b.length);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */