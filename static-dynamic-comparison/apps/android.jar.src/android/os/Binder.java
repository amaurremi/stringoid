/*    */
package android.os;
/*    */ 
/*    */

import java.io.FileDescriptor;

/*    */
/*  5 */ public class Binder implements IBinder {
    public Binder() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public static final native int getCallingPid();

    /*    */
    public static final native int getCallingUid();

    /*    */
    public static final native long clearCallingIdentity();

    /*    */
    public static final native void restoreCallingIdentity(long paramLong);

    /*    */
    public static final native void flushPendingCommands();

    /*    */
    public static final native void joinThreadPool();

    /* 12 */
    public void attachInterface(IInterface owner, String descriptor) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public String getInterfaceDescriptor() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean pingBinder() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public boolean isBinderAlive() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public IInterface queryLocalInterface(String descriptor) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void dump(FileDescriptor fd, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void dumpAsync(FileDescriptor fd, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    protected void dump(FileDescriptor fd, java.io.PrintWriter fout, String[] args) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final boolean transact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void linkToDeath(IBinder.DeathRecipient recipient, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public boolean unlinkToDeath(IBinder.DeathRecipient recipient, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/Binder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */