package com.bogdan;

import java.util.ArrayList;
import java.util.HashMap;

abstract class Algorithm {
   protected Problem problem;


  public abstract HashMap<String,String> solve(Problem pb);
}
