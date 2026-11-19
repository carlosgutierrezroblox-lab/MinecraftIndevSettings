
package net.indev.settings;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.network.chat.Component;

public final class IndevSettingsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ScreenEvents.AFTER_INIT.register(
                (client, screen, scaledWidth, scaledHeight) -> {

                    if (screen instanceof OptionsScreen) {

                        int buttonWidth = 200;
                        int x = (scaledWidth - buttonWidth) / 2;
                        int y = scaledHeight - 30;

                        Button button = Button.builder(
                                Component.literal("Minecraft Indev Settings"),
                                b -> client.gui.setScreen(
                                        new IndevSettingsScreen(screen))
                        )
                        .bounds(x, y, buttonWidth, 20)
                        .build();

                        Screens.getWidgets(screen).add(button);
                    }
                }
        );
    }
}
