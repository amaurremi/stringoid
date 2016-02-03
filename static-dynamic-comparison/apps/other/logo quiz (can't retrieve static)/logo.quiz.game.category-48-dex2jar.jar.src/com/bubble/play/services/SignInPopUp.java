package com.bubble.play.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.bluebird.mobile.tools.font.FontLoader;
import com.bluebird.mobile.tools.net.NetUtils;
import com.google.example.games.basegameutils.GameHelper;

public class SignInPopUp
  implements View.OnClickListener
{
  public static final String LOG_NAME = "logo.quiz.commons.popup.SignInPopUp";
  static boolean isPopUpOffAnimEnd = true;
  private Activity activity;
  private GameHelper gameHelper;
  private boolean isPopUpShow = false;
  protected ProgressDialog mLoadingDialog = null;
  
  public SignInPopUp(ProgressDialog paramProgressDialog, GameHelper paramGameHelper, Activity paramActivity)
  {
    this.mLoadingDialog = paramProgressDialog;
    this.gameHelper = paramGameHelper;
    this.activity = paramActivity;
  }
  
  private void animateShow()
  {
    this.activity.findViewById(R.id.signInPopUp).setVisibility(0);
    popUp(R.id.popUpContainer, 100, this.activity);
    darkScreen(R.id.signInPopUpBg, 0, this.activity);
  }
  
  public static Animation darkScreen(int paramInt1, int paramInt2, Activity paramActivity)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(paramActivity, R.anim.dark_screen);
    localAnimation.setStartOffset(paramInt2);
    paramActivity.findViewById(paramInt1).startAnimation(localAnimation);
    return localAnimation;
  }
  
  private boolean init()
  {
    if ((this.activity.findViewById(R.id.signInPopUpStub) != null) || (this.activity.findViewById(R.id.signInPopUp) != null))
    {
      if (this.activity.findViewById(R.id.signInPopUp) == null) {
        ((ViewStub)this.activity.findViewById(R.id.signInPopUpStub)).inflate();
      }
      initClickListeners();
      initFonts();
      return true;
    }
    Log.e("logo.quiz.commons.popup.SignInPopUp", "Add view stub (id=popUpStub) to your layout.");
    return false;
  }
  
  private void initClickListeners()
  {
    this.activity.findViewById(R.id.signInPopUpBg).setOnClickListener(this);
    this.activity.findViewById(R.id.sign_in_h1).setOnClickListener(this);
    this.activity.findViewById(R.id.leaderboard_icon).setOnClickListener(this);
    this.activity.findViewById(R.id.leaderboard_h1).setOnClickListener(this);
    this.activity.findViewById(R.id.leaderboard_p).setOnClickListener(this);
    this.activity.findViewById(R.id.cloud_save_icon).setOnClickListener(this);
    this.activity.findViewById(R.id.cloud_save_h1).setOnClickListener(this);
    this.activity.findViewById(R.id.cloud_save_p).setOnClickListener(this);
    this.activity.findViewById(R.id.sign_in_button).setOnClickListener(this);
  }
  
  private void initFonts()
  {
    Typeface localTypeface = FontLoader.get(this.activity.getApplicationContext(), "fonts/Roboto-Bold.ttf");
    if (localTypeface != null)
    {
      ((TextView)this.activity.findViewById(R.id.sign_in_h1)).setTypeface(localTypeface);
      ((TextView)this.activity.findViewById(R.id.leaderboard_h1)).setTypeface(localTypeface);
      ((TextView)this.activity.findViewById(R.id.cloud_save_h1)).setTypeface(localTypeface);
    }
    localTypeface = FontLoader.get(this.activity.getApplicationContext(), "fonts/Roboto-Light.ttf");
    if (localTypeface != null)
    {
      ((TextView)this.activity.findViewById(R.id.leaderboard_p)).setTypeface(localTypeface);
      ((TextView)this.activity.findViewById(R.id.cloud_save_p)).setTypeface(localTypeface);
    }
  }
  
  private void onSignInButtonClicked()
  {
    if (!NetUtils.isOnline(this.activity.getApplicationContext()))
    {
      Toast localToast = Toast.makeText(this.activity.getApplicationContext(), this.activity.getString(R.string.you_have_to_be_online), 1);
      localToast.setGravity(17, 0, 0);
      localToast.show();
      return;
    }
    if (this.mLoadingDialog != null) {
      this.mLoadingDialog.show();
    }
    this.gameHelper.setConnectOnStart(true);
    this.gameHelper.onStart(this.activity);
    this.gameHelper.reconnectClient();
    this.gameHelper.beginUserInitiatedSignIn();
  }
  
  public static Animation popUp(int paramInt1, int paramInt2, Activity paramActivity)
  {
    View localView = paramActivity.findViewById(paramInt1);
    localView.setVisibility(0);
    paramActivity = AnimationUtils.loadAnimation(paramActivity, R.anim.pop_up);
    paramActivity.setStartOffset(paramInt2);
    localView.startAnimation(paramActivity);
    return paramActivity;
  }
  
  public static Animation popUpHide(int paramInt, Activity paramActivity)
  {
    View localView = paramActivity.findViewById(R.id.signInPopUp);
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, R.anim.pop_up_hide);
    if (isPopUpOffAnimEnd)
    {
      isPopUpOffAnimEnd = false;
      Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, R.anim.dark_screen_off);
      paramActivity.findViewById(R.id.signInPopUpBg).startAnimation(localAnimation2);
      localAnimation1.setStartOffset(paramInt);
      localAnimation1.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          this.val$popUpView.setVisibility(8);
          SignInPopUp.isPopUpOffAnimEnd = true;
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      localView.startAnimation(localAnimation1);
    }
    return localAnimation1;
  }
  
  public GameHelper getGameHelper()
  {
    return this.gameHelper;
  }
  
  public SignInPopUp hide()
  {
    if (this.isPopUpShow)
    {
      this.isPopUpShow = false;
      if (init()) {
        popUpHide(100, this.activity);
      }
    }
    return this;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.signInPopUpBg)
    {
      hide();
      return;
    }
    onSignInButtonClicked();
  }
  
  public SignInPopUp show()
  {
    if (!this.isPopUpShow)
    {
      this.isPopUpShow = true;
      if (init()) {
        animateShow();
      }
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/play/services/SignInPopUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */