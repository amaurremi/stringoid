/*   */
package android.app.backup;
/*   */

import java.io.IOException;

/*   */
/* 4 */ public class BackupDataInput {
    BackupDataInput() {
        throw new RuntimeException("Stub!");
    }

    /* 5 */
    public boolean readNextHeader() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public String getKey() {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int getDataSize() {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public int readEntityData(byte[] data, int offset, int size) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public void skipEntityData() throws IOException {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/backup/BackupDataInput.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */