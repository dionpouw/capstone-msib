package com.aldion.capstonemsib.ui.consultation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/aldion/capstonemsib/ui/consultation/PsychologistAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/aldion/capstonemsib/ui/consultation/PsychologistAdapter$ListViewHolder;", "data", "", "Lcom/aldion/capstonemsib/data/entity/Psychologist;", "listener", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "contextAdapter", "Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ListViewHolder", "app_debug"})
public final class PsychologistAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.aldion.capstonemsib.ui.consultation.PsychologistAdapter.ListViewHolder> {
    private java.util.List<com.aldion.capstonemsib.data.entity.Psychologist> data;
    private final kotlin.jvm.functions.Function1<com.aldion.capstonemsib.data.entity.Psychologist, kotlin.Unit> listener = null;
    private android.content.Context contextAdapter;
    
    public PsychologistAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.aldion.capstonemsib.data.entity.Psychologist> data, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.aldion.capstonemsib.data.entity.Psychologist, kotlin.Unit> listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.aldion.capstonemsib.ui.consultation.PsychologistAdapter.ListViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.ui.consultation.PsychologistAdapter.ListViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/aldion/capstonemsib/ui/consultation/PsychologistAdapter$ListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "tvExperience", "Landroid/widget/TextView;", "tvImage", "Landroid/widget/ImageView;", "tvName", "tvType", "bindItem", "", "data", "Lcom/aldion/capstonemsib/data/entity/Psychologist;", "listener", "Lkotlin/Function1;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class ListViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView tvName = null;
        private final android.widget.TextView tvType = null;
        private final android.widget.TextView tvExperience = null;
        private final android.widget.ImageView tvImage = null;
        
        public ListViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bindItem(@org.jetbrains.annotations.NotNull()
        com.aldion.capstonemsib.data.entity.Psychologist data, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.aldion.capstonemsib.data.entity.Psychologist, kotlin.Unit> listener, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}