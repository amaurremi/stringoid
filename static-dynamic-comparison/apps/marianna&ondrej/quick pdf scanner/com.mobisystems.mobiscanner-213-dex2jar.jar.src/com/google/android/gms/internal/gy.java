package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class gy
  implements SafeParcelable, Invitation
{
  public static final ei MF = new ei();
  private final ArrayList<InvitationEntity> MG;
  private final int qh;
  
  gy(int paramInt, ArrayList<InvitationEntity> paramArrayList)
  {
    this.qh = paramInt;
    this.MG = paramArrayList;
    rb();
  }
  
  private void rb()
  {
    if (!this.MG.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      cq.G(bool);
      Invitation localInvitation1 = (Invitation)this.MG.get(0);
      int j = this.MG.size();
      int i = 1;
      while (i < j)
      {
        Invitation localInvitation2 = (Invitation)this.MG.get(i);
        cq.a(localInvitation1.nZ().equals(localInvitation2.nZ()), "All the invitations must be from the same inviter");
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
    if (!(paramObject instanceof gy)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (gy)paramObject;
    if (((gy)paramObject).MG.size() != this.MG.size()) {
      return false;
    }
    int j = this.MG.size();
    int i = 0;
    while (i < j)
    {
      if (!((Invitation)this.MG.get(i)).equals((Invitation)((gy)paramObject).MG.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    return cz.hashCode(this.MG.toArray());
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public Game nX()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String nY()
  {
    return ((InvitationEntity)this.MG.get(0)).nY();
  }
  
  public Participant nZ()
  {
    return ((InvitationEntity)this.MG.get(0)).nZ();
  }
  
  public long oa()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int ob()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int oc()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int od()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public ArrayList<Participant> oe()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Invitation of()
  {
    return this;
  }
  
  public ArrayList<Invitation> rc()
  {
    return new ArrayList(this.MG);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ei.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */