package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] Xp = "gtm.lifetime".toString().split("\\.");
    private static final Pattern Xq = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> Xr;
    private final Map<String, Object> Xs;
    private final ReentrantLock Xt;
    private final LinkedList<Map<String, Object>> Xu;
    private final c Xv;
    private final CountDownLatch Xw;

    DataLayer() {
        this(new c() {
            public void a(DataLayer.c.a paramAnonymousa) {
                paramAnonymousa.a(new ArrayList());
            }

            public void a(List<DataLayer.a> paramAnonymousList, long paramAnonymousLong) {
            }

            public void bx(String paramAnonymousString) {
            }
        });
    }

    DataLayer(c paramc) {
        this.Xv = paramc;
        this.Xr = new ConcurrentHashMap();
        this.Xs = new HashMap();
        this.Xt = new ReentrantLock();
        this.Xu = new LinkedList();
        this.Xw = new CountDownLatch(1);
        ko();
    }

    private void A(Map<String, Object> paramMap) {
        this.Xt.lock();
        try {
            this.Xu.offer(paramMap);
            if (this.Xt.getHoldCount() == 1) {
                kp();
            }
            B(paramMap);
            return;
        } finally {
            this.Xt.unlock();
        }
    }

    private void B(Map<String, Object> paramMap) {
        Long localLong = C(paramMap);
        if (localLong == null) {
            return;
        }
        paramMap = E(paramMap);
        paramMap.remove("gtm.lifetime");
        this.Xv.a(paramMap, localLong.longValue());
    }

    private Long C(Map<String, Object> paramMap) {
        paramMap = D(paramMap);
        if (paramMap == null) {
            return null;
        }
        return bw(paramMap.toString());
    }

    private Object D(Map<String, Object> paramMap) {
        String[] arrayOfString = Xp;
        int j = arrayOfString.length;
        int i = 0;
        for (; ; ) {
            Object localObject = paramMap;
            if (i < j) {
                localObject = arrayOfString[i];
                if (!(paramMap instanceof Map)) {
                    localObject = null;
                }
            } else {
                return localObject;
            }
            paramMap = ((Map) paramMap).get(localObject);
            i += 1;
        }
    }

    private List<a> E(Map<String, Object> paramMap) {
        ArrayList localArrayList = new ArrayList();
        a(paramMap, "", localArrayList);
        return localArrayList;
    }

    private void F(Map<String, Object> paramMap) {
        synchronized (this.Xs) {
            Iterator localIterator = paramMap.keySet().iterator();
            if (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                a(c(str, paramMap.get(str)), this.Xs);
            }
        }
        G(paramMap);
    }

    private void G(Map<String, Object> paramMap) {
        Iterator localIterator = this.Xr.keySet().iterator();
        while (localIterator.hasNext()) {
            ((b) localIterator.next()).y(paramMap);
        }
    }

    private void a(Map<String, Object> paramMap, String paramString, Collection<a> paramCollection) {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder().append(paramString);
            if (paramString.length() == 0) {
            }
            for (paramMap = ""; ; paramMap = ".") {
                paramMap = paramMap + (String) localEntry.getKey();
                if (!(localEntry.getValue() instanceof Map)) {
                    break label119;
                }
                a((Map) localEntry.getValue(), paramMap, paramCollection);
                break;
            }
            label119:
            if (!paramMap.equals("gtm.lifetime")) {
                paramCollection.add(new a(paramMap, localEntry.getValue()));
            }
        }
    }

    static Long bw(String paramString) {
        Object localObject = Xq.matcher(paramString);
        if (!((Matcher) localObject).matches()) {
            bh.x("unknown _lifetime: " + paramString);
            return null;
        }
        long l;
        try {
            l = Long.parseLong(((Matcher) localObject).group(1));
            if (l <= 0L) {
                bh.x("non-positive _lifetime: " + paramString);
                return null;
            }
        } catch (NumberFormatException localNumberFormatException) {
            for (; ; ) {
                bh.z("illegal number in _lifetime value: " + paramString);
                l = 0L;
            }
            localObject = ((Matcher) localObject).group(2);
            if (((String) localObject).length() == 0) {
                return Long.valueOf(l);
            }
            switch (((String) localObject).charAt(0)) {
                default:
                    bh.z("unknown units in _lifetime: " + paramString);
                    return null;
            }
        }
        return Long.valueOf(l * 1000L);
        return Long.valueOf(l * 1000L * 60L);
        return Long.valueOf(l * 1000L * 60L * 60L);
        return Long.valueOf(l * 1000L * 60L * 60L * 24L);
    }

    private void ko() {
        this.Xv.a(new DataLayer.c.a() {
            public void a(List<DataLayer.a> paramAnonymousList) {
                paramAnonymousList = paramAnonymousList.iterator();
                while (paramAnonymousList.hasNext()) {
                    DataLayer.a locala = (DataLayer.a) paramAnonymousList.next();
                    DataLayer.a(DataLayer.this, DataLayer.this.c(locala.Xy, locala.Xz));
                }
                DataLayer.a(DataLayer.this).countDown();
            }
        });
    }

    private void kp() {
        int i = 0;
        for (; ; ) {
            Map localMap = (Map) this.Xu.poll();
            if (localMap != null) {
                F(localMap);
                i += 1;
                if (i > 500) {
                    this.Xu.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else {
                return;
            }
        }
    }

    public static List<Object> listOf(Object... paramVarArgs) {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramVarArgs.length) {
            localArrayList.add(paramVarArgs[i]);
            i += 1;
        }
        return localArrayList;
    }

    public static Map<String, Object> mapOf(Object... paramVarArgs) {
        if (paramVarArgs.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap localHashMap = new HashMap();
        int i = 0;
        while (i < paramVarArgs.length) {
            if (!(paramVarArgs[i] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + paramVarArgs[i]);
            }
            localHashMap.put((String) paramVarArgs[i], paramVarArgs[(i + 1)]);
            i += 2;
        }
        return localHashMap;
    }

    void a(b paramb) {
        this.Xr.put(paramb, Integer.valueOf(0));
    }

    void a(List<Object> paramList1, List<Object> paramList2) {
        while (paramList2.size() < paramList1.size()) {
            paramList2.add(null);
        }
        int i = 0;
        if (i < paramList1.size()) {
            Object localObject = paramList1.get(i);
            if ((localObject instanceof List)) {
                if (!(paramList2.get(i) instanceof List)) {
                    paramList2.set(i, new ArrayList());
                }
                a((List) localObject, (List) paramList2.get(i));
            }
            for (; ; ) {
                i += 1;
                break;
                if ((localObject instanceof Map)) {
                    if (!(paramList2.get(i) instanceof Map)) {
                        paramList2.set(i, new HashMap());
                    }
                    a((Map) localObject, (Map) paramList2.get(i));
                } else if (localObject != OBJECT_NOT_PRESENT) {
                    paramList2.set(i, localObject);
                }
            }
        }
    }

    void a(Map<String, Object> paramMap1, Map<String, Object> paramMap2) {
        Iterator localIterator = paramMap1.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            Object localObject = paramMap1.get(str);
            if ((localObject instanceof List)) {
                if (!(paramMap2.get(str) instanceof List)) {
                    paramMap2.put(str, new ArrayList());
                }
                a((List) localObject, (List) paramMap2.get(str));
            } else if ((localObject instanceof Map)) {
                if (!(paramMap2.get(str) instanceof Map)) {
                    paramMap2.put(str, new HashMap());
                }
                a((Map) localObject, (Map) paramMap2.get(str));
            } else {
                paramMap2.put(str, localObject);
            }
        }
    }

    void bv(String paramString) {
        push(paramString, null);
        this.Xv.bx(paramString);
    }

    Map<String, Object> c(String paramString, Object paramObject) {
        HashMap localHashMap1 = new HashMap();
        String[] arrayOfString = paramString.toString().split("\\.");
        int i = 0;
        HashMap localHashMap2;
        for (paramString = localHashMap1; i < arrayOfString.length - 1; paramString = localHashMap2) {
            localHashMap2 = new HashMap();
            paramString.put(arrayOfString[i], localHashMap2);
            i += 1;
        }
        paramString.put(arrayOfString[(arrayOfString.length - 1)], paramObject);
        return localHashMap1;
    }

    public Object get(String paramString) {
        for (; ; ) {
            int i;
            synchronized (this.Xs) {
                Map localMap1 = this.Xs;
                String[] arrayOfString = paramString.split("\\.");
                int j = arrayOfString.length;
                paramString = localMap1;
                i = 0;
                if (i < j) {
                    localMap1 = arrayOfString[i];
                    if (!(paramString instanceof Map)) {
                        return null;
                    }
                    paramString = ((Map) paramString).get(localMap1);
                    if (paramString == null) {
                        return null;
                    }
                } else {
                    return paramString;
                }
            }
            i += 1;
        }
    }

    public void push(String paramString, Object paramObject) {
        push(c(paramString, paramObject));
    }

    public void push(Map<String, Object> paramMap) {
        try {
            this.Xw.await();
            A(paramMap);
            return;
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
                bh.z("DataLayer.push: unexpected InterruptedException");
            }
        }
    }

    public void pushEvent(String paramString, Map<String, Object> paramMap) {
        paramMap = new HashMap(paramMap);
        paramMap.put("event", paramString);
        push(paramMap);
    }

    static final class a {
        public final String Xy;
        public final Object Xz;

        a(String paramString, Object paramObject) {
            this.Xy = paramString;
            this.Xz = paramObject;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof a)) {
            }
            do {
                return false;
                paramObject = (a) paramObject;
            } while ((!this.Xy.equals(((a) paramObject).Xy)) || (!this.Xz.equals(((a) paramObject).Xz)));
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.Xy.hashCode()), Integer.valueOf(this.Xz.hashCode())});
        }

        public String toString() {
            return "Key: " + this.Xy + " value: " + this.Xz.toString();
        }
    }

    static abstract interface b {
        public abstract void y(Map<String, Object> paramMap);
    }

    static abstract interface c {
        public abstract void a(a parama);

        public abstract void a(List<DataLayer.a> paramList, long paramLong);

        public abstract void bx(String paramString);

        public static abstract interface a {
            public abstract void a(List<DataLayer.a> paramList);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */