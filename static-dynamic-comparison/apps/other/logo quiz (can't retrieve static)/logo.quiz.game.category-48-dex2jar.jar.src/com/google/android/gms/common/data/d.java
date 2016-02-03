package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;

public abstract class d
{
  protected final DataHolder IC;
  protected int JQ;
  private int JR;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.IC = ((DataHolder)n.i(paramDataHolder));
    ap(paramInt);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.IC.a(paramString, this.JQ, this.JR, paramCharArrayBuffer);
  }
  
  public boolean aQ(String paramString)
  {
    return this.IC.aQ(paramString);
  }
  
  protected Uri aR(String paramString)
  {
    return this.IC.g(paramString, this.JQ, this.JR);
  }
  
  protected boolean aS(String paramString)
  {
    return this.IC.h(paramString, this.JQ, this.JR);
  }
  
  protected void ap(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.IC.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      n.I(bool);
      this.JQ = paramInt;
      this.JR = this.IC.ar(this.JQ);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (m.equal(Integer.valueOf(((d)paramObject).JQ), Integer.valueOf(this.JQ)))
      {
        bool1 = bool2;
        if (m.equal(Integer.valueOf(((d)paramObject).JR), Integer.valueOf(this.JR)))
        {
          bool1 = bool2;
          if (((d)paramObject).IC == this.IC) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected int gA()
  {
    return this.JQ;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.IC.d(paramString, this.JQ, this.JR);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.IC.f(paramString, this.JQ, this.JR);
  }
  
  protected float getFloat(String paramString)
  {
    return this.IC.e(paramString, this.JQ, this.JR);
  }
  
  protected int getInteger(String paramString)
  {
    return this.IC.b(paramString, this.JQ, this.JR);
  }
  
  protected long getLong(String paramString)
  {
    return this.IC.a(paramString, this.JQ, this.JR);
  }
  
  protected String getString(String paramString)
  {
    return this.IC.c(paramString, this.JQ, this.JR);
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.JQ), Integer.valueOf(this.JR), this.IC });
  }
  
  public boolean isDataValid()
  {
    return !this.IC.isClosed();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */