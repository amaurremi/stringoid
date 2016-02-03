package com.quoord.xmlrpc;

import java.io.IOException;
import java.io.Writer;

public class XmlWriter
        extends AbstractXmlWriter {
    static char[] indent = {13, 10, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    int indentLevel = 0;
    int noIndent = Integer.MAX_VALUE;
    boolean pending = false;
    protected Writer writer;

    public XmlWriter(Writer paramWriter) {
        this.writer = paramWriter;
    }

    public void attribute(String paramString1, String paramString2)
            throws IOException {
        if (!this.pending) {
            throw new RuntimeException("can write attr only immediately after a startTag");
        }
        this.writer.write(32);
        this.writer.write(paramString1);
        this.writer.write("=\"");
        this.writer.write(Xml.encode(paramString2, 1));
        this.writer.write(34);
        if ((paramString1.equals("xml:space")) && (paramString2.equals("preserve"))) {
            this.noIndent = this.indentLevel;
        }
    }

    protected void checkPending()
            throws IOException {
        if (this.pending) {
            this.writer.write(62);
            this.pending = false;
        }
    }

    public void close()
            throws IOException {
        flush();
        this.writer.close();
    }

    public void endTag()
            throws IOException {
        this.indentLevel -= 1;
        if (this.pending) {
            this.writer.write(" />");
            this.pending = false;
        }
        for (; ; ) {
            if (this.indentLevel + 1 == this.noIndent) {
                this.noIndent = Integer.MAX_VALUE;
            }
            this.current = this.current.prev;
            if (this.current != null) {
                break;
            }
            throw new RuntimeException("too many closing tags!");
            if (this.indentLevel + 1 < this.noIndent) {
                writeIndent();
            }
            this.writer.write("</");
            this.writer.write(this.current.tag);
            this.writer.write(">");
        }
    }

    public void flush()
            throws IOException {
        checkPending();
        this.writer.flush();
    }

    protected void startTag(PrefixMap paramPrefixMap, String paramString)
            throws IOException {
        this.current = new State(this.current, paramPrefixMap, paramString);
        checkPending();
        if (this.indentLevel < this.noIndent) {
            writeIndent();
        }
        this.indentLevel += 1;
        this.writer.write(60);
        this.writer.write(paramString);
        this.pending = true;
    }

    public void write(char paramChar)
            throws IOException {
        checkPending();
        if (this.noIndent > this.indentLevel) {
            this.noIndent = this.indentLevel;
        }
        switch (paramChar) {
            default:
                this.writer.write(paramChar);
                return;
            case '<':
                this.writer.write("&lt;");
                return;
            case '>':
                this.writer.write("&gt;");
                return;
        }
        this.writer.write("&amp;");
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
            throws IOException {
        checkPending();
        if (this.noIndent > this.indentLevel) {
            this.noIndent = this.indentLevel;
        }
        int i = paramInt1 + paramInt2;
        do {
            paramInt2 = paramInt1;
            for (; ; ) {
                if ((paramInt2 >= i) || ("<>&".indexOf(paramArrayOfChar[paramInt2]) != -1)) {
                    this.writer.write(paramArrayOfChar, paramInt1, paramInt2 - paramInt1);
                    if (paramInt2 != i) {
                        break;
                    }
                    return;
                }
                paramInt2 += 1;
            }
            write(paramArrayOfChar[paramInt2]);
            paramInt2 += 1;
            paramInt1 = paramInt2;
        } while (paramInt2 < i);
    }

    public void writeIndent()
            throws IOException {
        int j = this.indentLevel + 2;
        int i;
        if (j < 2) {
            i = 2;
        }
        for (; ; ) {
            checkPending();
            this.writer.write(indent, 0, i);
            return;
            i = j;
            if (j > indent.length) {
                i = indent.length;
            }
        }
    }

    public void writeLegacy(int paramInt, String paramString)
            throws IOException {
        checkPending();
        switch (paramInt) {
            default:
                return;
            case 1:
                this.writer.write("<!--");
                this.writer.write(paramString);
                this.writer.write("-->");
                return;
            case 2:
                this.writer.write("<!DOCTYPE ");
                this.writer.write(paramString);
                this.writer.write(">");
                return;
        }
        this.writer.write("<?");
        this.writer.write(paramString);
        this.writer.write("?>");
    }

    public void writeRaw(String paramString)
            throws IOException {
        checkPending();
        this.writer.write(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/xmlrpc/XmlWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */