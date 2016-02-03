package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fm
  implements SafeParcelable
{
  public static final fn CREATOR = new fn();
  public final int id;
  final int xM;
  final Bundle xY;
  
  fm(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.xM = paramInt1;
    this.id = paramInt2;
    this.xY = paramBundle;
  }
  
  public int describeContents()
  {
    fn localfn = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fn localfn = CREATOR;
    fn.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */