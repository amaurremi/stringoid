package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class x
  implements SafeParcelable
{
  public static final Parcelable.Creator<x> CREATOR = new y();
  public final m avp;
  public final int statusCode;
  public final int versionCode;
  
  x(int paramInt1, int paramInt2, m paramm)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.avp = paramm;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    y.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */