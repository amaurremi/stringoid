package com.ideashower.readitlater.g;

import android.util.SparseIntArray;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;

public class f
  extends i
{
  private final SparseIntArray e = new SparseIntArray();
  private int f;
  
  public f(int paramInt, String paramString)
  {
    super(paramInt, paramInt, new PriorityBlockingQueue(11, new e()), paramString);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.e)
      {
        paramInt2 = this.e.get(paramInt1, 0) + paramInt2;
        this.e.put(paramInt1, paramInt2);
        if ((paramInt2 > 0) && (paramInt1 > this.f))
        {
          this.f = paramInt1;
          return;
        }
        if ((paramInt2 > 0) || (paramInt1 != this.f)) {
          continue;
        }
        this.f = 0;
        paramInt1 -= 1;
        if (paramInt1 < 1) {
          continue;
        }
        if (this.e.get(paramInt1) > 0) {
          this.f = paramInt1;
        }
      }
      paramInt1 -= 1;
    }
  }
  
  public FutureTask a(k paramk)
  {
    paramk = super.a(paramk);
    if ((paramk instanceof d)) {
      b(((d)paramk).a(), 1);
    }
    return paramk;
  }
  
  protected FutureTask a(k paramk, long paramLong)
  {
    return new d(paramk, paramLong);
  }
  
  public void b(Runnable paramRunnable)
  {
    super.b(paramRunnable);
    if ((paramRunnable instanceof d)) {
      b(((d)paramRunnable).a(), -1);
    }
  }
  
  public int c()
  {
    synchronized (this.e)
    {
      int i = this.f;
      return i;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */