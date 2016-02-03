package com.jirbo.adcolony;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ADCData
{
  static Value false_value = new FalseValue();
  static Value null_value = new NullValue();
  static Value true_value = new TrueValue();
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("==== ADCData Test ====");
    paramArrayOfString = new Table();
    paramArrayOfString.set("one", 1);
    paramArrayOfString.set("pi", 3.14D);
    paramArrayOfString.set("name", "\"Abe Pralle\"");
    paramArrayOfString.set("list", new List());
    paramArrayOfString.set("subtable", new Table());
    paramArrayOfString.get_Table("subtable").set("five", 5);
    System.out.println("LIST:" + paramArrayOfString.get_List("list"));
    paramArrayOfString.get_List("list").add(3);
    System.out.println(paramArrayOfString);
    System.out.println(paramArrayOfString.get_Integer("one"));
    System.out.println(paramArrayOfString.get_Real("one"));
    System.out.println(paramArrayOfString.get_Integer("pi"));
    System.out.println(paramArrayOfString.get_Real("pi"));
    System.out.println(paramArrayOfString.get_String("name"));
    System.out.println(paramArrayOfString.get_Real("name"));
    System.out.println(paramArrayOfString.get_Integer("name"));
    System.out.println(paramArrayOfString.get_List("list"));
    System.out.println(paramArrayOfString.get_List("list2"));
    System.out.println(paramArrayOfString.get_List("subtable"));
    System.out.println(paramArrayOfString.get_Table("subtable"));
    System.out.println(paramArrayOfString.get_Table("subtable2"));
    System.out.println(paramArrayOfString.get_Table("list"));
  }
  
  static class FalseValue
    extends ADCData.Value
  {
    boolean is_Logical()
    {
      return true;
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      paramADCWriter.print("false");
    }
    
    String to_String()
    {
      return "false";
    }
  }
  
  static class IntegerValue
    extends ADCData.Value
  {
    int value;
    
    IntegerValue(int paramInt)
    {
      this.value = paramInt;
    }
    
    boolean is_Integer()
    {
      return true;
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      paramADCWriter.print(this.value);
    }
    
    int to_Integer()
    {
      return this.value;
    }
    
    double to_Real()
    {
      return this.value;
    }
  }
  
  static class List
    extends ADCData.Value
  {
    ArrayList<ADCData.Value> data = new ArrayList();
    
    List add(double paramDouble)
    {
      add(new ADCData.RealValue(paramDouble));
      return this;
    }
    
    List add(int paramInt)
    {
      add(new ADCData.IntegerValue(paramInt));
      return this;
    }
    
    List add(ADCData.Value paramValue)
    {
      this.data.add(paramValue);
      return this;
    }
    
    List add(String paramString)
    {
      add(new ADCData.StringValue(paramString));
      return this;
    }
    
    List add(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (ADCData.Value localValue = ADCData.true_value;; localValue = ADCData.false_value)
      {
        add(localValue);
        return this;
      }
    }
    
    List add_all(List paramList)
    {
      int i = 0;
      while (i < paramList.count())
      {
        add((ADCData.Value)paramList.data.get(i));
        i += 1;
      }
      return this;
    }
    
    void clear()
    {
      this.data.clear();
    }
    
    int count()
    {
      return this.data.size();
    }
    
    int get_Integer(int paramInt)
    {
      return get_Integer(paramInt, 0);
    }
    
    int get_Integer(int paramInt1, int paramInt2)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramInt1);
      paramInt1 = paramInt2;
      if (localValue != null)
      {
        paramInt1 = paramInt2;
        if (localValue.is_Number()) {
          paramInt1 = localValue.to_Integer();
        }
      }
      return paramInt1;
    }
    
    List get_List(int paramInt)
    {
      List localList = get_List(paramInt, null);
      if (localList != null) {
        return localList;
      }
      return new List();
    }
    
    List get_List(int paramInt, List paramList)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramInt);
      List localList = paramList;
      if (localValue != null)
      {
        localList = paramList;
        if (localValue.is_List()) {
          localList = localValue.to_List();
        }
      }
      return localList;
    }
    
    boolean get_Logical(int paramInt)
    {
      return get_Logical(paramInt, false);
    }
    
    boolean get_Logical(int paramInt, boolean paramBoolean)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramInt);
      boolean bool = paramBoolean;
      if (localValue != null) {
        if (!localValue.is_Logical())
        {
          bool = paramBoolean;
          if (!localValue.is_String()) {}
        }
        else
        {
          bool = localValue.to_Logical();
        }
      }
      return bool;
    }
    
    double get_Real(int paramInt)
    {
      return get_Real(paramInt, 0.0D);
    }
    
    double get_Real(int paramInt, double paramDouble)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramInt);
      double d = paramDouble;
      if (localValue != null)
      {
        d = paramDouble;
        if (localValue.is_Number()) {
          d = localValue.to_Real();
        }
      }
      return d;
    }
    
    String get_String(int paramInt)
    {
      return get_String(paramInt, "");
    }
    
    String get_String(int paramInt, String paramString)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramInt);
      String str = paramString;
      if (localValue != null)
      {
        str = paramString;
        if (localValue.is_String()) {
          str = localValue.to_String();
        }
      }
      return str;
    }
    
    ADCData.Table get_Table(int paramInt)
    {
      ADCData.Table localTable = get_Table(paramInt, null);
      if (localTable != null) {
        return localTable;
      }
      return new ADCData.Table();
    }
    
    ADCData.Table get_Table(int paramInt, ADCData.Table paramTable)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramInt);
      ADCData.Table localTable = paramTable;
      if (localValue != null)
      {
        localTable = paramTable;
        if (localValue.is_Table()) {
          localTable = localValue.to_Table();
        }
      }
      return localTable;
    }
    
    boolean is_List()
    {
      return true;
    }
    
    boolean is_compact()
    {
      return (this.data.size() == 0) || ((this.data.size() == 1) && (((ADCData.Value)this.data.get(0)).is_compact()));
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      int k = this.data.size();
      if (k == 0)
      {
        paramADCWriter.print("[]");
        return;
      }
      if ((k == 1) && (((ADCData.Value)this.data.get(0)).is_compact()))
      {
        paramADCWriter.print("[");
        ((ADCData.Value)this.data.get(0)).print_json(paramADCWriter);
        paramADCWriter.print("]");
        return;
      }
      paramADCWriter.println("[");
      paramADCWriter.indent += 2;
      int j = 1;
      int i = 0;
      if (i < k)
      {
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          ((ADCData.Value)this.data.get(i)).print_json(paramADCWriter);
          i += 1;
          break;
          paramADCWriter.println(',');
        }
      }
      paramADCWriter.println();
      paramADCWriter.indent -= 2;
      paramADCWriter.print("]");
    }
    
    ADCData.Value remove_last()
    {
      return (ADCData.Value)this.data.remove(this.data.size() - 1);
    }
    
    List to_List()
    {
      return this;
    }
  }
  
  static class NullValue
    extends ADCData.Value
  {
    boolean is_null()
    {
      return true;
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      paramADCWriter.print("null");
    }
    
    String to_String()
    {
      return "null";
    }
  }
  
  static class RealValue
    extends ADCData.Value
  {
    double value;
    
    RealValue(double paramDouble)
    {
      this.value = paramDouble;
    }
    
    boolean is_Real()
    {
      return true;
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      paramADCWriter.print(this.value);
    }
    
    int to_Integer()
    {
      return (int)this.value;
    }
    
    double to_Real()
    {
      return this.value;
    }
  }
  
  static class StringValue
    extends ADCData.Value
  {
    String value;
    
    StringValue(String paramString)
    {
      this.value = paramString;
    }
    
    boolean is_String()
    {
      return true;
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      print_json(paramADCWriter, this.value);
    }
    
    int to_Integer()
    {
      return (int)to_Real();
    }
    
    boolean to_Logical()
    {
      String str = this.value.toLowerCase();
      return (str.equals("true")) || (str.equals("yes"));
    }
    
    double to_Real()
    {
      try
      {
        double d = Double.parseDouble(this.value);
        return d;
      }
      catch (NumberFormatException localNumberFormatException) {}
      return 0.0D;
    }
    
    String to_String()
    {
      return this.value;
    }
  }
  
  static class Table
    extends ADCData.Value
  {
    HashMap<String, ADCData.Value> data = new HashMap();
    ArrayList<String> keys = new ArrayList();
    
    boolean contains(String paramString)
    {
      return this.data.containsKey(paramString);
    }
    
    int count()
    {
      return this.keys.size();
    }
    
    int get_Integer(String paramString)
    {
      return get_Integer(paramString, 0);
    }
    
    int get_Integer(String paramString, int paramInt)
    {
      paramString = (ADCData.Value)this.data.get(paramString);
      int i = paramInt;
      if (paramString != null)
      {
        i = paramInt;
        if (paramString.is_Number()) {
          i = paramString.to_Integer();
        }
      }
      return i;
    }
    
    ADCData.List get_List(String paramString)
    {
      paramString = get_List(paramString, null);
      if (paramString != null) {
        return paramString;
      }
      return new ADCData.List();
    }
    
    ADCData.List get_List(String paramString, ADCData.List paramList)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramString);
      paramString = paramList;
      if (localValue != null)
      {
        paramString = paramList;
        if (localValue.is_List()) {
          paramString = localValue.to_List();
        }
      }
      return paramString;
    }
    
    boolean get_Logical(String paramString)
    {
      return get_Logical(paramString, false);
    }
    
    boolean get_Logical(String paramString, boolean paramBoolean)
    {
      paramString = (ADCData.Value)this.data.get(paramString);
      boolean bool = paramBoolean;
      if (paramString != null) {
        if (!paramString.is_Logical())
        {
          bool = paramBoolean;
          if (!paramString.is_String()) {}
        }
        else
        {
          bool = paramString.to_Logical();
        }
      }
      return bool;
    }
    
    double get_Real(String paramString)
    {
      return get_Real(paramString, 0.0D);
    }
    
    double get_Real(String paramString, double paramDouble)
    {
      paramString = (ADCData.Value)this.data.get(paramString);
      double d = paramDouble;
      if (paramString != null)
      {
        d = paramDouble;
        if (paramString.is_Number()) {
          d = paramString.to_Real();
        }
      }
      return d;
    }
    
    String get_String(String paramString)
    {
      return get_String(paramString, "");
    }
    
    String get_String(String paramString1, String paramString2)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramString1);
      paramString1 = paramString2;
      if (localValue != null)
      {
        paramString1 = paramString2;
        if (localValue.is_String()) {
          paramString1 = localValue.to_String();
        }
      }
      return paramString1;
    }
    
    ArrayList<String> get_StringList(String paramString)
    {
      ArrayList localArrayList = get_StringList(paramString, null);
      paramString = localArrayList;
      if (localArrayList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
    
    ArrayList<String> get_StringList(String paramString, ArrayList<String> paramArrayList)
    {
      paramString = get_List(paramString);
      if (paramString == null) {
        return paramArrayList;
      }
      paramArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.count())
      {
        String str = paramString.get_String(i);
        if (str != null) {
          paramArrayList.add(str);
        }
        i += 1;
      }
      return paramArrayList;
    }
    
    Table get_Table(String paramString)
    {
      paramString = get_Table(paramString, null);
      if (paramString != null) {
        return paramString;
      }
      return new Table();
    }
    
    Table get_Table(String paramString, Table paramTable)
    {
      ADCData.Value localValue = (ADCData.Value)this.data.get(paramString);
      paramString = paramTable;
      if (localValue != null)
      {
        paramString = paramTable;
        if (localValue.is_Table()) {
          paramString = localValue.to_Table();
        }
      }
      return paramString;
    }
    
    boolean is_Table()
    {
      return true;
    }
    
    boolean is_compact()
    {
      return (this.data.size() < 0) || ((this.data.size() == 1) && (((ADCData.Value)this.data.get(this.keys.get(0))).is_compact()));
    }
    
    String key_at(int paramInt)
    {
      return (String)this.keys.get(paramInt);
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      int k = this.keys.size();
      if (k == 0)
      {
        paramADCWriter.print("{}");
        return;
      }
      String str;
      ADCData.Value localValue;
      if ((k == 1) && (((ADCData.Value)this.data.get(this.keys.get(0))).is_compact()))
      {
        paramADCWriter.print("{");
        str = (String)this.keys.get(0);
        localValue = (ADCData.Value)this.data.get(str);
        print_json(paramADCWriter, str);
        paramADCWriter.print(':');
        localValue.print_json(paramADCWriter);
        paramADCWriter.print("}");
        return;
      }
      paramADCWriter.println("{");
      paramADCWriter.indent += 2;
      int j = 1;
      int i = 0;
      if (i < k)
      {
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          str = (String)this.keys.get(i);
          localValue = (ADCData.Value)this.data.get(str);
          print_json(paramADCWriter, str);
          paramADCWriter.print(':');
          if (!localValue.is_compact()) {
            paramADCWriter.println();
          }
          localValue.print_json(paramADCWriter);
          i += 1;
          break;
          paramADCWriter.println(',');
        }
      }
      paramADCWriter.println();
      paramADCWriter.indent -= 2;
      paramADCWriter.print("}");
    }
    
    void set(String paramString, double paramDouble)
    {
      set(paramString, new ADCData.RealValue(paramDouble));
    }
    
    void set(String paramString, int paramInt)
    {
      set(paramString, new ADCData.IntegerValue(paramInt));
    }
    
    void set(String paramString, ADCData.Value paramValue)
    {
      if (!this.data.containsKey(paramString)) {
        this.keys.add(paramString);
      }
      this.data.put(paramString, paramValue);
    }
    
    void set(String paramString1, String paramString2)
    {
      set(paramString1, new ADCData.StringValue(paramString2));
    }
    
    void set(String paramString, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (ADCData.Value localValue = ADCData.true_value;; localValue = ADCData.false_value)
      {
        set(paramString, localValue);
        return;
      }
    }
    
    Table to_Table()
    {
      return this;
    }
  }
  
  static class TrueValue
    extends ADCData.Value
  {
    boolean is_Logical()
    {
      return true;
    }
    
    void print_json(ADCWriter paramADCWriter)
    {
      paramADCWriter.print("true");
    }
    
    int to_Integer()
    {
      return 1;
    }
    
    boolean to_Logical()
    {
      return true;
    }
    
    double to_Real()
    {
      return 1.0D;
    }
    
    String to_String()
    {
      return "true";
    }
  }
  
  static class Value
  {
    boolean is_Integer()
    {
      return false;
    }
    
    boolean is_List()
    {
      return false;
    }
    
    boolean is_Logical()
    {
      return false;
    }
    
    boolean is_Number()
    {
      return (is_Real()) || (is_Integer());
    }
    
    boolean is_Real()
    {
      return false;
    }
    
    boolean is_String()
    {
      return false;
    }
    
    boolean is_Table()
    {
      return false;
    }
    
    boolean is_compact()
    {
      return true;
    }
    
    boolean is_null()
    {
      return false;
    }
    
    void print_json(ADCWriter paramADCWriter) {}
    
    void print_json(ADCWriter paramADCWriter, String paramString)
    {
      paramADCWriter.print('"');
      int m = paramString.length();
      int i = 0;
      if (i < m)
      {
        char c1 = paramString.charAt(i);
        switch (c1)
        {
        default: 
          if ((c1 >= ' ') && (c1 <= '~')) {
            paramADCWriter.print(c1);
          }
          break;
        case '"': 
        case '\\': 
        case '/': 
        case '\b': 
        case '\f': 
        case '\n': 
        case '\r': 
        case '\t': 
          for (;;)
          {
            i += 1;
            break;
            paramADCWriter.print("\\\"");
            continue;
            paramADCWriter.print("\\\\");
            continue;
            paramADCWriter.print("\\/");
            continue;
            paramADCWriter.print("\\b");
            continue;
            paramADCWriter.print("\\f");
            continue;
            paramADCWriter.print("\\n");
            continue;
            paramADCWriter.print("\\r");
            continue;
            paramADCWriter.print("\\t");
          }
        }
        paramADCWriter.print("\\u");
        char c2 = c1;
        int j = 0;
        label214:
        int n;
        if (j < 4)
        {
          n = c2 >> '\f' & 0xF;
          int k;
          c2 <<= '\004';
          if (n > 9) {
            break label259;
          }
          paramADCWriter.print(n);
        }
        for (;;)
        {
          j += 1;
          break label214;
          break;
          label259:
          paramADCWriter.print((char)(n - 10 + 97));
        }
      }
      paramADCWriter.print('"');
    }
    
    public String toString()
    {
      return to_json();
    }
    
    int to_Integer()
    {
      return 0;
    }
    
    ADCData.List to_List()
    {
      return null;
    }
    
    boolean to_Logical()
    {
      return false;
    }
    
    double to_Real()
    {
      return 0.0D;
    }
    
    String to_String()
    {
      return to_json();
    }
    
    ADCData.Table to_Table()
    {
      return null;
    }
    
    String to_json()
    {
      ADCStringBuilder localADCStringBuilder = new ADCStringBuilder();
      print_json(localADCStringBuilder);
      return localADCStringBuilder.toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */