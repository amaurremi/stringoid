/*    */
package android.widget;
/*    */ 
/*    */

import android.database.Cursor;

/*    */
/*    */ public abstract class CursorAdapter extends BaseAdapter implements Filterable {
    /*    */
    @Deprecated
/*  7 */ public CursorAdapter(android.content.Context context, Cursor c) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public CursorAdapter(android.content.Context context, Cursor c, boolean autoRequery) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public CursorAdapter(android.content.Context context, Cursor c, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 11 */ protected void init(android.content.Context context, Cursor c, boolean autoRequery) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public Cursor getCursor() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getCount() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public Object getItem(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public long getItemId(int position) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public boolean hasStableIds() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public android.view.View getDropDownView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract android.view.View newView(android.content.Context paramContext, Cursor paramCursor, android.view.ViewGroup paramViewGroup);

    /* 20 */
    public android.view.View newDropDownView(android.content.Context context, Cursor cursor, android.view.ViewGroup parent) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void bindView(android.view.View paramView, android.content.Context paramContext, Cursor paramCursor);

    /* 22 */
    public void changeCursor(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public Cursor swapCursor(Cursor newCursor) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public CharSequence convertToString(Cursor cursor) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public Filter getFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public FilterQueryProvider getFilterQueryProvider() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    protected void onContentChanged() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    @Deprecated
/*    */ public static final int FLAG_AUTO_REQUERY = 1;
    /*    */   public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/widget/CursorAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */