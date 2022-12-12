package com.insandroid.insurance.data.model.insurance

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//상담대기신규고객조회
@Parcelize
data class GetInsCustomer(
    val empCusId : Long,
    val customerName : String,
    val phoneNum : String,
    val kindOfInsurance : String,
    val kindOfJob : String,
) : Parcelable

/*
{
      "empCusId": 0,
      "customerName": "string",
      "ssn": "string",
      "job": "OFFICE_WORKER",
      "phoneNum": "string",
      "email": "string",
      "address": {
        "address": "string",
        "detailAddress": "string",
        "zipcode": "string"
      },
      "kindOfInsurance": "LIFE",
      "kindOfJob": "OFFICE_WORKER",
      "healthInformation": {
        "createdDate": "2022-12-12T11:45:00.399Z",
        "lastModifiedDate": "2022-12-12T11:45:00.399Z",
        "isEnable": true,
        "id": 0,
        "cancer": "A",
        "smoke": "A",
        "alcohol": "A"
      }
    }
 */