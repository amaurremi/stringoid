package javassist.tools.web;

import java.io.IOException;
import java.net.Socket;

class ServiceThread
        extends Thread {
    Socket sock;
    Webserver web;

    public ServiceThread(Webserver paramWebserver, Socket paramSocket) {
        this.web = paramWebserver;
        this.sock = paramSocket;
    }

    public void run() {
        try {
            this.web.process(this.sock);
            return;
        } catch (IOException localIOException) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/web/ServiceThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */