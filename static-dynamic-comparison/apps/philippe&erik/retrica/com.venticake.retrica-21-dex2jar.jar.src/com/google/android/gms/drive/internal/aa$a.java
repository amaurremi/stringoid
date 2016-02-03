package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class aa$a
  extends Binder
  implements aa
{
  public static aa P(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
    if ((localIInterface != null) && ((localIInterface instanceof aa))) {
      return (aa)localIInterface;
    }
    return new q(paramIBinder);
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
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    Object localObject17 = null;
    Object localObject18 = null;
    Object localObject19 = null;
    Object localObject20 = null;
    Object localObject21 = null;
    Object localObject22 = null;
    Object localObject23 = null;
    Object localObject24 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((GetMetadataRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((QueryRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((UpdateMetadataRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CreateContentsRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CreateFileRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CreateFolderRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((OpenContentsRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CloseContentsRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      a(ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((OpenFileIntentSenderRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((CreateFileIntentSenderRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject11;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((AuthorizeAccessRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject12;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((ListParentsRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject13;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((AddEventListenerRequest)localObject1, ac.a.R(paramParcel1.readStrongBinder()), paramParcel1.readString(), ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject14;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((RemoveEventListenerRequest)localObject1, ac.a.R(paramParcel1.readStrongBinder()), paramParcel1.readString(), ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject15;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((DisconnectRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject16;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((TrashResourceRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject17;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CloseContentsAndUpdateMetadataRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject18;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      }
      b((QueryRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      b(ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      c(ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      d(ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      e(ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject19;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((DeleteResourceRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject20;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DeleteCustomPropertyRequest)DeleteCustomPropertyRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((DeleteCustomPropertyRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject21;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((LoadRealtimeRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject22;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((SetResourceParentsRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject23;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((GetDriveIdFromUniqueIdentifierRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
    localObject1 = localObject24;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(paramParcel1);
    }
    a((CheckResourceIdsExistRequest)localObject1, ab.a.Q(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/aa$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */