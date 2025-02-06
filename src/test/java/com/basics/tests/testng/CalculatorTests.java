package com.basics.tests.testng;

import com.basics.demo.calculator.Calculator;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CalculatorTests {
    Calculator calculator = new Calculator();

    @BeforeMethod(alwaysRun = true)
    public void clear() {
        calculator.clear();
    }

    @Test(dataProvider = "operationsWithZero", groups = {"test"})
    public void divisionTests(Double operand1, Double operand2, Double expectedResult){
        Double result = calculator
                .setFirstOperand(operand1)
                .divide()
                .setSecondOperand(operand2)
                .equal()
                .getResult();
        Assert.assertEquals(result, expectedResult);
    }

    @Test(dataProvider = "operationsWithZeroFromFile")
    public void divisionTestsFromFile(Double operand1, Double operand2, Double expectedResult){
        Double result = calculator
                .setFirstOperand(operand1)
                .divide()
                .setSecondOperand(operand2)
                .equal()
                .getResult();
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider(name = "operationsWithZero")
    public Object[][] provideOperationsWithZeroData(){
        return new Object[][]{
                {0.0, 4.0, 0.0},
                {4.0, 0.0, null},
                {4.0, 2.0, 2.0}
        };
    }

    @DataProvider(name = "operationsWithZeroFromFile")
    public Object[][] provideOperationsWithZeroDataFromFile(){
        try {
            List<String> list = FileUtils.readLines(new File("src/test/resources/forDivisionTests"), StandardCharsets.UTF_8);
            Object[][] data = new Object[list.size()][3];
            for (int i = 0; i < list.size(); i++) {
                String line = list.get(i);
                String[] split = line.split(",");
                for (int j = 0; j < 3; j++) {
                    data[i][j] = split[j].equals("null") ? null : Double.parseDouble(split[j]);
                }
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
