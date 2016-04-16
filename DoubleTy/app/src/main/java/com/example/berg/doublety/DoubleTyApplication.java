package com.example.berg.doublety;

import android.app.Application;

/**
 * Created by Berg on 13/04/16.
 */
public class DoubleTyApplication extends Application {

    private boolean exibirDialog;

    @Override
    public void onCreate() {
        super.onCreate();
        exibirDialog = true;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public boolean isDialog(){
        return exibirDialog;
    }

    public void setDialog(boolean dialog) {
        this.exibirDialog = dialog;
    }
}
