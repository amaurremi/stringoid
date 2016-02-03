package com.jaysquared.games.whereishd.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.utils.DistanceUnit;
import com.jaysquared.games.whereishd.utils.GameDifficulty;
import com.jaysquared.games.whereishd.utils.GuessTimer;
import com.jaysquared.games.whereishd.utils.InAppSupportHelper;
import com.jaysquared.games.whereishd.utils.Language;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.jaysquared.games.whereishd.utils.SegmentedRadioGroup;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

public class SettingsDialogActivity
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = SettingsDialogActivity.class.getSimpleName();
  private ImageButton HD_mapBtn;
  private Boolean bannerClicked;
  private ImageButton easy_mapBtn;
  private Button feedbackButton;
  private ImageButton hard_mapBtn;
  private Button mExitBtn;
  private Boolean mapChanged;
  private MoPubView moPubView;
  private RadioButton s_ctrlLanguages_DE;
  private RadioButton s_ctrlLanguages_EN;
  private RadioButton s_ctrlLanguages_ES;
  private RadioButton s_ctrlLanguages_FR;
  private RadioButton s_ctrlLanguages_IT;
  private RadioButton s_ctrlLanguages_NL;
  private RadioButton s_ctrlLanguages_PT;
  
  private void buttonActions()
  {
    ((SegmentedRadioGroup)findViewById(2131230946)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 2131230947: 
          ApplicationManager.getInstance().getSettings().setTimer(GuessTimer.OFF);
          return;
        case 2131230948: 
          ApplicationManager.getInstance().getSettings().setTimer(GuessTimer.FIVE);
          return;
        case 2131230949: 
          ApplicationManager.getInstance().getSettings().setTimer(GuessTimer.TEN);
          return;
        }
        ApplicationManager.getInstance().getSettings().setTimer(GuessTimer.TWENTY);
      }
    });
    ((SegmentedRadioGroup)findViewById(2131230953)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 2131230954: 
          ApplicationManager.getInstance().getSettings().setDistanceUnit(DistanceUnit.KILOMETERS);
          return;
        }
        ApplicationManager.getInstance().getSettings().setDistanceUnit(DistanceUnit.MILES);
      }
    });
    ((SegmentedRadioGroup)findViewById(2131230957)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 2131230958: 
          ApplicationManager.getInstance().getSettings().setLanguage(Language.EN);
          return;
        case 2131230959: 
          ApplicationManager.getInstance().getSettings().setLanguage(Language.DE);
          return;
        case 2131230960: 
          ApplicationManager.getInstance().getSettings().setLanguage(Language.ES);
          return;
        case 2131230961: 
          ApplicationManager.getInstance().getSettings().setLanguage(Language.FR);
          return;
        case 2131230962: 
          ApplicationManager.getInstance().getSettings().setLanguage(Language.IT);
          return;
        case 2131230963: 
          ApplicationManager.getInstance().getSettings().setLanguage(Language.NL);
          return;
        }
        ApplicationManager.getInstance().getSettings().setLanguage(Language.PT);
      }
    });
    this.mExitBtn = ((Button)findViewById(2131230813));
    this.mExitBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((!SettingsDialogActivity.this.bannerClicked.booleanValue()) && (SettingsDialogActivity.this.mapChanged.booleanValue()))
        {
          paramAnonymousView = new Intent(SettingsDialogActivity.this, MainMenuActivity.class);
          SettingsDialogActivity.this.setResult(90001, paramAnonymousView);
        }
        SettingsDialogActivity.this.finish();
      }
    });
    this.easy_mapBtn = ((ImageButton)findViewById(2131230940));
    this.easy_mapBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ApplicationManager.getInstance().getSettings().getGameDifficulty() != GameDifficulty.EASY)
        {
          SettingsDialogActivity.this.easy_mapBtn.setImageResource(2130837719);
          SettingsDialogActivity.this.hard_mapBtn.setImageResource(2130837722);
          if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
            break label91;
          }
          SettingsDialogActivity.this.HD_mapBtn.setImageResource(2130837725);
        }
        for (;;)
        {
          ApplicationManager.getInstance().getSettings().setGameDifficulty(GameDifficulty.EASY);
          SettingsDialogActivity.access$102(SettingsDialogActivity.this, Boolean.valueOf(true));
          return;
          label91:
          SettingsDialogActivity.this.HD_mapBtn.setImageResource(2130837724);
        }
      }
    });
    this.hard_mapBtn = ((ImageButton)findViewById(2131230941));
    this.hard_mapBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ApplicationManager.getInstance().getSettings().getGameDifficulty() != GameDifficulty.HARD)
        {
          SettingsDialogActivity.this.hard_mapBtn.setImageResource(2130837721);
          SettingsDialogActivity.this.easy_mapBtn.setImageResource(2130837720);
          if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
            break label91;
          }
          SettingsDialogActivity.this.HD_mapBtn.setImageResource(2130837725);
        }
        for (;;)
        {
          ApplicationManager.getInstance().getSettings().setGameDifficulty(GameDifficulty.HARD);
          SettingsDialogActivity.access$102(SettingsDialogActivity.this, Boolean.valueOf(true));
          return;
          label91:
          SettingsDialogActivity.this.HD_mapBtn.setImageResource(2130837724);
        }
      }
    });
    this.HD_mapBtn = ((ImageButton)findViewById(2131230942));
    this.HD_mapBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS)
        {
          if (ApplicationManager.getInstance().getSettings().getGameDifficulty() != GameDifficulty.HD)
          {
            SettingsDialogActivity.this.HD_mapBtn.setClickable(true);
            SettingsDialogActivity.this.HD_mapBtn.setImageResource(2130837723);
            SettingsDialogActivity.this.easy_mapBtn.setImageResource(2130837720);
            SettingsDialogActivity.this.hard_mapBtn.setImageResource(2130837722);
            ApplicationManager.getInstance().getSettings().setGameDifficulty(GameDifficulty.HD);
            SettingsDialogActivity.access$102(SettingsDialogActivity.this, Boolean.valueOf(true));
          }
          return;
        }
        try
        {
          SettingsDialogActivity.access$002(SettingsDialogActivity.this, Boolean.valueOf(true));
          paramAnonymousView = new Intent("android.intent.action.VIEW");
          paramAnonymousView.setData(Uri.parse("market://details?id=com.jaysquared.games.whereishd.release"));
          SettingsDialogActivity.this.startActivity(paramAnonymousView);
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView)
        {
          SLog.d(SettingsDialogActivity.LOG_TAG, "market works only on a device");
        }
      }
    });
    this.feedbackButton = ((Button)findViewById(2131230815));
    this.feedbackButton.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
    this.feedbackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InAppSupportHelper.openSupportChannel(SettingsDialogActivity.this);
      }
    });
  }
  
  public void onBannerClicked(MoPubView paramMoPubView)
  {
    SLog.d(LOG_TAG, "settings on banner clicked");
    this.bannerClicked = Boolean.valueOf(true);
  }
  
  public void onBannerCollapsed(MoPubView paramMoPubView) {}
  
  public void onBannerExpanded(MoPubView paramMoPubView) {}
  
  public void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode) {}
  
  public void onBannerLoaded(MoPubView paramMoPubView)
  {
    findViewById(2131230817).setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    SLog.d(LOG_TAG, "Creating activity...");
    this.bannerClicked = Boolean.valueOf(false);
    this.mapChanged = Boolean.valueOf(false);
    super.onCreate(paramBundle);
    setContentView(2130903079);
    paramBundle = ApplicationManager.getInstance().getGameManager().getTypeface();
    ((TextView)findViewById(2131230952)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230945)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230956)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230947)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230948)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230949)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230950)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230954)).setTypeface(paramBundle);
    ((TextView)findViewById(2131230955)).setTypeface(paramBundle);
    this.s_ctrlLanguages_EN = ((RadioButton)findViewById(2131230958));
    this.s_ctrlLanguages_EN.setTypeface(paramBundle);
    this.s_ctrlLanguages_DE = ((RadioButton)findViewById(2131230959));
    this.s_ctrlLanguages_DE.setTypeface(paramBundle);
    this.s_ctrlLanguages_FR = ((RadioButton)findViewById(2131230961));
    this.s_ctrlLanguages_FR.setTypeface(paramBundle);
    this.s_ctrlLanguages_ES = ((RadioButton)findViewById(2131230960));
    this.s_ctrlLanguages_ES.setTypeface(paramBundle);
    this.s_ctrlLanguages_IT = ((RadioButton)findViewById(2131230962));
    this.s_ctrlLanguages_IT.setTypeface(paramBundle);
    this.s_ctrlLanguages_NL = ((RadioButton)findViewById(2131230963));
    this.s_ctrlLanguages_NL.setTypeface(paramBundle);
    this.s_ctrlLanguages_PT = ((RadioButton)findViewById(2131230964));
    this.s_ctrlLanguages_PT.setTypeface(paramBundle);
    this.easy_mapBtn = ((ImageButton)findViewById(2131230940));
    if (ApplicationManager.getInstance().getSettings().getGameDifficulty() == GameDifficulty.EASY) {
      this.easy_mapBtn.setImageResource(2130837719);
    }
    this.hard_mapBtn = ((ImageButton)findViewById(2131230941));
    if (ApplicationManager.getInstance().getSettings().getGameDifficulty() == GameDifficulty.HARD) {}
    this.hard_mapBtn.setVisibility(4);
    this.HD_mapBtn = ((ImageButton)findViewById(2131230942));
    if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
      this.HD_mapBtn.setImageResource(2130837724);
    }
    if (ApplicationManager.getInstance().getSettings().getGameDifficulty() == GameDifficulty.HD) {
      this.HD_mapBtn.setImageResource(2130837723);
    }
    paramBundle = (SegmentedRadioGroup)findViewById(2131230946);
    switch (11.$SwitchMap$com$jaysquared$games$whereishd$utils$GuessTimer[ApplicationManager.getInstance().getSettings().getTimer().ordinal()])
    {
    default: 
      paramBundle = (SegmentedRadioGroup)findViewById(2131230953);
      switch (11.$SwitchMap$com$jaysquared$games$whereishd$utils$DistanceUnit[ApplicationManager.getInstance().getSettings().getDistanceUnit().ordinal()])
      {
      default: 
        label548:
        paramBundle = (SegmentedRadioGroup)findViewById(2131230957);
        switch (ApplicationManager.getInstance().getSettings().getLanguage())
        {
        default: 
          label616:
          if (ApplicationManager.getInstance().getSettings().getPayStatus() != PayStatus.NOADS)
          {
            this.moPubView = ((MoPubView)findViewById(2131230817));
            this.moPubView.setBannerAdListener(this);
            this.moPubView.setAdUnitId("839ee51f8b814b948645d5f0268a1aae");
            this.moPubView.loadAd();
          }
          break;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      buttonActions();
      return;
      paramBundle.check(2131230947);
      break;
      paramBundle.check(2131230948);
      break;
      paramBundle.check(2131230949);
      break;
      paramBundle.check(2131230950);
      break;
      paramBundle.check(2131230954);
      break label548;
      paramBundle.check(2131230955);
      break label548;
      paramBundle.check(2131230958);
      break label616;
      paramBundle.check(2131230959);
      break label616;
      paramBundle.check(2131230961);
      break label616;
      paramBundle.check(2131230960);
      break label616;
      paramBundle.check(2131230962);
      break label616;
      paramBundle.check(2131230964);
      break label616;
      paramBundle.check(2131230963);
      break label616;
      this.moPubView = ((MoPubView)findViewById(2131230817));
    }
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
    if (this.moPubView != null) {
      this.moPubView.destroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((!this.bannerClicked.booleanValue()) && (this.mapChanged.booleanValue()))
    {
      setResult(90001, new Intent(this, MainMenuActivity.class));
      finish();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    SLog.d(LOG_TAG, "settings resume");
    this.bannerClicked = Boolean.valueOf(false);
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance(this).activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance(this).activityStop(this);
  }
  
  public void showHDMapAlert()
  {
    View localView = LayoutInflater.from(this).inflate(2130903066, null);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setView(localView);
    localBuilder.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(SettingsDialogActivity.this, StartActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("downloadExpansionFile", true);
        paramAnonymousDialogInterface.putExtras(localBundle);
        SettingsDialogActivity.this.setResult(90001, paramAnonymousDialogInterface);
        SettingsDialogActivity.this.finish();
      }
    }).setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    localBuilder.create().show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/SettingsDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */