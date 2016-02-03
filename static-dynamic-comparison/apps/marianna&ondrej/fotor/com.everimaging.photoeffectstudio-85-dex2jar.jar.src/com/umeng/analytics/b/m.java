package com.umeng.analytics.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.umeng.analytics.d;
import com.umeng.analytics.e;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class m {
    private static final String a = "umeng_general_config";
    private static final m b = new m();
    private SharedPreferences c;

    private m() {
    }

    private m(SharedPreferences paramSharedPreferences) {
        this.c = paramSharedPreferences;
    }

    public static m a(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("umeng_general_config", 0);
        b.a(paramContext);
        return b;
    }

    public static m a(Context paramContext, String paramString) {
        return new m(paramContext.getSharedPreferences(paramString, 0));
    }

    public float a(String paramString, float paramFloat) {
        return this.c.getFloat(paramString, paramFloat);
    }

    public int a(String paramString, int paramInt) {
        return this.c.getInt(paramString, paramInt);
    }

    public long a(String paramString, long paramLong) {
        return this.c.getLong(paramString, paramLong);
    }

    public a a() {
        return new a(this.c.edit());
    }

    public String a(String paramString1, String paramString2) {
        return this.c.getString(paramString1, paramString2);
    }

    public List<String> a(String paramString) {
        Object localObject = null;
        String str = this.c.getString(paramString, null);
        paramString = (String) localObject;
        if (str != null) {
            if (str.contains("\r\n")) {
                paramString = Arrays.asList(str.split("\r\n"));
            }
        } else {
            return paramString;
        }
        return Arrays.asList(new String[]{str});
    }

    public void a(SharedPreferences paramSharedPreferences) {
        this.c = paramSharedPreferences;
    }

    public boolean a(String paramString, boolean paramBoolean) {
        return this.c.getBoolean(paramString, paramBoolean);
    }

    public byte[] b(String paramString) {
        Object localObject = null;
        String str = this.c.getString(paramString, null);
        paramString = (String) localObject;
        if (str != null) {
            paramString = j.b(str);
        }
        return paramString;
    }

    public boolean c(String paramString) {
        return this.c.contains(paramString);
    }

    public static class a {
        private SharedPreferences.Editor a;

        public a(SharedPreferences.Editor paramEditor) {
            this.a = paramEditor;
        }

        public a a() {
            this.a.clear();
            return this;
        }

        public a a(String paramString) {
            this.a.remove(paramString);
            return this;
        }

        public a a(String paramString, float paramFloat) {
            this.a.putFloat(paramString, paramFloat);
            return this;
        }

        public a a(String paramString, int paramInt) {
            this.a.putInt(paramString, paramInt);
            return this;
        }

        public a a(String paramString, long paramLong) {
            this.a.putLong(paramString, paramLong);
            return this;
        }

        public a a(String paramString1, String paramString2) {
            this.a.putString(paramString1, paramString2);
            return this;
        }

        public a a(String paramString, List<String> paramList) {
            StringBuilder localStringBuilder = new StringBuilder();
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                localStringBuilder.append((String) paramList.next());
                localStringBuilder.append("\r\n");
            }
            int i = localStringBuilder.length();
            if (i > 0) {
                localStringBuilder.delete(i - 2, i);
            }
            this.a.putString(paramString, localStringBuilder.toString());
            return this;
        }

        public a a(String paramString, boolean paramBoolean) {
            this.a.putBoolean(paramString, paramBoolean);
            return this;
        }

        public a a(String paramString, byte[] paramArrayOfByte) {
            paramArrayOfByte = j.a(paramArrayOfByte);
            this.a.putString(paramString, paramArrayOfByte);
            return this;
        }

        public void b() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.a.apply();
                return;
            }
            d.a(new e() {
                public void a() {
                    m.a.a(m.a.this).commit();
                }
            });
        }

        public boolean c() {
            return this.a.commit();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */