package com.github.kamildike.bigointellijplugin;

import com.github.kamildike.bigointellijplugin.model.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


class TimeComplexity extends AnAction {


    @Override
    public void update(AnActionEvent e) {
        try {
            PsiElement method = e.getData(LangDataKeys.PSI_ELEMENT);
            PsiElement parent = Objects.requireNonNull(method).getContext();
            if (ClassComparator.getInstance().isRecognizedClass(Objects.requireNonNull(parent))) {
                e.getPresentation().setEnabledAndVisible(
                        MethodComparator.getInstance().
                                isRecognizedMethod(method));
            }else{
                e.getPresentation().setEnabledAndVisible(false);
            }
        } catch (NullPointerException ignored) {
            e.getPresentation().setEnabledAndVisible(false);
        }
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = editor.getProject();

        PsiElement method = e.getData(LangDataKeys.PSI_ELEMENT);
        //Not null because method and parent are checked in update(AnActionEvent)
        PsiElement parent = Objects.requireNonNull(e.getData(LangDataKeys.PSI_ELEMENT)).getContext();

        Notation notation = ComplexityFinder.find(Objects.requireNonNull(method), Objects.requireNonNull(parent));

        Notifier.notify(project, notation);

    }
}


