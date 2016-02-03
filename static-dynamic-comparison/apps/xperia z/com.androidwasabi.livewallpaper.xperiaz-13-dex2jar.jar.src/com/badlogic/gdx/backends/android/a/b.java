package com.badlogic.gdx.backends.android.a;

import android.app.Service;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import com.badlogic.gdx.backends.android.a;
import com.badlogic.gdx.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  implements d
{
  final AssetManager a;
  protected final List<j> b = new ArrayList();
  private SoundPool c;
  private final AudioManager d;
  
  public b(Service paramService, a parama)
  {
    this.a = paramService.getAssets();
    this.c = new SoundPool(parama.n, 3, 100);
    this.d = ((AudioManager)paramService.getSystemService("audio"));
  }
  
  protected void a()
  {
    for (;;)
    {
      j localj;
      synchronized (this.b)
      {
        Iterator localIterator = this.b.iterator();
        if (!localIterator.hasNext()) {
          return;
        }
        localj = (j)localIterator.next();
        if (localj.a())
        {
          localj.a = true;
          localj.b();
        }
      }
      localj.a = false;
    }
  }
  
  protected void b()
  {
    List localList = this.b;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.b.size()) {
          return;
        }
        if (((j)this.b.get(i)).a) {
          ((j)this.b.get(i)).d();
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void c()
  {
    synchronized (this.b)
    {
      Iterator localIterator = new ArrayList(this.b).iterator();
      if (!localIterator.hasNext())
      {
        this.c.release();
        return;
      }
      ((j)localIterator.next()).c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */