package net.indev.settings;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class IndevInventoryPreviewScreen extends Screen {
    private final Screen parent;

    public IndevInventoryPreviewScreen(Screen parent) {
        super(Component.literal("Inventario Indev"));
        this.parent = parent;
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        renderBackground(g, mouseX, mouseY, partialTick);

        int left = (width - 344) / 2;
        int top = (height - 230) / 2;

        // Panel principal y borde pixelado sencillo inspirado en la captura enviada.
        g.fill(left - 2, top - 2, left + 346, top + 232, 0xFF202020);
        g.fill(left, top, left + 342, top + 228, 0xFFC6C6C6);
        g.fill(left + 3, top + 3, left + 339, top + 225, 0xFFBEBEBE);

        // Zona de armadura y retrato.
        for (int i = 0; i < 4; i++) {
            int sy = top + 10 + i * 35;
            g.fill(left + 8, sy, left + 42, sy + 33, 0xFF777777);
            g.fill(left + 10, sy + 2, left + 40, sy + 31, 0xFFBDBDBD);
        }
        g.fill(left + 46, top + 10, left + 152, top + 150, 0xFF111111);
        g.drawString(font, "PLAYER NAME", left + 160, top + 12, 0xFF303030, false);
        g.drawString(font, "ATK: 100", left + 160, top + 42, 0xFF303030, false);
        g.drawString(font, "DEF: 100", left + 160, top + 58, 0xFF303030, false);
        g.drawString(font, "SPD: 100", left + 160, top + 74, 0xFF303030, false);

        // Rejilla visual 9 x 3, como en la referencia. Es una vista previa, no slots funcionales.
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int sx = left + 9 + col * 36;
                int sy = top + 154 + row * 34;
                g.fill(sx, sy, sx + 34, sy + 32, 0xFF777777);
                g.fill(sx + 2, sy + 2, sx + 32, sy + 30, 0xFFB0B0B0);
            }
        }

        // Barra inferior.
        for (int col = 0; col < 9; col++) {
            int sx = left + 9 + col * 36;
            int sy = top + 190;
            g.fill(sx, sy, sx + 34, sy + 32, 0xFF777777);
            g.fill(sx + 2, sy + 2, sx + 32, sy + 30, 0xFFB0B0B0);
        }

        g.drawCenteredString(font, "Vista previa del diseño Indev", width / 2, top + 235, 0xFFFFFF);
        g.drawCenteredString(font, "ESC para volver", width / 2, height - 18, 0xFFFFFF);
        super.render(g, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        minecraft.setScreen(parent);
    }
}
