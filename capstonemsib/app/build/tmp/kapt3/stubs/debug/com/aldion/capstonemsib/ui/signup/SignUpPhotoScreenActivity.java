package com.aldion.capstonemsib.ui.signup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u00020.H\u0016J\u0012\u00105\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u000107H\u0015J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020(X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006;"}, d2 = {"Lcom/aldion/capstonemsib/ui/signup/SignUpPhotoScreenActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/aldion/capstonemsib/databinding/ActivitySignUpPhotoScreenBinding;", "filePath", "Landroid/net/Uri;", "getFilePath", "()Landroid/net/Uri;", "setFilePath", "(Landroid/net/Uri;)V", "mFirebaseDatabase", "Lcom/google/firebase/database/DatabaseReference;", "mFirebaseInstance", "Lcom/google/firebase/database/FirebaseDatabase;", "preferences", "Lcom/aldion/capstonemsib/utils/Preferences;", "getPreferences", "()Lcom/aldion/capstonemsib/utils/Preferences;", "setPreferences", "(Lcom/aldion/capstonemsib/utils/Preferences;)V", "statusAdd", "", "getStatusAdd", "()Z", "setStatusAdd", "(Z)V", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "getStorage", "()Lcom/google/firebase/storage/FirebaseStorage;", "setStorage", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "getStorageReference", "()Lcom/google/firebase/storage/StorageReference;", "setStorageReference", "(Lcom/google/firebase/storage/StorageReference;)V", "user", "Lcom/aldion/capstonemsib/data/entity/User;", "getUser", "()Lcom/aldion/capstonemsib/data/entity/User;", "setUser", "(Lcom/aldion/capstonemsib/data/entity/User;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveToFirebase", "url", "", "app_debug"})
public final class SignUpPhotoScreenActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aldion.capstonemsib.databinding.ActivitySignUpPhotoScreenBinding binding;
    private boolean statusAdd = false;
    public android.net.Uri filePath;
    public com.google.firebase.storage.FirebaseStorage storage;
    public com.google.firebase.storage.StorageReference storageReference;
    public com.aldion.capstonemsib.utils.Preferences preferences;
    public com.aldion.capstonemsib.data.entity.User user;
    private com.google.firebase.database.DatabaseReference mFirebaseDatabase;
    private com.google.firebase.database.FirebaseDatabase mFirebaseInstance;
    
    public SignUpPhotoScreenActivity() {
        super();
    }
    
    public final boolean getStatusAdd() {
        return false;
    }
    
    public final void setStatusAdd(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.FirebaseStorage getStorage() {
        return null;
    }
    
    public final void setStorage(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getStorageReference() {
        return null;
    }
    
    public final void setStorageReference(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.StorageReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aldion.capstonemsib.utils.Preferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.utils.Preferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aldion.capstonemsib.data.entity.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.data.entity.User p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void saveToFirebase(java.lang.String url) {
    }
}