package com.example.michal.myapplication;

import com.example.michal.myapplication.Data.EmailAndPassword;
import com.example.michal.myapplication.Data.KomentWydL;
import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.Data.TerminL;
import com.example.michal.myapplication.Data.User;
import com.example.michal.myapplication.Data.WydarzenieL;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Mariusz on 2015-05-25.
 */
@Rest(rootUrl = "https://dsp-planar.cloud.dreamfactory.com/rest",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface PlanArRestClient extends RestClientHeaders {

    @Post("/user/session")
    User login(EmailAndPassword emailAndPassword);

    @Post("/user/register/?login=true")
    User register(EmailAndPassword emailAndPassword);

    @RequiresHeader({"X-Dreamfactory-Application-Name", "X-Dreamfactory-Session-Token"})
    @Post("/db/komentarzWydarzenie")
    void addComWydarzenie(KomentarzWydarzenie komentarzWydarzenie);

    @Get("/db/komentarzWydarzenie?filter={path}")
    KomentWydL getComWydarzenie(String path);

    @Get("/db/termin?filter={path}&order=terminRozpoczecia&related=*")
    TerminL getTermin(String path);

}
