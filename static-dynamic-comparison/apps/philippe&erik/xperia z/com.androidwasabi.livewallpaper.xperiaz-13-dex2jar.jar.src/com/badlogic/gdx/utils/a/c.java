package com.badlogic.gdx.utils.a;

import com.badlogic.gdx.utils.f;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class c<T>
{
  private final Future<T> a;
  
  c(Future<T> paramFuture)
  {
    this.a = paramFuture;
  }
  
  public boolean a()
  {
    return this.a.isDone();
  }
  
  public T b()
  {
    try
    {
      Object localObject = this.a.get();
      return (T)localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      throw new f(localExecutionException.getCause());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/utils/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */