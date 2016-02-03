package com.venticake.retrica.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class UserInterfaceUtil
{
  public static final int currentapiVersion = Build.VERSION.SDK_INT;
  
  public static float densityOfView(View paramView)
  {
    return paramView.getResources().getDisplayMetrics().density;
  }
  
  public static void displayError(Context paramContext, final String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(UserInterfaceUtil.this);
        localBuilder.setTitle(UserInterfaceUtil.this.getResources().getString(2131165287));
        localBuilder.setMessage(paramString);
        localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        localBuilder.show();
      }
    });
  }
  
  public static int dp2px(float paramFloat, View paramView)
  {
    return (int)(densityOfView(paramView) * paramFloat + 0.5F);
  }
  
  public static int dp2px(int paramInt, float paramFloat)
  {
    return (int)(paramInt * paramFloat + 0.5F);
  }
  
  public static String getDPIString(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().densityDpi;
    switch (i)
    {
    default: 
      return "unknown:" + i;
    case 120: 
      return "ldpi";
    case 160: 
      return "mdpi";
    case 240: 
      return "hdpi";
    case 320: 
      return "xhdpi";
    case 480: 
      return "xxhdpi";
    case 400: 
      return "400";
    case 213: 
      return "tv";
    }
    return "xxxhdpi";
  }
  
  public static String getExifString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN: " + paramInt;
    case 1: 
      return "Normal";
    case 3: 
      return "Rotate 180";
    case 8: 
      return "Rotate 270";
    case 6: 
      return "Rotate 90";
    case 4: 
      return "Flip Vertical";
    case 2: 
      return "Flip Horizontal";
    case 5: 
      return "Transpose";
    case 7: 
      return "Transverse";
    }
    return "Undefined";
  }
  
  public static int[] getFitSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = new int[2];
    if (paramInt1 / paramInt2 > paramInt3 / paramInt4)
    {
      arrayOfInt[0] = paramInt3;
      arrayOfInt[1] = ((int)(arrayOfInt[0] * paramInt2 / paramInt1));
      return arrayOfInt;
    }
    arrayOfInt[1] = paramInt4;
    arrayOfInt[0] = ((int)(arrayOfInt[1] * paramInt1 / paramInt2));
    return arrayOfInt;
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    setAlpha(paramView, paramFloat, false);
  }
  
  public static void setAlpha(View paramView, float paramFloat, boolean paramBoolean)
  {
    setAlpha(paramView, paramFloat, paramBoolean, null);
  }
  
  @SuppressLint({"NewApi"})
  public static void setAlpha(View paramView, float paramFloat, boolean paramBoolean, Animation.AnimationListener paramAnimationListener)
  {
    float f = 0.0F;
    AlphaAnimation localAlphaAnimation;
    if (paramBoolean) {
      if (paramFloat > 0.0F)
      {
        localAlphaAnimation = new AlphaAnimation(f, paramFloat);
        localAlphaAnimation.setDuration(100L);
        if (paramAnimationListener != null) {
          localAlphaAnimation.setAnimationListener(paramAnimationListener);
        }
        paramView.startAnimation(localAlphaAnimation);
      }
    }
    for (;;)
    {
      return;
      f = 1.0F;
      break;
      if (currentapiVersion < 11)
      {
        localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        paramView.startAnimation(localAlphaAnimation);
      }
      while (paramAnimationListener != null)
      {
        paramAnimationListener.onAnimationEnd(null);
        return;
        paramView.setAlpha(paramFloat);
      }
    }
  }
  
  @TargetApi(16)
  public static void setBackground(View paramView, Drawable paramDrawable)
  {
    if (currentapiVersion >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void setImageViewAlpha(ImageView paramImageView, int paramInt)
  {
    setImageViewAlpha(paramImageView, paramInt, true);
  }
  
  public static void setImageViewAlpha(ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    AlphaAnimation localAlphaAnimation;
    if (paramInt > 0)
    {
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (paramInt = 500;; paramInt = 0)
    {
      localAlphaAnimation.setDuration(paramInt);
      localAlphaAnimation.setFillAfter(true);
      paramImageView.startAnimation(localAlphaAnimation);
      return;
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      break;
    }
  }
  
  public static void updateTextViewForLensIntensity(TextView paramTextView)
  {
    paramTextView.setTextSize(2, 128.0F);
  }
  
  public static void updateTextViewForLensTitle(TextView paramTextView)
  {
    paramTextView.setTextSize(2, 64.0F);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/UserInterfaceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */