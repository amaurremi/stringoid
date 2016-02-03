package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface u
  extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract void a(AddEventListenerRequest paramAddEventListenerRequest, w paramw, String paramString, v paramv)
    throws RemoteException;
  
  public abstract void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(CloseContentsRequest paramCloseContentsRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(CreateContentsRequest paramCreateContentsRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(CreateFileRequest paramCreateFileRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(CreateFolderRequest paramCreateFolderRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(DisconnectRequest paramDisconnectRequest)
    throws RemoteException;
  
  public abstract void a(GetMetadataRequest paramGetMetadataRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(ListParentsRequest paramListParentsRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(OpenContentsRequest paramOpenContentsRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(QueryRequest paramQueryRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, w paramw, String paramString, v paramv)
    throws RemoteException;
  
  public abstract void a(TrashResourceRequest paramTrashResourceRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, v paramv)
    throws RemoteException;
  
  public abstract void a(v paramv)
    throws RemoteException;
  
  public abstract void b(QueryRequest paramQueryRequest, v paramv)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements u
  {
    public static u G(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
      if ((localIInterface != null) && ((localIInterface instanceof u))) {
        return (u)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
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
        a((GetMetadataRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((QueryRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((UpdateMetadataRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CreateContentsRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CreateFileRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CreateFolderRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((OpenContentsRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CloseContentsRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        a(v.a.H(paramParcel1.readStrongBinder()));
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
        a((AuthorizeAccessRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((ListParentsRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject13;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((AddEventListenerRequest)localObject1, w.a.I(paramParcel1.readStrongBinder()), paramParcel1.readString(), v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject14;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((RemoveEventListenerRequest)localObject1, w.a.I(paramParcel1.readStrongBinder()), paramParcel1.readString(), v.a.H(paramParcel1.readStrongBinder()));
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
        a((TrashResourceRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject17;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CloseContentsAndUpdateMetadataRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject18;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      }
      b((QueryRequest)localObject1, v.a.H(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements u
    {
      private IBinder kn;
      
      a(IBinder paramIBinder)
      {
        this.kn = paramIBinder;
      }
      
      public IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              this.kn.transact(11, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramCreateFileIntentSenderRequest = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return paramCreateFileIntentSenderRequest;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCreateFileIntentSenderRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenFileIntentSenderRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenFileIntentSenderRequest.writeToParcel(localParcel1, 0);
              this.kn.transact(10, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramOpenFileIntentSenderRequest = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
                return paramOpenFileIntentSenderRequest;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramOpenFileIntentSenderRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(AddEventListenerRequest paramAddEventListenerRequest, w paramw, String paramString, v paramv)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAddEventListenerRequest != null)
            {
              localParcel1.writeInt(1);
              paramAddEventListenerRequest.writeToParcel(localParcel1, 0);
              if (paramw != null)
              {
                paramAddEventListenerRequest = paramw.asBinder();
                localParcel1.writeStrongBinder(paramAddEventListenerRequest);
                localParcel1.writeString(paramString);
                paramAddEventListenerRequest = (AddEventListenerRequest)localObject;
                if (paramv != null) {
                  paramAddEventListenerRequest = paramv.asBinder();
                }
                localParcel1.writeStrongBinder(paramAddEventListenerRequest);
                this.kn.transact(14, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAddEventListenerRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramAuthorizeAccessRequest != null)
            {
              localParcel1.writeInt(1);
              paramAuthorizeAccessRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramAuthorizeAccessRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramAuthorizeAccessRequest);
                this.kn.transact(12, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAuthorizeAccessRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsAndUpdateMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsAndUpdateMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramCloseContentsAndUpdateMetadataRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramCloseContentsAndUpdateMetadataRequest);
                this.kn.transact(18, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCloseContentsAndUpdateMetadataRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CloseContentsRequest paramCloseContentsRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCloseContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCloseContentsRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramCloseContentsRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramCloseContentsRequest);
                this.kn.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCloseContentsRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CreateContentsRequest paramCreateContentsRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateContentsRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramCreateContentsRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramCreateContentsRequest);
                this.kn.transact(4, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCreateContentsRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CreateFileRequest paramCreateFileRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFileRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFileRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramCreateFileRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramCreateFileRequest);
                this.kn.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCreateFileRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(CreateFolderRequest paramCreateFolderRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramCreateFolderRequest != null)
            {
              localParcel1.writeInt(1);
              paramCreateFolderRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramCreateFolderRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramCreateFolderRequest);
                this.kn.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCreateFolderRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(DisconnectRequest paramDisconnectRequest)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 124	com/google/android/gms/drive/internal/DisconnectRequest:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/drive/internal/u$a$a:kn	Landroid/os/IBinder;
        //   33: bipush 16
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 50 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 53	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 72	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 72	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 38	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 72	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 72	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramDisconnectRequest	DisconnectRequest
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void a(GetMetadataRequest paramGetMetadataRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramGetMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramGetMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramGetMetadataRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramGetMetadataRequest);
                this.kn.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetMetadataRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(ListParentsRequest paramListParentsRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramListParentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramListParentsRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramListParentsRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramListParentsRequest);
                this.kn.transact(13, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramListParentsRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(OpenContentsRequest paramOpenContentsRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramOpenContentsRequest != null)
            {
              localParcel1.writeInt(1);
              paramOpenContentsRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramOpenContentsRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramOpenContentsRequest);
                this.kn.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramOpenContentsRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(QueryRequest paramQueryRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramQueryRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
                this.kn.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramQueryRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, w paramw, String paramString, v paramv)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramRemoveEventListenerRequest != null)
            {
              localParcel1.writeInt(1);
              paramRemoveEventListenerRequest.writeToParcel(localParcel1, 0);
              if (paramw != null)
              {
                paramRemoveEventListenerRequest = paramw.asBinder();
                localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
                localParcel1.writeString(paramString);
                paramRemoveEventListenerRequest = (RemoveEventListenerRequest)localObject;
                if (paramv != null) {
                  paramRemoveEventListenerRequest = paramv.asBinder();
                }
                localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
                this.kn.transact(15, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramRemoveEventListenerRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(TrashResourceRequest paramTrashResourceRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramTrashResourceRequest != null)
            {
              localParcel1.writeInt(1);
              paramTrashResourceRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramTrashResourceRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramTrashResourceRequest);
                this.kn.transact(17, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramTrashResourceRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(UpdateMetadataRequest paramUpdateMetadataRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramUpdateMetadataRequest != null)
            {
              localParcel1.writeInt(1);
              paramUpdateMetadataRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramUpdateMetadataRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramUpdateMetadataRequest);
                this.kn.transact(3, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramUpdateMetadataRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(v paramv)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 96 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 90	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/internal/u$a$a:kn	Landroid/os/IBinder;
        //   34: bipush 9
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 50 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 53	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 72	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 72	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 72	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 72	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	paramv	v
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public IBinder asBinder()
      {
        return this.kn;
      }
      
      public void b(QueryRequest paramQueryRequest, v paramv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (paramQueryRequest != null)
            {
              localParcel1.writeInt(1);
              paramQueryRequest.writeToParcel(localParcel1, 0);
              if (paramv != null)
              {
                paramQueryRequest = paramv.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
                this.kn.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramQueryRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */