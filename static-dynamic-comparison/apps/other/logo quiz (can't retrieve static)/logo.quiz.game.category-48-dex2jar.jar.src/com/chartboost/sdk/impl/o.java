package com.chartboost.sdk.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;
import com.chartboost.sdk.Model.a;

public final class o
{
  public static void a(View paramView)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(510L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void a(b paramb, a parama, a parama1)
  {
    b(paramb, parama, parama1, true);
  }
  
  public static void b(View paramView)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(510L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void b(b paramb, a parama, a parama1)
  {
    c(paramb, parama, parama1, false);
  }
  
  private static void b(final b paramb, final a parama, final a parama1, final boolean paramBoolean)
  {
    if (paramb == b.f) {
      if (parama1 != null) {
        parama1.a(parama);
      }
    }
    View localView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      if ((parama == null) || (parama.h == null))
      {
        CBLogging.a("CBAnimationManager", "Transition of impression canceled due to lack of container");
        return;
      }
      localView = parama.h.f();
      if (localView == null)
      {
        CBLogging.a("CBAnimationManager", "Transition of impression canceled due to lack of view");
        return;
      }
      localViewTreeObserver = localView.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        o.a(paramb, parama, parama1, paramBoolean);
      }
    });
  }
  
  private static void c(b paramb, final a parama, a parama1, boolean paramBoolean)
  {
    Object localObject = CBPreferences.getInstance();
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 1.0F));
    if ((parama == null) || (parama.h == null))
    {
      CBLogging.a("CBAnimationManager", "Transition of impression canceled due to lack of container");
      return;
    }
    View localView = parama.h.f();
    if (localView == null)
    {
      CBLogging.a("CBAnimationManager", "Transition of impression canceled due to lack of view");
      return;
    }
    float f1 = localView.getWidth();
    float f2 = localView.getHeight();
    float f3 = (1.0F - 0.4F) / 2.0F;
    CBOrientation.Difference localDifference = ((CBPreferences)localObject).getForcedOrientationDifference();
    switch (3.b[paramb.ordinal()])
    {
    }
    for (;;)
    {
      if (paramb != b.f) {
        break label2113;
      }
      if (parama1 == null) {
        break;
      }
      parama1.a(parama);
      return;
      switch (3.a[localDifference.ordinal()])
      {
      default: 
        if (paramBoolean)
        {
          localObject = new q(-60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, false);
          label226:
          ((Animation)localObject).setDuration(600L);
          ((Animation)localObject).setFillAfter(true);
          localAnimationSet.addAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label557;
          }
          localObject = new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F);
          label266:
          ((Animation)localObject).setDuration(600L);
          ((Animation)localObject).setFillAfter(true);
          localAnimationSet.addAnimation((Animation)localObject);
          switch (3.a[localDifference.ordinal()])
          {
          default: 
            if (paramBoolean) {
              localObject = new TranslateAnimation(f1 * f3, 0.0F, -f2 * 0.4F, 0.0F);
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        ((Animation)localObject).setDuration(600L);
        ((Animation)localObject).setFillAfter(true);
        localAnimationSet.addAnimation((Animation)localObject);
        break;
        if (paramBoolean)
        {
          localObject = new q(-60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, true);
          break label226;
        }
        localObject = new q(0.0F, 60.0F, f1 / 2.0F, f2 / 2.0F, true);
        break label226;
        if (paramBoolean)
        {
          localObject = new q(60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, false);
          break label226;
        }
        localObject = new q(0.0F, -60.0F, f1 / 2.0F, f2 / 2.0F, false);
        break label226;
        if (paramBoolean)
        {
          localObject = new q(60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, true);
          break label226;
        }
        localObject = new q(0.0F, -60.0F, f1 / 2.0F, f2 / 2.0F, true);
        break label226;
        localObject = new q(0.0F, 60.0F, f1 / 2.0F, f2 / 2.0F, false);
        break label226;
        label557:
        localObject = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
        break label266;
        if (paramBoolean)
        {
          localObject = new TranslateAnimation(f1, 0.0F, f2 * f3, 0.0F);
        }
        else
        {
          localObject = new TranslateAnimation(0.0F, -f1 * 0.4F, 0.0F, f2 * f3);
          continue;
          if (paramBoolean)
          {
            localObject = new TranslateAnimation(f1 * f3, 0.0F, f2, 0.0F);
          }
          else
          {
            localObject = new TranslateAnimation(0.0F, f1 * f3, 0.0F, -f2 * 0.4F);
            continue;
            if (paramBoolean)
            {
              localObject = new TranslateAnimation(-f1 * 0.4F, 0.0F, f2 * f3, 0.0F);
            }
            else
            {
              localObject = new TranslateAnimation(0.0F, f1, 0.0F, f2 * f3);
              continue;
              localObject = new TranslateAnimation(0.0F, f1 * f3, 0.0F, f2);
            }
          }
        }
      }
      switch (3.a[localDifference.ordinal()])
      {
      default: 
        if (paramBoolean)
        {
          localObject = new q(-60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, true);
          label806:
          ((Animation)localObject).setDuration(600L);
          ((Animation)localObject).setFillAfter(true);
          localAnimationSet.addAnimation((Animation)localObject);
          if (!paramBoolean) {
            break label1137;
          }
          localObject = new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F);
          label846:
          ((Animation)localObject).setDuration(600L);
          ((Animation)localObject).setFillAfter(true);
          localAnimationSet.addAnimation((Animation)localObject);
          switch (3.a[localDifference.ordinal()])
          {
          default: 
            if (paramBoolean) {
              localObject = new TranslateAnimation(-f1 * 0.4F, 0.0F, f2 * f3, 0.0F);
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        ((Animation)localObject).setDuration(600L);
        ((Animation)localObject).setFillAfter(true);
        localAnimationSet.addAnimation((Animation)localObject);
        break;
        if (paramBoolean)
        {
          localObject = new q(60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, false);
          break label806;
        }
        localObject = new q(0.0F, -60.0F, f1 / 2.0F, f2 / 2.0F, false);
        break label806;
        if (paramBoolean)
        {
          localObject = new q(60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, true);
          break label806;
        }
        localObject = new q(0.0F, -60.0F, f1 / 2.0F, f2 / 2.0F, true);
        break label806;
        if (paramBoolean)
        {
          localObject = new q(-60.0F, 0.0F, f1 / 2.0F, f2 / 2.0F, false);
          break label806;
        }
        localObject = new q(0.0F, 60.0F, f1 / 2.0F, f2 / 2.0F, false);
        break label806;
        localObject = new q(0.0F, 60.0F, f1 / 2.0F, f2 / 2.0F, true);
        break label806;
        label1137:
        localObject = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
        break label846;
        if (paramBoolean)
        {
          localObject = new TranslateAnimation(f1 * f3, 0.0F, -f2 * 0.4F, 0.0F);
        }
        else
        {
          localObject = new TranslateAnimation(0.0F, f1 * f3, 0.0F, f2);
          continue;
          if (paramBoolean)
          {
            localObject = new TranslateAnimation(f1, 0.0F, f2 * f3, 0.0F);
          }
          else
          {
            localObject = new TranslateAnimation(0.0F, -f1 * 0.4F, 0.0F, f2 * f3);
            continue;
            if (paramBoolean)
            {
              localObject = new TranslateAnimation(f1 * f3, 0.0F, f2, 0.0F);
            }
            else
            {
              localObject = new TranslateAnimation(0.0F, f1 * f3, 0.0F, -f2 * 0.4F);
              continue;
              localObject = new TranslateAnimation(0.0F, f1, 0.0F, f2 * f3);
            }
          }
        }
      }
      float f4;
      label1425:
      float f5;
      switch (3.a[localDifference.ordinal()])
      {
      default: 
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        f4 = 0.0F;
        localObject = new TranslateAnimation(f4, f3, f2, f1);
        ((Animation)localObject).setDuration(600L);
        ((Animation)localObject).setFillAfter(true);
        localAnimationSet.addAnimation((Animation)localObject);
        break;
      case 4: 
        if (paramBoolean)
        {
          f3 = f2;
          if (!paramBoolean) {
            break label1455;
          }
        }
        for (f1 = 0.0F;; f1 = f2)
        {
          f5 = 0.0F;
          f4 = 0.0F;
          f2 = f3;
          f3 = f5;
          break;
          f3 = 0.0F;
          break label1425;
        }
      case 1: 
        if (paramBoolean)
        {
          f4 = -f1;
          if (!paramBoolean) {
            break label1497;
          }
        }
        for (f1 = 0.0F;; f1 = -f1)
        {
          f2 = 0.0F;
          f3 = f1;
          f1 = 0.0F;
          break;
          f4 = 0.0F;
          break label1471;
        }
      case 2: 
        if (paramBoolean)
        {
          f3 = -f2;
          if (!paramBoolean) {
            break label1544;
          }
        }
        for (f1 = 0.0F;; f1 = -f2)
        {
          f5 = 0.0F;
          f4 = 0.0F;
          f2 = f3;
          f3 = f5;
          break;
          f3 = 0.0F;
          break label1514;
        }
      case 3: 
        label1455:
        label1471:
        label1497:
        label1514:
        label1544:
        if (paramBoolean)
        {
          f4 = f1;
          label1560:
          if (!paramBoolean) {
            break label1586;
          }
          f1 = 0.0F;
        }
        label1586:
        for (;;)
        {
          f2 = 0.0F;
          f3 = f1;
          f1 = 0.0F;
          break;
          f4 = 0.0F;
          break label1560;
        }
        switch (3.a[localDifference.ordinal()])
        {
        default: 
          f1 = 0.0F;
          f4 = 0.0F;
          f2 = 0.0F;
          f3 = 0.0F;
          localObject = new TranslateAnimation(f3, f4, f2, f1);
          ((Animation)localObject).setDuration(600L);
          ((Animation)localObject).setFillAfter(true);
          localAnimationSet.addAnimation((Animation)localObject);
          break;
        case 4: 
          if (paramBoolean)
          {
            f3 = -f2;
            if (!paramBoolean) {
              break label1720;
            }
          }
          for (f1 = 0.0F;; f1 = -f2)
          {
            f4 = 0.0F;
            f5 = 0.0F;
            f2 = f3;
            f3 = f5;
            break;
            f3 = 0.0F;
            break label1690;
          }
        case 1: 
          if (paramBoolean) {}
          for (f2 = f1;; f2 = 0.0F)
          {
            f4 = f1;
            if (paramBoolean) {
              f4 = 0.0F;
            }
            f5 = 0.0F;
            f3 = f2;
            f1 = 0.0F;
            f2 = f5;
            break;
          }
        case 2: 
          if (paramBoolean) {}
          for (f1 = f2;; f1 = 0.0F)
          {
            if (paramBoolean) {
              f2 = 0.0F;
            }
            f3 = f1;
            f4 = 0.0F;
            f5 = 0.0F;
            f1 = f2;
            f2 = f3;
            f3 = f5;
            break;
          }
        case 3: 
          label1690:
          label1720:
          if (paramBoolean)
          {
            f2 = -f1;
            label1825:
            if (!paramBoolean) {
              break label1859;
            }
          }
          label1859:
          for (f1 = 0.0F;; f1 = -f1)
          {
            f4 = f1;
            f1 = 0.0F;
            f5 = 0.0F;
            f3 = f2;
            f2 = f5;
            break;
            f2 = 0.0F;
            break label1825;
          }
          if (paramBoolean)
          {
            localObject = new ScaleAnimation(0.6F, 1.1F, 0.6F, 1.1F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject).setDuration(Math.round((float)600L * 0.6F));
            ((Animation)localObject).setStartOffset(0L);
            ((Animation)localObject).setFillAfter(true);
            localAnimationSet.addAnimation((Animation)localObject);
            localObject = new ScaleAnimation(1.0F, 0.81818175F, 1.0F, 0.81818175F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject).setDuration(Math.round((float)600L * 0.19999999F));
            ((Animation)localObject).setStartOffset(Math.round((float)600L * 0.6F));
            ((Animation)localObject).setFillAfter(true);
            localAnimationSet.addAnimation((Animation)localObject);
            localObject = new ScaleAnimation(1.0F, 1.1111112F, 1.0F, 1.1111112F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject).setDuration(Math.round((float)600L * 0.099999964F));
            ((Animation)localObject).setStartOffset(Math.round((float)600L * 0.8F));
            ((Animation)localObject).setFillAfter(true);
            localAnimationSet.addAnimation((Animation)localObject);
          }
          else
          {
            localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
            ((Animation)localObject).setDuration(600L);
            ((Animation)localObject).setStartOffset(0L);
            ((Animation)localObject).setFillAfter(true);
            localAnimationSet.addAnimation((Animation)localObject);
          }
          break;
        }
        break;
      }
    }
    label2113:
    if (parama1 != null) {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          this.a.a(parama);
        }
      }, 600L);
    }
    localView.startAnimation(localAnimationSet);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
  }
  
  public static enum b
  {
    private b() {}
    
    public static b a(int paramInt)
    {
      if (paramInt == 0) {}
      while ((paramInt <= 0) || (paramInt > values().length)) {
        return null;
      }
      return values()[(paramInt - 1)];
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */