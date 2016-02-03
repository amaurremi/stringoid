package logo.quiz.commons.popup;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Chartboost;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.InterstitialAd;
import logo.quiz.commons.DeviceUtilCommons;
import logo.quiz.commons.R.drawable;
import logo.quiz.commons.R.id;
import logo.quiz.commons.R.raw;
import logo.quiz.commons.R.string;
import logo.quiz.commons.utils.Animations;

public class PopUp
{
  public static final String LOG_NAME = "logo.quiz.commons.popup.PopUp";
  private Activity activity;
  private String buttonText;
  private ButtonsClickListener buttonsClickListener;
  private Callback callback;
  private int image = R.drawable.level_unlocked_2_hints;
  private boolean isPopUpShow = false;
  private View.OnClickListener onClickGoToListener;
  private String textHeader1 = "";
  private int textHeader1Color = -14901795;
  private String textHeader2 = "";
  private int textHeader2Color = -11093268;
  private String textParagraph2 = "";
  
  public PopUp(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.buttonText = paramActivity.getString(R.string.view_continue).toUpperCase();
  }
  
  public PopUp(ButtonsClickListener paramButtonsClickListener, Activity paramActivity)
  {
    this.buttonsClickListener = paramButtonsClickListener;
    this.activity = paramActivity;
    this.buttonText = paramActivity.getString(R.string.view_continue).toUpperCase();
  }
  
  private void animateShow()
  {
    this.activity.findViewById(R.id.popUp).setVisibility(0);
    Animations.popUp(R.id.popUpContainer, 100, this.activity);
    Animations.darkScreen(R.id.popUpBg, 0, this.activity);
  }
  
  private boolean init()
  {
    if ((this.activity.findViewById(R.id.popUpStub) != null) || (this.activity.findViewById(R.id.popUp) != null))
    {
      if (this.activity.findViewById(R.id.popUp) == null)
      {
        ((ViewStub)this.activity.findViewById(R.id.popUpStub)).inflate();
        Typeface localTypeface = Typeface.createFromAsset(this.activity.getAssets(), "fonts/arial_black.ttf");
        ((Button)this.activity.findViewById(R.id.popUpBottomButton)).setTypeface(localTypeface);
      }
      initClickListeners();
      return true;
    }
    Log.e("logo.quiz.commons.popup.PopUp", "Add view stub (id=popUpStub) to your layout.");
    return false;
  }
  
  private void initClickListeners()
  {
    this.activity.findViewById(R.id.popUpContainer).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PopUp.this.hide();
      }
    });
    this.activity.findViewById(R.id.popUpBg).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PopUp.this.hide();
      }
    });
    this.activity.findViewById(R.id.popUpBottomButton).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (PopUp.this.buttonsClickListener != null)
        {
          PopUp.this.buttonsClickListener.onBottomButtonClick();
          return;
        }
        PopUp.this.hide();
      }
    });
    this.activity.findViewById(R.id.popUpText).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (PopUp.this.buttonsClickListener != null)
        {
          PopUp.this.buttonsClickListener.onBottomButtonClick();
          return;
        }
        PopUp.this.hide();
      }
    });
  }
  
  private void textInit()
  {
    TextView localTextView = (TextView)this.activity.findViewById(R.id.popUpH1);
    localTextView.setText(this.textHeader1);
    localTextView.setTextColor(this.textHeader1Color);
    localTextView = (TextView)this.activity.findViewById(R.id.popUpH2);
    localTextView.setTextColor(this.textHeader2Color);
    localTextView.setText(this.textHeader2);
    ((TextView)this.activity.findViewById(R.id.popUpText)).setText(this.textParagraph2);
    ((ImageView)this.activity.findViewById(R.id.lockPopUpImg)).setImageResource(this.image);
    ((Button)this.activity.findViewById(R.id.popUpBottomButton)).setText(this.buttonText);
  }
  
  public PopUp hide()
  {
    if (this.isPopUpShow)
    {
      this.isPopUpShow = false;
      if (init())
      {
        Animations.popUpHide(100, this.activity);
        if (this.callback != null) {
          this.callback.afterHide();
        }
      }
    }
    return this;
  }
  
  public boolean isPopUpShow()
  {
    return this.isPopUpShow;
  }
  
  public PopUp setButtonText(String paramString)
  {
    this.buttonText = paramString;
    return this;
  }
  
  public PopUp setImage(int paramInt)
  {
    this.image = paramInt;
    return this;
  }
  
  public void setOnClickGoToListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickGoToListener = paramOnClickListener;
  }
  
  public PopUp setTextHeader1(String paramString)
  {
    this.textHeader1 = paramString;
    return this;
  }
  
  public PopUp setTextHeader1Color(int paramInt)
  {
    this.textHeader1Color = paramInt;
    return this;
  }
  
  public PopUp setTextHeader2(String paramString)
  {
    this.textHeader2 = paramString;
    return this;
  }
  
  public PopUp setTextHeader2Color(int paramInt)
  {
    this.textHeader2Color = paramInt;
    return this;
  }
  
  public PopUp setTextParagraph2(String paramString)
  {
    this.textParagraph2 = paramString;
    return this;
  }
  
  public PopUp show()
  {
    return show(null);
  }
  
  public PopUp show(Callback paramCallback)
  {
    ImageButton localImageButton;
    if (!this.isPopUpShow)
    {
      this.isPopUpShow = true;
      this.callback = paramCallback;
      if (init())
      {
        localImageButton = (ImageButton)this.activity.findViewById(R.id.popUpGoToButton);
        if (this.onClickGoToListener == null) {
          break label78;
        }
        localImageButton.setOnClickListener(this.onClickGoToListener);
        localImageButton.setVisibility(0);
      }
    }
    for (;;)
    {
      textInit();
      animateShow();
      if (paramCallback != null) {
        paramCallback.afterShow();
      }
      return this;
      label78:
      localImageButton.setVisibility(8);
    }
  }
  
  public static abstract interface ButtonsClickListener
  {
    public abstract void onBottomButtonClick();
  }
  
  public static abstract interface Callback
  {
    public abstract void afterHide();
    
    public abstract void afterShow();
    
    public static class EarnHintsCallback
      implements PopUp.Callback
    {
      private Activity activity;
      private Chartboost cb;
      private int hintsCount = 0;
      private InterstitialAd interstitial;
      private boolean isAdEnable = false;
      private boolean isInterstitialReadyAfterHide = true;
      private SharedPreferences settings;
      
      public EarnHintsCallback(int paramInt, boolean paramBoolean, Chartboost paramChartboost, Activity paramActivity)
      {
        this.hintsCount = paramInt;
        this.cb = paramChartboost;
        this.activity = paramActivity;
        this.isAdEnable = paramBoolean;
        this.settings = PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext());
      }
      
      public void afterHide()
      {
        if (this.isAdEnable)
        {
          if ((this.cb != null) && (this.cb.hasCachedInterstitial())) {
            this.cb.showInterstitial();
          }
        }
        else {
          return;
        }
        if ((this.interstitial != null) && (this.interstitial.isLoaded()))
        {
          this.interstitial.show();
          return;
        }
        this.isInterstitialReadyAfterHide = false;
      }
      
      public void afterShow()
      {
        final Object localObject = this.settings.edit();
        int i = this.settings.getInt("allHints", 0);
        ((SharedPreferences.Editor)localObject).putInt("allHints", this.hintsCount + i);
        ((SharedPreferences.Editor)localObject).commit();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            if (PreferenceManager.getDefaultSharedPreferences(PopUp.Callback.EarnHintsCallback.this.activity.getApplicationContext()).getBoolean("SOUND", true)) {
              DeviceUtilCommons.playSound(PopUp.Callback.EarnHintsCallback.this.activity.getApplicationContext(), R.raw.unlocklevel);
            }
          }
        }, 200L);
        if (this.isAdEnable)
        {
          if (this.cb != null) {
            this.cb.cacheInterstitial();
          }
          localObject = this.activity.getString(R.string.ADMOB_FULL_SCREEN_AD_AFTER_LEVEL_COMPLETE);
          if ((localObject != null) && (!((String)localObject).equals("")))
          {
            localObject = new Handler()
            {
              public void handleMessage(Message paramAnonymousMessage)
              {
                try
                {
                  PopUp.Callback.EarnHintsCallback.access$202(PopUp.Callback.EarnHintsCallback.this, new InterstitialAd(PopUp.Callback.EarnHintsCallback.this.activity));
                  PopUp.Callback.EarnHintsCallback.this.interstitial.setAdUnitId(localObject);
                  AdRequest localAdRequest = new AdRequest.Builder().build();
                  PopUp.Callback.EarnHintsCallback.this.interstitial.loadAd(localAdRequest);
                  PopUp.Callback.EarnHintsCallback.this.interstitial.setAdListener(new AdListener()
                  {
                    public void onAdLoaded()
                    {
                      if (!PopUp.Callback.EarnHintsCallback.this.isInterstitialReadyAfterHide) {
                        PopUp.Callback.EarnHintsCallback.this.interstitial.show();
                      }
                    }
                  });
                  super.handleMessage(paramAnonymousMessage);
                  return;
                }
                catch (Exception localException)
                {
                  for (;;) {}
                }
              }
            };
            if (localObject != null) {
              ((Handler)localObject).sendEmptyMessageDelayed(0, 200L);
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/popup/PopUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */