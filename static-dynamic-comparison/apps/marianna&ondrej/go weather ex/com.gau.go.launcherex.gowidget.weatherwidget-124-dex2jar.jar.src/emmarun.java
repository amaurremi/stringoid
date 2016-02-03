import com.vladium.emma.Command;
import com.vladium.emma.EMMARuntimeException;

public final class emmarun
{
  public static void main(String[] paramArrayOfString)
    throws EMMARuntimeException
  {
    Command.create("run", emmarun.class.getName(), paramArrayOfString).run();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/emmarun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */