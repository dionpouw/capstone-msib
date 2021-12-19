package com.aldion.capstonemsib.data.room;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0018\u00010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/aldion/capstonemsib/data/room/StatementRepository;", "", "statementDao", "Lcom/aldion/capstonemsib/data/room/StatementDao;", "(Lcom/aldion/capstonemsib/data/room/StatementDao;)V", "getAllStatement", "Landroidx/lifecycle/LiveData;", "", "Lcom/aldion/capstonemsib/data/entity/Statement;", "insert", "", "statement", "Companion", "app_debug"})
public final class StatementRepository {
    private final com.aldion.capstonemsib.data.room.StatementDao statementDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.aldion.capstonemsib.data.room.StatementRepository.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.aldion.capstonemsib.data.room.StatementRepository instance;
    
    public StatementRepository(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.data.room.StatementDao statementDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.aldion.capstonemsib.data.entity.Statement>> getAllStatement() {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.data.entity.Statement statement) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/aldion/capstonemsib/data/room/StatementRepository$Companion;", "", "()V", "instance", "Lcom/aldion/capstonemsib/data/room/StatementRepository;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aldion.capstonemsib.data.room.StatementRepository getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}