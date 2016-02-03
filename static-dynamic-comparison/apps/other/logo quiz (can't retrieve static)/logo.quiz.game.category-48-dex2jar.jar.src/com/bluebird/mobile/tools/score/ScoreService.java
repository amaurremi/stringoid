package com.bluebird.mobile.tools.score;

public abstract interface ScoreService
{
  public abstract int getGroupScore(String paramString);
  
  public abstract int getScore(int paramInt1, int paramInt2);
  
  public abstract int getScore(String paramString1, String paramString2);
  
  public abstract int getTotalScore();
  
  public abstract int levelsSubmittedCount(int paramInt1, int paramInt2);
  
  public abstract int levelsSubmittedCount(String paramString, int paramInt);
  
  public abstract void reset();
  
  public abstract boolean submitLevelScoreIfItsBetter(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean submitLevelScoreIfItsBetter(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean wasLevelSubmitted(int paramInt1, int paramInt2);
  
  public abstract boolean wasLevelSubmitted(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/score/ScoreService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */