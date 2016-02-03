package com.google.android.gms.internal;

import java.util.List;

public final class c$d
  extends ma<d>
{
  public d.a[] eR;
  public d.a[] eS;
  public c.c[] eT;
  
  public c$d()
  {
    h();
  }
  
  public void a(lz paramlz)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.eR != null) && (this.eR.length > 0))
    {
      i = 0;
      while (i < this.eR.length)
      {
        localObject = this.eR[i];
        if (localObject != null) {
          paramlz.a(1, (me)localObject);
        }
        i += 1;
      }
    }
    if ((this.eS != null) && (this.eS.length > 0))
    {
      i = 0;
      while (i < this.eS.length)
      {
        localObject = this.eS[i];
        if (localObject != null) {
          paramlz.a(2, (me)localObject);
        }
        i += 1;
      }
    }
    if ((this.eT != null) && (this.eT.length > 0))
    {
      i = j;
      while (i < this.eT.length)
      {
        localObject = this.eT[i];
        if (localObject != null) {
          paramlz.a(3, (me)localObject);
        }
        i += 1;
      }
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int m = 0;
    int i = super.c();
    int j = i;
    Object localObject;
    if (this.eR != null)
    {
      j = i;
      if (this.eR.length > 0)
      {
        j = 0;
        while (j < this.eR.length)
        {
          localObject = this.eR[j];
          k = i;
          if (localObject != null) {
            k = i + lz.b(1, (me)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.eS != null)
    {
      i = j;
      if (this.eS.length > 0)
      {
        i = j;
        j = 0;
        while (j < this.eS.length)
        {
          localObject = this.eS[j];
          k = i;
          if (localObject != null) {
            k = i + lz.b(2, (me)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (this.eT != null)
    {
      k = i;
      if (this.eT.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.eT.length) {
            break;
          }
          localObject = this.eT[j];
          k = i;
          if (localObject != null) {
            k = i + lz.b(3, (me)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public d e(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        j = mh.b(paramly, 10);
        if (this.eR == null) {}
        for (i = 0;; i = this.eR.length)
        {
          localObject = new d.a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.eR, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new d.a();
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new d.a();
        paramly.a(localObject[j]);
        this.eR = ((d.a[])localObject);
        break;
      case 18: 
        j = mh.b(paramly, 18);
        if (this.eS == null) {}
        for (i = 0;; i = this.eS.length)
        {
          localObject = new d.a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.eS, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new d.a();
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new d.a();
        paramly.a(localObject[j]);
        this.eS = ((d.a[])localObject);
        break;
      case 26: 
        j = mh.b(paramly, 26);
        if (this.eT == null) {}
        for (i = 0;; i = this.eT.length)
        {
          localObject = new c.c[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.eT, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new c.c();
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new c.c();
        paramly.a(localObject[j]);
        this.eT = ((c.c[])localObject);
      }
    }
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
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof d));
            paramObject = (d)paramObject;
            bool1 = bool2;
          } while (!mc.equals(this.eR, ((d)paramObject).eR));
          bool1 = bool2;
        } while (!mc.equals(this.eS, ((d)paramObject).eS));
        bool1 = bool2;
      } while (!mc.equals(this.eT, ((d)paramObject).eT));
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label115;
      }
      if (((d)paramObject).amX == null) {
        break;
      }
      bool1 = bool2;
    } while (!((d)paramObject).amX.isEmpty());
    return true;
    label115:
    return this.amX.equals(((d)paramObject).amX);
  }
  
  public d h()
  {
    this.eR = d.a.r();
    this.eS = d.a.r();
    this.eT = c.c.f();
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public int hashCode()
  {
    int j = mc.hashCode(this.eR);
    int k = mc.hashCode(this.eS);
    int m = mc.hashCode(this.eT);
    if ((this.amX == null) || (this.amX.isEmpty())) {}
    for (int i = 0;; i = this.amX.hashCode()) {
      return i + (((j + 527) * 31 + k) * 31 + m) * 31;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/c$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */