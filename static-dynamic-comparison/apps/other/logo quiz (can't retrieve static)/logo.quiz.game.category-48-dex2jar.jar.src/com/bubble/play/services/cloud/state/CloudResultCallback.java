package com.bubble.play.services.cloud.state;

import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;

public abstract interface CloudResultCallback
{
  public abstract void processStateConflict(AppStateManager.StateConflictResult paramStateConflictResult);
  
  public abstract void processStateLoaded(AppStateManager.StateLoadedResult paramStateLoadedResult);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/cloud/state/CloudResultCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */