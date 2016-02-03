package com.a.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.WeakHashMap;

class c
        extends Handler
        implements Comparator<a> {
    private static WeakHashMap<Activity, c> a;
    private static g b;
    private final Queue<a> c = new PriorityQueue(1, this);
    private final Queue<a> d = new LinkedList();

    static int a(int paramInt1, int paramInt2) {
        if (paramInt1 < paramInt2) {
            return 1;
        }
        if (paramInt1 == paramInt2) {
            return 0;
        }
        return -1;
    }

    static c a(Activity paramActivity) {
        try {
            if (a == null) {
                a = new WeakHashMap(1);
            }
            c localc2 = (c) a.get(paramActivity);
            c localc1 = localc2;
            if (localc2 == null) {
                localc1 = new c();
                b(paramActivity);
                a.put(paramActivity, localc1);
            }
            return localc1;
        } finally {
        }
    }

    static void a(Collection<a> paramCollection1, Collection<a> paramCollection2) {
        paramCollection1 = paramCollection1.iterator();
        while (paramCollection1.hasNext()) {
            a locala = (a) paramCollection1.next();
            if (locala.b()) {
                paramCollection2.add(locala);
            }
        }
    }

    static void b(Activity paramActivity) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        if (b == null) {
            b = new h();
        }
        b.a(paramActivity.getApplication());
    }

    private void c() {
        if (this.c.isEmpty()) {
        }
        a locala;
        do {
            return;
            locala = (a) this.c.peek();
            if (!locala.b()) {
                Message localMessage = obtainMessage(-1040157475);
                localMessage.obj = locala;
                sendMessage(localMessage);
                return;
            }
        } while (locala.f() == -1);
        sendMessageDelayed(obtainMessage(794631), locala.f() + locala.d.getDuration() + locala.e.getDuration());
    }

    static void c(Activity paramActivity) {
        try {
            if (a != null) {
                paramActivity = (c) a.remove(paramActivity);
                if (paramActivity != null) {
                    paramActivity.a();
                }
            }
            return;
        } finally {
        }
    }

    private void c(a parama) {
        b(parama);
        View localView = parama.e();
        if ((ViewGroup) localView.getParent() != null) {
            parama.e.setAnimationListener(new e(parama, null));
            localView.clearAnimation();
            localView.startAnimation(parama.e);
        }
        sendMessage(obtainMessage(794631));
    }

    private void d(a parama) {
        Object localObject = parama.e();
        ViewGroup.LayoutParams localLayoutParams;
        if (((View) localObject).getParent() == null) {
            ViewGroup localViewGroup = parama.i();
            localLayoutParams = parama.g();
            if (localViewGroup == null) {
                break label92;
            }
            localViewGroup.addView((View) localObject, localLayoutParams);
        }
        for (; ; ) {
            ((View) localObject).clearAnimation();
            ((View) localObject).startAnimation(parama.d);
            if (((View) localObject).getVisibility() != 0) {
                ((View) localObject).setVisibility(0);
            }
            int i = parama.f();
            if (i == -1) {
                break;
            }
            localObject = obtainMessage(-1040155167);
            ((Message) localObject).obj = parama;
            sendMessageDelayed((Message) localObject, i);
            return;
            label92:
            parama.d().addContentView((View) localObject, localLayoutParams);
        }
        this.d.add(this.c.poll());
    }

    public int a(a parama1, a parama2) {
        return a(parama1.f, parama2.f);
    }

    void a() {
        removeMessages(794631);
        removeMessages(-1040157475);
        removeMessages(-1040155167);
        b();
        this.c.clear();
        this.d.clear();
    }

    void a(a parama) {
        this.c.add(parama);
        if (parama.d == null) {
            parama.d = AnimationUtils.loadAnimation(parama.d(), 17432576);
        }
        if (parama.e == null) {
            parama.e = AnimationUtils.loadAnimation(parama.d(), 17432577);
        }
        c();
    }

    void b() {
        Object localObject = new HashSet();
        a(this.c, (Collection) localObject);
        a(this.d, (Collection) localObject);
        localObject = ((Collection) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            b((a) ((Iterator) localObject).next());
        }
    }

    void b(a parama) {
        if ((this.c.contains(parama)) || (this.d.contains(parama))) {
            removeMessages(794631, parama);
            removeMessages(-1040157475, parama);
            removeMessages(-1040155167, parama);
            this.c.remove(parama);
            this.d.remove(parama);
            c(parama);
        }
    }

    public void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                super.handleMessage(paramMessage);
                return;
            case 794631:
                c();
                return;
            case -1040157475:
                d((a) paramMessage.obj);
                return;
        }
        c((a) paramMessage.obj);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */