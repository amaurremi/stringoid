package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

final class ac
  extends AbstractGamesCallbacks
{
  private final OnInvitationReceivedListener b;
  
  ac(GamesClientImpl paramGamesClientImpl, OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    this.b = paramOnInvitationReceivedListener;
  }
  
  public void n(DataHolder paramDataHolder)
  {
    InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localInvitationBuffer.getCount() > 0) {
        paramDataHolder = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
      }
      localInvitationBuffer.close();
      if (paramDataHolder != null) {
        this.a.a(new ad(this.a, this.b, paramDataHolder));
      }
      return;
    }
    finally
    {
      localInvitationBuffer.close();
    }
  }
  
  public void onInvitationRemoved(String paramString)
  {
    this.a.a(new ae(this.a, this.b, paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */