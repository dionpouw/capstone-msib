// Generated by view binder compiler. Do not edit!
package com.aldion.capstonemsib.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.aldion.capstonemsib.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemProfilHistoryBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final ImageView ivPosterImage;

  @NonNull
  public final TextView tvNamePsycholog;

  @NonNull
  public final TextView tvPricePsycholog;

  @NonNull
  public final TextView tvType;

  private ItemProfilHistoryBinding(@NonNull CardView rootView, @NonNull CardView cardView,
      @NonNull Guideline guideline2, @NonNull ImageView ivPosterImage,
      @NonNull TextView tvNamePsycholog, @NonNull TextView tvPricePsycholog,
      @NonNull TextView tvType) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.guideline2 = guideline2;
    this.ivPosterImage = ivPosterImage;
    this.tvNamePsycholog = tvNamePsycholog;
    this.tvPricePsycholog = tvPricePsycholog;
    this.tvType = tvType;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemProfilHistoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemProfilHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_profil_history, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemProfilHistoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.iv_poster_image;
      ImageView ivPosterImage = ViewBindings.findChildViewById(rootView, id);
      if (ivPosterImage == null) {
        break missingId;
      }

      id = R.id.tv_name_psycholog;
      TextView tvNamePsycholog = ViewBindings.findChildViewById(rootView, id);
      if (tvNamePsycholog == null) {
        break missingId;
      }

      id = R.id.tv_price_psycholog;
      TextView tvPricePsycholog = ViewBindings.findChildViewById(rootView, id);
      if (tvPricePsycholog == null) {
        break missingId;
      }

      id = R.id.tv_type;
      TextView tvType = ViewBindings.findChildViewById(rootView, id);
      if (tvType == null) {
        break missingId;
      }

      return new ItemProfilHistoryBinding((CardView) rootView, cardView, guideline2, ivPosterImage,
          tvNamePsycholog, tvPricePsycholog, tvType);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
