package com.github.kamildike.bigointellijplugin.model;

import com.intellij.psi.PsiElement;

import java.util.HashSet;

public class ClassComparator {

    private static ClassComparator  instance;
    HashSet<String> recognizedClasses;

    private ClassComparator(){
        recognizedClasses = new HashSet<>();
        recognizedClasses.add("public class TreeSet <E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable {\n" +
                "    private transient java.util.NavigableMap<E,java.lang.Object> m;\n" +
                "    private static final java.lang.Object PRESENT;\n" +
                "    private static final long serialVersionUID = -2479143000061671589L;");
        recognizedClasses.add("public class HashSet <E> extends java.util.AbstractSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable {\n" +
                "    static final long serialVersionUID = -5024744406713321676L;\n" +
                "    private transient java.util.HashMap<E,java.lang.Object> map;\n" +
                "    private static final java.lang.Object PRESENT;");
        recognizedClasses.add("public class ArrayDeque <E> extends java.util.AbstractCollection<E> implements java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {\n" +
                "    transient java.lang.Object[] elements;\n" +
                "    transient int head;\n" +
                "    transient int tail;\n" +
                "    private static final int MAX_ARRAY_SIZE = 2147483639;\n" +
                "    private static final long serialVersionUID = 2340985798034038923L;;");
        recognizedClasses.add("public class PriorityQueue <E> extends java.util.AbstractQueue<E> implements java.io.Serializable {\n" +
                "    private static final long serialVersionUID = -7720805057305804111L;\n" +
                "    private static final int DEFAULT_INITIAL_CAPACITY = 11;\n" +
                "    transient java.lang.Object[] queue;\n" +
                "    int size;\n" +
                "    private final java.util.Comparator<? super E> comparator;\n" +
                "    transient int modCount;");
        recognizedClasses.add("public class Vector <E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {\n" +
                "    protected java.lang.Object[] elementData;\n" +
                "    protected int elementCount;\n" +
                "    protected int capacityIncrement;\n" +
                "    private static final long serialVersionUID = -2767605614048989439L;");
        recognizedClasses.add("public class LinkedList <E> extends java.util.AbstractSequentialList<E> implements java.util.List<E>, java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {\n" +
                "    transient int size;\n" +
                "    transient java.util.LinkedList.Node<E> first;\n" +
                "    transient java.util.LinkedList.Node<E> last;\n" +
                "    private static final long serialVersionUID = 876323262645176354L;\n");
        recognizedClasses.add("public class ArrayList <E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {\n" +
                "    private static final long serialVersionUID = 8683452581122892189L;\n" +
                "    private static final int DEFAULT_CAPACITY = 10;\n" +
                "    private static final java.lang.Object[] EMPTY_ELEMENTDATA;\n" +
                "    private static final java.lang.Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA;\n" +
                "    transient java.lang.Object[] elementData; \n" +
                "}");
    }

    public boolean isRecognizedClass(PsiElement parent){
        String parentText = parent.getText();
        for (String classIdent : recognizedClasses) {
            if (parentText.contains(classIdent)) {
                return true;
            }
        }
        return false;
    }

    public static ClassComparator getInstance(){
        if(instance==null){
           instance = new ClassComparator();
        }
        return instance;
    }

}
