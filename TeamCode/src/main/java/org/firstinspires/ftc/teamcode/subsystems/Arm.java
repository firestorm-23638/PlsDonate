package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends SubsystemBase {

    public enum ArmState {
        HOME(0),
        SCORE(0.4);

        public double pos;
        private ArmState(double pos) {
            this.pos = pos;
        }

    }

    public enum ClawState{
        OPEN(0),
        CLOSE(1);

        public double pos;
        private ClawState(double pos) {
            this.pos = pos;
        }
    }
    private Servo arm;
    private Servo claw;

    public Arm(HardwareMap hMap) {
        arm = hMap.get(Servo.class, "arm");
        claw = hMap.get(Servo.class, "claw");

    }

    public Command goToPos(ArmState state) {
        return new InstantCommand(() -> this.arm.setPosition(state.pos));
    }

    public Command armClawOpen(){
        return new InstantCommand(()-> this.arm.setPosition(ClawState.OPEN.pos));
    }

    public Command armClawClose(){
        return new InstantCommand(()-> this.arm.setPosition(ClawState.CLOSE.pos));
    }
}