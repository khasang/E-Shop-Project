package com.eshop.tests;

import java.util.Arrays;

/**
 * Created by skuznet on 08.07.2015.
 */
public class Assert {
    public static void assertEquals(boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println("Success");
        }else {
            System.out.println("Failure: expected " + expected + ", actual " + actual);
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: " + expected + " ,actual " + actual);
        }
    }

    public static void assertEquals(char expected, char actual) {
        if (expected == actual) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: " + expected + " ,actual " + actual);
        }
    }

    public static void assertEquals(double expected, double actual) {
        if (expected == actual) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: " + expected + " ,actual " + actual);
        }
    }

    public static void assertEquals(double[] expected, double[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: ");
            for (double anExpected : expected) System.out.println(anExpected + "  ");

            System.out.println(", actual: ");
            for (double anActual : actual) System.out.print(anActual + "  ");
        }
    }

    public static void assertEquals(int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: ");
            for (int anExpected : expected) System.out.print(anExpected + "  ");

            System.out.println(", actual: ");
            for (int anActual : actual) System.out.print(anActual + "  ");
        }
    }

    public static void assertEquals(double[][] expected, double[][] actual) {
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: ");
            for (double[] anExpected : expected) {
                for (double anAnExpected : anExpected) {
                    System.out.print(anAnExpected + "  ");
                }
                System.out.println();
            }

            System.out.println(", actual: ");
            for (double[] anActual : actual) {
                for (double anAnActual : anActual) {
                    System.out.print(anAnActual + "  ");
                }
                System.out.println();
            }
        }
    }

    public static void assertEquals(int[][] expected, int[][] actual) {
        if (Arrays.deepEquals(expected, actual)) {
            System.out.println("Success");
        } else {
            System.out.println("Failure:expected: ");
            for (int[] anExpected : expected) {
                for (int anAnExpected : anExpected) {
                    System.out.print(anAnExpected + "  ");
                }
                System.out.println();
            }

            System.out.println(", actual: ");
            for (int[] anActual : actual) {
                for (int anAnActual : anActual) {
                    System.out.print(anAnActual + "  ");
                }
                System.out.println();
            }
        }
    }
}
