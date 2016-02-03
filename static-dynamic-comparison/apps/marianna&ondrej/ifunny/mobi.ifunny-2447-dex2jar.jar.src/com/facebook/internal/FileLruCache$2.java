package com.facebook.internal;

import java.io.File;

class FileLruCache$2
        implements Runnable {
    FileLruCache$2(FileLruCache paramFileLruCache, File[] paramArrayOfFile) {
    }

    public void run() {
        File[] arrayOfFile = this.val$filesToDelete;
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j) {
            arrayOfFile[i].delete();
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */