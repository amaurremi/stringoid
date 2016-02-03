package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cd
        implements ServiceConnection, Handler.Callback {
    private final Context a;
    private final HandlerThread b;
    private final Handler c;
    private final Map<ComponentName, ce> d = new HashMap();
    private Set<String> e = new HashSet();

    public cd(Context paramContext) {
        this.a = paramContext;
        this.b = new HandlerThread("NotificationManagerCompat");
        this.b.start();
        this.c = new Handler(this.b.getLooper(), this);
    }

    private void a() {
        Object localObject1 = bv.b(this.a);
        if (localObject1.equals(this.e)) {
        }
        for (; ; ) {
            return;
            this.e = ((Set) localObject1);
            Object localObject2 = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
            HashSet localHashSet = new HashSet();
            localObject2 = ((List) localObject2).iterator();
            while (((Iterator) localObject2).hasNext()) {
                ResolveInfo localResolveInfo = (ResolveInfo) ((Iterator) localObject2).next();
                if (((Set) localObject1).contains(localResolveInfo.serviceInfo.packageName)) {
                    ComponentName localComponentName = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
                    if (localResolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + localComponentName + ", not adding listener record.");
                    } else {
                        localHashSet.add(localComponentName);
                    }
                }
            }
            localObject1 = localHashSet.iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (ComponentName) ((Iterator) localObject1).next();
                if (!this.d.containsKey(localObject2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + localObject2);
                    }
                    this.d.put(localObject2, new ce((ComponentName) localObject2));
                }
            }
            localObject1 = this.d.entrySet().iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                if (!localHashSet.contains(((Map.Entry) localObject2).getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + ((Map.Entry) localObject2).getKey());
                    }
                    b((ce) ((Map.Entry) localObject2).getValue());
                    ((Iterator) localObject1).remove();
                }
            }
        }
    }

    private void a(ComponentName paramComponentName) {
        paramComponentName = (ce) this.d.get(paramComponentName);
        if (paramComponentName != null) {
            b(paramComponentName);
        }
    }

    private void a(ComponentName paramComponentName, IBinder paramIBinder) {
        paramComponentName = (ce) this.d.get(paramComponentName);
        if (paramComponentName != null) {
            paramComponentName.c = ad.a(paramIBinder);
            paramComponentName.e = 0;
            d(paramComponentName);
        }
    }

    private boolean a(ce paramce) {
        if (paramce.b) {
            return true;
        }
        Intent localIntent = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(paramce.a);
        paramce.b = this.a.bindService(localIntent, this, bv.a());
        if (paramce.b) {
            paramce.e = 0;
        }
        for (; ; ) {
            return paramce.b;
            Log.w("NotifManCompat", "Unable to bind to listener " + paramce.a);
            this.a.unbindService(this);
        }
    }

    private void b(ComponentName paramComponentName) {
        paramComponentName = (ce) this.d.get(paramComponentName);
        if (paramComponentName != null) {
            d(paramComponentName);
        }
    }

    private void b(ce paramce) {
        if (paramce.b) {
            this.a.unbindService(this);
            paramce.b = false;
        }
        paramce.c = null;
    }

    private void b(cf paramcf) {
        a();
        Iterator localIterator = this.d.values().iterator();
        while (localIterator.hasNext()) {
            ce localce = (ce) localIterator.next();
            localce.d.add(paramcf);
            d(localce);
        }
    }

    private void c(ce paramce) {
        if (this.c.hasMessages(3, paramce.a)) {
            return;
        }
        paramce.e += 1;
        if (paramce.e > 6) {
            Log.w("NotifManCompat", "Giving up on delivering " + paramce.d.size() + " tasks to " + paramce.a + " after " + paramce.e + " retries");
            paramce.d.clear();
            return;
        }
        int i = (1 << paramce.e - 1) * 1000;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
        }
        paramce = this.c.obtainMessage(3, paramce.a);
        this.c.sendMessageDelayed(paramce, i);
    }

    private void d(ce paramce) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + paramce.a + ", " + paramce.d.size() + " queued tasks");
        }
        if (paramce.d.isEmpty()) {
        }
        do {
            return;
            if ((!a(paramce)) || (paramce.c == null)) {
                c(paramce);
                return;
            }
            try {
                Object localObject;
                do {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + localObject);
                    }
                    ((cf) localObject).a(paramce.c);
                    paramce.d.remove();
                    localObject = (cf) paramce.d.peek();
                } while (localObject != null);
            } catch (DeadObjectException localDeadObjectException) {
                for (; ; ) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + paramce.a);
                    }
                }
            } catch (RemoteException localRemoteException) {
                for (; ; ) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + paramce.a, localRemoteException);
                }
            }
        } while (paramce.d.isEmpty());
        c(paramce);
    }

    public void a(cf paramcf) {
        this.c.obtainMessage(0, paramcf).sendToTarget();
    }

    public boolean handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                return false;
            case 0:
                b((cf) paramMessage.obj);
                return true;
            case 1:
                paramMessage = (cc) paramMessage.obj;
                a(paramMessage.a, paramMessage.b);
                return true;
            case 2:
                a((ComponentName) paramMessage.obj);
                return true;
        }
        b((ComponentName) paramMessage.obj);
        return true;
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + paramComponentName);
        }
        this.c.obtainMessage(1, new cc(paramComponentName, paramIBinder)).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + paramComponentName);
        }
        this.c.obtainMessage(2, paramComponentName).sendToTarget();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */