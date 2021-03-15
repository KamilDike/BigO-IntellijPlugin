package com.github.kamildike.bigointellijplugin.model;

import com.intellij.psi.PsiElement;



public class ComplexityFinder {

    public static Notation find(PsiElement method, PsiElement parent) {
        String[] parentList = parent.getText().split("\\s");
        String newParent = parentList[2].trim();
        String[] methodList = method.getText().split("\\s|\\(");
        String newMethod = methodList[2].trim();
        Notation complex = null;
        switch (newParent) {
            case "ArrayList":
                switch (newMethod){
                    case "add":
                    case "get":
                        complex = Notation.O1;
                        break;
                    case "remove":
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
                    case "size":
                    case "poll":
                    case "peak":
                    case "offer":
                        complex = Notation.O1;
                        break;
                    case "remove":
                    case "contains":
                    case "get":
                        complex = Notation.ON;
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
                    case "poll":
                        complex = Notation.OLOGN;
                        break;
                    case "peak":
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
                    case "size":
                    case "poll":
                    case "peak":
                        complex = Notation.O1;
                        break;
                    default:
                        break;
                }
                break;
            case "HashSet":
            case "LinkedHashSet":
                switch (newMethod){
                    case "add":
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
