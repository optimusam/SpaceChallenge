public class Rocket implements SpaceShip {
    int cargo_weight;
    double cost;
    int MAX_WEIGHT;
    int weight;
    double launch_explosion;
    double crash_landing;
    Rocket() {
        cargo_weight=0;
    }
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public void carry(Item item) {
        cargo_weight+=item.weight;
    }

    @Override
    public boolean canCarry(Item item) {
        return cargo_weight+item.weight<=MAX_WEIGHT;
    }
}
