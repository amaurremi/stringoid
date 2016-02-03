package com.c.a.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.ideashower.readitlater.util.e;
import java.lang.reflect.Method;

public class a
  extends WebView
{
  private static Method c;
  private static Method d;
  private Rect a = new Rect();
  private Matrix b = new Matrix();
  protected View h;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    try
    {
      c = WebView.class.getDeclaredMethod("getVisibleTitleHeight", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      e.d("TitleBarWebView", "Could not retrieve native hidden getVisibleTitleHeight method");
    }
  }
  
  private int getViewHeightWithTitle()
  {
    int j = getHeight();
    int i = j;
    if (isHorizontalScrollBarEnabled())
    {
      i = j;
      if (!overlayHorizontalScrollbar()) {
        i = j - getHorizontalScrollbarHeight();
      }
    }
    return i;
  }
  
  private void setEmbeddedTitleBarJellyBean(View paramView)
  {
    if (this.h == paramView) {
      return;
    }
    if (this.h != null) {
      removeView(this.h);
    }
    Object localObject = paramView;
    if (paramView != null)
    {
      localObject = paramView.getLayoutParams();
      if ((localObject == null) || (((ViewGroup.LayoutParams)localObject).height <= 0)) {
        break label108;
      }
    }
    label108:
    for (int i = ((ViewGroup.LayoutParams)localObject).height;; i = -2)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, i);
      AbsoluteLayout.LayoutParams localLayoutParams1 = new AbsoluteLayout.LayoutParams(-1, -2, 0, 0);
      localObject = new FrameLayout(getContext());
      ((FrameLayout)localObject).addView(paramView, localLayoutParams);
      addView((View)localObject, localLayoutParams1);
      this.h = ((View)localObject);
      return;
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    if (this.h == null) {
      return super.computeVerticalScrollExtent();
    }
    return getViewHeightWithTitle() - getVisibleTitleHeightCompat();
  }
  
  protected int computeVerticalScrollOffset()
  {
    if (this.h == null) {
      return super.computeVerticalScrollOffset();
    }
    return Math.max(getScrollY() - getTitleHeight(), 0);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramCanvas.save();
    if (paramView == this.h)
    {
      this.h.offsetLeftAndRight(getScrollX() - this.h.getLeft());
      if (Build.VERSION.SDK_INT < 16)
      {
        this.b.set(paramCanvas.getMatrix());
        this.b.postTranslate(0.0F, -getScrollY());
        paramCanvas.setMatrix(this.b);
      }
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restore();
    return bool;
  }
  
  public int getTitleHeight()
  {
    if (this.h != null) {
      return this.h.getHeight();
    }
    return 0;
  }
  
  public int getVisibleTitleHeightCompat()
  {
    if ((this.h == null) && (c != null)) {
      try
      {
        int i = ((Integer)c.invoke(this, new Object[0])).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return Math.max(getTitleHeight() - Math.max(0, getScrollY()), 0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    if (this.h != null)
    {
      int i = getScrollY();
      int j = getScrollX();
      this.a.top = i;
      this.a.left = j;
      this.a.right = (this.a.left + getWidth());
      this.a.bottom = (this.a.top + getHeight());
      paramCanvas.clipRect(this.a);
      this.b.set(paramCanvas.getMatrix());
      j = getVisibleTitleHeightCompat();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.b.postTranslate(0.0F, i);
      paramCanvas.setMatrix(this.b);
    }
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  /* Error */
  public void setEmbeddedTitleBarCompat(View paramView)
  {
    // Byte code:
    //   0: invokestatic 225	com/ideashower/readitlater/util/a:l	()Z
    //   3: ifeq +9 -> 12
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 227	com/c/a/a/a/a:setEmbeddedTitleBarJellyBean	(Landroid/view/View;)V
    //   11: return
    //   12: getstatic 229	com/c/a/a/a/a:d	Ljava/lang/reflect/Method;
    //   15: ifnonnull +24 -> 39
    //   18: aload_0
    //   19: invokevirtual 233	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: ldc -21
    //   24: iconst_1
    //   25: anewarray 44	java/lang/Class
    //   28: dup
    //   29: iconst_0
    //   30: ldc 83
    //   32: aastore
    //   33: invokevirtual 238	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   36: putstatic 229	com/c/a/a/a/a:d	Ljava/lang/reflect/Method;
    //   39: getstatic 229	com/c/a/a/a/a:d	Ljava/lang/reflect/Method;
    //   42: aload_0
    //   43: iconst_1
    //   44: anewarray 185	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: aastore
    //   51: invokevirtual 191	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: return
    //   56: astore_1
    //   57: aload_1
    //   58: invokestatic 241	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   61: new 243	java/lang/RuntimeException
    //   64: dup
    //   65: new 245	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   72: ldc -8
    //   74: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 160	android/os/Build$VERSION:SDK_INT	I
    //   80: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 262	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore_1
    //   91: aload_1
    //   92: invokestatic 241	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   95: new 243	java/lang/RuntimeException
    //   98: dup
    //   99: new 245	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 264
    //   109: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 160	android/os/Build$VERSION:SDK_INT	I
    //   115: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 262	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	a
    //   0	125	1	paramView	View
    // Exception table:
    //   from	to	target	type
    //   39	55	56	java/lang/Exception
    //   18	39	90	java/lang/NoSuchMethodException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/c/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */