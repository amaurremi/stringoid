/*    */
package android.provider;
/*    */ 
/*    */

import android.net.Uri;

/*    */
/*    */ public class SyncStateContract {
    /*    */   public static abstract interface Columns extends BaseColumns {
        /*    */     public static final String ACCOUNT_NAME = "account_name";
        /*    */     public static final String ACCOUNT_TYPE = "account_type";
        /*    */     public static final String DATA = "data";
/*    */
    }

    /*    */
/*    */   public static class Constants implements SyncStateContract.Columns {
        public static final String CONTENT_DIRECTORY = "syncstate";

        /*    */
/* 14 */
        public Constants() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */   public static final class Helpers {
        /* 19 */
        public Helpers() {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public static byte[] get(android.content.ContentProviderClient provider, Uri uri, android.accounts.Account account) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 21 */
        public static void set(android.content.ContentProviderClient provider, Uri uri, android.accounts.Account account, byte[] data) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 22 */
        public static Uri insert(android.content.ContentProviderClient provider, Uri uri, android.accounts.Account account, byte[] data) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 23 */
        public static void update(android.content.ContentProviderClient provider, Uri uri, byte[] data) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 24 */
        public static android.util.Pair<Uri, byte[]> getWithUri(android.content.ContentProviderClient provider, Uri uri, android.accounts.Account account) throws android.os.RemoteException {
            throw new RuntimeException("Stub!");
        }

        /* 25 */
        public static android.content.ContentProviderOperation newSetOperation(Uri uri, android.accounts.Account account, byte[] data) {
            throw new RuntimeException("Stub!");
        }

        /* 26 */
        public static android.content.ContentProviderOperation newUpdateOperation(Uri uri, byte[] data) {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/* 28 */
    public SyncStateContract() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/provider/SyncStateContract.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */