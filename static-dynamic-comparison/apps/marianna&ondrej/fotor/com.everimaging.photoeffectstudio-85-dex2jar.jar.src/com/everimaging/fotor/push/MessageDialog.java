package com.everimaging.fotor.push;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import com.everimaging.fotor.discovery.DiscoveryActivity;
import com.everimaging.fotor.discovery.DiscoveryNewsDetailsActivity;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.store.FotorStoreActivity;
import com.everimaging.fotorsdk.store.entity.DetailPageInfo;
import com.everimaging.fotorsdk.store.utils.c;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class MessageDialog
        extends Activity {
    private static final String a = MessageDialog.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private PushMessageEntity.MessageEntity c;

    private void a() {
        a(0);
    }

    private void a(int paramInt) {
        Intent localIntent = new Intent(this, DiscoveryActivity.class);
        localIntent.putExtra("extra_init_index", paramInt);
        startActivity(localIntent);
    }

    private void a(Context paramContext, final PushMessageEntity.MessageEntity paramMessageEntity) {
        paramContext = new AlertDialog.Builder(paramContext);
        paramContext.setCancelable(false);
        paramContext.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface paramAnonymousDialogInterface) {
                MessageDialog.this.finish();
            }
        });
        if (!TextUtils.isEmpty(paramMessageEntity.getTitle())) {
            paramContext.setTitle(paramMessageEntity.getTitle());
        }
        if (!TextUtils.isEmpty(paramMessageEntity.getMsgDescription())) {
            paramContext.setMessage(paramMessageEntity.getMsgDescription());
        }
        if (!TextUtils.isEmpty(paramMessageEntity.getJumpButtonTitle())) {
            paramContext.setPositiveButton(paramMessageEntity.getJumpButtonTitle(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    paramAnonymousDialogInterface = paramMessageEntity.getJump();
                    MessageDialog.a(MessageDialog.this, paramAnonymousDialogInterface);
                    MessageDialog.this.finish();
                }
            });
        }
        paramContext.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                MessageDialog.this.finish();
            }
        });
        b.c(new Object[]{"show text style dialog"});
        paramContext.show();
    }

    private void a(String paramString) {
        Object localObject1 = null;
        if (paramString != null) {
            Object localObject2;
            try {
                paramString = Uri.parse(paramString);
                if (("http".equals(paramString.getScheme())) || ("https".equals(paramString.getScheme()))) {
                    localObject1 = new Intent("android.intent.action.VIEW");
                    ((Intent) localObject1).setData(paramString);
                    startActivity((Intent) localObject1);
                    return;
                }
                if (!"fotor".equals(paramString.getScheme())) {
                    return;
                }
                localObject2 = paramString.getAuthority();
                if (!"discover.news".equals(localObject2)) {
                    break label114;
                }
                paramString = paramString.getQuery();
                if (TextUtils.isEmpty(paramString)) {
                    b();
                    return;
                }
            } catch (Exception paramString) {
                paramString.printStackTrace();
                return;
            }
            c(paramString);
            return;
            label114:
            if ("discover.inspiration".equals(localObject2)) {
                a();
                return;
            }
            if (("store.list".equals(localObject2)) || ("store.detail".equals(localObject2))) {
                if ("store.list".equals(localObject2)) {
                    paramString = paramString.getLastPathSegment();
                }
                for (; ; ) {
                    a(paramString, (DetailPageInfo) localObject1);
                    return;
                    if ("store.detail".equals(localObject2)) {
                        localObject1 = paramString.getPathSegments();
                        paramString = (String) ((List) localObject1).get(0);
                        localObject2 = new StringBuilder();
                        int i = 1;
                        while (i < ((List) localObject1).size()) {
                            if (i > 1) {
                                ((StringBuilder) localObject2).append("/");
                            }
                            ((StringBuilder) localObject2).append((String) ((List) localObject1).get(i));
                            i += 1;
                        }
                        localObject1 = b(((StringBuilder) localObject2).toString());
                    } else {
                        paramString = null;
                    }
                }
            }
        }
    }

    private void a(String paramString, DetailPageInfo paramDetailPageInfo) {
        if (c.a()) {
            Intent localIntent = new Intent(this, FotorStoreActivity.class);
            localIntent.putExtra("arg_feature_type", paramString);
            if (paramDetailPageInfo != null) {
                localIntent.putExtra("arg_package_info", paramDetailPageInfo);
            }
            startActivity(localIntent);
        }
    }

    private DetailPageInfo b(String paramString) {
        try {
            paramString = (DetailPageInfo) new GsonBuilder().create().fromJson(paramString, DetailPageInfo.class);
            return paramString;
        } catch (Exception paramString) {
            Log.e(a, "parse data:" + paramString.getMessage());
        }
        return null;
    }

    private void b() {
        a(1);
    }

    private void b(Context paramContext, final PushMessageEntity.MessageEntity paramMessageEntity) {
        setContentView(2130903207);
        paramContext = (ImageButton) findViewById(2131558861);
        Object localObject1 = (WebView) findViewById(2131558858);
        ((WebView) localObject1).getSettings().setJavaScriptEnabled(true);
        ((WebView) localObject1).setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString) {
                return false;
            }
        });
        ((WebView) localObject1).setBackgroundColor(0);
        if (((WebView) localObject1).getBackground() != null) {
            ((WebView) localObject1).getBackground().setAlpha(0);
        }
        Object localObject2 = paramMessageEntity.getLink();
        b.c(new Object[]{"will load web push message:" + (String) localObject2});
        ((WebView) localObject1).loadUrl((String) localObject2);
        localObject1 = (Button) findViewById(2131558860);
        localObject2 = findViewById(2131558859);
        if (!TextUtils.isEmpty(paramMessageEntity.getJumpButtonTitle())) {
            ((View) localObject2).setVisibility(0);
            ((Button) localObject1).setText(paramMessageEntity.getJumpButtonTitle());
            ((Button) localObject1).setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    MessageDialog.a(MessageDialog.this, paramMessageEntity.getJump());
                    MessageDialog.this.finish();
                }
            });
        }
        for (; ; ) {
            paramContext.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    MessageDialog.this.finish();
                }
            });
            return;
            ((View) localObject2).setVisibility(8);
        }
    }

    private void c(String paramString) {
        Intent localIntent = new Intent(this, DiscoveryNewsDetailsActivity.class);
        localIntent.putExtra("Discovery_News_Link_Url", paramString);
        startActivity(localIntent);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getIntent();
        if ((paramBundle == null) || (paramBundle.getParcelableExtra("extra_data") == null)) {
            finish();
        }
        this.c = ((PushMessageEntity.MessageEntity) paramBundle.getParcelableExtra("extra_data"));
        setContentView(2130903206);
        if (this.c.isDialogStyle()) {
            a(this, this.c);
        }
        while (!this.c.isWebStyle()) {
            return;
        }
        b(this, this.c);
    }

    protected void onDestroy() {
        super.onDestroy();
        b.c(new Object[]{"$$$onDestory$$$"});
        a.a().b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/push/MessageDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */