package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class x
  implements SafeParcelable
{
  public static final Parcelable.Creator<x> CREATOR = new y();
  private final int BR;
  private final String Tf;
  private final String mName;
  
  x(int paramInt, String paramString1, String paramString2)
  {
    this.BR = paramInt;
    this.mName = paramString1;
    this.Tf = paramString2;
  }
  
  private x(a parama)
  {
    this.BR = 1;
    this.mName = a.a(parama);
    this.Tf = a.b(parama);
  }
  
  private boolean a(x paramx)
  {
    return (m.equal(this.mName, paramx.mName)) && (m.equal(this.Tf, paramx.Tf));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof x)) && (a((x)paramObject)));
  }
  
  public String getIdentifier()
  {
    return this.Tf;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.mName, this.Tf });
  }
  
  public String toString()
  {
    return m.h(this).a("name", this.mName).a("identifier", this.Tf).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    y.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private String Tf;
    private String mName;
    
    public a br(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public a bs(String paramString)
    {
      this.Tf = paramString;
      return this;
    }
    
    public x jy()
    {
      return new x(this, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */