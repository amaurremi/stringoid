package com.games.HangManGame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;

public class MainScreen
  extends Activity
{
  public static final boolean DEBUG = true;
  public static final String TAG = "Hangman";
  Boolean bol = Boolean.valueOf(false);
  Handler handler;
  private Typeface myFont;
  private TextView tx;
  
  public void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903044);
    this.myFont = Typeface.createFromAsset(getAssets(), "fonts/myFont1.ttf");
    this.tx = ((TextView)findViewById(2131296314));
    this.tx.setTypeface(this.myFont);
    this.handler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        MainScreen localMainScreen = MainScreen.this;
        boolean bool;
        if (MainScreen.this.bol.booleanValue())
        {
          bool = false;
          localMainScreen.bol = Boolean.valueOf(bool);
          if (!MainScreen.this.bol.booleanValue()) {
            break label89;
          }
          MainScreen.this.tx.setTextColor(-65536);
        }
        for (;;)
        {
          MainScreen.this.tx.invalidate();
          MainScreen.this.handler.sendEmptyMessageDelayed(0, 500L);
          super.handleMessage(paramAnonymousMessage);
          return;
          bool = true;
          break;
          label89:
          MainScreen.this.tx.setTextColor(-1);
        }
      }
    };
    this.handler.sendEmptyMessage(0);
    super.onCreate(paramBundle);
  }
  
  protected void onStop()
  {
    this.handler.removeMessages(0);
    super.onStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Log.i("Hangman", "I am getting called in on touch");
    startActivity(new Intent(this, HangMan.class));
    finish();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/games/HangManGame/MainScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */