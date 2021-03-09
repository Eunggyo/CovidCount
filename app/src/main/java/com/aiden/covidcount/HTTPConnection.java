package com.aiden.covidcount;

import android.os.AsyncTask;

public class HTTPConnection extends AsyncTask {

    @Override
    protected Object doInBackground(Object[] objects) {
        ConnectManager.getHttp();
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}

