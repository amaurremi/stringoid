package com.bubble.keyboard;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.bluebird.mobile.tools.commonutils.DimensionUtil;
import com.bluebird.mobile.tools.sound.SoundUtils;
import com.bluebird.mobile.tools.sound.SoundUtilsFactory;
import com.bubble.keyboard.utils.Animations;
import com.bubble.keyboard.utils.DeviceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFieldWithLetters
  implements TextField, TextFieldListener
{
  public static final int ANIM_TIME = 70;
  public static final int CHARS_IN_ROW = 9;
  public static final int FLASHING_TEXT_COLOR = -4712938;
  public static final int FLASHING_TIME = 100;
  public static final int INPUT_BUTTON_NOT_CLICKABLE_TEXT_COLOR = -11621819;
  private Activity activity;
  private AnswerListener answerListener;
  private int completeLettersCount = 0;
  private List<InputButton> inputButtons = null;
  private char[] inputChars;
  private char[] inputCharsWithoutSpecial;
  private boolean isInputClickable = true;
  private KeyboardState keyboardState;
  private int lettersCount = 0;
  private OnClickInputButtonListener onClickInputButtonListener;
  private SoundUtils soundUtils;
  
  public TextFieldWithLetters(String paramString, char[] paramArrayOfChar, Activity paramActivity)
  {
    this.keyboardState = KeyboardStateFactory.getInstance(paramActivity);
    init(paramString, paramArrayOfChar);
    this.activity = paramActivity;
    this.soundUtils = SoundUtilsFactory.getInstance(paramActivity);
  }
  
  public TextFieldWithLetters(char[] paramArrayOfChar, Activity paramActivity)
  {
    this.keyboardState = KeyboardStateFactory.getInstance(paramActivity);
    init(null, paramArrayOfChar);
    this.activity = paramActivity;
    this.soundUtils = SoundUtilsFactory.getInstance(paramActivity);
  }
  
  private void checkAnswer()
  {
    int k = 1;
    int i = 0;
    Iterator localIterator = this.inputButtons.iterator();
    for (;;)
    {
      int j = k;
      if (localIterator.hasNext())
      {
        InputButton localInputButton = (InputButton)localIterator.next();
        if ((localInputButton.getButton().getText() == null) || (localInputButton.getButton().getText().equals("")) || (localInputButton.getButton().getText().charAt(0) != this.inputCharsWithoutSpecial[i])) {
          j = 0;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.keyboardState.clear();
        this.answerListener.correctAnswer();
        return;
      }
      i += 1;
    }
    this.soundUtils.playSound(R.raw.wrong_answer);
    if (this.activity.getResources().getBoolean(R.bool.isWrongAnswerFlashingEnable)) {
      new AsyncTask()
      {
        protected Void doInBackground(Void... paramAnonymousVarArgs)
        {
          int i = 0;
          for (;;)
          {
            if (i < 7) {}
            try
            {
              Thread.sleep(100L);
              publishProgress(new String[] { "FLASH" });
              i += 1;
            }
            catch (InterruptedException paramAnonymousVarArgs)
            {
              for (;;)
              {
                paramAnonymousVarArgs.printStackTrace();
                publishProgress(new String[] { "DONE" });
              }
            }
            finally
            {
              publishProgress(new String[] { "DONE" });
            }
          }
          publishProgress(new String[] { "DONE" });
          return null;
        }
        
        protected void onProgressUpdate(String... paramAnonymousVarArgs)
        {
          paramAnonymousVarArgs = paramAnonymousVarArgs[0];
          if (paramAnonymousVarArgs.equals("FLASH"))
          {
            paramAnonymousVarArgs = TextFieldWithLetters.this.inputButtons.iterator();
            while (paramAnonymousVarArgs.hasNext())
            {
              InputButton localInputButton = (InputButton)paramAnonymousVarArgs.next();
              if (localInputButton.isClickable()) {
                if (localInputButton.getButton().getCurrentTextColor() == -4712938) {
                  localInputButton.getButton().setTextColor(-1);
                } else {
                  localInputButton.getButton().setTextColor(-4712938);
                }
              }
            }
          }
          if (paramAnonymousVarArgs.equals("DONE")) {}
        }
      }.execute(new Void[] { (Void)null });
    }
    this.answerListener.wrongAnswer(isAlmostGoodAnswer());
  }
  
  private boolean fitCurrentRow(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2 < 10;
  }
  
  private List<Integer> getCharsCountInWords()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    char[] arrayOfChar = this.inputChars;
    int m = arrayOfChar.length;
    int j = 0;
    while (j < m)
    {
      int k = i;
      if (arrayOfChar[j] == ' ')
      {
        localArrayList.add(Integer.valueOf(i - 1));
        k = 0;
      }
      i = k + 1;
      j += 1;
    }
    localArrayList.add(Integer.valueOf(i - 1));
    return localArrayList;
  }
  
  private Button getDash(float paramFloat, Context paramContext)
  {
    Button localButton = new Button(paramContext);
    localButton.setLayoutParams(new LinearLayout.LayoutParams(DimensionUtil.dip((int)(30.0F * paramFloat), paramContext), DimensionUtil.dip((int)(31.0F * paramFloat), paramContext)));
    localButton.setPadding(0, 0, 0, DimensionUtil.dip((int)(4.0F * paramFloat), paramContext));
    localButton.setBackgroundResource(R.drawable.input_key_enter);
    localButton.setText(" ");
    localButton.setTextColor(-1);
    localButton.setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "fonts/arial_black.ttf"));
    localButton.setTextSize(23.0F * paramFloat);
    return localButton;
  }
  
  private InputButton getFirstEmptyButton()
  {
    Object localObject2 = null;
    Iterator localIterator = this.inputButtons.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (InputButton)localIterator.next();
    } while (!((InputButton)localObject1).getButton().getText().equals(""));
    return (InputButton)localObject1;
  }
  
  private View getLayout(boolean paramBoolean)
  {
    this.lettersCount = 0;
    this.completeLettersCount = 0;
    this.inputButtons = new ArrayList();
    LinearLayout localLinearLayout2 = (LinearLayout)((LayoutInflater)this.activity.getSystemService("layout_inflater")).inflate(R.layout.input_letters, null);
    LinearLayout localLinearLayout1 = getNewRow(this.activity);
    localLinearLayout2.addView(localLinearLayout1);
    char[] arrayOfChar = getSplitedInputChars(this.inputChars);
    List localList1 = getCharsCountInWords();
    int n = 0;
    int k = -1;
    float f = 1.0F;
    if (DeviceUtils.isTablet(this.activity)) {
      f = 1.5F;
    }
    int i2 = arrayOfChar.length;
    int m = 0;
    int j = 0;
    int i = 0;
    char c;
    label190:
    int i1;
    if (m < i2)
    {
      c = arrayOfChar[m];
      k += 1;
      if (c == ' ')
      {
        if (!hasNextWord(localList1, n)) {
          break label718;
        }
        if (fitCurrentRow(k, ((Integer)localList1.get(n + 1)).intValue()))
        {
          localLinearLayout1.addView(getSeparator(this.activity));
          n += 1;
          i1 = j;
          j = i;
          i = i1;
        }
      }
    }
    for (;;)
    {
      i1 = m + 1;
      m = j;
      j = i;
      i = m;
      m = i1;
      break;
      localLinearLayout1 = getNewRow(this.activity);
      localLinearLayout2.addView(localLinearLayout1);
      k = 0;
      break label190;
      Button localButton;
      if (c == '#')
      {
        localButton = getDash(f, this.activity);
        localLinearLayout1.addView(localButton);
        localLinearLayout1 = getNewRow(this.activity);
        localLinearLayout2.addView(localLinearLayout1);
        k = 0;
        i1 = j + 1;
        Animations.animateZoomIn(localButton, j * 70, this.activity);
        j = i;
        i = i1;
      }
      else if (isSpecialChar(c))
      {
        localButton = new Button(this.activity);
        localButton.setLayoutParams(new LinearLayout.LayoutParams(DimensionUtil.dip(15, this.activity), DimensionUtil.dip(36, this.activity)));
        localButton.setPadding(0, 0, 0, DimensionUtil.dip(2, this.activity));
        localButton.setBackgroundResource(0);
        localButton.setText(c + "");
        localButton.setTextColor(-16777216);
        localButton.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), "fonts/arial_black.ttf"));
        localButton.setTextSize(20.0F * f);
        localLinearLayout1.addView(localButton);
        i1 = j + 1;
        Animations.animateZoomIn(localButton, j * 70, this.activity);
        j = i;
        i = i1;
      }
      else
      {
        localButton = new Button(this.activity);
        localButton.setLayoutParams(new LinearLayout.LayoutParams(DimensionUtil.dip((int)(35.0F * f), this.activity), DimensionUtil.dip((int)(36.0F * f), this.activity)));
        localButton.setPadding(0, 0, 0, DimensionUtil.dip(2, this.activity));
        localButton.setBackgroundResource(R.drawable.input_key);
        if (paramBoolean) {
          localButton.setText(String.valueOf(Character.toUpperCase(c)));
        }
        for (;;)
        {
          localButton.setTextColor(-1);
          localButton.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), "fonts/arial_black.ttf"));
          localButton.setTextSize(20.0F * f);
          localLinearLayout1.addView(localButton);
          List localList2 = this.inputButtons;
          i1 = i + 1;
          localList2.add(new InputButton(i, localButton, c));
          i = j + 1;
          Animations.animateZoomIn(localButton, j * 70, this.activity);
          this.lettersCount += 1;
          j = i1;
          break;
          localButton.setText("");
        }
        return localLinearLayout2;
        label718:
        i1 = i;
        i = j;
        j = i1;
      }
    }
  }
  
  private LinearLayout getNewRow(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(0);
    paramContext.setGravity(17);
    return paramContext;
  }
  
  private FrameLayout getSeparator(Context paramContext)
  {
    paramContext = new FrameLayout(paramContext);
    paramContext.setMinimumWidth(25);
    return paramContext;
  }
  
  private char[] getSplitedInputChars(char[] paramArrayOfChar)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int k = 1;
    int n = paramArrayOfChar.length;
    int j = 0;
    while (j < n)
    {
      char c = paramArrayOfChar[j];
      localArrayList.add(Character.valueOf(c));
      int m;
      if (c != ' ')
      {
        m = i;
        if (paramArrayOfChar.length != k) {}
      }
      else
      {
        if (i > 9) {
          splitWord(localArrayList, i);
        }
        m = 1;
      }
      i = m + 1;
      k += 1;
      j += 1;
    }
    paramArrayOfChar = new char[localArrayList.size()];
    i = 0;
    while (i < localArrayList.size())
    {
      paramArrayOfChar[i] = ((Character)localArrayList.get(i)).charValue();
      i += 1;
    }
    return paramArrayOfChar;
  }
  
  private boolean hasNextWord(List<Integer> paramList, int paramInt)
  {
    return paramInt < paramList.size();
  }
  
  private boolean isAlmostGoodAnswer()
  {
    boolean bool = false;
    String str = getAnswerLetters();
    int k = 0;
    int j = 0;
    while (j < this.inputCharsWithoutSpecial.length)
    {
      try
      {
        int m = str.charAt(j);
        int n = this.inputCharsWithoutSpecial[j];
        i = k;
        if (m == n) {
          i = k + 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      j += 1;
      k = i;
    }
    if (k > this.inputCharsWithoutSpecial.length * 0.75D) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSpecialChar(char paramChar)
  {
    boolean bool = false;
    if (Pattern.compile("[^\\p{Alpha}\\p{Digit}]+").matcher(String.valueOf(paramChar)).find()) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSpecialChar(String paramString)
  {
    boolean bool = false;
    if (Pattern.compile("[^a-zA-Z0-9 ]+").matcher(paramString).find()) {
      bool = true;
    }
    return bool;
  }
  
  public static String removeAllSpecialChars(String paramString)
  {
    Pattern localPattern = Pattern.compile("[^\\p{Alpha}\\p{Digit}]+");
    for (Object localObject = localPattern.matcher(paramString); ((Matcher)localObject).find(); localObject = localPattern.matcher(paramString))
    {
      localObject = ((Matcher)localObject).group();
      paramString = paramString.replaceAll("\\" + (String)localObject, "");
    }
    return paramString;
  }
  
  private void setCorrectButton(InputButton paramInputButton)
  {
    paramInputButton.setClickable(false);
    paramInputButton.getButton().setTextColor(-11621819);
  }
  
  private void setLetter(final KeyboardButton paramKeyboardButton, final InputButton paramInputButton, boolean paramBoolean)
  {
    closeSelectedLetters();
    if (paramInputButton != null)
    {
      this.completeLettersCount += 1;
      paramInputButton.getButton().setText(paramKeyboardButton.getButton().getText());
      if (!paramInputButton.isClickable()) {
        paramInputButton.getButton().setTextColor(-11621819);
      }
      paramKeyboardButton.getButton().setVisibility(4);
      paramInputButton.getButton().setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((!paramInputButton.getButton().getText().equals("")) && (paramInputButton.isClickable()) && (TextFieldWithLetters.this.isInputClickable))
          {
            TextFieldWithLetters.access$310(TextFieldWithLetters.this);
            paramKeyboardButton.getButton().setVisibility(0);
            paramInputButton.getButton().setText("");
            TextFieldWithLetters.this.soundUtils.playSound(R.raw.click_off);
            paramAnonymousView = TextFieldWithLetters.this.inputButtons.iterator();
            while (paramAnonymousView.hasNext())
            {
              InputButton localInputButton = (InputButton)paramAnonymousView.next();
              if (localInputButton.isClickable()) {
                localInputButton.getButton().setTextColor(-1);
              } else {
                localInputButton.getButton().setTextColor(-11621819);
              }
            }
            TextFieldWithLetters.this.keyboardState.removeKey(paramKeyboardButton, paramInputButton);
            if (TextFieldWithLetters.this.onClickInputButtonListener != null) {
              TextFieldWithLetters.this.onClickInputButtonListener.onClickInputButtonListener();
            }
            TextFieldWithLetters.this.closeSelectedLetters();
          }
        }
      });
      if (!paramBoolean)
      {
        this.soundUtils.playSound(R.raw.click_on);
        this.keyboardState.saveKey(paramKeyboardButton, paramInputButton);
        if (this.lettersCount == this.completeLettersCount) {
          checkAnswer();
        }
      }
    }
  }
  
  private void splitWord(List<Character> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    if (paramInt > 9) {
      i = (int)Math.floor((paramInt + 6) / 8.0D);
    }
    i = (int)Math.ceil(paramInt / i);
    int j = i;
    if (i == 9) {
      j = i - 1;
    }
    int m = 1;
    i = paramList.size() - paramInt;
    int k = i;
    while (k < i + paramInt)
    {
      localArrayList.add((Character)paramList.get(k));
      if ((m > 1) && (m % j == 0) && (m < paramInt - 1)) {
        localArrayList.add(Character.valueOf('#'));
      }
      m += 1;
      k += 1;
    }
    j = i;
    while (j < i + paramInt)
    {
      paramList.remove(i);
      j += 1;
    }
    paramList.addAll(localArrayList);
  }
  
  public boolean closeSelectedLetters()
  {
    boolean bool2 = false;
    Object localObject = this.activity.findViewById(R.id.cancelSelectLetter);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (this.inputButtons != null)
      {
        bool1 = bool2;
        if (((View)localObject).getVisibility() == 0)
        {
          ((View)localObject).setVisibility(8);
          localObject = this.inputButtons.iterator();
          while (((Iterator)localObject).hasNext())
          {
            InputButton localInputButton = (InputButton)((Iterator)localObject).next();
            if (!localInputButton.isUsed())
            {
              localInputButton.getButton().setBackgroundResource(R.drawable.input_key);
              localInputButton.getButton().setOnClickListener(null);
            }
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String getAnswerLetters()
  {
    String str = "";
    Iterator localIterator = this.inputButtons.iterator();
    while (localIterator.hasNext())
    {
      InputButton localInputButton = (InputButton)localIterator.next();
      if (!localInputButton.getButton().getText().equals("")) {
        str = str + localInputButton.getButton().getText().charAt(0);
      }
    }
    return str;
  }
  
  public View getCompleteLayout()
  {
    return getLayout(true);
  }
  
  public List<InputButton> getInputButtons()
  {
    return this.inputButtons;
  }
  
  public View getLayout()
  {
    return getLayout(false);
  }
  
  public TextFieldListener getListener()
  {
    return this;
  }
  
  public void init(String paramString, char[] paramArrayOfChar)
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = Character.toUpperCase(paramArrayOfChar[i]);
      i += 1;
    }
    this.inputCharsWithoutSpecial = removeAllSpecialChars(new String(paramArrayOfChar)).toCharArray();
    this.inputChars = paramArrayOfChar;
    if (paramString != null) {
      this.keyboardState.setKeyboardId(paramString);
    }
    this.isInputClickable = true;
  }
  
  public void removeLettterFromKeyboard(KeyboardButton paramKeyboardButton, boolean paramBoolean)
  {
    Button localButton = paramKeyboardButton.getButton();
    localButton.setBackgroundResource(R.drawable.keyboard_button);
    localButton.setVisibility(4);
    if (!paramBoolean) {
      this.keyboardState.saveKeyboardLetterOnly(paramKeyboardButton);
    }
  }
  
  public void removeLettterFromKeyboardWithAnimation(KeyboardButton paramKeyboardButton, boolean paramBoolean)
  {
    closeSelectedLetters();
    final Button localButton = paramKeyboardButton.getButton();
    if (paramBoolean) {
      this.soundUtils.playSound(R.raw.explosion_sound);
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.activity, R.anim.shake);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = AnimationUtils.loadAnimation(TextFieldWithLetters.this.activity, R.anim.explosion_animation);
        localButton.setBackgroundResource(R.drawable.explosion);
        paramAnonymousAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            TextFieldWithLetters.2.this.val$button.setBackgroundResource(R.drawable.keyboard_button);
            TextFieldWithLetters.2.this.val$button.setVisibility(4);
          }
          
          public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
          
          public void onAnimationStart(Animation paramAnonymous2Animation) {}
        });
        localButton.startAnimation(paramAnonymousAnimation);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    localButton.startAnimation(localAnimation);
    this.keyboardState.saveKeyboardLetterOnly(paramKeyboardButton);
  }
  
  public void setAnswerListener(AnswerListener paramAnswerListener)
  {
    this.answerListener = paramAnswerListener;
  }
  
  public void setInputClickable(boolean paramBoolean)
  {
    this.isInputClickable = paramBoolean;
  }
  
  public void setLetter(KeyboardButton paramKeyboardButton)
  {
    setLetter(paramKeyboardButton, getFirstEmptyButton(), false);
  }
  
  public void setLetter(KeyboardButton paramKeyboardButton, InputButton paramInputButton)
  {
    setLetter(paramKeyboardButton, paramInputButton, false);
  }
  
  public void setLetterOnCorrectPositionWithAnimation(final KeyboardButton paramKeyboardButton, final InputButton paramInputButton)
  {
    this.soundUtils.playSound(R.raw.shake_sound);
    Animation localAnimation = AnimationUtils.loadAnimation(this.activity, R.anim.shake);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TextFieldWithLetters.this.setLetter(paramKeyboardButton, paramInputButton, false);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramKeyboardButton.getButton().startAnimation(localAnimation);
  }
  
  public void setLetterOnPosition(KeyboardButton paramKeyboardButton, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    InputButton localInputButton = (InputButton)this.inputButtons.get(paramInt);
    if (paramBoolean1) {
      setCorrectButton(localInputButton);
    }
    setLetter(paramKeyboardButton, localInputButton, paramBoolean2);
  }
  
  public void setOnClickInputButtonListener(OnClickInputButtonListener paramOnClickInputButtonListener)
  {
    this.onClickInputButtonListener = paramOnClickInputButtonListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/TextFieldWithLetters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */