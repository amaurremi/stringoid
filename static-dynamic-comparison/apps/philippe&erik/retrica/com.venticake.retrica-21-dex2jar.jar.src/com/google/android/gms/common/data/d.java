package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public abstract class d
{
  protected final DataHolder DG;
  protected int EC;
  private int ED;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.DG = ((DataHolder)hm.f(paramDataHolder));
    ac(paramInt);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.DG.a(paramString, this.EC, this.ED, paramCharArrayBuffer);
  }
  
  protected void ac(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.DG.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      hm.A(bool);
      this.EC = paramInt;
      this.ED = this.DG.ae(this.EC);
      return;
    }
  }
  
  public boolean av(String paramString)
  {
    return this.DG.av(paramString);
  }
  
  protected Uri aw(String paramString)
  {
    return this.DG.g(paramString, this.EC, this.ED);
  }
  
  protected boolean ax(String paramString)
  {
    return this.DG.h(paramString, this.EC, this.ED);
  }
  
  protected int eV()
  {
    return this.EC;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (hk.equal(Integer.valueOf(((d)paramObject).EC), Integer.valueOf(this.EC)))
      {
        bool1 = bool2;
        if (hk.equal(Integer.valueOf(((d)paramObject).ED), Integer.valueOf(this.ED)))
        {
          bool1 = bool2;
          if (((d)paramObject).DG == this.DG) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.DG.d(paramString, this.EC, this.ED);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.DG.f(paramString, this.EC, this.ED);
  }
  
  protected float getFloat(String paramString)
  {
    return this.DG.e(paramString, this.EC, this.ED);
  }
  
  protected int getInteger(String paramString)
  {
    return this.DG.b(paramString, this.EC, this.ED);
  }
  
  protected long getLong(String paramString)
  {
    return this.DG.a(paramString, this.EC, this.ED);
  }
  
  protected String getString(String paramString)
  {
    return this.DG.c(paramString, this.EC, this.ED);
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.EC), Integer.valueOf(this.ED), this.DG });
  }
  
  public boolean isDataValid()
  {
    return !this.DG.isClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */