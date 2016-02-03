package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class af
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<af> CREATOR = new ag();
  private final byte[] TC;
  private final String alS;
  private final String alT;
  private final int qX;
  final int xJ;
  
  af(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.xJ = paramInt1;
    this.qX = paramInt2;
    this.alS = paramString1;
    this.TC = paramArrayOfByte;
    this.alT = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public String getPath()
  {
    return this.alS;
  }
  
  public int getRequestId()
  {
    return this.qX;
  }
  
  public String getSourceNodeId()
  {
    return this.alT;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.qX).append(",").append(this.alS).append(", size=");
    if (this.TC == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.TC.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wearable/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */