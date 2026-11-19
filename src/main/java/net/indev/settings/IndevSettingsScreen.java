package net.indev.settings;

import net.minecraft.client.gui.GuiGraphics;
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
        int w = 230;
        int x = (this.width - w) / 2;
        rowY = Math.max(42, this.height / 2 - 90);

        addToggle(x, "Ocultar barra de experiencia", () -> IndevConfig.hideExperienceBar,
            v -> IndevConfig.hideExperienceBar = v);
        addToggle(x, "Ocultar indicador de correr", () -> IndevConfig.hideSprintIndicator,
            v -> IndevConfig.hideSprintIndicator = v);
        addToggle(x, "Texto: Minecraft Indev 2.23", () -> IndevConfig.showIndevLabel,
            v -> IndevConfig.showIndevLabel = v);
        addToggle(x, "Neblina clásica (experimental)", () -> IndevConfig.classicFog,
            v -> IndevConfig.classicFog = v);
        addToggle(x, "Textura de cerdo para Creeper", () -> IndevConfig.pigCreeperTexture,
            v -> IndevConfig.pigCreeperTexture = v);
        addToggle(x, "Explosión al morir (experimental)", () -> IndevConfig.explodeOnCreeperDeath,
            v -> IndevConfig.explodeOnCreeperDeath = v);

        addRenderableWidget(Button.builder(Component.literal("Vista previa del inventario Indev"),
            b -> this.minecraft.setScreen(new IndevInventoryPreviewScreen(this)))
            .bounds(x, rowY + 8, w, 20).build());

        addRenderableWidget(Button.builder(Component.literal("Volver"),
            b -> this.minecraft.setScreen(parent))
            .bounds(x, this.height - 28, w, 20).build());
    }

    private void addToggle(int x, String label, java.util.function.BooleanSupplier getter,
                           java.util.function.Consumer<Boolean> setter) {
        addRenderableWidget(Button.builder(toggleText(label, getter.getAsBoolean()), button -> {
            boolean next = !getter.getAsBoolean();
            setter.accept(next);
            button.setMessage(toggleText(label, next));
        }).bounds(x, rowY, 230, 20).build());
        rowY += 24;
    }

    private Component toggleText(String label, boolean enabled) {
        return Component.literal(label + ": " + (enabled ? "ON" : "OFF"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, "MINECRAFT INDEV SETTINGS", this.width / 2, 18, 0xFFFFFF);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
}
