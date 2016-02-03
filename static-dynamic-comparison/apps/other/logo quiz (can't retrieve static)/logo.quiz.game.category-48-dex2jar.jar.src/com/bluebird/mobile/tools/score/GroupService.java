package com.bluebird.mobile.tools.score;

public abstract interface GroupService
{
  public abstract boolean isGroupOpen(int paramInt);
  
  public abstract boolean isGroupOpen(int paramInt, boolean paramBoolean);
  
  public abstract boolean isGroupOpen(String paramString);
  
  public abstract boolean isGroupOpen(String paramString, boolean paramBoolean);
  
  public abstract void openGroup(int paramInt);
  
  public abstract void openGroup(String paramString);
  
  public abstract void reset();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/score/GroupService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */