public class Planet {
    //instance fields

    public double xxPos; // its current x position
    public double yyPos;// its current y position
    public double xxVel;// its current velocity in x direction
    public double yyVel;// its current velocity in y direction
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    // constructors
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;


    }

    public Planet(Planet p){

        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;

    }

    public double calcDistance(Planet givenPlanet){

        double dx= givenPlanet.xxPos -this.xxPos;
        double dy= givenPlanet.yyPos -this.yyPos;
        double distance = Math.sqrt(dx*dx+dy*dy);
        return distance;

    }

    public double calcForceExertedBy(Planet givenPlanet){
        double distance = calcDistance(givenPlanet);
        double force = (G*this.mass*givenPlanet.mass)/(distance*distance);
        return force;



    }

    public double calcForceExertedByX(Planet givenPlanet){
        double distance = calcDistance(givenPlanet);
        double dx = givenPlanet.xxPos - this.xxPos;
        double force = calcForceExertedBy(givenPlanet);
        return force*dx/distance;

    }
    public double calcForceExertedByY(Planet givenPlanet){
        double distance = calcDistance(givenPlanet);
        double dy = givenPlanet.yyPos - this.yyPos;
        double force = calcForceExertedBy(givenPlanet);
        return force*dy/distance;

    }

    public double calcNetForceExertedByX(Planet[] planets){
      double netForceByX = 0.0;
      for(Planet planet:planets){
        if(!this.equals(planet)){
            netForceByX+= calcForceExertedByX(planet);
        }
      }
      return netForceByX;
    }

    public double calcNetForceExertedByY(Planet[] planets){
      double netForceByY = 0.0;
      for(Planet planet:planets){
        if(!this.equals(planet)){
          netForceByY+= calcForceExertedByY(planet);
        }

      }
      return netForceByY;
    }

    public void update(double dt, double fX, double fY){
        double newXVel = this.xxVel + dt*fX/this.mass;
        double newYVel = this.yyVel + dt*fY/this.mass;
        double newXPos = this.xxPos + dt*newXVel;
        double newYPos = this.yyPos + dt*newYVel;
        // update the coordinates
        this.xxPos = newXPos;
        this.yyPos = newYPos;

        // update the current velocity
        this.xxVel = newXVel;
        this.yyVel = newYVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+imgFileName);
    }



}
