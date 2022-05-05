package com.bogdan;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Abstract class Algorithm, should not be instantiated: see GreedyAlgorithm or DSaturAlgorithm
 *
 * @implNote solve() method needs to be implemented, and it should return a Solution instance
 */
abstract class Algorithm {
    protected Problem problem;


    public abstract Solution solve();
}
