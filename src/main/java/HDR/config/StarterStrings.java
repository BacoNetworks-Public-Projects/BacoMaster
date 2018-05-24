package HDR.config;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class StarterStrings {
    public static Text TinkersKitString = Text.builder("Redeem Tinkers Kit").onClick(TextActions.runCommand("/start tinkerskit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Tinkers kit"))).style(TextStyles.BOLD).build();
    public static Text SurvivorKitString = Text.builder("Redeem Survivor Kit").onClick(TextActions.runCommand("/start survivorkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Survivor kit"))).style(TextStyles.BOLD).build();
    public static Text AeKitString = Text.builder("Redeem Ae2 Kit").onClick(TextActions.runCommand("/start aekit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Ae2 kit"))).style(TextStyles.BOLD).build();
    public static Text ThermalKitString = Text.builder("Redeem Thermal Expansion Kit").onClick(TextActions.runCommand("/start thermalkit")).color(TextColors.AQUA).onHover(TextActions.showText(Text.of("Redeem the Thermal Expansion kit"))).style(TextStyles.BOLD).build();

}
