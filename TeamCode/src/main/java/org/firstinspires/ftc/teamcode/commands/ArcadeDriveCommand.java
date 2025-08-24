package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import java.util.function.DoubleSupplier;

public class ArcadeDriveCommand extends CommandBase {
    private final Drivetrain drivetrain;
    private final DoubleSupplier fwd, rot, translate;

    public ArcadeDriveCommand(Drivetrain drivetrain, DoubleSupplier fwd, DoubleSupplier rot, DoubleSupplier translate) {
        this.drivetrain = drivetrain;
        this.fwd = fwd;
        this.rot = rot;
        this.translate = translate;

        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.mecanum(translate.getAsDouble(), fwd.getAsDouble(), rot.getAsDouble());
    }
}
