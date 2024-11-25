package com.example.a20241116_gauravsingh_nycschoolss.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a20241116_gauravsingh_nycschoolss.model.School
import com.example.a20241116_gauravsingh_nycschoolss.retrofit.SchoolApi
import javax.inject.Inject

class SchoolRepository @Inject constructor(private val schoolsApi: SchoolApi) {
    private val _school= MutableLiveData<List<School>>()
    val school : LiveData<List<School>>
        get() = _school
    suspend fun getSchool(){
        val result = schoolsApi.getSchool()
        _school.postValue(result.body())
    }
}