package mobi.beyondpod.ui.search;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class RepositorySearchProvider
  extends ContentProvider
{
  public static String AUTHORITY = "mobi.beyondpod.ui.search.RepositorySearchProvider";
  public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);
  private static final int GET_ITEM = 1;
  public static String PATH = "/repository";
  private static final int REFRESH_SHORTCUT = 3;
  public static final String RESULTS_MIME_TYPE = "vnd.android.cursor.dir/mobi.beyondpod.ui.search";
  public static final String RESULT_MIME_TYPE = "vnd.android.cursor.item/mobi.beyondpod.ui.search";
  private static final int SEARCH_REPO = 0;
  private static final int SEARCH_SUGGEST = 2;
  private static final UriMatcher sURIMatcher = buildUriMatcher();
  String TAG = "RepositorySearchProvider";
  private RepositorySearchDatabase mDictionary;
  
  private static UriMatcher buildUriMatcher()
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    localUriMatcher.addURI(AUTHORITY, "repository", 0);
    localUriMatcher.addURI(AUTHORITY, "repository/#", 1);
    localUriMatcher.addURI(AUTHORITY, "search_suggest_query", 2);
    localUriMatcher.addURI(AUTHORITY, "search_suggest_query/*", 2);
    localUriMatcher.addURI(AUTHORITY, "search_suggest_shortcut", 3);
    localUriMatcher.addURI(AUTHORITY, "search_suggest_shortcut/*", 3);
    return localUriMatcher;
  }
  
  private Cursor getSuggestions(String paramString)
  {
    paramString = paramString.toLowerCase();
    return this.mDictionary.getFeedTrackMatches(paramString, new String[] { "_id", "suggest_text_1", "suggest_text_2", "suggest_icon_1", "suggest_intent_data_id" });
  }
  
  private Cursor getWord(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    return this.mDictionary.getWord(paramUri, new String[] { "suggest_text_1", "suggest_text_2", "suggest_icon_1" });
  }
  
  private Cursor refreshShortcut(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    return this.mDictionary.getWord(paramUri, new String[] { "_id", "suggest_text_1", "suggest_text_2", "suggest_icon_1", "suggest_shortcut_id", "suggest_intent_data_id" });
  }
  
  private Cursor search(String paramString)
  {
    paramString = paramString.toLowerCase();
    return this.mDictionary.getFeedTrackMatches(paramString, new String[] { "_id", "suggest_text_1", "suggest_text_2", "suggest_icon_1" });
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getType(Uri paramUri)
  {
    switch (sURIMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 0: 
      return "vnd.android.cursor.dir/mobi.beyondpod.ui.search";
    case 1: 
      return "vnd.android.cursor.item/mobi.beyondpod.ui.search";
    case 2: 
      return "vnd.android.cursor.dir/vnd.android.search.suggest";
    }
    return "vnd.android.cursor.item/vnd.android.search.suggest";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean onCreate()
  {
    this.mDictionary = new RepositorySearchDatabase(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (sURIMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown Uri: " + paramUri);
    case 2: 
      if (paramArrayOfString2 == null) {
        throw new IllegalArgumentException("selectionArgs must be provided for the Uri: " + paramUri);
      }
      return getSuggestions(paramArrayOfString2[0]);
    case 0: 
      if (paramArrayOfString2 == null) {
        throw new IllegalArgumentException("selectionArgs must be provided for the Uri: " + paramUri);
      }
      return search(paramArrayOfString2[0]);
    case 1: 
      return getWord(paramUri);
    }
    return refreshShortcut(paramUri);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/search/RepositorySearchProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */