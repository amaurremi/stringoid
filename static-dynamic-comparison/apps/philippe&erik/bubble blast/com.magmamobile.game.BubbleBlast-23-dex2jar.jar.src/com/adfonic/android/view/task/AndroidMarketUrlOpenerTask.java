package com.adfonic.android.view.task;

public abstract class AndroidMarketUrlOpenerTask
  extends UrlOpenerTask
{
  protected void onUrlReceived(String paramString)
  {
    openAndroidMarket(paramString);
  }
  
  protected void openUrl(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/view/task/AndroidMarketUrlOpenerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */