package com.vladium.emma.report;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.data.ClassDescriptor;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.ICoverageData.DataHolder;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.data.MethodDescriptor;
import com.vladium.util.Descriptors;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class ReportDataModel
  implements IReportDataModel
{
  private final ICoverageData m_cdata;
  private final IMetaData m_mdata;
  private final IReportDataView[] m_views;
  
  ReportDataModel(IMetaData paramIMetaData, ICoverageData paramICoverageData)
  {
    if (paramIMetaData == null) {
      throw new IllegalArgumentException("null input: mdata");
    }
    if (paramICoverageData == null) {
      throw new IllegalArgumentException("null input: cdata");
    }
    this.m_views = new IReportDataView[2];
    this.m_mdata = paramIMetaData;
    this.m_cdata = paramICoverageData;
  }
  
  public IReportDataView getView(int paramInt)
  {
    try
    {
      if (paramInt >= this.m_views.length) {
        throw new IllegalArgumentException("invalid viewType: " + paramInt);
      }
    }
    finally {}
    Object localObject2 = this.m_views[paramInt];
    if (localObject2 != null) {
      return (IReportDataView)localObject2;
    }
    int i;
    label70:
    AllItem localAllItem;
    label134:
    Object localObject5;
    Object localObject4;
    Object localObject3;
    String str1;
    label369:
    label391:
    label410:
    int j;
    if (paramInt == 1)
    {
      i = 1;
      if ((i != 0) && (!this.m_mdata.hasSrcFileData())) {
        throw new IllegalStateException("source file data view requested for metadata with incomplete SourceFile debug info");
      }
      localAllItem = new AllItem();
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator = this.m_mdata.iterator();
      if (localIterator.hasNext())
      {
        localObject5 = (ClassDescriptor)localIterator.next();
        localObject4 = ((ClassDescriptor)localObject5).getPackageVMName();
        localObject2 = (PackageItem)localHashMap1.get(localObject4);
        localObject3 = localObject2;
        if (localObject2 == null) {
          if (((String)localObject4).length() != 0) {
            break label369;
          }
        }
        for (localObject2 = "default package";; localObject2 = Descriptors.vmNameToJavaName((String)localObject4))
        {
          localObject3 = new PackageItem(localAllItem, (String)localObject2, (String)localObject4);
          localHashMap1.put(localObject4, localObject3);
          localAllItem.addChild((IItem)localObject3);
          localObject2 = null;
          if (i != 0)
          {
            str1 = ((ClassDescriptor)localObject5).getSrcFileName();
            String str2 = Descriptors.combineVMName((String)localObject4, str1);
            localObject4 = (SrcFileItem)localHashMap2.get(str2);
            localObject2 = localObject4;
            if (localObject4 == null)
            {
              localObject2 = new SrcFileItem((IItem)localObject3, str1, str2);
              localHashMap2.put(str2, localObject2);
              ((PackageItem)localObject3).addChild((IItem)localObject2);
            }
          }
          localObject4 = this.m_cdata.getCoverage((ClassDescriptor)localObject5);
          if ((localObject4 == null) || (((ICoverageData.DataHolder)localObject4).m_stamp == ((ClassDescriptor)localObject5).getStamp())) {
            break;
          }
          throw new EMMARuntimeException("CLASS_STAMP_MISMATCH", new Object[] { Descriptors.vmNameToJavaName(((ClassDescriptor)localObject5).getClassVMName()) });
        }
        if (localObject4 != null)
        {
          localObject4 = ((ICoverageData.DataHolder)localObject4).m_coverage;
          if (i == 0) {
            break label455;
          }
          localObject4 = new ClassItem((IItem)localObject2, (ClassDescriptor)localObject5, (boolean[][])localObject4);
          localObject5 = ((ClassDescriptor)localObject5).getMethods();
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j < localObject5.length)
      {
        str1 = localObject5[j];
        if ((str1.getStatus() & 0xE) != 0)
        {
          break label557;
          localObject4 = (boolean[][])null;
          break label391;
          label455:
          localObject4 = new ClassItem((IItem)localObject3, (ClassDescriptor)localObject5, (boolean[][])localObject4);
          break label410;
        }
        ((ClassItem)localObject4).addChild(new MethodItem((IItem)localObject4, j, str1.getName(), str1.getDescriptor(), str1.getFirstLine()));
        break label557;
      }
      if (i != 0)
      {
        ((SrcFileItem)localObject2).addChild((IItem)localObject4);
        break label134;
      }
      ((PackageItem)localObject3).addChild((IItem)localObject4);
      break label134;
      localObject2 = new ReportDataView(localAllItem);
      this.m_views[paramInt] = localObject2;
      break;
      i = 0;
      break label70;
      label557:
      j += 1;
    }
  }
  
  private static final class ReportDataView
    implements IReportDataView
  {
    private final IItem m_root;
    
    ReportDataView(IItem paramIItem)
    {
      this.m_root = paramIItem;
    }
    
    public IItem getRoot()
    {
      return this.m_root;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/ReportDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */