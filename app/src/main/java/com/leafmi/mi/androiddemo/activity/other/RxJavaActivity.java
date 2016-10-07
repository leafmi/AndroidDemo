package com.leafmi.mi.androiddemo.activity.other;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.leafmi.mi.androiddemo.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class RxJavaActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        iv = (ImageView) findViewById(R.id.iv);
        RxJava4();
    }

    private void rxJava() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d("RxJava", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("RxJava", s);
            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {
            /**
             *事件还未发出时侯调用
             */
            @Override
            public void onStart() {
                super.onStart();
            }

            /**
             * 事件队列完结的时候调用
             */
            @Override
            public void onCompleted() {

            }

            /**
             * 事件队列异常时调用
             * @param e
             */
            @Override
            public void onError(Throwable e) {

            }

            /**
             * 事件触发时候调用
             * @param s
             */
            @Override
            public void onNext(String s) {

            }
        };

        /**
         * 取消订阅（要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）调用 unsubscribe() 来解除引用关系，以避免内存泄露的发生。）
         */
        subscriber.unsubscribe();


        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello1");
                subscriber.onNext("hello2");
                subscriber.onNext("hello3");
                subscriber.onCompleted();

            }
        });

        observable.subscribe(observer);
    }

    private void RxJava2() {
        String[] names = {"j", "p", "c"};

        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("RxJava", s);
            }
        });
    }


    private void RxJava3() {
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(R.drawable.flash_them_default);
                subscriber.onNext(drawable);
            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {
                iv.setImageDrawable(drawable);
            }
        });
    }

    private void RxJava4() {
        Observable.just("5265", "4654")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d("RxJava", s);
                    }
                });
    }
}
