package mobi.ifunny.l;

import android.os.Looper;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class g {
    private static final String a = g.class.getSimpleName();
    private static volatile g f;
    private final Map<String, h> b = new HashMap();
    private final Map<String, Queue<c>> c = new HashMap();
    private final Map<String, Set<i>> d = new HashMap();
    private final Random e = new Random(System.currentTimeMillis());

    public static String a(h paramh, String paramString) {
        return paramh.L_() + '-' + paramString;
    }

    public static g a() {
        Object localObject = f;
        if (localObject == null) {
            try {
                g localg2 = f;
                localObject = localg2;
                if (localg2 == null) {
                    localObject = new g();
                    f = (g) localObject;
                }
                return (g) localObject;
            } finally {
            }
        }
        return localg1;
    }

    private void a(String paramString, boolean paramBoolean) {
        paramString = (Set) this.d.get(paramString);
        if (paramString != null) {
            paramString = paramString.iterator();
            while (paramString.hasNext()) {
                i locali = (i) paramString.next();
                if (locali != null) {
                    locali.cancel(paramBoolean);
                }
            }
        }
    }

    public static void a(h paramh) {
        if (!Looper.myLooper().equals(Looper.getMainLooper())) {
            throw new IllegalThreadStateException("must be executed on main thread");
        }
        g localg = a();
        if (localg.b.containsValue(paramh)) {
            throw new IllegalStateException("try to register same subscriber second time");
        }
        Object localObject2 = paramh.L_();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence) localObject2)) {
            do {
                localObject1 = Long.toHexString(localg.e.nextLong());
            } while (localg.b.containsKey(localObject1));
            paramh.b_((String) localObject1);
        }
        if (localg.b.containsKey(localObject1)) {
            throw new IllegalArgumentException("subscriber with such id already exist");
        }
        if ((Queue) localg.c.get(localObject1) == null) {
            localObject2 = new LinkedList();
            localg.c.put(localObject1, localObject2);
        }
        localg.b.put(localObject1, paramh);
        paramh.J_();
    }

    private void a(h paramh, String paramString, boolean paramBoolean) {
        if ((paramh == null) || (TextUtils.isEmpty(paramString))) {
            return;
        }
        a(a(paramh, paramString), paramBoolean);
    }

    public static void a(h paramh, boolean paramBoolean) {
        if (!Looper.myLooper().equals(Looper.getMainLooper())) {
            throw new IllegalThreadStateException("must be executed on main thread");
        }
        g localg = a();
        String str = paramh.L_();
        if (!localg.b.containsKey(str)) {
            return;
        }
        localg.b.remove(str);
        if (paramBoolean) {
            localg.c.remove(str);
            localg.b(paramh, true);
        }
        paramh.K_();
    }

    public static void a(h paramh, String... paramVarArgs) {
        if ((paramh == null) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
        }
        for (; ; ) {
            return;
            g localg = a();
            int j = paramVarArgs.length;
            int i = 0;
            while (i < j) {
                localg.a(paramh, paramVarArgs[i], false);
                i += 1;
            }
        }
    }

    public static void a(String... paramVarArgs) {
        if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
        }
        for (; ; ) {
            return;
            g localg = a();
            int j = paramVarArgs.length;
            int i = 0;
            while (i < j) {
                localg.a(paramVarArgs[i], false);
                i += 1;
            }
        }
    }

    public static boolean a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return false;
        }
        g localg = a();
        if (!localg.d.containsKey(paramString)) {
            return false;
        }
        paramString = ((Set) localg.d.get(paramString)).iterator();
        while (paramString.hasNext()) {
            if (!((i) paramString.next()).isCanceled()) {
                return true;
            }
        }
        return false;
    }

    public static void b(h paramh) {
        if (!Looper.myLooper().equals(Looper.getMainLooper())) {
            throw new IllegalThreadStateException("must be executed on main thread");
        }
        Object localObject = a();
        paramh.H_();
        localObject = (Queue) ((g) localObject).c.get(paramh.L_());
        if (localObject != null) {
            int j = ((Queue) localObject).size();
            int i = 0;
            while (i < j) {
                ((c) ((Queue) localObject).poll()).a(paramh);
                i += 1;
            }
        }
    }

    private void b(h paramh, boolean paramBoolean) {
        label4:
        Iterator localIterator;
        if (paramh == null) {
            return;
        } else {
            localIterator = this.d.entrySet().iterator();
        }
        for (; ; ) {
            if (!localIterator.hasNext()) {
                break label4;
            }
            Object localObject = (Set) ((Map.Entry) localIterator.next()).getValue();
            if (localObject == null) {
                break;
            }
            localObject = ((Set) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                i locali = (i) ((Iterator) localObject).next();
                if (TextUtils.equals(paramh.L_(), locali.subscribeId)) {
                    locali.cancel(paramBoolean);
                }
            }
        }
    }

    public static boolean b(h paramh, String paramString) {
        if ((paramh == null) || (TextUtils.isEmpty(paramString))) {
            return false;
        }
        return a(a(paramh, paramString));
    }

    public static void c(h paramh) {
        paramh.M_();
    }

    public void a(c paramc) {
        Object localObject = paramc.a;
        i locali = paramc.b;
        h localh = (h) this.b.get(localObject);
        if (locali.isSilence()) {
            if ((paramc instanceof d)) {
                ((d) paramc).a(localh);
            }
        }
        do {
            return;
            if ((localh != null) && (localh.I_())) {
                paramc.a(localh);
                return;
            }
            localObject = (Queue) this.c.get(localObject);
        } while (localObject == null);
        ((Queue) localObject).offer(paramc);
    }

    void a(i parami) {
        mobi.ifunny.d.c(a, "register " + parami);
        Set localSet = (Set) this.d.get(parami.tag);
        Object localObject = localSet;
        if (localSet == null) {
            localObject = new HashSet();
            this.d.put(parami.tag, localObject);
        }
        ((Set) localObject).add(parami);
    }

    void b(i parami) {
        mobi.ifunny.d.c(a, "unregister " + parami);
        Set localSet = (Set) this.d.get(parami.tag);
        if (localSet == null) {
        }
        do {
            return;
            localSet.remove(parami);
        } while (localSet.size() != 0);
        this.d.remove(parami.tag);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/l/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */