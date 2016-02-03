package com.admob.android.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

final class g
  extends RelativeLayout
  implements Animation.AnimationListener, b.a, d.b, s
{
  private static float i = -1.0F;
  private static d j = null;
  protected d a;
  final AdView b;
  protected ProgressBar c;
  private Vector<String> d;
  private View e;
  private long f = -1L;
  private boolean g;
  private View h;
  
  public g(d paramd, Context paramContext, AdView paramAdView)
  {
    super(paramContext);
    this.b = paramAdView;
    setId(1);
    i = getResources().getDisplayMetrics().density;
    setBackgroundDrawable(paramContext.getResources().getDrawable(17301602));
    paramd = paramContext.getResources().getDrawable(17301602);
    paramd.setAlpha(128);
    this.e = new View(paramContext);
    this.e.setBackgroundDrawable(paramd);
    this.e.setVisibility(4);
    addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
    a(null);
  }
  
  private static Vector<String> a(int paramInt1, int paramInt2, int paramInt3, long paramLong, Vector<String> paramVector)
  {
    if (paramVector == null) {
      paramVector = new Vector();
    }
    for (;;)
    {
      float f1 = (float)paramLong / 1000.0F;
      if ((paramInt2 != -1) && (paramInt3 != -1)) {}
      for (String str = String.format("{%d,%d,%d,%f}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(f1) });; str = String.format("{%d,%f}", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f1) }))
      {
        paramVector.add(str);
        if (Log.isLoggable("AdMobSDK", 2)) {
          Log.v("AdMobSDK", "recordEvent:" + str);
        }
        return paramVector;
      }
    }
  }
  
  private Vector<String> a(KeyEvent paramKeyEvent, Vector<String> paramVector)
  {
    int k = paramKeyEvent.getAction();
    long l1 = paramKeyEvent.getEventTime();
    long l2 = this.f;
    if ((k == 0) || (k == 1))
    {
      if (k == 1) {}
      for (k = 1;; k = 0) {
        return a(k, -1, -1, l1 - l2, paramVector);
      }
    }
    return paramVector;
  }
  
  private Vector<String> a(MotionEvent paramMotionEvent, boolean paramBoolean, Vector<String> paramVector)
  {
    int k = paramMotionEvent.getAction();
    long l1 = paramMotionEvent.getEventTime();
    long l2 = this.f;
    if ((k == 0) || (k == 1))
    {
      if (k == 1) {}
      for (k = 1;; k = 0) {
        return a(k, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), l1 - l2, paramVector);
      }
    }
    return paramVector;
  }
  
  private static void a(View paramView, JSONObject paramJSONObject)
  {
    Object localObject;
    JSONObject localJSONObject;
    if ((paramView instanceof s))
    {
      localObject = (s)paramView;
      localJSONObject = ((s)localObject).i();
      localObject = ((s)localObject).h();
      if ((localJSONObject == null) || (localObject == null)) {}
    }
    try
    {
      paramJSONObject.put((String)localObject, localJSONObject);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int k = 0;
        while (k < paramView.getChildCount())
        {
          a(paramView.getChildAt(k), paramJSONObject);
          k += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  static float c()
  {
    return i;
  }
  
  private boolean j()
  {
    return (this.a != null) && (SystemClock.uptimeMillis() - this.f > this.a.c());
  }
  
  private void k()
  {
    JSONObject localJSONObject;
    int k;
    if ((this.a != null) && (isPressed()))
    {
      setPressed(false);
      if (!this.g)
      {
        this.g = true;
        localJSONObject = l();
        if (this.h == null) {
          break label196;
        }
        k = 1;
        if (k == 0) {
          break label201;
        }
        AnimationSet localAnimationSet = new AnimationSet(true);
        float f1 = this.h.getWidth() / 2.0F;
        float f2 = this.h.getHeight() / 2.0F;
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, f1, f2);
        localScaleAnimation.setDuration(200L);
        localAnimationSet.addAnimation(localScaleAnimation);
        localScaleAnimation = new ScaleAnimation(1.2F, 0.001F, 1.2F, 0.001F, f1, f2);
        localScaleAnimation.setDuration(299L);
        localScaleAnimation.setStartOffset(200L);
        localScaleAnimation.setAnimationListener(this);
        localAnimationSet.addAnimation(localScaleAnimation);
        postDelayed(new a(localJSONObject, this), 500L);
        this.h.startAnimation(localAnimationSet);
      }
    }
    label196:
    label201:
    do
    {
      return;
      k = 0;
      break;
      this.a.a(localJSONObject);
    } while (this.b == null);
    this.b.performClick();
  }
  
  /* Error */
  private JSONObject l()
  {
    // Byte code:
    //   0: new 213	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 312	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 228	com/admob/android/ads/g:a	(Landroid/view/View;Lorg/json/JSONObject;)V
    //   13: new 213	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 312	org/json/JSONObject:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc_w 314
    //   25: aload_1
    //   26: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_2
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_2
    //   35: ldc -107
    //   37: ldc_w 316
    //   40: aload_1
    //   41: invokestatic 320	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   44: pop
    //   45: aload_2
    //   46: areturn
    //   47: astore_1
    //   48: goto -13 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	g
    //   7	19	1	localJSONObject1	JSONObject
    //   32	9	1	localException1	Exception
    //   47	1	1	localException2	Exception
    //   20	26	2	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	21	32	java/lang/Exception
    //   21	30	47	java/lang/Exception
  }
  
  public final void a()
  {
    post(new c(this));
  }
  
  public final void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if ((paramView != null) && (paramView != this.h))
    {
      this.h = paramView;
      this.c = new ProgressBar(getContext());
      this.c.setIndeterminate(true);
      this.c.setId(2);
      if (paramLayoutParams != null) {
        this.c.setLayoutParams(paramLayoutParams);
      }
      this.c.setVisibility(4);
      post(new b(this));
    }
  }
  
  final void a(d paramd)
  {
    this.a = paramd;
    if (paramd == null)
    {
      setFocusable(false);
      setClickable(false);
      return;
    }
    paramd.a(this);
    setFocusable(true);
    setClickable(true);
  }
  
  protected final d b()
  {
    return this.a;
  }
  
  final void d()
  {
    if (this.a != null)
    {
      this.a.h();
      this.a = null;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (Log.isLoggable("AdMobSDK", 2)) {
      Log.v("AdMobSDK", "dispatchTouchEvent: action=" + k + " x=" + paramMotionEvent.getX() + " y=" + paramMotionEvent.getY());
    }
    if (j())
    {
      if (this.a == null) {
        break label196;
      }
      Rect localRect = this.a.g();
      if (this.a.a(localRect).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break label196;
      }
    }
    label196:
    for (boolean bool = false;; bool = true)
    {
      if (bool) {
        this.d = a(paramMotionEvent, true, this.d);
      }
      if (k == 0) {
        setPressed(bool);
      }
      do
      {
        return true;
        if (k == 2)
        {
          setPressed(bool);
          return true;
        }
        if (k == 1)
        {
          if ((isPressed()) && (bool)) {
            k();
          }
          setPressed(false);
          return true;
        }
      } while (k != 3);
      setPressed(false);
      return true;
    }
  }
  
  public final boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (Log.isLoggable("AdMobSDK", 2)) {
      Log.v("AdMobSDK", "dispatchTrackballEvent: action=" + paramMotionEvent.getAction());
    }
    if (j())
    {
      this.d = a(paramMotionEvent, true, this.d);
      if (paramMotionEvent.getAction() != 0) {
        break label77;
      }
      setPressed(true);
    }
    for (;;)
    {
      return super.onTrackballEvent(paramMotionEvent);
      label77:
      if (paramMotionEvent.getAction() == 1)
      {
        if (hasFocus()) {
          k();
        }
        setPressed(false);
      }
    }
  }
  
  protected final void e()
  {
    this.g = false;
    if (this.c != null) {
      this.c.setVisibility(4);
    }
    if (this.h != null) {
      this.h.setVisibility(0);
    }
  }
  
  public final void f()
  {
    Vector localVector = new Vector();
    int k = 0;
    while (k < getChildCount())
    {
      localVector.add(getChildAt(k));
      k += 1;
    }
    if (j == null) {
      j = new d();
    }
    Collections.sort(localVector, j);
    k = localVector.size() - 1;
    while (k >= 0)
    {
      if (indexOfChild((View)localVector.elementAt(k)) != k) {
        bringChildToFront((View)localVector.elementAt(k));
      }
      k -= 1;
    }
    this.e.bringToFront();
  }
  
  public final long g()
  {
    long l2 = SystemClock.uptimeMillis() - this.f;
    long l1;
    if ((this.f >= 0L) && (l2 >= 0L))
    {
      l1 = l2;
      if (l2 <= 10000000L) {}
    }
    else
    {
      l1 = 0L;
    }
    return l1;
  }
  
  public final String h()
  {
    return "container";
  }
  
  public final JSONObject i()
  {
    JSONObject localJSONObject = null;
    if (this.d != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("touches", new JSONArray(this.d));
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public final void onAnimationEnd(Animation paramAnimation) {}
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
  
  protected final void onDraw(Canvas paramCanvas)
  {
    if ((isPressed()) || (isFocused())) {
      paramCanvas.clipRect(3, 3, getWidth() - 3, getHeight() - 3);
    }
    super.onDraw(paramCanvas);
    if (this.f == -1L)
    {
      this.f = SystemClock.uptimeMillis();
      if (this.a != null) {
        this.a.i();
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (Log.isLoggable("AdMobSDK", 2)) {
      Log.v("AdMobSDK", "onKeyDown: keyCode=" + paramInt);
    }
    if ((paramInt == 66) || (paramInt == 23))
    {
      this.d = a(paramKeyEvent, this.d);
      setPressed(true);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (Log.isLoggable("AdMobSDK", 2)) {
      Log.v("AdMobSDK", "onKeyUp: keyCode=" + paramInt);
    }
    if ((j()) && ((paramInt == 66) || (paramInt == 23)))
    {
      this.d = a(paramKeyEvent, this.d);
      k();
    }
    setPressed(false);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setPressed(boolean paramBoolean)
  {
    if ((this.g) && (paramBoolean)) {}
    while (isPressed() == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      if (this.e != null) {
        this.e.bringToFront();
      }
      this.e.setVisibility(0);
    }
    for (;;)
    {
      super.setPressed(paramBoolean);
      invalidate();
      return;
      this.e.setVisibility(4);
    }
  }
  
  protected static final class a
    extends Thread
  {
    private JSONObject a;
    private WeakReference<g> b;
    
    public a(JSONObject paramJSONObject, g paramg)
    {
      this.a = paramJSONObject;
      this.b = new WeakReference(paramg);
    }
    
    public final void run()
    {
      try
      {
        g localg = (g)this.b.get();
        if ((localg != null) && (localg.a != null))
        {
          localg.a.a(this.a);
          if (localg.b != null) {
            localg.b.performClick();
          }
        }
        return;
      }
      catch (Exception localException)
      {
        while (!Log.isLoggable("AdMobSDK", 6)) {}
        Log.e("AdMobSDK", "exception caught in AdClickThread.run(), " + localException.getMessage());
      }
    }
  }
  
  private static final class b
    implements Runnable
  {
    private WeakReference<g> a;
    
    public b(g paramg)
    {
      this.a = new WeakReference(paramg);
    }
    
    public final void run()
    {
      try
      {
        g localg = (g)this.a.get();
        if (localg != null) {
          localg.addView(localg.c);
        }
        return;
      }
      catch (Exception localException)
      {
        while (!Log.isLoggable("AdMobSDK", 6)) {}
        Log.e("AdMobSDK", "exception caught in AdContainer post run(), " + localException.getMessage());
      }
    }
  }
  
  private static final class c
    implements Runnable
  {
    private WeakReference<g> a;
    
    public c(g paramg)
    {
      this.a = new WeakReference(paramg);
    }
    
    public final void run()
    {
      try
      {
        g localg = (g)this.a.get();
        if (localg != null) {
          localg.e();
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  static final class d
    implements Comparator<View>
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */