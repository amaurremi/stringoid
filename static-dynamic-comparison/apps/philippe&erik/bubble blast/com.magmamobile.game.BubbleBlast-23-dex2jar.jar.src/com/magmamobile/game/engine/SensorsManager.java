package com.magmamobile.game.engine;

import android.hardware.SensorManager;
import android.util.SparseArray;

public final class SensorsManager
{
  protected static boolean enabled;
  protected static SensorCallback sensorListener;
  protected static SensorManager sensorMgr;
  protected static SparseArray<SensorInfo> sensors;
  
  public static void disable(int paramInt)
  {
    SensorInfo localSensorInfo = (SensorInfo)sensors.get(paramInt);
    if ((localSensorInfo != null) && (enabled))
    {
      sensors.remove(paramInt);
      if (localSensorInfo.activated)
      {
        localSensorInfo.activated = false;
        sensorMgr.unregisterListener(sensorListener, localSensorInfo.sensor);
      }
    }
  }
  
  public static void enable(int paramInt)
  {
    SensorInfo localSensorInfo2 = (SensorInfo)sensors.get(paramInt);
    SensorInfo localSensorInfo1 = localSensorInfo2;
    if (localSensorInfo2 == null)
    {
      localSensorInfo1 = new SensorInfo();
      localSensorInfo1.sensor = sensorMgr.getDefaultSensor(paramInt);
      localSensorInfo1.activated = false;
      sensors.append(paramInt, localSensorInfo1);
    }
    if ((enabled) && (!localSensorInfo1.activated))
    {
      localSensorInfo1.activated = true;
      sensorMgr.registerListener(sensorListener, localSensorInfo1.sensor, 1);
    }
  }
  
  protected static void onInitialize()
  {
    if (Game.parameters.USE_SENSORS)
    {
      sensorListener = new SensorCallback();
      sensors = new SparseArray();
      sensorMgr = (SensorManager)Game.activity.getSystemService("sensor");
    }
  }
  
  protected static void onPause()
  {
    int j;
    int i;
    if (sensorMgr != null)
    {
      j = sensors.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        enabled = false;
        return;
      }
      SensorInfo localSensorInfo = (SensorInfo)sensors.valueAt(i);
      if (localSensorInfo.activated)
      {
        sensorMgr.unregisterListener(sensorListener, localSensorInfo.sensor);
        localSensorInfo.activated = false;
      }
      i += 1;
    }
  }
  
  protected static void onResume()
  {
    int j;
    int i;
    if (sensorMgr != null)
    {
      j = sensors.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        enabled = true;
        return;
      }
      SensorInfo localSensorInfo = (SensorInfo)sensors.valueAt(i);
      if (!localSensorInfo.activated)
      {
        sensorMgr.registerListener(sensorListener, localSensorInfo.sensor, 1);
        localSensorInfo.activated = true;
      }
      i += 1;
    }
  }
  
  protected static void onTerminate() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/SensorsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */