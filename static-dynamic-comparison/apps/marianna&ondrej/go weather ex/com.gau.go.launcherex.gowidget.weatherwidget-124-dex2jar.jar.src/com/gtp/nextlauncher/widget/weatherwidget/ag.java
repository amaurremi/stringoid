package com.gtp.nextlauncher.widget.weatherwidget;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class ag
  implements SensorEventListener
{
  private float b;
  private float c;
  private float d = 1.0F;
  private float e;
  
  ag(WeatherTrendView paramWeatherTrendView) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = 0;
    if (this.a.mCubeViewDrawingCacheEnabled) {
      return;
    }
    if (WeatherTrendView.access$000(this.a) == 0)
    {
      this.b = (-paramSensorEvent.values[0]);
      label34:
      if (Math.abs(this.b - this.c) > 0.05F)
      {
        this.c = (this.c * 0.85F + this.b * 0.15F);
        if (Math.abs(this.c) > this.d)
        {
          this.e = this.c;
          if (this.c >= 0.0F) {
            break label231;
          }
        }
      }
    }
    label231:
    for (this.e = (this.c + this.d);; this.e = (this.c - this.d))
    {
      paramSensorEvent = WeatherTrendView.access$100(this.a);
      int j = paramSensorEvent.length;
      while (i < j)
      {
        Object localObject = paramSensorEvent[i];
        if (localObject != null) {
          ((TemperatureCubeView)localObject).updateAngleByAccelerometer(this.e);
        }
        i += 1;
      }
      break;
      if (WeatherTrendView.access$000(this.a) == 1)
      {
        this.b = paramSensorEvent.values[1];
        break label34;
      }
      if (WeatherTrendView.access$000(this.a) == 2)
      {
        this.b = paramSensorEvent.values[0];
        break label34;
      }
      if (WeatherTrendView.access$000(this.a) != 3) {
        break label34;
      }
      this.b = (-paramSensorEvent.values[1]);
      break label34;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */