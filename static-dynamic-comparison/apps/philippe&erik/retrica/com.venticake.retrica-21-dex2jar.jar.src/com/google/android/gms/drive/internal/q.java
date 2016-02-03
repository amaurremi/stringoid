package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class q
  implements aa
{
  private IBinder a;
  
  q(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
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
          this.a.transact(11, localParcel1, localParcel2, 0);
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
          this.a.transact(10, localParcel1, localParcel2, 0);
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
  
  public void a(AddEventListenerRequest paramAddEventListenerRequest, ac paramac, String paramString, ab paramab)
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
          if (paramac != null)
          {
            paramAddEventListenerRequest = paramac.asBinder();
            localParcel1.writeStrongBinder(paramAddEventListenerRequest);
            localParcel1.writeString(paramString);
            paramAddEventListenerRequest = (AddEventListenerRequest)localObject;
            if (paramab != null) {
              paramAddEventListenerRequest = paramab.asBinder();
            }
            localParcel1.writeStrongBinder(paramAddEventListenerRequest);
            this.a.transact(14, localParcel1, localParcel2, 0);
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
  
  public void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, ab paramab)
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
          if (paramab != null)
          {
            paramAuthorizeAccessRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramAuthorizeAccessRequest);
            this.a.transact(12, localParcel1, localParcel2, 0);
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
  
  public void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, ab paramab)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCheckResourceIdsExistRequest != null)
        {
          localParcel1.writeInt(1);
          paramCheckResourceIdsExistRequest.writeToParcel(localParcel1, 0);
          if (paramab != null)
          {
            paramCheckResourceIdsExistRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramCheckResourceIdsExistRequest);
            this.a.transact(30, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCheckResourceIdsExistRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, ab paramab)
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
          if (paramab != null)
          {
            paramCloseContentsAndUpdateMetadataRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramCloseContentsAndUpdateMetadataRequest);
            this.a.transact(18, localParcel1, localParcel2, 0);
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
  
  public void a(CloseContentsRequest paramCloseContentsRequest, ab paramab)
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
          if (paramab != null)
          {
            paramCloseContentsRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramCloseContentsRequest);
            this.a.transact(8, localParcel1, localParcel2, 0);
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
  
  public void a(CreateContentsRequest paramCreateContentsRequest, ab paramab)
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
          if (paramab != null)
          {
            paramCreateContentsRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramCreateContentsRequest);
            this.a.transact(4, localParcel1, localParcel2, 0);
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
  
  public void a(CreateFileRequest paramCreateFileRequest, ab paramab)
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
          if (paramab != null)
          {
            paramCreateFileRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramCreateFileRequest);
            this.a.transact(5, localParcel1, localParcel2, 0);
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
  
  public void a(CreateFolderRequest paramCreateFolderRequest, ab paramab)
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
          if (paramab != null)
          {
            paramCreateFolderRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramCreateFolderRequest);
            this.a.transact(6, localParcel1, localParcel2, 0);
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
  
  public void a(DeleteCustomPropertyRequest paramDeleteCustomPropertyRequest, ab paramab)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramDeleteCustomPropertyRequest != null)
        {
          localParcel1.writeInt(1);
          paramDeleteCustomPropertyRequest.writeToParcel(localParcel1, 0);
          if (paramab != null)
          {
            paramDeleteCustomPropertyRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramDeleteCustomPropertyRequest);
            this.a.transact(26, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramDeleteCustomPropertyRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(DeleteResourceRequest paramDeleteResourceRequest, ab paramab)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramDeleteResourceRequest != null)
        {
          localParcel1.writeInt(1);
          paramDeleteResourceRequest.writeToParcel(localParcel1, 0);
          if (paramab != null)
          {
            paramDeleteResourceRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramDeleteResourceRequest);
            this.a.transact(24, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramDeleteResourceRequest = null;
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
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 130	com/google/android/gms/drive/internal/DisconnectRequest:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/drive/internal/q:a	Landroid/os/IBinder;
    //   33: bipush 16
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 45 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 48	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 67	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 67	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 67	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 67	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	q
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
  
  public void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, ab paramab)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetDriveIdFromUniqueIdentifierRequest != null)
        {
          localParcel1.writeInt(1);
          paramGetDriveIdFromUniqueIdentifierRequest.writeToParcel(localParcel1, 0);
          if (paramab != null)
          {
            paramGetDriveIdFromUniqueIdentifierRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramGetDriveIdFromUniqueIdentifierRequest);
            this.a.transact(29, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGetDriveIdFromUniqueIdentifierRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(GetMetadataRequest paramGetMetadataRequest, ab paramab)
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
          if (paramab != null)
          {
            paramGetMetadataRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramGetMetadataRequest);
            this.a.transact(1, localParcel1, localParcel2, 0);
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
  
  public void a(ListParentsRequest paramListParentsRequest, ab paramab)
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
          if (paramab != null)
          {
            paramListParentsRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramListParentsRequest);
            this.a.transact(13, localParcel1, localParcel2, 0);
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
  
  public void a(LoadRealtimeRequest paramLoadRealtimeRequest, ab paramab)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramLoadRealtimeRequest != null)
        {
          localParcel1.writeInt(1);
          paramLoadRealtimeRequest.writeToParcel(localParcel1, 0);
          if (paramab != null)
          {
            paramLoadRealtimeRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramLoadRealtimeRequest);
            this.a.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramLoadRealtimeRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(OpenContentsRequest paramOpenContentsRequest, ab paramab)
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
          if (paramab != null)
          {
            paramOpenContentsRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramOpenContentsRequest);
            this.a.transact(7, localParcel1, localParcel2, 0);
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
  
  public void a(QueryRequest paramQueryRequest, ab paramab)
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
          if (paramab != null)
          {
            paramQueryRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramQueryRequest);
            this.a.transact(2, localParcel1, localParcel2, 0);
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
  
  public void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, ac paramac, String paramString, ab paramab)
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
          if (paramac != null)
          {
            paramRemoveEventListenerRequest = paramac.asBinder();
            localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
            localParcel1.writeString(paramString);
            paramRemoveEventListenerRequest = (RemoveEventListenerRequest)localObject;
            if (paramab != null) {
              paramRemoveEventListenerRequest = paramab.asBinder();
            }
            localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
            this.a.transact(15, localParcel1, localParcel2, 0);
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
  
  public void a(SetResourceParentsRequest paramSetResourceParentsRequest, ab paramab)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetResourceParentsRequest != null)
        {
          localParcel1.writeInt(1);
          paramSetResourceParentsRequest.writeToParcel(localParcel1, 0);
          if (paramab != null)
          {
            paramSetResourceParentsRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramSetResourceParentsRequest);
            this.a.transact(28, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramSetResourceParentsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void a(TrashResourceRequest paramTrashResourceRequest, ab paramab)
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
          if (paramab != null)
          {
            paramTrashResourceRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramTrashResourceRequest);
            this.a.transact(17, localParcel1, localParcel2, 0);
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
  
  public void a(UpdateMetadataRequest paramUpdateMetadataRequest, ab paramab)
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
          if (paramab != null)
          {
            paramUpdateMetadataRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramUpdateMetadataRequest);
            this.a.transact(3, localParcel1, localParcel2, 0);
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
  public void a(ab paramab)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 90 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/drive/internal/q:a	Landroid/os/IBinder;
    //   34: bipush 9
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	q
    //   0	74	1	paramab	ab
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
    return this.a;
  }
  
  public void b(QueryRequest paramQueryRequest, ab paramab)
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
          if (paramab != null)
          {
            paramQueryRequest = paramab.asBinder();
            localParcel1.writeStrongBinder(paramQueryRequest);
            this.a.transact(19, localParcel1, localParcel2, 0);
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
  
  /* Error */
  public void b(ab paramab)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 90 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/drive/internal/q:a	Landroid/os/IBinder;
    //   34: bipush 20
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	q
    //   0	74	1	paramab	ab
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void c(ab paramab)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 90 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/drive/internal/q:a	Landroid/os/IBinder;
    //   34: bipush 21
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	q
    //   0	74	1	paramab	ab
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void d(ab paramab)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 90 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/drive/internal/q:a	Landroid/os/IBinder;
    //   34: bipush 22
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	q
    //   0	74	1	paramab	ab
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public void e(ab paramab)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 90 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/drive/internal/q:a	Landroid/os/IBinder;
    //   34: bipush 23
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	q
    //   0	74	1	paramab	ab
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */