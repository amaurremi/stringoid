package javassist.bytecode;

import java.io.PrintWriter;
import java.util.List;

import javassist.Modifier;

public class ClassFilePrinter {
    public static void print(ClassFile paramClassFile) {
        print(paramClassFile, new PrintWriter(System.out, true));
    }

    public static void print(ClassFile paramClassFile, PrintWriter paramPrintWriter) {
        int j = 0;
        int i = AccessFlag.toModifier(paramClassFile.getAccessFlags() & 0xFFFFFFDF);
        paramPrintWriter.println("major: " + paramClassFile.major + ", minor: " + paramClassFile.minor + " modifiers: " + Integer.toHexString(paramClassFile.getAccessFlags()));
        paramPrintWriter.println(Modifier.toString(i) + " class " + paramClassFile.getName() + " extends " + paramClassFile.getSuperclass());
        Object localObject1 = paramClassFile.getInterfaces();
        if ((localObject1 != null) && (localObject1.length > 0)) {
            paramPrintWriter.print("    implements ");
            paramPrintWriter.print(localObject1[0]);
            i = 1;
            while (i < localObject1.length) {
                paramPrintWriter.print(", " + localObject1[i]);
                i += 1;
            }
            paramPrintWriter.println();
        }
        paramPrintWriter.println();
        localObject1 = paramClassFile.getFields();
        int k = ((List) localObject1).size();
        i = 0;
        Object localObject2;
        while (i < k) {
            localObject2 = (FieldInfo) ((List) localObject1).get(i);
            int m = ((FieldInfo) localObject2).getAccessFlags();
            paramPrintWriter.println(Modifier.toString(AccessFlag.toModifier(m)) + " " + ((FieldInfo) localObject2).getName() + "\t" + ((FieldInfo) localObject2).getDescriptor());
            printAttributes(((FieldInfo) localObject2).getAttributes(), paramPrintWriter, 'f');
            i += 1;
        }
        paramPrintWriter.println();
        localObject1 = paramClassFile.getMethods();
        k = ((List) localObject1).size();
        i = j;
        while (i < k) {
            localObject2 = (MethodInfo) ((List) localObject1).get(i);
            j = ((MethodInfo) localObject2).getAccessFlags();
            paramPrintWriter.println(Modifier.toString(AccessFlag.toModifier(j)) + " " + ((MethodInfo) localObject2).getName() + "\t" + ((MethodInfo) localObject2).getDescriptor());
            printAttributes(((MethodInfo) localObject2).getAttributes(), paramPrintWriter, 'm');
            paramPrintWriter.println();
            i += 1;
        }
        paramPrintWriter.println();
        printAttributes(paramClassFile.getAttributes(), paramPrintWriter, 'c');
    }

    static void printAttributes(List paramList, PrintWriter paramPrintWriter, char paramChar) {
        if (paramList == null) {
            return;
        }
        int j = paramList.size();
        int i = 0;
        label15:
        Object localObject;
        if (i < j) {
            localObject = (AttributeInfo) paramList.get(i);
            if (!(localObject instanceof CodeAttribute)) {
                break label181;
            }
            CodeAttribute localCodeAttribute = (CodeAttribute) localObject;
            paramPrintWriter.println("attribute: " + ((AttributeInfo) localObject).getName() + ": " + localObject.getClass().getName());
            paramPrintWriter.println("max stack " + localCodeAttribute.getMaxStack() + ", max locals " + localCodeAttribute.getMaxLocals() + ", " + localCodeAttribute.getExceptionTable().size() + " catch blocks");
            paramPrintWriter.println("<code attribute begin>");
            printAttributes(localCodeAttribute.getAttributes(), paramPrintWriter, paramChar);
            paramPrintWriter.println("<code attribute end>");
        }
        for (; ; ) {
            i += 1;
            break label15;
            break;
            label181:
            if ((localObject instanceof AnnotationsAttribute)) {
                paramPrintWriter.println("annnotation: " + localObject.toString());
            } else if ((localObject instanceof ParameterAnnotationsAttribute)) {
                paramPrintWriter.println("parameter annnotations: " + localObject.toString());
            } else if ((localObject instanceof StackMapTable)) {
                paramPrintWriter.println("<stack map table begin>");
                StackMapTable.Printer.print((StackMapTable) localObject, paramPrintWriter);
                paramPrintWriter.println("<stack map table end>");
            } else if ((localObject instanceof StackMap)) {
                paramPrintWriter.println("<stack map begin>");
                ((StackMap) localObject).print(paramPrintWriter);
                paramPrintWriter.println("<stack map end>");
            } else {
                String str;
                if ((localObject instanceof SignatureAttribute)) {
                    localObject = ((SignatureAttribute) localObject).getSignature();
                    paramPrintWriter.println("signature: " + (String) localObject);
                    if (paramChar == 'c') {
                    }
                    for (; ; ) {
                        try {
                            localObject = SignatureAttribute.toClassSignature((String) localObject).toString();
                            paramPrintWriter.println("           " + (String) localObject);
                        } catch (BadBytecode localBadBytecode) {
                            paramPrintWriter.println("           syntax error");
                        }
                        break;
                        if (paramChar == 'm') {
                            str = SignatureAttribute.toMethodSignature(localBadBytecode).toString();
                        } else {
                            str = SignatureAttribute.toFieldSignature(str).toString();
                        }
                    }
                }
                paramPrintWriter.println("attribute: " + str.getName() + " (" + str.get().length + " byte): " + str.getClass().getName());
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/ClassFilePrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */