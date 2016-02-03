package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton
  extends Button
{
  private static final boolean IS_GINGERBREAD;
  private static final int[] R_styleable_Button;
  private static final int R_styleable_Button_textAppearance = 0;
  private static final int[] R_styleable_TextAppearance;
  private static final int R_styleable_TextAppearance_textAllCaps = 0;
  private static final boolean SANS_ICE_CREAM;
  private boolean mAllCaps;
  
  static
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      bool = true;
      SANS_ICE_CREAM = bool;
      if (Build.VERSION.SDK_INT < 9) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      IS_GINGERBREAD = bool;
      R_styleable_Button = new int[] { 16842804 };
      R_styleable_TextAppearance = new int[] { 16843660 };
      return;
      bool = false;
      break;
    }
  }
  
  public CapitalizingButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R_styleable_Button);
    int i = paramAttributeSet.getResourceId(0, -1);
    paramAttributeSet.recycle();
    if (i != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(i, R_styleable_TextAppearance);
      if (paramContext != null)
      {
        this.mAllCaps = paramContext.getBoolean(0, true);
        paramContext.recycle();
      }
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/CapitalizingButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */