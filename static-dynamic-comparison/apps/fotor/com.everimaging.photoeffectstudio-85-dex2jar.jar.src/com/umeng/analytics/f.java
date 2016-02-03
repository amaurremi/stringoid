package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.common.Log;
import com.umeng.common.b;
import com.umeng.common.util.h;

import java.io.File;

public final class f {
    private static f a = new f();
    private static Context b;
    private static String c;
    private static long d = 1209600000L;
    private static long e = 2097152L;
    private static final String f = "age";
    private static final String g = "sex";
    private static final String h = "id";
    private static final String i = "url";
    private static final String j = "mobclick_agent_user_";
    private static final String k = "mobclick_agent_online_setting_";
    private static final String l = "mobclick_agent_header_";
    private static final String m = "mobclick_agent_update_";
    private static final String n = "mobclick_agent_state_";
    private static final String o = "mobclick_agent_cached_";
    private static final String p = "mobclick_agent_sealed_";

    public static f a(Context paramContext) {
        if (b == null) {
            b = paramContext.getApplicationContext();
        }
        if (c == null) {
            c = paramContext.getPackageName();
        }
        return a;
    }

    private static boolean a(File paramFile) {
        long l1 = paramFile.length();
        return (paramFile.exists()) && (l1 > e);
    }

    private SharedPreferences k() {
        return b.getSharedPreferences("mobclick_agent_user_" + c, 0);
    }

    private String l() {
        return "mobclick_agent_header_" + c;
    }

    private String m() {
        return "mobclick_agent_cached_" + c + b.c(b);
    }

    private String n() {
        return "mobclick_agent_sealed_" + c;
    }

    public void a(int paramInt1, int paramInt2) {
        SharedPreferences.Editor localEditor = a(b).g().edit();
        localEditor.putInt("umeng_net_report_policy", paramInt1);
        localEditor.putLong("umeng_net_report_interval", paramInt2);
        localEditor.commit();
    }

    public void a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
        SharedPreferences.Editor localEditor = k().edit();
        if (!TextUtils.isEmpty(paramString1)) {
            localEditor.putString("id", paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
            localEditor.putString("url", paramString2);
        }
        if (paramInt1 > 0) {
            localEditor.putInt("age", paramInt1);
        }
        localEditor.putInt("sex", paramInt2);
        localEditor.commit();
    }

    public void a(byte[] paramArrayOfByte) {
        String str = m();
        try {
            h.a(new File(b.getFilesDir(), str), paramArrayOfByte);
            return;
        } catch (Exception paramArrayOfByte) {
            Log.b("MobclickAgent", paramArrayOfByte.getMessage());
        }
    }

    public int[] a() {
        SharedPreferences localSharedPreferences = g();
        int[] arrayOfInt = new int[2];
        if (localSharedPreferences.getInt("umeng_net_report_policy", -1) != -1) {
            arrayOfInt[0] = localSharedPreferences.getInt("umeng_net_report_policy", 1);
            arrayOfInt[1] = ((int) localSharedPreferences.getLong("umeng_net_report_interval", 0L));
            return arrayOfInt;
        }
        arrayOfInt[0] = localSharedPreferences.getInt("umeng_local_report_policy", 1);
        arrayOfInt[1] = ((int) localSharedPreferences.getLong("umeng_local_report_interval", 0L));
        return arrayOfInt;
    }

    public void b(byte[] paramArrayOfByte) {
        try {
            h.a(new File(b.getFilesDir(), n()), paramArrayOfByte);
            return;
        } catch (Exception paramArrayOfByte) {
            paramArrayOfByte.printStackTrace();
        }
    }

    /* Error */
    public byte[] b() {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 157	com/umeng/analytics/f:m	()Ljava/lang/String;
        //   4: astore_1
        //   5: new 83	java/io/File
        //   8: dup
        //   9: getstatic 68	com/umeng/analytics/f:b	Landroid/content/Context;
        //   12: invokevirtual 161	android/content/Context:getFilesDir	()Ljava/io/File;
        //   15: aload_1
        //   16: invokespecial 164	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   19: astore_2
        //   20: aload_2
        //   21: invokestatic 200	com/umeng/analytics/f:a	(Ljava/io/File;)Z
        //   24: ifeq +10 -> 34
        //   27: aload_2
        //   28: invokevirtual 203	java/io/File:delete	()Z
        //   31: pop
        //   32: aconst_null
        //   33: areturn
        //   34: aload_2
        //   35: invokevirtual 91	java/io/File:exists	()Z
        //   38: ifeq -6 -> 32
        //   41: getstatic 68	com/umeng/analytics/f:b	Landroid/content/Context;
        //   44: aload_1
        //   45: invokevirtual 207	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
        //   48: astore_2
        //   49: aload_2
        //   50: astore_1
        //   51: aload_2
        //   52: invokestatic 210	com/umeng/common/util/h:b	(Ljava/io/InputStream;)[B
        //   55: astore_3
        //   56: aload_2
        //   57: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   60: aload_3
        //   61: areturn
        //   62: astore_3
        //   63: aconst_null
        //   64: astore_2
        //   65: aload_2
        //   66: astore_1
        //   67: aload_3
        //   68: invokevirtual 197	java/lang/Exception:printStackTrace	()V
        //   71: aload_2
        //   72: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   75: aconst_null
        //   76: areturn
        //   77: astore_1
        //   78: aconst_null
        //   79: astore_3
        //   80: aload_1
        //   81: astore_2
        //   82: aload_3
        //   83: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   86: aload_2
        //   87: athrow
        //   88: astore_2
        //   89: aload_1
        //   90: astore_3
        //   91: goto -9 -> 82
        //   94: astore_3
        //   95: goto -30 -> 65
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	f
        //   4	63	1	localObject1	Object
        //   77	13	1	localObject2	Object
        //   19	68	2	localObject3	Object
        //   88	1	2	localObject4	Object
        //   55	6	3	arrayOfByte	byte[]
        //   62	6	3	localException1	Exception
        //   79	12	3	localObject5	Object
        //   94	1	3	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   41	49	62	java/lang/Exception
        //   41	49	77	finally
        //   51	56	88	finally
        //   67	71	88	finally
        //   51	56	94	java/lang/Exception
    }

    public Object[] b(Context paramContext) {
        paramContext = k();
        Object[] arrayOfObject = new Object[4];
        if (paramContext.contains("id")) {
            arrayOfObject[0] = paramContext.getString("id", null);
        }
        if (paramContext.contains("url")) {
            arrayOfObject[1] = paramContext.getString("url", null);
        }
        if (paramContext.contains("age")) {
            arrayOfObject[2] = Integer.valueOf(paramContext.getInt("age", -1));
        }
        if (paramContext.contains("sex")) {
            arrayOfObject[3] = Integer.valueOf(paramContext.getInt("sex", -1));
        }
        return arrayOfObject;
    }

    public void c() {
        b.deleteFile(l());
        b.deleteFile(m());
    }

    /* Error */
    public byte[] d() {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 194	com/umeng/analytics/f:n	()Ljava/lang/String;
        //   4: astore_3
        //   5: new 83	java/io/File
        //   8: dup
        //   9: getstatic 68	com/umeng/analytics/f:b	Landroid/content/Context;
        //   12: invokevirtual 161	android/content/Context:getFilesDir	()Ljava/io/File;
        //   15: aload_3
        //   16: invokespecial 164	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   19: astore 6
        //   21: aload 6
        //   23: invokevirtual 91	java/io/File:exists	()Z
        //   26: ifeq +15 -> 41
        //   29: aload 6
        //   31: invokevirtual 87	java/io/File:length	()J
        //   34: lstore_1
        //   35: lload_1
        //   36: lconst_0
        //   37: lcmp
        //   38: ifgt +5 -> 43
        //   41: aconst_null
        //   42: areturn
        //   43: getstatic 68	com/umeng/analytics/f:b	Landroid/content/Context;
        //   46: aload_3
        //   47: invokevirtual 207	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
        //   50: astore 4
        //   52: aload 4
        //   54: astore_3
        //   55: aload 4
        //   57: invokestatic 210	com/umeng/common/util/h:b	(Ljava/io/InputStream;)[B
        //   60: astore 5
        //   62: aload 4
        //   64: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   67: aload 5
        //   69: areturn
        //   70: astore_3
        //   71: aload 6
        //   73: invokevirtual 203	java/io/File:delete	()Z
        //   76: pop
        //   77: aload_3
        //   78: invokevirtual 197	java/lang/Exception:printStackTrace	()V
        //   81: aconst_null
        //   82: areturn
        //   83: astore 5
        //   85: aconst_null
        //   86: astore 4
        //   88: aload 4
        //   90: astore_3
        //   91: aload 5
        //   93: invokevirtual 197	java/lang/Exception:printStackTrace	()V
        //   96: aload 4
        //   98: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   101: goto -20 -> 81
        //   104: aload_3
        //   105: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   108: aload 4
        //   110: athrow
        //   111: astore 4
        //   113: goto -9 -> 104
        //   116: astore 5
        //   118: goto -30 -> 88
        //   121: astore 4
        //   123: aconst_null
        //   124: astore_3
        //   125: goto -21 -> 104
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	this	f
        //   34	2	1	l1	long
        //   4	51	3	localObject1	Object
        //   70	8	3	localException1	Exception
        //   90	35	3	localObject2	Object
        //   50	59	4	localFileInputStream	java.io.FileInputStream
        //   111	1	4	localObject3	Object
        //   121	1	4	localObject4	Object
        //   60	8	5	arrayOfByte	byte[]
        //   83	9	5	localException2	Exception
        //   116	1	5	localException3	Exception
        //   19	53	6	localFile	File
        // Exception table:
        //   from	to	target	type
        //   21	35	70	java/lang/Exception
        //   62	67	70	java/lang/Exception
        //   96	101	70	java/lang/Exception
        //   104	111	70	java/lang/Exception
        //   43	52	83	java/lang/Exception
        //   55	62	111	finally
        //   91	96	111	finally
        //   55	62	116	java/lang/Exception
        //   43	52	121	finally
    }

    public void e() {
        String str = n();
        boolean bool = b.deleteFile(str);
        Log.a("--->", "delete envelope:" + bool);
    }

    public boolean f() {
        Object localObject = n();
        localObject = new File(b.getFilesDir(), (String) localObject);
        return (((File) localObject).exists()) && (((File) localObject).length() > 0L);
    }

    public SharedPreferences g() {
        return b.getSharedPreferences("mobclick_agent_online_setting_" + c, 0);
    }

    public SharedPreferences h() {
        return b.getSharedPreferences("mobclick_agent_header_" + c, 0);
    }

    public SharedPreferences i() {
        return b.getSharedPreferences("mobclick_agent_update_" + c, 0);
    }

    public SharedPreferences j() {
        return b.getSharedPreferences("mobclick_agent_state_" + c, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */