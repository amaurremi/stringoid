package org.osmdroid.views.overlay.compass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class InternalCompassOrientationProvider
  implements SensorEventListener, IOrientationProvider
{
  private float mAzimuth;
  private IOrientationConsumer mOrientationConsumer;
  private final SensorManager mSensorManager;
  
  public InternalCompassOrientationProvider(Context paramContext)
  {
    this.mSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  public float getLastKnownOrientation()
  {
    return this.mAzimuth;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((paramSensorEvent.sensor.getType() == 3) && (paramSensorEvent.values != null))
    {
      this.mAzimuth = paramSensorEvent.values[0];
      if (this.mOrientationConsumer != null) {
        this.mOrientationConsumer.onOrientationChanged(this.mAzimuth, this);
      }
    }
  }
  
  public boolean startOrientationProvider(IOrientationConsumer paramIOrientationConsumer)
  {
    this.mOrientationConsumer = paramIOrientationConsumer;
    boolean bool = false;
    paramIOrientationConsumer = this.mSensorManager.getDefaultSensor(3);
    if (paramIOrientationConsumer != null) {
      bool = this.mSensorManager.registerListener(this, paramIOrientationConsumer, 2);
    }
    return bool;
  }
  
  public void stopOrientationProvider()
  {
    this.mSensorManager.unregisterListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/compass/InternalCompassOrientationProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */