package twitter4j;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class JSONObject {
    public static final Object NULL = new JSONObject.Null(null);
    private final Map map = new HashMap();

    public JSONObject() {
    }

    public JSONObject(Object paramObject) {
        this();
        populateMap(paramObject);
    }

    public JSONObject(Object paramObject, String[] paramArrayOfString) {
        this();
        Class localClass = paramObject.getClass();
        int j = paramArrayOfString.length;
        int i = 0;
        for (; ; ) {
            String str;
            if (i < j) {
                str = paramArrayOfString[i];
            }
            try {
                putOpt(str, localClass.getField(str).get(paramObject));
                i += 1;
                continue;
                return;
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public JSONObject(String paramString) {
        this(new JSONTokener(paramString));
    }

    public JSONObject(String paramString, Locale paramLocale) {
        this();
        ResourceBundle localResourceBundle = ResourceBundle.getBundle(paramString, paramLocale, Thread.currentThread().getContextClassLoader());
        Enumeration localEnumeration = localResourceBundle.getKeys();
        while (localEnumeration.hasMoreElements()) {
            Object localObject2 = localEnumeration.nextElement();
            if ((localObject2 instanceof String)) {
                String[] arrayOfString = ((String) localObject2).split("\\.");
                int j = arrayOfString.length - 1;
                int i = 0;
                Object localObject1 = this;
                if (i < j) {
                    String str = arrayOfString[i];
                    paramString = ((JSONObject) localObject1).opt(str);
                    if ((paramString instanceof JSONObject)) {
                    }
                    for (paramString = (JSONObject) paramString; ; paramString = null) {
                        paramLocale = paramString;
                        if (paramString == null) {
                            paramLocale = new JSONObject();
                            ((JSONObject) localObject1).put(str, paramLocale);
                        }
                        i += 1;
                        localObject1 = paramLocale;
                        break;
                    }
                }
                ((JSONObject) localObject1).put(arrayOfString[j], localResourceBundle.getString((String) localObject2));
            }
        }
    }

    public JSONObject(Map paramMap) {
        if (paramMap != null) {
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                Map.Entry localEntry = (Map.Entry) paramMap.next();
                Object localObject = localEntry.getValue();
                if (localObject != null) {
                    this.map.put(localEntry.getKey(), wrap(localObject));
                }
            }
        }
    }

    public JSONObject(JSONObject paramJSONObject, String[] paramArrayOfString) {
        this();
        int j = paramArrayOfString.length;
        int i = 0;
        for (; ; ) {
            String str;
            if (i < j) {
                str = paramArrayOfString[i];
            }
            try {
                putOnce(str, paramJSONObject.opt(str));
                i += 1;
                continue;
                return;
            } catch (Exception localException) {
                for (; ; ) {
                }
            }
        }
    }

    public JSONObject(JSONTokener paramJSONTokener) {
        this();
        if (paramJSONTokener.nextClean() != '{') {
            throw paramJSONTokener.syntaxError("A JSONObject text must begin with '{' found:" + paramJSONTokener.nextClean());
        }
        do {
            paramJSONTokener.back();
            String str;
            int i;
            switch (paramJSONTokener.nextClean()) {
                default:
                    paramJSONTokener.back();
                    str = paramJSONTokener.nextValue().toString();
                    i = paramJSONTokener.nextClean();
                    if (i == 61) {
                        if (paramJSONTokener.next() != '>') {
                            paramJSONTokener.back();
                        }
                    }
                case '\000':
                    while (i == 58) {
                        putOnce(str, paramJSONTokener.nextValue());
                        switch (paramJSONTokener.nextClean()) {
                            default:
                                throw paramJSONTokener.syntaxError("Expected a ',' or '}'");
                                throw paramJSONTokener.syntaxError("A JSONObject text must end with '}'");
                        }
                    }
                    throw paramJSONTokener.syntaxError("Expected a ':' after a key");
            }
        } while (paramJSONTokener.nextClean() != '}');
    }

    public static String numberToString(Number paramNumber) {
        if (paramNumber == null) {
            throw new JSONException("Null pointer");
        }
        testValidity(paramNumber);
        String str = paramNumber.toString();
        paramNumber = str;
        if (str.indexOf('.') > 0) {
            paramNumber = str;
            if (str.indexOf('e') < 0) {
                paramNumber = str;
                if (str.indexOf('E') < 0) {
                    while (str.endsWith("0")) {
                        str = str.substring(0, str.length() - 1);
                    }
                    paramNumber = str;
                    if (str.endsWith(".")) {
                        paramNumber = str.substring(0, str.length() - 1);
                    }
                }
            }
        }
        return paramNumber;
    }

    private void populateMap(Object paramObject) {
        Object localObject1 = paramObject.getClass();
        int i;
        Method[] arrayOfMethod;
        label27:
        label33:
        Object localObject2;
        if (((Class) localObject1).getClassLoader() != null) {
            i = 1;
            if (i == 0) {
                break label190;
            }
            arrayOfMethod = ((Class) localObject1).getMethods();
            int j = arrayOfMethod.length;
            i = 0;
            if (i >= j) {
                break label282;
            }
            localObject2 = arrayOfMethod[i];
        }
        try {
            if (!Modifier.isPublic(((Method) localObject2).getModifiers())) {
                break label178;
            }
            str2 = ((Method) localObject2).getName();
            localObject1 = "";
            if (!str2.startsWith("get")) {
                break label211;
            }
            if (str2.equals("getClass")) {
                break label291;
            }
            if (!str2.equals("getDeclaringClass")) {
                break label200;
            }
        } catch (Exception localException) {
            for (; ; ) {
                String str2;
                label99:
                continue;
                continue;
                String str1 = "";
            }
        }
        if ((((String) localObject1).length() > 0) && (Character.isUpperCase(((String) localObject1).charAt(0))) && (((Method) localObject2).getParameterTypes().length == 0)) {
            if (((String) localObject1).length() != 1) {
                break label233;
            }
        }
        for (localObject1 = ((String) localObject1).toLowerCase(); ; localObject1 = ((String) localObject1).substring(0, 1).toLowerCase() + ((String) localObject1).substring(1)) {
            localObject2 = ((Method) localObject2).invoke(paramObject, (Object[]) null);
            if (localObject2 != null) {
                this.map.put(localObject1, wrap(localObject2));
            }
            label178:
            i += 1;
            break label33;
            i = 0;
            break;
            label190:
            arrayOfMethod = ((Class) localObject1).getDeclaredMethods();
            break label27;
            label200:
            localObject1 = str2.substring(3);
            break label99;
            label211:
            if (!str2.startsWith("is")) {
                break label99;
            }
            localObject1 = str2.substring(2);
            break label99;
            label233:
            if (Character.isUpperCase(((String) localObject1).charAt(1))) {
                break label288;
            }
        }
        label282:
    }

    public static String quote(String paramString) {
        int i = 0;
        if ((paramString == null) || (paramString.length() == 0)) {
            return "\"\"";
        }
        int k = paramString.length();
        StringBuilder localStringBuilder = new StringBuilder(k + 4);
        localStringBuilder.append('"');
        int j = 0;
        if (i < k) {
            char c = paramString.charAt(i);
            switch (c) {
                default:
                    if ((c < ' ') || ((c >= '') && (c < ' ')) || ((c >= ' ') && (c < '℀'))) {
                        String str = "000" + Integer.toHexString(c);
                        localStringBuilder.append("\\u").append(str.substring(str.length() - 4));
                    }
                    break;
            }
            for (; ; ) {
                i += 1;
                j = c;
                break;
                localStringBuilder.append('\\');
                localStringBuilder.append(c);
                continue;
                if (j == 60) {
                    localStringBuilder.append('\\');
                }
                localStringBuilder.append(c);
                continue;
                localStringBuilder.append("\\b");
                continue;
                localStringBuilder.append("\\t");
                continue;
                localStringBuilder.append("\\n");
                continue;
                localStringBuilder.append("\\f");
                continue;
                localStringBuilder.append("\\r");
                continue;
                localStringBuilder.append(c);
            }
        }
        localStringBuilder.append('"');
        return localStringBuilder.toString();
    }

    public static Object stringToValue(String paramString) {
        if (paramString.equals("")) {
        }
        int i;
        do {
            return paramString;
            if (paramString.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (paramString.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            if (paramString.equalsIgnoreCase("null")) {
                return NULL;
            }
            i = paramString.charAt(0);
        } while (((i < 48) || (i > 57)) && (i != 46) && (i != 45) && (i != 43));
        if ((i == 48) && (paramString.length() > 2) && ((paramString.charAt(1) == 'x') || (paramString.charAt(1) == 'X'))) {
            try {
                i = Integer.parseInt(paramString.substring(2), 16);
                return Integer.valueOf(i);
            } catch (Exception localException1) {
            }
        }
        try {
            if ((paramString.indexOf('.') > -1) || (paramString.indexOf('e') > -1) || (paramString.indexOf('E') > -1)) {
                return Double.valueOf(paramString);
            }
            Long localLong = new Long(paramString);
            if (localLong.longValue() == localLong.intValue()) {
                i = localLong.intValue();
                return Integer.valueOf(i);
            }
            return localLong;
        } catch (Exception localException2) {
        }
        return paramString;
    }

    public static void testValidity(Object paramObject) {
        if (paramObject != null) {
            if ((paramObject instanceof Double)) {
                if ((((Double) paramObject).isInfinite()) || (((Double) paramObject).isNaN())) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else if (((paramObject instanceof Float)) && ((((Float) paramObject).isInfinite()) || (((Float) paramObject).isNaN()))) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    public static String valueToString(Object paramObject) {
        if ((paramObject == null) || (paramObject.equals(null))) {
            return "null";
        }
        if ((paramObject instanceof Number)) {
            return numberToString((Number) paramObject);
        }
        if (((paramObject instanceof Boolean)) || ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray))) {
            return paramObject.toString();
        }
        if ((paramObject instanceof Map)) {
            return new JSONObject((Map) paramObject).toString();
        }
        if ((paramObject instanceof Collection)) {
            return new JSONArray((Collection) paramObject).toString();
        }
        if (paramObject.getClass().isArray()) {
            return new JSONArray(paramObject).toString();
        }
        return quote(paramObject.toString());
    }

    static String valueToString(Object paramObject, int paramInt1, int paramInt2) {
        if ((paramObject == null) || (paramObject.equals(null))) {
            return "null";
        }
        if ((paramObject instanceof Number)) {
            return numberToString((Number) paramObject);
        }
        if ((paramObject instanceof Boolean)) {
            return paramObject.toString();
        }
        if ((paramObject instanceof JSONObject)) {
            return ((JSONObject) paramObject).toString(paramInt1, paramInt2);
        }
        if ((paramObject instanceof JSONArray)) {
            return ((JSONArray) paramObject).toString(paramInt1, paramInt2);
        }
        if ((paramObject instanceof Map)) {
            return new JSONObject((Map) paramObject).toString(paramInt1, paramInt2);
        }
        if ((paramObject instanceof Collection)) {
            return new JSONArray((Collection) paramObject).toString(paramInt1, paramInt2);
        }
        if (paramObject.getClass().isArray()) {
            return new JSONArray(paramObject).toString(paramInt1, paramInt2);
        }
        return quote(paramObject.toString());
    }

    public static Object wrap(Object paramObject) {
        if (paramObject == null) {
        }
        try {
            return NULL;
        } catch (Exception paramObject) {
            localObject = null;
        }
        Object localObject = paramObject;
        if (!(paramObject instanceof JSONObject)) {
            localObject = paramObject;
            if (!(paramObject instanceof JSONArray)) {
                localObject = paramObject;
                if (!NULL.equals(paramObject)) {
                    localObject = paramObject;
                    if (!(paramObject instanceof Byte)) {
                        localObject = paramObject;
                        if (!(paramObject instanceof Character)) {
                            localObject = paramObject;
                            if (!(paramObject instanceof Short)) {
                                localObject = paramObject;
                                if (!(paramObject instanceof Integer)) {
                                    localObject = paramObject;
                                    if (!(paramObject instanceof Long)) {
                                        localObject = paramObject;
                                        if (!(paramObject instanceof Boolean)) {
                                            localObject = paramObject;
                                            if (!(paramObject instanceof Float)) {
                                                localObject = paramObject;
                                                if (!(paramObject instanceof Double)) {
                                                    localObject = paramObject;
                                                    if (!(paramObject instanceof String)) {
                                                        if ((paramObject instanceof Collection)) {
                                                            return new JSONArray((Collection) paramObject);
                                                        }
                                                        if (paramObject.getClass().isArray()) {
                                                            return new JSONArray(paramObject);
                                                        }
                                                        if ((paramObject instanceof Map)) {
                                                            return new JSONObject((Map) paramObject);
                                                        }
                                                        localObject = paramObject.getClass().getPackage();
                                                        if (localObject == null) {
                                                            break label244;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        label244:
        for (localObject = ((Package) localObject).getName(); ; localObject = "") {
            if ((((String) localObject).startsWith("java.")) || (((String) localObject).startsWith("javax.")) || (paramObject.getClass().getClassLoader() == null)) {
                return paramObject.toString();
            }
            paramObject = new JSONObject(paramObject);
            return paramObject;
            return localObject;
        }
    }

    public JSONObject append(String paramString, Object paramObject) {
        testValidity(paramObject);
        Object localObject = opt(paramString);
        if (localObject == null) {
            put(paramString, new JSONArray().put(paramObject));
            return this;
        }
        if ((localObject instanceof JSONArray)) {
            put(paramString, ((JSONArray) localObject).put(paramObject));
            return this;
        }
        throw new JSONException("JSONObject[" + paramString + "] is not a JSONArray.");
    }

    public Object get(String paramString) {
        if (paramString == null) {
            throw new JSONException("Null key.");
        }
        Object localObject = opt(paramString);
        if (localObject == null) {
            throw new JSONException("JSONObject[" + quote(paramString) + "] not found.");
        }
        return localObject;
    }

    public boolean getBoolean(String paramString) {
        Object localObject = get(paramString);
        if ((localObject.equals(Boolean.FALSE)) || (((localObject instanceof String)) && (((String) localObject).equalsIgnoreCase("false")))) {
            return false;
        }
        if ((localObject.equals(Boolean.TRUE)) || (((localObject instanceof String)) && (((String) localObject).equalsIgnoreCase("true")))) {
            return true;
        }
        throw new JSONException("JSONObject[" + quote(paramString) + "] is not a Boolean.");
    }

    public int getInt(String paramString) {
        Object localObject = get(paramString);
        try {
            if ((localObject instanceof Number)) {
                return ((Number) localObject).intValue();
            }
            int i = Integer.parseInt((String) localObject);
            return i;
        } catch (Exception localException) {
            throw new JSONException("JSONObject[" + quote(paramString) + "] is not an int.");
        }
    }

    public JSONArray getJSONArray(String paramString) {
        Object localObject = get(paramString);
        if ((localObject instanceof JSONArray)) {
            return (JSONArray) localObject;
        }
        throw new JSONException("JSONObject[" + quote(paramString) + "] is not a JSONArray.");
    }

    public JSONObject getJSONObject(String paramString) {
        Object localObject = get(paramString);
        if ((localObject instanceof JSONObject)) {
            return (JSONObject) localObject;
        }
        throw new JSONException("JSONObject[" + quote(paramString) + "] is not a JSONObject.");
    }

    public long getLong(String paramString) {
        Object localObject = get(paramString);
        try {
            if ((localObject instanceof Number)) {
                return ((Number) localObject).longValue();
            }
            long l = Long.parseLong((String) localObject);
            return l;
        } catch (Exception localException) {
            throw new JSONException("JSONObject[" + quote(paramString) + "] is not a long.");
        }
    }

    public String getString(String paramString) {
        paramString = get(paramString);
        if (paramString == NULL) {
            return null;
        }
        return paramString.toString();
    }

    public boolean has(String paramString) {
        return this.map.containsKey(paramString);
    }

    public boolean isNull(String paramString) {
        return NULL.equals(opt(paramString));
    }

    public Iterator keys() {
        return this.map.keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        JSONArray localJSONArray = new JSONArray();
        Object localObject = keys();
        while (((Iterator) localObject).hasNext()) {
            localJSONArray.put(((Iterator) localObject).next());
        }
        localObject = localJSONArray;
        if (localJSONArray.length() == 0) {
            localObject = null;
        }
        return (JSONArray) localObject;
    }

    public Object opt(String paramString) {
        if (paramString == null) {
            return null;
        }
        return this.map.get(paramString);
    }

    public JSONObject put(String paramString, double paramDouble) {
        put(paramString, new Double(paramDouble));
        return this;
    }

    public JSONObject put(String paramString, int paramInt) {
        put(paramString, new Integer(paramInt));
        return this;
    }

    public JSONObject put(String paramString, long paramLong) {
        put(paramString, new Long(paramLong));
        return this;
    }

    public JSONObject put(String paramString, Object paramObject) {
        if (paramString == null) {
            throw new JSONException("Null key.");
        }
        if (paramObject != null) {
            testValidity(paramObject);
            this.map.put(paramString, paramObject);
            return this;
        }
        remove(paramString);
        return this;
    }

    public JSONObject put(String paramString, Collection paramCollection) {
        put(paramString, new JSONArray(paramCollection));
        return this;
    }

    public JSONObject put(String paramString, Map paramMap) {
        put(paramString, new JSONObject(paramMap));
        return this;
    }

    public JSONObject put(String paramString, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE) {
            put(paramString, localBoolean);
            return this;
        }
    }

    public JSONObject putOnce(String paramString, Object paramObject) {
        if ((paramString != null) && (paramObject != null)) {
            if (opt(paramString) != null) {
                throw new JSONException("Duplicate key \"" + paramString + "\"");
            }
            put(paramString, paramObject);
        }
        return this;
    }

    public JSONObject putOpt(String paramString, Object paramObject) {
        if ((paramString != null) && (paramObject != null)) {
            put(paramString, paramObject);
        }
        return this;
    }

    public Object remove(String paramString) {
        return this.map.remove(paramString);
    }

    public Iterator sortedKeys() {
        return new TreeSet(this.map.keySet()).iterator();
    }

    public String toString() {
        try {
            Object localObject1 = keys();
            StringBuilder localStringBuilder = new StringBuilder("{");
            while (((Iterator) localObject1).hasNext()) {
                if (localStringBuilder.length() > 1) {
                    localStringBuilder.append(',');
                }
                Object localObject2 = ((Iterator) localObject1).next();
                localStringBuilder.append(quote(localObject2.toString()));
                localStringBuilder.append(':');
                localStringBuilder.append(valueToString(this.map.get(localObject2)));
            }
            localStringBuilder.append('}');
            localObject1 = localStringBuilder.toString();
            return (String) localObject1;
        } catch (Exception localException) {
        }
        return null;
    }

    public String toString(int paramInt) {
        return toString(paramInt, 0);
    }

    String toString(int paramInt1, int paramInt2) {
        int j = 0;
        int i = length();
        if (i == 0) {
            return "{}";
        }
        Object localObject1 = sortedKeys();
        int k = paramInt2 + paramInt1;
        StringBuilder localStringBuilder = new StringBuilder("{");
        if (i == 1) {
            localObject1 = ((Iterator) localObject1).next();
            localStringBuilder.append(quote(localObject1.toString()));
            localStringBuilder.append(": ");
            localStringBuilder.append(valueToString(this.map.get(localObject1), paramInt1, paramInt2));
        }
        for (; ; ) {
            localStringBuilder.append('}');
            return localStringBuilder.toString();
            Object localObject2;
            localStringBuilder.append(quote(localObject2.toString()));
            localStringBuilder.append(": ");
            localStringBuilder.append(valueToString(this.map.get(localObject2), paramInt1, k));
            if (((Iterator) localObject1).hasNext()) {
                localObject2 = ((Iterator) localObject1).next();
                if (localStringBuilder.length() > 1) {
                    localStringBuilder.append(",\n");
                }
                for (; ; ) {
                    i = 0;
                    while (i < k) {
                        localStringBuilder.append(' ');
                        i += 1;
                    }
                    break;
                    localStringBuilder.append('\n');
                }
            }
            if (localStringBuilder.length() > 1) {
                localStringBuilder.append('\n');
                paramInt1 = j;
                while (paramInt1 < paramInt2) {
                    localStringBuilder.append(' ');
                    paramInt1 += 1;
                }
            }
        }
    }

    public Writer write(Writer paramWriter) {
        for (int i = 0; ; i = 1) {
            Object localObject;
            try {
                Iterator localIterator = keys();
                paramWriter.write(123);
                if (!localIterator.hasNext()) {
                    break label135;
                }
                if (i != 0) {
                    paramWriter.write(44);
                }
                localObject = localIterator.next();
                paramWriter.write(quote(localObject.toString()));
                paramWriter.write(58);
                localObject = this.map.get(localObject);
                if ((localObject instanceof JSONObject)) {
                    ((JSONObject) localObject).write(paramWriter);
                } else if ((localObject instanceof JSONArray)) {
                    ((JSONArray) localObject).write(paramWriter);
                }
            } catch (IOException paramWriter) {
                throw new JSONException(paramWriter);
            }
            paramWriter.write(valueToString(localObject));
            continue;
            label135:
            paramWriter.write(125);
            return paramWriter;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/JSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */