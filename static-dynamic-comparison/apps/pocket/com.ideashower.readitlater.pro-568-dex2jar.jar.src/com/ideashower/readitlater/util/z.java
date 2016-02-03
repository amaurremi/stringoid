package com.ideashower.readitlater.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ideashower.readitlater.objects.i;
import com.ideashower.readitlater.views.toolbars.b;
import org.apache.a.c.k;

public class z
{
  public static int a(View paramView, ScrollView paramScrollView, int[] paramArrayOfInt)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[2];
    }
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    paramScrollView.getLocationOnScreen(arrayOfInt);
    return i - arrayOfInt[1] + paramScrollView.getScrollY();
  }
  
  public static Context a(Context paramContext)
  {
    if (a.e()) {
      return paramContext;
    }
    return new ContextThemeWrapper(paramContext, 16973836);
  }
  
  public static void a(int paramInt, View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
      i += 1;
    }
  }
  
  public static void a(MotionEvent paramMotionEvent, View paramView)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent.setLocation(i.a(paramView.getLeft(), paramView.getRight(), f1), i.a(paramView.getTop(), paramView.getBottom(), f2));
    paramView.dispatchTouchEvent(paramMotionEvent);
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramView, paramFloat1, paramFloat2, paramFloat1, paramFloat2);
  }
  
  public static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramView.setPadding(j.a(paramFloat1), j.a(paramFloat2), j.a(paramFloat3), j.a(paramFloat4));
  }
  
  public static void a(View paramView, int paramInt)
  {
    paramView.setPadding(paramView.getPaddingLeft(), paramInt, paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static void a(View paramView, Rect paramRect)
  {
    paramView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  public static void a(View paramView1, View paramView2)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView1.getParent();
    int i = localViewGroup.indexOfChild(paramView1);
    localViewGroup.removeView(paramView1);
    paramView2.setLayoutParams(paramView1.getLayoutParams());
    localViewGroup.addView(paramView2, i);
  }
  
  public static void a(View paramView, ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null)
    {
      if (localViewGroup == paramViewGroup) {
        return;
      }
      localViewGroup.removeView(paramView);
    }
    paramViewGroup.addView(paramView);
  }
  
  public static void a(final View paramView, boolean paramBoolean, long paramLong)
  {
    float f2 = 1.0F;
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label65;
      }
    }
    for (;;)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(f1, f2);
      localAlphaAnimation.setDuration(paramLong);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (!this.a) {
            paramView.setVisibility(8);
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      paramView.setVisibility(0);
      paramView.startAnimation(localAlphaAnimation);
      return;
      f1 = 1.0F;
      break;
      label65:
      f2 = 0.0F;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, int paramInt)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        if ((localView instanceof b)) {
          ((b)localView).setStyle(paramInt);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        a((ViewGroup)localView, paramInt);
        continue;
        if ((localView instanceof b)) {
          ((b)localView).setStyle(paramInt);
        }
      }
    }
  }
  
  public static void a(ViewGroup paramViewGroup, Rect paramRect)
  {
    paramRect.set(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), paramViewGroup.getPaddingRight(), paramViewGroup.getPaddingBottom());
  }
  
  public static void a(ViewGroup paramViewGroup, View paramView, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      j = paramView.getLeft() + j;
      i = paramView.getTop() + i;
      paramView = (View)paramView.getParent();
      if (paramView == paramViewGroup)
      {
        paramArrayOfInt[0] = j;
        paramArrayOfInt[1] = i;
        return;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    paramPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    paramPopupWindow.setOutsideTouchable(true);
    paramPopupWindow.setFocusable(true);
  }
  
  public static void a(ProgressBar paramProgressBar, float paramFloat)
  {
    paramProgressBar.setProgress((int)(paramProgressBar.getMax() * paramFloat));
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    if (k.c(paramString)) {}
    for (int i = 8;; i = 0)
    {
      paramTextView.setVisibility(i);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      a(i, paramVarArgs);
      return;
    }
  }
  
  public static boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getVisibility() == 0);
  }
  
  public static boolean a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      if (paramBoolean) {}
    }
    do
    {
      return true;
      return false;
      if (paramView.getVisibility() == 0) {
        return paramBoolean;
      }
    } while (!paramBoolean);
    return false;
  }
  
  public static boolean a(boolean paramBoolean, View paramView)
  {
    if (paramBoolean) {
      paramView.requestFocus();
    }
    for (;;)
    {
      return b(paramBoolean, paramView);
      paramView.clearFocus();
    }
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    return org.apache.a.c.a.b(paramArrayOfInt, new int[] { 16842919, 16842912, 16842908, 16842913 });
  }
  
  public static Bitmap b(View paramView)
  {
    Bitmap localBitmap1 = null;
    paramView.setDrawingCacheEnabled(true);
    Bitmap localBitmap2 = paramView.getDrawingCache();
    if (localBitmap2 != null) {
      localBitmap1 = Bitmap.createBitmap(localBitmap2);
    }
    paramView.setDrawingCacheEnabled(false);
    return localBitmap1;
  }
  
  public static View b(View paramView, float paramFloat1, float paramFloat2)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    int j = localViewGroup.getChildCount();
    paramView.getLocationOnScreen(arrayOfInt);
    int k = (int)paramFloat1;
    int m = arrayOfInt[0];
    int n = (int)paramFloat2;
    int i1 = arrayOfInt[1];
    int i = 0;
    while (i < j)
    {
      paramView = localViewGroup.getChildAt(i);
      paramView.getHitRect(localRect);
      if (localRect.contains(k - m, n - i1)) {
        return paramView;
      }
      i += 1;
    }
    return null;
  }
  
  public static void b(int paramInt, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    label10:
    if (i < j) {
      if (paramVarArgs[i] != null) {
        break label28;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label28:
      ViewGroup.LayoutParams localLayoutParams = paramVarArgs[i].getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = paramInt;
        paramVarArgs[i].setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public static void b(View paramView, int paramInt)
  {
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramInt);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    a(paramView, paramBoolean, 444L);
  }
  
  public static boolean b(View paramView1, View paramView2)
  {
    if (paramView2 == paramView1) {
      return true;
    }
    if ((paramView1 instanceof ViewGroup))
    {
      paramView1 = (ViewGroup)paramView1;
      int j = paramView1.getChildCount();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label50;
        }
        if (b(paramView1.getChildAt(i), paramView2)) {
          break;
        }
        i += 1;
      }
    }
    label50:
    return false;
  }
  
  public static boolean b(boolean paramBoolean, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramView.getContext().getSystemService("input_method");
    if (paramBoolean) {
      return localInputMethodManager.showSoftInput(paramView, 1);
    }
    return localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static void c(View paramView, int paramInt)
  {
    paramView.setPadding(paramInt, paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static void c(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    a(paramBoolean, new View[] { paramView });
  }
  
  public static boolean c(View paramView)
  {
    if ((paramView != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
      return true;
    }
    return false;
  }
  
  public static void d(View paramView)
  {
    paramView.refreshDrawableState();
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        d(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  public static void d(View paramView, int paramInt)
  {
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramInt, paramView.getPaddingBottom());
  }
  
  public static void e(View paramView, int paramInt)
  {
    paramView.setPadding(paramInt, paramView.getPaddingTop(), paramInt, paramView.getPaddingBottom());
  }
  
  public static void f(View paramView, int paramInt)
  {
    paramView.setPadding(paramInt, paramInt, paramInt, paramInt);
  }
  
  public static void g(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public static View h(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramInt > 0))
    {
      if ((paramView.getParent() instanceof View)) {}
      for (paramView = (View)paramView.getParent();; paramView = null)
      {
        paramInt -= 1;
        break;
      }
    }
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */