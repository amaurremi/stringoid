package android.support.v4.app;

import android.os.IBinder;
import android.os.Parcel;

class ae
        implements ac {
    private IBinder a;

    ae(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public void a(String paramString) {
        Parcel localParcel = Parcel.obtain();
        try {
            localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            localParcel.writeString(paramString);
            this.a.transact(3, localParcel, null, 1);
            return;
        } finally {
            localParcel.recycle();
        }
    }

    public void a(String paramString1, int paramInt, String paramString2) {
        Parcel localParcel = Parcel.obtain();
        try {
            localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            localParcel.writeString(paramString1);
            localParcel.writeInt(paramInt);
            localParcel.writeString(paramString2);
            this.a.transact(2, localParcel, null, 1);
            return;
        } finally {
            localParcel.recycle();
        }
    }

    /* Error */
    public void a(String paramString1, int paramInt, String paramString2, android.app.Notification paramNotification) {
        // Byte code:
        //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: aload 5
        //   7: ldc 25
        //   9: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 5
        //   14: aload_1
        //   15: invokevirtual 31	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload 5
        //   20: iload_2
        //   21: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   24: aload 5
        //   26: aload_3
        //   27: invokevirtual 31	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   30: aload 4
        //   32: ifnull +38 -> 70
        //   35: aload 5
        //   37: iconst_1
        //   38: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   41: aload 4
        //   43: aload 5
        //   45: iconst_0
        //   46: invokevirtual 52	android/app/Notification:writeToParcel	(Landroid/os/Parcel;I)V
        //   49: aload_0
        //   50: getfield 15	android/support/v4/app/ae:a	Landroid/os/IBinder;
        //   53: iconst_1
        //   54: aload 5
        //   56: aconst_null
        //   57: iconst_1
        //   58: invokeinterface 37 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 40	android/os/Parcel:recycle	()V
        //   69: return
        //   70: aload 5
        //   72: iconst_0
        //   73: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   76: goto -27 -> 49
        //   79: astore_1
        //   80: aload 5
        //   82: invokevirtual 40	android/os/Parcel:recycle	()V
        //   85: aload_1
        //   86: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	ae
        //   0	87	1	paramString1	String
        //   0	87	2	paramInt	int
        //   0	87	3	paramString2	String
        //   0	87	4	paramNotification	android.app.Notification
        //   3	78	5	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	30	79	finally
        //   35	49	79	finally
        //   49	64	79	finally
        //   70	76	79	finally
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */