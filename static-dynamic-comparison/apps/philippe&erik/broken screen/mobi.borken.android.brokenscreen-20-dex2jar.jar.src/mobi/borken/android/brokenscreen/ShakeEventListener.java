package mobi.borken.android.brokenscreen;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class ShakeEventListener
  implements SensorEventListener
{
  private static final int MAX_PAUSE_BETHWEEN_DIRECTION_CHANGE = 200;
  private static final int MAX_TOTAL_DURATION_OF_SHAKE = 400;
  private static final int MIN_DIRECTION_CHANGE = 3;
  private static final int MIN_FORCE = 10;
  private float lastX = 0.0F;
  private float lastY = 0.0F;
  private float lastZ = 0.0F;
  private int mDirectionChangeCount = 0;
  private long mFirstDirectionChangeTime = 0L;
  private long mLastDirectionChangeTime;
  private OnShakeListener mShakeListener;
  
  private void resetShakeParameters()
  {
    this.mFirstDirectionChangeTime = 0L;
    this.mDirectionChangeCount = 0;
    this.mLastDirectionChangeTime = 0L;
    this.lastX = 0.0F;
    this.lastY = 0.0F;
    this.lastZ = 0.0F;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (Math.abs(f1 + f2 + f3 - this.lastX - this.lastY - this.lastZ) > 10.0F)
    {
      long l = System.currentTimeMillis();
      if (this.mFirstDirectionChangeTime == 0L)
      {
        this.mFirstDirectionChangeTime = l;
        this.mLastDirectionChangeTime = l;
      }
      if (l - this.mLastDirectionChangeTime >= 200L) {
        break label160;
      }
      this.mLastDirectionChangeTime = l;
      this.mDirectionChangeCount += 1;
      this.lastX = f1;
      this.lastY = f2;
      this.lastZ = f3;
      if ((this.mDirectionChangeCount >= 3) && (l - this.mFirstDirectionChangeTime < 400L))
      {
        this.mShakeListener.onShake();
        resetShakeParameters();
      }
    }
    return;
    label160:
    resetShakeParameters();
  }
  
  public void setOnShakeListener(OnShakeListener paramOnShakeListener)
  {
    this.mShakeListener = paramOnShakeListener;
  }
  
  public static abstract interface OnShakeListener
  {
    public abstract void onShake();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/brokenscreen/ShakeEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */