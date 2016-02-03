package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;

public class NotFilter
  implements SafeParcelable, a
{
  public static final Parcelable.Creator<NotFilter> CREATOR = new g();
  final int qh;
  final FilterHolder uC;
  
  NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    this.qh = paramInt;
    this.uC = paramFilterHolder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/query/internal/NotFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */