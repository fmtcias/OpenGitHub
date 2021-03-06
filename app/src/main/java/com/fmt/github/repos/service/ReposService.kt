package com.fmt.github.repos.service

import com.fmt.github.repos.model.ReposListModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ReposService {

    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String, @Query("page") page: Int, @Query("per_page") per_page: Int = 10): ReposListModel

    @GET("user/starred/{owner}/{repo}")
    suspend fun checkRepoStarred(@Path("owner") owner: String, @Path("repo") repo: String): Response<ResponseBody>

    @PUT("user/starred/{owner}/{repo}")
    suspend fun starRepo(@Path("owner") owner: String, @Path("repo") repo: String): Response<ResponseBody>

    @DELETE("user/starred/{owner}/{repo}")
    suspend fun unStarRepo(@Path("owner") owner: String, @Path("repo") repo: String): Response<ResponseBody>
}