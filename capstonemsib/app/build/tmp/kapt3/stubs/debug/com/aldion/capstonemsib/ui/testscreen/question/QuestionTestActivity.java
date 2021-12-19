package com.aldion.capstonemsib.ui.testscreen.question;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J \u0010\u001e\u001a\u00020\u00132\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/aldion/capstonemsib/ui/testscreen/question/QuestionTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "_binding", "Lcom/aldion/capstonemsib/databinding/ActivityQuestionTestBinding;", "binding", "getBinding", "()Lcom/aldion/capstonemsib/databinding/ActivityQuestionTestBinding;", "mCurrentPosition", "", "mQuestionList", "Ljava/util/ArrayList;", "Lcom/aldion/capstonemsib/data/entity/Statement;", "Lkotlin/collections/ArrayList;", "mSelectedOptionPosition", "viewModel", "Lcom/aldion/capstonemsib/ui/testscreen/question/QuestionTestViewModel;", "defaultOptionsView", "", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "selectedOptionView", "tv", "Landroid/widget/TextView;", "selectedOptionNum", "setQuestion", "app_debug"})
public final class QuestionTestActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding _binding;
    private int mCurrentPosition = 1;
    private java.util.ArrayList<com.aldion.capstonemsib.data.entity.Statement> mQuestionList;
    private int mSelectedOptionPosition = 0;
    private com.aldion.capstonemsib.ui.testscreen.question.QuestionTestViewModel viewModel;
    
    public QuestionTestActivity() {
        super();
    }
    
    private final com.aldion.capstonemsib.databinding.ActivityQuestionTestBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setQuestion(java.util.ArrayList<com.aldion.capstonemsib.data.entity.Statement> mQuestionList) {
    }
    
    private final void defaultOptionsView() {
    }
    
    private final void selectedOptionView(android.widget.TextView tv, int selectedOptionNum) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
}