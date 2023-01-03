package com.gauravbora.newsplush.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gauravbora.newsplush.R
import com.gauravbora.newsplush.databinding.ActivityNewsBinding
import com.gauravbora.newsplush.db.ArticleDatabase
import com.gauravbora.newsplush.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        // val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }
}