package com.aldion.capstonemsib.data.room;

import java.lang.System;

@androidx.room.Database(entities = {com.aldion.capstonemsib.data.entity.Statement.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/aldion/capstonemsib/data/room/StatementDatabase;", "Landroidx/room/RoomDatabase;", "()V", "statementDao", "Lcom/aldion/capstonemsib/data/room/StatementDao;", "Companion", "app_debug"})
public abstract class StatementDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.aldion.capstonemsib.data.room.StatementDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.aldion.capstonemsib.data.room.StatementDatabase INSTANCE;
    
    public StatementDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aldion.capstonemsib.data.room.StatementDao statementDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/aldion/capstonemsib/data/room/StatementDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/aldion/capstonemsib/data/room/StatementDatabase;", "getInstance", "context", "Landroid/content/Context;", "populateDbAsyncTask", "", "statementDao", "Lcom/aldion/capstonemsib/data/room/StatementDao;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.aldion.capstonemsib.data.room.StatementDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final void populateDbAsyncTask(com.aldion.capstonemsib.data.room.StatementDao statementDao) {
        }
    }
}