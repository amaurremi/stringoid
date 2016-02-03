package com.vungle.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum Orientation
  implements Parcelable
{
  public static final Parcelable.Creator<Orientation> CREATOR = new Parcelable.Creator() {};
  
  static
  {
    a = new Orientation[] { autoRotate, matchVideo };
  }
  
  private Orientation() {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ordinal());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/Orientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */