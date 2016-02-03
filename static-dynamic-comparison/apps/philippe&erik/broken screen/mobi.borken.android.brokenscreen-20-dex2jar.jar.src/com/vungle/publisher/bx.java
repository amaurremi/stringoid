package com.vungle.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class bx
  implements Parcelable
{
  public static final Parcelable.Creator<bx> CREATOR = new Parcelable.Creator() {};
  public long a;
  public int b;
  public int c;
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "{firstAttemptMillis: " + this.a + ", hardRetryCount: " + this.b + ", softRetryCount: " + this.c + "}";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */