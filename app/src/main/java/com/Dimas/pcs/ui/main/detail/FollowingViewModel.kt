package com.Dimas.pcs.ui.main.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Dimas.pcs.ui.main.api.RetrofitClient
import com.Dimas.pcs.ui.main.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingViewModel : ViewModel() {
    val listFollowing = MutableLiveData<ArrayList<User>>()

    fun setListFollowing(username: String){
        RetrofitClient.apiInstance
                .getFollowing(username)
                .enqueue(object : Callback<ArrayList<User>>{
                    override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                        if (response.isSuccessful){
                            listFollowing.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                        Log.d("Failure", t.message)
                    }

                })
    }

    fun getListFollowing(): LiveData<ArrayList<User>>{
        return listFollowing
    }
}