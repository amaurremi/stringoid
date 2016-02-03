package android.support.v7.media;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class MediaRouteProviderService
  extends Service
{
  static final String CLIENT_DATA_ROUTE_ID = "routeId";
  static final String CLIENT_DATA_VOLUME = "volume";
  static final int CLIENT_MSG_CREATE_ROUTE_CONTROLLER = 3;
  static final int CLIENT_MSG_REGISTER = 1;
  static final int CLIENT_MSG_RELEASE_ROUTE_CONTROLLER = 4;
  static final int CLIENT_MSG_ROUTE_CONTROL_REQUEST = 9;
  static final int CLIENT_MSG_SELECT_ROUTE = 5;
  static final int CLIENT_MSG_SET_DISCOVERY_REQUEST = 10;
  static final int CLIENT_MSG_SET_ROUTE_VOLUME = 7;
  static final int CLIENT_MSG_UNREGISTER = 2;
  static final int CLIENT_MSG_UNSELECT_ROUTE = 6;
  static final int CLIENT_MSG_UPDATE_ROUTE_VOLUME = 8;
  static final int CLIENT_VERSION_1 = 1;
  static final int CLIENT_VERSION_CURRENT = 1;
  private static final boolean DEBUG = Log.isLoggable("MediaRouteProviderSrv", 3);
  private static final int PRIVATE_MSG_CLIENT_DIED = 1;
  static final String SERVICE_DATA_ERROR = "error";
  public static final String SERVICE_INTERFACE = "android.media.MediaRouteProviderService";
  static final int SERVICE_MSG_CONTROL_REQUEST_FAILED = 4;
  static final int SERVICE_MSG_CONTROL_REQUEST_SUCCEEDED = 3;
  static final int SERVICE_MSG_DESCRIPTOR_CHANGED = 5;
  static final int SERVICE_MSG_GENERIC_FAILURE = 0;
  static final int SERVICE_MSG_GENERIC_SUCCESS = 1;
  static final int SERVICE_MSG_REGISTERED = 2;
  static final int SERVICE_VERSION_1 = 1;
  static final int SERVICE_VERSION_CURRENT = 1;
  private static final String TAG = "MediaRouteProviderSrv";
  private final ArrayList<ClientRecord> mClients = new ArrayList();
  private MediaRouteDiscoveryRequest mCompositeDiscoveryRequest;
  private final PrivateHandler mPrivateHandler = new PrivateHandler(null);
  private MediaRouteProvider mProvider;
  private final ProviderCallback mProviderCallback = new ProviderCallback(null);
  private final ReceiveHandler mReceiveHandler = new ReceiveHandler(this);
  private final Messenger mReceiveMessenger = new Messenger(this.mReceiveHandler);
  
  private int findClient(Messenger paramMessenger)
  {
    int j = this.mClients.size();
    int i = 0;
    while (i < j)
    {
      if (((ClientRecord)this.mClients.get(i)).hasMessenger(paramMessenger)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private ClientRecord getClient(Messenger paramMessenger)
  {
    int i = findClient(paramMessenger);
    if (i >= 0) {
      return (ClientRecord)this.mClients.get(i);
    }
    return null;
  }
  
  private static String getClientId(Messenger paramMessenger)
  {
    return "Client connection " + paramMessenger.getBinder().toString();
  }
  
  static boolean isValidRemoteMessenger(Messenger paramMessenger)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessenger != null) {}
    try
    {
      paramMessenger = paramMessenger.getBinder();
      bool1 = bool2;
      if (paramMessenger != null) {
        bool1 = true;
      }
      return bool1;
    }
    catch (NullPointerException paramMessenger) {}
    return false;
  }
  
  private void onBinderDied(Messenger paramMessenger)
  {
    int i = findClient(paramMessenger);
    if (i >= 0)
    {
      paramMessenger = (ClientRecord)this.mClients.remove(i);
      if (DEBUG) {
        Log.d("MediaRouteProviderSrv", paramMessenger + ": Binder died");
      }
      paramMessenger.dispose();
    }
  }
  
  private boolean onCreateRouteController(Messenger paramMessenger, int paramInt1, int paramInt2, String paramString)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if ((localClientRecord != null) && (localClientRecord.createRouteController(paramString, paramInt2)))
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderSrv", localClientRecord + ": Route controller created" + ", controllerId=" + paramInt2 + ", routeId=" + paramString);
      }
      sendGenericSuccess(paramMessenger, paramInt1);
      return true;
    }
    return false;
  }
  
  private boolean onRegisterClient(Messenger paramMessenger, int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 1) && (findClient(paramMessenger) < 0))
    {
      Object localObject = new ClientRecord(paramMessenger, paramInt2);
      if (((ClientRecord)localObject).register())
      {
        this.mClients.add(localObject);
        if (DEBUG) {
          Log.d("MediaRouteProviderSrv", localObject + ": Registered, version=" + paramInt2);
        }
        if (paramInt1 != 0)
        {
          localObject = this.mProvider.getDescriptor();
          if (localObject == null) {
            break label117;
          }
        }
        label117:
        for (localObject = ((MediaRouteProviderDescriptor)localObject).asBundle();; localObject = null)
        {
          sendReply(paramMessenger, 2, paramInt1, 1, localObject, null);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean onReleaseRouteController(Messenger paramMessenger, int paramInt1, int paramInt2)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if ((localClientRecord != null) && (localClientRecord.releaseRouteController(paramInt2)))
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderSrv", localClientRecord + ": Route controller released" + ", controllerId=" + paramInt2);
      }
      sendGenericSuccess(paramMessenger, paramInt1);
      return true;
    }
    return false;
  }
  
  private boolean onRouteControlRequest(final Messenger paramMessenger, final int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    final ClientRecord localClientRecord = getClient(paramMessenger);
    if (localClientRecord != null)
    {
      MediaRouteProvider.RouteController localRouteController = localClientRecord.getRouteController(paramInt2);
      if (localRouteController != null)
      {
        MediaRouter.ControlRequestCallback local1 = null;
        if (paramInt1 != 0) {
          local1 = new MediaRouter.ControlRequestCallback()
          {
            public void onError(String paramAnonymousString, Bundle paramAnonymousBundle)
            {
              if (MediaRouteProviderService.DEBUG) {
                Log.d("MediaRouteProviderSrv", localClientRecord + ": Route control request failed" + ", controllerId=" + paramInt2 + ", intent=" + paramIntent + ", error=" + paramAnonymousString + ", data=" + paramAnonymousBundle);
              }
              if (MediaRouteProviderService.this.findClient(paramMessenger) >= 0)
              {
                if (paramAnonymousString != null)
                {
                  Bundle localBundle = new Bundle();
                  localBundle.putString("error", paramAnonymousString);
                  MediaRouteProviderService.sendReply(paramMessenger, 4, paramInt1, 0, paramAnonymousBundle, localBundle);
                }
              }
              else {
                return;
              }
              MediaRouteProviderService.sendReply(paramMessenger, 4, paramInt1, 0, paramAnonymousBundle, null);
            }
            
            public void onResult(Bundle paramAnonymousBundle)
            {
              if (MediaRouteProviderService.DEBUG) {
                Log.d("MediaRouteProviderSrv", localClientRecord + ": Route control request succeeded" + ", controllerId=" + paramInt2 + ", intent=" + paramIntent + ", data=" + paramAnonymousBundle);
              }
              if (MediaRouteProviderService.this.findClient(paramMessenger) >= 0) {
                MediaRouteProviderService.sendReply(paramMessenger, 3, paramInt1, 0, paramAnonymousBundle, null);
              }
            }
          };
        }
        if (localRouteController.onControlRequest(paramIntent, local1))
        {
          if (DEBUG) {
            Log.d("MediaRouteProviderSrv", localClientRecord + ": Route control request delivered" + ", controllerId=" + paramInt2 + ", intent=" + paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean onSelectRoute(Messenger paramMessenger, int paramInt1, int paramInt2)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if (localClientRecord != null)
    {
      MediaRouteProvider.RouteController localRouteController = localClientRecord.getRouteController(paramInt2);
      if (localRouteController != null)
      {
        localRouteController.onSelect();
        if (DEBUG) {
          Log.d("MediaRouteProviderSrv", localClientRecord + ": Route selected" + ", controllerId=" + paramInt2);
        }
        sendGenericSuccess(paramMessenger, paramInt1);
        return true;
      }
    }
    return false;
  }
  
  private boolean onSetDiscoveryRequest(Messenger paramMessenger, int paramInt, MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if (localClientRecord != null)
    {
      boolean bool = localClientRecord.setDiscoveryRequest(paramMediaRouteDiscoveryRequest);
      if (DEBUG) {
        Log.d("MediaRouteProviderSrv", localClientRecord + ": Set discovery request, request=" + paramMediaRouteDiscoveryRequest + ", actuallyChanged=" + bool + ", compositeDiscoveryRequest=" + this.mCompositeDiscoveryRequest);
      }
      sendGenericSuccess(paramMessenger, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean onSetRouteVolume(Messenger paramMessenger, int paramInt1, int paramInt2, int paramInt3)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if (localClientRecord != null)
    {
      MediaRouteProvider.RouteController localRouteController = localClientRecord.getRouteController(paramInt2);
      if (localRouteController != null)
      {
        localRouteController.onSetVolume(paramInt3);
        if (DEBUG) {
          Log.d("MediaRouteProviderSrv", localClientRecord + ": Route volume changed" + ", controllerId=" + paramInt2 + ", volume=" + paramInt3);
        }
        sendGenericSuccess(paramMessenger, paramInt1);
        return true;
      }
    }
    return false;
  }
  
  private boolean onUnregisterClient(Messenger paramMessenger, int paramInt)
  {
    int i = findClient(paramMessenger);
    if (i >= 0)
    {
      ClientRecord localClientRecord = (ClientRecord)this.mClients.remove(i);
      if (DEBUG) {
        Log.d("MediaRouteProviderSrv", localClientRecord + ": Unregistered");
      }
      localClientRecord.dispose();
      sendGenericSuccess(paramMessenger, paramInt);
      return true;
    }
    return false;
  }
  
  private boolean onUnselectRoute(Messenger paramMessenger, int paramInt1, int paramInt2)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if (localClientRecord != null)
    {
      MediaRouteProvider.RouteController localRouteController = localClientRecord.getRouteController(paramInt2);
      if (localRouteController != null)
      {
        localRouteController.onUnselect();
        if (DEBUG) {
          Log.d("MediaRouteProviderSrv", localClientRecord + ": Route unselected" + ", controllerId=" + paramInt2);
        }
        sendGenericSuccess(paramMessenger, paramInt1);
        return true;
      }
    }
    return false;
  }
  
  private boolean onUpdateRouteVolume(Messenger paramMessenger, int paramInt1, int paramInt2, int paramInt3)
  {
    ClientRecord localClientRecord = getClient(paramMessenger);
    if (localClientRecord != null)
    {
      MediaRouteProvider.RouteController localRouteController = localClientRecord.getRouteController(paramInt2);
      if (localRouteController != null)
      {
        localRouteController.onUpdateVolume(paramInt3);
        if (DEBUG) {
          Log.d("MediaRouteProviderSrv", localClientRecord + ": Route volume updated" + ", controllerId=" + paramInt2 + ", delta=" + paramInt3);
        }
        sendGenericSuccess(paramMessenger, paramInt1);
        return true;
      }
    }
    return false;
  }
  
  private void sendDescriptorChanged(MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
  {
    if (paramMediaRouteProviderDescriptor != null) {}
    for (Bundle localBundle = paramMediaRouteProviderDescriptor.asBundle();; localBundle = null)
    {
      int j = this.mClients.size();
      int i = 0;
      while (i < j)
      {
        ClientRecord localClientRecord = (ClientRecord)this.mClients.get(i);
        sendReply(localClientRecord.mMessenger, 5, 0, 0, localBundle, null);
        if (DEBUG) {
          Log.d("MediaRouteProviderSrv", localClientRecord + ": Sent descriptor change event, descriptor=" + paramMediaRouteProviderDescriptor);
        }
        i += 1;
      }
    }
  }
  
  private static void sendGenericFailure(Messenger paramMessenger, int paramInt)
  {
    if (paramInt != 0) {
      sendReply(paramMessenger, 0, paramInt, 0, null, null);
    }
  }
  
  private static void sendGenericSuccess(Messenger paramMessenger, int paramInt)
  {
    if (paramInt != 0) {
      sendReply(paramMessenger, 1, paramInt, 0, null, null);
    }
  }
  
  private static void sendReply(Messenger paramMessenger, int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    localMessage.setData(paramBundle);
    try
    {
      paramMessenger.send(localMessage);
      return;
    }
    catch (RemoteException paramObject)
    {
      Log.e("MediaRouteProviderSrv", "Could not send message to " + getClientId(paramMessenger), (Throwable)paramObject);
      return;
    }
    catch (DeadObjectException paramMessenger) {}
  }
  
  private boolean updateCompositeDiscoveryRequest()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int j = this.mClients.size();
    int i = 0;
    if (i < j)
    {
      MediaRouteDiscoveryRequest localMediaRouteDiscoveryRequest = ((ClientRecord)this.mClients.get(i)).mDiscoveryRequest;
      boolean bool2 = bool1;
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      if (localMediaRouteDiscoveryRequest != null) {
        if (localMediaRouteDiscoveryRequest.getSelector().isEmpty())
        {
          bool2 = bool1;
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (!localMediaRouteDiscoveryRequest.isActiveScan()) {}
        }
        else
        {
          bool2 = bool1 | localMediaRouteDiscoveryRequest.isActiveScan();
          if (localObject2 != null) {
            break label125;
          }
          localObject4 = localMediaRouteDiscoveryRequest;
          localObject3 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        label125:
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new MediaRouteSelector.Builder(((MediaRouteDiscoveryRequest)localObject2).getSelector());
        }
        ((MediaRouteSelector.Builder)localObject3).addSelector(localMediaRouteDiscoveryRequest.getSelector());
        localObject4 = localObject2;
      }
    }
    if (localObject1 != null) {
      localObject2 = new MediaRouteDiscoveryRequest(((MediaRouteSelector.Builder)localObject1).build(), bool1);
    }
    if ((this.mCompositeDiscoveryRequest != localObject2) && ((this.mCompositeDiscoveryRequest == null) || (!this.mCompositeDiscoveryRequest.equals(localObject2))))
    {
      this.mCompositeDiscoveryRequest = ((MediaRouteDiscoveryRequest)localObject2);
      this.mProvider.setDiscoveryRequest((MediaRouteDiscoveryRequest)localObject2);
      return true;
    }
    return false;
  }
  
  public MediaRouteProvider getMediaRouteProvider()
  {
    return this.mProvider;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.MediaRouteProviderService"))
    {
      if (this.mProvider == null)
      {
        paramIntent = onCreateMediaRouteProvider();
        if (paramIntent != null)
        {
          String str = paramIntent.getMetadata().getPackageName();
          if (!str.equals(getPackageName())) {
            throw new IllegalStateException("onCreateMediaRouteProvider() returned a provider whose package name does not match the package name of the service.  A media route provider service can only export its own media route providers.  Provider package name: " + str + ".  Service package name: " + getPackageName() + ".");
          }
          this.mProvider = paramIntent;
          this.mProvider.setCallback(this.mProviderCallback);
        }
      }
      if (this.mProvider != null) {
        return this.mReceiveMessenger.getBinder();
      }
    }
    return null;
  }
  
  public abstract MediaRouteProvider onCreateMediaRouteProvider();
  
  private final class ClientRecord
    implements IBinder.DeathRecipient
  {
    private final SparseArray<MediaRouteProvider.RouteController> mControllers = new SparseArray();
    public MediaRouteDiscoveryRequest mDiscoveryRequest;
    public final Messenger mMessenger;
    public final int mVersion;
    
    public ClientRecord(Messenger paramMessenger, int paramInt)
    {
      this.mMessenger = paramMessenger;
      this.mVersion = paramInt;
    }
    
    public void binderDied()
    {
      MediaRouteProviderService.this.mPrivateHandler.obtainMessage(1, this.mMessenger).sendToTarget();
    }
    
    public boolean createRouteController(String paramString, int paramInt)
    {
      if (this.mControllers.indexOfKey(paramInt) < 0)
      {
        paramString = MediaRouteProviderService.this.mProvider.onCreateRouteController(paramString);
        if (paramString != null)
        {
          this.mControllers.put(paramInt, paramString);
          return true;
        }
      }
      return false;
    }
    
    public void dispose()
    {
      int j = this.mControllers.size();
      int i = 0;
      while (i < j)
      {
        ((MediaRouteProvider.RouteController)this.mControllers.valueAt(i)).onRelease();
        i += 1;
      }
      this.mControllers.clear();
      this.mMessenger.getBinder().unlinkToDeath(this, 0);
      setDiscoveryRequest(null);
    }
    
    public MediaRouteProvider.RouteController getRouteController(int paramInt)
    {
      return (MediaRouteProvider.RouteController)this.mControllers.get(paramInt);
    }
    
    public boolean hasMessenger(Messenger paramMessenger)
    {
      return this.mMessenger.getBinder() == paramMessenger.getBinder();
    }
    
    public boolean register()
    {
      try
      {
        this.mMessenger.getBinder().linkToDeath(this, 0);
        return true;
      }
      catch (RemoteException localRemoteException)
      {
        binderDied();
      }
      return false;
    }
    
    public boolean releaseRouteController(int paramInt)
    {
      MediaRouteProvider.RouteController localRouteController = (MediaRouteProvider.RouteController)this.mControllers.get(paramInt);
      if (localRouteController != null)
      {
        this.mControllers.remove(paramInt);
        localRouteController.onRelease();
        return true;
      }
      return false;
    }
    
    public boolean setDiscoveryRequest(MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest)
    {
      if ((this.mDiscoveryRequest != paramMediaRouteDiscoveryRequest) && ((this.mDiscoveryRequest == null) || (!this.mDiscoveryRequest.equals(paramMediaRouteDiscoveryRequest))))
      {
        this.mDiscoveryRequest = paramMediaRouteDiscoveryRequest;
        return MediaRouteProviderService.this.updateCompositeDiscoveryRequest();
      }
      return false;
    }
    
    public String toString()
    {
      return MediaRouteProviderService.getClientId(this.mMessenger);
    }
  }
  
  private final class PrivateHandler
    extends Handler
  {
    private PrivateHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      MediaRouteProviderService.this.onBinderDied((Messenger)paramMessage.obj);
    }
  }
  
  private final class ProviderCallback
    extends MediaRouteProvider.Callback
  {
    private ProviderCallback() {}
    
    public void onDescriptorChanged(MediaRouteProvider paramMediaRouteProvider, MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
    {
      MediaRouteProviderService.this.sendDescriptorChanged(paramMediaRouteProviderDescriptor);
    }
  }
  
  private static final class ReceiveHandler
    extends Handler
  {
    private final WeakReference<MediaRouteProviderService> mServiceRef;
    
    public ReceiveHandler(MediaRouteProviderService paramMediaRouteProviderService)
    {
      this.mServiceRef = new WeakReference(paramMediaRouteProviderService);
    }
    
    private boolean processMessage(int paramInt1, Messenger paramMessenger, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      MediaRouteProviderService localMediaRouteProviderService = (MediaRouteProviderService)this.mServiceRef.get();
      if (localMediaRouteProviderService != null) {
        switch (paramInt1)
        {
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                return localMediaRouteProviderService.onRegisterClient(paramMessenger, paramInt2, paramInt3);
                return localMediaRouteProviderService.onUnregisterClient(paramMessenger, paramInt2);
                paramObject = paramBundle.getString("routeId");
              } while (paramObject == null);
              return localMediaRouteProviderService.onCreateRouteController(paramMessenger, paramInt2, paramInt3, (String)paramObject);
              return localMediaRouteProviderService.onReleaseRouteController(paramMessenger, paramInt2, paramInt3);
              return localMediaRouteProviderService.onSelectRoute(paramMessenger, paramInt2, paramInt3);
              return localMediaRouteProviderService.onUnselectRoute(paramMessenger, paramInt2, paramInt3);
              paramInt1 = paramBundle.getInt("volume", -1);
            } while (paramInt1 < 0);
            return localMediaRouteProviderService.onSetRouteVolume(paramMessenger, paramInt2, paramInt3, paramInt1);
            paramInt1 = paramBundle.getInt("volume", 0);
          } while (paramInt1 == 0);
          return localMediaRouteProviderService.onUpdateRouteVolume(paramMessenger, paramInt2, paramInt3, paramInt1);
        } while (!(paramObject instanceof Intent));
        return localMediaRouteProviderService.onRouteControlRequest(paramMessenger, paramInt2, paramInt3, (Intent)paramObject);
      } while ((paramObject != null) && (!(paramObject instanceof Bundle)));
      paramObject = MediaRouteDiscoveryRequest.fromBundle((Bundle)paramObject);
      if ((paramObject != null) && (((MediaRouteDiscoveryRequest)paramObject).isValid())) {}
      for (;;)
      {
        return localMediaRouteProviderService.onSetDiscoveryRequest(paramMessenger, paramInt2, (MediaRouteDiscoveryRequest)paramObject);
        paramObject = null;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      Messenger localMessenger = paramMessage.replyTo;
      if (MediaRouteProviderService.isValidRemoteMessenger(localMessenger))
      {
        i = paramMessage.what;
        j = paramMessage.arg1;
        k = paramMessage.arg2;
        localObject = paramMessage.obj;
        paramMessage = paramMessage.peekData();
        if (!processMessage(i, localMessenger, j, k, localObject, paramMessage))
        {
          if (MediaRouteProviderService.DEBUG) {
            Log.d("MediaRouteProviderSrv", MediaRouteProviderService.getClientId(localMessenger) + ": Message failed, what=" + i + ", requestId=" + j + ", arg=" + k + ", obj=" + localObject + ", data=" + paramMessage);
          }
          MediaRouteProviderService.sendGenericFailure(localMessenger, j);
        }
      }
      while (!MediaRouteProviderService.DEBUG)
      {
        int i;
        int j;
        int k;
        Object localObject;
        return;
      }
      Log.d("MediaRouteProviderSrv", "Ignoring message without valid reply messenger.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaRouteProviderService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */