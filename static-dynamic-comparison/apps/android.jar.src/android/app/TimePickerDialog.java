/*    */
package android.app;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.widget.TimePicker;

/*    */
/*    */ public class TimePickerDialog extends AlertDialog implements android.content.DialogInterface.OnClickListener, android.widget.TimePicker.OnTimeChangedListener
/*    */ {
    /*    */
    public TimePickerDialog(Context context, OnTimeSetListener callBack, int hourOfDay, int minute, boolean is24HourView)
/*    */ {
/* 10 */
        super((Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public TimePickerDialog(Context context, int theme, OnTimeSetListener callBack, int hourOfDay, int minute, boolean is24HourView) {
        super((Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onClick(android.content.DialogInterface dialog, int which) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void updateTime(int hourOfDay, int minutOfHour) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public android.os.Bundle onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnTimeSetListener
/*    */ {
        /*    */
        public abstract void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/TimePickerDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */