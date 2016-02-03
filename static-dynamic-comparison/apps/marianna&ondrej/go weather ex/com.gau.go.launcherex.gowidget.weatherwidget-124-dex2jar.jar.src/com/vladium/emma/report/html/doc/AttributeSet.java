package com.vladium.emma.report.html.doc;

import com.vladium.util.Strings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AttributeSet
  implements IContent
{
  public static AttributeSet create()
  {
    return new AttributeSetImpl();
  }
  
  public abstract boolean isEmpty();
  
  public abstract AttributeSet set(Attribute paramAttribute, int paramInt);
  
  public abstract AttributeSet set(Attribute paramAttribute, String paramString);
  
  private static final class AttributeSetImpl
    extends AttributeSet
  {
    private static final int MAX_BUF_LENGTH = 4096;
    private final Map m_attrMap = new HashMap();
    private StringBuffer m_buf;
    
    public void emit(HTMLWriter paramHTMLWriter)
    {
      int i = 1;
      Iterator localIterator = this.m_attrMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        Attribute localAttribute = (Attribute)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue().toString();
        if (i != 0)
        {
          i = 0;
          label67:
          paramHTMLWriter.write(localAttribute.getName());
          paramHTMLWriter.write("=\"");
          if ((this.m_buf == null) || (this.m_buf.length() > 4096)) {
            break label148;
          }
          this.m_buf.setLength(0);
        }
        for (;;)
        {
          Strings.HTMLEscape((String)localObject, this.m_buf);
          paramHTMLWriter.write(this.m_buf.toString());
          paramHTMLWriter.write('"');
          break;
          paramHTMLWriter.write(' ');
          break label67;
          label148:
          this.m_buf = new StringBuffer();
        }
      }
    }
    
    public boolean isEmpty()
    {
      return this.m_attrMap.isEmpty();
    }
    
    public AttributeSet set(Attribute paramAttribute, int paramInt)
    {
      this.m_attrMap.put(paramAttribute, new Integer(paramInt));
      return this;
    }
    
    public AttributeSet set(Attribute paramAttribute, String paramString)
    {
      this.m_attrMap.put(paramAttribute, paramString);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/AttributeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */