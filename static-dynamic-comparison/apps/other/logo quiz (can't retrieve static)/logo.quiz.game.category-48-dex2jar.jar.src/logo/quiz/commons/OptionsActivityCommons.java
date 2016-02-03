package logo.quiz.commons;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.content.IntentCompat;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.bluebird.mobile.tools.sound.SoundUtils;
import com.bluebird.mobile.tools.sound.SoundUtilsFactory;
import com.bubble.bugsense.BugSense;
import com.bubble.keyboard.KeyboardClassic;
import com.bubble.keyboard.KeyboardState;
import com.bubble.mobile.language.support.LaguageChanger;
import com.bubble.mobile.language.support.LanguageSpinnerAdapter;
import com.bubble.mobile.language.support.LocaleCodes;
import com.bubble.play.services.PlayServicesActionHelper;
import logo.quiz.commons.cloud.save.SameGameState;
import logo.quiz.commons.cloud.save.SaveGame;
import logo.quiz.commons.flurry.Flurry;
import logo.quiz.commons.language.LanguageSpinnerAdapterLogoQuiz;
import logo.quiz.commons.utils.hints.HintsService;
import logo.quiz.commons.utils.hints.HintsServiceFactory;
import logo.quiz.commons.utils.menu.MenuService;
import logo.quiz.commons.utils.score.ScoreService;

public abstract class OptionsActivityCommons
  extends LogoQuizAbstractActivity
{
  public static final String IS_LANGUAGE_CHANGED = "isLanguageChanged";
  Activity activity = this;
  protected PlayServicesActionHelper playServicesActionHelper;
  
  private void buttonSetLeftImage(Button paramButton, int paramInt)
  {
    paramButton.setCompoundDrawablesWithIntrinsicBounds(getApplicationContext().getResources().getDrawable(paramInt), null, null, null);
  }
  
  private void layout()
  {
    Object localObject1 = (Button)findViewById(R.id.soundMute);
    Object localObject2 = (Button)findViewById(R.id.vibrate);
    Button localButton1 = (Button)findViewById(R.id.rateThisApp);
    Button localButton2 = (Button)findViewById(R.id.facebookLike);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    if (localSharedPreferences.getBoolean("SOUND", true))
    {
      ((Button)localObject1).setText(Html.fromHtml(getString(R.string.options_sounds_on)));
      ((Button)localObject1).setTextColor(getButtonTextColor());
      buttonSetLeftImage((Button)localObject1, R.drawable.options_sound_on);
      if (!localSharedPreferences.getBoolean("VIBRATE", true)) {
        break label295;
      }
      ((Button)localObject2).setText(Html.fromHtml(getString(R.string.options_vibrate_on)));
      ((Button)localObject2).setTextColor(getButtonTextColor());
      buttonSetLeftImage((Button)localObject2, R.drawable.options_vibrate_on);
      label137:
      if (localSharedPreferences.getBoolean("promo_rate", false)) {
        break label328;
      }
      localButton1.setTextColor(getButtonTextColor());
      buttonSetLeftImage(localButton1, R.drawable.options_rate_app_on);
      label166:
      if (localSharedPreferences.getBoolean("like_on_fb", false)) {
        break label347;
      }
      localButton2.setTextColor(getButtonTextColor());
      buttonSetLeftImage(localButton2, R.drawable.options_facebook_like_on);
    }
    for (;;)
    {
      localObject1 = (Spinner)findViewById(R.id.languageSpinner);
      localObject2 = new LanguageSpinnerAdapterLogoQuiz(this, this.laguageChanger.getLanguageImages());
      ((LanguageSpinnerAdapter)localObject2).setDropDownViewResource(17367049);
      ((Spinner)localObject1).setAdapter((SpinnerAdapter)localObject2);
      ((Spinner)localObject1).setSelection(this.laguageChanger.getCurrentLaguage().getId());
      ((Spinner)localObject1).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (!OptionsActivityCommons.this.laguageChanger.getCurrentLaguage().equals(OptionsActivityCommons.this.laguageChanger.getLocaleCodeByPos(paramAnonymousInt)))
          {
            OptionsActivityCommons.this.laguageChanger.changeLanguage(paramAnonymousInt, true);
            OptionsActivityCommons.this.finish();
            paramAnonymousAdapterView = OptionsActivityCommons.this.getIntent();
            paramAnonymousAdapterView.putExtra("isLanguageChanged", true);
            OptionsActivityCommons.this.startActivity(paramAnonymousAdapterView);
          }
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      return;
      ((Button)localObject1).setText(Html.fromHtml(getString(R.string.options_sounds_off)));
      ((Button)localObject1).setTextColor(getButtonTextColorDisable());
      buttonSetLeftImage((Button)localObject1, R.drawable.options_sound_off);
      break;
      label295:
      ((Button)localObject2).setText(Html.fromHtml(getString(R.string.options_vibrate_off)));
      ((Button)localObject2).setTextColor(getButtonTextColorDisable());
      buttonSetLeftImage((Button)localObject2, R.drawable.options_vibrate_off);
      break label137;
      label328:
      localButton1.setTextColor(getButtonTextColorDisable());
      buttonSetLeftImage(localButton1, R.drawable.options_rate_app_off);
      break label166;
      label347:
      localButton2.setTextColor(getButtonTextColorDisable());
      buttonSetLeftImage(localButton2, R.drawable.options_facebook_like_off);
    }
  }
  
  private void like()
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + getConstants().getFacebookProfileId()));
      localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.facebook.com/pages/profile/" + getConstants().getFacebookProfileId()));
    }
    catch (Exception localException1)
    {
      try
      {
        localIntent1.addFlags(1073741824);
        localIntent1.addFlags(268435456);
        startActivity(localIntent1);
        return;
      }
      catch (Exception localException2)
      {
        Intent localIntent2;
        for (;;) {}
      }
      localException1 = localException1;
    }
    localIntent2.addFlags(1073741824);
    localIntent2.addFlags(268435456);
    startActivity(localIntent2);
  }
  
  private void rate()
  {
    try
    {
      Flurry.onEvent("Rate app");
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("market://details?id=" + getApplicationContext().getPackageName()));
      localIntent.addFlags(1073741824);
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
    }
  }
  
  public void back(View paramView)
  {
    if (getIntent().getBooleanExtra("isLanguageChanged", false))
    {
      startActivity(IntentCompat.makeRestartActivityTask(new Intent(this, DeviceUtilCommons.getClassByName(getApplicationContext(), "LogosQuizActivity")).getComponent()));
      finish();
      return;
    }
    super.back(paramView);
  }
  
  protected void clearOther() {}
  
  public void fbLikeClick(View paramView)
  {
    paramView = getApplicationContext();
    if (DeviceUtilCommons.isOnline(paramView))
    {
      paramView = PreferenceManager.getDefaultSharedPreferences(paramView);
      if (!paramView.getBoolean("like_on_fb", false))
      {
        SharedPreferences.Editor localEditor = paramView.edit();
        localEditor.putBoolean("like_on_fb", true);
        localEditor.putInt("newHints", paramView.getInt("newHints", 0) + 3);
        localEditor.commit();
        paramView = (Button)findViewById(R.id.facebookLike);
        paramView.setTextColor(getButtonTextColorDisable());
        buttonSetLeftImage(paramView, R.drawable.options_facebook_like_off);
      }
      like();
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  public int getButtonTextColor()
  {
    return getResources().getColor(DeviceUtilCommons.getColorIdByName("button_text_color", getApplicationContext()));
  }
  
  public int getButtonTextColorDisable()
  {
    return getResources().getColor(DeviceUtilCommons.getColorIdByName("button_text_color_disable", getApplicationContext()));
  }
  
  protected abstract ConstantsProvider getConstants();
  
  protected int getGuessedLogosCount()
  {
    return getScoreService().getCompletedLogosCount(getApplicationContext());
  }
  
  protected String getLeaderboardIdKey()
  {
    int i = getResources().getIdentifier("leaderboard", "string", getPackageName());
    return getResources().getString(i);
  }
  
  protected SameGameState getSaveGame()
  {
    return new SaveGame(HintsServiceFactory.getInstance().getAvailibleHintsCount(getApplicationContext()), getScoreUtilProvider(), getScoreService(), getApplicationContext());
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  public void onBackPressed()
  {
    back(null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(0, 0);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.onCreate(paramBundle, R.layout.options);
    this.playServicesActionHelper = new PlayServicesActionHelper(this);
    addActivityActions(new ActivityAction[] { this.playServicesActionHelper });
    layout();
    ((TextView)findViewById(R.id.menuInfo)).setText(getString(R.string.options));
    ((TextView)findViewById(R.id.hintsLabelLevel)).setText(getResources().getString(R.string.logos));
    ((Button)findViewById(R.id.my_swarm_button)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = OptionsActivityCommons.this.getLeaderboardIdKey();
        if (paramAnonymousView != null)
        {
          OptionsActivityCommons.this.playServicesActionHelper.setLoginCheck(true);
          OptionsActivityCommons.this.playServicesActionHelper.showAndSubmitLeaderBoard(paramAnonymousView, OptionsActivityCommons.this.getGuessedLogosCount());
          OptionsActivityCommons.this.playServicesActionHelper.setLoginCheck(false);
        }
      }
    });
  }
  
  public void onResume()
  {
    super.onResume();
    this.bugSense.addCrashExtraData("activity", getClass().getSimpleName());
    getMenuService().refreshScore(this);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void otherApps(View paramView)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      paramView = "market://search?q=pub:bubble quiz games";
      if ("market://details?id=".contains("amazon")) {
        paramView = "market://details?id=logo.quiz.music.bands.game&showAll=1";
      }
      localIntent.setData(Uri.parse(paramView));
      localIntent.addFlags(1073741824);
      startActivity(localIntent);
      return;
    }
    catch (Exception paramView)
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=bubble%20quiz%20games")));
    }
  }
  
  public void rateClick(View paramView)
  {
    if (DeviceUtilCommons.isOnline(getApplicationContext()))
    {
      paramView = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
      if (!paramView.getBoolean("promo_rate", false))
      {
        paramView.edit().putBoolean("promo_rate", true);
        paramView = (Button)findViewById(R.id.rateThisApp);
        paramView.setTextColor(getButtonTextColorDisable());
        buttonSetLeftImage(paramView, R.drawable.options_rate_app_off);
      }
      rate();
      return;
    }
    DeviceUtilCommons.showLongToast(getString(R.string.you_have_to_be_online), getApplicationContext());
  }
  
  public void reset(View paramView)
  {
    paramView = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        }
        OptionsActivityCommons.this.resetAllSettings();
      }
    };
    new AlertDialog.Builder(this).setMessage(getString(R.string.attention_reset_app)).setPositiveButton("Reset", paramView).setNegativeButton(getString(17039360), paramView).show();
  }
  
  protected void resetAllSettings()
  {
    KeyboardState.clearAll(this);
    KeyboardClassic.clearAllKeybaordKeys(this);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this).edit();
    ((SharedPreferences.Editor)localObject).clear();
    ((SharedPreferences.Editor)localObject).putInt("allHints", getResources().getInteger(R.integer.hintsOnStart));
    ((SharedPreferences.Editor)localObject).commit();
    SoundUtilsFactory.getInstance(this.activity.getApplicationContext()).turnOnSound();
    getScoreService().reset();
    clearOther();
    getScoreUtilProvider().initLogos(this);
    getScoreUtilProvider().setActiveBrandsLevel(null);
    getMenuService().refreshScore(this);
    localObject = getIntent();
    ((Intent)localObject).putExtra("isLanguageChanged", true);
    saveGameStateToCloud();
    finish();
    startActivity((Intent)localObject);
  }
  
  protected void saveGameStateToCloud()
  {
    this.playServicesActionHelper.setLoginCheck(false);
    this.playServicesActionHelper.updateCloud(0, getSaveGame().getBytes());
    this.playServicesActionHelper.setLoginCheck(true);
  }
  
  public void soundMute(View paramView)
  {
    paramView = SoundUtilsFactory.getInstance(this.activity.getApplicationContext());
    Button localButton = (Button)findViewById(R.id.soundMute);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (localSharedPreferences.getBoolean("SOUND", true))
    {
      localButton.setText(Html.fromHtml(getString(R.string.options_sounds_off)));
      localButton.setTextColor(getButtonTextColorDisable());
      buttonSetLeftImage(localButton, R.drawable.options_sound_off);
      localEditor.putBoolean("SOUND", false);
      paramView.turnOffSoundOn();
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localButton.setText(Html.fromHtml(getString(R.string.options_sounds_on)));
      localButton.setTextColor(getButtonTextColor());
      buttonSetLeftImage(localButton, R.drawable.options_sound_on);
      DeviceUtilCommons.playSound(getApplicationContext(), R.raw.correct);
      localEditor.putBoolean("SOUND", true);
      paramView.turnOnSound();
    }
  }
  
  public void stats(View paramView)
  {
    paramView = new Intent(getApplicationContext(), DeviceUtilCommons.getClassByName(getApplicationContext(), "StatisticsActivity"));
    paramView.setFlags(603979776);
    startActivity(paramView);
  }
  
  public void vibrate(View paramView)
  {
    paramView = (Button)findViewById(R.id.vibrate);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (localSharedPreferences.getBoolean("VIBRATE", true))
    {
      paramView.setText(Html.fromHtml(getString(R.string.options_vibrate_off)));
      paramView.setTextColor(getButtonTextColorDisable());
      buttonSetLeftImage(paramView, R.drawable.options_vibrate_off);
      localEditor.putBoolean("VIBRATE", false);
    }
    for (;;)
    {
      localEditor.commit();
      return;
      paramView.setText(Html.fromHtml(getString(R.string.options_vibrate_on)));
      paramView.setTextColor(getButtonTextColor());
      buttonSetLeftImage(paramView, R.drawable.options_vibrate_on);
      localEditor.putBoolean("VIBRATE", true);
      ((Vibrator)getSystemService("vibrator")).vibrate(500L);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/OptionsActivityCommons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */