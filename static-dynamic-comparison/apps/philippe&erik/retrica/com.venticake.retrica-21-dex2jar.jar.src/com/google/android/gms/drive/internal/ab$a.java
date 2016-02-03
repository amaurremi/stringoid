package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.drive.realtime.internal.m.a;

public abstract class ab$a
  extends Binder
  implements ab
{
  public ab$a()
  {
    attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
  }
  
  public static ab Q(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof ab))) {
      return (ab)localIInterface;
    }
    return new az(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnDownloadProgressResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnListEntriesResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnDriveIdResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnMetadataResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnContentsResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = Status.CREATOR.createFromParcel(paramParcel1);
      }
      o((Status)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      onSuccess();
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnListParentsResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnSyncMoreResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnStorageStatsResponse)OnStorageStatsResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnStorageStatsResponse)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(paramParcel1);
      }
      a((OnLoadRealtimeResponse)localObject1, m.a.ac(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    localObject1 = localObject11;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(paramParcel1);
    }
    a((OnResourceIdSetResponse)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/ab$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */