package com.example.crm.entities;

public record ShippingInfoData(
  String address,
  String city,
  String country,
  String postalCode
) {}
