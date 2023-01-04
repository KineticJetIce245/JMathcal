package Jmathcal.Plotter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.CardLayout;

import Jmathcal.Expression.Expressions;
import Jmathcal.Expression.VariablePool;
import Jmathcal.IOControl.IOBridge;

public class PlotterTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                constructUI();
            }
        });
/*
        Thread myThread = new Thread(){
            public void run() {
                constructUI();
            }
        };
*/
        //myThread.run();
    }
    

    private static void constructUI() {
        VariablePool vp = new VariablePool();
        Expressions rightExpr = Expressions.parseFromFlattenExpr("ln2x/5.6-sinx", vp, IOBridge.DFLT_BRIDGE);
        Expressions leftExpr = Expressions.parseFromFlattenExpr("y", vp, IOBridge.DFLT_BRIDGE);

        int[] resolution = {50, 50};
        int[] length = {10, 10};
        double[] origin = {-5, -5};
        int[] planeSize = {1000, 1000};
        
        PlotterPlane.PlaneInfo planeInfo = new PlotterPlane.PlaneInfo(resolution, length, origin, planeSize);

        PlotterPlane myPlane = new PlotterPlane(planeInfo, rightExpr, leftExpr);
        JFrame jf = new JFrame();
        jf.setLocationRelativeTo(null);
        CardLayout card = new CardLayout();
        jf.setSize(1000,1000);
        jf.setLayout(card);
        myPlane.subdivide();
        myPlane.subdivide();
        myPlane.subdivide();
        myPlane.subdivide();

        jf.add(new PlotterGraph(myPlane.subdivide(), planeInfo));;

        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
