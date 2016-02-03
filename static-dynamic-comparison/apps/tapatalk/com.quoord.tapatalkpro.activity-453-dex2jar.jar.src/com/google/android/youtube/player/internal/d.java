package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.view.KeyEvent;

import java.util.List;

public abstract interface d
        extends IInterface {
    public abstract void a()
            throws RemoteException;

    public abstract void a(int paramInt)
            throws RemoteException;

    public abstract void a(Configuration paramConfiguration)
            throws RemoteException;

    public abstract void a(e parame)
            throws RemoteException;

    public abstract void a(f paramf)
            throws RemoteException;

    public abstract void a(g paramg)
            throws RemoteException;

    public abstract void a(h paramh)
            throws RemoteException;

    public abstract void a(String paramString)
            throws RemoteException;

    public abstract void a(String paramString, int paramInt)
            throws RemoteException;

    public abstract void a(String paramString, int paramInt1, int paramInt2)
            throws RemoteException;

    public abstract void a(List<String> paramList, int paramInt1, int paramInt2)
            throws RemoteException;

    public abstract void a(boolean paramBoolean)
            throws RemoteException;

    public abstract boolean a(int paramInt, KeyEvent paramKeyEvent)
            throws RemoteException;

    public abstract boolean a(Bundle paramBundle)
            throws RemoteException;

    public abstract void b()
            throws RemoteException;

    public abstract void b(int paramInt)
            throws RemoteException;

    public abstract void b(String paramString, int paramInt)
            throws RemoteException;

    public abstract void b(String paramString, int paramInt1, int paramInt2)
            throws RemoteException;

    public abstract void b(List<String> paramList, int paramInt1, int paramInt2)
            throws RemoteException;

    public abstract void b(boolean paramBoolean)
            throws RemoteException;

    public abstract boolean b(int paramInt, KeyEvent paramKeyEvent)
            throws RemoteException;

    public abstract void c(int paramInt)
            throws RemoteException;

    public abstract void c(boolean paramBoolean)
            throws RemoteException;

    public abstract boolean c()
            throws RemoteException;

    public abstract void d(int paramInt)
            throws RemoteException;

    public abstract void d(boolean paramBoolean)
            throws RemoteException;

    public abstract boolean d()
            throws RemoteException;

    public abstract void e(boolean paramBoolean)
            throws RemoteException;

    public abstract boolean e()
            throws RemoteException;

    public abstract void f()
            throws RemoteException;

    public abstract void g()
            throws RemoteException;

    public abstract int h()
            throws RemoteException;

    public abstract int i()
            throws RemoteException;

    public abstract int j()
            throws RemoteException;

    public abstract void k()
            throws RemoteException;

    public abstract void l()
            throws RemoteException;

    public abstract void m()
            throws RemoteException;

    public abstract void n()
            throws RemoteException;

    public abstract void o()
            throws RemoteException;

    public abstract void p()
            throws RemoteException;

    public abstract void q()
            throws RemoteException;

    public abstract Bundle r()
            throws RemoteException;

    public abstract u s()
            throws RemoteException;

    public static abstract class a
            extends Binder
            implements d {
        public static d a(IBinder paramIBinder) {
            if (paramIBinder == null) {
                return null;
            }
            IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            if ((localIInterface != null) && ((localIInterface instanceof d))) {
                return (d) localIInterface;
            }
            return new a(paramIBinder);
        }

        public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
                throws RemoteException {
            Object localObject2 = null;
            Object localObject3 = null;
            Object localObject4 = null;
            Object localObject6 = null;
            Object localObject7 = null;
            Object localObject8 = null;
            Object localObject9 = null;
            Object localObject5 = null;
            Object localObject1 = null;
            int m = 0;
            int n = 0;
            boolean bool1 = false;
            boolean bool2 = false;
            boolean bool3 = false;
            boolean bool4 = false;
            int i1 = 0;
            int i = 0;
            int j = 0;
            int k = 0;
            switch (paramInt1) {
                default:
                    return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
                case 1598968902:
                    paramParcel2.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    return true;
                case 1:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (paramParcel1.readInt() != 0) {
                    }
                    for (bool1 = true; ; bool1 = false) {
                        a(bool1);
                        paramParcel2.writeNoException();
                        return true;
                    }
                case 2:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    a(paramParcel1.readString(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 3:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    b(paramParcel1.readString(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 4:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 5:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    b(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 6:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    a(paramParcel1.createStringArrayList(), paramParcel1.readInt(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 7:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    b(paramParcel1.createStringArrayList(), paramParcel1.readInt(), paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 8:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    a();
                    paramParcel2.writeNoException();
                    return true;
                case 9:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    b();
                    paramParcel2.writeNoException();
                    return true;
                case 10:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    bool1 = c();
                    paramParcel2.writeNoException();
                    paramInt1 = k;
                    if (bool1) {
                        paramInt1 = 1;
                    }
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 11:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    bool1 = d();
                    paramParcel2.writeNoException();
                    paramInt1 = m;
                    if (bool1) {
                        paramInt1 = 1;
                    }
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 12:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    bool1 = e();
                    paramParcel2.writeNoException();
                    paramInt1 = n;
                    if (bool1) {
                        paramInt1 = 1;
                    }
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 13:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    f();
                    paramParcel2.writeNoException();
                    return true;
                case 14:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    g();
                    paramParcel2.writeNoException();
                    return true;
                case 15:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramInt1 = h();
                    paramParcel2.writeNoException();
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 16:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramInt1 = i();
                    paramParcel2.writeNoException();
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 17:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    a(paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 18:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    b(paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 19:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (paramParcel1.readInt() != 0) {
                        bool1 = true;
                    }
                    b(bool1);
                    paramParcel2.writeNoException();
                    return true;
                case 20:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    c(paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 21:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramInt1 = j();
                    paramParcel2.writeNoException();
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 22:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    d(paramParcel1.readInt());
                    paramParcel2.writeNoException();
                    return true;
                case 23:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    a(paramParcel1.readString());
                    paramParcel2.writeNoException();
                    return true;
                case 24:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    bool1 = bool2;
                    if (paramParcel1.readInt() != 0) {
                        bool1 = true;
                    }
                    c(bool1);
                    paramParcel2.writeNoException();
                    return true;
                case 25:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    bool1 = bool3;
                    if (paramParcel1.readInt() != 0) {
                        bool1 = true;
                    }
                    d(bool1);
                    paramParcel2.writeNoException();
                    return true;
                case 26:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramParcel1 = paramParcel1.readStrongBinder();
                    if (paramParcel1 == null) {
                        paramParcel1 = (Parcel) localObject1;
                    }
                    for (; ; ) {
                        a(paramParcel1);
                        paramParcel2.writeNoException();
                        return true;
                        localObject1 = paramParcel1.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                        if ((localObject1 != null) && ((localObject1 instanceof e))) {
                            paramParcel1 = (e) localObject1;
                        } else {
                            paramParcel1 = new e.a.a(paramParcel1);
                        }
                    }
                case 27:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramParcel1 = paramParcel1.readStrongBinder();
                    if (paramParcel1 == null) {
                        paramParcel1 = (Parcel) localObject2;
                    }
                    for (; ; ) {
                        a(paramParcel1);
                        paramParcel2.writeNoException();
                        return true;
                        localObject1 = paramParcel1.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                        if ((localObject1 != null) && ((localObject1 instanceof h))) {
                            paramParcel1 = (h) localObject1;
                        } else {
                            paramParcel1 = new h.a.a(paramParcel1);
                        }
                    }
                case 28:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramParcel1 = paramParcel1.readStrongBinder();
                    if (paramParcel1 == null) {
                        paramParcel1 = (Parcel) localObject3;
                    }
                    for (; ; ) {
                        a(paramParcel1);
                        paramParcel2.writeNoException();
                        return true;
                        localObject1 = paramParcel1.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                        if ((localObject1 != null) && ((localObject1 instanceof g))) {
                            paramParcel1 = (g) localObject1;
                        } else {
                            paramParcel1 = new g.a.a(paramParcel1);
                        }
                    }
                case 29:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramParcel1 = paramParcel1.readStrongBinder();
                    if (paramParcel1 == null) {
                        paramParcel1 = (Parcel) localObject4;
                    }
                    for (; ; ) {
                        a(paramParcel1);
                        paramParcel2.writeNoException();
                        return true;
                        localObject1 = paramParcel1.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                        if ((localObject1 != null) && ((localObject1 instanceof f))) {
                            paramParcel1 = (f) localObject1;
                        } else {
                            paramParcel1 = new f.a.a(paramParcel1);
                        }
                    }
                case 30:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    k();
                    paramParcel2.writeNoException();
                    return true;
                case 31:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    l();
                    paramParcel2.writeNoException();
                    return true;
                case 32:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localObject1 = localObject6;
                    if (paramParcel1.readInt() != 0) {
                        localObject1 = (Configuration) Configuration.CREATOR.createFromParcel(paramParcel1);
                    }
                    a((Configuration) localObject1);
                    paramParcel2.writeNoException();
                    return true;
                case 33:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    m();
                    paramParcel2.writeNoException();
                    return true;
                case 34:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    n();
                    paramParcel2.writeNoException();
                    return true;
                case 35:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    o();
                    paramParcel2.writeNoException();
                    return true;
                case 36:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    p();
                    paramParcel2.writeNoException();
                    return true;
                case 37:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    bool1 = bool4;
                    if (paramParcel1.readInt() != 0) {
                        bool1 = true;
                    }
                    e(bool1);
                    paramParcel2.writeNoException();
                    return true;
                case 38:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    q();
                    paramParcel2.writeNoException();
                    return true;
                case 39:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramParcel1 = r();
                    paramParcel2.writeNoException();
                    if (paramParcel1 != null) {
                        paramParcel2.writeInt(1);
                        paramParcel1.writeToParcel(paramParcel2, 1);
                        return true;
                    }
                    paramParcel2.writeInt(0);
                    return true;
                case 40:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localObject1 = localObject7;
                    if (paramParcel1.readInt() != 0) {
                        localObject1 = (Bundle) Bundle.CREATOR.createFromParcel(paramParcel1);
                    }
                    bool1 = a((Bundle) localObject1);
                    paramParcel2.writeNoException();
                    paramInt1 = i1;
                    if (bool1) {
                        paramInt1 = 1;
                    }
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 41:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramInt1 = paramParcel1.readInt();
                    localObject1 = localObject8;
                    if (paramParcel1.readInt() != 0) {
                        localObject1 = (KeyEvent) KeyEvent.CREATOR.createFromParcel(paramParcel1);
                    }
                    bool1 = a(paramInt1, (KeyEvent) localObject1);
                    paramParcel2.writeNoException();
                    paramInt1 = i;
                    if (bool1) {
                        paramInt1 = 1;
                    }
                    paramParcel2.writeInt(paramInt1);
                    return true;
                case 42:
                    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    paramInt1 = paramParcel1.readInt();
                    localObject1 = localObject9;
                    if (paramParcel1.readInt() != 0) {
                        localObject1 = (KeyEvent) KeyEvent.CREATOR.createFromParcel(paramParcel1);
                    }
                    bool1 = b(paramInt1, (KeyEvent) localObject1);
                    paramParcel2.writeNoException();
                    paramInt1 = j;
                    if (bool1) {
                        paramInt1 = 1;
                    }
                    paramParcel2.writeInt(paramInt1);
                    return true;
            }
            paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            localObject1 = s();
            paramParcel2.writeNoException();
            paramParcel1 = (Parcel) localObject5;
            if (localObject1 != null) {
                paramParcel1 = ((u) localObject1).asBinder();
            }
            paramParcel2.writeStrongBinder(paramParcel1);
            return true;
        }

        private static final class a
                implements d {
            private IBinder a;

            a(IBinder paramIBinder) {
                this.a = paramIBinder;
            }

            public final void a()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(8, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeInt(paramInt);
                    this.a.transact(17, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            /* Error */
            public final void a(Configuration paramConfiguration)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 28
                //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +42 -> 57
                //   18: aload_2
                //   19: iconst_1
                //   20: invokevirtual 49	android/os/Parcel:writeInt	(I)V
                //   23: aload_1
                //   24: aload_2
                //   25: iconst_0
                //   26: invokevirtual 56	android/content/res/Configuration:writeToParcel	(Landroid/os/Parcel;I)V
                //   29: aload_0
                //   30: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   33: bipush 32
                //   35: aload_2
                //   36: aload_3
                //   37: iconst_0
                //   38: invokeinterface 38 5 0
                //   43: pop
                //   44: aload_3
                //   45: invokevirtual 41	android/os/Parcel:readException	()V
                //   48: aload_3
                //   49: invokevirtual 44	android/os/Parcel:recycle	()V
                //   52: aload_2
                //   53: invokevirtual 44	android/os/Parcel:recycle	()V
                //   56: return
                //   57: aload_2
                //   58: iconst_0
                //   59: invokevirtual 49	android/os/Parcel:writeInt	(I)V
                //   62: goto -33 -> 29
                //   65: astore_1
                //   66: aload_3
                //   67: invokevirtual 44	android/os/Parcel:recycle	()V
                //   70: aload_2
                //   71: invokevirtual 44	android/os/Parcel:recycle	()V
                //   74: aload_1
                //   75: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	76	0	this	a
                //   0	76	1	paramConfiguration	Configuration
                //   3	68	2	localParcel1	Parcel
                //   7	60	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	65	finally
                //   18	29	65	finally
                //   29	48	65	finally
                //   57	62	65	finally
            }

            /* Error */
            public final void a(e parame)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 28
                //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +43 -> 58
                //   18: aload_1
                //   19: invokeinterface 63 1 0
                //   24: astore_1
                //   25: aload_2
                //   26: aload_1
                //   27: invokevirtual 66	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   30: aload_0
                //   31: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   34: bipush 26
                //   36: aload_2
                //   37: aload_3
                //   38: iconst_0
                //   39: invokeinterface 38 5 0
                //   44: pop
                //   45: aload_3
                //   46: invokevirtual 41	android/os/Parcel:readException	()V
                //   49: aload_3
                //   50: invokevirtual 44	android/os/Parcel:recycle	()V
                //   53: aload_2
                //   54: invokevirtual 44	android/os/Parcel:recycle	()V
                //   57: return
                //   58: aconst_null
                //   59: astore_1
                //   60: goto -35 -> 25
                //   63: astore_1
                //   64: aload_3
                //   65: invokevirtual 44	android/os/Parcel:recycle	()V
                //   68: aload_2
                //   69: invokevirtual 44	android/os/Parcel:recycle	()V
                //   72: aload_1
                //   73: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	74	0	this	a
                //   0	74	1	parame	e
                //   3	66	2	localParcel1	Parcel
                //   7	58	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	63	finally
                //   18	25	63	finally
                //   25	49	63	finally
            }

            /* Error */
            public final void a(f paramf)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 28
                //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +43 -> 58
                //   18: aload_1
                //   19: invokeinterface 70 1 0
                //   24: astore_1
                //   25: aload_2
                //   26: aload_1
                //   27: invokevirtual 66	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   30: aload_0
                //   31: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   34: bipush 29
                //   36: aload_2
                //   37: aload_3
                //   38: iconst_0
                //   39: invokeinterface 38 5 0
                //   44: pop
                //   45: aload_3
                //   46: invokevirtual 41	android/os/Parcel:readException	()V
                //   49: aload_3
                //   50: invokevirtual 44	android/os/Parcel:recycle	()V
                //   53: aload_2
                //   54: invokevirtual 44	android/os/Parcel:recycle	()V
                //   57: return
                //   58: aconst_null
                //   59: astore_1
                //   60: goto -35 -> 25
                //   63: astore_1
                //   64: aload_3
                //   65: invokevirtual 44	android/os/Parcel:recycle	()V
                //   68: aload_2
                //   69: invokevirtual 44	android/os/Parcel:recycle	()V
                //   72: aload_1
                //   73: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	74	0	this	a
                //   0	74	1	paramf	f
                //   3	66	2	localParcel1	Parcel
                //   7	58	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	63	finally
                //   18	25	63	finally
                //   25	49	63	finally
            }

            /* Error */
            public final void a(g paramg)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 28
                //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +43 -> 58
                //   18: aload_1
                //   19: invokeinterface 74 1 0
                //   24: astore_1
                //   25: aload_2
                //   26: aload_1
                //   27: invokevirtual 66	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   30: aload_0
                //   31: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   34: bipush 28
                //   36: aload_2
                //   37: aload_3
                //   38: iconst_0
                //   39: invokeinterface 38 5 0
                //   44: pop
                //   45: aload_3
                //   46: invokevirtual 41	android/os/Parcel:readException	()V
                //   49: aload_3
                //   50: invokevirtual 44	android/os/Parcel:recycle	()V
                //   53: aload_2
                //   54: invokevirtual 44	android/os/Parcel:recycle	()V
                //   57: return
                //   58: aconst_null
                //   59: astore_1
                //   60: goto -35 -> 25
                //   63: astore_1
                //   64: aload_3
                //   65: invokevirtual 44	android/os/Parcel:recycle	()V
                //   68: aload_2
                //   69: invokevirtual 44	android/os/Parcel:recycle	()V
                //   72: aload_1
                //   73: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	74	0	this	a
                //   0	74	1	paramg	g
                //   3	66	2	localParcel1	Parcel
                //   7	58	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	63	finally
                //   18	25	63	finally
                //   25	49	63	finally
            }

            /* Error */
            public final void a(h paramh)
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 28
                //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_1
                //   15: ifnull +43 -> 58
                //   18: aload_1
                //   19: invokeinterface 78 1 0
                //   24: astore_1
                //   25: aload_2
                //   26: aload_1
                //   27: invokevirtual 66	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
                //   30: aload_0
                //   31: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   34: bipush 27
                //   36: aload_2
                //   37: aload_3
                //   38: iconst_0
                //   39: invokeinterface 38 5 0
                //   44: pop
                //   45: aload_3
                //   46: invokevirtual 41	android/os/Parcel:readException	()V
                //   49: aload_3
                //   50: invokevirtual 44	android/os/Parcel:recycle	()V
                //   53: aload_2
                //   54: invokevirtual 44	android/os/Parcel:recycle	()V
                //   57: return
                //   58: aconst_null
                //   59: astore_1
                //   60: goto -35 -> 25
                //   63: astore_1
                //   64: aload_3
                //   65: invokevirtual 44	android/os/Parcel:recycle	()V
                //   68: aload_2
                //   69: invokevirtual 44	android/os/Parcel:recycle	()V
                //   72: aload_1
                //   73: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	74	0	this	a
                //   0	74	1	paramh	h
                //   3	66	2	localParcel1	Parcel
                //   7	58	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	14	63	finally
                //   18	25	63	finally
                //   25	49	63	finally
            }

            public final void a(String paramString)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeString(paramString);
                    this.a.transact(23, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(String paramString, int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeString(paramString);
                    localParcel1.writeInt(paramInt);
                    this.a.transact(2, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(String paramString, int paramInt1, int paramInt2)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeString(paramString);
                    localParcel1.writeInt(paramInt1);
                    localParcel1.writeInt(paramInt2);
                    this.a.transact(4, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void a(List<String> paramList, int paramInt1, int paramInt2)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeStringList(paramList);
                    localParcel1.writeInt(paramInt1);
                    localParcel1.writeInt(paramInt2);
                    this.a.transact(6, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            /* Error */
            public final void a(boolean paramBoolean)
                    throws RemoteException {
                // Byte code:
                //   0: iconst_1
                //   1: istore_2
                //   2: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   5: astore_3
                //   6: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   9: astore 4
                //   11: aload_3
                //   12: ldc 28
                //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   17: iload_1
                //   18: ifeq +38 -> 56
                //   21: aload_3
                //   22: iload_2
                //   23: invokevirtual 49	android/os/Parcel:writeInt	(I)V
                //   26: aload_0
                //   27: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   30: iconst_1
                //   31: aload_3
                //   32: aload 4
                //   34: iconst_0
                //   35: invokeinterface 38 5 0
                //   40: pop
                //   41: aload 4
                //   43: invokevirtual 41	android/os/Parcel:readException	()V
                //   46: aload 4
                //   48: invokevirtual 44	android/os/Parcel:recycle	()V
                //   51: aload_3
                //   52: invokevirtual 44	android/os/Parcel:recycle	()V
                //   55: return
                //   56: iconst_0
                //   57: istore_2
                //   58: goto -37 -> 21
                //   61: astore 5
                //   63: aload 4
                //   65: invokevirtual 44	android/os/Parcel:recycle	()V
                //   68: aload_3
                //   69: invokevirtual 44	android/os/Parcel:recycle	()V
                //   72: aload 5
                //   74: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	75	0	this	a
                //   0	75	1	paramBoolean	boolean
                //   1	57	2	i	int
                //   5	64	3	localParcel1	Parcel
                //   9	55	4	localParcel2	Parcel
                //   61	12	5	localObject	Object
                // Exception table:
                //   from	to	target	type
                //   11	17	61	finally
                //   21	46	61	finally
            }

            public final boolean a(int paramInt, KeyEvent paramKeyEvent)
                    throws RemoteException {
                boolean bool = true;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                for (; ; ) {
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        localParcel1.writeInt(paramInt);
                        if (paramKeyEvent != null) {
                            localParcel1.writeInt(1);
                            paramKeyEvent.writeToParcel(localParcel1, 0);
                            this.a.transact(41, localParcel1, localParcel2, 0);
                            localParcel2.readException();
                            paramInt = localParcel2.readInt();
                            if (paramInt != 0) {
                                return bool;
                            }
                        } else {
                            localParcel1.writeInt(0);
                            continue;
                        }
                        bool = false;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }
            }

            public final boolean a(Bundle paramBundle)
                    throws RemoteException {
                boolean bool = true;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                for (; ; ) {
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        if (paramBundle != null) {
                            localParcel1.writeInt(1);
                            paramBundle.writeToParcel(localParcel1, 0);
                            this.a.transact(40, localParcel1, localParcel2, 0);
                            localParcel2.readException();
                            int i = localParcel2.readInt();
                            if (i != 0) {
                                return bool;
                            }
                        } else {
                            localParcel1.writeInt(0);
                            continue;
                        }
                        bool = false;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void b()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(9, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void b(int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeInt(paramInt);
                    this.a.transact(18, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void b(String paramString, int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeString(paramString);
                    localParcel1.writeInt(paramInt);
                    this.a.transact(3, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void b(String paramString, int paramInt1, int paramInt2)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeString(paramString);
                    localParcel1.writeInt(paramInt1);
                    localParcel1.writeInt(paramInt2);
                    this.a.transact(5, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void b(List<String> paramList, int paramInt1, int paramInt2)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeStringList(paramList);
                    localParcel1.writeInt(paramInt1);
                    localParcel1.writeInt(paramInt2);
                    this.a.transact(7, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void b(boolean paramBoolean)
                    throws RemoteException {
                int i = 0;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (paramBoolean) {
                        i = 1;
                    }
                    localParcel1.writeInt(i);
                    this.a.transact(19, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final boolean b(int paramInt, KeyEvent paramKeyEvent)
                    throws RemoteException {
                boolean bool = true;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                for (; ; ) {
                    try {
                        localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                        localParcel1.writeInt(paramInt);
                        if (paramKeyEvent != null) {
                            localParcel1.writeInt(1);
                            paramKeyEvent.writeToParcel(localParcel1, 0);
                            this.a.transact(42, localParcel1, localParcel2, 0);
                            localParcel2.readException();
                            paramInt = localParcel2.readInt();
                            if (paramInt != 0) {
                                return bool;
                            }
                        } else {
                            localParcel1.writeInt(0);
                            continue;
                        }
                        bool = false;
                    } finally {
                        localParcel2.recycle();
                        localParcel1.recycle();
                    }
                }
            }

            public final void c(int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeInt(paramInt);
                    this.a.transact(20, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void c(boolean paramBoolean)
                    throws RemoteException {
                int i = 0;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (paramBoolean) {
                        i = 1;
                    }
                    localParcel1.writeInt(i);
                    this.a.transact(24, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final boolean c()
                    throws RemoteException {
                boolean bool = false;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(10, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = localParcel2.readInt();
                    if (i != 0) {
                        bool = true;
                    }
                    return bool;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void d(int paramInt)
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    localParcel1.writeInt(paramInt);
                    this.a.transact(22, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void d(boolean paramBoolean)
                    throws RemoteException {
                int i = 0;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (paramBoolean) {
                        i = 1;
                    }
                    localParcel1.writeInt(i);
                    this.a.transact(25, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final boolean d()
                    throws RemoteException {
                boolean bool = false;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(11, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = localParcel2.readInt();
                    if (i != 0) {
                        bool = true;
                    }
                    return bool;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void e(boolean paramBoolean)
                    throws RemoteException {
                int i = 0;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (paramBoolean) {
                        i = 1;
                    }
                    localParcel1.writeInt(i);
                    this.a.transact(37, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final boolean e()
                    throws RemoteException {
                boolean bool = false;
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(12, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = localParcel2.readInt();
                    if (i != 0) {
                        bool = true;
                    }
                    return bool;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void f()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(13, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void g()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(14, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final int h()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(15, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = localParcel2.readInt();
                    return i;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final int i()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(16, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = localParcel2.readInt();
                    return i;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final int j()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(21, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    int i = localParcel2.readInt();
                    return i;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void k()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(30, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void l()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(31, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void m()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(33, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void n()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(34, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void o()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(35, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void p()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(36, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            public final void q()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(38, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    return;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }

            /* Error */
            public final Bundle r()
                    throws RemoteException {
                // Byte code:
                //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   3: astore_2
                //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
                //   7: astore_3
                //   8: aload_2
                //   9: ldc 28
                //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
                //   14: aload_0
                //   15: getfield 17	com/google/android/youtube/player/internal/d$a$a:a	Landroid/os/IBinder;
                //   18: bipush 39
                //   20: aload_2
                //   21: aload_3
                //   22: iconst_0
                //   23: invokeinterface 38 5 0
                //   28: pop
                //   29: aload_3
                //   30: invokevirtual 41	android/os/Parcel:readException	()V
                //   33: aload_3
                //   34: invokevirtual 99	android/os/Parcel:readInt	()I
                //   37: ifeq +26 -> 63
                //   40: getstatic 126	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
                //   43: aload_3
                //   44: invokeinterface 132 2 0
                //   49: checkcast 102	android/os/Bundle
                //   52: astore_1
                //   53: aload_3
                //   54: invokevirtual 44	android/os/Parcel:recycle	()V
                //   57: aload_2
                //   58: invokevirtual 44	android/os/Parcel:recycle	()V
                //   61: aload_1
                //   62: areturn
                //   63: aconst_null
                //   64: astore_1
                //   65: goto -12 -> 53
                //   68: astore_1
                //   69: aload_3
                //   70: invokevirtual 44	android/os/Parcel:recycle	()V
                //   73: aload_2
                //   74: invokevirtual 44	android/os/Parcel:recycle	()V
                //   77: aload_1
                //   78: athrow
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	79	0	this	a
                //   52	13	1	localBundle	Bundle
                //   68	10	1	localObject	Object
                //   3	71	2	localParcel1	Parcel
                //   7	63	3	localParcel2	Parcel
                // Exception table:
                //   from	to	target	type
                //   8	53	68	finally
            }

            public final u s()
                    throws RemoteException {
                Parcel localParcel1 = Parcel.obtain();
                Parcel localParcel2 = Parcel.obtain();
                try {
                    localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(43, localParcel1, localParcel2, 0);
                    localParcel2.readException();
                    u localu = u.a.a(localParcel2.readStrongBinder());
                    return localu;
                } finally {
                    localParcel2.recycle();
                    localParcel1.recycle();
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/youtube/player/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */