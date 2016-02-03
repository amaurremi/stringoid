package com.google.android.gms.internal;

public final class gw$a
{
  public final int FS;
  public final int FT;
  
  public gw$a(int paramInt1, int paramInt2)
  {
    this.FS = paramInt1;
    this.FT = paramInt2;
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
      if (((a)paramObject).FS != this.FS) {
        break;
      }
      bool1 = bool2;
    } while (((a)paramObject).FT == this.FT);
    return false;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.FS), Integer.valueOf(this.FT) });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gw$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */