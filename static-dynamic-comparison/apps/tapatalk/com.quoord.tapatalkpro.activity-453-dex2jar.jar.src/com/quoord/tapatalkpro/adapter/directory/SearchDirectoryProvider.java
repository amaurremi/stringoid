package com.quoord.tapatalkpro.adapter.directory;

import android.content.SearchRecentSuggestionsProvider;

public class SearchDirectoryProvider
        extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "com.quoord.tapatalkpro.directory.SearchDirectorySuggestionProvider";
    public static final int MODE = 1;

    public SearchDirectoryProvider() {
        setupSuggestions("com.quoord.tapatalkpro.directory.SearchDirectorySuggestionProvider", 1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/SearchDirectoryProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */