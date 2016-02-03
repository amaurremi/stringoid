package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.pe;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.pg;
import com.google.android.gms.internal.pl;
import com.google.android.gms.internal.pm;
import java.io.IOException;

public final class ah
  extends pg<ah>
{
  public String Pd;
  public long Pe;
  public long Pf;
  public int versionCode;
  
  public ah()
  {
    ic();
  }
  
  public static ah g(byte[] paramArrayOfByte)
    throws pl
  {
    return (ah)pm.a(new ah(), paramArrayOfByte);
  }
  
  public void a(pf parampf)
    throws IOException
  {
    parampf.s(1, this.versionCode);
    parampf.b(2, this.Pd);
    parampf.c(3, this.Pe);
    parampf.c(4, this.Pf);
    super.a(parampf);
  }
  
  protected int c()
  {
    return super.c() + pf.u(1, this.versionCode) + pf.j(2, this.Pd) + pf.e(3, this.Pe) + pf.e(4, this.Pf);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof ah));
        paramObject = (ah)paramObject;
        bool1 = bool2;
      } while (this.versionCode != ((ah)paramObject).versionCode);
      if (this.Pd != null) {
        break;
      }
      bool1 = bool2;
    } while (((ah)paramObject).Pd != null);
    while (this.Pd.equals(((ah)paramObject).Pd))
    {
      bool1 = bool2;
      if (this.Pe != ((ah)paramObject).Pe) {
        break;
      }
      bool1 = bool2;
      if (this.Pf != ((ah)paramObject).Pf) {
        break;
      }
      return a((pg)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.versionCode;
    if (this.Pd == null) {}
    for (int i = 0;; i = this.Pd.hashCode()) {
      return (((i + (j + 527) * 31) * 31 + (int)(this.Pe ^ this.Pe >>> 32)) * 31 + (int)(this.Pf ^ this.Pf >>> 32)) * 31 + qx();
    }
  }
  
  public ah ic()
  {
    this.versionCode = 1;
    this.Pd = "";
    this.Pe = -1L;
    this.Pf = -1L;
    this.awy = null;
    this.awJ = -1;
    return this;
  }
  
  public ah m(pe parampe)
    throws IOException
  {
    for (;;)
    {
      int i = parampe.qg();
      switch (i)
      {
      default: 
        if (a(parampe, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.versionCode = parampe.qj();
        break;
      case 18: 
        this.Pd = parampe.readString();
        break;
      case 24: 
        this.Pe = parampe.qm();
        break;
      case 32: 
        this.Pf = parampe.qm();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */