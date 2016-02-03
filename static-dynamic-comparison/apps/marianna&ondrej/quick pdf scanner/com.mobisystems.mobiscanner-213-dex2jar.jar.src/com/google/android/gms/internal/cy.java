package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;

public abstract interface cy
  extends IInterface
{
  public abstract c a(c paramc, int paramInt1, int paramInt2);
  
  public static abstract class a
    extends Binder
    implements cy
  {
    public static cy z(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      if ((localIInterface != null) && ((localIInterface instanceof cy))) {
        return (cy)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      paramParcel1 = a(c.a.h(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }
    
    private static class a
      implements cy
    {
      private IBinder tS;
      
      a(IBinder paramIBinder)
      {
        this.tS = paramIBinder;
      }
      
      /* Error */
      public c a(c paramc, int paramInt1, int paramInt2)
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 28
        //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +70 -> 88
        //   21: aload_1
        //   22: invokeinterface 38 1 0
        //   27: astore_1
        //   28: aload 4
        //   30: aload_1
        //   31: invokevirtual 41	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 4
        //   36: iload_2
        //   37: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   40: aload 4
        //   42: iload_3
        //   43: invokevirtual 45	android/os/Parcel:writeInt	(I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/cy$a$a:tS	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 51 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 54	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 57	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   72: invokestatic 63	com/google/android/gms/dynamic/c$a:h	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/c;
        //   75: astore_1
        //   76: aload 5
        //   78: invokevirtual 66	android/os/Parcel:recycle	()V
        //   81: aload 4
        //   83: invokevirtual 66	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: areturn
        //   88: aconst_null
        //   89: astore_1
        //   90: goto -62 -> 28
        //   93: astore_1
        //   94: aload 5
        //   96: invokevirtual 66	android/os/Parcel:recycle	()V
        //   99: aload 4
        //   101: invokevirtual 66	android/os/Parcel:recycle	()V
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	a
        //   0	106	1	paramc	c
        //   0	106	2	paramInt1	int
        //   0	106	3	paramInt2	int
        //   3	97	4	localParcel1	Parcel
        //   8	87	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	93	finally
        //   21	28	93	finally
        //   28	76	93	finally
      }
      
      public IBinder asBinder()
      {
        return this.tS;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */