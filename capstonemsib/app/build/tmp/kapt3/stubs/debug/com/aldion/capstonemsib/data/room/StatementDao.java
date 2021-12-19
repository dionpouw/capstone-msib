package com.aldion.capstonemsib.data.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'\u00a8\u0006\t"}, d2 = {"Lcom/aldion/capstonemsib/data/room/StatementDao;", "", "getAllStatement", "Landroidx/lifecycle/LiveData;", "", "Lcom/aldion/capstonemsib/data/entity/Statement;", "insert", "", "statement", "app_debug"})
public abstract interface StatementDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM statement_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.aldion.capstonemsib.data.entity.Statement>> getAllStatement();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.data.entity.Statement statement);
}