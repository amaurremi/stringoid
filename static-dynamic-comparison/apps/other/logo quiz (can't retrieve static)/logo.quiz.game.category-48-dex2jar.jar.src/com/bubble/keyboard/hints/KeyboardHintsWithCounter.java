package com.bubble.keyboard.hints;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.bluebird.mobile.tools.sound.SoundUtils;
import com.bluebird.mobile.tools.sound.SoundUtilsFactory;
import com.bubble.keyboard.InputButton;
import com.bubble.keyboard.Keyboard;
import com.bubble.keyboard.KeyboardButton;
import com.bubble.keyboard.R.drawable;
import com.bubble.keyboard.R.id;
import com.bubble.keyboard.R.integer;
import com.bubble.keyboard.R.string;
import com.bubble.keyboard.TextField;
import com.bubble.keyboard.TextFieldListener;
import com.bubble.keyboard.utils.Animations;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class KeyboardHintsWithCounter
  implements KeyboardHints
{
  public static final int DEFAULT_MAX_BOMB = 3;
  private Activity activity;
  private View.OnClickListener cancelSelectLetterOnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      KeyboardHintsWithCounter.this.closeSelectedLetters();
    }
  };
  private CounterListener counterListener;
  private Keyboard keyboard;
  private TextField textField;
  
  public KeyboardHintsWithCounter(Keyboard paramKeyboard, TextField paramTextField, CounterListener paramCounterListener, Activity paramActivity)
  {
    this.keyboard = paramKeyboard;
    this.textField = paramTextField;
    this.activity = paramActivity;
    this.counterListener = paramCounterListener;
  }
  
  private void showLetterOnCorrectPosition(KeyboardButton paramKeyboardButton, InputButton paramInputButton, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInputButton.setClickable(false);
    if (paramBoolean1) {
      this.textField.getListener().setLetterOnCorrectPositionWithAnimation(paramKeyboardButton, paramInputButton);
    }
    for (;;)
    {
      if (paramBoolean2) {
        this.counterListener.minus(this.activity.getResources().getInteger(R.integer.costOfShowLetter));
      }
      return;
      this.textField.getListener().setLetter(paramKeyboardButton, paramInputButton);
    }
  }
  
  public boolean closeSelectedLetters()
  {
    return this.textField.closeSelectedLetters();
  }
  
  public void fullAnswer()
  {
    fullAnswer(true);
  }
  
  public void fullAnswer(boolean paramBoolean)
  {
    SoundUtils localSoundUtils = SoundUtilsFactory.getInstance(this.activity);
    boolean bool = localSoundUtils.isSoundOn();
    if (bool) {
      localSoundUtils.turnOffSoundOn();
    }
    Object localObject1 = this.textField.getInputButtons().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (InputButton)((Iterator)localObject1).next();
      ((InputButton)localObject2).setClickable(true);
      ((InputButton)localObject2).getButton().performClick();
    }
    localObject1 = new ArrayList();
    Object localObject2 = this.textField.getInputButtons().iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label216;
      }
      InputButton localInputButton = (InputButton)((Iterator)localObject2).next();
      Iterator localIterator = this.keyboard.getKeyboardButtons().iterator();
      if (localIterator.hasNext())
      {
        KeyboardButton localKeyboardButton = (KeyboardButton)localIterator.next();
        if ((!localKeyboardButton.isCorrect()) || (localKeyboardButton.isUsed()) || (localInputButton.getCorrectAnswerChar() != localKeyboardButton.getButton().getText().charAt(0))) {
          break;
        }
        ((List)localObject1).add(localKeyboardButton);
      }
    }
    label216:
    if (((List)localObject1).size() > 0)
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        this.textField.getListener().setLetterOnPosition((KeyboardButton)((List)localObject1).get(i), i, false, false);
        i += 1;
      }
      if (paramBoolean) {
        this.counterListener.minus(this.activity.getResources().getInteger(R.integer.costOfFullAnswer));
      }
    }
    if (bool) {
      localSoundUtils.turnOnSound();
    }
  }
  
  public boolean isBombs()
  {
    Iterator localIterator = this.keyboard.getKeyboardButtons().iterator();
    while (localIterator.hasNext())
    {
      KeyboardButton localKeyboardButton = (KeyboardButton)localIterator.next();
      if ((!localKeyboardButton.isUsed()) && (!localKeyboardButton.isCorrect())) {
        return true;
      }
    }
    return false;
  }
  
  public void showRandomLetter()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = this.keyboard.getKeyboardButtons().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label159;
      }
      KeyboardButton localKeyboardButton = (KeyboardButton)localIterator1.next();
      if ((!localKeyboardButton.isUsed()) && (localKeyboardButton.isCorrect()))
      {
        Iterator localIterator2 = this.textField.getInputButtons().iterator();
        if (localIterator2.hasNext())
        {
          InputButton localInputButton = (InputButton)localIterator2.next();
          if ((localInputButton.isUsed()) || (localInputButton.getCorrectAnswerChar() != localKeyboardButton.getButton().getText().charAt(0))) {
            break;
          }
          localArrayList1.add(localKeyboardButton);
          localArrayList2.add(localInputButton);
        }
      }
    }
    label159:
    if (localArrayList1.size() > 0)
    {
      int i = new Random().nextInt(localArrayList1.size());
      showLetterOnCorrectPosition((KeyboardButton)localArrayList1.get(i), (InputButton)localArrayList2.get(i), true, true);
    }
  }
  
  public void showRandomLetters(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    List localList = this.textField.getInputButtons();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      InputButton localInputButton = (InputButton)localIterator1.next();
      if (!localInputButton.isUsed())
      {
        Iterator localIterator2 = this.keyboard.getKeyboardButtons().iterator();
        while (localIterator2.hasNext())
        {
          KeyboardButton localKeyboardButton = (KeyboardButton)localIterator2.next();
          if ((!localKeyboardButton.isUsed()) && (localKeyboardButton.isCorrect()) && (localInputButton.getCorrectAnswerChar() == localKeyboardButton.getButton().getText().charAt(0)) && ((i % 2 == 0) || (i == localList.size() - 1))) {
            showLetterOnCorrectPosition(localKeyboardButton, localInputButton, paramBoolean1, paramBoolean2);
          }
        }
      }
      i += 1;
    }
  }
  
  public void showSelectedLetter()
  {
    Object localObject = this.activity.findViewById(R.id.cancelSelectLetter);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      this.activity.findViewById(R.id.cancelSelectLetterButton).setOnClickListener(this.cancelSelectLetterOnClickListener);
    }
    localObject = this.textField.getInputButtons().iterator();
    while (((Iterator)localObject).hasNext())
    {
      final InputButton localInputButton = (InputButton)((Iterator)localObject).next();
      if (!localInputButton.isUsed())
      {
        Button localButton = localInputButton.getButton();
        localButton.setBackgroundResource(R.drawable.show_selected_letter_button);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = (Button)paramAnonymousView;
            Object localObject = null;
            Iterator localIterator = KeyboardHintsWithCounter.this.keyboard.getKeyboardButtons().iterator();
            do
            {
              paramAnonymousView = (View)localObject;
              if (!localIterator.hasNext()) {
                break;
              }
              paramAnonymousView = (KeyboardButton)localIterator.next();
            } while ((!paramAnonymousView.isCorrect()) || (paramAnonymousView.isUsed()) || (localInputButton.getCorrectAnswerChar() != paramAnonymousView.getButton().getText().charAt(0)));
            KeyboardHintsWithCounter.this.closeSelectedLetters();
            if (paramAnonymousView != null)
            {
              KeyboardHintsWithCounter.this.showLetterOnCorrectPosition(paramAnonymousView, localInputButton, false, true);
              return;
            }
            paramAnonymousView = Toast.makeText(KeyboardHintsWithCounter.this.activity.getApplicationContext(), KeyboardHintsWithCounter.this.activity.getString(R.string.no_matching_letters), 1);
            paramAnonymousView.setGravity(17, 0, 0);
            paramAnonymousView.show();
          }
        });
        Animations.shakeRotate(localButton, 0, this.activity);
      }
    }
  }
  
  public void useBomb()
  {
    useBomb(3, true, true);
  }
  
  public void useBomb(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.keyboard.getKeyboardButtons().iterator();
    while (((Iterator)localObject).hasNext())
    {
      KeyboardButton localKeyboardButton = (KeyboardButton)((Iterator)localObject).next();
      if ((!localKeyboardButton.isUsed()) && (!localKeyboardButton.isCorrect())) {
        localArrayList.add(localKeyboardButton);
      }
    }
    int i;
    if (localArrayList.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramInt)
      {
        int j = new Random().nextInt(localArrayList.size());
        localObject = (KeyboardButton)localArrayList.get(j);
        localArrayList.remove(j);
        ((KeyboardButton)localObject).setUsed(true);
        if (!paramBoolean1) {
          break label227;
        }
        if (i != 0) {
          break label207;
        }
        this.textField.getListener().removeLettterFromKeyboardWithAnimation((KeyboardButton)localObject, true);
      }
      while (localArrayList.size() == 0)
      {
        if (paramBoolean2) {
          this.counterListener.minus(this.activity.getResources().getInteger(R.integer.costOfRemoveLetters));
        }
        return;
        label207:
        this.textField.getListener().removeLettterFromKeyboardWithAnimation((KeyboardButton)localObject, false);
        continue;
        label227:
        this.textField.getListener().removeLettterFromKeyboard((KeyboardButton)localObject, false);
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/hints/KeyboardHintsWithCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */