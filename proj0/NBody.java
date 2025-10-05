
import java.util.Scanner;

/**
 * simulate a universe specified in one of the data files
 */
public class NBody {
    private In in;

    public static double readRadius(String dataFile){
        /* Start reading in dataFile.txt */
        In in = new In(dataFile);
        /* if the file is not empty, the second line represents the radius of the universe. */


            // the first line represents the number of planets
            int numOfPlanets = in.readInt();
            // the second line represents the radius of the universe
            double radiusOfUniverse = in.readDouble();

            return radiusOfUniverse;


    }

    public static Planet[] readPlanets(String dataFile){
        In in = new In(dataFile);
        int numOfPlanets = in.readInt(); // the first line represents the number of planets
        double radiusOfUniverse = in.readDouble();// the second line represents the radius of the universe
        Planet[] planets = new Planet[numOfPlanets];
        for (int i=0;i<numOfPlanets;i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFile = in.readString();
            planets[i]= new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFile);
        }
        return planets;}

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double universeRadius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);

        StdDraw.setScale(-universeRadius, universeRadius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.enableDoubleBuffering();
        StdAudio.play("audio/2001.mid");

        for (Planet planet:planets){
            planet.draw();
        }





        //Create a time variable and set it to 0.
        // Set up a loop to loop until this time variable is T.
        double time = 0.0;
        while(time<T){
            //Calculate the net x and y forces for each planet,
            // storing these in the xForces and yForces arrays respectively.
            double[] xForce = new double[planets.length];
            double[] yForce = new double[planets.length];
            for(int i=0;i<planets.length;i++){
                xForce[i]=planets[i].calcNetForceExertedByX(planets);
                yForce[i]=planets[i].calcNetForceExertedByY(planets);

            }
            // update the planets after updating xForce and yForce
            for (int i =0;i<planets.length;i++){
                planets[i].update(dt,xForce[i],yForce[i]);
            }
            // draw background
            StdDraw.picture(0, 0, "images/starfield.jpg");
            // draw planets
            for (Planet planet:planets){
                planet.draw();
            }
            // show and pause
            StdDraw.show();
            StdDraw.pause(10);

            // increase time
            time += dt;

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universeRadius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }




}
