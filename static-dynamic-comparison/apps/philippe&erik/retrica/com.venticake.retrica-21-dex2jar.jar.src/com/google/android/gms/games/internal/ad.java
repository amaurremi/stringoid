package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class ad
  extends hb<IGamesService>.b<OnInvitationReceivedListener>
{
  private final Invitation b;
  
  ad(GamesClientImpl paramGamesClientImpl, OnInvitationReceivedListener paramOnInvitationReceivedListener, Invitation paramInvitation)
  {
    super(paramGamesClientImpl, paramOnInvitationReceivedListener);
    this.b = paramInvitation;
  }
  
  protected void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    paramOnInvitationReceivedListener.onInvitationReceived(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */