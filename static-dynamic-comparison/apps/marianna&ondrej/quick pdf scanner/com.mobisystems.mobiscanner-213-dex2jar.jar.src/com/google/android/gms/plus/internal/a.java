package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;

public abstract interface a
  extends IInterface
{
  public abstract c a(c paramc, int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  public abstract c a(c paramc, int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a am(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        paramParcel1 = a(c.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
      c localc = a(c.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject;
      if (localc != null) {
        paramParcel1 = localc.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    
    private static class a
      implements a
    {
      private IBinder tS;
      
      a(IBinder paramIBinder)
      {
        this.tS = paramIBinder;
      }
      
      /* Error */
      public c a(c paramc, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 28
        //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +84 -> 102
        //   21: aload_1
        //   22: invokeinterface 38 1 0
        //   27: astore_1
        //   28: aload 6
        //   30: aload_1
        //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 6
        //   36: iload_2
        //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   40: aload 6
        //   42: iload_3
        //   43: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   46: aload 6
        //   48: aload 4
        //   50: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   53: aload 6
        //   55: iload 5
        //   57: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   60: aload_0
        //   61: getfield 18	com/google/android/gms/plus/internal/a$a$a:tS	Landroid/os/IBinder;
        //   64: iconst_1
        //   65: aload 6
        //   67: aload 7
        //   69: iconst_0
        //   70: invokeinterface 54 5 0
        //   75: pop
        //   76: aload 7
        //   78: invokevirtual 57	android/os/Parcel:readException	()V
        //   81: aload 7
        //   83: invokevirtual 60	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   86: invokestatic 66	com/google/android/gms/dynamic/c$a:h	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/c;
        //   89: astore_1
        //   90: aload 7
        //   92: invokevirtual 69	android/os/Parcel:recycle	()V
        //   95: aload 6
        //   97: invokevirtual 69	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: areturn
        //   102: aconst_null
        //   103: astore_1
        //   104: goto -76 -> 28
        //   107: astore_1
        //   108: aload 7
        //   110: invokevirtual 69	android/os/Parcel:recycle	()V
        //   113: aload 6
        //   115: invokevirtual 69	android/os/Parcel:recycle	()V
        //   118: aload_1
        //   119: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	this	a
        //   0	120	1	paramc	c
        //   0	120	2	paramInt1	int
        //   0	120	3	paramInt2	int
        //   0	120	4	paramString	String
        //   0	120	5	paramInt3	int
        //   3	111	6	localParcel1	Parcel
        //   8	101	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	107	finally
        //   21	28	107	finally
        //   28	90	107	finally
      }
      
      /* Error */
      public c a(c paramc, int paramInt1, int paramInt2, String paramString1, String paramString2)
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 6
        //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 7
        //   10: aload 6
        //   12: ldc 28
        //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +84 -> 102
        //   21: aload_1
        //   22: invokeinterface 38 1 0
        //   27: astore_1
        //   28: aload 6
        //   30: aload_1
        //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 6
        //   36: iload_2
        //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   40: aload 6
        //   42: iload_3
        //   43: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   46: aload 6
        //   48: aload 4
        //   50: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   53: aload 6
        //   55: aload 5
        //   57: invokevirtual 48	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   60: aload_0
        //   61: getfield 18	com/google/android/gms/plus/internal/a$a$a:tS	Landroid/os/IBinder;
        //   64: iconst_2
        //   65: aload 6
        //   67: aload 7
        //   69: iconst_0
        //   70: invokeinterface 54 5 0
        //   75: pop
        //   76: aload 7
        //   78: invokevirtual 57	android/os/Parcel:readException	()V
        //   81: aload 7
        //   83: invokevirtual 60	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   86: invokestatic 66	com/google/android/gms/dynamic/c$a:h	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/c;
        //   89: astore_1
        //   90: aload 7
        //   92: invokevirtual 69	android/os/Parcel:recycle	()V
        //   95: aload 6
        //   97: invokevirtual 69	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: areturn
        //   102: aconst_null
        //   103: astore_1
        //   104: goto -76 -> 28
        //   107: astore_1
        //   108: aload 7
        //   110: invokevirtual 69	android/os/Parcel:recycle	()V
        //   113: aload 6
        //   115: invokevirtual 69	android/os/Parcel:recycle	()V
        //   118: aload_1
        //   119: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	120	0	this	a
        //   0	120	1	paramc	c
        //   0	120	2	paramInt1	int
        //   0	120	3	paramInt2	int
        //   0	120	4	paramString1	String
        //   0	120	5	paramString2	String
        //   3	111	6	localParcel1	Parcel
        //   8	101	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	107	finally
        //   21	28	107	finally
        //   28	90	107	finally
      }
      
      public IBinder asBinder()
      {
        return this.tS;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/plus/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */