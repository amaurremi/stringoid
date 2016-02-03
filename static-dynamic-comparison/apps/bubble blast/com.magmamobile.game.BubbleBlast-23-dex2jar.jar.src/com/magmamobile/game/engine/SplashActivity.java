package com.magmamobile.game.engine;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class SplashActivity
  extends Activity
{
  private BitmapDrawable image;
  private ImageView imageview;
  private Class<?> mActivity;
  private int mBackColor;
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
    this(paramClass, paramString, paramLong1, paramLong2, -1);
  }
  
  public SplashActivity(Class<?> paramClass, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this.mActivity = paramClass;
    this.mLogoAsset = paramString;
    this.mStartTime = paramLong1;
    this.mDuration = paramLong2;
    this.mBackColor = paramInt;
  }
  
  public static final int getVersion()
  {
    return 259;
  }
  
  private void handleMessage(Message paramMessage)
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Game.metaiDTGV) {
      getWindow().addFlags(524288);
    }
    this.mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        SplashActivity.this.handleMessage(paramAnonymousMessage);
      }
    };
    this.imageview = new ImageView(this);
    paramBundle = new LinearLayout(this);
    paramBundle.setBackgroundColor(this.mBackColor);
    paramBundle.setGravity(17);
    paramBundle.addView(this.imageview);
    setContentView(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   4: invokevirtual 25	com/magmamobile/game/engine/SplashActivity:getAssets	()Landroid/content/res/AssetManager;
        //   7: aload_0
        //   8: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   11: invokestatic 29	com/magmamobile/game/engine/SplashActivity:access$1	(Lcom/magmamobile/game/engine/SplashActivity;)Ljava/lang/String;
        //   14: invokevirtual 35	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   17: astore_1
        //   18: aload_0
        //   19: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   22: new 37	android/graphics/drawable/BitmapDrawable
        //   25: dup
        //   26: aload_1
        //   27: invokespecial 40	android/graphics/drawable/BitmapDrawable:<init>	(Ljava/io/InputStream;)V
        //   30: invokestatic 44	com/magmamobile/game/engine/SplashActivity:access$2	(Lcom/magmamobile/game/engine/SplashActivity;Landroid/graphics/drawable/BitmapDrawable;)V
        //   33: aload_1
        //   34: invokevirtual 49	java/io/InputStream:close	()V
        //   37: aload_0
        //   38: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   41: invokestatic 53	com/magmamobile/game/engine/SplashActivity:access$3	(Lcom/magmamobile/game/engine/SplashActivity;)J
        //   44: invokestatic 57	java/lang/Thread:sleep	(J)V
        //   47: aload_0
        //   48: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   51: invokestatic 61	com/magmamobile/game/engine/SplashActivity:access$4	(Lcom/magmamobile/game/engine/SplashActivity;)Landroid/os/Handler;
        //   54: iconst_0
        //   55: invokevirtual 67	android/os/Handler:sendEmptyMessage	(I)Z
        //   58: pop
        //   59: aload_0
        //   60: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   63: invokestatic 70	com/magmamobile/game/engine/SplashActivity:access$5	(Lcom/magmamobile/game/engine/SplashActivity;)J
        //   66: invokestatic 57	java/lang/Thread:sleep	(J)V
        //   69: aload_0
        //   70: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   73: invokestatic 74	com/magmamobile/game/engine/SplashActivity:access$6	(Lcom/magmamobile/game/engine/SplashActivity;)Z
        //   76: ifne +38 -> 114
        //   79: aload_0
        //   80: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   83: invokestatic 78	com/magmamobile/game/engine/SplashActivity:access$7	(Lcom/magmamobile/game/engine/SplashActivity;)Ljava/lang/Class;
        //   86: ifnull +28 -> 114
        //   89: aload_0
        //   90: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   93: new 80	android/content/Intent
        //   96: dup
        //   97: aload_0
        //   98: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   101: aload_0
        //   102: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   105: invokestatic 78	com/magmamobile/game/engine/SplashActivity:access$7	(Lcom/magmamobile/game/engine/SplashActivity;)Ljava/lang/Class;
        //   108: invokespecial 83	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   111: invokevirtual 87	com/magmamobile/game/engine/SplashActivity:startActivity	(Landroid/content/Intent;)V
        //   114: aload_0
        //   115: getfield 15	com/magmamobile/game/engine/SplashActivity$2:this$0	Lcom/magmamobile/game/engine/SplashActivity;
        //   118: invokevirtual 90	com/magmamobile/game/engine/SplashActivity:finish	()V
        //   121: return
        //   122: astore_1
        //   123: new 92	java/lang/RuntimeException
        //   126: dup
        //   127: ldc 94
        //   129: aload_1
        //   130: invokespecial 97	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   133: athrow
        //   134: astore_1
        //   135: goto -66 -> 69
        //   138: astore_1
        //   139: goto -92 -> 47
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	142	0	this	2
        //   17	17	1	localInputStream	java.io.InputStream
        //   122	8	1	localException1	Exception
        //   134	1	1	localException2	Exception
        //   138	1	1	localException3	Exception
        // Exception table:
        //   from	to	target	type
        //   0	37	122	java/lang/Exception
        //   59	69	134	java/lang/Exception
        //   37	47	138	java/lang/Exception
      }
    }.start();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mCancel = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/SplashActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */