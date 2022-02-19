package com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.data.PostClient;
import com.bobabelga.retrofitmvvmrecyclerviewrxjavawithplaceholder.pojo.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    public MutableLiveData<List<Post>> mutablePostLiveData = new MutableLiveData<>();

    public void getPosts (){
        Observable observable = PostClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<Post>> observer = new Observer<List<Post>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Post> value) {
                mutablePostLiveData.setValue(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
}
