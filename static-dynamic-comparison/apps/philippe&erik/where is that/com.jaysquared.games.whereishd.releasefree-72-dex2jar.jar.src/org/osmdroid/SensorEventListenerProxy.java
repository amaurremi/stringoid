package org.osmdroid;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorEventListenerProxy
  implements SensorEventListener
{
  private SensorEventListener mListener = null;
  private final SensorManager mSensorManager;
  
  public SensorEventListenerProxy(SensorManager paramSensorManager)
  {
    this.mSensorManager = paramSensorManager;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.onAccuracyChanged(paramSensor, paramInt);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.mListener != null) {
      this.mListener.onSensorChanged(paramSensorEvent);
    }
  }
  
  public boolean startListening(SensorEventListener paramSensorEventListener, int paramInt1, int paramInt2)
  {
    Sensor localSensor = this.mSensorManager.getDefaultSensor(paramInt1);
    if (localSensor == null) {
      return false;
    }
    this.mListener = paramSensorEventListener;
    return this.mSensorManager.registerListener(this, localSensor, paramInt2);
  }
  
  public void stopListening()
  {
    this.mListener = null;
    this.mSensorManager.unregisterListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/SensorEventListenerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */