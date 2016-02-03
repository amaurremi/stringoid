package com.bubble.keyboard.cloud.save;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluebird.mobile.tools.storage.SharedPreferencesUtils;
import com.bubble.keyboard.KeyboardState;
import java.io.Serializable;
import java.util.List;

public class KeyboardStateTO
  implements Serializable
{
  boolean isLogoGuessBefore;
  String keyboardId;
  String keyboardShuffleChars;
  String keyboardShuffleCharsCorrects;
  List<String> usedInputLetters;
  List<String> usedInputLettersCorrect;
  List<String> usedKeyboardLetters;
  List<String> usedKeyboardLettersOnly;
  
  public KeyboardStateTO(String paramString, Context paramContext)
  {
    this.keyboardId = paramString;
    if (paramString != null)
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("KEYBOARD_SETTINGS_FILE", 0);
      this.usedInputLetters = SharedPreferencesUtils.getStringArrayPref(localSharedPreferences, KeyboardState.USED_KEYBOARD_LETTERS + paramString);
      this.usedInputLettersCorrect = SharedPreferencesUtils.getStringArrayPref(localSharedPreferences, KeyboardState.USED_INPUT_LETTERS_CORRECT + paramString);
      this.usedKeyboardLetters = SharedPreferencesUtils.getStringArrayPref(localSharedPreferences, KeyboardState.USED_INPUT_LETTERS + paramString);
      this.usedKeyboardLettersOnly = SharedPreferencesUtils.getStringArrayPref(localSharedPreferences, KeyboardState.USED_KEYBOARD_LETTERS_ONLY + paramString);
      paramContext = paramContext.getSharedPreferences("KEYBOARD_HELPER_SETTINGS_FILE", 0);
      this.isLogoGuessBefore = paramContext.getBoolean("LOGO_GUESS_BEFORE_" + paramString, false);
      this.keyboardShuffleChars = paramContext.getString("LOGO_NAME_NAME_SHUFFLE_CHARS_" + paramString, null);
      this.keyboardShuffleCharsCorrects = paramContext.getString("LOGO_NAME_SHUFFLE_CORRECTS_" + paramString, null);
    }
  }
  
  public void loadKeyboardState(Context paramContext)
  {
    try
    {
      if (this.keyboardId != null)
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("KEYBOARD_SETTINGS_FILE", 0);
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        SharedPreferencesUtils.setStringArrayPref(localSharedPreferences, KeyboardState.USED_INPUT_LETTERS + this.keyboardId, this.usedInputLetters);
        SharedPreferencesUtils.setStringArrayPref(localSharedPreferences, KeyboardState.USED_INPUT_LETTERS_CORRECT + this.keyboardId, this.usedInputLettersCorrect);
        SharedPreferencesUtils.setStringArrayPref(localSharedPreferences, KeyboardState.USED_KEYBOARD_LETTERS + this.keyboardId, this.usedKeyboardLetters);
        SharedPreferencesUtils.setStringArrayPref(localSharedPreferences, KeyboardState.USED_KEYBOARD_LETTERS_ONLY + this.keyboardId, this.usedKeyboardLettersOnly);
        localEditor.commit();
        paramContext = paramContext.getSharedPreferences("KEYBOARD_HELPER_SETTINGS_FILE", 0).edit();
        paramContext.putBoolean("LOGO_GUESS_BEFORE_" + this.keyboardId, this.isLogoGuessBefore);
        paramContext.putString("LOGO_NAME_NAME_SHUFFLE_CHARS_" + this.keyboardId, this.keyboardShuffleChars);
        paramContext.putString("LOGO_NAME_SHUFFLE_CORRECTS_" + this.keyboardId, this.keyboardShuffleCharsCorrects);
        paramContext.commit();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/cloud/save/KeyboardStateTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */