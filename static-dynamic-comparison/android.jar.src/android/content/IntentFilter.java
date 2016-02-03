/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public class IntentFilter implements android.os.Parcelable {
    /*    */   public static final int SYSTEM_HIGH_PRIORITY = 1000;

    /*    */
/*  8 */   public static class MalformedMimeTypeException extends android.util.AndroidException {
        public MalformedMimeTypeException() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public MalformedMimeTypeException(String name) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static final class AuthorityEntry {
        /* 13 */
        public AuthorityEntry(String host, String port) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public String getHost() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public int getPort() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public int match(Uri data) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 18 */
    public IntentFilter() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public IntentFilter(String action) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public IntentFilter(String action, String dataType) throws IntentFilter.MalformedMimeTypeException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public IntentFilter(IntentFilter o) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static IntentFilter create(String action, String dataType) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final void setPriority(int priority) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public final int getPriority() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final void addAction(String action) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final int countActions() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public final String getAction(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public final boolean hasAction(String action) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public final boolean matchAction(String action) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public final java.util.Iterator<String> actionsIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public final void addDataType(String type) throws IntentFilter.MalformedMimeTypeException {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public final boolean hasDataType(String type) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public final int countDataTypes() {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public final String getDataType(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public final java.util.Iterator<String> typesIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public final void addDataScheme(String scheme) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public final int countDataSchemes() {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public final String getDataScheme(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public final boolean hasDataScheme(String scheme) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public final java.util.Iterator<String> schemesIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public final void addDataAuthority(String host, String port) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public final int countDataAuthorities() {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public final AuthorityEntry getDataAuthority(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public final boolean hasDataAuthority(Uri data) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public final java.util.Iterator<AuthorityEntry> authoritiesIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public final void addDataPath(String path, int type) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public final int countDataPaths() {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public final android.os.PatternMatcher getDataPath(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public final boolean hasDataPath(String data) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public final java.util.Iterator<android.os.PatternMatcher> pathsIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public final int matchDataAuthority(Uri data) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public final int matchData(String type, String scheme, Uri data) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public final void addCategory(String category) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public final int countCategories() {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public final String getCategory(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public final boolean hasCategory(String category) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public final java.util.Iterator<String> categoriesIterator() {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public final String matchCategories(java.util.Set<String> categories) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public final int match(ContentResolver resolver, Intent intent, boolean resolve, String logTag) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public final int match(String action, String type, String scheme, Uri data, java.util.Set<String> categories, String logTag) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public void writeToXml(org.xmlpull.v1.XmlSerializer serializer) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public void readFromXml(org.xmlpull.v1.XmlPullParser parser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public void dump(android.util.Printer du, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public final int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public final void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */   public static final int SYSTEM_LOW_PRIORITY = -1000;
    /*    */   public static final int MATCH_CATEGORY_MASK = 268369920;
    /*    */   public static final int MATCH_ADJUSTMENT_MASK = 65535;
    /*    */   public static final int MATCH_ADJUSTMENT_NORMAL = 32768;
    /*    */   public static final int MATCH_CATEGORY_EMPTY = 1048576;
    /*    */   public static final int MATCH_CATEGORY_SCHEME = 2097152;
    /*    */   public static final int MATCH_CATEGORY_HOST = 3145728;
    /*    */   public static final int MATCH_CATEGORY_PORT = 4194304;
    /*    */   public static final int MATCH_CATEGORY_PATH = 5242880;
    /*    */   public static final int MATCH_CATEGORY_TYPE = 6291456;
    /*    */   public static final int NO_MATCH_TYPE = -1;
    /*    */   public static final int NO_MATCH_DATA = -2;
    /*    */   public static final int NO_MATCH_ACTION = -3;
    /*    */   public static final int NO_MATCH_CATEGORY = -4;
    /* 82 */   public static final android.os.Parcelable.Creator<IntentFilter> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/IntentFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */