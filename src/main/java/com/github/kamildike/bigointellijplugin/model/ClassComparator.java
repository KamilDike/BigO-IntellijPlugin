package com.github.kamildike.bigointellijplugin.model;

import com.intellij.psi.PsiElement;

import java.util.HashSet;

public class ClassComparator {

    private static ClassComparator  instance;
    HashSet<String> recognizedClasses;

    private ClassComparator(){
        recognizedClasses = new HashSet<>();
        recognizedClasses.add("public class TreeSet <E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable");
        recognizedClasses.add("public class HashSet <E> extends java.util.AbstractSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable");
        recognizedClasses.add("public class ArrayDeque <E> extends java.util.AbstractCollection<E> implements java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable");
        recognizedClasses.add("public class PriorityQueue <E> extends java.util.AbstractQueue<E> implements java.io.Serializable");
        recognizedClasses.add("public class Vector <E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable");
        recognizedClasses.add("public class LinkedList <E> extends java.util.AbstractSequentialList<E> implements java.util.List<E>, java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable");
        recognizedClasses.add("public class ArrayList <E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable");
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
