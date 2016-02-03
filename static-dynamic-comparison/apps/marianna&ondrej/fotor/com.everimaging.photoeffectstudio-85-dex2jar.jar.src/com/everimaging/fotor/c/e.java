package com.everimaging.fotor.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

import java.io.FileOutputStream;
import java.io.IOException;

public class e {
    private static final String a = e.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);

    public static int a(int paramInt) {
        if (paramInt == -1) {
        }
        for (int i = 0; ; i = paramInt) {
            i %= 360;
            if (i < 45) {
                i = 0;
            }
            for (; ; ) {
                b.c(new Object[]{"map orientation " + paramInt + " to " + i});
                return i;
                if (i < 135) {
                    i = 90;
                } else if (i < 225) {
                    i = 180;
                } else if (i < 315) {
                    i = 270;
                } else {
                    i = 0;
                }
            }
        }
    }

    public static View.OnClickListener a() {
        new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
            }
        };
    }

    public static boolean a(byte[] paramArrayOfByte, String paramString) {
        try {
            paramString = new FileOutputStream(paramString);
            paramString.write(paramArrayOfByte);
            paramString.close();
            return true;
        } catch (IOException paramArrayOfByte) {
        }
        return false;
    }

    public static int b(int paramInt) {
        if (paramInt == -1) {
        }
        for (int i = 0; ; i = paramInt) {
            i %= 360;
            if (i < 45) {
                i = 180;
            }
            for (; ; ) {
                b.c(new Object[]{"map orientation " + paramInt + " to " + i});
                return i;
                if (i < 135) {
                    i = 90;
                } else if (i < 225) {
                    i = 0;
                } else if (i < 315) {
                    i = 270;
                } else {
                    i = 0;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */