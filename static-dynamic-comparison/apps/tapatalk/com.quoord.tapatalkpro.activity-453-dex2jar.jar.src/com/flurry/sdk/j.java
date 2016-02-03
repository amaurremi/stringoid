package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
        extends ah {
    private static final String a = j.class.getSimpleName();
    private static final Map<Class<? extends ViewGroup>, c> b = f();
    private i c;

    public j(FlurryAdModule paramFlurryAdModule, AdUnit paramAdUnit, e parame) {
        super(paramFlurryAdModule, paramAdUnit, parame);
    }

    private int a(ViewGroup paramViewGroup) {
        int i = paramViewGroup.getChildCount();
        if ((c() == null) || (c().d().size() < 1)) {
            return i;
        }
        paramViewGroup = ((AdFrame) c().d().get(0)).e();
        if (paramViewGroup != null) {
            paramViewGroup = paramViewGroup.f().toString().split("-");
            if ((paramViewGroup.length == 2) && ("t".equals(paramViewGroup[0]))) {
                return 0;
            }
        }
        return i;
    }

    private ViewGroup.LayoutParams a(ViewGroup paramViewGroup, l paraml) {
        if ((c() == null) || (c().d().size() < 1)) {
            paraml = null;
        }
        Object localObject;
        do {
            return paraml;
            paraml = ((AdFrame) c().d().get(0)).e();
            if (paraml == null) {
                return null;
            }
            localObject = b(paramViewGroup);
            if (localObject == null) {
                eo.a(5, a, "Ad space layout and alignment from the server is being ignored for ViewGroup subclass " + paramViewGroup.getClass().getSimpleName());
                return null;
            }
            localObject = ((c) localObject).a(paraml);
            paraml = (l) localObject;
        } while (localObject != null);
        eo.a(6, a, "Ad space layout and alignment from the server is being ignored for ViewGroup subclass " + paramViewGroup.getClass().getSimpleName());
        return (ViewGroup.LayoutParams) localObject;
    }

    private void a(Context paramContext, ViewGroup paramViewGroup, FlurryAdModule paramFlurryAdModule) {
        paramContext = paramFlurryAdModule.a(paramContext, paramViewGroup, e());
        if (paramContext == null) {
            eo.a(6, a, "failed to render banner ad for holder = " + paramContext + " for adSpaceName = " + e());
            return;
        }
        paramFlurryAdModule = (ViewGroup) paramContext.getParent();
        if (paramFlurryAdModule != null) {
            paramFlurryAdModule.removeView(paramContext);
        }
        paramContext.d();
        paramContext.removeAllViews();
        paramFlurryAdModule = (ViewGroup) this.c.getParent();
        if (paramFlurryAdModule != null) {
            paramFlurryAdModule.removeView(this.c);
        }
        paramContext.addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        this.c.initLayout();
        paramFlurryAdModule = a(paramViewGroup, paramContext);
        if (paramFlurryAdModule != null) {
            paramContext.setLayoutParams(paramFlurryAdModule);
            eo.a(3, a, "banner ad holder layout params = " + paramFlurryAdModule.getClass().getName() + " {width = " + paramFlurryAdModule.width + ", height = " + paramFlurryAdModule.height + "} for banner ad with adSpaceName = " + e());
        }
        paramViewGroup.addView(paramContext, a(paramViewGroup));
    }

    private static c b(ViewGroup paramViewGroup) {
        return (c) b.get(paramViewGroup.getClass());
    }

    private static Map<Class<? extends ViewGroup>, c> f() {
        HashMap localHashMap = new HashMap();
        localHashMap.put(LinearLayout.class, new d());
        localHashMap.put(AbsoluteLayout.class, new a());
        localHashMap.put(FrameLayout.class, new b());
        localHashMap.put(RelativeLayout.class, new e());
        return Collections.unmodifiableMap(localHashMap);
    }

    public void a(Context paramContext, ViewGroup paramViewGroup) {
        eo.a(3, a, "render(" + paramContext + ", " + paramViewGroup + ")");
        if ((paramContext == null) || (paramViewGroup == null)) {
            eo.a(6, a, "failed to render banner ad for adspace: " + e() + " context: " + paramContext + " viewGroup: " + paramViewGroup);
            return;
        }
        FlurryAdModule localFlurryAdModule = b();
        AdUnit localAdUnit = c();
        e locale = d();
        if (localAdUnit == null) {
            eo.a(6, a, "failed to render banner ad, adUnit is null for adspace: " + e() + " context: " + paramContext + " viewGroup: " + paramViewGroup);
            return;
        }
        Object localObject1 = localAdUnit.d();
        if ((localObject1 == null) || (((List) localObject1).isEmpty())) {
            eo.a(6, a, "failed to render banner ad, no adFrames for adspace: " + e() + " context: " + paramContext + " viewGroup: " + paramViewGroup);
            return;
        }
        Object localObject2 = (AdFrame) ((List) localObject1).get(0);
        int i = ((AdFrame) localObject2).b().intValue();
        localObject1 = ((AdFrame) localObject2).d().toString();
        localObject2 = cc.a(((AdFrame) localObject2).e());
        ICustomAdNetworkHandler localICustomAdNetworkHandler = localFlurryAdModule.q();
        k localk = localFlurryAdModule.b();
        if ((i == 4) && (localICustomAdNetworkHandler != null)) {
            this.c = localICustomAdNetworkHandler.getAdFromNetwork(paramContext, (AdCreative) localObject2, (String) localObject1);
            if (this.c != null) {
                this.c.setPlatformModule(localFlurryAdModule);
                this.c.setAdLog(locale);
                this.c.setAdFrameIndex(0);
                this.c.setAdUnit(localAdUnit);
            }
        }
        while (this.c == null) {
            eo.d(a, "Failed to create view for ad network: " + (String) localObject1 + ", network is unsupported on Android, or no ICustomAdNetworkHandler was registered or it failed to return a view.");
            paramViewGroup = new HashMap();
            paramViewGroup.put("errorCode", Integer.toString(b.p.a()));
            if (i == 4) {
                paramViewGroup.put("binding_3rd_party", Integer.toString(4));
            }
            localFlurryAdModule.a(new q("renderFailed", paramViewGroup, paramContext, localAdUnit, locale, 0), localFlurryAdModule.a(), 1);
            return;
            this.c = localk.a(paramContext, localFlurryAdModule, locale, localAdUnit);
        }
        a(paramContext, paramViewGroup, localFlurryAdModule);
    }

    static final class a
            extends j.c {
        a() {
            super();
        }

        public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout) {
            eo.a(5, j.a(), "AbsoluteLayout is deprecated, please consider to use FrameLayout or RelativeLayout for banner ad container view");
            return new AbsoluteLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout), 0, 0);
        }
    }

    static final class b
            extends j.c {
        b() {
            super();
        }

        public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout) {
            return new FrameLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout), 17);
        }
    }

    static abstract class c {
        private static boolean h(AdSpaceLayout paramAdSpaceLayout) {
            return paramAdSpaceLayout.b().intValue() != 0;
        }

        private static boolean i(AdSpaceLayout paramAdSpaceLayout) {
            return paramAdSpaceLayout.c().intValue() != 0;
        }

        public abstract ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout);

        public int b(AdSpaceLayout paramAdSpaceLayout) {
            if (h(paramAdSpaceLayout)) {
                return d(paramAdSpaceLayout);
            }
            return f(paramAdSpaceLayout);
        }

        public int c(AdSpaceLayout paramAdSpaceLayout) {
            if (i(paramAdSpaceLayout)) {
                return e(paramAdSpaceLayout);
            }
            return g(paramAdSpaceLayout);
        }

        public int d(AdSpaceLayout paramAdSpaceLayout) {
            return fc.b(paramAdSpaceLayout.b().intValue());
        }

        public int e(AdSpaceLayout paramAdSpaceLayout) {
            return fc.b(paramAdSpaceLayout.c().intValue());
        }

        public int f(AdSpaceLayout paramAdSpaceLayout) {
            return -1;
        }

        public int g(AdSpaceLayout paramAdSpaceLayout) {
            return -2;
        }
    }

    static final class d
            extends j.c {
        d() {
            super();
        }

        public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout) {
            return new LinearLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout));
        }
    }

    static final class e
            extends j.c {
        private static final Map<String, Integer> a = ;

        e() {
            super();
        }

        private static Integer a(String paramString) {
            return (Integer) a.get(paramString);
        }

        private static Map<String, Integer> a() {
            HashMap localHashMap = new HashMap();
            localHashMap.put("b", Integer.valueOf(12));
            localHashMap.put("t", Integer.valueOf(10));
            localHashMap.put("m", Integer.valueOf(15));
            localHashMap.put("c", Integer.valueOf(14));
            localHashMap.put("l", Integer.valueOf(9));
            localHashMap.put("r", Integer.valueOf(11));
            return Collections.unmodifiableMap(localHashMap);
        }

        public ViewGroup.LayoutParams a(AdSpaceLayout paramAdSpaceLayout) {
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(b(paramAdSpaceLayout), c(paramAdSpaceLayout));
            paramAdSpaceLayout = paramAdSpaceLayout.f().toString().split("-");
            if (paramAdSpaceLayout.length == 2) {
                Integer localInteger = a(paramAdSpaceLayout[0]);
                if (localInteger != null) {
                    localLayoutParams.addRule(localInteger.intValue());
                }
                paramAdSpaceLayout = a(paramAdSpaceLayout[1]);
                if (paramAdSpaceLayout != null) {
                    localLayoutParams.addRule(paramAdSpaceLayout.intValue());
                }
            }
            return localLayoutParams;
        }

        public int g(AdSpaceLayout paramAdSpaceLayout) {
            return -1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */