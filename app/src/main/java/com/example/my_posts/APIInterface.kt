package com.example.my_posts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {
    @GET("posts")
    fun getPosts():Call<List<Posts>>
    @GET("posts/{id}")
    fun getPostByid(@Path("id")postId:Int):Call<Posts>
    @GET("Posts/{id}/comments")
    fun getCommentsById(@Path("id") postId: String):Call<Comments>


}