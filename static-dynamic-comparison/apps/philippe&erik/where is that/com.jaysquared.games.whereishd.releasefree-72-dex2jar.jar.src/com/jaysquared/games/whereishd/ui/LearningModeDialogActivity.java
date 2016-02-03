package com.jaysquared.games.whereishd.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.db.Categories;
import com.jaysquared.games.whereishd.db.CategoriesUserdata;
import com.jaysquared.games.whereishd.db.DatabaseManager;
import com.jaysquared.games.whereishd.utils.DisplaySize;
import com.jaysquared.games.whereishd.utils.DistanceUnit;
import com.jaysquared.games.whereishd.utils.InAppSupportHelper;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

public class LearningModeDialogActivity
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = LearningModeDialogActivity.class.getSimpleName();
  private Categories category;
  private CategoriesUserdata categoryUserdata;
  private String category_id;
  private int distance = 0;
  private RadioGroup distanceRadioGroup;
  private TextView distanceTextView;
  private int exclude = 0;
  private RadioGroup excludeRadioGroup;
  private TextView excludeTextView;
  private Button exitButton;
  private Button feedbackButton;
  private RadioButton loc1;
  private RadioButton loc2;
  private RadioButton loc3;
  private RadioButton loc4;
  private RadioButton loc5;
  private RadioGroup locationsRadioGroup;
  private int locationsSelection = 0;
  private TextView locationsTextView;
  private TextView mainTitleTextView;
  private MoPubView moPubView = null;
  private RadioButton rb1;
  private RadioButton rb2;
  private RadioButton rb3;
  private RadioButton rb4;
  private Button resetButton;
  private RadioButton rg1;
  private RadioButton rg2;
  private RadioButton rg3;
  private RadioButton rg4;
  private Button startButton;
  private TextView subtitleTextView;
  private TextView titleTextView;
  private int value = 0;
  
  private void SetupListeners()
  {
    this.excludeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          LearningModeDialogActivity.this.changeViews();
          return;
          LearningModeDialogActivity.access$002(LearningModeDialogActivity.this, 0);
          continue;
          LearningModeDialogActivity.access$002(LearningModeDialogActivity.this, 2);
          continue;
          LearningModeDialogActivity.access$002(LearningModeDialogActivity.this, 3);
          continue;
          LearningModeDialogActivity.access$002(LearningModeDialogActivity.this, 4);
          continue;
          LearningModeDialogActivity.access$002(LearningModeDialogActivity.this, 5);
        }
      }
    });
    this.locationsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          LearningModeDialogActivity.this.changeViews();
          return;
          LearningModeDialogActivity.access$102(LearningModeDialogActivity.this, 2131230836);
          continue;
          LearningModeDialogActivity.access$102(LearningModeDialogActivity.this, 2131230837);
          continue;
          LearningModeDialogActivity.access$102(LearningModeDialogActivity.this, 2131230838);
          continue;
          LearningModeDialogActivity.access$102(LearningModeDialogActivity.this, 2131230839);
        }
      }
    });
    this.distanceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          LearningModeDialogActivity.this.changeViews();
          return;
          LearningModeDialogActivity.access$202(LearningModeDialogActivity.this, 0);
          continue;
          LearningModeDialogActivity.access$202(LearningModeDialogActivity.this, 25);
          continue;
          LearningModeDialogActivity.access$202(LearningModeDialogActivity.this, 50);
          continue;
          LearningModeDialogActivity.access$202(LearningModeDialogActivity.this, 100);
        }
      }
    });
    this.resetButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new AlertDialog.Builder(LearningModeDialogActivity.this).create();
        paramAnonymousView.setCancelable(false);
        paramAnonymousView.setMessage("Reset Learning Status - This can't be undone.");
        paramAnonymousView.setButton("Cancel", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        paramAnonymousView.setButton2("Reset", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            boolean bool = false;
            DatabaseManager.getInstance().resetCategory(LearningModeDialogActivity.this.category_id);
            LearningModeDialogActivity.access$102(LearningModeDialogActivity.this, 0);
            LearningModeDialogActivity.access$202(LearningModeDialogActivity.this, 0);
            LearningModeDialogActivity.access$002(LearningModeDialogActivity.this, 0);
            LearningModeDialogActivity localLearningModeDialogActivity = LearningModeDialogActivity.this;
            DatabaseManager localDatabaseManager = DatabaseManager.getInstance();
            String str = LearningModeDialogActivity.this.category_id;
            if (LearningModeDialogActivity.this.exclude == 0) {
              bool = true;
            }
            LearningModeDialogActivity.access$402(localLearningModeDialogActivity, (int)localDatabaseManager.getLocationsCount(str, bool));
            LearningModeDialogActivity.this.storeData();
            LearningModeDialogActivity.this.changeViews();
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        paramAnonymousView.show();
      }
    });
    this.exitButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LearningModeDialogActivity.this.storeData();
        LearningModeDialogActivity.this.finish();
      }
    });
    this.feedbackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InAppSupportHelper.openSupportChannel(LearningModeDialogActivity.this);
      }
    });
    this.startButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LearningModeDialogActivity.this.storeData();
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("category_id", LearningModeDialogActivity.this.category_id);
        Intent localIntent = new Intent(LearningModeDialogActivity.this, GameActivity.class);
        localIntent.putExtras(paramAnonymousView);
        LearningModeDialogActivity.this.setResult(90001, localIntent);
        LearningModeDialogActivity.this.finish();
      }
    });
  }
  
  private void loadData()
  {
    this.locationsSelection = this.categoryUserdata.getLocationsSelection();
    this.distance = this.categoryUserdata.getDistanceFactor();
    this.exclude = this.categoryUserdata.getExclude();
    DatabaseManager localDatabaseManager = DatabaseManager.getInstance();
    String str = this.category_id;
    if (this.exclude == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.value = ((int)localDatabaseManager.getLocationsCount(str, bool));
      return;
    }
  }
  
  private void setStartButton()
  {
    if (this.value == 0)
    {
      this.startButton.setEnabled(false);
      this.startButton.setBackgroundResource(2130837647);
      this.startButton.setText(getString(2131427399));
      return;
    }
    this.startButton.setEnabled(true);
    this.startButton.setBackgroundResource(2130837598);
    this.startButton.setText(getString(2131427425, new Object[] { Integer.valueOf(this.value) }));
  }
  
  private void storeData()
  {
    this.categoryUserdata.setLocations(this.value);
    this.categoryUserdata.setExclude(this.exclude);
    this.categoryUserdata.setDistanceFactor(this.distance);
    this.categoryUserdata.setLocationsSelection(this.locationsSelection);
    DatabaseManager.getInstance().updateCategoryUserdata(this.categoryUserdata);
  }
  
  public void changeViews()
  {
    label64:
    label108:
    boolean bool;
    switch (this.distance)
    {
    default: 
      if (this.locationsSelection == 0)
      {
        this.locationsRadioGroup.check(2131230836);
        switch (this.exclude)
        {
        case 1: 
        default: 
          DatabaseManager localDatabaseManager = DatabaseManager.getInstance();
          String str = this.category_id;
          if (this.exclude == 0)
          {
            bool = true;
            label126:
            this.value = ((int)localDatabaseManager.getLocationsCount(str, bool));
            switch (this.locationsRadioGroup.getCheckedRadioButtonId())
            {
            }
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      setStartButton();
      return;
      this.distanceRadioGroup.check(2131230843);
      this.distanceRadioGroup.check(2131230844);
      break;
      this.distanceRadioGroup.check(2131230845);
      break;
      this.distanceRadioGroup.check(2131230846);
      break;
      this.locationsRadioGroup.check(this.locationsSelection);
      break label64;
      this.excludeRadioGroup.check(2131230827);
      break label108;
      this.excludeRadioGroup.check(2131230828);
      break label108;
      this.excludeRadioGroup.check(2131230829);
      break label108;
      this.excludeRadioGroup.check(2131230830);
      break label108;
      this.excludeRadioGroup.check(2131230831);
      break label108;
      bool = false;
      break label126;
      if (this.value >= 10)
      {
        this.value = 10;
        continue;
        if (this.value >= 25)
        {
          this.value = 25;
          continue;
          if (this.value >= 50) {
            this.value = 50;
          }
        }
      }
    }
  }
  
  public void onBannerClicked(MoPubView paramMoPubView) {}
  
  public void onBannerCollapsed(MoPubView paramMoPubView) {}
  
  public void onBannerExpanded(MoPubView paramMoPubView) {}
  
  public void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode) {}
  
  public void onBannerLoaded(MoPubView paramMoPubView)
  {
    findViewById(2131230816).setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SLog.d(LOG_TAG, "Creating activity...");
    setContentView(2130903070);
    this.startButton = ((Button)findViewById(2131230851));
    this.resetButton = ((Button)findViewById(2131230849));
    this.feedbackButton = ((Button)findViewById(2131230815));
    this.mainTitleTextView = ((TextView)findViewById(2131230818));
    this.titleTextView = ((TextView)findViewById(2131230782));
    this.subtitleTextView = ((TextView)findViewById(2131230820));
    this.excludeTextView = ((TextView)findViewById(2131230824));
    this.locationsTextView = ((TextView)findViewById(2131230834));
    this.distanceTextView = ((TextView)findViewById(2131230841));
    this.locationsRadioGroup = ((RadioGroup)findViewById(2131230835));
    this.distanceRadioGroup = ((RadioGroup)findViewById(2131230842));
    this.excludeRadioGroup = ((RadioGroup)findViewById(2131230826));
    this.exitButton = ((Button)findViewById(2131230813));
    this.rg1 = ((RadioButton)findViewById(2131230836));
    this.rg2 = ((RadioButton)findViewById(2131230837));
    this.rg3 = ((RadioButton)findViewById(2131230838));
    this.rg4 = ((RadioButton)findViewById(2131230839));
    this.rg2.setText("10");
    this.rg3.setText("25");
    this.rg4.setText("50");
    paramBundle = ApplicationManager.getInstance().getGameManager().getTypeface();
    this.rg1.setTypeface(paramBundle);
    this.rg2.setTypeface(paramBundle);
    this.rg3.setTypeface(paramBundle);
    this.rg4.setTypeface(paramBundle);
    this.rb1 = ((RadioButton)findViewById(2131230843));
    this.rb2 = ((RadioButton)findViewById(2131230844));
    this.rb3 = ((RadioButton)findViewById(2131230845));
    this.rb4 = ((RadioButton)findViewById(2131230846));
    String str;
    if (ApplicationManager.getInstance().getSettings().getDistanceUnit() == DistanceUnit.KILOMETERS)
    {
      str = getString(2131427379);
      this.rb1 = ((RadioButton)findViewById(2131230843));
      this.rb2.setText("25" + str);
      this.rb3.setText("50" + str);
      this.rb4.setText("100" + str);
      this.rb1.setTypeface(paramBundle);
      this.rb2.setTypeface(paramBundle);
      this.rb3.setTypeface(paramBundle);
      this.rb4.setTypeface(paramBundle);
      this.loc1 = ((RadioButton)findViewById(2131230827));
      this.loc2 = ((RadioButton)findViewById(2131230828));
      this.loc3 = ((RadioButton)findViewById(2131230829));
      this.loc4 = ((RadioButton)findViewById(2131230830));
      this.loc5 = ((RadioButton)findViewById(2131230831));
      this.loc1.setTypeface(paramBundle);
      this.loc2.setTypeface(paramBundle);
      this.loc3.setTypeface(paramBundle);
      this.loc4.setTypeface(paramBundle);
      this.loc5.setTypeface(paramBundle);
      this.startButton.setTypeface(paramBundle);
      this.resetButton.setTypeface(paramBundle);
      this.mainTitleTextView.setTypeface(paramBundle);
      this.feedbackButton.setTypeface(paramBundle);
      this.titleTextView.setTypeface(paramBundle);
      this.subtitleTextView.setTypeface(paramBundle);
      this.excludeTextView.setTypeface(paramBundle);
      this.locationsTextView.setTypeface(paramBundle);
      this.distanceTextView.setTypeface(paramBundle);
      if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
        break label995;
      }
      this.moPubView = ((MoPubView)findViewById(2131230817));
      this.moPubView.setBannerAdListener(this);
      this.moPubView.setAdUnitId("839ee51f8b814b948645d5f0268a1aae");
      this.moPubView.loadAd();
    }
    for (;;)
    {
      paramBundle = ApplicationManager.getInstance().getGameManager().getDisplaySize();
      if ((paramBundle == DisplaySize.NORMAL) || (paramBundle == DisplaySize.SMALL)) {
        ((LinearLayout)findViewById(2131230852)).setVisibility(8);
      }
      this.category_id = getIntent().getExtras().getString("category_id");
      this.category = DatabaseManager.getInstance().getCategory(this.category_id);
      this.categoryUserdata = this.category.getUserdata();
      paramBundle = this.category.getTitle().split(">");
      this.titleTextView.setText(paramBundle[0]);
      this.subtitleTextView.setText(paramBundle[1]);
      loadData();
      changeViews();
      SetupListeners();
      return;
      str = getString(2131427392);
      this.rb1 = ((RadioButton)findViewById(2131230843));
      this.rb2.setText("25" + str);
      this.rb3.setText("50" + str);
      this.rb4.setText("100" + str);
      break;
      label995:
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/LearningModeDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */