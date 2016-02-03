package com.flurry.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Toast;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class r
        implements ad {
    private static final String d = r.class.getSimpleName();
    private static int e = 0;
    FlurryAdModule a;
    y b;
    ag c;
    private boolean f = true;

    public r(FlurryAdModule paramFlurryAdModule) {
        this.a = paramFlurryAdModule;
        this.c = new ag(paramFlurryAdModule);
        this.b = y.a();
    }

    private void a(a parama, String paramString, int paramInt) {
        Context localContext = parama.c.a();
        e locale = parama.c.d;
        AdUnit localAdUnit = parama.c.c;
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", parama.c.a);
        localHashMap.put("url", paramString);
        localHashMap.put("response", paramInt + "");
        this.a.a(new q("sendUrlStatusResult", localHashMap, localContext, localAdUnit, locale, parama.c.e), this, 0);
    }

    private void a(final a parama, final String paramString, final int paramInt1, final b paramb, int paramInt2) {
        if (paramInt1 >= 5) {
            eo.a(5, d, "No response for url: " + paramString);
            if (paramInt2 != 0) {
                a(parama, paramString, paramInt2);
            }
            if (paramb != null) {
                paramb.a(true);
            }
            return;
        }
        el localel = new el();
        localel.a(paramString);
        localel.a(new el.a() {
            public void a(el<Void, Void> paramAnonymousel, Void paramAnonymousVoid) {
                final int i = paramAnonymousel.e();
                if ((eo.c() <= 3) && (eo.d())) {
                    do.a().a(new Runnable() {
                        public void run() {
                            Toast.makeText( do.a().b(), "sUUS HTTP Response Code: " + i, 0).show();
                        }
                    });
                }
                if (i == 200) {
                    eo.a(3, r.b(), "URL hit succeeded for: " + paramString);
                    r.a(r.this, parama, paramString, i);
                    if (paramb != null) {
                        paramb.a(true);
                    }
                    return;
                }
                r.a(r.this, parama, paramString, paramInt1 + 1, paramb, i);
            }
        });
        em.a().a(this, localel);
    }

    private void a(final String paramString1, final String paramString2, final int paramInt, final a parama) {
        if (parama == null) {
        }
        do {
            return;
            if ((paramString1 == null) || (paramString2 == null)) {
                parama.a(null);
                return;
            }
            if (paramInt >= 5) {
                parama.a(null);
                return;
            }
            paramString2 = cf.a(paramString2);
        } while (TextUtils.isEmpty(paramString2));
        if (paramString2.startsWith("http")) {
            el localel = new el();
            localel.a(paramString2);
            localel.a(false);
            localel.a(new el.a() {
                public void a(el<Void, Void> paramAnonymousel, Void paramAnonymousVoid) {
                    final int i = paramAnonymousel.e();
                    if ((eo.c() <= 3) && (eo.d())) {
                        do.a().a(new Runnable() {
                            public void run() {
                                Toast.makeText( do.a().b(), "pRU HTTP Response Code: " + i, 0).show();
                            }
                        });
                    }
                    if (i == 200) {
                        eo.a(3, r.b(), "Redirect URL found for: " + paramString1);
                        parama.a(paramString2);
                        return;
                    }
                    if ((i >= 300) && (i < 400)) {
                        eo.a(3, r.b(), "Num redirects: " + (paramInt + 1));
                        paramAnonymousel = paramAnonymousel.b("Location");
                        if ((paramAnonymousel != null) && (paramAnonymousel.size() > 0)) {
                            r.a(r.this, paramString1, (String) paramAnonymousel.get(0), paramInt + 1, parama);
                            return;
                        }
                        eo.a(3, r.b(), "No location for redirect url: " + paramString2);
                    }
                    for (; ; ) {
                        parama.a(null);
                        return;
                        eo.a(3, r.b(), "Bad Response status code: " + i);
                    }
                }
            });
            em.a().a(this, localel);
            return;
        }
        if (a(paramString2, "android.intent.action.VIEW")) {
            parama.a(paramString2);
            return;
        }
        if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("market://"))) {
            parama.a(paramString2);
            return;
        }
        parama.a(null);
    }

    private boolean a(AdUnit paramAdUnit) {
        if ((paramAdUnit != null) && (paramAdUnit.d().size() > 0)) {
            return ((AdFrame) paramAdUnit.d().get(0)).e().e().toString().equalsIgnoreCase("banner");
        }
        return false;
    }

    public int a(a parama) {
        parama = parama.c.c.b().toString();
        return this.a.d().c().c(parama);
    }

    Intent a(Intent paramIntent, String paramString) {
        if (fe.b(paramIntent)) {
        }
        Intent localIntent;
        for (paramIntent = new Intent(paramIntent); ; paramIntent = localIntent) {
            if (paramIntent != null) {
                paramIntent.putExtra("adSpaceName", paramString);
            }
            return paramIntent;
            localIntent = new Intent( do.a().b(), FlurryFullscreenTakeoverActivity.class);
            localIntent.putExtra("targetIntent", paramIntent);
        }
    }

    public String a(e parame, AdUnit paramAdUnit, a parama, String paramString) {
        Pattern localPattern = Pattern.compile(".*?(%\\{\\w+\\}).*?");
        Matcher localMatcher = localPattern.matcher(paramString);
        String str = paramString;
        for (paramString = localMatcher; paramString.matches(); paramString = localPattern.matcher(str)) {
            str = this.c.a(parame, paramAdUnit, parama, str, paramString.group(1));
        }
        return str;
    }

    public void a() {
        this.f = b(null);
    }

    void a(Context paramContext, String paramString, AdUnit paramAdUnit) {
        Intent localIntent = do.a().c().getLaunchIntentForPackage(paramString);
        if ((localIntent != null) && (fe.a(localIntent))) {
            a(paramContext, localIntent, paramAdUnit.b().toString());
            return;
        }
        a(paramContext, "https://play.google.com/store/apps/details?id=" + paramString, false, paramAdUnit, true);
    }

    public void a(Context paramContext, String paramString1, String paramString2) {
        if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        }
        do {
            return;
            if (!paramString1.startsWith("market://details?id=")) {
                break label114;
            }
            if (!this.f) {
                break;
            }
        } while (d(paramContext, paramString1, paramString2));
        eo.a(6, d, "Cannot launch Google Play url " + paramString1);
        return;
        paramString1 = paramString1.substring("market://details?id=".length());
        d(paramContext, "https://market.android.com/details?id=" + paramString1, paramString2);
        return;
        label114:
        eo.a(5, d, "Unexpected Google Play url scheme: " + paramString1);
    }

    public void a(Context paramContext, String paramString1, boolean paramBoolean, AdUnit paramAdUnit, String paramString2) {
        if (paramContext == null) {
            eo.a(5, d, "Cannot process redirect, null context");
            return;
        }
        paramString2 = this.a.c(paramString2);
        if (paramString2.h()) {
            paramString2.g(false);
            if ((paramContext instanceof FlurryFullscreenTakeoverActivity)) {
                ((FlurryFullscreenTakeoverActivity) paramContext).setVideoMoreInfoInProgress(paramString2);
            }
        }
        a(paramContext, paramString1, paramBoolean, paramAdUnit, false);
    }

    void a(final Context paramContext, final String paramString, final boolean paramBoolean1, final AdUnit paramAdUnit, final boolean paramBoolean2) {
        if (paramContext == null) {
            eo.a(5, d, "Unable to launch url, null context");
            return;
        }
        this.a.b(new ff() {
            public void a() {
                if (paramString != null) {
                    str1 = paramAdUnit.b().toString();
                    String str2 = cf.a(paramString);
                    eo.a(5, r.b(), "Generic Launch of " + str2);
                    if (TextUtils.isEmpty(str2)) {
                    }
                    label203:
                    label228:
                    do {
                        for (; ; ) {
                            return;
                            if (str2.startsWith("market://")) {
                                r.this.a(paramContext, str2, str1);
                                return;
                            }
                            if (!str2.startsWith("http")) {
                                break label228;
                            }
                            if (cf.e(str2)) {
                            }
                            for (boolean bool = r.this.b(paramContext, str2, str1); !bool; bool = r.this.c(paramContext, str2, str1)) {
                                Intent localIntent = new Intent( do.a().b(), FlurryFullscreenTakeoverActivity.class);
                                localIntent.putExtra("url", str2);
                                localIntent.putExtra("should_close_ad", paramBoolean2);
                                if ((!paramBoolean1) || (!fe.a(localIntent))) {
                                    break label203;
                                }
                                r.this.a(paramContext, localIntent, str1);
                                return;
                            }
                        }
                        eo.a(6, r.b(), "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
                        r.this.d(paramContext, str2, str1);
                        return;
                    } while (r.this.d(paramContext, str2, str1));
                    eo.a(5, r.b(), "Failed to launch intent for:" + str2);
                    return;
                }
                String str1 = "Unable to launch intent for: " + paramString;
                eo.a(5, r.b(), str1);
            }
        });
    }

    void a(final a parama, int paramInt) {
        e = a(parama);
        if (paramInt > e) {
            eo.a(5, d, "Maximum depth for event/action loop exceeded when performing next AdUnit:");
            return;
        }
        final Context localContext = parama.c.a();
        AdUnit localAdUnit = parama.c.c;
        final String str = localAdUnit.b().toString();
        boolean bool1 = parama.b.containsKey("delay");
        final boolean bool2 = a(localAdUnit, parama.c.e);
        if (bool1) {
        }
        for (; ; ) {
            try {
                l = Long.parseLong((String) parama.b.get("delay"));
                parama = this.a.d().c(str);
                if ((parama == null) || (!bool1) || (!bool2)) {
                    break;
                }
                parama.a(l * 1000L);
                return;
            } catch (NumberFormatException localNumberFormatException) {
                eo.a(6, d, "caught NumberFormatException with delay parameter in nextAdUnit:" + (String) parama.b.get("delay"));
            }
            long l = 30L;
        }
        if (parama != null) {
            do.a().c(new ff() {
                public void a() {
                    u localu = r.this.a.d();
                    Context localContext = localContext;
                    String str = str;
                    ViewGroup localViewGroup = parama.getViewGroup();
                    if (bool2) {
                    }
                    for (FlurryAdSize localFlurryAdSize = FlurryAdSize.BANNER_BOTTOM; ; localFlurryAdSize = FlurryAdSize.FULLSCREEN) {
                        localu.a(localContext, str, localViewGroup, localFlurryAdSize, true);
                        return;
                    }
                }
            });
            return;
        }
        if (bool2 == true) {
            do.a().c(new ff() {
                public void a() {
                    r.this.a.d().a(localContext, str, null, FlurryAdSize.BANNER_BOTTOM, false);
                }
            });
            return;
        }
        do.a().c(new ff() {
            public void a() {
                r.this.a.d().a(localContext, str, null, FlurryAdSize.FULLSCREEN, true);
            }
        });
    }

    public void a(a parama, ae paramae, int paramInt) {
        String str1 = null;
        if (parama.c != null) {
            str1 = parama.c.a;
        }
        eo.a(3, d, "performAction:action=" + parama.a + ",params=" + parama.b + ",triggering event=" + str1);
        String str2 = parama.a;
        if (paramInt > 10) {
            eo.a(5, d, "Maximum depth for event/action loop exceeded when performing action:" + str2 + "," + parama.b + ",triggered by:" + str1);
            return;
        }
        if (str2.equals("directOpen")) {
            b(parama);
            return;
        }
        if (str2.equals("delete")) {
            c(parama);
            return;
        }
        if (str2.equals("processRedirect")) {
            d(parama);
            return;
        }
        if (str2.equals("verifyUrl")) {
            b(parama, paramae, paramInt);
            return;
        }
        if (str2.equals("launchPackage")) {
            e(parama);
            return;
        }
        if (str2.equals("sendUrlAsync")) {
            f(parama);
            return;
        }
        if (str2.equals("sendAdLogs")) {
            g(parama);
            return;
        }
        if (str2.equals("logEvent")) {
            h(parama);
            return;
        }
        if (str2.equals("nextFrame")) {
            i(parama);
            return;
        }
        if (str2.equals("nextAdUnit")) {
            a(parama, paramInt);
            return;
        }
        if (str2.equals("checkCap")) {
            c(parama, paramae, paramInt);
            return;
        }
        if (str2.equals("updateViewCount")) {
            j(parama);
            return;
        }
        eo.a(5, d, "Unknown action:" + str2 + ",triggered by:" + str1);
    }

    void a(a parama, String paramString) {
        eo.a(3, d, "url after is: " + paramString);
        a(parama, paramString, null);
    }

    void a(a parama, String paramString, b paramb) {
        a(parama, paramString, 0, paramb, 0);
    }

    void a(String paramString, a parama) {
        a(paramString, paramString, 0, parama);
    }

    public boolean a(Context paramContext, Intent paramIntent, String paramString) {
        if (paramContext == null) {
            eo.a(5, d, "Cannot launch activity, null context");
        }
        while ((paramIntent == null) || (paramString == null) || (!fe.a(paramIntent))) {
            return false;
        }
        paramIntent = a(paramIntent, paramString);
        try {
            paramContext.startActivity(paramIntent);
            return true;
        } catch (ActivityNotFoundException paramContext) {
            eo.a(6, d, "Cannot launch Activity", paramContext);
        }
        return false;
    }

    boolean a(AdUnit paramAdUnit, int paramInt) {
        if ((paramAdUnit != null) && (paramAdUnit.d().size() > 0)) {
            return ((AdFrame) paramAdUnit.d().get(paramInt)).e().e().toString().equals("banner");
        }
        return false;
    }

    boolean a(String paramString) {
        paramString = do.a().c().getLaunchIntentForPackage(paramString);
        return (paramString != null) && (fe.a(paramString));
    }

    boolean a(String paramString1, String paramString2) {
        paramString2 = new Intent(paramString2);
        paramString2.setData(Uri.parse(paramString1));
        return fe.a(paramString2);
    }

    void b(final Context paramContext, final String paramString, final boolean paramBoolean1, final AdUnit paramAdUnit, final boolean paramBoolean2) {
        if (paramContext == null) {
            eo.a(5, d, "Cannot process redirect, null context");
            return;
        }
        a(paramString, new a() {
            public void a(String paramAnonymousString) {
                if (paramAnonymousString != null) {
                    eo.a(3, r.b(), "Got final url after processRedirect:" + paramAnonymousString);
                    r.this.a(paramContext, paramAnonymousString, paramBoolean1, paramAdUnit, paramBoolean2);
                    return;
                }
                eo.a(5, r.b(), "Redirect URL could not be found for: " + paramString);
            }
        });
    }

    void b(a parama) {
        Context localContext = parama.c.a();
        e locale = parama.c.d;
        AdUnit localAdUnit = parama.c.c;
        String str1 = localAdUnit.b().toString();
        if (parama.b.containsKey("url")) {
            String str2 = (String) parama.b.get("url");
            if (str2.startsWith("market://")) {
                a(localContext, str2, str1);
                return;
            }
            if ("true".equals(parama.b.get("native"))) {
                eo.a(2, d, "Explictly instructed to use native browser");
                d(localContext, a(locale, localAdUnit, parama, str2), str1);
                return;
            }
            if (a(localAdUnit)) {
                this.a.b(locale);
                this.a.b(localAdUnit);
            }
            parama = new Intent( do.a().b(), FlurryFullscreenTakeoverActivity.class);
            parama.putExtra("url", str2);
            parama.putExtra("is_mraid_ad", true);
            if (fe.a(parama)) {
                a(localContext, parama, str1);
                return;
            }
            eo.a(6, d, "Can't start FlurryFullscreenTakeoverActivity, was it declared in the manifest? Falling back to default browser");
            d(localContext, str2, str1);
            return;
        }
        eo.a(6, d, "failed to perform directOpen action: no url in " + parama.c.a);
    }

    void b(a parama, ae paramae, int paramInt) {
        Context localContext = parama.c.a();
        e locale = parama.c.d;
        AdUnit localAdUnit = parama.c.c;
        if (parama.b.containsKey("url")) {
            if (!a((String) parama.b.get("url"))) {
                break label113;
            }
        }
        label113:
        for (String str = "urlVerified"; ; str = "urlNotVerified") {
            this.a.a(str, 1);
            paramae.a(new q(str, Collections.emptyMap(), localContext, localAdUnit, locale, parama.c.e), this, paramInt + 1);
            return;
        }
    }

    public void b(a parama, String paramString) {
        eo.a(3, d, "url after is: " + paramString);
        a(parama, paramString, 4, null, 0);
    }

    public boolean b(Context paramContext, String paramString1, String paramString2) {
        if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
            return false;
        }
        Intent localIntent = h.b(paramContext, paramString1);
        if (localIntent != null) {
            return a(paramContext, localIntent, paramString2);
        }
        eo.a(5, d, "Google Play is not installed: " + paramString1);
        return false;
    }

    boolean b(String paramString) {
        String str2 = do.a().b().getPackageName();
        String str1 = paramString;
        if (paramString == null) {
            str1 = "market://details?id=" + str2;
        }
        return a(str1, "android.intent.action.VIEW");
    }

    void c(a parama) {
        String str = parama.c.c.b().toString();
        if (parama.b.containsKey("count")) {
            parama = (String) parama.b.get("count");
        }
        while (!parama.b.containsKey("groupId")) {
            try {
                i = Integer.parseInt(parama);
                this.a.d().a(str, i);
                return;
            } catch (NumberFormatException localNumberFormatException) {
                for (; ; ) {
                    eo.a(6, d, "caught NumberFormatException with count parameter in deleteAds:" + parama);
                    int i = -1;
                }
            }
        }
        parama = (String) parama.b.get("groupId");
        this.a.d().a(str, parama);
    }

    void c(a parama, ae paramae, int paramInt) {
        Context localContext = parama.c.a();
        e locale = parama.c.d;
        AdUnit localAdUnit = parama.c.c;
        if (parama.b.containsKey("idHash")) {
            String str2 = (String) parama.b.get("idHash");
            Object localObject2 = this.b.a(str2);
            String str1 = "capNotExhausted";
            Object localObject1 = localObject2;
            if (localObject2 != null) {
                localObject1 = localObject2;
                if (this.b.a(((x) localObject2).h())) {
                    eo.a(4, d, "Discarding expired frequency cap info for idHash=" + str2);
                    this.b.b(str2);
                    localObject1 = null;
                }
            }
            localObject2 = str1;
            if (localObject1 != null) {
                localObject2 = str1;
                if (((x) localObject1).c() >= ((x) localObject1).e()) {
                    eo.a(4, d, "Frequency cap exhausted for idHash=" + str2);
                    localObject2 = "capExhausted";
                }
            }
            this.a.a((String) localObject2, 1);
            paramae.a(new q((String) localObject2, Collections.emptyMap(), localContext, localAdUnit, locale, parama.c.e), this, paramInt + 1);
        }
    }

    public boolean c(Context paramContext, String paramString1, String paramString2) {
        if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
            return false;
        }
        Intent localIntent = h.a(paramContext, paramString1);
        if (localIntent != null) {
            return a(paramContext, localIntent, paramString2);
        }
        eo.a(5, d, "Cannot launch App: " + paramString1);
        return false;
    }

    void d(a parama) {
        Context localContext = parama.c.a();
        e locale = parama.c.d;
        AdUnit localAdUnit = parama.c.c;
        String str;
        if (parama.b.containsKey("url")) {
            str = (String) parama.b.get("url");
            if (!parama.b.containsKey("native")) {
                break label188;
            }
        }
        label177:
        label188:
        for (boolean bool = "false".equals(parama.b.get("native")); ; bool = true) {
            if (!TextUtils.isEmpty(str)) {
                parama = cf.a(a(locale, localAdUnit, parama, str));
                if (!TextUtils.isEmpty(parama)) {
                    if (!parama.startsWith("http")) {
                        break label177;
                    }
                    eo.a(3, d, "Calling processRedirectURL for: " + parama + " and launching in webView: " + bool);
                    b(localContext, parama, bool, localAdUnit, true);
                }
            }
            return;
            a(localContext, parama, false, localAdUnit, true);
            return;
        }
    }

    public boolean d(Context paramContext, String paramString1, String paramString2) {
        if (paramContext == null) {
            eo.a(5, d, "Cannot launch url, null context");
            return false;
        }
        return a(paramContext, new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString1)), paramString2);
    }

    void e(a parama) {
        Context localContext = parama.c.a();
        AdUnit localAdUnit = parama.c.c;
        if (parama.b.containsKey("package")) {
            a(localContext, (String) parama.b.get("package"), localAdUnit);
        }
    }

    void f(a parama) {
        e locale = parama.c.d;
        AdUnit localAdUnit = parama.c.c;
        if (parama.b.containsKey("url")) {
            a(parama, a(locale, localAdUnit, parama, (String) parama.b.get("url")));
        }
    }

    void g(a parama) {
        this.a.C();
    }

    void h(a parama) {
        if ((parama.b.containsKey("__sendToServer")) && (((String) parama.b.get("__sendToServer")).equals("true"))) {
        }
        for (boolean bool = true; ; bool = false) {
            parama.b.remove("__sendToServer");
            this.a.a(parama.c.d, parama.c.a, bool, parama.b);
            return;
        }
    }

    void i(a parama) {
    }

    void j(a parama) {
        Object localObject;
        if (parama.b.containsKey("idHash")) {
            localObject = (String) parama.b.get("idHash");
            localObject = this.b.a((String) localObject);
            if (localObject != null) {
                ((x) localObject).d();
                eo.a(4, d, "updateViewCount:idHash=" + ((x) localObject).b() + ",newCap=" + ((x) localObject).e() + ",prevCap=" + ((x) localObject).f() + ",views=" + ((x) localObject).c());
                if (((x) localObject).c() >= ((x) localObject).e()) {
                    parama = parama.c.c.b().toString();
                    if (((x) localObject).c() <= ((x) localObject).e()) {
                        break label206;
                    }
                    eo.a(6, d, "FlurryAdAction: !! rendering a capped object: " + ((x) localObject).b() + " for adspace: " + parama);
                }
            }
        }
        for (; ; ) {
            this.a.d().d(parama);
            return;
            label206:
            eo.a(4, d, "FlurryAdAction: hit cap for object: " + ((x) localObject).b() + ", cache cleared for adspace: " + parama);
        }
    }

    public static abstract interface a {
        public abstract void a(String paramString);
    }

    public static abstract interface b {
        public abstract void a(boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */