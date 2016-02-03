package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

final class ah
  extends b
  implements Leaderboards.LeaderboardMetadataResult
{
  private final LeaderboardBuffer a;
  
  ah(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new LeaderboardBuffer(paramDataHolder);
  }
  
  public LeaderboardBuffer getLeaderboards()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */