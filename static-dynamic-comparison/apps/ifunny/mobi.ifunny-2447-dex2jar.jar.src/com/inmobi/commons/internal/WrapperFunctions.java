package com.inmobi.commons.internal;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WrapperFunctions {
    private static int a;

    private static void a(WebView paramWebView, int paramInt) {
        try {
            paramWebView.getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(paramWebView, new Object[]{Integer.valueOf(paramInt), null});
            return;
        } catch (NoSuchMethodException paramWebView) {
            Log.internal("[InMobi]-4.5.1", "Cannot set hardware accl", paramWebView);
            return;
        } catch (IllegalArgumentException paramWebView) {
            Log.internal("[InMobi]-4.5.1", "Cannot set hardware accl", paramWebView);
            return;
        } catch (IllegalAccessException paramWebView) {
            Log.internal("[InMobi]-4.5.1", "Cannot set hardware accl", paramWebView);
            return;
        } catch (InvocationTargetException paramWebView) {
            Log.internal("[InMobi]-4.5.1", "Cannot set hardware accl", paramWebView);
        }
    }

    public static void disableHardwareAccl(WebView paramWebView) {
        a(paramWebView, 1);
    }

    public static int getCurrentOrientationInFixedValues(Context paramContext) {
        switch (paramContext.getResources().getConfiguration().orientation) {
            default:
                return 1;
            case 1:
                if (Build.VERSION.SDK_INT < 8) {
                    return 1;
                }
                i = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
                if ((i == 1) || (i == 2)) {
                    return 9;
                }
                return 1;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return 0;
        }
        int i = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if ((i == 0) || (i == 1)) {
            return 0;
        }
        return 8;
    }

    public static int getDisplayHeight(Display paramDisplay) {
        Object localObject1 = null;
        try {
            localObject2 = Display.class.getMethod("getSize", new Class[]{Point.class});
            localObject1 = localObject2;
            i = 1;
        } catch (NoSuchMethodException localNoSuchMethodException1) {
            for (; ; ) {
                try {
                    Object localObject2 = new Point();
                    ((Method) localObject1).invoke(paramDisplay, new Object[]{localObject2});
                    i = ((Point) localObject2).y;
                    return i;
                } catch (IllegalArgumentException paramDisplay) {
                    int i;
                    Log.internal("[InMobi]-4.5.1", "Cannot get display height", paramDisplay);
                    return 0;
                } catch (IllegalAccessException paramDisplay) {
                    Log.internal("[InMobi]-4.5.1", "Cannot get display height", paramDisplay);
                    return 0;
                } catch (InvocationTargetException paramDisplay) {
                    Log.internal("[InMobi]-4.5.1", "Cannot get display height", paramDisplay);
                }
                localNoSuchMethodException1 = localNoSuchMethodException1;
                try {
                    Method localMethod = Display.class.getMethod("getHeight", (Class[]) null);
                    localObject1 = localMethod;
                    i = 0;
                } catch (NoSuchMethodException localNoSuchMethodException2) {
                    Log.internal("[InMobi]-4.5.1", "Cannot get display height", localNoSuchMethodException2);
                    i = 0;
                }
            }
            i = ((Integer) ((Method) localObject1).invoke(paramDisplay, (Object[]) null)).intValue();
            return i;
        }
        if (i != 0) {
        }
        return 0;
    }

    public static int getDisplayWidth(Display paramDisplay) {
        Object localObject1 = null;
        try {
            localObject2 = Display.class.getMethod("getSize", new Class[]{Point.class});
            localObject1 = localObject2;
            i = 1;
        } catch (NoSuchMethodException localNoSuchMethodException1) {
            for (; ; ) {
                try {
                    Object localObject2 = new Point();
                    ((Method) localObject1).invoke(paramDisplay, new Object[]{localObject2});
                    i = ((Point) localObject2).x;
                    return i;
                } catch (IllegalArgumentException paramDisplay) {
                    int i;
                    Log.internal("[InMobi]-4.5.1", "Cannot get display width", paramDisplay);
                    return 0;
                } catch (IllegalAccessException paramDisplay) {
                    Log.internal("[InMobi]-4.5.1", "Cannot get display width", paramDisplay);
                    return 0;
                } catch (InvocationTargetException paramDisplay) {
                    Log.internal("[InMobi]-4.5.1", "Cannot get display width", paramDisplay);
                }
                localNoSuchMethodException1 = localNoSuchMethodException1;
                try {
                    Method localMethod = Display.class.getMethod("getWidth", (Class[]) null);
                    localObject1 = localMethod;
                    i = 0;
                } catch (NoSuchMethodException localNoSuchMethodException2) {
                    Log.internal("[InMobi]-4.5.1", "Cannot get display width", localNoSuchMethodException2);
                    i = 0;
                }
            }
            i = ((Integer) ((Method) localObject1).invoke(paramDisplay, (Object[]) null)).intValue();
            return i;
        }
        if (i != 0) {
        }
        return 0;
    }

    public static int getParamConfigScreenSize() {
        int i = 0;
        ActivityInfo localActivityInfo = new ActivityInfo();
        try {
            Field localField = ActivityInfo.class.getField("CONFIG_SCREEN_SIZE");
            if (localField != null) {
                i = localField.getInt(localActivityInfo);
            }
            return i;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get screen size", localNoSuchFieldException);
            return 0;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get screen size", localException);
        }
        return 0;
    }

    public static int getParamConfigSmallestScreenSize() {
        int i = 0;
        ActivityInfo localActivityInfo = new ActivityInfo();
        try {
            Field localField = ActivityInfo.class.getField("CONFIG_SMALLEST_SCREEN_SIZE");
            if (localField != null) {
                i = localField.getInt(localActivityInfo);
            }
            return i;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get smallest screen size", localNoSuchFieldException);
            return 0;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get smallest screen size", localException);
        }
        return 0;
    }

    /* Error */
    public static int getParamFillParent() {
        // Byte code:
        //   0: getstatic 165	com/inmobi/commons/internal/WrapperFunctions:a	I
        //   3: ifne +45 -> 48
        //   6: ldc 2
        //   8: monitorenter
        //   9: getstatic 165	com/inmobi/commons/internal/WrapperFunctions:a	I
        //   12: ifne +33 -> 45
        //   15: new 167	android/view/ViewGroup$LayoutParams
        //   18: dup
        //   19: iconst_1
        //   20: iconst_1
        //   21: invokespecial 170	android/view/ViewGroup$LayoutParams:<init>	(II)V
        //   24: astore_1
        //   25: ldc -89
        //   27: ldc -84
        //   29: invokevirtual 149	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   32: astore_0
        //   33: aload_0
        //   34: ifnull +11 -> 45
        //   37: aload_0
        //   38: aload_1
        //   39: invokevirtual 155	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
        //   42: putstatic 165	com/inmobi/commons/internal/WrapperFunctions:a	I
        //   45: ldc 2
        //   47: monitorexit
        //   48: getstatic 165	com/inmobi/commons/internal/WrapperFunctions:a	I
        //   51: ireturn
        //   52: astore_0
        //   53: ldc -89
        //   55: ldc -82
        //   57: invokevirtual 149	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   60: astore_0
        //   61: goto -28 -> 33
        //   64: astore_0
        //   65: ldc 52
        //   67: ldc -80
        //   69: aload_0
        //   70: invokestatic 60	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   73: aconst_null
        //   74: astore_0
        //   75: goto -42 -> 33
        //   78: astore_0
        //   79: ldc 52
        //   81: ldc -80
        //   83: aload_0
        //   84: invokestatic 60	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   87: goto -42 -> 45
        //   90: astore_0
        //   91: ldc 2
        //   93: monitorexit
        //   94: aload_0
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   32	6	0	localField1	Field
        //   52	1	0	localNoSuchFieldException1	NoSuchFieldException
        //   60	1	0	localField2	Field
        //   64	6	0	localNoSuchFieldException2	NoSuchFieldException
        //   74	1	0	localObject1	Object
        //   78	6	0	localException	Exception
        //   90	5	0	localObject2	Object
        //   24	15	1	localLayoutParams	android.view.ViewGroup.LayoutParams
        // Exception table:
        //   from	to	target	type
        //   25	33	52	java/lang/NoSuchFieldException
        //   53	61	64	java/lang/NoSuchFieldException
        //   37	45	78	java/lang/Exception
        //   9	25	90	finally
        //   25	33	90	finally
        //   37	45	90	finally
        //   45	48	90	finally
        //   53	61	90	finally
        //   65	73	90	finally
        //   79	87	90	finally
        //   91	94	90	finally
    }

    public static int getParamLandscapeOrientation(int paramInt) {
        int j = 0;
        int i = j;
        ActivityInfo localActivityInfo;
        if (paramInt == 3) {
            localActivityInfo = new ActivityInfo();
        }
        try {
            Field localField = ActivityInfo.class.getField("SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
            i = j;
            if (localField != null) {
                i = localField.getInt(localActivityInfo);
            }
            return i;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get landscape orientation", localNoSuchFieldException);
            return 0;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get landscape orientation", localException);
        }
        return 0;
    }

    public static int getParamPortraitOrientation(int paramInt) {
        int j = 1;
        int i = j;
        ActivityInfo localActivityInfo;
        if (paramInt == 2) {
            localActivityInfo = new ActivityInfo();
        }
        try {
            Field localField = ActivityInfo.class.getField("SCREEN_ORIENTATION_REVERSE_PORTRAIT");
            i = j;
            if (localField != null) {
                i = localField.getInt(localActivityInfo);
            }
            return i;
        } catch (NoSuchFieldException localNoSuchFieldException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get portrait orientation", localNoSuchFieldException);
            return 1;
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Cannot get portrait orientation", localException);
        }
        return 1;
    }

    public static String getSSLErrorUrl(SslError paramSslError) {
        try {
            paramSslError = Class.forName("android.net.http.SslError").getDeclaredMethod("getUrl", new Class[0]).invoke(paramSslError, new Object[0]).toString();
            return paramSslError;
        } catch (Exception paramSslError) {
            Log.internal("[InMobi]-4.5.1", "Cannot get SSL Url", paramSslError);
        }
        return null;
    }

    public static Bitmap getVideoBitmap(String paramString) {
        try {
            paramString = (Bitmap) Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{paramString, Integer.valueOf(1)});
            return paramString;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-4.5.1", "Cannot get video bitmap", paramString);
            throw paramString;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/WrapperFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */