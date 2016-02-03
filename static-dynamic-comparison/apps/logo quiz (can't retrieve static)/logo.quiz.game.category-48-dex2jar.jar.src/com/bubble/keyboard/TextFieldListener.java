package com.bubble.keyboard;

public abstract interface TextFieldListener
{
  public abstract void removeLettterFromKeyboard(KeyboardButton paramKeyboardButton, boolean paramBoolean);
  
  public abstract void removeLettterFromKeyboardWithAnimation(KeyboardButton paramKeyboardButton, boolean paramBoolean);
  
  public abstract void setLetter(KeyboardButton paramKeyboardButton);
  
  public abstract void setLetter(KeyboardButton paramKeyboardButton, InputButton paramInputButton);
  
  public abstract void setLetterOnCorrectPositionWithAnimation(KeyboardButton paramKeyboardButton, InputButton paramInputButton);
  
  public abstract void setLetterOnPosition(KeyboardButton paramKeyboardButton, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/TextFieldListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */