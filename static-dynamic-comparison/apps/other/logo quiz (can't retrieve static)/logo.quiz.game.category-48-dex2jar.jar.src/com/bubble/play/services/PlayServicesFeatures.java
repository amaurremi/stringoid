package com.bubble.play.services;

import com.bubble.play.services.cloud.state.CloudResultCallback;
import java.util.List;

public abstract interface PlayServicesFeatures
{
  public abstract void hideSignInPopUp();
  
  public abstract void incrementAchievement(String paramString, int paramInt);
  
  public abstract boolean isCloudAutoSync();
  
  public abstract boolean isLoginCheck();
  
  public abstract void loadCloud(int paramInt, CloudResultCallback paramCloudResultCallback);
  
  public abstract void resolveCloudConflict(int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract void setCloudAutoSync(boolean paramBoolean);
  
  public abstract void setLoginCheck(boolean paramBoolean);
  
  public abstract void showAchievements();
  
  public abstract void showAndSubmitLeaderBoard(String paramString, long paramLong);
  
  public abstract void showAndSubmitLeaderBoards(List<LeaderBoardScore> paramList);
  
  public abstract void showLeaderBoard(String paramString);
  
  public abstract void showLeaderBoards();
  
  public abstract void showLoginPopUpAfterLaunches(int paramInt);
  
  public abstract void submitLeaderBoardScore(String paramString, long paramLong);
  
  public abstract void unlockAchievement(String paramString);
  
  public abstract void updateCloud(int paramInt, byte[] paramArrayOfByte);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/PlayServicesFeatures.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */