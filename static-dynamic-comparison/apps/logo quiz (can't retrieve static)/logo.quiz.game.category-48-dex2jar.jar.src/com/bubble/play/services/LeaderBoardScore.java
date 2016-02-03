package com.bubble.play.services;

public class LeaderBoardScore
{
  private String leaderboardId;
  private long score;
  
  public LeaderBoardScore(String paramString, long paramLong)
  {
    this.leaderboardId = paramString;
    this.score = paramLong;
  }
  
  public String getLeaderboardId()
  {
    return this.leaderboardId;
  }
  
  public long getScore()
  {
    return this.score;
  }
  
  public void setLeaderboardId(String paramString)
  {
    this.leaderboardId = paramString;
  }
  
  public void setScore(long paramLong)
  {
    this.score = paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/LeaderBoardScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */