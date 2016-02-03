package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class hi$a
  extends Binder
  implements hi
{
  public static hi L(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    if ((localIInterface != null) && ((localIInterface instanceof hi))) {
      return (hi)localIInterface;
    }
    return new ou(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    String str1 = null;
    IBinder localIBinder = null;
    String str2 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject1 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.createStringArray();
      str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((hh)localObject1, paramInt1, (String)localObject2, (String)localObject3, (String[])localObject4, str1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject3 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject4 = paramParcel1.readString();
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b((hh)localObject3, paramInt1, (String)localObject4, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject4 = paramParcel1.readString();
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      c((hh)localObject2, paramInt1, (String)localObject4, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      d((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = str1;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      e((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject1 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.createStringArray();
      str1 = paramParcel1.readString();
      localIBinder = paramParcel1.readStrongBinder();
      str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((hh)localObject1, paramInt1, (String)localObject2, (String)localObject3, (String[])localObject4, str1, localIBinder, str2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localIBinder;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      f((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = str2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      g((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      h((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      i((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      j((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      k((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      l((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      m((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject1 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((hh)localObject1, paramInt1, (String)localObject2, (IBinder)localObject3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject1 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.createStringArray();
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((hh)localObject1, paramInt1, (String)localObject2, (String[])localObject3, (String)localObject4, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      b(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      c(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject11;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      n((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      d(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject12;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      o((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      e(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject2 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject3 = paramParcel1.readString();
      localObject1 = localObject13;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      p((hh)localObject2, paramInt1, (String)localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      b(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      localObject1 = hh.a.K(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.createStringArray();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((hh)localObject1, paramInt1, (String)localObject2, (String)localObject3, (String[])localObject4, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 31: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      f(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      g(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      a(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      h(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
    i(hh.a.K(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hi$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */