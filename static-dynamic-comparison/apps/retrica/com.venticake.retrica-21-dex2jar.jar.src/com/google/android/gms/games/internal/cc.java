package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.internal.hm;

final class cc
  extends AbstractGamesCallbacks
{
  private final a.d<Quests.ClaimMilestoneResult> b;
  private final String c;
  
  public cc(a.d<Quests.ClaimMilestoneResult> paramd, String paramString)
  {
    this.b = ((a.d)hm.b(paramString, "Holder must not be null"));
    Object localObject;
    this.c = ((String)hm.b(localObject, "MilestoneId must not be null"));
  }
  
  public void K(DataHolder paramDataHolder)
  {
    this.b.a(new h(paramDataHolder, this.c));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */