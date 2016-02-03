package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.internal.hm;

final class ai
  extends AbstractGamesCallbacks
{
  private final a.d<Leaderboards.LoadScoresResult> b;
  
  ai(a.d<Leaderboards.LoadScoresResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
  {
    this.b.a(new bc(paramDataHolder1, paramDataHolder2));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */