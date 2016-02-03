package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

public final class b
  extends e
  implements Invitation
{
  private final ArrayList<Participant> vQ;
  private final Game wd;
  private final d we;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return InvitationEntity.a(this, paramObject);
  }
  
  public int hashCode()
  {
    return InvitationEntity.a(this);
  }
  
  public Game nX()
  {
    return this.wd;
  }
  
  public String nY()
  {
    return getString("external_invitation_id");
  }
  
  public Participant nZ()
  {
    return this.we;
  }
  
  public long oa()
  {
    return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
  }
  
  public int ob()
  {
    return getInteger("type");
  }
  
  public int oc()
  {
    return getInteger("variant");
  }
  
  public int od()
  {
    if (!getBoolean("has_automatch_criteria")) {
      return 0;
    }
    return getInteger("automatch_max_players");
  }
  
  public ArrayList<Participant> oe()
  {
    return this.vQ;
  }
  
  public Invitation of()
  {
    return new InvitationEntity(this);
  }
  
  public String toString()
  {
    return InvitationEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((InvitationEntity)of()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */