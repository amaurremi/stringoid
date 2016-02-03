package com.e.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class a
  implements SensorEventListener
{
  private final e a = new e();
  private final b b;
  private SensorManager c;
  private Sensor d;
  
  public a(b paramb)
  {
    this.b = paramb;
  }
  
  private boolean a(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    return Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3) > 13.0D;
  }
  
  public void a()
  {
    if (this.d != null)
    {
      this.c.unregisterListener(this, this.d);
      this.c = null;
      this.d = null;
    }
  }
  
  public boolean a(SensorManager paramSensorManager)
  {
    if (this.d != null) {}
    do
    {
      return true;
      this.d = paramSensorManager.getDefaultSensor(1);
      if (this.d != null)
      {
        this.c = paramSensorManager;
        paramSensorManager.registerListener(this, this.d, 0);
      }
    } while (this.d != null);
    return false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool = a(paramSensorEvent);
    long l = paramSensorEvent.timestamp;
    this.a.a(l, bool);
    if (this.a.b())
    {
      this.a.a();
      this.b.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */