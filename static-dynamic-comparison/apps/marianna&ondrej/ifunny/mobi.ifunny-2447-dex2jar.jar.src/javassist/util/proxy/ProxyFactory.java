package javassist.util.proxy;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

import javassist.CannotCompileException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.StackMapTable.Writer;

public class ProxyFactory {
    private static final String DEFAULT_INTERCEPTOR = "default_interceptor";
    private static final String FILTER_SIGNATURE_FIELD = "_filter_signature";
    private static final String FILTER_SIGNATURE_TYPE = "[B";
    private static final String HANDLER = "handler";
    private static final String HANDLER_GETTER = "getHandler";
    private static final String HANDLER_GETTER_KEY = "getHandler:()";
    private static final String HANDLER_GETTER_TYPE;
    private static final String HANDLER_SETTER = "setHandler";
    private static final String HANDLER_SETTER_TYPE;
    private static final String HANDLER_TYPE;
    private static final String HOLDER = "_methods_";
    private static final String HOLDER_TYPE = "[Ljava/lang/reflect/Method;";
    private static final String NULL_INTERCEPTOR_HOLDER = "javassist.util.proxy.RuntimeSupport";
    private static final Class OBJECT_TYPE = Object.class;
    private static final String SERIAL_VERSION_UID_FIELD = "serialVersionUID";
    private static final String SERIAL_VERSION_UID_TYPE = "J";
    private static final int SERIAL_VERSION_UID_VALUE = -1;
    public static ProxyFactory.ClassLoaderProvider classLoaderProvider = new ProxyFactory
    .1();
    private static int counter = 0;
    private static char[] hexDigits;
    private static WeakHashMap proxyCache;
    private static Comparator sorter = new ProxyFactory
    .2();
    public static volatile boolean useCache;
    public static volatile boolean useWriteReplace;
    private String basename;
    private String classname;
    private boolean factoryUseCache = useCache;
    private boolean factoryWriteReplace = useWriteReplace;
    private MethodHandler handler = null;
    private boolean hasGetHandler = false;
    private Class[] interfaces = null;
    private MethodFilter methodFilter = null;
    private byte[] signature = null;
    private List signatureMethods = null;
    private Class superClass = null;
    private String superName;
    private Class thisClass = null;
    public String writeDirectory = null;

    static {
        HANDLER_TYPE = 'L' + MethodHandler.class.getName().replace('.', '/') + ';';
        HANDLER_SETTER_TYPE = "(" + HANDLER_TYPE + ")V";
        HANDLER_GETTER_TYPE = "()" + HANDLER_TYPE;
        useCache = true;
        useWriteReplace = true;
        proxyCache = new WeakHashMap();
        hexDigits = new char[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    private static void addGetter(String paramString, ClassFile paramClassFile, ConstPool paramConstPool) {
        MethodInfo localMethodInfo = new MethodInfo(paramConstPool, "getHandler", HANDLER_GETTER_TYPE);
        localMethodInfo.setAccessFlags(1);
        paramConstPool = new Bytecode(paramConstPool, 1, 1);
        paramConstPool.addAload(0);
        paramConstPool.addGetfield(paramString, "handler", HANDLER_TYPE);
        paramConstPool.addOpcode(176);
        localMethodInfo.setCodeAttribute(paramConstPool.toCodeAttribute());
        paramClassFile.addMethod(localMethodInfo);
    }

    private static int addLoad(Bytecode paramBytecode, int paramInt, Class paramClass) {
        if (paramClass.isPrimitive()) {
            if (paramClass == Long.TYPE) {
                paramBytecode.addLload(paramInt);
                return 2;
            }
            if (paramClass == Float.TYPE) {
                paramBytecode.addFload(paramInt);
            }
        }
        for (; ; ) {
            return 1;
            if (paramClass == Double.TYPE) {
                paramBytecode.addDload(paramInt);
                return 2;
            }
            paramBytecode.addIload(paramInt);
            continue;
            paramBytecode.addAload(paramInt);
        }
    }

    private static int addLoadParameters(Bytecode paramBytecode, Class[] paramArrayOfClass, int paramInt) {
        int i = 0;
        int k = paramArrayOfClass.length;
        int j = 0;
        while (i < k) {
            j += addLoad(paramBytecode, j + paramInt, paramArrayOfClass[i]);
            i += 1;
        }
        return j;
    }

    private static void addMethodsHolder(ClassFile paramClassFile, ConstPool paramConstPool, String paramString, int paramInt) {
        Object localObject = new FieldInfo(paramConstPool, "_methods_", "[Ljava/lang/reflect/Method;");
        ((FieldInfo) localObject).setAccessFlags(10);
        paramClassFile.addField((FieldInfo) localObject);
        localObject = new MethodInfo(paramConstPool, "<clinit>", "()V");
        ((MethodInfo) localObject).setAccessFlags(8);
        paramConstPool = new Bytecode(paramConstPool, 0, 0);
        paramConstPool.addIconst(paramInt * 2);
        paramConstPool.addAnewarray("java.lang.reflect.Method");
        paramConstPool.addPutstatic(paramString, "_methods_", "[Ljava/lang/reflect/Method;");
        paramConstPool.addLconst(-1L);
        paramConstPool.addPutstatic(paramString, "serialVersionUID", "J");
        paramConstPool.addOpcode(177);
        ((MethodInfo) localObject).setCodeAttribute(paramConstPool.toCodeAttribute());
        paramClassFile.addMethod((MethodInfo) localObject);
    }

    private static int addReturn(Bytecode paramBytecode, Class paramClass) {
        if (paramClass.isPrimitive()) {
            if (paramClass == Long.TYPE) {
                paramBytecode.addOpcode(173);
                return 2;
            }
            if (paramClass == Float.TYPE) {
                paramBytecode.addOpcode(174);
            }
        }
        for (; ; ) {
            return 1;
            if (paramClass == Double.TYPE) {
                paramBytecode.addOpcode(175);
                return 2;
            }
            if (paramClass == Void.TYPE) {
                paramBytecode.addOpcode(177);
                return 0;
            }
            paramBytecode.addOpcode(172);
            continue;
            paramBytecode.addOpcode(176);
        }
    }

    private static void addSetter(String paramString, ClassFile paramClassFile, ConstPool paramConstPool) {
        MethodInfo localMethodInfo = new MethodInfo(paramConstPool, "setHandler", HANDLER_SETTER_TYPE);
        localMethodInfo.setAccessFlags(1);
        paramConstPool = new Bytecode(paramConstPool, 2, 2);
        paramConstPool.addAload(0);
        paramConstPool.addAload(1);
        paramConstPool.addPutfield(paramString, "handler", HANDLER_TYPE);
        paramConstPool.addOpcode(177);
        localMethodInfo.setCodeAttribute(paramConstPool.toCodeAttribute());
        paramClassFile.addMethod(localMethodInfo);
    }

    private static void addUnwrapper(Bytecode paramBytecode, Class paramClass) {
        if (paramClass.isPrimitive()) {
            if (paramClass == Void.TYPE) {
                paramBytecode.addOpcode(87);
                return;
            }
            int i = FactoryHelper.typeIndex(paramClass);
            paramClass = FactoryHelper.wrapperTypes[i];
            paramBytecode.addCheckcast(paramClass);
            paramBytecode.addInvokevirtual(paramClass, FactoryHelper.unwarpMethods[i], FactoryHelper.unwrapDesc[i]);
            return;
        }
        paramBytecode.addCheckcast(paramClass.getName());
    }

    private void allocateClassName() {
        this.classname = makeProxyName(this.basename);
    }

    private static void callFind2Methods(Bytecode paramBytecode, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2) {
        String str = RuntimeSupport.class.getName();
        paramBytecode.addAload(0);
        paramBytecode.addLdc(paramString1);
        if (paramString2 == null) {
            paramBytecode.addOpcode(1);
        }
        for (; ; ) {
            paramBytecode.addIconst(paramInt1);
            paramBytecode.addLdc(paramString3);
            paramBytecode.addAload(paramInt2);
            paramBytecode.addInvokestatic(str, "find2Methods", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;[Ljava/lang/reflect/Method;)V");
            return;
            paramBytecode.addLdc(paramString2);
        }
    }

    private void checkClassAndSuperName() {
        if (this.interfaces == null) {
            this.interfaces = new Class[0];
        }
        String str;
        if (this.superClass == null) {
            this.superClass = OBJECT_TYPE;
            this.superName = this.superClass.getName();
            if (this.interfaces.length == 0) {
                str = this.superName;
            }
        }
        for (this.basename = str; ; this.basename = this.superName) {
            if (!Modifier.isFinal(this.superClass.getModifiers())) {
                break label137;
            }
            throw new RuntimeException(this.superName + " is final");
            str = this.interfaces[0].getName();
            break;
            this.superName = this.superClass.getName();
        }
        label137:
        if (this.basename.startsWith("java.")) {
            this.basename = ("org.javassist.tmp." + this.basename);
        }
    }

    private void computeSignature(MethodFilter paramMethodFilter) {
        makeSortedMethodList();
        int j = this.signatureMethods.size();
        this.signature = new byte[j + 7 >> 3];
        int i = 0;
        while (i < j) {
            Method localMethod = (Method) ((Map.Entry) this.signatureMethods.get(i)).getValue();
            int k = localMethod.getModifiers();
            if ((!Modifier.isFinal(k)) && (!Modifier.isStatic(k)) && (isVisible(k, this.basename, localMethod)) && ((paramMethodFilter == null) || (paramMethodFilter.isHandled(localMethod)))) {
                setBit(this.signature, i);
            }
            i += 1;
        }
    }

    private Class createClass1() {
        ClassLoader localClassLoader;
        if (this.thisClass == null) {
            localClassLoader = getClassLoader();
        }
        synchronized (proxyCache) {
            if (this.factoryUseCache) {
                createClass2(localClassLoader);
                ???=this.thisClass;
                this.thisClass = null;
                return (Class) ???;
            }
            createClass3(localClassLoader);
        }
    }

    private void createClass2(ClassLoader paramClassLoader) {
        String str = getKey(this.superClass, this.interfaces, this.signature, this.factoryWriteReplace);
        HashMap localHashMap = (HashMap) proxyCache.get(paramClassLoader);
        if (localHashMap == null) {
            localHashMap = new HashMap();
            proxyCache.put(paramClassLoader, localHashMap);
        }
        for (; ; ) {
            ProxyFactory.ProxyDetails localProxyDetails = (ProxyFactory.ProxyDetails) localHashMap.get(str);
            if (localProxyDetails != null) {
                this.thisClass = ((Class) localProxyDetails.proxyClass.get());
                if (this.thisClass != null) {
                    return;
                }
            }
            createClass3(paramClassLoader);
            localHashMap.put(str, new ProxyFactory.ProxyDetails(this.signature, this.thisClass, this.factoryWriteReplace));
            return;
        }
    }

    private void createClass3(ClassLoader paramClassLoader) {
        allocateClassName();
        try {
            ClassFile localClassFile = make();
            if (this.writeDirectory != null) {
                FactoryHelper.writeFile(localClassFile, this.writeDirectory);
            }
            this.thisClass = FactoryHelper.toClass(localClassFile, paramClassLoader, getDomain());
            setField("_filter_signature", this.signature);
            if (!this.factoryUseCache) {
                setField("default_interceptor", this.handler);
            }
            return;
        } catch (CannotCompileException paramClassLoader) {
            throw new RuntimeException(paramClassLoader.getMessage(), paramClassLoader);
        }
    }

    private static Object getField(Class paramClass, String paramString) {
        try {
            paramClass = paramClass.getField(paramString);
            paramClass.setAccessible(true);
            paramString = paramClass.get(null);
            paramClass.setAccessible(false);
            return paramString;
        } catch (Exception paramClass) {
            throw new RuntimeException(paramClass);
        }
    }

    static byte[] getFilterSignature(Class paramClass) {
        return (byte[]) getField(paramClass, "_filter_signature");
    }

    public static MethodHandler getHandler(Proxy paramProxy) {
        try {
            Field localField = paramProxy.getClass().getDeclaredField("handler");
            localField.setAccessible(true);
            paramProxy = localField.get(paramProxy);
            localField.setAccessible(false);
            paramProxy = (MethodHandler) paramProxy;
            return paramProxy;
        } catch (Exception paramProxy) {
            throw new RuntimeException(paramProxy);
        }
    }

    private static HashMap getMethods(Class paramClass, Class[] paramArrayOfClass) {
        HashMap localHashMap = new HashMap();
        HashSet localHashSet = new HashSet();
        int i = 0;
        while (i < paramArrayOfClass.length) {
            getMethods(localHashMap, paramArrayOfClass[i], localHashSet);
            i += 1;
        }
        getMethods(localHashMap, paramClass, localHashSet);
        return localHashMap;
    }

    private static void getMethods(HashMap paramHashMap, Class paramClass, Set paramSet) {
        int j = 0;
        if (!paramSet.add(paramClass)) {
        }
        for (; ; ) {
            return;
            Object localObject = paramClass.getInterfaces();
            int i = 0;
            while (i < localObject.length) {
                getMethods(paramHashMap, localObject[i], paramSet);
                i += 1;
            }
            localObject = paramClass.getSuperclass();
            if (localObject != null) {
                getMethods(paramHashMap, (Class) localObject, paramSet);
            }
            paramClass = SecurityActions.getDeclaredMethods(paramClass);
            i = j;
            while (i < paramClass.length) {
                if (!Modifier.isPrivate(paramClass[i].getModifiers())) {
                    paramSet = paramClass[i];
                    paramSet = paramSet.getName() + ':' + RuntimeSupport.makeDescriptor(paramSet.getParameterTypes(), null);
                    localObject = (Method) paramHashMap.put(paramSet, paramClass[i]);
                    if ((localObject != null) && (Modifier.isPublic(((Method) localObject).getModifiers())) && (!Modifier.isPublic(paramClass[i].getModifiers()))) {
                        paramHashMap.put(paramSet, localObject);
                    }
                }
                i += 1;
            }
        }
    }

    private static String getPackageName(String paramString) {
        int i = paramString.lastIndexOf('.');
        if (i < 0) {
            return null;
        }
        return paramString.substring(0, i);
    }

    private void installSignature(byte[] paramArrayOfByte) {
        makeSortedMethodList();
        int i = this.signatureMethods.size();
        if (paramArrayOfByte.length != i + 7 >> 3) {
            throw new RuntimeException("invalid filter signature length for deserialized proxy class");
        }
        this.signature = paramArrayOfByte;
    }

    public static boolean isProxyClass(Class paramClass) {
        return Proxy.class.isAssignableFrom(paramClass);
    }

    private static boolean isVisible(int paramInt, String paramString, Member paramMember) {
        boolean bool2 = true;
        boolean bool1;
        if ((paramInt & 0x2) != 0) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while ((paramInt & 0x5) != 0);
            paramString = getPackageName(paramString);
            paramMember = getPackageName(paramMember.getDeclaringClass().getName());
            if (paramString != null) {
                break;
            }
            bool1 = bool2;
        } while (paramMember == null);
        return false;
        return paramString.equals(paramMember);
    }

    private static String keyToDesc(String paramString, Method paramMethod) {
        return RuntimeSupport.makeDescriptor(paramString.substring(paramString.indexOf(':') + 1), paramMethod.getReturnType());
    }

    private ClassFile make() {
        ClassFile localClassFile = new ClassFile(false, this.classname, this.superName);
        localClassFile.setAccessFlags(1);
        Object localObject2 = this.interfaces;
        Object localObject1;
        if (this.hasGetHandler) {
            localObject1 = Proxy.class;
        }
        for (; ; ) {
            setInterfaces(localClassFile, (Class[]) localObject2, (Class) localObject1);
            localObject1 = localClassFile.getConstPool();
            if (!this.factoryUseCache) {
                localObject2 = new FieldInfo((ConstPool) localObject1, "default_interceptor", HANDLER_TYPE);
                ((FieldInfo) localObject2).setAccessFlags(9);
                localClassFile.addField((FieldInfo) localObject2);
            }
            localObject2 = new FieldInfo((ConstPool) localObject1, "handler", HANDLER_TYPE);
            ((FieldInfo) localObject2).setAccessFlags(2);
            localClassFile.addField((FieldInfo) localObject2);
            localObject2 = new FieldInfo((ConstPool) localObject1, "_filter_signature", "[B");
            ((FieldInfo) localObject2).setAccessFlags(9);
            localClassFile.addField((FieldInfo) localObject2);
            localObject2 = new FieldInfo((ConstPool) localObject1, "serialVersionUID", "J");
            ((FieldInfo) localObject2).setAccessFlags(25);
            localClassFile.addField((FieldInfo) localObject2);
            makeConstructors(this.classname, localClassFile, (ConstPool) localObject1, this.classname);
            int i = overrideMethods(localClassFile, (ConstPool) localObject1, this.classname);
            addMethodsHolder(localClassFile, (ConstPool) localObject1, this.classname, i);
            addSetter(this.classname, localClassFile, (ConstPool) localObject1);
            if (!this.hasGetHandler) {
                addGetter(this.classname, localClassFile, (ConstPool) localObject1);
            }
            if (this.factoryWriteReplace) {
            }
            try {
                localClassFile.addMethod(makeWriteReplace((ConstPool) localObject1));
                this.thisClass = null;
                return localClassFile;
                localObject1 = ProxyObject.class;
            } catch (DuplicateMemberException localDuplicateMemberException) {
                for (; ; ) {
                }
            }
        }
    }

    private static MethodInfo makeConstructor(String paramString, Constructor paramConstructor, ConstPool paramConstPool, Class paramClass, boolean paramBoolean) {
        String str = RuntimeSupport.makeDescriptor(paramConstructor.getParameterTypes(), Void.TYPE);
        MethodInfo localMethodInfo = new MethodInfo(paramConstPool, "<init>", str);
        localMethodInfo.setAccessFlags(1);
        setThrows(localMethodInfo, paramConstPool, paramConstructor.getExceptionTypes());
        Bytecode localBytecode = new Bytecode(paramConstPool, 0, 0);
        if (paramBoolean) {
            localBytecode.addAload(0);
            localBytecode.addGetstatic(paramString, "default_interceptor", HANDLER_TYPE);
            localBytecode.addPutfield(paramString, "handler", HANDLER_TYPE);
            localBytecode.addGetstatic(paramString, "default_interceptor", HANDLER_TYPE);
            localBytecode.addOpcode(199);
            localBytecode.addIndex(10);
        }
        localBytecode.addAload(0);
        localBytecode.addGetstatic("javassist.util.proxy.RuntimeSupport", "default_interceptor", HANDLER_TYPE);
        localBytecode.addPutfield(paramString, "handler", HANDLER_TYPE);
        int i = localBytecode.currentPc();
        localBytecode.addAload(0);
        int j = addLoadParameters(localBytecode, paramConstructor.getParameterTypes(), 1);
        localBytecode.addInvokespecial(paramClass.getName(), "<init>", str);
        localBytecode.addOpcode(177);
        localBytecode.setMaxLocals(j + 1);
        paramString = localBytecode.toCodeAttribute();
        localMethodInfo.setCodeAttribute(paramString);
        paramConstructor = new StackMapTable.Writer(32);
        paramConstructor.sameFrame(i);
        paramString.setAttribute(paramConstructor.toStackMapTable(paramConstPool));
        return localMethodInfo;
    }

    private void makeConstructors(String paramString1, ClassFile paramClassFile, ConstPool paramConstPool, String paramString2) {
        int i = 0;
        paramString2 = SecurityActions.getDeclaredConstructors(this.superClass);
        boolean bool;
        if (!this.factoryUseCache) {
            bool = true;
        }
        while (i < paramString2.length) {
            Member localMember = paramString2[i];
            int j = localMember.getModifiers();
            if ((!Modifier.isFinal(j)) && (!Modifier.isPrivate(j)) && (isVisible(j, this.basename, localMember))) {
                paramClassFile.addMethod(makeConstructor(paramString1, localMember, paramConstPool, this.superClass, bool));
            }
            i += 1;
            continue;
            bool = false;
        }
    }

    private static MethodInfo makeDelegator(Method paramMethod, String paramString1, ConstPool paramConstPool, Class paramClass, String paramString2) {
        paramString2 = new MethodInfo(paramConstPool, paramString2, paramString1);
        paramString2.setAccessFlags(paramMethod.getModifiers() & 0xFAD9 | 0x11);
        setThrows(paramString2, paramConstPool, paramMethod);
        paramConstPool = new Bytecode(paramConstPool, 0, 0);
        paramConstPool.addAload(0);
        int i = addLoadParameters(paramConstPool, paramMethod.getParameterTypes(), 1);
        paramConstPool.addInvokespecial(paramClass.getName(), paramMethod.getName(), paramString1);
        addReturn(paramConstPool, paramMethod.getReturnType());
        paramConstPool.setMaxLocals(i + 1);
        paramString2.setCodeAttribute(paramConstPool.toCodeAttribute());
        return paramString2;
    }

    private static MethodInfo makeForwarder(String paramString1, Method paramMethod, String paramString2, ConstPool paramConstPool, Class paramClass, String paramString3, int paramInt) {
        paramClass = new MethodInfo(paramConstPool, paramMethod.getName(), paramString2);
        paramClass.setAccessFlags(paramMethod.getModifiers() & 0xFADF | 0x10);
        setThrows(paramClass, paramConstPool, paramMethod);
        int j = Descriptor.paramSize(paramString2);
        paramConstPool = new Bytecode(paramConstPool, 0, j + 2);
        int i = paramInt * 2;
        j += 1;
        paramConstPool.addGetstatic(paramString1, "_methods_", "[Ljava/lang/reflect/Method;");
        paramConstPool.addAstore(j);
        callFind2Methods(paramConstPool, paramMethod.getName(), paramString3, i, paramString2, j);
        paramConstPool.addAload(0);
        paramConstPool.addGetfield(paramString1, "handler", HANDLER_TYPE);
        paramConstPool.addAload(0);
        paramConstPool.addAload(j);
        paramConstPool.addIconst(i);
        paramConstPool.addOpcode(50);
        paramConstPool.addAload(j);
        paramConstPool.addIconst(paramInt * 2 + 1);
        paramConstPool.addOpcode(50);
        makeParameterList(paramConstPool, paramMethod.getParameterTypes());
        paramConstPool.addInvokeinterface(MethodHandler.class.getName(), "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", 5);
        paramString1 = paramMethod.getReturnType();
        addUnwrapper(paramConstPool, paramString1);
        addReturn(paramConstPool, paramString1);
        paramClass.setCodeAttribute(paramConstPool.toCodeAttribute());
        return paramClass;
    }

    private static void makeParameterList(Bytecode paramBytecode, Class[] paramArrayOfClass) {
        int k = paramArrayOfClass.length;
        paramBytecode.addIconst(k);
        paramBytecode.addAnewarray("java/lang/Object");
        int i = 1;
        int j = 0;
        if (j < k) {
            paramBytecode.addOpcode(89);
            paramBytecode.addIconst(j);
            Class localClass = paramArrayOfClass[j];
            if (localClass.isPrimitive()) {
                i = makeWrapper(paramBytecode, localClass, i);
            }
            for (; ; ) {
                paramBytecode.addOpcode(83);
                j += 1;
                break;
                paramBytecode.addAload(i);
                i += 1;
            }
        }
    }

    private static String makeProxyName(String paramString) {
        try {
            paramString = new StringBuilder().append(paramString).append("_$$_javassist_");
            int i = counter;
            counter = i + 1;
            paramString = i;
            return paramString;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    private void makeSortedMethodList() {
        checkClassAndSuperName();
        HashMap localHashMap = getMethods(this.superClass, this.interfaces);
        this.signatureMethods = new ArrayList(localHashMap.entrySet());
        if (localHashMap.get("getHandler:()") != null) {
        }
        for (boolean bool = true; ; bool = false) {
            this.hasGetHandler = bool;
            Collections.sort(this.signatureMethods, sorter);
            return;
        }
    }

    private static String makeUniqueName(String paramString, List paramList) {
        if (makeUniqueName0(paramString, paramList.iterator())) {
            return paramString;
        }
        int i = 100;
        while (i < 999) {
            String str = paramString + i;
            if (makeUniqueName0(str, paramList.iterator())) {
                return str;
            }
            i += 1;
        }
        throw new RuntimeException("cannot make a unique method name");
    }

    private static boolean makeUniqueName0(String paramString, Iterator paramIterator) {
        while (paramIterator.hasNext()) {
            if (((String) ((Map.Entry) paramIterator.next()).getKey()).startsWith(paramString)) {
                return false;
            }
        }
        return true;
    }

    private static int makeWrapper(Bytecode paramBytecode, Class paramClass, int paramInt) {
        int i = FactoryHelper.typeIndex(paramClass);
        String str = FactoryHelper.wrapperTypes[i];
        paramBytecode.addNew(str);
        paramBytecode.addOpcode(89);
        addLoad(paramBytecode, paramInt, paramClass);
        paramBytecode.addInvokespecial(str, "<init>", FactoryHelper.wrapperDesc[i]);
        return FactoryHelper.dataSize[i] + paramInt;
    }

    private static MethodInfo makeWriteReplace(ConstPool paramConstPool) {
        MethodInfo localMethodInfo = new MethodInfo(paramConstPool, "writeReplace", "()Ljava/lang/Object;");
        ExceptionsAttribute localExceptionsAttribute = new ExceptionsAttribute(paramConstPool);
        localExceptionsAttribute.setExceptions(new String[]{"java.io.ObjectStreamException"});
        localMethodInfo.setExceptionsAttribute(localExceptionsAttribute);
        paramConstPool = new Bytecode(paramConstPool, 0, 1);
        paramConstPool.addAload(0);
        paramConstPool.addInvokestatic("javassist.util.proxy.RuntimeSupport", "makeSerializedProxy", "(Ljava/lang/Object;)Ljavassist/util/proxy/SerializedProxy;");
        paramConstPool.addOpcode(176);
        localMethodInfo.setCodeAttribute(paramConstPool.toCodeAttribute());
        return localMethodInfo;
    }

    private void override(String paramString1, Method paramMethod, String paramString2, int paramInt, String paramString3, ClassFile paramClassFile, ConstPool paramConstPool) {
        Class localClass = paramMethod.getDeclaringClass();
        paramString2 = paramString2 + paramInt + paramMethod.getName();
        if (Modifier.isAbstract(paramMethod.getModifiers())) {
            paramString2 = null;
        }
        for (; ; ) {
            paramClassFile.addMethod(makeForwarder(paramString1, paramMethod, paramString3, paramConstPool, localClass, paramString2, paramInt));
            return;
            MethodInfo localMethodInfo = makeDelegator(paramMethod, paramString3, paramConstPool, localClass, paramString2);
            localMethodInfo.setAccessFlags(localMethodInfo.getAccessFlags() & 0xFFFFFFBF);
            paramClassFile.addMethod(localMethodInfo);
        }
    }

    private int overrideMethods(ClassFile paramClassFile, ConstPool paramConstPool, String paramString) {
        String str1 = makeUniqueName("_d", this.signatureMethods);
        Iterator localIterator = this.signatureMethods.iterator();
        int i = 0;
        while (localIterator.hasNext()) {
            Object localObject = (Map.Entry) localIterator.next();
            String str2 = (String) ((Map.Entry) localObject).getKey();
            localObject = (Method) ((Map.Entry) localObject).getValue();
            ((Method) localObject).getModifiers();
            if (testBit(this.signature, i)) {
                override(paramString, (Method) localObject, str1, i, keyToDesc(str2, (Method) localObject), paramClassFile, paramConstPool);
            }
            i += 1;
        }
        return i;
    }

    private void setBit(byte[] paramArrayOfByte, int paramInt) {
        int i = paramInt >> 3;
        if (i < paramArrayOfByte.length) {
            paramArrayOfByte[i] = ((byte) (1 << (paramInt & 0x7) | paramArrayOfByte[i]));
        }
    }

    private void setField(String paramString, Object paramObject) {
        if ((this.thisClass != null) && (paramObject != null)) {
        }
        try {
            paramString = this.thisClass.getField(paramString);
            SecurityActions.setAccessible(paramString, true);
            paramString.set(null, paramObject);
            SecurityActions.setAccessible(paramString, false);
            return;
        } catch (Exception paramString) {
            throw new RuntimeException(paramString);
        }
    }

    private static void setInterfaces(ClassFile paramClassFile, Class[] paramArrayOfClass, Class paramClass) {
        int i = 0;
        String str = paramClass.getName();
        if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0)) {
        }
        for (paramArrayOfClass = new String[]{str}; ; paramArrayOfClass = paramClass) {
            paramClassFile.setInterfaces(paramArrayOfClass);
            return;
            paramClass = new String[paramArrayOfClass.length + 1];
            while (i < paramArrayOfClass.length) {
                paramClass[i] = paramArrayOfClass[i].getName();
                i += 1;
            }
            paramClass[paramArrayOfClass.length] = str;
        }
    }

    private static void setThrows(MethodInfo paramMethodInfo, ConstPool paramConstPool, Method paramMethod) {
        setThrows(paramMethodInfo, paramConstPool, paramMethod.getExceptionTypes());
    }

    private static void setThrows(MethodInfo paramMethodInfo, ConstPool paramConstPool, Class[] paramArrayOfClass) {
        if (paramArrayOfClass.length == 0) {
            return;
        }
        String[] arrayOfString = new String[paramArrayOfClass.length];
        int i = 0;
        while (i < paramArrayOfClass.length) {
            arrayOfString[i] = paramArrayOfClass[i].getName();
            i += 1;
        }
        paramConstPool = new ExceptionsAttribute(paramConstPool);
        paramConstPool.setExceptions(arrayOfString);
        paramMethodInfo.setExceptionsAttribute(paramConstPool);
    }

    private boolean testBit(byte[] paramArrayOfByte, int paramInt) {
        boolean bool = true;
        int i = paramInt >> 3;
        if (i > paramArrayOfByte.length) {
            return false;
        }
        if ((paramArrayOfByte[i] & 1 << (paramInt & 0x7)) != 0) {
        }
        for (; ; ) {
            return bool;
            bool = false;
        }
    }

    public Object create(Class[] paramArrayOfClass, Object[] paramArrayOfObject) {
        return createClass().getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
    }

    public Object create(Class[] paramArrayOfClass, Object[] paramArrayOfObject, MethodHandler paramMethodHandler) {
        paramArrayOfClass = create(paramArrayOfClass, paramArrayOfObject);
        ((Proxy) paramArrayOfClass).setHandler(paramMethodHandler);
        return paramArrayOfClass;
    }

    public Class createClass() {
        if (this.signature == null) {
            computeSignature(this.methodFilter);
        }
        return createClass1();
    }

    public Class createClass(MethodFilter paramMethodFilter) {
        computeSignature(paramMethodFilter);
        return createClass1();
    }

    Class createClass(byte[] paramArrayOfByte) {
        installSignature(paramArrayOfByte);
        return createClass1();
    }

    protected ClassLoader getClassLoader() {
        return classLoaderProvider.get(this);
    }

    protected ClassLoader getClassLoader0() {
        Object localObject1 = null;
        Object localObject2;
        if ((this.superClass != null) && (!this.superClass.getName().equals("java.lang.Object"))) {
            localObject2 = this.superClass.getClassLoader();
        }
        for (; ; ) {
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject2 = getClass().getClassLoader();
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject2 = Thread.currentThread().getContextClassLoader();
                    localObject1 = localObject2;
                    if (localObject2 == null) {
                        localObject1 = ClassLoader.getSystemClassLoader();
                    }
                }
            }
            return (ClassLoader) localObject1;
            localObject2 = localObject1;
            if (this.interfaces != null) {
                localObject2 = localObject1;
                if (this.interfaces.length > 0) {
                    localObject2 = this.interfaces[0].getClassLoader();
                }
            }
        }
    }

    protected ProtectionDomain getDomain() {
        Class localClass;
        if ((this.superClass != null) && (!this.superClass.getName().equals("java.lang.Object"))) {
            localClass = this.superClass;
        }
        for (; ; ) {
            return localClass.getProtectionDomain();
            if ((this.interfaces != null) && (this.interfaces.length > 0)) {
                localClass = this.interfaces[0];
            } else {
                localClass = getClass();
            }
        }
    }

    public Class[] getInterfaces() {
        return this.interfaces;
    }

    public String getKey(Class paramClass, Class[] paramArrayOfClass, byte[] paramArrayOfByte, boolean paramBoolean) {
        int k = 0;
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramClass != null) {
            localStringBuffer.append(paramClass.getName());
        }
        localStringBuffer.append(":");
        int j = 0;
        int i;
        for (; ; ) {
            i = k;
            if (j >= paramArrayOfClass.length) {
                break;
            }
            localStringBuffer.append(paramArrayOfClass[j].getName());
            localStringBuffer.append(":");
            j += 1;
        }
        while (i < paramArrayOfByte.length) {
            j = paramArrayOfByte[i];
            localStringBuffer.append(hexDigits[(j & 0xF)]);
            localStringBuffer.append(hexDigits[(j >> 4 & 0xF)]);
            i += 1;
        }
        if (paramBoolean) {
            localStringBuffer.append(":w");
        }
        return localStringBuffer.toString();
    }

    public Class getSuperclass() {
        return this.superClass;
    }

    public boolean isUseCache() {
        return this.factoryUseCache;
    }

    public boolean isUseWriteReplace() {
        return this.factoryWriteReplace;
    }

    public void setFilter(MethodFilter paramMethodFilter) {
        this.methodFilter = paramMethodFilter;
        this.signature = null;
    }

    public void setHandler(MethodHandler paramMethodHandler) {
        if ((this.factoryUseCache) && (paramMethodHandler != null)) {
            this.factoryUseCache = false;
            this.thisClass = null;
        }
        this.handler = paramMethodHandler;
        setField("default_interceptor", this.handler);
    }

    public void setInterfaces(Class[] paramArrayOfClass) {
        this.interfaces = paramArrayOfClass;
        this.signature = null;
    }

    public void setSuperclass(Class paramClass) {
        this.superClass = paramClass;
        this.signature = null;
    }

    public void setUseCache(boolean paramBoolean) {
        if ((this.handler != null) && (paramBoolean)) {
            throw new RuntimeException("caching cannot be enabled if the factory default interceptor has been set");
        }
        this.factoryUseCache = paramBoolean;
    }

    public void setUseWriteReplace(boolean paramBoolean) {
        this.factoryWriteReplace = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/ProxyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */