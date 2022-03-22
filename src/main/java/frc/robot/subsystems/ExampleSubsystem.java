// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  PWM servoLeft, servoRight;

  public ExampleSubsystem() {
    SmartDashboard.putNumber("LEFT position", 0);
    SmartDashboard.putNumber("RIGHT position", 1);

    servoLeft = new PWM(4);
    servoRight = new PWM(5);
    servoLeft.setBounds(2.5, 0, 1.5, 1, 0.5);
    servoRight.setBounds(2.5, 0, 1.5, 1, 0.5);

    setBottom();
  }

  @Override
  public void periodic() {
    // System.out.println("Current servoRight position = " +
    // servoRight.getPosition());
    // System.out.println("Current servoLeft position = " +
    // servoLeft.getPosition());

    System.out.println("Current Left, Right = ");

    System.out.println(servoLeft.getPosition() + ", " + servoRight.getPosition());
    // System.out.println("Current servoLeft raw = " + servoLeft.getRaw());
    // This method will be called once per scheduler run
  }

  public void setPosition(double s) {
    servoLeft.setPosition(Math.abs(s));
    servoRight.setPosition(1 - Math.abs(s));
  }

  public void fetchPosition() {
    double left = SmartDashboard.getNumber("LEFT position", 0);
    double right = SmartDashboard.getNumber("RIGHT position", 0);

    servoLeft.setPosition(left);
    servoRight.setPosition(right);

  }

  public void setHalf() {
    servoLeft.setPosition(0.5);
    servoRight.setPosition(0.5);
  }

  public void setBottom() {
    servoLeft.setPosition(0);
    servoRight.setPosition(1);
  }

  public void setTop() {
    servoLeft.setPosition(1);
    servoRight.setPosition(0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
