package com.mopub.mobileads.util.vast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class f {
    static String a(Node paramNode) {
        if ((paramNode != null) && (paramNode.getFirstChild() != null) && (paramNode.getFirstChild().getNodeValue() != null)) {
            return paramNode.getFirstChild().getNodeValue().trim();
        }
        return null;
    }

    static List<String> a(Document paramDocument, String paramString) {
        return a(paramDocument, paramString, null, null);
    }

    static List<String> a(Document paramDocument, String paramString1, String paramString2, String paramString3) {
        ArrayList localArrayList = new ArrayList();
        if (paramDocument == null) {
            return localArrayList;
        }
        paramDocument = paramDocument.getElementsByTagName(paramString1);
        if (paramDocument == null) {
            return localArrayList;
        }
        int i = 0;
        while (i < paramDocument.getLength()) {
            paramString1 = paramDocument.item(i);
            if (paramString1 != null) {
                if (a(paramString1, paramString2, Arrays.asList(new String[]{paramString3}))) {
                    paramString1 = a(paramString1);
                    if (paramString1 != null) {
                        localArrayList.add(paramString1);
                    }
                }
            }
            i += 1;
        }
        return localArrayList;
    }

    static Node a(Node paramNode, String paramString) {
        return a(paramNode, paramString, null, null);
    }

    static Node a(Node paramNode, String paramString1, String paramString2, List<String> paramList) {
        if ((paramNode == null) || (paramString1 == null)) {
        }
        do {
            return null;
            paramNode = b(paramNode, paramString1, paramString2, paramList);
        } while ((paramNode == null) || (paramNode.isEmpty()));
        return (Node) paramNode.get(0);
    }

    static boolean a(Node paramNode, String paramString, List<String> paramList) {
        if ((paramString == null) || (paramList == null)) {
        }
        do {
            return true;
            paramNode = paramNode.getAttributes();
            if (paramNode == null) {
                break;
            }
            paramNode = paramNode.getNamedItem(paramString);
        } while ((paramNode != null) && (paramList.contains(paramNode.getNodeValue())));
        return false;
    }

    static Integer b(Node paramNode, String paramString) {
        if ((paramNode == null) || (paramString == null)) {
            return null;
        }
        try {
            int i = Integer.parseInt(c(paramNode, paramString));
            return Integer.valueOf(i);
        } catch (NumberFormatException paramNode) {
        }
        return null;
    }

    static List<Node> b(Node paramNode, String paramString1, String paramString2, List<String> paramList) {
        if ((paramNode == null) || (paramString1 == null)) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        paramNode = paramNode.getChildNodes();
        int i = 0;
        while (i < paramNode.getLength()) {
            Node localNode = paramNode.item(i);
            if ((localNode.getNodeName().equals(paramString1)) && (a(localNode, paramString2, paramList))) {
                localArrayList.add(localNode);
            }
            i += 1;
        }
        return localArrayList;
    }

    static String c(Node paramNode, String paramString) {
        if ((paramNode == null) || (paramString == null)) {
        }
        do {
            return null;
            paramNode = paramNode.getAttributes().getNamedItem(paramString);
        } while (paramNode == null);
        return paramNode.getNodeValue();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/util/vast/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */