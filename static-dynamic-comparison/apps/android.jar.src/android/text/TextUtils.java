/*    */
package android.text;
/*    */ 
/*    */

import java.util.Iterator;

/*    */
/*    */ public class TextUtils {
    /*    */   public static abstract interface StringSplitter
/*    */ extends Iterable<String> {
        /*    */
        public abstract void setString(String paramString);
/*    */
    }

    /*    */
/*    */   public static class SimpleStringSplitter implements TextUtils.StringSplitter, Iterator<String> {
        /* 12 */
        public SimpleStringSplitter(char delimiter) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public void setString(String string) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public Iterator<String> iterator() {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public boolean hasNext() {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public String next() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public void remove() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static enum TruncateAt {
        /* 21 */     END,
        /* 22 */     MARQUEE,
        /* 23 */     MIDDLE,
        /* 24 */     START;

        /*    */
/*    */ 
/*    */
        private TruncateAt() {
        }
/*    */
    }

    /*    */
/* 30 */   TextUtils() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public static void getChars(CharSequence s, int start, int end, char[] dest, int destoff) {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public static int indexOf(CharSequence s, char ch) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public static int indexOf(CharSequence s, char ch, int start) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public static int indexOf(CharSequence s, char ch, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public static int lastIndexOf(CharSequence s, char ch) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public static int lastIndexOf(CharSequence s, char ch, int last) {
        throw new RuntimeException("Stub!");
    }

    /* 37 */
    public static int lastIndexOf(CharSequence s, char ch, int start, int last) {
        throw new RuntimeException("Stub!");
    }

    /* 38 */
    public static int indexOf(CharSequence s, CharSequence needle) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public static int indexOf(CharSequence s, CharSequence needle, int start) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public static int indexOf(CharSequence s, CharSequence needle, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public static boolean regionMatches(CharSequence one, int toffset, CharSequence two, int ooffset, int len) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public static String substring(CharSequence source, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public static String join(CharSequence delimiter, Object[] tokens) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public static String join(CharSequence delimiter, Iterable tokens) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public static String[] split(String text, String expression) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public static String[] split(String text, java.util.regex.Pattern pattern) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public static CharSequence stringOrSpannedString(CharSequence source) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public static boolean isEmpty(CharSequence str) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public static int getTrimmedLength(CharSequence s) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public static boolean equals(CharSequence a, CharSequence b) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public static CharSequence getReverse(CharSequence source, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public static void writeToParcel(CharSequence cs, android.os.Parcel p, int parcelableFlags) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public static void dumpSpans(CharSequence cs, android.util.Printer printer, String prefix) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public static CharSequence replace(CharSequence template, String[] sources, CharSequence[] destinations) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public static CharSequence expandTemplate(CharSequence template, CharSequence... values) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public static int getOffsetBefore(CharSequence text, int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public static int getOffsetAfter(CharSequence text, int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public static void copySpansFrom(Spanned source, int start, int end, Class kind, Spannable dest, int destoff) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public static CharSequence ellipsize(CharSequence text, TextPaint p, float avail, TruncateAt where) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    public static CharSequence ellipsize(CharSequence text, TextPaint paint, float avail, TruncateAt where, boolean preserveLength, EllipsizeCallback callback) {
        throw new RuntimeException("Stub!");
    }

    /* 61 */
    public static CharSequence commaEllipsize(CharSequence text, TextPaint p, float avail, String oneMore, String more) {
        throw new RuntimeException("Stub!");
    }

    /* 62 */
    public static String htmlEncode(String s) {
        throw new RuntimeException("Stub!");
    }

    /* 63 */
    public static CharSequence concat(CharSequence... text) {
        throw new RuntimeException("Stub!");
    }

    /* 64 */
    public static boolean isGraphic(CharSequence str) {
        throw new RuntimeException("Stub!");
    }

    /* 65 */
    public static boolean isGraphic(char c) {
        throw new RuntimeException("Stub!");
    }

    /* 66 */
    public static boolean isDigitsOnly(CharSequence str) {
        throw new RuntimeException("Stub!");
    }

    /* 67 */
    public static int getCapsMode(CharSequence cs, int off, int reqModes) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/* 72 */   public static final android.os.Parcelable.Creator<CharSequence> CHAR_SEQUENCE_CREATOR = null;
    /*    */   public static final int CAP_MODE_CHARACTERS = 4096;
    /*    */   public static final int CAP_MODE_WORDS = 8192;
    /*    */   public static final int CAP_MODE_SENTENCES = 16384;

    /*    */
/*    */   public static abstract interface EllipsizeCallback
/*    */ {
        /*    */
        public abstract void ellipsized(int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/TextUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */