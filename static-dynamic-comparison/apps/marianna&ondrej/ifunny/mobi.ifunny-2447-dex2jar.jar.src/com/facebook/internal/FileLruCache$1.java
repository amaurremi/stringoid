package com.facebook.internal;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

class FileLruCache$1
        implements FileLruCache.StreamCloseCallback {
    FileLruCache$1(FileLruCache paramFileLruCache, long paramLong, File paramFile, String paramString) {
    }

    public void onClose() {
        if (this.val$bufferFileCreateTime < FileLruCache.access$000(this.this$0).get()) {
            this.val$buffer.delete();
            return;
        }
        FileLruCache.access$100(this.this$0, this.val$key, this.val$buffer);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */