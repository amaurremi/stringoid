package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef
  extends d
  implements Participant
{
  private final PlayerRef Te;
  
  public ParticipantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.Te = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.a(this, paramObject);
  }
  
  public Participant freeze()
  {
    return new ParticipantEntity(this);
  }
  
  public String gW()
  {
    return getString("client_address");
  }
  
  public int getCapabilities()
  {
    return getInteger("capabilities");
  }
  
  public String getDisplayName()
  {
    if (ax("external_player_id")) {
      return getString("default_display_name");
    }
    return this.Te.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (ax("external_player_id"))
    {
      a("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.Te.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (ax("external_player_id")) {
      return aw("default_display_hi_res_image_uri");
    }
    return this.Te.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (ax("external_player_id")) {
      return getString("default_display_hi_res_image_url");
    }
    return this.Te.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (ax("external_player_id")) {
      return aw("default_display_image_uri");
    }
    return this.Te.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (ax("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.Te.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return getString("external_participant_id");
  }
  
  public Player getPlayer()
  {
    if (ax("external_player_id")) {
      return null;
    }
    return this.Te;
  }
  
  public ParticipantResult getResult()
  {
    if (ax("result_type")) {
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */