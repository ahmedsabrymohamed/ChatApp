package com.example.mine.chatapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;



public class AllUserChatFragmet extends Fragment {

    private ArrayList<Employee> employees=new ArrayList<>();
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference2;
    private CustomRecyclerViewAdapter customRecyclerViewAdapter;
    private String userID;
    private String userProfileID;


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Uid";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param Uid Parameter 1.
     * @return A new instance of fragment AllUserChatFragmet.
     */
    public static AllUserChatFragmet newInstance(String Uid) {
        AllUserChatFragmet fragment = new AllUserChatFragmet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, Uid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userID = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_all_user_chat_fragmet, container, false);
        recyclerView=view.findViewById(R.id.AllUserRecyclerView);
        //connecting to database
        databaseReference=FirebaseDatabase.getInstance().getReference();
        databaseReference2=FirebaseDatabase.getInstance().getReference();

        RealData();
        customRecyclerViewAdapter=new CustomRecyclerViewAdapter(getContext(),employees);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customRecyclerViewAdapter);

        return view;
    }

    public void RealData() {


        databaseReference.child(getResources().getString( R.string.UsersProfile)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final Employee emp=dataSnapshot.getValue(Employee.class);
                emp.name=emp.name.replaceAll("\\p{P}[^\\\\p{L} ]", "");
                if(!(emp.departmentCode.isEmpty())){

                    databaseReference2
                            .child(getResources().getString(R.string.Departments))
                            .child(emp.departmentCode).child("name")
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {

                                    emp.departmentName=dataSnapshot.getValue().toString();
                                    emp.departmentName=emp.departmentName.replaceAll("\"", "");
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                    Toast.makeText(getActivity(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });
                }
                else{
                    emp.departmentName=getResources().getString(R.string.notFound);
                }
               // Log.d("ahmed", "onChildAdded: "+databaseReference2
                 //       .child(getResources().getString(R.string.Sections))
                   //     .child(emp.sectionCode).child("sectionCode").toString());
                if(!(emp.sectionCode.isEmpty())){


                    databaseReference2
                            .child(getResources().getString(R.string.Sections))
                            .child(emp.sectionCode).child("name")
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {

                                    emp.sectionName=dataSnapshot.getValue().toString();
                                    emp.sectionName=emp.sectionName.replaceAll("\\p{P}[^\\\\p{L} ]", "");
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                    Toast.makeText(getActivity(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });
                }
                else{
                    emp.sectionName=getResources().getString(R.string.notFound);
                }
                employees.add(emp);
                customRecyclerViewAdapter.notifyItemInserted(employees.size()-1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //report error
                Toast.makeText(getActivity(),databaseError.getMessage(),Toast.LENGTH_LONG);
            }
        });



    }
}
