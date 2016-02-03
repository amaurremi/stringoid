package com.bubble.bugsense;

import android.content.Context;
import android.content.res.Resources;
import com.bugsense.trace.BugSenseHandler;

public class BugSense
{
  private boolean isEnable = false;
  
  public BugSense(Context paramContext)
  {
    String str = getBugsenseApiKey(paramContext);
    if ((str != null) && (!str.equals(""))) {}
    try
    {
      BugSenseHandler.initAndStartSession(paramContext, str);
      this.isEnable = true;
      return;
    }
    catch (Exception paramContext)
    {
      this.isEnable = false;
    }
  }
  
  public void addCrashExtraData(String paramString1, String paramString2)
  {
    if (this.isEnable) {}
    try
    {
      BugSenseHandler.addCrashExtraData(paramString1, paramString2);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  protected String getBugsenseApiKey(Context paramContext)
  {
    return paramContext.getString(paramContext.getResources().getIdentifier("bug_sense_key", "string", paramContext.getPackageName()));
  }
  
  public void sendExceptionMessage(String paramString1, String paramString2, Exception paramException)
  {
    if (this.isEnable) {}
    try
    {
      BugSenseHandler.sendExceptionMessage(paramString1, paramString2, paramException);
      return;
    }
    catch (Exception paramString1) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/bugsense/BugSense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */