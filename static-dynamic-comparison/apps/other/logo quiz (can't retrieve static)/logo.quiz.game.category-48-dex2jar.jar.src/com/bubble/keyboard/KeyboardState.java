package com.bubble.keyboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluebird.mobile.tools.storage.SharedPreferencesUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardState
{
  public static final String KEYBOARD_SETTINGS_FILE = "KEYBOARD_SETTINGS_FILE";
  public static String USED_INPUT_LETTERS = "USED_INPUT_LETTERS";
  public static String USED_INPUT_LETTERS_CORRECT = "USED_INPUT_LETTERS_CORRECT";
  public static String USED_KEYBOARD_LETTERS = "USED_KEYBOARD_LETTERS";
  public static String USED_KEYBOARD_LETTERS_ONLY = "USED_KEYBOARD_LETTERS_ONLY";
  private String keyboardId = "";
  private SharedPreferences sharedPreferences;
  
  public KeyboardState(Context paramContext)
  {
    this.sharedPreferences = paramContext.getSharedPreferences("KEYBOARD_SETTINGS_FILE", 0);
  }
  
  public static void clearAll(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("KEYBOARD_SETTINGS_FILE", 0).edit();
    paramContext.clear();
    paramContext.commit();
  }
  
  private List<Integer> parseToIntegerList(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(Integer.parseInt((String)paramList.next())));
    }
    return localArrayList;
  }
  
  public void clear()
  {
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.remove(USED_INPUT_LETTERS + this.keyboardId);
    localEditor.remove(USED_INPUT_LETTERS_CORRECT + this.keyboardId);
    localEditor.remove(USED_KEYBOARD_LETTERS + this.keyboardId);
    localEditor.remove(USED_KEYBOARD_LETTERS_ONLY + this.keyboardId);
    localEditor.commit();
  }
  
  public List<Integer> getInputKeysCorrectIds()
  {
    return parseToIntegerList(SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS_CORRECT + this.keyboardId));
  }
  
  public List<Integer> getInputKeysIds()
  {
    return parseToIntegerList(SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS + this.keyboardId));
  }
  
  public String getKeyboardId()
  {
    return this.keyboardId;
  }
  
  public List<Integer> getKeyboardKeysIds()
  {
    return parseToIntegerList(SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS + this.keyboardId));
  }
  
  public List<Integer> getKeyboardKeysOnlyIds()
  {
    return parseToIntegerList(SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS_ONLY + this.keyboardId));
  }
  
  public void removeKey(KeyboardButton paramKeyboardButton, InputButton paramInputButton)
  {
    ArrayList localArrayList1 = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS + this.keyboardId);
    ArrayList localArrayList2 = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS_CORRECT + this.keyboardId);
    ArrayList localArrayList3 = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS + this.keyboardId);
    int i = 0;
    for (;;)
    {
      if (i < localArrayList1.size())
      {
        if (paramKeyboardButton.getId() == Integer.parseInt((String)localArrayList3.get(i)))
        {
          localArrayList1.remove(String.valueOf(paramInputButton.getId()));
          if (!paramInputButton.isClickable()) {
            localArrayList2.remove(String.valueOf(paramInputButton.getId()));
          }
          localArrayList3.remove(String.valueOf(paramKeyboardButton.getId()));
        }
      }
      else
      {
        SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS + this.keyboardId, localArrayList1);
        SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS_CORRECT + this.keyboardId, localArrayList2);
        SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS + this.keyboardId, localArrayList3);
        return;
      }
      i += 1;
    }
  }
  
  public void saveKey(KeyboardButton paramKeyboardButton, InputButton paramInputButton)
  {
    ArrayList localArrayList1 = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS + this.keyboardId);
    ArrayList localArrayList2 = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS_CORRECT + this.keyboardId);
    ArrayList localArrayList3 = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS + this.keyboardId);
    localArrayList1.add(String.valueOf(paramInputButton.getId()));
    if (!paramInputButton.isClickable()) {
      localArrayList2.add(String.valueOf(paramInputButton.getId()));
    }
    localArrayList3.add(String.valueOf(paramKeyboardButton.getId()));
    SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS + this.keyboardId, localArrayList1);
    SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_INPUT_LETTERS_CORRECT + this.keyboardId, localArrayList2);
    SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS + this.keyboardId, localArrayList3);
  }
  
  public void saveKeyboardLetterOnly(KeyboardButton paramKeyboardButton)
  {
    ArrayList localArrayList = SharedPreferencesUtils.getStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS_ONLY + this.keyboardId);
    localArrayList.add(String.valueOf(paramKeyboardButton.getId()));
    SharedPreferencesUtils.setStringArrayPref(this.sharedPreferences, USED_KEYBOARD_LETTERS_ONLY + this.keyboardId, localArrayList);
  }
  
  public void setKeyboardId(String paramString)
  {
    this.keyboardId = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/KeyboardState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */