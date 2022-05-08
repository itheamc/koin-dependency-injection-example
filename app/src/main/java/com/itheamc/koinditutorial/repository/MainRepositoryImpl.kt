package com.itheamc.koinditutorial.repository

class MainRepositoryImpl(): MainRepository {
    override fun fetchPosts(): String {
        return "This is the response from network!!"
    }
}