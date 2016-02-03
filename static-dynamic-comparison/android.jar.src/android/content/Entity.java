/*    */
package android.content;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public final class Entity {
    public static class NamedContentValues {
        public final Uri uri;

        /*  6 */
        public NamedContentValues(Uri uri, ContentValues values) {
            throw new RuntimeException("Stub!");
        }

        /*    */
/*    */     public final ContentValues values;
    }

    /*    */
/* 10 */
    public Entity(ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public ContentValues getEntityValues() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public java.util.ArrayList<NamedContentValues> getSubValues() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void addSubValue(Uri uri, ContentValues values) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/content/Entity.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */