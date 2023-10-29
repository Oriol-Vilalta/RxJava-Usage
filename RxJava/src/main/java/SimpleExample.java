import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class SimpleExample {

    public static void main(String[] args) {
        /*
         Creation of the observable.
         The range operator is an observable creator operator. Creates an Integer Observable
         that will emit 5 numbers from the start number (2).
         */
        Observable<Integer> observable = Observable.range(2,5);

        // Subscribes an observer to the observable.
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) { // Gets executed when subscribed.
                System.out.println("Observer: Subscribed");
            }

            @Override
            public void onNext(@NonNull Integer integer) {  // Gets executed when the observable emits an item
                System.out.println("Observer: " + integer); // in this case the items will be numbers.
            }

            @Override
            public void onError(@NonNull Throwable e) {     // Gets executed when an error occurs.
                System.out.println("Observer: " + e.getMessage());
            }

            @Override
            public void onComplete() {  // Gets executed when the observable finalizes.
                System.out.println("Observer: The observable has ended");
            }
        });

    }
}
