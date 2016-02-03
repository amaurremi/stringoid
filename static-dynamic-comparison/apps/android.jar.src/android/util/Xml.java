/*    */
package android.util;
/*    */ 
/*    */

import org.xml.sax.ContentHandler;

/*    */
/*    */ public class Xml {
    /*  6 */   public static enum Encoding {
        ISO_8859_1,
        /*  7 */     US_ASCII,
        /*  8 */     UTF_16,
        /*  9 */     UTF_8;

        /*    */
        private Encoding() {
        }
    }

    /* 11 */   Xml() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static void parse(String xml, ContentHandler contentHandler) throws org.xml.sax.SAXException {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static void parse(java.io.Reader in, ContentHandler contentHandler) throws java.io.IOException, org.xml.sax.SAXException {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static void parse(java.io.InputStream in, Encoding encoding, ContentHandler contentHandler) throws java.io.IOException, org.xml.sax.SAXException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static org.xmlpull.v1.XmlPullParser newPullParser() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static org.xmlpull.v1.XmlSerializer newSerializer() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static Encoding findEncodingByName(String encodingName) throws java.io.UnsupportedEncodingException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static AttributeSet asAttributeSet(org.xmlpull.v1.XmlPullParser parser) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static String FEATURE_RELAXED;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/util/Xml.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */