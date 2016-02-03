package com.tapjoy.mraid.controller;

import android.content.Context;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.Accel;
import com.tapjoy.mraid.view.MraidView;

public class MraidSensor
  extends Abstract
{
  private static final String TAG = "MRAID Sensor";
  final int INTERVAL = 1000;
  private Accel mAccel = new Accel(paramContext, this);
  private float mLastX = 0.0F;
  private float mLastY = 0.0F;
  private float mLastZ = 0.0F;
  
  public MraidSensor(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
  }
  
  public float getHeading()
  {
    TapjoyLog.d("MRAID Sensor", "getHeading: " + this.mAccel.getHeading());
    return this.mAccel.getHeading();
  }
  
  public String getTilt()
  {
    String str = "{ x : \"" + this.mLastX + "\", y : \"" + this.mLastY + "\", z : \"" + this.mLastZ + "\"}";
    TapjoyLog.d("MRAID Sensor", "getTilt: " + str);
    return str;
  }
  
  public void onHeadingChange(float paramFloat)
  {
    String str = "window.mraidview.fireChangeEvent({ heading: " + (int)(paramFloat * 57.29577951308232D) + "});";
    TapjoyLog.d("MRAID Sensor", str);
    this.mMraidView.injectMraidJavaScript(str);
  }
  
  public void onShake()
  {
    this.mMraidView.injectMraidJavaScript("mraid.gotShake()");
  }
  
  public void onTilt(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mLastX = paramFloat1;
    this.mLastY = paramFloat2;
    this.mLastZ = paramFloat3;
    String str = "window.mraidview.fireChangeEvent({ tilt: " + getTilt() + "})";
    TapjoyLog.d("MRAID Sensor", str);
    this.mMraidView.injectMraidJavaScript(str);
  }
  
  public void startHeadingListener()
  {
    this.mAccel.startTrackingHeading();
  }
  
  public void startShakeListener()
  {
    this.mAccel.startTrackingShake();
  }
  
  public void startTiltListener()
  {
    this.mAccel.startTrackingTilt();
  }
  
  void stop() {}
  
  public void stopAllListeners()
  {
    this.mAccel.stopAllListeners();
  }
  
  public void stopHeadingListener()
  {
    this.mAccel.stopTrackingHeading();
  }
  
  public void stopShakeListener()
  {
    this.mAccel.stopTrackingShake();
  }
  
  public void stopTiltListener()
  {
    this.mAccel.stopTrackingTilt();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/MraidSensor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */