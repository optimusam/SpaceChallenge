import java.util.Random;

public class U2 extends Rocket {
    U2() {
        cost = 120000000;
        weight = 18000;
        MAX_WEIGHT = 29000;
        launch_explosion = 4;
        crash_landing = 8;
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
