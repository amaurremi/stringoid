package com.chiralcode.colorpicker;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ColorPickerPreference
  extends DialogPreference
{
  private ColorPicker fl;
  private int fp;
  
  public ColorPickerPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onBindDialogView(View paramView)
  {
    super.onBindDialogView(paramView);
    this.fl.setColor(this.fp);
  }
  
  protected View onCreateDialogView()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    this.fl = new ColorPicker(getContext());
    this.fl.setId(1);
    localRelativeLayout.addView(this.fl, localLayoutParams);
    return localRelativeLayout;
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    if ((paramBoolean) && (shouldPersist()) && (callChangeListener(Integer.valueOf(this.fl.getColor()))))
    {
      this.fp = this.fl.getColor();
      persistInt(this.fp);
    }
  }
  
  protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt)
  {
    return Integer.valueOf(paramTypedArray.getInt(paramInt, -1));
  }
  
  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    super.onPrepareDialogBuilder(paramBuilder);
    paramBuilder.setTitle(null);
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (int i = getPersistedInt(-1);; i = ((Integer)paramObject).intValue())
    {
      this.fp = i;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/chiralcode/colorpicker/ColorPickerPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */