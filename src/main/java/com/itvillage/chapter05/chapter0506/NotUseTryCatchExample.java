package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class NotUseTryCatchExample {
    public static void main(String[] args) {
        try{
            Observable.just(2)
                    .map(num -> num / 0)
                    .subscribe(System.out::println);
        }catch (Exception e){
            Logger.print("# 에러 처리가 필요: " + e.getCause());
        }
    }
}
