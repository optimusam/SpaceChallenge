import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("U1 Rockets");
        System.out.println("Total cost Phase 1: "+formatter.format(sim.runSimulation(sim.loadU1(sim.beginPhase1()))));
        System.out.println("Total cost Phase 2: "+formatter.format(sim.runSimulation(sim.loadU1(sim.beginPhase2()))));
        System.out.println("U2 Rockets");
        System.out.println("total cost Phase 1: "+formatter.format(sim.runSimulation(sim.loadU2(sim.beginPhase1()))));
        System.out.println("total cost Phase 2: "+formatter.format(sim.runSimulation(sim.loadU2(sim.beginPhase2()))));

    }
}
