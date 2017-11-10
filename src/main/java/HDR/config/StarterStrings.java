package HDR.config;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class StarterStrings {
    public static Text EnviroKitString = Text.builder("Redeem Enviro Kit").onClick(TextActions.runCommand("/start envirokit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Enviro kit"))).style(TextStyles.BOLD).build();
    public static Text RefinedKitString = Text.builder("Redeem Refined Kit").onClick(TextActions.runCommand("/start refinedkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Refined kit"))).style(TextStyles.BOLD).build();
    public static Text ThermalKitString = Text.builder("Redeem Thermal Kit").onClick(TextActions.runCommand("/start thermalkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Thermal kit"))).style(TextStyles.BOLD).build();
    public static Text XnetKitString = Text.builder("Redeem XNet Kit").onClick(TextActions.runCommand("/start xnetkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the XNet kit"))).style(TextStyles.BOLD).build();
    public static Text FarmerKitString = Text.builder("Redeem Farmer Kit").onClick(TextActions.runCommand("/start farmerkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Farmer kit"))).style(TextStyles.BOLD).build();
    public static Text EnchanterKitString = Text.builder("Redeem Enchanter Kit").onClick(TextActions.runCommand("/start enchanterkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Enchanter kit"))).style(TextStyles.BOLD).build();

}
