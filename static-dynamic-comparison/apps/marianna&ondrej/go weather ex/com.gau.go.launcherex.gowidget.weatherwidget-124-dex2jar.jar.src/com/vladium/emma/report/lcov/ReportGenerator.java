package com.vladium.emma.report.lcov;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.report.AbstractReportGenerator;
import com.vladium.emma.report.AllItem;
import com.vladium.emma.report.ClassItem;
import com.vladium.emma.report.IItem;
import com.vladium.emma.report.IItemMetadata;
import com.vladium.emma.report.IReportDataView;
import com.vladium.emma.report.ItemComparator;
import com.vladium.emma.report.MethodItem;
import com.vladium.emma.report.PackageItem;
import com.vladium.emma.report.ReportProperties.ParsedProperties;
import com.vladium.emma.report.SourcePathCache;
import com.vladium.emma.report.SrcFileItem;
import com.vladium.emma.report.SrcFileItem.LineCoverageData;
import com.vladium.logging.Logger;
import com.vladium.util.Descriptors;
import com.vladium.util.Files;
import com.vladium.util.IProperties;
import com.vladium.util.IntObjectMap;
import com.vladium.util.asserts..assert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public final class ReportGenerator
  extends AbstractReportGenerator
  implements IAppErrorCodes
{
  private static final int IO_BUF_SIZE = 32768;
  private static final String TYPE = "lcov";
  private BufferedWriter m_out;
  private LinkedList m_queue;
  
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
  
  private void emitFileCoverage(SrcFileItem paramSrcFileItem)
  {
    String str1 = paramSrcFileItem.getFullVMName();
    String str2 = ((PackageItem)paramSrcFileItem.getParent()).getVMName();
    if (!this.m_hasLineNumberInfo) {
      this.m_log.info("source file '" + Descriptors.combineVMName(str2, str1) + "' has no line number information");
    }
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    for (;;)
    {
      try
      {
        localObject1 = this.m_typeSortComparators[ClassItem.getTypeMetadata().getTypeID()];
        i = 0;
        localObject1 = paramSrcFileItem.getChildren((ItemComparator)localObject1);
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject3 = (ClassItem)((Iterator)localObject1).next();
        localObject2 = ((ClassItem)localObject3).getName();
        ((ClassItem)localObject3).getClassDescriptor();
        boolean[][] arrayOfBoolean = ((ClassItem)localObject3).getCoverage();
        localObject3 = ((ClassItem)localObject3).getChildren(this.m_typeSortComparators[MethodItem.getTypeMetadata().getTypeID()]);
        if (!((Iterator)localObject3).hasNext()) {
          break label361;
        }
        Object localObject4 = (MethodItem)((Iterator)localObject3).next();
        String str3 = ((MethodItem)localObject4).getName();
        j = ((MethodItem)localObject4).getID();
        k = 0;
        if (arrayOfBoolean != null) {
          k = arrayOfBoolean[j][0];
        }
        row("FN:" + ((MethodItem)localObject4).getFirstLine() + "," + (String)localObject2 + "::" + str3);
        localObject4 = new StringBuilder().append("FNDA:");
        if (k == 0) {
          break label356;
        }
        j = 1;
        row(j + "," + (String)localObject2 + "::" + str3);
        continue;
        if (i != 0) {
          break label355;
        }
      }
      catch (Throwable paramSrcFileItem)
      {
        paramSrcFileItem.printStackTrace(System.out);
        i = 0;
      }
      this.m_log.info("[source file '" + Descriptors.combineVMName(str2, str1) + "' not found in sourcepath]");
      label355:
      return;
      label356:
      j = 0;
      continue;
      label361:
      i += 1;
    }
    this.m_settings.getUnitsType();
    paramSrcFileItem = paramSrcFileItem.getLineCoverage();
    if (paramSrcFileItem != null) {}
    label591:
    int m;
    for (int k = 1;; m = 0)
    {
      .assert.ASSERT(k, "null: lineCoverageMap");
      localObject1 = paramSrcFileItem.keys();
      Arrays.sort((int[])localObject1);
      i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          j = localObject1[i];
          localObject2 = (SrcFileItem.LineCoverageData)paramSrcFileItem.get(j);
          switch (((SrcFileItem.LineCoverageData)localObject2).m_coverageStatus)
          {
          }
        }
        for (;;)
        {
          .assert.ASSERT(false, "invalid line coverage status: " + ((SrcFileItem.LineCoverageData)localObject2).m_coverageStatus);
          break label591;
          row("DA:" + j + ",0");
          break label591;
          row("DA:" + j + ",1");
          break label591;
          row("DA:" + j + ",1");
          break label591;
          i = 1;
          break;
        }
        i += 1;
      }
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
      paramFile.delete();
      if (paramFile.exists()) {
        throw new EMMARuntimeException("Failed to delete " + paramFile);
      }
    }
    catch (UnsupportedEncodingException paramFile)
    {
      throw new EMMARuntimeException(paramFile);
      this.m_out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(paramFile), paramString), 32768);
      return;
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
    return "lcov";
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
    close();
    if (bool)
    {
      long l2 = System.currentTimeMillis();
      this.m_log.trace1("process", "[" + getType() + "] report generated in " + (l2 - l1) + " ms");
    }
  }
  
  public Object visit(AllItem paramAllItem, Object paramObject)
  {
    File localFile = this.m_settings.getOutFile();
    Object localObject = localFile;
    if (localFile == null)
    {
      localObject = new File("coverage.lcov");
      this.m_settings.setOutFile((File)localObject);
    }
    localObject = Files.newFile(this.m_settings.getOutDir(), (File)localObject);
    this.m_log.info("writing [" + getType() + "] report to [" + ((File)localObject).getAbsolutePath() + "] ...");
    openOutFile((File)localObject, this.m_settings.getOutEncoding(), true);
    paramAllItem = paramAllItem.getChildren(this.m_typeSortComparators[PackageItem.getTypeMetadata().getTypeID()]);
    while (paramAllItem.hasNext())
    {
      localObject = (IItem)paramAllItem.next();
      this.m_queue.addLast(localObject);
    }
    return paramObject;
  }
  
  public Object visit(ClassItem paramClassItem, Object paramObject)
  {
    return paramObject;
  }
  
  public Object visit(PackageItem paramPackageItem, Object paramObject)
  {
    if (this.m_verbose) {
      this.m_log.verbose("  report: processing package [" + paramPackageItem.getName() + "] ...");
    }
    if (this.m_srcView) {}
    for (int i = SrcFileItem.getTypeMetadata().getTypeID();; i = ClassItem.getTypeMetadata().getTypeID())
    {
      paramPackageItem = paramPackageItem.getChildren(this.m_typeSortComparators[i]);
      while (paramPackageItem.hasNext())
      {
        IItem localIItem = (IItem)paramPackageItem.next();
        this.m_queue.addLast(localIItem);
      }
    }
    return paramObject;
  }
  
  public Object visit(SrcFileItem paramSrcFileItem, Object paramObject)
  {
    row("SF:".concat(paramSrcFileItem.getFullVMName()));
    emitFileCoverage(paramSrcFileItem);
    row("end_of_record");
    return paramObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/lcov/ReportGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */