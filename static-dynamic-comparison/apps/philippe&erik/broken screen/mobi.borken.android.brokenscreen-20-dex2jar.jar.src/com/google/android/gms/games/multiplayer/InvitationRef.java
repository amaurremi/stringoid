package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;

public final class InvitationRef
  extends d
  implements Invitation
{
  private final ArrayList<Participant> SU;
  private final ParticipantRef SX;
  private final Game Sp;
  
  InvitationRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Sp = new GameRef(paramDataHolder, paramInt1);
    this.SU = new ArrayList(paramInt2);
    String str = getString("external_inviter_id");
    paramInt1 = 0;
    paramDataHolder = null;
    while (paramInt1 < paramInt2)
    {
      ParticipantRef localParticipantRef = new ParticipantRef(this.DD, this.Ez + paramInt1);
      if (localParticipantRef.getParticipantId().equals(str)) {
        paramDataHolder = localParticipantRef;
      }
      this.SU.add(localParticipantRef);
      paramInt1 += 1;
    }
    this.SX = ((ParticipantRef)hn.b(paramDataHolder, "Must have a valid inviter!"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return InvitationEntity.a(this, paramObject);
  }
  
  public Invitation freeze()
  {
    return new InvitationEntity(this);
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
    return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
  }
  
  public Game getGame()
  {
    return this.Sp;
  }
  
  public String getInvitationId()
  {
    return getString("external_invitation_id");
  }
  
  public int getInvitationType()
  {
    return getInteger("type");
  }
  
  public Participant getInviter()
  {
    return this.SX;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return this.SU;
  }
  
  public int getVariant()
  {
    return getInteger("variant");
  }
  
  public int hashCode()
  {
    return InvitationEntity.a(this);
  }
  
  public String toString()
  {
    return InvitationEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((InvitationEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */