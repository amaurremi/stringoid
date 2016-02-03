/*    */
package android.app.backup;
/*    */ 
/*    */

import android.os.ParcelFileDescriptor;

/*    */
/*  5 */ public abstract class BackupAgent extends android.content.ContextWrapper {
    public BackupAgent() {
        super((android.content.Context) null);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public void onCreate() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public void onDestroy() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract void onBackup(ParcelFileDescriptor paramParcelFileDescriptor1, BackupDataOutput paramBackupDataOutput, ParcelFileDescriptor paramParcelFileDescriptor2) throws java.io.IOException;

    /*    */
    public abstract void onRestore(BackupDataInput paramBackupDataInput, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor) throws java.io.IOException;

    /* 10 */
    public void onFullBackup(FullBackupDataOutput data) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public final void fullBackupFile(java.io.File file, FullBackupDataOutput output) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void onRestoreFile(ParcelFileDescriptor data, long size, java.io.File destination, int type, long mode, long mtime) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int TYPE_FILE = 1;
    /*    */   public static final int TYPE_DIRECTORY = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/backup/BackupAgent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */