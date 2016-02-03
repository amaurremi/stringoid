package com.jirbo.adcolony;

import java.io.PrintStream;

class ADCJSON
{
  static ADCStringBuilder buffer = new ADCStringBuilder();
  
  static void discard_space(ADCParseReader paramADCParseReader)
  {
    for (int i = paramADCParseReader.peek(); (paramADCParseReader.has_another()) && ((i <= 32) || (i > 126)); i = paramADCParseReader.peek()) {
      paramADCParseReader.read();
    }
  }
  
  static int hex_character_to_value(int paramInt)
  {
    if ((paramInt >= 48) && (paramInt <= 57)) {
      return paramInt - 48;
    }
    if ((paramInt >= 97) && (paramInt <= 102)) {
      return paramInt - 97 + 10;
    }
    if ((paramInt >= 65) && (paramInt <= 70)) {
      return paramInt - 65 + 10;
    }
    return 0;
  }
  
  static ADCData.Value load(ADCDataFile paramADCDataFile)
  {
    paramADCDataFile = paramADCDataFile.create_reader();
    if (paramADCDataFile == null) {
      return null;
    }
    return parse_value(paramADCDataFile);
  }
  
  static ADCData.List load_List(ADCDataFile paramADCDataFile)
  {
    paramADCDataFile = load(paramADCDataFile);
    if ((paramADCDataFile == null) || (!paramADCDataFile.is_List())) {
      return null;
    }
    return paramADCDataFile.to_List();
  }
  
  static ADCData.Table load_Table(ADCDataFile paramADCDataFile)
  {
    paramADCDataFile = load(paramADCDataFile);
    if ((paramADCDataFile == null) || (!paramADCDataFile.is_Table())) {
      return null;
    }
    return paramADCDataFile.to_Table();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("==== ADCJSON Test ====");
    load_Table(new ADCDataFile("test.txt"));
    save(new ADCDataFile("test2.txt"), load(new ADCDataFile("test.txt")));
    save(new ADCDataFile("test3.txt"), load(new ADCDataFile("test2.txt")));
  }
  
  static ADCData.Value parse(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return parse_value(new ADCParseReader(paramString));
  }
  
  static ADCData.List parse_List(ADCParseReader paramADCParseReader)
  {
    discard_space(paramADCParseReader);
    Object localObject;
    if (!paramADCParseReader.consume('[')) {
      localObject = null;
    }
    do
    {
      ADCData.List localList;
      do
      {
        return (ADCData.List)localObject;
        discard_space(paramADCParseReader);
        localList = new ADCData.List();
        localObject = localList;
      } while (paramADCParseReader.consume(']'));
      int i = 1;
      while ((i != 0) || (paramADCParseReader.consume(',')))
      {
        i = 0;
        localList.add(parse_value(paramADCParseReader));
        discard_space(paramADCParseReader);
      }
      localObject = localList;
    } while (paramADCParseReader.consume(']'));
    return null;
  }
  
  static ADCData.List parse_List(String paramString)
  {
    paramString = parse(paramString);
    if ((paramString == null) || (!paramString.is_List())) {
      return null;
    }
    return paramString.to_List();
  }
  
  static ADCData.Value parse_Number(ADCParseReader paramADCParseReader)
  {
    discard_space(paramADCParseReader);
    double d3 = 1.0D;
    if (paramADCParseReader.consume('-'))
    {
      d3 = -1.0D;
      discard_space(paramADCParseReader);
    }
    double d1 = 0.0D;
    for (int i = paramADCParseReader.peek(); (paramADCParseReader.has_another()) && (i >= 48) && (i <= 57); i = paramADCParseReader.peek())
    {
      paramADCParseReader.read();
      d1 = 10.0D * d1 + (i - 48);
    }
    i = 0;
    double d2 = d1;
    int j;
    if (paramADCParseReader.consume('.'))
    {
      j = 1;
      double d4 = 0.0D;
      d2 = 0.0D;
      for (i = paramADCParseReader.peek(); (paramADCParseReader.has_another()) && (i >= 48) && (i <= 57); i = paramADCParseReader.peek())
      {
        paramADCParseReader.read();
        d4 = 10.0D * d4 + (i - 48);
        d2 += 1.0D;
      }
      d2 = d1 + d4 / Math.pow(10.0D, d2);
      i = j;
    }
    if (!paramADCParseReader.consume('e'))
    {
      d1 = d2;
      if (!paramADCParseReader.consume('E')) {}
    }
    else
    {
      int k = 0;
      j = k;
      if (!paramADCParseReader.consume('+'))
      {
        j = k;
        if (paramADCParseReader.consume('-')) {
          j = 1;
        }
      }
      d1 = 0.0D;
      for (k = paramADCParseReader.peek(); (paramADCParseReader.has_another()) && (k >= 48) && (k <= 57); k = paramADCParseReader.peek())
      {
        paramADCParseReader.read();
        d1 = 10.0D * d1 + (k - 48);
      }
      if (j == 0) {
        break label330;
      }
    }
    label330:
    for (d1 = d2 / Math.pow(10.0D, d1);; d1 = d2 * Math.pow(10.0D, d1))
    {
      d1 *= d3;
      if ((i == 0) && (d1 == (int)d1)) {
        break;
      }
      return new ADCData.RealValue(d1);
    }
    return new ADCData.IntegerValue((int)d1);
  }
  
  static String parse_String(ADCParseReader paramADCParseReader)
  {
    discard_space(paramADCParseReader);
    int i = 34;
    if (paramADCParseReader.consume('"')) {
      i = 34;
    }
    while (!paramADCParseReader.has_another())
    {
      return "";
      if (paramADCParseReader.consume('\'')) {
        i = 39;
      }
    }
    buffer.clear();
    char c = paramADCParseReader.read();
    if ((paramADCParseReader.has_another()) && (c != i))
    {
      if (c == '\\')
      {
        c = paramADCParseReader.read();
        if (c == 'b') {
          buffer.print('\b');
        }
      }
      for (;;)
      {
        c = paramADCParseReader.read();
        break;
        if (c == 'f')
        {
          buffer.print('\f');
        }
        else if (c == 'n')
        {
          buffer.print('\n');
        }
        else if (c == 'r')
        {
          buffer.print('\r');
        }
        else if (c == 't')
        {
          buffer.print('\t');
        }
        else if (c == 'u')
        {
          buffer.print(parse_hex_quad(paramADCParseReader));
        }
        else
        {
          buffer.print(c);
          continue;
          buffer.print(c);
        }
      }
    }
    return buffer.toString();
  }
  
  static ADCData.Table parse_Table(ADCParseReader paramADCParseReader)
  {
    discard_space(paramADCParseReader);
    Object localObject;
    if (!paramADCParseReader.consume('{')) {
      localObject = null;
    }
    do
    {
      ADCData.Table localTable;
      do
      {
        return (ADCData.Table)localObject;
        discard_space(paramADCParseReader);
        localTable = new ADCData.Table();
        localObject = localTable;
      } while (paramADCParseReader.consume('}'));
      int i = 1;
      if ((i != 0) || (paramADCParseReader.consume(',')))
      {
        i = 0;
        localObject = parse_identifier(paramADCParseReader);
        discard_space(paramADCParseReader);
        if (!paramADCParseReader.consume(':')) {
          localTable.set((String)localObject, true);
        }
        for (;;)
        {
          discard_space(paramADCParseReader);
          break;
          discard_space(paramADCParseReader);
          localTable.set((String)localObject, parse_value(paramADCParseReader));
        }
      }
      localObject = localTable;
    } while (paramADCParseReader.consume('}'));
    return null;
  }
  
  static ADCData.Table parse_Table(String paramString)
  {
    paramString = parse(paramString);
    if ((paramString == null) || (!paramString.is_Table())) {
      return null;
    }
    return paramString.to_Table();
  }
  
  static char parse_hex_quad(ADCParseReader paramADCParseReader)
  {
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      int k = j;
      if (paramADCParseReader.has_another()) {
        k = j << 4 | hex_character_to_value(paramADCParseReader.read());
      }
      i += 1;
      j = k;
    }
    return (char)j;
  }
  
  static String parse_identifier(ADCParseReader paramADCParseReader)
  {
    discard_space(paramADCParseReader);
    int j = paramADCParseReader.peek();
    if ((j == 34) || (j == 39)) {
      return parse_String(paramADCParseReader);
    }
    buffer.clear();
    int i = 0;
    while ((i == 0) && (paramADCParseReader.has_another())) {
      if (((j >= 97) && (j <= 122)) || ((j >= 65) && (j <= 90)) || (j == 95) || (j == 36))
      {
        paramADCParseReader.read();
        buffer.print((char)j);
        j = paramADCParseReader.peek();
      }
      else
      {
        i = 1;
      }
    }
    return buffer.toString();
  }
  
  static ADCData.Value parse_value(ADCParseReader paramADCParseReader)
  {
    discard_space(paramADCParseReader);
    int i = paramADCParseReader.peek();
    if (i == 123) {
      return parse_Table(paramADCParseReader);
    }
    if (i == 91) {
      return parse_List(paramADCParseReader);
    }
    if (i == 45) {
      return parse_Number(paramADCParseReader);
    }
    if ((i >= 48) && (i <= 57)) {
      return parse_Number(paramADCParseReader);
    }
    if ((i == 34) || (i == 39))
    {
      paramADCParseReader = parse_String(paramADCParseReader);
      if (paramADCParseReader.length() == 0) {
        return new ADCData.StringValue("");
      }
      i = paramADCParseReader.charAt(0);
      if ((i == 116) && (paramADCParseReader.equals("true"))) {
        return ADCData.true_value;
      }
      if ((i == 102) && (paramADCParseReader.equals("false"))) {
        return ADCData.false_value;
      }
      if ((i == 110) && (paramADCParseReader.equals("null"))) {
        return ADCData.null_value;
      }
      return new ADCData.StringValue(paramADCParseReader);
    }
    if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 95) || (i == 36))
    {
      paramADCParseReader = parse_identifier(paramADCParseReader);
      if (paramADCParseReader.length() == 0) {
        return new ADCData.StringValue("");
      }
      i = paramADCParseReader.charAt(0);
      if ((i == 116) && (paramADCParseReader.equals("true"))) {
        return ADCData.true_value;
      }
      if ((i == 102) && (paramADCParseReader.equals("false"))) {
        return ADCData.false_value;
      }
      if ((i == 110) && (paramADCParseReader.equals("null"))) {
        return ADCData.null_value;
      }
      return new ADCData.StringValue(paramADCParseReader);
    }
    return null;
  }
  
  static void save(ADCDataFile paramADCDataFile, ADCData.List paramList)
  {
    paramADCDataFile = paramADCDataFile.create_writer();
    if (paramList != null)
    {
      paramList.print_json(paramADCDataFile);
      paramADCDataFile.println();
    }
    for (;;)
    {
      paramADCDataFile.close();
      return;
      ADCLog.debug.println("Saving empty property list.");
      paramADCDataFile.println("[]");
    }
  }
  
  static void save(ADCDataFile paramADCDataFile, ADCData.Table paramTable)
  {
    paramADCDataFile = paramADCDataFile.create_writer();
    if (paramTable != null)
    {
      paramTable.print_json(paramADCDataFile);
      paramADCDataFile.println();
    }
    for (;;)
    {
      paramADCDataFile.close();
      return;
      ADCLog.debug.println("Saving empty property table.");
      paramADCDataFile.println("{}");
    }
  }
  
  static void save(ADCDataFile paramADCDataFile, ADCData.Value paramValue)
  {
    paramADCDataFile = paramADCDataFile.create_writer();
    if (paramValue == null) {
      paramADCDataFile.println("null");
    }
    for (;;)
    {
      paramADCDataFile.close();
      return;
      paramValue.print_json(paramADCDataFile);
      paramADCDataFile.println();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCJSON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */