package com.millennialmedia.android;

import com.millennialmedia.google.gson.annotations.SerializedName;

class DTOAdViewLayout
{
  int height;
  int width;
  @SerializedName("x")
  int xWindowPosition;
  @SerializedName("y")
  int yWindowPosition;
  
  DTOAdViewLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.xWindowPosition = paramInt1;
    this.yWindowPosition = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/DTOAdViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */