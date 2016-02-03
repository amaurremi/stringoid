package com.tapjoy.mraid.listener;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tapjoy.mraid.controller.MraidSensor;
import java.util.List;

public class Accel
  implements SensorEventListener
{
  private static final int FORCE_THRESHOLD = 1000;
  private static final int SHAKE_COUNT = 2;
  private static final int SHAKE_DURATION = 2000;
  private static final int SHAKE_TIMEOUT = 500;
  private static final int TIME_THRESHOLD = 100;
  private boolean bAccReady;
  private boolean bMagReady;
  private float[] mAccVals = { 0.0F, 0.0F, 0.0F };
  private float[] mActualOrientation = { -1.0F, -1.0F, -1.0F };
  String mKey;
  private float[] mLastAccVals = { 0.0F, 0.0F, 0.0F };
  private long mLastForce;
  private long mLastShake;
  private long mLastTime;
  private float[] mMagVals;
  MraidSensor mSensorController;
  private int mSensorDelay = 3;
  private int mShakeCount;
  int registeredHeadingListeners = 0;
  int registeredShakeListeners = 0;
  int registeredTiltListeners = 0;
  private SensorManager sensorManager;
  
  public Accel(Context paramContext, MraidSensor paramMraidSensor)
  {
    this.mSensorController = paramMraidSensor;
    this.sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  private void start()
  {
    List localList = this.sensorManager.getSensorList(1);
    if (localList.size() > 0) {
      this.sensorManager.registerListener(this, (Sensor)localList.get(0), this.mSensorDelay);
    }
  }
  
  private void startMag()
  {
    List localList = this.sensorManager.getSensorList(2);
    if (localList.size() > 0)
    {
      this.sensorManager.registerListener(this, (Sensor)localList.get(0), this.mSensorDelay);
      start();
    }
  }
  
  public float getHeading()
  {
    return this.mActualOrientation[0];
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      if ((this.mMagVals != null) && (this.mAccVals != null) && (this.bAccReady) && (this.bMagReady))
      {
        this.bAccReady = false;
        this.bMagReady = false;
        float[] arrayOfFloat = new float[9];
        SensorManager.getRotationMatrix(arrayOfFloat, new float[9], this.mAccVals, this.mMagVals);
        this.mActualOrientation = new float[3];
        SensorManager.getOrientation(arrayOfFloat, this.mActualOrientation);
        this.mSensorController.onHeadingChange(this.mActualOrientation[0]);
      }
      if (paramSensorEvent.sensor.getType() == 1)
      {
        long l1 = System.currentTimeMillis();
        if (l1 - this.mLastForce > 500L) {
          this.mShakeCount = 0;
        }
        if (l1 - this.mLastTime > 100L)
        {
          long l2 = this.mLastTime;
          if (Math.abs(this.mAccVals[0] + this.mAccVals[1] + this.mAccVals[2] - this.mLastAccVals[0] - this.mLastAccVals[1] - this.mLastAccVals[2]) / (float)(l1 - l2) * 10000.0F > 1000.0F)
          {
            int i = this.mShakeCount + 1;
            this.mShakeCount = i;
            if ((i >= 2) && (l1 - this.mLastShake > 2000L))
            {
              this.mLastShake = l1;
              this.mShakeCount = 0;
              this.mSensorController.onShake();
            }
            this.mLastForce = l1;
          }
          this.mLastTime = l1;
          this.mSensorController.onTilt(this.mAccVals[0], this.mAccVals[1], this.mAccVals[2]);
        }
      }
      return;
      this.mMagVals = ((float[])paramSensorEvent.values.clone());
      this.bMagReady = true;
      continue;
      this.mLastAccVals = this.mAccVals;
      this.mAccVals = ((float[])paramSensorEvent.values.clone());
      this.bAccReady = true;
    }
  }
  
  public void setSensorDelay(int paramInt)
  {
    this.mSensorDelay = paramInt;
    if ((this.registeredTiltListeners > 0) || (this.registeredShakeListeners > 0))
    {
      stop();
      start();
    }
  }
  
  public void startTrackingHeading()
  {
    if (this.registeredHeadingListeners == 0) {
      startMag();
    }
    this.registeredHeadingListeners += 1;
  }
  
  public void startTrackingShake()
  {
    if (this.registeredShakeListeners == 0)
    {
      setSensorDelay(1);
      start();
    }
    this.registeredShakeListeners += 1;
  }
  
  public void startTrackingTilt()
  {
    if (this.registeredTiltListeners == 0) {
      start();
    }
    this.registeredTiltListeners += 1;
  }
  
  public void stop()
  {
    if ((this.registeredHeadingListeners == 0) && (this.registeredShakeListeners == 0) && (this.registeredTiltListeners == 0)) {
      this.sensorManager.unregisterListener(this);
    }
  }
  
  public void stopAllListeners()
  {
    this.registeredTiltListeners = 0;
    this.registeredShakeListeners = 0;
    this.registeredHeadingListeners = 0;
    try
    {
      stop();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopTrackingHeading()
  {
    if (this.registeredHeadingListeners > 0)
    {
      int i = this.registeredHeadingListeners - 1;
      this.registeredHeadingListeners = i;
      if (i == 0) {
        stop();
      }
    }
  }
  
  public void stopTrackingShake()
  {
    if (this.registeredShakeListeners > 0)
    {
      int i = this.registeredShakeListeners - 1;
      this.registeredShakeListeners = i;
      if (i == 0)
      {
        setSensorDelay(3);
        stop();
      }
    }
  }
  
  public void stopTrackingTilt()
  {
    if (this.registeredTiltListeners > 0)
    {
      int i = this.registeredTiltListeners - 1;
      this.registeredTiltListeners = i;
      if (i == 0) {
        stop();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/listener/Accel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */