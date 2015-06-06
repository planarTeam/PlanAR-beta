package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Mariusz on 2015-05-25.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wydarzenie implements Serializable {

    public String nazwa;
    public String ownerId;
    public Integer id;
    public Integer idProwadzacego;
}
