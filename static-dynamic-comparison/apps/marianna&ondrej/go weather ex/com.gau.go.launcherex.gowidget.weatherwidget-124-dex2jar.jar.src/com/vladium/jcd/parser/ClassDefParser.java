package com.vladium.jcd.parser;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.cls.Field_info;
import com.vladium.jcd.cls.IAttributeCollection;
import com.vladium.jcd.cls.IConstantCollection;
import com.vladium.jcd.cls.IFieldCollection;
import com.vladium.jcd.cls.IInterfaceCollection;
import com.vladium.jcd.cls.IMethodCollection;
import com.vladium.jcd.cls.Method_info;
import com.vladium.jcd.cls.attribute.Attribute_info;
import com.vladium.jcd.cls.attribute.ConstantValueAttribute_info;
import com.vladium.jcd.cls.constant.CONSTANT_Double_info;
import com.vladium.jcd.cls.constant.CONSTANT_Long_info;
import com.vladium.jcd.cls.constant.CONSTANT_info;
import com.vladium.jcd.lib.UDataInputStream;
import com.vladium.util.ByteArrayIStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ClassDefParser
{
  static final boolean PARSE_SERIAL_VERSION_UID = true;
  static final int SERIAL_VERSION_UID_FIELD_MASK = 24;
  static final String SERIAL_VERSION_UID_FIELD_NAME = "serialVersionUID";
  
  public static ClassDef parseClass(InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("null input: bytes");
    }
    return new classParser(new UDataInputStream(paramInputStream)).class_table();
  }
  
  public static ClassDef parseClass(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("null input: bytes");
    }
    return new classParser(new UDataInputStream(new ByteArrayIStream(paramArrayOfByte))).class_table();
  }
  
  public static ClassDef parseClass(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("null input: bytes");
    }
    return new classParser(new UDataInputStream(new ByteArrayIStream(paramArrayOfByte, paramInt))).class_table();
  }
  
  private static final class classParser
  {
    private static final boolean DEBUG = false;
    private static final String s_line = "------------------------------------------------------------------------";
    private final UDataInputStream m_bytes;
    private ClassDef m_table;
    
    classParser(UDataInputStream paramUDataInputStream)
    {
      this.m_bytes = paramUDataInputStream;
    }
    
    void access_flags()
      throws IOException
    {
      int i = this.m_bytes.readU2();
      this.m_table.setAccessFlags(i);
    }
    
    void attributes()
      throws IOException
    {
      int j = this.m_bytes.readU2();
      IConstantCollection localIConstantCollection = this.m_table.getConstants();
      int i = 0;
      while (i < j)
      {
        Attribute_info localAttribute_info = Attribute_info.new_Attribute_info(localIConstantCollection, this.m_bytes);
        this.m_table.getAttributes().add(localAttribute_info);
        i += 1;
      }
    }
    
    ClassDef class_table()
      throws IOException
    {
      this.m_table = new ClassDef();
      magic();
      version();
      constant_pool();
      access_flags();
      this_class();
      super_class();
      interfaces();
      fields();
      methods();
      attributes();
      return this.m_table;
    }
    
    void constant_pool()
      throws IOException
    {
      int k = this.m_bytes.readU2();
      IConstantCollection localIConstantCollection = this.m_table.getConstants();
      int j;
      for (int i = 1; i < k; i = j + 1)
      {
        CONSTANT_info localCONSTANT_info = CONSTANT_info.new_CONSTANT_info(this.m_bytes);
        localIConstantCollection.add(localCONSTANT_info);
        if (!(localCONSTANT_info instanceof CONSTANT_Long_info))
        {
          j = i;
          if (!(localCONSTANT_info instanceof CONSTANT_Double_info)) {}
        }
        else
        {
          j = i + 1;
        }
      }
    }
    
    void fields()
      throws IOException
    {
      int k = this.m_bytes.readU2();
      IConstantCollection localIConstantCollection = this.m_table.getConstants();
      int i = 0;
      while (i < k)
      {
        Object localObject1 = new Field_info(localIConstantCollection, this.m_bytes);
        this.m_table.getFields().add((Field_info)localObject1);
        if (((((Field_info)localObject1).getAccessFlags() & 0x18) == 24) && ("serialVersionUID".equals(((Field_info)localObject1).getName(this.m_table))))
        {
          localObject1 = ((Field_info)localObject1).getAttributes();
          int j = 0;
          int m = ((IAttributeCollection)localObject1).size();
          while (j < m)
          {
            Object localObject2 = ((IAttributeCollection)localObject1).get(j);
            if ((localObject2 instanceof ConstantValueAttribute_info))
            {
              localObject2 = ((ConstantValueAttribute_info)localObject2).getValue(this.m_table);
              if ((localObject2 instanceof CONSTANT_Long_info)) {
                this.m_table.setDeclaredSUID(((CONSTANT_Long_info)localObject2).m_value);
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    
    void interfaces()
      throws IOException
    {
      int j = this.m_bytes.readU2();
      int i = 0;
      while (i < j)
      {
        int k = this.m_bytes.readU2();
        this.m_table.getInterfaces().add(k);
        i += 1;
      }
    }
    
    void magic()
      throws IOException
    {
      long l = this.m_bytes.readU4();
      this.m_table.setMagic(l);
    }
    
    void methods()
      throws IOException
    {
      int j = this.m_bytes.readU2();
      IConstantCollection localIConstantCollection = this.m_table.getConstants();
      int i = 0;
      while (i < j)
      {
        Method_info localMethod_info = new Method_info(localIConstantCollection, this.m_bytes);
        this.m_table.getMethods().add(localMethod_info);
        i += 1;
      }
    }
    
    void super_class()
      throws IOException
    {
      int i = this.m_bytes.readU2();
      this.m_table.setSuperClassIndex(i);
    }
    
    void this_class()
      throws IOException
    {
      int i = this.m_bytes.readU2();
      this.m_table.setThisClassIndex(i);
    }
    
    void version()
      throws IOException
    {
      int i = this.m_bytes.readU2();
      int j = this.m_bytes.readU2();
      this.m_table.setVersion(new int[] { j, i });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/parser/ClassDefParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */