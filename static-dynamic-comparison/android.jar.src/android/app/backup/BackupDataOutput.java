/*   */
package android.app.backup;
/*   */

import java.io.IOException;

/*   */
/* 4 */ public class BackupDataOutput {
    BackupDataOutput() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public int writeEntityHeader(String key, int dataSize) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public int writeEntityData(byte[] data, int size) throws IOException {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/backup/BackupDataOutput.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */