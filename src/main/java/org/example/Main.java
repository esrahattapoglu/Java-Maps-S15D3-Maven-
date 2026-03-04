package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Esra", "Hattapoglu"));
        employees.add(new Employee(1, "Esra", "Hattapoglu"));
        employees.add(new Employee(2, "Aaa", "Bbb"));
        employees.add(new Employee(2, "Aaa", "Bbb"));
        employees.add(new Employee(3, "Ddd", "Ccc"));
        employees.add(new Employee(3, "Ddd", "Ccc"));
        employees.add(new Employee(4, "Ebru", "Hattapoglu"));
        employees.add(null);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: "    + findUniques(employees));
        System.out.println("No duplicates: " + removeDuplicates(employees));
    }


    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }


        Set<Integer> added = new HashSet<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) > 1 && !added.contains(emp.getId())) {
                duplicates.add(emp);
                added.add(emp.getId());
            }
        }

        return duplicates;
    }


    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            if (!map.containsKey(emp.getId())) {
                map.put(emp.getId(), emp);
            }
        }

        return map;
    }


    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> result = new LinkedList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }

        return result;
    }
}