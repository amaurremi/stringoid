package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;

final class cd
  extends AbstractGamesCallbacks
{
  private final QuestUpdateListener b;
  
  cd(GamesClientImpl paramGamesClientImpl, QuestUpdateListener paramQuestUpdateListener)
  {
    this.b = paramQuestUpdateListener;
  }
  
  private Quest a(DataHolder paramDataHolder)
  {
    QuestBuffer localQuestBuffer = new QuestBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localQuestBuffer.getCount() > 0) {
        paramDataHolder = (Quest)((Quest)localQuestBuffer.get(0)).freeze();
      }
      return paramDataHolder;
    }
    finally
    {
      localQuestBuffer.close();
    }
  }
  
  public void M(DataHolder paramDataHolder)
  {
    paramDataHolder = a(paramDataHolder);
    if (paramDataHolder != null) {
      this.a.a(new cb(this.a, this.b, paramDataHolder));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */