package week5.class_problems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PlacementEngine {

    public static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return (cgpa >= 6.5) && (codingScore >= 60);
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlistedList = new ArrayList<>();
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlistedList.add(c);
            }
        }

        Candidate[] shortlistedArray = shortlistedList.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            sb.append(i + 1).append(". ").append(shortlistedArray[i].name)
                    .append(" (").append(shortlistedArray[i].getCompositeScore()).append(")");
            if (i < shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}


