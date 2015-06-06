package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by Mariusz on 2015-05-25.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KomentarzWydarzenie implements Serializable {

    public Integer id;
    public Integer idWydarzenia;
    public Integer ocena;
    public Integer ownerId;
    public String tresc;
}
