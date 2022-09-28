package Oppgave2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class Oppg2 {
    public static void main(String[] args) {
        List<Ansatt> listeAvAnsatte = Arrays.asList(
                new Ansatt("Lars", "Persen", Kjonn.MANN, "konsulet", 550000),
                new Ansatt("Daniel", "Jensen", Kjonn.MANN, "prosjektleder", 650000),
                new Ansatt("Tuva", "Vetlesen", Kjonn.KVINNE, "grafisk designer", 300000),
                new Ansatt("Fredrikke", "Johnson", Kjonn.HEN, "regnskapsfører", 600000),
                new Ansatt("Thom", "Persen", Kjonn.KVINNE, "konsulet", 450000));
        printAll(listeAvAnsatte);

        System.out.println("Fast kroneøke: ");
        Function<Ansatt, Integer> kroneTilleg = (a) -> a.getAarslonn() + 100000;
        lonnsoppgjor(listeAvAnsatte, kroneTilleg);
        printAll(listeAvAnsatte);

        System.out.println("Fast prosentøke: ");
        Function<Ansatt, Integer> prosentTilleg = (a) -> a.getAarslonn() * 110 / 100;
        lonnsoppgjor(listeAvAnsatte, prosentTilleg);
        printAll(listeAvAnsatte);

        System.out.println("Fast kronetillegg for lav lønn: ");
        Function<Ansatt, Integer> lavLonn = (a) -> {
            if (a.getAarslonn() <= 500000) {
                return a.getAarslonn() + 50_000;
            }
            return a.getAarslonn();

        };
        lonnsoppgjor(listeAvAnsatte, lavLonn);
        printAll(listeAvAnsatte);

        System.out.println("Prosentøke viss du er mann: ");
        Function<Ansatt, Integer> erMann = (a) -> {
            if (a.getKjonn().equals(Kjonn.MANN)) {
                return a.getAarslonn() * 120/100;
            }
            return a.getAarslonn();
        };
        lonnsoppgjor(listeAvAnsatte, erMann);
        printAll(listeAvAnsatte);
    }

    public static void printAll(List<Ansatt> liste) {
        System.out.println();
        for (Ansatt p : liste) {
            System.out.println(p);
        }
    }
    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt,Integer> funk){
        for (Ansatt a : ansatte){
            a.setAarslonn(funk.apply(a));
        }
    }
}

