package com.dilip.marketplace;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dilip.marketplace.databinding.FragmentResetPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordFragment extends Fragment {


    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    private FragmentResetPasswordBinding binding;
    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResetPasswordBinding.inflate(getLayoutInflater());
        View rootView = binding.getRoot(); // Get the root view from the binding

        parentFrameLayout = getActivity().findViewById(R.id.register_frame_layout);


        firebaseAuth = FirebaseAuth.getInstance();

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.forgotPasswordEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailIconContainer);
                binding.forgotPasswordEmailIconText.setVisibility(View.GONE);

                TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailIconContainer);
                binding.forgotPasswordEmailIcon.setVisibility(View.VISIBLE);
                binding.forgotPasswordProgressbar.setVisibility(View.VISIBLE);


                binding.resetPasswordBtn.setEnabled(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    binding.resetPasswordBtn.setTextColor(Color.argb(10f, 255, 255, 255));
                }

                firebaseAuth.sendPasswordResetEmail(binding.forgotPasswordEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {


                                } else {
                                    String error = task.getException().getMessage();

                                    binding.resetPasswordBtn.setEnabled(true);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        binding.resetPasswordBtn.setTextColor(Color.argb(50f, 255, 255, 255));
                                    }

                                    binding.forgotPasswordEmailIconText.setText(error);
                                    binding.forgotPasswordEmailIconText.setTextColor(Color.rgb(255, 0, 0));
                                    TransitionManager.beginDelayedTransition(binding.forgotPasswordEmailIconContainer);
                                    binding.forgotPasswordEmailIconText.setVisibility(View.VISIBLE);

                                }
                                binding.forgotPasswordProgressbar.setVisibility(View.GONE);

                            }
                        });
            }
        });

        binding.tvGoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());
            }
        });
    }

    private void checkInputs() {
        if (TextUtils.isEmpty(binding.forgotPasswordEmail.getText())) {
            binding.resetPasswordBtn.setEnabled(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.resetPasswordBtn.setTextColor(Color.argb(10f, 255, 255, 255));
            }
        } else {
            binding.resetPasswordBtn.setEnabled(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.resetPasswordBtn.setTextColor(Color.argb(50f, 255, 255, 255));
            }

        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}