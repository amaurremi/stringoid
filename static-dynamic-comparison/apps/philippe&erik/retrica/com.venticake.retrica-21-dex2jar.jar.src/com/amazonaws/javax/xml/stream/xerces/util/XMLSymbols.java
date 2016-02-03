package com.amazonaws.javax.xml.stream.xerces.util;

public class XMLSymbols
{
  public static final String EMPTY_STRING = "".intern();
  public static final String PREFIX_XML = "xml".intern();
  public static final String PREFIX_XMLNS = "xmlns".intern();
  public static final String fANYSymbol = "ANY".intern();
  public static final String fCDATASymbol = "CDATA".intern();
  public static final String fENTITIESSymbol;
  public static final String fENTITYSymbol;
  public static final String fENUMERATIONSymbol;
  public static final String fFIXEDSymbol = "#FIXED".intern();
  public static final String fIDREFSSymbol;
  public static final String fIDREFSymbol;
  public static final String fIDSymbol = "ID".intern();
  public static final String fIMPLIEDSymbol;
  public static final String fNMTOKENSSymbol;
  public static final String fNMTOKENSymbol;
  public static final String fNOTATIONSymbol;
  public static final String fREQUIREDSymbol;
  
  static
  {
    fIDREFSymbol = "IDREF".intern();
    fIDREFSSymbol = "IDREFS".intern();
    fENTITYSymbol = "ENTITY".intern();
    fENTITIESSymbol = "ENTITIES".intern();
    fNMTOKENSymbol = "NMTOKEN".intern();
    fNMTOKENSSymbol = "NMTOKENS".intern();
    fNOTATIONSymbol = "NOTATION".intern();
    fENUMERATIONSymbol = "ENUMERATION".intern();
    fIMPLIEDSymbol = "#IMPLIED".intern();
    fREQUIREDSymbol = "#REQUIRED".intern();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/XMLSymbols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */