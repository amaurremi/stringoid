package com.quoord.xmlrpc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class XmlRpcWriter {
    AbstractXmlWriter writer;

    public XmlRpcWriter(AbstractXmlWriter paramAbstractXmlWriter) {
        this.writer = paramAbstractXmlWriter;
    }

    private void writeValue(Object paramObject)
            throws IOException {
        this.writer.startTag("value");
        if ((paramObject instanceof String)) {
            this.writer.startTag("string");
            this.writer.write((String) paramObject);
        }
        for (; ; ) {
            this.writer.endTag();
            this.writer.endTag();
            return;
            if ((paramObject instanceof Integer)) {
                this.writer.startTag("i4");
                this.writer.write(((Integer) paramObject).intValue());
            } else {
                Object localObject1;
                if ((paramObject instanceof Boolean)) {
                    this.writer.startTag("boolean");
                    localObject1 = this.writer;
                    if (((Boolean) paramObject).booleanValue()) {
                    }
                    for (paramObject = "1"; ; paramObject = "0") {
                        ((AbstractXmlWriter) localObject1).write((String) paramObject);
                        break;
                    }
                }
                if ((paramObject instanceof Date)) {
                    this.writer.startTag("dateTime.iso8601");
                    this.writer.write(IsoDate.dateToString((Date) paramObject, 3));
                } else {
                    if ((paramObject instanceof List)) {
                        this.writer.startTag("array");
                        this.writer.startTag("data");
                        paramObject = ((List) paramObject).iterator();
                        for (; ; ) {
                            if (!((Iterator) paramObject).hasNext()) {
                                this.writer.endTag();
                                break;
                            }
                            writeValue(((Iterator) paramObject).next());
                        }
                    }
                    if ((paramObject instanceof Object[])) {
                        this.writer.startTag("array");
                        this.writer.startTag("data");
                        paramObject = (Object[]) paramObject;
                        int i = 0;
                        for (; ; ) {
                            if (i >= paramObject.length) {
                                this.writer.endTag();
                                break;
                            }
                            writeValue(paramObject[i]);
                            i += 1;
                        }
                    }
                    if ((paramObject instanceof Map)) {
                        this.writer.startTag("struct");
                        paramObject = ((Map) paramObject).entrySet().iterator();
                        while (((Iterator) paramObject).hasNext()) {
                            Object localObject2 = (Map.Entry) ((Iterator) paramObject).next();
                            localObject1 = (String) ((Map.Entry) localObject2).getKey();
                            localObject2 = ((Map.Entry) localObject2).getValue();
                            this.writer.startTag("member");
                            this.writer.startTag("name");
                            this.writer.write(((String) localObject1).toString());
                            this.writer.endTag();
                            writeValue(localObject2);
                            this.writer.endTag();
                        }
                    } else if ((paramObject instanceof byte[])) {
                        this.writer.startTag("base64");
                        paramObject = Base64Coder.encode((byte[]) paramObject);
                        this.writer.write((char[]) paramObject);
                    } else {
                        if (!(paramObject instanceof ByteArrayOutputStream)) {
                            break;
                        }
                        this.writer.startTag("base64");
                        this.writer.write(Base64Coder.encode((ByteArrayOutputStream) paramObject));
                    }
                }
            }
        }
        throw new IOException("Unknown data type: " + paramObject);
    }

    public void writeCall(String paramString, Object[] paramArrayOfObject)
            throws IOException {
        this.writer.startTag("methodCall");
        this.writer.startTag("methodName");
        this.writer.write(paramString);
        this.writer.endTag();
        int i;
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
            this.writer.startTag("params");
            i = 0;
        }
        for (; ; ) {
            if (i >= paramArrayOfObject.length) {
                this.writer.endTag();
                this.writer.endTag();
                return;
            }
            this.writer.startTag("param");
            writeValue(paramArrayOfObject[i]);
            this.writer.endTag();
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/XmlRpcWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */