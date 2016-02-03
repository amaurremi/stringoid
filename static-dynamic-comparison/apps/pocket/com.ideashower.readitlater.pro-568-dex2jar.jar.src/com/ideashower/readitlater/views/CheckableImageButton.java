package com.ideashower.readitlater.views;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class CheckableImageButton
  extends ImageButton
  implements Checkable
{
  public static final int[] a = { 16842912 };
  private boolean b = false;
  private boolean c = false;
  private boolean d;
  private i e;
  
  public CheckableImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public boolean isChecked()
  {
    return this.c;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, a);
    }
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (CheckableImageButton.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setChecked(paramParcelable.a);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    CheckableImageButton.SavedState localSavedState = new CheckableImageButton.SavedState(super.onSaveInstanceState());
    localSavedState.a = isChecked();
    return localSavedState;
  }
  
  public boolean performClick()
  {
    toggle();
    return super.performClick();
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (!this.b) {
      paramBoolean = false;
    }
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      refreshDrawableState();
      if (!this.d) {}
    }
    else
    {
      return;
    }
    this.d = true;
    if (this.e != null) {
      this.e.a(this, this.c);
    }
    this.d = false;
    invalidate();
  }
  
  public void setOnCheckedChangeListener(i parami)
  {
    this.e = parami;
  }
  
  public void toggle()
  {
    if (!this.c) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/CheckableImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */