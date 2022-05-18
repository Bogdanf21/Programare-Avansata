package com.Choco;

import com.Entity.City;
import com.Repository.CityRepository;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChocoSolver {
    public void result(int bound1, int bound2) {
        List<City> cities;
        List<Integer> citiesID;
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            Model model = new Model("Choco Solver");
            cities = new CityRepository().findByFirstLetter(letter);
            List<City> finalCities = cities;
            cities = cities.stream().filter(city -> {
                for (City tempCity : finalCities)
                    if (city.getCountry() == tempCity.getCountry() && city.getName() != tempCity.getName())
                        return false;
                return true;
            }).collect(Collectors.toList());


            if (!cities.isEmpty()) {
                int[] input = new int[cities.size()];
                for (int i = 0; i < input.length; i++)
                    input[i] = cities.get(i).getPopulation();

                IntVar [] populationCity = model.intVarArray(input.length, input);

                model.sum(populationCity, ">=",bound2).post();
                model.sum(populationCity, "<=",bound1).post();

                System.out.println(letter + ":\n");
                model.getSolver().solve();
                String [] result =Arrays.toString(model.getDomainUnion(populationCity)).substring(1,Arrays.toString(model.getDomainUnion(populationCity)).length()-1).split(", ");
                for (String res:result)
                {
                    System.out.print(new CityRepository().findByPopulation(Integer.parseInt(res)).getName()+" , ");
                }
                System.out.println();
                model.getSolver().setRestartOnSolutions();
            }

        }
    }
}
