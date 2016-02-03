package com.everimaging.fotor.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.everimaging.fotor.App;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;
import com.everimaging.fotorsdk.store.utils.c;

import java.util.List;

public class a {
    private static final String a = a.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private static a c;
    private boolean d = false;

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public boolean a(Context paramContext, PushMessageEntity.MessageEntity paramMessageEntity) {
        b.c(new Object[]{"isShowing:" + this.d + ",entity:" + paramMessageEntity});
        for (; ; ) {
            try {
                if ((this.d) || (paramMessageEntity == null)) {
                    continue;
                }
                Object localObject = paramMessageEntity.getJump();
                if (localObject != null) {
                    Uri localUri = Uri.parse((String) localObject);
                    if ("fotor".equals(localUri.getScheme())) {
                        String str = localUri.getAuthority();
                        if (("store.list".equals(str)) || ("store.detail".equals(str))) {
                            localObject = null;
                            if ("store.list".equals(str)) {
                                localObject = localUri.getLastPathSegment();
                                if ((localObject != null) && (c.e((String) localObject)) && (!com.everimaging.fotorsdk.store.iap.a.b())) {
                                    return true;
                                }
                            } else {
                                if (!"store.detail".equals(str)) {
                                    continue;
                                }
                                localObject = (String) localUri.getPathSegments().get(0);
                                continue;
                            }
                        }
                    }
                }
                bool1 = App.c(paramContext);
                boolean bool2 = paramMessageEntity.isShouldDisplay(App.b.i());
                b.c(new Object[]{"isApplicationToBackground:" + bool1, "is right place:" + bool2});
                if ((bool1) || (!bool2)) {
                    continue;
                }
                this.d = true;
                localObject = new Intent(paramContext, MessageDialog.class);
                ((Intent) localObject).setFlags(268435456);
                ((Intent) localObject).putExtra("extra_data", paramMessageEntity);
                paramContext.startActivity((Intent) localObject);
                bool1 = true;
                try {
                    b.c(new Object[]{"is showing success:" + bool1});
                    return bool1;
                } catch (Exception paramContext) {
                }
            } catch (Exception paramContext) {
                boolean bool1 = false;
                continue;
            }
            paramContext.printStackTrace();
            return bool1;
            b.c(new Object[]{"application was enter background..."});
            bool1 = false;
        }
    }

    public void b() {
        this.d = false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/push/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */