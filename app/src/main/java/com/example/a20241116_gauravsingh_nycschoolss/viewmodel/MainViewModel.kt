package com.example.a20241116_gauravsingh_nycschoolss.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20241116_gauravsingh_nycschoolss.model.School
import com.example.a20241116_gauravsingh_nycschoolss.repository.SchoolRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: SchoolRepository, private val testForMultiBinding: TestForMultiBinding):
    ViewModel() {
        val schoolLiveData: LiveData<List<School>>
        get() = repository.school

    val schoolLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        loading.value = true
        fetchSchool()
    }

    private fun fetchSchool(){
        viewModelScope.launch {
            repository.getSchool()
            loading.value = false
        }
    }
}
class TestForMultiBinding @Inject constructor() {
    fun testSomething() {

    }
}