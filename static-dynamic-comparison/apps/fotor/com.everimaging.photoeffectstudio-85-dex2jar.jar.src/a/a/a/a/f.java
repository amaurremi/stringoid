package a.a.a.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class f {
    private ArrayList<e> a;
    private c b;

    public f(c paramc) {
        this.b = paramc;
        this.a = this.b.c();
    }

    public int a() {
        try {
            int i = this.a.size();
            return i;
        } finally {
        }
    }

    public void a(String paramString, int paramInt) {
        int i = 0;
        for (; ; ) {
            try {
                e locale;
                if (i < this.a.size()) {
                    locale = (e) this.a.get(i);
                    if (locale.a.equals(paramString)) {
                        locale.c += paramInt;
                        locale.e = Math.round((float) ((locale.e + System.currentTimeMillis() / 1000L) / 2L));
                        this.b.a(this.a);
                    }
                } else {
                    locale = new e();
                    locale.a = paramString;
                    locale.c = paramInt;
                    locale.e = Math.round((float) (System.currentTimeMillis() / 1000L));
                    this.a.add(locale);
                    this.b.a(this.a);
                    return;
                }
            } finally {
            }
            i += 1;
        }
    }

    public void a(String paramString, Map<String, String> paramMap, int paramInt) {
        int i = 0;
        for (; ; ) {
            try {
                e locale;
                if (i < this.a.size()) {
                    locale = (e) this.a.get(i);
                    if ((locale.a.equals(paramString)) && (locale.b != null) && (locale.b.equals(paramMap))) {
                        locale.c += paramInt;
                        locale.e = Math.round((float) ((locale.e + System.currentTimeMillis() / 1000L) / 2L));
                        this.b.a(this.a);
                    }
                } else {
                    locale = new e();
                    locale.a = paramString;
                    locale.b = paramMap;
                    locale.c = paramInt;
                    locale.e = Math.round((float) (System.currentTimeMillis() / 1000L));
                    this.a.add(locale);
                    this.b.a(this.a);
                    return;
                }
            } finally {
            }
            i += 1;
        }
    }

    public String b() {
        Object localObject2;
        try {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (; ; ) {
                if (i < this.a.size()) {
                    localObject2 = new JSONObject();
                    e locale = (e) this.a.get(i);
                    try {
                        ((JSONObject) localObject2).put("key", locale.a);
                        ((JSONObject) localObject2).put("count", locale.c);
                        ((JSONObject) localObject2).put("sum", locale.d);
                        ((JSONObject) localObject2).put("timestamp", locale.e);
                        if (locale.b != null) {
                            ((JSONObject) localObject2).put("segmentation", new JSONObject(locale.b));
                        }
                        localJSONArray.put(localObject2);
                        i += 1;
                    } catch (JSONException localJSONException) {
                        for (; ; ) {
                            localJSONException.printStackTrace();
                        }
                    }
                }
            }
            str = ((JSONArray) localObject1).toString();
        } finally {
        }
        String str;
        this.a.clear();
        this.b.d();
        try {
            localObject2 = URLEncoder.encode(str, "UTF-8");
            return (String) localObject2;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        return str;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/a/a/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */