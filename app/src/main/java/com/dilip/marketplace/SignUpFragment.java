package com.dilip.marketplace;

import android.content.Intent;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dilip.marketplace.databinding.FragmentSignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpFragment extends Fragment {
    FragmentSignUpBinding binding; // View binding for the fragment

    public SignUpFragment() {
        // Required empty public constructor
    }

    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;
    private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(getLayoutInflater());
        View rootView = binding.getRoot();

        parentFrameLayout = getActivity().findViewById(R.id.register_frame_layout);

        firebaseAuth = FirebaseAuth.getInstance();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.tvSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignInFragment());

            }
        });

        binding.signUpEmail.addTextChangedListener(new TextWatcher() {
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
        binding.signUpFullName.addTextChangedListener(new TextWatcher() {
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
        binding.signUpPassword.addTextChangedListener(new TextWatcher() {
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
        binding.signUpConfirmPassword.addTextChangedListener(new TextWatcher() {
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


        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(binding.signUpEmail.getText())) {
            if (!TextUtils.isEmpty(binding.signUpFullName.getText())) {
                if (!TextUtils.isEmpty(binding.signUpPassword.getText()) && binding.signUpPassword.length() >= 8) {
                    if (!TextUtils.isEmpty(binding.signUpConfirmPassword.getText())) {
                        binding.signUpBtn.setEnabled(true);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            binding.signUpBtn.setTextColor(Color.argb(30f,255,255,255));
                        }

                    } else {
                        binding.signUpBtn.setEnabled(false);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            binding.signUpBtn.setTextColor(Color.argb(20f,255,255,255));
                        }
                    }

                } else {
                    binding.signUpBtn.setEnabled(false);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        binding.signUpBtn.setTextColor(Color.argb(20f,255,255,255));
                    }
                }

            } else {
                binding.signUpBtn.setEnabled(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    binding.signUpBtn.setTextColor(Color.argb(20f,255,255,255));
                }
            }

        } else {
            binding.signUpBtn.setEnabled(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.signUpBtn.setTextColor(Color.argb(20f,255,255,255));
            }
        }
    }

    private void checkEmailAndPassword() {
        if (binding.signUpEmail.getText().toString().matches(emailPattern)){
            if (binding.signUpPassword.getText().toString().equals(binding.signUpConfirmPassword.getText().toString())) {

                binding.signUpProgressbar.setVisibility(View.VISIBLE);
                binding.signUpBtn.setEnabled(false);

                firebaseAuth.createUserWithEmailAndPassword(binding.signUpEmail.getText().toString(), binding.signUpPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent mainIntent = new Intent(getActivity(), MainActivity.class);
                                    startActivity(mainIntent);
                                    getActivity().finish();
                                } else {
                                    binding.signUpProgressbar.setVisibility(View.INVISIBLE);
                                    binding.signUpBtn.setEnabled(true);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        binding.signUpBtn.setTextColor(Color.argb(20f,255,255,255));
                                    }

                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            } else {
                binding.signUpConfirmPassword.setError("Password doesn't match");
            }
        } else {
            binding.signUpEmail.setError("Invalid Email!");
        }

    }
}