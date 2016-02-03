package com.pocket.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.ideashower.readitlater.b;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.e;
import java.util.List;

public class aj
  extends CompoundButton
{
  public static final int[] a = { 16842912 };
  private Layout A;
  private final Rect B = new Rect();
  private Drawable b;
  private Drawable c;
  private int d;
  private int e;
  private int f;
  private int g;
  private CharSequence h;
  private CharSequence i;
  private int j;
  private final int k;
  private float l;
  private float m;
  private final VelocityTracker n = VelocityTracker.obtain();
  private final int o;
  private float p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private final TextPaint x = new TextPaint(1);
  private ColorStateList y;
  private Layout z;
  
  public aj(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public aj(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.x.density = localResources.getDisplayMetrics().density;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.Switch);
    this.b = paramAttributeSet.getDrawable(0);
    this.c = paramAttributeSet.getDrawable(1);
    this.h = paramAttributeSet.getText(2);
    this.i = paramAttributeSet.getText(3);
    this.d = paramAttributeSet.getDimensionPixelSize(4, 0);
    this.e = paramAttributeSet.getDimensionPixelSize(6, 0);
    this.g = paramAttributeSet.getDimensionPixelSize(7, 0);
    int i1 = paramAttributeSet.getResourceId(5, 0);
    if (i1 != 0) {
      a(paramContext, i1);
    }
    paramAttributeSet.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.k = paramContext.getScaledTouchSlop();
    this.o = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private Layout a(CharSequence paramCharSequence)
  {
    return new StaticLayout(paramCharSequence, this.x, (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, this.x)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void a()
  {
    e.b("This method not supported.");
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private void a(boolean paramBoolean)
  {
    setChecked(paramBoolean);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.b.getPadding(this.B);
    int i1 = this.u;
    int i2 = this.k;
    int i3 = this.t + (int)(this.p + 0.5F) - this.k;
    int i4 = this.s;
    int i5 = this.B.left;
    int i6 = this.B.right;
    int i7 = this.k;
    int i8 = this.w;
    int i9 = this.k;
    return (paramFloat1 > i3) && (paramFloat1 < i4 + i3 + i5 + i6 + i7) && (paramFloat2 > i1 - i2) && (paramFloat2 < i8 + i9);
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(View paramView)
  {
    if (a.n()) {
      return paramView.getLayoutDirection() == 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    this.j = 0;
    int i1;
    float f1;
    if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
    {
      i1 = 1;
      a(paramMotionEvent);
      if (i1 == 0) {
        break label117;
      }
      this.n.computeCurrentVelocity(1000);
      f1 = this.n.getXVelocity();
      if (Math.abs(f1) <= this.o) {
        break label108;
      }
      if (!a(this)) {
        break label96;
      }
      if (f1 >= 0.0F) {
        break label90;
      }
    }
    for (;;)
    {
      a(bool);
      return;
      i1 = 0;
      break;
      label90:
      bool = false;
      continue;
      label96:
      if (f1 <= 0.0F)
      {
        bool = false;
        continue;
        label108:
        bool = getTargetCheckedState();
      }
    }
    label117:
    a(isChecked());
  }
  
  private boolean getTargetCheckedState()
  {
    if (a(this)) {
      if (this.p > getThumbScrollRange() / 2) {}
    }
    while (this.p >= getThumbScrollRange() / 2)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private int getThumbScrollRange()
  {
    if (this.c == null) {
      return 0;
    }
    this.c.getPadding(this.B);
    return this.q - this.s - this.B.left - this.B.right;
  }
  
  private void setThumbPosition(boolean paramBoolean)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (a(this))
    {
      if (paramBoolean) {}
      for (;;)
      {
        this.p = f1;
        return;
        f1 = getThumbScrollRange();
      }
    }
    f1 = f2;
    if (paramBoolean) {
      f1 = getThumbScrollRange();
    }
    this.p = f1;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (this.b != null) {
      this.b.setState(arrayOfInt);
    }
    if (this.c != null) {
      this.c.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getCompoundPaddingLeft()
  {
    int i1;
    if (!a(this)) {
      i1 = super.getCompoundPaddingLeft();
    }
    int i2;
    do
    {
      return i1;
      i2 = super.getCompoundPaddingLeft() + this.q;
      i1 = i2;
    } while (TextUtils.isEmpty(getText()));
    return i2 + this.g;
  }
  
  public int getCompoundPaddingRight()
  {
    int i1;
    if (a(this)) {
      i1 = super.getCompoundPaddingRight();
    }
    int i2;
    do
    {
      return i1;
      i2 = super.getCompoundPaddingRight() + this.q;
      i1 = i2;
    } while (TextUtils.isEmpty(getText()));
    return i2 + this.g;
  }
  
  public int getSwitchMinWidth()
  {
    return this.e;
  }
  
  public int getSwitchPadding()
  {
    return this.g;
  }
  
  public CharSequence getTextOff()
  {
    return this.i;
  }
  
  public CharSequence getTextOn()
  {
    return this.h;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.b;
  }
  
  public int getThumbMinWidth()
  {
    return this.f;
  }
  
  public int getThumbTextPadding()
  {
    return this.d;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.c;
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    this.b.jumpToCurrentState();
    this.c.jumpToCurrentState();
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3 = this.t;
    int i1 = this.u;
    int i6 = this.v;
    int i2 = this.w;
    this.c.setBounds(i3, i1, i6, i2);
    this.c.draw(paramCanvas);
    paramCanvas.save();
    this.c.getPadding(this.B);
    int i5 = i3 + this.B.left;
    i3 = this.B.top;
    int i7 = this.B.right;
    int i4 = this.B.bottom;
    paramCanvas.clipRect(i5, i1, i6 - i7, i2);
    this.b.getPadding(this.B);
    i7 = (int)(this.p + 0.5F);
    i6 = i5 - this.B.left + i7;
    int i8 = this.s;
    i5 = this.B.right + (i5 + i7 + i8);
    this.b.setBounds(i6, i1, i5, i2);
    this.b.draw(paramCanvas);
    if (this.y != null) {
      this.x.setColor(this.y.getColorForState(getDrawableState(), this.y.getDefaultColor()));
    }
    this.x.drawableState = getDrawableState();
    if (getTargetCheckedState()) {}
    for (Layout localLayout = this.z;; localLayout = this.A)
    {
      if (localLayout != null)
      {
        paramCanvas.translate((i6 + i5) / 2 - localLayout.getWidth() / 2, (i3 + i1 + (i2 - i4)) / 2 - localLayout.getHeight() / 2);
        localLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Switch.class.getName());
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
    if (isChecked()) {}
    CharSequence localCharSequence2;
    for (CharSequence localCharSequence1 = this.h;; localCharSequence1 = this.i)
    {
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (!TextUtils.isEmpty(localCharSequence2)) {
          break;
        }
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
    paramAccessibilityNodeInfo.setText(localStringBuilder);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    setThumbPosition(isChecked());
    if (a(this))
    {
      paramInt3 = getPaddingLeft();
      paramInt4 = this.q + paramInt3;
      switch (getGravity() & 0x70)
      {
      default: 
        paramInt2 = getPaddingTop();
        paramInt1 = this.r + paramInt2;
      }
    }
    for (;;)
    {
      this.t = paramInt3;
      this.u = paramInt2;
      this.w = paramInt1;
      this.v = paramInt4;
      return;
      paramInt4 = getWidth() - getPaddingRight();
      paramInt3 = paramInt4 - this.q;
      break;
      paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.r / 2;
      paramInt1 = this.r + paramInt2;
      continue;
      paramInt1 = getHeight() - getPaddingBottom();
      paramInt2 = paramInt1 - this.r;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.z == null) {
      this.z = a(this.h);
    }
    if (this.A == null) {
      this.A = a(this.i);
    }
    this.c.getPadding(this.B);
    int i2 = Math.max(this.z.getWidth(), this.A.getWidth());
    int i3 = Math.max(this.e, i2 * 2 + this.d * 4 + this.B.left + this.B.right);
    int i1 = this.c.getIntrinsicHeight();
    this.s = Math.max(this.f, i2 + this.d * 2);
    this.q = i3;
    this.r = i1;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i1) {
      if (!a.e()) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = getMeasuredWidthAndState();; paramInt1 = getMeasuredWidth())
    {
      setMeasuredDimension(paramInt1, i1);
      return;
    }
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (Layout localLayout = this.z;; localLayout = this.A)
    {
      if ((localLayout != null) && (!TextUtils.isEmpty(localLayout.getText()))) {
        paramAccessibilityEvent.getText().add(localLayout.getText());
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    this.n.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = super.onTouchEvent(paramMotionEvent);
    case 0: 
    case 2: 
      float f1;
      float f2;
      do
      {
        return bool1;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if ((!isEnabled()) || (!a(f1, f2))) {
          break;
        }
        this.j = 1;
        this.l = f1;
        this.m = f2;
        break;
        switch (this.j)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.l) <= this.k) && (Math.abs(f2 - this.m) <= this.k)) {
            break;
          }
          this.j = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.l = f1;
          this.m = f2;
          return true;
        case 2: 
          f1 = paramMotionEvent.getX();
          f2 = Math.max(0.0F, Math.min(f1 - this.l + this.p, getThumbScrollRange()));
          bool1 = bool2;
        }
      } while (f2 == this.p);
      this.p = f2;
      this.l = f1;
      invalidate();
      return true;
    }
    if (this.j == 2)
    {
      b(paramMotionEvent);
      return true;
    }
    this.j = 0;
    this.n.clear();
    if (!isChecked()) {
      bool1 = true;
    }
    setChecked(bool1);
    return true;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    setThumbPosition(isChecked());
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.g = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (this.x.getTypeface() != paramTypeface)
    {
      this.x.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.h = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    requestLayout();
  }
  
  public void setThumbMinWidth(int paramInt)
  {
    this.f = paramInt;
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.d = paramInt;
    requestLayout();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.b) || (paramDrawable == this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */