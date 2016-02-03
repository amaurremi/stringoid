package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface iw
{
  public static final class a
    extends mb<a>
  {
    public a[] Uv;
    
    public a()
    {
      iL();
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if ((this.Uv != null) && (this.Uv.length > 0))
      {
        int i = 0;
        while (i < this.Uv.length)
        {
          a locala = this.Uv[i];
          if (locala != null) {
            paramma.a(1, locala);
          }
          i += 1;
        }
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i = super.c();
      int k = i;
      if (this.Uv != null)
      {
        k = i;
        if (this.Uv.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.Uv.length) {
              break;
            }
            a locala = this.Uv[j];
            k = i;
            if (locala != null) {
              k = i + ma.b(1, locala);
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
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof a));
          paramObject = (a)paramObject;
          bool1 = bool2;
        } while (!md.equals(this.Uv, ((a)paramObject).Uv));
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          break label83;
        }
        if (((a)paramObject).amU == null) {
          break;
        }
        bool1 = bool2;
      } while (!((a)paramObject).amU.isEmpty());
      return true;
      label83:
      return this.amU.equals(((a)paramObject).amU);
    }
    
    public int hashCode()
    {
      int j = md.hashCode(this.Uv);
      if ((this.amU == null) || (this.amU.isEmpty())) {}
      for (int i = 0;; i = this.amU.hashCode()) {
        return i + (j + 527) * 31;
      }
    }
    
    public a iL()
    {
      this.Uv = a.iM();
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public a n(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          int j = mi.b(paramlz, 10);
          if (this.Uv == null) {}
          a[] arrayOfa;
          for (i = 0;; i = this.Uv.length)
          {
            arrayOfa = new a[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.Uv, 0, arrayOfa, 0, i);
              j = i;
            }
            while (j < arrayOfa.length - 1)
            {
              arrayOfa[j] = new a();
              paramlz.a(arrayOfa[j]);
              paramlz.nw();
              j += 1;
            }
          }
          arrayOfa[j] = new a();
          paramlz.a(arrayOfa[j]);
          this.Uv = arrayOfa;
        }
      }
    }
    
    public static final class a
      extends mb<a>
    {
      private static volatile a[] Uw;
      public String Ux;
      public String Uy;
      public int viewId;
      
      public a()
      {
        iN();
      }
      
      public static a[] iM()
      {
        if (Uw == null) {}
        synchronized (md.amX)
        {
          if (Uw == null) {
            Uw = new a[0];
          }
          return Uw;
        }
      }
      
      public void a(ma paramma)
        throws IOException
      {
        if (!this.Ux.equals("")) {
          paramma.b(1, this.Ux);
        }
        if (!this.Uy.equals("")) {
          paramma.b(2, this.Uy);
        }
        if (this.viewId != 0) {
          paramma.p(3, this.viewId);
        }
        super.a(paramma);
      }
      
      protected int c()
      {
        int j = super.c();
        int i = j;
        if (!this.Ux.equals("")) {
          i = j + ma.h(1, this.Ux);
        }
        j = i;
        if (!this.Uy.equals("")) {
          j = i + ma.h(2, this.Uy);
        }
        i = j;
        if (this.viewId != 0) {
          i = j + ma.r(3, this.viewId);
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
            if (this.Ux != null) {
              break;
            }
            bool1 = bool2;
          } while (((a)paramObject).Ux != null);
          if (this.Uy != null) {
            break label128;
          }
          bool1 = bool2;
        } while (((a)paramObject).Uy != null);
        label128:
        while (this.Uy.equals(((a)paramObject).Uy))
        {
          bool1 = bool2;
          if (this.viewId != ((a)paramObject).viewId) {
            break;
          }
          if ((this.amU != null) && (!this.amU.isEmpty())) {
            break label144;
          }
          if (((a)paramObject).amU != null)
          {
            bool1 = bool2;
            if (!((a)paramObject).amU.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.Ux.equals(((a)paramObject).Ux)) {
            break label41;
          }
          return false;
        }
        return false;
        label144:
        return this.amU.equals(((a)paramObject).amU);
      }
      
      public int hashCode()
      {
        int m = 0;
        int i;
        int j;
        label21:
        int n;
        if (this.Ux == null)
        {
          i = 0;
          if (this.Uy != null) {
            break label85;
          }
          j = 0;
          n = this.viewId;
          k = m;
          if (this.amU != null) {
            if (!this.amU.isEmpty()) {
              break label96;
            }
          }
        }
        label85:
        label96:
        for (int k = m;; k = this.amU.hashCode())
        {
          return ((j + (i + 527) * 31) * 31 + n) * 31 + k;
          i = this.Ux.hashCode();
          break;
          j = this.Uy.hashCode();
          break label21;
        }
      }
      
      public a iN()
      {
        this.Ux = "";
        this.Uy = "";
        this.viewId = 0;
        this.amU = null;
        this.amY = -1;
        return this;
      }
      
      public a o(lz paramlz)
        throws IOException
      {
        for (;;)
        {
          int i = paramlz.nw();
          switch (i)
          {
          default: 
            if (a(paramlz, i)) {}
            break;
          case 0: 
            return this;
          case 10: 
            this.Ux = paramlz.readString();
            break;
          case 18: 
            this.Uy = paramlz.readString();
            break;
          case 24: 
            this.viewId = paramlz.nz();
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */