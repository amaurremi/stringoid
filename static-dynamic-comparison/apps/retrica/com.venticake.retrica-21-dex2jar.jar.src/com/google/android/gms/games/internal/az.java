package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

final class az
  extends b
  implements Quests.LoadQuestsResult
{
  private final DataHolder a;
  
  az(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.a = paramDataHolder;
  }
  
  public QuestBuffer getQuests()
  {
    return new QuestBuffer(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */