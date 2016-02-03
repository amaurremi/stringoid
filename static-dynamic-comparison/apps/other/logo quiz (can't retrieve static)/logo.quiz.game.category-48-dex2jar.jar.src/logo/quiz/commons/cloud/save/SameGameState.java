package logo.quiz.commons.cloud.save;

import android.content.Context;

public abstract interface SameGameState
{
  public abstract byte[] getBytes();
  
  public abstract int getGuessedLogosCount(Context paramContext);
  
  public abstract int getHintsCount();
  
  public abstract void loadPurchase(Context paramContext);
  
  public abstract void loadState(Context paramContext);
  
  public abstract void processStateConflict(SameGameState paramSameGameState1, SameGameState paramSameGameState2, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/cloud/save/SameGameState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */