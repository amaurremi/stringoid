package com.bubble.keyboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.bluebird.mobile.tools.commonutils.DimensionUtil;
import com.bubble.keyboard.utils.AlphabetUtil;
import com.bubble.keyboard.utils.DeviceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class KeyboardClassic
  implements Keyboard
{
  public static final String KEYBOARD_HELPER_SETTINGS_FILE = "KEYBOARD_HELPER_SETTINGS_FILE";
  public static final String LOGO_GUESS_BEFORE = "LOGO_GUESS_BEFORE_";
  public static final String LOGO_NAME_NAME_SHUFFLE_CHARS = "LOGO_NAME_NAME_SHUFFLE_CHARS_";
  public static final String LOGO_NAME_SHUFFLE_CORRECTS = "LOGO_NAME_SHUFFLE_CORRECTS_";
  public static int MAX_CHARS_IN_LINE = 7;
  private Context context;
  private List<KeyboardButton> keyboardButtons = new ArrayList();
  private List<CharKeyTO> keyboardChars;
  private int keyboardKeysCount;
  private KeyboardState keyboardState;
  private OnClickKeyboardButtonListener onClickKeyboardButtonListener;
  private TextFieldListener textFieldListener;
  
  public KeyboardClassic(TextFieldListener paramTextFieldListener, Context paramContext)
  {
    this.textFieldListener = paramTextFieldListener;
    this.context = paramContext;
  }
  
  public static void clearAllKeybaordKeys(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("KEYBOARD_HELPER_SETTINGS_FILE", 0).edit();
    paramContext.clear();
    paramContext.commit();
  }
  
  private void clearKeybaordKeys(String paramString)
  {
    SharedPreferences.Editor localEditor = this.context.getSharedPreferences("KEYBOARD_HELPER_SETTINGS_FILE", 0).edit();
    localEditor.remove("LOGO_GUESS_BEFORE_" + paramString);
    localEditor.remove("LOGO_NAME_NAME_SHUFFLE_CHARS_" + paramString);
    localEditor.remove("LOGO_NAME_SHUFFLE_CORRECTS_" + paramString);
    localEditor.commit();
  }
  
  private View createKeyboard(LayoutInflater paramLayoutInflater, List<Character> paramList, String paramString1, final String paramString2, Context paramContext)
  {
    this.keyboardButtons = new ArrayList();
    LinearLayout localLinearLayout = (LinearLayout)paramLayoutInflater.inflate(R.layout.keyboard_classic, null);
    paramLayoutInflater = new LinearLayout(paramContext);
    int i1 = 0;
    int n = MAX_CHARS_IN_LINE;
    float f = 1.0F;
    if (DeviceUtils.isTablet(paramContext)) {
      f = 1.5F;
    }
    int m = DimensionUtil.dip((int)(46.0F * f), paramContext);
    int i = DimensionUtil.dip((int)(48.0F * f), paramContext);
    int j = DimensionUtil.dip((int)(5.0F * f), paramContext);
    int k = (int)(28.0F * f);
    this.keyboardChars = getNameKeyboardChars(paramList, paramString1, paramString2);
    this.keyboardKeysCount = this.keyboardChars.size();
    if (this.keyboardChars.size() > 14)
    {
      n = MAX_CHARS_IN_LINE + 1;
      m = DimensionUtil.dip((int)(37.0F * f), paramContext);
      i = DimensionUtil.dip((int)(38.0F * f), paramContext);
      j = DimensionUtil.dip((int)(5.0F * f), paramContext);
      k = (int)(24.0F * f);
    }
    paramList = this.keyboardChars.iterator();
    while (paramList.hasNext())
    {
      paramString1 = (CharKeyTO)paramList.next();
      if (i1 % n == 0)
      {
        paramLayoutInflater = new LinearLayout(paramContext);
        paramLayoutInflater.setOrientation(0);
        paramLayoutInflater.setGravity(1);
        localLinearLayout.addView(paramLayoutInflater);
      }
      paramString2 = new KeyboardButton(i1, new Button(paramContext), paramString1.isCorrect());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, i);
      paramString2.getButton().setLayoutParams(localLayoutParams);
      paramString2.getButton().setPadding(0, 0, 0, j);
      paramString2.getButton().setBackgroundResource(R.drawable.keyboard_button);
      paramString2.getButton().setText(String.valueOf(paramString1.getCharacter()));
      paramString2.getButton().setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "fonts/arial_black.ttf"));
      paramString2.getButton().setTextSize(k);
      paramString2.getButton().setTextColor(Color.parseColor(paramContext.getResources().getString(R.string.keyboardTextColor)));
      paramString2.getButton().setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          KeyboardClassic.this.textFieldListener.setLetter(paramString2);
          if (KeyboardClassic.this.onClickKeyboardButtonListener != null) {
            KeyboardClassic.this.onClickKeyboardButtonListener.onKeyboardButtonClick();
          }
        }
      });
      this.keyboardButtons.add(paramString2);
      paramLayoutInflater.addView(paramString2.getButton());
      i1 += 1;
    }
    return localLinearLayout;
  }
  
  private String getCorrectCharsInfo(List<CharKeyTO> paramList)
  {
    String str = "";
    int i = 0;
    if (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str);
      if (((CharKeyTO)paramList.get(i)).isCorrect()) {}
      for (str = "t";; str = "f")
      {
        str = str;
        i += 1;
        break;
      }
    }
    return str;
  }
  
  private char[] getKeyboardChars(List<CharKeyTO> paramList)
  {
    char[] arrayOfChar = new char[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfChar[i] = ((CharKeyTO)paramList.get(i)).getCharacter();
      i += 1;
    }
    return arrayOfChar;
  }
  
  private List<CharKeyTO> getNameKeyboardChars(List<Character> paramList, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences;
    int i;
    label64:
    float f;
    if (paramString1 != null)
    {
      localSharedPreferences = this.context.getSharedPreferences("KEYBOARD_HELPER_SETTINGS_FILE", 0);
      if (localSharedPreferences.getBoolean("LOGO_GUESS_BEFORE_" + paramString1, false)) {
        break label346;
      }
      if (paramList.size() <= 14) {
        break label158;
      }
      i = MAX_CHARS_IN_LINE + 1;
      f = paramList.size() / i;
      if (f > 2.0F) {
        break label166;
      }
    }
    int m;
    Object localObject;
    label158:
    label166:
    for (int j = 2;; j = (int)Math.ceil(f))
    {
      m = paramList.size();
      localObject = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject).add(new CharKeyTO(((Character)paramList.next()).charValue(), true));
      }
      paramString1 = "";
      break;
      i = MAX_CHARS_IN_LINE;
      break label64;
    }
    int k = 0;
    while (k < j * i - m)
    {
      ((List)localObject).add(new CharKeyTO(AlphabetUtil.getRandomLetter(paramString2), false));
      k += 1;
    }
    Collections.shuffle((List)localObject);
    paramList = localSharedPreferences.edit();
    paramList.putBoolean("LOGO_GUESS_BEFORE_" + paramString1, true);
    paramList.putString("LOGO_NAME_NAME_SHUFFLE_CHARS_" + paramString1, new String(getKeyboardChars((List)localObject)));
    paramList.putString("LOGO_NAME_SHUFFLE_CORRECTS_" + paramString1, getCorrectCharsInfo((List)localObject));
    paramList.commit();
    paramList = (List<Character>)localObject;
    label346:
    do
    {
      return paramList;
      paramString2 = localSharedPreferences.getString("LOGO_NAME_NAME_SHUFFLE_CHARS_" + paramString1, null);
      localObject = localSharedPreferences.getString("LOGO_NAME_SHUFFLE_CORRECTS_" + paramString1, null);
      paramString1 = new ArrayList();
      i = 0;
      paramList = paramString1;
    } while (i >= paramString2.toCharArray().length);
    char c = paramString2.charAt(i);
    if (((String)localObject).charAt(i) == 't') {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.add(new CharKeyTO(c, bool));
      i += 1;
      break;
    }
  }
  
  private boolean isKeyboardStateCorrect(List<Character> paramList, List<CharKeyTO> paramList1)
  {
    Object localObject1 = this.keyboardState.getKeyboardKeysOnlyIds();
    int i = 0;
    Object localObject2;
    while (i < ((List)localObject1).size())
    {
      localObject2 = (CharKeyTO)paramList1.get(((Integer)((List)localObject1).get(i)).intValue());
      if (localObject2 != null) {
        ((CharKeyTO)localObject2).setCharacter(' ');
      }
      i += 1;
    }
    paramList = new ArrayList(paramList);
    paramList1 = paramList1.iterator();
    label169:
    while (paramList1.hasNext())
    {
      localObject1 = (CharKeyTO)paramList1.next();
      if (((CharKeyTO)localObject1).isCorrect())
      {
        i = 0;
        for (;;)
        {
          if (i >= paramList.size()) {
            break label169;
          }
          localObject2 = (Character)paramList.get(i);
          if (Character.toLowerCase(((CharKeyTO)localObject1).getCharacter()) == Character.toLowerCase(((Character)localObject2).charValue()))
          {
            paramList.remove(i);
            break;
          }
          i += 1;
        }
      }
    }
    return paramList.size() == 0;
  }
  
  private void restoreButtonsState()
  {
    try
    {
      List localList1 = this.keyboardState.getKeyboardKeysIds();
      Object localObject1 = this.keyboardState.getInputKeysIds();
      List localList2 = this.keyboardState.getInputKeysCorrectIds();
      int i = 0;
      while (i < localList1.size())
      {
        Object localObject2 = (Integer)localList1.get(i);
        localObject2 = (KeyboardButton)this.keyboardButtons.get(((Integer)localObject2).intValue());
        boolean bool = false;
        if (localList2.contains(((List)localObject1).get(i))) {
          bool = true;
        }
        this.textFieldListener.setLetterOnPosition((KeyboardButton)localObject2, ((Integer)((List)localObject1).get(i)).intValue(), bool, true);
        i += 1;
      }
      localList1 = this.keyboardState.getKeyboardKeysOnlyIds();
      i = 0;
      while (i < localList1.size())
      {
        localObject1 = (Integer)localList1.get(i);
        localObject1 = (KeyboardButton)this.keyboardButtons.get(((Integer)localObject1).intValue());
        this.textFieldListener.removeLettterFromKeyboard((KeyboardButton)localObject1, true);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public Button getButtonById(int paramInt)
  {
    return ((KeyboardButton)this.keyboardButtons.get(paramInt)).getButton();
  }
  
  public List<KeyboardButton> getKeyboardButtons()
  {
    return this.keyboardButtons;
  }
  
  public int getKeyboardKeysCount()
  {
    return this.keyboardKeysCount;
  }
  
  public View getLayout(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    this.keyboardState = KeyboardStateFactory.getInstance(paramContext);
    this.keyboardState.setKeyboardId(paramString2);
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    ArrayList localArrayList = new ArrayList();
    paramString1 = TextFieldWithLetters.removeAllSpecialChars(paramString1);
    int i = 0;
    while (i < paramString1.length())
    {
      localArrayList.add(Character.valueOf(paramString1.charAt(i)));
      i += 1;
    }
    paramString1 = createKeyboard(localLayoutInflater, localArrayList, paramString2, paramString3, paramContext);
    if (!isKeyboardStateCorrect(localArrayList, this.keyboardChars))
    {
      this.keyboardState.clear();
      clearKeybaordKeys(paramString2);
      paramString1 = createKeyboard(localLayoutInflater, localArrayList, paramString2, paramString3, paramContext);
    }
    restoreButtonsState();
    return paramString1;
  }
  
  public void setOnClickKeyboardButtonListener(OnClickKeyboardButtonListener paramOnClickKeyboardButtonListener)
  {
    this.onClickKeyboardButtonListener = paramOnClickKeyboardButtonListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/KeyboardClassic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */