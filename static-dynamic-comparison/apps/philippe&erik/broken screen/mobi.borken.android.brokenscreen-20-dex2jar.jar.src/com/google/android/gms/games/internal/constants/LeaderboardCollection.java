package com.google.android.gms.games.internal.constants;

public final class LeaderboardCollection
{
  public static String cm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown leaderboard collection: " + paramInt);
    case 0: 
      return "PUBLIC";
    }
    return "SOCIAL";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/constants/LeaderboardCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */