package twitter4j.conf;

class PropertyConfigurationFactory
  implements ConfigurationFactory
{
  private static final PropertyConfiguration ROOT_CONFIGURATION = new PropertyConfiguration();
  
  public void dispose() {}
  
  public Configuration getInstance()
  {
    return ROOT_CONFIGURATION;
  }
  
  public Configuration getInstance(String paramString)
  {
    paramString = new PropertyConfiguration(paramString);
    paramString.dumpConfiguration();
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/conf/PropertyConfigurationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */