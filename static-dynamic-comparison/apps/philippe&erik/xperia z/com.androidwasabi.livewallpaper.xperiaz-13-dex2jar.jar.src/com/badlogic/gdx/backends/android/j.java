package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import com.badlogic.gdx.h;
import com.badlogic.gdx.o;
import com.badlogic.gdx.utils.p;
import java.util.ArrayList;
import java.util.List;

public class j
  implements View.OnKeyListener, View.OnTouchListener, com.badlogic.gdx.k
{
  private final com.badlogic.gdx.l A;
  private long B;
  private SensorEventListener C;
  private SensorEventListener D;
  p<k> a;
  p<m> b;
  ArrayList<View.OnKeyListener> c;
  ArrayList<k> d;
  ArrayList<m> e;
  int[] f;
  int[] g;
  boolean[] h;
  int[] i;
  public boolean j;
  final com.badlogic.gdx.a k;
  final Context l;
  boolean m;
  boolean n;
  private com.badlogic.gdx.utils.g<Object> o;
  private SensorManager p;
  private final float[] q;
  private final u r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private final float[] w;
  private boolean x;
  private o y;
  private final a z;
  
  public long a()
  {
    return this.B;
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
      int i1 = this.h[paramInt];
      return i1;
    }
    finally {}
  }
  
  void b()
  {
    Object localObject2;
    for (;;)
    {
      try
      {
        this.x = false;
        if (this.y == null) {
          break label322;
        }
        o localo = this.y;
        i2 = this.d.size();
        i1 = 0;
        if (i1 >= i2) {
          break;
        }
        localObject2 = (k)this.d.get(i1);
        this.B = ((k)localObject2).a;
        switch (((k)localObject2).b)
        {
        case 0: 
          this.a.a(localObject2);
          i1 += 1;
          continue;
          localo.a(((k)localObject2).c);
          break;
        case 1: 
          ((o)localObject1).b(((k)localObject2).c);
        }
      }
      finally {}
      continue;
      ((o)localObject1).a(((k)localObject2).d);
    }
    int i2 = this.e.size();
    int i1 = 0;
    label164:
    if (i1 < i2)
    {
      localObject2 = (m)this.e.get(i1);
      this.B = ((m)localObject2).a;
      switch (((m)localObject2).b)
      {
      }
    }
    for (;;)
    {
      this.b.a(localObject2);
      i1 += 1;
      break label164;
      ((o)localObject1).a(((m)localObject2).c, ((m)localObject2).d, ((m)localObject2).e, 0);
      this.x = true;
      continue;
      ((o)localObject1).b(((m)localObject2).c, ((m)localObject2).d, ((m)localObject2).e, 0);
      continue;
      ((o)localObject1).a(((m)localObject2).c, ((m)localObject2).d, ((m)localObject2).e);
      continue;
      label322:
      i2 = this.e.size();
      i1 = 0;
      while (i1 < i2)
      {
        m localm = (m)this.e.get(i1);
        if (localm.b == 0) {
          this.x = true;
        }
        this.b.a(localm);
        i1 += 1;
      }
      i2 = this.d.size();
      i1 = 0;
      while (i1 < i2)
      {
        this.a.a(this.d.get(i1));
        i1 += 1;
      }
      if (this.e.size() == 0)
      {
        i1 = 0;
        while (i1 < this.f.length)
        {
          this.f[0] = 0;
          this.g[0] = 0;
          i1 += 1;
        }
      }
      this.d.clear();
      this.e.clear();
      return;
      break;
    }
  }
  
  void c()
  {
    Sensor localSensor;
    if (this.z.i)
    {
      this.p = ((SensorManager)this.l.getSystemService("sensor"));
      if (this.p.getSensorList(1).size() == 0)
      {
        this.j = false;
        if (!this.z.j) {
          break label240;
        }
        if (this.p == null) {
          this.p = ((SensorManager)this.l.getSystemService("sensor"));
        }
        localSensor = this.p.getDefaultSensor(2);
        if (localSensor == null) {
          break label232;
        }
        this.v = this.j;
        if (this.v)
        {
          this.D = new l(this, this.A, this.q, this.w);
          this.v = this.p.registerListener(this.D, localSensor, 1);
        }
      }
    }
    for (;;)
    {
      com.badlogic.gdx.g.a.a("AndroidInput", "sensor listener setup");
      return;
      localSensor = (Sensor)this.p.getSensorList(1).get(0);
      this.C = new l(this, this.A, this.q, this.w);
      this.j = this.p.registerListener(this.C, localSensor, 1);
      break;
      this.j = false;
      break;
      label232:
      this.v = false;
      continue;
      label240:
      this.v = false;
    }
  }
  
  void d()
  {
    if (this.p != null)
    {
      if (this.C != null)
      {
        this.p.unregisterListener(this.C);
        this.C = null;
      }
      if (this.D != null)
      {
        this.p.unregisterListener(this.D);
        this.D = null;
      }
      this.p = null;
    }
    com.badlogic.gdx.g.a.a("AndroidInput", "sensor listener tear down");
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i2 = this.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((View.OnKeyListener)this.c.get(i1)).onKey(paramView, paramInt, paramKeyEvent)) {
        return true;
      }
      i1 += 1;
    }
    label444:
    label475:
    for (;;)
    {
      char c1;
      try
      {
        if ((paramKeyEvent.getKeyCode() == 0) && (paramKeyEvent.getAction() == 2))
        {
          paramView = paramKeyEvent.getCharacters();
          paramInt = 0;
          if (paramInt < paramView.length())
          {
            paramKeyEvent = (k)this.a.c();
            paramKeyEvent.c = 0;
            paramKeyEvent.d = paramView.charAt(paramInt);
            paramKeyEvent.b = 2;
            this.d.add(paramKeyEvent);
            paramInt += 1;
            continue;
          }
          return false;
        }
        c1 = (char)paramKeyEvent.getUnicodeChar();
        if (paramInt != 67) {
          break label475;
        }
        c1 = '\b';
        switch (paramKeyEvent.getAction())
        {
        case 0: 
          this.k.a().h();
          if (paramInt != 255) {
            break label444;
          }
          return true;
        }
      }
      finally {}
      paramView = (k)this.a.c();
      paramView.d = '\000';
      paramView.c = paramKeyEvent.getKeyCode();
      paramView.b = 0;
      i1 = paramInt;
      if (paramInt == 4)
      {
        i1 = paramInt;
        if (paramKeyEvent.isAltPressed())
        {
          paramView.c = 255;
          i1 = 255;
        }
      }
      this.d.add(paramView);
      this.o.a(paramView.c, null);
      paramInt = i1;
      continue;
      paramView = (k)this.a.c();
      paramView.d = '\000';
      paramView.c = paramKeyEvent.getKeyCode();
      paramView.b = 1;
      i1 = paramInt;
      if (paramInt == 4)
      {
        i1 = paramInt;
        if (paramKeyEvent.isAltPressed())
        {
          paramView.c = 255;
          i1 = 255;
        }
      }
      this.d.add(paramView);
      paramView = (k)this.a.c();
      paramView.d = c1;
      paramView.c = 0;
      paramView.b = 2;
      this.d.add(paramView);
      if (i1 == 255)
      {
        this.o.a(255);
        paramInt = i1;
      }
      else
      {
        this.o.a(paramKeyEvent.getKeyCode());
        paramInt = i1;
        continue;
        if ((this.t) && (paramInt == 4)) {
          return true;
        }
        return (this.u) && (paramInt == 82);
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.n) && (paramView != null))
    {
      paramView.requestFocus();
      paramView.requestFocusFromTouch();
      this.n = false;
    }
    this.r.a(paramMotionEvent, this);
    if (this.s != 0) {}
    try
    {
      Thread.sleep(this.s);
      return true;
    }
    catch (InterruptedException paramView)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */