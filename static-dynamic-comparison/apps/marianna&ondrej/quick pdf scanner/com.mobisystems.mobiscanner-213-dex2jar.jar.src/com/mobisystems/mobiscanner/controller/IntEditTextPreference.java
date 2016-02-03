package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.EditTextPreference;
import android.preference.Preference.BaseSavedState;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

public class IntEditTextPreference
  extends EditTextPreference
{
  private int mValue;
  
  public IntEditTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getValue()
  {
    return this.mValue;
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    getEditText().setText(String.valueOf(this.mValue));
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    Editable localEditable;
    if (paramBoolean) {
      localEditable = getEditText().getText();
    }
    try
    {
      int i = Integer.parseInt(localEditable.toString());
      if (callChangeListener(Integer.valueOf(i)))
      {
        this.mValue = i;
        persistInt(this.mValue);
        notifyChanged();
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
  
  protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt)
  {
    return Integer.valueOf(paramTypedArray.getInt(paramInt, 0));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!paramParcelable.getClass().equals(SavedState.class))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mValue = paramParcelable.value;
    notifyChanged();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Object localObject = super.onSaveInstanceState();
    if (isPersistent()) {
      return (Parcelable)localObject;
    }
    localObject = new SavedState((Parcelable)localObject);
    ((SavedState)localObject).value = this.mValue;
    return (Parcelable)localObject;
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.mValue = getPersistedInt(this.mValue);
      return;
    }
    int i = ((Integer)paramObject).intValue();
    this.mValue = i;
    persistInt(i);
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public IntEditTextPreference.SavedState bL(Parcel paramAnonymousParcel)
      {
        return new IntEditTextPreference.SavedState(paramAnonymousParcel);
      }
      
      public IntEditTextPreference.SavedState[] gh(int paramAnonymousInt)
      {
        return new IntEditTextPreference.SavedState[paramAnonymousInt];
      }
    };
    int value;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.value = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.value);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/IntEditTextPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */