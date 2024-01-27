// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class Controller {
     //public static final int USB_DRIVECONTROLLER = 0;  //if using xbox
     public static final int MY_JOYSTICK = 0; //if using Thrustmaster joysticks
  }
  
  public static class Motors {

  public static final int ID_ELEV_LEFT = 3;//TODO find IDs for left/right motor controllers
  public static final int ID_ELEV_RIGHT = 4;
   public static final int ID_SHOOTER_LEFT = 1;
  public static final int ID_SHOOTER_RIGHT = 35;

  public static final int SMART_CURRENT_LIMIT = 40;

  public static final double ELEV_UP_SPEED = 0.5;
  public static final double ELEV_DOWN_SPEED = -0.25;
  public static final double SHOOTER_FWD_SPEED = 0.6;
  public static final double SHOOTER_REV_SPEED = -0.6;

  }

  public static class Limits {
    public static final int DIO_BOT_LIMIT = 0;
    public static final int DIO_TOP_LIMIT = 1;
  }

  public static class Thrustmaster {
    public static final int TRIGGER = 1;
    public static final int BUTTON_MIDDLE = 2;
    public static final int BUTTON_LEFT = 3;
    public static final int BUTTON_RIGHT = 4;
    public static final int LEFT_BASE_1 = 11;
    public static final int LEFT_BASE_2 = 16;
    public static final int LEFT_BASE_3 = 13;
    public static final int LEFT_BASE_4 = 14;
    public static final int RIGHT_BASE_5 = 7;
    public static final int RIGHT_BASE_6 = 8;
    public static final int RIGHT_BASE_7 = 5;
    public static final int RIGHT_BASE_8 = 10;

    public static class AxesThrustmaster {
        public static final int X = 0;
        public static final int Y = 1;
        public static final int Z = 2;
        public static final int THROTTLE = 3;
    }       
}

public static class XboxController {
  public static final int A = 1;
  public static final int B = 2;
  public static final int X = 3;
  public static final int Y = 4;
  public static final int LB = 5;
  public static final int RB = 6;
  public static final int VIEW = 7;
  public static final int MENU = 8;
  public static final int LM = 9;
  public static final int RM = 10;

  public static class AxesXbox {
    public static final int LX = 0;
    public static final int LY = 1;
    public static final int LTrig = 2;
    public static final int RTrig = 3;
    public static final int RX = 4;
    public static final int RY = 5;
  }
  public class POVXbox {
    public static final int UP_ANGLE = 0;
    public static final int RIGHT_ANGLE = 90;
    public static final int DOWN_ANGLE = 180;
    public static final int LEFT_ANGLE = 270;
  }
}

  }

