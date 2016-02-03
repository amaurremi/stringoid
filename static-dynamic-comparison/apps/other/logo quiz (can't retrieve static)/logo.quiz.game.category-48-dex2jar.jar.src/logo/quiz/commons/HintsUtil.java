package logo.quiz.commons;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.List;

public class HintsUtil
{
  public static final int HINT_BOMB_ID = 3;
  public static final int HINT_CLUE_1_ID = 1;
  public static final int HINT_CLUE_2_ID = 2;
  public static final int HINT_FULL_ANSWER_ID = 5;
  public static final int HINT_SHOW_LETTER_ID = 4;
  public static final String USED_HINTS_COUNT = "USED_HINTS_COUNT";
  
  public static void addUsedHints(int paramInt, Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences.Editor localEditor = paramContext.edit();
    localEditor.putInt("USED_HINTS_COUNT", paramContext.getInt("USED_HINTS_COUNT", 0) + paramInt);
    localEditor.commit();
  }
  
  public static List<Hint> getAllHintsForBrand(BrandTO paramBrandTO, String paramString, Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getHintById(1, paramBrandTO, paramString, paramContext));
    localArrayList.add(getHintById(2, paramBrandTO, paramString, paramContext));
    localArrayList.add(getHintById(3, paramBrandTO, paramString, paramContext));
    localArrayList.add(getHintById(4, paramBrandTO, paramString, paramContext));
    localArrayList.add(getHintById(5, paramBrandTO, paramString, paramContext));
    return localArrayList;
  }
  
  public static Hint getHintById(int paramInt, BrandTO paramBrandTO, String paramString, Context paramContext)
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("isUsedHint" + paramInt + "Brand" + paramBrandTO.getId() + paramString, false);
    int i = 1;
    int j = 1;
    int k = R.id.hintsClueSentense1;
    int m = R.drawable.hint_show_clue_disabled;
    paramString = "";
    String str = "";
    Resources localResources = paramContext.getResources();
    if (paramInt == 1)
    {
      paramString = paramBrandTO.getHint1();
      i = paramContext.getResources().getInteger(R.integer.costOfClue1);
      j = paramContext.getResources().getInteger(R.integer.costOfClue1);
      m = R.drawable.hint_show_clue_disabled;
      k = R.id.hintsClueSentense1;
      str = localResources.getString(R.string.hint_show_clue1, new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      return new Hint(paramInt, paramString, bool, paramBrandTO.getId(), i, j, k, m, str);
      if (paramInt == 2)
      {
        paramString = paramBrandTO.getHint2();
        i = paramContext.getResources().getInteger(R.integer.costOfClue2);
        j = paramContext.getResources().getInteger(R.integer.costOfClue2);
        m = R.drawable.hint_show_clue2_disabled;
        k = R.id.hintsClueSentense2;
        str = localResources.getString(R.string.hint_show_clue2, new Object[] { Integer.valueOf(i) });
      }
      else if (paramInt == 3)
      {
        paramString = shuffle(paramBrandTO.getbrandName());
        i = paramContext.getResources().getInteger(R.integer.costOfRemoveLetters);
        j = 2;
        m = R.drawable.hint_bomb_disabled;
        k = R.id.hintsOnlyUsedLetters;
        str = localResources.getString(R.string.hint_remove_letter, new Object[] { Integer.valueOf(i) });
      }
      else if (paramInt == 4)
      {
        paramString = hideCharsInBrandName(paramBrandTO.getbrandName());
        i = paramContext.getResources().getInteger(R.integer.costOfShowLetter);
        j = 3;
        m = R.drawable.hint_show_letter_button;
        if (paramContext.getResources().getBoolean(R.bool.isSystemKeyboardOnGuessForm)) {
          m = R.drawable.hint_show_letter_off;
        }
        k = R.id.hintsSomeLettersInOrder;
        str = localResources.getString(R.string.hint_show_letter, new Object[] { Integer.valueOf(i) });
      }
      else if (paramInt == 5)
      {
        paramString = paramBrandTO.getbrandName();
        i = paramContext.getResources().getInteger(R.integer.costOfFullAnswer);
        j = 7;
        m = R.drawable.hint_skip_riddle_button;
        k = R.id.hintsFullAnswer;
        str = localResources.getString(R.string.hint_skip_riddle, new Object[] { Integer.valueOf(i) });
      }
    }
  }
  
  public static int getUsedHints(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("USED_HINTS_COUNT", 0);
  }
  
  public static String hideCharsInBrandName(String paramString)
  {
    String str = "";
    int j = 0;
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    int i = 0;
    if (i < k)
    {
      char c = arrayOfChar[i];
      if ((j % 2 == 0) || (j == paramString.length() - 1)) {
        str = str + "" + c;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        if (c == ' ') {
          str = str + "  ";
        } else {
          str = str + "_";
        }
      }
    }
    return str;
  }
  
  public static String shuffle(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Character.valueOf(arrayOfChar[i]));
      i += 1;
    }
    paramString = new StringBuilder(paramString.length());
    while (localArrayList.size() != 0) {
      paramString.append(localArrayList.remove((int)(Math.random() * localArrayList.size())));
    }
    return paramString.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/HintsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */