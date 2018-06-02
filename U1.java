import java.util.Random;

public class U1 extends Rocket {
    U1() {
        cost = 100000000;
        weight = 10000;
        MAX_WEIGHT = 18000;
        launch_explosion = 5;
        crash_landing = 1;
    }

    @Override
    public boolean launch() {
        double chance_of_explosion = launch_explosion * cargo_weight/MAX_WEIGHT;
        Random rand = new Random();
        int rno = rand.nextInt(101);
        return chance_of_explosion<rno;
    }

    @Override
    public boolean land() {
        double chance_of_crash_landing = crash_landing * cargo_weight/MAX_WEIGHT;
        Random rand = new Random();
        int rno = rand.nextInt(101);
        return chance_of_crash_landing<rno;
    }
}
