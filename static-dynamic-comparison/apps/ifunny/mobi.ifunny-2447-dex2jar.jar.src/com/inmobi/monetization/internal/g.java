package com.inmobi.monetization.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

class g
        extends View {
    WebViewClient a = new f(this);
    private IMWebView b;
    private boolean c = false;
    private String d;
    private ArrayList<String> e = null;
    private boolean f = false;

    public g(Context paramContext, String paramString1, String paramString2) {
        super(paramContext);
        if ((paramString1 == null) || (paramString2 == null)) {
            return;
        }
        this.d = paramString2;
        paramString2 = new RelativeLayout.LayoutParams(-1, -1);
        paramString2.addRule(10);
        setLayoutParams(paramString2);
        setBackgroundColor(0);
        IMWebView.setIMAIController(IMAIController.class);
        this.b = new IMWebView(paramContext, null, false, false);
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.getSettings().setCacheMode(2);
        this.b.setWebViewClient(this.a);
        this.b.loadData(paramString1, "text/html", "UTF-8");
        this.e = new ArrayList();
        setId(999);
    }

    private String b() {
        return this.d + "recordEvent(18)";
    }

    private String b(HashMap<String, String> paramHashMap) {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
            localStringBuilder.append(this.d + "recordEvent(8)");
            return localStringBuilder.toString();
        }
        localStringBuilder.append(this.d + "recordEvent(8, ");
        localStringBuilder.append(new JSONObject(paramHashMap).toString());
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    public void a() {
        if (this.b != null) {
            this.b.destroy();
            this.b = null;
        }
        if (this.e != null) {
            this.e.clear();
            this.e = null;
        }
        this.c = false;
        this.f = false;
    }

    public void a(String paramString) {
        Log.debug("[InMobi]-[Monetization]", "Handle Impression");
        b(paramString);
    }

    public void a(HashMap<String, String> paramHashMap) {
        Log.debug("[InMobi]-[Monetization]", "Handle Click");
        paramHashMap = b(paramHashMap);
        if (this.f) {
            b(paramHashMap);
        }
        while (this.e == null) {
            return;
        }
        this.e.add(paramHashMap);
    }

    public void b(String paramString) {
        if (paramString != null) {
        }
        try {
            if (paramString.length() < 400) {
                Log.internal("[InMobi]-[Monetization]", paramString);
            }
            if (this.b != null) {
                this.b.loadUrl("javascript:try{" + paramString + "}catch(e){}");
            }
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        super.onWindowVisibilityChanged(paramInt);
        if ((paramInt == 0) && (!this.c)) {
            this.c = true;
            if (!this.f) {
                break label37;
            }
            a(b());
        }
        label37:
        while (this.e == null) {
            return;
        }
        this.e.add(b());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */