package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public abstract class ln$a
  extends Binder
  implements ln
{
  public static ln br(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
    if ((localIInterface != null) && ((localIInterface instanceof ln))) {
      return (ln)localIInterface;
    }
    return new qb(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
    d locald = d.a.ag(paramParcel1.readStrongBinder());
    c localc = c.a.af(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0) {}
    for (Object localObject1 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
    {
      localObject1 = a(locald, localc, (WalletFragmentOptions)localObject1, ll.a.bp(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject2;
      if (localObject1 != null) {
        paramParcel1 = ((lk)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ln$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */