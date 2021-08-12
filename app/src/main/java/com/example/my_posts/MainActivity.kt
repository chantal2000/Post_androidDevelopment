package com.example.my_posts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    lateinit var rvUser:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()
    }
    fun fetchPosts(){
        var retrofit=myposts.buildService(APIInterface::class.java)
        var request=retrofit.getPosts()
            request.enqueue(object : Callback<List<Posts>>{
                override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
if(response.isSuccessful){
    var postList=response.body()!!
    rvUser=findViewById(R.id.rvUser)
    rvUser.layoutManager=LinearLayoutManager(baseContext)
    var userAdapter=MyAdaptervar(baseContext,postList)
    rvUser.adapter=userAdapter
}
                }
                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                }
            })
    }
}