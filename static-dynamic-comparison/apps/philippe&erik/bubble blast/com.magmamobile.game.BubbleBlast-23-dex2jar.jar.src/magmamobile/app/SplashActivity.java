package magmamobile.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.io.InputStream;

public class SplashActivity
  extends Activity
{
  private BitmapDrawable image;
  private ImageView imageview;
  private LinearLayout layout;
  private Class<?> mActivity;
  private boolean mCancel;
  private long mDuration;
  private Handler mHandler;
  private String mLogoAsset;
  private long mStartTime;
  
  public SplashActivity(Class<?> paramClass)
  {
    this(paramClass, "magmamobile.png");
  }
  
  public SplashActivity(Class<?> paramClass, String paramString)
  {
    this(paramClass, paramString, 100L, 3000L);
  }
  
  public SplashActivity(Class<?> paramClass, String paramString, long paramLong1, long paramLong2)
  {
    this.mActivity = paramClass;
    this.mLogoAsset = paramString;
    this.mStartTime = paramLong1;
    this.mDuration = paramLong2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    float f1 = this.image.getIntrinsicWidth() >> 1;
    float f2 = this.image.getIntrinsicHeight() >> 1;
    int i = getWindowManager().getDefaultDisplay().getWidth();
    int j = (int)(i * (f2 / f1));
    paramMessage = new AnimationSet(true);
    Object localObject = new TranslateAnimation(0.0F, 0.0F, -500.0F, 0.0F);
    ((TranslateAnimation)localObject).setDuration(1000L);
    paramMessage.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(10.0F, 1.0F, 10.0F, 1.0F, f1, f2);
    ((ScaleAnimation)localObject).setDuration(1000L);
    paramMessage.addAnimation((Animation)localObject);
    localObject = new RotateAnimation(360.0F, 0.0F, f1, f2);
    ((RotateAnimation)localObject).setDuration(1000L);
    paramMessage.addAnimation((Animation)localObject);
    this.imageview.setBackgroundDrawable(this.image);
    this.imageview.setLayoutParams(new LinearLayout.LayoutParams(i, j));
    this.imageview.startAnimation(paramMessage);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        SplashActivity.this.handleMessage(paramAnonymousMessage);
      }
    };
    this.imageview = new ImageView(this);
    this.layout = new LinearLayout(this);
    this.layout.setBackgroundColor(-1);
    this.layout.setGravity(17);
    this.layout.addView(this.imageview);
    setContentView(this.layout);
  }
  
  protected void onStart()
  {
    super.onStart();
    new Thread()
    {
      public void run()
      {
        try
        {
          InputStream localInputStream = SplashActivity.this.getAssets().open(SplashActivity.this.mLogoAsset);
          SplashActivity.this.image = new BitmapDrawable(localInputStream);
          localInputStream.close();
        }
        catch (Exception localException2)
        {
          try
          {
            Thread.sleep(SplashActivity.this.mStartTime);
            SplashActivity.this.mHandler.sendEmptyMessage(0);
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                Thread.sleep(SplashActivity.this.mDuration);
                if ((!SplashActivity.this.mCancel) && (SplashActivity.this.mActivity != null)) {
                  SplashActivity.this.startActivity(new Intent(SplashActivity.this, SplashActivity.this.mActivity));
                }
                SplashActivity.this.finish();
                return;
                localException1 = localException1;
                localException1.printStackTrace();
              }
              localException2 = localException2;
              localException2.printStackTrace();
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                localException3.printStackTrace();
              }
            }
          }
        }
      }
    }.start();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mCancel = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/magmamobile/app/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */