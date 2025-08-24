package org.firstinspires.ftc.teamcode.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.ArcadeDriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class Teleop extends CommandOpMode {
    private Drivetrain drivetrain;
    private Arm arm;
    private GamepadEx driver;
    @Override
    public void initialize() {
        this.arm = new Arm(this.hardwareMap.get(Servo.class, "arm"));
        this.driver = new GamepadEx(this.gamepad1);
        this.drivetrain = new Drivetrain(hardwareMap);

        this.driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(arm.goToPos(Arm.ArmState.SCORE))
            .whenReleased(arm.goToPos(Arm.ArmState.HOME));
        this.drivetrain.setDefaultCommand(new ArcadeDriveCommand(drivetrain, this.driver::getLeftY, this.driver::getRightX, this.driver::getLeftX));

        register(arm);
    }


}
