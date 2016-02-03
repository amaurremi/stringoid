package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.FloatMath;
import org.json.JSONException;
import org.json.JSONObject;

final class z
  implements SensorEventListener
{
  private long a = 0L;
  private long b;
  private int c = 0;
  private Handler d;
  private Runnable e;
  private boolean f = false;
  private int g;
  private int h;
  private boolean i = true;
  
  public z(AdController paramAdController, boolean paramBoolean)
  {
    if (this.i)
    {
      this.d = new Handler();
      this.e = new A(this, paramAdController);
    }
  }
  
  private void d()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0;
  }
  
  private void e()
  {
    this.f = false;
    AdController.d(this.j, false);
    AdController.D(this.j).unregisterListener(this);
    AdLog.i("LBAdController", "shake event detection disabled");
  }
  
  public final void a()
  {
    this.d.postDelayed(this.e, this.h);
  }
  
  public final void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void b()
  {
    this.f = true;
    AdController.D(this.j).registerListener(this, AdController.D(this.j).getDefaultSensor(1), 1);
    AdLog.i("LBAdController", "shake event detection enabled");
  }
  
  public final void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void c()
  {
    if (this.f)
    {
      e();
      this.d.removeCallbacks(this.e);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    AdController.a(this.j, AdController.E(this.j));
    AdController.b(this.j, FloatMath.sqrt(f1 * f1 + f2 * f2 + f3 * f3));
    f1 = AdController.E(this.j);
    f2 = AdController.F(this.j);
    AdController.c(this.j, f1 - f2 + AdController.G(this.j) * 0.9F);
    if (AdController.G(this.j) > 2.5F)
    {
      long l = System.currentTimeMillis();
      if (this.a == 0L)
      {
        this.a = l;
        this.b = l;
      }
      if (l - this.b < 300L)
      {
        this.b = l;
        this.c += 1;
        if ((this.c >= this.g) && (l - this.a < 1500L))
        {
          AdLog.i("LBAdController", "valid shake");
          d();
          e();
          if (this.i)
          {
            if ((AdController.C(this.j) != null) && (AdController.C(this.j).isPlaying()))
            {
              AdController.C(this.j).stop();
              AdController.a(this.j, null);
              if (AdController.z(this.j) != null) {
                AdController.z(this.j).onAdFinished();
              }
              AdController.B(this.j).setStreamVolume(3, AdController.A(this.j), 8);
            }
            this.d.removeCallbacks(this.e);
          }
        }
      }
    }
    else
    {
      try
      {
        this.j.destroyAd();
        AdLog.d("LBAdController", "showing audio ad in browser");
        if (AdController.z(this.j) != null) {
          AdController.z(this.j).onAdClicked();
        }
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(AdController.o(this.j).getString("adurl")));
        localIntent.addFlags(268435456);
        if (AdController.l(this.j) != null) {}
        for (paramSensorEvent = AdController.l(this.j);; paramSensorEvent = this.j.a)
        {
          paramSensorEvent.startActivity(localIntent);
          return;
        }
        d();
        return;
      }
      catch (JSONException paramSensorEvent) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */