package logo.quiz.commons.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import com.bluebird.mobile.tools.sound.SoundUtils;
import com.bluebird.mobile.tools.sound.SoundUtilsFactory;
import com.bubble.keyboard.hints.KeyboardHints;
import logo.quiz.commons.BrandTO;
import logo.quiz.commons.DeviceUtilCommons;
import logo.quiz.commons.Hint;
import logo.quiz.commons.HintsUtil;
import logo.quiz.commons.R.id;

public class FormKeyboardHelper
{
  private final Activity activity;
  private KeyboardHints keyboardHints;
  private int previousHouseAdHeight = -1;
  
  public FormKeyboardHelper(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  private void setKeyboardMarginBottom(int paramInt)
  {
    View localView = this.activity.findViewById(R.id.editLogo);
    if (localView != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      localMarginLayoutParams.bottomMargin = paramInt;
      localView.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public void bigKeyboardHideAd(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.activity.findViewById(R.id.adSep);
    Object localObject2 = this.activity.findViewById(R.id.adContainer);
    ViewGroup.LayoutParams localLayoutParams;
    if ((localObject1 != null) && (localObject2 != null))
    {
      localLayoutParams = ((View)localObject2).getLayoutParams();
      if ((paramInt <= 16) && (DeviceUtilCommons.isOnline(this.activity))) {
        break label177;
      }
      localLayoutParams.height = 0;
      ((View)localObject1).setVisibility(8);
      ((View)localObject2).setVisibility(8);
      if (!paramBoolean)
      {
        setKeyboardMarginBottom(DeviceUtilCommons.dip(4, this.activity.getApplicationContext()));
        ((View)localObject2).setLayoutParams(localLayoutParams);
      }
    }
    else if (this.activity.findViewById(R.id.todayOfferContainer) != null)
    {
      localObject1 = (ViewGroup)this.activity.findViewById(R.id.todayOfferContainer);
      localObject2 = ((ViewGroup)localObject1).getLayoutParams();
      if (this.previousHouseAdHeight == -1) {
        this.previousHouseAdHeight = ((ViewGroup.LayoutParams)localObject2).height;
      }
      if (paramInt <= 16) {
        break label192;
      }
    }
    label177:
    label192:
    for (((ViewGroup.LayoutParams)localObject2).height = 0;; ((ViewGroup.LayoutParams)localObject2).height = this.previousHouseAdHeight)
    {
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      return;
      setKeyboardMarginBottom(0);
      break;
      localLayoutParams.height = -2;
      setKeyboardMarginBottom(0);
      break;
    }
  }
  
  public void checkBombButtonForBrand(BrandTO paramBrandTO, String paramString)
  {
    if (!this.keyboardHints.isBombs()) {
      disableHint(HintsUtil.getHintById(3, paramBrandTO, paramString, this.activity.getApplicationContext()), paramString);
    }
  }
  
  public boolean closeSelectedLetters()
  {
    return this.keyboardHints.closeSelectedLetters();
  }
  
  public void disableHint(Hint paramHint, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.activity.getApplicationContext()).edit();
    localEditor.putBoolean("isUsedHint" + paramHint.getId() + "Brand" + paramHint.getBrandId() + paramString, true);
    localEditor.commit();
    paramString = this.activity.findViewById(paramHint.getImageViewId());
    if (paramString != null) {
      paramString.setBackgroundResource(paramHint.getDrawableOff());
    }
  }
  
  public boolean isBombs()
  {
    return this.keyboardHints.isBombs();
  }
  
  public void setKeyboardHints(KeyboardHints paramKeyboardHints)
  {
    this.keyboardHints = paramKeyboardHints;
  }
  
  public void showSelectedLetter()
  {
    if (this.activity.findViewById(R.id.cancelSelectLetter) == null) {
      ((ViewStub)this.activity.findViewById(R.id.cancelSelectLetterStub)).inflate();
    }
    this.keyboardHints.showSelectedLetter();
  }
  
  public void skipRiddle()
  {
    this.keyboardHints.fullAnswer();
  }
  
  public void solveRiddle()
  {
    this.keyboardHints.fullAnswer(false);
  }
  
  public void useAllBombs()
  {
    this.keyboardHints.useBomb(99, false, false);
  }
  
  public void useBomb()
  {
    this.keyboardHints.useBomb();
  }
  
  public void useOldHintUsedLetters(Hint paramHint)
  {
    paramHint = SoundUtilsFactory.getInstance(this.activity);
    boolean bool = paramHint.isSoundOn();
    if (bool) {
      paramHint.turnOffSoundOn();
    }
    this.keyboardHints.showRandomLetters(false, false);
    if (bool) {
      paramHint.turnOnSound();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/FormKeyboardHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */