/*    */
package android.net;
/*    */

import java.net.Socket;

/*    */
/*  4 */ public class TrafficStats {
    public TrafficStats() {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public static void setThreadStatsTag(int tag) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static int getThreadStatsTag() {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public static void clearThreadStatsTag() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static void tagSocket(Socket socket) throws java.net.SocketException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static void untagSocket(Socket socket) throws java.net.SocketException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static void incrementOperationCount(int operationCount) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static void incrementOperationCount(int tag, int operationCount) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static long getMobileTxPackets() {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public static long getMobileRxPackets() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public static long getMobileTxBytes() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static long getMobileRxBytes() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static long getTotalTxPackets() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public static long getTotalRxPackets() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public static long getTotalTxBytes() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static long getTotalRxBytes() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int UNSUPPORTED = -1;

    /*    */
    public static native long getUidTxBytes(int paramInt);

    /*    */
/*    */
    public static native long getUidRxBytes(int paramInt);

    /*    */
/*    */
    public static native long getUidTxPackets(int paramInt);

    /*    */
/*    */
    public static native long getUidRxPackets(int paramInt);

    /*    */
/*    */
    public static native long getUidTcpTxBytes(int paramInt);

    /*    */
/*    */
    public static native long getUidTcpRxBytes(int paramInt);

    /*    */
/*    */
    public static native long getUidUdpTxBytes(int paramInt);

    /*    */
/*    */
    public static native long getUidUdpRxBytes(int paramInt);

    /*    */
/*    */
    public static native long getUidTcpTxSegments(int paramInt);

    /*    */
/*    */
    public static native long getUidTcpRxSegments(int paramInt);

    /*    */
/*    */
    public static native long getUidUdpTxPackets(int paramInt);

    /*    */
/*    */
    public static native long getUidUdpRxPackets(int paramInt);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/net/TrafficStats.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */