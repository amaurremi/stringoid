package mobi.ifunny.util;

import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.Environment;
import android.util.SparseArray;

import java.io.File;
import java.io.IOException;

import mobi.ifunny.d;

public final class l {
    private static final String a = l.class.getSimpleName();
    private static final SparseArray<String> b = new m();

    public static File a() {
        Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = File.separator + "Pictures" + File.separator + "iFunny" + File.separator;
        localObject = new File((String) localObject + str);
        if (((File) localObject).mkdirs()) {
            d.c(a, "Create album folder at " + ((File) localObject).getAbsolutePath());
        }
        return (File) localObject;
    }

    /* Error */
    public static File a(Context paramContext, byte[] paramArrayOfByte) {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +5 -> 6
        //   4: aconst_null
        //   5: areturn
        //   6: aload_0
        //   7: invokestatic 77	mobi/ifunny/util/l:b	(Landroid/content/Context;)Ljava/io/File;
        //   10: astore_2
        //   11: new 79	java/io/BufferedOutputStream
        //   14: dup
        //   15: new 81	java/io/FileOutputStream
        //   18: dup
        //   19: aload_2
        //   20: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   23: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   26: astore_0
        //   27: aload_0
        //   28: aload_1
        //   29: invokevirtual 93	java/io/OutputStream:write	([B)V
        //   32: aload_0
        //   33: ifnull +7 -> 40
        //   36: aload_0
        //   37: invokevirtual 96	java/io/OutputStream:close	()V
        //   40: aload_2
        //   41: areturn
        //   42: astore_0
        //   43: aconst_null
        //   44: astore_0
        //   45: aload_0
        //   46: ifnull -42 -> 4
        //   49: aload_0
        //   50: invokevirtual 96	java/io/OutputStream:close	()V
        //   53: aconst_null
        //   54: areturn
        //   55: astore_0
        //   56: aconst_null
        //   57: areturn
        //   58: astore_1
        //   59: aconst_null
        //   60: astore_0
        //   61: aload_0
        //   62: ifnull +7 -> 69
        //   65: aload_0
        //   66: invokevirtual 96	java/io/OutputStream:close	()V
        //   69: aload_1
        //   70: athrow
        //   71: astore_0
        //   72: goto -32 -> 40
        //   75: astore_0
        //   76: goto -7 -> 69
        //   79: astore_1
        //   80: goto -19 -> 61
        //   83: astore_1
        //   84: goto -39 -> 45
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	paramContext	Context
        //   0	87	1	paramArrayOfByte	byte[]
        //   10	31	2	localFile	File
        // Exception table:
        //   from	to	target	type
        //   6	27	42	java/io/IOException
        //   49	53	55	java/io/IOException
        //   6	27	58	finally
        //   36	40	71	java/io/IOException
        //   65	69	75	java/io/IOException
        //   27	32	79	finally
        //   27	32	83	java/io/IOException
    }

    public static void a(Context paramContext) {
        e(paramContext);
        g(paramContext);
    }

    /* Error */
    public static void a(Context paramContext, String paramString, byte[] paramArrayOfByte) {
        // Byte code:
        //   0: new 79	java/io/BufferedOutputStream
        //   3: dup
        //   4: aload_0
        //   5: aload_1
        //   6: iconst_0
        //   7: invokevirtual 112	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //   10: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   13: astore_1
        //   14: aload_1
        //   15: aload_2
        //   16: invokevirtual 113	java/io/BufferedOutputStream:write	([B)V
        //   19: aload_1
        //   20: ifnull +7 -> 27
        //   23: aload_1
        //   24: invokevirtual 114	java/io/BufferedOutputStream:close	()V
        //   27: return
        //   28: astore_0
        //   29: aconst_null
        //   30: astore_1
        //   31: aload_1
        //   32: ifnull +7 -> 39
        //   35: aload_1
        //   36: invokevirtual 114	java/io/BufferedOutputStream:close	()V
        //   39: aload_0
        //   40: athrow
        //   41: astore_0
        //   42: return
        //   43: astore_1
        //   44: goto -5 -> 39
        //   47: astore_0
        //   48: goto -17 -> 31
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	51	0	paramContext	Context
        //   0	51	1	paramString	String
        //   0	51	2	paramArrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   0	14	28	finally
        //   23	27	41	java/lang/Exception
        //   35	39	43	java/lang/Exception
        //   14	19	47	finally
    }

    public static void a(File paramFile) {
        paramFile = paramFile.listFiles();
        if (paramFile != null) {
            int j = paramFile.length;
            int i = 0;
            if (i < j) {
                File localFile = paramFile[i];
                if (localFile.isDirectory()) {
                    a(localFile);
                }
                for (; ; ) {
                    i += 1;
                    break;
                    if (localFile.delete()) {
                        d.a(a, "Delete file " + localFile);
                    } else {
                        d.d(a, "Can not delete file " + localFile);
                    }
                }
            }
        }
    }

    /* Error */
    public static boolean a(Context paramContext, byte[] paramArrayOfByte, String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: invokestatic 142	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
        //   5: ldc -112
        //   7: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   10: ifeq +61 -> 71
        //   13: new 36	java/io/File
        //   16: dup
        //   17: invokestatic 152	mobi/ifunny/util/l:a	()Ljava/io/File;
        //   20: aload_2
        //   21: invokespecial 155	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   24: astore 4
        //   26: new 79	java/io/BufferedOutputStream
        //   29: dup
        //   30: new 81	java/io/FileOutputStream
        //   33: dup
        //   34: aload 4
        //   36: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   39: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   42: astore_2
        //   43: aload_2
        //   44: aload_1
        //   45: invokevirtual 93	java/io/OutputStream:write	([B)V
        //   48: new 157	mobi/ifunny/util/k
        //   51: dup
        //   52: aload_0
        //   53: invokespecial 159	mobi/ifunny/util/k:<init>	(Landroid/content/Context;)V
        //   56: aload 4
        //   58: invokevirtual 160	mobi/ifunny/util/k:a	(Ljava/io/File;)V
        //   61: aload_2
        //   62: ifnull +7 -> 69
        //   65: aload_2
        //   66: invokevirtual 96	java/io/OutputStream:close	()V
        //   69: iconst_1
        //   70: ireturn
        //   71: iconst_0
        //   72: ifeq +11 -> 83
        //   75: new 162	java/lang/NullPointerException
        //   78: dup
        //   79: invokespecial 163	java/lang/NullPointerException:<init>	()V
        //   82: athrow
        //   83: iconst_0
        //   84: ireturn
        //   85: astore_0
        //   86: aload_3
        //   87: astore_0
        //   88: aload_0
        //   89: ifnull -6 -> 83
        //   92: aload_0
        //   93: invokevirtual 96	java/io/OutputStream:close	()V
        //   96: goto -13 -> 83
        //   99: astore_0
        //   100: goto -17 -> 83
        //   103: astore_0
        //   104: aconst_null
        //   105: astore_2
        //   106: aload_2
        //   107: ifnull +7 -> 114
        //   110: aload_2
        //   111: invokevirtual 96	java/io/OutputStream:close	()V
        //   114: aload_0
        //   115: athrow
        //   116: astore_0
        //   117: iconst_1
        //   118: ireturn
        //   119: astore_0
        //   120: goto -37 -> 83
        //   123: astore_1
        //   124: goto -10 -> 114
        //   127: astore_0
        //   128: goto -22 -> 106
        //   131: astore_0
        //   132: aload_2
        //   133: astore_0
        //   134: goto -46 -> 88
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	137	0	paramContext	Context
        //   0	137	1	paramArrayOfByte	byte[]
        //   0	137	2	paramString	String
        //   1	86	3	localObject	Object
        //   24	33	4	localFile	File
        // Exception table:
        //   from	to	target	type
        //   2	43	85	java/io/IOException
        //   92	96	99	java/io/IOException
        //   2	43	103	finally
        //   65	69	116	java/io/IOException
        //   75	83	119	java/io/IOException
        //   110	114	123	java/io/IOException
        //   43	61	127	finally
        //   43	61	131	java/io/IOException
    }

    /* Error */
    public static byte[] a(Context paramContext, String paramString) {
        // Byte code:
        //   0: new 166	java/io/BufferedInputStream
        //   3: dup
        //   4: aload_0
        //   5: aload_1
        //   6: invokevirtual 170	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
        //   9: invokespecial 173	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   12: astore_1
        //   13: new 175	mobi/ifunny/util/ag
        //   16: dup
        //   17: invokespecial 176	mobi/ifunny/util/ag:<init>	()V
        //   20: astore_0
        //   21: aload_1
        //   22: aload_0
        //   23: invokestatic 181	mobi/ifunny/util/u:a	()Lmobi/ifunny/util/u;
        //   26: invokestatic 186	mobi/ifunny/util/s:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lmobi/ifunny/util/u;)I
        //   29: pop
        //   30: aload_0
        //   31: invokevirtual 190	mobi/ifunny/util/ag:toByteArray	()[B
        //   34: astore_0
        //   35: aload_1
        //   36: ifnull +7 -> 43
        //   39: aload_1
        //   40: invokevirtual 191	java/io/BufferedInputStream:close	()V
        //   43: aload_0
        //   44: areturn
        //   45: astore_0
        //   46: aconst_null
        //   47: astore_1
        //   48: aload_1
        //   49: ifnull +7 -> 56
        //   52: aload_1
        //   53: invokevirtual 191	java/io/BufferedInputStream:close	()V
        //   56: aload_0
        //   57: athrow
        //   58: astore_1
        //   59: aload_0
        //   60: areturn
        //   61: astore_1
        //   62: goto -6 -> 56
        //   65: astore_0
        //   66: goto -18 -> 48
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	69	0	paramContext	Context
        //   0	69	1	paramString	String
        // Exception table:
        //   from	to	target	type
        //   0	13	45	finally
        //   39	43	58	java/lang/Exception
        //   52	56	61	java/lang/Exception
        //   13	35	65	finally
    }

    public static File b(Context paramContext) {
        return File.createTempFile("cache", null, f(paramContext));
    }

    /* Error */
    public static File b(Context paramContext, String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: new 203	java/io/FileInputStream
        //   5: dup
        //   6: aload_1
        //   7: invokespecial 204	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
        //   10: astore_1
        //   11: aload_1
        //   12: invokevirtual 208	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
        //   15: astore 4
        //   17: aload_0
        //   18: invokestatic 77	mobi/ifunny/util/l:b	(Landroid/content/Context;)Ljava/io/File;
        //   21: astore_3
        //   22: new 81	java/io/FileOutputStream
        //   25: dup
        //   26: aload_3
        //   27: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   30: astore_0
        //   31: aload_0
        //   32: invokevirtual 209	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
        //   35: aload 4
        //   37: lconst_0
        //   38: aload 4
        //   40: invokevirtual 215	java/nio/channels/FileChannel:size	()J
        //   43: invokevirtual 219	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
        //   46: pop2
        //   47: aload_1
        //   48: ifnull +7 -> 55
        //   51: aload_1
        //   52: invokevirtual 220	java/io/FileInputStream:close	()V
        //   55: aload_0
        //   56: ifnull +7 -> 63
        //   59: aload_0
        //   60: invokevirtual 221	java/io/FileOutputStream:close	()V
        //   63: aload_3
        //   64: areturn
        //   65: astore_0
        //   66: aconst_null
        //   67: astore_0
        //   68: aconst_null
        //   69: astore_1
        //   70: aload_1
        //   71: ifnull +7 -> 78
        //   74: aload_1
        //   75: invokevirtual 220	java/io/FileInputStream:close	()V
        //   78: aload_0
        //   79: ifnull +7 -> 86
        //   82: aload_0
        //   83: invokevirtual 221	java/io/FileOutputStream:close	()V
        //   86: aconst_null
        //   87: areturn
        //   88: astore_0
        //   89: aconst_null
        //   90: astore_1
        //   91: aload_1
        //   92: ifnull +7 -> 99
        //   95: aload_1
        //   96: invokevirtual 220	java/io/FileInputStream:close	()V
        //   99: aload_2
        //   100: ifnull +7 -> 107
        //   103: aload_2
        //   104: invokevirtual 221	java/io/FileOutputStream:close	()V
        //   107: aload_0
        //   108: athrow
        //   109: astore_1
        //   110: goto -55 -> 55
        //   113: astore_0
        //   114: goto -51 -> 63
        //   117: astore_1
        //   118: goto -40 -> 78
        //   121: astore_0
        //   122: goto -36 -> 86
        //   125: astore_1
        //   126: goto -27 -> 99
        //   129: astore_1
        //   130: goto -23 -> 107
        //   133: astore_0
        //   134: goto -43 -> 91
        //   137: astore_3
        //   138: aload_0
        //   139: astore_2
        //   140: aload_3
        //   141: astore_0
        //   142: goto -51 -> 91
        //   145: astore_0
        //   146: aconst_null
        //   147: astore_0
        //   148: goto -78 -> 70
        //   151: astore_2
        //   152: goto -82 -> 70
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	155	0	paramContext	Context
        //   0	155	1	paramString	String
        //   1	139	2	localContext	Context
        //   151	1	2	localIOException	IOException
        //   21	43	3	localFile	File
        //   137	4	3	localObject	Object
        //   15	24	4	localFileChannel	java.nio.channels.FileChannel
        // Exception table:
        //   from	to	target	type
        //   2	11	65	java/io/IOException
        //   2	11	88	finally
        //   51	55	109	java/lang/Exception
        //   59	63	113	java/lang/Exception
        //   74	78	117	java/lang/Exception
        //   82	86	121	java/lang/Exception
        //   95	99	125	java/lang/Exception
        //   103	107	129	java/lang/Exception
        //   11	31	133	finally
        //   31	47	137	finally
        //   11	31	145	java/io/IOException
        //   31	47	151	java/io/IOException
    }

    private static File c(Context paramContext) {
        return paramContext.getCacheDir();
    }

    public static boolean c(Context paramContext, String paramString) {
        return paramContext.deleteFile(paramString);
    }

    private static File d(Context paramContext) {
        return new File(c(paramContext), "http");
    }

    private static void e(Context paramContext) {
        try {
            paramContext = d(paramContext);
            d.c(a, "Trying to install HTTP response cache at " + paramContext);
            HttpResponseCache.install(paramContext, 20971520L);
            return;
        } catch (IOException paramContext) {
            d.c(a, "HTTP response cache installation failed", paramContext);
        }
    }

    private static File f(Context paramContext) {
        return new File(c(paramContext), "temp");
    }

    private static void g(Context paramContext) {
        paramContext = f(paramContext);
        if (paramContext.exists()) {
            if (!paramContext.isDirectory()) {
                if (!paramContext.delete()) {
                    break label64;
                }
                if (!paramContext.mkdir()) {
                    d.e(a, "Can not create directory " + paramContext);
                }
            }
        }
        for (; ; ) {
            a(paramContext);
            return;
            label64:
            d.e(a, "Cannot delete file " + paramContext);
            continue;
            if (!paramContext.mkdir()) {
                d.e(a, "Can not create directory " + paramContext);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */