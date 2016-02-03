package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface ok
{
  public static final class a
    extends pg<a>
  {
    public long asg;
    public c.j ash;
    public c.f gs;
    
    public a()
    {
      pJ();
    }
    
    public static a l(byte[] paramArrayOfByte)
      throws pl
    {
      return (a)pm.a(new a(), paramArrayOfByte);
    }
    
    public void a(pf parampf)
      throws IOException
    {
      parampf.b(1, this.asg);
      if (this.gs != null) {
        parampf.a(2, this.gs);
      }
      if (this.ash != null) {
        parampf.a(3, this.ash);
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int j = super.c() + pf.d(1, this.asg);
      int i = j;
      if (this.gs != null) {
        i = j + pf.c(2, this.gs);
      }
      j = i;
      if (this.ash != null) {
        j = i + pf.c(3, this.ash);
      }
      return j;
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
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof a));
            paramObject = (a)paramObject;
            bool1 = bool2;
          } while (this.asg != ((a)paramObject).asg);
          if (this.gs != null) {
            break;
          }
          bool1 = bool2;
        } while (((a)paramObject).gs != null);
        if (this.ash != null) {
          break label93;
        }
        bool1 = bool2;
      } while (((a)paramObject).ash != null);
      label93:
      while (this.ash.equals(((a)paramObject).ash))
      {
        return a((pg)paramObject);
        if (this.gs.equals(((a)paramObject).gs)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int j = 0;
      int k = (int)(this.asg ^ this.asg >>> 32);
      int i;
      if (this.gs == null)
      {
        i = 0;
        if (this.ash != null) {
          break label67;
        }
      }
      for (;;)
      {
        return ((i + (k + 527) * 31) * 31 + j) * 31 + qx();
        i = this.gs.hashCode();
        break;
        label67:
        j = this.ash.hashCode();
      }
    }
    
    public a p(pe parampe)
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
          this.asg = parampe.qi();
          break;
        case 18: 
          if (this.gs == null) {
            this.gs = new c.f();
          }
          parampe.a(this.gs);
          break;
        case 26: 
          if (this.ash == null) {
            this.ash = new c.j();
          }
          parampe.a(this.ash);
        }
      }
    }
    
    public a pJ()
    {
      this.asg = 0L;
      this.gs = null;
      this.ash = null;
      this.awy = null;
      this.awJ = -1;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */