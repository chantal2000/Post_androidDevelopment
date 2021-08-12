package com.example.my_posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_posts.databinding.ActivityViewPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewPost : AppCompatActivity() {
    lateinit var binding: ActivityViewPostBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityViewPostBinding.inflate(layoutInflater)
        postId = intent.getIntExtra("Post_Id", 0)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        getPost()
    }
    fun getPost() {
        var retrofit = myposts.buildService(APIInterface::class.java)
        var request = retrofit.getPostByid(postId)
        request.enqueue(object : Callback<Posts?> {
            override fun onResponse(call: Call<Posts?>, response: Response<Posts?>) {
                if (response.isSuccessful) {
                    binding.texView.text = response.body()?.title
                    binding.tvBody.text = response.body()?.body
                }


            }
            override fun onFailure(call: Call<Posts?>, t: Throwable) {
//                Toast.makeText(baseContext.t.message,Toast.LENGTH_LONG).show()

            }
        })

    }
    fun getCommentsPost(){
        var retrofit=myposts.buildService(APIInterface::class.java)
        var request=retrofit.getCommentsById("POST_ID")
        request.enqueue(object : Callback<Comments?> {
            override fun onResponse(call: Call<Comments?>, response: Response<Comments?>) {
                if (response.)
            }

            override fun onFailure(call: Call<Comments?>, t: Throwable) {
            }
        })
    }
}