package com.bubble.keyboard;

import android.view.View;
import java.util.List;

public abstract interface TextField
{
  public abstract boolean closeSelectedLetters();
  
  public abstract String getAnswerLetters();
  
  public abstract View getCompleteLayout();
  
  public abstract List<InputButton> getInputButtons();
  
  public abstract View getLayout();
  
  public abstract TextFieldListener getListener();
  
  public abstract void init(String paramString, char[] paramArrayOfChar);
  
  public abstract void setAnswerListener(AnswerListener paramAnswerListener);
  
  public abstract void setInputClickable(boolean paramBoolean);
  
  public abstract void setOnClickInputButtonListener(OnClickInputButtonListener paramOnClickInputButtonListener);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/TextField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */