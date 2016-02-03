package com.wbtech.ums.dao;

import android.content.Context;
import android.os.Environment;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.wbtech.ums.common.CommonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SaveInfo
        extends Thread {
    public Context context;
    public JSONObject object;

    public SaveInfo(Context paramContext, JSONObject paramJSONObject) {
        this.object = paramJSONObject;
        this.context = paramContext;
    }

    public void run() {
        super.run();
        try {
            if ((!Environment.getExternalStorageState().equals("mounted")) || (!CommonUtil.checkPermissions(this.context, "android.permission.WRITE_EXTERNAL_STORAGE"))) {
                break label255;
            }
            localObject1 = new File(AppCacheManager.getBaseCacheDir(this.context) + "mobclick_agent_cached_" + this.context.getPackageName());
            if (!((File) localObject1).exists()) {
                break label256;
            }
            CommonUtil.printLog("path", ((File) localObject1).getAbsolutePath());
            localObject1 = new FileInputStream(AppCacheManager.getBaseCacheDir(this.context) + "mobclick_agent_cached_" + this.context.getPackageName());
            localObject2 = new StringBuffer();
            localObject3 = new byte['က'];
        } catch (IOException localIOException1) {
            for (; ; ) {
                Object localObject1;
                int i;
                localIOException1.printStackTrace();
                return;
                ((StringBuffer) localObject2).append(new String((byte[]) localObject3, 0, i));
            }
        } catch (JSONException localJSONException1) {
            label255:
            label256:
            localJSONException1.printStackTrace();
            return;
        }
        i = ((FileInputStream) localObject1).read((byte[]) localObject3);
        if (i == -1) {
            if (((StringBuffer) localObject2).length() != 0) {
                localObject1 = new JSONObject(((StringBuffer) localObject2).toString());
            }
        } else {
            for (; ; ) {
                try {
                    localObject2 = this.object.keys();
                    if (((Iterator) localObject2).hasNext()) {
                        continue;
                    }
                    localObject2 = new FileOutputStream(AppCacheManager.getBaseCacheDir(this.context) + "mobclick_agent_cached_" + this.context.getPackageName(), false);
                    ((FileOutputStream) localObject2).write(((JSONObject) localObject1).toString().getBytes());
                    ((FileOutputStream) localObject2).flush();
                    ((FileOutputStream) localObject2).close();
                    return;
                } catch (JSONException localJSONException2) {
                    Object localObject4;
                    continue;
                    localObject2 = this.object.keys();
                    JSONObject localJSONObject = new JSONObject();
                    if (((Iterator) localObject2).hasNext()) {
                        continue;
                    }
                    localJSONObject.put("appkey", CommonUtil.getAppKey(this.context));
                    localObject2 = new FileOutputStream(AppCacheManager.getBaseCacheDir(this.context) + "mobclick_agent_cached_" + this.context.getPackageName(), false);
                    ((FileOutputStream) localObject2).write(localJSONObject.toString().getBytes());
                    ((FileOutputStream) localObject2).flush();
                    ((FileOutputStream) localObject2).close();
                    return;
                    localObject3 = (String) ((Iterator) localObject2).next();
                    localJSONObject.put((String) localObject3, this.object.getJSONArray((String) localObject3));
                    continue;
                } catch (IOException localIOException2) {
                    continue;
                }
                ((File) localObject1).createNewFile();
                CommonUtil.printLog("path", "No path");
                break;
                localObject4 = (String) ((Iterator) localObject2).next();
                localObject3 = this.object.getJSONArray((String) localObject4);
                if (localJSONException1.has((String) localObject4)) {
                    localObject4 = localJSONException1.getJSONArray((String) localObject4);
                    CommonUtil.printLog("SaveInfo", localObject3);
                    ((JSONArray) localObject4).put(((JSONArray) localObject3).get(0));
                } else {
                    localJSONException1.put((String) localObject4, this.object.getJSONArray((String) localObject4));
                    CommonUtil.printLog("SaveInfo", "jsonobject" + localJSONException1);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/dao/SaveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */