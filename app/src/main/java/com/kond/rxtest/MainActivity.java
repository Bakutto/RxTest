package com.kond.rxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<Integer> observable = Observable.just(1, 2, 4);
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i("MainActivity", String.valueOf(integer));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("MainActivity", String.valueOf(e));
            }

            @Override
            public void onComplete() {
                Log.i("MainActivity", "onComplete");
            }
        });
    }
}