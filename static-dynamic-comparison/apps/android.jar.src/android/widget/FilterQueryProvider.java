package android.widget;

import android.database.Cursor;

public abstract interface FilterQueryProvider {
    public abstract Cursor runQuery(CharSequence paramCharSequence);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/FilterQueryProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */