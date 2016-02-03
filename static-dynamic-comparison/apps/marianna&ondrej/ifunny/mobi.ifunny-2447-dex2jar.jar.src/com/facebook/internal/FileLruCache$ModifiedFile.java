package com.facebook.internal;

import java.io.File;

final class FileLruCache$ModifiedFile
        implements Comparable<ModifiedFile> {
    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    private final File file;
    private final long modified;

    FileLruCache$ModifiedFile(File paramFile) {
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

    public int hashCode() {
        return (this.file.hashCode() + 1073) * 37 + (int) (this.modified % 2147483647L);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/FileLruCache$ModifiedFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */