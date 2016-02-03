package com.bluebird.mobile.tools.score;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class GroupServiceImpl
  implements GroupService
{
  private SharedPreferences sharedPreferences;
  
  public GroupServiceImpl(Context paramContext)
  {
    this.sharedPreferences = paramContext.getSharedPreferences("groupService", 0);
  }
  
  public boolean isGroupOpen(int paramInt)
  {
    return isGroupOpen(String.valueOf(paramInt), false);
  }
  
  public boolean isGroupOpen(int paramInt, boolean paramBoolean)
  {
    return isGroupOpen(String.valueOf(paramInt), paramBoolean);
  }
  
  public boolean isGroupOpen(String paramString)
  {
    return isGroupOpen(paramString, false);
  }
  
  public boolean isGroupOpen(String paramString, boolean paramBoolean)
  {
    return this.sharedPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public void openGroup(int paramInt)
  {
    openGroup(String.valueOf(paramInt));
  }
  
  public void openGroup(String paramString)
  {
    this.sharedPreferences.edit().putBoolean(paramString, true).commit();
  }
  
  public void reset()
  {
    this.sharedPreferences.edit().clear().commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/score/GroupServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */