package com.jumptap.adtag.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.actions.ActionFactory;
import com.jumptap.adtag.actions.AdAction;
import com.jumptap.adtag.listeners.JtAdViewInnerListener;
import com.jumptap.adtag.media.JTMediaPlayer;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class JTVideoActivity
  extends Activity
  implements JtAdViewInnerListener, MediaPlayer.OnCompletionListener
{
  private static final int LEARN_MORE_BTN_ID = 77777777;
  private static final int SKIP_BTN_ID = 8888888;
  private Button learnMoreBtn;
  private RelativeLayout.LayoutParams learnMoreBtnRlp;
  private Button skipBtn;
  private RelativeLayout.LayoutParams skipBtnRlp;
  private VideoView videoView;
  
  private void closeActivity()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        JTMediaPlayer.getInstance().release();
        JTVideo.prepare(JtAdWidgetSettingsFactory.createWidgetSettings(), JTVideoActivity.this, true);
        JTVideoActivity.this.finish();
      }
    });
  }
  
  private void configLearnMoreBtnOnClickListener()
  {
    final String str = JTVideo.getClickThroughUrl();
    if ((str != null) && (!str.equals("")))
    {
      this.learnMoreBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          new Thread(new Runnable()
          {
            public void run()
            {
              Object localObject = JTVideoActivity.this.getWidgetSettings();
              localObject = ActionFactory.createAction(JTVideoActivity.1.this.val$clickThroughUrl, ((JtAdWidgetSettings)localObject).getUserAgent(null));
              ((AdAction)localObject).setRedirectedUrl(JTVideoActivity.1.this.val$clickThroughUrl);
              ((AdAction)localObject).perform(JTVideoActivity.this, null);
              JTVideoActivity.this.closeActivity();
            }
          }).start();
        }
      });
      return;
    }
    this.learnMoreBtn.setVisibility(8);
  }
  
  private void initJtMediaPlayer()
  {
    JTMediaPlayer localJTMediaPlayer = JTMediaPlayer.getInstance();
    localJTMediaPlayer.setOnCompletionListener(this);
    localJTMediaPlayer.setVideoView(this.videoView);
  }
  
  private void initUI()
  {
    int i = getWindowManager().getDefaultDisplay().getWidth();
    RelativeLayout localRelativeLayout = new RelativeLayout(this);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setLearnMoreButton();
    this.learnMoreBtnRlp = new RelativeLayout.LayoutParams(i / 2, 35);
    this.learnMoreBtnRlp.addRule(6);
    localRelativeLayout.addView(this.learnMoreBtn, this.learnMoreBtnRlp);
    setSkipButton();
    this.skipBtnRlp = new RelativeLayout.LayoutParams(i / 2, 35);
    this.skipBtnRlp.addRule(6);
    this.skipBtnRlp.addRule(1, 77777777);
    localRelativeLayout.addView(this.skipBtn, this.skipBtnRlp);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(3, 8888888);
    this.videoView = new VideoView(this);
    localRelativeLayout.addView(this.videoView, localLayoutParams);
    setContentView(localRelativeLayout);
  }
  
  private void sendTrackingLink()
  {
    Object localObject = JTVideo.getTrackingUrl();
    if (localObject != null)
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int i;
        label54:
        int j;
        if (str != null)
        {
          i = 1;
          if (str.equals("")) {
            break label125;
          }
          j = 1;
          if ((i & j) == 0) {
            continue;
          }
        }
        try
        {
          localObject = new HttpGet(str);
          try
          {
            localDefaultHttpClient.execute((HttpUriRequest)localObject);
            Log.i("JtAd", "Sending video tracking url succeeded   url=" + str);
          }
          catch (IOException localIOException2)
          {
            for (;;) {}
          }
          catch (ClientProtocolException localClientProtocolException2)
          {
            for (;;) {}
          }
          i = 0;
          break label54;
          label125:
          j = 0;
        }
        catch (ClientProtocolException localClientProtocolException1)
        {
          Log.e("JtAd", "fail to send video tracking url  url=" + str, localClientProtocolException1);
          continue;
        }
        catch (IOException localIOException1) {}
        Log.e("JtAd", "fail to send video tracking url  url=" + str, localIOException1);
      }
    }
  }
  
  private void setLearnMoreButton()
  {
    this.learnMoreBtn = new Button(this);
    this.learnMoreBtn.setId(77777777);
    this.learnMoreBtn.setClickable(true);
    this.learnMoreBtn.setText("Learn more");
  }
  
  private void setSkipButton()
  {
    this.skipBtn = new Button(this);
    this.skipBtn.setId(8888888);
    this.skipBtn.setClickable(true);
    this.skipBtn.setText("Skip");
    this.skipBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            JTVideoActivity.this.closeActivity();
          }
        }).start();
      }
    });
  }
  
  public String getAdRequestId()
  {
    return JTVideo.getAdRequestId();
  }
  
  public JtAdWidgetSettings getWidgetSettings()
  {
    return JtAdWidgetSettingsFactory.createWidgetSettings();
  }
  
  public void handleClicks(String paramString) {}
  
  public void hide() {}
  
  public void onAdError(int paramInt) {}
  
  public void onBeginAdInteraction() {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    closeActivity();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        int i = JTVideoActivity.this.getWindowManager().getDefaultDisplay().getWidth();
        JTVideoActivity.this.skipBtnRlp.width = (i / 2);
        JTVideoActivity.this.skipBtn.setLayoutParams(JTVideoActivity.this.skipBtnRlp);
        JTVideoActivity.this.skipBtn.requestLayout();
        JTVideoActivity.this.learnMoreBtnRlp.width = (i / 2);
        JTVideoActivity.this.learnMoreBtn.setLayoutParams(JTVideoActivity.this.learnMoreBtnRlp);
        JTVideoActivity.this.learnMoreBtn.requestLayout();
      }
    });
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initUI();
    initJtMediaPlayer();
    sendTrackingLink();
    configLearnMoreBtnOnClickListener();
  }
  
  public void onEndAdInteraction() {}
  
  public void onInterstitialDismissed() {}
  
  public void onNewAd() {}
  
  public void onNoAdFound() {}
  
  protected void onPause()
  {
    super.onPause();
    closeActivity();
  }
  
  public boolean post(Runnable paramRunnable)
  {
    return false;
  }
  
  public void resize(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void resizeWithCallback(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2) {}
  
  public void setContent(String paramString1, String paramString2) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/activity/JTVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */