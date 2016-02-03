package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class eb
        extends WebChromeClient {
    private final dz lC;

    public eb(dz paramdz) {
        this.lC = paramdz;
    }

    private static void a(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult) {
        paramBuilder.setMessage(paramString).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                this.rI.confirm();
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                this.rI.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface paramAnonymousDialogInterface) {
                this.rI.cancel();
            }
        }).create().show();
    }

    private static void a(final Context paramContext, AlertDialog.Builder paramBuilder, String paramString1, String paramString2, JsPromptResult paramJsPromptResult) {
        LinearLayout localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        TextView localTextView = new TextView(paramContext);
        localTextView.setText(paramString1);
        paramContext = new EditText(paramContext);
        paramContext.setText(paramString2);
        localLinearLayout.addView(localTextView);
        localLinearLayout.addView(paramContext);
        paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                this.rJ.confirm(paramContext.getText().toString());
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                this.rJ.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface paramAnonymousDialogInterface) {
                this.rJ.cancel();
            }
        }).create().show();
    }

    protected final void a(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
        cc localcc = this.lC.bH();
        if (localcc == null) {
            dw.z("Could not get ad overlay when showing custom view.");
            paramCustomViewCallback.onCustomViewHidden();
            return;
        }
        localcc.a(paramView, paramCustomViewCallback);
        localcc.setRequestedOrientation(paramInt);
    }

    protected boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean) {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
        localBuilder.setTitle(paramString1);
        if (paramBoolean) {
            a(paramContext, localBuilder, paramString2, paramString3, paramJsPromptResult);
        }
        for (; ; ) {
            return true;
            a(localBuilder, paramString2, paramJsResult);
        }
    }

    public final void onCloseWindow(WebView paramWebView) {
        if (!(paramWebView instanceof dz)) {
            dw.z("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        paramWebView = ((dz) paramWebView).bH();
        if (paramWebView == null) {
            dw.z("Tried to close an AdWebView not associated with an overlay.");
            return;
        }
        paramWebView.close();
    }

    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage) {
        String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
        switch (7. rL[paramConsoleMessage.messageLevel().ordinal()])
        {
            default:
                dw.x(str);
        }
        for (; ; ) {
            return super.onConsoleMessage(paramConsoleMessage);
            dw.w(str);
            continue;
            dw.z(str);
            continue;
            dw.x(str);
            continue;
            dw.v(str);
        }
    }

    public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage) {
        WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport) paramMessage.obj;
        paramWebView = new WebView(paramWebView.getContext());
        paramWebView.setWebViewClient(this.lC.bI());
        localWebViewTransport.setWebView(paramWebView);
        paramMessage.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater) {
        long l = 5242880L - paramLong3;
        if (l <= 0L) {
            paramQuotaUpdater.updateQuota(paramLong1);
            return;
        }
        if (paramLong1 == 0L) {
            if ((paramLong2 > l) || (paramLong2 > 1048576L)) {
            }
        }
        for (; ; ) {
            paramQuotaUpdater.updateQuota(paramLong2);
            return;
            paramLong2 = 0L;
            continue;
            if (paramLong2 == 0L) {
                paramLong2 = Math.min(Math.min(131072L, l) + paramLong1, 1048576L);
            } else {
                paramLong3 = paramLong1;
                if (paramLong2 <= Math.min(1048576L - paramLong1, l)) {
                    paramLong3 = paramLong1 + paramLong2;
                }
                paramLong2 = paramLong3;
            }
        }
    }

    public final void onHideCustomView() {
        cc localcc = this.lC.bH();
        if (localcc == null) {
            dw.z("Could not get ad overlay when hiding custom view.");
            return;
        }
        localcc.aL();
    }

    public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
    }

    public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult) {
        return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
    }

    public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult) {
        return a(paramWebView.getContext(), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater) {
        paramLong1 = 131072L + paramLong1;
        if (5242880L - paramLong2 < paramLong1) {
            paramQuotaUpdater.updateQuota(0L);
            return;
        }
        paramQuotaUpdater.updateQuota(paramLong1);
    }

    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {
        a(paramView, -1, paramCustomViewCallback);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */