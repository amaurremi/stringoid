package net.hockeyapp.android;

import android.os.Process;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

public class h
        implements Thread.UncaughtExceptionHandler {
    private boolean a = false;
    private g b;
    private Thread.UncaughtExceptionHandler c;

    public h(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, g paramg, boolean paramBoolean) {
        this.c = paramUncaughtExceptionHandler;
        this.a = paramBoolean;
        this.b = paramg;
    }

    private static String a(String paramString) {
        String str = paramString;
        if (paramString != null) {
            str = paramString;
            if (paramString.length() > 255) {
                str = paramString.substring(0, 255);
            }
        }
        return str;
    }

    private static void a(String paramString1, String paramString2) {
        try {
            paramString2 = a.a + "/" + paramString2;
            if (paramString1.trim().length() > 0) {
                paramString2 = new BufferedWriter(new FileWriter(paramString2));
                paramString2.write(paramString1);
                paramString2.flush();
                paramString2.close();
            }
            return;
        } catch (Exception paramString1) {
        }
    }

    public static void a(Throwable paramThrowable, g paramg) {
        Date localDate = new Date();
        StringWriter localStringWriter = new StringWriter();
        paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
        try {
            paramThrowable = UUID.randomUUID().toString();
            Object localObject = a.a + "/" + paramThrowable + ".stacktrace";
            Log.d("HockeyApp", "Writing unhandled exception to: " + (String) localObject);
            localObject = new BufferedWriter(new FileWriter((String) localObject));
            ((BufferedWriter) localObject).write("Package: " + a.d + "\n");
            ((BufferedWriter) localObject).write("Version Code: " + a.b + "\n");
            ((BufferedWriter) localObject).write("Version Name: " + a.c + "\n");
            if ((paramg == null) || (paramg.d())) {
                ((BufferedWriter) localObject).write("Android: " + a.e + "\n");
                ((BufferedWriter) localObject).write("Manufacturer: " + a.g + "\n");
                ((BufferedWriter) localObject).write("Model: " + a.f + "\n");
            }
            ((BufferedWriter) localObject).write("Date: " + localDate + "\n");
            ((BufferedWriter) localObject).write("\n");
            ((BufferedWriter) localObject).write(localStringWriter.toString());
            ((BufferedWriter) localObject).flush();
            ((BufferedWriter) localObject).close();
            if (paramg != null) {
                a(a(paramg.g()), paramThrowable + ".user");
                a(a(paramg.e()), paramThrowable + ".contact");
                a(paramg.f(), paramThrowable + ".description");
            }
            return;
        } catch (Exception paramThrowable) {
            Log.e("HockeyApp", "Error saving exception stacktrace!\n", paramThrowable);
        }
    }

    public void a(g paramg) {
        this.b = paramg;
    }

    public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
        if (a.a == null) {
            this.c.uncaughtException(paramThread, paramThrowable);
            return;
        }
        a(paramThrowable, this.b);
        if (!this.a) {
            this.c.uncaughtException(paramThread, paramThrowable);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/net/hockeyapp/android/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */