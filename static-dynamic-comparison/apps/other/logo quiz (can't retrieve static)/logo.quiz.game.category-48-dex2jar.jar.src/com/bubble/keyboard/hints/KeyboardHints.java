package com.bubble.keyboard.hints;

public abstract interface KeyboardHints
{
  public abstract boolean closeSelectedLetters();
  
  public abstract void fullAnswer();
  
  public abstract void fullAnswer(boolean paramBoolean);
  
  public abstract boolean isBombs();
  
  public abstract void showRandomLetter();
  
  public abstract void showRandomLetters(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void showSelectedLetter();
  
  public abstract void useBomb();
  
  public abstract void useBomb(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/hints/KeyboardHints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */