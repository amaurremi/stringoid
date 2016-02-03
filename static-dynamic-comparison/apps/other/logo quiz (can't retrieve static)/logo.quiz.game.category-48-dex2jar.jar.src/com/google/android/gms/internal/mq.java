package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class mq
  implements SafeParcelable
{
  public static final Parcelable.Creator<mq> CREATOR = new mr();
  final int BR;
  private final String Ss;
  private final LatLng ahN;
  private final List<mo> ahO;
  private final String ahP;
  private final String ahQ;
  private final String mName;
  
  mq(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<mo> paramList, String paramString3, String paramString4)
  {
    this.BR = paramInt;
    this.mName = paramString1;
    this.ahN = paramLatLng;
    this.Ss = paramString2;
    this.ahO = new ArrayList(paramList);
    this.ahP = paramString3;
    this.ahQ = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.Ss;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPhoneNumber()
  {
    return this.ahP;
  }
  
  public LatLng mj()
  {
    return this.ahN;
  }
  
  public List<mo> mk()
  {
    return this.ahO;
  }
  
  public String ml()
  {
    return this.ahQ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mr.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/mq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */