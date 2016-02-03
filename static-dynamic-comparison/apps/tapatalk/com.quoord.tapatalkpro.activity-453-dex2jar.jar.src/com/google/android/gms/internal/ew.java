package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ew {
    private static final String[] Ac = {"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String Ad = "yyyyMMdd'T'HHmmss" + Ac[0];
    private static final er zb = new er("MetadataUtils");

    public static String a(Calendar paramCalendar) {
        if (paramCalendar == null) {
            zb.b("Calendar object cannot be null", new Object[0]);
            paramCalendar = null;
        }
        Object localObject;
        do {
            return paramCalendar;
            String str = Ad;
            localObject = str;
            if (paramCalendar.get(11) == 0) {
                localObject = str;
                if (paramCalendar.get(12) == 0) {
                    localObject = str;
                    if (paramCalendar.get(13) == 0) {
                        localObject = "yyyyMMdd";
                    }
                }
            }
            localObject = new SimpleDateFormat((String) localObject);
            ((SimpleDateFormat) localObject).setTimeZone(paramCalendar.getTimeZone());
            localObject = ((SimpleDateFormat) localObject).format(paramCalendar.getTime());
            paramCalendar = (Calendar) localObject;
        } while (!((String) localObject).endsWith("+0000"));
        return ((String) localObject).replace("+0000", Ac[0]);
    }

    /* Error */
    public static void a(List<WebImage> paramList, JSONObject paramJSONObject) {
        // Byte code:
        //   0: aload_0
        //   1: invokeinterface 106 1 0
        //   6: aload_1
        //   7: ldc 108
        //   9: invokevirtual 114	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   12: astore_1
        //   13: aload_1
        //   14: invokevirtual 120	org/json/JSONArray:length	()I
        //   17: istore_3
        //   18: iconst_0
        //   19: istore_2
        //   20: iload_2
        //   21: iload_3
        //   22: if_icmpge +34 -> 56
        //   25: aload_1
        //   26: iload_2
        //   27: invokevirtual 124	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
        //   30: astore 4
        //   32: aload_0
        //   33: new 126	com/google/android/gms/common/images/WebImage
        //   36: dup
        //   37: aload 4
        //   39: invokespecial 129	com/google/android/gms/common/images/WebImage:<init>	(Lorg/json/JSONObject;)V
        //   42: invokeinterface 133 2 0
        //   47: pop
        //   48: iload_2
        //   49: iconst_1
        //   50: iadd
        //   51: istore_2
        //   52: goto -32 -> 20
        //   55: astore_0
        //   56: return
        //   57: astore 4
        //   59: goto -11 -> 48
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	62	0	paramList	List<WebImage>
        //   0	62	1	paramJSONObject	JSONObject
        //   19	33	2	i	int
        //   17	6	3	j	int
        //   30	8	4	localJSONObject	JSONObject
        //   57	1	4	localIllegalArgumentException	IllegalArgumentException
        // Exception table:
        //   from	to	target	type
        //   0	18	55	org/json/JSONException
        //   25	32	55	org/json/JSONException
        //   32	48	55	org/json/JSONException
        //   32	48	57	java/lang/IllegalArgumentException
    }

    public static void a(JSONObject paramJSONObject, List<WebImage> paramList) {
        JSONArray localJSONArray;
        if ((paramList != null) && (!paramList.isEmpty())) {
            localJSONArray = new JSONArray();
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                localJSONArray.put(((WebImage) paramList.next()).dB());
            }
        }
        try {
            paramJSONObject.put("images", localJSONArray);
            return;
        } catch (JSONException paramJSONObject) {
        }
    }

    public static Calendar ac(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            zb.b("Input string is empty or null", new Object[0]);
            return null;
        }
        Object localObject2 = ad(paramString);
        if (TextUtils.isEmpty((CharSequence) localObject2)) {
            zb.b("Invalid date format", new Object[0]);
            return null;
        }
        String str = ae(paramString);
        paramString = "yyyyMMdd";
        Object localObject1 = localObject2;
        if (!TextUtils.isEmpty(str)) {
            localObject1 = (String) localObject2 + "T" + str;
            if (str.length() != "HHmmss".length()) {
                break label127;
            }
        }
        for (paramString = "yyyyMMdd'T'HHmmss"; ; paramString = Ad) {
            localObject2 = GregorianCalendar.getInstance();
            try {
                paramString = new SimpleDateFormat(paramString).parse((String) localObject1);
                ((Calendar) localObject2).setTime(paramString);
                return (Calendar) localObject2;
            } catch (ParseException paramString) {
                label127:
                zb.b("Error parsing string: %s", new Object[]{paramString.getMessage()});
            }
        }
        return null;
    }

    private static String ad(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            zb.b("Input string is empty or null", new Object[0]);
            return null;
        }
        try {
            paramString = paramString.substring(0, "yyyyMMdd".length());
            return paramString;
        } catch (IndexOutOfBoundsException paramString) {
            zb.c("Error extracting the date: %s", new Object[]{paramString.getMessage()});
        }
        return null;
    }

    private static String ae(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            zb.b("string is empty or null", new Object[0]);
        }
        do {
            do {
                return null;
                int i = paramString.indexOf('T');
                if (i != "yyyyMMdd".length()) {
                    zb.b("T delimeter is not found", new Object[0]);
                    return null;
                }
                try {
                    paramString = paramString.substring(i + 1);
                    if (paramString.length() == "HHmmss".length()) {
                        return paramString;
                    }
                } catch (IndexOutOfBoundsException paramString) {
                    zb.b("Error extracting the time substring: %s", new Object[]{paramString.getMessage()});
                    return null;
                }
                switch (paramString.charAt("HHmmss".length())) {
                    default:
                        return null;
                }
            } while (!af(paramString));
            return paramString.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
        } while (paramString.length() != "HHmmss".length() + Ac[0].length());
        return paramString.substring(0, paramString.length() - 1) + "+0000";
    }

    private static boolean af(String paramString) {
        int i = paramString.length();
        int j = "HHmmss".length();
        return (i == Ac[1].length() + j) || (i == Ac[2].length() + j) || (i == j + Ac[3].length());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */