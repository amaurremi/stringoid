package com.greystripe.sdk;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

final class b
  implements SensorEventListener
{
  private b(a parama) {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (a.a(this.a) == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("try {AccelerometerHandler.onSensorChanged(");
    localStringBuilder.append("[");
    localStringBuilder.append(-paramSensorEvent.values[0]);
    localStringBuilder.append(", ");
    localStringBuilder.append(-paramSensorEvent.values[1]);
    localStringBuilder.append(", ");
    localStringBuilder.append(-paramSensorEvent.values[2]);
    localStringBuilder.append("]");
    localStringBuilder.append(");} catch(err) {Log.d('AccelerometerListener#onSensorChanged: ' + err);}");
    a.a(this.a).b(localStringBuilder.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */