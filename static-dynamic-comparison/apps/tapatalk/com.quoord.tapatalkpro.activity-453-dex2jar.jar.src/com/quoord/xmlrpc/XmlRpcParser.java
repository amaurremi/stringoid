package com.quoord.xmlrpc;

import com.quoord.tapatalkpro.util.Base64;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlRpcParser {
    public static String DATETIME_FORMAT = "yyyyMMdd'T'HH:mm:ss";
    static SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
    String methodName;
    Vector params = new Vector();
    KXmlParser parser;

    public XmlRpcParser(KXmlParser paramKXmlParser) {
        this.parser = paramKXmlParser;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public Vector getParams() {
        return this.params;
    }

    Object[] parseArray()
            throws IOException, XmlPullParserException {
        ArrayList localArrayList = new ArrayList();
        this.parser.nextTag();
        this.parser.require(2, null, "data");
        for (; ; ) {
            if (this.parser.nextTag() == 3) {
                this.parser.require(3, null, "data");
                this.parser.nextTag();
                return localArrayList.toArray();
            }
            localArrayList.add(parseValue());
        }
    }

    void parseParams()
            throws IOException, XmlPullParserException {
        this.parser.require(2, null, "params");
        for (; ; ) {
            if (this.parser.nextTag() == 3) {
                this.parser.require(3, null, "params");
                return;
            }
            this.parser.require(2, null, "param");
            this.parser.nextTag();
            this.params.addElement(parseValue());
            this.parser.nextTag();
            this.parser.require(3, null, "param");
        }
    }

    public Object parseResponse()
            throws Exception {
        this.parser.require(0, null, null);
        this.parser.nextTag();
        this.parser.require(2, null, "methodResponse");
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.parser.nextTag() == 2) {
            this.parser.require(2, null, null);
            if ("fault".equals(this.parser.getName())) {
                this.parser.nextTag();
                localObject1 = (HashMap) parseValue();
                this.parser.nextTag();
                this.parser.require(3, null, "fault");
                throw new XmlRpcException(((Integer) ((HashMap) localObject1).get("faultCode")).intValue(), ((Integer) ((HashMap) localObject1).get("faultCode")).intValue() + ":" + (String) ((HashMap) localObject1).get("faultString"));
            }
            if (!"params".equals(this.parser.getName())) {
                break label272;
            }
            parseParams();
            if (this.params.size() > 1) {
                throw new IOException("too many return parameters");
            }
            localObject1 = localObject2;
            if (this.params.size() == 1) {
                localObject1 = this.params.elementAt(0);
            }
        }
        this.parser.nextTag();
        this.parser.require(3, null, "methodResponse");
        this.parser.next();
        this.parser.require(1, null, null);
        this.parser = null;
        return localObject1;
        label272:
        throw new IOException("<fault> or <params> expected instead of " + this.parser.getName());
    }

    Map parseStruct()
            throws IOException, XmlPullParserException {
        HashMap localHashMap = new HashMap();
        for (; ; ) {
            if (this.parser.nextTag() == 3) {
                return localHashMap;
            }
            this.parser.require(2, null, "member");
            this.parser.nextTag();
            this.parser.require(2, null, "name");
            String str = this.parser.nextText();
            this.parser.require(3, null, "name");
            this.parser.nextTag();
            localHashMap.put(str, parseValue());
            this.parser.nextTag();
            this.parser.require(3, null, "member");
        }
    }

    Object parseValue()
            throws XmlPullParserException, IOException {
        Object localObject1 = null;
        this.parser.require(2, null, "value");
        String str;
        if (this.parser.nextTag() != 3) {
            this.parser.require(2, null, null);
            str = this.parser.getName();
            if (str.equals("string")) {
                localObject1 = this.parser.nextText();
                this.parser.require(3, null, str);
                this.parser.nextTag();
            }
        }
        for (; ; ) {
            this.parser.require(3, "", "value");
            return localObject1;
            if ((str.equals("i4")) || (str.equals("int"))) {
                try {
                    localObject1 = new Integer(Integer.parseInt(this.parser.nextText().trim()));
                } catch (NumberFormatException localNumberFormatException) {
                    localObject2 = Integer.valueOf(20000000);
                }
                break;
            }
            if (str.equals("boolean")) {
                localObject2 = new Boolean(this.parser.nextText().trim().equals("1"));
                break;
            }
            if (str.equals("dateTime.iso8601")) {
                try {
                    Object localObject3 = dateFormat.parseObject(this.parser.nextText());
                    localObject2 = localObject3;
                } catch (ParseException localParseException) {
                    localParseException.printStackTrace();
                }
                break;
            }
            if (str.equals("base64")) {
                localObject2 = Base64.decode(this.parser.nextText());
                break;
            }
            if (str.equals("struct")) {
                localObject2 = parseStruct();
                break;
            }
            if (str.equals("array")) {
                localObject2 = parseArray();
                break;
            }
            if (str.equals("double")) {
                localObject2 = this.parser.nextText();
                break;
            }
            Object localObject2 = this.parser.nextText();
            break;
            localObject2 = new String();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/XmlRpcParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */