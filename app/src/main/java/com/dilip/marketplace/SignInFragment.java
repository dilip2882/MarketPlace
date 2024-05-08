package com.dilip.marketplace;

import static com.dilip.marketplace.RegisterActivity.onResetPasswordFragment;

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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dilip.marketplace.databinding.FragmentSignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInFragment extends Fragment {
    FragmentSignInBinding binding; // View binding for the fragment


    public SignInFragment() {
        // Required empty public constructor
    }

    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;
    private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private ProgressBar progressBar;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(getLayoutInflater());
        View rootView = binding.getRoot(); // Get the root view from the binding

        parentFrameLayout = getActivity().findViewById(R.id.register_frame_layout);

        firebaseAuth = FirebaseAuth.getInstance();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.tvSignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());

            }
        });

        binding.signInForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPasswordFragment = true;
                setFragment(new ResetPasswordFragment());
            }
        });

        binding.signInEmail.addTextChangedListener(new TextWatcher() {
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
        binding.signInPassword.addTextChangedListener(new TextWatcher() {
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

        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });

        binding.signUpCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(binding.signInEmail.getText())) {
            if (!TextUtils.isEmpty(binding.signInPassword.getText())) {
                binding.signInBtn.setEnabled(true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    binding.signInBtn.setTextColor(Color.argb(30f, 255, 255, 255));
                }

            } else {
                    binding.signInBtn.setEnabled(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    binding.signInBtn.setTextColor(Color.argb(10f,255,255,255));
                }
            }
        } else {
            binding.signInBtn.setEnabled(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                binding.signInBtn.setTextColor(Color.argb(10f,255,255,255));
            }
        }
    }

    private void checkEmailAndPassword() {
        if (binding.signInEmail.getText().toString().matches(emailPattern)) {
            if (binding.signInPassword.length() >= 8) {

                binding.signInProgressbar.setVisibility(View.VISIBLE);
                binding.signInBtn.setEnabled(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    binding.signInBtn.setTextColor(Color.argb(10f, 255, 255, 255));
                }

                String email = String.valueOf(binding.signInEmail.getText());
                String password = String.valueOf(binding.signInPassword.getText());
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    mainIntent();
                                    getActivity().finish();

                                } else {
                                    binding.signInProgressbar.setVisibility(View.INVISIBLE);
                                    binding.signInBtn.setEnabled(true);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        binding.signInBtn.setTextColor(Color.argb(20f, 255, 255, 255));
                                    }

                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                
            } else {
                Toast.makeText(getActivity(), "Incorrect email or password!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Incorrect email or password!", Toast.LENGTH_SHORT).show();
        }
    }

    private  void mainIntent() {
        Intent mainIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(mainIntent);
    }

}