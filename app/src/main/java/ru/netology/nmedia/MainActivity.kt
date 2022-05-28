package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.TransformNum
import ru.netology.nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val TransformNum=TransformNum()
        viewModel.data.observe(this){ post ->
            with(binding){
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likesPic.setImageResource(
                    if(post.likedByMe) R.drawable.ic_baseline_heart_broken_24 else R.drawable.ic_outline_favorite_border_24
                )
                share?.text = TransformNum.transformNum(post.shares)
                view?.text = TransformNum.transformNum(post.views)
                likes?.text = post.likes.toString()
            }

        }
        binding.likesPic.setOnClickListener{
            viewModel.like()
        }


        binding.sharePic.setOnClickListener{
            viewModel.share1()
        }


    }




}