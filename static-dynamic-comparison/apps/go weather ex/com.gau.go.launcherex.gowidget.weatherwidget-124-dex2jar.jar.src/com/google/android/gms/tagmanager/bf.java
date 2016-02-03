package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gl;

class bf
  implements cf
{
  private final gl Wv;
  private final long Yx;
  private final long vm;
  private final int vn;
  private double vo;
  private long vp;
  private final Object vq = new Object();
  private final String vr;
  
  public bf(int paramInt, long paramLong1, long paramLong2, String paramString, gl paramgl)
  {
    this.vn = paramInt;
    this.vo = this.vn;
    this.vm = paramLong1;
    this.Yx = paramLong2;
    this.vr = paramString;
    this.Wv = paramgl;
  }
  
  public boolean cS()
  {
    synchronized (this.vq)
    {
      long l = this.Wv.currentTimeMillis();
      if (l - this.vp < this.Yx)
      {
        bh.z("Excessive " + this.vr + " detected; call ignored.");
        return false;
      }
      if (this.vo < this.vn)
      {
        double d = (l - this.vp) / this.vm;
        if (d > 0.0D) {
          this.vo = Math.min(this.vn, d + this.vo);
        }
      }
      this.vp = l;
      if (this.vo >= 1.0D)
      {
        this.vo -= 1.0D;
        return true;
      }
    }
    bh.z("Excessive " + this.vr + " detected; call ignored.");
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */