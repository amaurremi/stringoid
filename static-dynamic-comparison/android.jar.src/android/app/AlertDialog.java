/*    */
package android.app;
/*    */ 
/*    */

import android.content.DialogInterface.OnClickListener;

/*    */
/*    */ public class AlertDialog extends Dialog implements android.content.DialogInterface {
    public static final int THEME_TRADITIONAL = 1;
    /*    */   public static final int THEME_HOLO_DARK = 2;

    /*    */
/*  8 */   public static class Builder {
        public Builder(android.content.Context context) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public Builder(android.content.Context context, int theme) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public android.content.Context getContext() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public Builder setTitle(int titleId) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public Builder setTitle(CharSequence title) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public Builder setCustomTitle(android.view.View customTitleView) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public Builder setMessage(int messageId) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public Builder setMessage(CharSequence message) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public Builder setIcon(int iconId) {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public Builder setIcon(android.graphics.drawable.Drawable icon) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public Builder setIconAttribute(int attrId) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public Builder setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public Builder setNeutralButton(int textId, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public Builder setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public Builder setCancelable(boolean cancelable) {
            throw new RuntimeException("Stub!");
        }

        /* 26 */
        public Builder setOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
            throw new RuntimeException("Stub!");
        }

        /* 27 */
        public Builder setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
            throw new RuntimeException("Stub!");
        }

        /* 28 */
        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 29 */
        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 30 */
        public Builder setAdapter(android.widget.ListAdapter adapter, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 31 */
        public Builder setCursor(android.database.Cursor cursor, DialogInterface.OnClickListener listener, String labelColumn) {
            throw new RuntimeException("Stub!");
        }

        /* 32 */
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, android.content.DialogInterface.OnMultiChoiceClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 33 */
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, android.content.DialogInterface.OnMultiChoiceClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 34 */
        public Builder setMultiChoiceItems(android.database.Cursor cursor, String isCheckedColumn, String labelColumn, android.content.DialogInterface.OnMultiChoiceClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 35 */
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 36 */
        public Builder setSingleChoiceItems(android.database.Cursor cursor, int checkedItem, String labelColumn, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 37 */
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 38 */
        public Builder setSingleChoiceItems(android.widget.ListAdapter adapter, int checkedItem, DialogInterface.OnClickListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 39 */
        public Builder setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener listener) {
            throw new RuntimeException("Stub!");
        }

        /* 40 */
        public Builder setView(android.view.View view) {
            throw new RuntimeException("Stub!");
        }

        /* 41 */
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            throw new RuntimeException("Stub!");
        }

        /* 42 */
        public AlertDialog create() {
            throw new RuntimeException("Stub!");
        }

        /* 43 */
        public AlertDialog show() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 45 */
    protected AlertDialog(android.content.Context context) {
        super((android.content.Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    protected AlertDialog(android.content.Context context, int theme) {
        super((android.content.Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    protected AlertDialog(android.content.Context context, boolean cancelable, android.content.DialogInterface.OnCancelListener cancelListener) {
        super((android.content.Context) null, false, (android.content.DialogInterface.OnCancelListener) null);
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public android.widget.Button getButton(int whichButton) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public android.widget.ListView getListView() {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public void setTitle(CharSequence title) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public void setCustomTitle(android.view.View customTitleView) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public void setMessage(CharSequence message) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public void setView(android.view.View view) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public void setView(android.view.View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void setButton(int whichButton, CharSequence text, android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void setButton(int whichButton, CharSequence text, DialogInterface.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 58 */ public void setButton(CharSequence text, android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 60 */ public void setButton2(CharSequence text, android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 62 */ public void setButton3(CharSequence text, android.os.Message msg) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 64 */ public void setButton(CharSequence text, DialogInterface.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 66 */ public void setButton2(CharSequence text, DialogInterface.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 68 */ public void setButton3(CharSequence text, DialogInterface.OnClickListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 69 */
    public void setIcon(int resId) {
        throw new RuntimeException("Stub!");
    }

    /* 70 */
    public void setIcon(android.graphics.drawable.Drawable icon) {
        throw new RuntimeException("Stub!");
    }

    /* 71 */
    public void setIconAttribute(int attrId) {
        throw new RuntimeException("Stub!");
    }

    /* 72 */
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        throw new RuntimeException("Stub!");
    }

    /* 73 */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        throw new RuntimeException("Stub!");
    }

    /* 74 */
    public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /* 75 */
    public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int THEME_HOLO_LIGHT = 3;
    /*    */   public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    /*    */   public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/AlertDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */