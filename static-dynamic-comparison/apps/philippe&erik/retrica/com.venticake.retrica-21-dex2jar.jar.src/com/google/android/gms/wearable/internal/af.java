package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class af
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<af> CREATOR = new ag();
  private final byte[] TF;
  private final String alV;
  private final String alW;
  private final int ra;
  final int xM;
  
  af(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.xM = paramInt1;
    this.ra = paramInt2;
    this.alV = paramString1;
    this.TF = paramArrayOfByte;
    this.alW = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return this.TF;
  }
  
  public String getPath()
  {
    return this.alV;
  }
  
  public int getRequestId()
  {
    return this.ra;
  }
  
  public String getSourceNodeId()
  {
    return this.alW;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.ra).append(",").append(this.alV).append(", size=");
    if (this.TF == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.TF.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */