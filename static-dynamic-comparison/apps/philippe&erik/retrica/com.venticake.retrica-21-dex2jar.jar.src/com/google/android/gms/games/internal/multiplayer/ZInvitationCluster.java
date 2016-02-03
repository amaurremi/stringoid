package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;

public final class ZInvitationCluster
  implements SafeParcelable, Invitation
{
  public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
  private final ArrayList<InvitationEntity> RH;
  private final int xM;
  
  ZInvitationCluster(int paramInt, ArrayList<InvitationEntity> paramArrayList)
  {
    this.xM = paramInt;
    this.RH = paramArrayList;
    ii();
  }
  
  private void ii()
  {
    if (!this.RH.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      gx.A(bool);
      Invitation localInvitation1 = (Invitation)this.RH.get(0);
      int j = this.RH.size();
      int i = 1;
      while (i < j)
      {
        Invitation localInvitation2 = (Invitation)this.RH.get(i);
        gx.a(localInvitation1.getInviter().equals(localInvitation2.getInviter()), "All the invitations must be from the same inviter");
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ZInvitationCluster)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ZInvitationCluster)paramObject;
    if (((ZInvitationCluster)paramObject).RH.size() != this.RH.size()) {
      return false;
    }
    int j = this.RH.size();
    int i = 0;
    while (i < j)
    {
      if (!((Invitation)this.RH.get(i)).equals((Invitation)((ZInvitationCluster)paramObject).RH.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getInvitationId()
  {
    return ((InvitationEntity)this.RH.get(0)).getInvitationId();
  }
  
  public int getInvitationType()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Participant getInviter()
  {
    return ((InvitationEntity)this.RH.get(0)).getInviter();
  }
  
  public ArrayList<Participant> getParticipants()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVariant()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(this.RH.toArray());
  }
  
  public ArrayList<Invitation> ij()
  {
    return new ArrayList(this.RH);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    InvitationClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/multiplayer/ZInvitationCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */