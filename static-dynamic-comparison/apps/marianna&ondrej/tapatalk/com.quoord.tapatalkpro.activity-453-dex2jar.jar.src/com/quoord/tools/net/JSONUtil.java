package com.quoord.tools.net;

import org.json.JSONObject;

public class JSONUtil {
    public static final Boolean JSONUTIL_DEFUALT_BOOLEAN_VAL = Boolean.valueOf(false);
    public static final Double JSONUTIL_DEFUALT_DOUBLE_VAL = Double.valueOf(0.0D);
    public static final Integer JSONUTIL_DEFUALT_INTEGER_VAL = Integer.valueOf(0);
    public static final String JSONUTIL_DEFUALT_STRING_VAL = "";
    private JSONObject jsonObject = null;

    public JSONUtil(JSONObject paramJSONObject) {
        this.jsonObject = paramJSONObject;
    }

    public Object opt(String paramString) {
        return this.jsonObject.opt(paramString);
    }

    public Boolean optBoolean(String paramString) {
        return optBoolean(paramString, JSONUTIL_DEFUALT_BOOLEAN_VAL);
    }

    public Boolean optBoolean(String paramString, Boolean paramBoolean) {
        boolean bool = true;
        try {
            if (this.jsonObject == null) {
                return paramBoolean;
            }
            Object localObject = this.jsonObject.opt(paramString);
            if ((localObject != null) && (!this.jsonObject.isNull(paramString))) {
                if ((localObject instanceof Boolean)) {
                    return (Boolean) localObject;
                }
                if ((localObject instanceof String)) {
                    if ((((String) localObject).equals("1")) || (((String) localObject).equalsIgnoreCase("true"))) {
                        return Boolean.valueOf(true);
                    }
                    return Boolean.valueOf(false);
                }
                if ((localObject instanceof Integer)) {
                    if (((Integer) localObject).intValue() == 1) {
                    }
                    for (; ; ) {
                        return Boolean.valueOf(bool);
                        bool = false;
                    }
                }
            }
            return paramBoolean;
        } catch (Exception paramString) {
        }
    }

    public Double optDouble(String paramString) {
        return optDouble(paramString, JSONUTIL_DEFUALT_DOUBLE_VAL);
    }

    public Double optDouble(String paramString, Double paramDouble) {
        try {
            if (this.jsonObject == null) {
                return paramDouble;
            }
            Object localObject = this.jsonObject.opt(paramString);
            if ((localObject != null) && (!this.jsonObject.isNull(paramString))) {
                if ((localObject instanceof Double)) {
                    return (Double) localObject;
                }
                if ((localObject instanceof Integer)) {
                    return Double.valueOf(((Integer) localObject).doubleValue());
                }
                boolean bool = localObject instanceof String;
                if (bool) {
                    try {
                        paramString = Double.valueOf((String) localObject);
                        return paramString;
                    } catch (NumberFormatException paramString) {
                        for (; ; ) {
                            paramString = paramDouble;
                        }
                    }
                }
                if ((localObject instanceof Boolean)) {
                    if (((Boolean) localObject).booleanValue()) {
                    }
                    for (double d = 1.0D; ; d = 0.0D) {
                        return Double.valueOf(d);
                    }
                }
            }
            return paramDouble;
        } catch (Exception paramString) {
        }
    }

    public Integer optInteger(String paramString) {
        return optInteger(paramString, JSONUTIL_DEFUALT_INTEGER_VAL);
    }

    public Integer optInteger(String paramString, Integer paramInteger) {
        try {
            if (this.jsonObject == null) {
                return paramInteger;
            }
            Object localObject = this.jsonObject.opt(paramString);
            if ((localObject != null) && (!this.jsonObject.isNull(paramString))) {
                if ((localObject instanceof Integer)) {
                    return (Integer) localObject;
                }
                if ((localObject instanceof Double)) {
                    return Integer.valueOf(((Double) localObject).intValue());
                }
                boolean bool = localObject instanceof String;
                if (bool) {
                    try {
                        paramString = Integer.valueOf((String) localObject);
                        return paramString;
                    } catch (NumberFormatException paramString) {
                        for (; ; ) {
                            paramString = paramInteger;
                        }
                    }
                }
                if ((localObject instanceof Boolean)) {
                    if (((Boolean) localObject).booleanValue()) {
                    }
                    for (int i = 1; ; i = 0) {
                        return Integer.valueOf(i);
                    }
                }
            }
            return paramInteger;
        } catch (Exception paramString) {
        }
    }

    public String optString(String paramString) {
        return optString(paramString, "");
    }

    public String optString(String paramString1, String paramString2) {
        try {
            if (this.jsonObject == null) {
                return paramString2;
            }
            Object localObject = this.jsonObject.opt(paramString1);
            if ((localObject != null) && (!this.jsonObject.isNull(paramString1))) {
                if ((localObject instanceof String)) {
                    return (String) localObject;
                }
                if ((localObject instanceof Boolean)) {
                    return ((Boolean) localObject).toString();
                }
                if ((localObject instanceof Integer)) {
                    return ((Integer) localObject).toString();
                }
                if ((localObject instanceof Double)) {
                    paramString1 = ((Double) localObject).toString();
                    return paramString1;
                }
            }
        } catch (Exception paramString1) {
        }
        return paramString2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/JSONUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */