package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;

abstract class f
  extends Games.BaseGamesApiMethodImpl<Invitations.LoadInvitationsResult>
{
  public Invitations.LoadInvitationsResult a(final Status paramStatus)
  {
    new Invitations.LoadInvitationsResult()
    {
      public InvitationBuffer getInvitations()
      {
        return new InvitationBuffer(DataHolder.af(14));
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */