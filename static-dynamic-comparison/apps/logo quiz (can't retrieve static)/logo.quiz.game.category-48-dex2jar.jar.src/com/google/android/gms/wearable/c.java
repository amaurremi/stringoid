package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c
  implements SafeParcelable
{
  public static final Parcelable.Creator<c> CREATOR = new d();
  final int BR;
  private final int FD;
  private final String Ss;
  private final int auH;
  private final boolean auI;
  private boolean auJ;
  private String auK;
  private final String mName;
  
  c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    this.BR = paramInt1;
    this.mName = paramString1;
    this.Ss = paramString2;
    this.FD = paramInt2;
    this.auH = paramInt3;
    this.auI = paramBoolean1;
    this.auJ = paramBoolean2;
    this.auK = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    do
    {
      return false;
      paramObject = (c)paramObject;
    } while ((!m.equal(Integer.valueOf(this.BR), Integer.valueOf(((c)paramObject).BR))) || (!m.equal(this.mName, ((c)paramObject).mName)) || (!m.equal(this.Ss, ((c)paramObject).Ss)) || (!m.equal(Integer.valueOf(this.FD), Integer.valueOf(((c)paramObject).FD))) || (!m.equal(Integer.valueOf(this.auH), Integer.valueOf(((c)paramObject).auH))) || (!m.equal(Boolean.valueOf(this.auI), Boolean.valueOf(((c)paramObject).auI))));
    return true;
  }
  
  public String getAddress()
  {
    return this.Ss;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getRole()
  {
    return this.auH;
  }
  
  public int getType()
  {
    return this.FD;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.BR), this.mName, this.Ss, Integer.valueOf(this.FD), Integer.valueOf(this.auH), Boolean.valueOf(this.auI) });
  }
  
  public boolean isConnected()
  {
    return this.auJ;
  }
  
  public boolean isEnabled()
  {
    return this.auI;
  }
  
  public String pQ()
  {
    return this.auK;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.Ss);
    localStringBuilder.append(", mType=" + this.FD);
    localStringBuilder.append(", mRole=" + this.auH);
    localStringBuilder.append(", mEnabled=" + this.auI);
    localStringBuilder.append(", mIsConnected=" + this.auJ);
    localStringBuilder.append(", mEnabled=" + this.auK);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */