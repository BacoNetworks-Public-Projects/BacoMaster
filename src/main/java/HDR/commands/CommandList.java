package HDR.commands;

import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class CommandList {
    private static CommandSpec RefinedCMD = CommandSpec.builder().description(Text.of("Redeem Refined Kit")).permission("master.starterkits").executor(new RefinedKit()).build();
    private static CommandSpec EnviroCMD = CommandSpec.builder().description(Text.of("Redeem Enviro Kit")).permission("master.starterkits").executor(new EnviroKit()).build();
    private static CommandSpec ThermalCMD = CommandSpec.builder().description(Text.of("Redeem Thermal Kit")).permission("master.starterkits").executor(new ThermalKit()).build();
    private static CommandSpec XnetCMD = CommandSpec.builder().description(Text.of("Redeem XNet Kit")).permission("master.starterkits").executor(new XnetKit()).build();
    private static CommandSpec FarmerCMD = CommandSpec.builder().description(Text.of("Redeem Farmer Kit")).permission("master.starterkits").executor(new FarmerKit()).build();
    private static CommandSpec EnchanterCMD = CommandSpec.builder().description(Text.of("Redeem Enchanter Kit")).permission("master.starterkits").executor(new EnchanterKit()).build();
    public static CommandSpec StarterCMD = CommandSpec.builder().description(Text.of("")).executor(new StarterCommand()).child(RefinedCMD, "refinedkit").child(EnviroCMD, "envirokit").child(ThermalCMD, "thermalkit").child(XnetCMD,"xnetkit").child(FarmerCMD,"farmerkit").child(EnchanterCMD,"enchanterkit").permission("master.starterkits").build();
}
