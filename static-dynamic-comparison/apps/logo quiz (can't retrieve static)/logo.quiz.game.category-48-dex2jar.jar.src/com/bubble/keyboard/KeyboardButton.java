package com.bubble.keyboard;

import android.widget.Button;

public class KeyboardButton
{
  private Button button;
  private int id;
  private boolean isCorrect;
  private boolean isUsed = false;
  
  public KeyboardButton(int paramInt, Button paramButton, boolean paramBoolean)
  {
    this.id = paramInt;
    this.button = paramButton;
    this.isCorrect = paramBoolean;
  }
  
  public Button getButton()
  {
    return this.button;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public boolean isCorrect()
  {
    return this.isCorrect;
  }
  
  public boolean isUsed()
  {
    return (this.isUsed) || (this.button.getVisibility() != 0);
  }
  
  public void setButton(Button paramButton)
  {
    this.button = paramButton;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setUsed(boolean paramBoolean)
  {
    this.isUsed = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/KeyboardButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */