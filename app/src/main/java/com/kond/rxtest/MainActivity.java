package com.kond.rxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String TAG = "MainActivity";
        setContentView(R.layout.activity_main);
        Observable<Integer> observable = Observable.just(1, 2, 3, 4);
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Timber.tag(TAG).e(String.valueOf(d));
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Timber.tag(TAG).e(String.valueOf(integer));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}