package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;

public abstract class b
{
  protected final DataHolder nE;
  protected final int nG;
  private final int nH;
  
  public b(DataHolder paramDataHolder, int paramInt)
  {
    this.nE = ((DataHolder)eg.f(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < paramDataHolder.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      eg.p(bool);
      this.nG = paramInt;
      this.nH = paramDataHolder.C(this.nG);
      return;
    }
  }
  
  protected Uri L(String paramString)
  {
    return this.nE.parseUri(paramString, this.nG, this.nH);
  }
  
  protected boolean M(String paramString)
  {
    return this.nE.hasNull(paramString, this.nG, this.nH);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.nE.copyToBuffer(paramString, this.nG, this.nH, paramCharArrayBuffer);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (ee.equal(Integer.valueOf(((b)paramObject).nG), Integer.valueOf(this.nG)))
      {
        bool1 = bool2;
        if (ee.equal(Integer.valueOf(((b)paramObject).nH), Integer.valueOf(this.nH)))
        {
          bool1 = bool2;
          if (((b)paramObject).nE == this.nE) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.nE.getBoolean(paramString, this.nG, this.nH);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.nE.getByteArray(paramString, this.nG, this.nH);
  }
  
  protected int getInteger(String paramString)
  {
    return this.nE.getInteger(paramString, this.nG, this.nH);
  }
  
  protected long getLong(String paramString)
  {
    return this.nE.getLong(paramString, this.nG, this.nH);
  }
  
  protected String getString(String paramString)
  {
    return this.nE.getString(paramString, this.nG, this.nH);
  }
  
  public boolean hasColumn(String paramString)
  {
    return this.nE.hasColumn(paramString);
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.nG), Integer.valueOf(this.nH), this.nE });
  }
  
  public boolean isDataValid()
  {
    return !this.nE.isClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/common/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */