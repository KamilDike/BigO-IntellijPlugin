package com.github.kamildike.bigointellijplugin.model;

import com.intellij.psi.PsiElement;

import java.util.HashSet;

public class MethodComparator {

    private static MethodComparator  instance;
    HashSet<String> recognizedMethods;

    private MethodComparator(){
        recognizedMethods = new HashSet<>();
        recognizedMethods.add("");
        recognizedMethods.add("");
        recognizedMethods.add("");
        recognizedMethods.add("");
        recognizedMethods.add("");
        recognizedMethods.add("");
        recognizedMethods.add("");
    }

    public boolean isRecognizedClass(PsiElement parent){
        String parentText = parent.getText();
        for (String classIdent : recognizedMethods) {
            if (parentText.contains(classIdent)) {
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

