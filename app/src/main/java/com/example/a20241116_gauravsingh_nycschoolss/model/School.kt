package com.example.a20241116_gauravsingh_nycschoolss.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class School(
    var dbn:String,
    var school_name:String,
    var boro:String,
    var overview_paragraph:String,
    var school_10th_seats:String,
    var academicopportunities1:String,
    var academicopportunities2:String,
    var ell_programs:String,
    var neighborhood:String,
    var building_code:String,
    var location:String,
    var phone_number:String,
    var fax_number:String,
    var school_email:String,
    var website:String,
    var subway:String,
    var bus:String,
    var grades2018:String,
    var finalgrades:String,
    var total_students:String

) : Parcelable
