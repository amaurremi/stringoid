package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.eg;

public final class RealTimeMessage
  implements Parcelable
{
  public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator()
  {
    public RealTimeMessage[] aK(int paramAnonymousInt)
    {
      return new RealTimeMessage[paramAnonymousInt];
    }
    
    public RealTimeMessage ac(Parcel paramAnonymousParcel)
    {
      return new RealTimeMessage(paramAnonymousParcel, null);
    }
  };
  public static final int RELIABLE = 1;
  public static final int UNRELIABLE = 0;
  private final String wA;
  private final byte[] wB;
  private final int wC;
  
  private RealTimeMessage(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
  }
  
  public RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    this.wA = ((String)eg.f(paramString));
    this.wB = ((byte[])((byte[])eg.f(paramArrayOfByte)).clone());
    this.wC = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getMessageData()
  {
    return this.wB;
  }
  
  public String getSenderParticipantId()
  {
    return this.wA;
  }
  
  public boolean isReliable()
  {
    return this.wC == 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.wA);
    paramParcel.writeByteArray(this.wB);
    paramParcel.writeInt(this.wC);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RealTimeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */