package com.quoord.tapatalkpro.activity;

import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.net.Uri;

public class SearchSuggestionProvider
        extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "com.quoord.tapatalkpro.activity.SearchSuggestionProvider";
    public static final int MODE = 1;

    public SearchSuggestionProvider() {
        setupSuggestions("com.quoord.tapatalkpro.activity.SearchSuggestionProvider", 1);
    }

    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
        return super.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/SearchSuggestionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */