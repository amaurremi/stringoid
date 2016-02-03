package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class c
  implements SafeParcelable
{
  public static final Parcelable.Creator<c> CREATOR = new d();
  private final int AT;
  private final String YL;
  private final int ali;
  private final boolean alj;
  private final String mName;
  final int xM;
  
  c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.xM = paramInt1;
    this.mName = paramString1;
    this.YL = paramString2;
    this.AT = paramInt2;
    this.ali = paramInt3;
    this.alj = paramBoolean;
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
    } while ((!hk.equal(Integer.valueOf(this.xM), Integer.valueOf(((c)paramObject).xM))) || (!hk.equal(this.mName, ((c)paramObject).mName)) || (!hk.equal(this.YL, ((c)paramObject).YL)) || (!hk.equal(Integer.valueOf(this.AT), Integer.valueOf(((c)paramObject).AT))) || (!hk.equal(Integer.valueOf(this.ali), Integer.valueOf(((c)paramObject).ali))) || (!hk.equal(Boolean.valueOf(this.alj), Boolean.valueOf(((c)paramObject).alj))));
    return true;
  }
  
  public String getAddress()
  {
    return this.YL;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getRole()
  {
    return this.ali;
  }
  
  public int getType()
  {
    return this.AT;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.xM), this.mName, this.YL, Integer.valueOf(this.AT), Integer.valueOf(this.ali), Boolean.valueOf(this.alj) });
  }
  
  public boolean isEnabled()
  {
    return this.alj;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.YL);
    localStringBuilder.append(", mType=" + this.AT);
    localStringBuilder.append(", mRole=" + this.ali);
    localStringBuilder.append(", mEnabled=" + this.alj);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */