package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

public final class TurnBasedMatchRef
  extends d
  implements TurnBasedMatch
{
  private final int RD;
  private final Game Sp;
  
  TurnBasedMatchRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Sp = new GameRef(paramDataHolder, paramInt1);
    this.RD = paramInt2;
  }
  
  public boolean canRematch()
  {
    return (getTurnStatus() == 3) && (getRematchId() == null) && (getParticipants().size() > 1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return TurnBasedMatchEntity.a(this, paramObject);
  }
  
  public TurnBasedMatch freeze()
  {
    return new TurnBasedMatchEntity(this);
  }
  
  public Bundle getAutoMatchCriteria()
  {
    if (!getBoolean("has_automatch_criteria")) {
      return null;
    }
    return TurnBasedMatchConfig.createAutoMatchCriteria(getInteger("automatch_min_players"), getInteger("automatch_max_players"), getLong("automatch_bit_mask"));
  }
  
  public int getAvailableAutoMatchSlots()
  {
    if (!getBoolean("has_automatch_criteria")) {
      return 0;
    }
    return getInteger("automatch_max_players");
  }
  
  public long getCreationTimestamp()
  {
    return getLong("creation_timestamp");
  }
  
  public String getCreatorId()
  {
    return getString("creator_external");
  }
  
  public byte[] getData()
  {
    return getByteArray("data");
  }
  
  public String getDescription()
  {
    return getString("description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    a("description", paramCharArrayBuffer);
  }
  
  public Participant getDescriptionParticipant()
  {
    return getParticipant(getDescriptionParticipantId());
  }
  
  public String getDescriptionParticipantId()
  {
    return getString("description_participant_id");
  }
  
  public Game getGame()
  {
    return this.Sp;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return getLong("last_updated_timestamp");
  }
  
  public String getLastUpdaterId()
  {
    return getString("last_updater_external");
  }
  
  public String getMatchId()
  {
    return getString("external_match_id");
  }
  
  public int getMatchNumber()
  {
    return getInteger("match_number");
  }
  
  public Participant getParticipant(String paramString)
  {
    return TurnBasedMatchEntity.c(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return TurnBasedMatchEntity.b(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return TurnBasedMatchEntity.c(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return TurnBasedMatchEntity.a(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    ArrayList localArrayList = new ArrayList(this.RD);
    int i = 0;
    while (i < this.RD)
    {
      localArrayList.add(new ParticipantRef(this.DD, this.Ez + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public String getPendingParticipantId()
  {
    return getString("pending_participant_external");
  }
  
  public byte[] getPreviousMatchData()
  {
    return getByteArray("previous_match_data");
  }
  
  public String getRematchId()
  {
    return getString("rematch_id");
  }
  
  public int getStatus()
  {
    return getInteger("status");
  }
  
  public int getTurnStatus()
  {
    return getInteger("user_match_status");
  }
  
  public int getVariant()
  {
    return getInteger("variant");
  }
  
  public int getVersion()
  {
    return getInteger("version");
  }
  
  public int hashCode()
  {
    return TurnBasedMatchEntity.a(this);
  }
  
  public boolean isLocallyModified()
  {
    return getBoolean("upsync_required");
  }
  
  public String toString()
  {
    return TurnBasedMatchEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((TurnBasedMatchEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */