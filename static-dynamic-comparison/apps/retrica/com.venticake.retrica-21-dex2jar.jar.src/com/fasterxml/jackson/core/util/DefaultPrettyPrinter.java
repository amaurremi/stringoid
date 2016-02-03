package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.Serializable;

public class DefaultPrettyPrinter
  implements PrettyPrinter, Serializable
{
  public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
  protected DefaultPrettyPrinter.Indenter _arrayIndenter = DefaultPrettyPrinter.FixedSpaceIndenter.instance;
  protected transient int _nesting = 0;
  protected DefaultPrettyPrinter.Indenter _objectIndenter = DefaultPrettyPrinter.Lf2SpacesIndenter.instance;
  protected final SerializableString _rootSeparator;
  protected boolean _spacesInObjectEntries = true;
  
  public DefaultPrettyPrinter()
  {
    this(DEFAULT_ROOT_VALUE_SEPARATOR);
  }
  
  public DefaultPrettyPrinter(SerializableString paramSerializableString)
  {
    this._rootSeparator = paramSerializableString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/util/DefaultPrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */