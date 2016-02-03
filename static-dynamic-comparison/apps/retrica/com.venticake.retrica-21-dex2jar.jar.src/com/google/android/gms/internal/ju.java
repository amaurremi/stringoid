package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class ju
  implements SafeParcelable
{
  public static final Parcelable.Creator<ju> CREATOR = new jv();
  private final LatLng YK;
  private final String YL;
  private final List<js> YM;
  private final String YN;
  private final String YO;
  private final String mName;
  final int xM;
  
  ju(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<js> paramList, String paramString3, String paramString4)
  {
    this.xM = paramInt;
    this.mName = paramString1;
    this.YK = paramLatLng;
    this.YL = paramString2;
    this.YM = new ArrayList(paramList);
    this.YN = paramString3;
    this.YO = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.YL;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPhoneNumber()
  {
    return this.YN;
  }
  
  public LatLng jk()
  {
    return this.YK;
  }
  
  public List<js> jl()
  {
    return this.YM;
  }
  
  public String jm()
  {
    return this.YO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jv.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */