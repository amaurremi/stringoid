package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.PrettyPrinter;
import java.io.Serializable;

public class MinimalPrettyPrinter
  implements PrettyPrinter, Serializable
{
  protected String _rootValueSeparator = " ";
  
  public MinimalPrettyPrinter()
  {
    this(" ");
  }
  
  public MinimalPrettyPrinter(String paramString)
  {
    this._rootValueSeparator = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/util/MinimalPrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */