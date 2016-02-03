package org.OpenUDID;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.util.Log;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class a
        implements ServiceConnection {
    private static String f = null;
    private static boolean g = false;
    private final Context a;
    private List<ResolveInfo> b;
    private Map<String, Integer> c;
    private final SharedPreferences d;
    private final Random e;

    private a(Context paramContext) {
        this.d = paramContext.getSharedPreferences("openudid_prefs", 0);
        this.a = paramContext;
        this.e = new Random();
        this.c = new HashMap();
    }

    public static String a() {
        if (!g) {
            Log.e("OpenUDID", "Initialisation isn't done");
        }
        return f;
    }

    public static void a(Context paramContext) {
        a locala = new a(paramContext);
        f = locala.d.getString("openudid", null);
        if (f == null) {
            locala.b = paramContext.getPackageManager().queryIntentServices(new Intent("org.OpenUDID.GETUDID"), 0);
            Log.d("OpenUDID", locala.b.size() + " services matches OpenUDID");
            if (locala.b != null) {
                locala.e();
            }
            return;
        }
        Log.d("OpenUDID", "OpenUDID: " + f);
        g = true;
    }

    public static boolean b() {
        return g;
    }

    private void c() {
        SharedPreferences.Editor localEditor = this.d.edit();
        localEditor.putString("openudid", f);
        localEditor.commit();
    }

    private void d() {
        Log.d("OpenUDID", "Generating openUDID");
        f = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
        if ((f == null) || (f.equals("9774d56d682e549c")) || (f.length() < 15)) {
            f = new BigInteger(64, new SecureRandom()).toString(16);
        }
    }

    private void e() {
        if (this.b.size() > 0) {
            Log.d("OpenUDID", "Trying service " + ((ResolveInfo) this.b.get(0)).loadLabel(this.a.getPackageManager()));
            ServiceInfo localServiceInfo = ((ResolveInfo) this.b.get(0)).serviceInfo;
            Intent localIntent = new Intent();
            localIntent.setComponent(new ComponentName(localServiceInfo.applicationInfo.packageName, localServiceInfo.name));
            this.b.remove(0);
            try {
                this.a.bindService(localIntent, this, 1);
                return;
            } catch (SecurityException localSecurityException) {
                e();
                return;
            }
        }
        f();
        if (f == null) {
            d();
        }
        Log.d("OpenUDID", "OpenUDID: " + f);
        c();
        g = true;
    }

    private void f() {
        if (!this.c.isEmpty()) {
            TreeMap localTreeMap = new TreeMap(new a(null));
            localTreeMap.putAll(this.c);
            f = (String) localTreeMap.firstKey();
        }
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
        for (; ; ) {
            try {
                paramComponentName = Parcel.obtain();
                paramComponentName.writeInt(this.e.nextInt());
                Parcel localParcel = Parcel.obtain();
                paramIBinder.transact(1, Parcel.obtain(), localParcel, 0);
                if (paramComponentName.readInt() == localParcel.readInt()) {
                    paramComponentName = localParcel.readString();
                    if (paramComponentName != null) {
                        Log.d("OpenUDID", "Received " + paramComponentName);
                        if (!this.c.containsKey(paramComponentName)) {
                            continue;
                        }
                        this.c.put(paramComponentName, Integer.valueOf(((Integer) this.c.get(paramComponentName)).intValue() + 1));
                    }
                }
            } catch (RemoteException paramComponentName) {
                Log.e("OpenUDID", "RemoteException: " + paramComponentName.getMessage());
                continue;
            }
            this.a.unbindService(this);
            e();
            return;
            this.c.put(paramComponentName, Integer.valueOf(1));
        }
    }

    public void onServiceDisconnected(ComponentName paramComponentName) {
    }

    private class a
            implements Comparator {
        private a() {
        }

        public int compare(Object paramObject1, Object paramObject2) {
            if (((Integer) a.a(a.this).get(paramObject1)).intValue() < ((Integer) a.a(a.this).get(paramObject2)).intValue()) {
                return 1;
            }
            if (a.a(a.this).get(paramObject1) == a.a(a.this).get(paramObject2)) {
                return 0;
            }
            return -1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/org/OpenUDID/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */