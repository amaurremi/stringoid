package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl
  implements Quests
{
  public PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.b(new k(paramString)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.i(this, paramString);
      }
    });
  }
  
  public PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.b(new l(paramString1)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.b(this, paramString1, paramString2);
      }
    });
  }
  
  public Intent getQuestIntent(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return Games.c(paramGoogleApiClient).aU(paramString);
  }
  
  public Intent getQuestsIntent(GoogleApiClient paramGoogleApiClient, int[] paramArrayOfInt)
  {
    return Games.c(paramGoogleApiClient).a(paramArrayOfInt);
  }
  
  public PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient paramGoogleApiClient, final int[] paramArrayOfInt, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.a(new m(paramArrayOfInt)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.a(this, paramArrayOfInt, paramInt, paramBoolean);
      }
    });
  }
  
  public PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final String... paramVarArgs)
  {
    paramGoogleApiClient.a(new m(paramBoolean)
    {
      protected void a(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.b(this, paramBoolean, paramVarArgs);
      }
    });
  }
  
  public void registerQuestUpdateListener(GoogleApiClient paramGoogleApiClient, QuestUpdateListener paramQuestUpdateListener)
  {
    Games.c(paramGoogleApiClient).a(paramQuestUpdateListener);
  }
  
  public void unregisterQuestUpdateListener(GoogleApiClient paramGoogleApiClient)
  {
    Games.c(paramGoogleApiClient).hj();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/api/QuestsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */