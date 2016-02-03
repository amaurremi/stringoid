package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;

final class ch
  extends AbstractGamesCallbacks
{
  private final OnRequestReceivedListener b;
  
  ch(GamesClientImpl paramGamesClientImpl, OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    this.b = paramOnRequestReceivedListener;
  }
  
  public void o(DataHolder paramDataHolder)
  {
    GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localGameRequestBuffer.getCount() > 0) {
        paramDataHolder = (GameRequest)((GameRequest)localGameRequestBuffer.get(0)).freeze();
      }
      localGameRequestBuffer.close();
      if (paramDataHolder != null) {
        this.a.a(new ci(this.a, this.b, paramDataHolder));
      }
      return;
    }
    finally
    {
      localGameRequestBuffer.close();
    }
  }
  
  public void onRequestRemoved(String paramString)
  {
    this.a.a(new cj(this.a, this.b, paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */