package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class gx
  extends hr<a, Drawable>
{
  public gx()
  {
    super(10);
  }
  
  public static final class a
  {
    public final int FP;
    public final int FQ;
    
    public a(int paramInt1, int paramInt2)
    {
      this.FP = paramInt1;
      this.FQ = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof a)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this == paramObject);
        paramObject = (a)paramObject;
        if (((a)paramObject).FP != this.FP) {
          break;
        }
        bool1 = bool2;
      } while (((a)paramObject).FQ == this.FQ);
      return false;
    }
    
    public int hashCode()
    {
      return hl.hashCode(new Object[] { Integer.valueOf(this.FP), Integer.valueOf(this.FQ) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */