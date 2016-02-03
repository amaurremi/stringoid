/*    */
package android.text.util;
/*    */ 
/*    */

import android.text.Spannable;
/*    */ import android.widget.TextView;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;

/*    */
/*    */ 
/*    */ 
/*    */ public class Linkify
/*    */ {
    /* 12 */
    public Linkify() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static final boolean addLinks(Spannable text, int mask) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static final boolean addLinks(TextView text, int mask) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static final void addLinks(TextView text, Pattern pattern, String scheme) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static final void addLinks(TextView text, Pattern p, String scheme, MatchFilter matchFilter, TransformFilter transformFilter) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static final boolean addLinks(Spannable text, Pattern pattern, String scheme) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static final boolean addLinks(Spannable s, Pattern p, String scheme, MatchFilter matchFilter, TransformFilter transformFilter) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 27 */   public static final TransformFilter sPhoneNumberTransformFilter = null;
    public static final MatchFilter sPhoneNumberMatchFilter = null;
    public static final MatchFilter sUrlMatchFilter = null;
    /*    */   public static final int ALL = 15;
    /*    */   public static final int MAP_ADDRESSES = 8;
    /*    */   public static final int PHONE_NUMBERS = 4;
    /*    */   public static final int EMAIL_ADDRESSES = 2;
    /*    */   public static final int WEB_URLS = 1;

    /*    */
/*    */   public static abstract interface TransformFilter
/*    */ {
        /*    */
        public abstract String transformUrl(Matcher paramMatcher, String paramString);
/*    */
    }

    /*    */
/*    */   public static abstract interface MatchFilter
/*    */ {
        /*    */
        public abstract boolean acceptMatch(CharSequence paramCharSequence, int paramInt1, int paramInt2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/util/Linkify.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */