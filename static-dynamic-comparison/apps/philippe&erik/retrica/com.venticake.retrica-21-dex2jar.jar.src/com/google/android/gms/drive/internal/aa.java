package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.IInterface;

public abstract interface aa
  extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest);
  
  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest);
  
  public abstract void a(AddEventListenerRequest paramAddEventListenerRequest, ac paramac, String paramString, ab paramab);
  
  public abstract void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, ab paramab);
  
  public abstract void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, ab paramab);
  
  public abstract void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, ab paramab);
  
  public abstract void a(CloseContentsRequest paramCloseContentsRequest, ab paramab);
  
  public abstract void a(CreateContentsRequest paramCreateContentsRequest, ab paramab);
  
  public abstract void a(CreateFileRequest paramCreateFileRequest, ab paramab);
  
  public abstract void a(CreateFolderRequest paramCreateFolderRequest, ab paramab);
  
  public abstract void a(DeleteCustomPropertyRequest paramDeleteCustomPropertyRequest, ab paramab);
  
  public abstract void a(DeleteResourceRequest paramDeleteResourceRequest, ab paramab);
  
  public abstract void a(DisconnectRequest paramDisconnectRequest);
  
  public abstract void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, ab paramab);
  
  public abstract void a(GetMetadataRequest paramGetMetadataRequest, ab paramab);
  
  public abstract void a(ListParentsRequest paramListParentsRequest, ab paramab);
  
  public abstract void a(LoadRealtimeRequest paramLoadRealtimeRequest, ab paramab);
  
  public abstract void a(OpenContentsRequest paramOpenContentsRequest, ab paramab);
  
  public abstract void a(QueryRequest paramQueryRequest, ab paramab);
  
  public abstract void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, ac paramac, String paramString, ab paramab);
  
  public abstract void a(SetResourceParentsRequest paramSetResourceParentsRequest, ab paramab);
  
  public abstract void a(TrashResourceRequest paramTrashResourceRequest, ab paramab);
  
  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, ab paramab);
  
  public abstract void a(ab paramab);
  
  public abstract void b(QueryRequest paramQueryRequest, ab paramab);
  
  public abstract void b(ab paramab);
  
  public abstract void c(ab paramab);
  
  public abstract void d(ab paramab);
  
  public abstract void e(ab paramab);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */