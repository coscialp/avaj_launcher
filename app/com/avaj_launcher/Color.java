package com.avaj_launcher;

public enum Color {
    RESET("\033[0m"),
    BLACK("\033[0;30m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CYAN("\033[0;36m"),
    WHITE("\033[0;37m"),
    BLACK_BOLD("\033[1;30m"),
    RED_BOLD("\033[1;31m"),
    GREEN_BOLD("\033[1;32m"),
    YELLOW_BOLD("\033[1;33m"),
    BLUE_BOLD("\033[1;34m"),
    MAGENTA_BOLD("\033[1;35m"),
    CYAN_BOLD("\033[1;36m"),
    WHITE_BOLD("\033[1;37m"),
    BLACK_UNDERLINED("\033[4;30m"),
    RED_UNDERLINED("\033[4;31m"),
    GREEN_UNDERLINED("\033[4;32m"),
    YELLOW_UNDERLINED("\033[4;33m"),
    BLUE_UNDERLINED("\033[4;34m"),
    MAGENTA_UNDERLINED("\033[4;35m"),
    CYAN_UNDERLINED("\033[4;36m"),
    WHITE_UNDERLINED("\033[4;37m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    static public Color getRandomColor() {
        Color[] colors = Color.values();
        return colors[(int)(Math.random() * colors.length)];
    }

    @Override
    public String toString() {
        return code;
    }
}