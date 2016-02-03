package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.d;
import java.util.ArrayList;

public final class c
  extends e
  implements Room
{
  private final int IN;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return RoomEntity.a(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public int getStatus()
  {
    return getInteger("status");
  }
  
  public int hashCode()
  {
    return RoomEntity.a(this);
  }
  
  public long oa()
  {
    return getLong("creation_timestamp");
  }
  
  public int oc()
  {
    return getInteger("variant");
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
  
  public String oo()
  {
    return getString("external_match_id");
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
    return a.a(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
  }
  
  public int or()
  {
    return getInteger("automatch_wait_estimate_sec");
  }
  
  public Room os()
  {
    return new RoomEntity(this);
  }
  
  public String toString()
  {
    return RoomEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((RoomEntity)os()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */