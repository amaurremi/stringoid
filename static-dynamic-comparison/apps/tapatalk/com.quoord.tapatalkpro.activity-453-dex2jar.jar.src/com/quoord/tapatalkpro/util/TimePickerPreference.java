package com.quoord.tapatalkpro.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TimePicker;

public class TimePickerPreference
        extends DialogPreference {
    private int lastHour = 0;
    private int lastMinute = 0;
    private TimePicker picker = null;

    public TimePickerPreference(Context paramContext) {
        this(paramContext, null);
    }

    public TimePickerPreference(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public TimePickerPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setPositiveButtonText("Set");
        setNegativeButtonText("Cancel");
    }

    public static int getHour(String paramString) {
        return Integer.parseInt(paramString.split(":")[0]);
    }

    public static int getMinute(String paramString) {
        return Integer.parseInt(paramString.split(":")[1]);
    }

    protected void onBindDialogView(View paramView) {
        super.onBindDialogView(paramView);
        this.picker.setCurrentHour(Integer.valueOf(this.lastHour));
        this.picker.setCurrentMinute(Integer.valueOf(this.lastMinute));
    }

    protected View onCreateDialogView() {
        this.picker = new TimePicker(getContext());
        return this.picker;
    }

    protected void onDialogClosed(boolean paramBoolean) {
        super.onDialogClosed(paramBoolean);
        if (paramBoolean) {
            this.lastHour = this.picker.getCurrentHour().intValue();
            this.lastMinute = this.picker.getCurrentMinute().intValue();
            String str = String.valueOf(this.lastHour) + ":" + String.valueOf(this.lastMinute);
            if (callChangeListener(str)) {
                persistString(str);
            }
        }
    }

    protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt) {
        return paramTypedArray.getString(paramInt);
    }

    protected void onSetInitialValue(boolean paramBoolean, Object paramObject) {
        if (paramBoolean) {
            if (paramObject == null) {
                paramObject = getPersistedString("00:00");
            }
        }
        for (; ; ) {
            this.lastHour = getHour((String) paramObject);
            this.lastMinute = getMinute((String) paramObject);
            return;
            paramObject = getPersistedString(paramObject.toString());
            continue;
            paramObject = paramObject.toString();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/TimePickerPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */