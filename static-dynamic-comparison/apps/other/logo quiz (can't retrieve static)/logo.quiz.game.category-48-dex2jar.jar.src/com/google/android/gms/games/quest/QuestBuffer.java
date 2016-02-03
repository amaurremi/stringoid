package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class QuestBuffer
  extends g<Quest>
{
  public QuestBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String gE()
  {
    return "external_quest_id";
  }
  
  protected Quest m(int paramInt1, int paramInt2)
  {
    return new QuestRef(this.IC, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/quest/QuestBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */