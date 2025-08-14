package fr.dauphine.eu;

import lombok.Data;
import lombok.Getter;


@Getter
public enum Point {
    LOVE(0), FIFTEEN(1), THIRTY(2), FORTY(3);
    private final int value;
    Point(int value) { this.value = value; }
}

