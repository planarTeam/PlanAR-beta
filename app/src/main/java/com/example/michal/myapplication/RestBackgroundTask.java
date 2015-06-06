package com.example.michal.myapplication;

import com.example.michal.myapplication.Data.KomentWydL;
import com.example.michal.myapplication.Data.KomentarzWydarzenie;
import com.example.michal.myapplication.Data.TerminL;
import com.example.michal.myapplication.Data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Mariusz on 2015-05-25.
 */
@EBean
public class RestBackgroundTask {
    public static final int maxProby = 3;
    Integer i = 0;
    @RootContext
    LoginActivity activity;

    @RootContext
    PlanDoKoncaTygodniaDlaSaliActivity planNaTydzienActivity;

    @RootContext
    ReadCommentActivity activityCompro;

    @RestService
    PlanArRestClient restClient;

    @Background
     void addComWyd(KomentarzWydarzenie komentarzWydarzenie, String sessionId) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "PlanAR_AiB");
            restClient.setHeader("X-Dreamfactory-Session-Token", sessionId);
            restClient.addComWydarzenie(komentarzWydarzenie);
        } catch (Exception e) {
            i++;
            if(i<=maxProby){
                addComWyd(komentarzWydarzenie, sessionId);
            }
            else {
                publishError(e);
            }
        }
    }

    @Background
    void getPlanDoKoncaTygodnia(String filtr) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "PlanAR_AiB");
            TerminL terminy= restClient.getTermin(filtr);
            publishPlanNaTydzien(terminy);
        } catch (Exception e) {
            publishErrorPlanNaTydzien(e);
        }
    }

    @Background
    void getComWydarzenie(String wydarzenieID) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "PlanAR_AiB");
            KomentWydL komentarzWydarzenie = restClient.getComWydarzenie(wydarzenieID);

            publishComWyd(komentarzWydarzenie);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.loginSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

    @UiThread
    void publishErrorPlanNaTydzien(Exception e) {
        planNaTydzienActivity.showError(e);
    }

    @UiThread
    void publishPlanNaTydzien(TerminL plan) {
        try {
            planNaTydzienActivity.updatePlanNaTydzien(plan);
        } catch ( NullPointerException e) {
            publishError(e);
        }
    }

    @UiThread
    void publishComWyd(KomentWydL komentWydL) {
        try {
            activityCompro.updateComWyd(komentWydL); //activity zamienic na prawdziwa aktywnosci wyswietlajaca
        } catch ( NullPointerException e) {
            publishError(e);
        }
    }

}
