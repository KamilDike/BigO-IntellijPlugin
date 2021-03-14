package com.github.kamildike.bigointellijplugin;

import com.github.kamildike.bigointellijplugin.model.ClassComparator;
import com.github.kamildike.bigointellijplugin.model.Notifier;
import com.github.kamildike.bigointellijplugin.model.MethodComparator;
import com.github.kamildike.bigointellijplugin.model.Notation;
import com.intellij.openapi.actionSystem.*;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.project.Project;

import com.intellij.psi.PsiElement;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


class BigOn extends AnAction {


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
            // Do podpunktu 3.
            //PsiElement method = e.getData(LangDataKeys.PSI_ELEMENT);
            //PsiElement parent = Objects.requireNonNull(method).getContext();
            // elementy method i parent są notNull
            // parent należy do listy klas okreslonych w klasie ClassComparator
            // method należy do listy method określonych w klasie MethodComparator
            // method.getText() <- kod metody
            // parent.getText() <- kod clasy

        
        Notation notation = null;
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = editor.getProject();
        final Document document = editor.getDocument();

        final EditorActionManager actionManager = EditorActionManager.getInstance();

        final EditorActionHandler actionHandler = actionManager.getActionHandler(IdeActions.ACTION_EDITOR_MOVE_CARET_LEFT);
        actionHandler.execute(editor, editor.getCaretModel().getPrimaryCaret(), e.getDataContext());


        PsiElement method = e.getData(LangDataKeys.PSI_ELEMENT);
        PsiElement parent = e.getData(LangDataKeys.PSI_ELEMENT).getContext();


        notation = Notation.ON;

        Notifier.notify(project, notation);

    }
}


