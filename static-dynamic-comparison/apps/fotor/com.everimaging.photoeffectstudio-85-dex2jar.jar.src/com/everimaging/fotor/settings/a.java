package com.everimaging.fotor.settings;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Size;
import android.preference.PreferenceManager;
import com.everimaging.fotor.App;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static final List<com.everimaging.fotor.c.c> a() {
        Object localObject = null;
        String str = PreferenceManager.getDefaultSharedPreferences(App.b).getString("support_picture_size", null);
        if (str != null) {
            localObject = new GsonBuilder();
            Type localType = new TypeToken() {
            }.getType();
            localObject = (List) ((GsonBuilder) localObject).create().fromJson(str, localType);
        }
        return (List<com.everimaging.fotor.c.c>) localObject;
    }

    public static final void a(long paramLong) {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(App.b).edit();
        localEditor.putLong("pull_notification_time", paramLong);
        localEditor.commit();
    }

    public static final void a(com.everimaging.fotor.c.c paramc) {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(App.b).edit();
        if (paramc == null) {
            localEditor.remove("current_picture_size");
            localEditor.commit();
            return;
        }
        localEditor.putString("current_picture_size", new Gson().toJson(paramc));
        localEditor.commit();
    }

    public static final void a(String paramString) {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(App.b).edit();
        localEditor.putString("save_path", paramString);
        localEditor.commit();
    }

    public static final void a(List<Camera.Size> paramList) {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(App.b).edit();
        if ((paramList == null) || (paramList.isEmpty())) {
            localEditor.remove("support_picture_size");
            localEditor.commit();
            return;
        }
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramList.size()) {
            Camera.Size localSize = (Camera.Size) paramList.get(i);
            if ((localSize.width != 0) && (localSize.height != 0)) {
                localArrayList.add(new com.everimaging.fotor.c.c(localSize.width, localSize.height));
            }
            i += 1;
        }
        localEditor.putString("support_picture_size", new Gson().toJson(localArrayList));
        localEditor.commit();
    }

    public static final com.everimaging.fotor.c.c b() {
        String str = PreferenceManager.getDefaultSharedPreferences(App.b).getString("current_picture_size", "{}");
        if ("{}".equals(str)) {
            return null;
        }
        return (com.everimaging.fotor.c.c) new Gson().fromJson(str, com.everimaging.fotor.c.c.class);
    }

    public static final void b(long paramLong) {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(App.b).edit();
        localEditor.putLong("pull_notification_period", paramLong);
        localEditor.commit();
    }

    public static final boolean c() {
        return Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(App.b).getString("launch_home_v2", "true")).booleanValue();
    }

    public static final long d() {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.b);
        long l3 = e();
        long l2 = localSharedPreferences.getLong("pull_notification_time", l3);
        long l1 = l2;
        if (System.currentTimeMillis() >= l2) {
            l1 = System.currentTimeMillis() + l3;
        }
        return l1;
    }

    public static final long e() {
        return PreferenceManager.getDefaultSharedPreferences(App.b).getLong("pull_notification_period", com.everimaging.fotor.push.c.b);
    }

    public static void f() {
        try {
            SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(App.b).edit();
            localEditor.remove("support_picture_size");
            localEditor.remove("launch_home");
            localEditor.remove("current_picture_size");
            localEditor.remove("show_guide_1");
            localEditor.commit();
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static final String g() {
        return PreferenceManager.getDefaultSharedPreferences(App.b).getString("save_path", null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/settings/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */