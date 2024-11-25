package com.example.a20241116_gauravsingh_nycschoolss

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.a20241116_gauravsingh_nycschoolss.model.School
import com.example.a20241116_gauravsingh_nycschoolss.viewmodel.MainViewModel
import com.otherTallguy.dagger2example.viewmodel.MainViewModelFactory
import java.util.ArrayList
import javax.inject.Inject

//import com.example.a20241116_gauravsingh_nycschoolss.ui.theme.20241116GauravSinghNYCSchoolssTheme

class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var schoolList: ArrayList<School>

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory // Dagger will provide the object to this variable through field injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        schoolList = arrayListOf()
        mainViewModel.refresh()


        observeViewModel()

        setContent {
            displayList()
        }
    }

    @Composable
    fun Card(name: School) {
        androidx.compose.material.Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.medium,
            elevation = 5.dp,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = name.school_name,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = name.boro,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = name.academicopportunities1,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = name.location,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }

    @Composable
    fun displayList() {


        LazyColumn {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "\uD83C\uDF3F  Plants in Cosmetics",
                    )
                }
            }
            items(schoolList.count()) { index ->
                val item = schoolList[index % schoolList.size]
                Card(item)
            }
            items(schoolList.count()) { item ->

            }
        }


    }

    private fun observeViewModel() {

        mainViewModel.schoolLiveData.observe(this) { school ->
            school?.let {

                schoolList.addAll(it)
            }
        }

    }
}