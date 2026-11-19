
package net.indev.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class IndevSettingsScreen extends Screen {
    private final Screen parent;
    private int rowY;

    public IndevSettingsScreen(Screen parent) {
        super(Component.literal("Minecraft Indev Settings"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int w = 260;
        int x = (this.width - w) / 2;
        rowY = Math.max(48, this.height / 2 - 100);

        addToggle(x, "Ocultar barra de experiencia",
                () -> IndevConfig.hideExperienceBar,
                v -> IndevConfig.hideExperienceBar = v);

        addToggle(x, "Ocultar indicador de correr",
                () -> IndevConfig.hideSprintIndicator,
                v -> IndevConfig.hideSprintIndicator = v);

        addToggle(x, "Texto Minecraft Indev 2.23",
                () -> IndevConfig.showIndevLabel,
                v -> IndevConfig.showIndevLabel = v);

        addToggle(x, "Neblina clásica",
                () -> IndevConfig.classicFog,
                v -> IndevConfig.classicFog = v);

        addToggle(x, "Textura de cerdo para Creeper",
                () -> IndevConfig.pigCreeperTexture,
                v -> IndevConfig.pigCreeperTexture = v);

        addToggle(x, "Explosión al morir",
                () -> IndevConfig.explodeOnCreeperDeath,
                v -> IndevConfig.explodeOnCreeperDeath = v);

        addRenderableWidget(Button.builder(
                Component.literal("Vista previa del inventario Indev"),
                b -> Minecraft.getInstance().gui.setScreen(
                        new IndevInventoryPreviewScreen(this)))
                .bounds(x, rowY + 8, w, 20)
                .build());

        addRenderableWidget(Button.builder(
                Component.literal("Volver"),
                b -> Minecraft.getInstance().gui.setScreen(parent))
                .bounds(x, this.height - 30, w, 20)
                .build());
    }

    private void addToggle(int x, String label,
                           java.util.function.BooleanSupplier getter,
                           java.util.function.Consumer<Boolean> setter) {

        addRenderableWidget(Button.builder(
                toggleText(label, getter.getAsBoolean()),
                button -> {
                    boolean next = !getter.getAsBoolean();
                    setter.accept(next);
                    button.setMessage(toggleText(label, next));
                })
                .bounds(x, rowY, 260, 20)
                .build());

        rowY += 24;
    }

    private Component toggleText(String label, boolean enabled) {
        return Component.literal(label + ": " + (enabled ? "ON" : "OFF"));
    }

    @Override
    public void extractRenderState(
            GuiGraphicsExtractor graphics,
            int mouseX,
            int mouseY,
            float partialTick) {

        super.extractRenderState(graphics, mouseX, mouseY, partialTick);

        graphics.centeredText(
                this.font,
                "MINECRAFT INDEV SETTINGS",
                this.width / 2,
                20,
                0xFFFFFFFF
        );
    }

    @Override
    public void onClose() {
        Minecraft.getInstance().gui.setScreen(parent);
    }
}
