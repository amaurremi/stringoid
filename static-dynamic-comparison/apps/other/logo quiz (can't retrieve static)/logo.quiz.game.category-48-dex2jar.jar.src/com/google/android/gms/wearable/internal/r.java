package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;

@Deprecated
public class r
  implements SafeParcelable
{
  public static final Parcelable.Creator<r> CREATOR = new s();
  public final c avm;
  public final int statusCode;
  public final int versionCode;
  
  r(int paramInt1, int paramInt2, c paramc)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.avm = paramc;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */