package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Locale;

public class CapitalizingTextView
  extends TextView
{
  private static final boolean IS_GINGERBREAD;
  private static final int[] R_styleable_TextView;
  private static final int R_styleable_TextView_textAllCaps = 0;
  private static final boolean SANS_ICE_CREAM;
  private boolean mAllCaps;
  
  static
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      bool = true;
      SANS_ICE_CREAM = bool;
      if (Build.VERSION.SDK_INT < 9) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      IS_GINGERBREAD = bool;
      R_styleable_TextView = new int[] { 16843660 };
      return;
      bool = false;
      break;
    }
  }
  
  public CapitalizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CapitalizingTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R_styleable_TextView, paramInt, 0);
    this.mAllCaps = paramContext.getBoolean(0, true);
    paramContext.recycle();
  }
  
  public void setTextCompat(CharSequence paramCharSequence)
  {
    if ((SANS_ICE_CREAM) && (this.mAllCaps) && (paramCharSequence != null))
    {
      if (IS_GINGERBREAD) {
        try
        {
          setText(paramCharSequence.toString().toUpperCase(Locale.ROOT));
          return;
        }
        catch (NoSuchFieldError localNoSuchFieldError)
        {
          setText(paramCharSequence.toString().toUpperCase());
          return;
        }
      }
      setText(paramCharSequence.toString().toUpperCase());
      return;
    }
    setText(paramCharSequence);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/CapitalizingTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */