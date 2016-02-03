package mobi.ifunny.b;

import com.google.gson.Gson;

import java.util.LinkedList;

import mobi.ifunny.l.h;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Stats;

public class c {
    public static final String a = c.class.getSimpleName();
    private static c b = new c();
    private static long d;
    private long c = 120000L;
    private final LinkedList<d> e;

    private c() {
        d = System.currentTimeMillis();
        this.e = new LinkedList();
    }

    public static void a(long paramLong) {
        b.c = (1000L * paramLong);
    }

    private static void a(h paramh) {
        try {
            if (b.e.size() > 0) {
                d = System.currentTimeMillis();
                String str = new Gson().toJson(b.e.toArray());
                IFunnyRestRequest.Stats.collectStats(paramh, "rest.collectStats", str, null);
                mobi.ifunny.d.b(a, String.format("Sending json: %s", new Object[]{str}));
            }
            b.e.clear();
            return;
        } catch (Exception paramh) {
            for (; ; ) {
                mobi.ifunny.d.b(a, "Unable to send stats");
                paramh.printStackTrace();
            }
        }
    }

    public static void a(h paramh, String paramString1, String paramString2) {
        a(paramh, paramString1, paramString2, null, null);
    }

    public static void a(h paramh, String paramString1, String paramString2, String paramString3) {
        a(paramh, paramString1, paramString2, paramString3, null);
    }

    public static void a(h paramh, String paramString1, String paramString2, String paramString3, Long paramLong) {
        b.e.add(new d(paramString1, paramString2, paramString3, paramLong));
        mobi.ifunny.d.b(a, String.format("Adding event: %s - %s - %s - %s", new Object[]{paramString1, paramString2, paramString3, paramLong}));
        if (System.currentTimeMillis() - d >= b.c) {
            mobi.ifunny.d.b(a, String.format("Sending %d event(s)", new Object[]{Integer.valueOf(b.e.size())}));
            a(paramh);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */