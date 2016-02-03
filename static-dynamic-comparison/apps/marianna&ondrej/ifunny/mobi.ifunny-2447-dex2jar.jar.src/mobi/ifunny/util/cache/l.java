package mobi.ifunny.util.cache;

import java.io.File;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.video.a;
import mobi.ifunny.video.c;
import mobi.ifunny.video.m;

final class l
        implements i<c> {
    private final boolean a;

    private l(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    public c a(byte[] paramArrayOfByte) {
        File localFile = mobi.ifunny.util.l.a(IFunnyApplication.a, paramArrayOfByte);
        if (localFile != null) {
            try {
                if (this.a) {
                }
                for (paramArrayOfByte = new m(localFile); ; paramArrayOfByte = new a(localFile)) {
                    if (paramArrayOfByte == null) {
                        localFile.delete();
                    }
                    return paramArrayOfByte;
                }
            } catch (UnsatisfiedLinkError paramArrayOfByte) {
                for (; ; ) {
                    paramArrayOfByte = null;
                }
            } catch (Exception paramArrayOfByte) {
                for (; ; ) {
                    paramArrayOfByte = null;
                }
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/cache/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */