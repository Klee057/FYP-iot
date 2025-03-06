// Generated by view binder compiler. Do not edit!
package com.example.javaapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.javaapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button addMember;

  @NonNull
  public final TextView countdownText;

  @NonNull
  public final ListView customListView;

  @NonNull
  public final ConstraintLayout homeFrag;

  @NonNull
  public final BottomNavigationView navView;

  @NonNull
  public final Button registerButton;

  @NonNull
  public final TextView textView;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView, @NonNull Button addMember,
      @NonNull TextView countdownText, @NonNull ListView customListView,
      @NonNull ConstraintLayout homeFrag, @NonNull BottomNavigationView navView,
      @NonNull Button registerButton, @NonNull TextView textView) {
    this.rootView = rootView;
    this.addMember = addMember;
    this.countdownText = countdownText;
    this.customListView = customListView;
    this.homeFrag = homeFrag;
    this.navView = navView;
    this.registerButton = registerButton;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addMember;
      Button addMember = ViewBindings.findChildViewById(rootView, id);
      if (addMember == null) {
        break missingId;
      }

      id = R.id.countdownText;
      TextView countdownText = ViewBindings.findChildViewById(rootView, id);
      if (countdownText == null) {
        break missingId;
      }

      id = R.id.customListView;
      ListView customListView = ViewBindings.findChildViewById(rootView, id);
      if (customListView == null) {
        break missingId;
      }

      ConstraintLayout homeFrag = (ConstraintLayout) rootView;

      id = R.id.nav_view;
      BottomNavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      id = R.id.registerButton;
      Button registerButton = ViewBindings.findChildViewById(rootView, id);
      if (registerButton == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, addMember, countdownText,
          customListView, homeFrag, navView, registerButton, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
