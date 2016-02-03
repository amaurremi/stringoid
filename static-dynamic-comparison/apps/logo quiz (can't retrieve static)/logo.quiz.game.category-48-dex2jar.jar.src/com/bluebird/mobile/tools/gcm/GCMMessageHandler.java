package com.bluebird.mobile.tools.gcm;

import android.content.Context;
import android.content.Intent;

public abstract interface GCMMessageHandler
{
  public abstract boolean canHandle(String paramString);
  
  public abstract void handle(Intent paramIntent, Context paramContext);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/gcm/GCMMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */