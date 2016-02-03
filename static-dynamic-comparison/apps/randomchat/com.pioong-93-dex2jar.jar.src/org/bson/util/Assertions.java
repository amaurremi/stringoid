package org.bson.util;

public class Assertions
{
  public static void isTrue(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static <T> T notNull(String paramString, T paramT)
    throws IllegalArgumentException
  {
    if (paramT == null) {
      throw new NullArgumentException(paramString);
    }
    return paramT;
  }
  
  static class NullArgumentException
    extends IllegalArgumentException
  {
    private static final long serialVersionUID = 6178592463723624585L;
    
    NullArgumentException(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/Assertions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */