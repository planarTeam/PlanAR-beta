package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mariusz on 2015-05-25.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Termin implements Serializable {

    public Integer id;
    public Integer idWydarzenia;
    public String ownerId;
    public String sala;
    public String terminRozpoczecia;
    public String terminZakonczenia;

    @JsonProperty("wydarzenie_by_idWydarzenia")
    public Wydarzenie wydarzenie = new Wydarzenie();
}
