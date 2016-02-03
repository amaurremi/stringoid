package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class au
  implements SafeParcelable
{
  public static final Parcelable.Creator<au> CREATOR = new av();
  public final long avC;
  public final List<am> avE;
  public final int statusCode;
  public final int versionCode;
  
  au(int paramInt1, int paramInt2, long paramLong, List<am> paramList)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.avC = paramLong;
    this.avE = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    av.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */