package com.mobisystems.office.pdfExport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class i
{
  private a aNf = new a();
  private Map<b, String> aNg = new HashMap();
  private Set<Pattern> aNh = new HashSet();
  private Set<d> aNi = new HashSet();
  private Set<EmbeddedFont> aNj = new HashSet();
  
  private void a(PdfWriter paramPdfWriter, a parama)
  {
    a.a(parama, paramPdfWriter);
  }
  
  private void a(PdfWriter paramPdfWriter, String paramString, Set<? extends a> paramSet)
  {
    if (!paramSet.isEmpty())
    {
      paramPdfWriter.b(paramString);
      paramPdfWriter.Ki();
      paramString = paramSet.iterator();
      while (paramString.hasNext()) {
        a.b((a)paramString.next(), paramPdfWriter);
      }
      paramPdfWriter.Kj();
    }
  }
  
  public void a(PdfWriter paramPdfWriter, d paramd)
  {
    a(paramPdfWriter, paramd);
    a(paramd);
  }
  
  public void a(d paramd)
  {
    this.aNi.add(paramd);
  }
  
  public void clear()
  {
    this.aNg.clear();
    this.aNh.clear();
    this.aNi.clear();
    this.aNj.clear();
  }
  
  public void i(PdfWriter paramPdfWriter)
  {
    if (!this.aNg.isEmpty())
    {
      paramPdfWriter.b("ExtGState");
      paramPdfWriter.Ki();
      Iterator localIterator = this.aNg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localObject = (b)((Map.Entry)localObject).getKey();
        paramPdfWriter.b(str);
        ((b)localObject).b(paramPdfWriter);
      }
      paramPdfWriter.Kj();
    }
    a(paramPdfWriter, "Pattern", this.aNh);
    a(paramPdfWriter, "XObject", this.aNi);
    a(paramPdfWriter, "Font", this.aNj);
  }
  
  static abstract class a
    extends f
  {
    private String aNk;
    
    protected a(String paramString)
    {
      this.aNk = paramString;
    }
    
    private void j(PdfWriter paramPdfWriter)
    {
      paramPdfWriter.b(this.aNk);
    }
    
    private void k(PdfWriter paramPdfWriter)
    {
      int j = getId();
      int i = j;
      if (j < 0)
      {
        l(paramPdfWriter);
        i = paramPdfWriter.a(this);
        e(paramPdfWriter);
      }
      paramPdfWriter.b(this.aNk);
      paramPdfWriter.gH(i);
    }
    
    protected void e(PdfWriter paramPdfWriter) {}
    
    protected void l(PdfWriter paramPdfWriter) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/office/pdfExport/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */