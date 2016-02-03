package mobi.ifunny.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class s {
    public static int a(InputStream paramInputStream, OutputStream paramOutputStream, u paramu) {
        int j;
        if ((paramInputStream == null) || (paramOutputStream == null) || (paramu == null)) {
            j = 0;
        }
        for (; ; ) {
            return j;
            byte[] arrayOfByte = new byte[paramu.b()];
            int i = 0;
            try {
                do {
                    int k = paramInputStream.read(arrayOfByte);
                    j = i;
                    if (k == -1) {
                        break;
                    }
                    paramOutputStream.write(arrayOfByte, 0, k);
                    j = i + k;
                    i = j;
                } while (!paramu.a(j));
                throw new t(j, true);
            } catch (IOException paramInputStream) {
                paramOutputStream = new t(i, false);
                paramOutputStream.initCause(paramInputStream);
                throw paramOutputStream;
            }
        }
    }

    /* Error */
    public static String a(InputStream paramInputStream) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: new 43	java/io/InputStreamReader
        //   5: dup
        //   6: aload_0
        //   7: invokespecial 46	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   10: astore_1
        //   11: new 48	java/io/BufferedReader
        //   14: dup
        //   15: aload_1
        //   16: invokespecial 51	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   19: astore_0
        //   20: new 53	java/lang/StringBuilder
        //   23: dup
        //   24: invokespecial 56	java/lang/StringBuilder:<init>	()V
        //   27: astore_2
        //   28: aload_0
        //   29: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   32: astore_3
        //   33: aload_3
        //   34: ifnull +27 -> 61
        //   37: aload_2
        //   38: aload_3
        //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: pop
        //   43: goto -15 -> 28
        //   46: astore_3
        //   47: aload_0
        //   48: astore_2
        //   49: aload_3
        //   50: astore_0
        //   51: aload_2
        //   52: ifnull +34 -> 86
        //   55: aload_2
        //   56: invokevirtual 67	java/io/BufferedReader:close	()V
        //   59: aload_0
        //   60: athrow
        //   61: aload_2
        //   62: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   65: astore_2
        //   66: aload_0
        //   67: ifnull +9 -> 76
        //   70: aload_0
        //   71: invokevirtual 67	java/io/BufferedReader:close	()V
        //   74: aload_2
        //   75: areturn
        //   76: aload_1
        //   77: ifnull -3 -> 74
        //   80: aload_1
        //   81: invokevirtual 71	java/io/InputStreamReader:close	()V
        //   84: aload_2
        //   85: areturn
        //   86: aload_1
        //   87: ifnull -28 -> 59
        //   90: aload_1
        //   91: invokevirtual 71	java/io/InputStreamReader:close	()V
        //   94: goto -35 -> 59
        //   97: astore_0
        //   98: aconst_null
        //   99: astore_1
        //   100: goto -49 -> 51
        //   103: astore_0
        //   104: goto -53 -> 51
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	107	0	paramInputStream	InputStream
        //   10	90	1	localInputStreamReader	java.io.InputStreamReader
        //   1	84	2	localObject1	Object
        //   32	7	3	str	String
        //   46	4	3	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   20	28	46	finally
        //   28	33	46	finally
        //   37	43	46	finally
        //   61	66	46	finally
        //   2	11	97	finally
        //   11	20	103	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */