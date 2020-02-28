package com.itvillage.chapter05.chapter0505;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * - 각 Observable에서 통지할 때 마다 모든 Observable에서 마지막으로 통지한 데이터들을 함수형 인터페이스에 반환하고,
 * 이를 가공해서 통지하는 예제.
 * - 각 Observable 중 하나의 Observable에서만 통지가 발생하더라도 이미 통지한 Observable의 마지막 데이터와
 * 함께 전달된다.
 * - 각 Observable에서 동일한 시점에 통지를 할 경우 Observable의 통지 순서가 바뀔 수 있으므로 마지막 데이터를
 * 통지 받는 개수가 실행 시 마다 달라질 수 있다.
 */
public class ObservableCombineLatestExample01 {
    public static void main(String[] args) {
        Observable<Long> observable1 =
                Observable.interval(200L, TimeUnit.MILLISECONDS)
//                        .doOnNext(data -> Logger.don("# observable 1 : " + data))
                        .take(4);

        Observable<Long> observable2 =
                Observable.interval(400L, TimeUnit.MILLISECONDS)
//                        .doOnNext(data -> Logger.don("# observable 2 : " + data))
                        .take(4);

        Observable.combineLatest(
                observable1,
                observable2,
                (data1, data2) -> "data1: " + data1 + "\tdata2: " + data2)
                .subscribe(Logger::on);

        TimeUtil.sleep(3000L);
    }
}