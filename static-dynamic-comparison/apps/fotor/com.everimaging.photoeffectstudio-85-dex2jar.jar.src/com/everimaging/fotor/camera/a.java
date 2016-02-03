package com.everimaging.fotor.camera;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.everimaging.fotor.App;

import java.util.ArrayList;
import java.util.List;

public class a {
    public static final int a() {
        return App.b.getSharedPreferences("camera_params", 0).getInt("zoom_tool_value", 0);
    }

    public static final void a(int paramInt) {
        SharedPreferences.Editor localEditor = App.b.getSharedPreferences("camera_params", 0).edit();
        localEditor.putInt("camera_timer_value", paramInt);
        localEditor.commit();
    }

    public static final void a(int paramInt1, boolean paramBoolean1, String paramString, int paramInt2, boolean paramBoolean2) {
        SharedPreferences.Editor localEditor = App.b.getSharedPreferences("camera_params", 0).edit();
        localEditor.putInt("zoom_tool_value", paramInt1);
        localEditor.putBoolean("use_back_camera", paramBoolean1);
        localEditor.putString("last_flash_mode", paramString);
        localEditor.putInt("last_capture_mode", paramInt2);
        localEditor.putBoolean("zoom_tool_enable", paramBoolean2);
        localEditor.commit();
    }

    public static final void a(List<String> paramList) {
        if ((paramList == null) || (paramList.isEmpty())) {
            return;
        }
        SharedPreferences.Editor localEditor = App.b.getSharedPreferences("camera_params", 0).edit();
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < paramList.size()) {
            localStringBuffer.append((String) paramList.get(i));
            if (i != paramList.size() - 1) {
                localStringBuffer.append("|");
            }
            i += 1;
        }
        localEditor.putString("support_flash_mode", localStringBuffer.toString());
        localEditor.commit();
    }

    public static final void a(boolean paramBoolean1, boolean paramBoolean2) {
        SharedPreferences.Editor localEditor = App.b.getSharedPreferences("camera_params", 0).edit();
        if (paramBoolean2) {
        }
        for (String str = "grid_enable_hdr"; ; str = "grid_enable_normal") {
            localEditor.putBoolean(str, paramBoolean1);
            localEditor.commit();
            return;
        }
    }

    public static final boolean a(boolean paramBoolean) {
        SharedPreferences localSharedPreferences = App.b.getSharedPreferences("camera_params", 0);
        if (paramBoolean) {
        }
        for (String str = "grid_enable_hdr"; ; str = "grid_enable_normal") {
            return localSharedPreferences.getBoolean(str, false);
        }
    }

    public static final void b(boolean paramBoolean) {
        SharedPreferences.Editor localEditor = App.b.getSharedPreferences("camera_params", 0).edit();
        localEditor.putBoolean("zoom_support", paramBoolean);
        localEditor.commit();
    }

    public static final boolean b() {
        return App.b.getSharedPreferences("camera_params", 0).getBoolean("use_back_camera", true);
    }

    public static final boolean c() {
        return App.b.getSharedPreferences("camera_params", 0).getBoolean("zoom_tool_enable", true);
    }

    public static final String d() {
        return App.b.getSharedPreferences("camera_params", 0).getString("last_flash_mode", "off");
    }

    public static final int e() {
        return App.b.getSharedPreferences("camera_params", 0).getInt("last_capture_mode", 0);
    }

    public static final int f() {
        return App.b.getSharedPreferences("camera_params", 0).getInt("camera_timer_value", 5);
    }

    public static final boolean g() {
        return App.b.getSharedPreferences("camera_params", 0).getBoolean("zoom_support", false);
    }

    public static final List<String> h() {
        Object localObject1 = null;
        int i = 0;
        Object localObject2 = App.b.getSharedPreferences("camera_params", 0).getString("support_flash_mode", null);
        if (!TextUtils.isEmpty((CharSequence) localObject2)) {
            ArrayList localArrayList = new ArrayList();
            localObject2 = ((String) localObject2).split("\\|");
            int j = localObject2.length;
            for (; ; ) {
                localObject1 = localArrayList;
                if (i >= j) {
                    break;
                }
                localArrayList.add(localObject2[i]);
                i += 1;
            }
        }
        return (List<String>) localObject1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/camera/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */