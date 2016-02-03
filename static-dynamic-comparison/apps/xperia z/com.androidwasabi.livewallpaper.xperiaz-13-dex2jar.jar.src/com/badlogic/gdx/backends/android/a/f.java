package com.badlogic.gdx.backends.android.a;

import android.app.Application;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.service.wallpaper.WallpaperService;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.badlogic.gdx.j;
import com.badlogic.gdx.m;
import com.badlogic.gdx.o;
import com.badlogic.gdx.utils.p;
import java.util.ArrayList;
import java.util.List;

public final class f
  implements SensorEventListener, com.badlogic.gdx.k
{
  private String A = null;
  private m B = null;
  private boolean C = false;
  private final com.badlogic.gdx.l D;
  private long E = System.nanoTime();
  private long F = System.nanoTime();
  private SensorEventListener G;
  private SensorEventListener H;
  p<i> a = new g(this, 16, 1000);
  ArrayList<i> b = new ArrayList();
  int[] c = new int[20];
  int[] d = new int[20];
  int[] e = new int[20];
  int[] f = new int[20];
  boolean[] g = new boolean[20];
  int[] h = new int[0];
  public boolean i = false;
  final a j;
  final float[] k = new float[9];
  final float[] l = new float[3];
  private SensorManager m;
  private final float[] n = new float[3];
  private final l o;
  private int p = 0;
  private boolean q = false;
  private final Vibrator r;
  private boolean s = false;
  private final float[] t = new float[3];
  private float u = 0.0F;
  private float v = 0.0F;
  private float w = 0.0F;
  private boolean x = false;
  private o y;
  private final com.badlogic.gdx.backends.android.a z;
  
  public f(a parama, com.badlogic.gdx.backends.android.a parama1)
  {
    this.z = parama1;
    for (;;)
    {
      if (i1 >= this.h.length)
      {
        this.j = parama;
        this.p = parama1.k;
        this.o = new k();
        this.r = ((Vibrator)parama.f().getSystemService("vibrator"));
        i1 = e();
        parama = this.j.c.n();
        if (((i1 == 0) || (i1 == 180)) && ((parama.a < parama.b) && (((i1 != 90) && (i1 != 270)) || (parama.a > parama.b)))) {
          break;
        }
        this.D = com.badlogic.gdx.l.a;
        return;
      }
      this.h[i1] = -1;
      i1 += 1;
    }
    this.D = com.badlogic.gdx.l.b;
  }
  
  public long a()
  {
    return this.E;
  }
  
  public void a(o paramo)
  {
    try
    {
      this.y = paramo;
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      int i1 = this.g[paramInt];
      return i1;
    }
    finally {}
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    this.o.a(paramMotionEvent, this);
    if (this.p != 0) {}
    try
    {
      Thread.sleep(this.p);
      return true;
    }
    catch (InterruptedException paramMotionEvent)
    {
      for (;;) {}
    }
  }
  
  void b()
  {
    o localo;
    int i2;
    int i1;
    label44:
    label63:
    i locali2;
    try
    {
      this.x = false;
      if (this.y == null) {
        break label219;
      }
      localo = this.y;
      i2 = this.b.size();
      i1 = 0;
    }
    finally {}
    if (this.b.size() == 0)
    {
      i1 = 0;
      if (i1 < this.e.length) {}
    }
    else
    {
      this.b.clear();
      return;
      locali2 = (i)this.b.get(i1);
      this.E = locali2.a;
      switch (locali2.b)
      {
      }
    }
    for (;;)
    {
      this.a.a(locali2);
      i1 += 1;
      break label294;
      localo.a(locali2.c, locali2.d, locali2.e, 0);
      this.x = true;
      continue;
      ((o)localObject).b(locali2.c, locali2.d, locali2.e, 0);
      continue;
      ((o)localObject).a(locali2.c, locali2.d, locali2.e);
      continue;
      label219:
      i2 = this.b.size();
      i1 = 0;
      while (i1 < i2)
      {
        i locali1 = (i)this.b.get(i1);
        if (locali1.b == 0) {
          this.x = true;
        }
        this.a.a(locali1);
        i1 += 1;
      }
      this.e[0] = 0;
      this.f[0] = 0;
      i1 += 1;
      break label44;
      label294:
      if (i1 < i2) {
        break label63;
      }
      break;
    }
  }
  
  void c()
  {
    Sensor localSensor;
    if (this.z.i)
    {
      this.m = ((SensorManager)this.j.f().getSystemService("sensor"));
      if (this.m.getSensorList(1).size() == 0)
      {
        this.i = false;
        if (!this.z.j) {
          break label248;
        }
        if (this.m == null) {
          this.m = ((SensorManager)this.j.f().getSystemService("sensor"));
        }
        localSensor = this.m.getDefaultSensor(2);
        if (localSensor == null) {
          break label240;
        }
        this.s = this.i;
        if (this.s)
        {
          this.H = new h(this, this.D, this.n, this.t);
          this.s = this.m.registerListener(this.H, localSensor, 1);
        }
      }
    }
    for (;;)
    {
      com.badlogic.gdx.g.a.a("AndroidInput", "sensor listener setup");
      return;
      localSensor = (Sensor)this.m.getSensorList(1).get(0);
      this.G = new h(this, this.D, this.n, this.t);
      this.i = this.m.registerListener(this.G, localSensor, 1);
      break;
      this.i = false;
      break;
      label240:
      this.s = false;
      continue;
      label248:
      this.s = false;
    }
  }
  
  void d()
  {
    if (this.m != null)
    {
      if (this.G != null)
      {
        this.m.unregisterListener(this.G);
        this.G = null;
      }
      if (this.H != null)
      {
        this.m.unregisterListener(this.H);
        this.H = null;
      }
      this.m = null;
    }
    com.badlogic.gdx.g.a.a("AndroidInput", "sensor listener tear down");
  }
  
  public int e()
  {
    switch (((WindowManager)this.j.f().getApplication().getSystemService("window")).getDefaultDisplay().getOrientation())
    {
    default: 
      return 0;
    case 0: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      this.F = paramSensorEvent.timestamp;
      System.arraycopy(paramSensorEvent.values, 0, this.n, 0, this.n.length);
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      System.arraycopy(paramSensorEvent.values, 0, this.t, 0, this.t.length);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */