package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;

public abstract class d
{
  protected final DataHolder DD;
  private int EA;
  protected int Ez;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.DD = ((DataHolder)hn.f(paramDataHolder));
    ac(paramInt);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.DD.a(paramString, this.Ez, this.EA, paramCharArrayBuffer);
  }
  
  protected void ac(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.DD.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      hn.A(bool);
      this.Ez = paramInt;
      this.EA = this.DD.ae(this.Ez);
      return;
    }
  }
  
  public boolean av(String paramString)
  {
    return this.DD.av(paramString);
  }
  
  protected Uri aw(String paramString)
  {
    return this.DD.g(paramString, this.Ez, this.EA);
  }
  
  protected boolean ax(String paramString)
  {
    return this.DD.h(paramString, this.Ez, this.EA);
  }
  
  protected int eQ()
  {
    return this.Ez;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (hl.equal(Integer.valueOf(((d)paramObject).Ez), Integer.valueOf(this.Ez)))
      {
        bool1 = bool2;
        if (hl.equal(Integer.valueOf(((d)paramObject).EA), Integer.valueOf(this.EA)))
        {
          bool1 = bool2;
          if (((d)paramObject).DD == this.DD) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.DD.d(paramString, this.Ez, this.EA);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.DD.f(paramString, this.Ez, this.EA);
  }
  
  protected float getFloat(String paramString)
  {
    return this.DD.e(paramString, this.Ez, this.EA);
  }
  
  protected int getInteger(String paramString)
  {
    return this.DD.b(paramString, this.Ez, this.EA);
  }
  
  protected long getLong(String paramString)
  {
    return this.DD.a(paramString, this.Ez, this.EA);
  }
  
  protected String getString(String paramString)
  {
    return this.DD.c(paramString, this.Ez, this.EA);
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.Ez), Integer.valueOf(this.EA), this.DD });
  }
  
  public boolean isDataValid()
  {
    return !this.DD.isClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */