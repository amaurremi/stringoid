/*    */
package android.app;
/*    */ 
/*    */

import android.content.ComponentName;

/*    */
/*    */ public class SearchManager
/*    */ implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnCancelListener {
    /*    */   public static final char MENU_KEY = 's';
    /*    */   public static final int MENU_KEYCODE = 47;
    /*    */   public static final String QUERY = "query";
    /*    */   public static final String USER_QUERY = "user_query";
    /*    */   public static final String APP_DATA = "app_data";

    /*    */
/* 13 */   SearchManager() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void startSearch(String initialQuery, boolean selectInitialQuery, ComponentName launchActivity, android.os.Bundle appSearchData, boolean globalSearch) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public ComponentName getGlobalSearchActivity() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public void triggerSearch(String query, ComponentName launchActivity, android.os.Bundle appSearchData) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void stopSearch() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void setOnDismissListener(OnDismissListener listener) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void setOnCancelListener(OnCancelListener listener) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 21 */ public void onCancel(android.content.DialogInterface dialog) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 23 */ public void onDismiss(android.content.DialogInterface dialog) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public SearchableInfo getSearchableInfo(ComponentName componentName) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public java.util.List<SearchableInfo> getSearchablesInGlobalSearch() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final String ACTION_KEY = "action_key";
    /*    */   public static final String EXTRA_DATA_KEY = "intent_extra_data_key";
    /*    */   public static final String EXTRA_SELECT_QUERY = "select_query";
    /*    */   public static final String EXTRA_NEW_SEARCH = "new_search";
    /*    */   public static final String EXTRA_WEB_SEARCH_PENDINGINTENT = "web_search_pendingintent";
    /*    */   public static final String CURSOR_EXTRA_KEY_IN_PROGRESS = "in_progress";
    /*    */   public static final String ACTION_MSG = "action_msg";
    /*    */   public static final int FLAG_QUERY_REFINEMENT = 1;
    /*    */   public static final String SUGGEST_URI_PATH_QUERY = "search_suggest_query";
    /*    */   public static final String SUGGEST_MIME_TYPE = "vnd.android.cursor.dir/vnd.android.search.suggest";
    /*    */   public static final String SUGGEST_URI_PATH_SHORTCUT = "search_suggest_shortcut";
    /*    */   public static final String SHORTCUT_MIME_TYPE = "vnd.android.cursor.item/vnd.android.search.suggest";
    /*    */   public static final String SUGGEST_COLUMN_FORMAT = "suggest_format";
    /*    */   public static final String SUGGEST_COLUMN_TEXT_1 = "suggest_text_1";
    /*    */   public static final String SUGGEST_COLUMN_TEXT_2 = "suggest_text_2";
    /*    */   public static final String SUGGEST_COLUMN_TEXT_2_URL = "suggest_text_2_url";
    /*    */   public static final String SUGGEST_COLUMN_ICON_1 = "suggest_icon_1";
    /*    */   public static final String SUGGEST_COLUMN_ICON_2 = "suggest_icon_2";
    /*    */   public static final String SUGGEST_COLUMN_INTENT_ACTION = "suggest_intent_action";
    /*    */   public static final String SUGGEST_COLUMN_INTENT_DATA = "suggest_intent_data";
    /*    */   public static final String SUGGEST_COLUMN_INTENT_EXTRA_DATA = "suggest_intent_extra_data";
    /*    */   public static final String SUGGEST_COLUMN_INTENT_DATA_ID = "suggest_intent_data_id";
    /*    */   public static final String SUGGEST_COLUMN_QUERY = "suggest_intent_query";
    /*    */   public static final String SUGGEST_COLUMN_SHORTCUT_ID = "suggest_shortcut_id";
    /*    */   public static final String SUGGEST_COLUMN_SPINNER_WHILE_REFRESHING = "suggest_spinner_while_refreshing";
    /*    */   public static final String SUGGEST_COLUMN_FLAGS = "suggest_flags";
    /*    */   public static final String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";
    /*    */   public static final String SUGGEST_NEVER_MAKE_SHORTCUT = "_-1";
    /*    */   public static final String SUGGEST_PARAMETER_LIMIT = "limit";
    /*    */   public static final String INTENT_ACTION_GLOBAL_SEARCH = "android.search.action.GLOBAL_SEARCH";
    /*    */   public static final String INTENT_ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";
    /*    */   public static final String INTENT_ACTION_WEB_SEARCH_SETTINGS = "android.search.action.WEB_SEARCH_SETTINGS";
    /*    */   public static final String INTENT_ACTION_SEARCHABLES_CHANGED = "android.search.action.SEARCHABLES_CHANGED";
    /*    */   public static final String INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED = "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED";
    /*    */   public static final String INTENT_ACTION_SEARCH_SETTINGS_CHANGED = "android.search.action.SETTINGS_CHANGED";

    /*    */   public static abstract interface OnCancelListener
/*    */ {
        /*    */
        public abstract void onCancel();
/*    */
    }

    /*    */
/*    */   public static abstract interface OnDismissListener
/*    */ {
        /*    */
        public abstract void onDismiss();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/SearchManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */