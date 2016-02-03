package com.vladium.emma.report.txt;

import com.vladium.emma.EMMAProperties;
import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.report.AbstractReportGenerator;
import com.vladium.emma.report.AllItem;
import com.vladium.emma.report.ClassItem;
import com.vladium.emma.report.IItem;
import com.vladium.emma.report.IItemAttribute;
import com.vladium.emma.report.IItemMetadata;
import com.vladium.emma.report.IReportDataView;
import com.vladium.emma.report.MethodItem;
import com.vladium.emma.report.PackageItem;
import com.vladium.emma.report.ReportProperties.ParsedProperties;
import com.vladium.emma.report.SourcePathCache;
import com.vladium.emma.report.SrcFileItem;
import com.vladium.logging.Logger;
import com.vladium.util.Files;
import com.vladium.util.IProperties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class ReportGenerator
  extends AbstractReportGenerator
  implements IAppErrorCodes
{
  private static final int IO_BUF_SIZE = 32768;
  private static final String LINE = "-------------------------------------------------------------------------------";
  private static final String TYPE = "txt";
  private BufferedWriter m_out;
  private LinkedList m_queue;
  private char m_separator = '\t';
  
  private void addHeaderRow(IItem paramIItem, int[] paramArrayOfInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      IItemAttribute localIItemAttribute = paramIItem.getAttribute(paramArrayOfInt[i], this.m_settings.getUnitsType());
      if (localIItemAttribute != null)
      {
        localStringBuffer.append('[');
        localStringBuffer.append(localIItemAttribute.getName());
        localStringBuffer.append(']');
      }
      if (i != j - 1) {
        localStringBuffer.append(this.m_separator);
      }
      i += 1;
    }
    row(localStringBuffer);
  }
  
  private void addItemRow(IItem paramIItem, int[] paramArrayOfInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(11);
    int i = 0;
    int k = paramArrayOfInt.length;
    if (i < k)
    {
      int j = paramArrayOfInt[i];
      IItemAttribute localIItemAttribute = paramIItem.getAttribute(j, this.m_settings.getUnitsType());
      if (localIItemAttribute != null)
      {
        if ((this.m_metrics[j] <= 0) || (localIItemAttribute.passes(paramIItem, this.m_metrics[j]))) {
          break label129;
        }
        j = 1;
        label81:
        if (j == 0) {
          break label135;
        }
        localIItemAttribute.format(paramIItem, localStringBuffer);
        localStringBuffer.append('!');
      }
      for (;;)
      {
        if (i != k - 1) {
          localStringBuffer.append(this.m_separator);
        }
        i += 1;
        break;
        label129:
        j = 0;
        break label81;
        label135:
        localIItemAttribute.format(paramIItem, localStringBuffer);
      }
    }
    row(localStringBuffer);
  }
  
  private void addTitleRow(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt1)
    {
      eol();
      i += 1;
    }
    row(new StringBuffer(paramString).append(":"));
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      eol();
      paramInt1 += 1;
    }
  }
  
  private void close()
  {
    if (this.m_out != null) {}
    try
    {
      this.m_out.flush();
      this.m_out.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
    finally
    {
      this.m_out = null;
    }
  }
  
  private void eol()
  {
    try
    {
      this.m_out.newLine();
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
  }
  
  private void line()
  {
    try
    {
      this.m_out.write("-------------------------------------------------------------------------------");
      this.m_out.newLine();
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", localIOException);
    }
  }
  
  private void openOutFile(File paramFile, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      File localFile = paramFile.getParentFile();
      if (localFile != null) {
        localFile.mkdirs();
      }
      this.m_out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramString), 32768);
      return;
    }
    catch (UnsupportedEncodingException paramFile)
    {
      throw new EMMARuntimeException(paramFile);
    }
    catch (IOException paramFile)
    {
      throw new EMMARuntimeException(paramFile);
    }
  }
  
  private void row(String paramString)
  {
    try
    {
      this.m_out.write(paramString);
      this.m_out.newLine();
      return;
    }
    catch (IOException paramString)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", paramString);
    }
  }
  
  private void row(StringBuffer paramStringBuffer)
  {
    try
    {
      this.m_out.write(paramStringBuffer.toString());
      this.m_out.newLine();
      return;
    }
    catch (IOException paramStringBuffer)
    {
      throw new EMMARuntimeException("REPORT_IO_FAILURE", paramStringBuffer);
    }
  }
  
  public void cleanup()
  {
    this.m_queue = null;
    close();
    super.cleanup();
  }
  
  public String getType()
  {
    return "txt";
  }
  
  public void process(IMetaData paramIMetaData, ICoverageData paramICoverageData, SourcePathCache paramSourcePathCache, IProperties paramIProperties)
    throws EMMARuntimeException
  {
    initialize(paramIMetaData, paramICoverageData, paramSourcePathCache, paramIProperties);
    long l1 = 0L;
    boolean bool = this.m_log.atTRACE1();
    if (bool) {
      l1 = System.currentTimeMillis();
    }
    this.m_queue = new LinkedList();
    this.m_queue.add(this.m_view.getRoot());
    while (!this.m_queue.isEmpty()) {
      ((IItem)this.m_queue.removeFirst()).accept(this, null);
    }
    line();
    close();
    if (bool)
    {
      long l2 = System.currentTimeMillis();
      this.m_log.trace1("process", "[" + getType() + "] report generated in " + (l2 - l1) + " ms");
    }
  }
  
  public Object visit(AllItem paramAllItem, Object paramObject)
  {
    Object localObject2 = this.m_settings.getOutFile();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new File("coverage.txt");
      this.m_settings.setOutFile((File)localObject1);
    }
    localObject1 = Files.newFile(this.m_settings.getOutDir(), (File)localObject1);
    this.m_log.info("writing [" + getType() + "] report to [" + ((File)localObject1).getAbsolutePath() + "] ...");
    openOutFile((File)localObject1, this.m_settings.getOutEncoding(), true);
    for (;;)
    {
      try
      {
        localObject1 = new StringBuffer(101);
        ((StringBuffer)localObject1).append("[");
        ((StringBuffer)localObject1).append("EMMA");
        ((StringBuffer)localObject1).append(" v");
        ((StringBuffer)localObject1).append("0.0.0 (unsupported private build)");
        ((StringBuffer)localObject1).append(" report, generated ");
        ((StringBuffer)localObject1).append(new Date(EMMAProperties.getTimeStamp()));
        ((StringBuffer)localObject1).append("]");
        this.m_out.write(((StringBuffer)localObject1).toString());
        this.m_out.newLine();
        this.m_out.flush();
        localObject1 = this.m_settings.getColumnOrder();
        line();
        addTitleRow("OVERALL COVERAGE SUMMARY", 0, 1);
        addHeaderRow(paramAllItem, (int[])localObject1);
        addItemRow(paramAllItem, (int[])localObject1);
        addTitleRow("OVERALL STATS SUMMARY", 1, 1);
        row("total packages:" + this.m_separator + paramAllItem.getChildCount());
        row("total classes:" + this.m_separator + paramAllItem.getAggregate(11));
        row("total methods:" + this.m_separator + paramAllItem.getAggregate(10));
        if ((this.m_srcView) && (this.m_hasSrcFileInfo))
        {
          row("total executable files:" + this.m_separator + paramAllItem.getAggregate(12));
          if (this.m_hasLineNumberInfo) {
            row("total executable lines:" + this.m_separator + paramAllItem.getAggregate(7));
          }
        }
        if (this.m_settings.getDepth() > paramAllItem.getMetadata().getTypeID())
        {
          i = 1;
          addTitleRow("COVERAGE BREAKDOWN BY PACKAGE", 1, 1);
          int j = 0;
          paramAllItem = paramAllItem.getChildren(this.m_typeSortComparators[PackageItem.getTypeMetadata().getTypeID()]);
          if (!paramAllItem.hasNext()) {
            break;
          }
          localObject2 = (IItem)paramAllItem.next();
          int k = j;
          if (j == 0)
          {
            addHeaderRow((IItem)localObject2, (int[])localObject1);
            k = 1;
          }
          addItemRow((IItem)localObject2, (int[])localObject1);
          j = k;
          if (i == 0) {
            continue;
          }
          this.m_queue.addLast(localObject2);
          j = k;
          continue;
        }
        int i = 0;
      }
      catch (IOException paramAllItem)
      {
        throw new EMMARuntimeException("REPORT_IO_FAILURE", paramAllItem);
      }
    }
    return paramObject;
  }
  
  public Object visit(ClassItem paramClassItem, Object paramObject)
  {
    int[] arrayOfInt = this.m_settings.getColumnOrder();
    line();
    addTitleRow("COVERAGE SUMMARY FOR CLASS [".concat(paramClassItem.getName()).concat("]"), 0, 1);
    addHeaderRow(paramClassItem, arrayOfInt);
    addItemRow(paramClassItem, arrayOfInt);
    addTitleRow("COVERAGE BREAKDOWN BY METHOD", 1, 1);
    paramClassItem = paramClassItem.getChildren(this.m_typeSortComparators[MethodItem.getTypeMetadata().getTypeID()]);
    while (paramClassItem.hasNext()) {
      addItemRow((IItem)paramClassItem.next(), arrayOfInt);
    }
    return paramObject;
  }
  
  public Object visit(PackageItem paramPackageItem, Object paramObject)
  {
    int i = 0;
    if (this.m_verbose) {
      this.m_log.verbose("  report: processing package [" + paramPackageItem.getName() + "] ...");
    }
    int[] arrayOfInt = this.m_settings.getColumnOrder();
    line();
    addTitleRow("COVERAGE SUMMARY FOR PACKAGE [".concat(paramPackageItem.getName()).concat("]"), 0, 1);
    addHeaderRow(paramPackageItem, arrayOfInt);
    addItemRow(paramPackageItem, arrayOfInt);
    if (this.m_settings.getDepth() > paramPackageItem.getMetadata().getTypeID()) {
      i = 1;
    }
    Object localObject;
    int k;
    if (this.m_srcView)
    {
      localObject = "COVERAGE BREAKDOWN BY SOURCE FILE";
      addTitleRow((String)localObject, 1, 1);
      k = 0;
      localObject = this.m_typeSortComparators;
      if (!this.m_srcView) {
        break label255;
      }
    }
    label255:
    for (int j = SrcFileItem.getTypeMetadata().getTypeID();; j = ClassItem.getTypeMetadata().getTypeID())
    {
      paramPackageItem = paramPackageItem.getChildren(localObject[j]);
      j = k;
      while (paramPackageItem.hasNext())
      {
        localObject = (IItem)paramPackageItem.next();
        k = j;
        if (j == 0)
        {
          addHeaderRow((IItem)localObject, arrayOfInt);
          k = 1;
        }
        addItemRow((IItem)localObject, arrayOfInt);
        j = k;
        if (i != 0)
        {
          this.m_queue.addLast(localObject);
          j = k;
        }
      }
      localObject = "COVERAGE BREAKDOWN BY CLASS";
      break;
    }
    return paramObject;
  }
  
  public Object visit(SrcFileItem paramSrcFileItem, Object paramObject)
  {
    int[] arrayOfInt = this.m_settings.getColumnOrder();
    line();
    addTitleRow("COVERAGE SUMMARY FOR SOURCE FILE [".concat(paramSrcFileItem.getName()).concat("]"), 0, 1);
    addHeaderRow(paramSrcFileItem, arrayOfInt);
    addItemRow(paramSrcFileItem, arrayOfInt);
    addTitleRow("COVERAGE BREAKDOWN BY CLASS AND METHOD", 1, 1);
    int i = 0;
    paramSrcFileItem = paramSrcFileItem.getChildren(this.m_typeSortComparators[ClassItem.getTypeMetadata().getTypeID()]);
    if (paramSrcFileItem.hasNext())
    {
      Object localObject = (IItem)paramSrcFileItem.next();
      int j = i;
      if (i == 0)
      {
        addHeaderRow((IItem)localObject, arrayOfInt);
        j = 1;
      }
      addTitleRow("class [" + ((IItem)localObject).getName() + "] methods", 0, 0);
      localObject = ((IItem)localObject).getChildren(this.m_typeSortComparators[MethodItem.getTypeMetadata().getTypeID()]);
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        addItemRow((MethodItem)((Iterator)localObject).next(), arrayOfInt);
      }
    }
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/txt/ReportGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */