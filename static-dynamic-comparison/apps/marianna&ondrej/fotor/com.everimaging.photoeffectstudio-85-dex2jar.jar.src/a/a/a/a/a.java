package a.a.a.a;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

class a {
    private c a;
    private Thread b = null;
    private String c;
    private Context d;
    private String e;

    private void b() {
        if ((this.b != null) && (this.b.isAlive())) {
        }
        while (this.a.b()) {
            return;
        }
        this.b = new Thread() {
            public void run() {
                for (; ; ) {
                    Object localObject = a.a(a.this).a();
                    String str = localObject[0];
                    DefaultHttpClient localDefaultHttpClient = localObject[1];
                    if (localDefaultHttpClient == null) {
                    }
                    do {
                        return;
                        localObject = localDefaultHttpClient;
                        if (localDefaultHttpClient.indexOf("REPLACE_UDID") == -1) {
                            break;
                        }
                    } while (!org.OpenUDID.a.b());
                    localObject = localDefaultHttpClient.replaceFirst("REPLACE_UDID", org.OpenUDID.a.a());
                    try {
                        localDefaultHttpClient = new DefaultHttpClient();
                        InputStream localInputStream = localDefaultHttpClient.execute(new HttpGet(new URI(a.b(a.this) + "/i?" + (String) localObject))).getEntity().getContent();
                        while (localInputStream.read() != -1) {
                        }
                        localDefaultHttpClient.getConnectionManager().shutdown();
                        a.a(a.this).a(str);
                    } catch (Exception localException) {
                        Log.e("Countly", "error ->" + (String) localObject);
                    }
                }
            }
        };
        this.b.start();
    }

    public void a() {
        String str = "app_key=" + this.c;
        str = str + "&device_id=" + d.a();
        str = str + "&timestamp=" + (System.currentTimeMillis() / 1000.0D);
        str = str + "&sdk_version=2.0";
        str = str + "&begin_session=1";
        str = str + "&metrics=" + d.d(this.d);
        // todo keys passed into sql method
        this.a.b(str);
        b();
    }

    public void a(int paramInt) {
        String str = "app_key=" + this.c;
        str = str + "&device_id=" + d.a();
        str = str + "&timestamp=" + (System.currentTimeMillis() / 1000.0D);
        str = str + "&session_duration=" + paramInt;
        this.a.b(str);
        b();
    }

    public void a(c paramc) {
        this.a = paramc;
    }

    public void a(Context paramContext) {
        this.d = paramContext;
    }

    public void a(String paramString) {
        this.c = paramString;
    }

    public void b(int paramInt) {
        String str = "app_key=" + this.c;
        str = str + "&device_id=" + d.a();
        str = str + "&timestamp=" + (System.currentTimeMillis() / 1000.0D);
        str = str + "&end_session=1";
        str = str + "&session_duration=" + paramInt;
        this.a.b(str);
        b();
    }

    public void b(String paramString) {
        this.e = paramString;
    }

    public void c(String paramString) {
        String str = "app_key=" + this.c;
        str = str + "&device_id=" + d.a();
        str = str + "&timestamp=" + (System.currentTimeMillis() / 1000.0D);
        paramString = str + "&events=" + paramString;
        this.a.b(paramString);
        b();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */