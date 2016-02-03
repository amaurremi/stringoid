package com.games.HangManGame;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper_Class
{
  static List<String> usedWords = new ArrayList();
  
  public static boolean checkIfAlreadyUsed(String paramString)
  {
    Iterator localIterator = usedWords.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (usedWords.size() <= 80) {
          break;
        }
        usedWords.clear();
        usedWords.add(paramString);
        return false;
      }
      String str = (String)localIterator.next();
      Log.i("Imran", str);
    }
    if (usedWords.contains(paramString)) {
      return true;
    }
    usedWords.add(paramString);
    return false;
  }
  
  public static char getCharAtIndex(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return '?';
    case 0: 
      return 'a';
    case 1: 
      return 'b';
    case 2: 
      return 'c';
    case 3: 
      return 'd';
    case 4: 
      return 'e';
    case 5: 
      return 'f';
    case 6: 
      return 'g';
    case 7: 
      return 'h';
    case 8: 
      return 'i';
    case 9: 
      return 'j';
    case 10: 
      return 'k';
    case 11: 
      return 'l';
    case 12: 
      return 'm';
    case 13: 
      return 'n';
    case 14: 
      return 'o';
    case 15: 
      return 'p';
    case 16: 
      return 'q';
    case 17: 
      return 'r';
    case 18: 
      return 's';
    case 19: 
      return 't';
    case 20: 
      return 'u';
    case 21: 
      return 'v';
    case 22: 
      return 'w';
    case 23: 
      return 'x';
    case 24: 
      return 'y';
    }
    return 'z';
  }
  
  public static Object getCurrentArrayObject(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return Arrays.CountryNames;
    case 2: 
      return Arrays.AnimalNames;
    case 3: 
      return Arrays.ElementNames;
    case 4: 
      return Arrays.SportsNames;
    case 5: 
      return Arrays.MovieNames;
    }
    return Arrays.Actors;
  }
  
  public static String getWord(int paramInt)
  {
    String[] arrayOfString = (String[])getCurrentArrayObject(paramInt);
    String str;
    do
    {
      str = arrayOfString[((int)Math.floor(Math.random() * arrayOfString.length))];
      Log.i("WORD SELECTED", str);
    } while (checkIfAlreadyUsed(str));
    return str;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/games/HangManGame/Helper_Class.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */