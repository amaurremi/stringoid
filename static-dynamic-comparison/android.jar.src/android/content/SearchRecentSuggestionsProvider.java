/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*  5 */ public class SearchRecentSuggestionsProvider extends ContentProvider {
    public SearchRecentSuggestionsProvider() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected void setupSuggestions(String authority, int mode) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public String getType(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Uri insert(Uri uri, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public boolean onCreate() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public android.database.Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int DATABASE_MODE_QUERIES = 1;
    /*    */   public static final int DATABASE_MODE_2LINES = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/SearchRecentSuggestionsProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */