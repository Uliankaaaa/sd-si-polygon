package com.netcracker.hometaskWithTriangle;

import com.netcracker.hometaskWithTriangle.triangles.EquilateralTriangle;
import com.netcracker.hometaskWithTriangle.triangles.IsoscelesTriangle;
import com.netcracker.hometaskWithTriangle.triangles.RightTriangle;
import com.netcracker.hometaskWithTriangle.triangles.Triangle;
import com.netcracker.hometaskWithTriangle.view.InputSidesOfTheTriangleProvider;
import com.netcracker.hometaskWithTriangle.view.Printer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputSidesOfTheTriangleProvider sidesOfTheTriangleProvider = new InputSidesOfTheTriangleProvider();
        List<Double> sidesOfTheTriangle = sidesOfTheTriangleProvider.getSidesOfTheTriangle();

        if (!CorrectnessOfTheParties.isTriangle(sidesOfTheTriangle)) {
            Printer.print("It is not a triangle!");
            System.exit(0);
        }

        TriangleHolder triangleHolder = new TriangleHolder();
        triangleHolder.addTriangle(new RightTriangle())
                .addTriangle(new EquilateralTriangle())
                .addTriangle(new IsoscelesTriangle());


        triangleHolder.getTriangles().stream()
                .filter(triangle -> triangle.checkTriangle(sidesOfTheTriangle))
                .forEach(System.out::println);
    }
}


/*
    private static void checkRules(List<Rule> ruleList, InputStringProvider string) {
        for (Rule rule : ruleList) {
            if (rule.checkString(string)) {
                Rule.countRules++;
                System.out.println(rule.getClass().getSimpleName() + " is true");
            }
        }
        if (Rule.countRules == 0) {//If there's no confirmed rules
            System.out.println("This line does not fit under any rule!");
        }
    }
}*/

