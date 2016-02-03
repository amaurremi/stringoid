package com.badlogic.gdx.utils.a;

import com.badlogic.gdx.utils.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class a
  implements com.badlogic.gdx.utils.d
{
  private final ExecutorService a;
  
  public <T> c<T> a(d<T> paramd)
  {
    return new c(this.a.submit(new b(this, paramd)));
  }
  
  public void c()
  {
    this.a.shutdown();
    try
    {
      this.a.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new f("Couldn't shutdown loading thread", localInterruptedException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */