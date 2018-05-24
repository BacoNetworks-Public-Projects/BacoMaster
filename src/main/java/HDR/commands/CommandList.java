package HDR.commands;

import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandList {
    private static CommandSpec ThermalCMD = CommandSpec.builder().description(Text.of("Redeem Thermal Expansion Kit")).permission("master.starterkits").executor(new TeKit()).build();
    private static CommandSpec AECMD = CommandSpec.builder().description(Text.of("Redeem AE Kit")).permission("master.starterkits").executor(new AEKit()).build();
    private static CommandSpec SurvivorCMD = CommandSpec.builder().description(Text.of("Redeem Forestry Kit")).permission("master.starterkits").executor(new SurvKit()).build();
    private static CommandSpec TinkerCMD = CommandSpec.builder().description(Text.of("Redeem Immersive Kit")).permission("master.starterkits").executor(new TinkersKit()).build();
    public static CommandSpec StarterCMD = CommandSpec.builder().description(Text.of("")).executor(new StarterCommand()).child(ThermalCMD, "thermalkit").child(AECMD, "aekit").child(SurvivorCMD, "survivorkit").child(TinkerCMD,"tinkerskit").permission("master.starterkits").build();
    public static CommandSpec ClearEntitiesCMD = CommandSpec.builder().description(Text.of("")).permission("master.command.entities").executor(new ClearEntitiesCommand()).build();
    public static CommandSpec BacoMasterCMD = CommandSpec.builder().description(Text.of("")).permission("master.command").executor(new BacoMasterCommand()).child(ClearEntitiesCMD, "clear").build();
}
