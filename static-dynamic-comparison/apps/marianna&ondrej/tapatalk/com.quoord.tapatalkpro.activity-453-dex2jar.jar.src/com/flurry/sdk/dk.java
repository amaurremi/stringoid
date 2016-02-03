package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dk {
    private static final String a = dk.class.getSimpleName();
    private boolean b;
    private List<dh> c;
    private long d = -1L;

    private static String a(String paramString) {
        Object localObject = paramString;
        if (paramString != null) {
            localObject = paramString;
            if (paramString.length() > 4) {
                localObject = new StringBuilder();
                int i = 0;
                while (i < paramString.length() - 4) {
                    ((StringBuilder) localObject).append('*');
                    i += 1;
                }
                ((StringBuilder) localObject).append(paramString.substring(paramString.length() - 4));
                localObject = ((StringBuilder) localObject).toString();
            }
        }
        return (String) localObject;
    }

    private boolean a(String paramString, DataInputStream paramDataInputStream)
            throws IOException {
        int i = paramDataInputStream.readUnsignedShort();
        eo.a(3, a, "File version: " + i);
        if (i > 2) {
            eo.a(6, a, "Unknown agent file version: " + i);
            throw new IOException("Unknown agent file version: " + i);
        }
        if (i >= 2) {
            Object localObject = paramDataInputStream.readUTF();
            eo.a(3, a, "Loading API key: " + a(paramString));
            if (((String) localObject).equals(paramString)) {
                paramString = new ArrayList();
                paramDataInputStream.readUTF();
                boolean bool = paramDataInputStream.readBoolean();
                long l = paramDataInputStream.readLong();
                eo.a(3, a, "Loading session reports");
                i = 0;
                for (; ; ) {
                    int j = paramDataInputStream.readUnsignedShort();
                    if (j == 0) {
                        eo.a(3, a, "Persistent file loaded");
                        a(bool);
                        a(l);
                        a(paramString);
                        return true;
                    }
                    localObject = new byte[j];
                    paramDataInputStream.readFully((byte[]) localObject);
                    paramString.add(0, new dh((byte[]) localObject));
                    localObject = a;
                    StringBuilder localStringBuilder = new StringBuilder().append("Session report added: ");
                    i += 1;
                    eo.a(3, (String) localObject, i);
                }
            }
            eo.a(3, a, "Api keys do not match, old: " + a(paramString) + ", new: " + a((String) localObject));
            return false;
        }
        eo.a(5, a, "Deleting old file version: " + i);
        return false;
    }

    public void a(long paramLong) {
        this.d = paramLong;
    }

    /* Error */
    public void a(java.io.DataOutputStream paramDataOutputStream, String paramString1, String paramString2)
            throws IOException {
        // Byte code:
        //   0: aload_1
        //   1: ldc -116
        //   3: invokevirtual 146	java/io/DataOutputStream:writeShort	(I)V
        //   6: aload_1
        //   7: iconst_2
        //   8: invokevirtual 146	java/io/DataOutputStream:writeShort	(I)V
        //   11: aload_1
        //   12: aload_2
        //   13: invokevirtual 149	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: aload_3
        //   18: invokevirtual 149	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
        //   21: aload_1
        //   22: aload_0
        //   23: getfield 151	com/flurry/sdk/dk:b	Z
        //   26: invokevirtual 154	java/io/DataOutputStream:writeBoolean	(Z)V
        //   29: aload_1
        //   30: aload_0
        //   31: getfield 31	com/flurry/sdk/dk:d	J
        //   34: invokevirtual 157	java/io/DataOutputStream:writeLong	(J)V
        //   37: aload_0
        //   38: getfield 159	com/flurry/sdk/dk:c	Ljava/util/List;
        //   41: invokeinterface 162 1 0
        //   46: iconst_1
        //   47: isub
        //   48: istore 4
        //   50: iload 4
        //   52: iflt +67 -> 119
        //   55: aload_0
        //   56: getfield 159	com/flurry/sdk/dk:c	Ljava/util/List;
        //   59: iload 4
        //   61: invokeinterface 166 2 0
        //   66: checkcast 119	com/flurry/sdk/dh
        //   69: invokevirtual 169	com/flurry/sdk/dh:a	()[B
        //   72: astore_2
        //   73: aload_2
        //   74: arraylength
        //   75: istore 5
        //   77: iload 5
        //   79: iconst_2
        //   80: iadd
        //   81: aload_1
        //   82: invokevirtual 170	java/io/DataOutputStream:size	()I
        //   85: iadd
        //   86: ldc -85
        //   88: if_icmple +41 -> 129
        //   91: bipush 6
        //   93: getstatic 23	com/flurry/sdk/dk:a	Ljava/lang/String;
        //   96: new 40	java/lang/StringBuilder
        //   99: dup
        //   100: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   103: ldc -83
        //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   108: iload 4
        //   110: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   113: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   116: invokestatic 73	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   119: aload_1
        //   120: iconst_0
        //   121: invokevirtual 146	java/io/DataOutputStream:writeShort	(I)V
        //   124: aload_1
        //   125: invokestatic 178	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   128: return
        //   129: aload_1
        //   130: iload 5
        //   132: invokevirtual 146	java/io/DataOutputStream:writeShort	(I)V
        //   135: aload_1
        //   136: aload_2
        //   137: invokevirtual 181	java/io/DataOutputStream:write	([B)V
        //   140: iload 4
        //   142: iconst_1
        //   143: isub
        //   144: istore 4
        //   146: goto -96 -> 50
        //   149: astore_2
        //   150: bipush 6
        //   152: getstatic 23	com/flurry/sdk/dk:a	Ljava/lang/String;
        //   155: ldc -73
        //   157: aload_2
        //   158: invokestatic 186	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   161: new 58	java/io/IOException
        //   164: dup
        //   165: aload_2
        //   166: invokevirtual 189	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   169: invokespecial 78	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   172: athrow
        //   173: astore_2
        //   174: aload_1
        //   175: invokestatic 178	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   178: aload_2
        //   179: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	180	0	this	dk
        //   0	180	1	paramDataOutputStream	java.io.DataOutputStream
        //   0	180	2	paramString1	String
        //   0	180	3	paramString2	String
        //   48	97	4	i	int
        //   75	56	5	j	int
        // Exception table:
        //   from	to	target	type
        //   0	50	149	java/lang/Throwable
        //   55	119	149	java/lang/Throwable
        //   119	124	149	java/lang/Throwable
        //   129	140	149	java/lang/Throwable
        //   0	50	173	finally
        //   55	119	173	finally
        //   119	124	173	finally
        //   129	140	173	finally
        //   150	173	173	finally
    }

    public void a(List<dh> paramList) {
        this.c = paramList;
    }

    public void a(boolean paramBoolean) {
        this.b = paramBoolean;
    }

    public boolean a() {
        return this.b;
    }

    /* Error */
    public boolean a(DataInputStream paramDataInputStream, String paramString)
            throws IOException {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: aload_1
        //   4: invokevirtual 63	java/io/DataInputStream:readUnsignedShort	()I
        //   7: istore_3
        //   8: iconst_4
        //   9: getstatic 23	com/flurry/sdk/dk:a	Ljava/lang/String;
        //   12: new 40	java/lang/StringBuilder
        //   15: dup
        //   16: invokespecial 41	java/lang/StringBuilder:<init>	()V
        //   19: ldc -62
        //   21: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   24: iload_3
        //   25: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   28: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   31: invokestatic 73	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   34: iload_3
        //   35: ldc -116
        //   37: if_icmpne +18 -> 55
        //   40: aload_0
        //   41: aload_2
        //   42: aload_1
        //   43: invokespecial 196	com/flurry/sdk/dk:a	(Ljava/lang/String;Ljava/io/DataInputStream;)Z
        //   46: istore 4
        //   48: aload_1
        //   49: invokestatic 178	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   52: iload 4
        //   54: ireturn
        //   55: iconst_3
        //   56: getstatic 23	com/flurry/sdk/dk:a	Ljava/lang/String;
        //   59: ldc -58
        //   61: invokestatic 73	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   64: goto -16 -> 48
        //   67: astore_2
        //   68: bipush 6
        //   70: getstatic 23	com/flurry/sdk/dk:a	Ljava/lang/String;
        //   73: ldc -56
        //   75: aload_2
        //   76: invokestatic 186	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   79: new 58	java/io/IOException
        //   82: dup
        //   83: aload_2
        //   84: invokevirtual 189	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   87: invokespecial 78	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   90: athrow
        //   91: astore_2
        //   92: aload_1
        //   93: invokestatic 178	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
        //   96: aload_2
        //   97: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	98	0	this	dk
        //   0	98	1	paramDataInputStream	DataInputStream
        //   0	98	2	paramString	String
        //   7	31	3	i	int
        //   1	52	4	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   3	34	67	java/lang/Throwable
        //   40	48	67	java/lang/Throwable
        //   55	64	67	java/lang/Throwable
        //   3	34	91	finally
        //   40	48	91	finally
        //   55	64	91	finally
        //   68	91	91	finally
    }

    public List<dh> b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */