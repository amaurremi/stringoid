package com.google.ads;

import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;

public class af
  implements Runnable
{
  private WeakReference<d> a;
  
  public af(d paramd)
  {
    this.a = new WeakReference(paramd);
  }
  
  public void run()
  {
    d locald = (d)this.a.get();
    if (locald == null)
    {
      b.a("The ad must be gone, so cancelling the refresh timer.");
      return;
    }
    locald.A();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */