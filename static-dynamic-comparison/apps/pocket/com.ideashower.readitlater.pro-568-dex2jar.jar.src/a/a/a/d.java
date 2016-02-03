package a.a.a;

import android.os.Process;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

public class d
  implements Thread.UncaughtExceptionHandler
{
  private boolean a = false;
  private c b;
  private Thread.UncaughtExceptionHandler c;
  
  public d(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, c paramc, boolean paramBoolean)
  {
    this.c = paramUncaughtExceptionHandler;
    this.a = paramBoolean;
    this.b = paramc;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 255) {
        str = paramString.substring(0, 255);
      }
    }
    return str;
  }
  
  private static void a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = a.a + "/" + paramString2;
      if (paramString1.trim().length() > 0)
      {
        paramString2 = new BufferedWriter(new FileWriter(paramString2));
        paramString2.write(paramString1);
        paramString2.flush();
        paramString2.close();
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void a(Throwable paramThrowable, c paramc)
  {
    Date localDate = new Date();
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    try
    {
      paramThrowable = UUID.randomUUID().toString();
      Object localObject = a.a + "/" + paramThrowable + ".stacktrace";
      Log.d("HockeyApp", "Writing unhandled exception to: " + (String)localObject);
      localObject = new BufferedWriter(new FileWriter((String)localObject));
      ((BufferedWriter)localObject).write("Package: " + a.d + "\n");
      ((BufferedWriter)localObject).write("Version: " + a.b + "\n");
      if ((paramc == null) || (paramc.c()))
      {
        ((BufferedWriter)localObject).write("Android: " + a.e + "\n");
        ((BufferedWriter)localObject).write("Manufacturer: " + a.g + "\n");
        ((BufferedWriter)localObject).write("Model: " + a.f + "\n");
      }
      ((BufferedWriter)localObject).write("Date: " + localDate + "\n");
      ((BufferedWriter)localObject).write("\n");
      ((BufferedWriter)localObject).write(localStringWriter.toString());
      ((BufferedWriter)localObject).flush();
      ((BufferedWriter)localObject).close();
      if (paramc != null)
      {
        a(a(paramc.f()), paramThrowable + ".user");
        a(a(paramc.d()), paramThrowable + ".contact");
        a(paramc.e(), paramThrowable + ".description");
      }
      return;
    }
    catch (Exception paramThrowable)
    {
      Log.e("HockeyApp", "Error saving exception stacktrace!\n", paramThrowable);
    }
  }
  
  public void a(c paramc)
  {
    this.b = paramc;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (a.a == null)
    {
      this.c.uncaughtException(paramThread, paramThrowable);
      return;
    }
    a(paramThrowable, this.b);
    if (!this.a)
    {
      this.c.uncaughtException(paramThread, paramThrowable);
      return;
    }
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */