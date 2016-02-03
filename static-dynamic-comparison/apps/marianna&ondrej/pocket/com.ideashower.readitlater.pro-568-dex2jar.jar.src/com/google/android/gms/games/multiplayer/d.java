package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Player;

public final class d
  extends e
  implements Participant
{
  private final com.google.android.gms.games.d c;
  
  public d(com.google.android.gms.common.data.d paramd, int paramInt)
  {
    super(paramd, paramInt);
    this.c = new com.google.android.gms.games.d(paramd, paramInt);
  }
  
  public int b()
  {
    return b("player_status");
  }
  
  public String c()
  {
    return d("client_address");
  }
  
  public int d()
  {
    return b("capabilities");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return b("connected") > 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.a(this, paramObject);
  }
  
  public String f()
  {
    if (f("external_player_id")) {
      return d("default_display_name");
    }
    return this.c.c();
  }
  
  public Uri g()
  {
    if (f("external_player_id")) {
      return e("default_display_image_uri");
    }
    return this.c.d();
  }
  
  public Uri h()
  {
    if (f("external_player_id")) {
      return null;
    }
    return this.c.e();
  }
  
  public int hashCode()
  {
    return ParticipantEntity.a(this);
  }
  
  public String i()
  {
    return d("external_participant_id");
  }
  
  public Player j()
  {
    if (f("external_player_id")) {
      return null;
    }
    return this.c;
  }
  
  public Participant k()
  {
    return new ParticipantEntity(this);
  }
  
  public String toString()
  {
    return ParticipantEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)k()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */