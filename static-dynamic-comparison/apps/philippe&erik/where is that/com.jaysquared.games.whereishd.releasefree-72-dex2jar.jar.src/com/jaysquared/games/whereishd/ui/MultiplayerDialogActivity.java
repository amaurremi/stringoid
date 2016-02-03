package com.jaysquared.games.whereishd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.utils.AppPreferences;
import com.jaysquared.games.whereishd.utils.GamePlayMode;
import com.jaysquared.games.whereishd.utils.SLog;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiplayerDialogActivity
  extends Activity
{
  private static final String LOG_TAG = MultiplayerDialogActivity.class.getSimpleName();
  private AppPreferences appPref;
  private TextView mCountTxt;
  private EditText[] mEditText;
  private Button mExitBtn;
  private SeekBar mSeekBar;
  private Button mSelectBtn;
  private ArrayList<String> set;
  
  private void buttonViews()
  {
    this.mExitBtn = ((Button)findViewById(2131230813));
    this.mExitBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MultiplayerDialogActivity.this.appPref.removePreferences();
        MultiplayerDialogActivity.access$102(MultiplayerDialogActivity.this, MultiplayerDialogActivity.this.appPref.getMember());
        int i = 0;
        while (i < 8)
        {
          if (MultiplayerDialogActivity.this.mEditText[i].getVisibility() == 0) {
            MultiplayerDialogActivity.this.set.add(MultiplayerDialogActivity.this.mEditText[i].getText().toString());
          }
          i += 1;
        }
        MultiplayerDialogActivity.this.appPref.setMember(MultiplayerDialogActivity.this.set);
        MultiplayerDialogActivity.this.setResult(0);
        MultiplayerDialogActivity.this.finish();
      }
    });
    this.mSelectBtn = ((Button)findViewById(2131230889));
    this.mSelectBtn.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
    this.mSelectBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MultiplayerDialogActivity.this.appPref.removePreferences();
        MultiplayerDialogActivity.access$102(MultiplayerDialogActivity.this, MultiplayerDialogActivity.this.appPref.getMember());
        int i = 0;
        while (i < 8)
        {
          if (MultiplayerDialogActivity.this.mEditText[i].getVisibility() == 0) {
            MultiplayerDialogActivity.this.set.add(MultiplayerDialogActivity.this.mEditText[i].getText().toString());
          }
          i += 1;
        }
        MultiplayerDialogActivity.this.appPref.setMember(MultiplayerDialogActivity.this.set);
        ApplicationManager.getInstance().getGameManager().setGamePlayMode(GamePlayMode.MULTIPLAYER);
        MultiplayerDialogActivity.this.setResult(-1);
        MultiplayerDialogActivity.this.finish();
      }
    });
    this.mSelectBtn.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
    ((TextView)findViewById(2131230888)).setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
  }
  
  private void editViews()
  {
    this.mEditText = new EditText[8];
    this.mEditText[0] = ((EditText)findViewById(2131230892));
    this.mEditText[1] = ((EditText)findViewById(2131230893));
    this.mEditText[2] = ((EditText)findViewById(2131230894));
    this.mEditText[3] = ((EditText)findViewById(2131230896));
    this.mEditText[4] = ((EditText)findViewById(2131230897));
    this.mEditText[5] = ((EditText)findViewById(2131230899));
    this.mEditText[6] = ((EditText)findViewById(2131230900));
    this.mEditText[7] = ((EditText)findViewById(2131230902));
    int i = 0;
    while (i < this.mEditText.length)
    {
      this.mEditText[i].setText(getString(2131427406, new Object[] { Integer.valueOf(i + 1) }));
      this.mEditText[i].setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
      i += 1;
    }
    this.set = this.appPref.getMember();
    if (this.set.size() == 0)
    {
      this.set.add(this.mEditText[0].getText().toString());
      this.set.add(this.mEditText[1].getText().toString());
      this.appPref.setMember(this.set);
      i = 0;
      label269:
      if (i >= 8) {
        return;
      }
      if (i >= this.set.size()) {
        break label349;
      }
      this.mEditText[i].setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label269;
      i = 0;
      Iterator localIterator = this.set.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.mEditText[i].setText(str);
        i += 1;
      }
      break;
      label349:
      this.mEditText[i].setVisibility(4);
    }
  }
  
  private void seekbarView()
  {
    this.set = this.appPref.getMember();
    this.mSeekBar = ((SeekBar)findViewById(2131230891));
    this.mSeekBar.setProgress(this.set.size() - 2);
    this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        SLog.d("multiplayer", String.valueOf(paramAnonymousSeekBar.getProgress()));
        int i = paramAnonymousSeekBar.getProgress() + 2;
        MultiplayerDialogActivity.this.mCountTxt.setText(MultiplayerDialogActivity.this.getString(2131427407, new Object[] { Integer.valueOf(i) }));
        paramAnonymousInt = 0;
        if (paramAnonymousInt < 8)
        {
          if (paramAnonymousInt < i) {
            MultiplayerDialogActivity.this.mEditText[paramAnonymousInt].setVisibility(0);
          }
          for (;;)
          {
            paramAnonymousInt += 1;
            break;
            MultiplayerDialogActivity.this.mEditText[paramAnonymousInt].setVisibility(4);
          }
        }
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SLog.d(LOG_TAG, "Creating activity...");
    setContentView(2130903075);
    this.appPref = new AppPreferences(getApplicationContext());
    this.set = new ArrayList();
    editViews();
    this.mCountTxt = ((TextView)findViewById(2131230890));
    if (this.set.size() == 0) {
      this.mCountTxt.setText(getString(2131427407, new Object[] { Integer.valueOf(2) }));
    }
    for (;;)
    {
      this.mCountTxt.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
      buttonViews();
      seekbarView();
      return;
      this.mCountTxt.setText(getString(2131427407, new Object[] { Integer.valueOf(this.set.size()) }));
    }
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/MultiplayerDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */