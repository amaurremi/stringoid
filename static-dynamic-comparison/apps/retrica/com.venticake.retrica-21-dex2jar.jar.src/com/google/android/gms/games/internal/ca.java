package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.internal.hm;

final class ca
  extends AbstractGamesCallbacks
{
  private final a.d<Quests.AcceptQuestResult> b;
  
  public ca(a.d<Quests.AcceptQuestResult> paramd)
  {
    Object localObject;
    this.b = ((a.d)hm.b(localObject, "Holder must not be null"));
  }
  
  public void L(DataHolder paramDataHolder)
  {
    this.b.a(new d(paramDataHolder));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */