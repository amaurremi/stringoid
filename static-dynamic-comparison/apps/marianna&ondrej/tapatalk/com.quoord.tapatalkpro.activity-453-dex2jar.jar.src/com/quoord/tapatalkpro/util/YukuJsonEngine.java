package com.quoord.tapatalkpro.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class YukuJsonEngine {
    private static final int RECALL_FUNCTION = 2;
    private static final int SUCCESS_RETURN = 1;
    private CallBackInterface mAdapter = null;

    public YukuJsonEngine(CallBackInterface paramCallBackInterface) {
        this.mAdapter = paramCallBackInterface;
    }

    public void Call(final String paramString)
            throws Exception {
        ThreadPoolManager.addExecuteTask(new Thread() {
            public void handleMessage(Message paramAnonymousMessage) {
                switch (paramAnonymousMessage.what) {
                }
                do {
                    return;
                    paramAnonymousMessage = (EngineResponse) paramAnonymousMessage.obj;
                } while (YukuJsonEngine.this.mAdapter.isOpCancel());
                try {
                    YukuJsonEngine.this.mAdapter.callBack(paramAnonymousMessage);
                    return;
                } catch (Exception paramAnonymousMessage) {
                    paramAnonymousMessage.printStackTrace();
                }
            }
        }
        {
            public void run ()
            {
                ArrayList localArrayList = new ArrayList();
                for (; ; ) {
                    try {
                        Object localObject1 = new DefaultHttpClient();
                        Object localObject3 = new HttpGet();
                        ((HttpGet) localObject3).setURI(new URI(paramString));
                        localObject1 = new BufferedReader(new InputStreamReader(((HttpClient) localObject1).execute((HttpUriRequest) localObject3).getEntity().getContent()));
                        try {
                            localObject3 = new StringBuffer("");
                            String str1 = System.getProperty("line.separator");
                            String str2 = ((BufferedReader) localObject1).readLine();
                            if (str2 == null) {
                                ((BufferedReader) localObject1).close();
                                localObject3 = ((StringBuffer) localObject3).toString();
                                i = ((String) localObject3).indexOf("{");
                                j = ((String) localObject3).indexOf("[");
                                localObject1 = localObject3;
                                if (i != 0) {
                                    localObject1 = localObject3;
                                    if (j != 0) {
                                        if (i >= j) {
                                            continue;
                                        }
                                        localObject1 = ((String) localObject3).substring(i);
                                    }
                                }
                                if ((localObject1 == null) || (((String) localObject1).length() <= 0)) {
                                    continue;
                                }
                                if (!((String) localObject1).startsWith("{")) {
                                    continue;
                                }
                                localObject1 = new JSONObject((String) localObject1);
                                localArrayList.add(paramString);
                                localArrayList.add(localObject1);
                                localArrayList.add(Boolean.valueOf(true));
                                localObject1 = this.val$handler.obtainMessage(1, localArrayList);
                                this.val$handler.sendMessage((Message) localObject1);
                                return;
                            }
                            ((StringBuffer) localObject3).append(str2 + str1);
                            continue;
                            localArrayList.add(paramString);
                        } catch (Exception localException1) {
                        }
                    } catch (Exception localException2) {
                        int i;
                        int j;
                        Object localObject2;
                        continue;
                    }
                    localArrayList.add(localException1.getMessage());
                    localArrayList.add(Boolean.valueOf(false));
                    localObject2 = this.val$handler.obtainMessage(1, localArrayList);
                    this.val$handler.sendMessage((Message) localObject2);
                    return;
                    i = j;
                    continue;
                    localObject2 = new JSONArray((String) localObject2);
                    localArrayList.add(paramString);
                    localArrayList.add(localObject2);
                    localArrayList.add(Boolean.valueOf(true));
                    continue;
                    localArrayList.add(paramString);
                    localArrayList.add("");
                    localArrayList.add(Boolean.valueOf(false));
                }
            }
        });
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/YukuJsonEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */