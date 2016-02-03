package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;

final class at
  extends b
  implements Invitations.LoadInvitationsResult
{
  private final InvitationBuffer a;
  
  at(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new InvitationBuffer(paramDataHolder);
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */