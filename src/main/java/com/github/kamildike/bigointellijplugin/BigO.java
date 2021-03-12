package com.github.kamildike.bigointellijplugin;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;

class BigOn extends AnAction  {


    @Override
    public void update(AnActionEvent e) {

        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);

        boolean menuAllowed = false;
        if(project != null
                && editor != null){
            menuAllowed = !editor.getCaretModel().getAllCarets().isEmpty();
        };
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final EditorActionManager actionManager = EditorActionManager.getInstance();

        final EditorActionHandler actionHandler = actionManager.getActionHandler(IdeActions.ACTION_EDITOR_MOVE_CARET_LEFT);
        actionHandler.execute(editor, editor.getCaretModel().getPrimaryCaret(), e.getDataContext());


        final Document document = editor.getDocument();
        final Project project = editor.getProject();

        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        int start = primaryCaret.getLeadSelectionOffset();
        int end = primaryCaret.getSelectionEnd();
        int startV = primaryCaret.getVisualLineStart();
        int endV = primaryCaret.getVisualLineEnd();


        TextRange textRange = new TextRange(start,end);
        TextRange textRange2 = new TextRange(startV,endV);
        String text = document.getText(textRange);
        String text1 = document.getText(textRange2);


        String text3 = e.getData(LangDataKeys.PSI_ELEMENT).getText();
        String text4 = e.getData(LangDataKeys.PSI_ELEMENT).getContext().getText();



        Runnable runnable = () -> document.insertString(0, "editor_basics\n");
        WriteCommandAction.runWriteCommandAction(project, runnable);
    }
}
