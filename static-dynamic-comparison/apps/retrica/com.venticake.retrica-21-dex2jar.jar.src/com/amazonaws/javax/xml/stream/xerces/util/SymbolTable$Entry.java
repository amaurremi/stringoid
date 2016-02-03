package com.amazonaws.javax.xml.stream.xerces.util;

public final class SymbolTable$Entry
{
  public char[] characters;
  int hashCode = 0;
  public Entry next;
  public String symbol;
  
  public SymbolTable$Entry(String paramString, Entry paramEntry)
  {
    this.symbol = paramString.intern();
    this.characters = new char[paramString.length()];
    paramString.getChars(0, this.characters.length, this.characters, 0);
    this.next = paramEntry;
  }
  
  public SymbolTable$Entry(char[] paramArrayOfChar, int paramInt1, int paramInt2, Entry paramEntry)
  {
    this.characters = new char[paramInt2];
    System.arraycopy(paramArrayOfChar, paramInt1, this.characters, 0, paramInt2);
    this.symbol = new String(this.characters).intern();
    this.next = paramEntry;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/SymbolTable$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */