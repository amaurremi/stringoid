package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.hp;
import com.google.android.gms.plus.internal.g;

public final class PlusOneButton
  extends FrameLayout
{
  public static final int ANNOTATION_BUBBLE = 1;
  public static final int ANNOTATION_INLINE = 2;
  public static final int ANNOTATION_NONE = 0;
  public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
  public static final int SIZE_MEDIUM = 1;
  public static final int SIZE_SMALL = 0;
  public static final int SIZE_STANDARD = 3;
  public static final int SIZE_TALL = 2;
  private View abB;
  private int abC;
  private int abD;
  private PlusOneButton.OnPlusOneClickListener abE;
  private int mSize;
  private String qY;
  
  public PlusOneButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlusOneButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mSize = getSize(paramContext, paramAttributeSet);
    this.abC = getAnnotation(paramContext, paramAttributeSet);
    this.abD = -1;
    C(getContext());
    if (isInEditMode()) {}
  }
  
  private void C(Context paramContext)
  {
    if (this.abB != null) {
      removeView(this.abB);
    }
    this.abB = g.a(paramContext, this.mSize, this.abC, this.qY, this.abD);
    setOnPlusOneClickListener(this.abE);
    addView(this.abB);
  }
  
  protected static int getAnnotation(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    paramContext = hp.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("INLINE".equalsIgnoreCase(paramContext)) {
      i = 2;
    }
    while ("NONE".equalsIgnoreCase(paramContext)) {
      return i;
    }
    return 1;
  }
  
  protected static int getSize(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = hp.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if ("SMALL".equalsIgnoreCase(paramContext)) {
      return 0;
    }
    if ("MEDIUM".equalsIgnoreCase(paramContext)) {
      return 1;
    }
    if ("TALL".equalsIgnoreCase(paramContext)) {
      return 2;
    }
    return 3;
  }
  
  public void initialize(String paramString, int paramInt)
  {
    hm.a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
    this.qY = paramString;
    this.abD = paramInt;
    C(getContext());
  }
  
  public void initialize(String paramString, PlusOneButton.OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.qY = paramString;
    this.abD = 0;
    C(getContext());
    setOnPlusOneClickListener(paramOnPlusOneClickListener);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.abB.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.abB;
    measureChild(localView, paramInt1, paramInt2);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setAnnotation(int paramInt)
  {
    this.abC = paramInt;
    C(getContext());
  }
  
  public void setOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.abE = paramOnPlusOneClickListener;
    this.abB.setOnClickListener(new PlusOneButton.DefaultOnPlusOneClickListener(this, paramOnPlusOneClickListener));
  }
  
  public void setSize(int paramInt)
  {
    this.mSize = paramInt;
    C(getContext());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/PlusOneButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */