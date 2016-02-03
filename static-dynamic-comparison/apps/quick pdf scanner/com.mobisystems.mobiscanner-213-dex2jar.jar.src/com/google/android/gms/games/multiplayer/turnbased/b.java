package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;

public final class b
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */