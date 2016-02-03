package com.appflood;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appflood.c.a;
import com.appflood.c.b;
import com.appflood.c.e;
import com.appflood.c.f;
import com.appflood.e.c;
import com.appflood.e.j;
import com.appflood.mraid.AFBannerWebView;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class AFBannerView
  extends RelativeLayout
  implements b
{
  private a a;
  private int b = 0;
  private int c = 0;
  private View d;
  private int e = 14;
  private int f = 470;
  private int g = 73;
  private Timer h;
  private boolean i = false;
  private boolean j = false;
  private AppFlood.AFBannerShowDelegate k;
  
  public AFBannerView(Context paramContext)
  {
    this(paramContext, 14);
  }
  
  public AFBannerView(Context paramContext, int paramInt)
  {
    super(paramContext);
    init(paramContext);
    setType(paramInt);
  }
  
  public AFBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    setType(14);
  }
  
  /* Error */
  private void close(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/appflood/AFBannerView:j	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 57	com/appflood/AFBannerView:j	Z
    //   19: aload_0
    //   20: getfield 75	com/appflood/AFBannerView:a	Lcom/appflood/c/a;
    //   23: ifnull +15 -> 38
    //   26: aload_0
    //   27: getfield 75	com/appflood/AFBannerView:a	Lcom/appflood/c/a;
    //   30: invokevirtual 114	com/appflood/c/a:d	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 75	com/appflood/AFBannerView:a	Lcom/appflood/c/a;
    //   38: iload_1
    //   39: ifne -28 -> 11
    //   42: aload_0
    //   43: getfield 79	com/appflood/AFBannerView:d	Landroid/view/View;
    //   46: ifnull +23 -> 69
    //   49: aload_0
    //   50: getfield 79	com/appflood/AFBannerView:d	Landroid/view/View;
    //   53: instanceof 116
    //   56: ifeq +13 -> 69
    //   59: aload_0
    //   60: getfield 79	com/appflood/AFBannerView:d	Landroid/view/View;
    //   63: checkcast 116	com/appflood/mraid/AFBannerWebView
    //   66: invokevirtual 119	com/appflood/mraid/AFBannerWebView:destroy	()V
    //   69: aload_0
    //   70: invokevirtual 122	com/appflood/AFBannerView:removeAllViews	()V
    //   73: aload_0
    //   74: iconst_4
    //   75: invokevirtual 125	com/appflood/AFBannerView:setVisibility	(I)V
    //   78: aload_0
    //   79: getfield 101	com/appflood/AFBannerView:h	Ljava/util/Timer;
    //   82: ifnull +15 -> 97
    //   85: aload_0
    //   86: getfield 101	com/appflood/AFBannerView:h	Ljava/util/Timer;
    //   89: invokevirtual 130	java/util/Timer:cancel	()V
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 101	com/appflood/AFBannerView:h	Ljava/util/Timer;
    //   97: aload_0
    //   98: invokevirtual 134	com/appflood/AFBannerView:getParent	()Landroid/view/ViewParent;
    //   101: ifnull +14 -> 115
    //   104: aload_0
    //   105: invokevirtual 134	com/appflood/AFBannerView:getParent	()Landroid/view/ViewParent;
    //   108: checkcast 136	android/view/ViewGroup
    //   111: aload_0
    //   112: invokevirtual 139	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   115: invokestatic 144	com/appflood/c/e:a	()Lcom/appflood/c/e;
    //   118: iconst_0
    //   119: ldc -110
    //   121: iconst_1
    //   122: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokestatic 157	com/appflood/e/j:a	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: invokevirtual 160	com/appflood/c/e:a	(ZLorg/json/JSONObject;)V
    //   131: goto -120 -> 11
    //   134: astore_3
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_3
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	AFBannerView
    //   0	139	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   134	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	134	finally
    //   14	38	134	finally
    //   42	69	134	finally
    //   69	97	134	finally
    //   97	115	134	finally
    //   115	131	134	finally
  }
  
  private void init(Context paramContext)
  {
    setBackgroundColor(0);
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView) {}
    });
    this.a = new a(paramContext);
    this.a.a(this);
    this.a.a();
  }
  
  private int myResolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    new StringBuilder("ooooooooooooo specMode ").append(n).toString();
    j.a();
    paramInt2 = paramInt1;
    switch (n)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (m < paramInt1)
      {
        paramInt2 = m | 0x1000000;
        continue;
        paramInt2 = m;
      }
    }
  }
  
  private int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (m)
    {
    default: 
      return paramInt1;
    case 0: 
      j.a();
      return paramInt1;
    case -2147483648: 
      new StringBuilder("ooooooooooooo  22222 ").append(paramInt1).append(" specSize ").append(paramInt2).toString();
      j.a();
      return Math.min(paramInt1, paramInt2);
    }
    j.a();
    return paramInt2;
  }
  
  private void setType(int paramInt)
  {
    this.e = paramInt;
    if (this.e == 16)
    {
      this.f = AFListActivity.1.a(getContext(), 527);
      this.g = AFListActivity.1.a(getContext(), 88);
    }
    for (;;)
    {
      this.a.a(paramInt);
      return;
      if (paramInt == 17)
      {
        this.f = AFListActivity.1.a(getContext(), 313);
        this.g = AFListActivity.1.a(getContext(), 49);
      }
    }
  }
  
  private void startFadeIn(View paramView)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    paramView.setAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    localAlphaAnimation.start();
  }
  
  private void startFadeOut(final View paramView)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramView.setAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if ((paramView instanceof AFBannerWebView)) {
          ((AFBannerWebView)paramView).destroy();
        }
        AFBannerView.this.removeAllViews();
        paramAnonymousAnimation = new RelativeLayout.LayoutParams(AFBannerView.this.getWidth(), AFBannerView.this.getHeight());
        AFBannerView.access$202(AFBannerView.this, AFBannerView.this.a.c());
        AFBannerView.this.addView(AFBannerView.this.d, paramAnonymousAnimation);
        AFBannerView.this.startFadeIn(AFBannerView.this.d);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.setSelected(true);
    localAlphaAnimation.start();
  }
  
  public ViewGroup.LayoutParams getOriginalParams()
  {
    return null;
  }
  
  public int getType()
  {
    return this.e;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.h == null) {
      this.h = new Timer();
    }
    this.h.schedule(new TimerTask()
    {
      public final void run()
      {
        new StringBuilder("onAttached to window ").append(AFBannerView.this.getWidth()).append(" height ").append(AFBannerView.this.getHeight()).toString();
        j.a();
        int j;
        int i;
        if (AFBannerView.this.getWidth() > 0)
        {
          AFBannerView.access$502(AFBannerView.this, AFBannerView.this.getWidth());
          AFBannerView.access$602(AFBannerView.this, AFBannerView.this.getHeight());
          int[] arrayOfInt = new int[2];
          AFBannerView.this.getLocationOnScreen(arrayOfInt);
          j = AFListActivity.1.a(AFBannerView.this.getContext());
          i = arrayOfInt[1] - j;
          j = c.h - j - i - AFBannerView.this.getHeight();
          if (i != j) {
            break label199;
          }
          i = 7;
        }
        for (;;)
        {
          if (AFBannerView.this.a != null) {
            AFBannerView.this.a.a(AFBannerView.this.b, AFBannerView.this.c, i);
          }
          if (AFBannerView.this.h != null)
          {
            AFBannerView.this.h.cancel();
            AFBannerView.access$702(AFBannerView.this, null);
          }
          return;
          label199:
          if (i < j) {
            i = 4;
          } else {
            i = 5;
          }
        }
      }
    }, 500L, 500L);
  }
  
  public void onClick() {}
  
  public void onClose()
  {
    close(false);
  }
  
  public void onComplete() {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    j.a();
    close(true);
  }
  
  public void onFinish(final HashMap<String, Object> paramHashMap)
  {
    boolean bool = ((Boolean)paramHashMap.get("result")).booleanValue();
    new StringBuilder("result = ").append(paramHashMap).toString();
    j.a();
    if (bool) {
      f.a(new Runnable()
      {
        public final void run()
        {
          if (AFBannerView.this.getVisibility() != 0)
          {
            localObject = AFBannerView.this.a.c();
            if ((localObject instanceof AFBannerWebView)) {
              ((AFBannerWebView)localObject).destroy();
            }
            return;
          }
          if ((AFBannerView.this.d != null) && (AFBannerView.this.i))
          {
            AFBannerView.this.startFadeOut(AFBannerView.this.d);
            AFBannerView.access$302(AFBannerView.this, false);
            return;
          }
          new StringBuilder(" ww ").append(AFBannerView.this.getWidth()).append(" hh ").append(AFBannerView.this.getHeight()).toString();
          j.a();
          Object localObject = new RelativeLayout.LayoutParams(AFBannerView.this.getWidth(), AFBannerView.this.getHeight());
          int m;
          int n;
          int j;
          int i;
          if ("video".equals(paramHashMap.get("type")))
          {
            m = ((Integer)paramHashMap.get("w")).intValue();
            n = ((Integer)paramHashMap.get("h")).intValue();
            if ((m > 0) && (n > 0))
            {
              if (m <= AFBannerView.this.getWidth()) {
                break label431;
              }
              j = AFBannerView.this.getWidth();
              i = n * j / m;
            }
          }
          for (;;)
          {
            int k = i;
            if (i > AFBannerView.this.getHeight())
            {
              k = AFBannerView.this.getHeight();
              j = k * m / n;
            }
            new StringBuilder(" caculate  ww ").append(j).append(" hh ").append(k).toString();
            j.a();
            ((RelativeLayout.LayoutParams)localObject).width = j;
            ((RelativeLayout.LayoutParams)localObject).height = k;
            ((RelativeLayout.LayoutParams)localObject).addRule(13);
            AFBannerView.access$202(AFBannerView.this, AFBannerView.this.a.c());
            new StringBuilder(" this ").append(this).append(" parent ").append(AFBannerView.this.d.getParent()).append(" webView ").append(AFBannerView.this.d).toString();
            j.a();
            if (AFBannerView.this.d.getParent() == null)
            {
              AFBannerView.this.addView(AFBannerView.this.d, (ViewGroup.LayoutParams)localObject);
              return;
            }
            AFBannerView.this.updateViewLayout(AFBannerView.this.d, (ViewGroup.LayoutParams)localObject);
            return;
            label431:
            i = n;
            j = m;
          }
        }
      });
    }
    for (;;)
    {
      e.a().a(bool, 1);
      return;
      if (paramHashMap.containsKey("video_error")) {
        this.i = true;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    new StringBuilder("onLayout  changed ").append(paramBoolean).append(" l ").append(paramInt1).append(" t ").append(paramInt2).append(" r ").append(paramInt3).append(" b ").append(paramInt4).toString();
    j.a();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      f1 = this.f / this.g;
      n = View.MeasureSpec.getMode(paramInt1);
      m = View.MeasureSpec.getMode(paramInt2);
      new StringBuilder("oooooooooooooooo  wid ").append(n).append(" heightSpecMode ").append(m).toString();
      j.a();
      if (n == 1073741824) {
        break label340;
      }
      i2 = 1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        float f1;
        int i2;
        int i1;
        label224:
        label257:
        label340:
        int m = 0;
        int n = 0;
        continue;
        label474:
        label480:
        label495:
        if (m != 1073741824) {
          i1 = 1;
        }
      }
    }
    new StringBuilder("oooooooooooooooo banner w ").append(this.f).append(" h = ").append(this.g).toString();
    j.a();
    if ((i2 != 0) || (i1 != 0)) {
      m = resolveAdjustedSize(this.f, paramInt1);
    }
    try
    {
      n = resolveAdjustedSize(this.g, paramInt2);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        float f2;
        int i3;
        n = m;
        m = 0;
      }
    }
    try
    {
      new StringBuilder("oooooooooooooooo resize w ").append(m).append(" h = ").append(n).toString();
      j.a();
      f2 = Math.abs(m / n - f1);
      if (f2 <= 1.0E-7D) {
        break label480;
      }
      if (i2 == 0) {
        break label474;
      }
      i3 = (int)(n * f1);
      if (i3 > m) {
        break label474;
      }
      i2 = 1;
      m = i3;
    }
    catch (Throwable localThrowable3)
    {
      i1 = m;
      m = n;
      n = i1;
      break label257;
      break label257;
      i1 = m;
      m = n;
      n = i1;
      break label257;
      i2 = 0;
      break label224;
      i1 = m;
      m = n;
      n = i1;
      break label257;
    }
    if ((i2 == 0) && (i1 != 0))
    {
      i1 = (int)(m / f1);
      if (i1 <= n)
      {
        n = m;
        m = i1;
        for (;;)
        {
          ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
          if (((localLayoutParams.width == -2) || (localLayoutParams.width == -1)) && (localLayoutParams.height == -2))
          {
            new StringBuilder("onmeasure ").append(n).append("  hhh ").append(m).toString();
            j.a();
            super.onMeasure(paramInt1, paramInt1);
            setMeasuredDimension(n, m);
            return;
            i2 = 0;
            break label495;
            i1 = 0;
            break;
            n = Math.max(this.f, getSuggestedMinimumWidth());
            m = Math.max(this.g, getSuggestedMinimumHeight());
            n = myResolveSizeAndState(n, paramInt1, 0);
          }
          try
          {
            m = myResolveSizeAndState(m, paramInt2, 0);
          }
          catch (Throwable localThrowable4)
          {
            m = 0;
          }
        }
        j.a();
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
  }
  
  public void setAutoFresh(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public void setPreload(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setShowDelegate(final AppFlood.AFBannerShowDelegate paramAFBannerShowDelegate)
  {
    this.k = paramAFBannerShowDelegate;
    paramAFBannerShowDelegate = new Timer("banner");
    paramAFBannerShowDelegate.schedule(new TimerTask()
    {
      public final void run()
      {
        new StringBuilder(" run  shown ").append(AFBannerView.this.isShown()).append(" ").append(AFBannerView.this.hasWindowFocus()).append(" isEnable ").append(AFBannerView.this.isEnabled()).append(" ").append(AFBannerView.this.isClickable()).append(AFBannerView.this.isFocused()).append("   ").append(AFBannerView.this.getVisibility()).toString();
        j.a();
        if (AFBannerView.this.hasWindowFocus())
        {
          if (AFBannerView.this.k != null) {
            AFBannerView.this.k.onResume();
          }
          paramAFBannerShowDelegate.cancel();
        }
      }
    }, 500L, 500L);
  }
  
  public void setSize(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/AFBannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */