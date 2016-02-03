package logo.quiz.commons;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.bluebird.bubble.adserwer.tools.PrizeListener;
import com.bluebird.mobile.tools.CommonPreferencesName;
import com.bluebird.mobile.tools.R.anim;
import com.bluebird.mobile.tools.activities.AbstractActivity;
import com.bluebird.mobile.tools.activities.ActivityAction;
import com.bluebird.mobile.tools.activities.GoogleAnalyticsActivityAction;
import com.bubble.adserwer.AdId;
import com.bubble.adserwer.AdserwerBubble;
import com.bubble.bugsense.BugSense;
import com.bubble.bugsense.BugSenseFactory;
import com.bubble.mobile.language.support.LaguageChanger;
import com.bubble.mobile.language.support.LocaleCodes;
import com.chartboost.sdk.Chartboost;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import logo.quiz.commons.flurry.Flurry;
import logo.quiz.commons.utils.menu.MenuService;
import logo.quiz.commons.utils.menu.MenuServiceFactory;
import logo.quiz.commons.utils.score.ScoreService;
import logo.quiz.commons.utils.score.ScoreServiceFactory;

public abstract class LogoQuizAbstractActivity
  extends AbstractActivity
{
  private AdView adView;
  private int admobShowDelay = 500;
  protected AdserwerBubble adserwer;
  protected BugSense bugSense;
  protected Chartboost cb;
  protected boolean isAdReceived = false;
  protected LaguageChanger laguageChanger;
  
  public void back(View paramView)
  {
    if ((this.cb != null) && (this.cb.onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  public void emptyClick(View paramView) {}
  
  protected abstract ConstantsProvider getConstants();
  
  protected MenuService getMenuService()
  {
    return MenuServiceFactory.getInstance(getScoreUtilProvider());
  }
  
  protected ScoreService getScoreService()
  {
    return ScoreServiceFactory.getInstance(getScoreUtilProvider());
  }
  
  protected abstract ScoreUtilProvider getScoreUtilProvider();
  
  protected boolean isAddmobOn()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle, int paramInt)
  {
    this.laguageChanger = new LaguageChanger(this);
    this.laguageChanger.changeLanguage(this.laguageChanger.getCurrentLaguage().getId(), false);
    this.bugSense = BugSenseFactory.getInstance(getApplicationContext());
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    setContentView(paramInt);
    addActivityActions(new ActivityAction[] { new GoogleAnalyticsActivityAction(this) });
    setVolumeControlStream(3);
    if (getResources().getBoolean(R.bool.isGradientColorOnMenuHeader)) {}
    try
    {
      paramBundle = (TextView)findViewById(R.id.menuInfo);
      Object localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(0.0F, 0.0F, 0.0F, 50.0F, new int[] { -4408132, -7303024 }, new float[] { 0.0F, 1.0F }, (Shader.TileMode)localObject);
      paramBundle.getPaint().setShader((Shader)localObject);
      this.adserwer = new AdserwerBubble(AdId.AD_ID_NULL, CommonPreferencesName.HINTS, this);
      this.adserwer.setPrizeListener(new PrizeListener()
      {
        public void onPrizeCollection(int paramAnonymousInt) {}
      });
      this.adserwer.setAdViewContainer320x50("adContainer");
      try
      {
        if ((findViewById(R.id.adContainer) != null) && (isAddmobOn()))
        {
          paramBundle = new Handler()
          {
            public void handleMessage(Message paramAnonymousMessage)
            {
              try
              {
                ViewGroup localViewGroup = (ViewGroup)LogoQuizAbstractActivity.this.findViewById(R.id.adContainer);
                LogoQuizAbstractActivity.access$002(LogoQuizAbstractActivity.this, AdserwerCommons.getAdmob(jdField_this, LogoQuizAbstractActivity.this.getConstants().getAdmobPubId(), new AdListener()
                {
                  public void onAdLoaded()
                  {
                    LogoQuizAbstractActivity.this.isAdReceived = true;
                    View localView = LogoQuizAbstractActivity.this.findViewById(R.id.todayOfferContainer);
                    if ((localView != null) && (localView.getVisibility() == 0))
                    {
                      localView.setVisibility(8);
                      localView.startAnimation(AnimationUtils.loadAnimation(LogoQuizAbstractActivity.this.getApplicationContext(), R.anim.slide_down));
                    }
                  }
                }));
                localViewGroup.addView(LogoQuizAbstractActivity.this.adView);
                super.handleMessage(paramAnonymousMessage);
                return;
              }
              catch (Exception localException)
              {
                for (;;) {}
              }
            }
          };
          if (paramBundle != null) {
            paramBundle.sendEmptyMessageDelayed(0, this.admobShowDelay);
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;) {}
      }
      getMenuService().refreshScore(this);
      Flurry.onStartSession(getApplicationContext());
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;) {}
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.adView != null) {
      this.adView.destroy();
    }
    if (this.cb != null) {
      this.cb.onDestroy(this);
    }
  }
  
  public void onPause()
  {
    if (this.adView != null) {}
    try
    {
      this.adView.pause();
      super.onPause();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.adView != null) {}
    try
    {
      this.adView.resume();
      AdserwerCommons.checkNewHints(this, this.adserwer);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.cb != null) {
      this.cb.onStart(this);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Flurry.onEndSession(this);
    if (this.cb != null) {
      this.cb.onStop(this);
    }
  }
  
  public void promo(View paramView)
  {
    startActivity(AdserwerCommons.getPromoIntent(getApplicationContext()));
  }
  
  public void setAdmobShowDelay(int paramInt)
  {
    this.admobShowDelay = paramInt;
  }
  
  public void switchScore(View paramView)
  {
    getMenuService().switchScore(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/LogoQuizAbstractActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */