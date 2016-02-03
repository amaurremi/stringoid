package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class f
{
  private final Object a = new Object();
  private WeakHashMap b = new WeakHashMap();
  private ArrayList c = new ArrayList();
  
  public a a(ak paramak, bA parambA)
  {
    synchronized (this.a)
    {
      if (a(parambA))
      {
        paramak = (a)this.b.get(parambA);
        return paramak;
      }
      paramak = new a(paramak, parambA);
      paramak.a(this);
      this.b.put(parambA, paramak);
      this.c.add(paramak);
      return paramak;
    }
  }
  
  public void a(a parama)
  {
    synchronized (this.a)
    {
      if (!parama.d()) {
        this.c.remove(parama);
      }
      return;
    }
  }
  
  public boolean a(bA parambA)
  {
    synchronized (this.a)
    {
      parambA = (a)this.b.get(parambA);
      if ((parambA != null) && (parambA.d()))
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public void b(bA parambA)
  {
    synchronized (this.a)
    {
      parambA = (a)this.b.get(parambA);
      if (parambA != null) {
        parambA.b();
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */