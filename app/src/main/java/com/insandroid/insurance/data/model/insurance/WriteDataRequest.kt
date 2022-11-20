package com.insandroid.insurance.data.model.insurance

data class WriteDataRequest(
    val insuranceName : String,
    val fee : Int,
    val maxAge : Int,
    val minAge : Int,
    val smoke : String,
    val alcohol : String,
    val cancer : String,
    val kindOfInsurance : String
)

/*
  "insuranceName": "string",
  "fee": 0,
  "maxAge": 0,
  "minAge": 0,
  "smoke": "string",
  "alcohol": "string",
  "cancer": "string",
  "kindOfInsurance": "string"
 */
