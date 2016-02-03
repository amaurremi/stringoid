package org.codehaus.jackson.map;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;

public abstract class Module
  implements Versioned
{
  public abstract String getModuleName();
  
  public abstract void setupModule(Module.SetupContext paramSetupContext);
  
  public abstract Version version();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */