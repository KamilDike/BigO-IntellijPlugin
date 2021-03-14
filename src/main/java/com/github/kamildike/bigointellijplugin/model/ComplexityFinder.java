package com.github.kamildike.bigointellijplugin.model;

import com.intellij.psi.PsiElement;

import java.util.ArrayList;

public class ComplexityFinder {

    public static Notation find(PsiElement method, PsiElement parent) {
        String[] parentList = parent.getText().split("\\s");
        String newParent = parentList[2].strip();
        String[] methodList = method.getText().split("\\s|\\(");
        String newMethod = methodList[2].strip();
        Notation complex = null;
        switch (newParent) {
            case "ArrayList":
                switch (newMethod){
                    case "add":
                        complex = Notation.O1;
                        break;
                    case "remove":
                        complex = Notation.ON;
                        break;
                    case "get":
                        complex = Notation.O1;
                        break;
                    case "contains":
                        complex = Notation.ON;
                        break;
                    default:
                        break;
                }
                break;
            case "LinkedList":
                switch (newMethod){
                    case "add":
                        complex = Notation.O1;
                        break;
                    case "remove":
                        complex = Notation.ON;
                        break;
                    case "get":
                        complex = Notation.ON;
                        break;
                    case "contains":
                        complex = Notation.ON;
                        break;
                    case "offer":
                        complex = Notation.O1;
                        break;
                    case "peak":
                        complex = Notation.O1;
                        break;
                    case "poll":
                        complex = Notation.O1;
                        break;
                    case "size()":
                        complex = Notation.O1;
                        break;
                    default:
                        break;
                }
                break;
//            case "Vector":
//                switch (method.getText()){
//                    case "add":
//                        complex = Notation.O2N;
//                        break;
//                    case "remove":
//                        complex = Notation.O1;
//                        break;
//                    case "get":
//                        complex = Notation.O1;
//                        break;
//                    case "contains":
//                        complex = Notation.O1;
//                        break;
//                    default:
//                        break;
//                }
//                break;
            case "PriorityQueue":
                switch (newMethod){
                    case "offer":
                        complex = Notation.OLOGN;
                        break;
                    case "peak":
                        complex = Notation.O1;
                        break;
                    case "poll":
                        complex = Notation.OLOGN;
                        break;
                    case "size":
                        complex = Notation.O1;
                        break;
                    default:
                        break;
                }
                break;
            case "ArrayDeque":
                switch (newMethod){
                    case "offer":
                        complex = Notation.O1;
                        break;
                    case "peak":
                        complex = Notation.O1;
                        break;
                    case "poll":
                        complex = Notation.O1;
                        break;
                    case "size":
                        complex = Notation.O1;
                        break;
                    default:
                        break;
                }
                break;
            case "HashSet":
                switch (newMethod){
                    case "add":
                        complex = Notation.O1;
                        break;
                    case "contains":
                        complex = Notation.O1;
                        break;
                    default:
                        break;
                }
                break;
            case "LinkedHashSet":
                switch (newMethod){
                    case "add":
                        complex = Notation.O1;
                        break;
                    case "contains":
                        complex = Notation.O1;
                        break;
                    default:
                        break;
                }
                break;
            case "TreeSet":
                switch (newMethod){
                    case "add":
                        complex = Notation.OLOGN;
                        break;
                    case "contains":
                        complex = Notation.OLOGN;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return complex;
    }

}
