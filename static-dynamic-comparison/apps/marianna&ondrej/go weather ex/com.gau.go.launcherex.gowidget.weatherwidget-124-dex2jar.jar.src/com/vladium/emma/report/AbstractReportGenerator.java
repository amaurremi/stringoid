package com.vladium.emma.report;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.data.ClassDescriptor;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.logging.Logger;
import com.vladium.util.Descriptors;
import com.vladium.util.IProperties;
import com.vladium.util.IntIntMap;
import com.vladium.util.IntVector;
import com.vladium.util.ObjectIntMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractReportGenerator
  extends AbstractItemVisitor
  implements IReportGenerator
{
  private static final int MAX_DEBUG_INFO_WARNING_COUNT = 3;
  protected SourcePathCache m_cache;
  protected boolean m_hasLineNumberInfo;
  protected boolean m_hasSrcFileInfo;
  protected Logger m_log;
  protected int[] m_metrics;
  protected ReportProperties.ParsedProperties m_settings;
  protected boolean m_srcView;
  protected ItemComparator[] m_typeSortComparators;
  protected boolean m_verbose;
  protected IReportDataView m_view;
  
  public static IReportGenerator create(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new IllegalArgumentException("null/empty input: type");
    }
    if ("html".equals(paramString)) {
      return new com.vladium.emma.report.html.ReportGenerator();
    }
    if ("lcov".equals(paramString)) {
      return new com.vladium.emma.report.lcov.ReportGenerator();
    }
    if ("txt".equals(paramString)) {
      return new com.vladium.emma.report.txt.ReportGenerator();
    }
    if ("xml".equals(paramString)) {
      return new com.vladium.emma.report.xml.ReportGenerator();
    }
    throw new EMMARuntimeException("no report generator class found for type [" + paramString + "]");
  }
  
  public void cleanup()
  {
    reset();
  }
  
  public void initialize(IMetaData paramIMetaData, ICoverageData paramICoverageData, SourcePathCache paramSourcePathCache, IProperties paramIProperties)
    throws EMMARuntimeException
  {
    this.m_log = Logger.getLogger();
    this.m_verbose = this.m_log.atVERBOSE();
    this.m_settings = ReportProperties.parseProperties(paramIProperties, getType());
    this.m_cache = paramSourcePathCache;
    this.m_hasSrcFileInfo = paramIMetaData.hasSrcFileData();
    this.m_hasLineNumberInfo = paramIMetaData.hasLineNumberData();
    int j = 0;
    int n = 0;
    int i = j;
    if (!paramIMetaData.hasSrcFileData())
    {
      i = j;
      if (this.m_settings.getViewType() == 1)
      {
        i = 1;
        this.m_log.warning("not all instrumented classes were compiled with source file");
        this.m_log.warning("debug data: no sources will be embedded in the report.");
        this.m_settings.setViewType(0);
      }
    }
    j = n;
    int m = i;
    int k;
    if (!this.m_hasLineNumberInfo)
    {
      paramSourcePathCache = this.m_settings.getColumnOrder();
      paramIProperties = new IntVector();
      k = 0;
      j = 0;
      if (j < paramSourcePathCache.length)
      {
        if (paramSourcePathCache[j] == 4) {
          k = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          paramIProperties.add(paramSourcePathCache[j]);
        }
      }
      j = n;
      m = i;
      if (k != 0)
      {
        m = 1;
        if (paramIProperties.size() != 0) {
          break label418;
        }
        this.m_log.warning("line coverage requested in a report of type [" + getType() + "] but");
        this.m_log.warning("not all instrumented classes were compiled with line number");
        this.m_log.warning("debug data: since this was the only requested column, no report will be generated.");
        j = 1;
      }
    }
    if ((m != 0) && (this.m_log.atINFO()))
    {
      paramSourcePathCache = new TreeSet();
      paramIProperties = new ObjectIntMap();
      int[] arrayOfInt = new int[1];
      Iterator localIterator = paramIMetaData.iterator();
      label320:
      label418:
      label572:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label574;
        }
        ClassDescriptor localClassDescriptor = (ClassDescriptor)localIterator.next();
        if ((!localClassDescriptor.hasCompleteLineNumberInfo()) || (!localClassDescriptor.hasSrcFileInfo()))
        {
          String str = localClassDescriptor.getPackageVMName();
          if (paramIProperties.get(str, arrayOfInt)) {}
          for (i = arrayOfInt[0];; i = 0)
          {
            if (i >= 3) {
              break label572;
            }
            paramSourcePathCache.add(Descriptors.vmNameToJavaName(localClassDescriptor.getClassVMName()));
            paramIProperties.put(str, i + 1);
            break label320;
            this.m_log.warning("line coverage requested in a report of type [" + getType() + "] but");
            this.m_log.warning("not all instrumented classes were compiled with line number");
            this.m_log.warning("debug data: this column will be removed from the report.");
            this.m_settings.setColumnOrder(paramIProperties.values());
            paramSourcePathCache = this.m_settings.getSortOrder();
            paramIProperties = new IntVector();
            i = 0;
            while (i < paramSourcePathCache.length)
            {
              if (Math.abs(paramSourcePathCache[i]) != 4)
              {
                paramIProperties.add(paramSourcePathCache[i]);
                paramIProperties.add(paramSourcePathCache[(i + 1)]);
              }
              i += 2;
            }
            this.m_settings.setSortOrder(paramIProperties.values());
            j = n;
            break;
          }
        }
      }
      label574:
      this.m_log.info("showing up to 3 classes without full debug info per package:");
      paramSourcePathCache = paramSourcePathCache.iterator();
      while (paramSourcePathCache.hasNext()) {
        this.m_log.info("  " + paramSourcePathCache.next());
      }
    }
    if (j != 0) {
      throw new EMMARuntimeException("BAILED OUT");
    }
    paramSourcePathCache = IItemMetadata.Factory.getAllTypes();
    this.m_typeSortComparators = new ItemComparator[paramSourcePathCache.length];
    i = 0;
    while (i < paramSourcePathCache.length)
    {
      paramIProperties = new IntVector();
      long l = paramSourcePathCache[i].getAttributeIDs();
      j = 0;
      while (j < this.m_settings.getSortOrder().length)
      {
        k = this.m_settings.getSortOrder()[j];
        if ((1 << k & l) != 0L)
        {
          paramIProperties.add(k);
          paramIProperties.add(this.m_settings.getSortOrder()[(j + 1)]);
        }
        j += 2;
      }
      this.m_typeSortComparators[i] = ItemComparator.Factory.create(paramIProperties.values(), this.m_settings.getUnitsType());
      i += 1;
    }
    this.m_metrics = new int[paramSourcePathCache.length];
    paramSourcePathCache = this.m_settings.getMetrics();
    i = 0;
    while (i < this.m_metrics.length)
    {
      this.m_metrics[i] = -1;
      paramSourcePathCache.get(i, this.m_metrics, i);
      i += 1;
    }
    this.m_view = IReportDataModel.Factory.create(paramIMetaData, paramICoverageData).getView(this.m_settings.getViewType());
    if (this.m_settings.getViewType() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.m_srcView = bool;
      return;
    }
  }
  
  protected void reset()
  {
    this.m_settings = null;
    this.m_cache = null;
    this.m_view = null;
    this.m_srcView = false;
    this.m_typeSortComparators = null;
    this.m_metrics = null;
    this.m_log = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/AbstractReportGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */