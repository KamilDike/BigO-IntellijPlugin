package com.github.kamildike.bigointellijplugin;

import com.github.kamildike.bigointellijplugin.model.ClassComparator;
import com.github.kamildike.bigointellijplugin.model.MethodComparator;
import com.github.kamildike.bigointellijplugin.model.Notation;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;

import com.intellij.psi.PsiElement;

import org.jetbrains.annotations.NotNull;


class BigOn extends AnAction {


    @Override
    public void update(AnActionEvent e) {
        try {
            PsiElement method = e.getData(LangDataKeys.PSI_ELEMENT);
            //assert method != null;
            PsiElement parent = method.getContext();
            //assert parent != null;
            if (ClassComparator.getInstance().isRecognizedClass(parent)) {
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

        Notation notation = null;
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = editor.getProject();
        final Document document = editor.getDocument();

        final EditorActionManager actionManager = EditorActionManager.getInstance();

        final EditorActionHandler actionHandler = actionManager.getActionHandler(IdeActions.ACTION_EDITOR_MOVE_CARET_LEFT);
        actionHandler.execute(editor, editor.getCaretModel().getPrimaryCaret(), e.getDataContext());


        PsiElement method = e.getData(LangDataKeys.PSI_ELEMENT);
        PsiElement parent = e.getData(LangDataKeys.PSI_ELEMENT).getContext();


        if (method.getText().equals("public int indexOf(java.lang.Object o) { /* compiled code */ }")) {
            if (parent.getText().contains("public class ArrayList <E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {\n" +
                    "    private static final long serialVersionUID = 8683452581122892189L;\n" +
                    "    private static final int DEFAULT_CAPACITY = 10;\n"
            )) {
                notation = Notation.ON;
            }

        }


        if (notation != null) {
            JBPopupFactory.getInstance().
                    createMessage(Notation.getLabel(notation)).showInBestPositionFor(editor);

            Notation finalNotation = notation;
            Runnable runnable = () -> document.insertString(editor.getCaretModel().getPrimaryCaret().getVisualLineStart()
                    , "// has time complexity: " + Notation.getLabel(finalNotation) + "\n");
            WriteCommandAction.runWriteCommandAction(project, runnable);
        }
    }
}
