package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {

    public static void main(String[] args) throws IOException {

        // file - файловая переменная, хранит адрес файла
        File file = new File("C://Users//Boss//Desktop//Java_projects//Hackaton//data.txt");
        FileWriter fileWriter = new FileWriter(file);

        int x = 0, y = 0;
        for (int i = 0; i < 20; i++) {
            x = (int)(Math.random() * 100);
            y = (int)(Math.random() * 100);
            fileWriter.write( x + " " + y + "\n");
        }
        fileWriter.flush();  // пусть будет
        fileWriter.close();



        XYSeries s1 = new XYSeries("grapg");
        int a = 0, b = 0;
        Scanner scan = new Scanner(file);
        while( scan.hasNext() ) {
            a = scan.nextInt();
            b = scan.nextInt();
            s1.add(a, b);
        }

        scan.close();

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        //chart sam
        JFreeChart chart = ChartFactory.createXYLineChart("graph", "x", "y", dataset, PlotOrientation.VERTICAL, true, true, false);

        // create form and display
        ChartFrame frame = new ChartFrame("...", chart);
        frame.pack();
        frame.setVisible(true);
    }
}


