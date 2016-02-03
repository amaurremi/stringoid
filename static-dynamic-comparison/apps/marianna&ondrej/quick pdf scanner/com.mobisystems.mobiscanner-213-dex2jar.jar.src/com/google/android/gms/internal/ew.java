package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ew
  implements SafeParcelable
{
  public static final dh HG = new dh();
  private final ey HH;
  private final int qh;
  
  ew(int paramInt, ey paramey)
  {
    this.qh = paramInt;
    this.HH = paramey;
  }
  
  private ew(ey paramey)
  {
    this.qh = 1;
    this.HH = paramey;
  }
  
  public static ew a(fb.b<?, ?> paramb)
  {
    if ((paramb instanceof ey)) {
      return new ew((ey)paramb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public int describeContents()
  {
    dh localdh = HG;
    return 0;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public fb.b<?, ?> qA()
  {
    if (this.HH != null) {
      return this.HH;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  ey qz()
  {
    return this.HH;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dh localdh = HG;
    dh.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */