// Generated by view binder compiler. Do not edit!
package com.example.javaapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.javaapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCameraViewBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView outputText;

  @NonNull
  public final Button sendButton;

  private FragmentCameraViewBinding(@NonNull LinearLayout rootView, @NonNull TextView outputText,
      @NonNull Button sendButton) {
    this.rootView = rootView;
    this.outputText = outputText;
    this.sendButton = sendButton;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCameraViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCameraViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_camera_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCameraViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.outputText;
      TextView outputText = ViewBindings.findChildViewById(rootView, id);
      if (outputText == null) {
        break missingId;
      }

      id = R.id.send_button;
      Button sendButton = ViewBindings.findChildViewById(rootView, id);
      if (sendButton == null) {
        break missingId;
      }

      return new FragmentCameraViewBinding((LinearLayout) rootView, outputText, sendButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
