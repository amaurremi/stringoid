package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class ah
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<ah> CREATOR = new ai();
  final int BR;
  private final byte[] acw;
  private final String avw;
  private final String avx;
  private final int uQ;
  
  ah(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.BR = paramInt1;
    this.uQ = paramInt2;
    this.avw = paramString1;
    this.acw = paramArrayOfByte;
    this.avx = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return this.acw;
  }
  
  public String getPath()
  {
    return this.avw;
  }
  
  public int getRequestId()
  {
    return this.uQ;
  }
  
  public String getSourceNodeId()
  {
    return this.avx;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.uQ).append(",").append(this.avw).append(", size=");
    if (this.acw == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.acw.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ai.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */