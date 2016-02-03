package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class jv
  implements SafeParcelable
{
  public static final Parcelable.Creator<jv> CREATOR = new jw();
  private final LatLng YH;
  private final String YI;
  private final List<jt> YJ;
  private final String YK;
  private final String YL;
  private final String mName;
  final int xJ;
  
  jv(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<jt> paramList, String paramString3, String paramString4)
  {
    this.xJ = paramInt;
    this.mName = paramString1;
    this.YH = paramLatLng;
    this.YI = paramString2;
    this.YJ = new ArrayList(paramList);
    this.YK = paramString3;
    this.YL = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.YI;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPhoneNumber()
  {
    return this.YK;
  }
  
  public LatLng jf()
  {
    return this.YH;
  }
  
  public List<jt> jg()
  {
    return this.YJ;
  }
  
  public String jh()
  {
    return this.YL;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */