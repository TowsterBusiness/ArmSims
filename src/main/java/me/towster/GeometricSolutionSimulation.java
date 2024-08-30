/*
 * All Calculations are derived from https://www.desmos.com/calculator/6ocjywflgo
 * I am not smart enough to figure this out.
 *
 *
 *
 *
 *
 *
 * */

package me.towster;

import me.towster.utils.MouseListener;
import me.towster.utils.Rectangle;
import me.towster.utils.Scene;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;
import java.util.Queue;

import static org.lwjgl.opengl.GL11.*;

public class GeometricSolutionSimulation extends Scene {

    Rectangle arm1;
    Rectangle arm2;
    Rectangle arm3;
    Rectangle arm4;
    float armBuffer = 0.05f;
    float armLength1 = 0.4f;
    float armLength2 = 0.4f;

    float lastArmAngle1;
    float lastArmAngle2;

    @Override
    public void update(float dt) {
        // TODO: Add code to make sure that the pointer is not too close to the orgin or too far from the outside

        float finX = (MouseListener.get().getX() / 400 - 1);
        float finY = - (MouseListener.get().getY() / 300 - 1);

        double c = Math.sqrt(Math.pow(finX, 2) + Math.pow(finY, 2));

        double a1 = Math.PI - Math.acos((Math.pow(armLength1, 2) + Math.pow(armLength2, 2) - Math.pow(c, 2)) / (2 * armLength1 * armLength2));
        double a2 = Math.PI + Math.acos((Math.pow(armLength1, 2) + Math.pow(armLength2, 2) - Math.pow(c, 2)) / (2 * armLength1 * armLength2));

        double ad1 = Math.atan2(finY, finX) - Math.atan2(Math.sin(a1) * armLength2, armLength1 + Math.cos(a1) * armLength2);
        double ad2 = Math.atan2(finY, finX) - Math.atan2(Math.sin(a2) * armLength2, armLength1 + Math.cos(a2) * armLength2);

        double ax1 = Math.cos(ad1) * armLength1;
        double ay1 = Math.sin(ad1) * armLength1;
        double ax2 = Math.cos(ad2) * armLength1;
        double ay2 = Math.sin(ad2) * armLength1;

        double bx1 = ax1 + Math.cos(a1 + ad1) * armLength2;
        double by1 = ay1 + Math.sin(a1 + ad1) * armLength2;
        double bx2 = ax2 + Math.cos(a2 + ad2) * armLength2;
        double by2 = ay2 + Math.sin(a2 + ad2) * armLength2;
    }
}
