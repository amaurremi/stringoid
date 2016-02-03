package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;

final class bf
  extends b
  implements Players.LoadXpStreamResult
{
  private final ExperienceEventBuffer a;
  
  bf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = new ExperienceEventBuffer(paramDataHolder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */