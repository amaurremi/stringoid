package com.google.android.gms.games.internal.data;

import android.net.Uri;
import android.net.Uri.Builder;

public final class GamesDataChangeUris
{
  private static final Uri Rg = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
  public static final Uri Rh = Rg.buildUpon().appendPath("invitations").build();
  public static final Uri Ri = Rg.buildUpon().appendEncodedPath("players").build();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/data/GamesDataChangeUris.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */