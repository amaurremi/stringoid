/*    */
package android.nfc.tech;
/*    */ 
/*    */

import java.io.IOException;

/*    */
/*  5 */ public final class MifareClassic extends BasicTagTechnology {
    MifareClassic() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static MifareClassic get(android.nfc.Tag tag) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getSize() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getSectorCount() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getBlockCount() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getBlockCountInSector(int sectorIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int blockToSector(int blockIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int sectorToBlock(int sectorIndex) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean authenticateSectorWithKeyA(int sectorIndex, byte[] key) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean authenticateSectorWithKeyB(int sectorIndex, byte[] key) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public byte[] readBlock(int blockIndex) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void writeBlock(int blockIndex, byte[] data) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void increment(int blockIndex, int value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void decrement(int blockIndex, int value) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public void transfer(int blockIndex) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void restore(int blockIndex) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public byte[] transceive(byte[] data) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getMaxTransceiveLength() {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public void setTimeout(int timeout) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getTimeout() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */   public static final byte[] KEY_DEFAULT = null;
    /* 27 */   public static final byte[] KEY_MIFARE_APPLICATION_DIRECTORY = null;
    /* 28 */   public static final byte[] KEY_NFC_FORUM = null;
    /*    */   public static final int TYPE_UNKNOWN = -1;
    /*    */   public static final int TYPE_CLASSIC = 0;
    /*    */   public static final int TYPE_PLUS = 1;
    /*    */   public static final int TYPE_PRO = 2;
    /*    */   public static final int SIZE_1K = 1024;
    /*    */   public static final int SIZE_2K = 2048;
    /*    */   public static final int SIZE_4K = 4096;
    /*    */   public static final int SIZE_MINI = 320;
    /*    */   public static final int BLOCK_SIZE = 16;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/nfc/tech/MifareClassic.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */