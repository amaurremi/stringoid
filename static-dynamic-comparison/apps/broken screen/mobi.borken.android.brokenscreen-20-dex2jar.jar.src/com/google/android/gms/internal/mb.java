package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class mb<M extends mb<M>>
  extends mf
{
  protected List<mh> amU;
  
  public final <T> T a(mc<M, T> parammc)
  {
    return (T)parammc.i(this.amU);
  }
  
  public void a(ma paramma)
    throws IOException
  {
    if (this.amU == null) {}
    for (int i = 0;; i = this.amU.size())
    {
      int j = 0;
      while (j < i)
      {
        mh localmh = (mh)this.amU.get(j);
        paramma.eI(localmh.tag);
        paramma.t(localmh.amZ);
        j += 1;
      }
    }
  }
  
  protected final boolean a(lz paramlz, int paramInt)
    throws IOException
  {
    int i = paramlz.getPosition();
    if (!paramlz.ev(paramInt)) {
      return false;
    }
    if (this.amU == null) {
      this.amU = new ArrayList();
    }
    paramlz = paramlz.o(i, paramlz.getPosition() - i);
    this.amU.add(new mh(paramInt, paramlz));
    return true;
  }
  
  protected int c()
  {
    if (this.amU == null) {}
    int k;
    for (int i = 0;; i = this.amU.size())
    {
      int j = 0;
      k = 0;
      while (j < i)
      {
        mh localmh = (mh)this.amU.get(j);
        k = k + ma.eJ(localmh.tag) + localmh.amZ.length;
        j += 1;
      }
    }
    return k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/mb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */