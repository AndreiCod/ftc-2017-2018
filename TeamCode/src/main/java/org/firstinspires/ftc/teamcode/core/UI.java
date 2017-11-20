package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Hashtable;
import java.util.Map;

public final class UI {
    public final Gamepad gp;

    static final double TIME_AFTER_PRESS_BUTTON_TOGGLE = 0.3;

    private ElapsedTime runtime = new ElapsedTime();

    private Map<GamepadButtons, Double> lastTime = new Hashtable<>();
    private Map<GamepadButtons, Boolean> lastState = new Hashtable<>();
    private Map<GamepadButtons, Boolean> buttonLock = new Hashtable<>();

    UI(Gamepad gp) {
        this.gp = gp;
    }

    private boolean getButtonValue(GamepadButtons button) {
        switch (button) {
            case A:
                return this.gp.a;
            case B:
                return this.gp.b;
            case X:
                return this.gp.x;
            case Y:
                return this.gp.y;
            case DPAD_DOWN:
                return this.gp.dpad_down;
            case DPAD_LEFT:
                return this.gp.dpad_left;
            case DPAD_UP:
                return this.gp.dpad_up;
            case RIGHT_BUMPER:
                return this.gp.right_bumper;
            case LEFT_BUMPER:
                return this.gp.left_bumper;
            case START:
                return this.gp.start;
            default:
                return false;
        }
    }

    public boolean checkButtonHold(GamepadButtons button) {
        return getButtonValue(button);
    }

    public boolean checkButtonToggle(GamepadButtons button) {
        boolean buttonValue = getButtonValue(button);

        // First time button press.
        if (buttonLock.containsKey(button) == false) {
            buttonLock.put(button, false);
            lastTime.put(button, 0.0);

            return buttonValue;
        }

        if (buttonValue == false) {
            // Disable the button's lock.
            buttonLock.put(button, false);
            return false;
        }

        if (buttonLock.get(button) == true)
            return false;

        buttonLock.put(button, true);

        if (runtime.time() - lastTime.get(button) > TIME_AFTER_PRESS_BUTTON_TOGGLE) {
            lastTime.put(button, runtime.time());
            return true;
        }

        return false;
    }
}