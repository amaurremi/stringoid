package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.dc;

public abstract class e
{
  protected final DataHolder rM;
  protected final int se;
  private final int sf;
  
  public e(DataHolder paramDataHolder, int paramInt)
  {
    this.rM = ((DataHolder)dc.N(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < paramDataHolder.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      dc.G(bool);
      this.se = paramInt;
      this.sf = paramDataHolder.bo(this.se);
      return;
    }
  }
  
  public boolean ao(String paramString)
  {
    return this.rM.ao(paramString);
  }
  
  protected Uri ap(String paramString)
  {
    return this.rM.f(paramString, this.se, this.sf);
  }
  
  protected boolean aq(String paramString)
  {
    return this.rM.g(paramString, this.se, this.sf);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      bool1 = bool2;
      if (cz.b(Integer.valueOf(((e)paramObject).se), Integer.valueOf(this.se)))
      {
        bool1 = bool2;
        if (cz.b(Integer.valueOf(((e)paramObject).sf), Integer.valueOf(this.sf)))
        {
          bool1 = bool2;
          if (((e)paramObject).rM == this.rM) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.rM.d(paramString, this.se, this.sf);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.rM.e(paramString, this.se, this.sf);
  }
  
  protected int getInteger(String paramString)
  {
    return this.rM.b(paramString, this.se, this.sf);
  }
  
  protected long getLong(String paramString)
  {
    return this.rM.a(paramString, this.se, this.sf);
  }
  
  protected String getString(String paramString)
  {
    return this.rM.c(paramString, this.se, this.sf);
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { Integer.valueOf(this.se), Integer.valueOf(this.sf), this.rM });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */