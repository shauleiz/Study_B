package com.example.study_b;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;




public class MyViewModel extends ViewModel {
    public MutableLiveData<Integer> mld_count;

    public MyViewModel(){

        mld_count = new MutableLiveData<Integer>();
        mld_count.setValue(0);
    }

    public void IncCount(){
        int c =  mld_count.getValue();
        c++;
        mld_count.setValue(c);
    }

 //   public void Increment() {count++;}


}