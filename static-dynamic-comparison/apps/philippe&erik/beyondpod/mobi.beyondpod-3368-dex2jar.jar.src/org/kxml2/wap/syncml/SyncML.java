package org.kxml2.wap.syncml;

import org.kxml2.wap.WbxmlParser;
import org.kxml2.wap.WbxmlSerializer;

public abstract class SyncML
{
  public static final String[] TAG_TABLE_0 = { "Add", "Alert", "Archive", "Atomic", "Chal", "Cmd", "CmdID", "CmdRef", "Copy", "Cred", "Data", "Delete", "Exec", "Final", "Get", "Item", "Lang", "LocName", "LocURI", "Map", "MapItem", "Meta", "MsgID", "MsgRef", "NoResp", "NoResults", "Put", "Replace", "RespURI", "Results", "Search", "Sequence", "SessionID", "SftDel", "Source", "SourceRef", "Status", "Sync", "SyncBody", "SyncHdr", "SyncML", "Target", "TargetRef", "Reserved for future use", "VerDTD", "VerProto", "NumberOfChanged", "MoreData", "Field", "Filter", "Record", "FilterType", "SourceParent", "TargetParent", "Move", "Correlator" };
  public static final String[] TAG_TABLE_1 = { "Anchor", "EMI", "Format", "FreeID", "FreeMem", "Last", "Mark", "MaxMsgSize", "Mem", "MetInf", "Next", "NextNonce", "SharedMem", "Size", "Type", "Version", "MaxObjSize", "FieldLevel" };
  public static final String[] TAG_TABLE_2_DM = { "AccessType", "ACL", "Add", "b64", "bin", "bool", "chr", "CaseSense", "CIS", "Copy", "CS", "date", "DDFName", "DefaultValue", "Delete", "Description", "DDFFormat", "DFProperties", "DFTitle", "DFType", "Dynamic", "Exec", "float", "Format", "Get", "int", "Man", "MgmtTree", "MIME", "Mod", "Name", "Node", "node", "NodeName", "null", "Occurence", "One", "OneOrMore", "OneOrN", "Path", "Permanent", "Replace", "RTProperties", "Scope", "Size", "time", "Title", "TStamp", "Type", "Value", "VerDTD", "VerNo", "xml", "ZeroOrMore", "ZeroOrN", "ZeroOrOne" };
  
  public static WbxmlParser createDMParser()
  {
    WbxmlParser localWbxmlParser = createParser();
    localWbxmlParser.setTagTable(2, TAG_TABLE_2_DM);
    return localWbxmlParser;
  }
  
  public static WbxmlSerializer createDMSerializer()
  {
    WbxmlSerializer localWbxmlSerializer = createSerializer();
    localWbxmlSerializer.setTagTable(2, TAG_TABLE_2_DM);
    return localWbxmlSerializer;
  }
  
  public static WbxmlParser createParser()
  {
    WbxmlParser localWbxmlParser = new WbxmlParser();
    localWbxmlParser.setTagTable(0, TAG_TABLE_0);
    localWbxmlParser.setTagTable(1, TAG_TABLE_1);
    return localWbxmlParser;
  }
  
  public static WbxmlSerializer createSerializer()
  {
    WbxmlSerializer localWbxmlSerializer = new WbxmlSerializer();
    localWbxmlSerializer.setTagTable(0, TAG_TABLE_0);
    localWbxmlSerializer.setTagTable(1, TAG_TABLE_1);
    return localWbxmlSerializer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/kxml2/wap/syncml/SyncML.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */