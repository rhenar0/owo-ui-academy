package io.wispforest.academy.screen;

import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.HorizontalAlignment;
import io.wispforest.owo.ui.core.VerticalAlignment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class AlignmentTutorialScreen extends BaseUIModelScreen<FlowLayout> {

    private final Screen parent;

    public AlignmentTutorialScreen(@Nullable Screen parent) {
        super(FlowLayout.class, DataSource.asset(new Identifier("owo-ui-academy", "alignment")));
        this.parent = parent;
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void build(FlowLayout rootComponent) {
        rootComponent.childById(ButtonComponent.class, "inspector-button")
                .onPress(button -> this.uiAdapter.toggleInspector());

        rootComponent.childById(ButtonComponent.class, "previous-button")
                .onPress(button -> this.client.setScreen(this.parent));

        rootComponent.childById(ButtonComponent.class, "next-button")
                .onPress(button -> this.client.setScreen(new SizingTutorialScreen(this)));

        // --------

        var boxContainer = rootComponent.childById(FlowLayout.class, "box-container");

        rootComponent.childById(ButtonComponent.class, "top-button").onPress(button -> boxContainer.verticalAlignment(VerticalAlignment.TOP));
        rootComponent.childById(ButtonComponent.class, "vertical-center-button").onPress(button -> boxContainer.verticalAlignment(VerticalAlignment.CENTER));
        rootComponent.childById(ButtonComponent.class, "bottom-button").onPress(button -> boxContainer.verticalAlignment(VerticalAlignment.BOTTOM));

        rootComponent.childById(ButtonComponent.class, "left-button").onPress(button -> boxContainer.horizontalAlignment(HorizontalAlignment.LEFT));
        rootComponent.childById(ButtonComponent.class, "horizontal-center-button").onPress(button -> boxContainer.horizontalAlignment(HorizontalAlignment.CENTER));
        rootComponent.childById(ButtonComponent.class, "right-button").onPress(button -> boxContainer.horizontalAlignment(HorizontalAlignment.RIGHT));
    }
}
