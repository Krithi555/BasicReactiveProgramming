package ReactiveServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
public class TestReactive {
    ReactiveSources reactiveSources = new ReactiveSources();
    @Test
    void Movies(){
        var movies = reactiveSources.Movies();
        StepVerifier.create(movies)
                .expectNext("Spider man","titanic","batman","avengers").verifyComplete();
    }

    @Test
    void Numbers(){
        var numbers = reactiveSources.Numbers();
        StepVerifier.create(numbers)
                .expectNext(3,4,6).verifyComplete();
    }

    @Test
    void Transform(){
        var transform = reactiveSources.Transform();
        StepVerifier.create(transform)
                .expectNext("A","P","N").verifyComplete();

    }

    @Test
    void Reduce(){
        var reduce = reactiveSources.Reduce();
        StepVerifier.create(reduce)
                .expectNext("Bitcoin/Crypto").verifyComplete();

    }

    @Test
    void Combine(){
        var combine = reactiveSources.Combine();
        StepVerifier.create(combine)
                .expectNext("Famous Five Enid Blyton","Ponniyin Selvan Kalki").verifyComplete();

    }

    @Test
    void monoMap(){
        var monoMap = reactiveSources.monoMap();
        StepVerifier.create(monoMap)
                .expectNext("abcde").verifyComplete();

    }







}
