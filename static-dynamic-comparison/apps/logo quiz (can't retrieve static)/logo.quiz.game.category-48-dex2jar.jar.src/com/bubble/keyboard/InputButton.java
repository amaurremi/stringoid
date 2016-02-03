package com.bubble.keyboard;

import android.widget.Button;

public class InputButton
{
  private Button button;
  private char correctAnswerChar;
  private int id;
  private boolean isClickable = true;
  
  public InputButton(int paramInt, Button paramButton, char paramChar)
  {
    this.id = paramInt;
    this.button = paramButton;
    this.correctAnswerChar = paramChar;
  }
  
  public Button getButton()
  {
    return this.button;
  }
  
  public char getCorrectAnswerChar()
  {
    return this.correctAnswerChar;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public boolean isClickable()
  {
    return this.isClickable;
  }
  
  public boolean isUsed()
  {
    return !this.button.getText().equals("");
  }
  
  public void setButton(Button paramButton)
  {
    this.button = paramButton;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.isClickable = paramBoolean;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/InputButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */