package com.google.android.gms.internal;

import java.util.List;

public abstract class gh<M extends gh<M>>
  extends gj
{
  protected List<gl> SZ;
  
  public void a(jz paramjz)
  {
    if (this.SZ == null) {}
    for (int i = 0;; i = this.SZ.size())
    {
      int j = 0;
      while (j < i)
      {
        gl localgl = (gl)this.SZ.get(j);
        paramjz.dD(localgl.tag);
        paramjz.f(localgl.Tb);
        j += 1;
      }
    }
  }
  
  public int nq()
  {
    if (this.SZ == null) {}
    int k;
    for (int i = 0;; i = this.SZ.size())
    {
      int j = 0;
      k = 0;
      while (j < i)
      {
        gl localgl = (gl)this.SZ.get(j);
        k = k + jz.dE(localgl.tag) + localgl.Tb.length;
        j += 1;
      }
    }
    this.tX = k;
    return k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */