package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;

public final class a
{
  public static Bundle a(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("min_automatch_players", paramInt1);
    localBundle.putInt("max_automatch_players", paramInt2);
    localBundle.putLong("exclusive_bit_mask", paramLong);
    return localBundle;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */