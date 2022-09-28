package Oppgave3;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Oppg3 {
    public static void main(String[] args) {
        List<Ansatt> listeAvAnsatte = Arrays.asList(
                new Ansatt("Lars", "Persen", Kjonn.MANN, "konsulet", 400000),
                new Ansatt("Daniel", "Jensen", Kjonn.MANN, "prosjektleder", 750000),
                new Ansatt("Tuva", "Vetlesen", Kjonn.KVINNE, "sjef", 400000),
                new Ansatt("Fredrikke", "Johnson", Kjonn.KVINNE, "regnskapsfører", 800000),
                new Ansatt("Thom", "Persen", Kjonn.MANN, "sjef", 1000000));

        //a) liste av alle etternavn
        List <String> etternavn = listeAvAnsatte.stream().map(Ansatt::getEtternavn).toList();
        System.out.println("a) " + etternavn);

        //b) skriver ut antall kvinner
        long antallKvinner = listeAvAnsatte.stream().filter(p->p.getKjonn().equals(Kjonn.KVINNE)).count();
        System.out.println("b) Antall kvinner: " + antallKvinner);

        //c) regne ut gjennomsnittslønna til kvinnene
       Double gjenommsnittsLonnKvinner = listeAvAnsatte.stream()
                 .filter(p->p.getKjonn().equals(Kjonn.KVINNE))
                 .mapToInt(Ansatt::getAarslonn).average().getAsDouble();
        System.out.println("c) Gjennomsnittslønn kvinner: " + gjenommsnittsLonnKvinner);

        //d) gi alle sjefer lønnsøkning på 7%, skriver ut den listen av ansatte etter lønnsøkningen
        System.out.println("d) ");
        listeAvAnsatte.stream().filter(p->p.getStilling().contains("sjef")).forEach(p->p.setAarslonn(p.getAarslonn() * 107/100));
        listeAvAnsatte.forEach(System.out::println);

        //e) tjener noen mere en 800 000kr?
        boolean overÅtteHundreTusen = listeAvAnsatte.stream().anyMatch(p->p.getAarslonn() > 800000);
        System.out.println("e) Tjener noen mere en 800000? " + overÅtteHundreTusen);

        //f) skriver ut alle ansatte
        System.out.println("f) ");
        listeAvAnsatte.stream().forEach(System.out::println);

        //g) finner ansatte med minst lønn
        List<Ansatt> lavestLonn = listeAvAnsatte.stream().min(Comparator.comparing(Ansatt::getAarslonn)).stream().toList();
        System.out.println("g) Den/de med lavest lønn: " + lavestLonn);

        //h)summen av alle heltall i [1, 1000> som er delelig med 3 eller 5
        int sum = IntStream.rangeClosed(0, 999).filter(x -> x%3 == 0).filter(x->x%5 ==0).sum();
        System.out.println("h) Summen av alle heltall fra 1-999 som er delelig med 3 eller 5: " + sum);










    }

}
