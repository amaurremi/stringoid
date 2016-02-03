package org.codehaus.jackson.format;

public abstract interface InputAccessor
{
  public abstract boolean hasMoreBytes();
  
  public abstract byte nextByte();
  
  public abstract void reset();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/format/InputAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */