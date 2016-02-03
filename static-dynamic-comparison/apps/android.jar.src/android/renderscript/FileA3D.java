/*    */
package android.renderscript;
/*    */ 
/*    */

import android.content.res.Resources;

/*    */
/*    */
@Deprecated
/*    */ public class FileA3D extends BaseObj {
    /*    */
    @Deprecated
/*    */ public static enum EntryType {
        /*  9 */     MESH,
        /* 10 */     UNKNOWN;

        /*    */
/*    */
        private EntryType() {
        }
    }

    /*    */
/*    */
    @Deprecated
/* 15 */ public static class IndexEntry {
        IndexEntry() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 17 */ public String getName() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 19 */ public FileA3D.EntryType getEntryType() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 21 */ public BaseObj getObject() {
            throw new RuntimeException("Stub!");
        }

        /*    */
        @Deprecated
/* 23 */ public Mesh getMesh() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 25 */   FileA3D() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 27 */ public int getIndexEntryCount() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 29 */ public IndexEntry getIndexEntry(int index) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 31 */ public static FileA3D createFromAsset(RenderScript rs, android.content.res.AssetManager mgr, String path) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public static FileA3D createFromFile(RenderScript rs, String path) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 35 */ public static FileA3D createFromFile(RenderScript rs, java.io.File path) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 37 */ public static FileA3D createFromResource(RenderScript rs, Resources res, int id) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/renderscript/FileA3D.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */