package com.WorkshopJava.app;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class App extends GameApplication {

    private Entity player;
    private Entity enemy;

    @Override
    public void initGame() {
        FXGL.getGameWorld().addEntityFactory(new Factory());
        FXGL.spawn("enemy", 0, 0);
        player = FXGL.entityBuilder()
                .at(0, 0)
                .view(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach();
        enemy = FXGL.entityBuilder()
                .at(200, 200)
                .view(new Rectangle(25, 25, Color.RED))
                .buildAndAttach();
    }

    @Override
    public void initInput() {
        FXGL.onKeyDown(KeyCode.UP, () -> {
            player.translateY(-5);
        });
        FXGL.onKeyDown(KeyCode.DOWN, () -> {
            player.translateY(5);
        });
        FXGL.onKeyDown(KeyCode.RIGHT, () -> {
            player.translateX(5);
        });
        FXGL.onKeyDown(KeyCode.LEFT, () -> {
            player.translateX(-5);
        });
    }

    @Override
    public void initSettings(GameSettings arg) {
        arg.setWidth(800);
        arg.setHeight(600);
        arg.setTitle("Workshopjava");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
