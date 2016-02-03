package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;

public final class d
  extends b
  implements Participant
{
  private final com.google.android.gms.games.d wx;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.wx = new com.google.android.gms.games.d(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String dy()
  {
    return getString("client_address");
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.a(this, paramObject);
  }
  
  public Participant freeze()
  {
    return new ParticipantEntity(this);
  }
  
  public int getCapabilities()
  {
    return getInteger("capabilities");
  }
  
  public String getDisplayName()
  {
    if (M("external_player_id")) {
      return getString("default_display_name");
    }
    return this.wx.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (M("external_player_id"))
    {
      a("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.wx.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (M("external_player_id")) {
      return L("default_display_hi_res_image_uri");
    }
    return this.wx.getHiResImageUri();
  }
  
  public Uri getIconImageUri()
  {
    if (M("external_player_id")) {
      return L("default_display_image_uri");
    }
    return this.wx.getIconImageUri();
  }
  
  public String getParticipantId()
  {
    return getString("external_participant_id");
  }
  
  public Player getPlayer()
  {
    if (M("external_player_id")) {
      return null;
    }
    return this.wx;
  }
  
  public ParticipantResult getResult()
  {
    if (M("result_type")) {
      return null;
    }
    int i = getInteger("result_type");
    int j = getInteger("placing");
    return new ParticipantResult(getParticipantId(), i, j);
  }
  
  public int getStatus()
  {
    return getInteger("player_status");
  }
  
  public int hashCode()
  {
    return ParticipantEntity.a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return getInteger("connected") > 0;
  }
  
  public String toString()
  {
    return ParticipantEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */