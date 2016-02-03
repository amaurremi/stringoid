package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface lk
{
  public static final class a
    extends pg<a>
  {
    public a[] adt;
    
    public a()
    {
      lN();
    }
    
    public void a(pf parampf)
      throws IOException
    {
      if ((this.adt != null) && (this.adt.length > 0))
      {
        int i = 0;
        while (i < this.adt.length)
        {
          a locala = this.adt[i];
          if (locala != null) {
            parampf.a(1, locala);
          }
          i += 1;
        }
      }
      super.a(parampf);
    }
    
    protected int c()
    {
      int i = super.c();
      int k = i;
      if (this.adt != null)
      {
        k = i;
        if (this.adt.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.adt.length) {
              break;
            }
            a locala = this.adt[j];
            k = i;
            if (locala != null) {
              k = i + pf.c(1, locala);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof a));
        paramObject = (a)paramObject;
        bool1 = bool2;
      } while (!pk.equals(this.adt, ((a)paramObject).adt));
      return a((pg)paramObject);
    }
    
    public int hashCode()
    {
      return (pk.hashCode(this.adt) + 527) * 31 + qx();
    }
    
    public a lN()
    {
      this.adt = a.lO();
      this.awy = null;
      this.awJ = -1;
      return this;
    }
    
    public a n(pe parampe)
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
        case 10: 
          int j = pp.b(parampe, 10);
          if (this.adt == null) {}
          a[] arrayOfa;
          for (i = 0;; i = this.adt.length)
          {
            arrayOfa = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.adt, 0, arrayOfa, 0, i);
              j = i;
            }
            while (j < arrayOfa.length - 1)
            {
              arrayOfa[j] = new a();
              parampe.a(arrayOfa[j]);
              parampe.qg();
              j += 1;
            }
          }
          arrayOfa[j] = new a();
          parampe.a(arrayOfa[j]);
          this.adt = arrayOfa;
        }
      }
    }
    
    public static final class a
      extends pg<a>
    {
      private static volatile a[] adu;
      public String adv;
      public String adw;
      public int viewId;
      
      public a()
      {
        lP();
      }
      
      public static a[] lO()
      {
        if (adu == null) {}
        synchronized (pk.awI)
        {
          if (adu == null) {
            adu = new a[0];
          }
          return adu;
        }
      }
      
      public void a(pf parampf)
        throws IOException
      {
        if (!this.adv.equals("")) {
          parampf.b(1, this.adv);
        }
        if (!this.adw.equals("")) {
          parampf.b(2, this.adw);
        }
        if (this.viewId != 0) {
          parampf.s(3, this.viewId);
        }
        super.a(parampf);
      }
      
      protected int c()
      {
        int j = super.c();
        int i = j;
        if (!this.adv.equals("")) {
          i = j + pf.j(1, this.adv);
        }
        j = i;
        if (!this.adw.equals("")) {
          j = i + pf.j(2, this.adw);
        }
        i = j;
        if (this.viewId != 0) {
          i = j + pf.u(3, this.viewId);
        }
        return i;
      }
      
      public boolean equals(Object paramObject)
      {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
          bool1 = true;
        }
        label41:
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
            if (this.adv != null) {
              break;
            }
            bool1 = bool2;
          } while (((a)paramObject).adv != null);
          if (this.adw != null) {
            break label92;
          }
          bool1 = bool2;
        } while (((a)paramObject).adw != null);
        label92:
        while (this.adw.equals(((a)paramObject).adw))
        {
          bool1 = bool2;
          if (this.viewId != ((a)paramObject).viewId) {
            break;
          }
          return a((pg)paramObject);
          if (this.adv.equals(((a)paramObject).adv)) {
            break label41;
          }
          return false;
        }
        return false;
      }
      
      public int hashCode()
      {
        int j = 0;
        int i;
        if (this.adv == null)
        {
          i = 0;
          if (this.adw != null) {
            break label56;
          }
        }
        for (;;)
        {
          return (((i + 527) * 31 + j) * 31 + this.viewId) * 31 + qx();
          i = this.adv.hashCode();
          break;
          label56:
          j = this.adw.hashCode();
        }
      }
      
      public a lP()
      {
        this.adv = "";
        this.adw = "";
        this.viewId = 0;
        this.awy = null;
        this.awJ = -1;
        return this;
      }
      
      public a o(pe parampe)
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
          case 10: 
            this.adv = parampe.readString();
            break;
          case 18: 
            this.adw = parampe.readString();
            break;
          case 24: 
            this.viewId = parampe.qj();
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */