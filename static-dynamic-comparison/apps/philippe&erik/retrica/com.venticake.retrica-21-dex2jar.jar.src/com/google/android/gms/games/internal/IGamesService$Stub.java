package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.internal.request.GameRequestClusterCreator;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;

public abstract class IGamesService$Stub
  extends Binder
  implements IGamesService
{
  public IGamesService$Stub()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
  }
  
  public static IGamesService aj(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
    if ((localIInterface != null) && ((localIInterface instanceof IGamesService))) {
      return (IGamesService)localIInterface;
    }
    return new dm(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    String str = null;
    Object localObject2 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    boolean bool8 = false;
    boolean bool3 = false;
    boolean bool5 = false;
    boolean bool9 = false;
    int i = 0;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool4 = false;
    boolean bool14 = false;
    boolean bool15 = false;
    boolean bool16 = false;
    boolean bool17 = false;
    boolean bool18 = false;
    boolean bool19 = false;
    boolean bool20 = false;
    boolean bool21 = false;
    boolean bool22 = false;
    boolean bool23 = false;
    boolean bool24 = false;
    int j = 0;
    boolean bool25 = false;
    boolean bool26 = false;
    boolean bool27 = false;
    boolean bool28 = false;
    boolean bool29 = false;
    boolean bool30 = false;
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.games.internal.IGamesService");
      return true;
    case 5001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      q(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 5002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = ho();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = ef();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((IBinder)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      hw();
      paramParcel2.writeNoException();
      return true;
    case 5007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = gZ();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5064: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = aV(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5065: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      m(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = ha();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hy();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5014: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5015: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        a((IGamesCallbacks)localObject1, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
      }
    case 5016: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 5017: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5018: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5019: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, paramInt2, i, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5020: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        b((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, paramInt2, i, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5021: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        a((IGamesCallbacks)localObject2, (Bundle)localObject1, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 5022: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5023: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((IGamesCallbacks)localObject1, (String)localObject2, (IBinder)localObject3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5024: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        b((IGamesCallbacks)localObject1, (String)localObject2, (IBinder)localObject3, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5025: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject3 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject4 = paramParcel1.readStrongBinder();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a((IGamesCallbacks)localObject2, (String)localObject3, paramInt1, (IBinder)localObject4, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5026: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5027: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      e(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5028: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      n(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5029: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      m(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5058: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 5059: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      r(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 5030: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject3 = paramParcel1.readStrongBinder();
      paramInt1 = paramParcel1.readInt();
      localObject5 = paramParcel1.createStringArray();
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((IGamesCallbacks)localObject2, (IBinder)localObject3, paramInt1, (String[])localObject5, (Bundle)localObject1, bool1, paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
    case 5031: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readStrongBinder();
      localObject3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((IGamesCallbacks)localObject1, (IBinder)localObject2, (String)localObject3, bool1, paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
    case 5032: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5033: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5034: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = b(paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5035: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = aW(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5036: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      ch(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5037: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5038: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5039: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, paramInt1, paramInt2, i, bool1);
      paramParcel2.writeNoException();
      return true;
    case 5040: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      bool1 = bool8;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, paramInt1, paramInt2, i, bool1);
      paramParcel2.writeNoException();
      return true;
    case 5041: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5042: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      e(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5043: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      f(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5044: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label3383;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((IGamesCallbacks)localObject1, paramInt1, paramInt2, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 5045: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label3460;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 5046: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        b((IGamesCallbacks)localObject1, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
      }
    case 5047: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      f(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5048: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool5;
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        c((IGamesCallbacks)localObject1, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
      }
    case 5049: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      g(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5050: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      aX(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5051: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5052: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      g(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5053: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = h(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5060: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = aY(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5054: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      bool1 = bool9;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, (String)localObject2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 5061: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      i(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5055: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      p(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5067: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      bool1 = hz();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5068: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      bool1 = bool10;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      E(bool1);
      paramParcel2.writeNoException();
      return true;
    case 5056: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      h(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5057: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      j(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5062: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      i(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5063: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool11;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((IGamesCallbacks)localObject1, bool1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5066: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = aZ(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5501: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label4220;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        b((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 5502: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hA();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 6001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool12;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      bool1 = bool13;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool6;
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        d((IGamesCallbacks)localObject1, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
      }
    case 6004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool7;
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        e((IGamesCallbacks)localObject1, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
      }
    case 6501: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label4596;
        }
        bool2 = true;
        if (paramParcel1.readInt() == 0) {
          break label4602;
        }
      }
      for (bool3 = true;; bool3 = false)
      {
        if (paramParcel1.readInt() != 0) {
          bool4 = true;
        }
        a((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2, bool3, bool4);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label4547;
      }
    case 6502: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      bool1 = bool14;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b((IGamesCallbacks)localObject1, (String)localObject2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6503: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool15;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b((IGamesCallbacks)localObject1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6504: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      bool1 = bool16;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      c((IGamesCallbacks)localObject1, (String)localObject2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6505: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      bool1 = bool17;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      d((IGamesCallbacks)localObject1, (String)localObject2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6506: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      bool1 = bool18;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, bool1);
      paramParcel2.writeNoException();
      return true;
    case 6507: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        paramParcel1 = h(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 7001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      k(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 7002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 7003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject3 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject4 = paramParcel1.readStrongBinder();
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b((IGamesCallbacks)localObject2, (String)localObject3, paramInt1, (IBinder)localObject4, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 8001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      ba(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      return true;
    case 8004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      localObject3 = paramParcel1.createStringArray();
      localObject1 = str;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a((IGamesCallbacks)localObject2, paramInt1, paramInt2, (String[])localObject3, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 8005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      l(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      m(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readString(), (ParticipantResult[])paramParcel1.createTypedArray(ParticipantResult.CREATOR));
      paramParcel2.writeNoException();
      return true;
    case 8008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray(), (ParticipantResult[])paramParcel1.createTypedArray(ParticipantResult.CREATOR));
      paramParcel2.writeNoException();
      return true;
    case 8009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      n(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8010: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      o(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8011: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 8013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      s(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 8014: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      p(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8024: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = hp();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 8025: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      n(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8015: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8016: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      e(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8017: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      return true;
    case 8026: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8018: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8019: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8020: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8021: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 8022: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      hB();
      paramParcel2.writeNoException();
      return true;
    case 8023: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      bool1 = bool19;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 8027: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool20;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      c((IGamesCallbacks)localObject1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 9001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label5991;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        c((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 9002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      q(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 9003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hd();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = aR(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = he();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hf();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hg();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramParcel1 = a(paramInt1, paramInt2, bool1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramParcel1 = b(paramInt1, paramInt2, bool1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9010: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hl();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9011: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (RoomEntity)RoomEntity.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        paramParcel1 = a((RoomEntity)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hm();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hC();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9031: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject3 = (ParticipantEntity[])paramParcel1.createTypedArray(ParticipantEntity.CREATOR);
      localObject4 = paramParcel1.readString();
      localObject5 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = a((ParticipantEntity[])localObject3, (String)localObject4, (String)localObject5, (Uri)localObject1, (Uri)localObject2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 9019: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = hn();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9020: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label6768;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        d((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 9028: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label6853;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        a((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 9030: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = bb(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 10002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      t(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 10003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 10004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 10005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createStringArray(), paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 10007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 10008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 10009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10010: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10011: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = hr();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10023: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = hs();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10015: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = hq();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10022: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = GameRequestCluster.CREATOR.bk(paramParcel1);
      }
      paramParcel1 = a((GameRequestCluster)localObject1, paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10014: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      q(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10016: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10017: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      bool1 = bool21;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 10021: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = ZInvitationCluster.CREATOR.bi(paramParcel1);
      }
      paramParcel1 = a((ZInvitationCluster)localObject1, paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10018: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      return true;
    case 10019: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      a(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      return true;
    case 10020: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 11001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      j(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      hD();
      paramParcel2.writeNoException();
      return true;
    case 12001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label7831;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        paramParcel1 = a((String)localObject1, bool1, bool2, paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label7837;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
        bool1 = false;
        break;
      }
      paramParcel2.writeInt(0);
      return true;
    case 12002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool22;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      d((IGamesCallbacks)localObject1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      bool1 = bool23;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      c((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      bool1 = bool24;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      e((IGamesCallbacks)localObject1, (String)localObject2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject2 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject3 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = SnapshotMetadataChange.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label8077;
        }
      }
      for (paramParcel1 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((IGamesCallbacks)localObject2, (String)localObject3, (SnapshotMetadataChange)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 12019: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 12020: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      r(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12033: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject4 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject5 = paramParcel1.readString();
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = SnapshotMetadataChange.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        localObject2 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject2 = (Contents)Contents.CREATOR.createFromParcel(paramParcel1);
        }
        a((IGamesCallbacks)localObject4, (String)localObject5, str, (SnapshotMetadataChange)localObject1, (Contents)localObject2);
        paramParcel2.writeNoException();
        return true;
      }
    case 12035: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = ht();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12036: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramInt1 = hu();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      s(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12023: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      b(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 12024: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      c(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 12021: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label8449;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        e((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 12022: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label8526;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        f((IGamesCallbacks)localObject1, (String)localObject2, paramInt1, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        bool1 = false;
        break;
      }
    case 12025: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      bool1 = hE();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12026: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      bool1 = bool25;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      F(bool1);
      paramParcel2.writeNoException();
      return true;
    case 12027: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      t(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12032: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool26;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      e((IGamesCallbacks)localObject1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12016: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool27;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      f((IGamesCallbacks)localObject1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12031: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      bool1 = bool28;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, bool1, paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 12017: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      l(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 12008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      u(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      f(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12010: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.createIntArray();
      paramInt1 = paramParcel1.readInt();
      bool1 = bool29;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, (int[])localObject2, paramInt1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12029: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.createStringArray();
      bool1 = bool30;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((IGamesCallbacks)localObject1, (String[])localObject2, bool1);
      paramParcel2.writeNoException();
      return true;
    case 12015: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.createIntArray();
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, (int[])localObject4, paramInt1, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 12028: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.readString();
      localObject4 = paramParcel1.createStringArray();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, (String[])localObject4, bool1);
        paramParcel2.writeNoException();
        return true;
      }
    case 12011: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 12013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      d(IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder()), paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      u(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 12014: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      d(paramParcel1.readLong(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 12030: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = a(paramParcel1.createIntArray());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 12034: 
      label3383:
      label3460:
      label4220:
      label4547:
      label4596:
      label4602:
      label5991:
      label6768:
      label6853:
      label7831:
      label7837:
      label8077:
      label8449:
      label8526:
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
      paramParcel1 = aU(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesService");
    localObject1 = IGamesCallbacks.Stub.ai(paramParcel1.readStrongBinder());
    localObject2 = paramParcel1.readString();
    localObject3 = paramParcel1.readString();
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0)
    {
      bool1 = true;
      if (paramParcel1.readInt() == 0) {
        break label9358;
      }
    }
    label9358:
    for (bool2 = true;; bool2 = false)
    {
      b((IGamesCallbacks)localObject1, (String)localObject2, (String)localObject3, paramInt1, bool1, bool2);
      paramParcel2.writeNoException();
      return true;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IGamesService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */