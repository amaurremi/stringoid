/*   */
package android.app.backup;
/*   */ 
/*   */

import android.os.ParcelFileDescriptor;

/*   */
/*   */ public class FileBackupHelper extends FileBackupHelperBase implements BackupHelper {
    /* 6 */
    public FileBackupHelper(android.content.Context context, String... files) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void restoreEntity(BackupDataInputStream data) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/backup/FileBackupHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */