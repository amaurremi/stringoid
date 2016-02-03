package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class n {
    private static final Object f = new Object();
    private static n g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
    private final HashMap<String, ArrayList<q>> c = new HashMap();
    private final ArrayList<p> d = new ArrayList();
    private final Handler e;

    private n(Context paramContext) {
        this.a = paramContext;
        this.e = new o(this, paramContext.getMainLooper());
    }

    public static n a(Context paramContext) {
        synchronized (f) {
            if (g == null) {
                g = new n(paramContext.getApplicationContext());
            }
            paramContext = g;
            return paramContext;
        }
    }

    private void a() {
        for (; ; ) {
            int i;
            synchronized (this.b) {
                i = this.d.size();
                if (i <= 0) {
                    return;
                }
                p[] arrayOfp = new p[i];
                this.d.toArray(arrayOfp);
                this.d.clear();
                i = 0;
                if (i >= arrayOfp.length) {
                    continue;
                }
                ???=arrayOfp[i];
                int j = 0;
                if (j < ???.b.size())
                {
                    ((q) ? ??.b.get(j)).b.onReceive(this.a, ???.a);
                    j += 1;
                }
            }
            i += 1;
        }
    }

    public void a(BroadcastReceiver paramBroadcastReceiver) {
        for (; ; ) {
            int k;
            int i;
            synchronized (this.b) {
                ArrayList localArrayList1 = (ArrayList) this.b.remove(paramBroadcastReceiver);
                if (localArrayList1 != null) {
                    break label167;
                }
                return;
                if (j < localArrayList1.size()) {
                    IntentFilter localIntentFilter = (IntentFilter) localArrayList1.get(j);
                    k = 0;
                    if (k >= localIntentFilter.countActions()) {
                        break label188;
                    }
                    String str = localIntentFilter.getAction(k);
                    ArrayList localArrayList2 = (ArrayList) this.c.get(str);
                    if (localArrayList2 == null) {
                        break label179;
                    }
                    i = 0;
                    if (i < localArrayList2.size()) {
                        if (((q) localArrayList2.get(i)).b == paramBroadcastReceiver) {
                            localArrayList2.remove(i);
                            i -= 1;
                            break label172;
                        }
                    } else {
                        if (localArrayList2.size() > 0) {
                            break label179;
                        }
                        this.c.remove(str);
                        break label179;
                    }
                } else {
                    return;
                }
            }
            break label172;
            label167:
            int j = 0;
            continue;
            label172:
            i += 1;
            continue;
            label179:
            k += 1;
            continue;
            label188:
            j += 1;
        }
    }

    public void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
        synchronized (this.b) {
            q localq = new q(paramIntentFilter, paramBroadcastReceiver);
            Object localObject2 = (ArrayList) this.b.get(paramBroadcastReceiver);
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = new ArrayList(1);
                this.b.put(paramBroadcastReceiver, localObject1);
            }
            ((ArrayList) localObject1).add(paramIntentFilter);
            int i = 0;
            while (i < paramIntentFilter.countActions()) {
                localObject2 = paramIntentFilter.getAction(i);
                localObject1 = (ArrayList) this.c.get(localObject2);
                paramBroadcastReceiver = (BroadcastReceiver) localObject1;
                if (localObject1 == null) {
                    paramBroadcastReceiver = new ArrayList(1);
                    this.c.put(localObject2, paramBroadcastReceiver);
                }
                paramBroadcastReceiver.add(localq);
                i += 1;
            }
            return;
        }
    }

    public boolean a(Intent paramIntent) {
        int i;
        label161:
        int j;
        Object localObject;
        int k;
        ArrayList localArrayList1;
        synchronized (this.b) {
            String str1 = paramIntent.getAction();
            String str2 = paramIntent.resolveTypeIfNeeded(this.a.getContentResolver());
            Uri localUri = paramIntent.getData();
            String str3 = paramIntent.getScheme();
            Set localSet = paramIntent.getCategories();
            if ((paramIntent.getFlags() & 0x8) == 0) {
                break label500;
            }
            i = 1;
            if (i != 0) {
                Log.v("LocalBroadcastManager", "Resolving type " + str2 + " scheme " + str3 + " of intent " + paramIntent);
            }
            ArrayList localArrayList2 = (ArrayList) this.c.get(paramIntent.getAction());
            if (localArrayList2 == null) {
                break label477;
            }
            if (i == 0) {
                break label485;
            }
            Log.v("LocalBroadcastManager", "Action list: " + localArrayList2);
            break label485;
            if (j >= localArrayList2.size()) {
                break label536;
            }
            localObject = (q) localArrayList2.get(j);
            if (i != 0) {
                Log.v("LocalBroadcastManager", "Matching against filter " + ((q) localObject).a);
            }
            if (((q) localObject).c) {
                if (i == 0) {
                    break label505;
                }
                Log.v("LocalBroadcastManager", "  Filter's target already added");
            } else {
                k = ((q) localObject).a.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
                if (k >= 0) {
                    if (i != 0) {
                        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(k));
                    }
                    if (localArrayList1 != null) {
                        break label482;
                    }
                    localArrayList1 = new ArrayList();
                    label311:
                    localArrayList1.add(localObject);
                    ((q) localObject).c = true;
                }
            }
        }
        if (i != 0) {
            switch (k) {
                default:
                    localObject = "unknown reason";
                    label376:
                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (String) localObject);
                    break;
            }
        }
        for (; ; ) {
            if (i < localArrayList1.size()) {
                ((q) localArrayList1.get(i)).c = false;
                i += 1;
            } else {
                this.d.add(new p(paramIntent, localArrayList1));
                if (!this.e.hasMessages(1)) {
                    this.e.sendEmptyMessage(1);
                }
                return true;
                label477:
                label482:
                label485:
                label500:
                label505:
                label536:
                do {
                    return false;
                    break label311;
                    localArrayList1 = null;
                    j = 0;
                    break label161;
                    for (; ; ) {
                        j += 1;
                        break label161;
                        i = 0;
                        break;
                    }
                    localObject = "action";
                    break label376;
                    localObject = "category";
                    break label376;
                    localObject = "data";
                    break label376;
                    localObject = "type";
                    break label376;
                } while (localArrayList1 == null);
                i = 0;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */