package net.hockeyapp.android.d;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import net.hockeyapp.android.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    ArrayList<JSONObject> a;
    JSONObject b;
    q c;

    public f(String paramString, q paramq) {
        this.c = paramq;
        a(paramString);
        c();
    }

    public static int a(String paramString1, String paramString2) {
        int j = -1;
        int i;
        if ((paramString1 == null) || (paramString2 == null)) {
            i = 0;
        }
        for (; ; ) {
            return i;
            try {
                paramString1 = new Scanner(paramString1.replaceAll("\\-.*", ""));
                paramString2 = new Scanner(paramString2.replaceAll("\\-.*", ""));
                paramString1.useDelimiter("\\.");
                paramString2.useDelimiter("\\.");
                for (; ; ) {
                    if ((paramString1.hasNextInt()) && (paramString2.hasNextInt())) {
                        int k = paramString1.nextInt();
                        int m = paramString2.nextInt();
                        i = j;
                        if (k < m) {
                            break;
                        }
                        if (k > m) {
                            return 1;
                        }
                    }
                }
                if (paramString1.hasNextInt()) {
                    return 1;
                }
                boolean bool = paramString2.hasNextInt();
                i = j;
                if (!bool) {
                    return 0;
                }
            } catch (Exception paramString1) {
            }
        }
        return 0;
    }

    private static int a(JSONObject paramJSONObject, String paramString, int paramInt) {
        try {
            int i = paramJSONObject.getInt(paramString);
            return i;
        } catch (JSONException paramJSONObject) {
        }
        return paramInt;
    }

    private String a(int paramInt, JSONObject paramJSONObject) {
        StringBuilder localStringBuilder = new StringBuilder();
        paramJSONObject = a(paramJSONObject);
        if (paramJSONObject.length() > 0) {
            localStringBuilder.append("<a href='restore:" + paramJSONObject + "'  style='background: #c8c8c8; color: #000; display: block; float: right; padding: 7px; margin: 0px 10px 10px; text-decoration: none;'>Restore</a>");
        }
        return localStringBuilder.toString();
    }

    private String a(JSONObject paramJSONObject) {
        try {
            paramJSONObject = paramJSONObject.getString("id");
            return paramJSONObject;
        } catch (JSONException paramJSONObject) {
        }
        return "";
    }

    private static String a(JSONObject paramJSONObject, String paramString1, String paramString2) {
        try {
            paramJSONObject = paramJSONObject.getString(paramString1);
            return paramJSONObject;
        } catch (JSONException paramJSONObject) {
        }
        return paramString2;
    }

    private void a(String paramString) {
        this.b = new JSONObject();
        this.a = new ArrayList();
        try {
            paramString = new JSONArray(paramString);
            int j = this.c.e();
            int i = 0;
            while (i < paramString.length()) {
                JSONObject localJSONObject = paramString.getJSONObject(i);
                int k = j;
                if (localJSONObject.getInt("version") > j) {
                    this.b = localJSONObject;
                    k = localJSONObject.getInt("version");
                }
                this.a.add(localJSONObject);
                i += 1;
                j = k;
            }
            return;
        } catch (NullPointerException paramString) {
            return;
        } catch (JSONException paramString) {
        }
    }

    private int b(JSONObject paramJSONObject) {
        try {
            int i = paramJSONObject.getInt("version");
            return i;
        } catch (JSONException paramJSONObject) {
        }
        return 0;
    }

    private String b(int paramInt, JSONObject paramJSONObject) {
        StringBuilder localStringBuilder1 = new StringBuilder();
        int i = b(paramJSONObject);
        paramJSONObject = c(paramJSONObject);
        localStringBuilder1.append("<div style='padding: 20px 10px 10px;'><strong>");
        if (paramInt == 0) {
            localStringBuilder1.append("Newest version:");
            localStringBuilder1.append("</strong></div>");
            return localStringBuilder1.toString();
        }
        paramInt = this.c.e();
        StringBuilder localStringBuilder2 = new StringBuilder().append("Version ").append(paramJSONObject).append(" (").append(i).append("): ");
        if (i == paramInt) {
        }
        for (paramJSONObject = "[INSTALLED]"; ; paramJSONObject = "") {
            localStringBuilder1.append(paramJSONObject);
            break;
        }
    }

    private String c(int paramInt, JSONObject paramJSONObject) {
        StringBuilder localStringBuilder = new StringBuilder();
        paramJSONObject = a(paramJSONObject, "notes", "");
        localStringBuilder.append("<div style='padding: 0px 10px;'>");
        if (paramJSONObject.trim().length() == 0) {
            localStringBuilder.append("<em>No information.</em>");
        }
        for (; ; ) {
            localStringBuilder.append("</div>");
            return localStringBuilder.toString();
            localStringBuilder.append(paramJSONObject);
        }
    }

    private String c(JSONObject paramJSONObject) {
        try {
            paramJSONObject = paramJSONObject.getString("shortversion");
            return paramJSONObject;
        } catch (JSONException paramJSONObject) {
        }
        return "";
    }

    private void c() {
        Collections.sort(this.a, new g(this));
    }

    private Object d() {
        return "<hr style='border-top: 1px solid #c8c8c8; border-bottom: 0px; margin: 40px 10px 0px 10px;' />";
    }

    public String a() {
        return a(this.b, "shortversion", "") + " (" + a(this.b, "version", "") + ")";
    }

    public String a(boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<html>");
        localStringBuilder.append("<body style='padding: 0px 0px 20px 0px'>");
        Iterator localIterator = this.a.iterator();
        int i = 0;
        while (localIterator.hasNext()) {
            JSONObject localJSONObject = (JSONObject) localIterator.next();
            if (i > 0) {
                localStringBuilder.append(d());
                if (paramBoolean) {
                    localStringBuilder.append(a(i, localJSONObject));
                }
            }
            localStringBuilder.append(b(i, localJSONObject));
            localStringBuilder.append(c(i, localJSONObject));
            i += 1;
        }
        localStringBuilder.append("</body>");
        localStringBuilder.append("</html>");
        return localStringBuilder.toString();
    }

    public String b() {
        int i = a(this.b, "appsize", 0);
        Date localDate = new Date(a(this.b, "timestamp", 0) * 1000L);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return localSimpleDateFormat.format(localDate) + " - " + String.format("%.2f", new Object[]{Float.valueOf(i / 1024.0F / 1024.0F)}) + " MB";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */