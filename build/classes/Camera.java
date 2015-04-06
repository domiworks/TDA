/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dominikus
 */
public class Camera {

    private double movementSpeed;
    private double lookAtDistance;
    private double angleIncrement;
    private double fovy;

    private double xLookAt;
    private double yLookAt;
    private double zLookAt;
    private double xPlayerAt;
    private double yPlayerAt;
    private double zPlayerAt;
    private double xStep, yStep, zStep;
    private double viewAngle;
    private double viewAngle_z;

    public Camera() {
        movementSpeed = 2;
        lookAtDistance = -100.0;
        angleIncrement = 1.0;
        fovy = 55;

        xLookAt = 0;
        yLookAt = 0;
        zLookAt = 100;
        xPlayerAt = -100;
        yPlayerAt = -100;
        zPlayerAt = 100;
        viewAngle = -90.0;
        viewAngle_z = 15;
    }

    /*------------*/
    public void setFOVy(double fovy) {
        this.fovy = fovy;
    }

    public double getFOVy() {
        return fovy;
    }

    /*------------*/
    public void cameraOperate() {
        xStep = Math.cos(Math.toRadians(viewAngle));
        yStep = Math.sin(Math.toRadians(viewAngle));
        zStep = Math.tan(Math.toRadians(viewAngle_z));

        xLookAt = xPlayerAt + (lookAtDistance * xStep);
        yLookAt = yPlayerAt + (lookAtDistance * yStep);
        zLookAt = zPlayerAt + (lookAtDistance * zStep);
    }

    /*------------*/
    public double getXPlayerAt() {
        return xPlayerAt;
    }

    public double getYPlayerAt() {
        return yPlayerAt;
    }

    public double getZPlayerAt() {
        return zPlayerAt;
    }

    public double getXLookAt() {
        return xLookAt;
    }

    public double getYLookAt() {
        return yLookAt;
    }

    public double getZLookAt() {
        return zLookAt;
    }
    /*------------*/

    public void trackUp() {
        //track up
        zPlayerAt += movementSpeed;
    }

    public void trackDown() {
        //track down
        zPlayerAt -= movementSpeed;
    }

    public void trackLeft() {
        //track left
        xPlayerAt += yStep * movementSpeed;
        yPlayerAt -= xStep * movementSpeed;
    }

    public void trackRight() {
        //track right
        xPlayerAt -= yStep * movementSpeed;
        yPlayerAt += xStep * movementSpeed;
    }

    public void dollyIn() {
        //dolly in
        zPlayerAt -= zStep * movementSpeed;
        xPlayerAt -= xStep * movementSpeed;
        yPlayerAt -= yStep * movementSpeed;
    }

    public void dollyOut() {
        //dolly out
        zPlayerAt += zStep * movementSpeed;
        xPlayerAt += xStep * movementSpeed;
        yPlayerAt += yStep * movementSpeed;
    }

    public void tiltUp() {
        //tilt up
        if (viewAngle_z != -90) {
            viewAngle_z -= angleIncrement;
            zStep = Math.sin(Math.toRadians(viewAngle_z));
            System.out.println("z angle : " + viewAngle_z + "  zLookAt : " + zLookAt);
        }
    }

    public void tiltDown() {
        //tilt down
        if (viewAngle_z != 90) {
            viewAngle_z += angleIncrement;
            zStep = Math.sin(Math.toRadians(viewAngle_z));
            System.out.println("z angle : " + viewAngle_z + "  zLookAt : " + zLookAt);
        }
    }

    public void rotateLeft() {
        //rotate left
        viewAngle += angleIncrement;
        xStep = Math.cos(Math.toRadians(viewAngle));
        yStep = Math.sin(Math.toRadians(viewAngle));
    }

    public void rotateRight() {
        //rotate right
        viewAngle -= angleIncrement;
        xStep = Math.cos(Math.toRadians(viewAngle));
        yStep = Math.sin(Math.toRadians(viewAngle));
    }

}
