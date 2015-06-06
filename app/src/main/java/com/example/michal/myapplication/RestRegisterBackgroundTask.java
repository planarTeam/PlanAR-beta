package com.example.michal.myapplication;

import com.example.michal.myapplication.Data.EmailAndPassword;
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
public class RestRegisterBackgroundTask {

    @RootContext
    RegisterActivity activity;

    @RestService
    PlanArRestClient restClient;

    @Background
    void register(EmailAndPassword emailAndPassword) {
        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "PlanAR_AiB");
            User user = restClient.register(emailAndPassword);
            publishResult(user);
        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.registerSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
