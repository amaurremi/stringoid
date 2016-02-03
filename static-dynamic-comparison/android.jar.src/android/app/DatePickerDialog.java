/*    */
package android.app;
/*    */ 
/*    */

import android.content.Context;
/*    */ import android.widget.DatePicker;

/*    */
/*    */ public class DatePickerDialog extends AlertDialog implements android.content.DialogInterface.OnClickListener, android.widget.DatePicker.OnDateChangedListener
/*    */ {
    /*    */
    public DatePickerDialog(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth)
/*    */ {
/* 10 */
        super((Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public DatePickerDialog(Context context, int theme, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        super((Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onClick(android.content.DialogInterface dialog, int which) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void onDateChanged(DatePicker view, int year, int month, int day) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public DatePicker getDatePicker() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void updateDate(int year, int monthOfYear, int dayOfMonth) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    protected void onStop() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public android.os.Bundle onSaveInstanceState() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void onRestoreInstanceState(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface OnDateSetListener
/*    */ {
        /*    */
        public abstract void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/DatePickerDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */