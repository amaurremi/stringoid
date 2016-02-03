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
import android.widget.Toast;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.CommonPreferences.MeasurementUnits;
import com.mobisystems.mobiscanner.common.OperationStatus;
import java.text.ParseException;

public class PageMeasureEditTextPreference
  extends EditTextPreference
{
  private float mValue;
  
  public PageMeasureEditTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public float HB()
  {
    return this.mValue;
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    paramView = getEditText();
    if (paramView != null)
    {
      CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
      paramView.setText(CommonPreferences.MeasurementUnits.z(CommonPreferences.MeasurementUnits.a(this.mValue, localMeasurementUnits)));
    }
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    Editable localEditable;
    CommonPreferences.MeasurementUnits localMeasurementUnits;
    if (paramBoolean)
    {
      localEditable = getEditText().getText();
      localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
    }
    try
    {
      float f = CommonPreferences.MeasurementUnits.A(CommonPreferences.MeasurementUnits.b(CommonPreferences.MeasurementUnits.df(localEditable.toString()), localMeasurementUnits));
      if (callChangeListener(Float.valueOf(f)))
      {
        this.mValue = f;
        persistFloat(this.mValue);
        notifyChanged();
      }
      return;
    }
    catch (ParseException localParseException)
    {
      Toast.makeText(getContext(), OperationStatus.avY.Ds(), 0).show();
    }
  }
  
  protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt)
  {
    return Float.valueOf(paramTypedArray.getFloat(paramInt, 0.0F));
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
      this.mValue = getPersistedFloat(this.mValue);
      return;
    }
    float f = ((Float)paramObject).floatValue();
    this.mValue = f;
    persistFloat(f);
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public PageMeasureEditTextPreference.SavedState bM(Parcel paramAnonymousParcel)
      {
        return new PageMeasureEditTextPreference.SavedState(paramAnonymousParcel);
      }
      
      public PageMeasureEditTextPreference.SavedState[] gr(int paramAnonymousInt)
      {
        return new PageMeasureEditTextPreference.SavedState[paramAnonymousInt];
      }
    };
    float value;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.value = paramParcel.readFloat();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.value);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/PageMeasureEditTextPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */