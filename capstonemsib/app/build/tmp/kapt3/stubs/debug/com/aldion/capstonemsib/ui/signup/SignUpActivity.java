package com.aldion.capstonemsib.ui.signup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J8\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/aldion/capstonemsib/ui/signup/SignUpActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mDatabase", "Lcom/google/firebase/database/DatabaseReference;", "mDatabaseReference", "mFirebaseInstance", "Lcom/google/firebase/database/FirebaseDatabase;", "preferences", "Lcom/aldion/capstonemsib/utils/Preferences;", "signUpBinding", "Lcom/aldion/capstonemsib/databinding/ActivitySignUpBinding;", "suDateOfBirth", "", "suEmail", "suName", "suPassword", "suTelephoneNumber", "suUsername", "checkingUsername", "", "data", "Lcom/aldion/capstonemsib/data/entity/User;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveUsername", "app_debug"})
public final class SignUpActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aldion.capstonemsib.databinding.ActivitySignUpBinding signUpBinding;
    private java.lang.String suUsername;
    private java.lang.String suPassword;
    private java.lang.String suName;
    private java.lang.String suEmail;
    private java.lang.String suTelephoneNumber;
    private java.lang.String suDateOfBirth;
    private com.google.firebase.database.DatabaseReference mDatabaseReference;
    private com.google.firebase.database.FirebaseDatabase mFirebaseInstance;
    private com.google.firebase.database.DatabaseReference mDatabase;
    private com.aldion.capstonemsib.utils.Preferences preferences;
    
    public SignUpActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void saveUsername(java.lang.String suUsername, java.lang.String suPassword, java.lang.String suName, java.lang.String suEmail, java.lang.String suTelephoneNumber, java.lang.String suDateOfBirth) {
    }
    
    private final void checkingUsername(java.lang.String suUsername, com.aldion.capstonemsib.data.entity.User data) {
    }
}