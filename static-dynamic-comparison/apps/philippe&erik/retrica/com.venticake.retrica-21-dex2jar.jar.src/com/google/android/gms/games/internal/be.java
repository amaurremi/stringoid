package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import java.util.List;

final class be
  implements Players.LoadXpForGameCategoriesResult
{
  private final Status a;
  private final List<String> b;
  private final Bundle c;
  
  be(Status paramStatus, Bundle paramBundle)
  {
    this.a = paramStatus;
    this.b = paramBundle.getStringArrayList("game_category_list");
    this.c = paramBundle;
  }
  
  public Status getStatus()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */