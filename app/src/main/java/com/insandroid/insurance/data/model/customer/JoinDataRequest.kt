package com.insandroid.insurance.data.model.customer

//회원가입 Request Data
data class JoinDataRequest(
    val email: String?,
    val password: String?,
    val name: String?,
    val address: String?,
    val detailAddress: String?,
    val zipcode: String?,
    val phoneNumber: String?,
    val kindOfJob: String?,
    val kindOfInsurance: String?,
    val ssn: String?,
    val cancer: String?,
    val smoke: String?,
    val alcohol: String?,
)


/*
{
  "customerId": 0,
  "password": "string",
  "name": "string",
  "address": "string",
  "detailAddress": "string",
  "zipcode": "string",
  "email": "string",
  "phoneNumber": "string",
  "kindOfJob": "string",
  "kindOfInsurance": "string",
  "ssn": "string",
  "cancer": "string",
  "smoke": "string",
  "alcohol": "string"
}
 */