package com.badlogic.gdx.backends.android;

import android.media.SoundPool;
import com.badlogic.gdx.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  implements d
{
  protected final List<r> a;
  private final SoundPool b;
  
  protected void a()
  {
    for (;;)
    {
      r localr;
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localr = (r)localIterator.next();
        if (localr.a())
        {
          localr.a = true;
          localr.b();
        }
      }
      localr.a = false;
    }
  }
  
  protected void b()
  {
    List localList = this.a;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.a.size())
        {
          if (((r)this.a.get(i)).a == true) {
            ((r)this.a.get(i)).d();
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      if (localIterator.hasNext()) {
        ((r)localIterator.next()).c();
      }
    }
    this.b.release();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */