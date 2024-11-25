package com.example.a20241116_gauravsingh_nycschoolss.retrofit

import com.example.a20241116_gauravsingh_nycschoolss.model.School
import retrofit2.Response

interface SchoolApi {

    suspend fun getSchool(): Response<List<School>>
}