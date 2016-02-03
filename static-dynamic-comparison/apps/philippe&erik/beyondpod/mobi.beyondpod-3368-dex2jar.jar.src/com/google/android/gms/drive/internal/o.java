package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface o
  extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
    throws RemoteException;
  
  public abstract void a(CloseContentsRequest paramCloseContentsRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(CreateContentsRequest paramCreateContentsRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(CreateFileRequest paramCreateFileRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(CreateFolderRequest paramCreateFolderRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(GetMetadataRequest paramGetMetadataRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(OpenContentsRequest paramOpenContentsRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(QueryRequest paramQueryRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, p paramp)
    throws RemoteException;
  
  public abstract void a(p paramp)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements o
  {
    public static o C(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
      if ((localIInterface != null) && ((localIInterface instanceof o))) {
        return (o)localIInterface;
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
        a((GetMetadataRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((QueryRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((UpdateMetadataRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CreateContentsRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CreateFileRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CreateFolderRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((OpenContentsRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((CloseContentsRequest)localObject1, p.a.D(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
        a(p.a.D(paramParcel1.readStrongBinder()));
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
      }
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
    }
    
    private static class a
      implements o
    {
      private IBinder dU;
      
      a(IBinder paramIBinder)
      {
        this.dU = paramIBinder;
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
              this.dU.transact(11, localParcel1, localParcel2, 0);
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
              this.dU.transact(10, localParcel1, localParcel2, 0);
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
      
      public void a(CloseContentsRequest paramCloseContentsRequest, p paramp)
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
              if (paramp != null)
              {
                paramCloseContentsRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramCloseContentsRequest);
                this.dU.transact(8, localParcel1, localParcel2, 0);
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
      
      public void a(CreateContentsRequest paramCreateContentsRequest, p paramp)
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
              if (paramp != null)
              {
                paramCreateContentsRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramCreateContentsRequest);
                this.dU.transact(4, localParcel1, localParcel2, 0);
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
      
      public void a(CreateFileRequest paramCreateFileRequest, p paramp)
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
              if (paramp != null)
              {
                paramCreateFileRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramCreateFileRequest);
                this.dU.transact(5, localParcel1, localParcel2, 0);
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
      
      public void a(CreateFolderRequest paramCreateFolderRequest, p paramp)
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
              if (paramp != null)
              {
                paramCreateFolderRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramCreateFolderRequest);
                this.dU.transact(6, localParcel1, localParcel2, 0);
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
      
      public void a(GetMetadataRequest paramGetMetadataRequest, p paramp)
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
              if (paramp != null)
              {
                paramGetMetadataRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramGetMetadataRequest);
                this.dU.transact(1, localParcel1, localParcel2, 0);
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
      
      public void a(OpenContentsRequest paramOpenContentsRequest, p paramp)
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
              if (paramp != null)
              {
                paramOpenContentsRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramOpenContentsRequest);
                this.dU.transact(7, localParcel1, localParcel2, 0);
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
      
      public void a(QueryRequest paramQueryRequest, p paramp)
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
              if (paramp != null)
              {
                paramQueryRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramQueryRequest);
                this.dU.transact(2, localParcel1, localParcel2, 0);
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
      
      public void a(UpdateMetadataRequest paramUpdateMetadataRequest, p paramp)
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
              if (paramp != null)
              {
                paramUpdateMetadataRequest = paramp.asBinder();
                localParcel1.writeStrongBinder(paramUpdateMetadataRequest);
                this.dU.transact(3, localParcel1, localParcel2, 0);
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
      public void a(p paramp)
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
        //   19: invokeinterface 87 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 90	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/drive/internal/o$a$a:dU	Landroid/os/IBinder;
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
        //   0	74	1	paramp	p
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
        return this.dU;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */