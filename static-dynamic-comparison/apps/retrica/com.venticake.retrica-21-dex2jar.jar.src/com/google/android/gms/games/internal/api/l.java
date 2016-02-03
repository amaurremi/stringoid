package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;

abstract class l
  extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult>
{
  public Quests.ClaimMilestoneResult a(final Status paramStatus)
  {
    new Quests.ClaimMilestoneResult()
    {
      public Milestone getMilestone()
      {
        return null;
      }
      
      public Quest getQuest()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */