package com.inmobi.re.container;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Environment;
import android.webkit.URLUtil;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

class IMWebView$g
        extends AsyncTask<Void, Void, String> {
    File a;
    String b;
    String c;
    int d = -1;
    String e = "";

    IMWebView$g(IMWebView paramIMWebView, File paramFile, String paramString1, String paramString2) {
        this.a = paramFile;
        this.b = paramString1;
        this.c = paramString2;
        if (IMWebView.q(paramIMWebView) == null) {
            IMWebView.a(paramIMWebView, new ArrayList());
        }
        IMWebView.q(paramIMWebView).add(this);
    }

    public String a() {
        return this.c;
    }

    protected String a(Void... paramVarArgs) {
        paramVarArgs = IMWebView.i(this.f).getPackageManager();
        if (paramVarArgs.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", paramVarArgs.getNameForUid(Binder.getCallingUid())) == 0) {
        }
        for (int i = 1; i == 0; i = 0) {
            this.d = IMWebView.h.j.ordinal();
            return "failure";
        }
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
            this.d = IMWebView.h.i.ordinal();
            return "failure";
        }
        if ((!this.c.matches("[A-Za-z0-9]+")) || (this.c.equals(""))) {
            this.d = IMWebView.h.c.ordinal();
            return "failure";
        }
        if ((this.b.equals("")) || (!URLUtil.isValidUrl(this.b))) {
            this.d = IMWebView.h.d.ordinal();
            return "failure";
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            this.d = IMWebView.h.k.ordinal();
            return "failure";
        }
        paramVarArgs = Initializer.getConfigParams().getAllowedContentType().replace("\\", "");
        paramVarArgs = paramVarArgs.substring(1, paramVarArgs.length() - 1);
        int j;
        if (paramVarArgs.contains(",")) {
            paramVarArgs = paramVarArgs.split(",");
            j = Initializer.getConfigParams().getMaxSaveContentSize();
        }
        for (; ; ) {
            try {
                long l2 = System.currentTimeMillis();
                Object localObject1 = (HttpURLConnection) new URL(this.b).openConnection();
                ((HttpURLConnection) localObject1).setRequestMethod("GET");
                ((HttpURLConnection) localObject1).setConnectTimeout(5000);
                Object localObject2 = ((HttpURLConnection) localObject1).getContentType();
                android.util.Log.i("[InMobi]-[RE]-4.5.1", "contentType_url: " + (String) localObject2);
                i = 0;
                long l1;
                if (i < paramVarArgs.length) {
                    if (paramVarArgs[i].substring(1, paramVarArgs[i].length() - 1).equals(localObject2)) {
                        i = 1;
                        if (i != 0) {
                            continue;
                        }
                        this.d = IMWebView.h.g.ordinal();
                        return "failure";
                        paramVarArgs = new String[]{paramVarArgs};
                        break;
                    }
                    i += 1;
                    continue;
                    l1 = ((HttpURLConnection) localObject1).getContentLength();
                    if (l1 >= 0L) {
                        android.util.Log.e("[InMobi]-[RE]-4.5.1", "content size: " + l1);
                        android.util.Log.e("[InMobi]-[RE]-4.5.1", "max size: " + j * 1024 * 1024);
                        if (l1 > j * 1024 * 1024) {
                            this.d = IMWebView.h.h.ordinal();
                            return "failure";
                        }
                    }
                    ((HttpURLConnection) localObject1).connect();
                    paramVarArgs = new FileOutputStream(this.a);
                    localObject1 = ((HttpURLConnection) localObject1).getInputStream();
                    localObject2 = new byte['Ѐ'];
                    l1 = 0L;
                    i = ((InputStream) localObject1).read((byte[]) localObject2);
                    if (i > 0) {
                        l1 += i;
                        if (l1 > j * 1024 * 1024) {
                            this.d = IMWebView.h.h.ordinal();
                            return "failure";
                        }
                        paramVarArgs.write((byte[]) localObject2, 0, i);
                        continue;
                    }
                }
                i = 0;
            } catch (SocketTimeoutException paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "SocketTimeoutException");
                this.d = IMWebView.h.i.ordinal();
                return "failure";
                paramVarArgs.close();
                l1 = System.currentTimeMillis();
                paramVarArgs = "file://" + this.a.getAbsolutePath();
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "file path of video: " + paramVarArgs);
                localObject1 = new JSONObject();
                ((JSONObject) localObject1).put("url", this.b);
                ((JSONObject) localObject1).put("saved_url", paramVarArgs);
                ((JSONObject) localObject1).put("size_in_bytes", this.a.length());
                ((JSONObject) localObject1).put("download_started_at", l2);
                ((JSONObject) localObject1).put("download_ended_at", l1);
                this.e = ((JSONObject) localObject1).toString().replace("\"", "\\\"");
                return "success";
            } catch (FileNotFoundException paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "FileNotFoundException");
                this.d = IMWebView.h.e.ordinal();
                return "failure";
            } catch (MalformedURLException paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "MalformedURLException");
                this.d = IMWebView.h.d.ordinal();
                return "failure";
            } catch (ProtocolException paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "ProtocolException");
                this.d = IMWebView.h.i.ordinal();
                return "failure";
            } catch (IOException paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "IOException");
                this.d = IMWebView.h.a.ordinal();
                return "failure";
            } catch (JSONException paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "JSONException");
                this.d = IMWebView.h.a.ordinal();
                return "failure";
            } catch (Exception paramVarArgs) {
                com.inmobi.commons.internal.Log.internal("[InMobi]-[RE]-4.5.1", "Unknown Exception");
                this.d = IMWebView.h.a.ordinal();
                return "failure";
            }
        }
    }

    protected void a(String paramString) {
        if (paramString.equals("success")) {
            this.f.injectJavaScript("window.mraid.sendSaveContentResult(\"saveContent_" + this.c + "\", 'success', \"" + this.e + "\");");
            if (this.f.c != null) {
                this.f.c.postSuccess();
            }
        }
        for (; ; ) {
            super.onPostExecute(paramString);
            return;
            Object localObject = new JSONObject();
            try {
                ((JSONObject) localObject).put("url", this.b);
                ((JSONObject) localObject).put("reason", this.d);
                localObject = ((JSONObject) localObject).toString().replace("\"", "\\\"");
                this.f.injectJavaScript("window.mraid.sendSaveContentResult(\"saveContent_" + this.c + "\", 'failure', \"" + (String) localObject + "\");");
                if (this.f.c != null) {
                    this.f.c.postFailed(this.d);
                }
            } catch (JSONException localJSONException) {
            }
        }
    }

    protected void onCancelled() {
        super.onCancelled();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */