package com.bubble.keyboard;

import android.content.Context;
import android.view.View;
import java.util.List;

public abstract interface Keyboard
{
  public abstract List<KeyboardButton> getKeyboardButtons();
  
  public abstract int getKeyboardKeysCount();
  
  public abstract View getLayout(String paramString1, String paramString2, String paramString3, Context paramContext);
  
  public abstract void setOnClickKeyboardButtonListener(OnClickKeyboardButtonListener paramOnClickKeyboardButtonListener);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/Keyboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */