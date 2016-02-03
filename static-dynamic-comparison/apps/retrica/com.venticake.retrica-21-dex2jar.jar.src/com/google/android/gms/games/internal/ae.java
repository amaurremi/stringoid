package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class ae
  extends hb<IGamesService>.b<OnInvitationReceivedListener>
{
  private final String b;
  
  ae(GamesClientImpl paramGamesClientImpl, OnInvitationReceivedListener paramOnInvitationReceivedListener, String paramString)
  {
    super(paramGamesClientImpl, paramOnInvitationReceivedListener);
    this.b = paramString;
  }
  
  protected void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    paramOnInvitationReceivedListener.onInvitationRemoved(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */