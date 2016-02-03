package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.n;

public final class RealTimeMessage
  implements Parcelable
{
  public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator()
  {
    public RealTimeMessage cn(Parcel paramAnonymousParcel)
    {
      return new RealTimeMessage(paramAnonymousParcel, null);
    }
    
    public RealTimeMessage[] dU(int paramAnonymousInt)
    {
      return new RealTimeMessage[paramAnonymousInt];
    }
  };
  public static final int RELIABLE = 1;
  public static final int UNRELIABLE = 0;
  private final String aca;
  private final byte[] acb;
  private final int acc;
  
  private RealTimeMessage(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
  }
  
  public RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    this.aca = ((String)n.i(paramString));
    this.acb = ((byte[])((byte[])n.i(paramArrayOfByte)).clone());
    this.acc = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getMessageData()
  {
    return this.acb;
  }
  
  public String getSenderParticipantId()
  {
    return this.aca;
  }
  
  public boolean isReliable()
  {
    return this.acc == 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.aca);
    paramParcel.writeByteArray(this.acb);
    paramParcel.writeInt(this.acc);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RealTimeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */