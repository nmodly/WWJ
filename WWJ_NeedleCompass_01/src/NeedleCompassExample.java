package gov.nasa.worldwind.examples;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Earth.BMNGOneImage;
import gov.nasa.worldwind.layers.LayerSet;
import javax.swing.JFrame;

/**
 * Using NeedledCompass.
 *
 * @author Antonio Santiago [asantiagop(at)gmail.com]
 */
public class NeedleCompassExample {

    private static class AppFrame extends javax.swing.JFrame {

        public AppFrame() {
            WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
            wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
            this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
            this.pack();

            BasicModel model = new BasicModel();
            wwd.setModel(model);

            LayerSet main = new LayerSet();

            main.add(new BMNGOneImage());

            CompassLayer compass1 = new CompassLayer();
            compass1.setPosition(CompassLayer.NORTHEAST);

            CompassLayer compass2 = new CompassLayer(true);
            compass2.setOpacity(0.6);
            compass2.setPosition(CompassLayer.SOUTHEAST);

            CompassLayer compass3 = new CompassLayer("some_dir/needlecompass.png", true);
            compass3.setShowTilt(false);
            compass3.setPosition(CompassLayer.SOUTHWEST);

            CompassLayer compass4 = new CompassLayer("some_dir/needlecompass.png", "some_dir/notched-compass.png");            
            compass4.setPosition(CompassLayer.NORTHWEST);

            main.add(compass1);
            main.add(compass2);
            main.add(compass3);
            main.add(compass4);
            main.setPickEnabled(false);

            model.setLayers(main);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

                                            public void run() {
                                                AppFrame appFrame = new AppFrame();
                                                appFrame.setSize(400, 400);
                                                appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                appFrame.setVisible(true);
                                            }
                                        });
    }
}
