/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public class ContentProviderOperation implements android.os.Parcelable {
    /*    */   public static class Builder {
        /*  7 */     Builder() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public ContentProviderOperation build() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public Builder withValueBackReferences(ContentValues backReferences) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public Builder withValueBackReference(String key, int previousResult) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public Builder withSelectionBackReference(int selectionArgIndex, int previousResult) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public Builder withValues(ContentValues values) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public Builder withValue(String key, Object value) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public Builder withSelection(String selection, String[] selectionArgs) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public Builder withExpectedCount(int count) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public Builder withYieldAllowed(boolean yieldAllowed) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 18 */   ContentProviderOperation() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static Builder newInsert(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public static Builder newUpdate(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public static Builder newDelete(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public static Builder newAssertQuery(Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public Uri getUri() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public boolean isYieldAllowed() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public boolean isWriteOperation() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean isReadOperation() {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public ContentProviderResult apply(ContentProvider provider, ContentProviderResult[] backRefs, int numBackRefs) throws OperationApplicationException {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public ContentValues resolveValueBackReferences(ContentProviderResult[] backRefs, int numBackRefs) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public String[] resolveSelectionArgsBackReferences(ContentProviderResult[] backRefs, int numBackRefs) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 34 */   public static final android.os.Parcelable.Creator<ContentProviderOperation> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ContentProviderOperation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */