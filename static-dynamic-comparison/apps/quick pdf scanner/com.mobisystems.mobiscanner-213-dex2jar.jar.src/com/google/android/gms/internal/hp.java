package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hp
  implements SafeParcelable
{
  public static final eu Ng = new eu();
  private final String Nh;
  private final String mTag;
  final int qh;
  
  hp(int paramInt, String paramString1, String paramString2)
  {
    this.qh = paramInt;
    this.Nh = paramString1;
    this.mTag = paramString2;
  }
  
  public int describeContents()
  {
    eu localeu = Ng;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof hp)) {}
    do
    {
      return false;
      paramObject = (hp)paramObject;
    } while ((!cz.b(this.Nh, ((hp)paramObject).Nh)) || (!cz.b(this.mTag, ((hp)paramObject).mTag)));
    return true;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.Nh, this.mTag });
  }
  
  public String rp()
  {
    return this.Nh;
  }
  
  public String toString()
  {
    return cz.M(this).a("mPlaceId", this.Nh).a("mTag", this.mTag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    eu localeu = Ng;
    eu.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */