package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

abstract class m
  extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult>
{
  public Quests.LoadQuestsResult a(final Status paramStatus)
  {
    new Quests.LoadQuestsResult()
    {
      public QuestBuffer getQuests()
      {
        return null;
      }
      
      public Status getStatus()
      {
        return paramStatus;
      }
      
      public void release() {}
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */