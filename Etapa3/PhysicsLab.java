public class PhysicsLab {
   public static void main(String[] args) {
      if (args.length != 3)  {
        System.out.println("usage: java PhysicsLab <delta_time[s]> <end_time[s]> <sampling_time[s]>");
        System.exit(-1);
      }
      double deltaTime = Double.parseDouble(args[0]);    // [s]
      double endTime = Double.parseDouble(args[1]);      // [s]
      double samplingTime = Double.parseDouble(args[2]); // [s]
      MyWorld world = new MyWorld(System.out);
      
      double mass = 1.0;      // 1 [kg] 
      double radius = 0.1;    // 10 [cm] 
      double position = 0;  // 0 [m] 
      double speed = 0;     // 0 [m/s]
      
      FixedHook f0=new FixedHook(position);
      Ball b0 = new Ball(mass, radius, 10, speed);
      Spring spring = new Spring(1, 1);
      
      spring.attachEnd(f0);
      spring.attachEnd(b0);
      
      world.addElement(spring);
      world.addElement(f0);
      world.addElement(b0);
      world.simulate(deltaTime, endTime, samplingTime); // delta time[s], total simulation time [s].
   }
}
