package com.flurry.android;

import java.util.Iterator;
import java.util.List;

final class j
  implements Runnable
{
  j(List paramList) {}
  
  public final void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((o)localIterator.next()).a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */