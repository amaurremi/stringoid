package javassist.tools.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.Translator;

public class Webserver {
    private static final byte[] endofline = {13, 10};
    private static final int typeClass = 2;
    private static final int typeGif = 3;
    private static final int typeHtml = 1;
    private static final int typeJpeg = 4;
    private static final int typeText = 5;
    private ClassPool classPool;
    public String debugDir = null;
    public String htmlfileBase = null;
    private ServerSocket socket;
    protected Translator translator;

    public Webserver(int paramInt) {
        this.socket = new ServerSocket(paramInt);
        this.classPool = null;
        this.translator = null;
    }

    public Webserver(String paramString) {
        this(Integer.parseInt(paramString));
    }

    private void checkFilename(String paramString, int paramInt) {
        int i = 0;
        while (i < paramInt) {
            char c = paramString.charAt(i);
            if ((!Character.isJavaIdentifierPart(c)) && (c != '.') && (c != '/')) {
                throw new BadHttpRequest();
            }
            i += 1;
        }
        if (paramString.indexOf("..") >= 0) {
            throw new BadHttpRequest();
        }
    }

    private boolean letUsersSendClassfile(OutputStream paramOutputStream, String paramString, int paramInt) {
        if (this.classPool == null) {
            return false;
        }
        paramString = paramString.substring(0, paramInt - 6).replace('/', '.');
        try {
            if (this.translator != null) {
                this.translator.onLoad(this.classPool, paramString);
            }
            paramString = this.classPool.get(paramString);
            byte[] arrayOfByte = paramString.toBytecode();
            if (this.debugDir != null) {
                paramString.writeFile(this.debugDir);
            }
            sendHeader(paramOutputStream, arrayOfByte.length, 2);
            paramOutputStream.write(arrayOfByte);
            return true;
        } catch (Exception paramOutputStream) {
            throw new BadHttpRequest(paramOutputStream);
        }
    }

    public static void main(String[] paramArrayOfString) {
        if (paramArrayOfString.length == 1) {
            new Webserver(paramArrayOfString[0]).run();
            return;
        }
        System.err.println("Usage: java javassist.tools.web.Webserver <port number>");
    }

    private String readLine(InputStream paramInputStream) {
        StringBuffer localStringBuffer = new StringBuffer();
        for (; ; ) {
            int i = paramInputStream.read();
            if ((i < 0) || (i == 13)) {
                break;
            }
            localStringBuffer.append((char) i);
        }
        paramInputStream.read();
        return localStringBuffer.toString();
    }

    private void replyError(OutputStream paramOutputStream, BadHttpRequest paramBadHttpRequest) {
        logging2("bad request: " + paramBadHttpRequest.toString());
        paramOutputStream.write("HTTP/1.0 400 Bad Request".getBytes());
        paramOutputStream.write(endofline);
        paramOutputStream.write(endofline);
        paramOutputStream.write("<H1>Bad Request</H1>".getBytes());
    }

    private void sendHeader(OutputStream paramOutputStream, long paramLong, int paramInt) {
        paramOutputStream.write("HTTP/1.0 200 OK".getBytes());
        paramOutputStream.write(endofline);
        paramOutputStream.write("Content-Length: ".getBytes());
        paramOutputStream.write(Long.toString(paramLong).getBytes());
        paramOutputStream.write(endofline);
        if (paramInt == 2) {
            paramOutputStream.write("Content-Type: application/octet-stream".getBytes());
        }
        for (; ; ) {
            paramOutputStream.write(endofline);
            paramOutputStream.write(endofline);
            return;
            if (paramInt == 1) {
                paramOutputStream.write("Content-Type: text/html".getBytes());
            } else if (paramInt == 3) {
                paramOutputStream.write("Content-Type: image/gif".getBytes());
            } else if (paramInt == 4) {
                paramOutputStream.write("Content-Type: image/jpg".getBytes());
            } else if (paramInt == 5) {
                paramOutputStream.write("Content-Type: text/plain".getBytes());
            }
        }
    }

    private int skipLine(InputStream paramInputStream) {
        int i = 0;
        for (; ; ) {
            int j = paramInputStream.read();
            if ((j < 0) || (j == 13)) {
                break;
            }
            i += 1;
        }
        paramInputStream.read();
        return i;
    }

    public void addTranslator(ClassPool paramClassPool, Translator paramTranslator) {
        this.classPool = paramClassPool;
        this.translator = paramTranslator;
        paramTranslator.start(this.classPool);
    }

    public void doReply(InputStream paramInputStream, OutputStream paramOutputStream, String paramString) {
        int i = 5;
        Object localObject;
        if (paramString.startsWith("GET /")) {
            localObject = paramString.substring(5, paramString.indexOf(' ', 5));
            if (!((String) localObject).endsWith(".class")) {
                break label73;
            }
            i = 2;
        }
        int j;
        for (; ; ) {
            j = ((String) localObject).length();
            if ((i != 2) || (!letUsersSendClassfile(paramOutputStream, (String) localObject, j))) {
                break;
            }
            return;
            throw new BadHttpRequest();
            label73:
            if ((((String) localObject).endsWith(".html")) || (((String) localObject).endsWith(".htm"))) {
                i = 1;
            } else if (((String) localObject).endsWith(".gif")) {
                i = 3;
            } else if (((String) localObject).endsWith(".jpg")) {
                i = 4;
            }
        }
        checkFilename((String) localObject, j);
        if (this.htmlfileBase != null) {
        }
        for (paramInputStream = this.htmlfileBase + (String) localObject; ; paramInputStream = (InputStream) localObject) {
            paramString = paramInputStream;
            if (File.separatorChar != '/') {
                paramString = paramInputStream.replace('/', File.separatorChar);
            }
            paramInputStream = new File(paramString);
            if (paramInputStream.canRead()) {
                sendHeader(paramOutputStream, paramInputStream.length(), i);
                paramInputStream = new FileInputStream(paramInputStream);
                paramString = new byte['က'];
                for (; ; ) {
                    i = paramInputStream.read(paramString);
                    if (i <= 0) {
                        paramInputStream.close();
                        return;
                    }
                    paramOutputStream.write(paramString, 0, i);
                }
            }
            if (i == 2) {
                paramInputStream = getClass().getResourceAsStream("/" + (String) localObject);
                if (paramInputStream != null) {
                    paramString = new ByteArrayOutputStream();
                    localObject = new byte['က'];
                    for (; ; ) {
                        i = paramInputStream.read((byte[]) localObject);
                        if (i <= 0) {
                            paramString = paramString.toByteArray();
                            sendHeader(paramOutputStream, paramString.length, 2);
                            paramOutputStream.write(paramString);
                            paramInputStream.close();
                            return;
                        }
                        paramString.write((byte[]) localObject, 0, i);
                    }
                }
            }
            throw new BadHttpRequest();
        }
    }

    public void end() {
        this.socket.close();
    }

    public void logging(String paramString) {
        System.out.println(paramString);
    }

    public void logging(String paramString1, String paramString2) {
        System.out.print(paramString1);
        System.out.print(" ");
        System.out.println(paramString2);
    }

    public void logging(String paramString1, String paramString2, String paramString3) {
        System.out.print(paramString1);
        System.out.print(" ");
        System.out.print(paramString2);
        System.out.print(" ");
        System.out.println(paramString3);
    }

    public void logging2(String paramString) {
        System.out.print("    ");
        System.out.println(paramString);
    }

    final void process(Socket paramSocket) {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramSocket.getInputStream());
        String str = readLine(localBufferedInputStream);
        logging(paramSocket.getInetAddress().getHostName(), new Date().toString(), str);
        while (skipLine(localBufferedInputStream) > 0) {
        }
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramSocket.getOutputStream());
        try {
            doReply(localBufferedInputStream, localBufferedOutputStream, str);
            localBufferedOutputStream.flush();
            localBufferedInputStream.close();
            localBufferedOutputStream.close();
            paramSocket.close();
            return;
        } catch (BadHttpRequest localBadHttpRequest) {
            for (; ; ) {
                replyError(localBufferedOutputStream, localBadHttpRequest);
            }
        }
    }

    public void run() {
        System.err.println("ready to service...");
        try {
            for (; ; ) {
                new ServiceThread(this, this.socket.accept()).start();
            }
        } catch (IOException localIOException) {
            logging(localIOException.toString());
        }
    }

    public void setClassPool(ClassPool paramClassPool) {
        this.classPool = paramClassPool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/web/Webserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */