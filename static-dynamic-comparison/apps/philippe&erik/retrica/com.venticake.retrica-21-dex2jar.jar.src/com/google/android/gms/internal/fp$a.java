package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public final class fp$a
{
  private final String mName;
  private String yi;
  private boolean yj;
  private int yk;
  private boolean yl;
  private String ym;
  private final List<fm> yn;
  private BitSet yo;
  private String yp;
  
  public fp$a(String paramString)
  {
    this.mName = paramString;
    this.yk = 1;
    this.yn = new ArrayList();
  }
  
  public a I(int paramInt)
  {
    if (this.yo == null) {
      this.yo = new BitSet();
    }
    this.yo.set(paramInt);
    return this;
  }
  
  public a Z(String paramString)
  {
    this.yi = paramString;
    return this;
  }
  
  public a aa(String paramString)
  {
    this.yp = paramString;
    return this;
  }
  
  public fp dQ()
  {
    int i = 0;
    Object localObject = null;
    if (this.yo != null)
    {
      int[] arrayOfInt = new int[this.yo.cardinality()];
      int j = this.yo.nextSetBit(0);
      for (;;)
      {
        localObject = arrayOfInt;
        if (j < 0) {
          break;
        }
        arrayOfInt[i] = j;
        j = this.yo.nextSetBit(j + 1);
        i += 1;
      }
    }
    return new fp(this.mName, this.yi, this.yj, this.yk, this.yl, this.ym, (fm[])this.yn.toArray(new fm[this.yn.size()]), (int[])localObject, this.yp);
  }
  
  public a w(boolean paramBoolean)
  {
    this.yj = paramBoolean;
    return this;
  }
  
  public a x(boolean paramBoolean)
  {
    this.yl = paramBoolean;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fp$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */