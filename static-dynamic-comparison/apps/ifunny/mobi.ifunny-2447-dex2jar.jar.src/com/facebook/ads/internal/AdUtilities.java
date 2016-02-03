package com.facebook.ads.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

class AdUtilities {
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

    public static void closeQuietly(Closeable paramCloseable) {
        if (paramCloseable == null) {
            return;
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException paramCloseable) {
        }
    }

    public static String getAttributionId(ContentResolver paramContentResolver) {
        try {
            paramContentResolver = paramContentResolver.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, null, null, null);
            if ((paramContentResolver != null) && (paramContentResolver.moveToFirst())) {
                String str = paramContentResolver.getString(paramContentResolver.getColumnIndex("aid"));
                paramContentResolver.close();
                return str;
            }
        } catch (Exception paramContentResolver) {
            return null;
        }
        return null;
    }

    public static Method getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
        try {
            paramClass = paramClass.getMethod(paramString, paramVarArgs);
            return paramClass;
        } catch (NoSuchMethodException paramClass) {
        }
        return null;
    }

    public static Method getMethod(String paramString1, String paramString2, Class<?>... paramVarArgs) {
        try {
            paramString1 = getMethod(Class.forName(paramString1), paramString2, paramVarArgs);
            return paramString1;
        } catch (ClassNotFoundException paramString1) {
        }
        return null;
    }

    public static Object getStringPropertyAsJSON(JSONObject paramJSONObject, String paramString) {
        Object localObject = paramJSONObject.opt(paramString);
        paramJSONObject = (JSONObject) localObject;
        if (localObject != null) {
            paramJSONObject = (JSONObject) localObject;
            if ((localObject instanceof String)) {
                paramJSONObject = new JSONTokener((String) localObject).nextValue();
            }
        }
        if ((paramJSONObject != null) && (!(paramJSONObject instanceof JSONObject)) && (!(paramJSONObject instanceof JSONArray))) {
            throw new IllegalArgumentException(paramString);
        }
        return paramJSONObject;
    }

    public static Object invokeMethod(Object paramObject, Method paramMethod, Object... paramVarArgs) {
        try {
            paramObject = paramMethod.invoke(paramObject, paramVarArgs);
            return paramObject;
        } catch (Exception paramObject) {
        }
        return null;
    }

    public static String jsonEncode(Map<String, Object> paramMap) {
        JSONObject localJSONObject = new JSONObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            try {
                localJSONObject.put((String) localEntry.getKey(), localEntry.getValue());
            } catch (JSONException localJSONException) {
                localJSONException.printStackTrace();
            }
        }
        return localJSONObject.toString();
    }

    /* Error */
    public static String readStreamToString(java.io.InputStream paramInputStream) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: new 162	java/io/BufferedInputStream
        //   5: dup
        //   6: aload_0
        //   7: invokespecial 165	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   10: astore_0
        //   11: new 167	java/io/InputStreamReader
        //   14: dup
        //   15: aload_0
        //   16: invokespecial 168	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   19: astore_2
        //   20: new 170	java/lang/StringBuilder
        //   23: dup
        //   24: invokespecial 171	java/lang/StringBuilder:<init>	()V
        //   27: astore_3
        //   28: sipush 2048
        //   31: newarray <illegal type>
        //   33: astore 4
        //   35: aload_2
        //   36: aload 4
        //   38: invokevirtual 175	java/io/InputStreamReader:read	([C)I
        //   41: istore_1
        //   42: iload_1
        //   43: iconst_m1
        //   44: if_icmpeq +32 -> 76
        //   47: aload_3
        //   48: aload 4
        //   50: iconst_0
        //   51: iload_1
        //   52: invokevirtual 179	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
        //   55: pop
        //   56: goto -21 -> 35
        //   59: astore 4
        //   61: aload_0
        //   62: astore_3
        //   63: aload 4
        //   65: astore_0
        //   66: aload_3
        //   67: invokestatic 181	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   70: aload_2
        //   71: invokestatic 181	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   74: aload_0
        //   75: athrow
        //   76: aload_3
        //   77: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   80: astore_3
        //   81: aload_0
        //   82: invokestatic 181	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   85: aload_2
        //   86: invokestatic 181	com/facebook/ads/internal/AdUtilities:closeQuietly	(Ljava/io/Closeable;)V
        //   89: aload_3
        //   90: areturn
        //   91: astore_0
        //   92: aconst_null
        //   93: astore_2
        //   94: goto -28 -> 66
        //   97: astore 4
        //   99: aconst_null
        //   100: astore_2
        //   101: aload_0
        //   102: astore_3
        //   103: aload 4
        //   105: astore_0
        //   106: goto -40 -> 66
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	109	0	paramInputStream	java.io.InputStream
        //   41	11	1	i	int
        //   19	82	2	localInputStreamReader	java.io.InputStreamReader
        //   1	102	3	localObject1	Object
        //   33	16	4	arrayOfChar	char[]
        //   59	5	4	localObject2	Object
        //   97	7	4	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   20	35	59	finally
        //   35	42	59	finally
        //   47	56	59	finally
        //   76	81	59	finally
        //   2	11	91	finally
        //   11	20	97	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */