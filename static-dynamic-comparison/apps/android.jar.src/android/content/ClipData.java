/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public class ClipData implements android.os.Parcelable {
    /*    */   public static class Item {
        /*  7 */
        public Item(CharSequence text) {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public Item(CharSequence text, String htmlText) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public Item(Intent intent) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public Item(Uri uri) {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public Item(CharSequence text, Intent intent, Uri uri) {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public Item(CharSequence text, String htmlText, Intent intent, Uri uri) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public CharSequence getText() {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public String getHtmlText() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public Intent getIntent() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public Uri getUri() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public CharSequence coerceToText(Context context) {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public CharSequence coerceToStyledText(Context context) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public String coerceToHtmlText(Context context) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 22 */
    public ClipData(CharSequence label, String[] mimeTypes, Item item) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public ClipData(ClipDescription description, Item item) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public ClipData(ClipData other) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public static ClipData newPlainText(CharSequence label, CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public static ClipData newHtmlText(CharSequence label, CharSequence text, String htmlText) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public static ClipData newIntent(CharSequence label, Intent intent) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public static ClipData newUri(ContentResolver resolver, CharSequence label, Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public static ClipData newRawUri(CharSequence label, Uri uri) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public ClipDescription getDescription() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public void addItem(Item item) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int getItemCount() {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public Item getItemAt(int index) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void writeToParcel(android.os.Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 38 */   public static final android.os.Parcelable.Creator<ClipData> CREATOR = null;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/ClipData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */