package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jp
  implements SafeParcelable
{
  public static final jq CREATOR = new jq();
  private final String Wi;
  private final String mTag;
  final int xJ;
  
  jp(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.Wi = paramString1;
    this.mTag = paramString2;
  }
  
  public int describeContents()
  {
    jq localjq = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof jp)) {}
    do
    {
      return false;
      paramObject = (jp)paramObject;
    } while ((!hl.equal(this.Wi, ((jp)paramObject).Wi)) || (!hl.equal(this.mTag, ((jp)paramObject).mTag)));
    return true;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.Wi, this.mTag });
  }
  
  public String je()
  {
    return this.Wi;
  }
  
  public String toString()
  {
    return hl.e(this).a("mPlaceId", this.Wi).a("mTag", this.mTag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jq localjq = CREATOR;
    jq.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */