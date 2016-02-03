package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.Settings;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimPending;
    private final Limits limits;
    private final Object lock;
    private final String tag;

    public FileLruCache(Context paramContext, String paramString, Limits paramLimits) {
        this.tag = paramString;
        this.limits = paramLimits;
        this.directory = new File(paramContext.getCacheDir(), paramString);
        this.lock = new Object();
        this.directory.mkdirs();
        BufferFile.deleteAll(this.directory);
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                Settings.getExecutor().execute(new Runnable() {
                    public void run() {
                        FileLruCache.this.trim();
                    }
                });
            }
            return;
        }
    }

    private void renameToTargetAndTrim(String paramString, File paramFile) {
        if (!paramFile.renameTo(new File(this.directory, Utility.md5hash(paramString)))) {
            paramFile.delete();
        }
        postTrim();
    }

    private void trim() {
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            ???=new PriorityQueue();
            l2 = 0L;
            l1 = 0L;
            localObject2 = this.directory.listFiles(BufferFile.excludeBufferFiles());
            j = localObject2.length;
            i = 0;
        } finally {
            int j;
            int i;
            synchronized (this.lock) {
                for (; ; ) {
                    long l2;
                    long l1;
                    this.isTrimPending = false;
                    this.lock.notifyAll();
                    return;
                    File localFile = localObject2[i];
                    ModifiedFile localModifiedFile = new ModifiedFile(localFile);
                    ((PriorityQueue) ? ??).add(localModifiedFile);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(localModifiedFile.getModified()) + " name=" + localModifiedFile.getFile().getName());
                    l2 += localFile.length();
                    l1 += 1L;
                    i += 1;
                    break;
                    Object localObject2 = ((ModifiedFile) ((PriorityQueue) ? ? ?).remove()).getFile();
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + ((File) localObject2).getName());
                    l2 -= ((File) localObject2).length();
                    l1 -= 1L;
                    ((File) localObject2).delete();
                }
                localObject3 =finally;
            }
            synchronized (this.lock) {
                this.isTrimPending = false;
                this.lock.notifyAll();
                throw ((Throwable) localObject3);
            }
        }
        if (l2 <= this.limits.getByteCount()) {
            i = this.limits.getFileCount();
            if (l1 > i) {
            }
        }
    }

    public void clearForTest()
            throws IOException {
        File[] arrayOfFile = this.directory.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return;
            }
            arrayOfFile[i].delete();
            i += 1;
        }
    }

    public InputStream get(String paramString)
            throws IOException {
        return get(paramString, null);
    }

    /* Error */
    public InputStream get(String paramString1, String paramString2)
            throws IOException {
        // Byte code:
        //   0: new 77	java/io/File
        //   3: dup
        //   4: aload_0
        //   5: getfield 88	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
        //   8: aload_1
        //   9: invokestatic 134	com/facebook/internal/Utility:md5hash	(Ljava/lang/String;)Ljava/lang/String;
        //   12: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   15: astore 6
        //   17: new 242	java/io/FileInputStream
        //   20: dup
        //   21: aload 6
        //   23: invokespecial 243	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   26: astore 7
        //   28: new 245	java/io/BufferedInputStream
        //   31: dup
        //   32: aload 7
        //   34: sipush 8192
        //   37: invokespecial 248	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
        //   40: astore 7
        //   42: aload 7
        //   44: invokestatic 252	com/facebook/internal/FileLruCache$StreamHeader:readHeader	(Ljava/io/InputStream;)Lorg/json/JSONObject;
        //   47: astore 8
        //   49: aload 8
        //   51: ifnonnull +17 -> 68
        //   54: iconst_0
        //   55: ifne +8 -> 63
        //   58: aload 7
        //   60: invokevirtual 255	java/io/BufferedInputStream:close	()V
        //   63: aconst_null
        //   64: areturn
        //   65: astore_1
        //   66: aconst_null
        //   67: areturn
        //   68: aload 8
        //   70: ldc 37
        //   72: invokevirtual 260	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   75: astore 9
        //   77: aload 9
        //   79: ifnull +14 -> 93
        //   82: aload 9
        //   84: aload_1
        //   85: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   88: istore_3
        //   89: iload_3
        //   90: ifne +14 -> 104
        //   93: iconst_0
        //   94: ifne +8 -> 102
        //   97: aload 7
        //   99: invokevirtual 255	java/io/BufferedInputStream:close	()V
        //   102: aconst_null
        //   103: areturn
        //   104: aload 8
        //   106: ldc 40
        //   108: aconst_null
        //   109: invokevirtual 268	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   112: astore_1
        //   113: aload_2
        //   114: ifnonnull +7 -> 121
        //   117: aload_1
        //   118: ifnonnull +17 -> 135
        //   121: aload_2
        //   122: ifnull +24 -> 146
        //   125: aload_2
        //   126: aload_1
        //   127: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   130: istore_3
        //   131: iload_3
        //   132: ifne +14 -> 146
        //   135: iconst_0
        //   136: ifne +8 -> 144
        //   139: aload 7
        //   141: invokevirtual 255	java/io/BufferedInputStream:close	()V
        //   144: aconst_null
        //   145: areturn
        //   146: new 270	java/util/Date
        //   149: dup
        //   150: invokespecial 271	java/util/Date:<init>	()V
        //   153: invokevirtual 274	java/util/Date:getTime	()J
        //   156: lstore 4
        //   158: getstatic 149	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
        //   161: getstatic 61	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
        //   164: new 186	java/lang/StringBuilder
        //   167: dup
        //   168: ldc_w 276
        //   171: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   174: lload 4
        //   176: invokestatic 201	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   179: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   182: ldc_w 278
        //   185: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: aload 6
        //   190: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
        //   193: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   196: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   199: invokestatic 157	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
        //   202: aload 6
        //   204: lload 4
        //   206: invokevirtual 282	java/io/File:setLastModified	(J)Z
        //   209: pop
        //   210: iconst_1
        //   211: ifne +8 -> 219
        //   214: aload 7
        //   216: invokevirtual 255	java/io/BufferedInputStream:close	()V
        //   219: aload 7
        //   221: areturn
        //   222: astore_1
        //   223: iconst_0
        //   224: ifne +8 -> 232
        //   227: aload 7
        //   229: invokevirtual 255	java/io/BufferedInputStream:close	()V
        //   232: aload_1
        //   233: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	234	0	this	FileLruCache
        //   0	234	1	paramString1	String
        //   0	234	2	paramString2	String
        //   88	44	3	bool	boolean
        //   156	49	4	l	long
        //   15	188	6	localFile	File
        //   26	202	7	localObject	Object
        //   47	58	8	localJSONObject	JSONObject
        //   75	8	9	str	String
        // Exception table:
        //   from	to	target	type
        //   17	28	65	java/io/IOException
        //   42	49	222	finally
        //   68	77	222	finally
        //   82	89	222	finally
        //   104	113	222	finally
        //   125	131	222	finally
        //   146	210	222	finally
    }

    public InputStream interceptAndPut(String paramString, InputStream paramInputStream)
            throws IOException {
        return new CopyingInputStream(paramInputStream, openPutStream(paramString));
    }

    OutputStream openPutStream(String paramString)
            throws IOException {
        return openPutStream(paramString, null);
    }

    /* Error */
    public OutputStream openPutStream(final String paramString1, String paramString2)
            throws IOException {
        // Byte code:
        //   0: aload_0
        //   1: getfield 88	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
        //   4: invokestatic 302	com/facebook/internal/FileLruCache$BufferFile:newFile	(Ljava/io/File;)Ljava/io/File;
        //   7: astore_3
        //   8: aload_3
        //   9: invokevirtual 141	java/io/File:delete	()Z
        //   12: pop
        //   13: aload_3
        //   14: invokevirtual 305	java/io/File:createNewFile	()Z
        //   17: ifne +31 -> 48
        //   20: new 231	java/io/IOException
        //   23: dup
        //   24: new 186	java/lang/StringBuilder
        //   27: dup
        //   28: ldc_w 307
        //   31: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   34: aload_3
        //   35: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
        //   38: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   41: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   44: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   47: athrow
        //   48: new 313	java/io/FileOutputStream
        //   51: dup
        //   52: aload_3
        //   53: invokespecial 314	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   56: astore 4
        //   58: new 316	java/io/BufferedOutputStream
        //   61: dup
        //   62: new 17	com/facebook/internal/FileLruCache$CloseCallbackOutputStream
        //   65: dup
        //   66: aload 4
        //   68: new 6	com/facebook/internal/FileLruCache$1
        //   71: dup
        //   72: aload_0
        //   73: aload_1
        //   74: aload_3
        //   75: invokespecial 318	com/facebook/internal/FileLruCache$1:<init>	(Lcom/facebook/internal/FileLruCache;Ljava/lang/String;Ljava/io/File;)V
        //   78: invokespecial 321	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
        //   81: sipush 8192
        //   84: invokespecial 324	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
        //   87: astore_3
        //   88: new 257	org/json/JSONObject
        //   91: dup
        //   92: invokespecial 325	org/json/JSONObject:<init>	()V
        //   95: astore 4
        //   97: aload 4
        //   99: ldc 37
        //   101: aload_1
        //   102: invokevirtual 329	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   105: pop
        //   106: aload_2
        //   107: invokestatic 333	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   110: ifne +12 -> 122
        //   113: aload 4
        //   115: ldc 40
        //   117: aload_2
        //   118: invokevirtual 329	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   121: pop
        //   122: aload_3
        //   123: aload 4
        //   125: invokestatic 337	com/facebook/internal/FileLruCache$StreamHeader:writeHeader	(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
        //   128: iconst_1
        //   129: ifne +7 -> 136
        //   132: aload_3
        //   133: invokevirtual 338	java/io/BufferedOutputStream:close	()V
        //   136: aload_3
        //   137: areturn
        //   138: astore_1
        //   139: getstatic 149	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
        //   142: iconst_5
        //   143: getstatic 61	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
        //   146: new 186	java/lang/StringBuilder
        //   149: dup
        //   150: ldc_w 340
        //   153: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   156: aload_1
        //   157: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   160: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   163: invokestatic 343	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
        //   166: new 231	java/io/IOException
        //   169: dup
        //   170: aload_1
        //   171: invokevirtual 346	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
        //   174: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   177: athrow
        //   178: astore_1
        //   179: getstatic 149	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
        //   182: iconst_5
        //   183: getstatic 61	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
        //   186: new 186	java/lang/StringBuilder
        //   189: dup
        //   190: ldc_w 348
        //   193: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   196: aload_1
        //   197: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   200: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   203: invokestatic 343	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
        //   206: new 231	java/io/IOException
        //   209: dup
        //   210: aload_1
        //   211: invokevirtual 349	org/json/JSONException:getMessage	()Ljava/lang/String;
        //   214: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   217: athrow
        //   218: astore_1
        //   219: iconst_0
        //   220: ifne +7 -> 227
        //   223: aload_3
        //   224: invokevirtual 338	java/io/BufferedOutputStream:close	()V
        //   227: aload_1
        //   228: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	229	0	this	FileLruCache
        //   0	229	1	paramString1	String
        //   0	229	2	paramString2	String
        //   7	217	3	localObject1	Object
        //   56	68	4	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   48	58	138	java/io/FileNotFoundException
        //   88	122	178	org/json/JSONException
        //   122	128	178	org/json/JSONException
        //   88	122	218	finally
        //   122	128	218	finally
        //   179	218	218	finally
    }

    long sizeInBytesForTest() {
        for (; ; ) {
            long l;
            int i;
            synchronized (this.lock) {
                if (!this.isTrimPending) {
                    ???=this.directory.listFiles();
                    l = 0L;
                    int j =???.length;
                    i = 0;
                    if (i >= j) {
                        return l;
                    }
                } else {
                    try {
                        this.lock.wait();
                    } catch (InterruptedException localInterruptedException) {
                    }
                }
            }
            l +=???[i].length();
            i += 1;
        }
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }

    private static class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() {
            public boolean accept(File paramAnonymousFile, String paramAnonymousString) {
                return !paramAnonymousString.startsWith("buffer");
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() {
            public boolean accept(File paramAnonymousFile, String paramAnonymousString) {
                return paramAnonymousString.startsWith("buffer");
            }
        };

        static void deleteAll(File paramFile) {
            paramFile = paramFile.listFiles(excludeNonBufferFiles());
            int j = paramFile.length;
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    return;
                }
                paramFile[i].delete();
                i += 1;
            }
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File paramFile) {
            return new File(paramFile, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }
    }

    private static class CloseCallbackOutputStream
            extends OutputStream {
        final FileLruCache.StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream paramOutputStream, FileLruCache.StreamCloseCallback paramStreamCloseCallback) {
            this.innerStream = paramOutputStream;
            this.callback = paramStreamCloseCallback;
        }

        public void close()
                throws IOException {
            try {
                this.innerStream.close();
                return;
            } finally {
                this.callback.onClose();
            }
        }

        public void flush()
                throws IOException {
            this.innerStream.flush();
        }

        public void write(int paramInt)
                throws IOException {
            this.innerStream.write(paramInt);
        }

        public void write(byte[] paramArrayOfByte)
                throws IOException {
            this.innerStream.write(paramArrayOfByte);
        }

        public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            this.innerStream.write(paramArrayOfByte, paramInt1, paramInt2);
        }
    }

    private static final class CopyingInputStream
            extends InputStream {
        final InputStream input;
        final OutputStream output;

        CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream) {
            this.input = paramInputStream;
            this.output = paramOutputStream;
        }

        public int available()
                throws IOException {
            return this.input.available();
        }

        public void close()
                throws IOException {
            try {
                this.input.close();
                return;
            } finally {
                this.output.close();
            }
        }

        public void mark(int paramInt) {
            throw new UnsupportedOperationException();
        }

        public boolean markSupported() {
            return false;
        }

        public int read()
                throws IOException {
            int i = this.input.read();
            if (i >= 0) {
                this.output.write(i);
            }
            return i;
        }

        public int read(byte[] paramArrayOfByte)
                throws IOException {
            int i = this.input.read(paramArrayOfByte);
            if (i > 0) {
                this.output.write(paramArrayOfByte, 0, i);
            }
            return i;
        }

        public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
                throws IOException {
            paramInt2 = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt2 > 0) {
                this.output.write(paramArrayOfByte, paramInt1, paramInt2);
            }
            return paramInt2;
        }

        public void reset() {
            try {
                throw new UnsupportedOperationException();
            } finally {
            }
        }

        public long skip(long paramLong)
                throws IOException {
            byte[] arrayOfByte = new byte['Ѐ'];
            int i;
            for (long l = 0L; ; l += i) {
                if (l >= paramLong) {
                }
                do {
                    return l;
                    i = read(arrayOfByte, 0, (int) Math.min(paramLong - l, arrayOfByte.length));
                } while (i < 0);
            }
        }
    }

    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = 1024;

        int getByteCount() {
            return this.byteCount;
        }

        int getFileCount() {
            return this.fileCount;
        }

        void setByteCount(int paramInt) {
            if (paramInt < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = paramInt;
        }

        void setFileCount(int paramInt) {
            if (paramInt < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = paramInt;
        }
    }

    private static final class ModifiedFile
            implements Comparable<ModifiedFile> {
        private final File file;
        private final long modified;

        ModifiedFile(File paramFile) {
            this.file = paramFile;
            this.modified = paramFile.lastModified();
        }

        public int compareTo(ModifiedFile paramModifiedFile) {
            if (getModified() < paramModifiedFile.getModified()) {
                return -1;
            }
            if (getModified() > paramModifiedFile.getModified()) {
                return 1;
            }
            return getFile().compareTo(paramModifiedFile.getFile());
        }

        public boolean equals(Object paramObject) {
            return ((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile) paramObject) == 0);
        }

        File getFile() {
            return this.file;
        }

        long getModified() {
            return this.modified;
        }
    }

    private static abstract interface StreamCloseCallback {
        public abstract void onClose();
    }

    private static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        static JSONObject readHeader(InputStream paramInputStream)
                throws IOException {
            if (paramInputStream.read() != 0) {
                return null;
            }
            int j = 0;
            int i = 0;
            for (; ; ) {
                byte[] arrayOfByte;
                if (i >= 3) {
                    arrayOfByte = new byte[j];
                    i = 0;
                    label25:
                    if (i < arrayOfByte.length) {
                        break label135;
                    }
                    paramInputStream = new JSONTokener(new String(arrayOfByte));
                }
                try {
                    paramInputStream = paramInputStream.nextValue();
                    if (!(paramInputStream instanceof JSONObject)) {
                        Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + paramInputStream.getClass().getCanonicalName());
                        return null;
                        int k = paramInputStream.read();
                        if (k == -1) {
                            Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                            return null;
                        }
                        j = (j << 8) + (k & 0xFF);
                        i += 1;
                        continue;
                        label135:
                        j = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
                        if (j < 1) {
                            Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + arrayOfByte.length);
                            return null;
                        }
                        i += j;
                        break label25;
                    }
                    paramInputStream = (JSONObject) paramInputStream;
                    return paramInputStream;
                } catch (JSONException paramInputStream) {
                    throw new IOException(paramInputStream.getMessage());
                }
            }
        }

        static void writeHeader(OutputStream paramOutputStream, JSONObject paramJSONObject)
                throws IOException {
            paramJSONObject = paramJSONObject.toString().getBytes();
            paramOutputStream.write(0);
            paramOutputStream.write(paramJSONObject.length >> 16 & 0xFF);
            paramOutputStream.write(paramJSONObject.length >> 8 & 0xFF);
            paramOutputStream.write(paramJSONObject.length >> 0 & 0xFF);
            paramOutputStream.write(paramJSONObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/internal/FileLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */