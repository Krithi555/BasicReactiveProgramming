package ReactiveServices;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.math.BigDecimal;
import java.time.Duration;

import java.util.List;
import java.util.Random;
public class ReactiveSources {

    //Returns a Flux of Strings.
    public Flux<String> Movies(){
        return Flux.fromIterable(List.of("Spider man","titanic","batman","avengers")).log();
   }
    //Return the length of each string with its corresponding length (map)
    public Flux<Integer> Numbers(){
        return Flux.fromIterable(List.of("aaa","bbbb","cccccc")).map(String::length).log();
    }

    //Returns the number greater than 10 (Filter)
    public Flux<Integer> Num(){
        return Flux.fromIterable(List.of(24,2,45,3,7)).filter(num -> num>10).log();
    }


    //Convert each second character in a flux of string to uppercase
    public Flux<String> Transform(){
        List<String> mobile = List.of("Samsung","Iphone","OnePlus");
       return Flux.fromIterable(mobile).flatMap(s->Flux.just(String.valueOf(s.charAt(1)).toUpperCase())).log();
    }

    //Reduce list of elements to a single element
    public Flux<String> Reduce(){
          return Flux.fromIterable(List.of("Bitcoin","Crypto")).reduce((accumulator,current)->accumulator+"/"+current).flux().log();
    }

    //Combine the two flux

    public Flux<String>  Combine(){
        Flux<String> books = Flux.just("Famous Five","Ponniyin Selvan");
        Flux<String> authors = Flux.just("Enid Blyton","Kalki");
        return Flux.zip(books,authors,(first,second)->first + " " + second).log();
    }


    public Mono<String> monoMap(){
        return Mono.just("ABCDE")
                .map(String::toLowerCase)
                .log();
    }
    public Mono<List<String>> monoFlatMap(){
        return Mono.just("ABCDEF")
                .flatMap(s -> Mono.just(List.of(s.split(""))))
                .log();
    }

     public static void main(String[] args){

        ReactiveSources rs = new ReactiveSources();
        rs.Movies().subscribe(e->{
             System.out.println(e);
        });
        rs.Numbers().subscribe(e->{
            System.out.println(e);
        });
        rs.Num().subscribe(e->{
            System.out.println(e);
        });
        rs.Reduce().subscribe(e->{
            System.out.println(e);
        });
        rs.Combine().subscribe(e->{
            System.out.println(e);
        });
        rs.Transform().subscribe(e->{
            System.out.println(e);
        });
        rs.monoFlatMap().subscribe(e->{
            System.out.println(e);
        });
        rs.monoMap().subscribe(e->{
            System.out.println(e);
        });


     }



}
