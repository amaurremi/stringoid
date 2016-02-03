package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hn;

public final class RealTimeMessage
  implements Parcelable
{
  public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator()
  {
    public RealTimeMessage bn(Parcel paramAnonymousParcel)
    {
      return new RealTimeMessage(paramAnonymousParcel, null);
    }
    
    public RealTimeMessage[] cz(int paramAnonymousInt)
    {
      return new RealTimeMessage[paramAnonymousInt];
    }
  };
  public static final int RELIABLE = 1;
  public static final int UNRELIABLE = 0;
  private final String Te;
  private final byte[] Tf;
  private final int Tg;
  
  private RealTimeMessage(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
  }
  
  public RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    this.Te = ((String)hn.f(paramString));
    this.Tf = ((byte[])((byte[])hn.f(paramArrayOfByte)).clone());
    this.Tg = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getMessageData()
  {
    return this.Tf;
  }
  
  public String getSenderParticipantId()
  {
    return this.Te;
  }
  
  public boolean isReliable()
  {
    return this.Tg == 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.Te);
    paramParcel.writeByteArray(this.Tf);
    paramParcel.writeInt(this.Tg);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RealTimeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */