package com.almasb.game;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

/**
 * class for SimpleGameApp
 */
public class SimpleGameApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {

    }

    @Override
    protected void initInput() {
        onKeyDown(KeyCode.F, () -> {
//            System.out.println("Hi");
            getNotificationService().pushNotification("Hello World");
        });
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new SimpleFactory());
//        FXGL.spawn("enemy", 100, 100);
//        FXGL.spawn("ally", 600, 100);
        FXGL.run(() -> {
            FXGL.spawn("ally", FXGLMath.randomPoint(
                    new Rectangle2D(0, 0, FXGL.getAppWidth(), FXGL.getAppHeight()))
            );
            FXGL.spawn("enemy", FXGLMath.randomPoint(
                    new Rectangle2D(0, 0, FXGL.getAppWidth(), FXGL.getAppHeight()))
            );
        }, Duration.seconds(1));
    }

    public static void main(String[] args) {
        launch(args);
    }


}
