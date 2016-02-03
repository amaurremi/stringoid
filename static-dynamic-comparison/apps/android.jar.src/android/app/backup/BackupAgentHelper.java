/*   */
package android.app.backup;
/*   */ 
/*   */

import android.os.ParcelFileDescriptor;

/*   */
/* 5 */ public class BackupAgentHelper extends BackupAgent {
    public BackupAgentHelper() {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data, ParcelFileDescriptor newState) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void addHelper(String keyPrefix, BackupHelper helper) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/backup/BackupAgentHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */