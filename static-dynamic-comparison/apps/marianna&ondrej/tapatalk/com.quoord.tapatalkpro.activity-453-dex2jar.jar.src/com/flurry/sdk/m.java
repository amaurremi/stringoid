package com.flurry.sdk;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public final class m {
    private static final String a = m.class.getSimpleName();
    private Map<String, Stack<WeakReference<l>>> b = new HashMap();

    private void a(String paramString, l paraml) {
        Stack localStack2 = (Stack) this.b.get(paramString);
        Stack localStack1 = localStack2;
        if (localStack2 == null) {
            localStack1 = new Stack();
            this.b.put(paramString, localStack1);
        }
        localStack1.push(new WeakReference(paraml));
    }

    /* Error */
    public l a(com.flurry.android.impl.ads.FlurryAdModule paramFlurryAdModule, Context paramContext, android.view.ViewGroup paramViewGroup, String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: aload 4
        //   5: invokevirtual 54	com/flurry/sdk/m:a	(Ljava/lang/String;)Lcom/flurry/sdk/l;
        //   8: astore 6
        //   10: aload 6
        //   12: ifnull +26 -> 38
        //   15: aload 6
        //   17: invokevirtual 60	com/flurry/sdk/l:getContext	()Landroid/content/Context;
        //   20: aload_2
        //   21: invokevirtual 64	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   24: istore 5
        //   26: iload 5
        //   28: ifeq +10 -> 38
        //   31: aload 6
        //   33: astore_1
        //   34: aload_0
        //   35: monitorexit
        //   36: aload_1
        //   37: areturn
        //   38: new 56	com/flurry/sdk/l
        //   41: dup
        //   42: aload_1
        //   43: aload_2
        //   44: aload 4
        //   46: aload_3
        //   47: invokespecial 67	com/flurry/sdk/l:<init>	(Lcom/flurry/android/impl/ads/FlurryAdModule;Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;)V
        //   50: astore_1
        //   51: aload_0
        //   52: aload 4
        //   54: aload_1
        //   55: invokespecial 69	com/flurry/sdk/m:a	(Ljava/lang/String;Lcom/flurry/sdk/l;)V
        //   58: goto -24 -> 34
        //   61: astore_1
        //   62: aload_0
        //   63: monitorexit
        //   64: aload_1
        //   65: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	66	0	this	m
        //   0	66	1	paramFlurryAdModule	com.flurry.android.impl.ads.FlurryAdModule
        //   0	66	2	paramContext	Context
        //   0	66	3	paramViewGroup	android.view.ViewGroup
        //   0	66	4	paramString	String
        //   24	3	5	bool	boolean
        //   8	24	6	locall	l
        // Exception table:
        //   from	to	target	type
        //   2	10	61	finally
        //   15	26	61	finally
        //   38	58	61	finally
    }

    /* Error */
    public l a(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 28	com/flurry/sdk/m:b	Ljava/util/Map;
        //   6: aload_1
        //   7: invokeinterface 72 2 0
        //   12: ifeq +47 -> 59
        //   15: aload_0
        //   16: getfield 28	com/flurry/sdk/m:b	Ljava/util/Map;
        //   19: aload_1
        //   20: invokeinterface 35 2 0
        //   25: checkcast 37	java/util/Stack
        //   28: astore_1
        //   29: aload_1
        //   30: invokevirtual 76	java/util/Stack:size	()I
        //   33: ifle +21 -> 54
        //   36: aload_1
        //   37: invokevirtual 80	java/util/Stack:peek	()Ljava/lang/Object;
        //   40: checkcast 44	java/lang/ref/WeakReference
        //   43: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   46: checkcast 56	com/flurry/sdk/l
        //   49: astore_1
        //   50: aload_0
        //   51: monitorexit
        //   52: aload_1
        //   53: areturn
        //   54: aconst_null
        //   55: astore_1
        //   56: goto -6 -> 50
        //   59: aconst_null
        //   60: astore_1
        //   61: goto -11 -> 50
        //   64: astore_1
        //   65: aload_0
        //   66: monitorexit
        //   67: aload_1
        //   68: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	69	0	this	m
        //   0	69	1	paramString	String
        // Exception table:
        //   from	to	target	type
        //   2	50	64	finally
    }

    public List<l> a(Context paramContext) {
        ArrayList localArrayList;
        try {
            localArrayList = new ArrayList();
            Iterator localIterator1 = this.b.values().iterator();
            while (localIterator1.hasNext()) {
                Iterator localIterator2 = ((Stack) localIterator1.next()).iterator();
                while (localIterator2.hasNext()) {
                    l locall = (l) ((WeakReference) localIterator2.next()).get();
                    if ((locall != null) && ((paramContext == null) || (paramContext == locall.getContext()))) {
                        localArrayList.add(locall);
                    }
                }
            }
        } finally {
        }
        return localArrayList;
    }

    public void a(l paraml) {
        if (paraml == null) {
        }
        for (; ; ) {
            return;
            try {
                String str = paraml.getAdSpace();
                Stack localStack = (Stack) this.b.get(str);
                if (localStack == null) {
                    continue;
                }
                Iterator localIterator = localStack.iterator();
                while (localIterator.hasNext()) {
                    WeakReference localWeakReference = (WeakReference) localIterator.next();
                    if (paraml == localWeakReference.get()) {
                        if (localStack.remove(localWeakReference)) {
                            eo.a(3, a, "removed banner holder for adSpaceName: " + paraml.getAdSpace());
                        }
                    }
                }
                if (localStack.size() != 0) {
                    continue;
                }
                this.b.remove(str);
            } finally {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */