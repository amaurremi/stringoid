package javassist;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

final class ClassPoolTail {
    protected ClassPathList pathList = null;

    public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream) {
        int k = 4096;
        byte[] arrayOfByte = null;
        int i = 0;
        while (i < 64) {
            int j = k;
            if (i < 8) {
                j = k * 2;
                arrayOfByte = new byte[j];
            }
            k = 0;
            int m;
            do {
                m = paramInputStream.read(arrayOfByte, k, j - k);
                if (m < 0) {
                    break;
                }
                m = k + m;
                k = m;
            } while (m < j);
            paramOutputStream.write(arrayOfByte);
            i += 1;
            k = j;
            continue;
            paramOutputStream.write(arrayOfByte, 0, k);
            return;
        }
        throw new IOException("too much data");
    }

    private static ClassPath makePathObject(String paramString) {
        String str = paramString.toLowerCase();
        if ((str.endsWith(".jar")) || (str.endsWith(".zip"))) {
            return new JarClassPath(paramString);
        }
        int i = paramString.length();
        if ((i > 2) && (paramString.charAt(i - 1) == '*') && ((paramString.charAt(i - 2) == '/') || (paramString.charAt(i - 2) == File.separatorChar))) {
            return new JarDirClassPath(paramString.substring(0, i - 2));
        }
        return new DirClassPath(paramString);
    }

    public static byte[] readStream(InputStream paramInputStream) {
        byte[][] arrayOfByte = new byte[8][];
        int i = 0;
        int k = 4096;
        while (i < 8) {
            arrayOfByte[i] = new byte[k];
            int j = 0;
            do {
                m = paramInputStream.read(arrayOfByte[i], j, k - j);
                if (m < 0) {
                    break;
                }
                m = j + m;
                j = m;
            } while (m < k);
            k *= 2;
            i += 1;
            continue;
            paramInputStream = new byte[k - 4096 + j];
            k = 0;
            int m = 0;
            while (k < i) {
                System.arraycopy(arrayOfByte[k], 0, paramInputStream, m, m + 4096);
                m = m + m + 4096;
                k += 1;
            }
            System.arraycopy(arrayOfByte[i], 0, paramInputStream, m, j);
            return paramInputStream;
        }
        throw new IOException("too much data");
    }

    public ClassPath appendClassPath(String paramString) {
        return appendClassPath(makePathObject(paramString));
    }

    /* Error */
    public ClassPath appendClassPath(ClassPath paramClassPath) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: new 98	javassist/ClassPathList
        //   5: dup
        //   6: aload_1
        //   7: aconst_null
        //   8: invokespecial 101	javassist/ClassPathList:<init>	(Ljavassist/ClassPath;Ljavassist/ClassPathList;)V
        //   11: astore 4
        //   13: aload_0
        //   14: getfield 12	javassist/ClassPoolTail:pathList	Ljavassist/ClassPathList;
        //   17: astore_3
        //   18: aload_3
        //   19: astore_2
        //   20: aload_3
        //   21: ifnonnull +13 -> 34
        //   24: aload_0
        //   25: aload 4
        //   27: putfield 12	javassist/ClassPoolTail:pathList	Ljavassist/ClassPathList;
        //   30: aload_0
        //   31: monitorexit
        //   32: aload_1
        //   33: areturn
        //   34: aload_2
        //   35: getfield 104	javassist/ClassPathList:next	Ljavassist/ClassPathList;
        //   38: ifnull +11 -> 49
        //   41: aload_2
        //   42: getfield 104	javassist/ClassPathList:next	Ljavassist/ClassPathList;
        //   45: astore_2
        //   46: goto -12 -> 34
        //   49: aload_2
        //   50: aload 4
        //   52: putfield 104	javassist/ClassPathList:next	Ljavassist/ClassPathList;
        //   55: goto -25 -> 30
        //   58: astore_1
        //   59: aload_0
        //   60: monitorexit
        //   61: aload_1
        //   62: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	63	0	this	ClassPoolTail
        //   0	63	1	paramClassPath	ClassPath
        //   19	31	2	localClassPathList1	ClassPathList
        //   17	4	3	localClassPathList2	ClassPathList
        //   11	40	4	localClassPathList3	ClassPathList
        // Exception table:
        //   from	to	target	type
        //   2	18	58	finally
        //   24	30	58	finally
        //   34	46	58	finally
        //   49	55	58	finally
    }

    public ClassPath appendSystemPath() {
        return appendClassPath(new ClassClassPath());
    }

    public URL find(String paramString) {
        for (ClassPathList localClassPathList = this.pathList; localClassPathList != null; localClassPathList = localClassPathList.next) {
            URL localURL2 = localClassPathList.path.find(paramString);
            localURL1 = localURL2;
            if (localURL2 != null) {
                return localURL1;
            }
        }
        URL localURL1 = null;
        return localURL1;
    }

    public ClassPath insertClassPath(String paramString) {
        return insertClassPath(makePathObject(paramString));
    }

    public ClassPath insertClassPath(ClassPath paramClassPath) {
        try {
            this.pathList = new ClassPathList(paramClassPath, this.pathList);
            return paramClassPath;
        } finally {
            paramClassPath =finally;
            throw paramClassPath;
        }
    }

    InputStream openClassfile(String paramString) {
        ClassPathList localClassPathList = this.pathList;
        Object localObject2 = null;
        Object localObject1 = null;
        if (localClassPathList != null) {
        }
        label69:
        label72:
        for (; ; ) {
            try {
                Object localObject3 = localClassPathList.path.openClassfile(paramString);
                localObject1 = localObject3;
                localObject3 = localObject1;
                if (localObject1 != null) {
                    break label69;
                }
                localClassPathList = localClassPathList.next;
            } catch (NotFoundException localNotFoundException) {
                if (localObject2 != null) {
                    break label72;
                }
            }
            localObject2 = localNotFoundException;
            continue;
            if (localObject2 != null) {
                throw ((Throwable) localObject2);
            }
            InputStream localInputStream = null;
            return localInputStream;
        }
    }

    public void removeClassPath(ClassPath paramClassPath) {
        for (; ; ) {
            try {
                ClassPathList localClassPathList2 = this.pathList;
                if (localClassPathList2 != null) {
                    localClassPathList1 = localClassPathList2;
                    if (localClassPathList2.path == paramClassPath) {
                        this.pathList = localClassPathList2.next;
                    }
                } else {
                    paramClassPath.close();
                    return;
                }
                if (localClassPathList1.next != null) {
                    if (localClassPathList1.next.path == paramClassPath) {
                        localClassPathList1.next = localClassPathList1.next.next;
                    }
                } else {
                    continue;
                }
                ClassPathList localClassPathList1 = localClassPathList1.next;
            } finally {
            }
        }
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("[class path: ");
        for (ClassPathList localClassPathList = this.pathList; localClassPathList != null; localClassPathList = localClassPathList.next) {
            localStringBuffer.append(localClassPathList.path.toString());
            localStringBuffer.append(File.pathSeparatorChar);
        }
        localStringBuffer.append(']');
        return localStringBuffer.toString();
    }

    void writeClassfile(String paramString, OutputStream paramOutputStream) {
        InputStream localInputStream = openClassfile(paramString);
        if (localInputStream == null) {
            throw new NotFoundException(paramString);
        }
        try {
            copyStream(localInputStream, paramOutputStream);
            return;
        } finally {
            localInputStream.close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassPoolTail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */