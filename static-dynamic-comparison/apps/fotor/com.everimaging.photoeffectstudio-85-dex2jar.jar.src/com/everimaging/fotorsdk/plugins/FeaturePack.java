package com.everimaging.fotorsdk.plugins;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public abstract class FeaturePack {
    private static final String TAG = FeaturePack.class.getSimpleName();
    private static FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private String packID;
    protected String packName;
    protected String packageName;
    protected String packageVersion;
    protected int packageVersionCode;
    protected int pluginType;
    protected int version;

    public FeaturePack(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
        this.packageName = paramString1;
        this.packageVersionCode = paramInt1;
        this.version = paramInt2;
        this.pluginType = paramInt3;
        this.packName = paramString2;
    }

    public final String getPackID() {
        if (this.packID == null) {
            this.packID = (this.pluginType + "_" + this.packName);
        }
        return this.packID;
    }

    public String getPackName() {
        return this.packName;
    }

    public String getPackVersion() {
        return this.packageVersion;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int getPackageVersionCode() {
        return this.packageVersionCode;
    }

    public final int getPluginType() {
        return this.pluginType;
    }

    public int getVersion() {
        return this.version;
    }

    public abstract boolean isFree();

    public static class a
            implements JsonDeserializer<FeaturePack>, JsonSerializer<FeaturePack> {
        public FeaturePack a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
                throws JsonParseException {
            paramJsonElement = paramJsonElement.getAsJsonObject();
            paramType = ((JsonPrimitive) paramJsonElement.get("CLASSNAME")).getAsString();
            try {
                paramType = Class.forName(paramType);
                return (FeaturePack) paramJsonDeserializationContext.deserialize(paramJsonElement.get("INSTANCE"), paramType);
            } catch (ClassNotFoundException paramJsonElement) {
                paramJsonElement.printStackTrace();
                throw new JsonParseException(paramJsonElement.getMessage());
            }
        }

        public JsonElement a(FeaturePack paramFeaturePack, Type paramType, JsonSerializationContext paramJsonSerializationContext) {
            paramType = new JsonObject();
            paramType.addProperty("CLASSNAME", paramFeaturePack.getClass().getCanonicalName());
            paramType.add("INSTANCE", paramJsonSerializationContext.serialize(paramFeaturePack));
            return paramType;
        }
    }

    public static class b {
        public static int a(Context paramContext, String paramString) {
            int i3 = 0;
            for (; ; ) {
                try {
                    paramContext = paramContext.getPackageManager().getResourcesForApplication(paramString);
                    i = paramContext.getIdentifier("fotor_plugin_sticker", "integer", paramString);
                    if (i == 0) {
                        break label318;
                    }
                    i = paramContext.getInteger(i);
                    j = paramContext.getIdentifier("fotor_plugin_fx_effect", "integer", paramString);
                    if (j == 0) {
                        break label312;
                    }
                    i2 = paramContext.getInteger(j);
                    j = paramContext.getIdentifier("fotor_plugin_border", "integer", paramString);
                    if (j == 0) {
                        break label306;
                    }
                    k = paramContext.getInteger(j);
                    j = paramContext.getIdentifier("fotor_plugin_font", "integer", paramString);
                    if (j == 0) {
                        break label300;
                    }
                    m = paramContext.getInteger(j);
                    j = paramContext.getIdentifier("fotor_plugin_collage_template", "integer", paramString);
                    if (j == 0) {
                        break label294;
                    }
                    n = paramContext.getInteger(j);
                    j = paramContext.getIdentifier("fotor_plugin_collage_poster", "integer", paramString);
                    if (j == 0) {
                        break label288;
                    }
                    i1 = paramContext.getInteger(j);
                    j = paramContext.getIdentifier("fotor_plugin_collage_background", "integer", paramString);
                    if (j == 0) {
                        break label283;
                    }
                    j = paramContext.getInteger(j);
                    if (i2 == 1) {
                        i2 = 2;
                        if (i != 1) {
                            break label254;
                        }
                        i = 3;
                        if (k != 1) {
                            break label259;
                        }
                        k = 4;
                        if (m != 1) {
                            break label265;
                        }
                        m = 6;
                        if (n != 1) {
                            break label271;
                        }
                        n = 7;
                        if (i1 != 1) {
                            break label277;
                        }
                        i1 = 8;
                        if (j == 1) {
                            i3 = 9;
                        }
                        return i3 | i1 | i2 | i | k | m | n;
                    }
                } catch (PackageManager.NameNotFoundException paramContext) {
                    paramContext.printStackTrace();
                    return 0;
                }
                int i2 = 0;
                continue;
                label254:
                int i = 0;
                continue;
                label259:
                int k = 0;
                continue;
                label265:
                int m = 0;
                continue;
                label271:
                int n = 0;
                continue;
                label277:
                int i1 = 0;
                continue;
                label283:
                int j = 0;
                continue;
                label288:
                i1 = 0;
                continue;
                label294:
                n = 0;
                continue;
                label300:
                m = 0;
                continue;
                label306:
                k = 0;
                continue;
                label312:
                i2 = 0;
                continue;
                label318:
                i = 0;
            }
        }

        public static int a(String paramString) {
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.effects")) {
                return 2;
            }
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.borders")) {
                return 4;
            }
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.stickers")) {
                return 3;
            }
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.fonts")) {
                return 6;
            }
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.collage.classic")) {
                return 7;
            }
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.collage.poster")) {
                return 8;
            }
            if (paramString.startsWith("com.everimaging.fotorsdk.plugins.collage.background")) {
                return 9;
            }
            return 0;
        }

        public static boolean a(int paramInt) {
            return a(paramInt, 3);
        }

        static boolean a(int paramInt1, int paramInt2) {
            return paramInt1 == paramInt2;
        }

        public static boolean a(Context paramContext, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3) {
            if (!b(paramString)) {
                return false;
            }
            if (paramContext.getPackageName().equals(paramString)) {
                FeaturePack.logger.c(new Object[]{"vaildPackge is the same package with context:" + paramString});
                paramArrayOfInt1[0] = a(paramContext, paramString);
            }
            for (; ; ) {
                boolean bool1 = a(paramArrayOfInt1[0]);
                boolean bool2 = b(paramArrayOfInt1[0]);
                boolean bool3 = c(paramArrayOfInt1[0]);
                boolean bool4 = d(paramArrayOfInt1[0]);
                boolean bool5 = e(paramArrayOfInt1[0]);
                boolean bool6 = f(paramArrayOfInt1[0]);
                boolean bool7 = g(paramArrayOfInt1[0]);
                if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5) && (!bool6) && (!bool7)) {
                    break;
                }
                return true;
                FeaturePack.logger.c(new Object[]{"vaildPackge name:" + paramString});
                paramArrayOfInt1[0] = a(paramString);
            }
        }

        public static boolean b(int paramInt) {
            return a(paramInt, 2);
        }

        public static boolean b(String paramString) {
            return paramString.startsWith("com.everimaging.fotorsdk.plugins.");
        }

        public static boolean c(int paramInt) {
            return a(paramInt, 4);
        }

        public static boolean d(int paramInt) {
            return a(paramInt, 6);
        }

        public static boolean e(int paramInt) {
            return a(paramInt, 7);
        }

        public static boolean f(int paramInt) {
            return a(paramInt, 8);
        }

        public static boolean g(int paramInt) {
            return a(paramInt, 9);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/FeaturePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */