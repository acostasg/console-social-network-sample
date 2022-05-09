package com.console.social.network.sample.view.view;

public class ErrorView {
    public static void render(Exception e) {
        System.err.println("!!! Error: " + e.getMessage());
    }
}
