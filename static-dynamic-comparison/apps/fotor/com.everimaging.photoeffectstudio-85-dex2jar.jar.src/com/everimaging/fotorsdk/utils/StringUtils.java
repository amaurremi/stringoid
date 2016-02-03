package com.everimaging.fotorsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import java.io.UnsupportedEncodingException;

public class StringUtils {
    @SuppressLint({"DefaultLocale"})
    public static String convert2ResStr(String paramString) {
        if (paramString == null) {
            throw new IllegalStateException("source is null");
        }
        return removeSpeicalCharacter(paramString.toLowerCase());
    }

    public static String getBorderPackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getBorderPackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getBorderPackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_effect_border_pack_" + paramContext;
    }

    public static String getCollageBackgroundPackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getCollageBackgroundPackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getCollageBackgroundPackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_collage_background_pack_" + paramContext;
    }

    public static String getCollagePosterPackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getCollagePosterPackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getCollagePosterPackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_collage_poster_pack_" + paramContext;
    }

    public static String getCollageTemplatePackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getCollageTemplatePackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getCollageTemplatePackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_collage_template_pack_" + paramContext;
    }

    public static String getFontsPackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getStikersPackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getFontsPackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_fonts_pack_" + paramContext;
    }

    public static String getFxEffectPackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getFxEffectPackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getFxEffectPackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_effect_fx_pack_" + paramContext;
    }

    public static String getStickersPackName(Context paramContext, String paramString) {
        int i = FotorResUtils.getStringId(paramContext, getStikersPackResName(paramContext, paramString));
        if (i != 0) {
            return paramContext.getString(i);
        }
        return null;
    }

    public static String getStikersPackResName(Context paramContext, String paramString) {
        paramContext = convert2ResStr(paramString);
        return "fotor_stickers_pack_" + paramContext;
    }

    public static String removeSpeicalCharacter(String paramString) {
        try {
            String str = paramString.replace(new String(new byte[]{-62, -96}, "utf-8"), " ");
            paramString = str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
        return paramString.replaceAll("[` ~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]", "");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */