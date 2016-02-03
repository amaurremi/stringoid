package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hm;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable
  implements SafeParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new j();
  private final String JL;
  private final String xG;
  final int xM;
  
  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    this.xM = paramInt;
    this.xG = paramString1;
    this.JL = paramString2;
  }
  
  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    this.xM = 1;
    this.xG = ((String)hm.f(paramDataItemAsset.getId()));
    this.JL = ((String)hm.f(paramDataItemAsset.getDataItemKey()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDataItemKey()
  {
    return this.JL;
  }
  
  public String getId()
  {
    return this.xG;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItemAsset nq()
  {
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.xG == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.JL);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.xG);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/DataItemAssetParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */