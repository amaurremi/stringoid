package com.vladium.emma;

import com.vladium.emma.data.mergeCommand;
import com.vladium.emma.instr.instrCommand;
import com.vladium.emma.report.reportCommand;
import com.vladium.util.IConstants;
import com.vladium.util.Property;
import com.vladium.util.Strings;
import com.vladium.util.XProperties;
import com.vladium.util.args.IOptsParser;
import com.vladium.util.args.IOptsParser.Factory;
import com.vladium.util.args.IOptsParser.IOpt;
import com.vladium.util.args.IOptsParser.IOpts;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public abstract class Command
{
  protected static final String COMMA_DELIMITERS = ", \t\r\n";
  protected static final String PATH_DELIMITERS = ",".concat(File.pathSeparator);
  protected static final int RC_OK = 0;
  protected static final int RC_UNEXPECTED = 2;
  protected static final int RC_USAGE = 1;
  protected static final int STDOUT_WIDTH = 80;
  protected static final String[] USAGE_OPT_NAMES = { "h", "help" };
  protected final String[] m_args;
  protected boolean m_exit;
  protected PrintWriter m_out;
  protected File m_propertyFile;
  protected Properties m_propertyOverrides;
  protected final String m_usageToolName;
  
  protected Command(String paramString, String[] paramArrayOfString)
  {
    this.m_usageToolName = paramString;
    if (paramArrayOfString != null) {}
    for (paramString = (String[])paramArrayOfString.clone();; paramString = IConstants.EMPTY_STRING_ARRAY)
    {
      this.m_args = paramString;
      return;
    }
  }
  
  public static Command create(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ("run".equals(paramString1)) {
      paramString1 = new runCommand(paramString2, paramArrayOfString);
    }
    for (;;)
    {
      paramString1.initialize();
      return paramString1;
      if ("instr".equals(paramString1))
      {
        paramString1 = new instrCommand(paramString2, paramArrayOfString);
      }
      else if ("report".equals(paramString1))
      {
        paramString1 = new reportCommand(paramString2, paramArrayOfString);
      }
      else
      {
        if (!"merge".equals(paramString1)) {
          break;
        }
        paramString1 = new mergeCommand(paramString2, paramArrayOfString);
      }
    }
    throw new IllegalArgumentException("unknown command: [" + paramString1 + "]");
  }
  
  protected static String[] getListOptValue(IOptsParser.IOpt paramIOpt, String paramString, boolean paramBoolean)
    throws IOException
  {
    return Strings.mergeAT(paramIOpt.getValues(), paramString, paramBoolean);
  }
  
  protected static boolean getOptionalBooleanOptValue(IOptsParser.IOpt paramIOpt)
  {
    if (paramIOpt.getValueCount() == 0) {
      return true;
    }
    return Property.toBoolean(paramIOpt.getFirstValue().toLowerCase());
  }
  
  private void setPropertyOverride(String paramString1, String paramString2)
  {
    Properties localProperties = this.m_propertyOverrides;
    Object localObject = localProperties;
    if (localProperties == null)
    {
      localObject = new XProperties();
      this.m_propertyOverrides = ((Properties)localObject);
    }
    ((Properties)localObject).setProperty(paramString1, paramString2);
  }
  
  protected static String toolNameToCommandName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  protected static String usageMsgPrefix(String paramString)
  {
    return toolNameToCommandName(paramString).concat(" usage: ");
  }
  
  protected static String usageResName(String paramString)
  {
    return paramString.replace('.', '/').concat("_usage.res");
  }
  
  protected final void exit(boolean paramBoolean, String paramString, Throwable paramThrowable, int paramInt)
    throws EMMARuntimeException
  {
    if (paramBoolean) {
      this.m_out.println("[EMMA v0.0, build 0 (unsupported private build)]");
    }
    if (paramString != null)
    {
      this.m_out.print(toolNameToCommandName(this.m_usageToolName) + ": ");
      this.m_out.println(paramString);
    }
    if (paramInt != 0) {
      if (this.m_exit)
      {
        if (paramThrowable != null) {
          paramThrowable.printStackTrace(this.m_out);
        }
        System.exit(paramInt);
      }
    }
    while (!this.m_exit)
    {
      do
      {
        return;
        if ((paramThrowable instanceof EMMARuntimeException)) {
          throw ((EMMARuntimeException)paramThrowable);
        }
      } while (paramThrowable == null);
      if (paramString != null) {}
      for (paramString = new EMMARuntimeException(paramString, paramThrowable);; paramString = new EMMARuntimeException("unexpected failure: ", paramThrowable)) {
        throw paramString;
      }
    }
    System.exit(0);
  }
  
  protected final IOptsParser getOptParser(ClassLoader paramClassLoader)
  {
    return IOptsParser.Factory.create(usageResName(getToolName()), paramClassLoader, usageMsgPrefix(this.m_usageToolName), USAGE_OPT_NAMES);
  }
  
  protected final String getToolName()
  {
    String str = getClass().getName();
    return str.substring(0, str.length() - 7);
  }
  
  protected void initialize()
  {
    this.m_exit = false;
    if (this.m_out != null) {}
    try
    {
      this.m_out.flush();
      this.m_out = new PrintWriter(System.out, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  protected final void processCmdPropertyOverrides(IOptsParser.IOpts paramIOpts)
  {
    paramIOpts = paramIOpts.getOpts("D");
    if ((paramIOpts != null) && (paramIOpts.length != 0))
    {
      XProperties localXProperties = new XProperties();
      int i = 0;
      while (i < paramIOpts.length)
      {
        Object localObject = paramIOpts[i];
        localXProperties.setProperty(((IOptsParser.IOpt)localObject).getName().substring(((IOptsParser.IOpt)localObject).getPatternPrefix().length()), ((IOptsParser.IOpt)localObject).getFirstValue());
        i += 1;
      }
      this.m_propertyOverrides = Property.combine(localXProperties, this.m_propertyOverrides);
    }
  }
  
  protected final boolean processFilePropertyOverrides()
  {
    if (this.m_propertyFile != null) {}
    try
    {
      Properties localProperties = Property.getPropertiesFromFile(this.m_propertyFile);
      this.m_propertyOverrides = Property.combine(this.m_propertyOverrides, localProperties);
      return true;
    }
    catch (IOException localIOException)
    {
      exit(true, "property override file [" + this.m_propertyFile.getAbsolutePath() + "] could not be read", localIOException, 1);
    }
    return false;
  }
  
  protected final boolean processOpt(IOptsParser.IOpt paramIOpt)
  {
    String str = paramIOpt.getCanonicalName();
    if ("exit".equals(str))
    {
      this.m_exit = getOptionalBooleanOptValue(paramIOpt);
      return true;
    }
    if ("p".equals(str))
    {
      this.m_propertyFile = new File(paramIOpt.getFirstValue());
      return true;
    }
    if ("verbose".equals(str))
    {
      setPropertyOverride("verbosity.level", "verbose");
      return true;
    }
    if ("quiet".equals(str))
    {
      setPropertyOverride("verbosity.level", "warning");
      return true;
    }
    if ("silent".equals(str))
    {
      setPropertyOverride("verbosity.level", "severe");
      return true;
    }
    if ("debug".equals(str))
    {
      if (paramIOpt.getValueCount() == 0)
      {
        setPropertyOverride("verbosity.level", "trace1");
        return true;
      }
      setPropertyOverride("verbosity.level", paramIOpt.getFirstValue());
      return true;
    }
    if ("debugcls".equals(str))
    {
      setPropertyOverride("verbosity.filter", Strings.toListForm(Strings.merge(paramIOpt.getValues(), ", \t\r\n", true), ','));
      return true;
    }
    return false;
  }
  
  public abstract void run();
  
  protected abstract String usageArgsMsg();
  
  protected final void usageexit(IOptsParser paramIOptsParser, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      this.m_out.print(usageMsgPrefix(this.m_usageToolName));
      this.m_out.println(paramString);
    }
    if (paramIOptsParser != null)
    {
      this.m_out.println();
      this.m_out.print(usageMsgPrefix(this.m_usageToolName));
      this.m_out.println(toolNameToCommandName(this.m_usageToolName) + " " + usageArgsMsg() + ",");
      this.m_out.println("  where options include:");
      this.m_out.println();
      paramIOptsParser.usage(this.m_out, paramInt, 80);
    }
    this.m_out.println();
    exit(true, null, null, 1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */