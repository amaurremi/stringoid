package com.google.android.gms.games.internal;

import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.b;

final class cb
  extends hb<IGamesService>.b<QuestUpdateListener>
{
  private final Quest b;
  
  cb(GamesClientImpl paramGamesClientImpl, QuestUpdateListener paramQuestUpdateListener, Quest paramQuest)
  {
    super(paramGamesClientImpl, paramQuestUpdateListener);
    this.b = paramQuest;
  }
  
  protected void a(QuestUpdateListener paramQuestUpdateListener)
  {
    paramQuestUpdateListener.onQuestCompleted(this.b);
  }
  
  protected void fu() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */