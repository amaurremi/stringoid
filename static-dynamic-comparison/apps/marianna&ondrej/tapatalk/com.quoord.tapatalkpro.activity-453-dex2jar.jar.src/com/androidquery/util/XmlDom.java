package com.androidquery.util;

import android.util.Xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class XmlDom {
    private Element root;

    public XmlDom(InputStream paramInputStream)
            throws SAXException {
        DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            this.root = localDocumentBuilderFactory.newDocumentBuilder().parse(paramInputStream).getDocumentElement();
            return;
        } catch (IOException paramInputStream) {
            throw new SAXException(paramInputStream);
        } catch (ParserConfigurationException paramInputStream) {
        }
    }

    public XmlDom(String paramString)
            throws SAXException {
        this(paramString.getBytes());
    }

    public XmlDom(Element paramElement) {
        this.root = paramElement;
    }

    public XmlDom(byte[] paramArrayOfByte)
            throws SAXException {
        this(new ByteArrayInputStream(paramArrayOfByte));
    }

    private static XmlDom convert(Node paramNode, String paramString1, String paramString2, String paramString3) {
        if (paramNode.getNodeType() != 1) {
        }
        do {
            return null;
            paramNode = (Element) paramNode;
        }
        while (((paramString1 != null) && (!paramString1.equals(paramNode.getTagName()))) || ((paramString2 != null) && (!paramNode.hasAttribute(paramString2))) || ((paramString3 != null) && (!paramString3.equals(paramNode.getAttribute(paramString2)))));
        return new XmlDom(paramNode);
    }

    private static List<XmlDom> convert(NodeList paramNodeList, String paramString1, String paramString2, String paramString3) {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (; ; ) {
            if (i >= paramNodeList.getLength()) {
                return localArrayList;
            }
            XmlDom localXmlDom = convert(paramNodeList.item(i), paramString1, paramString2, paramString3);
            if (localXmlDom != null) {
                localArrayList.add(localXmlDom);
            }
            i += 1;
        }
    }

    private String serialize(Element paramElement, int paramInt) {
        try {
            XmlSerializer localXmlSerializer = Xml.newSerializer();
            StringWriter localStringWriter = new StringWriter();
            localXmlSerializer.setOutput(localStringWriter);
            localXmlSerializer.startDocument("utf-8", null);
            paramElement = null;
            if (paramInt > 0) {
                paramElement = new char[paramInt];
                Arrays.fill(paramElement, ' ');
                paramElement = new String(paramElement);
            }
            serialize(this.root, localXmlSerializer, 0, paramElement);
            localXmlSerializer.endDocument();
            paramElement = localStringWriter.toString();
            return paramElement;
        } catch (Exception paramElement) {
            paramElement.printStackTrace();
        }
        return null;
    }

    private void serialize(Element paramElement, XmlSerializer paramXmlSerializer, int paramInt, String paramString)
            throws Exception {
        String str = paramElement.getTagName();
        writeSpace(paramXmlSerializer, paramInt, paramString);
        paramXmlSerializer.startTag("", str);
        int i;
        if (paramElement.hasAttributes()) {
            localObject = paramElement.getAttributes();
            i = 0;
        }
        int j;
        for (; ; ) {
            if (i >= ((NamedNodeMap) localObject).getLength()) {
                if (paramElement.hasChildNodes()) {
                    paramElement = paramElement.getChildNodes();
                    j = 0;
                    i = 0;
                    if (i < paramElement.getLength()) {
                        break;
                    }
                    if (j > 0) {
                        writeSpace(paramXmlSerializer, paramInt, paramString);
                    }
                }
                paramXmlSerializer.endTag("", str);
                return;
            }
            Attr localAttr = (Attr) ((NamedNodeMap) localObject).item(i);
            paramXmlSerializer.attribute("", localAttr.getName(), localAttr.getValue());
            i += 1;
        }
        Object localObject = paramElement.item(i);
        int k = j;
        switch (((Node) localObject).getNodeType()) {
            default:
                k = j;
        }
        for (; ; ) {
            i += 1;
            j = k;
            break;
            serialize((Element) localObject, paramXmlSerializer, paramInt + 1, paramString);
            k = j + 1;
            continue;
            paramXmlSerializer.text(text((Node) localObject));
            k = j;
            continue;
            paramXmlSerializer.cdsect(text((Node) localObject));
            k = j;
        }
    }

    private String text(Node paramNode) {
        Object localObject = null;
        switch (paramNode.getNodeType()) {
            default:
                paramNode = (Node) localObject;
        }
        for (; ; ) {
            localObject = paramNode;
            if (paramNode == null) {
                localObject = "";
            }
            return (String) localObject;
            localObject = paramNode.getNodeValue();
            paramNode = (Node) localObject;
            if (localObject != null) {
                paramNode = ((String) localObject).trim();
                continue;
                paramNode = paramNode.getNodeValue();
            }
        }
    }

    private void writeSpace(XmlSerializer paramXmlSerializer, int paramInt, String paramString)
            throws Exception {
        int i;
        if (paramString != null) {
            paramXmlSerializer.text("\n");
            i = 0;
        }
        for (; ; ) {
            if (i >= paramInt) {
                return;
            }
            paramXmlSerializer.text(paramString);
            i += 1;
        }
    }

    public String attr(String paramString) {
        return this.root.getAttribute(paramString);
    }

    public XmlDom child(String paramString) {
        return child(paramString, null, null);
    }

    public XmlDom child(String paramString1, String paramString2, String paramString3) {
        paramString1 = children(paramString1, paramString2, paramString3);
        if (paramString1.size() == 0) {
            return null;
        }
        return (XmlDom) paramString1.get(0);
    }

    public List<XmlDom> children(String paramString) {
        return children(paramString, null, null);
    }

    public List<XmlDom> children(String paramString1, String paramString2, String paramString3) {
        return convert(this.root.getChildNodes(), paramString1, paramString2, paramString3);
    }

    public Element getElement() {
        return this.root;
    }

    public XmlDom tag(String paramString) {
        NodeList localNodeList = this.root.getElementsByTagName(paramString);
        Object localObject = null;
        paramString = (String) localObject;
        if (localNodeList != null) {
            paramString = (String) localObject;
            if (localNodeList.getLength() > 0) {
                paramString = new XmlDom((Element) localNodeList.item(0));
            }
        }
        return paramString;
    }

    public XmlDom tag(String paramString1, String paramString2, String paramString3) {
        paramString1 = tags(paramString1, paramString2, paramString3);
        if (paramString1.size() == 0) {
            return null;
        }
        return (XmlDom) paramString1.get(0);
    }

    public List<XmlDom> tags(String paramString) {
        return tags(paramString, null, null);
    }

    public List<XmlDom> tags(String paramString1, String paramString2, String paramString3) {
        return convert(this.root.getElementsByTagName(paramString1), null, paramString2, paramString3);
    }

    public String text() {
        NodeList localNodeList = this.root.getChildNodes();
        if (localNodeList.getLength() == 1) {
            return localNodeList.item(0).getNodeValue();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        for (; ; ) {
            if (i >= localNodeList.getLength()) {
                return localStringBuilder.toString();
            }
            localStringBuilder.append(text(localNodeList.item(i)));
            i += 1;
        }
    }

    public String text(String paramString) {
        paramString = child(paramString);
        if (paramString == null) {
            return null;
        }
        return paramString.text();
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int paramInt) {
        return serialize(this.root, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/XmlDom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */