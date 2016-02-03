package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

public class c
  implements SafeParcelable
{
  public static final Parcelable.Creator<c> CREATOR = new d();
  private final int AQ;
  private final String YI;
  private final int alf;
  private final boolean alg;
  private final String mName;
  final int xJ;
  
  c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.mName = paramString1;
    this.YI = paramString2;
    this.AQ = paramInt2;
    this.alf = paramInt3;
    this.alg = paramBoolean;
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
    } while ((!hl.equal(Integer.valueOf(this.xJ), Integer.valueOf(((c)paramObject).xJ))) || (!hl.equal(this.mName, ((c)paramObject).mName)) || (!hl.equal(this.YI, ((c)paramObject).YI)) || (!hl.equal(Integer.valueOf(this.AQ), Integer.valueOf(((c)paramObject).AQ))) || (!hl.equal(Integer.valueOf(this.alf), Integer.valueOf(((c)paramObject).alf))) || (!hl.equal(Boolean.valueOf(this.alg), Boolean.valueOf(((c)paramObject).alg))));
    return true;
  }
  
  public String getAddress()
  {
    return this.YI;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getRole()
  {
    return this.alf;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.xJ), this.mName, this.YI, Integer.valueOf(this.AQ), Integer.valueOf(this.alf), Boolean.valueOf(this.alg) });
  }
  
  public boolean isEnabled()
  {
    return this.alg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.YI);
    localStringBuilder.append(", mType=" + this.AQ);
    localStringBuilder.append(", mRole=" + this.alf);
    localStringBuilder.append(", mEnabled=" + this.alg);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */