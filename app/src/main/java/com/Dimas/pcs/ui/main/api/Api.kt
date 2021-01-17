package com.Dimas.pcs.ui.main.api

import com.Dimas.pcs.ui.main.data.model.DetailUserResponse
import com.Dimas.pcs.ui.main.data.model.User
import retrofit2.Call
import com.Dimas.pcs.ui.main.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token f995c912973336e604278447e3034462cf17cb2a")
    fun getSearchUsers(
        @Query("q") query: String
    ) : Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token f995c912973336e604278447e3034462cf17cb2a")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token f995c912973336e604278447e3034462cf17cb2a")
    fun getFollowers(
        @Path("username") username : String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token f995c912973336e604278447e3034462cf17cb2a")
    fun getFollowing(
        @Path("username") username : String
    ): Call<ArrayList<User>>

}