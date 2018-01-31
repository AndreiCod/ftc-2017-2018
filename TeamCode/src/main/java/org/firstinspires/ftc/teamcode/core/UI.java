package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Hashtable;
import java.util.Map;

public final class UI {
    public final Gamepad gp;

    static final double TIME_AFTER_PRESS_BUTTON_TOGGLE = 0.3;

    private ElapsedTime runtime = new ElapsedTime();

    private Map<GamepadButton, Double> lastTime = new Hashtable<>();
    private Map<GamepadButton, Boolean> lastState = new Hashtable<>();
    private Map<GamepadButton, Boolean> buttonLock = new Hashtable<>();

    public UI(Gamepad gp) {
        this.gp = gp;

        for (GamepadButton button : GamepadButton.values()) {
            buttonLock.put(button, false);
            lastState.put(button, false);
            lastTime.put(button, 0.0);
        }
    }

    private boolean getButtonValue(GamepadButton button) {
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
            case DPAD_RIGHT:
                return this.gp.dpad_right;
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

    public boolean checkButtonHold(GamepadButton button) {
        return getButtonValue(button);
    }

    public boolean checkButtonToggle(GamepadButton button) {
        boolean buttonValue = getButtonValue(button);
        boolean lastValue = lastState.get(button);

        // If false, no state change is requested.
        if (!buttonValue) {
            return lastValue;
        } else {
            // Record new state.

            // Unlock if enough time passed.
            if (runtime.time() - lastTime.get(button) > TIME_AFTER_PRESS_BUTTON_TOGGLE) {
                lastTime.put(button, runtime.time());
                buttonLock.put(button, false);
            }

            // If its currently locked.
            if (buttonLock.get(button) == true) {
                return lastValue;
            } else {
                // Toggle state.
                lastState.put(button, !lastValue);

                // Lock state.
                buttonLock.put(button, true);
                // Update time.
                lastTime.put(button, runtime.time());

                return !lastValue;
            }
        }
    }
}