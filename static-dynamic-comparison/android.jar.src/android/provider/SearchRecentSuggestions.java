/*   */
package android.provider;
/*   */

import android.content.Context;

/*   */
/* 4 */ public class SearchRecentSuggestions {
    public SearchRecentSuggestions(Context context, String authority, int mode) {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public void saveRecentQuery(String queryString, String line2) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void clearHistory() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    protected void truncateHistory(android.content.ContentResolver cr, int maxEntries) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */   public static final String[] QUERIES_PROJECTION_1LINE = null;
    /* 9 */   public static final String[] QUERIES_PROJECTION_2LINE = null;
    /*   */   public static final int QUERIES_PROJECTION_DATE_INDEX = 1;
    /*   */   public static final int QUERIES_PROJECTION_QUERY_INDEX = 2;
    /*   */   public static final int QUERIES_PROJECTION_DISPLAY1_INDEX = 3;
    /*   */   public static final int QUERIES_PROJECTION_DISPLAY2_INDEX = 4;
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/SearchRecentSuggestions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */