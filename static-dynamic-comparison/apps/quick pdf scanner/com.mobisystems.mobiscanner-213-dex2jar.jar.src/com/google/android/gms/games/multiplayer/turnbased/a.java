package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.d;
import java.util.ArrayList;

public final class a
  extends e
  implements TurnBasedMatch
{
  private final int IN;
  private final Game wd;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return TurnBasedMatchEntity.a(this, paramObject);
  }
  
  public byte[] getData()
  {
    return getByteArray("data");
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public int getStatus()
  {
    return getInteger("status");
  }
  
  public int getVersion()
  {
    return getInteger("version");
  }
  
  public int hashCode()
  {
    return TurnBasedMatchEntity.a(this);
  }
  
  public Game nX()
  {
    return this.wd;
  }
  
  public int oA()
  {
    return getInteger("match_number");
  }
  
  public boolean oB()
  {
    return getBoolean("upsync_required");
  }
  
  public String oC()
  {
    return getString("description_participant_id");
  }
  
  public TurnBasedMatch oD()
  {
    return new TurnBasedMatchEntity(this);
  }
  
  public long oa()
  {
    return getLong("creation_timestamp");
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
    ArrayList localArrayList = new ArrayList(this.IN);
    int i = 0;
    while (i < this.IN)
    {
      localArrayList.add(new d(this.rM, this.se + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public String op()
  {
    return getString("creator_external");
  }
  
  public Bundle oq()
  {
    if (!getBoolean("has_automatch_criteria")) {
      return null;
    }
    return b.a(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
  }
  
  public String ot()
  {
    return getString("external_match_id");
  }
  
  public int ou()
  {
    return getInteger("user_match_status");
  }
  
  public String ov()
  {
    return getString("last_updater_external");
  }
  
  public long ow()
  {
    return getLong("last_updated_timestamp");
  }
  
  public String ox()
  {
    return getString("pending_participant_external");
  }
  
  public String oy()
  {
    return getString("rematch_id");
  }
  
  public byte[] oz()
  {
    return getByteArray("previous_match_data");
  }
  
  public String toString()
  {
    return TurnBasedMatchEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((TurnBasedMatchEntity)oD()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */