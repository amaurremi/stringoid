package com.pioong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

public class SplashActivity
  extends Activity
{
  private boolean exit = false;
  private LinearLayout splash;
  
  public void onBackPressed()
  {
    this.exit = true;
    startActivity(new Intent(this, IntroActivity.class));
    overridePendingTransition(2130968576, 2130968577);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
    paramBundle = new AlphaAnimation(0.0F, 1.0F);
    paramBundle.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if (!SplashActivity.this.exit)
            {
              SplashActivity.this.startActivity(new Intent(SplashActivity.this, IntroActivity.class));
              SplashActivity.this.overridePendingTransition(2130968576, 2130968577);
              SplashActivity.this.finish();
            }
          }
        }, 1000L);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramBundle.setDuration(300L);
    this.splash = ((LinearLayout)findViewById(2131296284));
    this.splash.startAnimation(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */