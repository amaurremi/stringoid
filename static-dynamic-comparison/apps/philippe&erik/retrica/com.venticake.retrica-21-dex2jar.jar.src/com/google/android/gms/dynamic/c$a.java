package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class c$a
  extends Binder
  implements c
{
  public c$a()
  {
    attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
  }
  
  public static c af(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new j(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    d locald = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      locald = gI();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject1;
      if (locald != null) {
        paramParcel1 = locald.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      paramParcel1 = getArguments();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      paramInt1 = getId();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      localObject1 = gJ();
      paramParcel2.writeNoException();
      paramParcel1 = locald;
      if (localObject1 != null) {
        paramParcel1 = ((c)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      localObject1 = gK();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject2;
      if (localObject1 != null) {
        paramParcel1 = ((d)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = getRetainInstance();
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      paramParcel1 = getTag();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      localObject1 = gL();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject3;
      if (localObject1 != null) {
        paramParcel1 = ((c)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      paramInt1 = getTargetRequestCode();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = getUserVisibleHint();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      localObject1 = getView();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject4;
      if (localObject1 != null) {
        paramParcel1 = ((d)localObject1).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isAdded();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isDetached();
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isHidden();
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isInLayout();
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isRemoving();
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isResumed();
      paramParcel2.writeNoException();
      paramInt1 = i2;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = isVisible();
      paramParcel2.writeNoException();
      paramInt1 = i3;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      c(d.a.ag(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      setHasOptionsMenu(bool1);
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      setMenuVisibility(bool1);
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = bool3;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      setRetainInstance(bool1);
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      bool1 = bool4;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      setUserVisibleHint(bool1);
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
      }
      startActivity((Intent)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
      }
      startActivityForResult((Intent)localObject1, paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
    d(d.a.ag(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/dynamic/c$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */