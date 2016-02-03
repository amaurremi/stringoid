import com.vladium.emma.Command;
import com.vladium.emma.EMMARuntimeException;
import java.io.PrintStream;

public final class emma
{
  private static final String EOL = System.getProperty("line.separator", "\n");
  private static final String USAGE = "emma usage: emma <command> [command options]," + EOL + "  where <command> is one of:" + EOL + EOL + "   run     application runner {same as 'emmarun' tool};" + EOL + "   instr   offline instrumentation processor;" + EOL + "   report  offline report generator;" + EOL + "   merge   offline data file merge processor." + EOL + EOL + "  {use '<command> -h' to see usage help for a given command}" + EOL + EOL + "[EMMA v0.0, build 0 (unsupported private build)]";
  
  public static void main(String[] paramArrayOfString)
    throws EMMARuntimeException
  {
    if ((paramArrayOfString.length == 0) || (paramArrayOfString[0].startsWith("-h")))
    {
      System.out.println(USAGE);
      return;
    }
    String str = paramArrayOfString[0];
    String[] arrayOfString = new String[paramArrayOfString.length - 1];
    System.arraycopy(paramArrayOfString, 1, arrayOfString, 0, arrayOfString.length);
    Command.create(str, "emma ".concat(str), arrayOfString).run();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/emma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */