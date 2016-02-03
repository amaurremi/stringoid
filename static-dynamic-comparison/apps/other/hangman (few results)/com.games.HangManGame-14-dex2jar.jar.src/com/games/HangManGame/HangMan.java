package com.games.HangManGame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.PrintStream;

public class HangMan
  extends Activity
{
  public static int ABOUT_US_ACTIVITY_REQ_CODE = 333;
  public static final boolean DEBUG = true;
  public static int HOW_TO_PLAY_ACTIVITY_REQ_CODE = 0;
  public static final int MENU_ABOUTUS_ID = 3;
  public static final int MENU_HOWTOPLAY_ID = 2;
  public static final int MENU_SETTINGS_ID = 1;
  private static final int REQ_CODE = 123;
  private static final int REQ_CODE1 = 100;
  public static int SETTING_ACTIVITY_REQ_CODE = 111;
  public static final String TAG = "HangMan";
  private int COUNT = 0;
  public char CURRENTCHAR;
  private String CURRENT_WORD = "";
  public int INDEX = 0;
  private int LOSS_COUNT = 0;
  private boolean MUSIC_MODE = true;
  public int TXTVIEW_INDEX = 0;
  private Button a;
  private Dialog ab;
  public Button[] alphabets = new Button[26];
  private Button b;
  private MediaPlayer backGroundSoundPlayer;
  Boolean bol = Boolean.valueOf(false);
  private Button c;
  private TextView catgHintView;
  private TextView ch1;
  private TextView ch10;
  private TextView ch11;
  private TextView ch12;
  private TextView ch13;
  private TextView ch14;
  private TextView ch15;
  private TextView ch2;
  private TextView ch3;
  private TextView ch4;
  private TextView ch5;
  private TextView ch6;
  private TextView ch7;
  private TextView ch8;
  private TextView ch9;
  CountDownTimer countDownTimer;
  private Button d;
  private Button e;
  private Button f;
  private Button g;
  private Button h;
  Handler handler;
  private ImageView hangman;
  private Button hintBtn;
  public String hintString;
  private TextView hintTextView;
  public Hints hints;
  private Button i;
  private int[] imagesRes = { 2130837526, 2130837536, 2130837534, 2130837510, 2130837509, 2130837529, 2130837528, 2130837508, 2130837524 };
  Boolean isSoundMute = Boolean.valueOf(false);
  boolean isTimeOver = false;
  private Button j;
  private Button k;
  private Button l;
  private Button m;
  private MediaPlayer mp;
  private Button musicBtn;
  private Typeface myFont;
  public Toast myToast;
  private Button n;
  private Button newGame;
  private Button o;
  private Button okBtn;
  private Button p;
  public SharedPreferences preferences;
  private Button q;
  private Button r;
  private Button s;
  private Button seeOnMap;
  private Button t;
  public TextView[] textBoxes = new TextView[26];
  private TextView timer;
  private Typeface timerFont;
  private Button u;
  private Button v;
  private Button w;
  private Button wikiHelp;
  private int wordCategory;
  private Button x;
  private Button y;
  private Button z;
  
  static
  {
    HOW_TO_PLAY_ACTIVITY_REQ_CODE = 222;
  }
  
  public void callGameLogic(char paramChar)
  {
    if (this.CURRENT_WORD.contains(String.valueOf(this.CURRENTCHAR)))
    {
      char[] arrayOfChar = this.CURRENT_WORD.toCharArray();
      char c1 = arrayOfChar.length;
      paramChar = '\000';
      if (paramChar >= c1) {
        return;
      }
      if (String.valueOf(arrayOfChar[paramChar]).equalsIgnoreCase(String.valueOf(this.CURRENTCHAR)))
      {
        this.TXTVIEW_INDEX += 1;
        this.COUNT += 1;
        display_Letter(this.TXTVIEW_INDEX);
        checkWin();
      }
      for (;;)
      {
        paramChar += '\001';
        break;
        this.TXTVIEW_INDEX += 1;
      }
    }
    this.LOSS_COUNT += 1;
    displayHangManImgs(this.LOSS_COUNT);
    checkLost();
  }
  
  public void checkLost()
  {
    if ((this.LOSS_COUNT == 9) || (this.isTimeOver))
    {
      Toast.makeText(this, "U LOST THE GAME", 1).show();
      this.countDownTimer.cancel();
      setBtnsUnClickable();
      wikiMapFtr();
      displayWord();
      playSound("lost");
      this.COUNT = 0;
      this.LOSS_COUNT = 0;
      this.hangman.setBackgroundResource(2130837524);
      this.isTimeOver = false;
    }
  }
  
  public void checkWin()
  {
    if (this.COUNT == this.CURRENT_WORD.length())
    {
      this.countDownTimer.cancel();
      this.myToast.show();
      setBtnsUnClickable();
      wikiMapFtr();
      playSound("win");
      this.COUNT = 0;
      this.LOSS_COUNT = 0;
    }
  }
  
  public void displayCategory(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.catgHintView.setText("Guess " + str);
      return;
      str = "Country Name";
      continue;
      str = "Animal Name";
      continue;
      str = "Element Name";
      continue;
      str = "Sports Name";
      continue;
      str = "Movie Name";
      continue;
      str = "Actor & Actress Names";
    }
  }
  
  public void displayHangManImgs(int paramInt)
  {
    int i1 = 0;
    for (;;)
    {
      if (i1 >= 9) {
        return;
      }
      if (paramInt - 1 == i1) {
        this.hangman.setBackgroundResource(this.imagesRes[i1]);
      }
      i1 += 1;
    }
  }
  
  public void displayWord()
  {
    char[] arrayOfChar = this.CURRENT_WORD.toCharArray();
    int i2 = 0;
    int i3 = arrayOfChar.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i3) {
        return;
      }
      char c1 = arrayOfChar[i1];
      this.textBoxes[i2].setText(String.valueOf(c1).toUpperCase());
      i2 += 1;
      i1 += 1;
    }
  }
  
  public void display_Letter(int paramInt)
  {
    int i2 = this.textBoxes.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return;
      }
      if (paramInt - 1 == i1) {
        this.textBoxes[i1].setText(String.valueOf(this.CURRENTCHAR).toUpperCase());
      }
      i1 += 1;
    }
  }
  
  public View.OnClickListener getOnClickListener(final Button paramButton)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HangMan.this.TXTVIEW_INDEX = 0;
        paramButton.setVisibility(4);
        int i = 0;
        for (;;)
        {
          if (i >= 26) {
            return;
          }
          if (paramButton == HangMan.this.alphabets[i])
          {
            HangMan.this.INDEX = i;
            HangMan.this.CURRENTCHAR = Helper_Class.getCharAtIndex(i);
            HangMan.this.callGameLogic(HangMan.this.CURRENTCHAR);
            return;
          }
          i += 1;
        }
      }
    };
  }
  
  public long getTime()
  {
    return 180000L;
  }
  
  public String getTime(long paramLong)
  {
    paramLong /= 1000L;
    Object localObject3 = Integer.toString((int)(paramLong % 60L));
    Object localObject1 = Integer.toString((int)(paramLong % 3600L / 60L));
    int i1 = 0;
    for (;;)
    {
      if (i1 >= 2) {
        return "  " + (String)localObject1 + ":" + (String)localObject3;
      }
      Object localObject2 = localObject3;
      if (((String)localObject3).length() < 2) {
        localObject2 = "0" + (String)localObject3;
      }
      localObject3 = localObject1;
      if (((String)localObject1).length() < 2) {
        localObject3 = "0" + (String)localObject1;
      }
      i1 += 1;
      localObject1 = localObject3;
      localObject3 = localObject2;
    }
  }
  
  public void invokeHandler()
  {
    this.handler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        HangMan localHangMan = HangMan.this;
        boolean bool;
        if (HangMan.this.bol.booleanValue())
        {
          bool = false;
          localHangMan.bol = Boolean.valueOf(bool);
          if (!HangMan.this.bol.booleanValue()) {
            break label89;
          }
          HangMan.this.catgHintView.setTextColor(-65536);
        }
        for (;;)
        {
          HangMan.this.catgHintView.invalidate();
          HangMan.this.handler.sendEmptyMessageDelayed(0, 500L);
          super.handleMessage(paramAnonymousMessage);
          return;
          bool = true;
          break;
          label89:
          HangMan.this.catgHintView.setTextColor(-1);
        }
      }
    };
    this.handler.sendEmptyMessage(0);
  }
  
  public void makeMyToast()
  {
    View localView = getLayoutInflater().inflate(2130903045, (ViewGroup)findViewById(2131296315));
    ((ImageView)localView.findViewById(2131296316)).setImageResource(2130837538);
    TextView localTextView = (TextView)localView.findViewById(2131296317);
    localTextView.setTypeface(this.myFont);
    localTextView.setTextSize(24.0F);
    localTextView.setText(" \t\tU \n\t WON \nTHE GAME..!!");
    this.myToast = new Toast(getApplicationContext());
    this.myToast.setGravity(16, -45, -60);
    this.myToast.setDuration(1);
    this.myToast.setView(localView);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == SETTING_ACTIVITY_REQ_CODE) {
      selectWord();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    this.preferences = PreferenceManager.getDefaultSharedPreferences(this);
    setContentView(2130903043);
    if (!this.isSoundMute.booleanValue()) {
      playBackGroundSound();
    }
    this.myFont = Typeface.createFromAsset(getAssets(), "fonts/myFont.ttf");
    this.timerFont = Typeface.createFromAsset(getAssets(), "fonts/timefont.ttf");
    this.hints = new Hints();
    this.catgHintView = ((TextView)findViewById(2131296265));
    this.wikiHelp = ((Button)findViewById(2131296270));
    this.wikiHelp.setVisibility(4);
    this.wikiHelp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((HangMan.this.wordCategory == 5) || (HangMan.this.wordCategory == 6)) {}
        for (paramAnonymousView = HangMan.this.hints.getWikiId(HangMan.this.CURRENT_WORD, HangMan.this.wordCategory);; paramAnonymousView = HangMan.this.CURRENT_WORD)
        {
          paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse("http://en.wikipedia.org/wiki/" + paramAnonymousView));
          HangMan.this.startActivityForResult(paramAnonymousView, 123);
          return;
        }
      }
    });
    this.seeOnMap = ((Button)findViewById(2131296271));
    this.seeOnMap.setVisibility(4);
    this.seeOnMap.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + HangMan.this.CURRENT_WORD));
        HangMan.this.startActivityForResult(paramAnonymousView, 100);
      }
    });
    this.newGame = ((Button)findViewById(2131296268));
    this.newGame.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HangMan.this.selectWord();
      }
    });
    this.hangman = ((ImageView)findViewById(2131296266));
    this.musicBtn = ((Button)findViewById(2131296313));
    this.musicBtn.setBackgroundResource(2130837520);
    this.musicBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = HangMan.this;
        boolean bool;
        if (HangMan.this.MUSIC_MODE)
        {
          bool = false;
          paramAnonymousView.MUSIC_MODE = bool;
          if (!HangMan.this.MUSIC_MODE) {
            break label68;
          }
          HangMan.this.isSoundMute = Boolean.valueOf(false);
          HangMan.this.musicBtn.setBackgroundResource(2130837520);
          HangMan.this.playBackGroundSound();
        }
        label68:
        do
        {
          return;
          bool = true;
          break;
          HangMan.this.isSoundMute = Boolean.valueOf(true);
          HangMan.this.musicBtn.setBackgroundResource(2130837519);
        } while (HangMan.this.backGroundSoundPlayer == null);
        HangMan.this.backGroundSoundPlayer.stop();
        HangMan.this.backGroundSoundPlayer.release();
        HangMan.this.backGroundSoundPlayer = null;
      }
    });
    this.hintBtn = ((Button)findViewById(2131296269));
    this.hintBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HangMan.this.hintTextView.setText(HangMan.this.hintString);
        HangMan.this.ab.show();
      }
    });
    this.timer = ((TextView)findViewById(2131296267));
    this.timer.setTypeface(this.timerFont);
    registerDialogBox();
    makeMyToast();
    invokeHandler();
    registerButtons();
    registerListeners();
    registerTextBoxes();
    selectWord();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 1, 0, "Settings");
    paramMenu.add(0, 2, 0, "How to play");
    paramMenu.add(0, 3, 0, "More Games");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    this.handler.removeMessages(0);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.backGroundSoundPlayer != null))
    {
      this.backGroundSoundPlayer.stop();
      this.backGroundSoundPlayer.release();
      this.backGroundSoundPlayer = null;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      startActivityForResult(new Intent(this, GamePreferences.class), SETTING_ACTIVITY_REQ_CODE);
      continue;
      startActivityForResult(new Intent(this, HowToPlayActivity.class), HOW_TO_PLAY_ACTIVITY_REQ_CODE);
      continue;
      startActivityForResult(new Intent(this, AboutUsActivity.class), ABOUT_US_ACTIVITY_REQ_CODE);
    }
  }
  
  protected void onPause()
  {
    if (this.backGroundSoundPlayer != null)
    {
      this.backGroundSoundPlayer.stop();
      this.backGroundSoundPlayer.release();
      this.backGroundSoundPlayer = null;
    }
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  protected void onResume()
  {
    if ((this.MUSIC_MODE) && (this.backGroundSoundPlayer == null)) {
      playBackGroundSound();
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    this.countDownTimer.cancel();
    super.onStop();
  }
  
  public void playBackGroundSound()
  {
    this.backGroundSoundPlayer = MediaPlayer.create(this, 2131034112);
    this.backGroundSoundPlayer.setLooping(true);
    this.backGroundSoundPlayer.start();
  }
  
  public void playSound(String paramString)
  {
    if (!this.isSoundMute.booleanValue()) {
      if (!paramString.equals("win")) {
        break label56;
      }
    }
    label56:
    for (int i1 = 2131034113;; i1 = 2131034114)
    {
      this.mp = MediaPlayer.create(this, i1);
      this.mp.start();
      this.mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          if (HangMan.this.mp != null)
          {
            HangMan.this.mp.stop();
            HangMan.this.mp.release();
            HangMan.this.mp = null;
          }
        }
      });
      return;
    }
  }
  
  public void registerButtons()
  {
    this.a = ((Button)findViewById(2131296287));
    this.b = ((Button)findViewById(2131296288));
    this.c = ((Button)findViewById(2131296289));
    this.d = ((Button)findViewById(2131296290));
    this.e = ((Button)findViewById(2131296291));
    this.f = ((Button)findViewById(2131296292));
    this.g = ((Button)findViewById(2131296293));
    this.h = ((Button)findViewById(2131296294));
    this.i = ((Button)findViewById(2131296295));
    this.j = ((Button)findViewById(2131296296));
    this.k = ((Button)findViewById(2131296297));
    this.l = ((Button)findViewById(2131296298));
    this.m = ((Button)findViewById(2131296299));
    this.n = ((Button)findViewById(2131296300));
    this.o = ((Button)findViewById(2131296301));
    this.p = ((Button)findViewById(2131296302));
    this.q = ((Button)findViewById(2131296303));
    this.r = ((Button)findViewById(2131296304));
    this.s = ((Button)findViewById(2131296305));
    this.t = ((Button)findViewById(2131296306));
    this.u = ((Button)findViewById(2131296307));
    this.v = ((Button)findViewById(2131296308));
    this.w = ((Button)findViewById(2131296309));
    this.x = ((Button)findViewById(2131296310));
    this.y = ((Button)findViewById(2131296311));
    this.z = ((Button)findViewById(2131296312));
    this.alphabets = new Button[] { this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z };
  }
  
  public void registerDialogBox()
  {
    this.ab = new Dialog(this);
    this.ab.requestWindowFeature(1);
    this.ab.setContentView(2130903041);
    this.hintTextView = ((TextView)this.ab.findViewById(2131296260));
    this.okBtn = ((Button)this.ab.findViewById(2131296261));
    this.okBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HangMan.this.ab.dismiss();
      }
    });
  }
  
  public void registerListeners()
  {
    Button[] arrayOfButton = this.alphabets;
    int i2 = arrayOfButton.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return;
      }
      Button localButton = arrayOfButton[i1];
      localButton.setOnClickListener(getOnClickListener(localButton));
      i1 += 1;
    }
  }
  
  public void registerTextBoxes()
  {
    this.ch1 = ((TextView)findViewById(2131296272));
    this.ch2 = ((TextView)findViewById(2131296273));
    this.ch3 = ((TextView)findViewById(2131296274));
    this.ch4 = ((TextView)findViewById(2131296275));
    this.ch5 = ((TextView)findViewById(2131296276));
    this.ch6 = ((TextView)findViewById(2131296277));
    this.ch7 = ((TextView)findViewById(2131296278));
    this.ch8 = ((TextView)findViewById(2131296279));
    this.ch9 = ((TextView)findViewById(2131296280));
    this.ch10 = ((TextView)findViewById(2131296281));
    this.ch11 = ((TextView)findViewById(2131296282));
    this.ch12 = ((TextView)findViewById(2131296283));
    this.ch13 = ((TextView)findViewById(2131296284));
    this.ch14 = ((TextView)findViewById(2131296285));
    this.ch15 = ((TextView)findViewById(2131296286));
    this.textBoxes = new TextView[] { this.ch1, this.ch2, this.ch3, this.ch4, this.ch5, this.ch6, this.ch7, this.ch8, this.ch9, this.ch10, this.ch11, this.ch12, this.ch13, this.ch14, this.ch15 };
  }
  
  public void resetAlphaBtns()
  {
    int i2 = this.alphabets.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return;
      }
      this.alphabets[i1].setVisibility(0);
      i1 += 1;
    }
  }
  
  public void resetTextViews()
  {
    int i2 = this.textBoxes.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return;
      }
      this.textBoxes[i1].setText("");
      i1 += 1;
    }
  }
  
  public void selectWord()
  {
    this.wordCategory = Integer.parseInt(this.preferences.getString("pref_key_category", "0"));
    if (this.wordCategory == 0) {
      do
      {
        this.wordCategory = ((int)Math.floor(Math.random() * 7.0D));
        System.out.println(this.i);
      } while (this.wordCategory == 0);
    }
    displayCategory(this.wordCategory);
    startCountDownTimer();
    this.COUNT = 0;
    this.LOSS_COUNT = 0;
    resetTextViews();
    resetAlphaBtns();
    setBtnsClickable();
    this.wikiHelp.setVisibility(4);
    this.seeOnMap.setVisibility(4);
    this.hangman.setBackgroundResource(2130837533);
    this.CURRENT_WORD = Helper_Class.getWord(this.wordCategory);
    this.hintString = this.hints.getHint(this.CURRENT_WORD, this.wordCategory);
    int i1 = 0;
    if (i1 >= this.CURRENT_WORD.length()) {
      return;
    }
    if (this.CURRENT_WORD.charAt(i1) == ' ')
    {
      this.textBoxes[i1].setText("");
      this.COUNT += 1;
    }
    for (;;)
    {
      i1 += 1;
      break;
      this.textBoxes[i1].setText("__");
    }
  }
  
  public void setBtnsClickable()
  {
    int i2 = this.alphabets.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return;
      }
      this.alphabets[i1].setClickable(true);
      i1 += 1;
    }
  }
  
  public void setBtnsUnClickable()
  {
    int i2 = this.alphabets.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return;
      }
      this.alphabets[i1].setClickable(false);
      i1 += 1;
    }
  }
  
  public void startCountDownTimer()
  {
    if (this.countDownTimer != null)
    {
      this.countDownTimer.cancel();
      this.countDownTimer = null;
    }
    this.countDownTimer = new CountDownTimer(getTime(), 1000L)
    {
      public void onFinish()
      {
        HangMan.this.timer.setText("  00:00");
        HangMan.this.isTimeOver = true;
        HangMan.this.checkLost();
      }
      
      public void onTick(long paramAnonymousLong)
      {
        HangMan.this.timer.setText(HangMan.this.getTime(paramAnonymousLong));
      }
    };
    this.countDownTimer.start();
  }
  
  public void wikiMapFtr()
  {
    if (this.wordCategory == 1)
    {
      this.wikiHelp.setVisibility(0);
      this.seeOnMap.setVisibility(0);
    }
    if ((this.wordCategory == 2) || (this.wordCategory == 3) || (this.wordCategory == 4) || (this.wordCategory == 5) || (this.wordCategory == 6)) {
      this.wikiHelp.setVisibility(0);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/games/HangManGame/HangMan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */