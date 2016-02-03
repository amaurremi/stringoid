package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef
  extends d
  implements ExperienceEvent
{
  private final GameRef aam;
  
  public ExperienceEventRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    if (aS("external_game_id"))
    {
      this.aam = null;
      return;
    }
    this.aam = new GameRef(this.IC, this.JQ);
  }
  
  public String getIconImageUrl()
  {
    return getString("icon_url");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/experience/ExperienceEventRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */