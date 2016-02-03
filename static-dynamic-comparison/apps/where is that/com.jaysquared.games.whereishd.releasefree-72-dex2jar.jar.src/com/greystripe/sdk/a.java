package com.greystripe.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.webkit.JavascriptInterface;

final class a
{
  private SensorManager a;
  private Sensor b;
  private b c;
  private aa d;
  private boolean e;
  
  public a(Context paramContext, aa paramaa)
  {
    this.d = paramaa;
    this.c = new b(this, (byte)0);
    this.e = false;
    this.a = ((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  /* Error */
  @JavascriptInterface
  public final void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/greystripe/sdk/a:d	Lcom/greystripe/sdk/aa;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 30	com/greystripe/sdk/a:e	Z
    //   18: ifne -7 -> 11
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 42	com/greystripe/sdk/a:a	Landroid/hardware/SensorManager;
    //   26: iconst_1
    //   27: invokevirtual 50	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   30: putfield 52	com/greystripe/sdk/a:b	Landroid/hardware/Sensor;
    //   33: aload_0
    //   34: getfield 42	com/greystripe/sdk/a:a	Landroid/hardware/SensorManager;
    //   37: aload_0
    //   38: getfield 28	com/greystripe/sdk/a:c	Lcom/greystripe/sdk/b;
    //   41: aload_0
    //   42: getfield 52	com/greystripe/sdk/a:b	Landroid/hardware/Sensor;
    //   45: iconst_1
    //   46: invokevirtual 56	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   49: pop
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 30	com/greystripe/sdk/a:e	Z
    //   55: goto -44 -> 11
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   6	2	1	localaa	aa
    //   58	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	58	finally
    //   14	55	58	finally
  }
  
  @JavascriptInterface
  public final void stop()
  {
    if (this.a != null)
    {
      this.a.unregisterListener(this.c);
      this.e = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */