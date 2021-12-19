package com.aldion.capstonemsib.ui.signin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/aldion/capstonemsib/ui/signin/SignInActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mDatabase", "Lcom/google/firebase/database/DatabaseReference;", "preference", "Lcom/aldion/capstonemsib/utils/Preferences;", "getPreference", "()Lcom/aldion/capstonemsib/utils/Preferences;", "setPreference", "(Lcom/aldion/capstonemsib/utils/Preferences;)V", "siPassword", "", "siUsername", "signInBinding", "Lcom/aldion/capstonemsib/databinding/ActivitySignInBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "pushLogin", "app_debug"})
public final class SignInActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aldion.capstonemsib.databinding.ActivitySignInBinding signInBinding;
    private java.lang.String siUsername;
    private java.lang.String siPassword;
    private com.google.firebase.database.DatabaseReference mDatabase;
    public com.aldion.capstonemsib.utils.Preferences preference;
    
    public SignInActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aldion.capstonemsib.utils.Preferences getPreference() {
        return null;
    }
    
    public final void setPreference(@org.jetbrains.annotations.NotNull()
    com.aldion.capstonemsib.utils.Preferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void pushLogin(java.lang.String siUsername, java.lang.String siPassword) {
    }
}