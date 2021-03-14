package com.github.kamildike.bigointellijplugin.model;

import com.intellij.psi.PsiElement;

import java.util.HashSet;

public class MethodComparator {

    private static MethodComparator  instance;
    HashSet<String> recognizedMethods;

    private MethodComparator(){
        recognizedMethods = new HashSet<>();
        //array
        recognizedMethods.add("public boolean add(E e)");
        recognizedMethods.add("public boolean contains(java.lang.Object o)");
        recognizedMethods.add("public E get(int index)");
        recognizedMethods.add("public E remove(int index)");
        //queue
        recognizedMethods.add("public boolean offer(E e)");
        recognizedMethods.add("public E peek()");
        recognizedMethods.add("public E poll()");
        recognizedMethods.add("public int size()");
        //set
        //add,contains

        /* add here recognised methods */
    }

    public boolean isRecognizedMethod(PsiElement parent){
        String parentText = parent.getText();
        for (String classIdent : recognizedMethods) {
            if (parentText.startsWith(classIdent)) {
                return true;
            }
        }
        return false;
    }

    public static MethodComparator getInstance(){
        if(instance==null){
            instance = new MethodComparator();
        }
        return instance;
    }

}

