/*    */
package android.text;
/*    */ 
/*    */

import android.graphics.drawable.Drawable;
/*    */ import org.xml.sax.XMLReader;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Html
/*    */ {
    /* 12 */   Html() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static Spanned fromHtml(String source) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static Spanned fromHtml(String source, ImageGetter imageGetter, TagHandler tagHandler) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static String toHtml(Spanned text) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static String escapeHtml(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface TagHandler
/*    */ {
        /*    */
        public abstract void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader);
/*    */
    }

    /*    */
/*    */   public static abstract interface ImageGetter
/*    */ {
        /*    */
        public abstract Drawable getDrawable(String paramString);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/Html.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */