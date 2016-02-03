package com.inmobi.re.controller;

import android.content.Context;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.NavigationStringEnum;
import com.inmobi.re.controller.util.TransitionStringEnum;

import java.lang.reflect.Field;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSController {
    public static final String EXIT = "exit";
    public static final String FULL_SCREEN = "fullscreen";
    public static final String STYLE_NORMAL = "normal";
    protected JSController.ExpandProperties expProps;
    protected IMWebView imWebView;
    protected Context mContext;
    protected JSController.ExpandProperties temporaryexpProps;

    public JSController(IMWebView paramIMWebView, Context paramContext) {
        this.imWebView = paramIMWebView;
        this.mContext = paramContext;
        this.expProps = new JSController.ExpandProperties();
        this.temporaryexpProps = new JSController.ExpandProperties();
    }

    protected static Object getFromJSON(JSONObject paramJSONObject, Class<?> paramClass) {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        paramClass = paramClass.newInstance();
        int j = 0;
        Field localField;
        String str1;
        String str2;
        if (j < arrayOfField.length) {
            localField = arrayOfField[j];
            str1 = localField.getName().replace('_', '-');
            str2 = localField.getType().toString();
        }
        for (; ; ) {
            try {
                if (str2.equals("int")) {
                    str1 = paramJSONObject.getString(str1).toLowerCase(Locale.ENGLISH);
                }
            } catch (JSONException localJSONException) {
                boolean bool;
                int i;
                int k;
                label117:
                continue;
            }
            try {
                bool = str1.startsWith("#");
                if (bool) {
                    i = -1;
                }
            } catch (NumberFormatException localNumberFormatException1) {
                i = 0;
                continue;
            }
            try {
                if (!str1.startsWith("#0x")) {
                    continue;
                }
                k = Integer.decode(str1.substring(1)).intValue();
                i = k;
            } catch (NumberFormatException localNumberFormatException2) {
            }
        }
        localField.set(paramClass, Integer.valueOf(i));
        for (; ; ) {
            j += 1;
            break;
            k = Integer.parseInt(str1.substring(1), 16);
            i = k;
            break label117;
            i = Integer.parseInt(str1);
            break label117;
            if (str2.equals("class java.lang.String")) {
                localField.set(paramClass, paramJSONObject.getString(str1));
            } else if (str2.equals("boolean")) {
                localField.set(paramClass, Boolean.valueOf(paramJSONObject.getBoolean(str1)));
            } else if (str2.equals("float")) {
                localField.set(paramClass, Float.valueOf(Float.parseFloat(paramJSONObject.getString(str1))));
            } else if (str2.equals("class com.mraid.NavigationStringEnum")) {
                localField.set(paramClass, NavigationStringEnum.fromString(paramJSONObject.getString(str1)));
            } else if (str2.equals("class com.mraid.TransitionStringEnum")) {
                localField.set(paramClass, TransitionStringEnum.fromString(paramJSONObject.getString(str1)));
            }
        }
        return paramClass;
    }

    public abstract void stopAllListeners();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/controller/JSController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */