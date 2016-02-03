package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Player;

public final class d
  extends e
  implements Participant
{
  private final com.google.android.gms.games.d wf;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.wf = new com.google.android.gms.games.d(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.a(this, paramObject);
  }
  
  public int getCapabilities()
  {
    return getInteger("capabilities");
  }
  
  public String getDisplayName()
  {
    if (aq("external_player_id")) {
      return getString("default_display_name");
    }
    return this.wf.getDisplayName();
  }
  
  public int getStatus()
  {
    return getInteger("player_status");
  }
  
  public int hashCode()
  {
    return ParticipantEntity.a(this);
  }
  
  public Uri nC()
  {
    if (aq("external_player_id")) {
      return ap("default_display_image_uri");
    }
    return this.wf.nC();
  }
  
  public String nD()
  {
    if (aq("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.wf.nD();
  }
  
  public Uri nE()
  {
    if (aq("external_player_id")) {
      return ap("default_display_hi_res_image_uri");
    }
    return this.wf.nE();
  }
  
  public String nF()
  {
    if (aq("external_player_id")) {
      return getString("default_display_hi_res_image_url");
    }
    return this.wf.nF();
  }
  
  public String og()
  {
    return getString("client_address");
  }
  
  public boolean oh()
  {
    return getInteger("connected") > 0;
  }
  
  public String oi()
  {
    return getString("external_participant_id");
  }
  
  public Player oj()
  {
    if (aq("external_player_id")) {
      return null;
    }
    return this.wf;
  }
  
  public ParticipantResult ok()
  {
    if (aq("result_type")) {
      return null;
    }
    int i = getInteger("result_type");
    int j = getInteger("placing");
    return new ParticipantResult(oi(), i, j);
  }
  
  public Participant ol()
  {
    return new ParticipantEntity(this);
  }
  
  public String toString()
  {
    return ParticipantEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)ol()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */