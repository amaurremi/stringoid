package com.facebook;

import com.facebook.internal.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class NativeAppCallAttachmentStore$2
        implements NativeAppCallAttachmentStore.ProcessAttachment<File> {
    NativeAppCallAttachmentStore$2(NativeAppCallAttachmentStore paramNativeAppCallAttachmentStore) {
    }

    public void processAttachment(File paramFile1, File paramFile2) {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
        try {
            paramFile2 = new FileInputStream(paramFile1);
            try {
                paramFile1 = new byte['Ѐ'];
                for (; ; ) {
                    int i = paramFile2.read(paramFile1);
                    if (i <= 0) {
                        break;
                    }
                    localFileOutputStream.write(paramFile1, 0, i);
                }
                Utility.closeQuietly(localFileOutputStream);
            } finally {
            }
        } finally {
            for (; ; ) {
                paramFile2 = null;
            }
        }
        Utility.closeQuietly(paramFile2);
        throw paramFile1;
        Utility.closeQuietly(localFileOutputStream);
        Utility.closeQuietly(paramFile2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/NativeAppCallAttachmentStore$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */