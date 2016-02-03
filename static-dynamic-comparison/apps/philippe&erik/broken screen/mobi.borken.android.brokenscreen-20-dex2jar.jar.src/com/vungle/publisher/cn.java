package com.vungle.publisher;

import java.util.concurrent.atomic.AtomicInteger;

public final class cn
  extends cm
{
  public final boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      a(paramInt2);
      b();
      ci.a(i);
      int j;
      int k;
      do
      {
        j = this.b.get();
        if (paramInt1 != j >>> this.a) {
          break;
        }
        k = b(paramInt2, ci.a(j, i));
      } while (!this.b.compareAndSet(j, k));
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */