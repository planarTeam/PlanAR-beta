package com.example.michal.myapplication.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damiank on 2015-05-31.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminL {

     @JsonProperty("record")
        public List<Termin> records = new ArrayList<Termin>();

}
