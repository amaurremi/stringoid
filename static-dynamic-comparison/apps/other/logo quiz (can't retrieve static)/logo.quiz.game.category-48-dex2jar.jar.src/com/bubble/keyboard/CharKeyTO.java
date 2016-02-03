package com.bubble.keyboard;

public class CharKeyTO
{
  private char character;
  private boolean isCorrect;
  
  public CharKeyTO(char paramChar, boolean paramBoolean)
  {
    this.character = Character.toUpperCase(paramChar);
    this.isCorrect = paramBoolean;
  }
  
  public char getCharacter()
  {
    return this.character;
  }
  
  public boolean isCorrect()
  {
    return this.isCorrect;
  }
  
  public void setCharacter(char paramChar)
  {
    this.character = paramChar;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/CharKeyTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */