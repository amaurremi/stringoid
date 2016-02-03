package com.google.android.gms.maps.model.internal;

import android.os.IBinder;

class s
  implements i
{
  private IBinder a;
  
  s(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public com.google.android.gms.maps.model.Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 28
    //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: iload_1
    //   20: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   23: aload 5
    //   25: iload_2
    //   26: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   29: aload 5
    //   31: iload_3
    //   32: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   35: aload_0
    //   36: getfield 15	com/google/android/gms/maps/model/internal/s:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload 5
    //   42: aload 6
    //   44: iconst_0
    //   45: invokeinterface 42 5 0
    //   50: pop
    //   51: aload 6
    //   53: invokevirtual 45	android/os/Parcel:readException	()V
    //   56: aload 6
    //   58: invokevirtual 49	android/os/Parcel:readInt	()I
    //   61: ifeq +26 -> 87
    //   64: getstatic 55	com/google/android/gms/maps/model/Tile:CREATOR	Lcom/google/android/gms/maps/model/TileCreator;
    //   67: aload 6
    //   69: invokevirtual 61	com/google/android/gms/maps/model/TileCreator:createFromParcel	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/Tile;
    //   72: astore 4
    //   74: aload 6
    //   76: invokevirtual 64	android/os/Parcel:recycle	()V
    //   79: aload 5
    //   81: invokevirtual 64	android/os/Parcel:recycle	()V
    //   84: aload 4
    //   86: areturn
    //   87: aconst_null
    //   88: astore 4
    //   90: goto -16 -> 74
    //   93: astore 4
    //   95: aload 6
    //   97: invokevirtual 64	android/os/Parcel:recycle	()V
    //   100: aload 5
    //   102: invokevirtual 64	android/os/Parcel:recycle	()V
    //   105: aload 4
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	s
    //   0	108	1	paramInt1	int
    //   0	108	2	paramInt2	int
    //   0	108	3	paramInt3	int
    //   72	17	4	localTile	com.google.android.gms.maps.model.Tile
    //   93	13	4	localObject	Object
    //   3	98	5	localParcel1	android.os.Parcel
    //   8	88	6	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	74	93	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */