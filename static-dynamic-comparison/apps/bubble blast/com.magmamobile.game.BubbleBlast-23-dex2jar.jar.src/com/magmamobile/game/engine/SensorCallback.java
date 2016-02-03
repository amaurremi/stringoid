package com.magmamobile.game.engine;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

final class SensorCallback
  implements SensorEventListener
{
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    Game.onSensorAccuracyChanged(paramSensor, paramInt);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    Game.onSensorChanged(paramSensorEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/SensorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */