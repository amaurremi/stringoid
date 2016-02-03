package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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
import java.util.List;

final class RegisteredMediaRouteProvider
  extends MediaRouteProvider
  implements ServiceConnection
{
  private static final boolean DEBUG = Log.isLoggable("MediaRouteProviderProxy", 3);
  private static final String TAG = "MediaRouteProviderProxy";
  private Connection mActiveConnection;
  private boolean mBound;
  private final ComponentName mComponentName;
  private boolean mConnectionReady;
  private final ArrayList<Controller> mControllers = new ArrayList();
  private final PrivateHandler mPrivateHandler;
  private boolean mStarted;
  
  public RegisteredMediaRouteProvider(Context paramContext, ComponentName paramComponentName)
  {
    super(paramContext, new MediaRouteProvider.ProviderMetadata(paramComponentName.getPackageName()));
    this.mComponentName = paramComponentName;
    this.mPrivateHandler = new PrivateHandler(null);
  }
  
  private void attachControllersToConnection()
  {
    int j = this.mControllers.size();
    int i = 0;
    while (i < j)
    {
      ((Controller)this.mControllers.get(i)).attachConnection(this.mActiveConnection);
      i += 1;
    }
  }
  
  private void bind()
  {
    Intent localIntent;
    if (!this.mBound)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Binding");
      }
      localIntent = new Intent("android.media.MediaRouteProviderService");
      localIntent.setComponent(this.mComponentName);
    }
    try
    {
      this.mBound = getContext().bindService(localIntent, this, 1);
      if ((!this.mBound) && (DEBUG)) {
        Log.d("MediaRouteProviderProxy", this + ": Bind failed");
      }
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (!DEBUG) {}
      Log.d("MediaRouteProviderProxy", this + ": Bind failed", localSecurityException);
    }
  }
  
  private void detachControllersFromConnection()
  {
    int j = this.mControllers.size();
    int i = 0;
    while (i < j)
    {
      ((Controller)this.mControllers.get(i)).detachConnection();
      i += 1;
    }
  }
  
  private void disconnect()
  {
    if (this.mActiveConnection != null)
    {
      setDescriptor(null);
      this.mConnectionReady = false;
      detachControllersFromConnection();
      this.mActiveConnection.dispose();
      this.mActiveConnection = null;
    }
  }
  
  private void onConnectionDescriptorChanged(Connection paramConnection, MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
  {
    if (this.mActiveConnection == paramConnection)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Descriptor changed, descriptor=" + paramMediaRouteProviderDescriptor);
      }
      setDescriptor(paramMediaRouteProviderDescriptor);
    }
  }
  
  private void onConnectionDied(Connection paramConnection)
  {
    if (this.mActiveConnection == paramConnection)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Service connection died");
      }
      disconnect();
    }
  }
  
  private void onConnectionError(Connection paramConnection, String paramString)
  {
    if (this.mActiveConnection == paramConnection)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Service connection error - " + paramString);
      }
      unbind();
    }
  }
  
  private void onConnectionReady(Connection paramConnection)
  {
    if (this.mActiveConnection == paramConnection)
    {
      this.mConnectionReady = true;
      attachControllersToConnection();
      paramConnection = getDiscoveryRequest();
      if (paramConnection != null) {
        this.mActiveConnection.setDiscoveryRequest(paramConnection);
      }
    }
  }
  
  private void onControllerReleased(Controller paramController)
  {
    this.mControllers.remove(paramController);
    paramController.detachConnection();
    updateBinding();
  }
  
  private boolean shouldBind()
  {
    if (this.mStarted)
    {
      if (getDiscoveryRequest() != null) {}
      while (!this.mControllers.isEmpty()) {
        return true;
      }
    }
    return false;
  }
  
  private void unbind()
  {
    if (this.mBound)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Unbinding");
      }
      this.mBound = false;
      disconnect();
      getContext().unbindService(this);
    }
  }
  
  private void updateBinding()
  {
    if (shouldBind())
    {
      bind();
      return;
    }
    unbind();
  }
  
  public boolean hasComponentName(String paramString1, String paramString2)
  {
    return (this.mComponentName.getPackageName().equals(paramString1)) && (this.mComponentName.getClassName().equals(paramString2));
  }
  
  public MediaRouteProvider.RouteController onCreateRouteController(String paramString)
  {
    Object localObject = getDescriptor();
    if (localObject != null)
    {
      localObject = ((MediaRouteProviderDescriptor)localObject).getRoutes();
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        if (((MediaRouteDescriptor)((List)localObject).get(i)).getId().equals(paramString))
        {
          paramString = new Controller(paramString);
          this.mControllers.add(paramString);
          if (this.mConnectionReady) {
            paramString.attachConnection(this.mActiveConnection);
          }
          updateBinding();
          return paramString;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest)
  {
    if (this.mConnectionReady) {
      this.mActiveConnection.setDiscoveryRequest(paramMediaRouteDiscoveryRequest);
    }
    updateBinding();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (DEBUG) {
      Log.d("MediaRouteProviderProxy", this + ": Connected");
    }
    if (this.mBound)
    {
      disconnect();
      if (paramIBinder == null) {
        break label86;
      }
      paramComponentName = new Messenger(paramIBinder);
      if (!MediaRouteProviderService.isValidRemoteMessenger(paramComponentName)) {
        break label124;
      }
      paramComponentName = new Connection(paramComponentName);
      if (!paramComponentName.register()) {
        break label91;
      }
      this.mActiveConnection = paramComponentName;
    }
    label86:
    label91:
    while (!DEBUG)
    {
      return;
      paramComponentName = null;
      break;
    }
    Log.d("MediaRouteProviderProxy", this + ": Registration failed");
    return;
    label124:
    Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (DEBUG) {
      Log.d("MediaRouteProviderProxy", this + ": Service disconnected");
    }
    disconnect();
  }
  
  public void rebindIfDisconnected()
  {
    if ((this.mActiveConnection == null) && (shouldBind()))
    {
      unbind();
      bind();
    }
  }
  
  public void start()
  {
    if (!this.mStarted)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Starting");
      }
      this.mStarted = true;
      updateBinding();
    }
  }
  
  public void stop()
  {
    if (this.mStarted)
    {
      if (DEBUG) {
        Log.d("MediaRouteProviderProxy", this + ": Stopping");
      }
      this.mStarted = false;
      updateBinding();
    }
  }
  
  public String toString()
  {
    return "Service connection " + this.mComponentName.flattenToShortString();
  }
  
  private final class Connection
    implements IBinder.DeathRecipient
  {
    private int mNextControllerId = 1;
    private int mNextRequestId = 1;
    private final SparseArray<MediaRouter.ControlRequestCallback> mPendingCallbacks = new SparseArray();
    private int mPendingRegisterRequestId;
    private final RegisteredMediaRouteProvider.ReceiveHandler mReceiveHandler;
    private final Messenger mReceiveMessenger;
    private final Messenger mServiceMessenger;
    private int mServiceVersion;
    
    public Connection(Messenger paramMessenger)
    {
      this.mServiceMessenger = paramMessenger;
      this.mReceiveHandler = new RegisteredMediaRouteProvider.ReceiveHandler(this);
      this.mReceiveMessenger = new Messenger(this.mReceiveHandler);
    }
    
    private void failPendingCallbacks()
    {
      int i = 0;
      while (i < this.mPendingCallbacks.size())
      {
        ((MediaRouter.ControlRequestCallback)this.mPendingCallbacks.valueAt(i)).onError(null, null);
        i += 1;
      }
      this.mPendingCallbacks.clear();
    }
    
    private boolean sendRequest(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      localMessage.setData(paramBundle);
      localMessage.replyTo = this.mReceiveMessenger;
      try
      {
        this.mServiceMessenger.send(localMessage);
        return true;
      }
      catch (RemoteException paramObject)
      {
        if (paramInt1 != 2) {
          Log.e("MediaRouteProviderProxy", "Could not send message to service.", (Throwable)paramObject);
        }
        return false;
      }
      catch (DeadObjectException paramObject)
      {
        for (;;) {}
      }
    }
    
    public void binderDied()
    {
      RegisteredMediaRouteProvider.this.mPrivateHandler.post(new Runnable()
      {
        public void run()
        {
          RegisteredMediaRouteProvider.this.onConnectionDied(RegisteredMediaRouteProvider.Connection.this);
        }
      });
    }
    
    public int createRouteController(String paramString)
    {
      int i = this.mNextControllerId;
      this.mNextControllerId = (i + 1);
      Bundle localBundle = new Bundle();
      localBundle.putString("routeId", paramString);
      int j = this.mNextRequestId;
      this.mNextRequestId = (j + 1);
      sendRequest(3, j, i, null, localBundle);
      return i;
    }
    
    public void dispose()
    {
      sendRequest(2, 0, 0, null, null);
      this.mReceiveHandler.dispose();
      this.mServiceMessenger.getBinder().unlinkToDeath(this, 0);
      RegisteredMediaRouteProvider.this.mPrivateHandler.post(new Runnable()
      {
        public void run()
        {
          RegisteredMediaRouteProvider.Connection.this.failPendingCallbacks();
        }
      });
    }
    
    public boolean onControlRequestFailed(int paramInt, String paramString, Bundle paramBundle)
    {
      MediaRouter.ControlRequestCallback localControlRequestCallback = (MediaRouter.ControlRequestCallback)this.mPendingCallbacks.get(paramInt);
      if (localControlRequestCallback != null)
      {
        this.mPendingCallbacks.remove(paramInt);
        localControlRequestCallback.onError(paramString, paramBundle);
        return true;
      }
      return false;
    }
    
    public boolean onControlRequestSucceeded(int paramInt, Bundle paramBundle)
    {
      MediaRouter.ControlRequestCallback localControlRequestCallback = (MediaRouter.ControlRequestCallback)this.mPendingCallbacks.get(paramInt);
      if (localControlRequestCallback != null)
      {
        this.mPendingCallbacks.remove(paramInt);
        localControlRequestCallback.onResult(paramBundle);
        return true;
      }
      return false;
    }
    
    public boolean onDescriptorChanged(Bundle paramBundle)
    {
      if (this.mServiceVersion != 0)
      {
        RegisteredMediaRouteProvider.this.onConnectionDescriptorChanged(this, MediaRouteProviderDescriptor.fromBundle(paramBundle));
        return true;
      }
      return false;
    }
    
    public boolean onGenericFailure(int paramInt)
    {
      if (paramInt == this.mPendingRegisterRequestId)
      {
        this.mPendingRegisterRequestId = 0;
        RegisteredMediaRouteProvider.this.onConnectionError(this, "Registation failed");
      }
      MediaRouter.ControlRequestCallback localControlRequestCallback = (MediaRouter.ControlRequestCallback)this.mPendingCallbacks.get(paramInt);
      if (localControlRequestCallback != null)
      {
        this.mPendingCallbacks.remove(paramInt);
        localControlRequestCallback.onError(null, null);
      }
      return true;
    }
    
    public boolean onGenericSuccess(int paramInt)
    {
      return true;
    }
    
    public boolean onRegistered(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if ((this.mServiceVersion == 0) && (paramInt1 == this.mPendingRegisterRequestId) && (paramInt2 >= 1))
      {
        this.mPendingRegisterRequestId = 0;
        this.mServiceVersion = paramInt2;
        RegisteredMediaRouteProvider.this.onConnectionDescriptorChanged(this, MediaRouteProviderDescriptor.fromBundle(paramBundle));
        RegisteredMediaRouteProvider.this.onConnectionReady(this);
        return true;
      }
      return false;
    }
    
    public boolean register()
    {
      int i = this.mNextRequestId;
      this.mNextRequestId = (i + 1);
      this.mPendingRegisterRequestId = i;
      if (!sendRequest(1, this.mPendingRegisterRequestId, 1, null, null)) {
        return false;
      }
      try
      {
        this.mServiceMessenger.getBinder().linkToDeath(this, 0);
        return true;
      }
      catch (RemoteException localRemoteException)
      {
        binderDied();
      }
      return false;
    }
    
    public void releaseRouteController(int paramInt)
    {
      int i = this.mNextRequestId;
      this.mNextRequestId = (i + 1);
      sendRequest(4, i, paramInt, null, null);
    }
    
    public void selectRoute(int paramInt)
    {
      int i = this.mNextRequestId;
      this.mNextRequestId = (i + 1);
      sendRequest(5, i, paramInt, null, null);
    }
    
    public boolean sendControlRequest(int paramInt, Intent paramIntent, MediaRouter.ControlRequestCallback paramControlRequestCallback)
    {
      int i = this.mNextRequestId;
      this.mNextRequestId = (i + 1);
      if (sendRequest(9, i, paramInt, paramIntent, null))
      {
        if (paramControlRequestCallback != null) {
          this.mPendingCallbacks.put(i, paramControlRequestCallback);
        }
        return true;
      }
      return false;
    }
    
    public void setDiscoveryRequest(MediaRouteDiscoveryRequest paramMediaRouteDiscoveryRequest)
    {
      int i = this.mNextRequestId;
      this.mNextRequestId = (i + 1);
      if (paramMediaRouteDiscoveryRequest != null) {}
      for (paramMediaRouteDiscoveryRequest = paramMediaRouteDiscoveryRequest.asBundle();; paramMediaRouteDiscoveryRequest = null)
      {
        sendRequest(10, i, 0, paramMediaRouteDiscoveryRequest, null);
        return;
      }
    }
    
    public void setVolume(int paramInt1, int paramInt2)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("volume", paramInt2);
      paramInt2 = this.mNextRequestId;
      this.mNextRequestId = (paramInt2 + 1);
      sendRequest(7, paramInt2, paramInt1, null, localBundle);
    }
    
    public void unselectRoute(int paramInt)
    {
      int i = this.mNextRequestId;
      this.mNextRequestId = (i + 1);
      sendRequest(6, i, paramInt, null, null);
    }
    
    public void updateVolume(int paramInt1, int paramInt2)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("volume", paramInt2);
      paramInt2 = this.mNextRequestId;
      this.mNextRequestId = (paramInt2 + 1);
      sendRequest(8, paramInt2, paramInt1, null, localBundle);
    }
  }
  
  private final class Controller
    extends MediaRouteProvider.RouteController
  {
    private RegisteredMediaRouteProvider.Connection mConnection;
    private int mControllerId;
    private int mPendingSetVolume = -1;
    private int mPendingUpdateVolumeDelta;
    private final String mRouteId;
    private boolean mSelected;
    
    public Controller(String paramString)
    {
      this.mRouteId = paramString;
    }
    
    public void attachConnection(RegisteredMediaRouteProvider.Connection paramConnection)
    {
      this.mConnection = paramConnection;
      this.mControllerId = paramConnection.createRouteController(this.mRouteId);
      if (this.mSelected)
      {
        paramConnection.selectRoute(this.mControllerId);
        if (this.mPendingSetVolume >= 0)
        {
          paramConnection.setVolume(this.mControllerId, this.mPendingSetVolume);
          this.mPendingSetVolume = -1;
        }
        if (this.mPendingUpdateVolumeDelta != 0)
        {
          paramConnection.updateVolume(this.mControllerId, this.mPendingUpdateVolumeDelta);
          this.mPendingUpdateVolumeDelta = 0;
        }
      }
    }
    
    public void detachConnection()
    {
      if (this.mConnection != null)
      {
        this.mConnection.releaseRouteController(this.mControllerId);
        this.mConnection = null;
        this.mControllerId = 0;
      }
    }
    
    public boolean onControlRequest(Intent paramIntent, MediaRouter.ControlRequestCallback paramControlRequestCallback)
    {
      if (this.mConnection != null) {
        return this.mConnection.sendControlRequest(this.mControllerId, paramIntent, paramControlRequestCallback);
      }
      return false;
    }
    
    public void onRelease()
    {
      RegisteredMediaRouteProvider.this.onControllerReleased(this);
    }
    
    public void onSelect()
    {
      this.mSelected = true;
      if (this.mConnection != null) {
        this.mConnection.selectRoute(this.mControllerId);
      }
    }
    
    public void onSetVolume(int paramInt)
    {
      if (this.mConnection != null)
      {
        this.mConnection.setVolume(this.mControllerId, paramInt);
        return;
      }
      this.mPendingSetVolume = paramInt;
      this.mPendingUpdateVolumeDelta = 0;
    }
    
    public void onUnselect()
    {
      this.mSelected = false;
      if (this.mConnection != null) {
        this.mConnection.unselectRoute(this.mControllerId);
      }
    }
    
    public void onUpdateVolume(int paramInt)
    {
      if (this.mConnection != null)
      {
        this.mConnection.updateVolume(this.mControllerId, paramInt);
        return;
      }
      this.mPendingUpdateVolumeDelta += paramInt;
    }
  }
  
  private final class PrivateHandler
    extends Handler
  {
    private PrivateHandler() {}
  }
  
  private static final class ReceiveHandler
    extends Handler
  {
    private final WeakReference<RegisteredMediaRouteProvider.Connection> mConnectionRef;
    
    public ReceiveHandler(RegisteredMediaRouteProvider.Connection paramConnection)
    {
      this.mConnectionRef = new WeakReference(paramConnection);
    }
    
    private boolean processMessage(RegisteredMediaRouteProvider.Connection paramConnection, int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      switch (paramInt1)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              paramConnection.onGenericFailure(paramInt2);
              return true;
              paramConnection.onGenericSuccess(paramInt2);
              return true;
            } while ((paramObject != null) && (!(paramObject instanceof Bundle)));
            return paramConnection.onRegistered(paramInt2, paramInt3, (Bundle)paramObject);
          } while ((paramObject != null) && (!(paramObject instanceof Bundle)));
          return paramConnection.onDescriptorChanged((Bundle)paramObject);
        } while ((paramObject != null) && (!(paramObject instanceof Bundle)));
        return paramConnection.onControlRequestSucceeded(paramInt2, (Bundle)paramObject);
      } while ((paramObject != null) && (!(paramObject instanceof Bundle)));
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.getString("error")) {
        return paramConnection.onControlRequestFailed(paramInt2, paramBundle, (Bundle)paramObject);
      }
    }
    
    public void dispose()
    {
      this.mConnectionRef.clear();
    }
    
    public void handleMessage(Message paramMessage)
    {
      RegisteredMediaRouteProvider.Connection localConnection = (RegisteredMediaRouteProvider.Connection)this.mConnectionRef.get();
      if ((localConnection != null) && (!processMessage(localConnection, paramMessage.what, paramMessage.arg1, paramMessage.arg2, paramMessage.obj, paramMessage.peekData())) && (RegisteredMediaRouteProvider.DEBUG)) {
        Log.d("MediaRouteProviderProxy", "Unhandled message from server: " + paramMessage);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/RegisteredMediaRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */