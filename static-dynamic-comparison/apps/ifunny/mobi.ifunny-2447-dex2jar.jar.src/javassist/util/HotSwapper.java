package javassist.util;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.Connector.Argument;
import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.EventRequestManager;
import com.sun.jdi.request.MethodEntryRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HotSwapper {
    private static final String HOST_NAME = "localhost";
    private static final String TRIGGER_NAME = Trigger.class.getName();
    private VirtualMachine jvm = null;
    private Map newClassFiles = null;
    private MethodEntryRequest request = null;
    private Trigger trigger = new Trigger();

    public HotSwapper(int paramInt) {
        this(Integer.toString(paramInt));
    }

    public HotSwapper(String paramString) {
        AttachingConnector localAttachingConnector = (AttachingConnector) findConnector("com.sun.jdi.SocketAttach");
        Map localMap = localAttachingConnector.defaultArguments();
        ((Connector.Argument) localMap.get("hostname")).setValue("localhost");
        ((Connector.Argument) localMap.get("port")).setValue(paramString);
        this.jvm = localAttachingConnector.attach(localMap);
        this.request = methodEntryRequests(this.jvm.eventRequestManager(), TRIGGER_NAME);
    }

    private void deleteEventRequest(EventRequestManager paramEventRequestManager, MethodEntryRequest paramMethodEntryRequest) {
        paramEventRequestManager.deleteEventRequest(paramMethodEntryRequest);
    }

    private Connector findConnector(String paramString) {
        Iterator localIterator = Bootstrap.virtualMachineManager().allConnectors().iterator();
        while (localIterator.hasNext()) {
            Connector localConnector = (Connector) localIterator.next();
            if (localConnector.name().equals(paramString)) {
                return localConnector;
            }
        }
        throw new IOException("Not found: " + paramString);
    }

    private static MethodEntryRequest methodEntryRequests(EventRequestManager paramEventRequestManager, String paramString) {
        paramEventRequestManager = paramEventRequestManager.createMethodEntryRequest();
        paramEventRequestManager.addClassFilter(paramString);
        paramEventRequestManager.setSuspendPolicy(1);
        return paramEventRequestManager;
    }

    private void reload2(Map paramMap, String paramString) {
        synchronized (this.trigger) {
            startDaemon();
            this.newClassFiles = paramMap;
            this.request.enable();
            this.trigger.doSwap();
            this.request.disable();
            if (this.newClassFiles != null) {
                this.newClassFiles = null;
                throw new RuntimeException("failed to reload: " + paramString);
            }
        }
    }

    private void startDaemon() {
        new HotSwapper .1 (this).start();
    }

    private ReferenceType toRefType(String paramString) {
        List localList = this.jvm.classesByName(paramString);
        if ((localList == null) || (localList.isEmpty())) {
            throw new RuntimeException("no such class: " + paramString);
        }
        return (ReferenceType) localList.get(0);
    }

    void hotswap() {
        Map localMap = this.newClassFiles;
        this.jvm.redefineClasses(localMap);
        this.newClassFiles = null;
    }

    public void reload(String paramString, byte[] paramArrayOfByte) {
        ReferenceType localReferenceType = toRefType(paramString);
        HashMap localHashMap = new HashMap();
        localHashMap.put(localReferenceType, paramArrayOfByte);
        reload2(localHashMap, paramString);
    }

    public void reload(Map paramMap) {
        Iterator localIterator = paramMap.entrySet().iterator();
        HashMap localHashMap = new HashMap();
        paramMap = null;
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            paramMap = (String) localEntry.getKey();
            localHashMap.put(toRefType(paramMap), localEntry.getValue());
        }
        if (paramMap != null) {
            reload2(localHashMap, paramMap + " etc.");
        }
    }

    EventSet waitEvent() {
        return this.jvm.eventQueue().remove();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/HotSwapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */