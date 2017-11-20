package org.firstinspires.ftc.teamcode.core;

public abstract class Utility {
    public static double clamp(double value, double min, double max) {
        return Math.min(Math.max(value, min), max);
    }

    public static double clamp1(double x) {
        return Utility.clamp(x, -1, 1);
    }
}
