package com.google.android.gms.games.internal;

import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class cj
  extends hb<IGamesService>.b<OnRequestReceivedListener>
{
  private final String b;
  
  cj(GamesClientImpl paramGamesClientImpl, OnRequestReceivedListener paramOnRequestReceivedListener, String paramString)
  {
    super(paramGamesClientImpl, paramOnRequestReceivedListener);
    this.b = paramString;
  }
  
  protected void a(OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    paramOnRequestReceivedListener.onRequestRemoved(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */