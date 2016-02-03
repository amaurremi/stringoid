package com.vladium.emma.rt;

import com.vladium.emma.data.IMetaData;
import com.vladium.emma.filter.IInclExclFilter;
import com.vladium.emma.instr.InstrVisitor;
import com.vladium.emma.instr.InstrVisitor.InstrResult;
import com.vladium.jcd.compiler.ClassWriter;
import com.vladium.jcd.parser.ClassDefParser;
import com.vladium.util.ByteArrayOStream;
import com.vladium.util.Descriptors;
import java.io.IOException;

public final class InstrClassLoadHook
  implements IClassLoadHook
{
  private final InstrVisitor m_classDefProcessor;
  private final IInclExclFilter m_filter;
  private final InstrVisitor.InstrResult m_instrResult;
  private final IMetaData m_metadata;
  
  public InstrClassLoadHook(IInclExclFilter paramIInclExclFilter, IMetaData paramIMetaData)
  {
    if (paramIMetaData == null) {
      throw new IllegalArgumentException("null input: mdata");
    }
    this.m_filter = paramIInclExclFilter;
    this.m_metadata = paramIMetaData;
    this.m_classDefProcessor = new InstrVisitor(paramIMetaData.getOptions());
    this.m_instrResult = new InstrVisitor.InstrResult();
  }
  
  public boolean processClassDef(String arg1, byte[] paramArrayOfByte, int paramInt, ByteArrayOStream paramByteArrayOStream)
    throws IOException
  {
    Object localObject = this.m_filter;
    if ((localObject == null) || (((IInclExclFilter)localObject).included(???)))
    {
      paramArrayOfByte = ClassDefParser.parseClass(paramArrayOfByte, paramInt);
      localObject = Descriptors.javaNameToVMName(???);
      for (;;)
      {
        boolean bool2;
        synchronized (this.m_metadata.lock())
        {
          bool1 = this.m_metadata.hasDescriptor((String)localObject);
          localObject = this.m_classDefProcessor;
          if (!bool1)
          {
            bool1 = true;
            ((InstrVisitor)localObject).process(paramArrayOfByte, false, true, bool1, this.m_instrResult);
            bool1 = this.m_instrResult.m_instrumented;
            bool2 = bool1;
            if (this.m_instrResult.m_descriptor == null) {}
          }
        }
        try
        {
          if (!this.m_metadata.add(this.m_instrResult.m_descriptor, false)) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!bool2) {
            break;
          }
          ClassWriter.writeClassTable(paramArrayOfByte, paramByteArrayOStream);
          return true;
        }
        finally {}
        paramArrayOfByte = finally;
        throw paramArrayOfByte;
        boolean bool1 = false;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/InstrClassLoadHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */