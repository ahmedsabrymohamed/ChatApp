package com.example.mine.chatapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Login_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {//@link Login_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login_Fragment extends Fragment {


    private EditText password_Code_edit_text;
    private EditText user_name_edit_text;
    private View root;
    private Button login_button;
    private FirebaseAuth mAuth;



    private OnFragmentInteractionListener mListener;

    public Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // get the root of view
        root = inflater.inflate(R.layout.fragment_login_, container, false);
        //attach every view to object in code
        login_button = root.findViewById(R.id.Login_button);
        user_name_edit_text = root.findViewById(R.id.User_name_edit_text);
        password_Code_edit_text = root.findViewById(R.id.Password_Code_edit_text);
        //handle clicks on login button
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name ,password ;

                user_name = user_name_edit_text.getText().toString();
                password = password_Code_edit_text.getText().toString();

                if (user_name.equals("") || password.equals("")) {
                    //Log.d("ahmed", "onClick: "+user_name_edit_text.getText().toString()+"  "+password);
                    mAuth.signInWithEmailAndPassword(user_name, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                        if (mListener != null) {
                                            mListener.onLogin(mAuth.getCurrentUser().getUid());
                                        }

                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(getActivity(), R.string.Wrong_Sign_in,
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
                else{
                    Toast.makeText(getActivity(), R.string.Wrong_Sign_in,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onLogin(String Uid);
    }
}
