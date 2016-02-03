package com.everimaging.fotorsdk.collage.svgutils;

import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.RectF;
import com.everimaging.fotorsdk.collage.utils.MagicPath;
import com.everimaging.fotorsdk.collage.utils.MagicPath.Direction;
import com.everimaging.fotorsdk.collage.utils.MagicPath.PathType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class a {
    static float a = 72.0F;
    private static final String b = a.class.getSimpleName();
    private static final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);

    public static ArrayList<c> a(InputStream paramInputStream)
            throws SVGParseException {
        return a(paramInputStream, a);
    }

    private static ArrayList<c> a(InputStream paramInputStream, float paramFloat) {
        long l = System.currentTimeMillis();
        ArrayList localArrayList = new ArrayList();
        try {
            XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            new Picture();
            b localb = new b(localArrayList, null);
            localb.a(paramFloat);
            localXMLReader.setContentHandler(localb);
            localXMLReader.parse(new InputSource(paramInputStream));
            c.c(new Object[]{b, "Parsing complete in " + (System.currentTimeMillis() - l) + " millis."});
            return localArrayList;
        } catch (Exception paramInputStream) {
            c.d(new Object[]{b, "Parse error: " + paramInputStream});
            throw new SVGParseException(paramInputStream);
        }
    }

    private static a b(String paramString) {
        int m = paramString.length();
        ArrayList localArrayList = new ArrayList();
        int j = 1;
        int k = 0;
        int i = 0;
        if (j < m) {
            if (k != 0) {
                k = 0;
            }
            for (; ; ) {
                j += 1;
                break;
                int n = paramString.charAt(j);
                switch (n) {
                    default:
                        break;
                    case 9:
                    case 10:
                    case 32:
                    case 44:
                    case 45:
                        str = paramString.substring(i, j);
                        if (str.trim().length() > 0) {
                            localArrayList.add(Float.valueOf(Float.parseFloat(str)));
                            if (n == 45) {
                                i = j;
                            }
                        }
                        break;
                    case 41:
                    case 65:
                    case 67:
                    case 72:
                    case 76:
                    case 77:
                    case 81:
                    case 83:
                    case 84:
                    case 86:
                    case 90:
                    case 97:
                    case 99:
                    case 104:
                    case 108:
                    case 109:
                    case 113:
                    case 115:
                    case 116:
                    case 118:
                    case 122:
                        paramString = paramString.substring(i, j);
                        if (paramString.trim().length() > 0) {
                            localArrayList.add(Float.valueOf(Float.parseFloat(paramString)));
                        }
                        return new a(localArrayList, j);
                    i = j + 1;
                    k = 1;
                    continue;
                    i += 1;
                }
            }
        }
        String str = paramString.substring(i);
        if (str.length() > 0) {
        }
        try {
            localArrayList.add(Float.valueOf(Float.parseFloat(str)));
            i = paramString.length();
            return new a(localArrayList, i);
        } catch (NumberFormatException localNumberFormatException) {
            for (; ; ) {
            }
        }
    }

    private static MagicPath c(String paramString) {
        int j = paramString.length();
        b localb = new b(paramString, 0);
        localb.a();
        MagicPath localMagicPath = new MagicPath();
        float f9 = 0.0F;
        float f10 = 0.0F;
        float f4 = 0.0F;
        float f3 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        new RectF();
        char c2 = 'x';
        char c1;
        label104:
        int i;
        float f2;
        float f1;
        float f8;
        float f7;
        if (localb.a < j) {
            c1 = paramString.charAt(localb.a);
            if ((!Character.isDigit(c1)) && (c1 != '.') && (c1 != '-')) {
                localb.c();
                i = 0;
            }
            switch (c1) {
                default:
                    c.d(new Object[]{b, "Invalid path command: " + c1});
                    localb.c();
                    f2 = f9;
                    f1 = f10;
                case 'M':
                case 'm':
                case 'Z':
                case 'z':
                case 'L':
                case 'l':
                case 'H':
                case 'h':
                case 'V':
                case 'v':
                    for (; ; ) {
                        if (i == 0) {
                            f3 = f1;
                            f4 = f2;
                        }
                        localb.a();
                        c2 = c1;
                        f10 = f1;
                        f9 = f2;
                        break;
                        if (c2 == 'M') {
                            c1 = 'L';
                            break label104;
                        }
                        c1 = c2;
                        if (c2 != 'm') {
                            break label104;
                        }
                        c1 = 'l';
                        break label104;
                        f1 = localb.e();
                        f2 = localb.e();
                        if (c1 == 'm') {
                            localMagicPath.a(MagicPath.PathType.RMOVE_TO, new PointF(f1, f2));
                            f1 += f9;
                            f2 += f10;
                        }
                        for (; ; ) {
                            f8 = f2;
                            f7 = f1;
                            f6 = f2;
                            f5 = f1;
                            f1 = f8;
                            f2 = f7;
                            break;
                            localMagicPath.a(MagicPath.PathType.MOVE_TO, new PointF(f1, f2));
                        }
                        localMagicPath.a(MagicPath.PathType.CLOSE);
                        f1 = f6;
                        f2 = f5;
                        continue;
                        f2 = localb.e();
                        f1 = localb.e();
                        if (c1 == 'l') {
                            localMagicPath.a(MagicPath.PathType.RLINE_TO, new PointF(f2, f1));
                            f2 = f9 + f2;
                            f1 = f10 + f1;
                        } else {
                            localMagicPath.a(MagicPath.PathType.LINE_TO, new PointF(f2, f1));
                            continue;
                            f2 = localb.e();
                            if (c1 == 'h') {
                                localMagicPath.a(MagicPath.PathType.RLINE_TO, new PointF(f2, 0.0F));
                                f2 = f9 + f2;
                                f1 = f10;
                            } else {
                                localMagicPath.a(MagicPath.PathType.LINE_TO, new PointF(f2, f10));
                                f1 = f10;
                                continue;
                                f1 = localb.e();
                                if (c1 == 'v') {
                                    localMagicPath.a(MagicPath.PathType.RLINE_TO, new PointF(0.0F, f1));
                                    f1 = f10 + f1;
                                    f2 = f9;
                                } else {
                                    localMagicPath.a(MagicPath.PathType.LINE_TO, new PointF(f9, f1));
                                    f2 = f9;
                                }
                            }
                        }
                    }
                case 'C':
                case 'c':
                    f8 = localb.e();
                    f7 = localb.e();
                    f1 = localb.e();
                    f3 = localb.e();
                    f2 = localb.e();
                    f4 = localb.e();
                    if (c1 == 'c') {
                        f2 += f9;
                        f4 += f10;
                        f3 += f10;
                        f7 += f10;
                        f1 += f9;
                        f8 += f9;
                    }
                    break;
            }
        }
        for (; ; ) {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new PointF(f8, f7));
            localArrayList.add(new PointF(f1, f3));
            localArrayList.add(new PointF(f2, f4));
            localMagicPath.a(MagicPath.PathType.CUBIC_TO, localArrayList);
            i = 1;
            f7 = f4;
            f4 = f1;
            f1 = f7;
            break;
            float f14 = localb.e();
            float f12 = localb.e();
            float f13 = localb.e();
            float f11 = localb.e();
            f7 = f11;
            f1 = f13;
            f8 = f12;
            f2 = f14;
            if (c1 == 's') {
                f2 = f14 + f9;
                f1 = f13 + f9;
                f8 = f12 + f10;
                f7 = f11 + f10;
            }
            localArrayList = new ArrayList();
            localArrayList.add(new PointF(f9 * 2.0F - f4, f10 * 2.0F - f3));
            localArrayList.add(new PointF(f2, f8));
            localArrayList.add(new PointF(f1, f7));
            localMagicPath.a(MagicPath.PathType.CUBIC_TO, localArrayList);
            f3 = f8;
            f8 = f1;
            i = 1;
            f4 = f2;
            f1 = f7;
            f2 = f8;
            break;
            f8 = localb.e();
            f7 = localb.e();
            f2 = f7;
            f1 = f8;
            if (c1 == 't') {
                f1 = f8 + f9;
                f2 = f7 + f10;
            }
            f4 = 2.0F * f9 - f4;
            f3 = 2.0F * f10 - f3;
            localArrayList = new ArrayList();
            localArrayList.add(new PointF(f9, f10));
            localArrayList.add(new PointF(f4, f3));
            localArrayList.add(new PointF(f1, f2));
            localMagicPath.a(MagicPath.PathType.CUBIC_TO, localArrayList);
            f7 = f1;
            i = 1;
            f1 = f2;
            f2 = f7;
            break;
            f8 = localb.e();
            f7 = localb.e();
            f12 = localb.e();
            f11 = localb.e();
            f4 = f11;
            f3 = f12;
            f1 = f7;
            f2 = f8;
            if (c1 == 'q') {
                f3 = f12 + f9;
                f4 = f11 + f10;
                f2 = f8 + f9;
                f1 = f7 + f10;
            }
            localArrayList = new ArrayList();
            localArrayList.add(new PointF(f9, f10));
            localArrayList.add(new PointF(f2, f1));
            localArrayList.add(new PointF(f3, f4));
            localMagicPath.a(MagicPath.PathType.CUBIC_TO, localArrayList);
            f7 = f4;
            f8 = f3;
            i = 1;
            f3 = f1;
            f4 = f2;
            f1 = f7;
            f2 = f8;
            break;
            return localMagicPath;
        }
    }

    private static String c(String paramString, Attributes paramAttributes) {
        int j = paramAttributes.getLength();
        int i = 0;
        while (i < j) {
            if (paramAttributes.getLocalName(i).equals(paramString)) {
                return paramAttributes.getValue(i);
            }
            i += 1;
        }
        return null;
    }

    private static a d(String paramString, Attributes paramAttributes) {
        int j = paramAttributes.getLength();
        int i = 0;
        while (i < j) {
            if (paramAttributes.getLocalName(i).equals(paramString)) {
                return b(paramAttributes.getValue(i));
            }
            i += 1;
        }
        return null;
    }

    private static class a {
        private ArrayList<Float> a;
        private int b;

        public a(ArrayList<Float> paramArrayList, int paramInt) {
            this.a = paramArrayList;
            this.b = paramInt;
        }
    }

    private static class b
            extends DefaultHandler {
        ArrayList<c> a;
        float b = a.a;
        float c;
        float d;
        private boolean e = false;

        private b(ArrayList<c> paramArrayList) {
            this.a = paramArrayList;
        }

        private Float a(String paramString, Attributes paramAttributes) {
            return a(paramString, paramAttributes, null);
        }

        private Float a(String paramString, Attributes paramAttributes, float paramFloat) {
            paramAttributes = a.a(paramString, paramAttributes);
            if (paramAttributes == null) {
                return null;
            }
            if (paramAttributes.endsWith("px")) {
                return Float.valueOf(Float.parseFloat(paramAttributes.substring(0, paramAttributes.length() - 2)));
            }
            if (paramAttributes.endsWith("pt")) {
                return Float.valueOf(Float.valueOf(paramAttributes.substring(0, paramAttributes.length() - 2)).floatValue() * paramFloat / 72.0F);
            }
            if (paramAttributes.endsWith("pc")) {
                return Float.valueOf(Float.valueOf(paramAttributes.substring(0, paramAttributes.length() - 2)).floatValue() * paramFloat / 6.0F);
            }
            if (paramAttributes.endsWith("cm")) {
                return Float.valueOf(Float.valueOf(paramAttributes.substring(0, paramAttributes.length() - 2)).floatValue() * paramFloat / 2.54F);
            }
            if (paramAttributes.endsWith("mm")) {
                return Float.valueOf(Float.valueOf(paramAttributes.substring(0, paramAttributes.length() - 2)).floatValue() * paramFloat / 254.0F);
            }
            if (paramAttributes.endsWith("in")) {
                return Float.valueOf(Float.valueOf(paramAttributes.substring(0, paramAttributes.length() - 2)).floatValue() * paramFloat);
            }
            if (paramAttributes.endsWith("%")) {
                paramAttributes = Float.valueOf(paramAttributes.substring(0, paramAttributes.length() - 1));
                if ((paramString.indexOf("x") >= 0) || (paramString.equals("width"))) {
                    paramFloat = this.c / 100.0F;
                }
                for (; ; ) {
                    return Float.valueOf(paramFloat * paramAttributes.floatValue());
                    if ((paramString.indexOf("y") >= 0) || (paramString.equals("height"))) {
                        paramFloat = this.d / 100.0F;
                    } else {
                        paramFloat = (this.c + this.d) / 2.0F;
                    }
                }
            }
            return Float.valueOf(paramAttributes);
        }

        private Float a(String paramString, Attributes paramAttributes, Float paramFloat) {
            paramString = a(paramString, paramAttributes, this.b);
            if (paramString == null) {
                return paramFloat;
            }
            return paramString;
        }

        public void a(float paramFloat) {
            this.b = paramFloat;
        }

        public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        }

        public void endDocument() {
        }

        public void endElement(String paramString1, String paramString2, String paramString3) {
        }

        public void startDocument() {
        }

        public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) {
            paramString1 = a.a("id", paramAttributes);
            if (paramString2.equals("svg")) {
                this.c = a("width", paramAttributes).floatValue();
                this.d = a("height", paramAttributes).floatValue();
            }
            do {
                do {
                    do {
                        Object localObject;
                        Float localFloat1;
                        do {
                            do {
                                return;
                                if ((!this.e) && (paramString2.equals("rect"))) {
                                    paramString2 = new MagicPath();
                                    localObject = a("x", paramAttributes, Float.valueOf(0.0F));
                                    localFloat1 = a("y", paramAttributes, Float.valueOf(0.0F));
                                    Float localFloat2 = a("width", paramAttributes);
                                    Float localFloat3 = a("height", paramAttributes);
                                    paramString3 = a("rx", paramAttributes, Float.valueOf(0.0F));
                                    paramAttributes = a("ry", paramAttributes, Float.valueOf(0.0F));
                                    localObject = new RectF(((Float) localObject).floatValue(), localFloat1.floatValue(), ((Float) localObject).floatValue() + localFloat2.floatValue(), localFloat1.floatValue() + localFloat3.floatValue());
                                    if ((paramString3.floatValue() <= 0.0F) && (paramAttributes.floatValue() <= 0.0F)) {
                                        paramString2.a((RectF) localObject, MagicPath.Direction.CW);
                                    }
                                    for (; ; ) {
                                        paramString3 = new c();
                                        paramString3.a(paramString2);
                                        paramString3.a(paramString1);
                                        this.a.add(paramString3);
                                        return;
                                        paramString2.a((RectF) localObject, paramString3.floatValue(), paramAttributes.floatValue(), MagicPath.Direction.CW);
                                    }
                                }
                                if ((!this.e) && (paramString2.equals("line"))) {
                                    paramString2 = new MagicPath();
                                    paramString3 = a("x1", paramAttributes);
                                    localObject = a("x2", paramAttributes);
                                    localFloat1 = a("y1", paramAttributes);
                                    paramAttributes = a("y2", paramAttributes);
                                    paramString2.a(MagicPath.PathType.MOVE_TO, new PointF(paramString3.floatValue(), localFloat1.floatValue()));
                                    paramString2.a(MagicPath.PathType.LINE_TO, new PointF(((Float) localObject).floatValue(), paramAttributes.floatValue()));
                                    paramString3 = new c();
                                    paramString3.a(paramString2);
                                    paramString3.a(paramString1);
                                    this.a.add(paramString3);
                                    return;
                                }
                                if ((this.e) || (!paramString2.equals("circle"))) {
                                    break;
                                }
                                paramString2 = a("cx", paramAttributes);
                                paramString3 = a("cy", paramAttributes);
                                localObject = a("r", paramAttributes);
                            } while ((paramString2 == null) || (paramString3 == null) || (localObject == null));
                            paramAttributes = new MagicPath();
                            paramAttributes.a(paramString2.floatValue(), paramString3.floatValue(), ((Float) localObject).floatValue(), MagicPath.Direction.CW);
                            paramString2 = new c();
                            paramString2.a(paramAttributes);
                            paramString2.a(paramString1);
                            this.a.add(paramString2);
                            return;
                            if ((this.e) || (!paramString2.equals("ellipse"))) {
                                break;
                            }
                            paramString2 = a("cx", paramAttributes);
                            paramString3 = a("cy", paramAttributes);
                            localObject = a("rx", paramAttributes);
                            localFloat1 = a("ry", paramAttributes);
                        }
                        while ((paramString2 == null) || (paramString3 == null) || (localObject == null) || (localFloat1 == null));
                        paramAttributes = new MagicPath();
                        paramAttributes.b(new RectF(paramString2.floatValue() - ((Float) localObject).floatValue(), paramString3.floatValue() - localFloat1.floatValue(), paramString2.floatValue() + ((Float) localObject).floatValue(), paramString3.floatValue() + localFloat1.floatValue()), MagicPath.Direction.CW);
                        paramString2 = new c();
                        paramString2.a(paramAttributes);
                        paramString2.a(paramString1);
                        this.a.add(paramString2);
                        return;
                        if ((this.e) || ((!paramString2.equals("polygon")) && (!paramString2.equals("polyline")))) {
                            break;
                        }
                        paramAttributes = a.b("points", paramAttributes);
                    } while (paramAttributes == null);
                    paramString3 = new MagicPath();
                    paramAttributes = a.a.a(paramAttributes);
                } while (paramAttributes.size() <= 1);
                paramString3.a(MagicPath.PathType.MOVE_TO, new PointF(((Float) paramAttributes.get(0)).floatValue(), ((Float) paramAttributes.get(1)).floatValue()));
                int i = 2;
                while (i < paramAttributes.size()) {
                    float f1 = ((Float) paramAttributes.get(i)).floatValue();
                    float f2 = ((Float) paramAttributes.get(i + 1)).floatValue();
                    paramString3.a(MagicPath.PathType.LINE_TO, new PointF(f1, f2));
                    i += 2;
                }
                if (paramString2.equals("polygon")) {
                    paramString3.a(MagicPath.PathType.CLOSE);
                }
                paramString2 = new c();
                paramString2.a(paramString3);
                paramString2.a(paramString1);
                this.a.add(paramString2);
                return;
            } while ((this.e) || (!paramString2.equals("path")));
            paramString2 = a.a(a.a("d", paramAttributes));
            paramString3 = new c();
            paramString3.a(paramString2);
            paramString3.a(paramString1);
            this.a.add(paramString3);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/svgutils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */